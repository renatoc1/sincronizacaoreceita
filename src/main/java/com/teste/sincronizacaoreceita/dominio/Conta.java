package com.teste.sincronizacaoreceita.dominio;

import java.io.Serializable;

import org.apache.logging.log4j.util.Strings;

import lombok.Data;

@Data
public class Conta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String agencia;
	
	private String conta;
	
	private String saldo;
	
	private String status;
	
	private String resultado;

	public boolean isValid() {
		return !Strings.isBlank(agencia) && !Strings.isBlank(conta) && !Strings.isBlank(saldo) && !Strings.isBlank(status);
	}

}
