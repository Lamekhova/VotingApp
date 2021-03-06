package com.example.sweater.web.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 *
 * Handling Hibernate lazy-loading
 *
 * @link https://github.com/FasterXML/jackson-datatype-hibernate
 * @link https://github.com/FasterXML/jackson-docs/wiki/JacksonHowToCustomSerializers
 */
@Component
@Primary
public class JacksonObjectMapper extends ObjectMapper {

    public JacksonObjectMapper() {
        registerModule(new Hibernate5Module());

        registerModule(new JavaTimeModule());
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // Make all fields globally serializable
        setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        // Suppress serialization of properties with zero values
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}