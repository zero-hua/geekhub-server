package ink.geekhub.server.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author linghua
 */
@Configuration
@Slf4j
public class ShiroConfig {

    @Bean
    public Realm getRealm(CredentialsMatcher matcher){
        UserRealm realm = new UserRealm();
        realm.setCredentialsMatcher(matcher);
        return realm;
    }

    @Bean
    public CredentialsMatcher getMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-256");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    @Bean
    public WebSecurityManager getWebSecurityManager(Realm realm){
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(realm);
        log.info("SecurityManager注入成功...");
        return webSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(WebSecurityManager webSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(webSecurityManager);
        return shiroFilterFactoryBean;
    }

}

