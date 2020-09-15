package com.teste.sincronizacaoreceita.dominio;

import java.io.Serializable;

import lombok.Data;

@Data
public class Conta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String agencia;
	
	private String conta;
	
	private String saldo;
	
	private String status;
	
	private String resultado;

}
