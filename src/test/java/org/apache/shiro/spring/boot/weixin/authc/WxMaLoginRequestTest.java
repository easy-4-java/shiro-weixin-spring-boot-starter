/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.shiro.spring.boot.weixin.authc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link WxMaLoginRequest}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("WxMaLoginRequest Tests")
class WxMaLoginRequestTest {

    @Test
    @DisplayName("Instance can be created via constructor")
    void testInstantiation() {
        WxMaLoginRequest instance = new WxMaLoginRequest("jscode", "sessionKey", "unionid",
                "openid", "signature", "rawData", "encryptedData", "iv", "token");
        assertThat(instance).isNotNull();
        assertThat(instance.getJscode()).isEqualTo("jscode");
        assertThat(instance.getSessionKey()).isEqualTo("sessionKey");
        assertThat(instance.getUnionid()).isEqualTo("unionid");
        assertThat(instance.getOpenid()).isEqualTo("openid");
        assertThat(instance.getSignature()).isEqualTo("signature");
        assertThat(instance.getRawData()).isEqualTo("rawData");
        assertThat(instance.getEncryptedData()).isEqualTo("encryptedData");
        assertThat(instance.getIv()).isEqualTo("iv");
        assertThat(instance.getToken()).isEqualTo("token");
    }

    @Test
    @DisplayName("Getters and setters work correctly")
    void testGettersSetters() {
        WxMaLoginRequest instance = new WxMaLoginRequest(null, null, null, null, null, null, null, null, null);
        instance.setJscode("newJscode");
        instance.setSessionKey("newSessionKey");
        instance.setUnionid("newUnionid");
        instance.setOpenid("newOpenid");
        instance.setSignature("newSignature");
        instance.setRawData("newRawData");
        instance.setEncryptedData("newEncryptedData");
        instance.setIv("newIv");
        instance.setToken("newToken");

        assertThat(instance.getJscode()).isEqualTo("newJscode");
        assertThat(instance.getSessionKey()).isEqualTo("newSessionKey");
        assertThat(instance.getUnionid()).isEqualTo("newUnionid");
        assertThat(instance.getOpenid()).isEqualTo("newOpenid");
        assertThat(instance.getSignature()).isEqualTo("newSignature");
        assertThat(instance.getRawData()).isEqualTo("newRawData");
        assertThat(instance.getEncryptedData()).isEqualTo("newEncryptedData");
        assertThat(instance.getIv()).isEqualTo("newIv");
        assertThat(instance.getToken()).isEqualTo("newToken");
    }
}
