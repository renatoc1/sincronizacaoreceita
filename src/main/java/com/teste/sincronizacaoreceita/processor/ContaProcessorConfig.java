package com.teste.sincronizacaoreceita.processor;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaProcessorConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ItemProcessor contaProcessor() {
		return new ClassifierCompositeItemProcessorBuilder<>()
				.classifier(classifier())
				.build();
	}

	@SuppressWarnings({ "rawtypes", "serial" })
	private Classifier classifier() {
		return new Classifier<Object, ItemProcessor>() {

			@Override
			public ItemProcessor classify(Object objeto) {
				return new ReceitaServiceProcessor();
			}
			
		};
	}

}
