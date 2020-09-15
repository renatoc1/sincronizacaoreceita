package com.teste.sincronizacaoreceita.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.teste.sincronizacaoreceita.dominio.Conta;

@Configuration
public class ArquivoContaReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader<Conta> arquivoContaReader(@Value("#{jobParameters['arquivoContas']}") Resource arquivoContas) {
		System.out.println(arquivoContas);
		return new FlatFileItemReaderBuilder<Conta>()
				.name("arquivoContaReader")
				.resource(arquivoContas)
				.delimited()
				.delimiter(";")
				.names(new String [] {"agencia", "conta", "saldo", "status"})
				.addComment("--")
				.targetType(Conta.class)
				.build();
	}
	
}
