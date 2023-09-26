package com.ebank.app.ebank.entities.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter; 
import com.ebank.app.ebank.enums.Type;



@Converter
public class TypeConverter implements AttributeConverter<Type, String> {



    @Override
    public String convertToDatabaseColumn(Type type) {
        return type.type;
    }


    
    @Override
    public Type convertToEntityAttribute(String type) {
        return Type.getByType(type);
    }

}
