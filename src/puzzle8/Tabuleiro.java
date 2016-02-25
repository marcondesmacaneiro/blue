package puzzle8;

/**
 * Classe com as informações do tabuleiro do jogo
 * @author Derlei
 */
public class Tabuleiro {

    private int l1c1;
    private int l1c2;
    private int l1c3;
    private int l2c1;
    private int l2c2;
    private int l2c3;
    private int l3c1;
    private int l3c2;
    private int l3c3;

    private int h1;
    private int h2;

    private Tabuleiro pai = null;

    public Tabuleiro(int l1c1, int l1c2, int l1c3, int l2c1, int l2c2, int l2c3, int l3c1, int l3c2, int l3c3) {
        this.l1c1 = l1c1;
        this.l1c2 = l1c2;
        this.l1c3 = l1c3;
        this.l2c1 = l2c1;
        this.l2c2 = l2c2;
        this.l2c3 = l2c3;
        this.l3c1 = l3c1;
        this.l3c2 = l3c2;
        this.l3c3 = l3c3;
    }

    public Tabuleiro() {}

    /**
     * Método para calcular a euristica
     * @param tabuleiro Tabuleiro
     * @return Valor da euristica
     */
    public int calculaEuristica(Tabuleiro tabuleiro) {
        return calcH1(tabuleiro) + calcH2(tabuleiro);
    }

    public ListaTabuleiros getFilhos() {

        ListaTabuleiros filhos = new ListaTabuleiros();

        if (l1c1 == 0) {
            Tabuleiro filho1 = clone();
            filho1.setL1c1(l1c2);
            filho1.setL1c2(l1c1);
            filho1.setPai(this);

            Tabuleiro filho2 = clone();
            filho2.setL2c1(l1c1);
            filho2.setL1c1(l2c1);
            filho2.setPai(this);

            filhos.add(filho1);
            filhos.add(filho2);

            return filhos;
        }
        if (l1c2 == 0) {
            Tabuleiro filho1 = clone();
            filho1.setL1c1(l1c2);
            filho1.setL1c2(l1c1);
            filho1.setPai(this);

            Tabuleiro filho2 = clone();
            filho2.setL1c3(l1c2);
            filho2.setL1c2(l1c3);
            filho2.setPai(this);

            Tabuleiro filho3 = clone();
            filho3.setL2c2(l1c2);
            filho3.setL1c2(l2c2);
            filho3.setPai(this);

            filhos.add(filho1);
            filhos.add(filho2);
            filhos.add(filho3);

            return filhos;
        }
        if (l1c3 == 0) {
            Tabuleiro filho1 = clone();
            filho1.setL1c3(l1c2);
            filho1.setL1c2(l1c3);
            filho1.setPai(this);

            Tabuleiro filho2 = clone();
            filho2.setL1c3(l2c3);
            filho2.setL2c3(l1c3);
            filho2.setPai(this);

            filhos.add(filho1);
            filhos.add(filho2);

            return filhos;
        }
        if (l2c1 == 0) {
            Tabuleiro filho1 = clone();
            filho1.setL2c1(l1c1);
            filho1.setL1c1(l2c1);
            filho1.setPai(this);

            Tabuleiro filho2 = clone();
            filho2.setL2c1(l3c1);
            filho2.setL3c1(l2c1);
            filho2.setPai(this);

            Tabuleiro filho3 = clone();
            filho3.setL2c1(l2c2);
            filho3.setL2c2(l2c1);
            filho3.setPai(this);

            filhos.add(filho1);
            filhos.add(filho2);
            filhos.add(filho3);

            return filhos;
        }
        if (l2c2 == 0) {
            Tabuleiro filho1 = clone();
            filho1.setL2c2(l1c2);
            filho1.setL1c2(l2c2);
            filho1.setPai(this);

            Tabuleiro filho2 = clone();
            filho2.setL2c2(l2c3);
            filho2.setL2c3(l2c2);
            filho2.setPai(this);

            Tabuleiro filho3 = clone();
            filho3.setL2c1(l2c2);
            filho3.setL2c2(l2c1);
            filho3.setPai(this);

            Tabuleiro filho4 = clone();
            filho4.setL3c3(l2c2);
            filho4.setL2c2(l3c3);
            filho4.setPai(this);

            filhos.add(filho1);
            filhos.add(filho2);
            filhos.add(filho3);
            filhos.add(filho4);

            return filhos;
        }
        if (l2c3 == 0) {
            Tabuleiro filho1 = clone();
            filho1.setL2c3(l2c2);
            filho1.setL2c2(l2c3);
            filho1.setPai(this);

            Tabuleiro filho2 = clone();
            filho2.setL2c3(l3c3);
            filho2.setL3c3(l2c3);
            filho2.setPai(this);

            Tabuleiro filho3 = clone();
            filho3.setL2c3(l1c3);
            filho3.setL1c3(l2c3);
            filho3.setPai(this);

            filhos.add(filho1);
            filhos.add(filho2);
            filhos.add(filho3);

            return filhos;
        }
        if (l3c1 == 0) {
            Tabuleiro filho1 = clone();
            filho1.setL3c1(l2c1);
            filho1.setL2c1(l3c1);
            filho1.setPai(this);

            Tabuleiro filho2 = clone();
            filho2.setL3c1(l3c2);
            filho2.setL3c2(l3c1);
            filho2.setPai(this);

            filhos.add(filho1);
            filhos.add(filho2);

            return filhos;
        }
        if (l3c2 == 0) {
            Tabuleiro filho1 = clone();
            filho1.setL3c2(l3c1);
            filho1.setL3c1(l3c2);
            filho1.setPai(this);

            Tabuleiro filho2 = clone();
            filho2.setL3c2(l2c2);
            filho2.setL2c2(l3c2);
            filho2.setPai(this);

            Tabuleiro filho3 = clone();
            filho3.setL3c2(l3c3);
            filho3.setL3c3(l3c2);
            filho3.setPai(this);

            filhos.add(filho1);
            filhos.add(filho2);
            filhos.add(filho3);

            return filhos;
        }
        if (l3c3 == 0) {
            Tabuleiro filho1 = clone();
            filho1.setL3c3(l3c2);
            filho1.setL3c2(l3c3);
            filho1.setPai(this);

            Tabuleiro filho2 = clone();
            filho2.setL3c3(l2c3);
            filho2.setL2c3(l3c3);
            filho2.setPai(this);

            filhos.add(filho1);
            filhos.add(filho2);

            return filhos;
        }
        return filhos;
    }

