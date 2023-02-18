package com.iu.s2.util;

public class Pager {
	Long perPage;
	Long page;
	Long startRow;
	Long lastRow;
	Long startNum;
	Long lastNum;
	Long totalPage;
	Long perBlock;
	public Long getPerBlock() {
		if(this.perBlock==null || this.perBlock<1) {this.perBlock=5L;}
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	boolean before, after;
	
	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}

	public void setPageNum(Long totalCount) {
		totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		if(this.getPage()>totalPage) { this.setPage(totalPage); }
		
		Long totalBlock=totalPage/this.getPerBlock();
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;

		this.after=true;
		if(curBlock==totalBlock) {
			lastNum = totalPage; 
			this.after=false;
		}

		if(curBlock==1) {
			this.before=true;
		}
		
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

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
}
