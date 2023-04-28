package transformer.frontend.obj.cache.receiptContent;

import bean.dto.frontend.obj.cache.receiptContent.PaidMoneyMsgOBJDTO;
import bean.obj.frontend.cache.receiptContent.PaidMoneyMsgOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class PaidMoneyMsgOBJTransformer extends CacheTransformerTemplate<PaidMoneyMsgOBJ, PaidMoneyMsgOBJDTO> {

	private static final PaidMoneyMsgOBJTransformer INSTANCE = new PaidMoneyMsgOBJTransformer();
	
	private PaidMoneyMsgOBJTransformer() {
	}
	
	public static PaidMoneyMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected PaidMoneyMsgOBJDTO objToDtoTransform(PaidMoneyMsgOBJ obj) {
		
		PaidMoneyMsgOBJDTO dto = new PaidMoneyMsgOBJDTO();
		
		dto.setPaidMoney(obj.getPaidMoney());
		
		return dto;
	}

	@Override
	protected PaidMoneyMsgOBJ dtoToObjTransform(PaidMoneyMsgOBJDTO dto) {
		
		PaidMoneyMsgOBJ obj = new PaidMoneyMsgOBJ();
		
		obj.setPaidMoney(dto.getPaidMoney());
		
		return obj;
	}


}
