package projeto_final.interfaces;

import projeto_final.classes.Produto;

public interface GerenciadorDeProdutos {
    
    public void adicionarProduto(Produto produto);

    public void listarProdutos();

    public void adicionarEstoque(String titulo, int quantidade);

    public void alterarPreco(String titulo, double preco);

    public void deletarProduto(String titulo);
}
