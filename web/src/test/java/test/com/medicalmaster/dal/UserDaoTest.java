package test.com.medicalmaster.dal;

import java.sql.SQLException;
import java.sql.Timestamp;

import junit.framework.TestCase;

import org.junit.Test;

import com.medicalmaster.dal.User;
import com.medicalmaster.dal.UserDao;

public class UserDaoTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	protected static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testUserDao() throws SQLException {
		UserDao dao = new UserDao();
		User user = new User();
		user.setName("jerry");
		user.setCreate_time(new Timestamp(System.currentTimeMillis()));
		user.setAuthentication("aaa");
		user.setDepartment("111");
		user.setDoctor_number("1111111");
		user.setEducation_level(1);
		user.setEmail("jerry@163.com");
		user.setHosptial_id(1);
		user.setIdentity_number("111");
		user.setMobile_phone_number("1122333");
		user.setNick_name("nick_name");
		user.setProfessional_rank(1);
		user.setSex(false);
		user.setTitle("title");
		user.setUser_type(2);
		dao.insert(null, user);
		
	}

	public void testQueryByPkNumberDalHints() {
		fail("Not yet implemented");
	}

	public void testQueryByPkUserDalHints() {
		fail("Not yet implemented");
	}

	public void testCount() {
		fail("Not yet implemented");
	}

	public void testQueryByPage() {
		fail("Not yet implemented");
	}

	public void testGetAll() {
		fail("Not yet implemented");
	}

	public void testInsertDalHintsUser() {
		fail("Not yet implemented");
	}

	public void testInsertDalHintsListOfUser() {
		fail("Not yet implemented");
	}

	public void testInsertDalHintsKeyHolderUser() {
		fail("Not yet implemented");
	}

	public void testInsertDalHintsKeyHolderListOfUser() {
		fail("Not yet implemented");
	}

	public void testBatchInsert() {
		fail("Not yet implemented");
	}

	public void testCombinedInsertDalHintsListOfUser() {
		fail("Not yet implemented");
	}

	public void testCombinedInsertDalHintsKeyHolderListOfUser() {
		fail("Not yet implemented");
	}

	public void testDeleteDalHintsUser() {
		fail("Not yet implemented");
	}

	public void testDeleteDalHintsListOfUser() {
		fail("Not yet implemented");
	}

	public void testBatchDelete() {
		fail("Not yet implemented");
	}

	public void testUpdateDalHintsUser() {
		fail("Not yet implemented");
	}

	public void testUpdateDalHintsListOfUser() {
		fail("Not yet implemented");
	}

	public void testBatchUpdate() {
		fail("Not yet implemented");
	}

}
