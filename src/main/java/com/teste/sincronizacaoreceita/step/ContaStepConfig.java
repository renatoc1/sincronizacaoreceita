package com.teste.sincronizacaoreceita.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.teste.sincronizacaoreceita.dominio.Conta;

@Configuration
public class ContaStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step contaStep(ItemReader<Conta> arquivoContaReader, ItemProcessor<Conta, Conta> contaProcessor, ItemWriter<Conta> bancoContaWriter) {
		return stepBuilderFactory
				.get("contaStep")
				.<Conta, Conta>chunk(1)
				.reader(arquivoContaReader)
				.processor(contaProcessor)
				.writer(bancoContaWriter)
				.build();
	}

}
