package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.ClearShoppingCartResultVODTO;
import bean.vo.frontend.writeout.ClearShoppingCartResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class ClearShoppingCartResultVOTransformer extends VOWriteOutTransformerTemplate<ClearShoppingCartResultVODTO, ClearShoppingCartResultVO> {

	private static final ClearShoppingCartResultVOTransformer INSTANCE = new ClearShoppingCartResultVOTransformer();
	
	private ClearShoppingCartResultVOTransformer() {
	}
	
	public static ClearShoppingCartResultVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ClearShoppingCartResultVO dtoToVoTransform(ClearShoppingCartResultVODTO dto) {
		
		ClearShoppingCartResultVO vo = new ClearShoppingCartResultVO();
		
		vo.setQueryString(dto.getQueryString());
		
		return vo;
	}
}
