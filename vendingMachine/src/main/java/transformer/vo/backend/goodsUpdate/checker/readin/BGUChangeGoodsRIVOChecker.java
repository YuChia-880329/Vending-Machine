package transformer.vo.backend.goodsUpdate.checker.readin;

import bean.vo.backend.goodsUpdate.readin.BGUChangeGoodsRIVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class BGUChangeGoodsRIVOChecker extends CheckerTemplate<BGUChangeGoodsRIVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods update, change goods selection, ";
	
	private static final BGUChangeGoodsRIVOChecker INSTANCE = new BGUChangeGoodsRIVOChecker();
	
	private BGUChangeGoodsRIVOChecker() {
	}
	
	public static BGUChangeGoodsRIVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(BGUChangeGoodsRIVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkId(vo);
	}
	
	private void checkVo(BGUChangeGoodsRIVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	private void checkId(BGUChangeGoodsRIVO vo) throws CheckerException {
		
		String id = vo.getId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(id, StringConcatUtil.concate(NAME_PREFIX, "id"));
	}
}
