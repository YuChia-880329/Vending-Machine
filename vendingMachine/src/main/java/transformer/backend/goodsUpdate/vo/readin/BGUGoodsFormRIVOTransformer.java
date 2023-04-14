package transformer.backend.goodsUpdate.vo.readin;

import bean.dto.backend.goodsUpdate.vo.readin.BGUGoodsFormRIVODTO;
import bean.vo.backend.goodsUpdate.readin.GoodsFormVO;
import enumeration.Status;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.backend.goodsUpdate.vo.readin.checker.BGUGoodsFormRIVOChecker;

public class BGUGoodsFormRIVOTransformer extends VOReanInTransformerTemplate<GoodsFormVO, BGUGoodsFormRIVODTO, CheckerException, BGUGoodsFormRIVOChecker> {

	private static final BGUGoodsFormRIVOTransformer INSTANCE = new BGUGoodsFormRIVOTransformer();
	
	private BGUGoodsFormRIVOTransformer() {
	}
	
	public static BGUGoodsFormRIVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGUGoodsFormRIVODTO voToDto(GoodsFormVO vo) throws CheckerException {

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
