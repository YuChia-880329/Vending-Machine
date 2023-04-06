package transformer.vo.backend.goodsUpdate.readin;

import bean.dto.vo.backend.goodsUpdate.readin.BGUGoodsFormRIVODTO;
import bean.vo.backend.goodsUpdate.readin.BGUGoodsFormRIVO;
import enumeration.Status;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.backend.goodsUpdate.readin.checker.BGUGoodsFormRIVOChecker;

public class BGUGoodsFormRIVOTransformer extends VOReanInTransformerTemplate<BGUGoodsFormRIVO, BGUGoodsFormRIVODTO, CheckerException, BGUGoodsFormRIVOChecker> {

	private static final BGUGoodsFormRIVOTransformer INSTANCE = new BGUGoodsFormRIVOTransformer();
	
	private BGUGoodsFormRIVOTransformer() {
	}
	
	public static BGUGoodsFormRIVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGUGoodsFormRIVODTO voToDto(BGUGoodsFormRIVO vo) throws CheckerException {

		BGUGoodsFormRIVODTO dto = new BGUGoodsFormRIVODTO();
		
		dto.setId(Integer.parseInt(vo.getId()));
		dto.setPrice(Integer.parseInt(vo.getPrice()));
		dto.setAddQuantity(Integer.parseInt(vo.getAddQuantity()));
		dto.setStatus(Status.getByDescription(vo.getStatus()));
		
		return dto;
	}

	@Override
	protected BGUGoodsFormRIVOChecker getChecker() {

		return BGUGoodsFormRIVOChecker.getInstance();
	}
}
