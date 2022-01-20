package wzx.wy.dao;

import org.apache.ibatis.annotations.Param;
import wzx.wy.pojo.User;
import wzx.wy.pojo.UserInfo;

import java.util.List;

public interface UserDao {
    /*
    查询所有用户信息
     */
    List<UserInfo> findAll();
    /**
     * 根据address查询用户,如果没有传入地址则查询出所有用户

     */
    List<User> findUserListByAddress(@Param("address") String address);
    /**
     * 根据用户的地址和性别查询用户, 如果有address才考虑address的条件，如果有sex才考虑sex的
     条件
     */
    List<User> findUserListByAddressAndSex(User user);

    /*
    批量删除: 根据id的集合删除所有元素
     */
    void deleteById(List<Integer> id);

}
