package icu.lowcoder.spring.commons.util.json;

import lombok.Data;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class JsonUtilsTests {
    @Data
    static class Person {
        private String name;
        private Integer age;
        private String idNo;
    }

    @Test
    public void test(){
        Person person = new Person();
        person.setName("张三");
        person.setAge(32);
        person.setIdNo("65335x");

        String json = JsonUtils.toJson(person);
        System.out.println(json);

        String snakeCaseJson = JsonUtils.toJson(person, PropertyNamingStrategy.SNAKE_CASE);
        System.out.println(snakeCaseJson);

        Person parsed = JsonUtils.parse(json, Person.class);

        assertEquals(person.getName(), parsed.getName());
        assertEquals(person.getAge(), parsed.getAge());
        assertEquals(person.getIdNo(), parsed.getIdNo());

        Person parsedFromSnakeCase = JsonUtils.parse(snakeCaseJson, Person.class, PropertyNamingStrategy.SNAKE_CASE);
        assertEquals(person.getName(), parsedFromSnakeCase.getName());
        assertEquals(person.getAge(), parsedFromSnakeCase.getAge());
        assertEquals(person.getIdNo(), parsedFromSnakeCase.getIdNo());
    }

    @Test
    public void testParseMap(){
        Person person = new Person();
        person.setName("张三");
        person.setAge(32);
        person.setIdNo("65335x");

        String snakeCaseJson = JsonUtils.toJson(person, PropertyNamingStrategy.SNAKE_CASE);
        System.out.println(snakeCaseJson);

        Map parsed = JsonUtils.parse(snakeCaseJson, Map.class, PropertyNamingStrategy.SNAKE_CASE);

        assertEquals(person.getName(), parsed.get("name"));
        assertEquals(person.getAge(), parsed.get("age"));
        assertEquals(person.getIdNo(), parsed.get("id_no"));
    }
}
