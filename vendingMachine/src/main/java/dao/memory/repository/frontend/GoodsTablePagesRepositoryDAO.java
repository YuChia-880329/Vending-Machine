package dao.memory.repository.frontend;

import bean.dto.frontend.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.obj.frontend.repository.goodsTablePages.readin.GoodsTablePagesInputOBJ;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTablePagesOBJ;
import memory.repository.frontend.GoodsTablePagesRepository;
import template.memory.repository.RepositoryDAOTemplate;
import transformer.frontend.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJTransformer;
import transformer.frontend.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJTransformer;

public class GoodsTablePagesRepositoryDAO extends RepositoryDAOTemplate<GoodsTablePagesInputOBJ, 
				GoodsTablePagesOBJ, GoodsTablePagesInputOBJDTO, GoodsTablePagesOBJDTO, 
				GoodsTablePagesRepository, GoodsTablePagesInputOBJTransformer, GoodsTablePagesOBJTransformer> {

	public static final String DAO = "frontendGoodsTablePagesRepositoryDAO";
	
	
	public GoodsTablePagesRepositoryDAO(GoodsTablePagesRepository repository) {
		
		super(repository);
	}

	public void requireUpdate() {
		
		repository.requireUpdate();
	}
	
	@Override
	protected GoodsTablePagesInputOBJTransformer getInputTransformer() {
		
		return GoodsTablePagesInputOBJTransformer.getInstance();
	}

	@Override
	protected GoodsTablePagesOBJTransformer getObjTransformer() {

		return GoodsTablePagesOBJTransformer.getInstance();
	}

}
