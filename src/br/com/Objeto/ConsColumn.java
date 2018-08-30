package br.com.Objeto;

public class ConsColumn {
	// faz referencia a tabela information_schema.KEY_COLUMN_USAGE
	

	private String constraintSchema;
	private String constraintName;
	private String tableName;
	private String columnName;
	private String ordinalPosition;
	private String refTableSchema;
	private String refTableName;
	private String refColumnName;

	public String getConstraintSchema() {
		return constraintSchema;
	}
	public void setConstraintSchema(String constraintSchema) {
		this.constraintSchema = constraintSchema;
	}
	public String getConstraintName() {
		return constraintName;
	}
	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getOrdinalPosition() {
		return ordinalPosition;
	}
	public void setOrdinalPosition(String ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}
	public String getRefTableSchema() {
		return refTableSchema;
	}
	public void setRefTableSchema(String refTableSchema) {
		this.refTableSchema = refTableSchema;
	}
	public String getRefTableName() {
		return refTableName;
	}
	public void setRefTableName(String refTableName) {
		this.refTableName = refTableName;
	}
	public String getRefColumnName() {
		return refColumnName;
	}
	public void setRefColumnName(String refColumnName) {
		this.refColumnName = refColumnName;
	}
	
	
	
}
