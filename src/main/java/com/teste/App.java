package com.teste;

import com.opencsv.exceptions.CsvException;
import com.teste.model.Funcionario;
import com.teste.service.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        LerArquivoService lerArquivoService = new LerArquivoService();
        FuncionarioService funcionarioService = new FuncionarioService();
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            System.out.println("Lendo arquivo CSV...");
            funcionarios = lerArquivoService.lerArquivoCsv("arquivos/funcionarios.csv");
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        System.out.println("Removendo João da lista...");
        funcionarioService.removeFuncionarioDaLista(funcionarios, "João");

        System.out.println();
        System.out.println("Imprimindo lista de funcionários...");
        System.out.println();
        funcionarioService.printFuncionarios(funcionarios);
    }
}
