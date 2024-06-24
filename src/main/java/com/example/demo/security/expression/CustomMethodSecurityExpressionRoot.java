package com.example.demo.security.expression;

import com.example.demo.security.JwtEntity;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Setter
@Getter
public class CustomMethodSecurityExpressionRoot
        extends SecurityExpressionRoot
        implements MethodSecurityExpressionOperations {

    private Object filterObject;
    private Object returnObject;
    private Object target;
    private HttpServletRequest request;

    private UserService userService;

    public CustomMethodSecurityExpressionRoot(
            final Authentication authentication
    ) {
        super(authentication);
    }

    public boolean canAccessUser(
            final Integer id
    ) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        JwtEntity user = (JwtEntity) authentication.getPrincipal();
        Integer userId = user.getId();

        return userId.equals(id) || hasAnyRole("ROLE_ADMIN");
    }

    public boolean canAccessOrder(
            final Integer orderId
    ) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        JwtEntity user = (JwtEntity) authentication.getPrincipal();
        Integer id = user.getId();

        return userService.isOrderOwner(id, orderId) || hasAnyRole("ROLE_ADMIN");
    }

    @Override
    public Object getThis() {
        return target;
    }

}
