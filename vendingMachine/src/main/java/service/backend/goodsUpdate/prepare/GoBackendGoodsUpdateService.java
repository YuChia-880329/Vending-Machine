package service.backend.goodsUpdate.prepare;

import bean.dto.backend.goodsUpdate.vo.writeout.BackendGoodsUpdateVODTO;

public class GoBackendGoodsUpdateService {

	private UpdateFormService updateFormService;
	
	private static final GoBackendGoodsUpdateService INSTANCE = new GoBackendGoodsUpdateService();
	
	private GoBackendGoodsUpdateService() {
		
		updateFormService = UpdateFormService.getInstance();
	}
	
	public static GoBackendGoodsUpdateService getInstance() {
		
		return INSTANCE;
	}
	
	public BackendGoodsUpdateVODTO prepare() {
		
		BackendGoodsUpdateVODTO backendGoodsUpdateVODTO = new BackendGoodsUpdateVODTO();

		backendGoodsUpdateVODTO.setUpdateForm(updateFormService.prepare());
		
		return backendGoodsUpdateVODTO;
	}
}
