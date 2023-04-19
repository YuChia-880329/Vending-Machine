package transformer.frontend.vo.readin.checker;

import java.util.List;

import bean.vo.frontend.readin.ShoppingCartGoodsVO;
import bean.vo.frontend.readin.ShoppingCartVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class ShoppingCartVOChecker extends CheckerTemplate<ShoppingCartVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, shopping cart form, ";
	
	private ShoppingCartGoodsVOChecker fscGoodsRIVOChecker;
	
	
	private static final ShoppingCartVOChecker INSTANCE = new ShoppingCartVOChecker();
	
	private ShoppingCartVOChecker() {
		
		fscGoodsRIVOChecker = ShoppingCartGoodsVOChecker.getInstance();
	}
	
	public static ShoppingCartVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(ShoppingCartVO vo) throws CheckerException {

		checkVo(vo);
		
		checkGoods(vo);
	}
	
	private void checkVo(ShoppingCartVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkGoods(ShoppingCartVO vo) throws CheckerException {
		
		List<ShoppingCartGoodsVO> goods = vo.getShoppingCartGoodsList();

		CheckUtil.checkOther(goods, StringConcatUtil.concate(NAME_PREFIX, "goods"));
	
		for(int i=0; i<goods.size(); i++) {
			
			fscGoodsRIVOChecker.check(goods.get(i));
		}
	}
}
