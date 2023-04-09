package database.goods;

import bean.dto.model.GoodsModelDTO;
import template.database.ModelServiceTemplate;

public class GoodsModelService extends ModelServiceTemplate<GoodsModel, Integer, GoodsModelDTO, GoodsModelDAO, GoodsModelTransformer> {

	private static final GoodsModelService INSTANCE = new GoodsModelService();
	
	private GoodsModelService() {
	}
	
	public static GoodsModelService getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected GoodsModelDAO getModelDAO() {

		return GoodsModelDAO.getInstance();
	}

	@Override
	protected GoodsModelTransformer getModelTransformer() {

		return GoodsModelTransformer.getInstance();
	}
}
