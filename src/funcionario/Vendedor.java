package funcionario;

import java.util.ArrayList;
import java.util.HashMap;


public class Vendedor extends Funcionario {
    private ArrayList<HashMap<String, Double>> vendas = new ArrayList<HashMap<String, Double>>(); // [{"produto", valor}, {"produto", valor}]
    public double valorVendido = 0.0;

    public Vendedor(String nome){
        super(nome);
    }

    public void novaVenda(Double valor, String produto){
        HashMap<String, Double> venda = new HashMap<String, Double>();
        
        venda.put(produto, valor);
        vendas.add(venda);

        this.valorVendido += valor;

    }
}