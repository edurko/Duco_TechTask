package com.duco.task.taf.data.dataFileManager;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

public class YamlDataFileManager implements DataFileManager {

    final private static String yamlFilePath = configData.pathToYamlFolder();

    public static <T> T readDataFromFile(String fileName, Class<T> type) {
        final String pathToFile = yamlFilePath + fileName;
        Yaml yaml = new Yaml(new Constructor(type));
        T data = null;

        try (InputStream input = new FileInputStream(pathToFile)) {
            data = yaml.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}