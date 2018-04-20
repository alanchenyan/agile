package part_1.db_2.exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Alan Chen
 * 2017-12-31 下午9:04:59
 * 
 * Point out and remove the duplation in the code
 */
public class ParticipantsInDB {

	private Connection db;
	
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
	
	public void deleteAllParticipant() throws SQLException{
		PreparedStatement st = db.prepareStatement("delete from participants");
		try {
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st.close();
		}
	}
	
	public int getCount() throws SQLException{
		PreparedStatement st = db.prepareStatement("select count(*) form participants");
		try {
			ResultSet rs = st.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st.close();
		}
		return 0;
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


