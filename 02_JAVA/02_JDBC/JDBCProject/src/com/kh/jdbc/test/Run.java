package com.kh.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Run {
	/*
	 *JDBC를 사용하기 위해서는 자바프로젝트에 JDBC드라이버를 추가해줘야한다.
	 *프로젝트 우틀릭 -> properties -> java build path->...->ojdbc.jar추가
	 *
	 *JDBC용 객체
	 *-Connection : DB의 연결정보를 담고있는 객체
	 *- [prepared]statement : 연결된 DB에 
	 * */
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null; //DB연결정보 보관 객체
		Statement stmt = null; //sql문을 전달해서 실행후 결과를 받아올 객체
		int result = 0;
		
		System.out.print("번호 : ");
		int tno = sc.nextInt();
		sc.nextLine();
		
		System.out.print("이름 : ");
		String tName = sc.nextLine();
		
		String sql = "INSERT INTO TEST VALUES("+tno+", '"+tName+"',SYSDATE)";
		
		//1) JDNC Driver등록
		//Class.forName()->문자열로 주어진 클래스 이름을 찾아서 JVM에 로드함.
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");//오타 ||ojbc.jar파일 추가x
			
			//127.0.0.1 - > 무조건 적으로 지금 실행중인 컴퓨터의 ip(localhost)
			//2)Connection생성(url, 계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##JDBC","JDBC");
			conn.setAutoCommit(false);
			
			//3)statement생성
			stmt = conn.createStatement();
			
			//4, 5) sql문 전달 후 결과를 받음(insert, update, delete ->)
			result = stmt.executeUpdate(sql);
			//트레젝션 처리
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//다쓴 자원 반납
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	*/
	/*
	public static void main(String[] args) {
		//select -> 결과 : resultSet->데이터 추출
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Test> list = new ArrayList<>();
		
		String sql = "SELECT * FROM TEST";
		
		try {
			//1) JDBC 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 등록완료");
			
			//2) Connection생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##JDBC","JDBC");
			
			//3) statement생성
			stmt = conn.createStatement();
			
			//4,5)sql문 전달하면서 결과받기(select -> ResultSet)
			rset = stmt.executeQuery(sql);
			
			//rset.next() -> rset의 다음행이 있는지 없는지를 알려주고 + 다음행을 가르킨다.
			
			while(rset.next()) {
				int tno = rset.getInt("TNO");
				String tName = rset.getString("TNAME");
				Date tDate = rset.getDate("TDATE");
				
				list.add(new Test(tno, tName, tDate.toLocalDate()));
			}
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) {
			System.out.println("데이터 없음");
		}else {
			System.out.println(list);
		}
		
	}
	*/
	//3 PreparedStatement객체 사용 -> sql문을 형태를 먼저 정의 하고 각 데이터는 추후에 넣는 방법
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		System.out.print("수정할 번호를 입력 : ");
		int tno = sc.nextInt();
		
		System.out.print("새로운 이름을 입력 : ");
		String newName = sc.next();
		
		System.out.print("새로운 날자 입력(YYYY-MM-DD): ");
		String newDate = sc.next();
		sc.nextLine();
		
		/*
		 * String sql = "UPDATE TEST SET TNAME = '"+newName+
		 * ", TDATE = TO_DATE('"+newDate+"', 'YYYY-MM-DD')"+ "WHERE TNO = "+tno;
		 */
		
		String sql = "UPDATE TEST SET TNAME=?, TDATE=TO_DATE(?,'YYYY-MM-DD') WHERE TNO=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##JDBC","JDBC");
			conn.setAutoCommit(false);
			
			//미완성된 sql문을 전달해서 pstmt객체생성
			pstmt = conn.prepareStatement(sql);
			
			//pstmt에 작성하지않은 값들을 메서드를 통해 완성(?개수만큼)
			pstmt.setString(1, newName);
			pstmt.setString(2, newDate);
			pstmt.setInt(3, tno);
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		if(result>0) {
			System.out.println(result+ "개의 행 update");
		}else{
			System.out.println("update 실패");
		}
	}
	
}
