package tda.grafo.matriz;

import java.util.ArrayList;

public class GrafoMatriz {

    //numero de vertices del grafo
    int numVertices;
    //Maximo numero de vertices del grafo
    int maxVertices;
    //Matriz de adyacencia con Clase Float - Null significa que no hay arco
    Float[][] matriz;
    //dirigido o no
    boolean dirigido;

    //alamcenara un arreglo con los previos saltos de cada vertice
    int[] saltoPrev;

    //variable temporal que alamacenara una lista cono los indices del recorrido recorrido mas corto
    ArrayList listSaltos = new ArrayList();

    public GrafoMatriz(int n, int max, boolean d) {
        maxVertices = max;
        numVertices = n;
        matriz = new Float[maxVertices][maxVertices];
        dirigido = d;
        saltoPrev = new int[maxVertices];
    }

    public void agregarVertice() {
        if (numVertices == maxVertices) {
            System.out.println("No es posible agregar vertice!!!");
            return;
        }
        //Ingrementar el numero de vertices
        numVertices++;
    }

    public void agregarArco(int i, int j) {
        //Por defecto, el arco es añadido con peso cero
        agregarArco(i, j, 0);
    }

    public void agregarArco(int i, int j, float w) {
        matriz[i][j] = w;
        //si el grafo es no dirigido debemos agregar también el arco simetrico
        if (!dirigido) {
            matriz[j][i] = w;
        }
    }

    public void eliminarArco(int i, int j) {
        //Actualizar el valor a null
        matriz[i][j] = null;
        //Si es un grafo no dirijido, debemos actualizar el simetrico
        if (!dirigido) {
            matriz[j][i] = null;
        }
    }

    public void mostrarGrafo() {
        //visitar las filas
        for (int i = 0; i < numVertices; i++) {
            //Para cada fila, visitar todas la columnas
            for (int j = 0; j < numVertices; j++) {
                //Imprimir el elemento en la matriz[i,j] y un tab
                System.out.print(matriz[i][j] + "\t");
            }
            //Nuev linea para una nueva fila
            System.out.println();
        }
        System.out.println();
    }

    // Devuelve el indice con peso minimo del arreglo distancias
    public int distanciaMinima(float distancias[], boolean conjuntoS[]) {
        // inicializar valor minimo 
        float min = Float.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < numVertices; v++) {
            if (conjuntoS[v] == false && distancias[v] <= min) {
                min = distancias[v];
                min_index = v;
            }
        }
        return min_index;
    }

    // Mostrar arreglo de ditancias minimas
    public void imprimirTablaRuteo(float distancias[], int sigSalto[]) {
        System.out.println("****** Tabla de Ruteo ******");
        System.out.println("Router\tDistancia\tSiguiente Salto");
        for (int i = 0; i < numVertices; i++) {

            recorridoMasCorto(i);
            if (distancias[i] == 0) {
                System.out.println("R" + i + "\t" + distancias[i] + "\t\t-");
            } else {
                System.out.println("R" + i + "\t" + distancias[i] + "\t\tR" + listSaltos.get(1));
            }

            listSaltos.clear();
        }

    }
    
    //inserta a listSaltos los vertices del recorrido mas corto hacia el vertice destino 
    void recorridoMasCorto(int vertice) {
        if (saltoPrev[vertice] != -1) //si hay vertice previo
        {
            recorridoMasCorto(saltoPrev[vertice]);  //recorro los indices recursivamente
        }
        listSaltos.add(vertice);//se añade a lista los vertices recorridos
    }

    //Algoritmo dijkstra
    public void dijkstra(int verticeFuente) {
        // El arreglo resultante de las distancias mas cortas hacia todos los vertices
        float distancias[] = new float[numVertices];
        // la distancia mas corta de la fuente a i 

        // conjuntoS[i] será verdadero si el vertice i es incluido en el  conjuntoS de caminos mas corto al origen
        // O la distancia del camino mas corto del vertice fuente a i ya finalizo 
        boolean conjuntoS[] = new boolean[numVertices];

        //este arreglo alamacenara los vertices previos de cada vertice
        int previo[] = new int[numVertices];

        // inicializar todas las distancas como infinitas y el conjuntoS de camino mas corto como falso 
        // y los vertices previos 
        for (int i = 0; i < numVertices; i++) {
            distancias[i] = Float.MAX_VALUE;
            conjuntoS[i] = false;
            previo[i] = -1;
        }

        // La distancia del vertice fuente a si mismo siempre es cero
        distancias[verticeFuente] = 0;

        // Encontrar el camino mas corto para todos los vertices 
        for (int contador = 0; contador < numVertices - 1; contador++) {
            //el vertice con la minima distancia del conjunto de vertices que todavia no hayan sido visitado 
            // w es siempre igual al vertice fuente al inicio de la iteracion 
            int w = distanciaMinima(distancias, conjuntoS);

            // Marcar el vertice elejido como visitado 
            conjuntoS[w] = true;

            // Actualiza el valor de la distacia de los vértices adyacentes del vértice seleccionado
            for (int v = 0; v < numVertices; v++) {
                // Actualizar distancias [v] solo si no fue visitado, hay un
                // arco de w a v, y peso total de la ruta del vertice fuente a
                // v a través de w es menor que el valor actual de distancias [v]  

                if (!conjuntoS[v] && matriz[w][v] != null
                        && distancias[w] != Float.MAX_VALUE
                        && distancias[w] + matriz[w][v] < distancias[v]) {

                    distancias[v] = distancias[w] + matriz[w][v];
                    previo[v] = w;
                }
            }
        }
        //guardar los vertices previos de cada vertice en la variable global
        saltoPrev = previo;
        // imprimir la tabla de routeo
        this.imprimirTablaRuteo(distancias, previo);

    }

}