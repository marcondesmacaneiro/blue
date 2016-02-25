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
        int qtdMovimentos = 0;
        Tabuleiro tab = new Tabuleiro();

        Tabuleiro inicio = new Tabuleiro(1, 0, 3, 4, 5, 2, 7, 8, 6);
        Tabuleiro fim = new Tabuleiro(1, 2, 3, 4, 5, 6, 7, 8, 0);
        Tabuleiro resultado = new Tabuleiro();

        abertos.add(inicio);

        do {
            if(inicio.equals(fim)){
                System.out.println("Final igual ao inicio \n" + inicio.toString());
                System.out.println(tab.imprime(count));
                break;
            }
                      
            ListaTabuleiros filhos = abertos.get(0).getFilhos();
            processados.add((Tabuleiro)abertos.get(0));
            
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
                    System.out.println("Fim encontrado");
                    System.out.println(fim.toString());
                    System.out.println(tab.imprime(count));
                    fim.setPai(abertos.get(0));
                    resultado = fim;
                    while(resultado.getPai() != null){
                        qtdMovimentos ++;
                        System.out.println("Pai: \n" +resultado.getPai().toString());
                        resultado = resultado.getPai();
                    }
                    System.out.println("Movimentos: " + qtdMovimentos);
                }
                
            }
            abertos.remove(0);
        } while (!achou);

    }
}
