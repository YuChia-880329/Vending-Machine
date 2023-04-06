package transformer.vo.backend.goodsUpdate.readin.checker;

import bean.vo.backend.goodsUpdate.readin.BGUGoodsFormRIVO;
import enumeration.Status;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class BGUGoodsFormRIVOChecker extends CheckerTemplate<BGUGoodsFormRIVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods update, goods form, ";
	
	private static final BGUGoodsFormRIVOChecker INSTANCE = new BGUGoodsFormRIVOChecker();
	
	private BGUGoodsFormRIVOChecker() {
	}
	
	public static BGUGoodsFormRIVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(BGUGoodsFormRIVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkId(vo);
		checkPrice(vo);
		checkAddQuantity(vo);
		checkStatus(vo);
	}
	
	private void checkVo(BGUGoodsFormRIVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	private void checkId(BGUGoodsFormRIVO vo) throws CheckerException {
		
		String id = vo.getId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(id, StringConcatUtil.concate(NAME_PREFIX, "id"));
	}
	private void checkPrice(BGUGoodsFormRIVO vo) throws CheckerException {
		
		String price = vo.getPrice();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(price, StringConcatUtil.concate(NAME_PREFIX, "price"));
	}
	private void checkAddQuantity(BGUGoodsFormRIVO vo) throws CheckerException {
		
		String addQuantity = vo.getAddQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(addQuantity, StringConcatUtil.concate(NAME_PREFIX, "addQuantity"));
	}
	private void checkStatus(BGUGoodsFormRIVO vo) throws CheckerException {
		
		String status = vo.getStatus();
		
		CheckUtil.checkStringWithOptions(status, StringConcatUtil.concate(NAME_PREFIX, "status"), new String[] {Status.ON.getDescription(), Status.OFF.getDescription()});
	}
	
}
