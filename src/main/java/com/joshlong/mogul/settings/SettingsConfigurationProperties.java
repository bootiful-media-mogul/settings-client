package com.joshlong.mogul.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mogul.settings")
public record SettingsConfigurationProperties(String baseUrl) {
}
