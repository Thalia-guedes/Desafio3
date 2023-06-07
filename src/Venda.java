import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Venda {
    private String nome;
    private String vendedor;
    private String cliente;
    private String email;
    private double preco;
    private int codigo;
    private int quantidade;
    private double valorTotal;

    public Venda(String nome, String vendedor, String cliente, String email, double preco, int codigo, int quantidade, double valorTotal) {
        this.nome = nome;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.email = email;
        this.preco = preco;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getVendedor() {
        return vendedor;
    }
    public static void cadastrarVenda(Venda venda){

        Venda venda1 = new Venda("Caixa de som", "Joao ", "Maria", "maria@", 99, 9990, 8, 55.0);
        List<Venda> vendas = new ArrayList<>();
        vendas.add(venda1);

        Venda venda2 = new Venda("biblia", "lucas ", "fulana", "maria@", 99, 9990, 8, 55.0);
        vendas.add(venda2);

    }
    public static List<Venda> obterVendasPorVendedor(List<Venda> vendas, String vendedorInformado) {
        List<Venda> vendasDoVendedor = new ArrayList<>();

        for (Venda venda : vendas) {
            if (venda.getVendedor().equals(vendedorInformado)) {
                vendasDoVendedor.add(venda);
            }
        }
        return vendasDoVendedor;
    }

}
