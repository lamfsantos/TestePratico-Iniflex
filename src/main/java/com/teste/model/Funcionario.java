package com.teste.model;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private String funcao;
    private double salario;

    public Funcionario(String nome, LocalDate dataDeNascimento, String funcao, double salario) {
        super(nome, dataDeNascimento);
        this.funcao = funcao;
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}