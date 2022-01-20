package wzx.wy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory ;
    static {
        try {
            //把配置文件转换成字节输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建...对象
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            //加载字节输入路
            sqlSessionFactory = factoryBuilder.build(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建sqlsession对象
     * @return
     */
    public static SqlSession openSqlSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 事务提交,然后关闭
     * @param sqlSession
     */
    public static void commit(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 事务回滚并关闭
     * @param sqlSession
     */
    public static void rollBack(SqlSession sqlSession){
        sqlSession.rollback();
        sqlSession.close();
    }
}
