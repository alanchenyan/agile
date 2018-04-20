package part_1.dbtestcase.tests;

/**
 * Alan Chen
 * 2018-1-1 上午10:53:24
 */
public class ParticipantsInDBTest extends TestCase {
	ParticipantsInDB p;

	void setUp() {
		p = ParticipantsInDB.getInstance();
	}

	void tearDown() {
		ParticipantsInDB.freeInstance();
	}
	
	//PS:clearData 换成 emptyData 也许更好,或者用cleanData
	private void clearData(){
		p.deleteAllParticipants();
	}
	
	private Participant add_1(){
		Participant part1 = new Participant("ABC001", "Kent", "Tong", true,
				"Manager");
		p.addParticipants(part1);
		return part1;
	}
	
	private Participant add_2(){
		Participant part2 = new Participant("ABC003", "Paul", "Chan", true,
				"Manager");
		p.addParticipants(part2);
		return part2;
	}
	

	void testAdd() {
		//PS:不足之处,clearData(),add_1()是否能有更好的方式？容易忘记写clearData(),先后顺序也容易错，导致代码逻辑错误。
		clearData();
		add_1();
		assserEquals(p.getCount(), 1);
	}

	void testAdd2() {
		clearData();
		add_1();
		add_2();
		assserEquals(p.getCount(), 2);
	}

	void testEnum() {
		clearData();
		Participant part1 = add_1();
		Participant part2 =add_2();

		ParticipantEnumeratorById penum = new ParticipantEnumeratorById();
		assertTrue(penum.next());
		assertTrue(penum.get().equals(part1));
		assertTrue(penum.next());
		assertTrue(penum.get().equals(part2));

	}

	// 假造代码用于辅助编译
	boolean assserEquals(int count, int targetCount) {
		return count == targetCount;
	}

	// 假造代码用于辅助编译
	boolean assertTrue(boolean result) {
		return result;
	}
}

// 假造代码用于辅助编译
class TestCase {
}

// 假造代码用于辅助编译
class Participant {
	Participant() {
	}

	Participant(String id, String firstName, String lastName, boolean b,
			String title) {
	}
}

// 假造代码用于辅助编译
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

// 假造代码用于辅助编译
class ParticipantEnumeratorById {
	public boolean next() {
		return true;
	}

	public Participant get() {
		return new Participant();
	}
}