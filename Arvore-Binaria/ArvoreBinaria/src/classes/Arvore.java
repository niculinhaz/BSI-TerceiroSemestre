package classes;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public void AdicionarNo(int valor) {
        if (this.raiz == null) {
            raiz = new No(valor);
        } else {
            AdicionarNo(raiz, valor);
        }
    }

    private No AdicionarNo (No no, int valor) {
        if (no == null) {
            no = new No(valor);
            return no;
        } else {
            if (valor < no.getValor()) {
                no.setEsquerda(AdicionarNo(no.getEsquerda(), valor));
          } else if (valor >= no.getValor()) {
                no.setDireita(AdicionarNo(no.getDireita(), valor));
          }
        }
        return no;
    }

    public void PreOrdem (No no) {
        if (no == null) return;
        else {
            System.out.println(no.toString());
            PreOrdem(no.getEsquerda());
            PreOrdem(no.getDireita());
        }
    }

    public void EmOrdem (No no) {
        if (no == null) return;
        else {
            EmOrdem(no.getEsquerda());
            System.out.println(no.toString());
            EmOrdem(no.getDireita());   
        }
    }

    public void PosOrdem (No no) {
        if (no == null) return;
        else {
            PosOrdem(no.getEsquerda());
            PosOrdem(no.getDireita());
            System.out.println(no.toString());
        }
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
        return getAltura(raiz) + 1;
    }

    public boolean eCompleta () {
        return ContarNos(raiz) == Math.pow(2, getAltura(raiz)) + 1;
        
    }
    
    public No getRaiz() {
        return raiz;
    }
}