package memory.repository.backend.goodsList;

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
import service.backend.goodsList.memory.repository.goodsTablePages.OBJTransformService;
import service.backend.goodsList.prepare.GoodsTablePageService;
import service.backend.goodsList.memory.repository.goodsTablePages.FilterParameterService;
import service.model.GoodsModelService;
import template.memory.repository.RepositoryTemplate;
import template.model.QueryObj;
import transformer.backend.goodsList.obj.goodsTablePages.writeout.GoodsTableRowOBJTransformer;
import util.PaginationUtil;

public class GoodsTablePagesRepository extends RepositoryTemplate<GoodsTablePagesInputOBJ, GoodsTablePagesOBJ> {

	private boolean updateRequired;
	
	private FilterParameterService filterParameterService;
	private GoodsModelService goodsModelService;
	private GoodsTableRowOBJTransformer goodsTableRowOBJTransformer;
	private OBJTransformService objTransformService;
	

	@Override
	protected void init() {
		
		updateRequired = false;
		
		filterParameterService = FilterParameterService.getInstance();
		goodsModelService = GoodsModelService.getInstance();
		goodsTableRowOBJTransformer = GoodsTableRowOBJTransformer.getInstance();
		objTransformService = OBJTransformService.getInstance();
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

		return !filterParameterService.equals(objTransformService.goodsTablePagesInputToFilterParameter(inputObj), obj.getFilterParameter())
				|| obj.getGoodsTablePageMap().get(inputObj.getCurrentPage())==null
				|| updateRequired;
	}

	@Override
	protected GoodsTablePagesOBJ update(GoodsTablePagesInputOBJ inputObj) {

		GoodsTablePagesOBJ goodsTablePages = new GoodsTablePagesOBJ();
		
		FilterParameterOBJ filterParameterOBJ = objTransformService.goodsTablePagesInputToFilterParameter(inputObj);
		QueryObj[] queryObjs = filterParameterService.getQueryObjs(filterParameterOBJ);
		int maxPage = PaginationUtil.getMaxPage(goodsModelService.searchRowNumber(queryObjs), GoodsTablePageService.GOODS_PER_PAGE);
		int startPage = PaginationUtil.getStartPage(inputObj.getCurrentPage(), GoodsTablePageService.PAGES_PER_PAGE_GROUP);
		int endpage = PaginationUtil.getEndPage(inputObj.getCurrentPage(), GoodsTablePageService.PAGES_PER_PAGE_GROUP, maxPage);
		Map<Integer, GoodsTablePageOBJ> goodsTablePageMap = new HashMap<>();
		for(int i=startPage; i<=endpage; i++) {
			
			GoodsTablePageOBJ goodsTablePage = new GoodsTablePageOBJ();
			
			GoodsTableOBJ goodsTable = new GoodsTableOBJ();
			
			List<GoodsModelDTO> goodsModelDTOList = goodsModelService.searchByQueryObjPage(i, GoodsTablePageService.GOODS_PER_PAGE, queryObjs);

			goodsTable.setGoodsTableRows(
					goodsTableRowOBJTransformer.dtoListToObjList(
							goodsModelsToGoodsOBJs(goodsModelDTOList)));
			
			goodsTablePage.setGoodsTable(goodsTable);
			goodsTablePageMap.put(i, goodsTablePage);
		}

		goodsTablePages.setGoodsTablePageMap(goodsTablePageMap);
		goodsTablePages.setMaxPage(maxPage);
		goodsTablePages.setFilterParameter(filterParameterOBJ);
		
		if(updateRequired)
			updateRequired = false;
		
		return goodsTablePages;
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
