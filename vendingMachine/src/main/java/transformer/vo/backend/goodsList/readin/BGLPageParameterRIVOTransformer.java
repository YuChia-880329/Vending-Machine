package transformer.vo.backend.goodsList.readin;

import bean.dto.vo.backend.goodsList.readin.BGLPageParameterRIVODTO;
import bean.vo.backend.goodsList.readin.BGLPageParameterRIVO;
import enumeration.Status;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.backend.goodsList.checker.readin.BGLPageParameterRIVOChecker;

public class BGLPageParameterRIVOTransformer extends VOReanInTransformerTemplate<BGLPageParameterRIVO, BGLPageParameterRIVODTO, CheckerException, BGLPageParameterRIVOChecker> {

	private static final BGLPageParameterRIVOTransformer INSTANCE = new BGLPageParameterRIVOTransformer();
	
	private BGLPageParameterRIVOTransformer() {
	}
	
	public static BGLPageParameterRIVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLPageParameterRIVODTO voToDto(BGLPageParameterRIVO vo) throws CheckerException {

		BGLPageParameterRIVODTO dto = new BGLPageParameterRIVODTO();
		
		String page = vo.getPage();
		dto.setPage((page==null||"".equals(page)) ? null : Integer.parseInt(page));
		
		String idMin = vo.getIdMin();
		dto.setIdMin((idMin==null||"".equals(idMin)) ? null : Integer.parseInt(idMin));
		
		String idMax = vo.getIdMax();
		dto.setIdMax((idMax==null||"".equals(idMax)) ? null : Integer.parseInt(idMax));
		
		dto.setName(vo.getName());
		
		String priceMin = vo.getPriceMin();
		dto.setPriceMin((priceMin==null||"".equals(priceMin)) ? null : Integer.parseInt(priceMin));
		
		String priceMax = vo.getPriceMax();
		dto.setPriceMax((priceMax==null||"".equals(priceMax)) ? null : Integer.parseInt(priceMax));
		
		String quantityMin = vo.getQuantityMin();
		dto.setQuantityMin((quantityMin==null||"".equals(quantityMin)) ? null : Integer.parseInt(quantityMin));
		
		String quantityMax = vo.getQuantityMax();
		dto.setQuantityMax((quantityMax==null||"".equals(quantityMax)) ? null : Integer.parseInt(quantityMax));
		
		String status = vo.getStatus();
		dto.setStatus((status==null||"".equals(status)) ? null : Status.getByDescription(status));
		
		return dto;
	}

	@Override
	protected BGLPageParameterRIVOChecker getChecker() {

		return BGLPageParameterRIVOChecker.getInstance();
	}
}
