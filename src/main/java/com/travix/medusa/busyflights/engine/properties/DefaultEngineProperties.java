package com.travix.medusa.busyflights.engine.properties;

import java.io.IOException;
import java.util.Properties;


import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class DefaultEngineProperties implements EngineProperties {

    private static final class Holder {
        private static final Holder INSTANCE = new Holder();
        private final Properties properties;

        private Holder() {
            this.properties = new Properties();
            try {
                this.properties.load(DefaultEngineProperties.class.getResourceAsStream("/config.properties"));
            } catch (IOException | RuntimeException e) {
                log.error(e.getMessage());
            }
        }
    }

    @Override
    public Properties getProperties() {
        return Holder.INSTANCE.properties;
    }

    @Override
    public String getProperty(String key) {
        return this.getProperties().getProperty(key);
    }
}
