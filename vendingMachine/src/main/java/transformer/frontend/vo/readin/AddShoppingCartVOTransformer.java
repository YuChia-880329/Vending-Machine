package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import bean.vo.frontend.readin.AddShoppingCartVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.frontend.vo.readin.AddShoppingCartVOChecker;

public class AddShoppingCartVOTransformer extends VOReanInTransformerTemplate<AddShoppingCartVO, AddShoppingCartVODTO, CheckerException, AddShoppingCartVOChecker>  {

	private AddShoppingCartGoodsVOTransformer fscGoodsRIVOTransformer;
	
	
	private static final AddShoppingCartVOTransformer INSTANCE = new AddShoppingCartVOTransformer();
	
	private AddShoppingCartVOTransformer() {
		
		fscGoodsRIVOTransformer = AddShoppingCartGoodsVOTransformer.getInstance();
	}
	
	public static AddShoppingCartVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartVODTO voToDtoTransform(AddShoppingCartVO vo) throws CheckerException {

		AddShoppingCartVODTO dto = new AddShoppingCartVODTO();
		
		dto.setAddShoppingCartGoodsList(fscGoodsRIVOTransformer.voArrayToDtoList(vo.getAddShoppingCartGoodsArray()));
		dto.setCurrentUrl(vo.getCurrentUrl());
		
		return dto;
	}

	@Override
	protected AddShoppingCartVOChecker getChecker() {

		return AddShoppingCartVOChecker.getInstance();
	}
}
