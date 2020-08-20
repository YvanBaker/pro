package com.yvan.util;

import com.yvan.entity.User;
import io.jsonwebtoken.Claims;
import junit.framework.TestCase;

/**
 * @author Yvan
 * @Description JwtUtils 的 测试类
 * @Classname JwtUtilsTest
 * @Date 2020/8/20 9:43
 */
public class JwtUtilsTest extends TestCase {


    public void testGeneJsonWebToken() {
        System.out.println(JwtUtils.geneJsonWebToken(new User("yvan", "123")));
        assertTrue(true);
    }

    public void testCheckJWT() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5dmFuIiwibmFtZSI6Inl2YW4iLCJwYXNzd29yZCI6IjEyMyIsImlhdCI6MTU5Nzg4ODg4NCwiZXhwIjoxNTk3ODg4ODg0fQ.kmKk-RfmK_1RypfWKsVjiFLdH8F8yE1lXWRIMx_Hans";
        Claims claims = JwtUtils.checkJWT(token);
        assert claims != null;
        System.out.println(((String) claims.get("name")));
        System.out.println(((String) claims.get("password")));
        assertTrue(true);
    }
}