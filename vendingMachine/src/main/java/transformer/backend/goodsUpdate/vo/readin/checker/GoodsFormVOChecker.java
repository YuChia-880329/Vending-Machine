package transformer.backend.goodsUpdate.vo.readin.checker;

import bean.vo.backend.goodsUpdate.readin.GoodsFormVO;
import enumeration.Status;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class GoodsFormVOChecker extends CheckerTemplate<GoodsFormVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods update, goods form, ";
	
	private static final GoodsFormVOChecker INSTANCE = new GoodsFormVOChecker();
	
	private GoodsFormVOChecker() {
	}
	
	public static GoodsFormVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(GoodsFormVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkId(vo);
		checkPrice(vo);
		checkAddQuantity(vo);
		checkStatus(vo);
	}
	
	private void checkVo(GoodsFormVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	private void checkId(GoodsFormVO vo) throws CheckerException {
		
		String id = vo.getId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(id, StringConcatUtil.concate(NAME_PREFIX, "id"));
	}
	private void checkPrice(GoodsFormVO vo) throws CheckerException {
		
		String price = vo.getPrice();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(price, StringConcatUtil.concate(NAME_PREFIX, "price"));
	}
	private void checkAddQuantity(GoodsFormVO vo) throws CheckerException {
		
		String addQuantity = vo.getAddQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(addQuantity, StringConcatUtil.concate(NAME_PREFIX, "addQuantity"));
	}
	private void checkStatus(GoodsFormVO vo) throws CheckerException {
		
		String status = vo.getStatus();
		
		CheckUtil.checkStringWithOptions(status, StringConcatUtil.concate(NAME_PREFIX, "status"), new String[] {Status.ON.getDescription(), Status.OFF.getDescription()});
	}
	
}
