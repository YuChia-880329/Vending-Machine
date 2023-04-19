package memory.repository.frontend;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsCardOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsIntroductionOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTableEntryOBJDTO;
import bean.dto.model.GoodsModelDTO;
import bean.obj.frontend.repository.goodsTablePages.readin.GoodsTablePagesInputOBJ;
import bean.obj.frontend.repository.goodsTablePages.writeout.FilterParameterOBJ;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTableEntryOBJ;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTableOBJ;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTablePageOBJ;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTablePagesOBJ;
import service.frontend.memory.repository.goodsTablePages.FilterParameterService;
import service.frontend.prepare.GoodsTablePageService;
import service.model.GoodsModelService;
import template.memory.repository.RepositoryTemplate;
import template.model.QueryObj;
import transformer.frontend.obj.goodsTablePages.writeout.GoodsTableEntryOBJTransformer;

public class GoodsTablePagesRepository extends RepositoryTemplate<GoodsTablePagesInputOBJ, GoodsTablePagesOBJ> {

	private boolean updateRequired;
	
	private FilterParameterService filterParameterService;
	private GoodsModelService goodsModelService;
	private GoodsTableEntryOBJTransformer goodsTableEntryOBJTransformer;
	
	@Override
	protected void init() {
		
		updateRequired = false;
		
		filterParameterService = FilterParameterService.getInstance();
		goodsModelService = GoodsModelService.getInstance();
		goodsTableEntryOBJTransformer = GoodsTableEntryOBJTransformer.getInstance();
	}
	
	@Override
	protected GoodsTablePagesInputOBJ initialInput() {

		GoodsTablePagesInputOBJ goodsTablePagesInputOBJ = new GoodsTablePagesInputOBJ();
		
		goodsTablePagesInputOBJ.setCurrentPage(1);
		goodsTablePagesInputOBJ.setName(null);
		
		return goodsTablePagesInputOBJ;
	}

	@Override
	protected boolean isNeedUpdate(GoodsTablePagesInputOBJ inputObj) {

		return !filterParameterService.equals(goodsTablePagesInputToFilterParameter(inputObj), obj.getFilterParameter())
				|| obj.getGoodsTablePageMap().get(inputObj.getCurrentPage())==null
				|| updateRequired;
	}

	@Override
	protected GoodsTablePagesOBJ update(GoodsTablePagesInputOBJ i) {

		return null;
	}
	
	
	
	private GoodsTablePageOBJ updateGoodsTablePageOBJ(int page, QueryObj[] queryObjs) throws SQLException {
		
		GoodsTablePageOBJ goodsTablePageOBJ = new GoodsTablePageOBJ();
		
		goodsTablePageOBJ.setGoodsTable(updateGoodsTableOBJ(page, queryObjs));
		
		return goodsTablePageOBJ;
	}
	private GoodsTableOBJ updateGoodsTableOBJ(int page, QueryObj[] queryObjs) throws SQLException {
		
		GoodsTableOBJ goodsTableOBJ = new GoodsTableOBJ();
		
		goodsTableOBJ.setGoodsTableEntries(updateGoodsTableEntries(page, queryObjs));
		
		return goodsTableOBJ;
	}
	private List<GoodsTableEntryOBJ> updateGoodsTableEntries(int page, QueryObj[] queryObjs) throws SQLException{
		
		List<GoodsModelDTO> goodsModels = goodsModelService.searchByQueryObjPage(page, GoodsTablePageService.GOODS_PER_PAGE, queryObjs);
		List<GoodsTableEntryOBJDTO> goodsTableEntryOBJs = goodsModelsToGoodsTableEntryOBJs(goodsModels);
		
		return goodsTableEntryOBJTransformer.dtoListToObjList(goodsTableEntryOBJs);
	}
	private GoodsTableEntryOBJDTO goodsModelToGoodsTableEntryOBJ(GoodsModelDTO goodsModelDTO) {
		
		GoodsTableEntryOBJDTO goodsTableEntryOBJDTO = new GoodsTableEntryOBJDTO();
		
		goodsTableEntryOBJDTO.setId(goodsModelDTO.getId());
		goodsTableEntryOBJDTO.setGoodsCard(goodsModelToGoodsCardOBJ(goodsModelDTO));
		goodsTableEntryOBJDTO.setGoodsIntroduction(goodsModelToGoodsIntroductionOBJ(goodsModelDTO));
		
		return goodsTableEntryOBJDTO;
	}
	private List<GoodsTableEntryOBJDTO> goodsModelsToGoodsTableEntryOBJs(List<GoodsModelDTO> goodsModelDTOs){
		
		return goodsModelDTOs.stream()
				.map(goodsModelDTO -> goodsModelToGoodsTableEntryOBJ(goodsModelDTO))
				.collect(Collectors.toList());
	}
	private GoodsCardOBJDTO goodsModelToGoodsCardOBJ(GoodsModelDTO goodsModelDTO) {
		
		GoodsCardOBJDTO goodsCardOBJDTO = new GoodsCardOBJDTO();
		
		goodsCardOBJDTO.setName(goodsModelDTO.getName());
		goodsCardOBJDTO.setPrice(goodsModelDTO.getPrice());
		goodsCardOBJDTO.setImageName(goodsModelDTO.getImageName());
		goodsCardOBJDTO.setQuantity(goodsModelDTO.getQuantity());
		
		return goodsCardOBJDTO;
	}
	private GoodsIntroductionOBJDTO goodsModelToGoodsIntroductionOBJ(GoodsModelDTO goodsModelDTO) {
		
		GoodsIntroductionOBJDTO goodsIntroductionOBJDTO = new GoodsIntroductionOBJDTO();
		
		goodsIntroductionOBJDTO.setName(goodsModelDTO.getName());
		goodsIntroductionOBJDTO.setImageName(goodsModelDTO.getImageName());
		goodsIntroductionOBJDTO.setDescription(goodsModelDTO.getDescription());
		goodsIntroductionOBJDTO.setPrice(goodsModelDTO.getPrice());
		goodsIntroductionOBJDTO.setQuantity(goodsModelDTO.getQuantity());
		
		return goodsIntroductionOBJDTO;
	}
	
	private FilterParameterOBJ goodsTablePagesInputToFilterParameter(GoodsTablePagesInputOBJ goodsTablePagesInputOBJ) {
		
		FilterParameterOBJ filterParameterOBJ = new FilterParameterOBJ();
		
		filterParameterOBJ.setName(goodsTablePagesInputOBJ.getName());
		
		return filterParameterOBJ;
	}
}
