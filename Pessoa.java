public class Pessoa {
	String nome;
	String CPF;
	int idade;
	Conta conta;
	
	public Pessoa(String nome, String CPF, int idade){
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
	}

	public Pessoa() { }

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public int getIdade() {
		return idade;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(int num, double saldo, String senha){
		this.conta = new Conta(num, saldo, senha);
	}
}