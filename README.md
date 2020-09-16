## Frameworks e Ferramentas

* Java 8
* Spring Batch
* Lombok
* Maven

## Arquitetura do projeto

Foi utilizado Spring Batch para a leitura do arquivo .csv informado, retornando um arquivo com o resultado do envio da atualização da Receita, adicionando o resultado em uma nova coluna.

## Execução

1 - Clonar o projeto no diretório escolhido;
2 - Abrir o projeto na IDE e executar "maven install" para a criação do .jar;
3 - Colocar o arquivo .csv (exemplo nome do arquivo: contas.csv) no mesmo local que foi gerado o .jar  ("./target")  e executar no mesmo diretório a seguinte linha de comando:

```execucao
java -jar sincronizacaoreceita-0.0.1-SNAPSHOT.jar arquivoContas=file:contas.csv
```
