package transformer.virtualMachine.obj.memoryDAOKitVM;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.MemoryDAOKitOBJDTO;
import bean.obj.virtualMachine.memoryDAOKitVM.MemoryDAOKitOBJ;
import template.transformer.bean.obj.OBJTransformerTemplate;

public class MemoryDAOKitOBJTransformer extends OBJTransformerTemplate<MemoryDAOKitOBJ, MemoryDAOKitOBJDTO> {

	private static final MemoryDAOKitOBJTransformer INSTANCE = new MemoryDAOKitOBJTransformer();
	
	private MemoryDAOKitOBJTransformer() {
	}
	
	public static MemoryDAOKitOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	protected MemoryDAOKitOBJDTO objToDtoTransform(MemoryDAOKitOBJ obj) {
		
		MemoryDAOKitOBJDTO dto = new MemoryDAOKitOBJDTO();
		
		dto.setReceiptContentCacheDAO(obj.getReceiptContentCacheDAO());
		dto.setShoppingCartMemoryDbDAO(obj.getShoppingCartMemoryDbDAO());
		dto.setGoodsTablePagesRepositoryDAO(obj.getGoodsTablePagesRepositoryDAO());
		dto.setOrderTablePagesRepositoryDAO(obj.getOrderTablePagesRepositoryDAO());
		dto.setFrontendGoodsTablePagesRepositoryDAO(obj.getFrontendGoodsTablePagesRepositoryDAO());
		dto.setCurrentMemberStatusCacheDAO(obj.getCurrentMemberStatusCacheDAO());
		dto.setNotLoginMsgStatusCacheDAO(obj.getNotLoginMsgStatusCacheDAO());
		dto.setCheckoutMoneyIllegalMsgStatusCacheDAO(obj.getCheckoutMoneyIllegalMsgStatusCacheDAO());
		
		return dto;
	}

	@Override
	protected MemoryDAOKitOBJ dtoToObjTransform(MemoryDAOKitOBJDTO dto) {
		
		MemoryDAOKitOBJ obj = new MemoryDAOKitOBJ();
		
		obj.setReceiptContentCacheDAO(dto.getReceiptContentCacheDAO());
		obj.setShoppingCartMemoryDbDAO(dto.getShoppingCartMemoryDbDAO());
		obj.setGoodsTablePagesRepositoryDAO(dto.getGoodsTablePagesRepositoryDAO());
		obj.setOrderTablePagesRepositoryDAO(dto.getOrderTablePagesRepositoryDAO());
		obj.setFrontendGoodsTablePagesRepositoryDAO(dto.getFrontendGoodsTablePagesRepositoryDAO());
		obj.setCurrentMemberStatusCacheDAO(dto.getCurrentMemberStatusCacheDAO());
		obj.setNotLoginMsgStatusCacheDAO(dto.getNotLoginMsgStatusCacheDAO());
		
		return obj;
	}


}
