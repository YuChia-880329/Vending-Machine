package transformer.vo.frontend.readin;

import bean.dto.vo.frontend.readin.FCheckoutRIVODTO;
import bean.vo.frontend.readin.FCheckoutRIVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.frontend.checker.readin.FCheckoutRIVOChecker;

public class FCheckoutRIVOTransformer extends VOReanInTransformerTemplate<FCheckoutRIVO, FCheckoutRIVODTO, CheckerException, FCheckoutRIVOChecker> {

	private static final FCheckoutRIVOTransformer INSTANCE = new FCheckoutRIVOTransformer();
	
	private FCheckoutRIVOTransformer() {
	}
	
	public static FCheckoutRIVOTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	@Override
	public FCheckoutRIVODTO voToDto(FCheckoutRIVO vo) throws CheckerException {

		FCheckoutRIVODTO dto = new FCheckoutRIVODTO();
		
		dto.setPaidMoney(Integer.parseInt(vo.getPaidMoney()));
		
		return dto;
	}

	@Override
	protected FCheckoutRIVOChecker getChecker() {

		return FCheckoutRIVOChecker.getInstance();
	}

}
