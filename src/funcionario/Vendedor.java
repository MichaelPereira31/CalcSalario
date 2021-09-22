package funcionario;

import java.util.ArrayList;
import java.util.HashMap;


public class Vendedor extends Funcionario {
    private ArrayList<HashMap<String, Double>> vendas = new ArrayList<HashMap<String, Double>>(); // [{"produto", valor}, {"produto", valor}]
    public double valorVendido = 0.0;

    public Vendedor(String nome){
        super(nome);
    }

    public void addVenda(HashMap<String, Double> venda){
        this.vendas.add(venda);
        
        String produto = String.valueOf(
            venda.keySet().toArray()[0]
        );

        this.valorVendido += venda.get(produto);
    }

    public void removeVenda(HashMap<String, Double> venda){
        this.vendas.remove(venda);
    }
}