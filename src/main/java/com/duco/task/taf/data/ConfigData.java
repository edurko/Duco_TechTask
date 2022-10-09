package com.duco.task.taf.data;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/configs/config.properties")
public interface ConfigData extends Config {

    @Key("path.folder.yaml")
    String pathToYamlFolder();

    @Key("driver.type")
    String driverType();

    @Key("url.ui")
    String uiUrl();

    @Key("wait.timeout.minutes")
    Integer waitTimeoutInMinutes();
}