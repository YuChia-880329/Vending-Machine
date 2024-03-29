package dao.memory.repository.backend.goodsList;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.readin.GoodsTablePagesInputOBJ;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTablePagesOBJ;
import memory.repository.backend.goodsList.GoodsTablePagesRepository;
import template.memory.repository.RepositoryDAOTemplate;
import transformer.backend.goodsList.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJTransformer;
import transformer.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJTransformer;

public class GoodsTablePagesRepositoryDAO extends RepositoryDAOTemplate<GoodsTablePagesInputOBJ, 
		GoodsTablePagesOBJ, GoodsTablePagesInputOBJDTO, GoodsTablePagesOBJDTO, 
		GoodsTablePagesRepository, GoodsTablePagesInputOBJTransformer, GoodsTablePagesOBJTransformer> {
	
	public static final String SESSION_ATTR_DAO = "goodsTablePagesRepositoryDAO";
	
	
	public GoodsTablePagesRepositoryDAO() {
		
		super(getInitialRepository());
	}
	
	private static GoodsTablePagesRepository getInitialRepository() {
		
		GoodsTablePagesRepository repository = new GoodsTablePagesRepository();
		
		return repository;
	}
	
	
	public synchronized void requireUpdate() {
		
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
