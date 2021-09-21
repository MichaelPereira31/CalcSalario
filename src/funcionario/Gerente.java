package funcionario;

public class Gerente extends Funcionario {
    private Vendedor[] vendedores;

    public Gerente(String nome, Vendedor[] vendedores){
        super(nome);
        this.vendedores = vendedores;
        this.cargo = "Gerente";
    }

    public Vendedor[] getVendedores(){
        return vendedores;
    }
}