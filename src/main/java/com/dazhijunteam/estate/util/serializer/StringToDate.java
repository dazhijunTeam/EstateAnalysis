package com.dazhijunteam.estate.util.serializer;





import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class StringToDate extends JsonSerializer<String>{

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            Date date=Date.valueOf(s);
            jsonGenerator.writeFieldName("s");

    }
}
