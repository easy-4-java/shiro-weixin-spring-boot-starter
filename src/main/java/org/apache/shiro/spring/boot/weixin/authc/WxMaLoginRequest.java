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

import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信小程序 Login Request
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WxMaLoginRequest {

	/**
	 * 第三方平台js-sdk获取的编码
	 */
	protected String jscode;
	/**
	 * 会话密钥
	 */
	protected String sessionKey;
	/**
	 * 第三方平台UnionID（通常指第三方账号体系下用户的唯一ID）
	 */
	protected String unionid;
	/**
	 * 第三方平台OpenID（通常指第三方账号体系下某应用中用户的唯一ID）
	 */
	protected String openid;
	/**
	 * 原始数据字符串
	 */
	protected String signature;
	/**
	 * 校验用户信息字符串
	 */
	protected String rawData;
	/**
	 * 加密用户数据
	 */
	protected String encryptedData;
	/**
	 * 加密算法的初始向量
	 */
	protected String iv;
	/**
	 * 	当前请求使用的token，用于绑定用户
	 */
	protected String token;
	/**
	 * 小程序手机号
	 */
	WxMaPhoneNumberInfo phoneNumberInfo;
	/**
	 * 用户信息
	 */
	protected WxMaUserInfo userInfo;

	@JsonCreator
	@JsonIgnoreProperties(ignoreUnknown = true)
	public WxMaLoginRequest(@JsonProperty("jscode") String jscode,
							@JsonProperty("sessionKey") String sessionKey,
							@JsonProperty("unionid") String unionid,
							@JsonProperty("openid") String openid,
							@JsonProperty("signature") String signature,
							@JsonProperty("rawData") String rawData,
							@JsonProperty("encryptedData") String encryptedData,
							@JsonProperty("iv") String iv,
							@JsonProperty("token") String token ) {

		this.jscode = jscode;
		this.sessionKey = sessionKey;
		this.unionid = unionid;
		this.openid = openid;
		this.signature = signature;
		this.rawData = rawData;
		this.encryptedData = encryptedData;
		this.iv = iv;
		this.token = token;
		this.userInfo = userInfo;
	}

	/**
	 * Returns the jscode.
	 *
	 * @return the jscode
	 */
	public String getJscode() {
		return jscode;
	}

	/**
	 * Sets the jscode.
	 *
	 * @param jscode the jscode
	 */
	public void setJscode(String jscode) {
		this.jscode = jscode;
	}

	/**
	 * Returns the session key.
	 *
	 * @return the session key
	 */
	public String getSessionKey() {
		return sessionKey;
	}

	/**
	 * Sets the session key.
	 *
	 * @param sessionKey the session key
	 */
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
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
	 * Returns the signature.
	 *
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * Sets the signature.
	 *
	 * @param signature the signature
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * Returns the raw data.
	 *
	 * @return the raw data
	 */
	public String getRawData() {
		return rawData;
	}

	/**
	 * Sets the raw data.
	 *
	 * @param rawData the raw data
	 */
	public void setRawData(String rawData) {
		this.rawData = rawData;
	}

	/**
	 * Returns the encrypted data.
	 *
	 * @return the encrypted data
	 */
	public String getEncryptedData() {
		return encryptedData;
	}

	/**
	 * Sets the encrypted data.
	 *
	 * @param encryptedData the encrypted data
	 */
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	/**
	 * Returns the iv.
	 *
	 * @return the iv
	 */
	public String getIv() {
		return iv;
	}

	/**
	 * Sets the iv.
	 *
	 * @param iv the iv
	 */
	public void setIv(String iv) {
		this.iv = iv;
	}

	/**
	 * Returns the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Returns the phone number info.
	 *
	 * @return the phone number info
	 */
	public WxMaPhoneNumberInfo getPhoneNumberInfo() {
		return phoneNumberInfo;
	}

	/**
	 * Sets the phone number info.
	 *
	 * @param phoneNumberInfo the phone number info
	 */
	public void setPhoneNumberInfo(WxMaPhoneNumberInfo phoneNumberInfo) {
		this.phoneNumberInfo = phoneNumberInfo;
	}

	/**
	 * Returns the user info.
	 *
	 * @return the user info
	 */
	public WxMaUserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * Sets the user info.
	 *
	 * @param userInfo the user info
	 */
	public void setUserInfo(WxMaUserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
