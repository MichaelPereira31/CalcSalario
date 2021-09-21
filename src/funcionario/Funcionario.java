package funcionario;

public abstract class Funcionario {
    private String nome;
    public String cargo;

    public Funcionario(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

}
