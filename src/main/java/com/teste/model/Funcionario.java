package com.teste.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private String funcao;
    private BigDecimal salario;

    public Funcionario(String nome, LocalDate dataDeNascimento, String funcao, BigDecimal salario) {
        super(nome, dataDeNascimento);
        this.funcao = funcao;
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}