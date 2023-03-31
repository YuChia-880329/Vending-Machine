package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import bean.model.GoodModel;
import util.OracleDBUtil;
import util.SQLUtil;
import util.StringConcatUtil;
import util.SQLUtil.BiConsumerSQLException;
import util.SQLUtil.ConsumerSQLException;
import util.SQLUtil.FunctionSQLException;

public class GoodDAO {

	private static final String TABLE_NAME = "BEVERAGE_GOODS";
	
	private static final String COL_NAME_ID = "GOODS_ID";
	private static final String COL_NAME_NAME = "GOODS_NAME";
	private static final String COL_NAME_DESCRIPTION = "DESCRIPTION";
	private static final String COL_NAME_PRICE = "PRICE";
	private static final String COL_NAME_QUANTITY = "QUANTITY";
	private static final String COL_NAME_IMAGE = "IMAGE_NAME";
	private static final String COL_NAME_STATUS = "STATUS";
	
	private static final String ID_GENERATE_SEQ_NAME = "BEVERAGE_GOODS_SEQ";
	
	
	private static final GoodDAO INSTANCE = new GoodDAO();
	
	private GoodDAO() {
	}
	
	public static GoodDAO getInstance() {
		
		return INSTANCE;
	}
	
	public List<GoodModel> searchAll(){
		
		String sqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s, %s FROM %s";
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_NAME, 
				COL_NAME_DESCRIPTION, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				COL_NAME_IMAGE, COL_NAME_STATUS, TABLE_NAME);

		return SQLUtil.searchListTemplate(GoodDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public GoodModel searchById(int id) {
		
		String sqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s, %s FROM %s WHERE %s = %d";
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_NAME, 
				COL_NAME_DESCRIPTION, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				COL_NAME_IMAGE, COL_NAME_STATUS, TABLE_NAME, COL_NAME_ID, id);
		
		return SQLUtil.searchOneTemplate(GoodDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public List<GoodModel> searchByQueryObj(QueryObj... objs) {
		
		if(objs.length == 0)
			return searchAll();
		
		
		String sqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s, %s FROM %s";
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_NAME, 
				COL_NAME_DESCRIPTION, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				COL_NAME_IMAGE, COL_NAME_STATUS, TABLE_NAME);
		
		
		for(int i=0; i<objs.length; i++) {
			
			if(i == 0)
				sql = StringConcatUtil.concate(sql, " WHERE ", objs[i].getQueryStatement());
			else
				sql = StringConcatUtil.concate(sql, " AND ", objs[i].getQueryStatement());
		}
		
		
		return SQLUtil.searchListTemplate(GoodDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public List<GoodModel> searchByQueryObjPage(int page, int numPerPage, QueryObj... objs){
		
		String subTableSqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s, %s, ROW_NUMBER()OVER(ORDER BY %s) AS RN FROM %s";
		String subTableSql = String.format(subTableSqlFormatStr, COL_NAME_ID, COL_NAME_NAME, 
				COL_NAME_DESCRIPTION, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				COL_NAME_IMAGE, COL_NAME_STATUS, COL_NAME_ID, TABLE_NAME);
		
		
		for(int i=0; i<objs.length; i++) {
			
			if(i == 0)
				subTableSql = StringConcatUtil.concate(subTableSql, " WHERE ", objs[i].getQueryStatement());
			else
				subTableSql = StringConcatUtil.concate(subTableSql, " AND ", objs[i].getQueryStatement());
		}
		
		String sqlFormatStr = StringConcatUtil.concate("SELECT %s, %s, %s, %s, %s, %s, %s FROM (%s) WHERE RN ", SQLUtil.pageStatement(page, numPerPage));
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_NAME, 
				COL_NAME_DESCRIPTION, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				COL_NAME_IMAGE, COL_NAME_STATUS, subTableSql);
		
		return SQLUtil.searchListTemplate(GoodDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public GoodModel add(GoodModel model) {
		
		String sqlFormatStr = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) VALUES (%s, ?, ?, ?, ?, ?, ?)";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, COL_NAME_NAME, 
				COL_NAME_DESCRIPTION, COL_NAME_PRICE, COL_NAME_QUANTITY, COL_NAME_IMAGE, 
				COL_NAME_STATUS, ID_GENERATE_SEQ_NAME + ".NEXTVAL");
		
		return SQLUtil.addTemplateGeneratedKey(GoodDAO::getConnection, sql, model, 
				getAddBiConsumerSQLException(), new String[] {COL_NAME_ID}, getAddGeneratedKeyBiConsumerSQLException());
	}
	
	public int update(GoodModel model) {
		
		String sqlFormatStr = "UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_NAME, 
				COL_NAME_DESCRIPTION, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				COL_NAME_IMAGE, COL_NAME_STATUS, COL_NAME_ID);
		
		return SQLUtil.updateTemplate(GoodDAO::getConnection, sql, getUpdateConsumerSQLException(model));
	}
	
	public int delete(int id) {
		
		String sqlFormatStr = "DELETE FROM %s WHERE %s = %d";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, id);
		
		return SQLUtil.deleteTemplate(GoodDAO::getConnection, sql);
	}
	
	
	
	
	private FunctionSQLException<ResultSet, GoodModel> getSearchFunctionSQLException(){
		
		return rs -> {
			
			GoodModel model = new GoodModel();
			
			model.setId(rs.getInt(COL_NAME_ID));
			model.setName(rs.getString(COL_NAME_NAME));
			model.setDescription(rs.getString(COL_NAME_DESCRIPTION));
			model.setPrice(rs.getInt(COL_NAME_PRICE));
			model.setQuantity(rs.getInt(COL_NAME_QUANTITY));
			model.setImage(rs.getString(COL_NAME_IMAGE));
			model.setStatus(rs.getString(COL_NAME_STATUS));
			
			return model;
		};
	}
	
