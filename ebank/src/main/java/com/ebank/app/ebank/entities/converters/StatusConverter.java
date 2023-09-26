package com.ebank.app.ebank.entities.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ebank.app.ebank.enums.Status;


@Converter
public class StatusConverter implements AttributeConverter<Status, String> {


    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.type;
    }


    @Override
    public Status convertToEntityAttribute(String type) {
        return Status.getByType(type);
    }

}
