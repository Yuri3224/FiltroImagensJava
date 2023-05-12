# Filtros de Imagens em Java

* Nesse programa feito completamente em Java você vai achar uma interface onde é possível escolher uma imagem da sua máquina e aplicar alguns dos filtros que estão disponibilizados.
alguns deles são:
 
 * Filtro negativo
 * Filtro Media (remover ruídos)
 * Filtro Mediana (remover ruídos)
 * Filtro Binarização (utilizado para separar branco e preto)
 
* As principais bibliotecas utilizadas foram a **BufferedImage** e os **JFrame, JPanel etc** da **Java Swing**

 
## Como utilizar
* Ao rodar o código esse JFrame se abrirá e você pode escolher qualquer imagem do seu PC

_funciona melhor com imagens quadradas_ 

![Abrir imagens.](https://cdn.discordapp.com/attachments/537311530346217484/1106597499797508126/imgJava.png "Clique em escolher imagem")

* Após selecionar a imagem desejada os filtros irão aparecer na barra superior, pode usar a vontade!

* Os filtros de média e mediana funcionam por kernel (matrizes em suma) onde quanto maior o kernel que você colocar, maior o efeito e a suavização da imagem:

![Média.](https://cdn.discordapp.com/attachments/537311530346217484/1106597492960788510/Screenshot_1.png "Média com kernel baixo")

_ao aumentar o kernel:_

![Mediana](https://cdn.discordapp.com/attachments/537311530346217484/1106597500334379210/Screenshot_2.png "Mediana com kernel maior")

# 
* A binarização funciona com uma limiar, que quanto maior, maior será a nuance de brancos e pretos.

_fato curioso: as bancas de concurso utilizam esse método para que uma máquina leia os gabaritos com mais facilidade, támbem pode ser usado em sensor de digitais para captar as linhas dos dedos_

![Binarizador](https://cdn.discordapp.com/attachments/537311530346217484/1106597499482951831/Screenshot_3.png "Binarização")

<hr> 

## Estrutura do Projeto

* O projeto é dividido em tres classes, separadas por arquivos, onde o **Principal** apenas invoca o programa em si, **metodos** é onde realmente estão os filtros, que seráo chamados na classe **chamada**, é nessa que serão criado os JFrames, que são as abas contendo as telas com a imagem, é bem simples de se entender se você tem alguma noção de OO.

# 

## Instalação 

* Você pode apenas copiar os códigos dos arquivos e colar no seu projeto ou clonar tudo através do `https://github.com/Yuri3224/FiltroImagensJava.git` 

>Caso for usar para algum fim que não seja acadêmico, deixe os creditos, linkando o repositório no seu projeto: `https://github.com/Yuri3224/FiltroImagensJava`

# 

## Contribuição
Pull requests são bem-vindos. Para grandes mudanças, abra um problema primeiro para discutir o que você gostaria de mudar.
Por favor, verifique se há testes adequados e inclua um teste para cada nova funcionalidade ou correção de bug.

# 

## Contato 
Pode entrar em contato comigo no Whatsapp, não garanto responder na mesma hora porém uma hora vou!

<br>
 <a href="https://wa.me/5583988733210?text=Opa,%20Vitor!%20Tudo%20beleza?" target="_blank"><img src="https://img.shields.io/badge/-WhatsApp-%2325c862?style=for-the-badge&logo=whatsapp&logoColor=white" target="_blank"></a> 