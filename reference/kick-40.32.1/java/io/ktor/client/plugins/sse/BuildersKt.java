package io.ktor.client.plugins.sse;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.log.LogAttributes;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.call.SavedHttpResponse;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.URLParserKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: builders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a.\u0010\u0006\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001aQ\u0010\u0013\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0083\u0001\u0010\u0013\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001a\u0010\u001b\u001a[\u0010\u0013\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001d\u0010\u001e\u001az\u0010%\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b#\u0010$\u001a¬\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b&\u0010'\u001a\u0084\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b(\u0010)\u001aQ\u0010+\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b*\u0010\u0012\u001a\u0083\u0001\u0010+\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b,\u0010\u001b\u001a[\u0010+\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b-\u0010\u001e\u001az\u0010/\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b.\u0010$\u001a¬\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b0\u00101\u001a\u0084\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b2\u00103\u001am\u0010\u0013\u001a\u000206*\u00020\b2\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001d\u00107\u001a\u009f\u0001\u0010\u0013\u001a\u000206*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b8\u00109\u001aw\u0010\u0013\u001a\u000206*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b:\u0010;\u001a\u0096\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b<\u0010=\u001aÈ\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b>\u0010?\u001a \u0001\u0010%\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b@\u0010A\u001am\u0010+\u001a\u000206*\u00020\b2\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b-\u00107\u001a\u009f\u0001\u0010+\u001a\u000206*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\bB\u00109\u001aw\u0010+\u001a\u000206*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\bC\u0010;\u001a\u0096\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b2\u0010=\u001aÈ\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\bD\u0010E\u001a \u0001\u0010/\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\bF\u0010G\u001al\u0010L\u001a\u00028\u0000\"\u0006\b\u0000\u0010H\u0018\u0001*\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0017\u0010I\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0082H¢\u0006\u0004\bJ\u0010K\u001a5\u0010P\u001a\u00020\u0003\"\b\b\u0000\u0010H*\u00020\"*\u00020\u000e2\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000M2\b\u0010O\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\bP\u0010Q\u001a/\u0010X\u001a\u00020V*\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010R2\b\u0010U\u001a\u0004\u0018\u00010T2\u0006\u0010W\u001a\u00020VH\u0002¢\u0006\u0004\bX\u0010Y\u001a\u0019\u0010\\\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010[\u001a\u00020Z¢\u0006\u0004\b\\\u0010]\" \u0010^\u001a\b\u0012\u0004\u0012\u00020\u000b0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\" \u0010b\u001a\b\u0012\u0004\u0012\u00020\t0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bb\u0010_\u001a\u0004\bc\u0010a\" \u0010d\u001a\b\u0012\u0004\u0012\u00020\u000b0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bd\u0010_\u001a\u0004\be\u0010a\" \u0010f\u001a\b\u0012\u0004\u0012\u00020\u000b0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bf\u0010_\u001a\u0004\bg\u0010a\"4\u0010h\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bh\u0010_\u001a\u0004\bi\u0010a\" \u0010j\u001a\b\u0012\u0004\u0012\u00020Z0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bj\u0010_\u001a\u0004\bk\u0010a¨\u0006l"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/sse/SSEConfig;", "", "Lkotlin/ExtensionFunctionType;", "config", "SSE", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/HttpClient;", "Lkotlin/time/Duration;", "reconnectionTime", "", "showCommentEvents", "showRetryEvents", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lio/ktor/client/plugins/sse/ClientSSESession;", "serverSentEventsSession-i8z2VEo", "(Lio/ktor/client/HttpClient;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession", "", "scheme", LogAttributes.HOST, "", "port", "path", "serverSentEventsSession-xEWcMm4", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "serverSentEventsSession-mY9Nd3A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "serverSentEvents-mY9Nd3A", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents", "serverSentEvents-1wIb-0I", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-3bFjkrY", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sseSession-i8z2VEo", "sseSession", "sseSession-xEWcMm4", "sseSession-mY9Nd3A", "sse-mY9Nd3A", "sse", "sse-tL6_L-A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sse-Mswn-_c", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "deserialize", "Lio/ktor/client/plugins/sse/ClientSSESessionWithDeserialization;", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession-tL6_L-A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession-Mswn-_c", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-Mswn-_c", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-BqdlHlk", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-pTj2aPc", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sseSession-tL6_L-A", "sseSession-Mswn-_c", "sse-BAHpl2s", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sse-Q9yt8Vw", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "additionalAttributes", "processSession-rp2poPw", "(Lio/ktor/client/HttpClient;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processSession", "Lio/ktor/util/AttributeKey;", "attributeKey", "value", "addAttribute", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/client/call/HttpClientCall;", NotificationCompat.CATEGORY_CALL, "", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "cause", "mapToSSEException", "(Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;[BLjava/lang/Throwable;)Ljava/lang/Throwable;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "policy", "bufferPolicy", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/plugins/sse/SSEBufferPolicy;)V", "sseRequestAttr", "Lio/ktor/util/AttributeKey;", "getSseRequestAttr", "()Lio/ktor/util/AttributeKey;", "reconnectionTimeAttr", "getReconnectionTimeAttr", "showCommentEventsAttr", "getShowCommentEventsAttr", "showRetryEventsAttr", "getShowRetryEventsAttr", "deserializerAttr", "getDeserializerAttr", "sseBufferPolicyAttr", "getSseBufferPolicyAttr", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuildersKt {
    private static final AttributeKey<Function2<TypeInfo, String, Object>> deserializerAttr;
    private static final AttributeKey<Duration> reconnectionTimeAttr;
    private static final AttributeKey<Boolean> showCommentEventsAttr;
    private static final AttributeKey<Boolean> showRetryEventsAttr;
    private static final AttributeKey<SSEBufferPolicy> sseBufferPolicyAttr;
    private static final AttributeKey<Boolean> sseRequestAttr;

    public static final AttributeKey<Boolean> getSseRequestAttr() {
        return sseRequestAttr;
    }

    public static final AttributeKey<Duration> getReconnectionTimeAttr() {
        return reconnectionTimeAttr;
    }

    public static final AttributeKey<Boolean> getShowCommentEventsAttr() {
        return showCommentEventsAttr;
    }

    public static final AttributeKey<Boolean> getShowRetryEventsAttr() {
        return showRetryEventsAttr;
    }

    public static final AttributeKey<Function2<TypeInfo, String, Object>> getDeserializerAttr() {
        return deserializerAttr;
    }

    public static final AttributeKey<SSEBufferPolicy> getSseBufferPolicyAttr() {
        return sseBufferPolicyAttr;
    }

    public static final void SSE(HttpClientConfig<?> httpClientConfig, final Function1<? super SSEConfig, Unit> config) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        httpClientConfig.install(SSEKt.getSSE(), new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.SSE$lambda$0(config, (SSEConfig) obj);
            }
        });
    }

    static final Unit SSE$lambda$0(Function1 function1, SSEConfig install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        function1.invoke(install);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-i8z2VEo$default, reason: not valid java name */
    public static /* synthetic */ Object m12516serverSentEventsSessioni8z2VEo$default(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            duration = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            bool2 = null;
        }
        return m12515serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-xEWcMm4$default, reason: not valid java name */
    public static /* synthetic */ Object m12524serverSentEventsSessionxEWcMm4$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            duration = null;
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        if ((i & 64) != 0) {
            bool2 = null;
        }
        if ((i & 128) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEventsSession_xEWcMm4$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12523serverSentEventsSessionxEWcMm4(httpClient, str, str2, num, str3, duration, bool, bool2, function1, continuation);
    }

    static final Unit serverSentEventsSession_xEWcMm4$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-xEWcMm4, reason: not valid java name */
    public static final Object m12523serverSentEventsSessionxEWcMm4(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m12515serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_xEWcMm4$lambda$1(str, str2, num, str3, function1, (HttpRequestBuilder) obj);
            }
        }, continuation);
    }

    static final Unit serverSentEventsSession_xEWcMm4$lambda$1(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder serverSentEventsSession) {
        Intrinsics.checkNotNullParameter(serverSentEventsSession, "$this$serverSentEventsSession");
        HttpRequestKt.url$default(serverSentEventsSession, str, str2, num, str3, null, 16, null);
        function1.invoke(serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m12519serverSentEventsSessionmY9Nd3A$default(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEventsSession_mY9Nd3A$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12517serverSentEventsSessionmY9Nd3A(httpClient, str, duration, bool, bool2, (Function1<? super HttpRequestBuilder, Unit>) function1, (Continuation<? super ClientSSESession>) continuation);
    }

    static final Unit serverSentEventsSession_mY9Nd3A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A, reason: not valid java name */
    public static final Object m12517serverSentEventsSessionmY9Nd3A(HttpClient httpClient, final String str, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m12515serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_mY9Nd3A$lambda$1(str, function1, (HttpRequestBuilder) obj);
            }
        }, continuation);
    }

    static final Unit serverSentEventsSession_mY9Nd3A$lambda$1(String str, Function1 function1, HttpRequestBuilder serverSentEventsSession) {
        Intrinsics.checkNotNullParameter(serverSentEventsSession, "$this$serverSentEventsSession");
        URLParserKt.takeFrom(serverSentEventsSession.getUrl(), str);
        function1.invoke(serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX INFO: renamed from: serverSentEvents-mY9Nd3A, reason: not valid java name */
    public static final Object m12509serverSentEventsmY9Nd3A(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        BuildersKt$serverSentEvents$1 buildersKt$serverSentEvents$1;
        Object objM12515serverSentEventsSessioni8z2VEo;
        Boolean bool3;
        Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function3;
        Boolean bool4;
        ClientSSESession clientSSESession;
        Throwable th;
        HttpClient httpClient2;
        ClientSSESession clientSSESession2;
        if (continuation instanceof BuildersKt$serverSentEvents$1) {
            buildersKt$serverSentEvents$1 = (BuildersKt$serverSentEvents$1) continuation;
            if ((buildersKt$serverSentEvents$1.label & Integer.MIN_VALUE) != 0) {
                buildersKt$serverSentEvents$1.label -= Integer.MIN_VALUE;
            } else {
                buildersKt$serverSentEvents$1 = new BuildersKt$serverSentEvents$1(continuation);
            }
        } else {
            buildersKt$serverSentEvents$1 = new BuildersKt$serverSentEvents$1(continuation);
        }
        BuildersKt$serverSentEvents$1 buildersKt$serverSentEvents$2 = buildersKt$serverSentEvents$1;
        Object obj = buildersKt$serverSentEvents$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = buildersKt$serverSentEvents$2.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    buildersKt$serverSentEvents$2.L$0 = httpClient;
                    buildersKt$serverSentEvents$2.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    buildersKt$serverSentEvents$2.L$2 = SpillingKt.nullOutSpilledVariable(duration);
                    buildersKt$serverSentEvents$2.L$3 = SpillingKt.nullOutSpilledVariable(bool);
                    buildersKt$serverSentEvents$2.L$4 = SpillingKt.nullOutSpilledVariable(bool2);
                    buildersKt$serverSentEvents$2.L$5 = function2;
                    buildersKt$serverSentEvents$2.label = 1;
                    objM12515serverSentEventsSessioni8z2VEo = m12515serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, function1, buildersKt$serverSentEvents$2);
                    if (objM12515serverSentEventsSessioni8z2VEo != coroutine_suspended) {
                        bool3 = bool2;
                        function3 = function2;
                        bool4 = bool;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    clientSSESession2 = (ClientSSESession) buildersKt$serverSentEvents$2.L$6;
                    httpClient2 = (HttpClient) buildersKt$serverSentEvents$2.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScopeKt.cancel$default(clientSSESession2, null, 1, null);
                        return Unit.INSTANCE;
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        throw mapToSSEException(httpClient2, clientSSESession2.getCall(), clientSSESession2.bodyBuffer(), th);
                    }
                }
                Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function4 = (Function2) buildersKt$serverSentEvents$2.L$5;
                Boolean bool5 = (Boolean) buildersKt$serverSentEvents$2.L$4;
                Boolean bool6 = (Boolean) buildersKt$serverSentEvents$2.L$3;
                Duration duration2 = (Duration) buildersKt$serverSentEvents$2.L$2;
                Function1<? super HttpRequestBuilder, Unit> function5 = (Function1) buildersKt$serverSentEvents$2.L$1;
                HttpClient httpClient3 = (HttpClient) buildersKt$serverSentEvents$2.L$0;
                ResultKt.throwOnFailure(obj);
                objM12515serverSentEventsSessioni8z2VEo = obj;
                bool4 = bool6;
                duration = duration2;
                bool3 = bool5;
                function1 = function5;
                function3 = function4;
                httpClient = httpClient3;
                buildersKt$serverSentEvents$2.L$0 = httpClient;
                buildersKt$serverSentEvents$2.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                buildersKt$serverSentEvents$2.L$2 = SpillingKt.nullOutSpilledVariable(duration);
                buildersKt$serverSentEvents$2.L$3 = SpillingKt.nullOutSpilledVariable(bool4);
                buildersKt$serverSentEvents$2.L$4 = SpillingKt.nullOutSpilledVariable(bool3);
                buildersKt$serverSentEvents$2.L$5 = SpillingKt.nullOutSpilledVariable(function3);
                buildersKt$serverSentEvents$2.L$6 = clientSSESession;
                buildersKt$serverSentEvents$2.label = 2;
                if (function3.invoke(clientSSESession, buildersKt$serverSentEvents$2) != coroutine_suspended) {
                    clientSSESession2 = clientSSESession;
                    CoroutineScopeKt.cancel$default(clientSSESession2, null, 1, null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (CancellationException e2) {
                throw e2;
            } catch (Throwable th3) {
                th = th3;
                httpClient2 = httpClient;
                clientSSESession2 = clientSSESession;
                throw mapToSSEException(httpClient2, clientSSESession2.getCall(), clientSSESession2.bodyBuffer(), th);
            }
            clientSSESession = (ClientSSESession) objM12515serverSentEventsSessioni8z2VEo;
        } catch (Throwable th4) {
            CoroutineScopeKt.cancel$default(httpClient, null, 1, null);
            throw th4;
        }
    }

    /* JADX INFO: renamed from: serverSentEvents-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m12510serverSentEventsmY9Nd3A$default(HttpClient httpClient, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        return m12509serverSentEventsmY9Nd3A(httpClient, function1, duration, bool, bool2, function2, continuation);
    }

    /* JADX INFO: renamed from: serverSentEvents-1wIb-0I$default, reason: not valid java name */
    public static /* synthetic */ Object m12502serverSentEvents1wIb0I$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            duration = null;
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        if ((i & 64) != 0) {
            bool2 = null;
        }
        if ((i & 128) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEvents_1wIb_0I$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12501serverSentEvents1wIb0I(httpClient, str, str2, num, str3, duration, bool, bool2, function1, function2, continuation);
    }

    static final Unit serverSentEvents_1wIb_0I$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-1wIb-0I, reason: not valid java name */
    public static final Object m12501serverSentEvents1wIb0I(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objM12509serverSentEventsmY9Nd3A = m12509serverSentEventsmY9Nd3A(httpClient, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_1wIb_0I$lambda$1(str, str2, num, str3, function1, (HttpRequestBuilder) obj);
            }
        }, duration, bool, bool2, function2, continuation);
        return objM12509serverSentEventsmY9Nd3A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12509serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    static final Unit serverSentEvents_1wIb_0I$lambda$1(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder serverSentEvents) {
        Intrinsics.checkNotNullParameter(serverSentEvents, "$this$serverSentEvents");
        HttpRequestKt.url$default(serverSentEvents, str, str2, num, str3, null, 16, null);
        function1.invoke(serverSentEvents);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-3bFjkrY$default, reason: not valid java name */
    public static /* synthetic */ Object m12504serverSentEvents3bFjkrY$default(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEvents_3bFjkrY$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12503serverSentEvents3bFjkrY(httpClient, str, duration, bool, bool2, function1, function2, continuation);
    }

    static final Unit serverSentEvents_3bFjkrY$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-3bFjkrY, reason: not valid java name */
    public static final Object m12503serverSentEvents3bFjkrY(HttpClient httpClient, final String str, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objM12509serverSentEventsmY9Nd3A = m12509serverSentEventsmY9Nd3A(httpClient, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_3bFjkrY$lambda$1(str, function1, (HttpRequestBuilder) obj);
            }
        }, duration, bool, bool2, function2, continuation);
        return objM12509serverSentEventsmY9Nd3A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12509serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    static final Unit serverSentEvents_3bFjkrY$lambda$1(String str, Function1 function1, HttpRequestBuilder serverSentEvents) {
        Intrinsics.checkNotNullParameter(serverSentEvents, "$this$serverSentEvents");
        URLParserKt.takeFrom(serverSentEvents.getUrl(), str);
        function1.invoke(serverSentEvents);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-i8z2VEo$default, reason: not valid java name */
    public static /* synthetic */ Object m12540sseSessioni8z2VEo$default(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            duration = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            bool2 = null;
        }
        return m12539sseSessioni8z2VEo(httpClient, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-i8z2VEo, reason: not valid java name */
    public static final Object m12539sseSessioni8z2VEo(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m12515serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-xEWcMm4$default, reason: not valid java name */
    public static /* synthetic */ Object m12548sseSessionxEWcMm4$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            duration = null;
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        if ((i & 64) != 0) {
            bool2 = null;
        }
        if ((i & 128) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.sseSession_xEWcMm4$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12547sseSessionxEWcMm4(httpClient, str, str2, num, str3, duration, bool, bool2, function1, continuation);
    }

    static final Unit sseSession_xEWcMm4$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-xEWcMm4, reason: not valid java name */
    public static final Object m12547sseSessionxEWcMm4(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m12523serverSentEventsSessionxEWcMm4(httpClient, str, str2, num, str3, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m12543sseSessionmY9Nd3A$default(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.sseSession_mY9Nd3A$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12541sseSessionmY9Nd3A(httpClient, str, duration, bool, bool2, (Function1<? super HttpRequestBuilder, Unit>) function1, (Continuation<? super ClientSSESession>) continuation);
    }

    static final Unit sseSession_mY9Nd3A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A, reason: not valid java name */
    public static final Object m12541sseSessionmY9Nd3A(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m12517serverSentEventsSessionmY9Nd3A(httpClient, str, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sse-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m12534ssemY9Nd3A$default(HttpClient httpClient, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        return m12533ssemY9Nd3A(httpClient, function1, duration, bool, bool2, function2, continuation);
    }

    /* JADX INFO: renamed from: sse-mY9Nd3A, reason: not valid java name */
    public static final Object m12533ssemY9Nd3A(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objM12509serverSentEventsmY9Nd3A = m12509serverSentEventsmY9Nd3A(httpClient, function1, duration, bool, bool2, function2, continuation);
        return objM12509serverSentEventsmY9Nd3A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12509serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-tL6_L-A$default, reason: not valid java name */
    public static /* synthetic */ Object m12536ssetL6_LA$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.sse_tL6_L_A$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        if ((i & 32) != 0) {
            duration = null;
        }
        if ((i & 64) != 0) {
            bool = null;
        }
        if ((i & 128) != 0) {
            bool2 = null;
        }
        return m12535ssetL6_LA(httpClient, str, str2, num, str3, function1, duration, bool, bool2, function2, continuation);
    }

    static final Unit sse_tL6_L_A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-tL6_L-A, reason: not valid java name */
    public static final Object m12535ssetL6_LA(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1<? super HttpRequestBuilder, Unit> function1, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objM12501serverSentEvents1wIb0I = m12501serverSentEvents1wIb0I(httpClient, str, str2, num, str3, duration, bool, bool2, function1, function2, continuation);
        return objM12501serverSentEvents1wIb0I == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12501serverSentEvents1wIb0I : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m12529sseMswn_c$default(HttpClient httpClient, String str, Function1 function1, Duration duration, Boolean bool, Boolean bool2, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.sse_Mswn__c$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12527sseMswn_c(httpClient, str, (Function1<? super HttpRequestBuilder, Unit>) function1, (i & 4) != 0 ? null : duration, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object>) function2, (Continuation<? super Unit>) continuation);
    }

    static final Unit sse_Mswn__c$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-Mswn-_c, reason: not valid java name */
    public static final Object m12527sseMswn_c(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objM12503serverSentEvents3bFjkrY = m12503serverSentEvents3bFjkrY(httpClient, str, duration, bool, bool2, function1, function2, continuation);
        return objM12503serverSentEvents3bFjkrY == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12503serverSentEvents3bFjkrY : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m12520serverSentEventsSessionmY9Nd3A$default(HttpClient httpClient, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        return m12518serverSentEventsSessionmY9Nd3A(httpClient, (Function2<? super TypeInfo, ? super String, ? extends Object>) function2, duration, bool, bool2, (Function1<? super HttpRequestBuilder, Unit>) function1, (Continuation<? super ClientSSESessionWithDeserialization>) continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-tL6_L-A$default, reason: not valid java name */
    public static /* synthetic */ Object m12522serverSentEventsSessiontL6_LA$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            duration = null;
        }
        if ((i & 64) != 0) {
            bool = null;
        }
        if ((i & 128) != 0) {
            bool2 = null;
        }
        if ((i & 256) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEventsSession_tL6_L_A$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12521serverSentEventsSessiontL6_LA(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, continuation);
    }

    static final Unit serverSentEventsSession_tL6_L_A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-tL6_L-A, reason: not valid java name */
    public static final Object m12521serverSentEventsSessiontL6_LA(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m12518serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, (Function1<? super HttpRequestBuilder, Unit>) new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_tL6_L_A$lambda$1(str, str2, num, str3, function1, (HttpRequestBuilder) obj);
            }
        }, continuation);
    }

    static final Unit serverSentEventsSession_tL6_L_A$lambda$1(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder serverSentEventsSession) {
        Intrinsics.checkNotNullParameter(serverSentEventsSession, "$this$serverSentEventsSession");
        HttpRequestKt.url$default(serverSentEventsSession, str, str2, num, str3, null, 16, null);
        function1.invoke(serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m12514serverSentEventsSessionMswn_c$default(HttpClient httpClient, String str, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        if ((i & 32) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEventsSession_Mswn__c$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12513serverSentEventsSessionMswn_c(httpClient, str, function2, duration, bool, bool2, function1, continuation);
    }

    static final Unit serverSentEventsSession_Mswn__c$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-Mswn-_c, reason: not valid java name */
    public static final Object m12513serverSentEventsSessionMswn_c(HttpClient httpClient, final String str, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m12518serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, (Function1<? super HttpRequestBuilder, Unit>) new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_Mswn__c$lambda$1(str, function1, (HttpRequestBuilder) obj);
            }
        }, continuation);
    }

    static final Unit serverSentEventsSession_Mswn__c$lambda$1(String str, Function1 function1, HttpRequestBuilder serverSentEventsSession) {
        Intrinsics.checkNotNullParameter(serverSentEventsSession, "$this$serverSentEventsSession");
        URLParserKt.takeFrom(serverSentEventsSession.getUrl(), str);
        function1.invoke(serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX INFO: renamed from: serverSentEvents-Mswn-_c, reason: not valid java name */
    public static final Object m12507serverSentEventsMswn_c(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        BuildersKt$serverSentEvents$8 buildersKt$serverSentEvents$8;
        Object objM12518serverSentEventsSessionmY9Nd3A;
        Function2<? super TypeInfo, ? super String, ? extends Object> function4;
        Duration duration2;
        Boolean bool3;
        Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function5;
        Boolean bool4;
        ClientSSESessionWithDeserialization clientSSESessionWithDeserialization;
        HttpClient httpClient2;
        ClientSSESessionWithDeserialization clientSSESessionWithDeserialization2;
        if (continuation instanceof BuildersKt$serverSentEvents$8) {
            buildersKt$serverSentEvents$8 = (BuildersKt$serverSentEvents$8) continuation;
            if ((buildersKt$serverSentEvents$8.label & Integer.MIN_VALUE) != 0) {
                buildersKt$serverSentEvents$8.label -= Integer.MIN_VALUE;
            } else {
                buildersKt$serverSentEvents$8 = new BuildersKt$serverSentEvents$8(continuation);
            }
        } else {
            buildersKt$serverSentEvents$8 = new BuildersKt$serverSentEvents$8(continuation);
        }
        BuildersKt$serverSentEvents$8 buildersKt$serverSentEvents$9 = buildersKt$serverSentEvents$8;
        Object obj = buildersKt$serverSentEvents$9.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = buildersKt$serverSentEvents$9.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    buildersKt$serverSentEvents$9.L$0 = httpClient;
                    buildersKt$serverSentEvents$9.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    buildersKt$serverSentEvents$9.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    buildersKt$serverSentEvents$9.L$3 = SpillingKt.nullOutSpilledVariable(duration);
                    buildersKt$serverSentEvents$9.L$4 = SpillingKt.nullOutSpilledVariable(bool);
                    buildersKt$serverSentEvents$9.L$5 = SpillingKt.nullOutSpilledVariable(bool2);
                    buildersKt$serverSentEvents$9.L$6 = function3;
                    buildersKt$serverSentEvents$9.label = 1;
                    objM12518serverSentEventsSessionmY9Nd3A = m12518serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, function1, buildersKt$serverSentEvents$9);
                    if (objM12518serverSentEventsSessionmY9Nd3A != coroutine_suspended) {
                        function4 = function2;
                        duration2 = duration;
                        bool3 = bool;
                        function5 = function3;
                        bool4 = bool2;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    clientSSESessionWithDeserialization2 = (ClientSSESessionWithDeserialization) buildersKt$serverSentEvents$9.L$7;
                    httpClient2 = (HttpClient) buildersKt$serverSentEvents$9.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScopeKt.cancel$default(clientSSESessionWithDeserialization2, null, 1, null);
                        return Unit.INSTANCE;
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        throw mapToSSEException(httpClient2, clientSSESessionWithDeserialization2.getCall(), clientSSESessionWithDeserialization2.bodyBuffer(), th);
                    }
                }
                Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function6 = (Function2) buildersKt$serverSentEvents$9.L$6;
                Boolean bool5 = (Boolean) buildersKt$serverSentEvents$9.L$5;
                bool3 = (Boolean) buildersKt$serverSentEvents$9.L$4;
                duration2 = (Duration) buildersKt$serverSentEvents$9.L$3;
                function4 = (Function2) buildersKt$serverSentEvents$9.L$2;
                Function1<? super HttpRequestBuilder, Unit> function7 = (Function1) buildersKt$serverSentEvents$9.L$1;
                HttpClient httpClient3 = (HttpClient) buildersKt$serverSentEvents$9.L$0;
                ResultKt.throwOnFailure(obj);
                objM12518serverSentEventsSessionmY9Nd3A = obj;
                bool4 = bool5;
                function1 = function7;
                function5 = function6;
                httpClient = httpClient3;
                buildersKt$serverSentEvents$9.L$0 = httpClient;
                buildersKt$serverSentEvents$9.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                buildersKt$serverSentEvents$9.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                buildersKt$serverSentEvents$9.L$3 = SpillingKt.nullOutSpilledVariable(duration2);
                buildersKt$serverSentEvents$9.L$4 = SpillingKt.nullOutSpilledVariable(bool3);
                buildersKt$serverSentEvents$9.L$5 = SpillingKt.nullOutSpilledVariable(bool4);
                buildersKt$serverSentEvents$9.L$6 = SpillingKt.nullOutSpilledVariable(function5);
                buildersKt$serverSentEvents$9.L$7 = clientSSESessionWithDeserialization;
                buildersKt$serverSentEvents$9.label = 2;
                if (function5.invoke(clientSSESessionWithDeserialization, buildersKt$serverSentEvents$9) != coroutine_suspended) {
                    clientSSESessionWithDeserialization2 = clientSSESessionWithDeserialization;
                    CoroutineScopeKt.cancel$default(clientSSESessionWithDeserialization2, null, 1, null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (CancellationException e2) {
                throw e2;
            } catch (Throwable th2) {
                th = th2;
                httpClient2 = httpClient;
                clientSSESessionWithDeserialization2 = clientSSESessionWithDeserialization;
                throw mapToSSEException(httpClient2, clientSSESessionWithDeserialization2.getCall(), clientSSESessionWithDeserialization2.bodyBuffer(), th);
            }
            clientSSESessionWithDeserialization = (ClientSSESessionWithDeserialization) objM12518serverSentEventsSessionmY9Nd3A;
        } catch (Throwable th3) {
            CoroutineScopeKt.cancel$default(httpClient, null, 1, null);
            throw th3;
        }
    }

    /* JADX INFO: renamed from: serverSentEvents-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m12508serverSentEventsMswn_c$default(HttpClient httpClient, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        return m12507serverSentEventsMswn_c(httpClient, function1, function2, duration, bool, bool2, function3, continuation);
    }

    /* JADX INFO: renamed from: serverSentEvents-BqdlHlk$default, reason: not valid java name */
    public static /* synthetic */ Object m12506serverSentEventsBqdlHlk$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            duration = null;
        }
        if ((i & 64) != 0) {
            bool = null;
        }
        if ((i & 128) != 0) {
            bool2 = null;
        }
        if ((i & 256) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEvents_BqdlHlk$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12505serverSentEventsBqdlHlk(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, function3, continuation);
    }

    static final Unit serverSentEvents_BqdlHlk$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-BqdlHlk, reason: not valid java name */
    public static final Object m12505serverSentEventsBqdlHlk(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objM12507serverSentEventsMswn_c = m12507serverSentEventsMswn_c(httpClient, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_BqdlHlk$lambda$1(str, str2, num, str3, function1, (HttpRequestBuilder) obj);
            }
        }, function2, duration, bool, bool2, function3, continuation);
        return objM12507serverSentEventsMswn_c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12507serverSentEventsMswn_c : Unit.INSTANCE;
    }

    static final Unit serverSentEvents_BqdlHlk$lambda$1(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder serverSentEvents) {
        Intrinsics.checkNotNullParameter(serverSentEvents, "$this$serverSentEvents");
        HttpRequestKt.url$default(serverSentEvents, str, str2, num, str3, null, 16, null);
        function1.invoke(serverSentEvents);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-pTj2aPc$default, reason: not valid java name */
    public static /* synthetic */ Object m12512serverSentEventspTj2aPc$default(HttpClient httpClient, String str, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        if ((i & 32) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEvents_pTj2aPc$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12511serverSentEventspTj2aPc(httpClient, str, function2, duration, bool, bool2, function1, function3, continuation);
    }

    static final Unit serverSentEvents_pTj2aPc$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-pTj2aPc, reason: not valid java name */
    public static final Object m12511serverSentEventspTj2aPc(HttpClient httpClient, final String str, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objM12507serverSentEventsMswn_c = m12507serverSentEventsMswn_c(httpClient, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_pTj2aPc$lambda$1(str, function1, (HttpRequestBuilder) obj);
            }
        }, function2, duration, bool, bool2, function3, continuation);
        return objM12507serverSentEventsMswn_c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12507serverSentEventsMswn_c : Unit.INSTANCE;
    }

    static final Unit serverSentEvents_pTj2aPc$lambda$1(String str, Function1 function1, HttpRequestBuilder serverSentEvents) {
        Intrinsics.checkNotNullParameter(serverSentEvents, "$this$serverSentEvents");
        URLParserKt.takeFrom(serverSentEvents.getUrl(), str);
        function1.invoke(serverSentEvents);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m12544sseSessionmY9Nd3A$default(HttpClient httpClient, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            duration = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            bool2 = null;
        }
        return m12542sseSessionmY9Nd3A(httpClient, (Function2<? super TypeInfo, ? super String, ? extends Object>) function2, duration, bool, bool2, (Function1<? super HttpRequestBuilder, Unit>) function1, (Continuation<? super ClientSSESessionWithDeserialization>) continuation);
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A, reason: not valid java name */
    public static final Object m12542sseSessionmY9Nd3A(HttpClient httpClient, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m12518serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-tL6_L-A$default, reason: not valid java name */
    public static /* synthetic */ Object m12546sseSessiontL6_LA$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            duration = null;
        }
        if ((i & 64) != 0) {
            bool = null;
        }
        if ((i & 128) != 0) {
            bool2 = null;
        }
        if ((i & 256) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.sseSession_tL6_L_A$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12545sseSessiontL6_LA(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, continuation);
    }

    static final Unit sseSession_tL6_L_A$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-tL6_L-A, reason: not valid java name */
    public static final Object m12545sseSessiontL6_LA(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m12521serverSentEventsSessiontL6_LA(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sseSession-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m12538sseSessionMswn_c$default(HttpClient httpClient, String str, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        if ((i & 32) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.sseSession_Mswn__c$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12537sseSessionMswn_c(httpClient, str, function2, duration, bool, bool2, function1, continuation);
    }

    static final Unit sseSession_Mswn__c$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-Mswn-_c, reason: not valid java name */
    public static final Object m12537sseSessionMswn_c(HttpClient httpClient, String str, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m12513serverSentEventsSessionMswn_c(httpClient, str, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sse-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m12530sseMswn_c$default(HttpClient httpClient, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        return m12528sseMswn_c(httpClient, (Function1<? super HttpRequestBuilder, Unit>) function1, (Function2<? super TypeInfo, ? super String, ? extends Object>) function2, duration, bool, bool2, (Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object>) function3, (Continuation<? super Unit>) continuation);
    }

    /* JADX INFO: renamed from: sse-Mswn-_c, reason: not valid java name */
    public static final Object m12528sseMswn_c(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objM12507serverSentEventsMswn_c = m12507serverSentEventsMswn_c(httpClient, function1, function2, duration, bool, bool2, function3, continuation);
        return objM12507serverSentEventsMswn_c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12507serverSentEventsMswn_c : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-BAHpl2s$default, reason: not valid java name */
    public static /* synthetic */ Object m12526sseBAHpl2s$default(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.sse_BAHpl2s$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        if ((i & 64) != 0) {
            duration = null;
        }
        if ((i & 128) != 0) {
            bool = null;
        }
        if ((i & 256) != 0) {
            bool2 = null;
        }
        return m12525sseBAHpl2s(httpClient, str, str2, num, str3, function1, function2, duration, bool, bool2, function3, continuation);
    }

    static final Unit sse_BAHpl2s$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-BAHpl2s, reason: not valid java name */
    public static final Object m12525sseBAHpl2s(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objM12505serverSentEventsBqdlHlk = m12505serverSentEventsBqdlHlk(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, function3, continuation);
        return objM12505serverSentEventsBqdlHlk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12505serverSentEventsBqdlHlk : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-Q9yt8Vw$default, reason: not valid java name */
    public static /* synthetic */ Object m12532sseQ9yt8Vw$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Duration duration, Boolean bool, Boolean bool2, Function2 function3, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BuildersKt.sse_Q9yt8Vw$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m12531sseQ9yt8Vw(httpClient, str, function1, function2, (i & 8) != 0 ? null : duration, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2, function3, continuation);
    }

    static final Unit sse_Q9yt8Vw$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-Q9yt8Vw, reason: not valid java name */
    public static final Object m12531sseQ9yt8Vw(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objM12511serverSentEventspTj2aPc = m12511serverSentEventspTj2aPc(httpClient, str, function2, duration, bool, bool2, function1, function3, continuation);
        return objM12511serverSentEventspTj2aPc == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12511serverSentEventspTj2aPc : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: processSession-rp2poPw, reason: not valid java name */
    private static final /* synthetic */ <T> Object m12500processSessionrp2poPw(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Function1<? super HttpRequestBuilder, Unit> function2, Continuation<? super T> continuation) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, true);
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, duration);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        function2.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        Intrinsics.needClassReification();
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new BuildersKt$processSession$2(httpStatement, completableDeferredCompletableDeferred$default, httpClient, null), 3, null);
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    private static final <T> void addAttribute(HttpRequestBuilder httpRequestBuilder, AttributeKey<T> attributeKey, T t) {
        if (t != null) {
            httpRequestBuilder.getAttributes().put(attributeKey, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapToSSEException(HttpClient httpClient, HttpClientCall httpClientCall, byte[] bArr, Throwable th) {
        SavedHttpResponse savedHttpResponse;
        if (httpClientCall == null) {
            savedHttpResponse = null;
        } else {
            if (bArr == null) {
                bArr = new byte[0];
            }
            SavedHttpCall savedHttpCall = new SavedHttpCall(httpClient, httpClientCall.getRequest(), httpClientCall.getResponse(), bArr);
            savedHttpCall.getAttributes().remove(HttpClientCall.INSTANCE.getCustomResponse$ktor_client_core());
            savedHttpCall.getAttributes().remove(sseRequestAttr);
            savedHttpResponse = new SavedHttpResponse(savedHttpCall, bArr, httpClientCall.getResponse());
            savedHttpCall.setResponse$ktor_client_core(savedHttpResponse);
        }
        return (!(th instanceof SSEClientException) || ((SSEClientException) th).getResponse() == null) ? new SSEClientException(savedHttpResponse, th, th.getMessage()) : th;
    }

    public static final void bufferPolicy(HttpRequestBuilder httpRequestBuilder, SSEBufferPolicy policy) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(policy, "policy");
        httpRequestBuilder.getAttributes().put(sseBufferPolicyAttr, policy);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-i8z2VEo, reason: not valid java name */
    public static final Object m12515serverSentEventsSessioni8z2VEo(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, Boxing.boxBoolean(true));
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, duration);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredCompletableDeferred$default, httpClient, null), 3, null);
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A, reason: not valid java name */
    public static final Object m12518serverSentEventsSessionmY9Nd3A(HttpClient httpClient, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, Boxing.boxBoolean(true));
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, duration);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        addAttribute(httpRequestBuilder, deserializerAttr, function2);
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new BuildersKt$serverSentEventsSessionmY9Nd3A$$inlined$processSessionrp2poPw$1(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredCompletableDeferred$default, httpClient, null), 3, null);
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static {
        KType kTypeTypeOf;
        KType kTypeTypeOf2;
        KType kTypeTypeOf3;
        KType kTypeTypeOf4;
        KType kTypeTypeOf5;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
        KType kTypeTypeOf6 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        sseRequestAttr = new AttributeKey<>("SSERequestFlag", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Duration.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(Duration.class);
        } catch (Throwable unused2) {
            kTypeTypeOf2 = null;
        }
        reconnectionTimeAttr = new AttributeKey<>("SSEReconnectionTime", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kTypeTypeOf3 = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused3) {
            kTypeTypeOf3 = null;
        }
        showCommentEventsAttr = new AttributeKey<>("SSEShowCommentEvents", new TypeInfo(orCreateKotlinClass3, kTypeTypeOf3));
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kTypeTypeOf4 = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused4) {
            kTypeTypeOf4 = null;
        }
        showRetryEventsAttr = new AttributeKey<>("SSEShowRetryEvents", new TypeInfo(orCreateKotlinClass4, kTypeTypeOf4));
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Function2.class);
        try {
            kTypeTypeOf5 = Reflection.typeOf(Function2.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(TypeInfo.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
        } catch (Throwable unused5) {
            kTypeTypeOf5 = null;
        }
        deserializerAttr = new AttributeKey<>("SSEDeserializer", new TypeInfo(orCreateKotlinClass5, kTypeTypeOf5));
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(SSEBufferPolicy.class);
        try {
            kTypeTypeOf6 = Reflection.typeOf(SSEBufferPolicy.class);
        } catch (Throwable unused6) {
        }
        sseBufferPolicyAttr = new AttributeKey<>("bufferPolicy", new TypeInfo(orCreateKotlinClass6, kTypeTypeOf6));
    }
}
