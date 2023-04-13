package dao.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.function.Supplier;

import bean.model.OrderJoinModel;
import template.model.QueryObj;
import util.OracleDBUtil;
import util.SQLUtil;
import util.StringConcatUtil;
import util.SQLUtil.FunctionSQLException;

public class OrderJoinModelDAO {

	private static final String BEVERAGE_GOODS_TABLE_NAME = "BEVERAGE_GOODS";
	private static final String BEVERAGE_MEMBER_TABLE_NAME = "BEVERAGE_MEMBER";
	private static final String BEVERAGE_ORDER_TABLE_NAME = "BEVERAGE_ORDER";
	
	private static final String BEVERAGE_MEMBER_COL_NAME_CUSTOMER_NAME = "CUSTOMER_NAME";
	private static final String BEVERAGE_ORDER_COL_NAME_ORDER_DATE = "ORDER_DATE";
	private static final String BEVERAGE_GOODS_COL_NAME_GOODS_NAME = "GOODS_NAME";
	private static final String BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE = "GOODS_BUY_PRICE";
	private static final String BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY = "BUY_QUANTITY";
	private static final String COL_NAME_TOTAL_PRICE = "TOTAL_PRICE";
	
	private static final String BEVERAGE_ORDER_COL_NAME_GOODS_ID = "GOODS_ID";
	private static final String BEVERAGE_ORDER_COL_NAME_CUSTOMER_ID = "CUSTOMER_ID";
	private static final String BEVERAGE_MEMBER_COL_NAME_IDENTIFICATION_NO = "IDENTIFICATION_NO";
	private static final String BEVERAGE_GOODS_COL_NAME_GOODS_ID = "GOODS_ID";
	
	private static final String BEVERAGE_ORDER_COL_NAME_ORDER_ID = "ORDER_ID";
	
	
	private static final OrderJoinModelDAO INSTANCE = new OrderJoinModelDAO();
	
	private OrderJoinModelDAO() {
	}
	
	public static OrderJoinModelDAO getInstance() {
		
		return INSTANCE;
	}
	
	
	protected Supplier<Connection> getConnectionSupplier() {
		
		return () -> OracleDBUtil.getConnection();
	}
	
	
	
	public List<OrderJoinModel> searchAll(){
		
		return SQLUtil.searchListTemplate(
				getConnectionSupplier(), 
				getSearchAllSql(), 
				getSearchFunctionSQLException());
	}
	public OrderJoinModel searchById(int id){
		
		return SQLUtil.searchOneTemplate(
				getConnectionSupplier(), 
				getSearchByIdSql(id), 
				getSearchFunctionSQLException());
	}
	public List<OrderJoinModel> searchByQueryObj(QueryObj... objs){
		
		if(objs.length == 0)
			return searchAll();
		
		return SQLUtil.searchListTemplate(
				getConnectionSupplier(), 
				getSearchByQueryObjSql(objs), 
				getSearchFunctionSQLException());
	}
	public List<OrderJoinModel> searchByQueryObjPage(int page, int numPerPage, QueryObj... objs){
		
		return SQLUtil.searchListTemplate(
				getConnectionSupplier(), 
				getSearchByQueryObjPageSql(page, numPerPage, objs), 
				getSearchFunctionSQLException());
	}
	public int searchRowNumber(QueryObj... objs) {
		
		return SQLUtil.searchOneTemplate(
				getConnectionSupplier(), 
				getSearchRowNumberSql(objs), 
				getSearchRowNumberFunctionSQLException());
	}
	
	
	
