package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.BoughtGoodsMsgVODTO;
import bean.vo.frontend.writeout.BoughtGoodsMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BoughtGoodsMsgVOTransformer extends VOWriteOutTransformerTemplate<BoughtGoodsMsgVODTO, BoughtGoodsMsgVO> {

	private static final BoughtGoodsMsgVOTransformer INSTANCE = new BoughtGoodsMsgVOTransformer();
	
	private BoughtGoodsMsgVOTransformer() {
	}
	
	public static BoughtGoodsMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected BoughtGoodsMsgVO dtoToVoTransform(BoughtGoodsMsgVODTO dto) {

		BoughtGoodsMsgVO vo = new BoughtGoodsMsgVO();
		
		vo.setName(dto.getName());
		vo.setPrice(String.valueOf(dto.getPrice()));
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		
		return vo;
	}
}
