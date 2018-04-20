package part_1.organization.solutions;

/**
 * Alan Chen 
 * 2017-12-31 下午5:32:40
 * 方式：将重复代码抽取封装为类
 */
public class Organization {

	private String id;
	private String eName;// English name
	private String cName;// Chinese name

	private TelNo telNo;
	private TelNo faxNo;
	private ContactPerson contactPerson;
}

class ContactPerson {
	// PS：name可以再抽取一下
	private String eFirstName;
	private String eLastName;
	private String cFirstName;
	private String cLastName;

	private TelNo tel;
	private TelNo fax;
	private TelNo mobile;
}

// PS：感觉名字取得不是很好
class TelNo {
	private String countryCode;
	private String rreaCode;
	private String cLocalNumber;
}
