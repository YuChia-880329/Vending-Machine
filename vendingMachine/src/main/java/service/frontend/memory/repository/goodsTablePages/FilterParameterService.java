package service.frontend.memory.repository.goodsTablePages;

import java.util.ArrayList;
import java.util.List;

import bean.obj.frontend.repository.goodsTablePages.writeout.FilterParameterOBJ;
import service.model.GoodsModelService;
import template.model.QueryObj;

public class FilterParameterService {

	private static final FilterParameterService INSTANCE = new FilterParameterService();
	
	private FilterParameterService() {
	}
	
	public static FilterParameterService getInstance() {
		
		return INSTANCE;
	}
	
	public QueryObj[] getQueryObjs(FilterParameterOBJ filterParameter) {
		
		List<QueryObj> list = new ArrayList<>();
		
		QueryObj nameQueryObj = getNameQueryObj(filterParameter.getName());
		if(nameQueryObj != null)
			list.add(nameQueryObj);
		
		return list.toArray(new QueryObj[list.size()]);
	}
	public boolean equals(FilterParameterOBJ filterParameter1, FilterParameterOBJ filterParameter2) {
		
		return nameEquals(filterParameter1.getName(), filterParameter2.getName());
	}
	
	
	private QueryObj getNameQueryObj(String name) {
		
		if(name == null)
			return null;
		else
			return GoodsModelService.getNameLikeQueryObj(name);
	}
	
	private boolean nameEquals(String name1, String name2) {
		
		if(name1==null && name2==null)
			return true;
		else if(name1==null || name2==null)
			return false;
		else
			return name1.equals(name2);
	}
}
