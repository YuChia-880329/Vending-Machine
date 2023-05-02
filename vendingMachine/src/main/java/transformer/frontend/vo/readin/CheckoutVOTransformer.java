package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.CheckoutVODTO;
import bean.vo.frontend.readin.CheckoutVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.frontend.vo.readin.CheckoutVOChecker;

public class CheckoutVOTransformer extends VOReanInTransformerTemplate<CheckoutVO, CheckoutVODTO, CheckerException, CheckoutVOChecker> {

	private CheckoutFormVOTransformer checkoutFormVOTransformer;
	
	
	private static final CheckoutVOTransformer INSTANCE = new CheckoutVOTransformer();
	
	private CheckoutVOTransformer() {
		
		checkoutFormVOTransformer = CheckoutFormVOTransformer.getInstance();
	}
	
	public static CheckoutVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected CheckoutVODTO voToDtoTransform(CheckoutVO vo) throws CheckerException {
		
		CheckoutVODTO dto = new CheckoutVODTO();
		
		dto.setQueryString(vo.getQueryString());
		dto.setCheckoutForm(checkoutFormVOTransformer.voToDto(vo.getCheckoutForm()));
		
		return dto;
	}

	@Override
	protected CheckoutVOChecker getChecker() {
		
		return CheckoutVOChecker.getInstance();
	}
}
