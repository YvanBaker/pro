package com.yvan.util;


import com.yvan.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

/**
 * JWT工具类
 */
public class JwtUtils {

    public static final String SUBJECT = "yvan";

    //过期时间，毫秒，一天
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    //秘钥
    public static final String APPSECRET = "yvna1314";

    /**
     * 生成JWT
     * @param user 用户
     * @return token
     */
    public static String geneJsonWebToken(User user){
        if (user == null || user.getName() == null || user.getPassword() == null){
            return null;
        }
        return Jwts.builder().setSubject(SUBJECT)
                        .claim("name", user.getName())
                        .claim("password", user.getPassword())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                        .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();
    }

    @Nullable
    public static Claims checkJWT(String token){
        try {
            final Claims claims;
            claims = Jwts.parser().setSigningKey(APPSECRET)
                        .parseClaimsJws(token).getBody();
            return claims;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
