package puzzle8;

/**
 *
 * @author Derlei
 */
public class Puzzle8 {

    public static void main(String[] args){
        ListaTabuleiros processados = new ListaTabuleiros();
        ListaTabuleiros abertos = new ListaTabuleiros();
        boolean achou = false;
        int count = 0;
        Tabuleiro tab = new Tabuleiro();

        Tabuleiro inicio = new Tabuleiro(1, 2, 3, 4, 0, 6, 7, 8, 5);

        Tabuleiro fim = new Tabuleiro(1, 2, 3, 4, 5, 6, 7, 8, 0);

        abertos.add(inicio);

        do {
            if(inicio.equals(fim)){
                System.out.println(tab.imprime(0));
                break;
            }
                
            
            ListaTabuleiros filhos = abertos.get(0).getFilhos();

            processados.add((Tabuleiro)abertos.get(0));
            abertos.remove(0);
            
            if(processados.contains(inicio)){
                    
                    System.out.println(inicio.toString());
                }
            
            for (Tabuleiro filho : filhos) {
                if(!processados.contains(filho)){
                    abertos.add(filho);
                    System.out.println(filho.toString());
                    count++;
                }
                if(fim.equals(filho)){
                    achou = true;
                    System.out.println("Deu boa");
                    System.out.println(fim.toString());
                    System.out.println(tab.imprime(count));
                    break;
                }
            }
            
        } while (!achou);

    }
}
