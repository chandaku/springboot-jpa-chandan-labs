package com.chandan.labs.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.LocalDateTime;

import java.io.IOException;
import java.text.SimpleDateFormat;


public class CustomDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private SimpleDateFormat formatter =
            new SimpleDateFormat("MMM dd yyyy HH:mm:ss");

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(formatter.format(localDateTime.toDate()));
    }
}
