# geradorDeGabaritos
Corretor de gabaritos escolares estilo Vestibular/ENEM/PAS

Este programa destina-se a gerar um cartao de resposta personalizado automaticamente seguindo as configurações 
pre-determinadas na estrutura do codigo.
+++++++++++++++++++++++++++++++++++++++++++++

Este programa em no diretório do dropbox, que deve estar instalado no computador que irá executar o programa. 
No dropbox os seguintes diretórios devem ser criados manualmente 

"C:\Users\" + username +"\Dropbox\Corretor\Main\
"C:\Users\" + username +"\Dropbox\Corretor\Cartao\"
"C:\Users\" + username +"\Dropbox\Corretor\Cartao\Bases"
"C:\Users\" + username +"\Dropbox\Corretor\Cartao\Cartoes"
"C:\Users\" + username +"\Dropbox\Corretor\Cartao\Cartoes\00 1o Bimestre"
"C:\Users\" + username +"\Dropbox\Corretor\Cartao\Cartoes\00 2o Bimestre"
"C:\Users\" + username +"\Dropbox\Corretor\Cartao\Cartoes\00 3o Bimestre"
"C:\Users\" + username +"\Dropbox\Corretor\Cartao\Cartoes\00 4o Bimestre"

e dentro de cada uma das ultimas 4 pastas criar uma pasta com o nome da prova
Exemplo:
"1EM_I_1_2019" onde:
'1EM' é 1o ano do ensino médio;
'I' é de interdisciplinar;
'1' é de 1o bimestre;
'2019' é o ano de aplicação.

+++++++++++++++++++++++++++++++++++++++++++++
Para gerar os cartões deve-se copiar a pasta "imagenspadrao" para a pasta "C:\Users\" + username +"\Dropbox\Corretor\Cartao\imagenspadrao" 
+++++++++++++++++++++++++++++++++++++++++++++

Para gerar os cartões já com a matricula e nome dos alunos preenchidos o arquivo lista.txt deve estar presente no seguinte diretório "C:\Users\" + username +"\Dropbox\Corretor\Main" 

Este arquivo deve seguir o padrao:

Nome /t matrícula /t série
Nome /t matrícula /t série
Nome /t matrícula /t série
Nome /t matrícula /t série
Nome /t matrícula /t série

+++++++++++++++++++++++++++++++++++++++++++++

// feito automático pela interface 
Para gerar um cartao de resposta deve-se configurar os arquivos base  na pasta "Cartao/bases" e fornecer as intrucoes para o cabecalho pela interface gráfica
presentes na pasta "C:/" + username+ "/dropbox/Corretor/Cartao" seguindo as configurações estabelecidas neste guia.

+++++++++++++++++++++++++++++++++++++++++++++

// feito automático pela interface 
Na pasta base estao os arquivos que geram contem as intrucoes para gerar a sequencia de tipos de questoes 


numero de questoes
Questao Tipo
Questao Tipo
Questao Tipo
Questao Tipo
Questao Tipo


Onde o tipo da questao deverá ser
1 - caso a questao seja do tipo A (CERTO OU ERRADO)
2 - Questoes do tipo B (Resultado numérico)
3 - caso a questao seja do tipo C (Multipla escolha 4 opcoes)
4 - caso a questao seja do tipo C' (Multipla escolha 5 opcoes)
5 - caso a questao seja do tipo D (Discertativa)

+++++++++++++++++++++++++++++++++++++++++++++

O limite  de questoes estabelecido para uso é de 150 questoes.
Dentre estas pode haver no máximo 6 questoes do tipo B.
As questoes tipo A,C , C' D somente obedecem o limite de 150 questoes totais
podendo haver a quantidade desejada de cada uma no arquivo base.txt

+++++++++++++++++++++++++++++++++++++++++++++

As intrucoes no arquivo C:/Cartao/IntrucaoCabecalho.txt
sao geradas automaticamente pelo programa ao acionar o botao presente na interface grafica

que segue o padrao:
1º linha Série -> 1EM , 2EM, 3EM, 9EF, 8EF, 7EF, 6EF
2º linha tipo prova -> I (Interdisciplinar), S (Simulado), v ( Verificação)
3º linha bimestre -> 1,2,3,4
4º linha ano -> 2013, 2014, 2015, 2016, 2017,2018 ,2019
5º linha dia -> 0,1,2 (Prova unica, 1ºdia , 2º dia)
6º linha numeroMatricula -> 6,7,8,9 digitos

deve-se somente colocar a opcao correspondente em da linha
+++++++++++++++++++++++++++++++++++++++++++++

Caso queira fazer modificações na logo e nome da escola que vai no cartao de resposta
basta modificar o arquivo logo.jpg e NomeEscola.jpg na pasta cabecalho. 
Deve-se manter o mesmo tamanho das imagens 300x300 pixels (logo) e 850x70 pixels (NomeEscola)
A fonte utilizada foi Arial tamanho 30 negrito.

+++++++++++++++++++++++++++++++++++++++++++++

Este programa foi criado de forma a complementar o programa "Corretor.jar" de minha autoria também.
Caso tenha interesse no programa para corrigir automaticamente os cartoes de resposta de
 acordo com um cartao de gabarito entre em contato.

+++++++++++++++++++++++++++++++++++++++++++++

Pedro Paulo Dunice
Universidade de Brasília UNB
Engenharia de Energia
pedro.dunice@gmail.com
55 (61) 998587076
