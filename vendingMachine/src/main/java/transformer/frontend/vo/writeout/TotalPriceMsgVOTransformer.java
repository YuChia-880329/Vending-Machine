package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.TotalPriceMsgVODTO;
import bean.vo.frontend.writeout.TotalPriceMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class TotalPriceMsgVOTransformer extends VOWriteOutTransformerTemplate<TotalPriceMsgVODTO, TotalPriceMsgVO> {

	private static final TotalPriceMsgVOTransformer INSTANCE = new TotalPriceMsgVOTransformer();
	
	private TotalPriceMsgVOTransformer() {
	}
	
	public static TotalPriceMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected TotalPriceMsgVO dtoToVoTransform(TotalPriceMsgVODTO dto) {

		TotalPriceMsgVO vo = new TotalPriceMsgVO();
		
		vo.setTotalPrice(String.valueOf(dto.getTotalPrice()));
		
		return vo;
	}
	
	
}
