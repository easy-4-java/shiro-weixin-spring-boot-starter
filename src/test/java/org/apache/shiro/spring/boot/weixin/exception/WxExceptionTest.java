package org.apache.shiro.spring.boot.weixin.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for WeChat exception classes.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("WeChat Exception Tests")
class WxExceptionTest {

    @Test
    @DisplayName("WxAuthenticationException default constructor")
    void testWxAuthenticationExceptionDefault() {
        WxAuthenticationException ex = new WxAuthenticationException();
        assertThat(ex).isNotNull();
    }

    @Test
    @DisplayName("WxAuthenticationException with message")
    void testWxAuthenticationExceptionMessage() {
        WxAuthenticationException ex = new WxAuthenticationException("test");
        assertThat(ex).hasMessage("test");
    }

    @Test
    @DisplayName("WxAuthenticationException with message and cause")
    void testWxAuthenticationExceptionCause() {
        Exception cause = new Exception("root");
        WxAuthenticationException ex = new WxAuthenticationException("test", cause);
        assertThat(ex).hasMessage("test");
        assertThat(ex.getCause()).isEqualTo(cause);
    }

    @Test
    @DisplayName("WxJsCodeInvalidException default constructor")
    void testWxJsCodeInvalidExceptionDefault() {
        WxJsCodeInvalidException ex = new WxJsCodeInvalidException();
        assertThat(ex).isNotNull();
    }

    @Test
    @DisplayName("WxJsCodeInvalidException with message")
    void testWxJsCodeInvalidExceptionMessage() {
        WxJsCodeInvalidException ex = new WxJsCodeInvalidException("invalid");
        assertThat(ex).hasMessage("invalid");
    }

    @Test
    @DisplayName("WxJsCodeInvalidException with message and cause")
    void testWxJsCodeInvalidExceptionCause() {
        Exception cause = new Exception("cause");
        WxJsCodeInvalidException ex = new WxJsCodeInvalidException("invalid", cause);
        assertThat(ex).hasMessage("invalid");
        assertThat(ex.getCause()).isEqualTo(cause);
    }

    @Test
    @DisplayName("WxJsCodeNotFoundException default constructor")
    void testWxJsCodeNotFoundExceptionDefault() {
        WxJsCodeNotFoundException ex = new WxJsCodeNotFoundException();
        assertThat(ex).isNotNull();
    }

    @Test
    @DisplayName("WxJsCodeNotFoundException with message")
    void testWxJsCodeNotFoundExceptionMessage() {
        WxJsCodeNotFoundException ex = new WxJsCodeNotFoundException("not found");
        assertThat(ex).hasMessage("not found");
    }

    @Test
    @DisplayName("WxJsCodeNotFoundException with message and cause")
    void testWxJsCodeNotFoundExceptionCause() {
        Exception cause = new Exception("cause");
        WxJsCodeNotFoundException ex = new WxJsCodeNotFoundException("not found", cause);
        assertThat(ex).hasMessage("not found");
        assertThat(ex.getCause()).isEqualTo(cause);
    }

    @Test
    @DisplayName("WxJsCodeExpiredException default constructor")
    void testWxJsCodeExpiredExceptionDefault() {
        WxJsCodeExpiredException ex = new WxJsCodeExpiredException();
        assertThat(ex).isNotNull();
    }

    @Test
    @DisplayName("WxJsCodeExpiredException with message")
    void testWxJsCodeExpiredExceptionMessage() {
        WxJsCodeExpiredException ex = new WxJsCodeExpiredException("expired");
        assertThat(ex).hasMessage("expired");
    }

    @Test
    @DisplayName("WxJsCodeExpiredException with message and cause")
    void testWxJsCodeExpiredExceptionCause() {
        Exception cause = new Exception("cause");
        WxJsCodeExpiredException ex = new WxJsCodeExpiredException("expired", cause);
        assertThat(ex).hasMessage("expired");
        assertThat(ex.getCause()).isEqualTo(cause);
    }

    @Test
    @DisplayName("WxJsCodeIncorrectException default constructor")
    void testWxJsCodeIncorrectExceptionDefault() {
        WxJsCodeIncorrectException ex = new WxJsCodeIncorrectException();
        assertThat(ex).isNotNull();
    }

    @Test
    @DisplayName("WxJsCodeIncorrectException with message")
    void testWxJsCodeIncorrectExceptionMessage() {
        WxJsCodeIncorrectException ex = new WxJsCodeIncorrectException("incorrect");
        assertThat(ex).hasMessage("incorrect");
    }

    @Test
    @DisplayName("WxJsCodeIncorrectException with message and cause")
    void testWxJsCodeIncorrectExceptionCause() {
        Exception cause = new Exception("cause");
        WxJsCodeIncorrectException ex = new WxJsCodeIncorrectException("incorrect", cause);
        assertThat(ex).hasMessage("incorrect");
        assertThat(ex.getCause()).isEqualTo(cause);
    }

    @Test
    @DisplayName("URIUnpermittedException default constructor")
    void testURIUnpermittedExceptionDefault() {
        URIUnpermittedException ex = new URIUnpermittedException();
        assertThat(ex).isNotNull();
    }

    @Test
    @DisplayName("URIUnpermittedException with message")
    void testURIUnpermittedExceptionMessage() {
        URIUnpermittedException ex = new URIUnpermittedException("unpermitted");
        assertThat(ex).hasMessage("unpermitted");
    }

    @Test
    @DisplayName("URIUnpermittedException with message and cause")
    void testURIUnpermittedExceptionCause() {
        Exception cause = new Exception("cause");
        URIUnpermittedException ex = new URIUnpermittedException("unpermitted", cause);
        assertThat(ex).hasMessage("unpermitted");
        assertThat(ex.getCause()).isEqualTo(cause);
    }
}
