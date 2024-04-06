import classes.*;

public class App {
    public static void main(String[] args) {
        ArvoreBusca arv = new ArvoreBusca();
        arv.AdicionarNo(10);
        arv.AdicionarNo(13);
        arv.AdicionarNo(7);
        arv.AdicionarNo(14);
        arv.AdicionarNo(12);
        arv.AdicionarNo(5);
        arv.AdicionarNo(2);

        //arv.EmOrdem(arv.getRaiz());
        int num = 9;
        System.out.println("total: " + arv.ContarNos(arv.getRaiz()));
        System.out.println("altura: " + arv.getAltura(arv.getRaiz()));
        System.out.println("niveis: " + arv.getNiveis(arv.getRaiz()));
        arv.BuscarNo(num);
        //System.out.println("é completa? " + arv.eCompleta());
    }
}
