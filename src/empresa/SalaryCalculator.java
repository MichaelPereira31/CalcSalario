package empresa; 

import java.util.List;
import java.util.Arrays;

import funcionario.Funcionario;
import funcionario.Vendedor;
import funcionario.Gerente;
import funcionario.Caixa;


public class SalaryCalculator {
    private SalaryDefaultCalculator defaultCalculator = new SalaryDefaultCalculator(); 
    private SalaryVendedorCalculator vendedorCalculator = new SalaryVendedorCalculator(defaultCalculator);
    private SalaryCaixaCalculator caixaCalculator = new SalaryCaixaCalculator(vendedorCalculator);
    private SalaryGerenteCalculator gerenteCalculator = new SalaryGerenteCalculator(caixaCalculator);

    public void calculate(Funcionario[] funcionarios, String nome){
        List<Funcionario> funcionario_arr = Arrays.asList(funcionarios);

        System.out.println("Salários " + nome);

        funcionario_arr.forEach((Funcionario item) -> {
            System.out.print(item.getNome()+ ": ");

            double salaryCalculated = this.gerenteCalculator.calcula_salario(item);
            System.out.println("R$ " + String.valueOf(salaryCalculated));
        });
    }
}



abstract class BaseCalculador {
    public double salary = 1200.00;
    public abstract double calcula_salario(Funcionario funcionario);
} 


class SalaryDefaultCalculator extends BaseCalculador {
    private double quantidade_salario_minimo = 1;
    
    @Override
    public double calcula_salario(Funcionario funcionario) {
        return this.salary * this.quantidade_salario_minimo;
    }
}


class SalaryCaixaCalculator extends BaseCalculador {
    private double quantidade_salario_minimo = 1.5;
    private BaseCalculador callback_obj;

    public SalaryCaixaCalculator(BaseCalculador callback_obj) {
        this.callback_obj = callback_obj;
    }
    
    @Override
    public double calcula_salario(Funcionario funcionario) {
        if (funcionario instanceof Caixa){
            return this.salary * this.quantidade_salario_minimo;
        } else {
            return this.callback_obj.calcula_salario(funcionario);
        }
    }
}


class SalaryVendedorCalculator extends BaseCalculador {
    private double quantidade_salario_minimo = 1; // estipulando que o vendedor tem a base salarial em 1 salário minimo
    private double taxa_commisao = 0.20; // A cada venda, o vendedor ganha 20% do valor do produto
    private BaseCalculador callback_obj;

    public SalaryVendedorCalculator(BaseCalculador callback_obj) {
        this.callback_obj = callback_obj;
    }

    @Override
    public double calcula_salario(Funcionario funcionario){
        if (funcionario instanceof Vendedor){
            Vendedor vendedor = (Vendedor) funcionario;

            double salary = this.salary * this.quantidade_salario_minimo;
            double comissao = vendedor.valorVendido * this.taxa_commisao;

            System.out.print("Salario (" + String.valueOf(salary) + ") + Comissão (" + String.valueOf(comissao) + ") = ");

            return salary + comissao;
        } else {
            return this.callback_obj.calcula_salario(funcionario);
        }
    }
}



class SalaryGerenteCalculator extends BaseCalculador{
    private double quantidade_salario_minimo = 2; // Estipulando base salarial do gerente para dois salarios
    private double taxa_comisao = 0.05;  
    private double total_vendido_na_empresa = 0.0;
    private BaseCalculador callback_obj;

    public SalaryGerenteCalculator(BaseCalculador callback_obj) {
        this.callback_obj = callback_obj;
    }  
    
    @Override 
    public double calcula_salario(Funcionario funcionario){
        if (funcionario instanceof Gerente){
            Gerente gerente = (Gerente) funcionario;
            List<Vendedor> vendedores = Arrays.asList(gerente.getVendedores());

            this.total_vendido_na_empresa = 0;

            vendedores.forEach((Vendedor item) -> {
                this.total_vendido_na_empresa += item.valorVendido;
                item.valorVendido = 0;
            });

            double salary = this.salary * quantidade_salario_minimo;
            double comissao = this.taxa_comisao * this.total_vendido_na_empresa;

            System.out.print("Salario (" + String.valueOf(salary) + ") + Comissão (" + String.valueOf(comissao) + ") = ");

            return salary + comissao;
        }else{
            return this.callback_obj.calcula_salario(funcionario);
        }
    }
}