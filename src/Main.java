import funcionario.*;
import empresa.*;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Caixa caixa_pedro = new Caixa("Pedro");
		Vendedor vendedor_savio = new Vendedor("Savio");
		Vendedor vendedora_carol = new Vendedor("Carol");
		Gerente gerente_michael = new Gerente("Michael");
		Empresa empresa_orion = new Empresa("Orion Tecnologia");

		// Adicionando vendedores gerenciados por Michael
		gerente_michael.addVendedor(vendedor_savio);
		gerente_michael.addVendedor(vendedora_carol);

		// Adionando funcionarios da empresa Orion
		empresa_orion.addFuncionario(caixa_pedro);
		empresa_orion.addFuncionario(vendedor_savio);
		empresa_orion.addFuncionario(vendedora_carol);
		empresa_orion.addFuncionario(gerente_michael);

		HashMap<String, Double> venda_1 = new HashMap<String, Double>();
		venda_1.put("Ventilador", 179.99);

		HashMap<String, Double> venda_2 = new HashMap<String, Double>();
		venda_2.put("Cadeira Gamer", 960.99);

		HashMap<String, Double> venda_3 = new HashMap<String, Double>();
		venda_3.put("Geladeira", 4499.99);

		HashMap<String, Double> venda_4 = new HashMap<String, Double>();
		venda_4.put("Iphone 7", 2400.00);

		// Adicionando vendas
		vendedor_savio.addVenda(venda_1);
		vendedor_savio.addVenda(venda_2);
		vendedora_carol.addVenda(venda_3);
		vendedora_carol.addVenda(venda_4);

		// Removendo uma venda
		vendedora_carol.removeVenda(venda_4);

		empresa_orion.calcula_salario();

	}

}
