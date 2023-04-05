package transformer.vo.frontend.writeout;

import bean.dto.vo.frontend.writeout.FGoodsTableWOVODTO;
import bean.vo.frontend.writeout.FGoodsTableWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FGoodsTableWOVOTransformer extends VOWriteOutTransformerTemplate<FGoodsTableWOVODTO, FGoodsTableWOVO> {

	private FGTGoodsWOVOTransformer fgtGoodsWOVOTransformer;
	
	
	private static final FGoodsTableWOVOTransformer INSTANCE = new FGoodsTableWOVOTransformer();
	
	private FGoodsTableWOVOTransformer() {
		
		fgtGoodsWOVOTransformer = FGTGoodsWOVOTransformer.getInstance();
	}
	
	public static FGoodsTableWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FGoodsTableWOVO dtoToVo(FGoodsTableWOVODTO dto) {

		FGoodsTableWOVO vo = new FGoodsTableWOVO();
		
		vo.setGoods(fgtGoodsWOVOTransformer.dtoListToVoList(dto.getGoods()));
		
		return vo;
	}
}
