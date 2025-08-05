package com.example.boot.config;

import com.example.boot.entity.Member.AttendanceStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AttendanceStatusConverter implements AttributeConverter<AttendanceStatus, String> {

    @Override
    public String convertToDatabaseColumn(AttendanceStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getDbValue();
    }

    @Override
    public AttendanceStatus convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return AttendanceStatus.fromDbValue(dbData);
    }
}