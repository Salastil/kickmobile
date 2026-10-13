package com.datadog.trace.api;

import com.datadog.android.trace.internal.compat.function.Function;
import com.datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class Functions {
    public static final Function<String, UTF8BytesString> UTF8_ENCODE = new Function() { // from class: com.datadog.trace.api.Functions$$ExternalSyntheticLambda0
        @Override // com.datadog.android.trace.internal.compat.function.Function
        public final Object apply(Object obj) {
            return UTF8BytesString.create((String) obj);
        }
    };

    private Functions() {
    }

    public static final class LowerCase implements Function<String, String> {
        public static final LowerCase INSTANCE = new LowerCase();

        @Override // com.datadog.android.trace.internal.compat.function.Function
        public String apply(String str) {
            return str.toLowerCase(Locale.ROOT);
        }
    }
}
