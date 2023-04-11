package service.backend.goodsList.memory.repository.goodsTablePages;

import bean.obj.backend.goodsList.repository.goodsTablePages.readin.GoodsTablePagesInputOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.FilterParameterOBJ;

public class OBJTransformService {

	private static final OBJTransformService INSTANCE = new OBJTransformService();
	
	private OBJTransformService() {
	}
	
	public static OBJTransformService getInstance() {
		
		return INSTANCE;
	}
	
	public FilterParameterOBJ goodsTablePagesInputToFilterParameter(GoodsTablePagesInputOBJ goodsTablePagesInputOBJ) {
		
		FilterParameterOBJ filterParameterOBJ = new FilterParameterOBJ();
		
		filterParameterOBJ.setIdMin(goodsTablePagesInputOBJ.getIdMin());
		filterParameterOBJ.setIdMax(goodsTablePagesInputOBJ.getIdMax());
		filterParameterOBJ.setName(goodsTablePagesInputOBJ.getName());
		filterParameterOBJ.setPriceMin(goodsTablePagesInputOBJ.getPriceMin());
		filterParameterOBJ.setPriceMax(goodsTablePagesInputOBJ.getPriceMax());
		filterParameterOBJ.setQuantityMin(goodsTablePagesInputOBJ.getQuantityMin());
		filterParameterOBJ.setQuantityMax(goodsTablePagesInputOBJ.getQuantityMax());
		filterParameterOBJ.setStatus(goodsTablePagesInputOBJ.getStatus());
		
		return filterParameterOBJ;
	}
}
