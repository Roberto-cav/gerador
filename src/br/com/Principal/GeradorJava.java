package br.com.Principal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.Gerador.GeraController;
import br.com.Gerador.GeraDAOImpl;
import br.com.Gerador.GeraInterface;
import br.com.Gerador.GeraObjetoJava;
import br.com.Gerador.GeraService;
import br.com.Gerador.InformationSchema;
import br.com.Objeto.Column;
import br.com.Objeto.ConsColumn;

public class GeradorJava {

	public static void main(String[] args) throws SQLException, Exception {

		String schema = "oper21";
		String tabela = "produtos";
		
		criaObjetoJava(listaColunas(schema, tabela));
		criaInterfaceDAO(listaConsColumn(schema, tabela));
		criaDAOImpl(listaColunas(schema, tabela), listaConsColumn(schema, tabela));
		criaInterfaceService(listaConsColumn(schema, tabela));
		//criaControllerInicial(tabela);
		//criaHtmlInicial();
	}

	
	public static List<Column> listaColunas(String schema, String tabela) throws SQLException, Exception {
		InformationSchema infoSch = new InformationSchema();
		List<Column> listaColunas = infoSch.retornaColunasTabela(schema, tabela);
		return listaColunas;
	}
	
	private static List<ConsColumn> listaConsColumn(String schema, String tabela) throws SQLException, Exception {
		InformationSchema infoSch = new InformationSchema();
		List<ConsColumn> listaConsColumn = infoSch.retornaConsColumnPK(schema, tabela);
		return listaConsColumn;
		
	}
	
	private static void criaObjetoJava(List<Column> lista) throws IOException {
		System.out.println("Criando classe .java...");
		GeraObjetoJava obj = new GeraObjetoJava(); 
		obj.geraCodigoJava(lista);
		System.out.println("Classe java criada com sucesso!");
	}
	
	private static void criaInterfaceDAO(List<ConsColumn> lista) throws SQLException, Exception {
		System.out.println("Criando inteface DAO...");
		GeraInterface dao = new GeraInterface();
		dao.geraInterface(lista);
		System.out.println("Interface DAO criada com sucesso!");
	}

	private static void criaDAOImpl(List<Column> lista, List<ConsColumn> listaConsColumn) throws SQLException, Exception {
		System.out.println("Criando classe DAOImpl...");
		GeraDAOImpl impl = new GeraDAOImpl();
		impl.geraDAOImpl(lista, listaConsColumn); 
		System.out.println("Classe DAOImpl criada com sucesso!");
	}
	
	private static void criaControllerInicial(String tabela) throws SQLException, Exception {
		System.out.println("criando classe Controller...");
		GeraController ctrl = new GeraController();
		ctrl.geraController(tabela);
		System.out.println("Classe Controller criada com sucesso");
	}
	
	private static void criaInterfaceService(List<ConsColumn> lista) throws SQLException, Exception {
		System.out.println("Criando inteface Service...");
		GeraService srv = new GeraService();
		srv.geraService(lista);
		System.out.println("Interface Service criada com sucesso!");
	}

}
