package part_2.badge.exercises;

/**
 * Alan Chen
 * 2018-1-6 下午9:50:42
 * 
 * This is a conference management application.In the conference,
 * every partichipant will wear a badge.On the badge there is some information
 * of the participant.Inthe application the Badge class below is used
 * to store this information.Please read the code and comments below:
 */

//It stores the information of a participant to be printed on his badge.
public class Badge {

	String pid;// participant ID
	String engName;//participant's full name in English
	String chiName;//participant's full name in Chinese
	String engOrgName;// name of the participant's organization in English
	String chiOrgName;// name of the participant's organization in Chinese
	String engCountry;// the organization's country in English
	String chiCountry;// the organization's country in Chinese
	
	//constructor.
	//The participant ID is provided.It then loads all the info from the DB.
	Badge(String pid){
		this.pid = pid;
		
		//get the participant's full names
		ParticipantsInDB partsInDB = ParticipantsInDB.getInstance();
		Participant part = partsInDB.locateParticipant(pid);
		if(part !=null){
			// get the participant's full name in English
			engName = part.getELastName()+","+part.getEFirstName();
			// get the participant's full name in Chinese 
			chiName = part.getCLastName()+","+part.getCFirstName();
			
			// get the organization's name and country
			OrganizationInDB orgsInDB = OrganizationInDB.getInstance();
			String oid = orgsInDB.getOrganization(pid);
			if(oid !=null){
				Organization org = orgsInDB.locateOrganization(oid);
				engOrgName = org.getEngOrgName();
				chiOrgName = org.getChiOrgName();
				engCountry = org.getEngCountry();
				chiCountry = org.getChiCountry();
			}
		}
	}
}

//补充代码用于辅助编译
class ParticipantsInDB{
	public static ParticipantsInDB getInstance(){return null;}
	
	public Participant locateParticipant(String pid){return null;}
}

//补充代码用于辅助编译
class OrganizationInDB{
	public static OrganizationInDB getInstance(){return null;}
	
	public String getOrganization(String pid){return null;};
	
	public Organization locateOrganization(String oid){return null;}
}

//补充代码用于辅助编译
class Organization{
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

//补充代码用于辅助编译
class Participant{
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
