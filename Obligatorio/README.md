# obligatorio
Obligatorio. Porgramacion II.

Para la carga y lectura del archivo de datos en formato CSV(comma-separated values) se utilizó la libreria BufferedReader.
El tipo abstracto de datos seleccionado para guardar los productos, empresas, marcas, paises y clases fue Hash, debido a su eficiencia en la búsqueda.
Para el primer reporte se recorrió el hash asignado para las empresas, utilizando Iterator. En la entidad empresa se creó una lista de productos habilitados.
Al recorrer las empresas, para poder listar las primeras 20 de mayor a menor según su cantidad de productos habilitados, se creó una cola con prioridad, cuya clave para insertarla era
esa cantidad, obtenida con la operacion .size() aplicada a la lista de productos ya existente. Luego, se obtuvieron los primeros 20 elementos de esa cola, y se listaron. 
Para el segundo reporte, fue necesario crear una clase auxiliar "PaisAux" que contenía al pais y a la cantidad de productos habilitados del mismo.
Dentro de la entidad Marca, se guardaron elementos de tipo PaisAux en otro Hash para ya tener un filtro hecho por pais dentro de marca, con su cantidad de productos habilitados. Luego,
se filtró por marcas, iterando el hash como se hizo en el reporte 1. Dentro de ese recorrido, también se iteró el hash de PaisAux, y se crearon dos colas con prioridad para
marcas y paisaux, cuya clave era la cantidad de productos habilitados en ambas.
Para terminarlo, se recorrieron ambas colas y se listaron las primeras 10.
El tercer reporte se hizo igual que el primero, con el agregado del porcentaje mediante una nueva variable auxiliar que lo calculara.
El cuarto reporte se hizo como el segundo, pero en lugar de tener un hash con PaisAux en la entidad Marca, se creó uno en la entidad Clase.
Para correr el programa, se deberá ejecutar la clase principal y seguir las órdenes que aparecerán en consola.


