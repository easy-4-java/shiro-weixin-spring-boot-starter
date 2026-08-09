package org.apache.shiro.spring.boot.weixin.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Exception thrown when a WeChat JS code has expired.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class WxJsCodeExpiredException extends AuthenticationException {

	public WxJsCodeExpiredException() {
		super();
	}

	public WxJsCodeExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

	public WxJsCodeExpiredException(String message) {
		super(message);
	}

	public WxJsCodeExpiredException(Throwable cause) {
		super(cause);
	}

}
