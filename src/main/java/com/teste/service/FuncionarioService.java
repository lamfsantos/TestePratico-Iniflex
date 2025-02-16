package com.teste.service;

import com.teste.model.Funcionario;

import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

public class FuncionarioService {
    public void removeFuncionarioDaLista(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public void printFuncionarios(List<Funcionario> funcionarios) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        funcionarios.forEach(funcionario -> {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + funcionario.getDataNascimento());
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println("Salário: " + numberFormat.format(funcionario.getSalario()));
            System.out.println("-------------------------");
        });
    }
}
