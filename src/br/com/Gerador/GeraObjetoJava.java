package br.com.Gerador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.Objeto.Column;

public class GeraObjetoJava {

	public void geraCodigoJava(List<Column> lista) throws IOException {

		Util utl = new Util();

		
		
		String path = "/temp/";
		String classe = lista.get(0).getTableName();
		classe = utl.setInitCap(classe);
		classe = utl.setSublinhadoOff(classe);
		classe = utl.retornaSingular(classe);
		
		
		path = path + classe + ".java";
		
		
		String tipoJava     = "";
		String coluna		= "";
		String colunaMetodo	= "";
		String nullAble     = "";
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.append("package br.com.oper21.x"  + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("// Atualizar imports" + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("public class "+ classe +"{" + "\n");
		bw.newLine();
		bw.newLine();
		
		for (int i=0; i<lista.size();i++) {
			tipoJava = utl.getTipoJava(lista.get(i).getDataType());
			coluna   = lista.get(i).getColumnName();
			
			if (coluna.indexOf("_") > -1) {
				coluna = utl.setSublinhadoOff(coluna);
			}
			
			bw.append("   private "+tipoJava+" "+coluna+";"+"\n");
			bw.newLine();
		}
		bw.newLine();

		for (int j=0; j<lista.size();j++) {
			tipoJava = utl.getTipoJava(lista.get(j).getDataType());
			coluna   = lista.get(j).getColumnName();
			colunaMetodo   = utl.setInitCap(coluna);
			
			if (coluna.indexOf("_") > -1) {
				coluna = utl.setSublinhadoOff(coluna);
			}
			
			if (colunaMetodo.indexOf("_") > -1) {
				colunaMetodo    = utl.setSublinhadoOff(colunaMetodo);
			}
			
			bw.append("   public "+tipoJava+" get"+colunaMetodo+"() {"     +"\n");
			bw.newLine();
			bw.append("       return "+coluna+";"   +"\n");
			bw.newLine();
			bw.append("   }");
			bw.newLine();
			bw.append("   public void set"+colunaMetodo+"("+tipoJava+" "+coluna+") {");
			bw.newLine();
			bw.append("       this."+coluna+" = "+coluna+";");
			bw.newLine();
			bw.append("   }");
			bw.newLine();
			
		}
		bw.newLine();
		bw.append("}" + "\n");
		
		bw.close();
		
		
	}

	private static String getTipoJava(String tipo) {
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
	
	public static String setInitCap(String coluna) {
		// converte a letra inicial em maiúscula

		String oldColuna = coluna;
		String letraInicial = oldColuna.substring(0, 1).toUpperCase();
		String newColuna = letraInicial + oldColuna.substring(1, oldColuna.length());
		
		return newColuna;
	}	
		
	public static String setSublinhadoOff(String coluna) {	
		// elimina sublinhado
		String oldColuna = "";
		String newColuna="";
		String parte2 = "";
		
		oldColuna = coluna;
		
		int pos = oldColuna.indexOf("_");
		while (pos > -1) {
			newColuna = oldColuna.substring(0, pos);
			parte2 = oldColuna.substring(pos+1, oldColuna.length());
			parte2 = setInitCap(parte2);

			newColuna = newColuna + parte2;

			pos = newColuna.indexOf("_");
		}
		
		return newColuna;
	}

}
