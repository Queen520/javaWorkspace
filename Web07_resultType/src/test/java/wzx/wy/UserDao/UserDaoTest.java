package wzx.wy.UserDao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import wzx.wy.dao.UserDao;
import wzx.wy.pojo.User;
import wzx.wy.utils.SqlSessionFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    @Test
    public void findAll(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        System.out.println(mapper.findAll());
        SqlSessionFactoryUtil.commit(sqlSession);
    }

    @Test
    public void findUserListByAddress(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.findUserListByAddress("上海");
        System.out.println(userList);
        SqlSessionFactoryUtil.commit(sqlSession);
    }

    @Test
    public void findUserListByAddressAndSex(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> listByAddressAndSex = mapper.findUserListByAddressAndSex(new User(null, null, "男", new Date(), "上海"));
        System.out.println(listByAddressAndSex);

//        List<User> userListByAddressAndSex = mapper.findUserListByAddressAndSex(new User());
//        for (User ListByAddressAndSex:userListByAddressAndSex) {
//            System.out.println(ListByAddressAndSex);
//        }

        SqlSessionFactoryUtil.commit(sqlSession);

    }

    @Test
    public void deleteById(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        mapper.deleteById(list);
//        mapper.deleteById(new ArrayList<Integer>(1));
        SqlSessionFactoryUtil.commit(sqlSession);
    }
}
