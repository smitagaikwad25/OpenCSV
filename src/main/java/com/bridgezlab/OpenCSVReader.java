package com.bridgezlab;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCSVReader {
    private static final String CSV_FILE_PATH = "./src/main/resources/userinformation.csv";

    public static void main(String[] args) throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
        ){
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null){
                System.out.println("name :" + nextRecord[0]);
                System.out.println("mail :" + nextRecord[1]);
                System.out.println("phoneNo :" + nextRecord[2]);
                System.out.println("------------------------");

            }
        }
    }
}
