package icu.lowcoder.spring.commons.util.json;

public interface JsonProcessor {
    String serialize(Object javaObject);

    String serialize(Object javaObject, PropertyNamingStrategy propertyNamingStrategy);

    <T> T deserialize(String json, Class<T> type);

    <T> T deserialize(String json, Class<T> type, PropertyNamingStrategy propertyNamingStrategy);
}
