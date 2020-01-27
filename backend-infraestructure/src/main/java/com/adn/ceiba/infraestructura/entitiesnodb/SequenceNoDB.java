package com.adn.ceiba.infraestructura.entitiesnodb;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;

public class SequenceNoDB {

	private static MongoOperations mongoOperations;

	private SequenceNoDB() {

	}	
	
	public static void setMongoOperations(ApplicationContext ctx) {
		SequenceNoDB.mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
	}

	public static MongoOperations getMongoOperations() {
		if (mongoOperations == null) {
			throw new RuntimeException("No se ha podido obtener la informacion de spring");
		}
		return mongoOperations;
	}	
	

	public static long generateSequence(String seqName) {
		DatabaseSequence counter = getMongoOperations().findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), DatabaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

}
