package com.teste.service;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoService {
    public List<List<String>> lerArquivoCsv(String path) throws IOException, CsvException {
        List<List<String>> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            List<String[]> allRows = reader.readAll();
            for (String[] row : allRows) {
                List<String> rowData = new ArrayList<>();
                for (String cell : row) {
                    rowData.add(cell);
                }
                data.add(rowData);
            }
        }

        return data;
    }
}
