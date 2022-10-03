import org.testng.annotations.Test;

public class UserDaoTest {
    UserDao userDao = new UserDao();
    @Test
    public void testAddUser(){
        int i = userDao.addUser(new User("dddd", "dddd"));
        System.out.println(i);
    }

    @Test
    public void testSelectUser(){
        int i = userDao.selectUser(new User("dddd", "dddd"));
        System.out.println(i);
    }
}
