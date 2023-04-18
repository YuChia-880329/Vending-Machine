package dao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Supplier;

import bean.model.OrderModel;
import template.model.ModelDAOTemplate;
import util.OracleDBUtil;
import util.SQLUtil;
import util.SQLUtil.BiConsumerSQLException;
import util.SQLUtil.ConsumerSQLException;
import util.SQLUtil.FunctionSQLException;

public class OrderModelDAO extends ModelDAOTemplate<OrderModel, Integer> {

	private static final String TABLE_NAME = "BEVERAGE_ORDER";
	
	private static final String COL_NAME_ID = "ORDER_ID";
	private static final String COL_NAME_DATE_TIME = "ORDER_DATE";
	private static final String COL_NAME_CUSTOMER_ID = "CUSTOMER_ID";
	private static final String COL_NAME_GOODS_ID = "GOODS_ID";
	private static final String COL_NAME_PRICE = "GOODS_BUY_PRICE";
	private static final String COL_NAME_QUANTITY = "BUY_QUANTITY";
	
	private static final String ID_GENERATE_SEQ_NAME = "BEVERAGE_ORDER_SEQ";
	
	
	private static final OrderModelDAO INSTANCE = new OrderModelDAO();
	
	private OrderModelDAO() {
	}
	
	public static OrderModelDAO getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected Supplier<Connection> getConnectionSupplier() {
		
		return () -> OracleDBUtil.getConnection();
	}
	
	
	@Override
	protected String getSearchAllSql() {
		
		String sqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s FROM %s ORDER BY %s ASC";
		return String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, 
				COL_NAME_QUANTITY, TABLE_NAME, COL_NAME_ID);
	}
	@Override
	protected String getSearchByIdSql(Integer id) {
		
		String sqlFormatStr = "SELECT %s, %s, %s, %s, %s, %s FROM %s WHERE %s = %d";
		return String.format(sqlFormatStr, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, 
				COL_NAME_QUANTITY, TABLE_NAME, COL_NAME_ID, id);
	}
	@Override
	protected String getAddSql() {
		
		String sqlFormatStr = "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (%s, ?, ?, ?, ?, ?)";
		return String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, COL_NAME_QUANTITY, 
				ID_GENERATE_SEQ_NAME + ".NEXTVAL");
	}
	@Override
	protected String getUpdateSql() {

		String sqlFormatStr = "UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?";
		return String.format(sqlFormatStr, TABLE_NAME, COL_NAME_DATE_TIME, 
				COL_NAME_CUSTOMER_ID, COL_NAME_GOODS_ID, COL_NAME_PRICE, 
				COL_NAME_QUANTITY, COL_NAME_ID);
	}
	@Override
	protected String getDeleteSql(Integer id) {
		
		String sqlFormatStr = "DELETE FROM %s WHERE %s = %d";
		return String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, id);
	}

	
	@Override
	protected FunctionSQLException<ResultSet, OrderModel> getSearchFunctionSQLException() {
		
		return rs -> {
			
			OrderModel model = new OrderModel();
			
			model.setId(rs.getInt(COL_NAME_ID));
			model.setTimestamp(rs.getTimestamp(COL_NAME_DATE_TIME));
			model.setCustomerId(rs.getString(COL_NAME_CUSTOMER_ID));
			model.setGoodsId(rs.getInt(COL_NAME_GOODS_ID));
			model.setGoodsPrice(rs.getInt(COL_NAME_PRICE));
			model.setBuyQuantity(rs.getInt(COL_NAME_QUANTITY));
			
			return model;
		};
	}
	@Override
	protected BiConsumerSQLException<OrderModel, PreparedStatement> getAddBiConsumerSQLException() {
		
		return (model, pst) -> {
		
			int index = 1;
			pst.setTimestamp(index++, model.getTimestamp());
			pst.setString(index++, model.getCustomerId());
			pst.setInt(index++, model.getGoodsId());
			pst.setInt(index++, model.getGoodsPrice());
			pst.setInt(index++, model.getBuyQuantity());
		};
	}
	@Override
	protected ConsumerSQLException<PreparedStatement> getUpdateConsumerSQLException(OrderModel model) {
		
		return pst -> {
		
			int index = 1;
			pst.setTimestamp(index++, model.getTimestamp());
			pst.setString(index++, model.getCustomerId());
			pst.setInt(index++, model.getGoodsId());
			pst.setInt(index++, model.getGoodsPrice());
			pst.setInt(index++, model.getBuyQuantity());
			
			pst.setInt(index++, model.getId());
		};
	}

	
	@Override
	protected OrderModel add(OrderModel model) throws SQLException {
		
		return SQLUtil.addTemplateGeneratedKey(
				getConnectionSupplier(), 
				getAddSql(), 
				model, 
				getAddBiConsumerSQLException(), 
				new String[] {COL_NAME_ID}, 
				getAddGeneratedKeyBiConsumerSQLException());
	}
	
	
	
	private BiConsumerSQLException<OrderModel, ResultSet> getAddGeneratedKeyBiConsumerSQLException(){
	
		return (model, rs) -> {
			
			int id = rs.getInt(1);
			model.setId(id);
		};
	}
}
