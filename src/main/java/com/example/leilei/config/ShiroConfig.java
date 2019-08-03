package com.example.leilei.config;

import com.example.leilei.entity.Permission;
import com.example.leilei.service.IEmployeeService;
import com.example.leilei.service.IPermissionService;
import com.example.leilei.shiro.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
@AutoConfigureAfter(ShiroLifecycleBeanPostProcessorConfig.class)//配置Bean加载的先后顺序
public class ShiroConfig {

    @Autowired
    private IPermissionService permissionService;

    /**
     * SecurityManager核心对象Bean
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //注入Realm
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    /**
     * 凭证比较器-加密加盐加次数
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//加密算法
        hashedCredentialsMatcher.setHashIterations(10);//加密次数
        return hashedCredentialsMatcher;
    }

    /**
     * 自定义的Realm
     * @return
     */
    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }

    /**
     *过滤器配置
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置过滤器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/logout", "logout");

        //权限拦截
        List<Permission> permissions = permissionService.list();
        for (Permission permission : permissions) {
            filterChainDefinitionMap.put(permission.getUrl(),"perms["+permission.getSn()+"]");
        }

        filterChainDefinitionMap.put("/**", "authc");

        //当访问需要认证才能访问的资源，如果没有认证，则跳转到这个资源
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //当访问需要授权才能访问的资源的时候，如果没有权限，则跳转到这个资源
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
