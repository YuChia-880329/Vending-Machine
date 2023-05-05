package temp.transformer.checker.frontend.vo.readin;

import bean.vo.frontend.readin.UpdateShoppingCartGoodsVO;
import temp.bean.vo.frontend.readin.UpdateShoppingCartVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import transformer.checker.frontend.vo.readin.UpdateShoppingCartGoodsVOChecker;
import util.CheckUtil;
import util.StringConcatUtil;

public class UpdateShoppingCartVOChecker extends CheckerTemplate<UpdateShoppingCartVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, update shopping cart form, ";
	
	
	private UpdateShoppingCartGoodsVOChecker updateShoppingCartGoodsVOChecker;
	
	private static final UpdateShoppingCartVOChecker INSTANCE = new UpdateShoppingCartVOChecker();
	
	private UpdateShoppingCartVOChecker() {
		
		updateShoppingCartGoodsVOChecker = UpdateShoppingCartGoodsVOChecker.getInstance();
	}
	
	public static UpdateShoppingCartVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(UpdateShoppingCartVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkShoppingCartGoodsArray(vo);
	}

	private void checkVo(UpdateShoppingCartVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	

	private void checkShoppingCartGoodsArray(UpdateShoppingCartVO vo) throws CheckerException {
		
		UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray = vo.getUpdateShoppingCartGoodsArray();

		CheckUtil.checkOther(updateShoppingCartGoodsArray, StringConcatUtil.concate(NAME_PREFIX, "goods"));
	
		for(int i=0; i<updateShoppingCartGoodsArray.length; i++) {
			
			updateShoppingCartGoodsVOChecker.check(updateShoppingCartGoodsArray[i]);
		}
	}
}
