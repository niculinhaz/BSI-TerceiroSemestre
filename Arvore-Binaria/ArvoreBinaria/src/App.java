import classes.*;

public class App {
    public static void main(String[] args) {
        ArvoreBusca arv = new ArvoreBusca(10);
        arv.AdicionarNo(8);
        arv.AdicionarNo(12);
        arv.AdicionarNo(14);
        arv.AdicionarNo(11);
        arv.AdicionarNo(6);
        arv.AdicionarNo(9);
        arv.AdicionarNo(5);
        arv.AdicionarNo(7);
        arv.AdicionarNo(4);
        arv.AdicionarNo(15);

        System.out.println("altura: " + arv.getAltura(arv.getRaiz()));
        System.out.println("niveis: " + arv.getNiveis(arv.getRaiz()));
        System.out.println("é completa? " + arv.eCompleta());
        System.out.println("total de nós: " + arv.ContarNos(arv.getRaiz()));
        arv.EmOrdem(arv.getRaiz());
    }
}
