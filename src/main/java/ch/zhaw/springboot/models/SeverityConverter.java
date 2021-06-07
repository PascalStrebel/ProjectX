package ch.zhaw.springboot.models;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SeverityConverter implements AttributeConverter<Severity, String> {

    @Override
    public String convertToDatabaseColumn(Severity severity) {
        if (severity == null) {
            return null;
        }
        return severity.getId();
    }

    @Override
    public Severity convertToEntityAttribute(String id) {
        if (id == null) {
            return null;
        }

        return Stream.of(Severity.values())
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
