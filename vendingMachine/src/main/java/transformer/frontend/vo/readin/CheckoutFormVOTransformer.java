package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.CheckoutFormVODTO;
import bean.vo.frontend.readin.CheckoutFormVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.frontend.vo.readin.CheckoutFormVOChecker;

public class CheckoutFormVOTransformer extends VOReanInTransformerTemplate<CheckoutFormVO, CheckoutFormVODTO, CheckerException, CheckoutFormVOChecker> {

	private static final CheckoutFormVOTransformer INSTANCE = new CheckoutFormVOTransformer();
	
	private CheckoutFormVOTransformer() {
	}
	
	public static CheckoutFormVOTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	@Override
	protected CheckoutFormVODTO voToDtoTransform(CheckoutFormVO vo) throws CheckerException {

		CheckoutFormVODTO dto = new CheckoutFormVODTO();
		
		dto.setPaidMoney(Integer.parseInt(vo.getPaidMoney()));
		
		return dto;
	}

	@Override
	protected CheckoutFormVOChecker getChecker() {

		return CheckoutFormVOChecker.getInstance();
	}

}
