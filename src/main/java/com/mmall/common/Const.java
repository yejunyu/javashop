package com.mmall.common;

/**
 * @author yejunyu
 * @date 18-3-6.
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public static final String PHONE = "phone";

    // 不用枚举，枚举太麻烦，用一个接口来实现选择
    public interface Role {
        int ROLE_CUSTOMER = 1; // 普通用户
        int ROLE_ADMIN = 0; // 管理员
    }
}
