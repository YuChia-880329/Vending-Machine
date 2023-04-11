package transformer.backend.goodsList.vo.writeout;

import bean.dto.backend.goodsList.vo.writeout.BackendGoodsListVODTO;
import bean.vo.backend.goodsList.writeout.BackendGoodsListVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackendGoodsListVOTransformer extends VOWriteOutTransformerTemplate<BackendGoodsListVODTO, BackendGoodsListVO> {

	private GoodsTablePageVOTransformer goodsTablePageVOTransformer;
	
	private static final BackendGoodsListVOTransformer INSTANCE = new BackendGoodsListVOTransformer();
	
	private BackendGoodsListVOTransformer() {
		
		goodsTablePageVOTransformer = GoodsTablePageVOTransformer.getInstance();
	}
	
	public static BackendGoodsListVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BackendGoodsListVO dtoToVo(BackendGoodsListVODTO dto) {
		
		BackendGoodsListVO vo = new BackendGoodsListVO();
		
		vo.setGoodsTablePage(goodsTablePageVOTransformer.dtoToVo(dto.getGoodsTablePage()));
		
		return vo;
	}
}
