package memory.repository.backend.goodsList.goodsTablePages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.goods.GoodsModel;
import database.goods.GoodsModelDAO;
import service.backend.goodsList.BGLRParameterService;
import service.backend.goodsList.GoBackendGoodsListService;
import service.backend.goodsList.GoodsTablePagesService;
import service.dao.QueryObj;
import template.memory.repository.RepositoryTemplate;
import util.PaginationUtil;

class GoodsTablePagesRepository extends RepositoryTemplate<GoodsTablePagesInputObj, GoodsTablePagesObj> {

	private boolean needUpdate;
	
	private SearchParametersService searchParametersService;
	private GoodsModelDAO goodsDAO;
	
	@Override
	protected void init() {
		
		needUpdate = false;
		
		searchParametersService = SearchParametersService.getInstance();
		goodsDAO = GoodsModelDAO.getInstance();
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
	protected boolean needUpdate(GoodsTablePagesInputObj input) {

		return !searchParametersService.equals(input.getSearchParameters(), obj.getSearchParameters())
				|| obj.getGoodsTablePageMap().get(input.getCurrentPage())==null
				|| needUpdate;
	}

	@Override
	protected GoodsTablePagesObj update(GoodsTablePagesInputObj input) {

		GoodsTablePagesObj goodsTablePages = new GoodsTablePagesObj();
		
		QueryObj[] queryObjs = searchParametersService.getQueryObjs(input.getSearchParameters());
		int maxPage = PaginationUtil.getMaxPage(goodsDAO.searchRowNumber(queryObjs), GoodsTablePagesService.GOODS_PER_PAGE);
		int startPage = PaginationUtil.getStartPage(input.getCurrentPage(), GoodsTablePagesService.PAGES_PER_PAGE_GROUP);
		int endpage = PaginationUtil.getEndPage(input.getCurrentPage(), GoodsTablePagesService.PAGES_PER_PAGE_GROUP, maxPage);
		Map<Integer, GoodsTablePageObj> goodsTablePageMap = new HashMap<>();
		for(int i=startPage; i<=endpage; i++) {
			
			GoodsTablePageObj goodsTablePage = new GoodsTablePageObj();
			
			GoodsTableObj goodsTable = new GoodsTableObj();
			
			List<GoodsObj> goodsList = new ArrayList<GoodsObj>();
			List<GoodsModel> goodsModelList = goodsDAO.searchByQueryObjPage(i, GoodsTablePagesService.GOODS_PER_PAGE, queryObjs);
			
			
			goodsTable.setGoodsList(goodsList);
			
			goodsTablePage.setGoodsTable(goodsTable);
		}

		goodsTablePages.setSearchParameters(input.getSearchParameters());
		goodsTablePages.setGoodsTablePageMap(goodsTablePageMap);
		goodsTablePages.setMaxPage(maxPage);
		return goodsTablePages;
	}

	
	private GoodsObj transform(GoodsModel model) {
		
		
	}
}
