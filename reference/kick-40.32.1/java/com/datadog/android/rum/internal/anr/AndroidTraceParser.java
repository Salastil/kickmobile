package com.datadog.android.rum.internal.anr;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.internal.utils.StringBuilderExtKt;
import com.google.android.gms.cast.MediaTrack;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidTraceParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\f\u0010\u000f\u001a\u00020\u0006*\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/anr/AndroidTraceParser;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "convertThreadState", "", "threadState", "parse", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "traceInputStream", "Ljava/io/InputStream;", "parse$dd_sdk_android_rum_release", "trace", "safeReadText", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidTraceParser {
    public static final String PARSING_FAILURE_MESSAGE = "Parsing tracing information for the exit reason wasn't successful, no thread dumps were parsed.";
    public static final String TRACE_STREAM_READ_FAILURE = "Failed to read crash trace stream.";
    private final InternalLogger internalLogger;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex THREAD_NAME_REGEX = new Regex("^\"(.+)\".+$");

    public AndroidTraceParser(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public final List<ThreadDump> parse$dd_sdk_android_rum_release(InputStream traceInputStream) {
        Intrinsics.checkNotNullParameter(traceInputStream, "traceInputStream");
        String strSafeReadText = safeReadText(traceInputStream);
        return StringsKt.isBlank(strSafeReadText) ? CollectionsKt.emptyList() : parse(strSafeReadText);
    }

    private final List<ThreadDump> parse(String trace) {
        List<String> groupValues;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        String str = null;
        String str2 = null;
        for (String str3 : StringsKt.lines(trace)) {
            String str4 = str3;
            if (StringsKt.isBlank(str4) && z) {
                if (sb.length() > 0 && str != null) {
                    ArrayList arrayList2 = arrayList;
                    String strConvertThreadState = convertThreadState(str2 == null ? "" : str2);
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "currentThreadStack.toString()");
                    arrayList2.add(new ThreadDump(str, strConvertThreadState, string, Intrinsics.areEqual(str, MediaTrack.ROLE_MAIN)));
                }
                StringsKt.clear(sb);
                z = false;
            } else if (StringsKt.contains$default((CharSequence) str4, (CharSequence) " prio=", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str4, (CharSequence) " tid=", false, 2, (Object) null)) {
                str2 = (String) CollectionsKt.lastOrNull(StringsKt.split$default((CharSequence) str4, new String[]{ServerSentEventKt.SPACE}, false, 0, 6, (Object) null));
                MatchResult matchResultMatchEntire = THREAD_NAME_REGEX.matchEntire(str4);
                str = (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues, 1);
                z = true;
            } else if (z) {
                String string2 = StringsKt.trimStart((CharSequence) str4).toString();
                if (StringsKt.startsWith$default(string2, "at ", false, 2, (Object) null) || StringsKt.startsWith$default(string2, "native: ", false, 2, (Object) null)) {
                    StringBuilderExtKt.appendIfNotEmpty(sb, '\n').append(str3);
                }
            }
        }
        if (arrayList.isEmpty()) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.anr.AndroidTraceParser.parse.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return AndroidTraceParser.PARSING_FAILURE_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return arrayList;
    }

    private final String convertThreadState(String threadState) {
        if (Intrinsics.areEqual(threadState, "TimedWaiting")) {
            threadState = "Timed_Waiting";
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = threadState.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final String safeReadText(InputStream inputStream) {
        try {
            InputStream inputStream2 = inputStream;
            try {
                String text = TextStreamsKt.readText(new InputStreamReader(inputStream2, Charsets.UTF_8));
                CloseableKt.closeFinally(inputStream2, null);
                return text;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream2, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.anr.AndroidTraceParser.safeReadText.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return AndroidTraceParser.TRACE_STREAM_READ_FAILURE;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return "";
        }
    }

    /* JADX INFO: compiled from: AndroidTraceParser.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/internal/anr/AndroidTraceParser$Companion;", "", "()V", "PARSING_FAILURE_MESSAGE", "", "THREAD_NAME_REGEX", "Lkotlin/text/Regex;", "getTHREAD_NAME_REGEX", "()Lkotlin/text/Regex;", "TRACE_STREAM_READ_FAILURE", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getTHREAD_NAME_REGEX() {
            return AndroidTraceParser.THREAD_NAME_REGEX;
        }
    }
}
