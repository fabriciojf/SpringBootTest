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

* [https://fabriciojf-mx.herokuapp.com/swagger-ui.html](https://fabriciojf-mx.herokuapp.com/swagger-ui.html)


## Autenticação

| Autenticação | Basic Authentication|
| --- | --- |
| User | admin |
| Password | spr1n6b00t |


## Como testar a API através do Postman

Baixe e instale o Postman através do link:

* [https://www.postman.com/](https://www.postman.com/). 

Caso você ainda não conheça o Postman, aprenda a utilizá-lo através da matéria:

* [Como instalar e utilizar o Postman para enviar requisições HTTP](https://atendimento.tecnospeed.com.br/hc/pt-br/articles/360017143594-Como-instalar-e-utilizar-o-Postman-para-enviar-requisi%C3%A7%C3%B5es-HTTP)

### Realizando uma Consulta (GET)

| Requisição | **GET** |
| --- | --- |
| URI | http://fabriciojf-mx.herokuapp.com/1.0b/terminals/LOGIC |
| LOGIC | chave do objeto Terminal que deseja cosultar |


### Realizando um Post

| Requisição | **POST** |
| --- | --- |
| URI | http://fabriciojf-mx.herokuapp.com/1.0b/terminals |
| Entrada | Linha no modelo CSV separada por ; (ponto e vírgula) | 
| Regra Básica | Não deve aceitar entradas Json |

Modelo de entrada aguardado através do Body

Campos:

```html
logic;serial;model;sam;ptid;plat;version;mxr;mxf;VERFM
```

Tipos:

```json
{
  "VERFM": "string",
  "model": "string",
  "mxf": "string",
  "mxr": 0,
  "plat": 0,
  "ptid": "string",
  "sam": 0,
  "serial": "string",
  "version": "string"
}
```

### Realizando um Put

| Requisição | **PUT** |
| --- | --- |
| URI | http://fabriciojf-mx.herokuapp.com/1.0b/terminals/LOGIC |
| LOGIC | chave do objeto Terminal que deseja atualizar |
| Entrada | Json | 

Modelo do Json aguardado através do Body

```json
{
  "VERFM": "string",
  "model": "string",
  "mxf": "string",
  "mxr": 0,
  "plat": 0,
  "ptid": "string",
  "sam": 0,
  "serial": "string",
  "version": "string"
}
```

### Delete

* Não deve aceitar a ação **Deletar**


### Author

Fabrício S Costa - fabriciojf@gmail.com

* [Linkedin: fabriciojf](https://www.linkedin.com/in/fabricioscosta/)
* [Site: fabriciojf](https://fabriciojf.com)
