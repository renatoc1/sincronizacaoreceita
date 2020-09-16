package com.teste.sincronizacaoreceita.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.teste.sincronizacaoreceita.dominio.Conta;

@Configuration
public class ContaClassifierWriterConfig {

	@Bean
	public ClassifierCompositeItemWriter<Conta> contaClassifierWriter(FlatFileItemWriter<Conta> contaWriter, @Qualifier("contaInvalidWriter") FlatFileItemWriter<Conta> contaInvalidWriter) {
		return new ClassifierCompositeItemWriterBuilder<Conta>()
				.classifier(classifier(contaWriter, contaInvalidWriter))
				.build();
	}

	@SuppressWarnings("serial")
	private Classifier<Conta, ItemWriter<? super Conta>> classifier(
			FlatFileItemWriter<Conta> contaWriter,
			FlatFileItemWriter<Conta> contaInvalidWriter) {
		return new Classifier<Conta, ItemWriter<? super Conta>>() {

			@Override
			public ItemWriter<? super Conta> classify(Conta conta) {
				if (conta.isValid()) {
					return contaWriter;
				} else {
					return contaInvalidWriter;
				}
			}
		};
	}
	
}
