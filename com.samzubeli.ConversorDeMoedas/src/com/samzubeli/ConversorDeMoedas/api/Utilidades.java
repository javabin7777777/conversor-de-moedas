package com.samzubeli.ConversorDeMoedas.api;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {
	public double obterTaxaDeCambio(Conexao con, String url) {	
		String bodyJson = con.conectar(url);
		
		if (!bodyJson.isEmpty()) {
			String str = bodyJson.substring(bodyJson.indexOf("{") + 1, bodyJson.lastIndexOf("}"));
			String[] arrayStr1 = str.split(",");
			String[] arrayStr2 = str.split(",");		
			arrayStr1 = arrayStr1[0].split(":");		
			if(arrayStr1[arrayStr1.length-1].compareToIgnoreCase("\"error\"") == 0) {
				System.out.println();
				System.out.println();
				System.out.println("retornou com status error".toUpperCase());
				System.out.println();
				System.out.println();
				return 0;
			} else {
				arrayStr2 = arrayStr2[arrayStr2.length - 1].split(":");				
				return Double.parseDouble(arrayStr2[arrayStr2.length-1]);
			}
		}
		return 0;

	}

	public void imprimirValores(String parMoedas, double moeda, double taxaCambio) {
		if (moeda > 0) {			
			System.out.println();
			System.out.println("Valor da taxa de câmbio: " + formatarValor(taxaCambio));
			System.out.println("Valor" + parMoedas + formatarValor(moeda));
			System.out.println();
		}
	}

	public double entradaDeValores(boolean entrada) {
		Scanner ler = new Scanner(System.in);
		if (entrada) {
			try {
				System.out.println("Entre com o valor para conversão de moeda: ".toUpperCase());
				double moeda = ler.nextDouble();
				moeda = Double.parseDouble(formatarValor(moeda));
				if (moeda <= 0) {
					System.out.println();
					System.out.println();
					System.out.println(
							">>>>>>>>>>>>  somente valores maiores que zero são aceitos  <<<<<<<<<<<<<".toUpperCase());
					System.out.println();
					System.out.println();
					return 0;

				}
				return moeda;
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println();
				System.out.println(">>>>>>>>>>>>  somente valores numéricos são aceitos  <<<<<<<<<<<<<".toUpperCase());
				System.out.println();
				System.out.println();
			}

			return 0;
		}

		try {
			System.out.println("\n escolha a sua opção: \n".toUpperCase());
			int valor = ler.nextInt();		
			if (!(valor > 0 & valor < 8)) {
				System.out.println();
				System.out.println();
				System.out.println("\n >>>>>>>>>>>>>  somente valores inteiros entre 1 e 7 são aceitos  <<<<<<<<<<<<<\n"
						.toUpperCase());
				System.out.println();
				System.out.println();
				return 0;
			}
			return valor;
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println();
			System.out.println(">>>>>>>>>>>>  somente valores numéricos são aceitos   <<<<<<<<<<<<".toUpperCase());
			System.out.println();
			System.out.println();
		}
		return 0;

	}
	
	private String formatarValor(double valor) {
		DecimalFormat f = new DecimalFormat("###.####");		 
		return f.format(valor);
	}
}
