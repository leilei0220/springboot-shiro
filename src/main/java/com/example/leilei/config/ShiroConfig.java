package com.example.leilei.config;

import com.example.leilei.entity.Permission;
import com.example.leilei.service.IEmployeeService;
import com.example.leilei.service.IPermissionService;
import com.example.leilei.shiro.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
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
    @Bean(name = "securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //注入Realm
        securityManager.setRealm(myRealm());
        //注入记住我管理器
        securityManager.setRememberMeManager(rememberMeManager());
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
     * cookie对象;
     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
        //System.out.println("ShiroConfiguration.rememberMeCookie()");
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        //System.out.println("ShiroConfiguration.rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }

    /**
     * 自定义的Realm
     * @return
     */
    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        //设置密码加密凭证，登录时会对密码进行加密匹配
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }

    /**
     *过滤器配置 过滤所有权限
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        //新建一个shirofilterbean工厂
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //将shiro安全核心对象存入bean工厂
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置过滤器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        filterChainDefinitionMap.put("/static/**", "anon");   //anon代表资源直接放行
        filterChainDefinitionMap.put("/logout", "logout");    //shiro的退出方法，会注销自己的认证

        //权限拦截，查出所有权限
        List<Permission> permissions = permissionService.list();
        for (Permission permission : permissions) {
            filterChainDefinitionMap.put(permission.getUrl(),"perms["+permission.getSn()+"]");
        }

        filterChainDefinitionMap.put("/**", "authc");

        //当访问需要认证才能访问的资源，如果没有认证，则跳转到这个资源
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
      //  shiroFilterFactoryBean.setSuccessUrl("/index");

        //当访问需要授权才能访问的资源的时候，如果没有权限，则跳转到这个资源
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
