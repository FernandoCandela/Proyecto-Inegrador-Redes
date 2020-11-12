# ProyectoIntegradorRedes
Implementación del algoritmo de Dijkstra

Tabajo Integrador del curso de Redes de computadoras

Fernando Candela Maldonado 20171937

### ¿Como abrir el Proyecto? 

Para abrir el proyecto utilizamos el IDE NetBeans con Java v8, existen dos formas de obtener el proyecto, el primero con la opción clonar del NetBeans, para ello ingresar al NetBeans en la barra de herramientas dirigirse a la ruta "Team/Git/Clone" al abrir se tiene ingresar la URL del repositorio. La otra opción es descargar el proyecto en un archivo .zip y abrirlo con NetBeans en la ruta "File/OpenProject" y seleccionar la ubicación del archivo descomprimido.

Para ejecutar la aplicación dirigirse a la clase “main”, darle click derecho y darle a la opción “Run File”.

### Explicación del contenido del Proyecto 

El programa cuenta con dos clases:

El primero llamado "GrafoMatriz" el cual contiene toda la lógica del programa y el algoritmo de Dijkstra, el segundo llamado "main", donde se realizará los llamados a las funciones de la clase GrafoMatriz, en este caso ya cuenta con las 3 topologías de prueba ingresadas predeterminadamente
  
  Si se desea ingresar más topologías tiene que realizar los siguientes pasos:
  
  -Tiene que generar un nuevo grafo(este objeto contendrá la matriz de adyacencia del grafo) 
 
    GrafoMatriz "Nombre de la topología" = new GrafoMatriz("numero de Vértices”,” máximo de vértices");
    
  -Luego de definir el tamaño de la topología se procede a ingresar los arcos (los enlaces)
  
    "Nombre de la topología".agregarArco("vértice inicio”,” vértice fin", "costo");
    
    Repetir el paso hasta generar los enlaces deseados
    
  -Para mostrar la matriz de adyacencia generado
  
    "Nombre de la topología".mostrarGrafo();
    
  -Para ejecutar el algoritmo de Dijkstra y mostrar la tabla de ruteo\n
  
    "Nombre de la topología".dijkstra("Vértice Fuente");
    
     Vértice Fuente es el vértice desde donde se ejecutará el algoritmo de Dijkstra      
