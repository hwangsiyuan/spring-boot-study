package com.hussein.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title: AppAuthenticationSuccessHandler</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/5 7:36 PM
 */
@Component
public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        redirectStrategy.sendRedirect(request, response, targetUrl(authentication));
    }

    private String targetUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roleList = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        if (roleList.contains("ROLE_ADMIN")) {
            return "/admin";
        } else if (roleList.contains("ROLE_USER")) {
            return "/home";
        } else {
            return "accessDenied";
        }
    }
}
