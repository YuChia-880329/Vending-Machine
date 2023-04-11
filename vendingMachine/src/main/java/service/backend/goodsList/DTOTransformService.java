package service.backend.goodsList;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.SearchParameterOBJDTO;
import bean.dto.backend.goodsList.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsOBJDTO;
import bean.dto.backend.goodsList.vo.SearchParameterVODTO;
import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.backend.goodsList.vo.writeout.GoodsTableRowVODTO;
import bean.dto.model.GoodsModelDTO;

public class DTOTransformService {

	private static final DTOTransformService INSTANCE = new DTOTransformService();
	
	private DTOTransformService() {
	}
	
	public static DTOTransformService getInstance() {
		
		return INSTANCE;
	}
	
	public GoodsOBJDTO goodsModelToGoodsOBJ(GoodsModelDTO goodsModelDTO) {
		
		GoodsOBJDTO goodsOBJDTO = new GoodsOBJDTO();
		
		goodsOBJDTO.setId(goodsModelDTO.getId());
		goodsOBJDTO.setName(goodsModelDTO.getName());
		goodsOBJDTO.setDescription(goodsModelDTO.getDescription());
		goodsOBJDTO.setPrice(goodsModelDTO.getPrice());
		goodsOBJDTO.setQuantity(goodsModelDTO.getQuantity());
		goodsOBJDTO.setImageName(goodsModelDTO.getImageName());
		goodsOBJDTO.setStatus(goodsModelDTO.getStatus());
		
		return goodsOBJDTO;
	}
	
	public List<GoodsOBJDTO> goodsModelsToGoodsOBJs(List<GoodsModelDTO> goodsModelDTOs){
		
		return goodsModelDTOs.stream()
				.map(goodsModelDTO -> goodsModelToGoodsOBJ(goodsModelDTO))
				.collect(Collectors.toList());
	}
	
	public GoodsTableRowVODTO goodsOBJToGoodsTableRowVO(GoodsOBJDTO goodsOBJDTO){
		
		GoodsTableRowVODTO goodsTableRowVODTO = new GoodsTableRowVODTO();
		
		goodsTableRowVODTO.setId(goodsOBJDTO.getId());
		goodsTableRowVODTO.setName(goodsOBJDTO.getName());
		goodsTableRowVODTO.setPrice(goodsOBJDTO.getPrice());
		goodsTableRowVODTO.setQuantity(goodsOBJDTO.getQuantity());
		goodsTableRowVODTO.setStatus(goodsOBJDTO.getStatus());
		
		return goodsTableRowVODTO;
	}
	
	public List<GoodsTableRowVODTO> goodsOBJsToGoodsTableRowVOs(List<GoodsOBJDTO> goodsOBJDTOs){
		
		return goodsOBJDTOs.stream()
				.map(goodsOBJDTO -> goodsOBJToGoodsTableRowVO(goodsOBJDTO))
				.collect(Collectors.toList());
	}
	
	public SearchParameterOBJDTO searchParameterVOToSearchParameterOBJ(SearchParameterVODTO searchParameterVODTO) {
		
		SearchParameterOBJDTO searchParameterOBJDTO = new SearchParameterOBJDTO();
		
		searchParameterOBJDTO.setIdMin(searchParameterVODTO.getIdMin());
		searchParameterOBJDTO.setIdMax(searchParameterVODTO.getIdMax());
		searchParameterOBJDTO.setName(searchParameterVODTO.getName());
		searchParameterOBJDTO.setPriceMin(searchParameterVODTO.getPriceMin());
		searchParameterOBJDTO.setPriceMax(searchParameterVODTO.getPriceMax());
		searchParameterOBJDTO.setQuantityMin(searchParameterVODTO.getQuantityMin());
		searchParameterOBJDTO.setQuantityMax(searchParameterVODTO.getQuantityMax());
		searchParameterOBJDTO.setStatus(searchParameterVODTO.getStatus());
		
		return searchParameterOBJDTO;
	}
	
	public GoodsTablePagesInputOBJDTO pageParameterVOToGoodsTablePagesInputOBJ(PageParameterVODTO pageParameterVODTO) {
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = new GoodsTablePagesInputOBJDTO();
		
		goodsTablePagesInputOBJDTO.setSearchParameter(searchParameterVOToSearchParameterOBJ(pageParameterVODTO.getSearchParameter()));
		goodsTablePagesInputOBJDTO.setCurrentPage(pageParameterVODTO.getPage());
		
		return goodsTablePagesInputOBJDTO;
	}
}
