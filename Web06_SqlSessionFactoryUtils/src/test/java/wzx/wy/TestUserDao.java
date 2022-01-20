package wzx.wy;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import wzx.wy.dao.UserDao;
import wzx.wy.pojo.QueryVo;
import wzx.wy.pojo.User;
import wzx.wy.utils.SqlSessionFactoryUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserDao {
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("uid",1);
        map.put("username","张三丰");
        map.put("sex","男");
        map.put("birthday",new Date());
        map.put("address","上海");
        mapper.updateuser(map);
        //提交事务,并关闭
        SqlSessionFactoryUtil.commit(sqlSession);
    }

    //QueryVo里面的
    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setSex("男");
        user.setAddress("上海");

        //5L
        QueryVo queryVo = new QueryVo(1l,4,user);
        List<User> userList = mapper.searchByCondition(queryVo);
        for (User user1 : userList) {
            System.out.println(user1);
        }
        SqlSessionFactoryUtil.commit(sqlSession);
    }
}
