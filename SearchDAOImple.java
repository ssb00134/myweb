package testPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class SearchDAOImple implements OracleQuery, SearchDAO {
	
	private static SearchDAOImple instance = null;
	
	public static SearchDAOImple getInstance() {
		if(instance == null) {
			instance = new SearchDAOImple();
		}
		return instance;
	}
	
	private void closeResource(Connection conn, Statement stmt) { // 리소스 해제 할려고 만든다.
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end closeResource()

	// conn, stmt, rs 리소스 해제 함수
		private void closeResource(Connection conn, Statement stmt, ResultSet rs) {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end closerResource()
	

	
	private SearchDAOImple() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("DB등록 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<CompanyVO> SelectCompany() {
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_COMPANY_SELECT);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				  int companyNO = rs.getInt(1);
				  String companyName = rs.getString(2);
				  String companyAdr = rs.getString(3);
				  String companySector = rs.getString(4);
				  String companyMenu =rs.getString(5);
				  String companyPhone = rs.getString(6);
				  CompanyVO vo = new CompanyVO(companyNO, companyName, companyAdr, companySector, companyMenu, companyPhone);
				  list.add(vo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				closeResource(conn, pstmt,rs);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	@Override
	public int DeleteCompany(int CompanyNO) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_COMPANY_Delete);
			pstmt.setString(1, COMPANY_NO);

			// 6. SQL 문장 실행 (DB 서버로 전송)
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt);
		}

		return result;
	}
	@Override
	public int InsertCompany(CompanyVO vo) {

		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_COMPANY_INSERT);

			pstmt.setString(1, vo.getCompanyName());
			pstmt.setString(2, vo.getCompanyAdr());
			pstmt.setString(3, vo.getCompanySector());
			pstmt.setString(4, vo.getCompanyMenu());
			pstmt.setString(5, vo.getCompanyPhone());
			

			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt);
		}
		return result;
	}
	
	@Override
	public ArrayList<String> SelectCompanyMenu() {
		ArrayList<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_COMPANY_SELECT_MENU);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 String companyMenu =rs.getString(5);
				 System.out.println(companyMenu);
				 list.add(companyMenu);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				closeResource(conn, pstmt,rs);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
	}
};
