package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.vo.frontend.readin.AddShoppingCartGoodsVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.frontend.vo.readin.checker.AddShoppingCartGoodsVOChecker;

public class AddShoppingCartGoodsVOTransformer extends VOReanInTransformerTemplate<AddShoppingCartGoodsVO, AddShoppingCartGoodsVODTO, CheckerException, AddShoppingCartGoodsVOChecker>  {

	private static final AddShoppingCartGoodsVOTransformer INSTANCE = new AddShoppingCartGoodsVOTransformer();
	
	private AddShoppingCartGoodsVOTransformer() {
	}
	
	public static AddShoppingCartGoodsVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartGoodsVODTO voToDtoTransform(AddShoppingCartGoodsVO vo) throws CheckerException {

		AddShoppingCartGoodsVODTO dto = new AddShoppingCartGoodsVODTO();
		
		dto.setId(Integer.parseInt(vo.getId()));
		dto.setBuyQuantity(Integer.parseInt(vo.getBuyQuantity()));
		
		return dto;
	}

	@Override
	protected AddShoppingCartGoodsVOChecker getChecker() {

		return AddShoppingCartGoodsVOChecker.getInstance();
	}
}
