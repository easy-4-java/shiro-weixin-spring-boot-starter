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

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.biz.authc.AuthcResponse;
import org.apache.shiro.biz.utils.WebUtils2;
import org.apache.shiro.web.util.WebUtils;
import org.apache.shiro.biz.web.filter.authc.AbstractTrustableAuthenticatingFilter;
import org.apache.shiro.biz.web.servlet.http.HttpStatus;
import org.apache.shiro.spring.boot.weixin.exception.WxJsCodeInvalidException;
import org.apache.shiro.spring.boot.weixin.token.WxMaAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 小程序微信认证 (authentication)过滤器
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class WxMaAuthenticatingFilter extends AbstractTrustableAuthenticatingFilter {

	private static final Logger log = LoggerFactory.getLogger(WxMaAuthenticatingFilter.class);

	public static final String SPRING_SECURITY_FORM_JSCODE_KEY = "jscode";
	public static final String SPRING_SECURITY_FORM_SESSIONKEY_KEY = "sessionKey";
	public static final String SPRING_SECURITY_FORM_UNIONID_KEY = "unionid";
	public static final String SPRING_SECURITY_FORM_OPENID_KEY = "openid";
	public static final String SPRING_SECURITY_FORM_SIGNATURE_KEY = "signature";
	public static final String SPRING_SECURITY_FORM_RAWDATA_KEY = "rawData";
	public static final String SPRING_SECURITY_FORM_ENCRYPTEDDATA_KEY = "encryptedData";
	public static final String SPRING_SECURITY_FORM_IV_KEY = "iv";
	public static final String SPRING_SECURITY_FORM_TOKEN_KEY = "token";

	private String jscodeParameter = SPRING_SECURITY_FORM_JSCODE_KEY;
	private String sessionKeyParameter = SPRING_SECURITY_FORM_SESSIONKEY_KEY;
	private String unionidParameter = SPRING_SECURITY_FORM_UNIONID_KEY;
	private String openidParameter = SPRING_SECURITY_FORM_OPENID_KEY;
	private String signatureParameter = SPRING_SECURITY_FORM_SIGNATURE_KEY;
	private String rawDataParameter = SPRING_SECURITY_FORM_RAWDATA_KEY;
	private String encryptedDataParameter = SPRING_SECURITY_FORM_ENCRYPTEDDATA_KEY;
	private String ivParameter = SPRING_SECURITY_FORM_IV_KEY;
	private String tokenParameter = SPRING_SECURITY_FORM_TOKEN_KEY;

	public WxMaAuthenticatingFilter() {
		super();
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		if (isLoginSubmission(request, response)) {
			if (log.isTraceEnabled()) {
				log.trace("Login submission detected.  Attempting to execute login.");
			}
			return executeLogin(request, response);
		} else {
			String mString = "Authentication url [" + getLoginUrl() + "] Not Http Post request.";
			if (log.isTraceEnabled()) {
				log.trace(mString);
			}

			WebUtils.toHttp(response).setStatus(HttpStatus.SC_OK);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

			// Response Authentication status information
			JSONObject.writeJSONString(response.getWriter(), AuthcResponse.fail(HttpStatus.SC_BAD_REQUEST, mString));

			return false;
		}

	}



	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		// Post && JSON
		if(WebUtils2.isObjectRequest(request)) {
			try {
				WxMaLoginRequest loginRequest = objectMapper.readValue(request.getReader(), WxMaLoginRequest.class);
				if ( !StringUtils.hasText(loginRequest.getJscode())) {
					log.debug("No jscode found in request.");
					throw new WxJsCodeInvalidException("No jscode found in request.");
				}
				return new WxMaAuthenticationToken(loginRequest, getHost(request));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String jscode = obtainJscode(request);
		if ( !StringUtils.hasText(jscode)) {
			log.debug("No jscode found in request.");
			throw new WxJsCodeInvalidException("No jscode found in request.");
		}
		String sessionKey = obtainSessionKey(request);
		String unionid = obtainUnionid(request);
		String openid = obtainOpenid(request);
		String signature = obtainSignature(request);
		String rawData = obtainRawData(request);
		String encryptedData = obtainEncryptedData(request);
		String iv = obtainIv(request);
		String token = obtainToken(request);

		if (sessionKey == null) {
			sessionKey = "";
		}
		if (unionid == null) {
			unionid = "";
		}
		if (openid == null) {
			openid = "";
		}
		if (signature == null) {
			signature = "";
		}
		if (rawData == null) {
			rawData = "";
		}
		if (encryptedData == null) {
			encryptedData = "";
		}
		if (iv == null) {
			iv = "";
		}
		if (token == null) {
			token = "";
		}
        WxMaLoginRequest loginRequest = new WxMaLoginRequest(jscode, sessionKey, unionid, openid,
				signature, rawData, encryptedData, iv, token);
		return new WxMaAuthenticationToken(loginRequest, getHost(request));
	}

	protected String obtainJscode(ServletRequest request) {
        return request.getParameter(jscodeParameter);
    }

	protected String obtainSessionKey(ServletRequest request) {
        return request.getParameter(sessionKeyParameter);
    }

	protected String obtainUnionid(ServletRequest request) {
        return request.getParameter(unionidParameter);
    }

	protected String obtainOpenid(ServletRequest request) {
        return request.getParameter(openidParameter);
    }


	protected String obtainSignature(ServletRequest request) {
        return request.getParameter(signatureParameter);
    }

	protected String obtainRawData(ServletRequest request) {
        return request.getParameter(rawDataParameter);
    }

	protected String obtainEncryptedData(ServletRequest request) {
        return request.getParameter(encryptedDataParameter);
    }

    protected String obtainIv(ServletRequest request) {
        return request.getParameter(ivParameter);
    }

	protected String obtainToken(ServletRequest request) {
		return request.getParameter(tokenParameter);
	}

	/**
	 * Returns the jscode parameter.
	 *
	 * @return the jscode parameter
	 */
	public String getJscodeParameter() {
		return jscodeParameter;
	}

	/**
	 * Sets the jscode parameter.
	 *
	 * @param jscodeParameter the jscode parameter
	 */
	public void setJscodeParameter(String jscodeParameter) {
		this.jscodeParameter = jscodeParameter;
	}

	/**
	 * Returns the signature parameter.
	 *
	 * @return the signature parameter
	 */
	public String getSignatureParameter() {
		return signatureParameter;
	}

	/**
	 * Sets the signature parameter.
	 *
	 * @param signatureParameter the signature parameter
	 */
	public void setSignatureParameter(String signatureParameter) {
		this.signatureParameter = signatureParameter;
	}

	/**
	 * Returns the raw data parameter.
	 *
	 * @return the raw data parameter
	 */
	public String getRawDataParameter() {
		return rawDataParameter;
	}

	/**
	 * Sets the raw data parameter.
	 *
	 * @param rawDataParameter the raw data parameter
	 */
	public void setRawDataParameter(String rawDataParameter) {
		this.rawDataParameter = rawDataParameter;
	}

	/**
	 * Returns the encrypted data parameter.
	 *
	 * @return the encrypted data parameter
	 */
	public String getEncryptedDataParameter() {
		return encryptedDataParameter;
	}

	/**
	 * Sets the encrypted data parameter.
	 *
	 * @param encryptedDataParameter the encrypted data parameter
	 */
	public void setEncryptedDataParameter(String encryptedDataParameter) {
		this.encryptedDataParameter = encryptedDataParameter;
	}

	/**
	 * Returns the iv parameter.
	 *
	 * @return the iv parameter
	 */
	public String getIvParameter() {
		return ivParameter;
	}

	/**
	 * Sets the iv parameter.
	 *
	 * @param ivParameter the iv parameter
	 */
	public void setIvParameter(String ivParameter) {
		this.ivParameter = ivParameter;
	}

	/**
	 * Sets the token parameter.
	 *
	 * @param tokenParameter the token parameter
	 */
	public void setTokenParameter(String tokenParameter) {
		this.tokenParameter = tokenParameter;
	}

	/**
	 * Returns the token parameter.
	 *
	 * @return the token parameter
	 */
	public String getTokenParameter() {
		return tokenParameter;
	}

}
