package service.backend.goodsUpdate.prepare;

import bean.dto.backend.goodsUpdate.vo.writeout.UpdateFormVODTO;

public class UpdateFormService {
	
	private GoodsNameOptionsService goodsNameOptionsService;

	private static final UpdateFormService INSTANCE = new UpdateFormService();
	
	private UpdateFormService() {
		
		goodsNameOptionsService = GoodsNameOptionsService.getInstance();
	}
	
	public static UpdateFormService getInstance() {
		
		return INSTANCE;
	}
	
	public UpdateFormVODTO prepare() {
		
		UpdateFormVODTO updateFormVODTO = new UpdateFormVODTO();
		
		updateFormVODTO.setGoodsNameOptions(goodsNameOptionsService.prepare());
		
		return updateFormVODTO;
	}
}
