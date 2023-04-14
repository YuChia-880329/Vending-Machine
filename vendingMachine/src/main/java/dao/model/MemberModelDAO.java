package dao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Supplier;

import bean.model.MemberModel;
import template.model.ModelDAOTemplate;
import util.OracleDBUtil;
import util.SQLUtil;
import util.SQLUtil.BiConsumerSQLException;
import util.SQLUtil.ConsumerSQLException;
import util.SQLUtil.FunctionSQLException;

public class MemberModelDAO extends ModelDAOTemplate<MemberModel, String> {

	private static final String TABLE_NAME = "BEVERAGE_MEMBER";
	
	private static final String COL_NAME_ID = "IDENTIFICATION_NO";
	private static final String COL_NAME_PW = "PASSWORD";
	private static final String COL_NAME_NAME = "CUSTOMER_NAME";
	
	
	private static final MemberModelDAO INSTANCE = new MemberModelDAO();
	
	private MemberModelDAO() {
	}
	
	public static MemberModelDAO getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected Supplier<Connection> getConnectionSupplier() {
		
		return () -> OracleDBUtil.getConnection();
	}

	
	@Override
	protected String getSearchAllSql() {

		String sqlFormatStr = "SELECT %s, %s, %s FROM %s";
		return String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_PW, COL_NAME_NAME, TABLE_NAME);
	}
	@Override
	protected String getSearchByIdSql(String id) {
		
		String sqlFormatStr = "SELECT %s, %s, %s FROM %s WHERE %s = %s";
		return String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_PW, COL_NAME_NAME, 
				TABLE_NAME, COL_NAME_ID, SQLUtil.singleQuotes(id));
	}
	@Override
	protected String getAddSql() {
		
		String sqlFormatStr = "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)";
		return String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, COL_NAME_PW, COL_NAME_NAME);
	}
	@Override
	protected String getUpdateSql() {
		
		String sqlFormatStr = "UPDATE %s SET %s = ?, %s = ? WHERE %s = ?";
		return String.format(sqlFormatStr, TABLE_NAME, COL_NAME_PW, COL_NAME_NAME, COL_NAME_ID);
	}
	@Override
	protected String getDeleteSql(String id) {
		
		String sqlFormatStr = "DELETE FROM %s WHERE %s = %s";
		return String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, SQLUtil.singleQuotes(id));
	}

	
	@Override
	protected FunctionSQLException<ResultSet, MemberModel> getSearchFunctionSQLException() {

		return rs -> {
		
			MemberModel model = new MemberModel();
			
			model.setId(rs.getString(COL_NAME_ID));
			model.setPw(rs.getString(COL_NAME_PW));
			model.setName(rs.getString(COL_NAME_NAME));
			
			return model;
		};
	}
	@Override
	protected BiConsumerSQLException<MemberModel, PreparedStatement> getAddBiConsumerSQLException() {
		
		return (model, pst) -> {
			
			int index = 1;
			pst.setString(index++, model.getId());
			pst.setString(index++, model.getPw());
			pst.setString(index++, model.getName());
		};
	}
	@Override
	protected ConsumerSQLException<PreparedStatement> getUpdateConsumerSQLException(MemberModel model) {

		return pst -> {
			
			int index = 1;
			pst.setString(index++, model.getPw());
			pst.setString(index++, model.getName());
			pst.setString(index++, model.getId());
		};
	}
}
