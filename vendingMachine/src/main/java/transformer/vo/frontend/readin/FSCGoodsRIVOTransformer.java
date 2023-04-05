package transformer.vo.frontend.readin;

import bean.dto.vo.frontend.readin.FSCGoodsRIVODTO;
import bean.vo.frontend.readin.FSCGoodsRIVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.frontend.checker.readin.FSCGoodsRIVOChecker;

public class FSCGoodsRIVOTransformer extends VOReanInTransformerTemplate<FSCGoodsRIVO, FSCGoodsRIVODTO, CheckerException, FSCGoodsRIVOChecker>  {

	private static final FSCGoodsRIVOTransformer INSTANCE = new FSCGoodsRIVOTransformer();
	
	private FSCGoodsRIVOTransformer() {
	}
	
	public static FSCGoodsRIVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FSCGoodsRIVODTO voToDto(FSCGoodsRIVO vo) throws CheckerException {

		FSCGoodsRIVODTO dto = new FSCGoodsRIVODTO();
		
		dto.setId(Integer.parseInt(vo.getId()));
		dto.setQuantity(Integer.parseInt(vo.getQuantity()));
		
		return dto;
	}

	@Override
	protected FSCGoodsRIVOChecker getChecker() {

		return FSCGoodsRIVOChecker.getInstance();
	}
}
