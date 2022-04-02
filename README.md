# Bartender
Prueba técnica para aplicar a desarrollador java en ALDEAMO - GMLSOFTWARE

API construida con java 11, springboot y maven

# PRUEBA

Eres un bar ténder del bar más famoso de tu ciudad. Hay un arreglo de vasos numerados que está
representado por el arreglo A. Adicional se tiene un arreglo con números primos representado
por P.

Valor del array P

P=2,3,5,7,11,13,17…

En cada iteración Qi, retira cada vaso de la parte superior del arreglo A. Determina si el número
del plato es divisible uniformemente por el Pi número primo. Si lo es, agréguelo en un arreglo B.
En caso contrario, añádalo a un arreglo Ai. Guarda los valores de B en el arreglo Respuesta. En
la siguiente iteración, haz lo mismo con los valores del arreglo Ai. Una vez completado el
número necesario de iteraciones Q, almacene los valores restantes de Ai, al final de Respuesta.

Se debe exponer un API que reciba un numero de iteraciones Q y un número del 1 al 5 que
representara el id de la pila de datos a trabajar (script de DB entregados) y entregue el array de
respuesta

# Uso de la API
http://localhost:8080/bartender/Q,id

donde

Q: número de iteraciones

id: número del 1 al 5 que representa el id de la pila de datos a trabajar

# Solución

Ejemplo:
http://localhost:8080/bartender/3,2

En la base de datos buscará el registro con id 2

(2, '3,7,9,5,4,2')

Devolverá como respuesta el siguiente array

[2,4,9,3,5,7]
#
Dado que son 3 iteraciones

Q1: En la primera iteración encontrará que 4 y 2 son divisibles por el primer primo = 2, asi que:

respuesta = 2,4

Q2: En la segunda iteración encontrará que 3 y 9 son divisibles por el segundo primo = 3, asi que:

respuesta = 2,4,9,3

Q3: En la tercera iteración encontrará que 5 es divisibles por el tercer primo = 5, asi que:

respuesta = 2,4,9,3,5

Como ya no hay más iteraciones agrega los valores restantes a la respuesta, en este caso solo queda el 7, asi que:

respuesta = 2,4,9,3,5,7



