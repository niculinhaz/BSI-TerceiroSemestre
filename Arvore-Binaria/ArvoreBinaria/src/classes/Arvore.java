package classes;

public abstract class Arvore {
    public No raiz;

    public Arvore () {
        this.raiz = null;
    }

    public Arvore (int valor) {
        setRaiz(valor);
    }

    protected void AdicionarNo (No no, int valor) {}
    public void AdicionarNo (int valor) {
        AdicionarNo(raiz, valor);
    }
    
    public int ContarNos(No no) {
        if (no == null) return 0;
        else return ContarNos(no.getEsquerda()) + ContarNos(no.getDireita()) + 1;
    }
    
    public int getAltura (No no) {
        if (no == null) return -1;
        else {
            int dir = getAltura(no.getDireita());
            int esq = getAltura(no.getEsquerda());
            if (dir > esq) return dir + 1;
            else return esq + 1;
        }
    }

    public int getNiveis (No no) {
        return getAltura(no) + 1;
    }

    public boolean eCompleta () {
        return ContarNos(raiz) == Math.pow(2, getAltura(raiz)) + 1;
        
    }
    
    public void setRaiz (int valor) {
        this.raiz = new No(valor);
    }

    public No getRaiz() {
        return raiz;
    }
}