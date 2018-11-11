package br.com.Gerador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.Gerador.InformationSchema;
import br.com.Objeto.Column;
import br.com.Objeto.ConsColumn;

public class GeraDAOImpl {
	
	public void geraDAOImpl(List<Column> lista, List<ConsColumn> listaConsColumn) throws IOException {
		
		Util utl = new Util();
		InformationSchema infoSch = new InformationSchema();

		String tabela = lista.get(0).getTableName();
		String objeto = tabela;
		objeto = utl.setInitCap(objeto);
		objeto = utl.setSublinhadoOff(objeto);
		objeto = utl.retornaSingular(objeto);

		
		
		String path = "/temp/";
		path = path + objeto + "DAOImpl.java";

		String coluna = "";
		String colunaChave = "";
		String tipoJava = "";
		String metodoGet = "";
		
		
		
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		
		
		
		bw.append("package br.com.oper21.impl.x"  + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("import java.util.List;");
		bw.newLine();
		bw.newLine();
		bw.append("import java.sql.ResultSet;");
		bw.newLine();
		bw.append("import java.sql.SQLException;");
		bw.newLine();
		bw.append("import javax.sql.DataSource;");
		bw.newLine();
		bw.newLine();
		bw.append("import org.springframework.stereotype.Repository;");
		bw.newLine();
		bw.append("import org.springframework.dao.DataAccessException;");
		bw.newLine();
		bw.append("import org.springframework.jdbc.core.*;");
		bw.newLine();
		
		bw.append("// *** Atualizar imports ***" + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("@Repository");
		bw.newLine();
		bw.append("public class "+ objeto +"DAOImpl implements " + objeto + "DAO {" + "\n");
		bw.newLine();
		bw.newLine();
		
		bw.append("   private JdbcTemplate jdbcTemplate;");
		bw.newLine();
		bw.newLine();
		
		bw.append("   public " + objeto + "DAOImple(DataSource datasource) {");
		bw.newLine();
		bw.append("      jdbcTemplate = new JdbcTemplate(datasource); ");
		bw.newLine();
		bw.append("   }");
		bw.newLine();
		bw.newLine();
		
		bw.append("   public boolean insere(" + objeto +", " + objeto.toLowerCase() + ") { " + "\n");
		bw.newLine();
		bw.append("      boolean resultado = false; ");
		bw.newLine();
		bw.newLine();
		bw.append("      String sql = 'insert into "+tabela+"(");
		
		for (int i=0; i<lista.size(); i++) {
			coluna = lista.get(i).getColumnName();
			
			bw.append(tipoJava + " " + coluna);
			if (i<lista.size()-1) {
				bw.append(",");
			}
		}
		bw.append(")'; " + "\n");
		bw.newLine();
		bw.append("       sql = sql + ' values( ");
		
		
		for (int i=0; i<lista.size(); i++) {
		
			
			bw.append(" ?");
			if (i<lista.size()-1) {
				bw.append(",");
			}
		}
		bw.append(")';" + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("      try {" + "\n");
		bw.newLine();
		bw.append("         jdbcTemplate.update(sql, ");
		bw.newLine();
		
		for (int i=0; i<lista.size(); i++) {
			
			metodoGet = lista.get(i).getColumnName();
			metodoGet = utl.setSublinhadoOff(metodoGet);
			metodoGet = utl.setInitCap(metodoGet);
	    	bw.append("                             "+objeto.toLowerCase()+".get"+metodoGet+"()");
			if (i<lista.size()-1) {
				bw.append("," + "  "   +"\n");
			} else {
				bw.append(");" + "  "  +"\n");
			}
			bw.newLine();
		}
		bw.append("         resultado = true; "+"\n");
		bw.newLine();
		bw.append("      } catch(Exception e) {" + "\n");
		bw.newLine();
		bw.append("         resultado = false; "+ "\n");
		bw.newLine();
		bw.append("         System.out.prinln(e.getCause()); "+ "\n");
		bw.newLine();
		bw.append("         System.out.println(e.getMessage()); "+ "\n" );
		bw.newLine();
		bw.append("         System.out.println(e.printStackTrace()); "+ "\n" );
		bw.newLine();
		bw.append("      }" + "\n");
		bw.newLine();
		bw.append("      return resultado;" + "\n");
		bw.newLine();
		bw.append("   }" + "\n");
		
		bw.newLine();
		bw.newLine();
		

		
		bw.append("   public boolean atualiza(" + objeto +" " + objeto.toLowerCase() + ") { " + "\n");
		bw.newLine();
		bw.append("      boolean resultado = false; ");
		bw.newLine();
		bw.newLine();
		bw.append("      String sql = 'update "+tabela+" set ';");
		bw.newLine();
		for (int i=0; i<lista.size(); i++) {
			coluna = lista.get(i).getColumnName();
			
			bw.append( "      sql = sql + ' " + coluna + "=?" );

			if (i<lista.size()-1) {
				bw.append(",';");
			} else {
				bw.append("';");
			}
			bw.newLine();
		}

		bw.append("      sql = sql + ' where '; ");
		bw.newLine();
		for (int i=0; i<listaConsColumn.size(); i++) {
			colunaChave = listaConsColumn.get(i).getColumnName();
			bw.append( "      sql = sql + ' " + colunaChave + "=? " );
			if (i<listaConsColumn.size()-1) {
				bw.append(" and ");
			}
			
		}
		
		bw.append("';" + "\n");
		bw.newLine();
		bw.newLine();
		bw.append("      try {" + "\n");
		bw.newLine();
		bw.append("         jdbcTemplate.update(sql, ");
		bw.newLine();
		
		for (int i=0; i<lista.size(); i++) {
			
			metodoGet = lista.get(i).getColumnName();
			metodoGet = utl.setSublinhadoOff(metodoGet);
			metodoGet = utl.setInitCap(metodoGet);
	    	bw.append("                              "+objeto.toLowerCase()+".get"+metodoGet+"()");
			bw.append("," + "  "   +"\n");
			bw.newLine();
		}
		
		for (int i=0; i<listaConsColumn.size(); i++) {

			metodoGet = listaConsColumn.get(i).getColumnName();
			metodoGet = utl.setSublinhadoOff(metodoGet);
			metodoGet = utl.setInitCap(metodoGet);
	    	bw.append("                              "+objeto.toLowerCase()+".get"+metodoGet+"()");
			if (i<listaConsColumn.size()-1) {
				bw.append("," + "  "   +"\n");
			} else {
				bw.append(");" + "  "   +"\n");
			}
			bw.newLine();
		}
		
		
		bw.append("         resultado = true; "+"\n");
		bw.newLine();
		bw.append("      } catch(Exception e) {" + "\n");
		bw.newLine();
		bw.append("         resultado = false; "+ "\n");
		bw.newLine();
		bw.append("         System.out.prinln(e.getCause()); "+ "\n");
		bw.newLine();
		bw.append("         System.out.println(e.getMessage()); "+ "\n" );
		bw.newLine();
		bw.append("         System.out.println(e.printStackTrace()); "+ "\n" );
		bw.newLine();
		bw.append("      }" + "\n");
		bw.newLine();
		bw.append("      return resultado;" + "\n");
		bw.newLine();
		bw.append("   }" + "\n");
		
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.append("}" + "\n");
		
		bw.close();
		
	}
}
