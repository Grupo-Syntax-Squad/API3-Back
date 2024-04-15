package com.assetbox.api.enums;

public enum ManutencaoStatus {
	CONCLUIDO(1),
	EM_ANDAMENTO(2),
	EM_ESPERA(3);
	
	private int code;
	
	private ManutencaoStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static ManutencaoStatus valueOf (int code) {
		for (ManutencaoStatus value : ManutencaoStatus.values()) {
			if (code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de status inválido!");
	}
}
