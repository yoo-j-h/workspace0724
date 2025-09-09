package com.kh.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

//공토 템플릿(매번 반복정으로 작성될 코드를 메서드 정의)
public class JDBCTemplate {
	//모든 메서드를 전부 statcic메서드로 만듬
	
	//1. connection객체 생성 후 해당 connection객체 반환
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//2. Connection객체를 전달받아 상태를 확인 후 commit하는 메서드
	public static void commit(Connection conn) {
		try {
			if(conn != null && conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//3. Connection객체를 전달받아 상태를 확인 후 rollback하는 메서드
		public static void rollback(Connection conn) {
			try {
				if(conn != null && conn.isClosed()) {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	//4. Statment관련 객체를 전달받나 반납시켜주는 메서드
		public static void close(Statement stmt) {
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	//5. Connection관련 객체를 전달받나 반납시켜주는 메서드
			public static void close(Connection conn) {
				try {
					if(conn != null && !conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		//5. Connection관련 객체를 전달받나 반납시켜주는 메서드
		public static void close(ResultSet rs) {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
