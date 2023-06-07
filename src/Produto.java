import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int codigoDeBarras;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getCodigoDeBarras() {
        return codigoDeBarras;
    }
}

class CarrinhoDeCompras {
    private List<Produto> produtos;

    public CarrinhoDeCompras() {
        produtos = new ArrayList<>();
    }


    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public int getQuantidadeItens() {
        return produtos.size();
    }
    public int codigoDeBarras(){
        return codigoDeBarras();
    }

    public double getValorTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }
}



