package org.apache.shiro.spring.boot.weixin.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Exception thrown when a WeChat JS code is invalid.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class WxJsCodeInvalidException extends AuthenticationException {

	public WxJsCodeInvalidException() {
		super();
	}

	public WxJsCodeInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public WxJsCodeInvalidException(String message) {
		super(message);
	}

	public WxJsCodeInvalidException(Throwable cause) {
		super(cause);
	}

}
