package transformer.backend.goodsUpdate.vo.readin;

import bean.dto.backend.goodsUpdate.vo.readin.ChangeGoodsVODTO;
import bean.vo.backend.goodsUpdate.readin.ChangeGoodsVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.backend.goodsUpdate.vo.readin.ChangeGoodsVOChecker;

public class ChangeGoodsVOTransformer extends VOReanInTransformerTemplate<ChangeGoodsVO, ChangeGoodsVODTO, CheckerException, ChangeGoodsVOChecker> {

	private static final ChangeGoodsVOTransformer INSTANCE = new ChangeGoodsVOTransformer();
	
	private ChangeGoodsVOTransformer() {
	}
	
	public static ChangeGoodsVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ChangeGoodsVODTO voToDtoTransform(ChangeGoodsVO vo) throws CheckerException {

		ChangeGoodsVODTO dto = new ChangeGoodsVODTO();
		
		dto.setId(Integer.parseInt(vo.getId()));
		
		return dto;
	}

	@Override
	protected ChangeGoodsVOChecker getChecker() {

		return ChangeGoodsVOChecker.getInstance();
	}
}
