package service.backend.goodsUpdate.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.backend.goodsUpdate.vo.writeout.GoodsNameOptionVODTO;
import bean.dto.model.GoodsModelDTO;
import service.model.GoodsModelService;

public class GoodsNameOptionsService {

	private GoodsModelService goodsModelService;
	
	private static final GoodsNameOptionsService INSTANCE = new GoodsNameOptionsService();
	
	private GoodsNameOptionsService() {
		
		goodsModelService = GoodsModelService.getInstance();
	}
	
	public static GoodsNameOptionsService getInstance() {
		
		return INSTANCE;
	}
	
	public List<GoodsNameOptionVODTO> prepare(){
		
		List<GoodsModelDTO> goodsModelDTOs = goodsModelService.searchAll();
		return goodsModelsToGoodsNameOptionVOs(goodsModelDTOs);
	}
	
	private List<GoodsNameOptionVODTO> goodsModelsToGoodsNameOptionVOs(List<GoodsModelDTO> goodsModelDTOs){
		
		return goodsModelDTOs.stream()
				.map(goodsModelDTO -> goodsModelToGoodsNameOptionVO(goodsModelDTO))
				.collect(Collectors.toList());
	}
	private GoodsNameOptionVODTO goodsModelToGoodsNameOptionVO(GoodsModelDTO goodsModelDTO) {
		
		GoodsNameOptionVODTO goodsNameOptionVODTO = new GoodsNameOptionVODTO();
		
		goodsNameOptionVODTO.setId(goodsModelDTO.getId());
		goodsNameOptionVODTO.setName(goodsModelDTO.getName());
		
		return goodsNameOptionVODTO;
	}
}
