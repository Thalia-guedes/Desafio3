import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Cadastro{
    private String nome;
    private String cpf;
    private String email;

    public Cadastro(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    public String getEmail() {
        return email;
    }
    public static String Vendedor(){
        ArrayList<String> vendedor = new ArrayList<>();

        vendedor.add("Luan");
        vendedor.add("juan");
        vendedor.add("Marcia");
        vendedor.add("Ana");
        vendedor.add("Vinicius");
        vendedor.add("Camila");

        Random random = new Random();
        int indiceAleatorio = random.nextInt(vendedor.size());
        return vendedor.get(indiceAleatorio);

    }

}
