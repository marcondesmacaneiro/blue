package puzzle8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Derlei
 */
public class Puzzle8 {

    public static void main(String[] args) {
        ListaTabuleiros processados = new ListaTabuleiros();
        ListaTabuleiros abertos     = new ListaTabuleiros();
        boolean achou               = false;
        int count = 0;
        int qtdMovimentos = 0;

        Tabuleiro inicio = new Tabuleiro(7, 8, 5, 3, 1, 4, 0, 6, 2);
        Tabuleiro fim = new Tabuleiro(1, 2, 3, 4, 5, 6, 7, 8, 0);
        Tabuleiro resultado = new Tabuleiro();

        abertos.add(inicio);

        if (inicio.equals(fim)) {
            System.out.println("Final igual ao inicio \n" + inicio.toString());
            achou = true;
        }

        do {

            ListaTabuleiros filhos = abertos.get(0).getFilhos();
            processados.add((Tabuleiro) abertos.get(0));

            for (Tabuleiro filho : filhos) {
                if (!processados.contains(filho)) {
                    filho.calculaEuristica(fim);
                    abertos.add(filho);
                    //System.out.println(filho.toString());
                    count++;
                }
                
                Collections.sort(abertos);
                
                if (fim.equals(filho)) {
                    achou = true;
                    System.out.println("Fim encontrado");
                    System.out.println(fim.toString());
                    System.out.println(String.format("Total de Verificacoes: %s", count));
                    filho.setPai(abertos.get(0));
                    resultado = filho;
                    while (resultado.getPai() != null) {
                        qtdMovimentos++;
                        System.out.println("Pai: \n" + resultado.getPai().toString());
                        resultado = resultado.getPai();
                    }
                    System.out.println("Movimentos: " + qtdMovimentos);
                    break;
                }
            }
            abertos.remove(0);
        } while (!achou);

    }
}
