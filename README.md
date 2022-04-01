Ejercicio 2. Modelado y programacion

Eduardo Montaño Gomez.
Modelado y Programación.

Se pide realizar el reto que se muestra en el link.
https://www.beecrowd.com.br/judge/en/problems/view/2253

El programa usa las librerías **InputStreamReader** y **BufferedReader** para poder leer la entrada del
usuario/juez. Las cuales se pueden revisar en el siguiente link: https://docs.oracle.com/javase/7/docs/api/java/io/InputStreamReader.html, https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html.
Dichas librerías se usaron de la siguiente forma en el programa:

- Importamos las librerías **InputStreamReader** y **BufferedReader** de java.io.
- Creamos un objeto de tipo **InputStreamReader** y como argumento al constructor le pasamos *System.in*
para que el programa pueda recibir entrada por teclado.
- Se crea un nuevo objeto de tipo **BufferedReader** y como argumento al constructor le pasamos el
objeto de tipo **InputStreamReader**. 

Con un while leemos lo que el usuario/juez introduce por teclado y cuando ya no haya nada en el stream
se acaba el ciclo.

El programa funciona de la siguiente forma:

Desde la clase *Main* llamamos al metodo auxiliar *passwordValidator*, éste último es el soporte
principal del programa.

El método *passwordValidator* utilza las librerías **InputStreamReader** y **BufferedReader** para
leer la entrada del usuario. Mientras no se presione `Ctrl-d` el programa no finalizará y el stream
seguirá abierto.

Primero se verifica que la cadena introducida por el usuario sea mayor o igual a 6 y menor o igual
a 32 caracteres, también se verifica que la cadena sólo contenga letras no acentuadas y números con
el método *contieneLetrasNoAcentuadasyNumeros*. Si algo de esto ocurre se imprime "Senha invalida." 
y vuelve a pedir la siguiente cadena. 

Si pasa el primer filtro, se verifica que la cadena contenga, al menos, una letra minúscula, una
mayúscula y un dígito con el método *contieneAlMenosUnaMinusculaMayusculaDigito*. Si lo cumple, 
se imprime "Senha valida.". Caso contrario se imprime "Senha invalida.".

El metodo *contieneLetrasNoAcentuadasyNumeros* recibe un string como parámetro. Se recorre el string
mediante un ciclo for, y si el i-ésimo caracter no es ni minúscula, mayúscula ni dígito, regresa false.
Si el ciclo termina entonces regresa true.

El método *contieneAlMenosUnaMinusculaMayusculaDigito* recibe como parámetro un string. Se inicializan 
tres variables de tipo boolean en false, hacen referencia a los caracteres de la cadena e indican si
la cadena contiene una letra minúscula, una letra mayúscula y un dígito. 
Primero se recorre el string del parámetro, para el i-ésimo caracter revisamos si es minúscula, mayúscula y o dígito, y se cambia a true el valor de las respectivas variables. Si las tres variables son true, 
se regresa true. Si termina el ciclo regresamos false.

# Como usar el programa.
Antes de ejecutar el programa debe de contar con la versión 14 de java (OpenJDK). En caso contrario podría
no ser capaz de compilar y/o ejecutar el programa. Deberá contar también de ser posible con un emulador
de terminal, por ejemplo GNO terminal, Xterminal, etc..
Una cosa a tener en mente es que el programa ha sido desarrollado en un ambiente unix, por lo que usarlo 
en otro OS podría hacer que no funcione correctamente.

La carpeta *src* contiene el archivo .java, así que debe de posicionarse en ella y compilar el archivo. En terminal se puede hacer de la siguiente forma:
```
cd src
javac Main.java
```

Esto creará el binario, que es un archivo .class. Ahora solamente queda ejecutar el binario. En la terminal
lo puede hacer de la siguiente manera:
```
java Main
```
El programa quedará en espera de que se le pase algo por medio del teclado. Una vez que introduzca una
línea el programa y presione la tecla *enter*, se arrojará el resultado en pantalla.
Esto lo puede repetir las veces que sea necesario. El programa finaliza si el usuario presiona 
```Ctrl-d```.
