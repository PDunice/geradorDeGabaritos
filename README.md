# geradorDeGabaritos<br/><br/>
Corretor de gabaritos escolares estilo Vestibular/ENEM/PAS <br/>
<br/>
Este programa destina-se a gerar um cartao de resposta personalizado automaticamente seguindo as configurações <br/>
pre-determinadas na estrutura do codigo. <br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
<br/>
Este programa funciona no diretório do dropbox que deve estar instalado no computador que irá executar o programa. <br/>
A estrutura básica para o funcionamento deste está no aquivo "cartao.rar" que deve ser descompactado para a pasta "Corretor" a ser criada dentro do dropbox <br/> 
<br/>
"C:\Users\ " + username +"\Dropbox\Corretor\Main" <br/>
"C:\Users\ " + username +"\Dropbox\Corretor\Cartao" <br/>
"C:\Users\ " + username +"\Dropbox\Corretor\Cartao\Bases" <br/>
"C:\Users\ " + username +"\Dropbox\Corretor\Cartao\Cartoes" <br/>
"C:\Users\ " + username +"\Dropbox\Corretor\Cartao\Cartoes\00 1o Bimestre" <br/>
"C:\Users\ " + username +"\Dropbox\Corretor\Cartao\Cartoes\00 2o Bimestre" <br/>
"C:\Users\ " + username +"\Dropbox\Corretor\Cartao\Cartoes\00 3o Bimestre" <br/>
"C:\Users\ " + username +"\Dropbox\Corretor\Cartao\Cartoes\00 4o Bimestre" <br/>
<br/>
No dropbox os diretórios adicionais devem ser criados manualmente.  <br/> 
Dentro de cada uma das ultimas 4 pastas criar uma pasta com o nome da prova<br/>
Exemplo:<br/>
"1EM_I_1_2019" onde:<br/>
'1EM' é 1o ano do ensino médio;<br/>
'I' é de interdisciplinar;<br/>
'1' é de 1o bimestre;<br/>
'2019' é o ano de aplicação.<br/>
<br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
<br/>
Para gerar os cartões já com a matricula e nome dos alunos preenchidos o arquivo lista.txt deve estar presente no seguinte diretório  <br/>
"C:\Users\ " + username +"\Dropbox\Corretor\Main" <br/>
<br/>
Este arquivo deve seguir o padrao:<br/>
<br/>
Nome /t matrícula /t série<br/>
Nome /t matrícula /t série<br/>
Nome /t matrícula /t série<br/>
Nome /t matrícula /t série<br/>
Nome /t matrícula /t série<br/>
<br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
Para gerar os cartões deve-se copiar a pasta "imagenspadrao" para a pasta "C:\Users\ " + username +"\Dropbox\Corretor\Cartao\imagenspadrao" <br/>

+++++++++++++++++++++++++++++++++++++++++++++<br/>
<br/>
// feito automático pela interface <br/>
Para gerar um cartao de resposta deve-se configurar os arquivos base  na pasta "Cartao/bases" e fornecer as intrucoes para o cabecalho pela interface gráfica<br/>
presentes na pasta "C:/ " + username+ "/dropbox/Corretor/Cartao" seguindo as configurações estabelecidas neste guia.<br/>
<br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
<br/>
// feito automático pela interface <br/>
Na pasta base estao os arquivos que geram contem as intrucoes para gerar a sequencia de tipos de questoes <br/>
<br/>
<br/>
numero de questoes<br/>
Questao Tipo<br/>
Questao Tipo<br/>
Questao Tipo<br/>
Questao Tipo<br/>
Questao Tipo<br/>
<br/>

Onde o tipo da questao deverá ser<br/>
1 - caso a questao seja do tipo A (CERTO OU ERRADO)<br/>
2 - Questoes do tipo B (Resultado numérico)<br/>
3 - caso a questao seja do tipo C (Multipla escolha 4 opcoes)<br/>
4 - caso a questao seja do tipo C' (Multipla escolha 5 opcoes)<br/>
5 - caso a questao seja do tipo D (Discertativa)<br/>
<br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
<br/>
O limite  de questoes estabelecido para uso é de 150 questoes.<br/>
Dentre estas pode haver no máximo 6 questoes do tipo B.<br/>
As questoes tipo A,C , C' D somente obedecem o limite de 150 questoes totais<br/>
podendo haver a quantidade desejada de cada uma no arquivo base.txt<br/>
<br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
<br/>
As intrucoes no arquivo C:/Cartao/IntrucaoCabecalho.txt<br/>
sao geradas automaticamente pelo programa ao acionar o botao presente na interface grafica<br/>
<br/>
que segue o padrao:<br/>
1º linha Série -> 1EM , 2EM, 3EM, 9EF, 8EF, 7EF, 6EF<br/>
2º linha tipo prova -> I (Interdisciplinar), S (Simulado), v ( Verificação)<br/>
3º linha bimestre -> 1,2,3,4<br/>
4º linha ano -> 2013, 2014, 2015, 2016, 2017,2018 ,2019<br/>
5º linha dia -> 0,1,2 (Prova unica, 1ºdia , 2º dia)<br/>
6º linha numeroMatricula -> 6,7,8,9 digitos<br/>
<br/>
deve-se somente colocar a opcao correspondente em da linha<br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
<br/>
Caso queira fazer modificações na logo e nome da escola que vai no cartao de resposta<br/>
basta modificar o arquivo logo.jpg e NomeEscola.jpg na pasta cabecalho. <br/>
Deve-se manter o mesmo tamanho das imagens 300x300 pixels (logo) e 850x70 pixels (NomeEscola)<br/>
A fonte utilizada foi Arial tamanho 30 negrito.<br/>
<br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
<br/>
Este programa foi criado de forma a complementar o programa "Corretor.jar" de minha autoria também.<br/>
Caso tenha interesse no programa para corrigir automaticamente os cartoes de resposta de<br/>
 acordo com um cartao de gabarito entre em contato.<br/>
<br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
<br/>
Pedro Paulo Dunice<br/>
Universidade de Brasília UNB<br/>
Engenharia de Energia<br/>
pedro.dunice@gmail.com<br/>
<br/><br/>
