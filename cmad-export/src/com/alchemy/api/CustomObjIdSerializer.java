package com.alchemy.api;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

// I was facing problem with mongo generated objectId
// On mongo console 
// ObjectId("5aba7e35e70afb19bcad2ab3"),
// on jaxrs response
//	"objectId": {
//		"timestamp": 1522171445,
//		"machineIdentifier": 15141627,
//		"processIdentifier": 6588,
//		"counter": 11348659,
//		"time": 1522171445000,
//		"date": 1522171445000,
//		"timeSecond": 1522171445
//	},
// @see https://github.com/bguerout/jongo/issues/221

public class CustomObjIdSerializer extends JsonSerializer<ObjectId> {

	@Override
	public void serialize(ObjectId value, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		if (value == null) {
			jsonGenerator.writeNull();
		} else {
			jsonGenerator.writeString(value.toHexString());
		}
	}

		
	}


