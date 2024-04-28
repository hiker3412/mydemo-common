package io.example.common.model.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class P2 extends JsonSerializer<Number> {
    @Override
    public void serialize(Number aNumber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        double format = Math.round(aNumber.doubleValue() * 100) / 100.0;
        jsonGenerator.writeNumber(format);
    }
}
