package org.example.technicaltask.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private Api api;
    private Histogram histogram;

    @Getter
    @Setter
    public static class Api {
        private String prefix;
    }

    @Getter
    @Setter
    public static class Histogram {
        private List<String> allowed;
    }
}
