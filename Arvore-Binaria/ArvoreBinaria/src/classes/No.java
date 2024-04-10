package classes;

public class No {
    private int valor;
    private No direita;
    private No esquerda;

    public No () {}

    public No (int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public No getDireita() {
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setDireita (No no) {
        this.direita = no;
    }

    public void setEsquerda (No no) {
        this.esquerda = no;
    }

    public void setNo (No no) {
        this.valor = no.getValor();
        this.direita = no.getDireita();
        this.esquerda = no.getEsquerda();
    }

    @Override
    public String toString() {
        String ret = "";
        ret = ret + this.getValor();
        return ret;
    }
}
