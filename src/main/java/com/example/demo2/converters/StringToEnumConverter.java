package com.example.demo2.converters;

import com.example.demo2.beans.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String source) {
        if(source.equals("Male")){
            return Gender.MALE;
        }else if (source.equals("Female")){
            return Gender.FEMALE;
        }else{
            return Gender.OTHER;
        }
    }
}
