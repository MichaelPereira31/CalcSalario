package empresa; 

import java.util.List;
import java.util.Arrays;

import funcionario.Funcionario;
// import funcionario.Vendedor;


public class SalaryCalculator {
    private SalaryCaixaCalculator caixaCalculator = new SalaryCaixaCalculator();
    // private SalaryVendedorCalculator vendedorCalculator = new SalaryVendedorCalculator();
    // public SalaryGerenteCalculator gerenteCalculator = new SalaryGerenteCalculator();
    // private SalaryDefaultCalculator defaultCalculator = new SalaryDefaultCalculator();

    public void calculate(Funcionario[] funcionarios, String nome){
        List<Funcionario> funcionario_arr = Arrays.asList(funcionarios);

        System.out.println("Calculando salários da " + nome);

        funcionario_arr.forEach((Funcionario item) -> {
            double salaryCalculated = this.caixaCalculator.calcula_salario(item);
            System.out.println(item.getNome() + ": " + String.valueOf(salaryCalculated));
        });
    }
}



abstract class BaseCalculador {
    public double salary = 1500.00;
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
    
    @Override
    public double calcula_salario(Funcionario funcionario) {
        if (funcionario.cargo == "Caixa"){
            return this.salary * this.quantidade_salario_minimo;
        } else {
            return 0.0;
        }
    }
}


// class SalaryVendedorCalculator extends BaseCalculador {
//     private double quantidade_salario_minimo = 1;
//     private double taxa_commisao = 0.10;

//     @Override
//     public double calcula_salario(Funcionario funcionario){
//         if (funcionario.cargo == "Vendedor"){
//             return this.salary * this.quantidade_salario_minimo * (funcionario.valorVendido * this.taxa_commisao);
//         } else {
//             return 0.0;
//         }
//     }
// }



// class SalaryGerenteCalculator extends BaseCalculador{
//     private double quantidade_salario_minimo = 2.5;
//     private double taxa_commisao = 0.05;    
    
//     @Override 
//     public double calcula_salario(Funcionario funcionario){
//         if (funcionario.cargo == "Gerente"){
//             double total_vendido_na_empresa = 0;
//             List<Vendedor> vendedores = Arrays.asList(funcionario.getVendedores());

//             vendedores.forEach((Vendedor item) -> {
//                 total_vendido_na_empresa += item.valorVendido;
//                 item.valorVendido = 0;
//             });

//             return this.salary * quantidade_salario_minimo * (this.taxa_commisao * total_vendido_na_empresa);
//         }else{
//             return 0.0;
//         }
//     }
// }