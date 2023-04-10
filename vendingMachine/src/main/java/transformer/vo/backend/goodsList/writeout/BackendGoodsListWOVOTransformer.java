package transformer.vo.backend.goodsList.writeout;

import bean.dto.vo.backend.goodsList.writeout.BackendGoodsListWOVODTO;
import bean.vo.backend.goodsList.writeout.BackendGoodsListWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackendGoodsListWOVOTransformer extends VOWriteOutTransformerTemplate<BackendGoodsListWOVODTO, BackendGoodsListWOVO> {

	private BGLGoodsTablePageWOVOTransformer bglGoodsTablePageWOVOTransformer;
	
	private static final BackendGoodsListWOVOTransformer INSTANCE = new BackendGoodsListWOVOTransformer();
	
	private BackendGoodsListWOVOTransformer() {
		
		bglGoodsTablePageWOVOTransformer = BGLGoodsTablePageWOVOTransformer.getInstance();
	}
	
	public static BackendGoodsListWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BackendGoodsListWOVO dtoToVo(BackendGoodsListWOVODTO dto) {
		
		BackendGoodsListWOVO vo = new BackendGoodsListWOVO();
		
		vo.setGoodsTablePage(bglGoodsTablePageWOVOTransformer.dtoToVo(dto.getGoodsTablePage()));
		
		return vo;
	}
}
