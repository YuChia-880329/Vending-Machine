package service.backend.goodsList;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTableRowOBJDTO;
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
	
	public GoodsTableRowOBJDTO goodsModelToGoodsOBJ(GoodsModelDTO goodsModelDTO) {
		
		GoodsTableRowOBJDTO goodsTableRowOBJDTO = new GoodsTableRowOBJDTO();
		
		goodsTableRowOBJDTO.setId(goodsModelDTO.getId());
		goodsTableRowOBJDTO.setName(goodsModelDTO.getName());
		goodsTableRowOBJDTO.setPrice(goodsModelDTO.getPrice());
		goodsTableRowOBJDTO.setQuantity(goodsModelDTO.getQuantity());
		goodsTableRowOBJDTO.setStatus(goodsModelDTO.getStatus());
		
		return goodsTableRowOBJDTO;
	}
	
	public List<GoodsTableRowOBJDTO> goodsModelsToGoodsOBJs(List<GoodsModelDTO> goodsModelDTOs){
		
		return goodsModelDTOs.stream()
				.map(goodsModelDTO -> goodsModelToGoodsOBJ(goodsModelDTO))
				.collect(Collectors.toList());
	}
	
	public GoodsTableRowVODTO goodsTableRowOBJToGoodsTableRowVO(GoodsTableRowOBJDTO goodsOBJDTO){
		
		GoodsTableRowVODTO goodsTableRowVODTO = new GoodsTableRowVODTO();
		
		goodsTableRowVODTO.setId(goodsOBJDTO.getId());
		goodsTableRowVODTO.setName(goodsOBJDTO.getName());
		goodsTableRowVODTO.setPrice(goodsOBJDTO.getPrice());
		goodsTableRowVODTO.setQuantity(goodsOBJDTO.getQuantity());
		goodsTableRowVODTO.setStatus(goodsOBJDTO.getStatus());
		
		return goodsTableRowVODTO;
	}
	
	public List<GoodsTableRowVODTO> goodsTableRowOBJsToGoodsTableRowVOs(List<GoodsTableRowOBJDTO> goodsOBJDTOs){
		
		return goodsOBJDTOs.stream()
				.map(goodsOBJDTO -> goodsTableRowOBJToGoodsTableRowVO(goodsOBJDTO))
				.collect(Collectors.toList());
	}
	
	public GoodsTablePagesInputOBJDTO pageParameterVOToGoodsTablePagesInputOBJ(PageParameterVODTO pageParameterVODTO) {
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = new GoodsTablePagesInputOBJDTO();

		goodsTablePagesInputOBJDTO.setCurrentPage(pageParameterVODTO.getPage().intValue());
		goodsTablePagesInputOBJDTO.setIdMin(pageParameterVODTO.getIdMin());
		goodsTablePagesInputOBJDTO.setIdMax(pageParameterVODTO.getIdMax());
		goodsTablePagesInputOBJDTO.setName(pageParameterVODTO.getName());
		goodsTablePagesInputOBJDTO.setPriceMin(pageParameterVODTO.getPriceMin());
		goodsTablePagesInputOBJDTO.setPriceMax(pageParameterVODTO.getPriceMax());
		goodsTablePagesInputOBJDTO.setQuantityMin(pageParameterVODTO.getQuantityMin());
		goodsTablePagesInputOBJDTO.setQuantityMax(pageParameterVODTO.getQuantityMax());
		goodsTablePagesInputOBJDTO.setStatus(pageParameterVODTO.getStatus());
		
		return goodsTablePagesInputOBJDTO;
	}
}
