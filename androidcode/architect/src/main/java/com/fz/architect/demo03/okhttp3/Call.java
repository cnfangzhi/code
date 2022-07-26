package com.fz.architect.demo03.okhttp3;

import java.io.IOException;

/**
 * description:
 * author: fz on 2017/10/9 15:39
 * email: 514905121@qq.com
 * version: 1.0
 */
public interface Call {
    /** Returns the original request that initiated this call. */
    Request request();

    /**
     * Invokes the request immediately, and blocks until the response can be processed or is in
     * error.
     *
     * <p>The caller may read the response body with the response's {@link Response#body} method. To
     * avoid leaking resources callers must {@linkplain ResponseBody close the response body}.
     *
     * <p>Note that transport-layer success (receiving a HTTP response code, headers and body) does
     * not necessarily indicate application-layer success: {@code response} may still indicate an
     * unhappy HTTP response code like 404 or 500.
     *
     * @throws IOException if the request could not be executed due to cancellation, a connectivity
     * problem or timeout. Because networks can fail during an exchange, it is possible that the
     * remote server accepted the request before the failure.
     * @throws IllegalStateException when the call has already been executed.
     */
    Response execute() throws IOException;

    /**
     * Schedules the request to be executed at some point in the future.
     *
     * <p>The {@link OkHttpClient#dispatcher dispatcher} defines when the request will run: usually
     * immediately unless there are several other requests currently being executed.
     *
     * <p>This client will later call back {@code responseCallback} with either an HTTP response or a
     * failure exception.
     *
     * @throws IllegalStateException when the call has already been executed.
     */
    void enqueue(Callback responseCallback);

    /** Cancels the request, if possible. Requests that are already complete cannot be canceled. */
    void cancel();

    /**
     * Returns true if this call has been either {@linkplain #execute() executed} or {@linkplain
     * #enqueue(Callback) enqueued}. It is an error to execute a call more than once.
     */
    boolean isExecuted();

    boolean isCanceled();

    interface Factory {
        Call newCall(Request request);
    }
}
