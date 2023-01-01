# Stream 
Stream é definido como um fluxo de dados.
É uma interface que representa uma sequência de elementos de um determinando tipo `<T>`, cujo pode ser feito operações agregadas e paralelas.
A API permite trabalhar com conjuntos de elementos de forma mais simples e com um número reduzido de linhas.

Para entendermos na prática o uso de Stream, vamos usar um a lista com números.

``
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 100, 99, 89, 45, 77)
``

Até agora não temos nenhuma novidade!

Caso eu queira iterar todos elementos, podemos fazer o 'foreach' antigo, digo entre aspas, pois não
é um foreach de fato, é um for normal por debaixo dos panos.

**Código**
````java
    for(Integer numero: numeros) {
        System.out.println(numero);
    }
````
**saída**
````
1
2
3
4
100
99
89
45
77
````

### Foreach

Agora iremos usar o `foreach` com `Streams`

**Código**
````java
    numeros.stream()
        .foreach(numero -> System.out.println(numero));
````
A saída será a mesma. É válido ressaltar, que utilizamos stream e lambda, e aplicamos um operação, nesse caso `foreach` para 
que todos os elementos da coleção fossem exibidos.

Vamos utilizar algumas funcionalidades.

### [Skip](https://docs.oracle.com/javase/9/docs/api/java/util/stream/Stream.html#skip-long-)
Vamos entender o método `skip(n)`.
Definimos os n primeiros elementos que serão pulados/ignorados, e o retorno desse método será uma Stream<t>.
Caso o total de elementos da stream for menor que o número **n**, um Stream vazia será retornada

**Código**
````java
    numeros.stream()
        .skip(2)
        .foreach(numero -> System.out.println(numero));
````

**Sáida**
````
3
4
100
99
89
45
77    
````
O método skip ignorou os dois primeiros elementos.

E poderíamos utilizar o skip mais duas ou três vezes se fosse necessário.

### [Limit](https://docs.oracle.com/javase/9/docs/api/java/util/stream/Stream.html#limit-long-)
Esse método serve para limitar a quantidade de elementos que serão utilizados desse fluxo de dados.
Indo desde o primeiro até o número que define o limite.
Retorna um `Stream<T>`

**Código**
````java
    numeros.stream()
        .limit(5)
        .foreach(numero -> System.out.println(numero));

````

**Saída**
````
1
2
3
4
100
````
Ou seja, o código acima exibiu os 5 primeiros elementos.


### [Distinct](https://docs.oracle.com/javase/9/docs/api/java/util/stream/Stream.html#distinct--)
Retorna uma `Stream<T>` de elementos distintos, ou seja, elementos não repetidos. Usa equals e hashcod, então devemos nos 
atentar para implementar os mesmos, caso o objeto seja de uma classe que criamos.

````java
    numbers.stream()
        .distinct()
        .forEach(numero -> System.out.println(numero));
````

Podemos usar todas mescladas. Os métodos `skip(n)`, `limit(n)` e `distinct()` são filtros, pois 
reduzem o tamanho de elementos da Stream.

Porém e se precisarmos fazer um filtro personalizado? uma condição específica?
Para isso, faremos uso do método `filter()`.

### [Filter](https://docs.oracle.com/javase/9/docs/api/java/util/stream/Stream.html#filter-java.util.function.Predicate-)

Retorna uma `Stream<T>` que combine com o filtro/condição/`Predicate` que criarmos

Filtrando os números pares da nossa coleção.

**Código**
````java
    numeros.stream()
        .filter(numero -> numero % 2 == 0)
        .foreach(numero -> System.out.println(numero));
````

**Saída**
````
2
4
100
````

### [Map](https://docs.oracle.com/javase/9/docs/api/java/util/stream/Stream.html#map-java.util.function.Function-)

Retorna um `Stream<T>` de dados transformados, ou seja podemos fazer uma alteração nos nossos dados.

Para entender, multiplicaremos todos os elementos da nossa lista pelo valor 2.

**Código**
````java
    numbers.stream()
        .map(numero -> numero * 2)
        .forEach(numero -> System.out.println(numero));
````

**Saída**
````
2
4
6
8
200
198
178
90
154
````