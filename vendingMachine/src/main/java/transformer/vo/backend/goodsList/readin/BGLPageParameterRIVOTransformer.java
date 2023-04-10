package transformer.vo.backend.goodsList.readin;

import bean.dto.vo.backend.goodsList.readin.BGLPageParameterRIVODTO;
import bean.vo.backend.goodsList.readin.BGLPageParameteRIVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.backend.goodsList.BGLSearchParameterVOTransformer;
import transformer.vo.backend.goodsList.readin.checker.BGLPageParameterRIVOChecker;

public class BGLPageParameterRIVOTransformer extends VOReanInTransformerTemplate<BGLPageParameteRIVO, BGLPageParameterRIVODTO, CheckerException, BGLPageParameterRIVOChecker> {

	private BGLSearchParameterVOTransformer bglSearchParameterRIVOTransformer;
	
	
	private static final BGLPageParameterRIVOTransformer INSTANCE = new BGLPageParameterRIVOTransformer();
	
	private BGLPageParameterRIVOTransformer() {
		
		bglSearchParameterRIVOTransformer = BGLSearchParameterVOTransformer.getInstance();
	}
	
	public static BGLPageParameterRIVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLPageParameterRIVODTO voToDto(BGLPageParameteRIVO vo) throws CheckerException {

		BGLPageParameterRIVODTO dto = new BGLPageParameterRIVODTO();
		
		String page = vo.getPage();
		dto.setPage((page==null||"".equals(page)) ? null : Integer.parseInt(page));

		dto.setSearchParameters(bglSearchParameterRIVOTransformer.voToDto(vo.getSearchParameters()));
		
		return dto;
	}

	@Override
	protected BGLPageParameterRIVOChecker getChecker() {

		return BGLPageParameterRIVOChecker.getInstance();
	}
}
