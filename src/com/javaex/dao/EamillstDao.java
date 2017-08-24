package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaex.vo.EmaillistVo;
@Repository
public class EamillstDao {
	
	
	public List<EmaillistVo>  getlist() {
		List<EmaillistVo> emaillist = new ArrayList<EmaillistVo>(); //이메일리스트를  모을 리스트하나만듬 
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
				String query = "select no,last_name,FIRST_NAME,adress,email from emaillist ";
				pstmt = conn.prepareStatement(query);
				
				
				//insert 에  유동적인 문장 설정을 위해 들어갔던것이 없어짐 
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int no= rs.getInt(1);
					String lastName = rs.getString(2);
					String firstName= rs.getString(3);
					String adress= rs.getString(4);
					String email= rs.getString(5);
					
					EmaillistVo vo= new EmaillistVo(no,lastName,firstName,adress,email);
					emaillist.add(vo);
					
					
				}
				
				
				
				System.out.println();
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
		
	
		
		return emaillist;
		
	}

	
	public int insert(EmaillistVo vo) {
		int countdb=0;
		//코드 짤거임 
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
				String query = "insert into emaillist values  (seq_email_no.nextval, ?,?,?,?)";
				pstmt = conn.prepareStatement(query);
				
				
				pstmt.setString(1, vo.getFirstName());
				pstmt.setString(2, vo.getLastName()); //위와 같은방법임 . 
				pstmt.setString(4, vo.getEmail()); //위와 같은방법임 
				pstmt.setString(3, vo.getAdress()); //위와 같은방법임 
				
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
