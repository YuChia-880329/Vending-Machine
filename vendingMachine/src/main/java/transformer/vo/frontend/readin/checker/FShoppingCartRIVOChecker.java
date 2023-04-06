package transformer.vo.frontend.readin.checker;

import java.util.List;

import bean.vo.frontend.readin.FSCGoodsRIVO;
import bean.vo.frontend.readin.FShoppingCartRIVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class FShoppingCartRIVOChecker extends CheckerTemplate<FShoppingCartRIVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, shopping cart form, ";
	
	private FSCGoodsRIVOChecker fscGoodsRIVOChecker;
	
	
	private static final FShoppingCartRIVOChecker INSTANCE = new FShoppingCartRIVOChecker();
	
	private FShoppingCartRIVOChecker() {
		
		fscGoodsRIVOChecker = FSCGoodsRIVOChecker.getInstance();
	}
	
	public static FShoppingCartRIVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(FShoppingCartRIVO vo) throws CheckerException {

		checkVo(vo);
		
		checkGoods(vo);
	}
	
	private void checkVo(FShoppingCartRIVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkGoods(FShoppingCartRIVO vo) throws CheckerException {
		
		List<FSCGoodsRIVO> goods = vo.getGoods();

		CheckUtil.checkOther(goods, StringConcatUtil.concate(NAME_PREFIX, "goods"));
	
		for(int i=0; i<goods.size(); i++) {
			
			fscGoodsRIVOChecker.check(goods.get(i));
		}
	}
}
