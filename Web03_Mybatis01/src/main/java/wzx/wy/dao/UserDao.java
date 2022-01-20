package wzx.wy.dao;

import wzx.wy.pojo.User;

import java.util.List;

public interface UserDao {
    /*
    查询所有数据
     */
    List<User> findAll();
}
