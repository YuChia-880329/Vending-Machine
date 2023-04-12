package dao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import bean.model.OrderModel;
import template.model.QueryObj;
import util.OracleDBUtil;
import util.SQLUtil;
import util.StringConcatUtil;
import util.SQLUtil.BiConsumerSQLException;
import util.SQLUtil.ConsumerSQLException;
import util.SQLUtil.FunctionSQLException;

public class OrderDAO {

	private static final String TABLE_NAME = "BEVERAGE_ORDER";
	
	private static final String COL_NAME_ID = "ORDER_ID";
	private static final String COL_NAME_DATE_TIME = "ORDER_DATE";
	private static final String COL_NAME_CUSTOMER_ID = "CUSTOMER_ID";
	private static final String COL_NAME_GOODS_ID = "GOODS_ID";
	private static final String COL_NAME_PRICE = "GOODS_BUY_PRICE";
	private static final String COL_NAME_QUANTITY = "BUY_QUANTITY";
	
	private static final String ID_GENERATE_SEQ_NAME = "BEVERAGE_ORDER_SEQ";
	
	
	private static final OrderDAO INSTANCE = new OrderDAO();
	
	private OrderDAO() {
	}
	
	public static OrderDAO getInstance() {
		
		return INSTANCE;
	}
	
	
	public List<OrderModel> searchAll(){
		
		String sqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s FROM %s";
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, 
				COL_NAME_QUANTITY, TABLE_NAME);

		return SQLUtil.searchListTemplate(OrderDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public OrderModel searchById(int id) {
		
		String sqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s FROM %s WHERE %s = %d";
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, 
				COL_NAME_QUANTITY, TABLE_NAME, COL_NAME_ID, id);
		
		return SQLUtil.searchOneTemplate(OrderDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public List<OrderModel> searchByQueryObj(QueryObj... objs) {
		
		if(objs.length == 0)
			return searchAll();
		
		
		String sqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s FROM %s";
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, 
				COL_NAME_QUANTITY, TABLE_NAME);
		
		
		for(int i=0; i<objs.length; i++) {
			
			if(i == 0)
				sql = StringConcatUtil.concate(sql, " WHERE ", objs[i].getQueryStatement());
			else
				sql = StringConcatUtil.concate(sql, " AND ", objs[i].getQueryStatement());
		}
		
		
		return SQLUtil.searchListTemplate(OrderDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public List<OrderModel> searchByQueryObjPage(int page, int numPerPage, QueryObj... objs){
		
		String subTableSqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s, ROW_NUMBER()OVER(ORDER BY %s) RN FROM %s";
		String subTableSql = String.format(subTableSqlFormatStr, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				COL_NAME_ID, TABLE_NAME);
		
		
		for(int i=0; i<objs.length; i++) {
			
			if(i == 0)
				subTableSql = StringConcatUtil.concate(subTableSql, " WHERE ", objs[i].getQueryStatement());
			else
				subTableSql = StringConcatUtil.concate(subTableSql, " AND ", objs[i].getQueryStatement());
		}
		
		String sqlFormatStr = StringConcatUtil.concate("SELECT %s, %s, %s, %s, %s, %s FROM (%s) WHERE RN ", SQLUtil.pageStatement(page, numPerPage));
		String sql = String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, 
				COL_NAME_QUANTITY, subTableSql);
		
		return SQLUtil.searchListTemplate(OrderDAO::getConnection, sql, getSearchFunctionSQLException());
	}
	
	public int searchRowNumber(QueryObj... objs) {
		
		String subTableSqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s, ROW_NUMBER()OVER(ORDER BY %s) RN FROM %s";
		String subTableSql = String.format(subTableSqlFormatStr, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				COL_NAME_ID, TABLE_NAME);
		
		
		for(int i=0; i<objs.length; i++) {
			
			if(i == 0)
				subTableSql = StringConcatUtil.concate(subTableSql, " WHERE ", objs[i].getQueryStatement());
			else
				subTableSql = StringConcatUtil.concate(subTableSql, " AND ", objs[i].getQueryStatement());
		}
		
		String sqlFormatStr = StringConcatUtil.concate("SELECT COUNT(RN) CRN FROM (%s)");
		String sql = String.format(sqlFormatStr, subTableSql);
		
		return SQLUtil.searchOneTemplate(OrderDAO::getConnection, sql, getSearchRowNumberFunctionSQLException());
	}

	
	public OrderModel add(OrderModel model) {
		
		String sqlFormatStr = "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (%s, ?, ?, ?, ?, ?)";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				ID_GENERATE_SEQ_NAME + ".NEXTVAL");
		
		return SQLUtil.addTemplateGeneratedKey(OrderDAO::getConnection, sql, model, 
				getAddBiConsumerSQLException(), new String[] {COL_NAME_ID}, 
				getAddGeneratedKeyBiConsumerSQLException());
	}
	
	public int update(OrderModel model) {
		
		String sqlFormatStr = "UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, 
				COL_NAME_QUANTITY, COL_NAME_ID);
		
		return SQLUtil.updateTemplate(OrderDAO::getConnection, sql, getUpdateConsumerSQLException(model));
	}
	
