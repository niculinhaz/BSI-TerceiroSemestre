package classes;

public class ArvoreBusca {
    private No raiz;

    public ArvoreBusca () {
        this.raiz = null;
    }

    public ArvoreBusca(int valor) {
        setRaiz(valor);
    }

    public void AdicionarNo(No no, int valor) {
        if (no.getValor() == valor) {
            System.out.println("O valor já existe na árvore!");
        } else if (no == null){
            no = new No(valor);
        } else {
            if (valor < no.getValor()) {
                if (no.getEsquerda() == null) {
                    no.setEsquerda(new No(valor));
                } else {
                    AdicionarNo(no.getEsquerda(), valor);
                }
            } else {
                if (no.getDireita() == null) {
                    no.setDireita(new No(valor));
                } else {
                    AdicionarNo(no.getDireita(), valor);
                }
            }
        }
    }

    public void AdicionarNo(int valor) {
        if (raiz == null) {
            setRaiz(valor);
        } else {
            AdicionarNo(raiz, valor);
        }
    }

    public void BuscarNo(No no, int valor) {
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
        if (raiz.getValor() == valor) {
            System.out.println("O nó de valor " + valor + " foi encontrado.");
        } else {
            BuscarNo(raiz, valor);
        }
    }

    public void RemoverNo() {}
    
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

    public void setRaiz (int valor) {
        this.raiz = new No(valor);
    }
    public No getRaiz () {
        return raiz;
    }
}
