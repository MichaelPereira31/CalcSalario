package funcionario;

import java.util.ArrayList;


public class Gerente extends Funcionario {
    private ArrayList<Vendedor> vendedores; // None

    public Gerente(String nome){
        super(nome);
        this.vendedores = new ArrayList<Vendedor>();
    }

    public ArrayList<Vendedor> getVendedores(){
        return this.vendedores;
    }

    public void addVendedor(Vendedor vendedor){
        this.vendedores.add(vendedor);
    }

    public void removeVendedor(Vendedor vendedor){
        this.vendedores.remove(vendedor);
    }
}