package com.ujn.hxl.inter;

import com.ujn.hxl.model.Article;
import com.ujn.hxl.model.User;
import com.ujn.hxl.util.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lss on 2017/5/21.
 */
public interface IUserOperation {
    public User selectUserByID(int id);
    public List<User> selectUsers(String userName);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public List<Article> getUserArticles(int id);
    public List<Article> selectArticleListPage(@Param("page") PageInfo page, @Param("userid") int userid);
}
