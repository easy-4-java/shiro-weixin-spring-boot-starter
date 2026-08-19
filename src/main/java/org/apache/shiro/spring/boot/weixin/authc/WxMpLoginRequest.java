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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;

/**
 * 微信公众号 Login Request
 * https://developers.weixin.qq.com/doc/oplatform/Website_App/WeChat_Login/Wechat_Login.html
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WxMpLoginRequest {

	/**
	 * oauth2换取access token的code .
	 */
	protected String code;

	/**
	 * 	当前请求使用的token，用于绑定用户
	 */
	protected String token;

	protected String state;
	/**
	 * 第三方平台UnionID（通常指第三方账号体系下用户的唯一ID）
	 */
	protected String unionid;
	/**
	 * 第三方平台OpenID（通常指第三方账号体系下某应用中用户的唯一ID）
	 */
	protected String openid;
	/**
	 * 用户语言：zh_CN, zh_TW, en
	 */
	protected String lang = "zh_CN";
	/**
	 * 网页授权接口调用凭证
	 */
	protected WxOAuth2AccessToken accessToken;
	/**
	 * 微信用户信息
	 */
	protected WxOAuth2UserInfo userInfo;

	@JsonCreator
	@JsonIgnoreProperties(ignoreUnknown = true)
	public WxMpLoginRequest(@JsonProperty("code") String code,
							@JsonProperty("state") String state,
							@JsonProperty("token") String token) {
		this.code = code;
		this.state = state;
		this.token = token;
	}

	/**
	 * Returns the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Returns the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Returns the unionid.
	 *
	 * @return the unionid
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * Sets the unionid.
	 *
	 * @param unionid the unionid
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * Returns the openid.
	 *
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * Sets the openid.
	 *
	 * @param openid the openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * Returns the lang.
	 *
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * Sets the lang.
	 *
	 * @param lang the lang
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * Returns the access token.
	 *
	 * @return the access token
	 */
	public WxOAuth2AccessToken getAccessToken() {
		return accessToken;
	}

	/**
	 * Sets the access token.
	 *
	 * @param accessToken the access token
	 */
	public void setAccessToken(WxOAuth2AccessToken accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * Returns the user info.
	 *
	 * @return the user info
	 */
	public WxOAuth2UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * Sets the user info.
	 *
	 * @param userInfo the user info
	 */
	public void setUserInfo(WxOAuth2UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
