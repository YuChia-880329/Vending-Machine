package transformer.vo.frontend.readin;

import bean.dto.vo.frontend.readin.FPageParameterRIVODTO;
import bean.vo.frontend.readin.FPageParameterRIVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.frontend.checker.readin.FPageParameterRIVOChecker;

public class FPageParameterRIVOTransformer extends VOReanInTransformerTemplate<FPageParameterRIVO, FPageParameterRIVODTO, CheckerException, FPageParameterRIVOChecker> {

	private static final FPageParameterRIVOTransformer INSTANCE = new FPageParameterRIVOTransformer();
	
	private FPageParameterRIVOTransformer() {
	}
	
	public static FPageParameterRIVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FPageParameterRIVODTO voToDto(FPageParameterRIVO vo) throws CheckerException {

		FPageParameterRIVODTO dto = new FPageParameterRIVODTO();
		
		String page = vo.getPage();
		dto.setPage((page==null||"".equals(page)) ? null : Integer.parseInt(page));
		
		dto.setName(vo.getName());
		
		return dto;
	}

	@Override
	protected FPageParameterRIVOChecker getChecker() {

		return FPageParameterRIVOChecker.getInstance();
	}
}
