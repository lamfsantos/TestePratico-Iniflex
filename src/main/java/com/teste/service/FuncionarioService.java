package com.teste.service;

import com.teste.model.Funcionario;

import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.Month;
import java.time.Period;
import java.time.LocalDate;

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

    public void aumentarSalario(List<Funcionario> funcionarios, BigDecimal percentual) {
        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(percentual.divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE));
            funcionario.setSalario(novoSalario);
        });
    }

    public Map<String, List<Funcionario>> getFuncionariosPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void printFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        funcionariosPorFuncao.forEach((funcao, funcionarios) -> {
            System.out.println("Função: " + funcao);
            funcionarios.forEach(funcionario -> {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Data de Nascimento: " + funcionario.getDataNascimento());
                System.out.println("Salário: " + funcionario.getSalario());
                System.out.println();
            });
            System.out.println("-------------------------");
        });
    }

    public void printFuncionariosPorMes(List<Funcionario> funcionarios) {
        funcionarios.stream()
            .filter(funcionario -> {
                Month mes = funcionario.getDataNascimento().getMonth();
                return mes == Month.OCTOBER || mes == Month.DECEMBER;
            })
            .forEach(funcionario -> {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Data de Nascimento: " + funcionario.getDataNascimento());
                System.out.println("Função: " + funcionario.getFuncao());
                System.out.println("Salário: " + funcionario.getSalario());
                System.out.println("-------------------------");
            });
    }

    public void printNomeEIdadeDoMaisVelho(List<Funcionario> funcionarios) {
        final Funcionario[] maisVelho = {null};

        funcionarios.forEach(funcionario -> {
            if (maisVelho[0] == null || funcionario.getDataNascimento().isBefore(maisVelho[0].getDataNascimento())) {
                maisVelho[0] = funcionario;
            }
        });

        int idade = Period.between(maisVelho[0].getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("Nome: " + maisVelho[0].getNome());
        System.out.println("Idade: " + idade);
    }

    public void printFuncionariosEmOrdemAlfabetica(List<Funcionario> funcionarios) {
        funcionarios.stream()
            .sorted((f1, f2) -> f1.getNome().compareToIgnoreCase(f2.getNome()))
            .forEach(funcionario -> {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Data de Nascimento: " + funcionario.getDataNascimento());
                System.out.println("Função: " + funcionario.getFuncao());
                System.out.println("Salário: " + funcionario.getSalario());
                System.out.println("-------------------------");
            });
    }

    public BigDecimal somaDeTodosOsSalarios(List<Funcionario> funcionarios) {
        BigDecimal soma = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            soma = soma.add(funcionario.getSalario());
        }

        return soma;
    }

    public void printQuantidadeSalariosMinimos(List<Funcionario> funcionarios) {
        BigDecimal salarioMinimo = BigDecimal.valueOf(1212);
        funcionarios.forEach(funcionario -> {
            BigDecimal quantidadeSalariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Quantidade de Salários Mínimos: " + quantidadeSalariosMinimos);
            System.out.println("-------------------------");
        });
    }
}
