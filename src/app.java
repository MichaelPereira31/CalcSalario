import funcionario.*;
import empresa.*;

public class app {

	public static void main(String[] args) {
		Caixa caixa_pedro = new Caixa("Pedro");
		Vendedor vendedor_savio = new Vendedor("Savio");
		Vendedor vendedora_carol = new Vendedor("Carol");

		Vendedor[] vendedores = {
			vendedor_savio, 
			vendedora_carol
		};
		Gerente gerente_michael = new Gerente("Michael", vendedores);

		Funcionario[] funcionarios = {
			caixa_pedro, 
			vendedor_savio, 
			vendedora_carol, 
			gerente_michael
		};

		Empresa empresa_orion = new Empresa("Orion Tecnologia", funcionarios);


		// Adicionando vendas
		vendedor_savio.novaVenda(250.0, "Ventilador");
		vendedor_savio.novaVenda(250.0, "Ventilador");

		vendedora_carol.novaVenda(500.0, "Cama");
		vendedora_carol.novaVenda(500.0, "Cama");

		empresa_orion.calcula_salario();

	}

}
