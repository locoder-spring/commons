package icu.lowcoder.spring.commons.util.json;

public class JsonUtils {
    private static JsonProcessor PROCESSOR = new JacksonJsonProcessor();
    public static void setJsonProcessor(JsonProcessor jsonProcessor) {
        PROCESSOR = jsonProcessor;
    }

    public static String toJson(Object object) {
        return PROCESSOR.serialize(object);
    }

    public static String toJson(Object object, PropertyNamingStrategy propertyNamingStrategy) {
        return PROCESSOR.serialize(object, propertyNamingStrategy);
    }

    public static <T> T parse(String json, Class<T> type) {
        return PROCESSOR.deserialize(json, type);
    }

    public static <T> T parse(String json, Class<T> type, PropertyNamingStrategy propertyNamingStrategy) {
        return PROCESSOR.deserialize(json, type, propertyNamingStrategy);
    }
}
