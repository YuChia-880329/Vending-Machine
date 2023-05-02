package virtualMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import bean.obj.virtualMachine.memoryDAOKitVM.AccountOBJ;
import bean.obj.virtualMachine.memoryDAOKitVM.MemoryDAOKitOBJ;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;

public class MemoryDAOKitVM {
	
	
	private Map<AccountOBJ, MemoryDAOKitOBJ> memoryDAOKitMap;

	
	private static final MemoryDAOKitVM INSTANCE = new MemoryDAOKitVM();
	
	private MemoryDAOKitVM() {
		
		memoryDAOKitMap = new HashMap<>();
	}
	
	public static MemoryDAOKitVM getInstance() {
		
		return INSTANCE;
	}
	
	
	public MemoryDAOKitOBJ getMemoryDAOKit(AccountOBJ account) {
		
		return memoryDAOKitMap.get(account);
	}
	
	public void setMemoryDAOKit(AccountOBJ account, MemoryDAOKitOBJ memoryDAOKit) {
		
		memoryDAOKitMap.put(account, memoryDAOKit);
	}
	
	
	public void requireUpdateGoodsTablePagesRepositoryDAO() {
		
		requireUpdate(memoryDAOKit -> {
			
			GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = memoryDAOKit.getGoodsTablePagesRepositoryDAO();
			
			if(goodsTablePagesRepositoryDAO != null)
				goodsTablePagesRepositoryDAO.requireUpdate();
		});
	}
	public void requireUpdateOrderTablePagesRepositoryDAO() {
		
		requireUpdate(memoryDAOKit -> {
			
			OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO = memoryDAOKit.getOrderTablePagesRepositoryDAO();
			
			if(orderTablePagesRepositoryDAO != null)
				orderTablePagesRepositoryDAO.requireUpdate();
		});
	}
	public void requireUpdateFrontendGoodsTablePagesRepositoryDAO() {
		
		requireUpdate(memoryDAOKit -> {
			
			dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO = memoryDAOKit.getFrontendGoodsTablePagesRepositoryDAO();
			
			if(frontendGoodsTablePagesRepositoryDAO != null)
				frontendGoodsTablePagesRepositoryDAO.requireUpdate();
		});
	}
	
	
	private void requireUpdate(Consumer<MemoryDAOKitOBJ> updateConsumer) {
		
		for(AccountOBJ account : memoryDAOKitMap.keySet()) {
			
			MemoryDAOKitOBJ memoryDAOKit = memoryDAOKitMap.get(account);
			
			updateConsumer.accept(memoryDAOKit);
		}
	}
}
