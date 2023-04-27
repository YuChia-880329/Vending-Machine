package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.UpdateShoppingCartResultVODTO;
import bean.vo.frontend.writeout.UpdateShoppingCartResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateShoppingCartResultVOTransformer extends VOWriteOutTransformerTemplate<UpdateShoppingCartResultVODTO, UpdateShoppingCartResultVO> {

	private static final UpdateShoppingCartResultVOTransformer INSTANCE = new UpdateShoppingCartResultVOTransformer();
	
	private UpdateShoppingCartResultVOTransformer() {
	}
	
	public static UpdateShoppingCartResultVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartResultVO dtoToVoTransform(UpdateShoppingCartResultVODTO dto) {
		
		UpdateShoppingCartResultVO vo = new UpdateShoppingCartResultVO();
		
		vo.setQueryString(dto.getQueryString());
		
		return vo;
	}
}
