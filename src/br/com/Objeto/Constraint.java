package br.com.Objeto;

public class Constraint {

	private String tableSchema;
	private String tableName;
	private String constraintType;
	private String constraintSchema;
	private String constraintName;

	public String getTableSchema() {
		return tableSchema;
	}
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getConstraintType() {
		return constraintType;
	}
	public void setConstraintType(String constraintType) {
		this.constraintType = constraintType;
	}
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
	
	
}
