package transformer.backend.goodsCreate.vo.readin;

import bean.dto.backend.goodsCreate.vo.readin.CreateFormVODTO;
import bean.vo.backend.goodsCreate.readin.CreateFormVO;
import enumeration.Status;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.backend.goodsCreate.vo.readin.CreateFormVOChecker;

public class CreateFormVOTransformer extends VOReanInTransformerTemplate<CreateFormVO, CreateFormVODTO, CheckerException, CreateFormVOChecker> {

	private static final CreateFormVOTransformer INSTANCE = new CreateFormVOTransformer();
	
	private CreateFormVOTransformer() {
	}
	
	public static CreateFormVOTransformer getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	protected CreateFormVODTO voToDtoTransform(CreateFormVO vo) throws CheckerException {
		
		CreateFormVODTO dto = new CreateFormVODTO();
		
		dto.setName(vo.getName());
		dto.setDescription(vo.getDescription());
		dto.setPrice(Integer.parseInt(vo.getPrice()));
		dto.setQuantity(Integer.parseInt(vo.getQuantity()));
		dto.setImageName(vo.getImageName());
		dto.setImagePart(vo.getImagePart());
		dto.setStatus(Status.getByValue(Integer.parseInt(vo.getStatus())));
		
		return dto;
	}

	@Override
	protected CreateFormVOChecker getChecker() {
		
		return CreateFormVOChecker.getInstance();
	}

}
