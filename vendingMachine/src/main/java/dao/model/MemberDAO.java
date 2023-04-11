package dao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import bean.model.MemberModel;
import util.OracleDBUtil;
import util.SQLUtil;
import util.SQLUtil.BiConsumerSQLException;
import util.SQLUtil.ConsumerSQLException;
import util.SQLUtil.FunctionSQLException;

public class MemberDAO {

	private static final String TABLE_NAME = "BEVERAGE_MEMBER";
	
	private static final String COL_NAME_ID = "IDENTIFICATION_NO";
	private static final String COL_NAME_PW = "PASSWORD";
	private static final String COL_NAME_NAME = "CUSTOMER_NAME";
	
	
	private static final MemberDAO INSTANCE = new MemberDAO();
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		
		return INSTANCE;
	}
	
	
	public List<MemberModel> searchAll(){
		
		String sqlFormatStr = "SELECT %s, %s, %s FROM %s";
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_PW, COL_NAME_NAME, TABLE_NAME);

		return SQLUtil.searchListTemplate(MemberDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public MemberModel searchById(String id) {
		
		String sqlFormatStr = "SELECT %s, %s, %s FROM %s WHERE %s = %s";
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_PW, COL_NAME_NAME, 
				TABLE_NAME, COL_NAME_ID, SQLUtil.singleQuotes(id));
		
		return SQLUtil.searchOneTemplate(MemberDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public MemberModel add(MemberModel model) {
		
		String sqlFormatStr = "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, COL_NAME_PW, COL_NAME_NAME);
		
		return SQLUtil.addTemplate(MemberDAO::getConnection, sql, model, getAddBiConsumerSQLException());
	}
	
	public int update(MemberModel model) {
		
		String sqlFormatStr = "UPDATE %s SET %s = ?, %s = ? WHERE %s = ?";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_PW, COL_NAME_NAME, COL_NAME_ID);
		
		return SQLUtil.updateTemplate(MemberDAO::getConnection, sql, getUpdateConsumerSQLException(model));
	}
	
	public int delete(String id) {
		
		String sqlFormatStr = "DELETE FROM %s WHERE %s = %s";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, SQLUtil.singleQuotes(id));
		
		return SQLUtil.deleteTemplate(MemberDAO::getConnection, sql);
	}
	
	
	private FunctionSQLException<ResultSet, MemberModel> getSearchFunctionSQLException(){
		
		return rs -> {
			
			MemberModel model = new MemberModel();
			
			model.setId(rs.getString(COL_NAME_ID));
			model.setPw(rs.getString(COL_NAME_PW));
			model.setName(rs.getString(COL_NAME_NAME));
			
			return model;
		};
	}
	
	private BiConsumerSQLException<MemberModel, PreparedStatement> getAddBiConsumerSQLException(){
		
		return (model, pst) -> {
			
			int index = 1;
			pst.setString(index++, model.getId());
			pst.setString(index++, model.getPw());
			pst.setString(index++, model.getName());
		};
	}
	
	private ConsumerSQLException<PreparedStatement> getUpdateConsumerSQLException(MemberModel model){
		
		return pst -> {
			
			int index = 1;
			pst.setString(index++, model.getPw());
			pst.setString(index++, model.getName());
			pst.setString(index++, model.getId());
		};
	}
	
	
	private static Connection getConnection() {
		
		return OracleDBUtil.getConnection();
	}
}
