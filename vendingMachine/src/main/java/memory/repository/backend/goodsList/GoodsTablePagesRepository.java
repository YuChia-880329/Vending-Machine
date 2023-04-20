package memory.repository.backend.goodsList;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTableRowOBJDTO;
import bean.dto.model.GoodsModelDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.readin.GoodsTablePagesInputOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.FilterParameterOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTableOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTablePageOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTablePagesOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTableRowOBJ;
import service.backend.goodsList.prepare.GoodsTablePageService;
import service.backend.goodsList.memory.repository.goodsTablePages.FilterParameterService;
import service.model.GoodsModelService;
import template.memory.repository.RepositoryTemplate;
import template.model.QueryObj;
import transformer.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTableRowOBJTransformer;
import util.PaginationUtil;

public class GoodsTablePagesRepository extends RepositoryTemplate<GoodsTablePagesInputOBJ, GoodsTablePagesOBJ> {

	private boolean updateRequired;
	
	private FilterParameterService filterParameterService;
	private GoodsModelService goodsModelService;
	private GoodsTableRowOBJTransformer goodsTableRowOBJTransformer;
	

	@Override
	protected void init() {
		
		updateRequired = false;
		
		filterParameterService = FilterParameterService.getInstance();
		goodsModelService = GoodsModelService.getInstance();
		goodsTableRowOBJTransformer = GoodsTableRowOBJTransformer.getInstance();
	}

	@Override
	protected GoodsTablePagesInputOBJ initialInput() {

		GoodsTablePagesInputOBJ goodsTablePagesInput = new GoodsTablePagesInputOBJ();
		
		goodsTablePagesInput.setCurrentPage(1);
		goodsTablePagesInput.setIdMin(null);
		goodsTablePagesInput.setIdMax(null);
		goodsTablePagesInput.setName(null);
		goodsTablePagesInput.setPriceMin(null);
		goodsTablePagesInput.setPriceMax(null);
		goodsTablePagesInput.setQuantityMin(null);
		goodsTablePagesInput.setQuantityMax(null);
		goodsTablePagesInput.setStatus(null);
		
		return goodsTablePagesInput;
	}

	@Override
	protected boolean isNeedUpdate(GoodsTablePagesInputOBJ inputObj) {

		return !filterParameterService.equals(goodsTablePagesInputToFilterParameter(inputObj), obj.getFilterParameter())
				|| obj.getGoodsTablePageMap().get(inputObj.getCurrentPage())==null
				|| updateRequired;
	}

	@Override
	protected GoodsTablePagesOBJ update(GoodsTablePagesInputOBJ inputObj) {

		GoodsTablePagesOBJ goodsTablePages = new GoodsTablePagesOBJ();
		
		FilterParameterOBJ filterParameterOBJ = goodsTablePagesInputToFilterParameter(inputObj);
		QueryObj[] queryObjs = filterParameterService.getQueryObjs(filterParameterOBJ);
		Map<Integer, GoodsTablePageOBJ> goodsTablePageMap;
		int maxPage;
		try {
			
			maxPage = PaginationUtil.getMaxPage(goodsModelService.searchRowNumber(queryObjs), GoodsTablePageService.GOODS_PER_PAGE);
			goodsTablePageMap = updateGoodsTablePageMap(inputObj, maxPage, queryObjs);
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			goodsTablePageMap = new HashMap<>();
			maxPage = 0;
		}

		goodsTablePages.setGoodsTablePageMap(goodsTablePageMap);
		goodsTablePages.setMaxPage(maxPage);
		goodsTablePages.setFilterParameter(filterParameterOBJ);
		
		if(updateRequired)
			updateRequired = false;
		
		return goodsTablePages;
	}
	
	public void requireUpdate() {
		
		updateRequired = true;
	}
	
	private Map<Integer, GoodsTablePageOBJ> updateGoodsTablePageMap(GoodsTablePagesInputOBJ inputObj, int maxPage, QueryObj[] queryObjs) throws SQLException{
		
		Map<Integer, GoodsTablePageOBJ> goodsTablePageMap = new HashMap<>();
			
		int startPage = PaginationUtil.getStartPage(inputObj.getCurrentPage(), GoodsTablePageService.PAGES_PER_PAGE_GROUP);
		int endpage = PaginationUtil.getEndPage(inputObj.getCurrentPage(), GoodsTablePageService.PAGES_PER_PAGE_GROUP, maxPage);
		
		for(int i=startPage; i<=endpage; i++) {

			goodsTablePageMap.put(i, updateGoodsTablePage(i, queryObjs));
		}
		
		return goodsTablePageMap;
	}
	private GoodsTablePageOBJ updateGoodsTablePage(int page, QueryObj[] queryObjs) throws SQLException {
		
		GoodsTablePageOBJ goodsTablePageOBJ = new GoodsTablePageOBJ();
		
		goodsTablePageOBJ.setGoodsTable(updateGoodsTable(page, queryObjs));
		
		return goodsTablePageOBJ;
	}
	private GoodsTableOBJ updateGoodsTable(int page, QueryObj[] queryObjs) throws SQLException {
		
		GoodsTableOBJ goodsTableOBJ = new GoodsTableOBJ();
		
		goodsTableOBJ.setGoodsTableRows(updateGoodsTableRows(page, queryObjs));
		
		return goodsTableOBJ;
	}
	private List<GoodsTableRowOBJ> updateGoodsTableRows(int page, QueryObj[] queryObjs) throws SQLException{
		
		List<GoodsModelDTO> goodsModelDTOs = goodsModelService.searchByQueryObjPage(page, GoodsTablePageService.GOODS_PER_PAGE, queryObjs);
		List<GoodsTableRowOBJDTO> goodsTableRowOBJs = goodsModelsToGoodsOBJs(goodsModelDTOs);
		
		return goodsTableRowOBJTransformer.dtoListToObjList(goodsTableRowOBJs);
	}
	
	
	private FilterParameterOBJ goodsTablePagesInputToFilterParameter(GoodsTablePagesInputOBJ goodsTablePagesInputOBJ) {
		
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
	private List<GoodsTableRowOBJDTO> goodsModelsToGoodsOBJs(List<GoodsModelDTO> goodsModelDTOs){
		
		return goodsModelDTOs.stream()
				.map(goodsModelDTO -> goodsModelToGoodsOBJ(goodsModelDTO))
				.collect(Collectors.toList());
	}
	private GoodsTableRowOBJDTO goodsModelToGoodsOBJ(GoodsModelDTO goodsModelDTO) {
		
		GoodsTableRowOBJDTO goodsTableRowOBJDTO = new GoodsTableRowOBJDTO();
		
		goodsTableRowOBJDTO.setId(goodsModelDTO.getId());
		goodsTableRowOBJDTO.setName(goodsModelDTO.getName());
		goodsTableRowOBJDTO.setPrice(goodsModelDTO.getPrice());
		goodsTableRowOBJDTO.setQuantity(goodsModelDTO.getQuantity());
		goodsTableRowOBJDTO.setStatus(goodsModelDTO.getStatus());
		
		return goodsTableRowOBJDTO;
	}
}
