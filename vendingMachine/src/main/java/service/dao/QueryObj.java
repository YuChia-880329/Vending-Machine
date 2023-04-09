package service.dao;

public class QueryObj {

	private String queryStatement;
	
	
	public QueryObj() {
	}
	public QueryObj(String queryStatement) {
		
		this.queryStatement = queryStatement;
	}
	
	
	public String getQueryStatement() {
		return queryStatement;
	}
	
	
	public void setQueryStatement(String queryStatement) {
		this.queryStatement = queryStatement;
	}
}
