package projeto_final.classes;

import java.time.LocalDate;

public class ProdutoPerecivel extends Produto{

    private LocalDate dataValidade;

    public ProdutoPerecivel(String titulo, double preco, int quantidade, String descricao, LocalDate dataValidade) {
        super(titulo, preco, quantidade, descricao);
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return String.format("| %s | %.2f | %d | %s | %s |", titulo, preco, quantidade, descricao, dataValidade.toString());
    }

    

}
