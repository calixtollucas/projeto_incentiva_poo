package projeto_final.classes;

import java.util.ArrayList;
import java.util.List;

import projeto_final.interfaces.GerenciadorDeProdutos;

public class GerenciadorSupermercado implements GerenciadorDeProdutos {

    List<Produto> produtos = new ArrayList();

    @Override
    public void adicionarEstoque(String titulo, int quantidade) {
        // TODO Auto-generated method stub
        for(Produto produto : produtos){
            if(produto.getTitulo().equalsIgnoreCase(titulo)){
                produto.setQuantidade(produto.getQuantidade()+quantidade);

                System.out.println("adicionado "+quantidade+ " unidades ao produto "+produto.getTitulo());
                return;
            }
        }
        System.out.println("O produto especificado não existe");
        
    }

    @Override
    public void adicionarProduto(Produto produto) {

        //verifica se o produto já existe
        
       if(produtos.contains(produto)){
            System.out.println("Este produto já existe.");
            return;
        }

        produtos.add(produto);

        System.out.println("Produto adicionado com sucesso");
    }

    @Override
    public void alterarPreco(String titulo, double preco) {
        // TODO Auto-generated method stub
        for(Produto produto : produtos){
            if(produto.getTitulo().equalsIgnoreCase(titulo)){
                produto.setPreco(preco);;

                System.out.println("O preço do produto "+produto.getTitulo()+ "foi alterado para: "+preco);
                return;
            }
        }
        System.out.println("O produto especificado não existe");
        
    }

    @Override
    public void deletarProduto(String titulo) {
        // TODO Auto-generated method stub
        boolean removido = produtos.removeIf(produto -> produto.getTitulo().equalsIgnoreCase(titulo));
        if(!removido){
            System.out.println("Produto especificaso não existe");
            return;
        }
        System.out.println("Produto removido com uscesso");
    }

    @Override
    public void listarProdutos() {
        // TODO Auto-generated method stub
        System.out.println("========================");
        System.out.println("         PRODUTOS       ");
        System.out.println("========================");
        System.out.println("| PRODUTO | PRECO | QNTD | DESCRICAO | VALIDADE |");
        for(Produto produto : produtos){
            System.out.println(produto.toString());
        }
        System.out.println("========================");
        
    }

}
