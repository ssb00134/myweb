package testPackage;

import java.util.ArrayList;

public interface SearchDAO {
	public abstract ArrayList<CompanyVO> SelectCompany();
	public abstract int DeleteCompany(int CompanyNO);
	public abstract int InsertCompany(CompanyVO vo);
	//테스트용
	public abstract int CountAllCompany();
	
	public abstract ArrayList<String> SelectCompanyMenu();
}
