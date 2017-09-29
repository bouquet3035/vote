package org.zerock.web.vote.vo;

import java.util.Date;

public class VoteResultVO {

	private int vno;
	private String voter;
	private int understand;
	private Date votedate;
	
	
	
	public VoteResultVO() {
		super();
	}
	
	
	
	public VoteResultVO(String vno, String voter, String understand) {
		super();
		this.vno = Integer.parseInt(vno);
		this.voter = voter;
		this.understand = Integer.parseInt(understand);
	}



	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public String getVoter() {
		return voter;
	}
	public void setVoter(String voter) {
		this.voter = voter;
	}
	public int getUnderstand() {
		return understand;
	}
	public void setUnderstand(int understand) {
		this.understand = understand;
	}
	public Date getVotedate() {
		return votedate;
	}
	public void setVotedate(Date votedate) {
		this.votedate = votedate;
	}
	@Override
	public String toString() {
		return "VoteResultVO [vno=" + vno + ", voter=" + voter + ", understand=" + understand + ", votedate=" + votedate
				+ "]";
	}
	
	
}