    /**
     * Create new Tabuleiro from this
     *
     * @return Tabuleiro
     */
    protected Tabuleiro clone() {

        Tabuleiro novo = new Tabuleiro();

        novo.setL1c1(l1c1);
        novo.setL1c2(l1c2);
        novo.setL1c3(l1c3);
        novo.setL2c1(l2c1);
        novo.setL2c2(l2c2);
        novo.setL2c3(l2c3);
        novo.setL3c1(l3c1);
        novo.setL3c2(l3c2);
        novo.setL3c3(l3c3);

        return novo;
    }

     private int calcH1(Tabuleiro t){
       
        int cont = 0;
        
        if(t.l1c1 != l1c1)
            cont ++;
        if(t.l1c2 != l1c2)
            cont ++;
        if(t.l1c3 != l1c3)
            cont ++;
        if(t.l2c1 != l2c1)
            cont ++;
        if(t.l2c2 != l2c2)
            cont ++;
        if(t.l2c3 != l2c3)
            cont ++;
        if(t.l3c1 != l3c1)
            cont ++;
        if(t.l3c2 != l3c2)
            cont ++;
        if(t.l3c3 != l3c3)
            cont ++;    

        return cont;
    }
    
    /**
     * Compare two Objects type of Tabuleiro
     *
     * @param tabuleiro Tabuleiro
     * @return boolean
     */
    protected boolean equals(Tabuleiro tabuleiro) {
        if (tabuleiro.l1c1 != l1c1) {
            return false;
        }

        if (tabuleiro.l1c2 != l1c2) {
            return false;
        }

        if (tabuleiro.l1c3 != l1c3) {
            return false;
        }

        if (tabuleiro.l2c1 != l2c1) {
            return false;
        }

        if (tabuleiro.l2c2 != l2c2) {
            return false;
        }

        if (tabuleiro.l2c3 != l2c3) {
            return false;
        }

        if (tabuleiro.l3c1 != l3c1) {
            return false;
        }

        if (tabuleiro.l3c2 != l3c2) {
            return false;
        }

        return tabuleiro.l3c3 == l3c3;
    }

    @Override
    public String toString() {
        String tabuleiro = "";
        tabuleiro += String.format("| %s | %s | %s | \n", l1c1, l1c2, l1c3);
        tabuleiro += String.format("| %s | %s | %s | \n", l2c1, l2c2, l2c3);
        tabuleiro += String.format("| %s | %s | %s | \n", l3c1, l3c2, l3c3);
        return tabuleiro;
    }

