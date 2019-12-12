package com.bridgezlab;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ReadUserRecord {
    private static final String CSV_FILE_PATH = "./src/main/resources/userinformation.csv";


    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        ) {
            CsvToBean<CsvInfo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvInfo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CsvInfo> csvInfoIterator = csvToBean.iterator();

            while (csvInfoIterator .hasNext()) {
                CsvInfo csvInfo = csvInfoIterator .next();
                System.out.println("Name : " + csvInfo.getName());
                System.out.println("Email : " + csvInfo.getEmail());
                System.out.println("PhoneNo : " + csvInfo.getPhoneNo());
                System.out.println("Country : " + csvInfo.getCountry());
                System.out.println("==========================");
            }
        }
    }

}
