
package projeto_final;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import projeto_final.classes.GerenciadorSupermercado;
import projeto_final.classes.Produto;
import projeto_final.classes.ProdutoPerecivel;
import projeto_final.interfaces.GerenciadorDeProdutos;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GerenciadorDeProdutos gerenciador = new GerenciadorSupermercado();
      
        boolean sair = false;
        int opcao;
    
        do {

            System.out.println(
                """
                    ================================
                               GerenciaNow        
                    ================================
                    Selecione uma das opções abaixo:

                    1 - adicionar produto
                    2 - adicionar estoque
                    3 - listar produtos
                    4 - alterar preço
                    5 - apagar produto
                    6 - sair do programa
                    """
            );

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: {
                    //adiciona produto
                    Produto produto;

                    System.out.println("""
                            Qual tipo de produto deseja adicionar?
                            1 - perecivel
                            2 - nao perecivel
                            """);
                            int tipoProduto = sc.nextInt();
                            sc.nextLine();

                    System.out.println("digite o nome do produto: ");
                    String titulo = sc.nextLine();
                    
                    System.out.println("insira a descrição do produto");
                    String descricao = sc.nextLine();

                    System.out.println("Digite o preço do produto");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Insira a quantidade inicial");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    if(tipoProduto==1){
                        System.out.println("Insira a data de validade (dd/MM/aaaa)");
                        String dataString = sc.nextLine();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataValidade = LocalDate.parse(dataString, formatter);
                        
                        produto = new ProdutoPerecivel(titulo, preco, quantidade, descricao, dataValidade);
                    } else {
                        produto = new Produto(titulo, preco, quantidade, descricao);
                    }

                    gerenciador.adicionarProduto(produto);;
                }
                    break;

                case 2: {
                    //adiciona estoque
                    System.out.println("Qual produto deseja adicionar estoque? ");
                    String titulo = sc.nextLine();

                    System.out.println("Quantas unidades deseja adicionar?");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    gerenciador.adicionarEstoque(titulo, quantidade);
                }
                    break;

                case 3: {
                    //lista produtos
                    gerenciador.listarProdutos();
                }
                    break;
                
                case 4: {
                    //altera preco
                    System.out.println("QUal produto deseja alterar o preço?");
                    String titulo = sc.nextLine();

                    System.out.println("Qual o novo preço?");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    gerenciador.alterarPreco(titulo, preco);
                }
                    break;
                
                case 5: {
                    //apagar produto
                    System.out.println("Qual produto deseja deletar?");
                    String titulo = sc.nextLine();

                    gerenciador.deletarProduto(titulo);
                }
                    
                    break;
                
                case 6: {
                    //sair
                    sair = true;
                }
                    break;
            
                default:
                    break;
            }
    
        } while(!sair);

        sc.close();
    }


}
