package transformer.vo.backend.goodsCreate.readin;

import bean.dto.vo.backend.goodsCreate.readin.BGCCreateFormRIVODTO;
import bean.vo.backend.goodsCreate.readin.BGCCreateFormRIVO;
import enumeration.Status;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.backend.goodsCreate.checker.readin.BGCCreateFormRIVOChecker;

public class BGCCreateFormRIVOTransformer extends VOReanInTransformerTemplate<BGCCreateFormRIVO, BGCCreateFormRIVODTO, CheckerException, BGCCreateFormRIVOChecker> {

	private static final BGCCreateFormRIVOTransformer INSTANCE = new BGCCreateFormRIVOTransformer();
	
	private BGCCreateFormRIVOTransformer() {
	}
	
	public static BGCCreateFormRIVOTransformer getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	public BGCCreateFormRIVODTO voToDto(BGCCreateFormRIVO vo) throws CheckerException {
		
		BGCCreateFormRIVODTO dto = new BGCCreateFormRIVODTO();
		
		dto.setName(vo.getName());
		dto.setPrice(Integer.parseInt(vo.getPrice()));
		dto.setQuantity(Integer.parseInt(vo.getQuantity()));
		dto.setImageName(vo.getImageName());
		dto.setImagePart(vo.getImagePart());
		dto.setStatus(Status.getByDescription(vo.getStatus()));
		
		return dto;
	}

	@Override
	protected BGCCreateFormRIVOChecker getChecker() {
		
		return BGCCreateFormRIVOChecker.getInstance();
	}

}
