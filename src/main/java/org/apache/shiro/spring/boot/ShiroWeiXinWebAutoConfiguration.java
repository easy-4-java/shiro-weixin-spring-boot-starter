package org.apache.shiro.spring.boot;

import org.apache.shiro.spring.boot.jwt.JwtPayloadRepository;
import org.apache.shiro.spring.boot.weixin.ShiroWxMaAuthcProperties;
import org.apache.shiro.spring.boot.weixin.ShiroWxMpAuthcProperties;
import org.apache.shiro.spring.boot.weixin.authc.WxAuthenticationSuccessHandler;
import org.apache.shiro.spring.web.config.AbstractShiroWebConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration for Shiro WeChat web authentication.
 * <p>Registers WeChat-specific authentication filters, success handlers and configuration
 * properties when the {@code shiro.weixin.enabled} property is set to {@code true}.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Configuration
@AutoConfigureBefore( name = {
	"org.apache.shiro.spring.config.web.autoconfigure.ShiroWebAutoConfiguration",  // shiro-spring-boot-web-starter
	"org.apache.shiro.spring.boot.ShiroBizWebAutoConfiguration" // spring-boot-starter-shiro-biz
})
@ConditionalOnProperty(prefix = ShiroWeiXinProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties({ ShiroWeiXinProperties.class, ShiroWxMaAuthcProperties.class, ShiroWxMpAuthcProperties.class })
public class ShiroWeiXinWebAutoConfiguration extends AbstractShiroWebConfiguration implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/**
	 * Creates the WeChat authentication success handler.
	 * @param jwtPayloadRepository the JWT payload repository
	 * @param jwtProperties the JWT configuration properties
	 * @return the configured success handler
	 */
	@Bean
	protected WxAuthenticationSuccessHandler wxAuthenticationSuccessHandler(
			JwtPayloadRepository jwtPayloadRepository,
			ShiroJwtProperties jwtProperties) {
		return new WxAuthenticationSuccessHandler(jwtPayloadRepository, jwtProperties.isCheckExpiry());
	}
 
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
