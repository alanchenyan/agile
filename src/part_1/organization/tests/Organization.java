package part_1.organization.tests;

/**
 * Alan Chen
 * 2017-12-31 下午5:32:40
 */
public class Organization {

	private String id;
	private String eName;//English name
	private String cName;//Chinese name
	
	private PhoneNumber telNumber;
	private PhoneNumber faxNumber;
	private ContactPerson contactPerson;
}


class ContactPerson{
	private FullName eName;
	private FullName cName;
	
	private PhoneNumber telNumber;
	private PhoneNumber faxNumber;
	private PhoneNumber mobileNumber;
}

class PhoneNumber{
	private String countryCode;
	private String rreaCode;
	private String cLocalNumber;
}

class FullName{
	private String firstName;
	private String lastName;
}
