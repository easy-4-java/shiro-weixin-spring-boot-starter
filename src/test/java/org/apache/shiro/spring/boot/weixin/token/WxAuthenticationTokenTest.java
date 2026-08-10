package org.apache.shiro.spring.boot.weixin.token;

import org.apache.shiro.spring.boot.weixin.authc.WxMaLoginRequest;
import org.apache.shiro.spring.boot.weixin.authc.WxMpLoginRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for WeChat authentication token classes.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("WeChat Authentication Token Tests")
class WxAuthenticationTokenTest {

    @Test
    @DisplayName("WxMaAuthenticationToken can be created")
    void testWxMaAuthenticationToken() {
        WxMaLoginRequest request = new WxMaLoginRequest("jscode", "sessionKey", "unionid",
                "openid", "signature", "rawData", "encryptedData", "iv", "token");
        WxMaAuthenticationToken token = new WxMaAuthenticationToken(request, "host");
        assertThat(token).isNotNull();
        assertThat(token.getPrincipal()).isEqualTo(request);
    }

    @Test
    @DisplayName("WxMpAuthenticationToken can be created")
    void testWxMpAuthenticationToken() {
        WxMpLoginRequest request = new WxMpLoginRequest("code", "state", "token");
        WxMpAuthenticationToken token = new WxMpAuthenticationToken(request, "host");
        assertThat(token).isNotNull();
        assertThat(token.getPrincipal()).isEqualTo(request);
    }
}
