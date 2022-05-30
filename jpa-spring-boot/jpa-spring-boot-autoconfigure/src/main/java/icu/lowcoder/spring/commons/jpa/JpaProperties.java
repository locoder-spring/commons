package icu.lowcoder.spring.commons.jpa;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "icu.lowcoder.spring.commons.jpa")
public class JpaProperties {
    private String softDeletedValue = "true";
    private String notSoftDeletedValue = "false";
}
