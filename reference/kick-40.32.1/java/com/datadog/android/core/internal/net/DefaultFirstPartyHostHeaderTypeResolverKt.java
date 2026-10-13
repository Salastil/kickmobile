package com.datadog.android.core.internal.net;

import kotlin.Metadata;

/* JADX INFO: compiled from: DefaultFirstPartyHostHeaderTypeResolver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"LABEL_SEPARATOR", "", "REGEX_METACHARACTERS", "WILDCARD", "", "WILDCARD_LABEL_SEGMENT", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DefaultFirstPartyHostHeaderTypeResolverKt {
    private static final String LABEL_SEPARATOR = ".";
    private static final String REGEX_METACHARACTERS = "\\^$.|?+()[]{}";
    private static final char WILDCARD = '*';
    private static final String WILDCARD_LABEL_SEGMENT = "[a-z0-9.-]+";
}
