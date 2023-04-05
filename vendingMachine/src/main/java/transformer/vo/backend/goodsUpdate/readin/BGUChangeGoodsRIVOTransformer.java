package transformer.vo.backend.goodsUpdate.readin;

import bean.dto.vo.backend.goodsUpdate.readin.BGUChangeGoodsRIVODTO;
import bean.vo.backend.goodsUpdate.readin.BGUChangeGoodsRIVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.backend.goodsUpdate.checker.readin.BGUChangeGoodsRIVOChecker;

public class BGUChangeGoodsRIVOTransformer extends VOReanInTransformerTemplate<BGUChangeGoodsRIVO, BGUChangeGoodsRIVODTO, CheckerException, BGUChangeGoodsRIVOChecker> {

	private static final BGUChangeGoodsRIVOTransformer INSTANCE = new BGUChangeGoodsRIVOTransformer();
	
	private BGUChangeGoodsRIVOTransformer() {
	}
	
	public static BGUChangeGoodsRIVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGUChangeGoodsRIVODTO voToDto(BGUChangeGoodsRIVO vo) throws CheckerException {

		BGUChangeGoodsRIVODTO dto = new BGUChangeGoodsRIVODTO();
		
		dto.setId(Integer.parseInt(vo.getId()));
		
		return dto;
	}

	@Override
	protected BGUChangeGoodsRIVOChecker getChecker() {

		return BGUChangeGoodsRIVOChecker.getInstance();
	}
}
