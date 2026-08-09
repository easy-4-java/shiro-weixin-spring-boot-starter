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
package org.apache.shiro.spring.boot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link ShiroWeiXinProperties}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("ShiroWeiXinProperties Tests")
class ShiroWeiXinPropertiesTest {

    @Test
    @DisplayName("Default constructor creates non-null instance")
    void testDefaultInstance() {
        ShiroWeiXinProperties props = new ShiroWeiXinProperties();
        assertThat(props).isNotNull();
        assertThat(props.isEnabled()).isFalse();
    }

    @Test
    @DisplayName("enabled can be set and read")
    void testEnabledField() {
        ShiroWeiXinProperties props = new ShiroWeiXinProperties();
        props.setEnabled(true);
        assertThat(props.isEnabled()).isTrue();
        props.setEnabled(false);
        assertThat(props.isEnabled()).isFalse();
    }

    @Test
    @DisplayName("PREFIX constant has expected value")
    void testPREFIXConstant() {
        assertThat(ShiroWeiXinProperties.PREFIX).isEqualTo("shiro.weixin");
    }
}
