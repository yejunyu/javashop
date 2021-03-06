package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer checkUsername(String username);

    User selectLogin(@Param("username") String username, @Param("password") String password);

    Integer checkEmail(String email);

    int checkPhone(String phone);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username") String username,
                    @Param("question") String question, @Param("answer") String answer);

    int updatePasswordByUsername(@Param("username") String username, @Param("password") String passwordNew);

    int checkPassword(@Param("password") String password, @Param("userId") int userId);

    int checkEmailByUserId(@Param("email") String email, @Param("userId") int userId);
}