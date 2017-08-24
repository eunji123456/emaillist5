package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaex.vo.guestBookVo;


@Repository
public class guestBookDao {
	
	public List<guestBookVo> getlist() {
	
		List<guestBookVo> booklist = new ArrayList<guestBookVo>(); //이메일리스트를  모을 리스트하나만듬 
		ResultSet rs = null;
		
		// TODO Auto-generated method stub
		//0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
				//1. JDBC 드라이버 (Oracle) 로딩
				Class.forName ("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 로딩 ");
				
				//2. Connection 얻어오기
			
				String Url ="jdbc:oracle:thin:@localhost:1521:xe";
				conn =DriverManager.getConnection(Url,"webdb","webdb");
				System.out.println("접속 성공 ");
				
				
				//3. SQL문 준비 / 바인딩 / 실행
				String query = "SELECT NO,NAME,PASSWORD ,CONTENT ,REG_DATE FROM GUESTBOOK ";
				pstmt = conn.prepareStatement(query);
				
				
				//insert 에  유동적인 문장 설정을 위해 들어갔던것이 없어짐 
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int no= rs.getInt(1);
					String NAME = rs.getString(2);
					String PASSWORD= rs.getString(3);
					String CONTENT= rs.getString(4);
					String REG_DATE= rs.getString(5);
					
					guestBookVo vo= new guestBookVo(no,NAME,PASSWORD,CONTENT,REG_DATE);
					booklist.add(vo);
					
					
				}
				
				
			
				// 4.결과처리
				
				
		}catch(ClassNotFoundException e) {
		
			System.out.println("드라이버 로딩  실패 "+e);
			
		}catch(SQLException e ) {
			System.out.println("sql문의 실패  "+e);
		}finally {
			//5. 자원정리
					try {
						
						if(pstmt != null) {
						 pstmt.close();
						}
						if(conn != null) {
						 conn.close();
							}
						}
					catch(SQLException e) {
					System.out.println("sql문의 실패  "+e);
											}
			
					}//finally 괄호 
		
	
		
		return booklist;
		
	}

	
	public int insert(guestBookVo vo) {
		int countdb=0;
		//코드 짤거임 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
				//1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				System.out.println("드라이버 로딩+인설트 ");
				//2. Connection 얻어오기
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn=DriverManager.getConnection(url,"webdb","webdb");
				
				System.out.println("접속 성공 ");
				
				
				//3. SQL문 준비 / 바인딩 / 실행
				String query = "insert into GUESTBOOK values(seq_GESTBOOK_NO.nextval,?,?,?,SYSDATE)";
				pstmt = conn.prepareStatement(query);
				
				
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getPassword()); //위와 같은방법임 . 
				pstmt.setString(3, vo.getContent()); //위와 같은방법임 
				
				countdb = pstmt.executeUpdate();
				System.out.println("처리한 쿼리 개수 : "+countdb);
				// 4.결과처리
				
				
		}catch(ClassNotFoundException e) {
		
			System.out.println("드라이버 로딩  실패 "+e);
			
		}catch(SQLException e ) {
			System.out.println("sql문의 실패  "+e);
		}finally {
			//5. 자원정리
					try {
						
						if(pstmt != null) {
						 pstmt.close();
						}
						if(conn != null) {
						 conn.close();
							}
						}
					catch(SQLException e) {
					System.out.println("sql문의 실패  "+e);
											}
			
		}//finally 괄호 
		
		return countdb;
		
	} 
	public int delete(int no,String password) {
		int countdb =0;
		// TODO Auto-generated method stub
		//0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
				//1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				System.out.println("드라이버 로딩 ");
				//2. Connection 얻어오기
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn=DriverManager.getConnection(url,"webdb","webdb");
				
				System.out.println("접속 성공 ");
				
				
				//3. SQL문 준비 / 바인딩 / 실행
				String query = "delete from GUESTBOOK where no=? and PASSWORD =?";
				pstmt = conn.prepareStatement(query);
				
				
				pstmt.setInt(1,no);
				pstmt.setString(2,password);
				countdb = pstmt.executeUpdate();
				System.out.println("처리한 쿼리 개수 : "+countdb);
				// 4.결과처리
				
				
		}catch(ClassNotFoundException e) {
		
			System.out.println("드라이버 로딩  실패 "+e);
			
		}catch(SQLException e ) {
			System.out.println("sql문의 실패  "+e);
		}finally {
			//5. 자원정리
					try {
						
						if(pstmt != null) {
						 pstmt.close();
						}
						if(conn != null) {
						 conn.close();
							}
						}
					catch(SQLException e) {
					System.out.println("sql문의 실패  "+e);
											}
			
		}//finally 괄호 
		
		return countdb;
	}

	
	
}
