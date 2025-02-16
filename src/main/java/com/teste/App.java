package com.teste;

import com.opencsv.exceptions.CsvException;
import com.teste.model.Funcionario;
import com.teste.service.LerArquivoService;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        LerArquivoService lerArquivoService = new LerArquivoService();
        try {
            List<Funcionario> funcionarios = lerArquivoService.lerArquivoCsv("arquivos/funcionarios.csv");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Data Nascimento: " + funcionario.getDataNascimento());
                System.out.println("Salário: " + funcionario.getSalario());
                System.out.println("Função: " + funcionario.getFuncao());
                System.out.println();
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
