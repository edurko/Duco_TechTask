package com.duco.task.taf.data.dataFileManager;

import com.duco.task.taf.data.ConfigData;
import org.aeonbits.owner.ConfigFactory;

public interface DataFileManager {

    final static ConfigData configData = ConfigFactory.create(ConfigData.class);

    static <T> T readDataFromFile(String fileName, Class<T> type) {
        return null;
    }
}