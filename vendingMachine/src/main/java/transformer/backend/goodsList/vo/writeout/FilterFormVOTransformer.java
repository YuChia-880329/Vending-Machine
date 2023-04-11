package transformer.backend.goodsList.vo.writeout;

import bean.dto.backend.goodsList.vo.writeout.FilterFormVODTO;
import bean.vo.backend.goodsList.writeout.FilterFormVO;
import enumeration.Status;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FilterFormVOTransformer extends VOWriteOutTransformerTemplate<FilterFormVODTO, FilterFormVO> {

	private static final FilterFormVOTransformer INSTANCE = new FilterFormVOTransformer();
	
	private FilterFormVOTransformer() {
	}
	
	public static FilterFormVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FilterFormVO dtoToVo(FilterFormVODTO dto) {
		
		FilterFormVO vo = new FilterFormVO();
		
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
