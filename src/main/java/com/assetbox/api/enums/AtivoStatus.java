package com.assetbox.api.enums;

public enum AtivoStatus {
	EM_OPERACAO("1"),
	OCIOSO("2"),
	EM_MANUTENCAO("3"),
	DESATIVADO("4");
	
	private String status;
	
	private AtivoStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return status;
	}
	// public static AtivoStatus valueOf (int code) {
	// 	for (AtivoStatus value : AtivoStatus.values()) {
	// 		if (status == value.getCode()) {
	// 			return value;
	// 		}
	// 	}
	// 	throw new IllegalArgumentException("Código de status inválido!");
	// }
}
