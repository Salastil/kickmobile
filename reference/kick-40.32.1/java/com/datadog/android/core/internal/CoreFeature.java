package com.datadog.android.core.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Process;
import com.datadog.android.Datadog;
import com.datadog.android.DatadogSite;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.configuration.BackPressureStrategy;
import com.datadog.android.core.configuration.BatchProcessingLevel;
import com.datadog.android.core.configuration.BatchSize;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.configuration.UploadFrequency;
import com.datadog.android.core.configuration.UploadSchedulerStrategy;
import com.datadog.android.core.internal.account.DatadogAccountInfoProvider;
import com.datadog.android.core.internal.account.MutableAccountInfoProvider;
import com.datadog.android.core.internal.account.NoOpMutableAccountInfoProvider;
import com.datadog.android.core.internal.data.upload.GzipRequestInterceptor;
import com.datadog.android.core.internal.data.upload.RotatingDnsResolver;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.core.internal.net.DefaultFirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.internal.net.info.BroadcastReceiverNetworkInfoProvider;
import com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.net.info.NoOpNetworkInfoProvider;
import com.datadog.android.core.internal.persistence.JsonObjectDeserializer;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.batch.BatchFileReaderWriter;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.core.internal.privacy.NoOpConsentProvider;
import com.datadog.android.core.internal.privacy.TrackingConsentProvider;
import com.datadog.android.core.internal.system.AndroidInfoProvider;
import com.datadog.android.core.internal.system.AppVersionProvider;
import com.datadog.android.core.internal.system.BroadcastReceiverSystemInfoProvider;
import com.datadog.android.core.internal.system.DefaultAndroidInfoProvider;
import com.datadog.android.core.internal.system.DefaultAppVersionProvider;
import com.datadog.android.core.internal.system.NoOpAndroidInfoProvider;
import com.datadog.android.core.internal.system.NoOpAppVersionProvider;
import com.datadog.android.core.internal.system.NoOpSystemInfoProvider;
import com.datadog.android.core.internal.system.SystemInfoProvider;
import com.datadog.android.core.internal.thread.BackPressureExecutorService;
import com.datadog.android.core.internal.thread.BackPressuredBlockingQueue;
import com.datadog.android.core.internal.thread.BroadcastReceiverThread;
import com.datadog.android.core.internal.thread.DatadogThreadFactory;
import com.datadog.android.core.internal.thread.LoggingScheduledThreadPoolExecutor;
import com.datadog.android.core.internal.thread.ScheduledExecutorServiceFactory;
import com.datadog.android.core.internal.time.AppStartTimeProvider;
import com.datadog.android.core.internal.time.DatadogNtpEndpoint;
import com.datadog.android.core.internal.time.KronosTimeProvider;
import com.datadog.android.core.internal.time.LoggingSyncListener;
import com.datadog.android.core.internal.user.DatadogUserInfoProvider;
import com.datadog.android.core.internal.user.MutableUserInfoProvider;
import com.datadog.android.core.internal.user.NoOpMutableUserInfoProvider;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.core.persistence.PersistenceStrategy;
import com.datadog.android.core.thread.FlushableExecutorService;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.internal.telemetry.TelemetryContext;
import com.datadog.android.internal.time.DefaultTimeProvider;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.internal.utils.StrictModeExtKt;
import com.datadog.android.ndk.internal.DatadogNdkCrashHandler;
import com.datadog.android.ndk.internal.NdkCrashHandler;
import com.datadog.android.ndk.internal.NdkCrashLogDeserializer;
import com.datadog.android.ndk.internal.NoOpNdkCrashHandler;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.security.Encryption;
import com.datadog.trace.api.config.GeneralConfig;
import com.google.gson.JsonObject;
import com.lyft.kronos.AndroidClockFactory;
import com.lyft.kronos.KronosClock;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.TlsVersion;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: CoreFeature.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¢\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00ad\u00022\u00020\u0001:\u0004\u00ad\u0002®\u0002B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010ö\u0001\u001a\u00030÷\u0001J\n\u0010ø\u0001\u001a\u00030ù\u0001H\u0002J\n\u0010ú\u0001\u001a\u00030ù\u0001H\u0002J\u0011\u0010û\u0001\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020\u001aJ&\u0010þ\u0001\u001a\u00030ÿ\u00012\u001c\u0010\u0080\u0002\u001a\u0017\u0012\u0005\u0012\u00030\u0082\u0002\u0012\u0005\u0012\u00030ù\u00010\u0081\u0002¢\u0006\u0003\b\u0083\u0002J\u0011\u0010\u0084\u0002\u001a\u00030\u0085\u00022\u0007\u0010ý\u0001\u001a\u00020\u001aJ\u0010\u0010\u0086\u0002\u001a\u00030ù\u0001H\u0001¢\u0006\u0003\b\u0087\u0002J\u0010\u0010\u0088\u0002\u001a\u00030ù\u0001H\u0001¢\u0006\u0003\b\u0089\u0002J\b\u0010\u008a\u0002\u001a\u00030ù\u0001J\u0014\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u008c\u00022\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0011\u0010\u008d\u0002\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 H\u0003J-\u0010\u008e\u0002\u001a\u00030ù\u00012\u0006\u0010\u001f\u001a\u00020 2\u0007\u0010\u008f\u0002\u001a\u00020\u001a2\b\u0010\u0090\u0002\u001a\u00030\u0091\u00022\b\u0010\u0092\u0002\u001a\u00030\u0093\u0002J\u0012\u0010\u0094\u0002\u001a\u00030ù\u00012\u0006\u0010\u001f\u001a\u00020 H\u0003J\u0015\u0010\u0095\u0002\u001a\u00030ù\u00012\t\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u001aH\u0002J\u001c\u0010\u0097\u0002\u001a\u00030ù\u00012\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0002J\u0014\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u001a2\u0007\u0010\u0099\u0002\u001a\u00020 H\u0002J\u0014\u0010\u009a\u0002\u001a\u00030ù\u00012\b\u0010\u0090\u0002\u001a\u00030\u009b\u0002H\u0002J\u000b\u0010\u009c\u0002\u001a\u0004\u0018\u00010{H\u0003J\u0012\u0010\u009d\u0002\u001a\u00030ù\u00012\u0006\u0010\u001f\u001a\u00020 H\u0002J\n\u0010\u009e\u0002\u001a\u00030ù\u0001H\u0002J\u001c\u0010\u009f\u0002\u001a\u00030ù\u00012\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0092\u0002\u001a\u00030\u0093\u0002H\u0002J\u001c\u0010 \u0002\u001a\u00030ù\u00012\u0006\u0010\u001f\u001a\u00020 2\b\u0010¡\u0002\u001a\u00030¢\u0002H\u0002J\u0014\u0010£\u0002\u001a\u00030ù\u00012\b\u0010\u0090\u0002\u001a\u00030\u009b\u0002H\u0002J\n\u0010¤\u0002\u001a\u00030ù\u0001H\u0002J\b\u0010¥\u0002\u001a\u00030ù\u0001J\u0019\u0010¦\u0002\u001a\u00030ù\u00012\u0007\u0010§\u0002\u001a\u00020&H\u0001¢\u0006\u0003\b¨\u0002J\u001a\u0010©\u0002\u001a\u00030ù\u00012\b\u0010ª\u0002\u001a\u00030«\u0002H\u0001¢\u0006\u0003\b¬\u0002R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u001a\u0010+\u001a\u00020,X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020DX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001c\"\u0004\bK\u0010\u001eR\u001a\u0010L\u001a\u00020MX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020SX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u001c\"\u0004\b`\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u00020bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0014\u0010g\u001a\u00020hX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010k\u001a\u00020lX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001c\u0010q\u001a\u0004\u0018\u00010rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0016\u0010w\u001a\u0004\u0018\u00010&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u001d\u0010z\u001a\u0004\u0018\u00010{8AX\u0080\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\u007f\u001a\u0004\b|\u0010}R \u0010\u0080\u0001\u001a\u00030\u0081\u00018CX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0084\u0001\u0010\u007f\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0085\u0001\u001a\u00030\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0089\u0001\u0010\u007f\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R(\u0010\u008a\u0001\u001a\u00030\u008b\u00018BX\u0082\u0084\u0002¢\u0006\u0017\n\u0005\b\u0090\u0001\u0010\u007f\u0012\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R%\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001X\u0080\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R \u0010\u009e\u0001\u001a\u00030\u009f\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R \u0010¤\u0001\u001a\u00030¥\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R \u0010ª\u0001\u001a\u00030«\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R \u0010°\u0001\u001a\u00030±\u0001X\u0080.¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R\"\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010¼\u0001\u001a\u00020\u001aX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010\u001c\"\u0005\b¾\u0001\u0010\u001eR\u001d\u0010¿\u0001\u001a\u00020\u001aX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010\u001c\"\u0005\bÁ\u0001\u0010\u001eR \u0010Â\u0001\u001a\u00030Ã\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R\u001d\u0010È\u0001\u001a\u00020\u001aX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u0010\u001c\"\u0005\bÊ\u0001\u0010\u001eR \u0010Ë\u0001\u001a\u00030\u0081\u0001X\u0080.¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0001\u0010\u0083\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R \u0010Ï\u0001\u001a\u00030Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R \u0010Õ\u0001\u001a\u00030Ö\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b×\u0001\u0010Ø\u0001\"\u0006\bÙ\u0001\u0010Ú\u0001R \u0010Û\u0001\u001a\u00030Ü\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R \u0010á\u0001\u001a\u00030â\u0001X\u0080.¢\u0006\u0012\n\u0000\u001a\u0006\bã\u0001\u0010ä\u0001\"\u0006\bå\u0001\u0010æ\u0001R \u0010ç\u0001\u001a\u00030è\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bé\u0001\u0010ê\u0001\"\u0006\bë\u0001\u0010ì\u0001R \u0010í\u0001\u001a\u00030î\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bï\u0001\u0010ð\u0001\"\u0006\bñ\u0001\u0010ò\u0001R\u001d\u0010ó\u0001\u001a\u00020\u001aX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bô\u0001\u0010\u001c\"\u0005\bõ\u0001\u0010\u001e¨\u0006¯\u0002"}, d2 = {"Lcom/datadog/android/core/internal/CoreFeature;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "appStartTimeProvider", "Lcom/datadog/android/core/internal/time/AppStartTimeProvider;", "executorServiceFactory", "Lcom/datadog/android/core/thread/FlushableExecutorService$Factory;", "scheduledExecutorServiceFactory", "Lcom/datadog/android/core/internal/thread/ScheduledExecutorServiceFactory;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/time/AppStartTimeProvider;Lcom/datadog/android/core/thread/FlushableExecutorService$Factory;Lcom/datadog/android/core/internal/thread/ScheduledExecutorServiceFactory;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "accountInfoProvider", "Lcom/datadog/android/core/internal/account/MutableAccountInfoProvider;", "getAccountInfoProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/account/MutableAccountInfoProvider;", "setAccountInfoProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/account/MutableAccountInfoProvider;)V", "androidInfoProvider", "Lcom/datadog/android/core/internal/system/AndroidInfoProvider;", "getAndroidInfoProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/system/AndroidInfoProvider;", "setAndroidInfoProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/system/AndroidInfoProvider;)V", "appBuildId", "", "getAppBuildId$dd_sdk_android_core_release", "()Ljava/lang/String;", "setAppBuildId$dd_sdk_android_core_release", "(Ljava/lang/String;)V", "appContext", "Landroid/content/Context;", "getAppContext$dd_sdk_android_core_release", "()Landroid/content/Context;", "setAppContext$dd_sdk_android_core_release", "(Landroid/content/Context;)V", "appStartTimeNs", "", "getAppStartTimeNs$dd_sdk_android_core_release", "()J", "appUptimeNs", "getAppUptimeNs$dd_sdk_android_core_release", "backpressureStrategy", "Lcom/datadog/android/core/configuration/BackPressureStrategy;", "getBackpressureStrategy$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/BackPressureStrategy;", "setBackpressureStrategy$dd_sdk_android_core_release", "(Lcom/datadog/android/core/configuration/BackPressureStrategy;)V", "batchProcessingLevel", "Lcom/datadog/android/core/configuration/BatchProcessingLevel;", "getBatchProcessingLevel$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/BatchProcessingLevel;", "setBatchProcessingLevel$dd_sdk_android_core_release", "(Lcom/datadog/android/core/configuration/BatchProcessingLevel;)V", "batchSize", "Lcom/datadog/android/core/configuration/BatchSize;", "getBatchSize$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/BatchSize;", "setBatchSize$dd_sdk_android_core_release", "(Lcom/datadog/android/core/configuration/BatchSize;)V", "broadcastReceiverThread", "Lcom/datadog/android/core/internal/thread/BroadcastReceiverThread;", "getBroadcastReceiverThread$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/thread/BroadcastReceiverThread;", "setBroadcastReceiverThread$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/thread/BroadcastReceiverThread;)V", "callFactory", "Lcom/datadog/android/core/internal/CoreFeature$OkHttpCallFactory;", "getCallFactory$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/CoreFeature$OkHttpCallFactory;", "setCallFactory$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/CoreFeature$OkHttpCallFactory;)V", "clientToken", "getClientToken$dd_sdk_android_core_release", "setClientToken$dd_sdk_android_core_release", "contextExecutorService", "Ljava/util/concurrent/ThreadPoolExecutor;", "getContextExecutorService$dd_sdk_android_core_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "setContextExecutorService$dd_sdk_android_core_release", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "contextProvider", "Lcom/datadog/android/core/internal/ContextProvider;", "getContextProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/ContextProvider;", "setContextProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/ContextProvider;)V", "customUploadSchedulerStrategy", "Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "getCustomUploadSchedulerStrategy$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "setCustomUploadSchedulerStrategy$dd_sdk_android_core_release", "(Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;)V", "envName", "getEnvName$dd_sdk_android_core_release", "setEnvName$dd_sdk_android_core_release", "firstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/DefaultFirstPartyHostHeaderTypeResolver;", "getFirstPartyHostHeaderTypeResolver$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/net/DefaultFirstPartyHostHeaderTypeResolver;", "setFirstPartyHostHeaderTypeResolver$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/net/DefaultFirstPartyHostHeaderTypeResolver;)V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_core_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isMainProcess", "", "isMainProcess$dd_sdk_android_core_release", "()Z", "setMainProcess$dd_sdk_android_core_release", "(Z)V", "kronosClock", "Lcom/lyft/kronos/KronosClock;", "getKronosClock$dd_sdk_android_core_release", "()Lcom/lyft/kronos/KronosClock;", "setKronosClock$dd_sdk_android_core_release", "(Lcom/lyft/kronos/KronosClock;)V", "lastFatalAnrSent", "getLastFatalAnrSent$dd_sdk_android_core_release", "()Ljava/lang/Long;", "lastViewEvent", "Lcom/google/gson/JsonObject;", "getLastViewEvent$dd_sdk_android_core_release", "()Lcom/google/gson/JsonObject;", "lastViewEvent$delegate", "Lkotlin/Lazy;", "lastViewEventFile", "Ljava/io/File;", "getLastViewEventFile", "()Ljava/io/File;", "lastViewEventFile$delegate", "lastViewEventFileWriter", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;", "getLastViewEventFileWriter", "()Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;", "lastViewEventFileWriter$delegate", "lazySharedOkHttpClient", "Lokhttp3/OkHttpClient;", "getLazySharedOkHttpClient$annotations", "()V", "getLazySharedOkHttpClient", "()Lokhttp3/OkHttpClient;", "lazySharedOkHttpClient$delegate", "localDataEncryption", "Lcom/datadog/android/security/Encryption;", "getLocalDataEncryption$dd_sdk_android_core_release", "()Lcom/datadog/android/security/Encryption;", "setLocalDataEncryption$dd_sdk_android_core_release", "(Lcom/datadog/android/security/Encryption;)V", "metricTelemetrySampleRateBypass", "", "getMetricTelemetrySampleRateBypass$dd_sdk_android_core_release", "()Ljava/lang/Float;", "setMetricTelemetrySampleRateBypass$dd_sdk_android_core_release", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "ndkCrashHandler", "Lcom/datadog/android/ndk/internal/NdkCrashHandler;", "getNdkCrashHandler$dd_sdk_android_core_release", "()Lcom/datadog/android/ndk/internal/NdkCrashHandler;", "setNdkCrashHandler$dd_sdk_android_core_release", "(Lcom/datadog/android/ndk/internal/NdkCrashHandler;)V", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "getNetworkInfoProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "setNetworkInfoProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;)V", "packageVersionProvider", "Lcom/datadog/android/core/internal/system/AppVersionProvider;", "getPackageVersionProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/system/AppVersionProvider;", "setPackageVersionProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/system/AppVersionProvider;)V", "persistenceExecutorService", "Lcom/datadog/android/core/thread/FlushableExecutorService;", "getPersistenceExecutorService$dd_sdk_android_core_release", "()Lcom/datadog/android/core/thread/FlushableExecutorService;", "setPersistenceExecutorService$dd_sdk_android_core_release", "(Lcom/datadog/android/core/thread/FlushableExecutorService;)V", "persistenceStrategyFactory", "Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;", "getPersistenceStrategyFactory$dd_sdk_android_core_release", "()Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;", "setPersistenceStrategyFactory$dd_sdk_android_core_release", "(Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;)V", "sdkVersion", "getSdkVersion$dd_sdk_android_core_release", "setSdkVersion$dd_sdk_android_core_release", "serviceName", "getServiceName$dd_sdk_android_core_release", "setServiceName$dd_sdk_android_core_release", GeneralConfig.SITE, "Lcom/datadog/android/DatadogSite;", "getSite$dd_sdk_android_core_release", "()Lcom/datadog/android/DatadogSite;", "setSite$dd_sdk_android_core_release", "(Lcom/datadog/android/DatadogSite;)V", "sourceName", "getSourceName$dd_sdk_android_core_release", "setSourceName$dd_sdk_android_core_release", "storageDir", "getStorageDir$dd_sdk_android_core_release", "setStorageDir$dd_sdk_android_core_release", "(Ljava/io/File;)V", "systemInfoProvider", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "getSystemInfoProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "setSystemInfoProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/system/SystemInfoProvider;)V", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "getTimeProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/internal/time/TimeProvider;", "setTimeProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/internal/time/TimeProvider;)V", "trackingConsentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "getTrackingConsentProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "setTrackingConsentProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;)V", "uploadExecutorService", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "getUploadExecutorService$dd_sdk_android_core_release", "()Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "setUploadExecutorService$dd_sdk_android_core_release", "(Ljava/util/concurrent/ScheduledThreadPoolExecutor;)V", "uploadFrequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "getUploadFrequency$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/UploadFrequency;", "setUploadFrequency$dd_sdk_android_core_release", "(Lcom/datadog/android/core/configuration/UploadFrequency;)V", "userInfoProvider", "Lcom/datadog/android/core/internal/user/MutableUserInfoProvider;", "getUserInfoProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/user/MutableUserInfoProvider;", "setUserInfoProvider$dd_sdk_android_core_release", "(Lcom/datadog/android/core/internal/user/MutableUserInfoProvider;)V", "variant", "getVariant$dd_sdk_android_core_release", "setVariant$dd_sdk_android_core_release", "buildFilePersistenceConfig", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "cleanupApplicationInfo", "", "cleanupProviders", "createExecutorService", "Ljava/util/concurrent/ExecutorService;", "executorContext", "createOkHttpCallFactory", "Lokhttp3/Call$Factory;", "block", "Lkotlin/Function1;", "Lokhttp3/OkHttpClient$Builder;", "Lkotlin/ExtensionFunctionType;", "createScheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "deleteLastFatalAnrSent", "deleteLastFatalAnrSent$dd_sdk_android_core_release", "deleteLastViewEvent", "deleteLastViewEvent$dd_sdk_android_core_release", "drainAndShutdownExecutors", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "getSafeContext", "initialize", "sdkInstanceId", "configuration", "Lcom/datadog/android/core/configuration/Configuration;", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "Lcom/datadog/android/privacy/TrackingConsent;", "initializeClockSync", "prepareNdkCrashData", "nativeSourceType", "readApplicationInformation", "readBuildId", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "readConfigurationSettings", "Lcom/datadog/android/core/configuration/Configuration$Core;", "readLastViewEvent", "resolveProcessInfo", "setupExecutors", "setupInfoProviders", "setupNetworkInfoProviders", "broadcastReceiverHandler", "Landroid/os/Handler;", "setupOkHttpClient", "shutDownExecutors", "stop", "writeLastFatalAnrSent", "anrTimestamp", "writeLastFatalAnrSent$dd_sdk_android_core_release", "writeLastViewEvent", "data", "", "writeLastViewEvent$dd_sdk_android_core_release", "Companion", "OkHttpCallFactory", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoreFeature {
    public static final String BUILD_ID_FILE_NAME = "datadog.buildId";
    public static final String BUILD_ID_IS_MISSING_INFO_MESSAGE = "Build ID is not found in the application assets. If you are using obfuscation, please use Datadog Gradle Plugin 1.13.0 or above to be able to de-obfuscate stacktraces.";
    public static final String BUILD_ID_READ_ERROR = "Failed to read Build ID information, de-obfuscation may not work properly.";
    private static final int CORE_DEFAULT_POOL_SIZE = 1;
    public static final String DATADOG_STORAGE_DIR_NAME = "datadog-%s";
    public static final String DEFAULT_APP_VERSION = "?";
    public static final String DEFAULT_SDK_VERSION = "3.13.1";
    public static final String DEFAULT_SOURCE_NAME = "android";
    public static final long DRAIN_WAIT_SECONDS = 10;
    public static final String LAST_FATAL_ANR_SENT_FILE_NAME = "last_fatal_anr_sent";
    public static final String LAST_RUM_VIEW_EVENT_FILE_NAME = "last_view_event";
    private static final long NETWORK_TIMEOUT_MS;
    public static final long NTP_CACHE_EXPIRATION_MINUTES = 30;
    public static final long NTP_DELAY_BETWEEN_SYNCS_MINUTES = 5;
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES;
    public static final String SDK_INITIALIZED_IN_SECONDARY_PROCESS_WARNING_MESSAGE = "Datadog SDK was initialized in a secondary process: although data will still be captured, nothing will be uploaded from this process. Make sure to also initialize the SDK from the main process of your application.";
    private static boolean disableKronosBackgroundSync;
    private MutableAccountInfoProvider accountInfoProvider;
    private AndroidInfoProvider androidInfoProvider;
    private volatile String appBuildId;
    private Context appContext;
    private final AppStartTimeProvider appStartTimeProvider;
    public BackPressureStrategy backpressureStrategy;
    private BatchProcessingLevel batchProcessingLevel;
    private BatchSize batchSize;
    public BroadcastReceiverThread broadcastReceiverThread;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    public OkHttpCallFactory callFactory;
    private volatile String clientToken;
    public ThreadPoolExecutor contextExecutorService;
    private ContextProvider contextProvider;
    private UploadSchedulerStrategy customUploadSchedulerStrategy;
    private volatile String envName;
    private final FlushableExecutorService.Factory executorServiceFactory;
    private DefaultFirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver;
    private final AtomicBoolean initialized;
    private final InternalLogger internalLogger;
    private volatile boolean isMainProcess;
    private KronosClock kronosClock;

    /* JADX INFO: renamed from: lastViewEvent$delegate, reason: from kotlin metadata */
    private final Lazy lastViewEvent;

    /* JADX INFO: renamed from: lastViewEventFile$delegate, reason: from kotlin metadata */
    private final Lazy lastViewEventFile;

    /* JADX INFO: renamed from: lastViewEventFileWriter$delegate, reason: from kotlin metadata */
    private final Lazy lastViewEventFileWriter;

    /* JADX INFO: renamed from: lazySharedOkHttpClient$delegate, reason: from kotlin metadata */
    private final Lazy lazySharedOkHttpClient;
    private Encryption localDataEncryption;
    private Float metricTelemetrySampleRateBypass;
    private NdkCrashHandler ndkCrashHandler;
    private NetworkInfoProvider networkInfoProvider;
    private AppVersionProvider packageVersionProvider;
    public FlushableExecutorService persistenceExecutorService;
    private PersistenceStrategy.Factory persistenceStrategyFactory;
    private final ScheduledExecutorServiceFactory scheduledExecutorServiceFactory;
    private volatile String sdkVersion;
    private volatile String serviceName;
    private volatile DatadogSite site;
    private volatile String sourceName;
    public File storageDir;
    private SystemInfoProvider systemInfoProvider;
    private TimeProvider timeProvider;
    private ConsentProvider trackingConsentProvider;
    public ScheduledThreadPoolExecutor uploadExecutorService;
    private UploadFrequency uploadFrequency;
    private MutableUserInfoProvider userInfoProvider;
    private volatile String variant;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FlushableExecutorService.Factory DEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY = new FlushableExecutorService.Factory() { // from class: com.datadog.android.core.internal.CoreFeature$$ExternalSyntheticLambda2
        @Override // com.datadog.android.core.thread.FlushableExecutorService.Factory
        public final FlushableExecutorService create(InternalLogger internalLogger, String str, BackPressureStrategy backPressureStrategy, TimeProvider timeProvider) {
            return CoreFeature.DEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY$lambda$11(internalLogger, str, backPressureStrategy, timeProvider);
        }
    };
    private static final ScheduledExecutorServiceFactory DEFAULT_SCHEDULED_EXECUTOR_SERVICE_FACTORY = new ScheduledExecutorServiceFactory() { // from class: com.datadog.android.core.internal.CoreFeature$$ExternalSyntheticLambda3
        @Override // com.datadog.android.core.internal.thread.ScheduledExecutorServiceFactory
        public final ScheduledExecutorService create(InternalLogger internalLogger, String str, BackPressureStrategy backPressureStrategy) {
            return CoreFeature.DEFAULT_SCHEDULED_EXECUTOR_SERVICE_FACTORY$lambda$12(internalLogger, str, backPressureStrategy);
        }
    };

    private static /* synthetic */ void getLazySharedOkHttpClient$annotations() {
    }

    public CoreFeature(InternalLogger internalLogger, AppStartTimeProvider appStartTimeProvider, FlushableExecutorService.Factory executorServiceFactory, ScheduledExecutorServiceFactory scheduledExecutorServiceFactory, BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(appStartTimeProvider, "appStartTimeProvider");
        Intrinsics.checkNotNullParameter(executorServiceFactory, "executorServiceFactory");
        Intrinsics.checkNotNullParameter(scheduledExecutorServiceFactory, "scheduledExecutorServiceFactory");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.internalLogger = internalLogger;
        this.appStartTimeProvider = appStartTimeProvider;
        this.executorServiceFactory = executorServiceFactory;
        this.scheduledExecutorServiceFactory = scheduledExecutorServiceFactory;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.lazySharedOkHttpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.datadog.android.core.internal.CoreFeature$lazySharedOkHttpClient$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                ConnectionSpec.Builder builderTlsVersions = new ConnectionSpec.Builder(ConnectionSpec.RESTRICTED_TLS).tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_3);
                CipherSuite[] rESTRICTED_CIPHER_SUITES$dd_sdk_android_core_release = CoreFeature.INSTANCE.getRESTRICTED_CIPHER_SUITES$dd_sdk_android_core_release();
                return new OkHttpClient.Builder().callTimeout(CoreFeature.INSTANCE.getNETWORK_TIMEOUT_MS$dd_sdk_android_core_release(), TimeUnit.MILLISECONDS).writeTimeout(CoreFeature.INSTANCE.getNETWORK_TIMEOUT_MS$dd_sdk_android_core_release(), TimeUnit.MILLISECONDS).protocols(CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1})).connectionSpecs(CollectionsKt.listOf(builderTlsVersions.cipherSuites((CipherSuite[]) Arrays.copyOf(rESTRICTED_CIPHER_SUITES$dd_sdk_android_core_release, rESTRICTED_CIPHER_SUITES$dd_sdk_android_core_release.length)).build())).dns(new RotatingDnsResolver(null, 0L, this.this$0.getTimeProvider(), 3, null)).build();
            }
        });
        this.initialized = new AtomicBoolean(false);
        this.firstPartyHostHeaderTypeResolver = new DefaultFirstPartyHostHeaderTypeResolver(MapsKt.emptyMap());
        this.networkInfoProvider = new NoOpNetworkInfoProvider();
        this.systemInfoProvider = new NoOpSystemInfoProvider();
        this.timeProvider = new DefaultTimeProvider();
        this.trackingConsentProvider = new NoOpConsentProvider();
        this.userInfoProvider = new NoOpMutableUserInfoProvider();
        this.accountInfoProvider = new NoOpMutableAccountInfoProvider();
        this.contextProvider = new NoOpContextProvider();
        this.packageVersionProvider = new NoOpAppVersionProvider();
        this.androidInfoProvider = new NoOpAndroidInfoProvider();
        this.clientToken = "";
        this.serviceName = "";
        this.sourceName = "android";
        this.sdkVersion = "3.13.1";
        this.isMainProcess = true;
        this.envName = "";
        this.variant = "";
        this.batchSize = BatchSize.MEDIUM;
        this.uploadFrequency = UploadFrequency.AVERAGE;
        this.batchProcessingLevel = BatchProcessingLevel.MEDIUM;
        this.ndkCrashHandler = new NoOpNdkCrashHandler();
        this.site = DatadogSite.US1;
        this.lastViewEvent = LazyKt.lazy(new Function0<JsonObject>() { // from class: com.datadog.android.core.internal.CoreFeature$lastViewEvent$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final JsonObject invoke() {
                JsonObject lastViewEvent = this.this$0.readLastViewEvent();
                if (lastViewEvent != null) {
                    this.this$0.deleteLastViewEvent$dd_sdk_android_core_release();
                }
                return lastViewEvent;
            }
        });
        this.lastViewEventFile = LazyKt.lazy(new Function0<File>() { // from class: com.datadog.android.core.internal.CoreFeature$lastViewEventFile$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return new File(this.this$0.getStorageDir$dd_sdk_android_core_release(), CoreFeature.LAST_RUM_VIEW_EVENT_FILE_NAME);
            }
        });
        this.lastViewEventFileWriter = LazyKt.lazy(new Function0<BatchFileReaderWriter>() { // from class: com.datadog.android.core.internal.CoreFeature$lastViewEventFileWriter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BatchFileReaderWriter invoke() {
                return BatchFileReaderWriter.INSTANCE.create(this.this$0.internalLogger, this.this$0.getLocalDataEncryption());
            }
        });
    }

    public /* synthetic */ CoreFeature(InternalLogger internalLogger, AppStartTimeProvider appStartTimeProvider, FlushableExecutorService.Factory factory, ScheduledExecutorServiceFactory scheduledExecutorServiceFactory, BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, appStartTimeProvider, factory, scheduledExecutorServiceFactory, (i & 16) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient getLazySharedOkHttpClient() {
        return (OkHttpClient) this.lazySharedOkHttpClient.getValue();
    }

    /* JADX INFO: compiled from: CoreFeature.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0006\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/core/internal/CoreFeature$OkHttpCallFactory;", "Lokhttp3/Call$Factory;", "factory", "Lkotlin/Function0;", "Lokhttp3/OkHttpClient;", "(Lkotlin/jvm/functions/Function0;)V", "okhttpClient", "getOkhttpClient", "()Lokhttp3/OkHttpClient;", "okhttpClient$delegate", "Lkotlin/Lazy;", "newCall", "Lokhttp3/Call;", "request", "Lokhttp3/Request;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OkHttpCallFactory implements Call.Factory {

        /* JADX INFO: renamed from: okhttpClient$delegate, reason: from kotlin metadata */
        private final Lazy okhttpClient;

        public OkHttpCallFactory(Function0<? extends OkHttpClient> factory) {
            Intrinsics.checkNotNullParameter(factory, "factory");
            this.okhttpClient = LazyKt.lazy(factory);
        }

        public final OkHttpClient getOkhttpClient() {
            return (OkHttpClient) this.okhttpClient.getValue();
        }

        @Override // okhttp3.Call.Factory
        public Call newCall(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            return getOkhttpClient().newCall(request);
        }
    }

    /* JADX INFO: renamed from: getInitialized$dd_sdk_android_core_release, reason: from getter */
    public final AtomicBoolean getInitialized() {
        return this.initialized;
    }

    /* JADX INFO: renamed from: getAppContext$dd_sdk_android_core_release, reason: from getter */
    public final Context getAppContext() {
        return this.appContext;
    }

    public final void setAppContext$dd_sdk_android_core_release(Context context) {
        this.appContext = context;
    }

    /* JADX INFO: renamed from: getFirstPartyHostHeaderTypeResolver$dd_sdk_android_core_release, reason: from getter */
    public final DefaultFirstPartyHostHeaderTypeResolver getFirstPartyHostHeaderTypeResolver() {
        return this.firstPartyHostHeaderTypeResolver;
    }

    public final void setFirstPartyHostHeaderTypeResolver$dd_sdk_android_core_release(DefaultFirstPartyHostHeaderTypeResolver defaultFirstPartyHostHeaderTypeResolver) {
        Intrinsics.checkNotNullParameter(defaultFirstPartyHostHeaderTypeResolver, "<set-?>");
        this.firstPartyHostHeaderTypeResolver = defaultFirstPartyHostHeaderTypeResolver;
    }

    /* JADX INFO: renamed from: getNetworkInfoProvider$dd_sdk_android_core_release, reason: from getter */
    public final NetworkInfoProvider getNetworkInfoProvider() {
        return this.networkInfoProvider;
    }

    public final void setNetworkInfoProvider$dd_sdk_android_core_release(NetworkInfoProvider networkInfoProvider) {
        Intrinsics.checkNotNullParameter(networkInfoProvider, "<set-?>");
        this.networkInfoProvider = networkInfoProvider;
    }

    /* JADX INFO: renamed from: getSystemInfoProvider$dd_sdk_android_core_release, reason: from getter */
    public final SystemInfoProvider getSystemInfoProvider() {
        return this.systemInfoProvider;
    }

    public final void setSystemInfoProvider$dd_sdk_android_core_release(SystemInfoProvider systemInfoProvider) {
        Intrinsics.checkNotNullParameter(systemInfoProvider, "<set-?>");
        this.systemInfoProvider = systemInfoProvider;
    }

    /* JADX INFO: renamed from: getTimeProvider$dd_sdk_android_core_release, reason: from getter */
    public final TimeProvider getTimeProvider() {
        return this.timeProvider;
    }

    public final void setTimeProvider$dd_sdk_android_core_release(TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(timeProvider, "<set-?>");
        this.timeProvider = timeProvider;
    }

    /* JADX INFO: renamed from: getTrackingConsentProvider$dd_sdk_android_core_release, reason: from getter */
    public final ConsentProvider getTrackingConsentProvider() {
        return this.trackingConsentProvider;
    }

    public final void setTrackingConsentProvider$dd_sdk_android_core_release(ConsentProvider consentProvider) {
        Intrinsics.checkNotNullParameter(consentProvider, "<set-?>");
        this.trackingConsentProvider = consentProvider;
    }

    /* JADX INFO: renamed from: getUserInfoProvider$dd_sdk_android_core_release, reason: from getter */
    public final MutableUserInfoProvider getUserInfoProvider() {
        return this.userInfoProvider;
    }

    public final void setUserInfoProvider$dd_sdk_android_core_release(MutableUserInfoProvider mutableUserInfoProvider) {
        Intrinsics.checkNotNullParameter(mutableUserInfoProvider, "<set-?>");
        this.userInfoProvider = mutableUserInfoProvider;
    }

    /* JADX INFO: renamed from: getAccountInfoProvider$dd_sdk_android_core_release, reason: from getter */
    public final MutableAccountInfoProvider getAccountInfoProvider() {
        return this.accountInfoProvider;
    }

    public final void setAccountInfoProvider$dd_sdk_android_core_release(MutableAccountInfoProvider mutableAccountInfoProvider) {
        Intrinsics.checkNotNullParameter(mutableAccountInfoProvider, "<set-?>");
        this.accountInfoProvider = mutableAccountInfoProvider;
    }

    /* JADX INFO: renamed from: getContextProvider$dd_sdk_android_core_release, reason: from getter */
    public final ContextProvider getContextProvider() {
        return this.contextProvider;
    }

    public final void setContextProvider$dd_sdk_android_core_release(ContextProvider contextProvider) {
        Intrinsics.checkNotNullParameter(contextProvider, "<set-?>");
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: getPackageVersionProvider$dd_sdk_android_core_release, reason: from getter */
    public final AppVersionProvider getPackageVersionProvider() {
        return this.packageVersionProvider;
    }

    public final void setPackageVersionProvider$dd_sdk_android_core_release(AppVersionProvider appVersionProvider) {
        Intrinsics.checkNotNullParameter(appVersionProvider, "<set-?>");
        this.packageVersionProvider = appVersionProvider;
    }

    /* JADX INFO: renamed from: getAndroidInfoProvider$dd_sdk_android_core_release, reason: from getter */
    public final AndroidInfoProvider getAndroidInfoProvider() {
        return this.androidInfoProvider;
    }

    public final void setAndroidInfoProvider$dd_sdk_android_core_release(AndroidInfoProvider androidInfoProvider) {
        Intrinsics.checkNotNullParameter(androidInfoProvider, "<set-?>");
        this.androidInfoProvider = androidInfoProvider;
    }

    public final OkHttpCallFactory getCallFactory$dd_sdk_android_core_release() {
        OkHttpCallFactory okHttpCallFactory = this.callFactory;
        if (okHttpCallFactory != null) {
            return okHttpCallFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callFactory");
        return null;
    }

    public final void setCallFactory$dd_sdk_android_core_release(OkHttpCallFactory okHttpCallFactory) {
        Intrinsics.checkNotNullParameter(okHttpCallFactory, "<set-?>");
        this.callFactory = okHttpCallFactory;
    }

    /* JADX INFO: renamed from: getKronosClock$dd_sdk_android_core_release, reason: from getter */
    public final KronosClock getKronosClock() {
        return this.kronosClock;
    }

    public final void setKronosClock$dd_sdk_android_core_release(KronosClock kronosClock) {
        this.kronosClock = kronosClock;
    }

    /* JADX INFO: renamed from: getClientToken$dd_sdk_android_core_release, reason: from getter */
    public final String getClientToken() {
        return this.clientToken;
    }

    public final void setClientToken$dd_sdk_android_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientToken = str;
    }

    /* JADX INFO: renamed from: getServiceName$dd_sdk_android_core_release, reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    public final void setServiceName$dd_sdk_android_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serviceName = str;
    }

    /* JADX INFO: renamed from: getSourceName$dd_sdk_android_core_release, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    public final void setSourceName$dd_sdk_android_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceName = str;
    }

    /* JADX INFO: renamed from: getSdkVersion$dd_sdk_android_core_release, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final void setSdkVersion$dd_sdk_android_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sdkVersion = str;
    }

    /* JADX INFO: renamed from: isMainProcess$dd_sdk_android_core_release, reason: from getter */
    public final boolean getIsMainProcess() {
        return this.isMainProcess;
    }

    public final void setMainProcess$dd_sdk_android_core_release(boolean z) {
        this.isMainProcess = z;
    }

    /* JADX INFO: renamed from: getEnvName$dd_sdk_android_core_release, reason: from getter */
    public final String getEnvName() {
        return this.envName;
    }

    public final void setEnvName$dd_sdk_android_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.envName = str;
    }

    /* JADX INFO: renamed from: getVariant$dd_sdk_android_core_release, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    public final void setVariant$dd_sdk_android_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.variant = str;
    }

    /* JADX INFO: renamed from: getBatchSize$dd_sdk_android_core_release, reason: from getter */
    public final BatchSize getBatchSize() {
        return this.batchSize;
    }

    public final void setBatchSize$dd_sdk_android_core_release(BatchSize batchSize) {
        Intrinsics.checkNotNullParameter(batchSize, "<set-?>");
        this.batchSize = batchSize;
    }

    /* JADX INFO: renamed from: getUploadFrequency$dd_sdk_android_core_release, reason: from getter */
    public final UploadFrequency getUploadFrequency() {
        return this.uploadFrequency;
    }

    public final void setUploadFrequency$dd_sdk_android_core_release(UploadFrequency uploadFrequency) {
        Intrinsics.checkNotNullParameter(uploadFrequency, "<set-?>");
        this.uploadFrequency = uploadFrequency;
    }

    /* JADX INFO: renamed from: getBatchProcessingLevel$dd_sdk_android_core_release, reason: from getter */
    public final BatchProcessingLevel getBatchProcessingLevel() {
        return this.batchProcessingLevel;
    }

    public final void setBatchProcessingLevel$dd_sdk_android_core_release(BatchProcessingLevel batchProcessingLevel) {
        Intrinsics.checkNotNullParameter(batchProcessingLevel, "<set-?>");
        this.batchProcessingLevel = batchProcessingLevel;
    }

    /* JADX INFO: renamed from: getMetricTelemetrySampleRateBypass$dd_sdk_android_core_release, reason: from getter */
    public final Float getMetricTelemetrySampleRateBypass() {
        return this.metricTelemetrySampleRateBypass;
    }

    public final void setMetricTelemetrySampleRateBypass$dd_sdk_android_core_release(Float f) {
        this.metricTelemetrySampleRateBypass = f;
    }

    /* JADX INFO: renamed from: getNdkCrashHandler$dd_sdk_android_core_release, reason: from getter */
    public final NdkCrashHandler getNdkCrashHandler() {
        return this.ndkCrashHandler;
    }

    public final void setNdkCrashHandler$dd_sdk_android_core_release(NdkCrashHandler ndkCrashHandler) {
        Intrinsics.checkNotNullParameter(ndkCrashHandler, "<set-?>");
        this.ndkCrashHandler = ndkCrashHandler;
    }

    /* JADX INFO: renamed from: getSite$dd_sdk_android_core_release, reason: from getter */
    public final DatadogSite getSite() {
        return this.site;
    }

    public final void setSite$dd_sdk_android_core_release(DatadogSite datadogSite) {
        Intrinsics.checkNotNullParameter(datadogSite, "<set-?>");
        this.site = datadogSite;
    }

    /* JADX INFO: renamed from: getAppBuildId$dd_sdk_android_core_release, reason: from getter */
    public final String getAppBuildId() {
        return this.appBuildId;
    }

    public final void setAppBuildId$dd_sdk_android_core_release(String str) {
        this.appBuildId = str;
    }

    /* JADX INFO: renamed from: getCustomUploadSchedulerStrategy$dd_sdk_android_core_release, reason: from getter */
    public final UploadSchedulerStrategy getCustomUploadSchedulerStrategy() {
        return this.customUploadSchedulerStrategy;
    }

    public final void setCustomUploadSchedulerStrategy$dd_sdk_android_core_release(UploadSchedulerStrategy uploadSchedulerStrategy) {
        this.customUploadSchedulerStrategy = uploadSchedulerStrategy;
    }

    public final ScheduledThreadPoolExecutor getUploadExecutorService$dd_sdk_android_core_release() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.uploadExecutorService;
        if (scheduledThreadPoolExecutor != null) {
            return scheduledThreadPoolExecutor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uploadExecutorService");
        return null;
    }

    public final void setUploadExecutorService$dd_sdk_android_core_release(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Intrinsics.checkNotNullParameter(scheduledThreadPoolExecutor, "<set-?>");
        this.uploadExecutorService = scheduledThreadPoolExecutor;
    }

    public final FlushableExecutorService getPersistenceExecutorService$dd_sdk_android_core_release() {
        FlushableExecutorService flushableExecutorService = this.persistenceExecutorService;
        if (flushableExecutorService != null) {
            return flushableExecutorService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("persistenceExecutorService");
        return null;
    }

    public final void setPersistenceExecutorService$dd_sdk_android_core_release(FlushableExecutorService flushableExecutorService) {
        Intrinsics.checkNotNullParameter(flushableExecutorService, "<set-?>");
        this.persistenceExecutorService = flushableExecutorService;
    }

    public final ThreadPoolExecutor getContextExecutorService$dd_sdk_android_core_release() {
        ThreadPoolExecutor threadPoolExecutor = this.contextExecutorService;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contextExecutorService");
        return null;
    }

    public final void setContextExecutorService$dd_sdk_android_core_release(ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "<set-?>");
        this.contextExecutorService = threadPoolExecutor;
    }

    public final BroadcastReceiverThread getBroadcastReceiverThread$dd_sdk_android_core_release() {
        BroadcastReceiverThread broadcastReceiverThread = this.broadcastReceiverThread;
        if (broadcastReceiverThread != null) {
            return broadcastReceiverThread;
        }
        Intrinsics.throwUninitializedPropertyAccessException("broadcastReceiverThread");
        return null;
    }

    public final void setBroadcastReceiverThread$dd_sdk_android_core_release(BroadcastReceiverThread broadcastReceiverThread) {
        Intrinsics.checkNotNullParameter(broadcastReceiverThread, "<set-?>");
        this.broadcastReceiverThread = broadcastReceiverThread;
    }

    public final BackPressureStrategy getBackpressureStrategy$dd_sdk_android_core_release() {
        BackPressureStrategy backPressureStrategy = this.backpressureStrategy;
        if (backPressureStrategy != null) {
            return backPressureStrategy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backpressureStrategy");
        return null;
    }

    public final void setBackpressureStrategy$dd_sdk_android_core_release(BackPressureStrategy backPressureStrategy) {
        Intrinsics.checkNotNullParameter(backPressureStrategy, "<set-?>");
        this.backpressureStrategy = backPressureStrategy;
    }

    /* JADX INFO: renamed from: getLocalDataEncryption$dd_sdk_android_core_release, reason: from getter */
    public final Encryption getLocalDataEncryption() {
        return this.localDataEncryption;
    }

    public final void setLocalDataEncryption$dd_sdk_android_core_release(Encryption encryption) {
        this.localDataEncryption = encryption;
    }

    /* JADX INFO: renamed from: getPersistenceStrategyFactory$dd_sdk_android_core_release, reason: from getter */
    public final PersistenceStrategy.Factory getPersistenceStrategyFactory() {
        return this.persistenceStrategyFactory;
    }

    public final void setPersistenceStrategyFactory$dd_sdk_android_core_release(PersistenceStrategy.Factory factory) {
        this.persistenceStrategyFactory = factory;
    }

    public final File getStorageDir$dd_sdk_android_core_release() {
        File file = this.storageDir;
        if (file != null) {
            return file;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storageDir");
        return null;
    }

    public final void setStorageDir$dd_sdk_android_core_release(File file) {
        Intrinsics.checkNotNullParameter(file, "<set-?>");
        this.storageDir = file;
    }

    public final long getAppStartTimeNs$dd_sdk_android_core_release() {
        return this.appStartTimeProvider.getAppStartTimeNs();
    }

    public final long getAppUptimeNs$dd_sdk_android_core_release() {
        return this.appStartTimeProvider.getAppUptimeNs();
    }

    public final JsonObject getLastViewEvent$dd_sdk_android_core_release() {
        return (JsonObject) this.lastViewEvent.getValue();
    }

    private final File getLastViewEventFile() {
        return (File) this.lastViewEventFile.getValue();
    }

    private final BatchFileReaderWriter getLastViewEventFileWriter() {
        return (BatchFileReaderWriter) this.lastViewEventFileWriter.getValue();
    }

    public final Long getLastFatalAnrSent$dd_sdk_android_core_release() {
        String textSafe;
        File file = new File(getStorageDir$dd_sdk_android_core_release(), LAST_FATAL_ANR_SENT_FILE_NAME);
        if (!FileExtKt.existsSafe(file, this.internalLogger) || (textSafe = FileExtKt.readTextSafe(file, Charsets.UTF_8, this.internalLogger)) == null) {
            return null;
        }
        return StringsKt.toLongOrNull(textSafe);
    }

    public final void initialize(final Context appContext, final String sdkInstanceId, Configuration configuration, TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(sdkInstanceId, "sdkInstanceId");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(consent, "consent");
        if (this.initialized.get()) {
            return;
        }
        this.appContext = appContext;
        readConfigurationSettings(configuration.getCoreConfig$dd_sdk_android_core_release());
        readApplicationInformation(appContext, configuration);
        resolveProcessInfo(appContext);
        setupExecutors();
        ConcurrencyExtKt.executeSafe(getPersistenceExecutorService$dd_sdk_android_core_release(), "NTP Sync initialization", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.CoreFeature$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.initializeClockSync(appContext);
            }
        });
        setupOkHttpClient(configuration.getCoreConfig$dd_sdk_android_core_release());
        this.firstPartyHostHeaderTypeResolver.addKnownHostsWithHeaderTypes$dd_sdk_android_core_release(configuration.getCoreConfig$dd_sdk_android_core_release().getFirstPartyHostsWithHeaderTypes());
        this.androidInfoProvider = new DefaultAndroidInfoProvider(appContext);
        setStorageDir$dd_sdk_android_core_release((File) StrictModeExtKt.allowThreadDiskReads(new Function0<File>() { // from class: com.datadog.android.core.internal.CoreFeature.initialize.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File cacheDir = appContext.getCacheDir();
                String str = String.format(Locale.US, CoreFeature.DATADOG_STORAGE_DIR_NAME, Arrays.copyOf(new Object[]{sdkInstanceId}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return new File(cacheDir, str);
            }
        }));
        Object obj = configuration.getAdditionalConfig$dd_sdk_android_core_release().get(Datadog.DD_NATIVE_SOURCE_TYPE);
        prepareNdkCrashData(obj instanceof String ? (String) obj : null);
        setupInfoProviders(appContext, consent);
        this.initialized.set(true);
    }

    public final void stop() {
        if (this.initialized.get()) {
            Context context = this.appContext;
            if (context != null) {
                this.networkInfoProvider.unregister(context);
                this.systemInfoProvider.unregister(context);
            }
            this.trackingConsentProvider.unregisterAllCallbacks();
            cleanupApplicationInfo();
            cleanupProviders();
            shutDownExecutors();
            try {
                KronosClock kronosClock = this.kronosClock;
                if (kronosClock != null) {
                    kronosClock.shutdown();
                }
            } catch (IllegalStateException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.CoreFeature.stop.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Trying to shut down Kronos when it is already not running";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
            this.initialized.set(false);
            this.ndkCrashHandler = new NoOpNdkCrashHandler();
            this.trackingConsentProvider = new NoOpConsentProvider();
            this.appContext = null;
        }
    }

    public final FilePersistenceConfig buildFilePersistenceConfig() {
        return new FilePersistenceConfig(this.batchSize.getWindowDurationMs(), 0L, 0L, 0, 0L, 0L, 0L, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    public final ExecutorService createExecutorService(String executorContext) {
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        return this.executorServiceFactory.create(this.internalLogger, executorContext, getBackpressureStrategy$dd_sdk_android_core_release(), this.timeProvider);
    }

    public final ScheduledExecutorService createScheduledExecutorService(String executorContext) {
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        return this.scheduledExecutorServiceFactory.create(this.internalLogger, executorContext, getBackpressureStrategy$dd_sdk_android_core_release());
    }

    public final Call.Factory createOkHttpCallFactory(Function1<? super OkHttpClient.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new Call.Factory(this, block) { // from class: com.datadog.android.core.internal.CoreFeature.createOkHttpCallFactory.1
            private final OkHttpClient client;

            {
                OkHttpClient.Builder builderNewBuilder = this.getLazySharedOkHttpClient().newBuilder();
                block.invoke(builderNewBuilder);
                this.client = builderNewBuilder.build();
            }

            @Override // okhttp3.Call.Factory
            public Call newCall(Request request) {
                Intrinsics.checkNotNullParameter(request, "request");
                return this.client.newCall(request);
            }
        };
    }

    public final void drainAndShutdownExecutors() throws UnsupportedOperationException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        getContextExecutorService$dd_sdk_android_core_release().getQueue().drainTo(arrayList);
        getContextExecutorService$dd_sdk_android_core_release().shutdown();
        getContextExecutorService$dd_sdk_android_core_release().awaitTermination(10L, TimeUnit.SECONDS);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = arrayList2;
        getPersistenceExecutorService$dd_sdk_android_core_release().drainTo(arrayList3);
        getUploadExecutorService$dd_sdk_android_core_release().getQueue().drainTo(arrayList3);
        getPersistenceExecutorService$dd_sdk_android_core_release().shutdown();
        getUploadExecutorService$dd_sdk_android_core_release().shutdown();
        getPersistenceExecutorService$dd_sdk_android_core_release().awaitTermination(10L, TimeUnit.SECONDS);
        getUploadExecutorService$dd_sdk_android_core_release().awaitTermination(10L, TimeUnit.SECONDS);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
    }

    public final void writeLastViewEvent$dd_sdk_android_core_release(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TelemetryContext telemetryContext = new TelemetryContext("rum", null, 2, null);
        byte[] bArrSerializeToBytes = getLastViewEventFileWriter().serializeToBytes(new RawBatchEvent(data, null, 2, null), telemetryContext);
        if (bArrSerializeToBytes == null) {
            return;
        }
        getLastViewEventFileWriter().writeBinaryData(getLastViewEventFile(), bArrSerializeToBytes, false, telemetryContext);
    }

    public final void deleteLastViewEvent$dd_sdk_android_core_release() {
        if (FileExtKt.existsSafe(getLastViewEventFile(), this.internalLogger)) {
            FileExtKt.deleteSafe(getLastViewEventFile(), this.internalLogger);
            return;
        }
        File lastViewEventFile$dd_sdk_android_core_release = DatadogNdkCrashHandler.INSTANCE.getLastViewEventFile$dd_sdk_android_core_release(getStorageDir$dd_sdk_android_core_release());
        if (FileExtKt.existsSafe(lastViewEventFile$dd_sdk_android_core_release, this.internalLogger)) {
            FileExtKt.deleteSafe(lastViewEventFile$dd_sdk_android_core_release, this.internalLogger);
        }
    }

    public final void writeLastFatalAnrSent$dd_sdk_android_core_release(long anrTimestamp) {
        FileExtKt.writeTextSafe(new File(getStorageDir$dd_sdk_android_core_release(), LAST_FATAL_ANR_SENT_FILE_NAME), String.valueOf(anrTimestamp), Charsets.UTF_8, this.internalLogger);
    }

    public final void deleteLastFatalAnrSent$dd_sdk_android_core_release() {
        File file = new File(getStorageDir$dd_sdk_android_core_release(), LAST_FATAL_ANR_SENT_FILE_NAME);
        if (FileExtKt.existsSafe(file, this.internalLogger)) {
            FileExtKt.deleteSafe(file, this.internalLogger);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject readLastViewEvent() {
        File lastViewEventFile$dd_sdk_android_core_release;
        if (FileExtKt.existsSafe(getLastViewEventFile(), this.internalLogger)) {
            lastViewEventFile$dd_sdk_android_core_release = getLastViewEventFile();
        } else {
            lastViewEventFile$dd_sdk_android_core_release = DatadogNdkCrashHandler.INSTANCE.getLastViewEventFile$dd_sdk_android_core_release(getStorageDir$dd_sdk_android_core_release());
            if (!FileExtKt.existsSafe(lastViewEventFile$dd_sdk_android_core_release, this.internalLogger)) {
                lastViewEventFile$dd_sdk_android_core_release = null;
            }
        }
        if (lastViewEventFile$dd_sdk_android_core_release == null) {
            return null;
        }
        List<RawBatchEvent> data = BatchFileReaderWriter.INSTANCE.create(this.internalLogger, this.localDataEncryption).readData(lastViewEventFile$dd_sdk_android_core_release, new TelemetryContext("rum", null, 2, null));
        if (data.isEmpty()) {
            return null;
        }
        return new JsonObjectDeserializer(this.internalLogger).deserialize(new String(((RawBatchEvent) CollectionsKt.last((List) data)).getData(), Charsets.UTF_8));
    }

    private final void prepareNdkCrashData(String nativeSourceType) {
        if (this.isMainProcess) {
            File storageDir$dd_sdk_android_core_release = getStorageDir$dd_sdk_android_core_release();
            FlushableExecutorService persistenceExecutorService$dd_sdk_android_core_release = getPersistenceExecutorService$dd_sdk_android_core_release();
            NdkCrashLogDeserializer ndkCrashLogDeserializer = new NdkCrashLogDeserializer(this.internalLogger);
            InternalLogger internalLogger = this.internalLogger;
            Function0<JsonObject> function0 = new Function0<JsonObject>() { // from class: com.datadog.android.core.internal.CoreFeature.prepareNdkCrashData.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final JsonObject invoke() {
                    return CoreFeature.this.getLastViewEvent$dd_sdk_android_core_release();
                }
            };
            if (nativeSourceType == null) {
                nativeSourceType = "ndk";
            }
            DatadogNdkCrashHandler datadogNdkCrashHandler = new DatadogNdkCrashHandler(storageDir$dd_sdk_android_core_release, persistenceExecutorService$dd_sdk_android_core_release, ndkCrashLogDeserializer, internalLogger, function0, nativeSourceType);
            this.ndkCrashHandler = datadogNdkCrashHandler;
            datadogNdkCrashHandler.prepareData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeClockSync(Context appContext) {
        if (this.buildSdkVersionProvider.getIsAtLeastN()) {
            appContext = getSafeContext(appContext);
        }
        Context context = appContext;
        AndroidClockFactory androidClockFactory = AndroidClockFactory.INSTANCE;
        List listListOf = CollectionsKt.listOf((Object[]) new DatadogNtpEndpoint[]{DatadogNtpEndpoint.NTP_0, DatadogNtpEndpoint.NTP_1, DatadogNtpEndpoint.NTP_2, DatadogNtpEndpoint.NTP_3});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(((DatadogNtpEndpoint) it.next()).getHost());
        }
        TimeUnit timeUnit = TimeUnit.MINUTES;
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        KronosClock kronosClockCreateKronosClock$default = AndroidClockFactory.createKronosClock$default(context, new LoggingSyncListener(this.internalLogger), arrayList, 0L, 300000L, 1800000L, 0L, 72, null);
        if (!disableKronosBackgroundSync) {
            try {
                kronosClockCreateKronosClock$default.syncInBackground();
            } catch (IllegalStateException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.CoreFeature$initializeClockSync$2$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to launch a synchronize local time with an NTP server.";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
        this.timeProvider = new KronosTimeProvider(kronosClockCreateKronosClock$default, this.internalLogger);
        this.kronosClock = kronosClockCreateKronosClock$default;
    }

    private final Context getSafeContext(Context appContext) {
        Context contextCreateDeviceProtectedStorageContext = appContext.createDeviceProtectedStorageContext();
        return contextCreateDeviceProtectedStorageContext == null ? appContext : contextCreateDeviceProtectedStorageContext;
    }

    private final void readApplicationInformation(Context appContext, Configuration configuration) {
        PackageInfo packageInfo = getPackageInfo(appContext);
        Integer numValueOf = packageInfo != null ? Integer.valueOf(packageInfo.versionCode) : null;
        String version$dd_sdk_android_core_release = configuration.getVersion$dd_sdk_android_core_release();
        if (version$dd_sdk_android_core_release == null) {
            version$dd_sdk_android_core_release = packageInfo != null ? packageInfo.versionName : null;
            if (version$dd_sdk_android_core_release == null) {
                String string = numValueOf != null ? numValueOf.toString() : null;
                version$dd_sdk_android_core_release = string == null ? "?" : string;
            }
        }
        this.packageVersionProvider = new DefaultAppVersionProvider(version$dd_sdk_android_core_release, numValueOf != null ? numValueOf.intValue() : 0);
        this.clientToken = configuration.getClientToken$dd_sdk_android_core_release();
        String service$dd_sdk_android_core_release = configuration.getService$dd_sdk_android_core_release();
        if (service$dd_sdk_android_core_release == null) {
            service$dd_sdk_android_core_release = appContext.getPackageName();
            Intrinsics.checkNotNullExpressionValue(service$dd_sdk_android_core_release, "appContext.packageName");
        }
        this.serviceName = service$dd_sdk_android_core_release;
        this.envName = configuration.getEnv$dd_sdk_android_core_release();
        this.variant = configuration.getVariant$dd_sdk_android_core_release();
        this.appBuildId = readBuildId(appContext);
    }

    private final PackageInfo getPackageInfo(Context appContext) {
        try {
            String packageName = appContext.getPackageName();
            PackageManager packageManager = appContext.getPackageManager();
            if (this.buildSdkVersionProvider.getIsAtLeastTiramisu()) {
                return packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0L));
            }
            return packageManager.getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.CoreFeature.getPackageInfo.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to read your application's version name";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    private final String readBuildId(Context context) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(BUILD_ID_FILE_NAME);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(BUILD_ID_FILE_NAME)");
            Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String string = StringsKt.trim((CharSequence) TextStreamsKt.readText(bufferedReader)).toString();
                CloseableKt.closeFinally(bufferedReader, null);
                return string;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        } catch (FileNotFoundException unused) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.CoreFeature$readBuildId$1$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CoreFeature.BUILD_ID_IS_MISSING_INFO_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        } catch (Exception e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.CoreFeature$readBuildId$1$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CoreFeature.BUILD_ID_READ_ERROR;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    private final void readConfigurationSettings(Configuration.Core configuration) {
        this.batchSize = configuration.getBatchSize();
        this.uploadFrequency = configuration.getUploadFrequency();
        this.localDataEncryption = configuration.getEncryption();
        this.persistenceStrategyFactory = configuration.getPersistenceStrategyFactory();
        this.site = configuration.getSite();
        setBackpressureStrategy$dd_sdk_android_core_release(configuration.getBackpressureStrategy());
        this.customUploadSchedulerStrategy = configuration.getUploadSchedulerStrategy();
    }

    private final void setupInfoProviders(Context appContext, TrackingConsent consent) {
        this.trackingConsentProvider = new TrackingConsentProvider(consent);
        Handler handler = new Handler(getBroadcastReceiverThread$dd_sdk_android_core_release().getLooper());
        BroadcastReceiverSystemInfoProvider broadcastReceiverSystemInfoProvider = new BroadcastReceiverSystemInfoProvider(this.internalLogger, handler);
        this.systemInfoProvider = broadcastReceiverSystemInfoProvider;
        broadcastReceiverSystemInfoProvider.register(appContext);
        setupNetworkInfoProviders(appContext, handler);
        this.userInfoProvider = new DatadogUserInfoProvider();
        this.accountInfoProvider = new DatadogAccountInfoProvider(this.internalLogger);
    }

    private final void setupNetworkInfoProviders(Context appContext, Handler broadcastReceiverHandler) {
        BroadcastReceiverNetworkInfoProvider broadcastReceiverNetworkInfoProvider;
        if (this.buildSdkVersionProvider.getIsAtLeastN()) {
            broadcastReceiverNetworkInfoProvider = new CallbackNetworkInfoProvider(this.buildSdkVersionProvider, this.internalLogger);
        } else {
            broadcastReceiverNetworkInfoProvider = new BroadcastReceiverNetworkInfoProvider(this.internalLogger, broadcastReceiverHandler, this.buildSdkVersionProvider);
        }
        this.networkInfoProvider = broadcastReceiverNetworkInfoProvider;
        broadcastReceiverNetworkInfoProvider.register(appContext);
    }

    private final void setupOkHttpClient(final Configuration.Core configuration) {
        setCallFactory$dd_sdk_android_core_release(new OkHttpCallFactory(new Function0<OkHttpClient>() { // from class: com.datadog.android.core.internal.CoreFeature.setupOkHttpClient.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                OkHttpClient.Builder builderNewBuilder = CoreFeature.this.getLazySharedOkHttpClient().newBuilder();
                if (configuration.getNeedsClearTextHttp()) {
                    builderNewBuilder.connectionSpecs(CollectionsKt.listOf(ConnectionSpec.CLEARTEXT));
                }
                builderNewBuilder.addInterceptor(new GzipRequestInterceptor(CoreFeature.this.internalLogger));
                if (configuration.getProxy() != null) {
                    builderNewBuilder.proxy(configuration.getProxy());
                    builderNewBuilder.proxyAuthenticator(configuration.getProxyAuth());
                }
                return builderNewBuilder.build();
            }
        }));
    }

    private final void setupExecutors() {
        setUploadExecutorService$dd_sdk_android_core_release(new LoggingScheduledThreadPoolExecutor(1, "upload", this.internalLogger, getBackpressureStrategy$dd_sdk_android_core_release()));
        setPersistenceExecutorService$dd_sdk_android_core_release(this.executorServiceFactory.create(this.internalLogger, "storage", getBackpressureStrategy$dd_sdk_android_core_release(), this.timeProvider));
        setContextExecutorService$dd_sdk_android_core_release(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new BackPressuredBlockingQueue(this.internalLogger, RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, 2048, Integer.MAX_VALUE, new Function0<Unit>() { // from class: com.datadog.android.core.internal.CoreFeature$setupExecutors$contextQueue$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function1<Object, Unit>() { // from class: com.datadog.android.core.internal.CoreFeature$setupExecutors$contextQueue$2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }
        }, null, this.timeProvider), new DatadogThreadFactory(RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX)));
        setBroadcastReceiverThread$dd_sdk_android_core_release(new BroadcastReceiverThread());
        getBroadcastReceiverThread$dd_sdk_android_core_release().start();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0047  */
    private final void resolveProcessInfo(Context appContext) {
        String processName;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object next;
        if (this.buildSdkVersionProvider.getIsAtLeastP()) {
            processName = Application.getProcessName();
        } else {
            int iMyPid = Process.myPid();
            Object systemService = appContext.getSystemService("activity");
            if (!(systemService instanceof ActivityManager)) {
                systemService = null;
            }
            ActivityManager activityManager = (ActivityManager) systemService;
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                processName = null;
            } else {
                Iterator<T> it = runningAppProcesses.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (((ActivityManager.RunningAppProcessInfo) next).pid != iMyPid);
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                if (runningAppProcessInfo != null) {
                    processName = runningAppProcessInfo.processName;
                } else {
                    processName = null;
                }
            }
        }
        this.isMainProcess = processName == null ? true : Intrinsics.areEqual(appContext.getPackageName(), processName);
        if (this.isMainProcess) {
            return;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.CoreFeature.resolveProcessInfo.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CoreFeature.SDK_INITIALIZED_IN_SECONDARY_PROCESS_WARNING_MESSAGE;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private final void shutDownExecutors() {
        getUploadExecutorService$dd_sdk_android_core_release().shutdownNow();
        getContextExecutorService$dd_sdk_android_core_release().shutdownNow();
        getPersistenceExecutorService$dd_sdk_android_core_release().shutdownNow();
        getBroadcastReceiverThread$dd_sdk_android_core_release().quitSafely();
        try {
            try {
                getUploadExecutorService$dd_sdk_android_core_release().awaitTermination(1L, TimeUnit.SECONDS);
                getContextExecutorService$dd_sdk_android_core_release().awaitTermination(1L, TimeUnit.SECONDS);
                getPersistenceExecutorService$dd_sdk_android_core_release().awaitTermination(1L, TimeUnit.SECONDS);
            } catch (SecurityException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.CoreFeature.shutDownExecutors.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Thread was unable to set its own interrupted state";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private final void cleanupApplicationInfo() {
        this.clientToken = "";
        this.packageVersionProvider = new NoOpAppVersionProvider();
        this.serviceName = "";
        this.sourceName = "android";
        this.sdkVersion = "3.13.1";
        this.isMainProcess = true;
        this.envName = "";
        this.variant = "";
    }

    private final void cleanupProviders() {
        this.firstPartyHostHeaderTypeResolver = new DefaultFirstPartyHostHeaderTypeResolver(MapsKt.emptyMap());
        this.networkInfoProvider = new NoOpNetworkInfoProvider();
        this.systemInfoProvider = new NoOpSystemInfoProvider();
        this.timeProvider = new DefaultTimeProvider();
        this.trackingConsentProvider = new NoOpConsentProvider();
        this.userInfoProvider = new NoOpMutableUserInfoProvider();
        this.androidInfoProvider = new NoOpAndroidInfoProvider();
    }

    /* JADX INFO: compiled from: CoreFeature.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0080\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/datadog/android/core/internal/CoreFeature$Companion;", "", "()V", "BUILD_ID_FILE_NAME", "", "BUILD_ID_IS_MISSING_INFO_MESSAGE", "BUILD_ID_READ_ERROR", "CORE_DEFAULT_POOL_SIZE", "", "DATADOG_STORAGE_DIR_NAME", "DEFAULT_APP_VERSION", "DEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY", "Lcom/datadog/android/core/thread/FlushableExecutorService$Factory;", "getDEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release", "()Lcom/datadog/android/core/thread/FlushableExecutorService$Factory;", "DEFAULT_SCHEDULED_EXECUTOR_SERVICE_FACTORY", "Lcom/datadog/android/core/internal/thread/ScheduledExecutorServiceFactory;", "getDEFAULT_SCHEDULED_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/thread/ScheduledExecutorServiceFactory;", "DEFAULT_SDK_VERSION", "DEFAULT_SOURCE_NAME", "DRAIN_WAIT_SECONDS", "", "LAST_FATAL_ANR_SENT_FILE_NAME", "LAST_RUM_VIEW_EVENT_FILE_NAME", "NETWORK_TIMEOUT_MS", "getNETWORK_TIMEOUT_MS$dd_sdk_android_core_release", "()J", "NTP_CACHE_EXPIRATION_MINUTES", "NTP_DELAY_BETWEEN_SYNCS_MINUTES", "RESTRICTED_CIPHER_SUITES", "", "Lokhttp3/CipherSuite;", "getRESTRICTED_CIPHER_SUITES$dd_sdk_android_core_release", "()[Lokhttp3/CipherSuite;", "[Lokhttp3/CipherSuite;", "SDK_INITIALIZED_IN_SECONDARY_PROCESS_WARNING_MESSAGE", "disableKronosBackgroundSync", "", "getDisableKronosBackgroundSync$dd_sdk_android_core_release", "()Z", "setDisableKronosBackgroundSync$dd_sdk_android_core_release", "(Z)V", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FlushableExecutorService.Factory getDEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release() {
            return CoreFeature.DEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY;
        }

        public final ScheduledExecutorServiceFactory getDEFAULT_SCHEDULED_EXECUTOR_SERVICE_FACTORY$dd_sdk_android_core_release() {
            return CoreFeature.DEFAULT_SCHEDULED_EXECUTOR_SERVICE_FACTORY;
        }

        public final long getNETWORK_TIMEOUT_MS$dd_sdk_android_core_release() {
            return CoreFeature.NETWORK_TIMEOUT_MS;
        }

        public final CipherSuite[] getRESTRICTED_CIPHER_SUITES$dd_sdk_android_core_release() {
            return CoreFeature.RESTRICTED_CIPHER_SUITES;
        }

        public final boolean getDisableKronosBackgroundSync$dd_sdk_android_core_release() {
            return CoreFeature.disableKronosBackgroundSync;
        }

        public final void setDisableKronosBackgroundSync$dd_sdk_android_core_release(boolean z) {
            CoreFeature.disableKronosBackgroundSync = z;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        NETWORK_TIMEOUT_MS = 45000L;
        RESTRICTED_CIPHER_SUITES = new CipherSuite[]{CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384};
    }

    static final FlushableExecutorService DEFAULT_FLUSHABLE_EXECUTOR_SERVICE_FACTORY$lambda$11(InternalLogger logger, String executorContext, BackPressureStrategy backPressureStrategy, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        Intrinsics.checkNotNullParameter(backPressureStrategy, "backPressureStrategy");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        return new BackPressureExecutorService(logger, executorContext, backPressureStrategy, timeProvider);
    }

    static final ScheduledExecutorService DEFAULT_SCHEDULED_EXECUTOR_SERVICE_FACTORY$lambda$12(InternalLogger logger, String executorContext, BackPressureStrategy backPressureStrategy) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        Intrinsics.checkNotNullParameter(backPressureStrategy, "backPressureStrategy");
        return new LoggingScheduledThreadPoolExecutor(1, executorContext, logger, backPressureStrategy);
    }
}