	private BiConsumerSQLException<GoodModel, PreparedStatement> getAddBiConsumerSQLException(){
		
		return (model, pst) -> {
			
			int index = 1;
			pst.setString(index++, model.getName());
			pst.setString(index++, model.getDescription());
			pst.setInt(index++, model.getPrice());
			pst.setInt(index++, model.getQuantity());
			pst.setString(index++, model.getImage());
			pst.setString(index++, model.getStatus());
		};
	}
	private BiConsumerSQLException<GoodModel, ResultSet> getAddGeneratedKeyBiConsumerSQLException(){
		
		return (model, rs) -> {
			
			int id = rs.getInt(1);
			model.setId(id);
		};
	}
	
	private ConsumerSQLException<PreparedStatement> getUpdateConsumerSQLException(GoodModel model){
		
		return pst -> {
			
			int index = 1;
			pst.setString(index++, model.getName());
			pst.setString(index++, model.getDescription());
			pst.setInt(index++, model.getPrice());
			pst.setInt(index++, model.getQuantity());
			pst.setString(index++, model.getImage());
			pst.setString(index++, model.getStatus());
			
			pst.setInt(index++, model.getId());
		};
	}
	
	
	
	public static QueryObj getIdGreaterThanOrEqualToQueryObj(int id) {
		
		return new QueryObj(SQLUtil.getIntGreaterThanOrEqualToStatement(COL_NAME_ID, id));
	}
	public static QueryObj getIdLessThanOrEqualToQueryObj(int id) {
		
		return new QueryObj(SQLUtil.getIntLessThanOrEqualToStatement(COL_NAME_ID, id));
	}
	public static QueryObj getIdBetweenQueryObj(int id1, int id2) {
		
		return new QueryObj(SQLUtil.getIntBetweenStatement(COL_NAME_ID, id1, id2));
	}
	
	public static QueryObj getNameLikeQueryObj(String name) {
		
		return new QueryObj(SQLUtil.getStringLikeStatement(COL_NAME_NAME, name));
	}
	
	public static QueryObj getPriceGreaterThanOrEqualToQueryObj(int price) {
		
		return new QueryObj(SQLUtil.getIntGreaterThanOrEqualToStatement(COL_NAME_PRICE, price));
	}
	public static QueryObj getPriceLessThanOrEqualToQueryObj(int price) {
		
		return new QueryObj(SQLUtil.getIntLessThanOrEqualToStatement(COL_NAME_PRICE, price));
	}
	public static QueryObj getPriceBetweenQueryObj(int price1, int price2) {
		
		return new QueryObj(SQLUtil.getIntBetweenStatement(COL_NAME_PRICE, price1, price2));
	}
	
	public static QueryObj getQuantityGreaterThanOrEqualToQueryObj(int quantity) {
		
		return new QueryObj(SQLUtil.getIntGreaterThanOrEqualToStatement(COL_NAME_QUANTITY, quantity));
	}
	public static QueryObj getQuantityLessThanOrEqualToQueryObj(int quantity) {
		
		return new QueryObj(SQLUtil.getIntLessThanOrEqualToStatement(COL_NAME_QUANTITY, quantity));
	}
	public static QueryObj getQuantityBetweenQueryObj(int quantity1, int quantity2) {
		
		return new QueryObj(SQLUtil.getIntBetweenStatement(COL_NAME_QUANTITY, quantity1, quantity2));
	}
	
	public static QueryObj getStatusQueryObj(String status) {
		
		return new QueryObj(SQLUtil.getStringEqualToStatement(COL_NAME_STATUS, status));
	}
	public static QueryObj getStatus1QueryObj() {
		
		return getStatusQueryObj("1");
	}
	public static QueryObj getStatus0QueryObj() {
		
		return getStatusQueryObj("0");
	}
	
	private static Connection getConnection() {
		
		return OracleDBUtil.getConnection();
	}
}
