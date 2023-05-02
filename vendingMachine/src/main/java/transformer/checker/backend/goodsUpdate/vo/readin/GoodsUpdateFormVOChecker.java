package transformer.checker.backend.goodsUpdate.vo.readin;

import bean.vo.backend.goodsUpdate.readin.GoodsUpdateFormVO;
import enumeration.Status;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class GoodsUpdateFormVOChecker extends CheckerTemplate<GoodsUpdateFormVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods update, goods form, ";
	
	private static final GoodsUpdateFormVOChecker INSTANCE = new GoodsUpdateFormVOChecker();
	
	private GoodsUpdateFormVOChecker() {
	}
	
	public static GoodsUpdateFormVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(GoodsUpdateFormVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkId(vo);
		checkPrice(vo);
		checkAddQuantity(vo);
		checkStatus(vo);
	}
	
	private void checkVo(GoodsUpdateFormVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	private void checkId(GoodsUpdateFormVO vo) throws CheckerException {
		
		String id = vo.getId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(id, StringConcatUtil.concate(NAME_PREFIX, "id"));
	}
	private void checkPrice(GoodsUpdateFormVO vo) throws CheckerException {
		
		String price = vo.getPrice();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(price, StringConcatUtil.concate(NAME_PREFIX, "price"));
	}
	private void checkAddQuantity(GoodsUpdateFormVO vo) throws CheckerException {
		
		String addQuantity = vo.getAddQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(addQuantity, StringConcatUtil.concate(NAME_PREFIX, "addQuantity"));
	}
	private void checkStatus(GoodsUpdateFormVO vo) throws CheckerException {
		
		String status = vo.getStatus();
		
		CheckUtil.checkStringWithOptions(status, StringConcatUtil.concate(NAME_PREFIX, "status"), new String[] {String.valueOf(Status.ON.getValue()), String.valueOf(Status.OFF.getValue())});
	}
	
}
