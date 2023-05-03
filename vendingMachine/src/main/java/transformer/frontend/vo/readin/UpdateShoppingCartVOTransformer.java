package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.UpdateShoppingCartVODTO;
import bean.vo.frontend.readin.UpdateShoppingCartVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.frontend.vo.readin.UpdateShoppingCartVOChecker;

public class UpdateShoppingCartVOTransformer extends VOReanInTransformerTemplate<UpdateShoppingCartVO, UpdateShoppingCartVODTO, CheckerException, UpdateShoppingCartVOChecker> {

	private UpdateShoppingCartGoodsVOTransformer updateShoppingCartGoodsVOTransformer;
	
	
	private static final UpdateShoppingCartVOTransformer INSTANCE = new UpdateShoppingCartVOTransformer();
	
	private UpdateShoppingCartVOTransformer() {
		
		updateShoppingCartGoodsVOTransformer = UpdateShoppingCartGoodsVOTransformer.getInstance();
	}
	
	public static UpdateShoppingCartVOTransformer getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	protected UpdateShoppingCartVODTO voToDtoTransform(UpdateShoppingCartVO vo) throws CheckerException {
		
		UpdateShoppingCartVODTO dto = new UpdateShoppingCartVODTO();
		
		dto.setCurrentUrl(vo.getCurrentUrl());
		dto.setUpdateShoppingCartGoodsList(updateShoppingCartGoodsVOTransformer.voArrayToDtoList(vo.getUpdateShoppingCartGoodsArray()));
		
		return dto;
	}

	@Override
	protected UpdateShoppingCartVOChecker getChecker() {
		
		return UpdateShoppingCartVOChecker.getInstance();
	}
}
