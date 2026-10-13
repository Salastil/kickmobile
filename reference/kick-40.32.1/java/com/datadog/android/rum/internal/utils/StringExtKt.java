package com.datadog.android.rum.internal.utils;

import com.datadog.android.api.InternalLogger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderMalfunctionError;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a,\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0000¨\u0006\u000b"}, d2 = {"logTruncationFailure", "", "Lcom/datadog/android/api/InternalLogger;", "e", "", "truncateToUtf8ByteSize", "Lkotlin/Pair;", "", "", "maxBytes", "internalLogger", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringExtKt {
    public static /* synthetic */ Pair truncateToUtf8ByteSize$default(String str, int i, InternalLogger internalLogger, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            internalLogger = null;
        }
        return truncateToUtf8ByteSize(str, i, internalLogger);
    }

    public static final Pair<String, Integer> truncateToUtf8ByteSize(String str, int i, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsetEncoder charsetEncoderNewEncoder = StandardCharsets.UTF_8.newEncoder();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        CharBuffer charBufferWrap = CharBuffer.wrap(str);
        try {
            charsetEncoderNewEncoder.encode(charBufferWrap, byteBufferAllocate, true);
            String strSubstring = str.substring(0, charBufferWrap.position());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return new Pair<>(strSubstring, Integer.valueOf(byteBufferAllocate.position()));
        } catch (IllegalStateException e) {
            if (internalLogger != null) {
                logTruncationFailure(internalLogger, e);
            }
            return new Pair<>("", 0);
        } catch (NullPointerException e2) {
            if (internalLogger != null) {
                logTruncationFailure(internalLogger, e2);
            }
            return new Pair<>("", 0);
        } catch (CoderMalfunctionError e3) {
            if (internalLogger != null) {
                logTruncationFailure(internalLogger, e3);
            }
            return new Pair<>("", 0);
        }
    }

    private static final void logTruncationFailure(InternalLogger internalLogger, Throwable th) {
        InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.utils.StringExtKt.logTruncationFailure.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Failed to truncate string to UTF-8 byte limit";
            }
        }, th, false, (Map) null, 48, (Object) null);
    }
}
