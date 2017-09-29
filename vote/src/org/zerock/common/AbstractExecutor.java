package org.zerock.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractExecutor {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public final void execute()throws RuntimeException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.32:1521:XE","user00","user00");
			
			System.out.println("try");
			System.out.println(con);
			
			con.setAutoCommit(false);
			
			
			doJob(con, pstmt, rs);
			
			con.commit();
			
		}catch(Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		
		}finally {
		
			System.out.println("finally");
			
			if(rs != null) { 
				try {rs.close();}catch(Exception e) {}
			}
			
			if(pstmt != null) { 
				try {pstmt.close();}catch(Exception e) {}
			}
			
			if(con != null) { 
				try {con.close();}catch(Exception e) {}
			}
		}
	}
	
	
	protected abstract void doJob(Connection con, PreparedStatement pstmt, ResultSet rs)throws Exception;
	
}
