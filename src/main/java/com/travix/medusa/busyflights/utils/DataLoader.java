package com.travix.medusa.busyflights.utils;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataLoader {

    public static <T> List<T> loadCsvData(Class<T> type, String fileName) {
        try {
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                csvMapper.readerFor(type).with(csvSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            log.error("Failed to load and read the csv file" + fileName, e);
            return Collections.emptyList();
        }
    }
}
