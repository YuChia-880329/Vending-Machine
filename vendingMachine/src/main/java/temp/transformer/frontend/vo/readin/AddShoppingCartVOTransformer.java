package temp.transformer.frontend.vo.readin;

import temp.bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import temp.bean.vo.frontend.readin.AddShoppingCartVO;
import temp.transformer.checker.frontend.vo.readin.AddShoppingCartVOChecker;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.frontend.vo.readin.AddShoppingCartGoodsVOTransformer;

public class AddShoppingCartVOTransformer extends VOReanInTransformerTemplate<AddShoppingCartVO, AddShoppingCartVODTO, CheckerException, AddShoppingCartVOChecker>  {

	private AddShoppingCartGoodsVOTransformer addShoppingCartGoodsVOTransformer;
	
	
	private static final AddShoppingCartVOTransformer INSTANCE = new AddShoppingCartVOTransformer();
	
	private AddShoppingCartVOTransformer() {
		
		addShoppingCartGoodsVOTransformer = AddShoppingCartGoodsVOTransformer.getInstance();
	}
	
	public static AddShoppingCartVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartVODTO voToDtoTransform(AddShoppingCartVO vo) throws CheckerException {

		AddShoppingCartVODTO dto = new AddShoppingCartVODTO();
		
		dto.setAddShoppingCartGoodsList(addShoppingCartGoodsVOTransformer.voArrayToDtoList(vo.getAddShoppingCartGoodsArray()));
		
		return dto;
	}

	@Override
	protected AddShoppingCartVOChecker getChecker() {

		return AddShoppingCartVOChecker.getInstance();
	}
}
