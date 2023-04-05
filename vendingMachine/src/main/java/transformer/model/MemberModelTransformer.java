package transformer.model;

import bean.dto.model.MemberModelDTO;
import bean.model.MemberModel;
import template.transformer.bean.model.ModelTransformerTemplate;

public class MemberModelTransformer extends ModelTransformerTemplate<MemberModel, MemberModelDTO> {

	private static final MemberModelTransformer INSTANCE = new MemberModelTransformer();
	
	private MemberModelTransformer() {
	}
	
	public static MemberModelTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public MemberModelDTO modelToDto(MemberModel model) {
		
		MemberModelDTO dto = new MemberModelDTO();
		
		dto.setId(model.getId());
		dto.setPw(model.getPw());
		dto.setName(model.getName());
		
		return dto;
	}

	@Override
	public MemberModel dtoToModel(MemberModelDTO dto) {

		MemberModel model = new MemberModel();
		
		model.setId(dto.getId());
		model.setPw(dto.getPw());
		model.setName(dto.getName());
		
		return model;
	}
}
