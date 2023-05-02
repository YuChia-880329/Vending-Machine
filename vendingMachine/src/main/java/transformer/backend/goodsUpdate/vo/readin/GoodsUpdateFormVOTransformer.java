package transformer.backend.goodsUpdate.vo.readin;

import bean.dto.backend.goodsUpdate.vo.readin.GoodsUpdateFormVODTO;
import bean.vo.backend.goodsUpdate.readin.GoodsUpdateFormVO;
import enumeration.Status;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.backend.goodsUpdate.vo.readin.GoodsUpdateFormVOChecker;

public class GoodsUpdateFormVOTransformer extends VOReanInTransformerTemplate<GoodsUpdateFormVO, GoodsUpdateFormVODTO, CheckerException, GoodsUpdateFormVOChecker> {

	private static final GoodsUpdateFormVOTransformer INSTANCE = new GoodsUpdateFormVOTransformer();
	
	private GoodsUpdateFormVOTransformer() {
	}
	
	public static GoodsUpdateFormVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsUpdateFormVODTO voToDtoTransform(GoodsUpdateFormVO vo) throws CheckerException {

		GoodsUpdateFormVODTO dto = new GoodsUpdateFormVODTO();
		
		dto.setId(Integer.parseInt(vo.getId()));
		dto.setPrice(Integer.parseInt(vo.getPrice()));
		dto.setAddQuantity(Integer.parseInt(vo.getAddQuantity()));
		dto.setStatus(Status.getByValue(Integer.parseInt(vo.getStatus())));
		
		return dto;
	}

	@Override
	protected GoodsUpdateFormVOChecker getChecker() {

		return GoodsUpdateFormVOChecker.getInstance();
	}
}
