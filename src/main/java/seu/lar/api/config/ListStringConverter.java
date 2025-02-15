package seu.lar.api.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class ListStringConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        // Converte a lista para o formato PostgreSQL ARRAY: {"item1","item2"}
        return "{" + attribute.stream()
                .map(s -> "\"" + s + "\"") // Adiciona aspas duplas em cada URL
                .collect(Collectors.joining(",")) + "}";
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        // Remove as chaves e divide, preservando as strings entre aspas
        String cleanData = dbData.replaceAll("[{}]", "");
        return Arrays.stream(cleanData.split("\",\""))
                .map(s -> s.replaceAll("\"", "")) // Remove aspas
                .collect(Collectors.toList());
    }
}