	public int delete(int id) {
		
		String sqlFormatStr = "DELETE FROM %s WHERE %s = %d";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, id);
		
		return SQLUtil.deleteTemplate(OrderDAO::getConnection, sql);
	}
	
	
	
	private FunctionSQLException<ResultSet, OrderModel> getSearchFunctionSQLException(){
		
		return rs -> {
			
			OrderModel model = new OrderModel();
			
			model.setId(rs.getInt(COL_NAME_ID));
			model.setDateTime(rs.getTimestamp(COL_NAME_DATE_TIME));
			model.setCustomerId(rs.getString(COL_NAME_CUSTOMER_ID));
			model.setGoodsId(rs.getInt(COL_NAME_GOODS_ID));
			model.setGoodsPrice(rs.getInt(COL_NAME_PRICE));
			model.setBuyQuantity(rs.getInt(COL_NAME_QUANTITY));
			
			return model;
		};
	}
	private FunctionSQLException<ResultSet, Integer> getSearchRowNumberFunctionSQLException(){
		
		return rs -> rs.getInt("CRN");
	}
	
	private BiConsumerSQLException<OrderModel, PreparedStatement> getAddBiConsumerSQLException(){
		
		return (model, pst) -> {
			
			int index = 1;
			pst.setTimestamp(index++, model.getDateTime());
			pst.setString(index++, model.getCustomerId());
			pst.setInt(index++, model.getGoodsId());
			pst.setInt(index++, model.getGoodsPrice());
			pst.setInt(index++, model.getBuyQuantity());
		};
	}
	private BiConsumerSQLException<OrderModel, ResultSet> getAddGeneratedKeyBiConsumerSQLException(){
		
		return (model, rs) -> {
			
			int id = rs.getInt(1);
			model.setId(id);
		};
	}
	
	private ConsumerSQLException<PreparedStatement> getUpdateConsumerSQLException(OrderModel model){
		
		return pst -> {
			
			int index = 1;
			pst.setTimestamp(index++, model.getDateTime());
			pst.setString(index++, model.getCustomerId());
			pst.setInt(index++, model.getGoodsId());
			pst.setInt(index++, model.getGoodsPrice());
			pst.setInt(index++, model.getBuyQuantity());
			
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

	public static QueryObj getDateTimeBeforeQueryObj(Timestamp dateTime) {
		
		return new QueryObj(SQLUtil.getTimeStampBeforeStatement(COL_NAME_DATE_TIME, dateTime));
	}
	public static QueryObj getDateTimeAfterQueryObj(Timestamp dateTime) {
		
		return new QueryObj(SQLUtil.getTimeStampAfterStatement(COL_NAME_DATE_TIME, dateTime));
	}
	public static QueryObj getDateTimeBetweenQueryObj(Timestamp dateTime1, Timestamp dateTime2) {
		
		return new QueryObj(SQLUtil.getTimeStampBetweenStatement(COL_NAME_DATE_TIME, dateTime1, dateTime2));
	}
	
	public static QueryObj getCustomerIdEqualToQueryObj(String customerId) {
		
		return new QueryObj(SQLUtil.getStringEqualToStatement(COL_NAME_CUSTOMER_ID, customerId));
	}
	
	public static QueryObj getGoodIdGreaterThanOrEqualToQueryObj(int goodId) {
		
		return new QueryObj(SQLUtil.getIntGreaterThanOrEqualToStatement(COL_NAME_GOODS_ID, goodId));
	}
	public static QueryObj getGoodIdLessThanOrEqualToQueryObj(int goodId) {
		
		return new QueryObj(SQLUtil.getIntLessThanOrEqualToStatement(COL_NAME_GOODS_ID, goodId));
	}
	public static QueryObj getGoodIdBetweenQueryObj(int goodId1, int goodId2) {
		
		return new QueryObj(SQLUtil.getIntBetweenStatement(COL_NAME_GOODS_ID, goodId1, goodId2));
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
	
	private static Connection getConnection() {
		
		return OracleDBUtil.getConnection();
	}
}
