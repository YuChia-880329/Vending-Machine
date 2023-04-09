package service.backend.goodsList;

import java.util.ArrayList;
import java.util.List;

import bean.dto.vo.backend.goodsList.BGLRParameterDTO;
import database.goods.GoodsModelDAO;
import enumeration.Status;
import service.dao.QueryObj;

public class BGLRParameterService {

	private static final BGLRParameterService INSTANCE = new BGLRParameterService();
	
	private BGLRParameterService() {
	}
	
	public static BGLRParameterService getInstance() {
		
		return INSTANCE;
	}
	
	public QueryObj[] getQueryObjs(BGLRParameterDTO parameter) {
		
		List<QueryObj> list = new ArrayList<>();
		
		QueryObj idQueryObj = getIdQueryObj(parameter.getIdMin(), parameter.getIdMax());
		if(idQueryObj != null)
			list.add(idQueryObj);
		
		QueryObj nameQueryObj = getNameQueryObj(parameter.getName());
		if(nameQueryObj != null)
			list.add(nameQueryObj);
		
		QueryObj priceQueryObj = getPriceQueryObj(parameter.getPriceMin(), parameter.getPriceMax());
		if(priceQueryObj != null)
			list.add(priceQueryObj);
		
		QueryObj quantityQueryObj = getQuantityQueryObj(parameter.getQuantityMin(), parameter.getQuantityMax());
		if(quantityQueryObj != null)
			list.add(quantityQueryObj);
		
		QueryObj statusQueryObj = getStatusQueryObj(parameter.getStatus());
		if(statusQueryObj != null)
			list.add(statusQueryObj);
		
		return list.toArray(new QueryObj[list.size()]);
	}
	
	public boolean equals(BGLRParameterDTO parameter1, BGLRParameterDTO parameter2) {
		
		return idMinEquals(parameter1.getIdMin(), parameter2.getIdMin())
				&& idMaxEquals(parameter1.getIdMax(), parameter2.getIdMax())
				&& nameEquals(parameter1.getName(), parameter2.getName())
				&& priceMinEquals(parameter1.getPriceMin(), parameter2.getPriceMin())
				&& priceMaxEquals(parameter1.getPriceMax(), parameter2.getPriceMax())
				&& quantityMinEquals(parameter1.getQuantityMin(), parameter2.getQuantityMin())
				&& quantityMaxEquals(parameter1.getQuantityMax(), parameter2.getQuantityMax())
				&& statusEquals(parameter1.getStatus(), parameter2.getStatus());
	}
	
	private QueryObj getIdQueryObj(Integer idMin, Integer idMax) {
		
		if(idMin==null && idMax==null)
			return null;
		else if(idMin!=null && idMax!=null)
			return GoodsModelDAO.getIdBetweenQueryObj(idMin, idMax);
		else if(idMin != null)
			return GoodsModelDAO.getIdGreaterThanOrEqualToQueryObj(idMin);
		else
			return GoodsModelDAO.getIdLessThanOrEqualToQueryObj(idMax);
	}
	private QueryObj getNameQueryObj(String name) {
		
		if(name == null)
			return null;
		else
			return GoodsModelDAO.getNameLikeQueryObj(name);
	}
	private QueryObj getPriceQueryObj(Integer priceMin, Integer priceMax) {
		
		if(priceMin==null && priceMax==null)
			return null;
		else if(priceMin!=null && priceMax!=null)
			return GoodsModelDAO.getPriceBetweenQueryObj(priceMin, priceMax);
		else if(priceMin != null)
			return GoodsModelDAO.getPriceGreaterThanOrEqualToQueryObj(priceMin);
		else
			return GoodsModelDAO.getPriceLessThanOrEqualToQueryObj(priceMax);
	}
	private QueryObj getQuantityQueryObj(Integer quantityMin, Integer quantityMax) {
		
		if(quantityMin==null && quantityMax==null)
			return null;
		else if(quantityMin!=null && quantityMax!=null)
			return GoodsModelDAO.getQuantityBetweenQueryObj(quantityMin, quantityMax);
		else if(quantityMin != null)
			return GoodsModelDAO.getQuantityGreaterThanOrEqualToQueryObj(quantityMin);
		else
			return GoodsModelDAO.getQuantityLessThanOrEqualToQueryObj(quantityMax);
	}
	private QueryObj getStatusQueryObj(Status status) {
		
		if(status == null)
			return null;
		else if(status == Status.ON)
			return GoodsModelDAO.getStatus1QueryObj();
		else
			return GoodsModelDAO.getStatus0QueryObj();
			
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
