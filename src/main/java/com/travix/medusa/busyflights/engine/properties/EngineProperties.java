package com.travix.medusa.busyflights.engine.properties;

import java.util.Properties;

public interface EngineProperties {

    Properties getProperties();
    String getProperty(String key);
}
