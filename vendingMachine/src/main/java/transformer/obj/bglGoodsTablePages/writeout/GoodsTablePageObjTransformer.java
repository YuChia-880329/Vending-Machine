package transformer.obj.bglGoodsTablePages.writeout;

import bean.dto.obj.repository.bglGoodsTablePages.writeout.BGLGoodsTablePageDTO;
import bean.obj.repository.bglGoodsTablePages.writeout.GoodsTablePageObj;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class GoodsTablePageObjTransformer extends RepositoryObjTransformerTemplate<GoodsTablePageObj, BGLGoodsTablePageDTO> {

	private GoodsTableObjTransformer goodsTableObjTransformer;
	
	
	private static final GoodsTablePageObjTransformer INSTANCE = new GoodsTablePageObjTransformer();
	
	private GoodsTablePageObjTransformer() {

		goodsTableObjTransformer = GoodsTableObjTransformer.getInstance();
	}
	
	public static GoodsTablePageObjTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLGoodsTablePageDTO objToDto(GoodsTablePageObj obj) {
		
		BGLGoodsTablePageDTO dto = new BGLGoodsTablePageDTO();
		
		dto.setGoodsTable(goodsTableObjTransformer.objToDto(obj.getGoodsTable()));
		
		return dto;
	}
}
