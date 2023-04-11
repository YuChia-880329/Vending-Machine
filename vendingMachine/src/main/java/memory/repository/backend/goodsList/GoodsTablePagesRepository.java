package memory.repository.backend.goodsList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.dto.model.GoodsModelDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.SearchParameterOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.readin.GoodsTablePagesInputOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTableOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTablePageOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTablePagesOBJ;
import service.backend.goodsList.DTOTransformService;
import service.backend.goodsList.GoodsTablePagesService;
import service.backend.goodsList.memory.repository.goodsTablePages.SearchParameterService;
import service.model.GoodsModelService;
import template.memory.repository.RepositoryTemplate;
import template.model.QueryObj;
import transformer.backend.goodsList.obj.goodsTablePages.writeout.GoodsOBJTransformer;
import util.PaginationUtil;

public class GoodsTablePagesRepository extends RepositoryTemplate<GoodsTablePagesInputOBJ, GoodsTablePagesOBJ> {

	private boolean updateRequired;
	
	private SearchParameterService searchParameterService;
	private GoodsModelService goodsModelService;
	private GoodsOBJTransformer goodsModelTransformer;
	private DTOTransformService dtoTransformService;
	

	@Override
	protected void init() {
		
		updateRequired = false;
		
		searchParameterService = SearchParameterService.getInstance();
		goodsModelService = GoodsModelService.getInstance();
		goodsModelTransformer = GoodsOBJTransformer.getInstance();
		dtoTransformService = DTOTransformService.getInstance();
	}

	@Override
	protected GoodsTablePagesInputOBJ initialInput() {

		GoodsTablePagesInputOBJ goodsTablePagesInput = new GoodsTablePagesInputOBJ();
		
		SearchParameterOBJ searchParameter = new SearchParameterOBJ();
		
		searchParameter.setIdMin(null);
		searchParameter.setIdMax(null);
		searchParameter.setName(null);
		searchParameter.setPriceMin(null);
		searchParameter.setPriceMax(null);
		searchParameter.setQuantityMin(null);
		searchParameter.setQuantityMax(null);
		searchParameter.setStatus(null);
		
		goodsTablePagesInput.setSearchParameter(searchParameter);
		goodsTablePagesInput.setCurrentPage(1);
		
		return goodsTablePagesInput;
	}

	@Override
	protected boolean isNeedUpdate(GoodsTablePagesInputOBJ inputObj) {

		return !searchParameterService.equals(inputObj.getSearchParameter(), obj.getSearchParameter())
				|| obj.getGoodsTablePageMap().get(inputObj.getCurrentPage())==null
				|| updateRequired;
	}

	@Override
	protected GoodsTablePagesOBJ update(GoodsTablePagesInputOBJ inputObj) {

		GoodsTablePagesOBJ goodsTablePages = new GoodsTablePagesOBJ();
		
		QueryObj[] queryObjs = searchParameterService.getQueryObjs(inputObj.getSearchParameter());
		int maxPage = PaginationUtil.getMaxPage(goodsModelService.searchRowNumber(queryObjs), GoodsTablePagesService.GOODS_PER_PAGE);
		int startPage = PaginationUtil.getStartPage(inputObj.getCurrentPage(), GoodsTablePagesService.PAGES_PER_PAGE_GROUP);
		int endpage = PaginationUtil.getEndPage(inputObj.getCurrentPage(), GoodsTablePagesService.PAGES_PER_PAGE_GROUP, maxPage);
		Map<Integer, GoodsTablePageOBJ> goodsTablePageMap = new HashMap<>();
		for(int i=startPage; i<=endpage; i++) {
			
			GoodsTablePageOBJ goodsTablePage = new GoodsTablePageOBJ();
			
			GoodsTableOBJ goodsTable = new GoodsTableOBJ();
			
			List<GoodsModelDTO> goodsModelDTOList = goodsModelService.searchByQueryObjPage(i, GoodsTablePagesService.GOODS_PER_PAGE, queryObjs);
			
			goodsTable.setGoodsList(
					goodsModelTransformer.dtoListToObjList(
							dtoTransformService.goodsModelsToGoodsOBJs(goodsModelDTOList)));
			
			goodsTablePage.setGoodsTable(goodsTable);
			goodsTablePageMap.put(i, goodsTablePage);
		}

		goodsTablePages.setSearchParameter(inputObj.getSearchParameter());
		goodsTablePages.setGoodsTablePageMap(goodsTablePageMap);
		goodsTablePages.setMaxPage(maxPage);
		
		if(updateRequired)
			updateRequired = false;
		
		return goodsTablePages;
	}
}
