package org.zerock.web.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.zerock.common.AbstractExecutor;
import org.zerock.web.member.vo.MemberVO;

public class MemberDAO {

	
	public MemberVO findByIdAndPw(String id, String pw) throws RuntimeException{
		
		MemberVO vo = new MemberVO();
		
		String query = "select * from tbl_member where mid=? and mpw=?";
		
		new AbstractExecutor() {
			
			@Override
			protected void doJob(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception {
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				
				rs = pstmt.executeQuery();
				
				if(rs.next() == false) {
					return;
				}
				
				vo.setMid(rs.getString(1));
				vo.setMpw(rs.getString(2));
				vo.setMname(rs.getString(3));
				vo.setPhone(rs.getString(4));
				vo.setRegdate(rs.getDate(5));
				vo.setGrade(rs.getString(6));
				
			}
		}.execute();
		
		return vo;
	}
	
}
