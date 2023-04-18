package service.model;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import bean.dto.model.OrderJoinModelDTO;
import dao.model.OrderJoinModelDAO;
import template.model.QueryObj;
import transformer.model.OrderJoinModelTransformer;

public class OrderJoinModelService {

	private OrderJoinModelDAO modelDAO;
	private OrderJoinModelTransformer modelTransformer;
	
	
	private static final OrderJoinModelService INSTANCE = new OrderJoinModelService();
	
	private OrderJoinModelService() {
		
		modelDAO = OrderJoinModelDAO.getInstance();
		modelTransformer = OrderJoinModelTransformer.getInstance();
	}
	
	public static OrderJoinModelService getInstance() {
		
		return INSTANCE;
	}
	
	
	public List<OrderJoinModelDTO> searchAll() throws SQLException{
		
		return modelTransformer.modelListToDtoList(modelDAO.searchAll());
	}
	public OrderJoinModelDTO searchById(int id) throws SQLException {
		
		return modelTransformer.modelToDto(modelDAO.searchById(id));
	}
	public List<OrderJoinModelDTO> searchByQueryObj(QueryObj... objs) throws SQLException{
		
		return modelTransformer.modelListToDtoList(modelDAO.searchByQueryObj(objs));
	}
	public List<OrderJoinModelDTO> searchByQueryObjPage(int page, int numPerPage, QueryObj... objs) throws SQLException{
		
		return modelTransformer.modelListToDtoList(modelDAO.searchByQueryObjPage(page, numPerPage, objs));
	}
	public int searchRowNumber(QueryObj... objs) throws SQLException {
		
		return modelDAO.searchRowNumber(objs);
	}
	
	
	
	public static QueryObj getCustomerNameLikeQueryObj(String customerName) {
		
		return OrderJoinModelDAO.getCustomerNameLikeQueryObj(customerName);
	}
	
	public static QueryObj getDateTimeBeforeQueryObj(Timestamp dateTime) {
		
		return OrderJoinModelDAO.getDateTimeBeforeQueryObj(dateTime);
	}
	public static QueryObj getDateTimeAfterQueryObj(Timestamp dateTime) {
		
		return OrderJoinModelDAO.getDateTimeAfterQueryObj(dateTime);
	}
	public static QueryObj getDateTimeBetweenQueryObj(Timestamp dateTime1, Timestamp dateTime2) {
		
		return OrderJoinModelDAO.getDateTimeBetweenQueryObj(dateTime1, dateTime2);
	}
	
	public static QueryObj getGoodsNameLikeQueryObj(String goodsName) {
		
		return OrderJoinModelDAO.getGoodsNameLikeQueryObj(goodsName);
	}
	
	public static QueryObj getGoodsPriceGreaterThanOrEqualToQueryObj(int goodsPrice) {
		
		return OrderJoinModelDAO.getGoodsPriceGreaterThanOrEqualToQueryObj(goodsPrice);
	}
	public static QueryObj getGoodsPriceLessThanOrEqualToQueryObj(int goodsPrice) {
		
		return OrderJoinModelDAO.getGoodsPriceLessThanOrEqualToQueryObj(goodsPrice);
	}
	public static QueryObj getGoodsPriceBetweenQueryObj(int goodsPrice1, int goodsPrice2) {
		
		return OrderJoinModelDAO.getGoodsPriceBetweenQueryObj(goodsPrice1, goodsPrice2);
	}
	
	public static QueryObj getBuyQuantityGreaterThanOrEqualToQueryObj(int buyQuantity) {
		
		return OrderJoinModelDAO.getBuyQuantityGreaterThanOrEqualToQueryObj(buyQuantity);
	}
	public static QueryObj getBuyQuantityLessThanOrEqualToQueryObj(int buyQuantity) {
		
		return OrderJoinModelDAO.getBuyQuantityLessThanOrEqualToQueryObj(buyQuantity);
	}
	public static QueryObj getBuyQuantityBetweenQueryObj(int buyQuantity1, int buyQuantity2) {
		
		return OrderJoinModelDAO.getBuyQuantityBetweenQueryObj(buyQuantity1, buyQuantity2);
	}
	
	public static QueryObj getTotalPriceGreaterThanOrEqualToQueryObj(int totalPrice) {
		
		return OrderJoinModelDAO.getTotalPriceGreaterThanOrEqualToQueryObj(totalPrice);
	}
	public static QueryObj getTotalPriceLessThanOrEqualToQueryObj(int totalPrice) {
		
		return OrderJoinModelDAO.getTotalPriceLessThanOrEqualToQueryObj(totalPrice);
	}
	public static QueryObj getTotalPriceBetweenQueryObj(int totalPrice1, int totalPrice2) {
		
		return OrderJoinModelDAO.getTotalPriceBetweenQueryObj(totalPrice1, totalPrice2);
	}
}
