package empresa;

import java.util.*;
import funcionario.Funcionario;


public class Empresa{
    private String nome;
    private ArrayList<Funcionario> funcionarios;

    public Empresa(String nome){
        this.nome = nome;
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public ArrayList<Funcionario> getFuncionarios(){
        return this.funcionarios;
    }

    public void addFuncionario(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }
    
    public void removeFuncionario(Funcionario funcionario){
        this.funcionarios.remove(funcionario);
    }

    public void calcula_salario(){
        SalaryCalculator salaryHandle = new SalaryCalculator();
        salaryHandle.calculate(this.funcionarios, this.nome);
    }
}