package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.vo.frontend.readin.AddShoppingCartGoodsVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.frontend.vo.readin.AddShoppingCartGoodsVOChecker;

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
		dto.setName(vo.getName());
		dto.setAddQuantity(Integer.parseInt(vo.getAddQuantity()));
		dto.setQuantity(Integer.parseInt(vo.getQuantity()));
		
		return dto;
	}

	@Override
	protected AddShoppingCartGoodsVOChecker getChecker() {

		return AddShoppingCartGoodsVOChecker.getInstance();
	}
}
