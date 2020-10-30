# ProyectoIntegradorRedes
Implementación del algoritmo de Dijkstra

Tabajo Integrador del curso de Redes de computadoras

Fernando Candela Maldonado 20171937

El programa cuenta con dos clases:

  El primero llamado "GrafoMatriz" el cual contiene toda la logica del programa y el algoritmo de Dijstra, el segundo llamado "Main", donde se realizara los llamados a las funciones de la clase GrafoMatriz, en este caso ya cuenta con las 3 topologias de prueba ingresadas predeterminadamente
  
  Si se desea ingresar mas topologias tiene que realizar los siguientes pasos:
  
  -Tiene que generar un nuevo grafo(este objeto contendra la matriz de adyacencia del grafo) 
 
    GrafoMatriz "Nombre de la topologia" = new GrafoMatriz("numero de Vertices","maximo de vertices");
    
  -Luego de definir el tamaño de la topologia se procede a ingresar los arcos (los enlaces)
  
    "Nombre de la topologia".agregarArco("vetice inicio","vertice fin", "costo");
    
    Repetir el paso hasta generar los enlaces deseados
    
  -Para mostrar la matriz de adyacencia generado
  
    "Nombre de la topologia".mostrarGrafo();
    
  -Para ejecutar el algoritmo de Dijkstra y mostrar la tabla de ruteo\n
  
    "Nombre de la topologia".dijkstra("vertice Fuente");
    
     Vertice Fuente es el vertice desde donde se ejecutara el algoritmo de Dijkstra      
  
  
