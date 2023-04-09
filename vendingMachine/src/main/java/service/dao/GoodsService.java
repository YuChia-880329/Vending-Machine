package service.dao;

import java.util.List;

import bean.dto.model.GoodsModelDTO;
import database.goods.GoodsModel;
import database.goods.GoodsModelDAO;
import database.goods.GoodsModelTransformer;
import util.SQLUtil;
import util.StringConcatUtil;

public class GoodsService {

	private GoodsModelDAO goodsDAO;
	private GoodsModelTransformer goodsModelTransformer;
	
	private static final GoodsService INSTANCE = new GoodsService();
	
	private GoodsService() {
		
		goodsDAO = GoodsModelDAO.getInstance();
		goodsModelTransformer = GoodsModelTransformer.getInstance();
	}
	
	public static GoodsService getInstance() {
		
		return INSTANCE;
	}
	
	
	public List<GoodsModelDTO> searchAll(){
		
		return goodsModelTransformer.modelListToDtoList(goodsDAO.searchAll());
	}
	
	public GoodsModelDTO searchById(int id) {
		
		return goodsModelTransformer.modelToDto(goodsDAO.searchById(id));
	}
	
	public List<GoodsModelDTO> searchByQueryObj(QueryObj... objs) {
		
		return goodsModelTransformer.modelListToDtoList(goodsDAO.searchByQueryObj(objs));
	}
	
	public List<GoodsModelDTO> searchByQueryObjPage(int page, int numPerPage, QueryObj... objs){
		
		return goodsModelTransformer.modelListToDtoList(goodsDAO.searchByQueryObjPage(page, numPerPage, objs));
	}
	
	public int searchRowNumber(QueryObj... objs) {
		
		return goodsDAO.searchRowNumber(objs);
	}
	
	public GoodsModelDTO add(GoodsModelDTO dto) {
		
		return goodsModelTransformer.modelToDto(goodsDAO.add(goodsModelTransformer.dtoToModel(dto)));
	}
	
	public int update(GoodsModelDTO dto) {
		
		return goodsDAO.update(goodsModelTransformer.dtoToModel(dto));
	}
	
	public int delete(int id) {
		
		String sqlFormatStr = "DELETE FROM %s WHERE %s = %d";
		String sql = String.format(sqlFormatStr, TABLE_NAME, COL_NAME_ID, id);
		
		return SQLUtil.deleteTemplate(GoodsModelDAO::getConnection, sql);
	}
}
