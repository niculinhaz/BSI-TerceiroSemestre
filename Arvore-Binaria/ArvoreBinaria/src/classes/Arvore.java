package classes;

import java.util.ArrayList;

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
        AdicionarNo(this.raiz, valor);
    }
    protected void RemoverNo (No no, No anterior, int valor) {}
    public void RemoverNo(int valor) {
        RemoverNo(this.raiz, this.raiz, valor);
    }
    
    public int ContarNos(No no) {
        if (no == null) return 0;
        else return ContarNos(no.getEsquerda()) + ContarNos(no.getDireita()) + 1;
    }
    
    public int getAltura (No no) {
        if (no == null) return 0;
        else {
            int dir = getAltura(no.getDireita());
            int esq = getAltura(no.getEsquerda());
            if (dir > esq) return dir + 1;
            else return esq + 1;
        }
    }

    public int getNiveis (No no) {
        return getAltura(no) - 1;
    }

    public boolean eCompleta () {
        return ContarNos(raiz) == Math.pow(2, getAltura(raiz)) - 1;
        
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

    public void EmLargura (No no) {
        if (no != null) {
            System.out.println(no.toString());
        } if (no.getEsquerda() != null) {
            EmLargura(no.getEsquerda());
        } if (no.getDireita() != null) {
            EmLargura(no.getDireita());
        }
    }

    public void setRaiz (int valor) {
        this.raiz = new No(valor);
    }

    public No getRaiz() {
        return raiz;
    }

    private void BuscarNo(No no, int valor) {
        if (no.getValor() == valor) {
            System.out.println("O nó de valor " + valor + " foi encontrado.");
        } else {
            if (valor < no.getValor()) {
                if (no.getEsquerda() == null) {
                    System.out.println("O nó de valor " + valor + " não foi encontrado.");
                } else {
                    BuscarNo(no.getEsquerda(), valor);
                }
            } else {
                if (valor > no.getValor()) {
                    if (no.getDireita() == null) {
                        System.out.println("O nó de valor " + valor + " não foi encontrado.");
                    } else {
                        BuscarNo(no.getDireita(), valor);
                    }
                }
            }
        }
    }

    public void BuscarNo(int valor) {
        BuscarNo(raiz, valor);
    }
}