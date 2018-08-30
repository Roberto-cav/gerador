package br.com.Gerador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.Gerador.InformationSchema;
import br.com.Objeto.ConsColumn;

public class GeraInterface {
	
	public void geraInterface(List<ConsColumn> lista) throws SQLException, Exception {
		
		Util utl = new Util();
		InformationSchema infoSch = new InformationSchema();

		String tabela =lista.get(0).getTableName();
		String objeto = tabela;
		objeto = utl.setInitCap(objeto);
		objeto = utl.setSublinhadoOff(objeto);

		
		objeto = utl.retornaSingular(objeto);
		
		String path = "/temp/";
		path = path + objeto + "DAO.java";

		String coluna = "";
		String tipoJava = "";
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.append("package br.com.oper21.daos.x"  + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("import java.util.List;");
		bw.newLine();
		bw.append("// Atualizar imports" + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("public interface "+ objeto +"DAO {" + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("   public boolean insere(" + objeto +", " + objeto.toLowerCase() + ") ; " + "\n");
		bw.newLine();
		bw.append("   public boolean atualiza(" + objeto +", " + objeto.toLowerCase() + ") ; " + "\n");
		bw.newLine();
		bw.append("   public List<"+ objeto +"> lista(** atualizar parametros**); " + "\n");
		bw.newLine();

		bw.append("   public " + objeto + " recupera(" );
		for (int i=0; i<lista.size();i++) {
			
			coluna = lista.get(i).getColumnName();
			
			tipoJava = infoSch.retornaDataTypeColuna("oper21", tabela, coluna);
			tipoJava = utl.setSublinhadoOff(tipoJava);

			coluna = utl.setSublinhadoOff(coluna);

			
			bw.append(tipoJava + " " + coluna);
			if (i<lista.size()-1) {
				bw.append(",");
			}
		}
		bw.append("); ");
		bw.newLine();
		bw.newLine();
		bw.append("}" + "\n");
		
		bw.close();
		
	}
}
