package tda.grafo.matriz;

public class main {

    public static void main(String args[]) {

        System.out.println("************Topologia 1*********** ");
        GrafoMatriz top1 = new GrafoMatriz(5, 5);
        top1.agregarArco(0, 1, 10);
        top1.agregarArco(0, 3, 30);
        top1.agregarArco(0, 4, 100);

        top1.agregarArco(1, 2, 50);

        top1.agregarArco(2, 4, 10);

        top1.agregarArco(3, 2, 20);
        top1.agregarArco(3, 4, 60);

        top1.mostrarGrafo();
        top1.dijkstra(0);
        System.out.println("");

        System.out.println("************Topologia 2*********** ");
        GrafoMatriz top2 = new GrafoMatriz(8, 8);
        top2.agregarArco(0, 1, 12);
        top2.agregarArco(0, 2, 10);
        top2.agregarArco(0, 3, 6);

        top2.agregarArco(1, 2, 20);
        top2.agregarArco(1, 5, 18);

        top2.agregarArco(2, 5, 30);
        top2.agregarArco(2, 4, 6);

        top2.agregarArco(3, 4, 15);

        top2.agregarArco(4, 6, 32);

        top2.agregarArco(5, 6, 5);
        top2.agregarArco(5, 7, 13);

        top2.agregarArco(6, 7, 3);

        top2.mostrarGrafo();
        top2.dijkstra(5);
        System.out.println("");
 
        System.out.println("************Topologia 3*********** ");
        GrafoMatriz top3 = new GrafoMatriz(11, 11);
        top3.agregarArco(0, 1, 8);
        top3.agregarArco(0, 2, 17);
        top3.agregarArco(0, 3, 15);

        top3.agregarArco(1, 2, 11);
        top3.agregarArco(1, 5, 15);

        top3.agregarArco(2, 8, 5);

        top3.agregarArco(3, 4, 6);
        top3.agregarArco(3, 9, 70);

        top3.agregarArco(4, 5, 14);
        top3.agregarArco(4, 6, 16);
        top3.agregarArco(4, 9, 7);

        top3.agregarArco(5, 7, 7);

        top3.agregarArco(6, 8, 30);
        top3.agregarArco(6, 7, 10);

        top3.agregarArco(9, 10, 20);

        top3.mostrarGrafo();
        top3.dijkstra(6);
        System.out.println("");

    }

}
