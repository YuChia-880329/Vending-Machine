package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class SQLUtil {
	
	public static final String ORACLE_SQL_FORMAT_STRING = "YYYY-MM-DD HH24:MI:SS";
	

	public static <M> List<M> searchListTemplate(Supplier<Connection> conSupplier, String sql, FunctionSQLException<ResultSet, M> modelFctn){
		
		List<M> list = new ArrayList<>();
		try(Connection con = conSupplier.get();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);){
			
			while(rs.next()) {
				
				list.add(modelFctn.apply(rs));
			}
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		return list;
	}
	
	public static <M> M searchOneTemplate(Supplier<Connection> conSupplier, String sql, FunctionSQLException<ResultSet, M> modelFctn){
		
		M model = null;
		try(Connection con = conSupplier.get();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);){
			
			if(rs.next()) {
				
				model = modelFctn.apply(rs);
			}
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		return model;
	}
	
	public static <M> M addTemplate(Supplier<Connection> conSupplier, String sql, M model, BiConsumerSQLException<M, PreparedStatement> psBiConsumer) {
		
		int result = 0;
		try(Connection con = conSupplier.get();){
		
			con.setAutoCommit(false);
			try(PreparedStatement pst = con.prepareStatement(sql);){
				
				psBiConsumer.accept(model, pst);
				
				result = pst.executeUpdate();
				
				con.commit();
			}catch (SQLException ex) {
				
				con.rollback();
				ex.printStackTrace();
				return null;
			}
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		if(result > 0)
			return model;
		else
			return null;
	}
	public static <M> M addTemplateGeneratedKey(Supplier<Connection> conSupplier, String sql, 
			M model, BiConsumerSQLException<M, PreparedStatement> psBiConsumer, String[] generatedKeys, 
			BiConsumerSQLException<M, ResultSet> generatedKeyBiConsumer) {
		
		int result = 0;
		try(Connection con = conSupplier.get();){
		
			con.setAutoCommit(false);
			try(PreparedStatement pst = con.prepareStatement(sql, generatedKeys);){
				
				psBiConsumer.accept(model, pst);
				
				result = pst.executeUpdate();
				
				ResultSet rs = pst.getGeneratedKeys();
				
				if(rs.next()) {
					
					generatedKeyBiConsumer.accept(model, rs);
				}
				
				con.commit();
			}catch (SQLException ex) {
				
				con.rollback();
				ex.printStackTrace();
				return null;
			}
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		if(result > 0)
			return model;
		else
			return null;
	}
	
	public static <M> int updateTemplate(Supplier<Connection> conSupplier, String sql, ConsumerSQLException<PreparedStatement> psConsumer) {
		
		int updateRowNum = 0;
		try(Connection con = conSupplier.get();){
			
			con.setAutoCommit(false);
			try(PreparedStatement pst = con.prepareStatement(sql);){
				
				psConsumer.accept(pst);
				
				updateRowNum = pst.executeUpdate();
				
				con.commit();
			}catch (SQLException ex) {
				
				con.rollback();
				ex.printStackTrace();
				return 0;
			}
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		return updateRowNum;
	}
	
	
	public static <M> int deleteTemplate(Supplier<Connection> conSupplier, String sql) {
		
		int updateRowNum = 0;
		try(Connection con = conSupplier.get();){

			con.setAutoCommit(false);
			try(Statement st = con.createStatement();){
				
				updateRowNum = st.executeUpdate(sql);
				
				con.commit();
			}catch (SQLException ex) {
				
				con.rollback();
				ex.printStackTrace();
				return 0;
			}
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		return updateRowNum;
	}
	
	
	
	public static String getIntEqualToStatement(String colName, int colVal) {
		
		return StringConcatUtil.concate(colName, " = ", String.valueOf(colVal));
	}
	public static String getIntGreaterThanOrEqualToStatement(String colName, int colVal) {
		
		return StringConcatUtil.concate(colName, " >= ", String.valueOf(colVal));
	}
	public static String getIntLessThanOrEqualToStatement(String colName, int colVal) {
		
		return StringConcatUtil.concate(colName, " <= ", String.valueOf(colVal));
	}
	public static String getIntBetweenStatement(String colName, int lowerBound, int upperBound) {
		
		return StringConcatUtil.concate(colName, " BETWEEN ", String.valueOf(lowerBound), 
				" AND ", String.valueOf(upperBound));
	}
	
	
	public static String getStringEqualToStatement(String colName, String colVal) {
		
		return StringConcatUtil.concate(colName, " = ", singleQuotes(colVal));
	}
	public static String getStringLikeStatement(String colName, String colVal) {
		
		return StringConcatUtil.concate(colName, " LIKE ", singleQuotes(StringConcatUtil.concate("%", colVal, "%")));
	}
	
	
	public static String getTimeStampEqualToStatement(String colName, Timestamp timestamp) {
		
		return StringConcatUtil.concate(colName, " = ", toDateFunction(timestamp));
	}
	public static String getTimeStampAfterStatement(String colName, Timestamp timestamp) {
		
		return StringConcatUtil.concate(colName, " >= ", toDateFunction(timestamp));
	}
	public static String getTimeStampBeforeStatement(String colName, Timestamp timestamp) {
		
		return StringConcatUtil.concate(colName, " <= ", toDateFunction(timestamp));
	}
	public static String getTimeStampBetweenStatement(String colName, Timestamp earlierDateTime, Timestamp laterDateTime) {
		
		return StringConcatUtil.concate(colName, " BETWEEN ", toDateFunction(earlierDateTime), 
				" AND ", toDateFunction(laterDateTime));
	}
	
	
	public static String singleQuotes(String str) {
		
		return StringConcatUtil.concate("\'", str, "\'");
	}
	
	public static String toDateFunction(Timestamp timestamp) {
		
		return StringConcatUtil.concate(
				"TO_DATE(", 
				singleQuotes(DateTimeUtil.timestampToString(timestamp)), 
				", ", 
				singleQuotes(ORACLE_SQL_FORMAT_STRING), 
				")");
	}
	
	
	public static String pageStatement(int page, int rowsPerPage) {
		
		int firstNumber = rowsPerPage * (page - 1) + 1;
		int lastNumber = rowsPerPage * (page - 1) + rowsPerPage;
		
		return StringConcatUtil.concate("BETWEEN ", String.valueOf(firstNumber), 
				" AND ", String.valueOf(lastNumber));
	}
	
	
	@FunctionalInterface
	public static interface FunctionSQLException<I, R>{
		
		public R apply(I input) throws SQLException; 
	}
	@FunctionalInterface
	public static interface ConsumerSQLException<I>{
		
		public void accept(I input) throws SQLException; 
	}
	@FunctionalInterface
	public static interface BiConsumerSQLException<I, J>{
		
		public void accept(I input, J input2) throws SQLException; 
	}
}
