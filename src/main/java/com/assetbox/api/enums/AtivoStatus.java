package com.assetbox.api.enums;

public enum AtivoStatus {
	EM_OPERACAO(1),
	OCIOSO(2),
	EM_MANUTENCAO(3),
	DESATIVADO(4);
	
	private int code;
	
	private AtivoStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static AtivoStatus valueOf (int code) {
		for (AtivoStatus value : AtivoStatus.values()) {
			if (code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de status inválido!");
	}
}
