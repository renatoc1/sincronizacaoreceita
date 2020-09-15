package com.teste.sincronizacaoreceita.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.teste.sincronizacaoreceita.dominio.Conta;

@Configuration
public class ContaWriterConfig {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public FlatFileItemWriter<Conta> contaWriter() {
		return new FlatFileItemWriterBuilder()
				.name("contaWriter")
				.resource(new FileSystemResource("./arquivoContaSaida"))
				.delimited()
				.delimiter(";")
				.names("agencia", "conta", "saldo", "status", "resultado")
				.build();
	}
	
}
