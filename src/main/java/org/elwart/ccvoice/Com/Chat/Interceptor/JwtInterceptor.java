package org.elwart.ccvoice.Com.Chat.Interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.elwart.ccvoice.Com.Common.Entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.validation.constraints.NotNull;

@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    // before controller method
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response,@NotNull Object handler) throws Exception {
        String jwt = request.getHeader("Authorization");
        //直接放行
        if(jwt == null){
            return true;
        }
        Claims claims;
        log.info("Receive JWT: "+jwt);
        try{
            claims= Jwts.parser().setSigningKey("secretKey").parseClaimsJws(jwt).getBody();
            response.setContentType("application/json;charset=utf-8");
        }catch (ExpiredJwtException e){
            response.getWriter().print("{\"code\":9004,\"msg\":\"凭证过期，请重新登录\",\"data\":null}");
            return false;
        }catch (SignatureException e){
            response.getWriter().print("{\"code\":9005,\"msg\":\"无效的凭证，请重新登录\",\"data\":null}");
            return false;
        }
        //打包
        String username = claims.get("username",String.class);
        String nickname = claims.get("nickname",String.class);
        String email = claims.get("email",String.class);
        User user = User.builder().username(username).nickname(nickname).email(email).build();
        request.setAttribute("user",user);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
