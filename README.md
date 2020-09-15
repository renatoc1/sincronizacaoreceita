## Frameworks e Ferramentas

* Java 8
* Spring Batch
* Lombok
* Maven

## Arquitetura do projeto

Foi utilizado Spring Batch para a leitura do arquivo .csv informado, retornando um arquivo com o resultado do envio da atualização da Receita, adicionando o resultado em uma nova coluna.

## Execução

Executar o maven install para criação do .jar, adicionar o arquivo .csv na raíz do projeto e enviar o nome do arquivo pelo parâmetro dos argumentos de execução (arquivoContas=file:contas.csv);

```execucao
java -jar sincronizacaoreceita-0.0.1-SNAPSHOT.jar arquivoContas=file:contas.csv
```
