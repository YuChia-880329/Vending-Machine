package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.AddShoppingCartResultVODTO;
import bean.vo.frontend.writeout.AddShoppingCartResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class AddShoppingCartResultVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartResultVODTO, AddShoppingCartResultVO> {

	private static final AddShoppingCartResultVOTransformer INSTANCE = new AddShoppingCartResultVOTransformer();
	
	private AddShoppingCartResultVOTransformer() {
	}
	
	public static AddShoppingCartResultVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartResultVO dtoToVoTransform(AddShoppingCartResultVODTO dto) {
		
		AddShoppingCartResultVO vo = new AddShoppingCartResultVO();
		
		vo.setQueryString(dto.getQueryString());
		
		return vo;
	}
}
