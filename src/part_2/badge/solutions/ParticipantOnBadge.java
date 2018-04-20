package part_2.badge.solutions;

/**
 * Alan Chen
 * 2018-1-6 下午10:14:09
 */

//PS:类名取得好
public class ParticipantOnBadge {

	String participantId;
	String participantEngFullName; 
	String participantChiFullName;
	String engOrgName;
	String chiOrgName;
	String engOrgCountry;
	String chiOrgCountry;

	ParticipantOnBadge(String participantId) {
		loadInfoFromDB(participantId);
	}
	
	//PS ：这个方法加得好
	void loadInfoFromDB(String participantId){
		this.participantId = participantId;
		getParticipantFullName();
		getOrgNameAndCountry();
	}

	private void getParticipantFullName() {
		ParticipantsInDB partsInDB = ParticipantsInDB.getInstance();
		Participant part = partsInDB.locateParticipant(participantId);
		if (part != null) {
			//PS:还可以优化
			participantEngFullName = part.getEFullName();
			participantChiFullName =part.getCFullName();
		}
	}

	private void getOrgNameAndCountry() {
		OrganizationInDB orgsInDB = OrganizationInDB.getInstance();
		String oid = orgsInDB.getOrganization(participantId);
		if (oid != null) {
			Organization org = orgsInDB.locateOrganization(oid);
			engOrgName = org.getEngOrgName();
			chiOrgName = org.getChiOrgName();
			engOrgCountry = org.getEngCountry();
			chiOrgCountry = org.getChiCountry();
		}
	}
}

// 补充代码用于辅助编译
class ParticipantsInDB {
	public static ParticipantsInDB getInstance() {
		return null;
	}

	public Participant locateParticipant(String pid) {
		return null;
	}
}

// 补充代码用于辅助编译
class OrganizationInDB {
	public static OrganizationInDB getInstance() {
		return null;
	}

	public String getOrganization(String pid) {
		return null;
	};

	public Organization locateOrganization(String oid) {
		return null;
	}
}

// 补充代码用于辅助编译
class Organization {
	private String engOrgName;
	private String chiOrgName;
	private String engCountry;
	private String chiCountry;

	public String getEngOrgName() {
		return engOrgName;
	}

	public String getChiOrgName() {
		return chiOrgName;
	}

	public String getEngCountry() {
		return engCountry;
	}

	public String getChiCountry() {
		return chiCountry;
	}
}

// 补充代码用于辅助编译
class Participant {
	private String ELastName;
	private String EFirstName;
	private String CLastName;
	private String CFirstName;
	
	public String getEFullName(){
		return ELastName +","+EFirstName;
	}
	
	public String getCFullName(){
		return CLastName +","+CFirstName;
	}
}
