package transformer.obj.bglGoodsTablePages.writeout;

import java.util.stream.Collectors;

import bean.dto.obj.repository.bglGoodsTablePages.writeout.BGLGoodsTablePagesDTO;
import bean.obj.repository.bglGoodsTablePages.writeout.GoodsTablePagesObj;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class GoodsTablePagesObjTransformer extends RepositoryObjTransformerTemplate<GoodsTablePagesObj, BGLGoodsTablePagesDTO> {

	private GoodsTablePageObjTransformer goodsTablePageObjTransformer;
	
	
	private static final GoodsTablePagesObjTransformer INSTANCE = new GoodsTablePagesObjTransformer();
	
	private GoodsTablePagesObjTransformer() {

		goodsTablePageObjTransformer = GoodsTablePageObjTransformer.getInstance();
	}
	
	public static GoodsTablePagesObjTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLGoodsTablePagesDTO objToDto(GoodsTablePagesObj obj) {
	
		BGLGoodsTablePagesDTO dto = new BGLGoodsTablePagesDTO();
		
		dto.setGoodsTablePageMap(obj.getGoodsTablePageMap().entrySet().stream()
				.collect(Collectors.toMap(
						entry -> entry.getKey(), 
						entry -> goodsTablePageObjTransformer.objToDto(entry.getValue()))));
		dto.setMaxPage(obj.getMaxPage());
		
		return dto;
	}
}
