package org.zerock.web.vote.vo;

import java.util.Date;

/*
 * create table tbl_vote (
 *   vno number,
 *   title varchar2(500) not null,
 *   desc varchar2(1000) not null default ' ',
 *   writer varchar2(50) default 'admin',
 *   regdate date default sysdate,
 *   enddate date defatult sysdate + (1/(24*60)) *10
 * );
 */
public class VoteVO {
	
	private Integer vno;
	private String title;
	private String descp;
	private String writer;
	private Date regdate, enddate;
	
	private boolean can;
		
	public VoteVO() {
		super();
	}
	
	
	
	public boolean isCan() {
		return enddate.getTime() - System.currentTimeMillis() > 0;
	}



	public VoteVO(Integer vno, String title, String descp, String writer, Date regdate, Date enddate) {
		super();
		this.vno = vno;
		this.title = title;
		this.descp = descp;
		this.writer = writer;
		this.regdate = regdate;
		this.enddate = enddate;
	}
	public Integer getVno() {
		return vno;
	}
	public void setVno(Integer vno) {
		this.vno = vno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	@Override
	public String toString() {
		return "VoteVO [vno=" + vno + ", title=" + title + ", descp=" + descp + ", writer=" + writer + ", regdate="
				+ regdate + ", enddate=" + enddate + "]";
	}
	
	
	

}
