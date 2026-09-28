package com.joshlong.mogul.settings;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.web.client.RestClient;

import java.util.Set;

@Configuration
@EnableConfigurationProperties(SettingsConfigurationProperties.class)
@ImportRuntimeHints(SettingsAutoConfiguration.Hints.class)
class SettingsAutoConfiguration {

	@Bean
	SettingsClient settingsClient(RestClient.Builder restClientBuilder,
			SettingsConfigurationProperties settingsConfigurationProperties) {
		return new SettingsClient(restClientBuilder, settingsConfigurationProperties.baseUrl() + "/graphql");
	}

	static class Hints implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(@NonNull RuntimeHints hints, @Nullable ClassLoader classLoader) {
			var mcs = MemberCategory.values();
			for (var cl : Set.of(Setting.class, SettingsPage.class))
				hints.reflection().registerType(cl, mcs);
		}

	}

}
