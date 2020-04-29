package com.loa.system.oasystem.config;

import com.loa.system.oasystem.entity.employee.GenEmployee;
import com.loa.system.oasystem.service.PermissionService;
import com.loa.system.oasystem.service.RoleService;
import com.loa.system.oasystem.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * @author 李涵林
 * @data 2020/4/10 16:57
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //给资源进行授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        //查询角色
        GenEmployee genEmployee = (GenEmployee) subject.getPrincipal();
        List<String> roles = this.roleService.selectRoleKeys(genEmployee.getEmpid());
        //查询权限
        Set<String> permissions = this.permissionService.selectPermsByUserId(genEmployee.getEmpid());
        if (roles.size() > 0 && !CollectionUtils.isEmpty(roles)) {
            roles.stream().forEach((r) -> {
                if ("admin".equals(r)) {
                    simpleAuthorizationInfo.addRole("admin");
                    simpleAuthorizationInfo.addStringPermission("*:*:*");
                } else {
                    //角色
                    simpleAuthorizationInfo.addRole(r);
                    //权限
                    simpleAuthorizationInfo.addStringPermissions(permissions);
                }
            });
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String password = "";
        if (upToken.getPassword() != null) {
            password = new String(upToken.getPassword());
        }
        GenEmployee login = this.userService.login(upToken.getUsername(), password);
        if (null == login || login.getDel() == 1) {
            //账号不存在
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(login, login.getPassword(), login.getEname());
    }
}
