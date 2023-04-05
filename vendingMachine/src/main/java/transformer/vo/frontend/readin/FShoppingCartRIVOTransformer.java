package transformer.vo.frontend.readin;

import bean.dto.vo.frontend.readin.FShoppingCartRIVODTO;
import bean.vo.frontend.readin.FShoppingCartRIVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.frontend.checker.readin.FShoppingCartRIVOChecker;

public class FShoppingCartRIVOTransformer extends VOReanInTransformerTemplate<FShoppingCartRIVO, FShoppingCartRIVODTO, CheckerException, FShoppingCartRIVOChecker>  {

	private FSCGoodsRIVOTransformer fscGoodsRIVOTransformer;
	
	
	private static final FShoppingCartRIVOTransformer INSTANCE = new FShoppingCartRIVOTransformer();
	
	private FShoppingCartRIVOTransformer() {
		
		fscGoodsRIVOTransformer = FSCGoodsRIVOTransformer.getInstance();
	}
	
	public static FShoppingCartRIVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FShoppingCartRIVODTO voToDto(FShoppingCartRIVO vo) throws CheckerException {

		FShoppingCartRIVODTO dto = new FShoppingCartRIVODTO();
		
		dto.setGoods(fscGoodsRIVOTransformer.voListToDtoList(vo.getGoods()));
		
		return dto;
	}

	@Override
	protected FShoppingCartRIVOChecker getChecker() {

		return FShoppingCartRIVOChecker.getInstance();
	}
}
