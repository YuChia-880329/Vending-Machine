package transformer.vo.backend.goodsCreate.readin.checker;

import javax.servlet.http.Part;

import bean.vo.backend.goodsCreate.readin.BGCCreateFormRIVO;
import enumeration.Status;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class BGCCreateFormRIVOChecker extends CheckerTemplate<BGCCreateFormRIVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods create, create form, ";
	
	private static final BGCCreateFormRIVOChecker INSTANCE = new BGCCreateFormRIVOChecker();
	
	private BGCCreateFormRIVOChecker() {
	}
	
	public static BGCCreateFormRIVOChecker getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	public void check(BGCCreateFormRIVO vo) throws CheckerException {
		
		checkVO(vo);
		
		checkName(vo);
		checkPrice(vo);
		checkQuantity(vo);
		checkImageName(vo);
		checkImagePart(vo);
		checkStatus(vo);
	}
	
	public void checkVO(BGCCreateFormRIVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}

	public void checkName(BGCCreateFormRIVO vo) throws CheckerException {
		
		String name = vo.getName();
		
		CheckUtil.checkString(name, StringConcatUtil.concate(NAME_PREFIX, "name"));
	}
	public void checkPrice(BGCCreateFormRIVO vo) throws CheckerException {
		
		String price = vo.getPrice();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(price, StringConcatUtil.concate(NAME_PREFIX, "price"));
	}
	public void checkQuantity(BGCCreateFormRIVO vo) throws CheckerException {
		
		String quantity = vo.getQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantity, StringConcatUtil.concate(NAME_PREFIX, "quantity"));
	}
	public void checkImageName(BGCCreateFormRIVO vo) throws CheckerException {
		
		String imageName = vo.getImageName();
		
		CheckUtil.checkString(imageName, StringConcatUtil.concate(NAME_PREFIX, "imageName"));
	}
	public void checkImagePart(BGCCreateFormRIVO vo) throws CheckerException {
		
		Part imagePart = vo.getImagePart();
		
		CheckUtil.checkOther(imagePart, StringConcatUtil.concate(NAME_PREFIX, "imagePart"));
	}
	public void checkStatus(BGCCreateFormRIVO vo) throws CheckerException {
		
		String status = vo.getStatus();
		
		CheckUtil.checkStringWithOptions(status, StringConcatUtil.concate(NAME_PREFIX, "status"), new String[] {Status.ON.getDescription(), Status.OFF.getDescription()});
	}
}
