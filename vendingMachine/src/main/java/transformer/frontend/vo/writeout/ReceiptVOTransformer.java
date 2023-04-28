package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.ReceiptVODTO;
import bean.vo.frontend.writeout.ReceiptVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class ReceiptVOTransformer extends VOWriteOutTransformerTemplate<ReceiptVODTO, ReceiptVO> {

	private ReceiptContentVOTransformer receiptContentVOTransformer;
	
	
	private static final ReceiptVOTransformer INSTANCE = new ReceiptVOTransformer();
	
	private ReceiptVOTransformer() {
		
		receiptContentVOTransformer = ReceiptContentVOTransformer.getInstance();
	}
	
	public static ReceiptVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ReceiptVO dtoToVoTransform(ReceiptVODTO dto) {
		
		ReceiptVO vo = new ReceiptVO();
		
		vo.setHasReceipt(dto.getHasReceipt().getDescription());
		vo.setReceiptContent(receiptContentVOTransformer.dtoToVo(dto.getReceiptContent()));
		
		return vo;
	}
}
