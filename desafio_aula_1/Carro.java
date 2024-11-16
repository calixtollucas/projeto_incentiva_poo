package desafio_aula_1;

public class Carro {
    
    String modelo;
    String cor;
    int preco;

    public Carro(String modelo, String cor, int preco) {
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return "Carro [modelo=" + modelo + ", cor=" + cor + ", preco=" + preco + "]";
    }

}
