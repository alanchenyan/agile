package part_1.db_2.solutions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Alan Chen 2017-12-31 下午9:04:59
 * 
 * The table name is duplicated.The call to "db.preparedStatement" is duplicated
 * 方式：抽取重复代码为类常量
 */
public class ParticipantsInDB {

	static final String tableName = "praticipants";
	private Connection db;

	PreparedStatement makeStatement(String sql) throws SQLException {
		return db.prepareStatement(sql);
	}

	public void addParticipant(Participant part) throws SQLException {
		PreparedStatement st = makeStatement("insert into " + tableName
				+ " values(?,?,?,?)");
		try {
			st.setString(1, part.getId());
			st.setString(2, part.geteFirstName());
			st.setString(3, part.geteLastName());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
		}
	}

	public void deleteAllParticipant() throws SQLException {
		PreparedStatement st = makeStatement("delete from " + tableName);
		try {
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
		}
	}

	public int getCount() throws SQLException {
		PreparedStatement st = makeStatement("select count(*) form "
				+ tableName);
		try {
			ResultSet rs = st.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
		}
		return 0;
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
