package com.teste.sincronizacaoreceita.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.teste.sincronizacaoreceita.dominio.Conta;

@Configuration
public class ContaStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step contaStep(ItemReader<Conta> arquivoContaReader, ItemProcessor<Conta, Conta> contaProcessor, ClassifierCompositeItemWriter<Conta> contaClassifierWriter,
			@Qualifier("contaWriter") FlatFileItemWriter<Conta> contaWriter, @Qualifier("contaInvalidWriter") FlatFileItemWriter<Conta> contaInvalidWriter) {
		return stepBuilderFactory
				.get("contaStep")
				.<Conta, Conta>chunk(1)
				.reader(arquivoContaReader)
				.processor(contaProcessor)
				.writer(contaClassifierWriter)
				.faultTolerant()
				.skip(Exception.class)
				.skipLimit(2)
				.stream(contaWriter)
				.stream(contaInvalidWriter)
				.build();
	}

}
