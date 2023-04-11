package template.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.Supplier;

import util.SQLUtil;
import util.SQLUtil.BiConsumerSQLException;
import util.SQLUtil.ConsumerSQLException;
import util.SQLUtil.FunctionSQLException;

public abstract class ModelDAOTemplate<M, P> {

	protected List<M> searchAll(){
		
		return SQLUtil.searchListTemplate(
				getConnectionSupplier(), 
				getSearchAllSql(), 
				getSearchFunctionSQLException());
	}
	protected M searchById(P pk) {
		
		return SQLUtil.searchOneTemplate(
				getConnectionSupplier(), 
				getSearchByIdSql(pk), 
				getSearchFunctionSQLException());
	};
	protected M add(M model) {
		
		return SQLUtil.addTemplate(getConnectionSupplier(), getAddSql(), model, getAddBiConsumerSQLException());
	}
	protected int update(M model) {
		
		return SQLUtil.updateTemplate(getConnectionSupplier(), getUpdateSql(), getUpdateConsumerSQLException(model));
	}
	protected int delete(P pk) {
		
		return SQLUtil.deleteTemplate(getConnectionSupplier(), getDeleteSql(pk));
	}
	
	protected abstract Supplier<Connection> getConnectionSupplier();
	
	protected abstract String getSearchAllSql();
	protected abstract String getSearchByIdSql(P pk);
	protected abstract String getAddSql();
	protected abstract String getUpdateSql();
	protected abstract String getDeleteSql(P pk);
	
	protected abstract FunctionSQLException<ResultSet, M> getSearchFunctionSQLException();
	protected abstract BiConsumerSQLException<M, PreparedStatement> getAddBiConsumerSQLException();
	protected abstract ConsumerSQLException<PreparedStatement> getUpdateConsumerSQLException(M model);
}
