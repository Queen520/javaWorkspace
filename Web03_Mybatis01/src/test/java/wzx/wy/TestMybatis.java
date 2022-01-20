package wzx.wy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import wzx.wy.dao.UserDao;
import wzx.wy.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(is);
    }

    /*
    Dao-->DaoImpl
    Dao-->Dao.xml
    SqlSession代表和数据库的一次会话,用完必须关闭
    SqlSession和Connection都是线程非安全的,每一次都应该获取新的对象
    getmapper():mapper没有实现类,mybatis会为这个接口生成动态代理(将接口和xml绑定)
    UserDao mapper = openSession.getMapper(UserDao.class);

    sqlSessionFactory:根据xml配置文件(全局配置文件)获取到一个sqlSessionFactory对象,包含了一些数据源,运行环境信息

    sql映射文件:配置了每一个sql,以及封装规则等
    使用sql唯一标识来告诉mybatis去执行哪个sql语句,sql都是保存在sql映射文件中的
     */
    @Test
    public void test01() throws IOException {
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取SqlSession
        SqlSession openSession = sqlSessionFactory.openSession();
        //获取接口实现类代理对象

        try {
            //获取接口的实现类对象
            //会为接口生成一个代理对象,执行增删改查的..
            UserDao mapper = openSession.getMapper(UserDao.class);
            List<User> userList = mapper.findAll();
            for (User user:userList) {
                System.out.println(user);
            }
        } finally {
            openSession.close();
        }
    }
}
