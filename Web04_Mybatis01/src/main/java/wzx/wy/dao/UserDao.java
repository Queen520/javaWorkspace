package wzx.wy.dao;

import wzx.wy.pojo.User;

import java.util.List;

public interface UserDao {

    /*
   增加
   受影响的行数,所以用int
    */
    int addUser(User user);
    /*
    根据id查询
     */
    User searchById(Integer id);
    /*
    修改用户
     */
    void updateUser(User user);
    /*
    删除用户,根据id删除
     */
    int deleteById(Integer id);

    /*
    模糊查询
    通过用户名模糊查询
     */
    List<User> searchByUsername(String username);

    /*
    查询所有数据
     */
    List<User> findAll();



}
