package service.backend.goodsList.memory.repository.goodsTablePages;

import java.util.ArrayList;
import java.util.List;

import bean.obj.backend.goodsList.repository.goodsTablePages.SearchParameterOBJ;
import enumeration.Status;
import service.model.GoodsModelService;
import template.model.QueryObj;

public class SearchParameterService {

	private static final SearchParameterService INSTANCE = new SearchParameterService();
	
	private SearchParameterService() {
	}
	
	public static SearchParameterService getInstance() {
		
		return INSTANCE;
	}
	
	public QueryObj[] getQueryObjs(SearchParameterOBJ searchParameter) {
		
		List<QueryObj> list = new ArrayList<>();
		
		QueryObj idQueryObj = getIdQueryObj(searchParameter.getIdMin(), searchParameter.getIdMax());
		if(idQueryObj != null)
			list.add(idQueryObj);
		
		QueryObj nameQueryObj = getNameQueryObj(searchParameter.getName());
		if(nameQueryObj != null)
			list.add(nameQueryObj);
		
		QueryObj priceQueryObj = getPriceQueryObj(searchParameter.getPriceMin(), searchParameter.getPriceMax());
		if(priceQueryObj != null)
			list.add(priceQueryObj);
		
		QueryObj quantityQueryObj = getQuantityQueryObj(searchParameter.getQuantityMin(), searchParameter.getQuantityMax());
		if(quantityQueryObj != null)
			list.add(quantityQueryObj);
		
		QueryObj statusQueryObj = getStatusQueryObj(searchParameter.getStatus());
		if(statusQueryObj != null)
			list.add(statusQueryObj);
		
		return list.toArray(new QueryObj[list.size()]);
	}
	
	public boolean equals(SearchParameterOBJ searchParameter1, SearchParameterOBJ searchParameter2) {
		
		return idMinEquals(searchParameter1.getIdMin(), searchParameter2.getIdMin())
				&& idMaxEquals(searchParameter1.getIdMax(), searchParameter2.getIdMax())
				&& nameEquals(searchParameter1.getName(), searchParameter2.getName())
				&& priceMinEquals(searchParameter1.getPriceMin(), searchParameter2.getPriceMin())
				&& priceMaxEquals(searchParameter1.getPriceMax(), searchParameter2.getPriceMax())
				&& quantityMinEquals(searchParameter1.getQuantityMin(), searchParameter2.getQuantityMin())
				&& quantityMaxEquals(searchParameter1.getQuantityMax(), searchParameter2.getQuantityMax())
				&& statusEquals(searchParameter1.getStatus(), searchParameter2.getStatus());
	}
	
	private QueryObj getIdQueryObj(Integer idMin, Integer idMax) {
		
		if(idMin==null && idMax==null)
			return null;
		else if(idMin!=null && idMax!=null)
			return GoodsModelService.getIdBetweenQueryObj(idMin, idMax);
		else if(idMin != null)
			return GoodsModelService.getIdGreaterThanOrEqualToQueryObj(idMin);
		else
			return GoodsModelService.getIdLessThanOrEqualToQueryObj(idMax);
	}
	private QueryObj getNameQueryObj(String name) {
		
		if(name == null)
			return null;
		else
			return GoodsModelService.getNameLikeQueryObj(name);
	}
	private QueryObj getPriceQueryObj(Integer priceMin, Integer priceMax) {
		
		if(priceMin==null && priceMax==null)
			return null;
		else if(priceMin!=null && priceMax!=null)
			return GoodsModelService.getPriceBetweenQueryObj(priceMin, priceMax);
		else if(priceMin != null)
			return GoodsModelService.getPriceGreaterThanOrEqualToQueryObj(priceMin);
		else
			return GoodsModelService.getPriceLessThanOrEqualToQueryObj(priceMax);
	}
	private QueryObj getQuantityQueryObj(Integer quantityMin, Integer quantityMax) {
		
		if(quantityMin==null && quantityMax==null)
			return null;
		else if(quantityMin!=null && quantityMax!=null)
			return GoodsModelService.getQuantityBetweenQueryObj(quantityMin, quantityMax);
		else if(quantityMin != null)
			return GoodsModelService.getQuantityGreaterThanOrEqualToQueryObj(quantityMin);
		else
			return GoodsModelService.getQuantityLessThanOrEqualToQueryObj(quantityMax);
	}
	private QueryObj getStatusQueryObj(Status status) {
		
		if(status == null)
			return null;
		else if(status == Status.ON)
			return GoodsModelService.getStatus1QueryObj();
		else
			return GoodsModelService.getStatus0QueryObj();
			
	}
	
	
	private boolean idMinEquals(Integer idMin1, Integer idMin2) {
		
		if(idMin1==null && idMin2==null)
			return true;
		else if(idMin1==null || idMin2==null)
			return false;
		else
			return idMin1.intValue() == idMin2.intValue();
	}
	private boolean idMaxEquals(Integer idMax1, Integer idMax2) {
		
		if(idMax1==null && idMax2==null)
			return true;
		else if(idMax1==null || idMax2==null)
			return false;
		else
			return idMax1.intValue() == idMax2.intValue();
	}
	private boolean nameEquals(String name1, String name2) {
		
		if(name1==null && name2==null)
			return true;
		else if(name1==null || name2==null)
			return false;
		else
			return name1.equals(name2);
	}
	private boolean priceMinEquals(Integer priceMin1, Integer priceMin2) {
		
		if(priceMin1==null && priceMin2==null)
			return true;
		else if(priceMin1==null || priceMin2==null)
			return false;
		else
			return priceMin1.intValue() == priceMin2.intValue();
	}
	private boolean priceMaxEquals(Integer priceMax1, Integer priceMax2) {
		
		if(priceMax1==null && priceMax2==null)
			return true;
		else if(priceMax1==null || priceMax2==null)
			return false;
		else
			return priceMax1.intValue() == priceMax2.intValue();
	}
	private boolean quantityMinEquals(Integer quantityMin1, Integer quantityMin2) {
		
		if(quantityMin1==null && quantityMin2==null)
			return true;
		else if(quantityMin1==null || quantityMin2==null)
			return false;
		else
			return quantityMin1.intValue() == quantityMin2.intValue();
	}
	private boolean quantityMaxEquals(Integer quantityMax1, Integer quantityMax2) {
		
		if(quantityMax1==null && quantityMax2==null)
			return true;
		else if(quantityMax1==null || quantityMax2==null)
			return false;
		else
			return quantityMax1.intValue() == quantityMax2.intValue();
	}
	private boolean statusEquals(Status status1, Status status2) {
		
		if(status1==null && status2==null)
			return true;
		else if(status1==null || status2==null)
			return false;
		else
			return status1 == status2;
	}
}
