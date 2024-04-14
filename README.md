# API3-Back

## Como rodar o projeto

Primeiramente você deverá baixar a  pasta do projeto, que pode ser obtida através do seguinte link:[https://github.com/Grupo-Syntax-Squad/API3-Back/tree/88150faebaa7cd4b0b17cf9f4e87e99e51cfb3b4](https://github.com/Grupo-Syntax-Squad/API3-Back/tree/88150faebaa7cd4b0b17cf9f4e87e99e51cfb3b4)

baixando a pasta pelo navegador, clicando em "codigo" e depois em "baixar ZIP".

ou pelo cmd com op comando: git clone "https://github.com/Grupo-Syntax-Squad/API3-Back/tree/88150faebaa7cd4b0b17cf9f4e87e99e51cfb3b4"

## Configuração do banco

vá até o arquivo de configuração do banco e altere o usuario e senha para os que você utiliza em seu dispositivo.

para chegar ao arquivo voce deve entrar em "..src\main\java\com\assetbox\api\ApiApplication.java" 

após isso altere o usuario "root" pelo seu usuario e a senha "fatec" pela sua senha.

## iniciar a aplicação

no diretorio inicial abra o CMD ou o terminal e digite os seguintes comandos.

javac src\main\java\com\assetbox\api\ApiApplication.java

java com.assetbox.api.ApiApplication



Após isso o projeto será iniciado .\
ele será aberto no [http://localhost:8000](http://localhost:8000) onde o banco de dados será iniciado, assim  como as rotas das apis.