package part_1.db_1.tests;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Alan Chen 2017-12-31 下午9:04:59
 */

class InDB {
	private static Connection db;

	private InDB() {
	}

	private static void initDB() {
		try {
			Class.forName("org.postgresql.Driver");
			db = DriverManager.getConnection(
					"jdbc:postgresql://myhoust/ConferenceDB", "PaulChan",
					"myP@ssword");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection sharedInstance() {
		if (db == null) {
			initDB();
		}
		return db;
	}
}

class BaseDB {

	private Connection db = InDB.sharedInstance();

	protected void add(String insertSql, List<Object> values) {
		PreparedStatement st = null;
		try {
			st = db.prepareStatement(insertSql);
			for (int i = 0; i < values.size(); i++) {
				Object obj = values.get(i);
				if (obj instanceof String) {
					st.setString(i + 1, (String) obj);
				} else if (obj instanceof Integer) {
					st.setInt(i + 1, (Integer) obj);
				} else if (obj instanceof Date) {
					st.setDate(i + 1, (Date) obj);
				} else if (obj instanceof Double) {
					st.setDouble(i + 1, (Double) obj);
				}
			}
			st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class ParticipantsInDB extends BaseDB {

	public void addParticipant(Participant part) throws SQLException {

		String insertSql = "insert into organization values(?,?,?,?)";
		List<Object> values = new ArrayList<Object>();
		values.add(part.getId());
		values.add(part.geteFirstName());
		values.add(part.geteLastName());
		super.add(insertSql, values);
	}
}

class OrganizationInDB extends BaseDB {

	public void addOrganization(Organization o) throws SQLException {
		String insertSql = "insert into organization values(?,?,?,?)";
		List<Object> values = new ArrayList<Object>();
		values.add(o.getId());
		values.add(o.geteFirstName());
		values.add(o.geteLastName());
		super.add(insertSql, values);
	}
}


class Participant {
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

class Organization {
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
