package desafio_aula_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LojaDeCarros {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Carro> carros = new ArrayList();
        int opcao;
        boolean sair = false;

        do {
        
            System.out.println("""
                    =======================
                            CARROS         
                    =======================
                    1 - adicionar carro
                    2 - listar carros
                    3 - sair
            """);

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){

                case 1: {
                    System.out.println("Informe o modelo do carro");
                    String modelo = sc.nextLine();

                    System.out.println("Informe a cor do carro");
                    String cor = sc.nextLine();

                    System.out.println("Informe o preço do carro");
                    int preco = sc.nextInt();
                    sc.nextLine(); 

                    Carro carro = new Carro(modelo, cor, preco);
                    
                    carros.add(carro);
                }
                    break;

                case 2: {
                    for(Carro carro : carros){
                        System.out.println(carro.toString());
                    }
                }
                    break;

                case 3: sair = true;
                    break;

                default: {
                    System.out.println("opção inválida");
                }
            }
        } while(!sair);

        sc.close();
    }
}
