package com.teste.sincronizacaoreceita.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.teste.sincronizacaoreceita.dominio.Conta;

@Configuration
public class ContaInvalidWriterConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FlatFileItemWriter<Conta> contaInvalidWriter() {
		return new FlatFileItemWriterBuilder()
				.name("contaInvalidWriter")
				.resource(new FileSystemResource("./arquivo_contas_invalid"))
				.delimited()
				.names("agencia", "conta", "saldo", "status", "resultado")
				.build();
	}
	
}
