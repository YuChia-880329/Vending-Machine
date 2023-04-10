package memory.repository.backend.goodsList.goodsTablePages;

import bean.dto.vo.backend.goodsList.BGLGoodsTablePageDTO;
import template.memory.repository.RepositoryObjTransformerTemplate;

class GoodsTablePageObjTransformer extends RepositoryObjTransformerTemplate<GoodsTablePageObj, BGLGoodsTablePageDTO> {

	private GoodsTableObjTransformer goodsTableObjTransformer;
	
	
	private static final GoodsTablePageObjTransformer INSTANCE = new GoodsTablePageObjTransformer();
	
	private GoodsTablePageObjTransformer() {

		goodsTableObjTransformer = GoodsTableObjTransformer.getInstance();
	}
	
	static GoodsTablePageObjTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLGoodsTablePageDTO objToDto(GoodsTablePageObj obj) {
		
		BGLGoodsTablePageDTO dto = new BGLGoodsTablePageDTO();
		
		dto.setGoodsTable(goodsTableObjTransformer.objToDto(obj.getGoodsTable()));
		
		return dto;
	}
}
