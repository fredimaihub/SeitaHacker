import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.text.NumberFormat;

public class Terminal {
	ArrayList<Pessoa> pessoas = new ArrayList();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String[] comandos = {
		"getNome", "getCPF", "getIdade",
		"getConta", "getSenha", "setSenha",
		"getSaldo", "transf", "removeLog"
	};
	
	public Terminal(ArrayList pessoas) {
		this.pessoas = pessoas;
	}

	public Terminal(String nick, ArrayList pessoas) {
		this.pessoas = pessoas;
		try {
			this.writeInfos("//LOG///////////////////////////////////////////////////////////", true);
			this.writeInfos("<"+nick+">\r\n", true);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String comand(String comando) {
		String data = dateFormat.format(new Date());
		String pessoa = "";
		int scndParam = 0;
		int thrdParam = 0;
		int frthParam = 0;
		int ini = 0;
		int fim = 0;
		String retorno = "Comando Inválido\r\n";

		for (int x = 0; x < comando.length(); x++){
			if (comando.charAt(x) == '('){
				ini = x + 1;

			}else if (comando.charAt(x) == ')') {
				fim = x;
			}
		}

		if (ini > 0 && fim > 0) {
			pessoa = comando.substring(ini, fim);

		}else{
			return retorno;
		}

		for (int i = 0; i < comandos.length; i++){
			if(comando.contains(comandos[i])){
				switch (comandos[i]){
					case "getNome":
						int randomNum = ThreadLocalRandom.current().nextInt(0, 10);
						retorno = pessoas.get(randomNum).getNome()+"\r\n";

						break;

					case "getCPF":
						if (verificaExistencia("nome", comando, pessoa)) {
							for (int x = 0; x < pessoas.size(); x++){
								if (pessoa.equals(pessoas.get(x).getNome())){
									retorno = pessoas.get(x).getCPF()+"\r\n";
								}
							}
						}else{
							retorno = "Usuário inexistente\r\n";
						}
						break;

					case "getIdade":
						if (verificaExistencia("nome", comando, pessoa)) {
							for (int x = 0; x < pessoas.size(); x++){
								if (pessoa.equals(pessoas.get(x).getNome())){
									retorno = pessoas.get(x).getIdade()+"\r\n";
								}
							}

						}else{
							retorno = "Usuário inexistente\r\n";
						}
						break;

					case "getConta":
						if (verificaExistencia("nome", comando, pessoa)) {
							for (int x = 0; x < pessoas.size(); x++){
								Pessoa titular = pessoas.get(x);

								if (pessoa.equals(titular.getNome())){
									retorno = titular.getConta().getNumero()+"\r\n";
								}
							}

						}else{
							retorno = "Usuário inexistente\r\n";
						}
						break;

					case "getSenha":
						if (verificaExistencia("conta", comando, pessoa)) {
							for (int x = 0; x < pessoas.size(); x++){
								Conta conta = pessoas.get(x).getConta();
								if (pessoa.equals(conta.getNumero()+"")){
									retorno = conta.getSenha()+"\r\n";
								}
							}

						}else{
							retorno = "Usuário inexistente\r\n";
						}
						break;

					case "getSaldo":
						if (verificaExistencia("conta", comando, pessoa)) {
							for (int x = 0; x < pessoas.size(); x++){
								Conta conta = pessoas.get(x).getConta();
								if (pessoa.equals(conta.getNumero()+"")){
									retorno = conta.getSaldo()+"\r\n";
								}
							}

						}else{
							retorno = "Usuário inexistente\r\n";
						}
						break;

					case "setSenha":
						for (int x = 0; x < comando.length(); x++){
							if (comando.charAt(x) == '('){
								ini = x + 1;
								
							}else if(comando.charAt(x) == ','){
								if(scndParam > 0) {
									thrdParam = x;
									
								}else{
									scndParam = x;
								}
								
							}else if (comando.charAt(x) == ')') {
								fim = x;
							}
						}
						
						if (ini > 0 && fim > 0 && scndParam > 0 && thrdParam > 0) {
							String numConta = comando.substring(ini, scndParam);
							String senha 	= comando.substring(scndParam+1, thrdParam);
							String newSenha = comando.substring(thrdParam+1, fim);

							for (int x = 0; x < pessoas.size(); x++){
								Conta conta = pessoas.get(x).getConta();
								if (numConta.contains(conta.getNumero()+"") && senha.contains(conta.getSenha())){
									conta.setSenha(newSenha);
									retorno = senha + " -> " + newSenha + "\r\n";
								}
							}
						}
						break;

					case "transf":
						for (int x = 0; x < comando.length(); x++){
							if (comando.charAt(x) == '('){
								ini = x + 1;
								
							}else if(comando.charAt(x) == ','){
								if(thrdParam > 0 && scndParam > 0){
									frthParam = x;
									
								}else if(scndParam > 0) {
									thrdParam = x;
									
								}else{
									scndParam = x;
								}
								
							}else if (comando.charAt(x) == ')') {
								fim = x;
							}
						}
						
						if (ini > 0 && fim > 0 && scndParam > 0 && thrdParam > 0) {
							Conta contaDestino = null;
							String numConta1 = comando.substring(ini, scndParam);
							String numConta2 = comando.substring(scndParam+1, thrdParam);
							String valor     = comando.substring(thrdParam+1, frthParam);
							String senha     = comando.substring(frthParam+1, fim);

							for (int y = 0; y < pessoas.size(); y++){
								contaDestino = pessoas.get(y).getConta();
								if (numConta2.contains(contaDestino.getNumero()+"")){
									break;
								}
							}

							for (int x = 0; x < pessoas.size(); x++){
								Conta conta = pessoas.get(x).getConta();
								if(verificaExistencia("conta", comando, numConta1) && contaDestino != null && conta.validaSenha(senha)){
									conta.transferencia(contaDestino, Float.parseFloat(valor));
									retorno = numConta1 + " (" + NumberFormat.getCurrencyInstance().format(Float.parseFloat(valor)) + ") -> " + numConta2 + "\r\n";
									break;
									
								}else{
									retorno = "dados inválidos \r\n";
								}
							}
						}
						break;

					case "removeLog":
						try {
							this.removeLog();

						} catch (IOException e) {
							e.printStackTrace();
						}
						retorno = data+" -> "+comando+" | log limpo com sucesso\r\n";

						return retorno;

					default:
						retorno = "comando inválido\r\n";
						break;
				}
			}
		}

		try {
			writeInfos(data+" -> "+comando+" | "+retorno, true);

		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		return data+" -> "+comando+" | "+retorno;
	}

	public void removeLog() throws IOException {
		writeInfos("", false);
	}

	public boolean verificaExistencia(String tipo, String dado, String pessoa){
		switch (tipo){
			case "nome":
				for (int x = 0; x < pessoas.size(); x++){
					Pessoa titular = pessoas.get(x);
					if (pessoa.equals(titular.getNome())){
						return true;
					}
				}
				break;

			case "conta":
				for (int x = 0; x < pessoas.size(); x++){
					String conta = pessoas.get(x).getConta().getNumero()+"";
					if (conta.equals(pessoas.get(x).getConta().getNumero()+"")){
						return true;
					}
				}
				break;

			default:
				return false;
		}

		return false;
	}

	public void writeInfos(String infos, boolean append) throws IOException {
		FileWriter arq = new FileWriter("log.txt", true);
		PrintWriter gravarArq = new PrintWriter(arq);

		gravarArq.printf(infos+" \r\n");
		arq.close();
	}

	public void setPessoas(ArrayList pessoas){
		this.pessoas = pessoas;
	}

	public void setNick(String nick){
		try {
			this.writeInfos("//LOG///////////////////////////////////////////////////////////", true);
			this.writeInfos("<"+nick+">\r\n", true);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}