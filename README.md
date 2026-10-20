# Fatoração Prima de Inteiros Grandes em Java

## Descrição

Este programa realiza a fatoração prima de um número inteiro utilizando
Java, a classe `BigInteger` e a estrutura de repetição `while`.

A fatoração prima consiste em representar um número inteiro maior que 1
como um produto de números primos.

Por exemplo:

`180 = 2 x 2 x 3 x 3 x 5`

Diferentemente de uma implementação que utiliza `int` ou `long`, este
programa usa `BigInteger`, que permite representar inteiros de tamanho
arbitrário, limitado pela memória disponível.

## Objetivos

-   Compreender o conceito de fatoração prima.
-   Utilizar a classe `BigInteger` para trabalhar com inteiros grandes.
-   Aplicar estruturas de repetição `while`.
-   Utilizar `mod()` para verificar se uma divisão é exata.
-   Utilizar `divide()` para reduzir o número durante a fatoração.
-   Utilizar `compareTo()` para comparar valores `BigInteger`.
-   Compreender a otimização de testar o fator 2 e, depois, apenas
    divisores ímpares.
-   Analisar a complexidade e as limitações da fatoração por tentativa
    de divisores.
-   Utilizar o Apache Maven para compilar e executar um projeto Java.

## Conceito matemático

Todo número inteiro maior que 1 pode ser representado como um produto de
números primos. Essa representação é chamada de fatoração prima.

    Número Fatoração prima
  -------- ------------------------
        12 `2 x 2 x 3`
        45 `3 x 3 x 5`
        91 `7 x 13`
       180 `2 x 2 x 3 x 3 x 5`
       997 `997` --- número primo

Um número primo possui exatamente dois divisores positivos: 1 e ele
mesmo.

## Funcionamento do programa

O programa realiza as seguintes etapas:

1.  **Entrada de dados:** utiliza `Scanner` para ler o número como texto
    e cria um objeto `BigInteger` a partir da entrada.
2.  **Inicialização:** define as constantes `dois` e `um`, usadas nas
    comparações e divisões.
3.  **Remoção dos fatores 2:** enquanto o número for divisível por 2,
    apresenta esse fator e divide o número por 2.
4.  **Teste dos divisores ímpares:** começa pelo divisor 3 e verifica os
    divisores ímpares seguintes.
5.  **Verificação do resto:** usa `mod()` para verificar se o divisor
    atual divide o número exatamente.
6.  **Redução do número:** quando encontra um fator, apresenta-o e
    divide o número por esse fator.
7.  **Atualização do divisor:** quando a divisão não é exata, soma 2 ao
    divisor para testar o próximo número ímpar.
8.  **Fator restante:** se, ao final, restar um número maior que 1, ele
    é apresentado como fator primo.
9.  **Encerramento:** fecha o objeto `Scanner`.

O laço dos divisores ímpares continua enquanto o quadrado do divisor for
menor ou igual ao número restante. Isso evita testar divisores maiores
do que o necessário.

**Observação sobre a saída:** o código apresenta mensagens de
acompanhamento para a remoção dos fatores 2 e para a etapa que diz
"Removendo os fatores iguais a 3". Apesar desse texto, o segundo laço
testa todos os divisores ímpares a partir de 3, e não apenas o fator 3.

## Código-fonte

O arquivo `Principal.java` contém a implementação do programa.

O arquivo `pom.xml`, localizado na raiz do projeto, contém as
configurações necessárias para o gerenciamento e a compilação do projeto
com o Maven.

## Tecnologias utilizadas

-   **Java:** linguagem de programação utilizada na implementação.
-   **Apache Maven:** ferramenta de gerenciamento, compilação e execução
    do projeto.
-   **`Scanner`:** classe utilizada para ler a entrada fornecida pelo
    usuário.
-   **`BigInteger`:** classe de `java.math` que representa inteiros de
    tamanho arbitrário, limitado pela memória disponível.

## Pré-requisitos

Antes de executar o projeto, instale:

-   Java Development Kit (JDK).
-   Apache Maven, caso não esteja utilizando uma ferramenta ou ambiente
    que já o disponibilize.

O programa utiliza recursos disponíveis no JDK 8. Verifique as
instalações com:

``` bash
java -version
javac -version
mvn -version
```

## Como executar

Os comandos a seguir devem ser executados no terminal, a partir do
diretório raiz do projeto, onde está localizado o arquivo `pom.xml`.

### 1. Compilar o projeto

``` bash
mvn compile
```

Esse comando compila o código-fonte do projeto e apresenta eventuais
erros de compilação.

