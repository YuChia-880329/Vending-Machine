package transformer.checker.backend.goodsUpdate.vo.readin;

import bean.vo.backend.goodsUpdate.readin.ChangeGoodsVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class ChangeGoodsVOChecker extends CheckerTemplate<ChangeGoodsVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods update, change goods selection, ";
	
	private static final ChangeGoodsVOChecker INSTANCE = new ChangeGoodsVOChecker();
	
	private ChangeGoodsVOChecker() {
	}
	
	public static ChangeGoodsVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(ChangeGoodsVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkId(vo);
	}
	
	private void checkVo(ChangeGoodsVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	private void checkId(ChangeGoodsVO vo) throws CheckerException {
		
		String id = vo.getId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(id, StringConcatUtil.concate(NAME_PREFIX, "id"));
	}
}
