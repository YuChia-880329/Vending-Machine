package memory.repository.backend.goodsList.goodsTablePages;

import bean.dto.vo.backend.goodsList.BGLGoodsTablePagesDTO;
import bean.dto.vo.backend.goodsList.BGLGoodsTablePagesInputDTO;
import template.memory.repository.RepositoryDAOTemplate;

public class GoodsTablePagesDAO extends RepositoryDAOTemplate<GoodsTablePagesInputObj, 
		GoodsTablePagesObj, BGLGoodsTablePagesInputDTO, BGLGoodsTablePagesDTO, 
		GoodsTablePagesRepository, GoodsTablePagesInputObjTransformer, GoodsTablePagesObjTransformer> {
	
	GoodsTablePagesDAO(GoodsTablePagesRepository repository) {
		
		super(repository);
	}
	
	
	@Override
	protected GoodsTablePagesInputObjTransformer getInputTransformer() {
		
		return GoodsTablePagesInputObjTransformer.getInstance();
	}
	@Override
	protected GoodsTablePagesObjTransformer getObjTransformer() {
		
		return GoodsTablePagesObjTransformer.getInstance();
	}
}
