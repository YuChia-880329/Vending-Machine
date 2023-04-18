package template.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;

import util.SQLUtil;
import util.SQLUtil.BiConsumerSQLException;
import util.SQLUtil.ConsumerSQLException;
import util.SQLUtil.FunctionSQLException;

public abstract class ModelDAOTemplate<M, P> {

	protected List<M> searchAll() throws SQLException{
		
		return SQLUtil.searchListTemplate(
				getConnectionSupplier(), 
				getSearchAllSql(), 
				getSearchFunctionSQLException());
	}
	protected M searchById(P pk) throws SQLException {
		
		return SQLUtil.searchOneTemplate(
				getConnectionSupplier(), 
				getSearchByIdSql(pk), 
				getSearchFunctionSQLException());
	};
	protected M add(M model) throws SQLException {
		
		return SQLUtil.addTemplate(getConnectionSupplier(), getAddSql(), model, getAddBiConsumerSQLException());
	}
	protected int update(M model) throws SQLException {
		
		return SQLUtil.updateTemplate(getConnectionSupplier(), getUpdateSql(), getUpdateConsumerSQLException(model));
	}
	protected int delete(P pk) throws SQLException {
		
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
