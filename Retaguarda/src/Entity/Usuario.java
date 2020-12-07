package Entity;

public class Usuario {
    private int codigo;
    private String nome;
    private String abreviacao;
    private String senha;
    
    public Usuario() {
        
    }
    
    public Usuario(String nome, String abreviacao, String senha){
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.senha = senha;
    }
    
    public Usuario(int codigo, String nome, String abreviacao, String senha){
        this.codigo = codigo;
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.senha = senha;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
