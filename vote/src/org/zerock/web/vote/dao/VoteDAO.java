package org.zerock.web.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.zerock.common.AbstractExecutor;
import org.zerock.web.vote.vo.VoteResultVO;
import org.zerock.web.vote.vo.VoteVO;

public class VoteDAO {
	
	public void create(VoteResultVO vo) {
	
		String sql ="insert into tbl_vote_result(vno, voter, understand) values(?,?,?)";
		
		new AbstractExecutor() {
			
			@Override
			protected void doJob(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception {
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,vo.getVno());
				pstmt.setString(2, vo.getVoter());
				pstmt.setInt(3, vo.getUnderstand());
				
				int count = pstmt.executeUpdate();
				
				System.out.println("COUNT: " + count);
				
			}
		}.execute();
	
	}

	public VoteVO get(Integer vno) {

		String query = "select * from tbl_vote where vno = ? ";

		VoteVO vo = new VoteVO();

		new AbstractExecutor() {

			@Override
			protected void doJob(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception {

				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, vno);
				rs = pstmt.executeQuery();

				while (rs.next()) {

					vo.setVno(rs.getInt(1));
					vo.setTitle(rs.getString(2)); 
					vo.setDescp(rs.getString(3));
					vo.setWriter(rs.getString(4));
					vo.setRegdate(rs.getDate(5));
					vo.setEnddate(rs.getDate(6));
					
				}

			}
		}.execute();

		return vo;

	}

	public void register(VoteVO vo) {

		String sql = "insert into tbl_vote (vno, descp, title, writer) values (seq_vote.nextval, ?,?,?)";

		new AbstractExecutor() {

			@Override
			protected void doJob(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getDescp());
				pstmt.setString(2, vo.getTitle());
				pstmt.setString(3, vo.getWriter());

				int count = pstmt.executeUpdate();

				System.out.println("COUNT: " + count);

			}
		}.execute();

	}
	
	public int getTotal() {
		
		StringBuffer buffer = new StringBuffer();
		
		new AbstractExecutor() {
			
			@Override
			protected void doJob(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception {
				
				pstmt = con.prepareStatement("select count(*) from tbl_vote");
				
				rs = pstmt.executeQuery();
				
				rs.next();
				
				buffer.append(rs.getInt(1));
				
			}
		}.execute();
		
		return Integer.parseInt(buffer.toString());
		
	}

	public List<VoteVO> getList(int page) {

		String query = "select vno, title, descp, writer, regdate, enddate \r\n" + "from \r\n" + "  (\r\n"
				+ "    select rownum rn, vno, title, descp, writer, regdate, enddate \r\n" + "    from tbl_vote \r\n"
				+ "    where vno > 0 \r\n" + "    and rownum < (? *10)\r\n" + "    order by vno desc\r\n" + ") \r\n"
				+ "where rn >= (? -1) * 10";

		// TODO Auto-generated method stub
		List<VoteVO> list = new ArrayList<>();

		new AbstractExecutor() {

			@Override
			protected void doJob(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception {

				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, page);
				pstmt.setInt(2, page);
				
				rs = pstmt.executeQuery();

				while (rs.next()) {

					VoteVO vo = new VoteVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getDate(5), rs.getDate(6));
					list.add(vo);
				}
			}
		}.execute();

		return list;

	}
}
