package com.bridgezlab;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadCSvWriteIntoJson {
    private static final String CSV_FILE="/home/admin1/OpenCsv/src/main/resources/CsvFile.csv";
    private static final String GSON_FILE="/home/admin1/OpenCsv/src/main/resources/info.json";
    public static void main(String[] args) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE));
            CsvToBeanBuilder<CsvInfo> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CsvInfo.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CsvInfo> csvToBean = csvToBeanBuilder.build();
            List<CsvInfo> csvUsers = csvToBean.parse();
            Gson gson= new Gson();
            String json =gson.toJson(csvUsers);
            FileWriter fileWriter = new FileWriter(GSON_FILE);
            fileWriter.write(json);
            fileWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(GSON_FILE));
            CsvInfo[] userObj = gson.fromJson(bufferedReader,CsvInfo[].class);
            List<CsvInfo> csvUserList = Arrays.asList(userObj);
        } catch (IOException |IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