	private String getSearchAllSql() {
		
		return getSelectSql(getSelectSubTableSql());
	}
	private String getSearchByIdSql(int id) {
		
		return getSelectSql(StringConcatUtil.concate(getSelectSubTableSql(), " WHERE ", 
				BEVERAGE_ORDER_COL_NAME_ORDER_ID, " = ", String.valueOf(id)));
	}
	private String getSearchByQueryObjSql(QueryObj... objs) {
		
		String sql = getSelectSql(getSelectSubTableSql());
		
		for(int i=0; i<objs.length; i++) {
			
			if(i == 0)
				sql = StringConcatUtil.concate(sql, " WHERE ", objs[i].getQueryStatement());
			else
				sql = StringConcatUtil.concate(sql, " AND ", objs[i].getQueryStatement());
		}
		
		return sql;
	}
	private String getSearchByQueryObjPageSql(int page, int numPerPage, QueryObj... objs) {
		
		String sql = getRowNumberSelectSql(getSelectSubTableSql());
		
		for(int i=0; i<objs.length; i++) {
			
			if(i == 0)
				sql = StringConcatUtil.concate(sql, " WHERE ", objs[i].getQueryStatement());
			else
				sql = StringConcatUtil.concate(sql, " AND ", objs[i].getQueryStatement());
		}
		
		String sqlFormatStr = StringConcatUtil.concate("SELECT %s %s %s %s %s %s FROM (%s) WHERE RN ", SQLUtil.pageStatement(page, numPerPage));
		return String.format(sqlFormatStr, 
				BEVERAGE_MEMBER_COL_NAME_CUSTOMER_NAME, 
				BEVERAGE_ORDER_COL_NAME_ORDER_DATE, 
				BEVERAGE_GOODS_COL_NAME_GOODS_NAME, 
				BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE, 
				BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY,
				COL_NAME_TOTAL_PRICE,
				sql);
	}
	private String getSearchRowNumberSql(QueryObj... objs) {
		
		String sql = getRowNumberSelectSql(getSelectSubTableSql());
		
		for(int i=0; i<objs.length; i++) {
			
			if(i == 0)
				sql = StringConcatUtil.concate(sql, " WHERE ", objs[i].getQueryStatement());
			else
				sql = StringConcatUtil.concate(sql, " AND ", objs[i].getQueryStatement());
		}
		
		String sqlFormatStr = "SELECT COUNT(RN) CRN FROM (%s)";
		return String.format(sqlFormatStr, sql);
	}
	
	private FunctionSQLException<ResultSet, OrderJoinModel> getSearchFunctionSQLException() {
		
		return rs -> {
			
			OrderJoinModel model = new OrderJoinModel();
			
			model.setCustomerName(rs.getString(BEVERAGE_MEMBER_COL_NAME_CUSTOMER_NAME));
			model.setTimestamp(rs.getTimestamp(BEVERAGE_ORDER_COL_NAME_ORDER_DATE));
			model.setGoodsName(rs.getString(BEVERAGE_GOODS_COL_NAME_GOODS_NAME));
			model.setGoodsPrice(rs.getInt(BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE));
			model.setBuyQuantity(rs.getInt(BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY));
			model.setTotalPrice(rs.getInt(COL_NAME_TOTAL_PRICE));
			
			return model;
		};
	}
	private FunctionSQLException<ResultSet, Integer> getSearchRowNumberFunctionSQLException(){
		
		return rs -> rs.getInt("CRN");
	}
	
	
	
	private String getSelectSubTableSql() {
		
		String subTableSqlFormatStr = "SELECT O.%s M.%s O.%s O.%s O.%s O.%s O.%s*O.%s %s FROM %s O INNER JOIN %s M ON O.%s = M.%s";
		return String.format(subTableSqlFormatStr, 
				BEVERAGE_ORDER_COL_NAME_ORDER_ID,
				BEVERAGE_MEMBER_COL_NAME_CUSTOMER_NAME, 
				BEVERAGE_ORDER_COL_NAME_GOODS_ID, 
				BEVERAGE_ORDER_COL_NAME_ORDER_DATE, 
				BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE, 
				BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY,
				BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE, 
				BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY,
				COL_NAME_TOTAL_PRICE,
				BEVERAGE_ORDER_TABLE_NAME, 
				BEVERAGE_MEMBER_TABLE_NAME, 
				BEVERAGE_ORDER_COL_NAME_CUSTOMER_ID, 
				BEVERAGE_MEMBER_COL_NAME_IDENTIFICATION_NO);
	}
	private String getSelectSql(String subTableSql) {
		
		String sqlFormatStr = "SELECT T.%s T.%s G.%s T.%s T.%s T.%s FROM (%s) T INNER JOIN %s G ON T.%s = G.%s";
		return String.format(sqlFormatStr, 
				BEVERAGE_MEMBER_COL_NAME_CUSTOMER_NAME, 
				BEVERAGE_ORDER_COL_NAME_ORDER_DATE, 
				BEVERAGE_GOODS_COL_NAME_GOODS_NAME, 
				BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE, 
				BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY,
				COL_NAME_TOTAL_PRICE,
				subTableSql, 
				BEVERAGE_GOODS_TABLE_NAME, 
				BEVERAGE_ORDER_COL_NAME_GOODS_ID, 
				BEVERAGE_GOODS_COL_NAME_GOODS_ID);
	}
	private String getRowNumberSelectSql(String subTableSql) {
		
		String sqlFormatStr = "SELECT T.%s T.%s G.%s T.%s T.%s %T.%s ROW_NUMBER()OVER(ORDER BY T.%s) FROM (%s) T INNER JOIN %s G ON T.%s = G.%s";
		return String.format(sqlFormatStr, 
				BEVERAGE_MEMBER_COL_NAME_CUSTOMER_NAME, 
				BEVERAGE_ORDER_COL_NAME_ORDER_DATE, 
				BEVERAGE_GOODS_COL_NAME_GOODS_NAME, 
				BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE, 
				BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY,
				COL_NAME_TOTAL_PRICE,
				BEVERAGE_ORDER_COL_NAME_ORDER_ID,
				subTableSql, 
				BEVERAGE_GOODS_TABLE_NAME, 
				BEVERAGE_ORDER_COL_NAME_GOODS_ID, 
				BEVERAGE_GOODS_COL_NAME_GOODS_ID);
	}
	

	
	
