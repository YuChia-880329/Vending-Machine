package dao;

public class QueryObj {

	private String queryStatement;
	
	
	QueryObj() {
	}
	QueryObj(String queryStatement) {
		
		this.queryStatement = queryStatement;
	}
	
	
	String getQueryStatement() {
		return queryStatement;
	}
	
	
	void setQueryStatement(String queryStatement) {
		this.queryStatement = queryStatement;
	}
}
