package br.com.Gerador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.Objeto.Column;

public class Util {


	
	public String getDataType(String schema, String tabela, String coluna) {
		String dataType = "";
				
		return dataType;
	}
	
	public String getTipoJava(String tipo) {
		String tipoJava = "";
		if (tipo.equalsIgnoreCase("int")) {
			tipoJava = "int";
		} else {
			if (tipo.equalsIgnoreCase("varchar")) {
				tipoJava = "String";
			} else {
				tipoJava = "Date";
			}
		}	
		return tipoJava;
	}
	
	public String setInitCap(String coluna) {
		// converte a letra inicial em maiúscula

		String oldColuna = coluna;
		String letraInicial = oldColuna.substring(0, 1).toUpperCase();
		String newColuna = letraInicial + oldColuna.substring(1, oldColuna.length());
		
		return newColuna;
	}	
		
	public String setSublinhadoOff(String coluna) {	

		// elimina sublinhado
		String oldColuna = "";
		String newColuna="";
		String parte2 = "";
		
		oldColuna = coluna;
		
		int pos = oldColuna.indexOf("_");
		if (pos > -1) {
			while (pos > -1) {

				newColuna = retornaSingular(oldColuna.substring(0, pos));
				parte2 = oldColuna.substring(pos+1, oldColuna.length());
				parte2 = setInitCap(parte2);
	
				newColuna = newColuna + parte2;
				
				oldColuna = newColuna;
				pos = newColuna.indexOf("_");

			}
		} else {
			newColuna = coluna;
		}
		return newColuna;
	}
	
	public String retornaSingular(String plural) {
		String singular = "";
		int tamanho = 0;
		tamanho = plural.length();
		
		if (plural.endsWith("s")) {
			singular = plural.substring(0,tamanho-1);
		} else {
			singular = plural;
		}
		
		return singular;
	}

}
