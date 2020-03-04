package testPackage;

import java.util.ArrayList;

public interface OracleQuery {
	public static final String URL = "jdbc:oracle:thin:localhost:orcl"; // ������ ����Ŭ DB ���
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	//[���̺� ����]
	public static final String COMPANY = "company";
	//end [���̺� ����]
	
	//[���ڵ� ����]
	public static final String COMPANY_NO = "COMPANY_NO";
	public static final String COMPANY_NAME= "COMPANY_NAME";
	public static final String COMPANY_ADR= "COMPANY_ADR";
	public static final String COMPANY_SECTOR = "COMPANY_SECTOR";
	public static final String COMPANY_MENU = "COMPANY_MENU";
	public static final String COMPANY_PHONE = "COMPANY_PHONE";
	//end [���ڵ� ����]
	
	
	//[sql�� ����]
	public static final String SQL_COMPANY_SELECT = 
			"select distinct * from company order by company_menu";
			//"select * from " + COMPANY + " order by " + COMPANY_NO;
	public static final String SQL_COMPANY_Delete = 
			"delete from company where COMPANY_NO = ?";
	public static final String SQL_COMPANY_INSERT = 
	"insert into company values(company_no.nextval, ?, ?, ? , ? , ? )";
	
	//�׽�Ʈ
	public static final String SQL_COMPANY_SELECT_MENU =
			"select distinct company_menu from company";

}
