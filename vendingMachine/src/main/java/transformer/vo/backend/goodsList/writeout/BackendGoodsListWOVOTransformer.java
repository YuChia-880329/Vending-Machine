package transformer.vo.backend.goodsList.writeout;

import bean.dto.vo.backend.goodsList.writeout.BackendGoodsListWOVODTO;
import bean.vo.backend.goodsList.writeout.BackendGoodsListWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.vo.writeout.PaginationWOVOTransformer;

public class BackendGoodsListWOVOTransformer extends VOWriteOutTransformerTemplate<BackendGoodsListWOVODTO, BackendGoodsListWOVO> {

	private BGLGoodsTableWOVOTransformer bglGoodsTableWOVOTransformer;
	private PaginationWOVOTransformer paginationWOVOTransformer;
	
	
	private static final BackendGoodsListWOVOTransformer INSTANCE = new BackendGoodsListWOVOTransformer();
	
	private BackendGoodsListWOVOTransformer() {
		
		bglGoodsTableWOVOTransformer = BGLGoodsTableWOVOTransformer.getInstance();
		paginationWOVOTransformer = PaginationWOVOTransformer.getInstance();
	}
	
	public static BackendGoodsListWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BackendGoodsListWOVO dtoToVo(BackendGoodsListWOVODTO dto) {

		BackendGoodsListWOVO vo = new BackendGoodsListWOVO();
		
		vo.setGoodsTable(bglGoodsTableWOVOTransformer.dtoToVo(dto.getGoodsTable()));
		vo.setPagination(paginationWOVOTransformer.dtoToVo(dto.getPagination()));
		
		return vo;
	}
}
