package com.iu.s2.util;

public class Pager {
	Long perPage;
	Long page;
	Long startRow;
	Long lastRow;
	Long startNum;
	Long lastNum;
	
	public void setPageNum(Long totalCount) {
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPage() != 0) {
			totalPage++;
		}
		
		Long perBlock=5L;
		Long totalBlock=totalPage/perBlock;
		if(totalPage%totalBlock != 0) {
			totalBlock++;
		}
		
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		
	}
	
	public void setRowNum() {
		startRow =  (page-1)*perPage+1;
		lastRow  = page * perPage;
	}

	public Long getPerPage() {
		if(perPage == null) { perPage = 10L; }
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {
		if(page == null) { page = 1L; }
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	
	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
}
