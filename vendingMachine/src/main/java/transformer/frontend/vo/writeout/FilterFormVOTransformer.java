package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.FilterFormVODTO;
import bean.vo.frontend.writeout.FilterFormVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FilterFormVOTransformer extends VOWriteOutTransformerTemplate<FilterFormVODTO, FilterFormVO> {

	private static final FilterFormVOTransformer INSTANCE = new FilterFormVOTransformer();
	
	private FilterFormVOTransformer() {
	}
	
	public static FilterFormVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected FilterFormVO dtoToVoTransform(FilterFormVODTO dto) {
		
		FilterFormVO vo = new FilterFormVO();
		
		vo.setName(dto.getName());
		
		return vo;
	}
}
