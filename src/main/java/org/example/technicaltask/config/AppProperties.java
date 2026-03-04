package org.example.technicaltask.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private Api api;
    private Histogram histogram;

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    public Histogram getHistogram() {
        return histogram;
    }

    public void setHistogram(Histogram histogram) {
        this.histogram = histogram;
    }

    public static class Api {
        private String prefix;

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }
    }

    public static class Histogram {
        private List<String> allowed;

        public List<String> getAllowed() {
            return allowed;
        }

        public void setAllowed(List<String> allowed) {
            this.allowed = allowed;
        }
    }
}
