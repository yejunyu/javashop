package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author yejunyu
 * @date 18-3-6.
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public static final String PHONE = "phone";

    public enum ProductStatusEnum {
        ON_SALE(1, "在线");

        private int code;
        private String value;

        ProductStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public interface ProductListOrderBy {
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    // 不用枚举，枚举太麻烦，用一个接口来实现选择
    public interface Role {
        int ROLE_CUSTOMER = 1; // 普通用户
        int ROLE_ADMIN = 0; // 管理员
    }
}
