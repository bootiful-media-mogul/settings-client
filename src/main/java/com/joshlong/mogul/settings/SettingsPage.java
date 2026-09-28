package com.joshlong.mogul.settings;

import java.util.List;

public record SettingsPage(Boolean valid, String category, List<Setting> settings) {
}
