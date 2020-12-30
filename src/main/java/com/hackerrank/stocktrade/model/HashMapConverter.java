package com.hackerrank.stocktrade.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;


public class HashMapConverter implements AttributeConverter<User, String> {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(User userInfo) {

        String userInfoJson= null;
        try {

            userInfoJson= objectMapper.writeValueAsString(userInfo);
        } catch (final JsonProcessingException e) {

        }

        return userInfoJson;
    }

    @Override
    public User convertToEntityAttribute(String userInfoJson) {

        User userInfo= null;
        try {
            userInfo= objectMapper.readValue(userInfoJson,User.class);
        } catch (final IOException e) {

        }

        return userInfo;
    }

}

