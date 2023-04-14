package transformer.backend.goodsUpdate.vo.readin;

import bean.dto.backend.goodsUpdate.vo.readin.GoodsFormVODTO;
import bean.vo.backend.goodsUpdate.readin.GoodsFormVO;
import enumeration.Status;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.backend.goodsUpdate.vo.readin.checker.BGUGoodsFormRIVOChecker;

public class GoodsFormVOTransformer extends VOReanInTransformerTemplate<GoodsFormVO, GoodsFormVODTO, CheckerException, BGUGoodsFormRIVOChecker> {

	private static final GoodsFormVOTransformer INSTANCE = new GoodsFormVOTransformer();
	
	private GoodsFormVOTransformer() {
	}
	
	public static GoodsFormVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsFormVODTO voToDto(GoodsFormVO vo) throws CheckerException {

		GoodsFormVODTO dto = new GoodsFormVODTO();
		
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