	public static QueryObj getCustomerNameLikeQueryObj(String customerName) {
		
		return new QueryObj(SQLUtil.getStringLikeStatement(BEVERAGE_MEMBER_COL_NAME_CUSTOMER_NAME, customerName));
	}
	
	public static QueryObj getDateTimeBeforeQueryObj(Timestamp dateTime) {
		
		return new QueryObj(SQLUtil.getTimeStampBeforeStatement(BEVERAGE_ORDER_COL_NAME_ORDER_DATE, dateTime));
	}
	public static QueryObj getDateTimeAfterQueryObj(Timestamp dateTime) {
		
		return new QueryObj(SQLUtil.getTimeStampAfterStatement(BEVERAGE_ORDER_COL_NAME_ORDER_DATE, dateTime));
	}
	public static QueryObj getDateTimeBetweenQueryObj(Timestamp dateTime1, Timestamp dateTime2) {
		
		return new QueryObj(SQLUtil.getTimeStampBetweenStatement(BEVERAGE_ORDER_COL_NAME_ORDER_DATE, dateTime1, dateTime2));
	}
	
	public static QueryObj getGoodsNameLikeQueryObj(String goodsName) {
		
		return new QueryObj(SQLUtil.getStringLikeStatement(BEVERAGE_GOODS_COL_NAME_GOODS_NAME, goodsName));
	}
	
	public static QueryObj getGoodsPriceGreaterThanOrEqualToQueryObj(int goodsPrice) {
		
		return new QueryObj(SQLUtil.getIntGreaterThanOrEqualToStatement(BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE, goodsPrice));
	}
	public static QueryObj getGoodsPriceLessThanOrEqualToQueryObj(int goodsPrice) {
		
		return new QueryObj(SQLUtil.getIntLessThanOrEqualToStatement(BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE, goodsPrice));
	}
	public static QueryObj getGoodsPriceBetweenQueryObj(int goodsPrice1, int goodsPrice2) {
		
		return new QueryObj(SQLUtil.getIntBetweenStatement(BEVERAGE_ORDER_COL_NAME_GOODS_BUY_PRICE, goodsPrice1, goodsPrice2));
	}
	
	public static QueryObj getBuyQuantityGreaterThanOrEqualToQueryObj(int buyQuantity) {
		
		return new QueryObj(SQLUtil.getIntGreaterThanOrEqualToStatement(BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY, buyQuantity));
	}
	public static QueryObj getBuyQuantityLessThanOrEqualToQueryObj(int buyQuantity) {
		
		return new QueryObj(SQLUtil.getIntLessThanOrEqualToStatement(BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY, buyQuantity));
	}
	public static QueryObj getBuyQuantityBetweenQueryObj(int buyQuantity1, int buyQuantity2) {
		
		return new QueryObj(SQLUtil.getIntBetweenStatement(BEVERAGE_ORDER_COL_NAME_BUY_QUANTITY, buyQuantity1, buyQuantity2));
	}
	
	public static QueryObj getTotalPriceGreaterThanOrEqualToQueryObj(int totalPrice) {
		
		return new QueryObj(SQLUtil.getIntGreaterThanOrEqualToStatement(COL_NAME_TOTAL_PRICE, totalPrice));
	}
	public static QueryObj getTotalPriceLessThanOrEqualToQueryObj(int totalPrice) {
		
		return new QueryObj(SQLUtil.getIntLessThanOrEqualToStatement(COL_NAME_TOTAL_PRICE, totalPrice));
	}
	public static QueryObj getTotalPriceBetweenQueryObj(int totalPrice1, int totalPrice2) {
		
		return new QueryObj(SQLUtil.getIntBetweenStatement(COL_NAME_TOTAL_PRICE, totalPrice1, totalPrice2));
	}
}
