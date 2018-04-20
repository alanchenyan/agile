package part_2.badge.tests;

/**
 * Alan Chen
 * 2018-1-6 下午10:12:11
 * 
 * PS:可对比一下solutions 就能体会到差别，并明白还有哪些地方需要提高
 */

//PS:类名还是不直观，参考solutions
public class ParticipantBadge {

	String participantId;
	String participantEngName; // PS:还是没体现"full" name
	String participantChiName;// PS:还是没体现"full" name
	String engOrgName;
	String chiOrgName;
	String engOrgCountry;
	String chiOrgCountry;

	ParticipantBadge(String participantId) {
		this.participantId = participantId;
		setParticipantName();
		setParticipantName();
	}

	private void setParticipantName() {
		ParticipantsInDB partsInDB = ParticipantsInDB.getInstance();
		Participant part = partsInDB.locateParticipant(participantId);
		if (part != null) {
			//PS:还可以优化
			participantEngName = part.getELastName() + ","
					+ part.getEFirstName();
			participantChiName = part.getCLastName() + ","
					+ part.getCFirstName();

		}
	}

	private void setOrgInfo() {
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

	public String getELastName() {
		return ELastName;
	}

	public String getEFirstName() {
		return EFirstName;
	}

	public String getCLastName() {
		return CLastName;
	}

	public String getCFirstName() {
		return CFirstName;
	}
}
