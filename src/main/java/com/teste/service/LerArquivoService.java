package com.teste.service;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.teste.model.Funcionario;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LerArquivoService {
    public List<Funcionario> lerArquivoCsv(String path) throws IOException, CsvException {
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

        return populaListaDeFuncionarios(data);
    }
    
    private List<Funcionario> populaListaDeFuncionarios(List<List<String>> data) {
        System.out.println("Populando lista de funcionários...");
        List<Funcionario> funcionarios = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Pulando a primeira linha que contém os cabeçalhos
        for (int i = 1; i < data.size(); i++) {
            List<String> row = data.get(i);
            String[] fields = row.get(0).split("\\s+"); // Divide a linha em campos separados por espaço
            String nome = fields[0];
            LocalDate dataNascimento = LocalDate.parse(fields[1], formatter);
            BigDecimal salario = new BigDecimal(fields[2]);
            String funcao = fields[3];

            Funcionario funcionario = new Funcionario(nome, dataNascimento, funcao, salario);
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }

}
