package transformer.vo.backend.goodsList.writeout;

import bean.dto.vo.backend.goodsList.writeout.BGLSearchParameterWOVODTO;
import bean.vo.backend.goodsList.writeout.BGLSearchParameterWOVO;
import enumeration.Status;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGLSearchParameterWOVOTransformer extends VOWriteOutTransformerTemplate<BGLSearchParameterWOVODTO, BGLSearchParameterWOVO> {

	private static final BGLSearchParameterWOVOTransformer INSTANCE = new BGLSearchParameterWOVOTransformer();
	
	private BGLSearchParameterWOVOTransformer() {
	}
	
	public static BGLSearchParameterWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLSearchParameterWOVO dtoToVo(BGLSearchParameterWOVODTO dto) {

		BGLSearchParameterWOVO vo = new BGLSearchParameterWOVO();
		
		Integer idMin = dto.getIdMin();
		vo.setIdMin(idMin==null ? "" : String.valueOf(idMin));
		
		Integer idMax = dto.getIdMax();
		vo.setIdMax(idMax==null ? "" : String.valueOf(idMax));
		
		String name = dto.getName();
		vo.setName(name==null ? "" : name);
		
		Integer priceMin = dto.getPriceMin();
		vo.setPriceMin(priceMin==null ? "" : String.valueOf(priceMin));
		
		Integer priceMax = dto.getPriceMax();
		vo.setPriceMax(priceMax==null ? "" : String.valueOf(priceMax));
		
		Integer quantityMin = dto.getQuantityMin();
		vo.setQuantityMin(quantityMin==null ? "" : String.valueOf(quantityMin));
		
		Integer quantityMax = dto.getQuantityMax();
		vo.setQuantityMax(quantityMax==null ? "" : String.valueOf(quantityMax));
		
		Status status = dto.getStatus();
		vo.setStatus(status==null ? "" : String.valueOf(status.getValue()));
		
		return vo;
	}
}
