package org.apache.shiro.spring.boot.weixin.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Exception thrown when a WeChat JS code is incorrect.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class WxJsCodeIncorrectException extends AuthenticationException {

	public WxJsCodeIncorrectException() {
		super();
	}

	public WxJsCodeIncorrectException(String message, Throwable cause) {
		super(message, cause);
	}

	public WxJsCodeIncorrectException(String message) {
		super(message);
	}

	public WxJsCodeIncorrectException(Throwable cause) {
		super(cause);
	}

}
