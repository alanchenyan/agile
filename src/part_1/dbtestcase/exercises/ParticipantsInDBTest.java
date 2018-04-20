package part_1.dbtestcase.exercises;


/**
 * Alan Chen
 * 2018-1-1 上午10:53:24
 * 
 * Point out and remove the duplation in the code
 */
public class ParticipantsInDBTest extends TestCase {
	ParticipantsInDB p;

	void setUp() {
		p = ParticipantsInDB.getInstance();
	}

	void tearDown() {
		ParticipantsInDB.freeInstance();
	}

	void testAdd() {
		Participant part1 = new Participant("ABC001", "Kent", "Tong", true,
				"Manager");
		p.deleteAllParticipants();
		p.addParticipants(part1);
		assserEquals(p.getCount(), 1);
	}

	void testAdd2() {
		Participant part1 = new Participant("ABC001", "Kent", "Tong", true,
				"Manager");
		Participant part2 = new Participant("ABC003", "Paul", "Chan", true,
				"Manager");
		p.deleteAllParticipants();
		p.addParticipants(part1);
		p.addParticipants(part2);
		assserEquals(p.getCount(), 2);
	}

	void testEnum() {
		Participant part1 = new Participant("ABC001", "Kent", "Tong", true,
				"Manager");
		Participant part2 = new Participant("ABC003", "Paul", "Chan", true,
				"Manager");
		p.deleteAllParticipants();
		p.addParticipants(part1);
		p.addParticipants(part2);

		ParticipantEnumeratorById penum = new ParticipantEnumeratorById();
		assertTrue(penum.next());
		assertTrue(penum.get().equals(part1));
		assertTrue(penum.next());
		assertTrue(penum.get().equals(part2));

	}

	//补充代码用于辅助编译
	boolean assserEquals(int count, int targetCount) {
		return count == targetCount;
	}

	//补充代码用于辅助编译
	boolean assertTrue(boolean result) {
		return result;
	}
}

//补充代码用于辅助编译
class TestCase {
}

//补充代码用于辅助编译
class Participant {
	Participant() {
	}

	Participant(String id, String firstName, String lastName, boolean b,
			String title) {
	}
}

//补充代码用于辅助编译
class ParticipantsInDB {
	public static ParticipantsInDB getInstance() {
		return new ParticipantsInDB();
	}
	
	public static void freeInstance() {
	}

	public void deleteAllParticipants() {
	}

	public void addParticipants(Participant p) {
	}

	public int getCount() {
		return 1;
	}
}

//补充代码用于辅助编译
class ParticipantEnumeratorById {
	public boolean next() {
		return true;
	}

	public Participant get() {
		return new Participant();
	}
}