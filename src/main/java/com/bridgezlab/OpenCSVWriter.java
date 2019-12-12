package com.bridgezlab;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCSVWriter {
    private static final String STRING_ARRAY_SAMPLE ="/home/admin1/OpenCsv/src/main/resources/stirng-array-sample.csv";
    public static void main(String[] args) throws IOException, IOException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
                ){
            String[] headerRecord = {"Name", "Email", "Phone", "Country"};
            csvWriter.writeNext(headerRecord);
            csvWriter.writeNext(new String[]{"Sandip", "sandi@gmail.com", "+1-1111111111", "India"});
            csvWriter.writeNext(new String[]{"Smita", "smita@outlook.com", "+1-1111111112", "India"});
        }
    }
}
