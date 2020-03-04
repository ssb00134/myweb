package testPackage;

public class CompanyVO {
	private int CompanyNO;
	private String CompanyName;
	private String CompanyAdr;
	private String CompanySector;
	private String CompanyMenu;
	private String CompanyPhone;
	
	
	public int getCompanyNO() {
		return CompanyNO;
	}
	public void setCompanyNO(int companyNO) {
		CompanyNO = companyNO;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCompanyAdr() {
		return CompanyAdr;
	}
	public void setCompanyAdr(String companyAdr) {
		CompanyAdr = companyAdr;
	}
	public String getCompanySector() {
		return CompanySector;
	}
	public void setCompanySector(String companySector) {
		CompanySector = companySector;
	}
	public String getCompanyMenu() {
		return CompanyMenu;
	}
	public void setCompanyMenu(String companyMenu) {
		CompanyMenu = companyMenu;
	}
	public String getCompanyPhone() {
		return CompanyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		CompanyPhone = companyPhone;
	}
	
	
	
	public CompanyVO(int companyNO, String companyName, String companyAdr, String companySector, String companyMenu,
			String companyPhone) {
	
		CompanyNO = companyNO;
		CompanyName = companyName;
		CompanyAdr = companyAdr;
		CompanySector = companySector;
		CompanyMenu = companyMenu;
		CompanyPhone = companyPhone;
	}
	@Override
	public String toString() {
		return "CompanyVO [CompanyNO=" + CompanyNO + ", CompanyName=" + CompanyName + ", CompanyAdr=" + CompanyAdr
				+ ", CompanySector=" + CompanySector + ", CompanyMenu=" + CompanyMenu + ", CompanyPhone=" + CompanyPhone
				+ "]";
	}
	
	
	
	
	
	
}
