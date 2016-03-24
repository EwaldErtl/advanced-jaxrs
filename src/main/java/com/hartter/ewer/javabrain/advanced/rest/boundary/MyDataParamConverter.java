/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hartter.ewer.javabrain.advanced.rest.boundary;

import com.hartter.ewer.javabrain.advanced.rest.entity.MyDate;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;



/**
 *
 * @author eertl
 */
@Provider
public class MyDataParamConverter implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if ( rawType.getName().equals(MyDate.class.getName())) {
            return new ParamConverter<T>() {
                @Override
                public T fromString(String string) {
                    Calendar cal = Calendar.getInstance();
                    
                    if ( "tomorrow".equalsIgnoreCase(string)) {
                        cal.add(Calendar.DATE, 1);
                    } else if ( "yesterday".equalsIgnoreCase(string)) {
                        cal.add(Calendar.DATE, -1);
                    } 
                    MyDate date = new MyDate();
                    date.setDay(cal.get(Calendar.DAY_OF_MONTH));
                    date.setMonth(cal.get(Calendar.MONTH));
                    date.setYear(cal.get(Calendar.YEAR));
                    
                    return rawType.cast(date);
                }

                @Override
                public String toString(T t) {
                    if ( t == null ) {
                        return null;
                    } else {
                        return t.toString();
                    }
                }
            };
        }
        // not responsible for the converter.
        return null;
    }
    
}