### 2. Executar o programa

Caso o `pom.xml` esteja configurado com o plugin Maven Exec, execute:

``` bash
mvn exec:java -Dexec.mainClass="Principal"
```

Esse comando inicia a classe `Principal` e permite informar o número a
ser fatorado no terminal.

**Importante:** o comando pressupõe que a classe `Principal` esteja no
pacote padrão. Se a classe estiver em um pacote nomeado, informe seu
nome completo no parâmetro `exec.mainClass`. O plugin Maven Exec também
deve estar configurado no `pom.xml`.

### 3. Limpar e recompilar o projeto

``` bash
mvn clean compile
```

O comando `clean` remove os arquivos gerados na compilação anterior,
enquanto `compile` compila novamente o código-fonte.

## Exemplos de execução

### Exemplo 1: número composto

Entrada:

``` text
Informe um numero inteiro maior que 1: 180
```

Fatoração apresentada:

``` text
Fatores primos:
Removendo os fatores iguais a 2
2 x 2 x 3 x 3 x 5
Removendo os fatores iguais a 3
```

A posição exata das mensagens depende do fluxo de saída do programa. A
fatoração prima de 180 é:

`180 = 2 x 2 x 3 x 3 x 5`

### Exemplo 2: número primo

Entrada:

``` text
Informe um numero inteiro maior que 1: 997
```

Fatoração:

``` text
997
```

Como 997 é primo, o próprio número é o único fator primo.

### Exemplo 3: número com fatores repetidos

Entrada:

``` text
Informe um numero inteiro maior que 1: 12
```

Fatoração:

``` text
2 x 2 x 3
```

## Conceitos fundamentais de `BigInteger`

`BigInteger` é uma classe utilizada para realizar operações com inteiros
maiores do que os limites dos tipos primitivos `int` e `long`.

Como `BigInteger` é um objeto imutável, operações como `divide()` e
`add()` retornam novos objetos. Por isso, o resultado precisa ser
atribuído à variável para atualizar o valor usado pelo programa.

Métodos utilizados:

-   `BigInteger.valueOf(2)`: cria um `BigInteger` a partir do valor 2.
-   `BigInteger.ONE`: representa o inteiro 1.
-   `mod(divisor)`: calcula o resto da divisão.
-   `divide(divisor)`: realiza a divisão inteira.
-   `compareTo(valor)`: compara dois valores.
-   `multiply(valor)`: multiplica dois valores.
-   `add(valor)`: soma dois valores.

## Conceito fundamental: redução sucessiva

Quando o número é divisível por um divisor, o programa apresenta esse
fator e divide o número pelo divisor. O processo se repete até que esse
fator não divida mais o número.

Depois de remover os fatores 2, o programa testa apenas divisores
ímpares. Isso reduz a quantidade de tentativas em comparação com testar
todos os inteiros a partir de 2.

## Complexidade do algoritmo

A fatoração por tentativa de divisores ainda pode ser lenta para números
grandes.

-   **Tempo:** o número de tentativas depende do menor fator primo do
    número restante. No pior caso, especialmente para um número primo, o
    algoritmo pode testar divisores até aproximadamente a raiz quadrada
    do número.
-   **Espaço auxiliar:** utiliza uma quantidade constante de variáveis,
    mas o espaço necessário para representar os valores `BigInteger`
    cresce com a quantidade de dígitos.

A classe `BigInteger` permite armazenar valores grandes, mas não torna
automaticamente rápida a fatoração desses valores.

## Limitações

-   O algoritmo pode demorar muito para fatorar números grandes,
    principalmente quando são primos ou possuem fatores primos grandes.
-   O código pressupõe que a entrada seja um inteiro válido. Entradas
    vazias, letras ou números em formato inválido podem provocar
    `NumberFormatException`.
-   O programa solicita um número maior que 1, mas não valida essa
    condição. Para números menores que 2, a fatoração não é apresentada
    corretamente.
-   O texto "Removendo os fatores iguais a 3" não descreve com precisão
    o segundo laço, que testa divisores ímpares a partir de 3.
-   Para fatorar números criptográficos muito grandes, são necessários
    algoritmos mais sofisticados.

## Conclusão

O programa demonstra a fatoração prima de inteiros grandes em Java
usando `BigInteger` e divisões sucessivas. A implementação permite
praticar estruturas de repetição, condicionais, operações aritméticas e
comparação de objetos numéricos.

O uso de `BigInteger` elimina os limites fixos de `int` e `long` para a
representação de inteiros, mas a eficiência da fatoração continua
dependendo do algoritmo utilizado.
