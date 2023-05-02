package transformer.checker.backend.goodsCreate.vo.readin;

import javax.servlet.http.Part;

import bean.vo.backend.goodsCreate.readin.CreateFormVO;
import enumeration.Status;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class CreateFormVOChecker extends CheckerTemplate<CreateFormVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods create, create form, ";
	
	private static final CreateFormVOChecker INSTANCE = new CreateFormVOChecker();
	
	private CreateFormVOChecker() {
	}
	
	public static CreateFormVOChecker getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	public void check(CreateFormVO vo) throws CheckerException {
		
		checkVO(vo);
		
		checkName(vo);
		checkPrice(vo);
		checkQuantity(vo);
		checkImageName(vo);
		checkImagePart(vo);
		checkStatus(vo);
	}
	
	public void checkVO(CreateFormVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}

	public void checkName(CreateFormVO vo) throws CheckerException {
		
		String name = vo.getName();
		
		CheckUtil.checkString(name, StringConcatUtil.concate(NAME_PREFIX, "name"));
	}
	public void checkPrice(CreateFormVO vo) throws CheckerException {
		
		String price = vo.getPrice();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(price, StringConcatUtil.concate(NAME_PREFIX, "price"));
	}
	public void checkQuantity(CreateFormVO vo) throws CheckerException {
		
		String quantity = vo.getQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantity, StringConcatUtil.concate(NAME_PREFIX, "quantity"));
	}
	public void checkImageName(CreateFormVO vo) throws CheckerException {
		
		String imageName = vo.getImageName();
		
		CheckUtil.checkString(imageName, StringConcatUtil.concate(NAME_PREFIX, "imageName"));
	}
	public void checkImagePart(CreateFormVO vo) throws CheckerException {
		
		Part imagePart = vo.getImagePart();
		
		CheckUtil.checkOther(imagePart, StringConcatUtil.concate(NAME_PREFIX, "imagePart"));
	}
	public void checkStatus(CreateFormVO vo) throws CheckerException {
		
		String status = vo.getStatus();
		
		CheckUtil.checkStringWithOptions(status, StringConcatUtil.concate(NAME_PREFIX, "status"), new String[] {String.valueOf(Status.ON.getValue()), String.valueOf(Status.OFF.getValue())});
	}
}
