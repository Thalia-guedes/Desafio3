import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String vendedor = Cadastro.Vendedor();

        List<Produto> listaProdutos = criarListaProdutos();
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo! A loja de eletronicos ElectraWorld !!! ");
        System.out.println("  -----------------------------------------   ");

        System.out.println("O Vendedor (a) disponivel ira te atender: ");
        System.out.println("                                         ");
        System.out.println(" Ola, meu nome é " + vendedor + " vou te mostrar os produtos disponiveis da loja !");
        System.out.println("                                         ");

        exibirListaProdutos(listaProdutos);

        boolean comprarNovamente = true;

        while (comprarNovamente) {
            System.out.print("Digite o número do produto que deseja comprar (ou 'sair' para finalizar): ");
            String opcao = scanner.nextLine();

            if (opcao.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                int indiceProduto = Integer.parseInt(opcao) - 1;
                if (indiceProduto >= 0 && indiceProduto < listaProdutos.size()) {
                    Produto produtoSelecionado = listaProdutos.get(indiceProduto);
                    carrinho.adicionarProduto(produtoSelecionado);
                    System.out.println("Produto adicionado ao carrinho.");
                } else {
                    System.out.println("Opção inválida. Por favor, selecione um número válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, selecione um número válido.");
            }

        }

        System.out.println("Agora que ja escolheu o produto vamos realizar seu cadastro");
        try {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            validarNome(nome);

            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Digite o email: ");
            String email = scanner.nextLine();
            validarEmail(email);

            Cadastro cadastro = new Cadastro(nome, cpf, email);

            System.out.println("Cadastro realizado com sucesso!");

            System.out.println(" --- Nota Fiscal do Pedido ---");
            System.out.println("Nome do Cliente: " + cadastro.getNome());
            System.out.println("CPF: " + cadastro.getCpf());
            System.out.println("Email: " + cadastro.getEmail());

            System.out.println("Quantidade de itens no carrinho: " + carrinho.getQuantidadeItens());
            System.out.println("Valor total da compra: R$ " + carrinho.getValorTotal());


        } catch (Exception e) {
            System.out.println("Erro ao realizar o cadastro. Verifique os dados informados.");

        }
            System.out.println(" -----------------------------------");
            System.out.println("Listar Vendas Cadastrada pelo vendedor ");
            System.out.print("Digite o email do cliente: ");
            String email = scanner.nextLine();
            System.out.println("Vendedor Responsavel pela compra " + vendedor);

            int QuantidadeItens = 0;
            double valorTotalCompras = 0;

            for (Produto venda : listaProdutos) {
                if (venda.getNome().equalsIgnoreCase(email)) {
                    QuantidadeItens++;
                    valorTotalCompras += venda.getPreco();
                }
            }

            System.out.println("Email do cliente: " + email);
            System.out.println("Quantidade de itens: " + carrinho.getQuantidadeItens());
            System.out.println("Valor total das compras: " +  carrinho.getValorTotal());

    }

    private static void validarNome(String nome) throws Exception {
        if (!nome.matches("[a-zA-Z\\s]+")) {
            throw new Exception("Nome inválido. Use apenas letras e espaços.");
        }
    }

    private static void validarEmail(String email) throws Exception {
        if (!email.contains("@")) {
            throw new Exception("Email inválido. O email deve conter o símbolo @.");
        }
    }

    private static List<Produto> criarListaProdutos() {
        List<Produto> listaProdutos = new ArrayList<>();

        listaProdutos.add(new Produto("Jbl", 199.99));
        listaProdutos.add(new Produto("Iphone 13", 2999.99));
        listaProdutos.add(new Produto("Pelicula", 9.99));
        listaProdutos.add(new Produto("Fone de Ouvido", 59.99));
        listaProdutos.add(new Produto("Cabo Usb", 19.99));
        listaProdutos.add(new Produto("Teclado", 79.99));
        listaProdutos.add(new Produto("Mouse", 39.99));
        listaProdutos.add(new Produto("Cabo auxiliar", 14.99));

        return listaProdutos;
    }

    private static void exibirListaProdutos(List<Produto> listaProdutos) {
        System.out.println("Lista de produtos disponíveis:");

        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto produto = listaProdutos.get(i);
            System.out.println((i + 1) + ". " + produto.getNome() + " - R$ " + produto.getPreco() + produto.getCodigoDeBarras());
        }

        System.out.println();
    }

}
