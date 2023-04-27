package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.UpdateShoppingCartGoodsVODTO;
import bean.vo.frontend.readin.UpdateShoppingCartGoodsVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.frontend.vo.readin.checker.UpdateShoppingCartGoodsVOChecker;

public class UpdateShoppingCartGoodsVOTransformer extends VOReanInTransformerTemplate<UpdateShoppingCartGoodsVO, 
					UpdateShoppingCartGoodsVODTO, CheckerException, UpdateShoppingCartGoodsVOChecker> {

	private static final UpdateShoppingCartGoodsVOTransformer INSTANCE = new UpdateShoppingCartGoodsVOTransformer();
	
	private UpdateShoppingCartGoodsVOTransformer() {
	}
	
	public static UpdateShoppingCartGoodsVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartGoodsVODTO voToDtoTransform(UpdateShoppingCartGoodsVO vo) throws CheckerException {
		
		UpdateShoppingCartGoodsVODTO dto = new UpdateShoppingCartGoodsVODTO();
		
		dto.setId(Integer.parseInt(vo.getId()));
		dto.setName(vo.getName());
		dto.setBuyQuantity(Integer.parseInt(vo.getBuyQuantity()));
		dto.setQuantity(Integer.parseInt(vo.getQuantity()));
		
		return dto;
	}

	@Override
	protected UpdateShoppingCartGoodsVOChecker getChecker() {
		
		return UpdateShoppingCartGoodsVOChecker.getInstance();
	}
}
