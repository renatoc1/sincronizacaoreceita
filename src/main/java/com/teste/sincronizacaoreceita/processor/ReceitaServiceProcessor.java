package com.teste.sincronizacaoreceita.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.batch.item.ItemProcessor;

import com.teste.sincronizacaoreceita.dominio.Conta;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReceitaServiceProcessor implements ItemProcessor<Conta, Conta> {

	@Override
	public Conta process(Conta item) throws Exception {
		String resultado = "";
		boolean result = this.atualizarConta(item.getAgencia(), item.getConta().replace("-", ""), Double.parseDouble(item.getSaldo().replace(",", ".")), item.getStatus());
		resultado = result == true ? "verdadeiro" : "falso";
		item.setResultado(resultado);
		return item;
	}
	
	public boolean atualizarConta(String agencia, String conta, double saldo, String status)
            throws RuntimeException, InterruptedException {
		
			
        // Formato agencia: 0000
        if (agencia == null || agencia.length() != 4 || !NumberUtils.isCreatable(agencia)) {
            return false;
        }
        
        // Formato conta: 000000
        if (conta == null || conta.length() != 6 || !NumberUtils.isCreatable(conta)) {
            return false;
        }
        
        // Tipos de status validos:
        List tipos = new ArrayList();
        tipos.add("A");
        tipos.add("I");
        tipos.add("B");
        tipos.add("P");                
                
        if (status == null || !tipos.contains(status)) {
            return false;
        }

        // Simula tempo de resposta do serviço (entre 1 e 5 segundos)
        long wait = Math.round(Math.random() * 4000) + 1000;
        Thread.sleep(wait);

        // Simula cenario de erro no serviço (0,1% de erro)
        long randomError = Math.round(Math.random() * 1000);
        if (randomError == 500) {
            throw new RuntimeException("Error");
        }

        return true;
    }

}
