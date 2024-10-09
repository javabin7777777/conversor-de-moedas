package com.samzubeli.ConversorDeMoedas.api;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {	

	public double obterTaxaDeCambio(Conexao con, String key) {		
		String bodyJson = con.conectar(key);
		String str = bodyJson.substring(bodyJson.indexOf("{") + 1, bodyJson.lastIndexOf("}"));		
		String[] array = str.split(":");
		return Double.parseDouble(array[array.length - 1]);
	}

	public void imprimirValores(String parMoedas, double moeda, double taxaCambio) {
		if (moeda > 0) {
			DecimalFormat f = new DecimalFormat("###.####");
			System.out.println();
			System.out.println("Valor da taxa de câmbio: " + f.format(taxaCambio));
			System.out.println("Valor" + parMoedas + f.format(moeda));
			System.out.println();
		}
	}

	public double entradaDeValores(boolean entrada) {
		Scanner ler = new Scanner(System.in);
		if (entrada) {
			try {
				System.out.println("Entre com o valor para conversão de moeda: ".toUpperCase());
				double moeda = ler.nextDouble();
				if (!(moeda > 0)) {
					System.out.println(
							">>>>>>>>>>>>  somente valores maiores que zero são aceitos  <<<<<<<<<<<<<"
									.toUpperCase());
					return 0;
				}
				return moeda;
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println();
				System.out.println(">>>>>>>>>>>>  somente valores numéricos são aceitos  <<<<<<<<<<<<<"
						.toUpperCase());
				System.out.println();
				System.out.println();
			}

			return 0;
		}

		try {
			System.out.println("\n escolha a sua opção: \n".toUpperCase());
			int valor = ler.nextInt();
			if (!(valor > 0 & valor < 8)) {
				System.out.println(
						"\n >>>>>>>>>>>>>  somente valores inteiros entre 1 e 7 são aceitos  <<<<<<<<<<<<<\n"
								.toUpperCase());
				return 0;
			}
			return valor;
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println();
			System.out.println(
					">>>>>>>>>>>>  somente valores numéricos são aceitos   <<<<<<<<<<<<".toUpperCase());
			System.out.println();
			System.out.println();
		}
		return 0;
	}
}
