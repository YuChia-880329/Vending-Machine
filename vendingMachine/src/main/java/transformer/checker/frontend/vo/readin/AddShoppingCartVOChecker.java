package transformer.checker.frontend.vo.readin;

import bean.vo.frontend.readin.AddShoppingCartGoodsVO;
import bean.vo.frontend.readin.AddShoppingCartVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class AddShoppingCartVOChecker extends CheckerTemplate<AddShoppingCartVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, shopping cart form, ";
	
	private AddShoppingCartGoodsVOChecker fscGoodsRIVOChecker;
	
	
	private static final AddShoppingCartVOChecker INSTANCE = new AddShoppingCartVOChecker();
	
	private AddShoppingCartVOChecker() {
		
		fscGoodsRIVOChecker = AddShoppingCartGoodsVOChecker.getInstance();
	}
	
	public static AddShoppingCartVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(AddShoppingCartVO vo) throws CheckerException {

		checkVo(vo);
		
		checkCurrentUrl(vo);
		checkShoppingCartGoodsArray(vo);
	}
	
	private void checkVo(AddShoppingCartVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkCurrentUrl(AddShoppingCartVO vo) throws CheckerException {
		
		String currentUrl = vo.getCurrentUrl();
		
		CheckUtil.checkString(currentUrl, StringConcatUtil.concate(NAME_PREFIX, "currentUrl"));
	}
	private void checkShoppingCartGoodsArray(AddShoppingCartVO vo) throws CheckerException {
		
		AddShoppingCartGoodsVO[] shoppingCartGoodsArray = vo.getAddShoppingCartGoodsArray();

		CheckUtil.checkOther(shoppingCartGoodsArray, StringConcatUtil.concate(NAME_PREFIX, "goods"));
	
		for(int i=0; i<shoppingCartGoodsArray.length; i++) {
			
			fscGoodsRIVOChecker.check(shoppingCartGoodsArray[i]);
		}
	}
}
