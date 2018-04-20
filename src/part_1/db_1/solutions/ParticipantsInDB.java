package part_1.db_1.solutions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Alan Chen
 * 2017-12-31 下午9:04:59
 * 
 * The code to setup the DB connection is duplicated.Extract it into a separate class
 * 方式：将重复代码抽取封装为类
 * 评：没有我重构的代码好
 */


class ConferenceDBConnection{
	//PS:这种方式不好，每次都需要连接
	static Connection makeConnection() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection("jdbc:postgresql://myhoust/ConferenceDB","PaulChan","myP@ssword");
	}
}

public class ParticipantsInDB {

	private Connection db;
	
	public ParticipantsInDB() throws ClassNotFoundException, SQLException{
		db =ConferenceDBConnection.makeConnection();
	}
	
	public void addParticipant(Participant part) throws SQLException{
		PreparedStatement st = db.prepareStatement("insert into participants values(?,?,?,?)");
		try {
			st.setString(1, part.getId());
			st.setString(2, part.geteFirstName());
			st.setString(3, part.geteLastName());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st.close();
		}
	}
}


 class OrganizationInDB {

	private Connection db;
	
	public OrganizationInDB() throws ClassNotFoundException, SQLException{
		db =ConferenceDBConnection.makeConnection();
	}
	
	public void addOrganization(Organization o) throws SQLException{
		PreparedStatement st = db.prepareStatement("insert into organization values(?,?,?,?)");
		try {
			st.setString(1, o.getId());
			st.setString(2, o.geteFirstName());
			st.setString(3, o.geteLastName());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st.close();
		}
	}
}

class Participant{
	private String id;
	private String eFirstName;
	private String eLastName;
	public String getId() {
		return id;
	}
	public String geteFirstName() {
		return eFirstName;
	}
	public String geteLastName() {
		return eLastName;
	}
}

class Organization{
	private String id;
	private String eFirstName;
	private String eLastName;
	public String getId() {
		return id;
	}
	public String geteFirstName() {
		return eFirstName;
	}
	public String geteLastName() {
		return eLastName;
	}
}

