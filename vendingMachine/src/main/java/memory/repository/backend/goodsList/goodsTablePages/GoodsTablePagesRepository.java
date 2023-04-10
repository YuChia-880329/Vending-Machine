package memory.repository.backend.goodsList.goodsTablePages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.dto.model.GoodsModelDTO;
import database.goods.GoodsModelService;
import service.backend.goodsList.GoodsTablePagesService;
import template.database.QueryObj;
import template.memory.repository.RepositoryTemplate;
import util.PaginationUtil;

class GoodsTablePagesRepository extends RepositoryTemplate<GoodsTablePagesInputObj, GoodsTablePagesObj> {

	private boolean updateRequired;
	
	private SearchParametersService searchParametersService;
	private GoodsModelService goodsModelService;
	private GoodsObjTransformer goodsModelTransformer;
	

	@Override
	protected void init() {
		
		updateRequired = false;
		
		searchParametersService = SearchParametersService.getInstance();
		goodsModelService = GoodsModelService.getInstance();
		goodsModelTransformer = GoodsObjTransformer.getInstance();
	}

	@Override
	protected GoodsTablePagesInputObj initialInput() {

		GoodsTablePagesInputObj goodsTablePagesInput = new GoodsTablePagesInputObj();
		
		SearchParametersObj searchParameters = new SearchParametersObj();
		
		searchParameters.setIdMin(null);
		searchParameters.setIdMax(null);
		searchParameters.setName(null);
		searchParameters.setPriceMin(null);
		searchParameters.setPriceMax(null);
		searchParameters.setQuantityMin(null);
		searchParameters.setQuantityMax(null);
		searchParameters.setStatus(null);
		
		goodsTablePagesInput.setSearchParameters(searchParameters);
		goodsTablePagesInput.setCurrentPage(1);
		
		return goodsTablePagesInput;
	}

	@Override
	protected boolean isNeedUpdate(GoodsTablePagesInputObj input) {

		return !searchParametersService.equals(input.getSearchParameters(), obj.getSearchParameters())
				|| obj.getGoodsTablePageMap().get(input.getCurrentPage())==null
				|| updateRequired;
	}

	@Override
	protected GoodsTablePagesObj update(GoodsTablePagesInputObj input) {

		GoodsTablePagesObj goodsTablePages = new GoodsTablePagesObj();
		
		QueryObj[] queryObjs = searchParametersService.getQueryObjs(input.getSearchParameters());
		int maxPage = PaginationUtil.getMaxPage(goodsModelService.searchRowNumber(queryObjs), GoodsTablePagesService.GOODS_PER_PAGE);
		int startPage = PaginationUtil.getStartPage(input.getCurrentPage(), GoodsTablePagesService.PAGES_PER_PAGE_GROUP);
		int endpage = PaginationUtil.getEndPage(input.getCurrentPage(), GoodsTablePagesService.PAGES_PER_PAGE_GROUP, maxPage);
		Map<Integer, GoodsTablePageObj> goodsTablePageMap = new HashMap<>();
		for(int i=startPage; i<=endpage; i++) {
			
			GoodsTablePageObj goodsTablePage = new GoodsTablePageObj();
			
			GoodsTableObj goodsTable = new GoodsTableObj();
			
			List<GoodsModelDTO> goodsModelDTOList = goodsModelService.searchByQueryObjPage(i, GoodsTablePagesService.GOODS_PER_PAGE, queryObjs);
			
			goodsTable.setGoodsList(goodsModelTransformer.dtoListToObjList(goodsModelDTOList));
			
			goodsTablePage.setGoodsTable(goodsTable);
			goodsTablePageMap.put(i, goodsTablePage);
		}

		goodsTablePages.setSearchParameters(input.getSearchParameters());
		goodsTablePages.setGoodsTablePageMap(goodsTablePageMap);
		goodsTablePages.setMaxPage(maxPage);
		
		if(updateRequired)
			updateRequired = false;
		
		return goodsTablePages;
	}



}
