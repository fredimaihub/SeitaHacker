
import java.text.NumberFormat;

public class Conta {
	int numero;
	Pessoa titular;
	double saldo;
	String senha;
	
	public Conta(int Numero, double Saldo, String Senha) {
		numero = Numero;
		saldo = Saldo;
		senha = Senha;
	}
	
	public void saque(double valor){
		saldo = saldo - valor;
	}
	
	public void deposito(double valor) {
		saldo = saldo + valor;
	}
	
	public void transferencia(Conta destino, double v) {
		System.out.println(v+"");
		destino.saldo += v;
		this.saldo 	  -= v;
	}
	
	public boolean validaSenha(String s) {
		System.out.println(s);
		System.out.println(senha);
		if (s.equals(this.senha)) {
			return true;
		}

		return false;
	}

	public int getNumero() {
		return numero;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public Pessoa getTitular() {
		return titular;
	}
	
	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}

	public String getSaldo() {
		return NumberFormat.getCurrencyInstance().format(this.saldo);
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}