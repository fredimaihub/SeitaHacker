import java.util.ArrayList;
import java.util.Random;

public class Database {
    public ArrayList<Pessoa> listaPessoas;
    String listaNomes[] = {
        "Vanessa Drum", "Craig Salinas", "Viviana Topham",
        "Hang Lakey", "Gretta Ortega", "Ned Ducker",
        "Shizuko Mirsky", "Charlena Wood", "Genevive Coop",
        "Wes Priestly"
    };
    
    String listaCPF[] = {
        "364.144.010-64", "273.385.090-34", "263.934.360-26",
        "946.768.610-44", "428.085.960-49", "038.240.940-02",
        "332.231.550-90", "992.108.400-38", "498.886.530-40",
        "792.237.070-99"
    };

    public Database(){
        listaPessoas = new ArrayList<Pessoa>();
    }

    public void montaPessoas(){
		for (int x = 0; x < listaCPF.length; x++){
			int idade 	= new Random().nextInt((90 - 18) + 1) + 18;
			int conta	= new Random().nextInt((700 - 300) + 1) + 300;
            int saldo   = new Random().nextInt((99999 - 300) + 1) + 300;
            float saldoF= (float) saldo;

            Pessoa pessoa = new Pessoa(this.listaNomes[x], this.listaCPF[x], idade);
            pessoa.setConta(conta, saldoF, geradorSenhaNumerica());

			this.listaPessoas.add(pessoa);
		}
    }

    public String geradorSenhaNumerica(){
		String senha="";
		for (int x = 0; x < 6; x++){
			int digito = new Random().nextInt(9);
			senha += digito;
		}

		return senha;
	}
    
    public ArrayList<Pessoa> getPessoas(){
        return this.listaPessoas;
    }
}