    private int calcH2(Tabuleiro tabuleiro) {
        return calcDistanciamManhattanL1c1(tabuleiro)
                + calcDistanciamManhattanL1c2(tabuleiro)
                + calcDistanciamManhattanL1c3(tabuleiro)
                + calcDistanciamManhattanL2c1(tabuleiro)
                + calcDistanciamManhattanL2c2(tabuleiro)
                + calcDistanciamManhattanL2c3(tabuleiro)
                + calcDistanciamManhattanL3c1(tabuleiro)
                + calcDistanciamManhattanL3c2(tabuleiro);
    }

    private int calcDistanciamManhattanL1c1(Tabuleiro t) {
        if (l1c1 == t.getL1c2() || l1c1 == t.getL2c1()) {
            return 1;
        }

        if (l1c1 == t.getL1c3() || l1c1 == t.getL2c2() || l1c1 == t.getL3c1()) {
            return 2;
        }

        if (l1c1 == t.getL3c2() || l1c1 == t.getL2c3()) {
            return 3;
        }

        if (l1c1 == t.getL3c3()) {
            return 4;
        }

        return 0;
    }

    private int calcDistanciamManhattanL1c2(Tabuleiro t) {
        if (l1c2 == t.getL1c3() || l1c2 == t.getL2c2()) {
            return 1;
        }

        if (l1c2 == t.getL3c2() || l1c2 == t.getL2c1() || l1c2 == t.getL2c3()) {
            return 2;
        }

        if (l1c2 == t.getL3c1() || l1c2 == t.getL3c3()) {
            return 3;
        }

        return 0;
    }

    private int calcDistanciamManhattanL1c3(Tabuleiro t) {
        if (l1c3 == t.getL1c3()) {
            return 1;
        }

        if (l1c3 == t.getL2c2() || l1c3 == t.getL3c3()) {
            return 2;
        }

        if (l1c3 == t.getL2c1() || l1c3 == t.getL3c2()) {
            return 3;
        }

        if (l1c3 == t.getL3c1()) {
            return 4;
        }

        return 0;
    }

    private int calcDistanciamManhattanL2c1(Tabuleiro t) {
        if (l2c1 == t.getL2c2() || l2c1 == t.getL3c1()) {
            return 1;
        }

        if (l2c1 == t.getL2c3() || l2c1 == t.getL3c2()) {
            return 2;
        }

        if (l2c1 == t.getL2c3()) {
            return 3;
        }

        return 0;
    }

    private int calcDistanciamManhattanL2c2(Tabuleiro t) {
        if (l2c2 == t.getL2c3() || l2c2 == t.getL3c2()) {
            return 1;
        }

        if (l2c2 == t.getL3c1() || l2c2 == t.getL3c3()) {
            return 2;
        }

        return 0;
    }

    private int calcDistanciamManhattanL2c3(Tabuleiro t) {
        if (l2c3 == t.getL3c3()) {
            return 1;
        }

        if (l2c3 == t.getL3c2()) {
            return 2;
        }

        if (l2c3 == t.getL3c1()) {
            return 3;
        }

        return 0;
    }

    private int calcDistanciamManhattanL3c1(Tabuleiro t) {
        if (l3c1 == t.getL3c2()) {
            return 1;
        }

        if (l3c1 == t.getL3c3()) {
            return 2;
        }

        return 0;
    }

    private int calcDistanciamManhattanL3c2(Tabuleiro t) {
        if (l3c2 == t.l3c3) {
            return 1;
        }

        return 0;
    }

    public int getL1c1() {
        return l1c1;
    }

    public void setL1c1(int l1c1) {
        this.l1c1 = l1c1;
    }

    public int getL1c2() {
        return l1c2;
    }

    public void setL1c2(int l1c2) {
        this.l1c2 = l1c2;
    }

    public int getL1c3() {
        return l1c3;
    }

    public void setL1c3(int l1c3) {
        this.l1c3 = l1c3;
    }

    public int getL2c1() {
        return l2c1;
    }

    public void setL2c1(int l2c1) {
        this.l2c1 = l2c1;
    }

    public int getL2c2() {
        return l2c2;
    }

    public void setL2c2(int l2c2) {
        this.l2c2 = l2c2;
    }

    public int getL2c3() {
        return l2c3;
    }

    public void setL2c3(int l2c3) {
        this.l2c3 = l2c3;
    }

    public int getL3c1() {
        return l3c1;
    }

    public void setL3c1(int l3c1) {
        this.l3c1 = l3c1;
    }

    public int getL3c2() {
        return l3c2;
    }

    public void setL3c2(int l3c2) {
        this.l3c2 = l3c2;
    }

    public int getL3c3() {
        return l3c3;
    }

    public void setL3c3(int l3c3) {
        this.l3c3 = l3c3;
    }

    public Tabuleiro getPai() {
        return pai;
    }

    public void setPai(Tabuleiro pai) {
        this.pai = pai;
    }
}