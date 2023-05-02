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
		
		dto.setAddShoppingCartIllegalMsgLineCacheDAO(obj.getAddShoppingCartIllegalMsgLineCacheDAO());
		dto.setAddShoppingCartMsgLineCacheDAO(obj.getAddShoppingCartMsgLineCacheDAO());
		dto.setReceiptContentCacheDAO(obj.getReceiptContentCacheDAO());
		dto.setUpdateShoppingCartIllegalMsgLineCacheDAO(obj.getUpdateShoppingCartIllegalMsgLineCacheDAO());
		dto.setUpdateShoppingCartMsgLineCacheDAO(obj.getUpdateShoppingCartMsgLineCacheDAO());
		dto.setShoppingCartMemoryDbDAO(obj.getShoppingCartMemoryDbDAO());
		dto.setGoodsTablePagesRepositoryDAO(obj.getGoodsTablePagesRepositoryDAO());
		dto.setOrderTablePagesRepositoryDAO(obj.getOrderTablePagesRepositoryDAO());
		dto.setFrontendGoodsTablePagesRepositoryDAO(obj.getFrontendGoodsTablePagesRepositoryDAO());
		dto.setCheckoutMoneyIllegalMsgStatusCacheDAO(obj.getCheckoutMoneyIllegalMsgStatusCacheDAO());
		dto.setClearShoppingCartMsgStatusCacheDAO(obj.getClearShoppingCartMsgStatusCacheDAO());
		
		return dto;
	}

	@Override
	protected MemoryDAOKitOBJ dtoToObjTransform(MemoryDAOKitOBJDTO dto) {
		
		MemoryDAOKitOBJ obj = new MemoryDAOKitOBJ();
		
		obj.setAddShoppingCartIllegalMsgLineCacheDAO(dto.getAddShoppingCartIllegalMsgLineCacheDAO());
		obj.setAddShoppingCartMsgLineCacheDAO(dto.getAddShoppingCartMsgLineCacheDAO());
		obj.setReceiptContentCacheDAO(dto.getReceiptContentCacheDAO());
		obj.setUpdateShoppingCartIllegalMsgLineCacheDAO(dto.getUpdateShoppingCartIllegalMsgLineCacheDAO());
		obj.setUpdateShoppingCartMsgLineCacheDAO(dto.getUpdateShoppingCartMsgLineCacheDAO());
		obj.setShoppingCartMemoryDbDAO(dto.getShoppingCartMemoryDbDAO());
		obj.setGoodsTablePagesRepositoryDAO(dto.getGoodsTablePagesRepositoryDAO());
		obj.setOrderTablePagesRepositoryDAO(dto.getOrderTablePagesRepositoryDAO());
		obj.setFrontendGoodsTablePagesRepositoryDAO(dto.getFrontendGoodsTablePagesRepositoryDAO());
		obj.setCheckoutMoneyIllegalMsgStatusCacheDAO(dto.getCheckoutMoneyIllegalMsgStatusCacheDAO());
		obj.setClearShoppingCartMsgStatusCacheDAO(dto.getClearShoppingCartMsgStatusCacheDAO());
		
		return obj;
	}


}
