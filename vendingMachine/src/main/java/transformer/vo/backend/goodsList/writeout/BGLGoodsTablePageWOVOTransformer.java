package transformer.vo.backend.goodsList.writeout;

import bean.dto.vo.backend.goodsList.writeout.BGLGoodsTablePageWOVODTO;
import bean.vo.backend.goodsList.writeout.BGLGoodsTablePageWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.vo.backend.goodsList.BGLSearchParameterVOTransformer;
import transformer.vo.writeout.PaginationWOVOTransformer;

public class BGLGoodsTablePageWOVOTransformer extends VOWriteOutTransformerTemplate<BGLGoodsTablePageWOVODTO, BGLGoodsTablePageWOVO> {

	private BGLGoodsTableWOVOTransformer bglGoodsTableWOVOTransformer;
	private BGLSearchParameterVOTransformer bglSearchParameterVOTransformer;
	private PaginationWOVOTransformer paginationWOVOTransformer;
	
	
	private static final BGLGoodsTablePageWOVOTransformer INSTANCE = new BGLGoodsTablePageWOVOTransformer();
	
	private BGLGoodsTablePageWOVOTransformer() {
		
		bglGoodsTableWOVOTransformer = BGLGoodsTableWOVOTransformer.getInstance();
		bglSearchParameterVOTransformer = BGLSearchParameterVOTransformer.getInstance();
		paginationWOVOTransformer = PaginationWOVOTransformer.getInstance();
	}
	
	public static BGLGoodsTablePageWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLGoodsTablePageWOVO dtoToVo(BGLGoodsTablePageWOVODTO dto) {

		BGLGoodsTablePageWOVO vo = new BGLGoodsTablePageWOVO();
		
		vo.setGoodsTable(bglGoodsTableWOVOTransformer.dtoToVo(dto.getGoodsTable()));
		vo.setSearchParameters(bglSearchParameterVOTransformer.dtoToVo(dto.getSearchParameters()));
		vo.setPagination(paginationWOVOTransformer.dtoToVo(dto.getPagination()));
		
		return vo;
	}
}
