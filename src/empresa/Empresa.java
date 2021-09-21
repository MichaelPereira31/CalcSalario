package empresa;

import funcionario.Funcionario;


public class Empresa{
    private String nome;
    public Funcionario[] funcionarios;

    public Empresa(String nome, Funcionario[] funcionarios){
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public void calcula_salario(){
        SalaryCalculator salaryHandle = new SalaryCalculator();
        salaryHandle.calculate(this.funcionarios, this.nome);
    }
}