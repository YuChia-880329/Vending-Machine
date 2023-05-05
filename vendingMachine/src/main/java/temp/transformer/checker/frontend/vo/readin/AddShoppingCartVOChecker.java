package temp.transformer.checker.frontend.vo.readin;

import bean.vo.frontend.readin.AddShoppingCartGoodsVO;
import temp.bean.vo.frontend.readin.AddShoppingCartVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import transformer.checker.frontend.vo.readin.AddShoppingCartGoodsVOChecker;
import util.CheckUtil;
import util.StringConcatUtil;

public class AddShoppingCartVOChecker extends CheckerTemplate<AddShoppingCartVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, shopping cart form, ";
	
	private AddShoppingCartGoodsVOChecker addShoppingCartGoodsVOChecker;
	
	
	private static final AddShoppingCartVOChecker INSTANCE = new AddShoppingCartVOChecker();
	
	private AddShoppingCartVOChecker() {
		
		addShoppingCartGoodsVOChecker = AddShoppingCartGoodsVOChecker.getInstance();
	}
	
	public static AddShoppingCartVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(AddShoppingCartVO vo) throws CheckerException {

		checkVo(vo);
		
		checkShoppingCartGoodsArray(vo);
	}
	
	private void checkVo(AddShoppingCartVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkShoppingCartGoodsArray(AddShoppingCartVO vo) throws CheckerException {
		
		AddShoppingCartGoodsVO[] shoppingCartGoodsArray = vo.getAddShoppingCartGoodsArray();

		CheckUtil.checkOther(shoppingCartGoodsArray, StringConcatUtil.concate(NAME_PREFIX, "goods"));
	
		for(int i=0; i<shoppingCartGoodsArray.length; i++) {
			
			addShoppingCartGoodsVOChecker.check(shoppingCartGoodsArray[i]);
		}
	}
}
