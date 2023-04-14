package service.model;

import bean.dto.model.MemberModelDTO;
import bean.model.MemberModel;
import dao.model.MemberModelDAO;
import template.model.ModelServiceTemplate;
import transformer.model.MemberModelTransformer;

public class MemberModelService extends ModelServiceTemplate<MemberModel, String, MemberModelDTO, MemberModelDAO, MemberModelTransformer> {

	private static final MemberModelService INSTANCE = new MemberModelService();
	
	private MemberModelService() {
	}
	
	public static MemberModelService getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected MemberModelDAO getModelDAO() {
		
		return MemberModelDAO.getInstance();
	}
	@Override
	protected MemberModelTransformer getModelTransformer() {

		return MemberModelTransformer.getInstance();
	}
}
