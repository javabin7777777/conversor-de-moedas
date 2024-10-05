package com.samzubeli.ConversorDeMoedas.api;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Utilidades {

	public boolean verificarEntrada(int valor) {
		if (valor > 0 & valor < 8)
			return false;
		return true;
	}

	public double obterTaxaDeCambio(Conexao con, String key) {
		String bodyJson = con.conectar(key);
		String str = bodyJson.substring(bodyJson.indexOf("{") + 1, bodyJson.lastIndexOf("}"));	
		String[] array = str.split(":");
		return Double.parseDouble(array[array.length - 1]);

	}

	public void imprimirValores(String parMoedas, double moeda, double taxaCambio) {
		DecimalFormat f = new DecimalFormat("###.####");
		System.out.println();
		System.out.println("Valor da taxa de câmbio: " + f.format(taxaCambio));
		System.out.println("Valor" + parMoedas + f.format(moeda));
		System.out.println();
	}
}
