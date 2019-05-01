package Entity;

import java.util.ArrayList;
import java.util.List;

public class BaseEntity <T>{
private List<T> resultList= new ArrayList<>();
private Integer page;
private Integer maxPageItem;
private Integer totalPage;
private Integer totalItem;


public Integer getTotalItem() {
	return totalItem;
}

public void setTotalItem(Integer totalItem) {
	this.totalItem = totalItem;
}

public Integer getPage() {
	return page;
}

public void setPage(Integer page) {
	this.page = page;
}

public Integer getMaxPageItem() {
	return maxPageItem;
}

public void setMaxPageItem(Integer maxPageItem) {
	this.maxPageItem = maxPageItem;
}

public Integer getTotalPage() {
	return totalPage;
}

public void setTotalPage(Integer totalPage) {
	this.totalPage = totalPage;
}

public List<T> getResultList() {
	return resultList;
}

public void setResultList(List<T> resultList) {
	this.resultList = resultList;
}

}
