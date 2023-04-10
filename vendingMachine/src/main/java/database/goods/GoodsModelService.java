package database.goods;

import java.util.List;

import bean.dto.model.GoodsModelDTO;
import template.database.ModelServiceTemplate;
import template.database.QueryObj;

public class GoodsModelService extends ModelServiceTemplate<GoodsModel, Integer, GoodsModelDTO, GoodsModelDAO, GoodsModelTransformer> {

	private static final GoodsModelService INSTANCE = new GoodsModelService();
	
	private GoodsModelService() {
	}
	
	public static GoodsModelService getInstance() {
		
		return INSTANCE;
	}
	
	public List<GoodsModelDTO> searchByQueryObj(QueryObj... objs){
		
		return modelTransformer.modelListToDtoList(modelDAO.searchByQueryObj(objs));
	}
	public List<GoodsModelDTO> searchByQueryObjPage(int page, int numPerPage, QueryObj... objs){
		
		return modelTransformer.modelListToDtoList(modelDAO.searchByQueryObjPage(page, numPerPage, objs));
	}
	public int searchRowNumber(QueryObj... objs) {
		
		return modelDAO.searchRowNumber(objs);
	}
	

	
	@Override
	protected GoodsModelDAO getModelDAO() {

		return GoodsModelDAO.getInstance();
	}

	@Override
	protected GoodsModelTransformer getModelTransformer() {

		return GoodsModelTransformer.getInstance();
	}
	
	
	public static QueryObj getIdGreaterThanOrEqualToQueryObj(int id) {
	
		return GoodsModelDAO.getIdGreaterThanOrEqualToQueryObj(id);
	}
	public static QueryObj getIdLessThanOrEqualToQueryObj(int id) {
		
		return GoodsModelDAO.getIdLessThanOrEqualToQueryObj(id);
	}
	public static QueryObj getIdBetweenQueryObj(int id1, int id2) {
		
		return GoodsModelDAO.getIdBetweenQueryObj(id1, id2);
	}
	
	public static QueryObj getNameLikeQueryObj(String name) {
		
		return GoodsModelDAO.getNameLikeQueryObj(name);
	}
	
	public static QueryObj getPriceGreaterThanOrEqualToQueryObj(int price) {
		
		return GoodsModelDAO.getPriceGreaterThanOrEqualToQueryObj(price);
	}
	public static QueryObj getPriceLessThanOrEqualToQueryObj(int price) {
		
		return GoodsModelDAO.getPriceLessThanOrEqualToQueryObj(price);
	}
	public static QueryObj getPriceBetweenQueryObj(int price1, int price2) {
		
		return GoodsModelDAO.getPriceBetweenQueryObj(price1, price2);
	}
	
	public static QueryObj getQuantityGreaterThanOrEqualToQueryObj(int quantity) {
		
		return GoodsModelDAO.getQuantityGreaterThanOrEqualToQueryObj(quantity);
	}
	public static QueryObj getQuantityLessThanOrEqualToQueryObj(int quantity) {
		
		return GoodsModelDAO.getQuantityLessThanOrEqualToQueryObj(quantity);
	}
	public static QueryObj getQuantityBetweenQueryObj(int quantity1, int quantity2) {
		
		return GoodsModelDAO.getQuantityBetweenQueryObj(quantity1, quantity2);
	}
	
	public static QueryObj getStatusQueryObj(String status) {
		
		return GoodsModelDAO.getStatusQueryObj(status);
	}
	public static QueryObj getStatus1QueryObj() {
		
		return GoodsModelDAO.getStatus1QueryObj();
	}
	public static QueryObj getStatus0QueryObj() {
		
		return GoodsModelDAO.getStatus0QueryObj();
	}
}
