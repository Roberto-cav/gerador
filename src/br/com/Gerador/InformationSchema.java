package br.com.Gerador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.ConexaoBanco.ConexaoMySQL;
import br.com.Objeto.Column;
import br.com.Objeto.ConsColumn;


public class InformationSchema {

	private Connection conn = null;
	private Statement  stmt = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public List<Column>  retornaColunasTabela(String tableSchema, String tableName) throws SQLException, Exception {
		
		List<Column> lista = new ArrayList<Column>();
		
		String sql = "select column_name, data_type, is_nullable, column_type, column_key ";
		sql = sql +  "from information_schema.columns ";
		sql = sql +  "where table_schema = '"+tableSchema+"' ";
		sql = sql +  "and   table_name = '"+tableName+"'";

		
		try {
			conn = ConexaoMySQL.getConnectionMySQL();
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Column column = new Column();
				column.setTableSchema(tableSchema);
				column.setTableName(tableName);
				column.setColumnName(rs.getString("column_name"));
				column.setDataType(rs.getString("data_type"));
				column.setIsNullable(rs.getString("is_nullable"));
				column.setColumnType(rs.getString("column_type"));
				column.setColumnKey(rs.getString("column_key"));
				lista.add(column);
				column = null;
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println("erro");
		} finally {
			conn.close();
		}
		return lista;
	}

	
	public String  retornaDataTypeColuna(String tableSchema, String tableName, String columnName) throws SQLException, Exception {
		
		String dataType = "";
		
		String sql = "select data_type ";
		sql = sql +  "from information_schema.columns ";
		sql = sql +  "where table_schema = '"+tableSchema+"' ";
		sql = sql +  "and   table_name = '"+tableName+"' ";
		sql = sql +  "and   column_name = '"+columnName+"'";
		
		try {
			conn = ConexaoMySQL.getConnectionMySQL();
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				dataType = rs.getString("data_type");
			}
			stmt.close();
		} finally {
			conn.close();
		}
		return dataType;
	}
	
	
	public List<ConsColumn>  retornaConsColumnPK(String constraintSchema, String tableName) throws SQLException, Exception {
		
		List<ConsColumn> lista = new ArrayList<ConsColumn>();
		
		String sql = "select cons.constraint_schema, cons.constraint_name, cons.table_name, consColumns.column_name, consColumns.ordinal_position ";
		sql = sql +  "from information_schema.table_constraints cons, information_schema.key_column_usage consColumns ";
		sql = sql +  "where cons.constraint_schema = '"+constraintSchema+"' ";
		sql = sql +  "and   cons.table_name = '"+tableName+"' ";
		sql = sql +  "and   cons.constraint_schema = consColumns.constraint_schema ";
		sql = sql +  "and   cons.table_name = consColumns.table_name ";
		sql = sql +  "and   cons.constraint_type = 'PRIMARY KEY' ";
		sql = sql +  "and   cons.constraint_name = consColumns.constraint_name ";
		sql = sql +  "order by ordinal_position";
		
		
		try {
			conn = ConexaoMySQL.getConnectionMySQL();
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ConsColumn consColumn = new ConsColumn();
				consColumn.setConstraintSchema(constraintSchema);
				consColumn.setConstraintName(rs.getString("constraint_name"));
				consColumn.setTableName(tableName);
				consColumn.setColumnName(rs.getString("column_name"));
				consColumn.setOrdinalPosition(rs.getString("ordinal_position"));
				lista.add(consColumn);
				consColumn = null;
			}
			stmt.close();
		} finally {
			conn.close();
		}
		return lista;

	}
	
}
