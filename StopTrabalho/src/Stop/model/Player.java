package Stop.model;
public class Player {
	
    private String Nome;
    private String idade;
    private String sexo;
  
    
	public Player(String Nome, String idade, String Sexo) {
		super();
		this.Nome = Nome;
		this.idade = idade;
		this.sexo = Sexo;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String Idade, String idade) {
		this.idade = idade; }

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}

    
