package wzx.wy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wzx.wy.dao.UserDao;
import wzx.wy.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    private UserDao userDao;
    private SqlSession openSession;
    private InputStream is;
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        is = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(is);
    }


    @Before
    public void test01() throws IOException {
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取SqlSession
        openSession = sqlSessionFactory.openSession();
        //获取接口实现类代理对象

        try {
            //获取接口的实现类对象
            //会为接口生成一个代理对象,执行增删改查的..
            userDao = openSession.getMapper(UserDao.class);
            List<User> userList = userDao.findAll();
            for (User user:userList) {
                System.out.println(user);
            }
        } finally {
//            openSession.close();
        }
    }

    @Test
    public void addUser(){
        //调用userDao对象的addUser方法添加用户
        User user = new User(null, "法外狂徒张三", "男", new Date(),"上海");
        //用户添加之前的id为null
        int i = userDao.addUser(user);
        //目标是添加完用户之后，获取到该用户的id : 在以后的多表中，进行关联添加
//        System.out.println(i);
        System.out.println(user.getUid());
    }

    //查询
    @Test
    public void searchById(){
        System.out.println(userDao.searchById(1));
    }

    //多个查询
    @Test
    public void searchUserByUsernameAndAddress(){
        System.out.println(userDao.searchUserByUsernameAndAddress("王五", "上海"));
    }

    //修改
    @Test
    public void updateUser(){
        User user = new User(1,"张三","男",new Date(),"上海");
        userDao.updateUser(user);
    }
    //修改
    @Test
    public void updateuser(){
        Map<String,Object> map = new HashMap<>();
        map.put("uid",1);
        map.put("username","王五");
        map.put("sex","男");
        map.put("birthday",new Date());
        map.put("address","上海");
        userDao.updateuser(map);
    }

    @Test
    public void testDeleteById(){
        //根据id删除用户
        System.out.println(userDao.deleteById(9));
    }

    //模糊查询,根据用户名查询
    @Test
    public void searchByUsername(){
//        System.out.println(userDao.searchByUsername("%三%"));
        System.out.println(userDao.searchByUsername("三"));

    }

    @After
    public void destory() throws IOException {
        //提交事务
        openSession.commit();
        //关闭资源
        openSession.close();
        is.close();
    }
}
