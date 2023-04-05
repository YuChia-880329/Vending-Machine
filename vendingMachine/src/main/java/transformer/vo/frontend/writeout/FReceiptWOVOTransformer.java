package transformer.vo.frontend.writeout;

import bean.dto.vo.frontend.writeout.FReceiptWOVODTO;
import bean.vo.frontend.writeout.FReceiptWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FReceiptWOVOTransformer extends VOWriteOutTransformerTemplate<FReceiptWOVODTO, FReceiptWOVO> {

	private FRBoughtGoodsWOVOTransformer frBoughtGoodsWOVOTransformer;
	
	
	private static final FReceiptWOVOTransformer INSTANCE = new FReceiptWOVOTransformer();
	
	private FReceiptWOVOTransformer() {
		
		frBoughtGoodsWOVOTransformer = FRBoughtGoodsWOVOTransformer.getInstance();
	}
	
	public static FReceiptWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FReceiptWOVO dtoToVo(FReceiptWOVODTO dto) {

		FReceiptWOVO vo = new FReceiptWOVO();
		
		vo.setHasReceipt(dto.getHasReceipt().getDescription());
		vo.setPaidMoney(String.valueOf(dto.getPaidMoney()));
		vo.setTotalPrice(String.valueOf(dto.getPaidMoney()));
		vo.setChange(String.valueOf(dto.getPaidMoney()));
		vo.setBoughtGoods(frBoughtGoodsWOVOTransformer.dtoListToVoList(dto.getBoughtGoods()));
		
		return vo;
	}
}
