package mybatis_001;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.china.mapper.UserMapper;
import com.china.pojo.User;

public class UserTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	//@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.err.println(user);
	}
	//@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> user = userMapper.findUserByName("Ð¡Ã÷");
		for (User user2 : user) {
			System.out.println(user2);
		}
		
	}
	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setName("Àî°×ºÙ");
		user.setAddress("ÂåÑô");
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.rollback(true);
		
		sqlSession.close();
	}
	//@Test
	public void testDeleteUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUserById(33);
		sqlSession.commit();
		sqlSession.close();
	}
	//@Test
	public void testUpdateUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setName("ÎâÒà·²");
		user.setId(34);
		userMapper.updateUserById(user);
		sqlSession.commit();
		sqlSession.close();
		
	}
	//@Test
	public void testFindCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int count = userMapper.findUserCount();
		System.out.println(count);
	}
		

}
