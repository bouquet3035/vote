package org.zerock.web;

public class PageMaker {

	private int count;
	private int page;
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	public PageMaker(int count, int page) {
		super();
		this.count = count;
		this.page = page;
		calculate();
	}

	private void calculate() {
		
		int tempEnd = (int)(Math.ceil(page/10.0) * 10);
		startPage = tempEnd - 9;
		
		int realEnd = (int)Math.ceil(count/10.0);
		
		endPage = realEnd < tempEnd?realEnd:tempEnd;
		
		prev = startPage != 1;
		next = tempEnd*10  < count ? true:false;
		
		
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	
	
	
}
