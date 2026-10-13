package com.datadog.trace.api.gateway;

import com.datadog.trace.appsec.api.blocking.BlockingContentType;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface Flow<T> {
    Action getAction();

    T getResult();

    public interface Action {
        boolean isBlocking();

        public static class Noop implements Action {
            public static Action INSTANCE = new Noop();

            @Override // com.datadog.trace.api.gateway.Flow.Action
            public boolean isBlocking() {
                return false;
            }

            private Noop() {
            }
        }

        public static class RequestBlockingAction implements Action {
            private final BlockingContentType blockingContentType;
            private final Map<String, String> extraHeaders;
            private final int statusCode;

            @Override // com.datadog.trace.api.gateway.Flow.Action
            public boolean isBlocking() {
                return true;
            }

            public RequestBlockingAction(int i, BlockingContentType blockingContentType, Map<String, String> map) {
                this.statusCode = i;
                this.blockingContentType = blockingContentType;
                this.extraHeaders = map;
            }

            public RequestBlockingAction(int i, BlockingContentType blockingContentType) {
                this(i, blockingContentType, Collections.EMPTY_MAP);
            }

            public static RequestBlockingAction forRedirect(int i, String str) {
                return new RequestBlockingAction(i, BlockingContentType.NONE, Collections.singletonMap("Location", str));
            }

            public int getStatusCode() {
                return this.statusCode;
            }

            public BlockingContentType getBlockingContentType() {
                return this.blockingContentType;
            }

            public Map<String, String> getExtraHeaders() {
                return this.extraHeaders;
            }
        }
    }

    public static class ResultFlow<R> implements Flow<R> {
        private static final ResultFlow EMPTY = new ResultFlow(null);
        private final R result;

        public static <R> ResultFlow<R> empty() {
            return EMPTY;
        }

        public ResultFlow(R r) {
            this.result = r;
        }

        @Override // com.datadog.trace.api.gateway.Flow
        public Action getAction() {
            return Action.Noop.INSTANCE;
        }

        @Override // com.datadog.trace.api.gateway.Flow
        public R getResult() {
            return this.result;
        }
    }
}
