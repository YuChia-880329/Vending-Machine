package transformer.backend.goodsList.vo.writeout;

import bean.dto.backend.goodsList.vo.writeout.GoodsTablePageVODTO;
import bean.vo.backend.goodsList.writeout.GoodsTablePageVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.backend.goodsList.vo.SearchParameterVOTransformer;
import transformer.vo.writeout.PaginationWOVOTransformer;

public class GoodsTablePageVOTransformer extends VOWriteOutTransformerTemplate<GoodsTablePageVODTO, GoodsTablePageVO> {

	private GoodsTableVOTransformer goodsTableVOTransformer;
	private SearchParameterVOTransformer searchParameterVOTransformer;
	private PaginationWOVOTransformer paginationWOVOTransformer;
	
	
	private static final GoodsTablePageVOTransformer INSTANCE = new GoodsTablePageVOTransformer();
	
	private GoodsTablePageVOTransformer() {
		
		goodsTableVOTransformer = GoodsTableVOTransformer.getInstance();
		searchParameterVOTransformer = SearchParameterVOTransformer.getInstance();
		paginationWOVOTransformer = PaginationWOVOTransformer.getInstance();
	}
	
	public static GoodsTablePageVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsTablePageVO dtoToVo(GoodsTablePageVODTO dto) {

		GoodsTablePageVO vo = new GoodsTablePageVO();
		
		vo.setGoodsTable(goodsTableVOTransformer.dtoToVo(dto.getGoodsTable()));
		vo.setSearchParameter(searchParameterVOTransformer.dtoToVo(dto.getSearchParameter()));
		vo.setPagination(paginationWOVOTransformer.dtoToVo(dto.getPagination()));
		
		return vo;
	}
}
