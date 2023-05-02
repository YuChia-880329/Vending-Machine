package transformer.virtualMachine.obj.memoryDAOKitVM;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import bean.obj.virtualMachine.memoryDAOKitVM.AccountOBJ;
import template.transformer.bean.obj.OBJTransformerTemplate;

public class AccountOBJTransformer extends OBJTransformerTemplate<AccountOBJ, AccountOBJDTO> {

	private static final AccountOBJTransformer INSTANCE = new AccountOBJTransformer();
	
	private AccountOBJTransformer() {
	}
	
	public static AccountOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AccountOBJDTO objToDtoTransform(AccountOBJ obj) {
		
		AccountOBJDTO dto = new AccountOBJDTO();
		
		dto.setAccount(obj.getAccount());
		
		return dto;
	}

	@Override
	protected AccountOBJ dtoToObjTransform(AccountOBJDTO dto) {
		
		AccountOBJ obj = new AccountOBJ();
		
		obj.setAccount(dto.getAccount());
		
		return obj;
	}
}
