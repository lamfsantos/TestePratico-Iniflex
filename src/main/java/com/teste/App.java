package com.teste;

import com.opencsv.exceptions.CsvException;
import com.teste.service.LerArquivoService;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        LerArquivoService lerArquivoService = new LerArquivoService();
        try {
            List<List<String>> data = lerArquivoService.lerArquivoCsv("arquivos/funcionarios.csv");
            for (List<String> row : data) {
                System.out.println(row);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
