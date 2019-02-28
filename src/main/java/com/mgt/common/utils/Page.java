package com.mgt.common.utils;

import java.util.List;

public class Page<T> {
	private Integer pageNum=1;// 当前的页码
	private Integer totalCount;// 总条数，总记录数
	private Integer totalPage;// 总页数
	public Integer pageCount = 10;// 每页默认10条记录
	private Integer rowNum;// 当前页起始行号
	private Integer isProcessor;
	//发起请求类型：0：用品审批，1：用品发放，2：采购申请
	private Integer typeApply;

	private List<T> list;// 当前页的内容

	public Integer getTypeApply() {
		return typeApply;
	}

	public void setTypeApply(Integer typeApply) {
		this.typeApply = typeApply;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageNum < 1) {
			pageNum = 1;
		}
		if (pageNum > totalPage) {
			pageNum = totalPage;
		}
		if (totalPage == 0) {
			pageNum = 1;
		}
		this.pageNum = pageNum;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		if (totalCount % pageCount == 0) {
			this.totalPage = totalCount / pageCount;
		} else {
			this.totalPage = totalCount / pageCount + 1;
		}
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum() {
		this.rowNum = (pageNum - 1) * pageCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	

	public Integer getIsProcessor() {
		return isProcessor;
	}

	public void setIsProcessor(Integer isProcessor) {
		this.isProcessor = isProcessor;
	}

	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", rowNum="
				+ rowNum + ", list=" + list + "]";
	}

	// Page类的设置顺序：
	// 1、setPageCount
	// 2、setTotalCount()
	// 3、setTotalPage()
	// 4、setPageNum()
	// 5、setRowNum()
	public void init(Integer totelCount, Integer pageNum, Integer pageCount) {
		setPageCount(pageCount);
		setTotalCount(totelCount);
		setTotalPage();
		setPageNum(pageNum);
		setRowNum();
	}

}
