package transformer.backend.goodsList.vo.writeout;

import bean.dto.backend.goodsList.vo.writeout.BackendGoodsListVODTO;
import bean.vo.backend.goodsList.writeout.BackendGoodsListVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackendGoodsListVOTransformer extends VOWriteOutTransformerTemplate<BackendGoodsListVODTO, BackendGoodsListVO> {

	private GoodsTablePageVOTransformer goodsTablePageVOTransformer;
	private FilterFormVOTransformer filterFormVOTransformer;
	
	private static final BackendGoodsListVOTransformer INSTANCE = new BackendGoodsListVOTransformer();
	
	private BackendGoodsListVOTransformer() {
		
		goodsTablePageVOTransformer = GoodsTablePageVOTransformer.getInstance();
		filterFormVOTransformer = FilterFormVOTransformer.getInstance();
	}
	
	public static BackendGoodsListVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected BackendGoodsListVO dtoToVoTransform(BackendGoodsListVODTO dto) {
		
		BackendGoodsListVO vo = new BackendGoodsListVO();
		
		vo.setGoodsTablePage(goodsTablePageVOTransformer.dtoToVo(dto.getGoodsTablePage()));
		vo.setFilterForm(filterFormVOTransformer.dtoToVo(dto.getFilterForm()));
		
		return vo;
	}
}
