package service.backend.goodsList;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.model.GoodsModelDTO;
import bean.dto.vo.backend.goodsList.BGLRParameterDTO;
import bean.dto.vo.backend.goodsList.readin.BGLPageParameterRIVODTO;
import bean.dto.vo.backend.goodsList.writeout.BGLGTGoodsWOVODTO;
import bean.dto.vo.backend.goodsList.writeout.BGLGoodsTableWOVODTO;
import bean.dto.vo.backend.goodsList.writeout.BackendGoodsListWOVODTO;

public class GoBackendGoodsListService {
	
	private GoodsRepositoryService goodsRepositoryService;

	private static final GoBackendGoodsListService INSTANCE = new GoBackendGoodsListService();
	
	private GoBackendGoodsListService() {
		
		goodsRepositoryService = GoodsRepositoryService.getInstance();
	}
	
	public static GoBackendGoodsListService getInstance() {
		
		return INSTANCE;
	}
	
	public BackendGoodsListWOVODTO prepare(BGLPageParameterRIVODTO pageParameter) {
		
		BackendGoodsListWOVODTO backendGoodsListWOVODTO = new BackendGoodsListWOVODTO();
		
		Integer page = pageParameter.getPage();
		if(page == null)
			page = 1;
		
		goodsRepositoryService.updateRepository(transform(pageParameter), page);
		backendGoodsListWOVODTO.setGoodsTable(transform(goodsRepositoryService.getPage(page)));
		backendGoodsListWOVODTO.setPagination(goodsRepositoryService.getPagination());
		
		return backendGoodsListWOVODTO;
	}
	
	private BGLRParameterDTO transform(BGLPageParameterRIVODTO pageParameter) {
		
		BGLRParameterDTO bglrParameterDTO = new BGLRParameterDTO();
		
		bglrParameterDTO.setIdMin(pageParameter.getIdMin());
		bglrParameterDTO.setIdMax(pageParameter.getIdMax());
		bglrParameterDTO.setName(pageParameter.getName());
		bglrParameterDTO.setPriceMin(pageParameter.getPriceMin());
		bglrParameterDTO.setPriceMax(pageParameter.getPriceMax());
		bglrParameterDTO.setQuantityMin(pageParameter.getQuantityMin());
		bglrParameterDTO.setQuantityMax(pageParameter.getQuantityMax());
		bglrParameterDTO.setStatus(pageParameter.getStatus());
		
		return bglrParameterDTO;
	}
	
	private BGLGTGoodsWOVODTO transform(GoodsModelDTO goodsModelDTO) {
		
		BGLGTGoodsWOVODTO bglgtGoodsWOVODTO = new BGLGTGoodsWOVODTO();
		
		bglgtGoodsWOVODTO.setId(goodsModelDTO.getId());
		bglgtGoodsWOVODTO.setName(goodsModelDTO.getName());
		bglgtGoodsWOVODTO.setPrice(goodsModelDTO.getPrice());
		bglgtGoodsWOVODTO.setQuantity(goodsModelDTO.getQuantity());
		bglgtGoodsWOVODTO.setStatus(goodsModelDTO.getStatus());
		
		return bglgtGoodsWOVODTO;
	}
	
	private BGLGoodsTableWOVODTO transform(List<GoodsModelDTO> goodsModelDTOs) {
		
		List<BGLGTGoodsWOVODTO> bglgtGoodsWOVODTOs = goodsModelDTOs.stream()
				.map(dto -> transform(dto))
				.collect(Collectors.toList());
		
		BGLGoodsTableWOVODTO bglGoodsTableWOVODTO = new BGLGoodsTableWOVODTO();
		
		bglGoodsTableWOVODTO.setGoods(bglgtGoodsWOVODTOs);
		
		return bglGoodsTableWOVODTO;
	}
}
