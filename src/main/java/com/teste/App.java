package com.teste;

import com.opencsv.exceptions.CsvException;
import com.teste.model.Funcionario;
import com.teste.service.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

        System.out.println();
        System.out.println("Aumentando salário dos funcionários em 10%...");
        funcionarioService.aumentarSalario(funcionarios, new BigDecimal("10"));
        
        System.out.println();
        System.out.println("Imprimindo funcionarios por função...");
        funcionarioService.printFuncionariosPorFuncao(funcionarioService.getFuncionariosPorFuncao(funcionarios));

        System.out.println();
        System.out.println("Imprimindo aniversariantes dos meses 10 e 12...");
        funcionarioService.printFuncionariosPorMes(funcionarios);

        System.out.println();
        System.out.println("Imprimindo funcionario mais velho...");
        funcionarioService.printNomeEIdadeDoMaisVelho(funcionarios);

        System.out.println();
        System.out.println("Imprimindo funcionarios por ordem alfabética...");
        funcionarioService.printFuncionariosEmOrdemAlfabetica(funcionarios);

        System.out.println();
        System.out.println(
            "Soma dos salários dos funcionários: " + 
            NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(funcionarioService.somaDeTodosOsSalarios(funcionarios))
        );

        System.out.println();
        System.out.println("Imprimindo salarios minimos por funcionario...");
        funcionarioService.printQuantidadeSalariosMinimos(funcionarios);
    }
}
