package testPackage;

public class MemberVO {
	private int MemNO;
	private String MemId;
	private String MemPw;
	private String MemName;
	private String MemAdr;
	private int MemPhone;
	
	
	
	public String getMemId() {
		return MemId;
	}


	public void setMemId(String memId) {
		MemId = memId;
	}


	public String getMemPw() {
		return MemPw;
	}


	public void setMemPw(String memPw) {
		MemPw = memPw;
	}


	public int getMemNO() {
		return MemNO;
	}


	public void setMemNO(int memNO) {
		MemNO = memNO;
	}


	public String getMemName() {
		return MemName;
	}


	public void setMemName(String memName) {
		MemName = memName;
	}


	public String getMemAdr() {
		return MemAdr;
	}


	public void setMemAdr(String memAdr) {
		MemAdr = memAdr;
	}


	public int getMemPhone() {
		return MemPhone;
	}


	public void setMemPhone(int memPhone) {
		MemPhone = memPhone;
	}


	public MemberVO(int memNO, String memName, String memAdr, int memPhone) {
		super();
		MemNO = memNO;
		MemName = memName;
		MemAdr = memAdr;
		MemPhone = memPhone;
	}


	public MemberVO(int memNO, String memId, String memPw, String memName, String memAdr, int memPhone) {
		super();
		MemNO = memNO;
		MemId = memId;
		MemPw = memPw;
		MemName = memName;
		MemAdr = memAdr;
		MemPhone = memPhone;
	}
	
	
	

}
