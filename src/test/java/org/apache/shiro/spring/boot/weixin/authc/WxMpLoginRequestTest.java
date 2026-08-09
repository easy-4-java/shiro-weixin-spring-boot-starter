package org.apache.shiro.spring.boot.weixin.authc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link WxMpLoginRequest}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("WxMpLoginRequest Tests")
class WxMpLoginRequestTest {

    @Test
    @DisplayName("Instance can be created via constructor")
    void testInstantiation() {
        WxMpLoginRequest instance = new WxMpLoginRequest("code", "state", "token");
        assertThat(instance).isNotNull();
        assertThat(instance.getCode()).isEqualTo("code");
        assertThat(instance.getState()).isEqualTo("state");
    }

    @Test
    @DisplayName("Getters and setters work correctly")
    void testGettersSetters() {
        WxMpLoginRequest instance = new WxMpLoginRequest(null, null, null);
        instance.setCode("newCode");
        instance.setState("newState");
        instance.setUnionid("unionid");
        instance.setOpenid("openid");
        instance.setLang("zh_CN");

        assertThat(instance.getCode()).isEqualTo("newCode");
        assertThat(instance.getState()).isEqualTo("newState");
        assertThat(instance.getUnionid()).isEqualTo("unionid");
        assertThat(instance.getOpenid()).isEqualTo("openid");
        assertThat(instance.getLang()).isEqualTo("zh_CN");
    }

    @Test
    @DisplayName("AccessToken and UserInfo can be set")
    void testTokenAndUserInfo() {
        WxMpLoginRequest instance = new WxMpLoginRequest("code", "state", "token");
        assertThat(instance.getAccessToken()).isNull();
        assertThat(instance.getUserInfo()).isNull();
    }
}
