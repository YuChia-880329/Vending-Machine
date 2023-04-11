package dao.memory.repository;

import bean.dto.obj.repository.bglGoodsTablePages.readin.BGLGoodsTablePagesInputRIOBJDTO;
import bean.dto.obj.repository.bglGoodsTablePages.writeout.BGLGoodsTablePagesDTO;
import bean.obj.repository.bglGoodsTablePages.readin.GoodsTablePagesInputObj;
import bean.obj.repository.bglGoodsTablePages.writeout.GoodsTablePagesObj;
import memory.repository.BGLGoodsTablePagesRepository;
import template.memory.repository.RepositoryDAOTemplate;
import transformer.obj.bglGoodsTablePages.readin.GoodsTablePagesInputObjTransformer;
import transformer.obj.bglGoodsTablePages.writeout.GoodsTablePagesObjTransformer;

public class GoodsTablePagesDAO extends RepositoryDAOTemplate<GoodsTablePagesInputObj, 
		GoodsTablePagesObj, BGLGoodsTablePagesInputRIOBJDTO, BGLGoodsTablePagesDTO, 
		BGLGoodsTablePagesRepository, GoodsTablePagesInputObjTransformer, GoodsTablePagesObjTransformer> {
	
	GoodsTablePagesDAO(BGLGoodsTablePagesRepository repository) {
		
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
