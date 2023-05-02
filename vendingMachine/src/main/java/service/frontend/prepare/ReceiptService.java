package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.cache.receiptContent.BoughtGoodsMsgOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.ChangeMsgOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.PaidMoneyMsgOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.ReceiptContentOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.TotalPriceMsgOBJDTO;
import bean.dto.frontend.vo.writeout.BoughtGoodsMsgVODTO;
import bean.dto.frontend.vo.writeout.ChangeMsgVODTO;
import bean.dto.frontend.vo.writeout.PaidMoneyMsgVODTO;
import bean.dto.frontend.vo.writeout.ReceiptContentVODTO;
import bean.dto.frontend.vo.writeout.ReceiptVODTO;
import bean.dto.frontend.vo.writeout.TotalPriceMsgVODTO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;

public class ReceiptService {
	
	private static final ReceiptService INSTANCE = new ReceiptService();
	
	private ReceiptService() {
	}
	
	public static ReceiptService getInstance() {
		
		return INSTANCE;
	}
	
	public ReceiptVODTO prepare(ReceiptContentCacheDAO receiptContentCacheDAO) {
		
		ReceiptVODTO receiptVODTO = new ReceiptVODTO();
		
		List<ReceiptContentOBJDTO> receiptContentOBJDTOs = receiptContentCacheDAO.use(false);
		
		if(receiptContentOBJDTOs.size() > 0) {
			
			ReceiptContentOBJDTO receiptContentOBJDTO = receiptContentOBJDTOs.get(0);
			
			receiptVODTO.setHasReceipt(true);
			receiptVODTO.setReceiptContent(receiptContentOBJToReceiptContentVO(receiptContentOBJDTO));
		}else {
			
			receiptVODTO.setHasReceipt(false);
			receiptVODTO.setReceiptContent(null);
		}
		
		return receiptVODTO;
	}
	
	private ReceiptContentVODTO receiptContentOBJToReceiptContentVO(ReceiptContentOBJDTO receiptContentOBJDTO) {
		
		ReceiptContentVODTO receiptContentVODTO = new ReceiptContentVODTO();
		
		receiptContentVODTO.setPaidMoneyMsg(paidMoneyMsgOBJToPaidMoneyMsgVO(receiptContentOBJDTO.getPaidMoneyMsg()));
		receiptContentVODTO.setTotalPriceMsg(totalPriceMsgOBJToTotalPriceMsgVO(receiptContentOBJDTO.getTotalPriceMsg()));
		receiptContentVODTO.setChangeMsg(changeMsgOBJToChangeMsgVO(receiptContentOBJDTO.getChangeMsg()));
		receiptContentVODTO.setBoughtGoodsMsgs(boughtGoodsMsgOBJsToBoughtGoodsMsgVOs(receiptContentOBJDTO.getBoughtGoodsMsgs()));
		
		return receiptContentVODTO;
	}
	
	private PaidMoneyMsgVODTO paidMoneyMsgOBJToPaidMoneyMsgVO(PaidMoneyMsgOBJDTO paidMoneyMsgOBJDTO) {
		
		PaidMoneyMsgVODTO paidMoneyMsgVODTO = new PaidMoneyMsgVODTO();
		
		paidMoneyMsgVODTO.setPaidMoney(paidMoneyMsgOBJDTO.getPaidMoney());
		
		return paidMoneyMsgVODTO;
	}
	private TotalPriceMsgVODTO totalPriceMsgOBJToTotalPriceMsgVO(TotalPriceMsgOBJDTO totalPriceMsgOBJDTO) {
		
		TotalPriceMsgVODTO totalPriceMsgVODTO = new TotalPriceMsgVODTO();
		
		totalPriceMsgVODTO.setTotalPrice(totalPriceMsgOBJDTO.getTotalPrice());
		
		return totalPriceMsgVODTO;
	}
	private ChangeMsgVODTO changeMsgOBJToChangeMsgVO(ChangeMsgOBJDTO changeMsgOBJDTO) {
		
		ChangeMsgVODTO changeMsgVODTO = new ChangeMsgVODTO();
		
		changeMsgVODTO.setHasMsg(changeMsgOBJDTO.getHasMsg());
		changeMsgVODTO.setChange(changeMsgOBJDTO.getChange());
		
		return changeMsgVODTO;
	}
	private List<BoughtGoodsMsgVODTO> boughtGoodsMsgOBJsToBoughtGoodsMsgVOs(List<BoughtGoodsMsgOBJDTO> boughtGoodsMsgOBJDTOs) {
		
		return boughtGoodsMsgOBJDTOs.stream()
				.map(boughtGoodsMsgOBJDTO -> BoughtGoodsMsgOBJToBoughtGoodsMsgVO(boughtGoodsMsgOBJDTO))
				.collect(Collectors.toList());
	}
	private BoughtGoodsMsgVODTO BoughtGoodsMsgOBJToBoughtGoodsMsgVO(BoughtGoodsMsgOBJDTO boughtGoodsMsgOBJDTO) {
		
		BoughtGoodsMsgVODTO boughtGoodsMsgVODTO = new BoughtGoodsMsgVODTO();
		
		boughtGoodsMsgVODTO.setName(boughtGoodsMsgOBJDTO.getName());
		boughtGoodsMsgVODTO.setPrice(boughtGoodsMsgOBJDTO.getPrice());
		boughtGoodsMsgVODTO.setBuyQuantity(boughtGoodsMsgOBJDTO.getBuyQuantity());
		
		return boughtGoodsMsgVODTO;
	}
}
