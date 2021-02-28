# SpringBootTest

Teste técnico avaliando os seguintes aspectos:

* Java
* SqLite / JDBC
* Testes Unitários
* Testes de Integração
* Validações com JsonSchema

## Distribuindo o .jar

Acesse o diretório do projeto e execute o comando mvn clean package

```console
$ cd PATH_DO_PROJETO/
$ mvn clean package
```

Acesse o executável knowledge-test-VERSION.jar dentro da pasta /target e renomeie 
para knowledge-test.jar

## Executando o projeto

### Linux

Para executar o projeto através do terminal Linux:

* Abra o terminal
* Acesse a pasta do projeto
* Digite o comando abaixo

```console
$ java -jar knowledge-test.jar
```

### Windows

Acesse o link abaixo para entender como abrir arquivos .jar no Windows 10

* [Abrindo arquivos .jar no Windows 10](https://answers.microsoft.com/pt-br/windows/forum/windows_10-other_settings/abrindo-arquivos-jar-no-windows-10/59036c1f-5bcf-4826-a833-9b160d7cb3b9)

## Documentação dos Recursos

Acesse a documentação dos recursos através do link:
[http://springboot.fabriciojf.com:3030/swagger-ui.html](http://springboot.fabriciojf.com:3030/swagger-ui.html)

## Como testar a API através do Postman

Baixe e instale o Postman através do link [https://www.postman.com/](https://www.postman.com/).

Caso você ainda não conheça o Postman, aprenda a utilizá-lo através da matéria [Como instalar e utilizar o Postman para enviar requisições HTTP](https://atendimento.tecnospeed.com.br/hc/pt-br/articles/360017143594-Como-instalar-e-utilizar-o-Postman-para-enviar-requisi%C3%A7%C3%B5es-HTTP)

### Realizando uma Consulta

* GET: http://DOMAIN:3030/1.0b/terminals/:logic
  * :logic é referente à chave do objeto Terminal que deseja cosultar

ex:

```console
http://springboot.fabriciojf.com:3030/1.0b/terminals/44332211
```

### Realizando um Post

* POST: http://DOMAIN:3030/1.0b/terminals
* Modelo do Json aguardado através do Body

```json
{
  "VERFM": "string",
  "logic": int,
  "model": "string",
  "mxf": "string",
  "mxr": int,
  "plat": int,
  "ptid": "string",
  "sam": int,
  "serial": "string",
  "version": "string"
}
```

### Realizando um Put

* PUT: http://DOMAIN:3030/1.0b/terminals/:logic  
  * :logic é referente à chave do objeto Terminal que deseja atualizar
* Modelo do Json aguardado através do Body

```json
{
  "VERFM": "string",
  "logic": int,
  "model": "string",
  "mxf": "string",
  "mxr": int,
  "plat": int,
  "ptid": "string",
  "sam": int,
  "serial": "string",
  "version": "string"
}

### Author

Fabrício S Costa - fabriciojf@gmail.com

[![Linkedin: fabriciojf](https://img.shields.io/badge/-Linkedin-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/fabricioscosta/)](https://www.linkedin.com/in/fabricioscosta/)
[![Site: fabriciojf](https://img.shields.io/badge/-PersonalSite-blue?style=flat-square&logo=wordpress&logoColor=white&link=https://fabriciojf.com)](https://fabriciojf.com)