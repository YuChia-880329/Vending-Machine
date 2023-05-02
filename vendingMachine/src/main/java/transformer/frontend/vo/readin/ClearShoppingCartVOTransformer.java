package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.ClearShoppingCartVODTO;
import bean.vo.frontend.readin.ClearShoppingCartVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.frontend.vo.readin.ClearShoppingCartVOChecker;

public class ClearShoppingCartVOTransformer extends VOReanInTransformerTemplate<ClearShoppingCartVO, ClearShoppingCartVODTO, CheckerException, ClearShoppingCartVOChecker> {

	private static final ClearShoppingCartVOTransformer INSTANCE = new ClearShoppingCartVOTransformer();
	
	private ClearShoppingCartVOTransformer() {
	}
	
	public static ClearShoppingCartVOTransformer getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	protected ClearShoppingCartVODTO voToDtoTransform(ClearShoppingCartVO vo) throws CheckerException {

		ClearShoppingCartVODTO dto = new ClearShoppingCartVODTO();
		
		dto.setQueryString(vo.getQueryString());
		
		return dto;
	}

	@Override
	protected ClearShoppingCartVOChecker getChecker() {
		
		return ClearShoppingCartVOChecker.getInstance();
	}

}
