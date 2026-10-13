package com.datadog.android.rum.resource;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.Datadog;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.google.android.gms.common.internal.ImagesContract;
import io.ktor.http.ContentDisposition;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: RumResourceInputStream.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010!\u001a\u00020\"H\u0016J4\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\u00042\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H$0'¢\u0006\u0002\b(H\u0002¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\"H\u0016J\b\u0010.\u001a\u00020\rH\u0016J\b\u0010/\u001a\u00020\"H\u0016J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u000201H\u0016J \u0010/\u001a\u00020\"2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\"H\u0016J\b\u00104\u001a\u00020+H\u0016J\u0010\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015¨\u00068"}, d2 = {"Lcom/datadog/android/rum/resource/RumResourceInputStream;", "Ljava/io/InputStream;", "delegate", ImagesContract.URL, "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "(Ljava/io/InputStream;Ljava/lang/String;Lcom/datadog/android/api/SdkCore;)V", "callStart", "", "getDelegate", "()Ljava/io/InputStream;", "failed", "", "getFailed$dd_sdk_android_rum_release", "()Z", "setFailed$dd_sdk_android_rum_release", "(Z)V", "firstByte", "key", "getKey$dd_sdk_android_rum_release", "()Ljava/lang/String;", "lastByte", "getSdkCore", "()Lcom/datadog/android/api/SdkCore;", ContentDisposition.Parameters.Size, "getSize$dd_sdk_android_rum_release", "()J", "setSize$dd_sdk_android_rum_release", "(J)V", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "getUrl", "available", "", "callWithErrorTracking", ExifInterface.GPS_DIRECTION_TRUE, "errorMessage", "operation", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "close", "", "mark", "readlimit", "markSupported", "read", "b", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "reset", "skip", "n", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumResourceInputStream extends InputStream {
    public static final String ERROR_CLOSE = "Error closing input stream";
    public static final String ERROR_MARK = "Error marking input stream";
    public static final String ERROR_READ = "Error reading from input stream";
    public static final String ERROR_RESET = "Error resetting input stream";
    public static final String ERROR_SKIP = "Error skipping bytes from input stream";
    private long callStart;
    private final InputStream delegate;
    private boolean failed;
    private long firstByte;
    private final String key;
    private long lastByte;
    private final SdkCore sdkCore;
    private long size;
    private final TimeProvider timeProvider;
    private final String url;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final RumResourceMethod METHOD = RumResourceMethod.GET;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RumResourceInputStream(InputStream delegate, String url) {
        this(delegate, url, null, 4, null);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public final InputStream getDelegate() {
        return this.delegate;
    }

    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ RumResourceInputStream(InputStream inputStream, String str, SdkCore sdkCore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputStream, str, (i & 4) != 0 ? Datadog.getInstance$default(null, 1, null) : sdkCore);
    }

    public final SdkCore getSdkCore() {
        return this.sdkCore;
    }

    public RumResourceInputStream(InputStream delegate, String url, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.delegate = delegate;
        this.url = url;
        this.sdkCore = sdkCore;
        String str = delegate.getClass().getSimpleName() + "@" + System.identityHashCode(delegate);
        this.key = str;
        Intrinsics.checkNotNull(sdkCore, "null cannot be cast to non-null type com.datadog.android.api.feature.FeatureSdkCore");
        TimeProvider timeProvider = ((FeatureSdkCore) sdkCore).getTimeProvider();
        this.timeProvider = timeProvider;
        RumMonitor rumMonitor = GlobalRumMonitor.get(sdkCore);
        RumMonitor.DefaultImpls.startResource$default(rumMonitor, str, METHOD, url, null, 8, null);
        this.callStart = timeProvider.getDeviceElapsedTimeNanos();
        if (rumMonitor instanceof AdvancedRumMonitor) {
            ((AdvancedRumMonitor) rumMonitor).waitForResourceTiming(str);
        }
    }

    /* JADX INFO: renamed from: getKey$dd_sdk_android_rum_release, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: getSize$dd_sdk_android_rum_release, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public final void setSize$dd_sdk_android_rum_release(long j) {
        this.size = j;
    }

    /* JADX INFO: renamed from: getFailed$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getFailed() {
        return this.failed;
    }

    public final void setFailed$dd_sdk_android_rum_release(boolean z) {
        this.failed = z;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.firstByte == 0) {
            this.firstByte = this.timeProvider.getDeviceElapsedTimeNanos();
        }
        return ((Number) callWithErrorTracking(ERROR_READ, new Function1<InputStream, Integer>() { // from class: com.datadog.android.rum.resource.RumResourceInputStream.read.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(InputStream callWithErrorTracking) {
                Intrinsics.checkNotNullParameter(callWithErrorTracking, "$this$callWithErrorTracking");
                Integer numValueOf = Integer.valueOf(callWithErrorTracking.read());
                RumResourceInputStream rumResourceInputStream = RumResourceInputStream.this;
                if (numValueOf.intValue() >= 0) {
                    rumResourceInputStream.setSize$dd_sdk_android_rum_release(rumResourceInputStream.getSize() + 1);
                }
                rumResourceInputStream.lastByte = rumResourceInputStream.timeProvider.getDeviceElapsedTimeNanos();
                return numValueOf;
            }
        })).intValue();
    }

    @Override // java.io.InputStream
    public int read(final byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (this.firstByte == 0) {
            this.firstByte = this.timeProvider.getDeviceElapsedTimeNanos();
        }
        return ((Number) callWithErrorTracking(ERROR_READ, new Function1<InputStream, Integer>() { // from class: com.datadog.android.rum.resource.RumResourceInputStream.read.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(InputStream callWithErrorTracking) {
                Intrinsics.checkNotNullParameter(callWithErrorTracking, "$this$callWithErrorTracking");
                Integer numValueOf = Integer.valueOf(callWithErrorTracking.read(b));
                RumResourceInputStream rumResourceInputStream = this;
                int iIntValue = numValueOf.intValue();
                if (iIntValue >= 0) {
                    rumResourceInputStream.setSize$dd_sdk_android_rum_release(rumResourceInputStream.getSize() + ((long) iIntValue));
                }
                rumResourceInputStream.lastByte = rumResourceInputStream.timeProvider.getDeviceElapsedTimeNanos();
                return numValueOf;
            }
        })).intValue();
    }

    @Override // java.io.InputStream
    public int read(final byte[] b, final int off, final int len) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (this.firstByte == 0) {
            this.firstByte = this.timeProvider.getDeviceElapsedTimeNanos();
        }
        return ((Number) callWithErrorTracking(ERROR_READ, new Function1<InputStream, Integer>() { // from class: com.datadog.android.rum.resource.RumResourceInputStream.read.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(InputStream callWithErrorTracking) {
                Intrinsics.checkNotNullParameter(callWithErrorTracking, "$this$callWithErrorTracking");
                Integer numValueOf = Integer.valueOf(callWithErrorTracking.read(b, off, len));
                RumResourceInputStream rumResourceInputStream = this;
                int iIntValue = numValueOf.intValue();
                if (iIntValue >= 0) {
                    rumResourceInputStream.setSize$dd_sdk_android_rum_release(rumResourceInputStream.getSize() + ((long) iIntValue));
                }
                rumResourceInputStream.lastByte = rumResourceInputStream.timeProvider.getDeviceElapsedTimeNanos();
                return numValueOf;
            }
        })).intValue();
    }

    @Override // java.io.InputStream
    public int available() {
        return ((Number) callWithErrorTracking(ERROR_READ, new Function1<InputStream, Integer>() { // from class: com.datadog.android.rum.resource.RumResourceInputStream.available.1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(InputStream callWithErrorTracking) {
                Intrinsics.checkNotNullParameter(callWithErrorTracking, "$this$callWithErrorTracking");
                return Integer.valueOf(callWithErrorTracking.available());
            }
        })).intValue();
    }

    @Override // java.io.InputStream
    public long skip(final long n) {
        return ((Number) callWithErrorTracking(ERROR_SKIP, new Function1<InputStream, Long>() { // from class: com.datadog.android.rum.resource.RumResourceInputStream.skip.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(InputStream callWithErrorTracking) {
                Intrinsics.checkNotNullParameter(callWithErrorTracking, "$this$callWithErrorTracking");
                return Long.valueOf(callWithErrorTracking.skip(n));
            }
        })).longValue();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return ((Boolean) callWithErrorTracking(ERROR_READ, new Function1<InputStream, Boolean>() { // from class: com.datadog.android.rum.resource.RumResourceInputStream.markSupported.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(InputStream callWithErrorTracking) {
                Intrinsics.checkNotNullParameter(callWithErrorTracking, "$this$callWithErrorTracking");
                return Boolean.valueOf(callWithErrorTracking.markSupported());
            }
        })).booleanValue();
    }

    @Override // java.io.InputStream
    public void mark(final int readlimit) {
        callWithErrorTracking(ERROR_MARK, new Function1<InputStream, Unit>() { // from class: com.datadog.android.rum.resource.RumResourceInputStream.mark.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InputStream inputStream) {
                invoke2(inputStream);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InputStream callWithErrorTracking) {
                Intrinsics.checkNotNullParameter(callWithErrorTracking, "$this$callWithErrorTracking");
                callWithErrorTracking.mark(readlimit);
            }
        });
    }

    @Override // java.io.InputStream
    public void reset() {
        callWithErrorTracking(ERROR_RESET, new Function1<InputStream, Unit>() { // from class: com.datadog.android.rum.resource.RumResourceInputStream.reset.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InputStream inputStream) throws IOException {
                invoke2(inputStream);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InputStream callWithErrorTracking) throws IOException {
                Intrinsics.checkNotNullParameter(callWithErrorTracking, "$this$callWithErrorTracking");
                callWithErrorTracking.reset();
            }
        });
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        callWithErrorTracking(ERROR_CLOSE, new Function1<InputStream, Unit>() { // from class: com.datadog.android.rum.resource.RumResourceInputStream.close.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InputStream inputStream) throws IOException {
                invoke2(inputStream);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InputStream callWithErrorTracking) throws IOException {
                Intrinsics.checkNotNullParameter(callWithErrorTracking, "$this$callWithErrorTracking");
                callWithErrorTracking.close();
                RumMonitor rumMonitor = GlobalRumMonitor.get(RumResourceInputStream.this.getSdkCore());
                AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
                if (advancedRumMonitor != null) {
                    advancedRumMonitor.addResourceTiming(RumResourceInputStream.this.getKey(), new ResourceTiming(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, RumResourceInputStream.this.firstByte - RumResourceInputStream.this.callStart, RumResourceInputStream.this.lastByte - RumResourceInputStream.this.firstByte, 255, null));
                }
                RumMonitor.DefaultImpls.stopResource$default(rumMonitor, RumResourceInputStream.this.getKey(), null, Long.valueOf(RumResourceInputStream.this.getSize()), RumResourceKind.OTHER, null, 16, null);
            }
        });
    }

    private final <T> T callWithErrorTracking(String errorMessage, Function1<? super InputStream, ? extends T> operation) {
        try {
            return operation.invoke(this.delegate);
        } catch (Throwable th) {
            if (!this.failed) {
                this.failed = true;
                RumMonitor.DefaultImpls.stopResourceWithError$default(GlobalRumMonitor.get(this.sdkCore), this.key, null, errorMessage, RumErrorSource.SOURCE, th, null, 32, null);
                throw th;
            }
            throw th;
        }
    }

    /* JADX INFO: compiled from: RumResourceInputStream.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/resource/RumResourceInputStream$Companion;", "", "()V", "ERROR_CLOSE", "", "ERROR_MARK", "ERROR_READ", "ERROR_RESET", "ERROR_SKIP", "METHOD", "Lcom/datadog/android/rum/RumResourceMethod;", "getMETHOD$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/RumResourceMethod;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumResourceMethod getMETHOD$dd_sdk_android_rum_release() {
            return RumResourceInputStream.METHOD;
        }
    }
}
