package com.amazon.mediatailorsdk;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.mediatailorsdk.logs.Logger;
import com.amazon.mediatailorsdk.logs.Logger_androidKt;
import com.amazon.mediatailorsdk.network.Resource;
import com.amazon.mediatailorsdk.network.tracking.AdTrackingUseCase;
import com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse;
import com.amazon.mediatailorsdk.utils.BinarySearchKt;
import com.amazon.mediatailorsdk.utils.DateTimeKt;
import com.amazon.mediatailorsdk.utils.DateTime_androidKt;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: SessionTracker.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010B\u001a\u00020C2\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020C0E¢\u0006\u0002\bFH\u0002J\u001c\u0010G\u001a\u00020C2\u0006\u0010H\u001a\u00020I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\rH\u0002JM\u0010O\u001a\u00020\u001c2\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010\u00032\b\u0010U\u001a\u0004\u0018\u00010\r2\u0006\u0010V\u001a\u00020\r2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010XH\u0002¢\u0006\u0002\u0010ZJ\u0012\u0010[\u001a\u00020C2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002J\u001f\u0010^\u001a\u00020C2\u0006\u0010_\u001a\u00020\r2\b\u0010`\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010aJö\u0001\u0010b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001Hd\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0c\"\u0004\b\u0000\u0010d2\u0006\u0010e\u001a\u00020\u00032\u0016\u0010f\u001a\u0012\u0012\u0004\u0012\u0002Hd0\u001fj\b\u0012\u0004\u0012\u0002Hd` 2\u0006\u0010g\u001a\u00020\r2\u0006\u0010h\u001a\u00020\u001c2F\u0010i\u001aB\u0012\u0013\u0012\u00110\r¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(l\u0012\u0013\u0012\u0011Hd¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002Hd`n2F\u0010o\u001aB\u0012\u0013\u0012\u00110\r¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(l\u0012\u0013\u0012\u0011Hd¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002Hd`n2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u0002Hd\u0012\u0004\u0012\u00020\r0EH\u0002J\u001f\u0010q\u001a\u00020C2\u0006\u0010_\u001a\u00020\r2\b\u0010`\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010aJ\"\u0010r\u001a\u00020C2\u0006\u0010_\u001a\u00020\r2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010sJ\u0018\u0010t\u001a\u00020C2\b\u0010u\u001a\u0004\u0018\u00010]H\u0086@¢\u0006\u0002\u0010vJ\u0018\u0010w\u001a\u00020C2\b\u0010x\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010yJ\u000e\u0010z\u001a\u00020CH\u0086@¢\u0006\u0002\u0010{J \u0010|\u001a\u00020C2\u0006\u0010_\u001a\u00020\r2\b\u0010`\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010sJ\u0016\u0010}\u001a\u00020C2\u0006\u0010~\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u007fJ\u001a\u0010\u0080\u0001\u001a\u00020C2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0086@¢\u0006\u0003\u0010\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020CH\u0086@¢\u0006\u0002\u0010{J\u000f\u0010\u0085\u0001\u001a\u00020CH\u0086@¢\u0006\u0002\u0010{J\u000f\u0010\u0086\u0001\u001a\u00020CH\u0086@¢\u0006\u0002\u0010{JR\u0010\u0087\u0001\u001a\u00020C2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012?\u0010\u008a\u0001\u001a:\u0012\u0015\u0012\u00130\u0089\u0001¢\u0006\r\bj\u0012\t\bk\u0012\u0005\b\b(\u0088\u0001\u0012\u0014\u0012\u00120\u008b\u0001¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020C0\fj\u0003`\u008c\u0001JR\u0010\u008d\u0001\u001a\u00020C2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012?\u0010\u008a\u0001\u001a:\u0012\u0015\u0012\u00130\u0089\u0001¢\u0006\r\bj\u0012\t\bk\u0012\u0005\b\b(\u0088\u0001\u0012\u0014\u0012\u00120\u008b\u0001¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020C0\fj\u0003`\u008c\u0001J\u0010\u0010\u008e\u0001\u001a\u00020C2\u0007\u0010\u008f\u0001\u001a\u00020?J\u0010\u0010\u0090\u0001\u001a\u00020C2\u0007\u0010\u008f\u0001\u001a\u00020?J\u0016\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0092\u0001H\u0086@¢\u0006\u0002\u0010{J \u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110\u0092\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u001cH\u0086@¢\u0006\u0003\u0010\u0095\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u001fj\b\u0012\u0004\u0012\u00020\u000e` X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#`$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u001fj\b\u0012\u0004\u0012\u00020\u0011` X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\"j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011`$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010)\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u0012\u0010.\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010/\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u0012\u00102\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u0010\u00103\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u0010\u00107\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u0012\u00109\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u0012\u0010:\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u000e\u0010;\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010>\u001a\u0012\u0012\u0004\u0012\u00020?0\u001fj\b\u0012\u0004\u0012\u00020?` X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0098\u0001\u001a\u00030\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009a\u0001"}, d2 = {"Lcom/amazon/mediatailorsdk/SessionTracker;", "", "trackingUrl", "", "palNonceManager", "Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;", "config", "Lcom/amazon/mediatailorsdk/SessionConfiguration;", "<init>", "(Ljava/lang/String;Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;Lcom/amazon/mediatailorsdk/SessionConfiguration;)V", "tag", "adStartComparator", "Lkotlin/Function2;", "", "Lcom/amazon/mediatailorsdk/AdData;", "adStartDateComparator", "nonlinearAdsStartComparator", "Lcom/amazon/mediatailorsdk/NonLinearAdsData;", "nonlinearAdsStartDateComparator", "incomingAdCountdownInterval", "trackingRequestInterval", "getTrackingRequestInterval$MediaTailor_release", "()D", "setTrackingRequestInterval$MediaTailor_release", "(D)V", "adTrackingUpdateMode", "Lcom/amazon/mediatailorsdk/AdTrackingUpdateMode;", "playheadAwareTracking", "", "paginatedTracking", "allAds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "availInfoMap", "Ljava/util/HashMap;", "Lcom/amazon/mediatailorsdk/AvailInfo;", "Lkotlin/collections/HashMap;", "nonLinearAdsOnTimeline", "allNonLinearAds", "adHasStartDate", "value", "currentAd", "getCurrentAd", "()Lcom/amazon/mediatailorsdk/AdData;", "checkedTimeRangeBegin", "Ljava/lang/Double;", "checkedTimeRangeEnd", "checkedTimeRangeAnchorAd", "nlCurrentAd", "nlCheckedTimeRangeBegin", "nlCheckedTimeRangeEnd", "nlCheckedTimeRangeAnchorAd", "trackingRequest", "Lkotlinx/coroutines/Job;", "lastTrackingRequestPos", "lastTrackingRequestNextToken", "lastAvailStartDateOffset", "lastPlayheadPos", "lastProgramDateTimePos", "continuousPbRangeBegin", "continuousPbRangeEnd", "currAdContPbRangeEnd", "allAdObservers", "Lcom/amazon/mediatailorsdk/AdObserver;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "notifyToAdObservers", "", FirebaseAnalytics.Param.METHOD, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "notifyAdTrackingEvent", "adTrackingEvent", "Lcom/amazon/mediatailorsdk/AdTrackingEvent;", "ad", "patchAdStartDate", "adData", "Lcom/amazon/mediatailorsdk/AdDataCommon;", "adStart", "processNonLinearAdsList", "avail", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail;", "nonlinearAvail", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail;", "availId", "availStart", "availStartDate", "adBreakTrackingEvents", "", "Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "(Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail;Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail;Ljava/lang/String;Ljava/lang/Double;D[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;)Z", "processAdTrackingResponse", "response", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse;", "requestAdTrackingInfoImp", "playhead", "programDateTime", "(DLjava/lang/Double;)V", "reevaluateAnchorAd", "Lkotlin/Triple;", ExifInterface.GPS_DIRECTION_TRUE, "adType", "adsList", "pos", "useProgramDateTime", "startComparator", "Lkotlin/ParameterName;", "name", TypedValues.Attributes.S_TARGET, "item", "Lcom/amazon/mediatailorsdk/utils/BinarySearchComparator;", "startDateComparator", "startTimeGetter", "onPlayheadUpdateImp", "requestAdTrackingInfo", "(DLjava/lang/Double;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAdTrackingInfo", "data", "(Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUpdatingAdTrackingInfo", "requestInterval", "(Ljava/lang/Double;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopUpdatingAdTrackingInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPlayheadUpdate", "onPlaybackRateUpdate", "rate", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPlaybackEvent", "playbackEvent", "Lcom/amazon/mediatailorsdk/PlaybackEvent;", "(Lcom/amazon/mediatailorsdk/PlaybackEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onVideoClick", "onAdClickthrough", "onAdSkip", "addUiEventListener", "event", "Lcom/amazon/mediatailorsdk/SessionUiEvent;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/amazon/mediatailorsdk/SessionUiEventData;", "Lcom/amazon/mediatailorsdk/SessionUiEventListener;", "removeUiEventListener", "addAdObserver", "adObserver", "removeAdObserver", "getAllAds", "", "getAllNonLinearAds", "includeOffTimelineAds", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionUiEventManager", "Lcom/amazon/mediatailorsdk/SessionUiEventManager;", "adBeaconManager", "Lcom/amazon/mediatailorsdk/AdBeaconManager;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SessionTracker {
    private final AdBeaconManager adBeaconManager;
    private boolean adHasStartDate;
    private final Function2<Double, AdData, Double> adStartComparator;
    private final Function2<Double, AdData, Double> adStartDateComparator;
    private final AdTrackingUpdateMode adTrackingUpdateMode;
    private final ArrayList<AdObserver> allAdObservers;
    private final ArrayList<AdData> allAds;
    private final HashMap<String, NonLinearAdsData> allNonLinearAds;
    private final HashMap<String, AvailInfo> availInfoMap;
    private AdData checkedTimeRangeAnchorAd;
    private Double checkedTimeRangeBegin;
    private Double checkedTimeRangeEnd;
    private final SessionConfiguration config;
    private double continuousPbRangeBegin;
    private double continuousPbRangeEnd;
    private double currAdContPbRangeEnd;
    private volatile AdData currentAd;
    private final double incomingAdCountdownInterval;
    private Double lastAvailStartDateOffset;
    private Double lastPlayheadPos;
    private Double lastProgramDateTimePos;
    private String lastTrackingRequestNextToken;
    private Double lastTrackingRequestPos;
    private final Mutex mutex;
    private NonLinearAdsData nlCheckedTimeRangeAnchorAd;
    private Double nlCheckedTimeRangeBegin;
    private Double nlCheckedTimeRangeEnd;
    private NonLinearAdsData nlCurrentAd;
    private final ArrayList<NonLinearAdsData> nonLinearAdsOnTimeline;
    private final Function2<Double, NonLinearAdsData, Double> nonlinearAdsStartComparator;
    private final Function2<Double, NonLinearAdsData, Double> nonlinearAdsStartDateComparator;
    private final boolean paginatedTracking;
    private final PalNonceManagerWrapper palNonceManager;
    private final boolean playheadAwareTracking;
    private final SessionUiEventManager sessionUiEventManager;
    private final String tag;
    private Job trackingRequest;
    private double trackingRequestInterval;
    private final String trackingUrl;

    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlaybackEvent.values().length];
            try {
                iArr[PlaybackEvent.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlaybackEvent.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlaybackEvent.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PlaybackEvent.RESUME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PlaybackEvent.MUTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PlaybackEvent.UNMUTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PlaybackEvent.FULLSCREEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PlaybackEvent.EXIT_FULLSCREEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$getAllAds$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0}, l = {1024}, m = "getAllAds", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "I$0"}, v = 2)
    static final class C05631 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05631(Continuation<? super C05631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.getAllAds(this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$getAllNonLinearAds$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0, 0}, l = {1024}, m = "getAllNonLinearAds", n = {"$this$withLock_u24default$iv", "includeOffTimelineAds", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "Z$0", "I$0"}, v = 2)
    static final class C05641 extends ContinuationImpl {
        int I$0;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C05641(Continuation<? super C05641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.getAllNonLinearAds(false, this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$onAdClickthrough$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0}, l = {1024}, m = "onAdClickthrough", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "I$0"}, v = 2)
    static final class C05661 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05661(Continuation<? super C05661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.onAdClickthrough(this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$onAdSkip$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0}, l = {1024}, m = "onAdSkip", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "I$0"}, v = 2)
    static final class C05671 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05671(Continuation<? super C05671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.onAdSkip(this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$onPlaybackEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0, 0}, l = {1024}, m = "onPlaybackEvent", n = {"playbackEvent", "$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C05681 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05681(Continuation<? super C05681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.onPlaybackEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$onPlayheadUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0, 0, 0}, l = {1024}, m = "onPlayheadUpdate", n = {"programDateTime", "$this$withLock_u24default$iv", "playhead", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "L$1", "D$0", "I$0"}, v = 2)
    static final class C05691 extends ContinuationImpl {
        double D$0;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05691(Continuation<? super C05691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.onPlayheadUpdate(0.0d, null, this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$onVideoClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0}, l = {1024}, m = "onVideoClick", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "I$0"}, v = 2)
    static final class C05701 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05701(Continuation<? super C05701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.onVideoClick(this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$requestAdTrackingInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0, 0, 0}, l = {1024}, m = "requestAdTrackingInfo", n = {"programDateTime", "$this$withLock_u24default$iv", "playhead", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "L$1", "D$0", "I$0"}, v = 2)
    static final class C05721 extends ContinuationImpl {
        double D$0;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05721(Continuation<? super C05721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.requestAdTrackingInfo(0.0d, null, this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$startUpdatingAdTrackingInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0, 0}, l = {1024}, m = "startUpdatingAdTrackingInfo", n = {"requestInterval", "$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C05741 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05741(Continuation<? super C05741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.startUpdatingAdTrackingInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$stopUpdatingAdTrackingInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0}, l = {1024}, m = "stopUpdatingAdTrackingInfo", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "I$0"}, v = 2)
    static final class C05751 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05751(Continuation<? super C05751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.stopUpdatingAdTrackingInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$updateAdTrackingInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker", f = "SessionTracker.kt", i = {0, 0, 0}, l = {1024}, m = "updateAdTrackingInfo", n = {"data", "$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C05761 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05761(Continuation<? super C05761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionTracker.this.updateAdTrackingInfo(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e4  */
    public SessionTracker(String str, PalNonceManagerWrapper palNonceManagerWrapper, SessionConfiguration config) {
        double dDoubleValue;
        boolean z;
        Intrinsics.checkNotNullParameter(config, "config");
        this.trackingUrl = str;
        this.palNonceManager = palNonceManagerWrapper;
        this.config = config;
        this.tag = "adTracking: ";
        this.adStartComparator = new Function2() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Double.valueOf(SessionTracker.adStartComparator$lambda$0(((Double) obj).doubleValue(), (AdData) obj2));
            }
        };
        this.adStartDateComparator = new Function2() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Double.valueOf(SessionTracker.adStartDateComparator$lambda$0(((Double) obj).doubleValue(), (AdData) obj2));
            }
        };
        this.nonlinearAdsStartComparator = new Function2() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Double.valueOf(SessionTracker.nonlinearAdsStartComparator$lambda$0(((Double) obj).doubleValue(), (NonLinearAdsData) obj2));
            }
        };
        this.nonlinearAdsStartDateComparator = new Function2() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Double.valueOf(SessionTracker.nonlinearAdsStartDateComparator$lambda$0(((Double) obj).doubleValue(), (NonLinearAdsData) obj2));
            }
        };
        Double incomingAdCountdownInterval = config.getIncomingAdCountdownInterval();
        this.incomingAdCountdownInterval = incomingAdCountdownInterval != null ? incomingAdCountdownInterval.doubleValue() : 5.0d;
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            dDoubleValue = -1.0d;
        } else {
            Double defaultTrackingRequestInterval = config.getDefaultTrackingRequestInterval();
            dDoubleValue = defaultTrackingRequestInterval != null ? defaultTrackingRequestInterval.doubleValue() : 0.0d;
        }
        this.trackingRequestInterval = dDoubleValue;
        if (Math.abs(dDoubleValue) > Double.MAX_VALUE || this.trackingRequestInterval == 0.0d) {
            this.trackingRequestInterval = 10.0d;
        }
        AdTrackingUpdateMode adTrackingUpdateMode = config.getAdTrackingUpdateMode();
        adTrackingUpdateMode = adTrackingUpdateMode == null ? AdTrackingUpdateMode.PAGINATION : adTrackingUpdateMode;
        this.adTrackingUpdateMode = adTrackingUpdateMode;
        this.playheadAwareTracking = adTrackingUpdateMode == AdTrackingUpdateMode.PLAYHEAD;
        this.paginatedTracking = adTrackingUpdateMode == AdTrackingUpdateMode.PAGINATION;
        this.allAds = new ArrayList<>();
        this.availInfoMap = new HashMap<>();
        this.nonLinearAdsOnTimeline = new ArrayList<>();
        this.allNonLinearAds = new HashMap<>();
        this.allAdObservers = new ArrayList<>();
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        SessionUiEventManager sessionUiEventManagerCreateSessionUiEventManager = SessionUiEventManagerKt.createSessionUiEventManager();
        this.sessionUiEventManager = sessionUiEventManagerCreateSessionUiEventManager;
        if (!Intrinsics.areEqual((Object) config.getDisableNoninteractiveClientSideBeaconing(), (Object) true)) {
            SessionFeatures sessionFeatures = config.getSessionFeatures();
            z = Intrinsics.areEqual(sessionFeatures != null ? sessionFeatures.getReportingMode() : null, SessionReportingMode.SERVER.getModeString());
        }
        AdBeaconManager adBeaconManagerCreateAdBeaconManager = AdBeaconManagerKt.createAdBeaconManager(z, new Function4() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SessionTracker.adBeaconManager$lambda$0(this.f$0, (AdData) obj, (AdData.TrackingEvent) obj2, (String) obj3, ((Integer) obj4).intValue());
            }
        });
        this.adBeaconManager = adBeaconManagerCreateAdBeaconManager;
        addAdObserver(sessionUiEventManagerCreateSessionUiEventManager);
        addAdObserver(adBeaconManagerCreateAdBeaconManager);
    }

    static final double adStartComparator$lambda$0(double d, AdData item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return d - item.getStart();
    }

    static final double adStartDateComparator$lambda$0(double d, AdData item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return d - item.getStartDate();
    }

    static final double nonlinearAdsStartComparator$lambda$0(double d, NonLinearAdsData item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return d - item.getStart();
    }

    static final double nonlinearAdsStartDateComparator$lambda$0(double d, NonLinearAdsData item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return d - item.getStartDate();
    }

    /* JADX INFO: renamed from: getTrackingRequestInterval$MediaTailor_release, reason: from getter */
    public final double getTrackingRequestInterval() {
        return this.trackingRequestInterval;
    }

    public final void setTrackingRequestInterval$MediaTailor_release(double d) {
        this.trackingRequestInterval = d;
    }

    public final AdData getCurrentAd() {
        return this.currentAd;
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$notifyToAdObservers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker$notifyToAdObservers$1", f = "SessionTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C05651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<AdObserver, Unit> $method;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05651(Function1<? super AdObserver, Unit> function1, Continuation<? super C05651> continuation) {
            super(2, continuation);
            this.$method = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionTracker.this.new C05651(this.$method, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = SessionTracker.this.allAdObservers;
                Function1<AdObserver, Unit> function1 = this.$method;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    function1.invoke((AdObserver) it.next());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyToAdObservers(Function1<? super AdObserver, Unit> method) {
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), Dispatchers.getMain(), null, new C05651(method, null), 2, null);
    }

    static /* synthetic */ void notifyAdTrackingEvent$default(SessionTracker sessionTracker, AdTrackingEvent adTrackingEvent, AdData adData, int i, Object obj) {
        if ((i & 2) != 0) {
            adData = null;
        }
        sessionTracker.notifyAdTrackingEvent(adTrackingEvent, adData);
    }

    private final void notifyAdTrackingEvent(final AdTrackingEvent adTrackingEvent, final AdData ad) {
        if (ad == null) {
            ad = this.currentAd;
        }
        if (ad != null) {
            Logger_androidKt.getLogger().d(this.tag + "Ad tracking event " + adTrackingEvent.getDebugName());
            notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SessionTracker.notifyAdTrackingEvent$lambda$0$0(ad, adTrackingEvent, (AdObserver) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notifyAdTrackingEvent$lambda$0$0(AdData adData, AdTrackingEvent adTrackingEvent, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        notifyToAdObservers.onAdTrackingEvent(adData, adTrackingEvent);
        return Unit.INSTANCE;
    }

    private final void patchAdStartDate(AdDataCommon adData, double adStart) {
        Double d;
        if (adData.getStartDate() == 0.0d && (d = this.lastAvailStartDateOffset) != null) {
            Intrinsics.checkNotNull(d);
            adData.setStartDate$MediaTailor_release(adStart + d.doubleValue());
        }
        boolean z = this.adHasStartDate;
        boolean z2 = !(adData.getStartDate() == 0.0d);
        this.adHasStartDate = z2;
        if (z2 != z) {
            Logger_androidKt.getLogger().d(this.tag + "Set adHasStartDate to " + this.adHasStartDate);
        }
    }

    private final boolean processNonLinearAdsList(AdTrackingResponse.Avail avail, AdTrackingResponse.NonLinearAvail nonlinearAvail, String availId, Double availStart, double availStartDate, AdBreakTrackingEvent[] adBreakTrackingEvents) {
        AdTrackingResponse.NonLinearAds[] nonLinearAdsList;
        AdTrackingResponse.NonLinearAds nonLinearAds = null;
        if (avail != null) {
            nonLinearAdsList = avail.getNonLinearAdsList();
        } else {
            nonLinearAdsList = nonlinearAvail != null ? nonlinearAvail.getNonLinearAdsList() : null;
        }
        boolean z = false;
        if (nonLinearAdsList != null && nonLinearAdsList.length != 0) {
            nonLinearAds = nonLinearAdsList[0];
        }
        AdTrackingResponse.NonLinearAds nonLinearAds2 = nonLinearAds;
        if (nonLinearAds2 != null) {
            if (availStart == null) {
                Logger_androidKt.getLogger().w(this.tag + "Invalid or missing nonlinear ad start time");
                return false;
            }
            Logger_androidKt.getLogger().d(this.tag + "nonLinearAds");
            if (availStartDate > 0.0d) {
                this.lastAvailStartDateOffset = Double.valueOf(availStartDate - availStart.doubleValue());
            }
            String str = availId;
            String strValueOf = (str == null || StringsKt.isBlank(str)) ? String.valueOf(availStart.doubleValue()) : availId;
            if (!this.allNonLinearAds.containsKey(strValueOf)) {
                final NonLinearAdsData nonLinearAdsDataCreateNonLinearAdsData = AdDataKt.createNonLinearAdsData(availStart.doubleValue(), availStartDate, availId, adBreakTrackingEvents, nonLinearAds2, avail == null);
                if (nonLinearAdsDataCreateNonLinearAdsData != null) {
                    patchAdStartDate(nonLinearAdsDataCreateNonLinearAdsData, availStart.doubleValue());
                    this.allNonLinearAds.put(strValueOf, nonLinearAdsDataCreateNonLinearAdsData);
                    if (BinarySearchKt.binarySearchExact(availStart, this.nonLinearAdsOnTimeline, this.nonlinearAdsStartComparator) < 0) {
                        this.nonLinearAdsOnTimeline.add(nonLinearAdsDataCreateNonLinearAdsData);
                        z = true;
                    }
                    notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SessionTracker.processNonLinearAdsList$lambda$1$0(nonLinearAdsDataCreateNonLinearAdsData, (AdObserver) obj);
                        }
                    });
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processNonLinearAdsList$lambda$1$0(NonLinearAdsData nonLinearAdsData, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        notifyToAdObservers.onNewNonLinearAds(nonLinearAdsData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processAdTrackingResponse(AdTrackingResponse response) {
        Double d;
        String str;
        double d2;
        int i;
        boolean z;
        int i2;
        String str2;
        AdTrackingResponse.NonLinearAvail[] nonLinearAvails;
        Double dValueOf;
        AdTrackingResponse.Avail[] avails;
        AdTrackingResponse.Avail[] availArr;
        int i3;
        int i4;
        Double d3;
        String str3;
        Double dValueOf2;
        boolean z2;
        String str4;
        boolean z3;
        String str5;
        AdTrackingResponse.Ad[] adArr;
        HashMap map;
        HashMap<String, AdInfo> map2;
        int i5;
        Double d4;
        String str6;
        int i6;
        String str7;
        AdBreakTrackingEvent[] adBreakTrackingEventArr;
        String str8;
        String str9;
        String str10;
        int iBinarySearchExact;
        Double dIsoDateTimeStringToEpochSeconds = DateTime_androidKt.isoDateTimeStringToEpochSeconds(response != null ? response.getDashAvailabilityStartTime() : null);
        String str11 = " (";
        if (response == null || (avails = response.getAvails()) == null) {
            d = dIsoDateTimeStringToEpochSeconds;
            str = " (";
            d2 = 0.0d;
            i = 1;
            z = false;
            i2 = 0;
        } else {
            int length = avails.length;
            int i7 = 0;
            z = false;
            i2 = 0;
            while (i7 < length) {
                int i8 = length;
                AdTrackingResponse.Avail avail = avails[i7];
                String availId = avail.getAvailId();
                String str12 = availId;
                if (str12 == null || StringsKt.isBlank(str12)) {
                    availArr = avails;
                    i3 = i7;
                    i4 = i8;
                    d3 = dIsoDateTimeStringToEpochSeconds;
                    str3 = str11;
                    Logger_androidKt.getLogger().w(this.tag + "Missing avail ID");
                } else {
                    Double startTimeInSeconds = avail.getStartTimeInSeconds();
                    String availProgramDateTime = avail.getAvailProgramDateTime();
                    if (availProgramDateTime != null && !StringsKt.isBlank(availProgramDateTime)) {
                        dValueOf2 = DateTime_androidKt.isoDateTimeStringToEpochSeconds(avail.getAvailProgramDateTime());
                    } else {
                        dValueOf2 = (dIsoDateTimeStringToEpochSeconds == null || startTimeInSeconds == null) ? null : Double.valueOf(dIsoDateTimeStringToEpochSeconds.doubleValue() + startTimeInSeconds.doubleValue());
                    }
                    double dDoubleValue = dValueOf2 != null ? dValueOf2.doubleValue() : 0.0d;
                    Double dIso8601IntervalToSeconds = DateTimeKt.iso8601IntervalToSeconds(avail.getAdMarkerDuration());
                    AdBreakTrackingEvent[] adBreakTrackingEvents = avail.getAdBreakTrackingEvents();
                    availArr = avails;
                    i4 = i8;
                    i3 = i7;
                    String str13 = availId;
                    if (processNonLinearAdsList(avail, null, str13, startTimeInSeconds, dDoubleValue, adBreakTrackingEvents)) {
                        i2 = 1;
                    }
                    AdTrackingResponse.Ad[] ads = avail.getAds();
                    AvailInfo availInfo = this.availInfoMap.get(str13);
                    String str14 = "";
                    if (ads == null) {
                        z2 = true;
                        str4 = "";
                    } else {
                        int length2 = ads.length;
                        str4 = "";
                        int i9 = 0;
                        z2 = true;
                        while (i9 < length2) {
                            AdTrackingResponse.Ad ad = ads[i9];
                            AdTrackingResponse.Avail avail2 = avail;
                            Double d5 = startTimeInSeconds;
                            double d6 = dDoubleValue;
                            str4 = ((Object) str4) + ad.getAdId() + WebViewLogEventConsumer.DDTAGS_SEPARATOR + ad.getStartTime() + WebViewLogEventConsumer.DDTAGS_SEPARATOR + ad.getDuration() + ";";
                            i9++;
                            startTimeInSeconds = d5;
                            avail = avail2;
                            dDoubleValue = d6;
                        }
                    }
                    AdTrackingResponse.Avail avail3 = avail;
                    Double d7 = startTimeInSeconds;
                    double d8 = dDoubleValue;
                    boolean z4 = (availInfo == null || !Intrinsics.areEqual(str4, availInfo.getDigest())) ? z2 : false;
                    Logger logger = Logger_androidKt.getLogger();
                    String str15 = this.tag;
                    if (z4) {
                        z3 = z4;
                        str5 = availInfo != null ? "!" : "";
                    } else {
                        z3 = z4;
                        str5 = "~";
                    }
                    AdBreakTrackingEvent[] adBreakTrackingEventArr2 = adBreakTrackingEvents;
                    logger.d(str15 + "Avail " + str5 + str13 + str11 + avail3.getDuration() + " @ " + avail3.getStartTime() + " / " + avail3.getAvailProgramDateTime() + ")");
                    if (z3) {
                        HashMap map3 = new HashMap();
                        HashMap<String, AdInfo> ads2 = availInfo != null ? availInfo.getAds() : null;
                        if (ads != null) {
                            int length3 = ads.length;
                            int length4 = ads.length;
                            int i10 = 0;
                            while (i10 < length4) {
                                AdTrackingResponse.Ad ad2 = ads[i10];
                                String adId = ad2.getAdId();
                                String str16 = adId;
                                if (str16 == null || StringsKt.isBlank(str16)) {
                                    adArr = ads;
                                    map = map3;
                                    map2 = ads2;
                                    length3 = length3;
                                    i5 = length4;
                                    d4 = dIsoDateTimeStringToEpochSeconds;
                                    str6 = str11;
                                    i6 = i10;
                                    str7 = str14;
                                    adBreakTrackingEventArr = adBreakTrackingEventArr2;
                                    str8 = str13;
                                    Logger_androidKt.getLogger().w(this.tag + "Missing ad ID");
                                } else {
                                    adArr = ads;
                                    Double startTimeInSeconds2 = ad2.getStartTimeInSeconds();
                                    if (startTimeInSeconds2 == null) {
                                        str9 = str13;
                                        Logger_androidKt.getLogger().w(this.tag + "Missing ad start time");
                                        map = map3;
                                        map2 = ads2;
                                        i5 = length4;
                                        d4 = dIsoDateTimeStringToEpochSeconds;
                                        str6 = str11;
                                        i6 = i10;
                                        str7 = str14;
                                    } else {
                                        str9 = str13;
                                        i5 = length4;
                                        i6 = i10;
                                        str7 = str14;
                                        d4 = dIsoDateTimeStringToEpochSeconds;
                                        map3.put(adId, new AdInfo(startTimeInSeconds2.doubleValue(), ad2.getDuration()));
                                        AdInfo adInfoRemove = ads2 != null ? ads2.remove(adId) : null;
                                        boolean z5 = (adInfoRemove != null && Intrinsics.areEqual(startTimeInSeconds2, adInfoRemove.getStart()) && Intrinsics.areEqual(ad2.getDuration(), adInfoRemove.getDuration())) ? false : z2;
                                        Logger logger2 = Logger_androidKt.getLogger();
                                        String str17 = this.tag;
                                        if (z5) {
                                            str10 = adInfoRemove != null ? "!" : str7;
                                        } else {
                                            str10 = "~";
                                        }
                                        AdInfo adInfo = adInfoRemove;
                                        map2 = ads2;
                                        boolean z6 = z5;
                                        str6 = str11;
                                        map = map3;
                                        logger2.d(str17 + "Ad " + str10 + adId + " (#" + (i6 + 1) + " of " + length3 + ") (" + ad2.getDuration() + " @ " + ad2.getStartTime() + " / " + ad2.getAdProgramDateTime() + ")");
                                        if (z6) {
                                            if (d7 != null && d8 > 0.0d) {
                                                this.lastAvailStartDateOffset = Double.valueOf(d8 - d7.doubleValue());
                                            }
                                            final int iBinarySearchExact2 = adInfo != null ? BinarySearchKt.binarySearchExact(Double.valueOf(adInfo.getStart()), this.allAds, this.adStartComparator) : -1;
                                            length3 = length3;
                                            final AdData adDataCreateAdData = AdDataKt.createAdData(startTimeInSeconds2.doubleValue(), str9, i6, length3, d7, avail3.getDurationInSeconds(), dIso8601IntervalToSeconds, adBreakTrackingEventArr2, ad2);
                                            str8 = str9;
                                            adBreakTrackingEventArr = adBreakTrackingEventArr2;
                                            if (adDataCreateAdData != null) {
                                                patchAdStartDate(adDataCreateAdData, startTimeInSeconds2.doubleValue());
                                                if (iBinarySearchExact2 >= 0) {
                                                    adDataCreateAdData.setPlayCount$MediaTailor_release(this.allAds.get(iBinarySearchExact2).getPlayCount());
                                                    this.allAds.remove(iBinarySearchExact2);
                                                }
                                                if (!Intrinsics.areEqual(startTimeInSeconds2, adInfo != null ? Double.valueOf(adInfo.getStart()) : null) && (iBinarySearchExact = BinarySearchKt.binarySearchExact(startTimeInSeconds2, this.allAds, this.adStartComparator)) >= 0) {
                                                    this.allAds.remove(iBinarySearchExact);
                                                }
                                                this.allAds.add(adDataCreateAdData);
                                                notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda7
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return SessionTracker.processAdTrackingResponse$lambda$0$1$1(adDataCreateAdData, iBinarySearchExact2, (AdObserver) obj);
                                                    }
                                                });
                                            } else if (iBinarySearchExact2 >= 0) {
                                                this.allAds.remove(iBinarySearchExact2);
                                            }
                                            z = z2;
                                        }
                                    }
                                    str8 = str9;
                                    adBreakTrackingEventArr = adBreakTrackingEventArr2;
                                }
                                i10 = i6 + 1;
                                str13 = str8;
                                adBreakTrackingEventArr2 = adBreakTrackingEventArr;
                                length3 = length3;
                                ads = adArr;
                                length4 = i5;
                                str14 = str7;
                                dIsoDateTimeStringToEpochSeconds = d4;
                                ads2 = map2;
                                str11 = str6;
                                map3 = map;
                            }
                        }
                        HashMap map4 = map3;
                        HashMap<String, AdInfo> map5 = ads2;
                        d3 = dIsoDateTimeStringToEpochSeconds;
                        str3 = str11;
                        String str18 = str13;
                        if (Intrinsics.areEqual(this.config.getDetectAdRemoval(), Boolean.valueOf(z2)) && map5 != null) {
                            Iterator<Map.Entry<String, AdInfo>> it = map5.entrySet().iterator();
                            while (it.hasNext()) {
                                int iBinarySearchExact3 = BinarySearchKt.binarySearchExact(Double.valueOf(it.next().getValue().getStart()), this.allAds, this.adStartComparator);
                                if (iBinarySearchExact3 >= 0) {
                                    this.allAds.remove(iBinarySearchExact3);
                                    z = z2;
                                }
                            }
                        }
                        this.availInfoMap.put(str18, new AvailInfo(str4, map4));
                    } else {
                        d3 = dIsoDateTimeStringToEpochSeconds;
                        str3 = str11;
                    }
                }
                i7 = i3 + 1;
                avails = availArr;
                length = i4;
                dIsoDateTimeStringToEpochSeconds = d3;
                str11 = str3;
            }
            d = dIsoDateTimeStringToEpochSeconds;
            str = str11;
            d2 = 0.0d;
            i = 1;
        }
        if (response != null && (nonLinearAvails = response.getNonLinearAvails()) != null) {
            int length5 = nonLinearAvails.length;
            int i11 = 0;
            while (i11 < length5) {
                AdTrackingResponse.NonLinearAvail nonLinearAvail = nonLinearAvails[i11];
                String availId2 = nonLinearAvail.getAvailId();
                Logger logger3 = Logger_androidKt.getLogger();
                String str19 = this.tag;
                String startTime = nonLinearAvail.getStartTime();
                String availProgramDateTime2 = nonLinearAvail.getAvailProgramDateTime();
                StringBuilder sb = new StringBuilder();
                sb.append(str19);
                sb.append("nonLinearAvail ");
                sb.append(availId2);
                String str20 = str;
                sb.append(str20);
                sb.append(startTime);
                sb.append(" / ");
                sb.append(availProgramDateTime2);
                sb.append(")\n=> ");
                sb.append(nonLinearAvail);
                logger3.d(sb.toString());
                Double startTimeInSeconds3 = nonLinearAvail.getStartTimeInSeconds();
                String availProgramDateTime3 = nonLinearAvail.getAvailProgramDateTime();
                if (availProgramDateTime3 != null && !StringsKt.isBlank(availProgramDateTime3)) {
                    dValueOf = DateTime_androidKt.isoDateTimeStringToEpochSeconds(nonLinearAvail.getAvailProgramDateTime());
                } else {
                    dValueOf = (d == null || startTimeInSeconds3 == null) ? null : Double.valueOf(d.doubleValue() + startTimeInSeconds3.doubleValue());
                }
                if (processNonLinearAdsList(null, nonLinearAvail, availId2, startTimeInSeconds3, dValueOf != null ? dValueOf.doubleValue() : d2, nonLinearAvail.getAdBreakTrackingEvents())) {
                    i2 = i;
                }
                i11++;
                str = str20;
            }
        }
        if (z) {
            ArrayList<AdData> arrayList = this.allAds;
            if (arrayList.size() > i) {
                CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.amazon.mediatailorsdk.SessionTracker$processAdTrackingResponse$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Double.valueOf(((AdData) t).getStart()), Double.valueOf(((AdData) t2).getStart()));
                    }
                });
            }
            this.checkedTimeRangeBegin = null;
            this.checkedTimeRangeEnd = null;
            this.checkedTimeRangeAnchorAd = null;
        }
        if (i2 != 0) {
            ArrayList<NonLinearAdsData> arrayList2 = this.nonLinearAdsOnTimeline;
            if (arrayList2.size() > 1) {
                CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: com.amazon.mediatailorsdk.SessionTracker$processAdTrackingResponse$$inlined$sortBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Double.valueOf(((NonLinearAdsData) t).getStart()), Double.valueOf(((NonLinearAdsData) t2).getStart()));
                    }
                });
            }
            str2 = null;
            this.nlCheckedTimeRangeBegin = null;
            this.nlCheckedTimeRangeEnd = null;
            this.nlCheckedTimeRangeAnchorAd = null;
        } else {
            str2 = null;
        }
        String nextToken = response != null ? response.getNextToken() : str2;
        this.lastTrackingRequestNextToken = nextToken;
        String str21 = nextToken;
        if (str21 == null || StringsKt.isBlank(str21)) {
            return;
        }
        Logger_androidKt.getLogger().d(this.tag + "nextToken \"" + this.lastTrackingRequestNextToken + "\"");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processAdTrackingResponse$lambda$0$1$1(AdData adData, int i, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        notifyToAdObservers.onNewAd(adData, i >= 0);
        return Unit.INSTANCE;
    }

    private final void requestAdTrackingInfoImp(double playhead, Double programDateTime) {
        String str = this.trackingUrl;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        Job job = this.trackingRequest;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.trackingRequest = BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05731(programDateTime, playhead, null), 3, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$requestAdTrackingInfoImp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker$requestAdTrackingInfoImp$1", f = "SessionTracker.kt", i = {0, 0, 0, 1, 2, 2, 2, 2}, l = {1024, 576, 1035}, m = "invokeSuspend", n = {"params", "$this$withLock_u24default$iv", "$i$f$withLock", "params", "params", "result", "$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {InputDeviceCompat.SOURCE_GAMEPAD, 577, 1036}, s = {"L$0", "L$1", "I$0", "L$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C05731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $playhead;
        final /* synthetic */ Double $programDateTime;
        double D$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05731(Double d, double d2, Continuation<? super C05731> continuation) {
            super(2, continuation);
            this.$programDateTime = d;
            this.$playhead = d2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionTracker.this.new C05731(this.$programDateTime, this.$playhead, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x014e  */
        /* JADX WARN: Code duplicated, block: B:46:0x0157 A[Catch: all -> 0x019f, TryCatch #1 {all -> 0x019f, blocks: (B:44:0x0151, B:46:0x0157, B:48:0x0194, B:47:0x0169), top: B:59:0x0151 }] */
        /* JADX WARN: Code duplicated, block: B:47:0x0169 A[Catch: all -> 0x019f, TryCatch #1 {all -> 0x019f, blocks: (B:44:0x0151, B:46:0x0157, B:48:0x0194, B:47:0x0169), top: B:59:0x0151 }] */
        /* JADX WARN: Instruction removed from duplicated block: B:47:0x0169, please report this as an issue */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            HashMap<String, Object> map;
            Mutex mutex;
            Double d;
            double dDoubleValue;
            SessionTracker sessionTracker;
            Object objInvoke;
            String str;
            Resource resource;
            Mutex mutex2;
            SessionTracker sessionTracker2;
            Resource resource2;
            Mutex mutex3;
            SessionTracker sessionTracker3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    map = new HashMap<>();
                    mutex = SessionTracker.this.mutex;
                    SessionTracker sessionTracker4 = SessionTracker.this;
                    d = this.$programDateTime;
                    dDoubleValue = this.$playhead;
                    this.L$0 = map;
                    this.L$1 = mutex;
                    this.L$2 = sessionTracker4;
                    this.L$3 = d;
                    this.D$0 = dDoubleValue;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        sessionTracker = sessionTracker4;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    double d2 = this.D$0;
                    Double d3 = (Double) this.L$3;
                    sessionTracker = (SessionTracker) this.L$2;
                    mutex = (Mutex) this.L$1;
                    HashMap<String, Object> map2 = (HashMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    d = d3;
                    map = map2;
                    dDoubleValue = d2;
                } else {
                    if (i == 2) {
                        map = (HashMap) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objInvoke = obj;
                        resource = (Resource) objInvoke;
                        mutex2 = SessionTracker.this.mutex;
                        sessionTracker2 = SessionTracker.this;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(map);
                        this.L$1 = resource;
                        this.L$2 = mutex2;
                        this.L$3 = sessionTracker2;
                        this.I$0 = 0;
                        this.label = 3;
                        if (mutex2.lock(null, this) != coroutine_suspended) {
                            resource2 = resource;
                            mutex3 = mutex2;
                            sessionTracker3 = sessionTracker2;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sessionTracker3 = (SessionTracker) this.L$3;
                    mutex3 = (Mutex) this.L$2;
                    resource2 = (Resource) this.L$1;
                    ResultKt.throwOnFailure(obj);
                }
                try {
                    if (resource2.isSuccess()) {
                        sessionTracker3.processAdTrackingResponse((AdTrackingResponse) resource2.getData());
                        sessionTracker3.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$requestAdTrackingInfoImp$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return SessionTracker.C05731.invokeSuspend$lambda$1$0((AdObserver) obj2);
                            }
                        });
                    } else {
                        Logger_androidKt.getLogger().w(sessionTracker3.tag + "Request failed, status " + resource2.getStatus());
                        sessionTracker3.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$requestAdTrackingInfoImp$1$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return SessionTracker.C05731.invokeSuspend$lambda$1$1((AdObserver) obj2);
                            }
                        });
                    }
                    sessionTracker3.trackingRequest = null;
                    Unit unit = Unit.INSTANCE;
                    return Unit.INSTANCE;
                } finally {
                    mutex3.unlock(null);
                }
                if (sessionTracker.playheadAwareTracking) {
                    HashMap<String, Object> map3 = map;
                    if (d != null && sessionTracker.lastAvailStartDateOffset != null && Math.abs(d.doubleValue()) <= Double.MAX_VALUE) {
                        Double d4 = sessionTracker.lastAvailStartDateOffset;
                        Intrinsics.checkNotNull(d4);
                        if (Math.abs(d4.doubleValue()) <= Double.MAX_VALUE) {
                            double dDoubleValue2 = d.doubleValue();
                            Double d5 = sessionTracker.lastAvailStartDateOffset;
                            Intrinsics.checkNotNull(d5);
                            dDoubleValue = dDoubleValue2 - d5.doubleValue();
                        }
                    }
                    map3.put("aws.playheadPositionInSeconds", Boxing.boxInt((int) Math.rint(dDoubleValue)));
                }
                if (sessionTracker.paginatedTracking && (str = sessionTracker.lastTrackingRequestNextToken) != null && !StringsKt.isBlank(str)) {
                    String str2 = sessionTracker.lastTrackingRequestNextToken;
                    Intrinsics.checkNotNull(str2);
                    map.put("aws.nextToken", str2);
                }
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock(null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(map);
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                objInvoke = new AdTrackingUseCase(MediaTailorKt.getNetwork()).invoke(SessionTracker.this.trackingUrl, map, this);
                if (objInvoke != coroutine_suspended) {
                    resource = (Resource) objInvoke;
                    mutex2 = SessionTracker.this.mutex;
                    sessionTracker2 = SessionTracker.this;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(map);
                    this.L$1 = resource;
                    this.L$2 = mutex2;
                    this.L$3 = sessionTracker2;
                    this.I$0 = 0;
                    this.label = 3;
                    if (mutex2.lock(null, this) != coroutine_suspended) {
                        resource2 = resource;
                        mutex3 = mutex2;
                        sessionTracker3 = sessionTracker2;
                        if (resource2.isSuccess()) {
                            sessionTracker3.processAdTrackingResponse((AdTrackingResponse) resource2.getData());
                            sessionTracker3.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$requestAdTrackingInfoImp$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return SessionTracker.C05731.invokeSuspend$lambda$1$0((AdObserver) obj2);
                                }
                            });
                        } else {
                            Logger_androidKt.getLogger().w(sessionTracker3.tag + "Request failed, status " + resource2.getStatus());
                            sessionTracker3.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$requestAdTrackingInfoImp$1$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return SessionTracker.C05731.invokeSuspend$lambda$1$1((AdObserver) obj2);
                                }
                            });
                        }
                        sessionTracker3.trackingRequest = null;
                        Unit unit3 = Unit.INSTANCE;
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1$0(AdObserver adObserver) {
            adObserver.onTrackingInfoResponse(false);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1$1(AdObserver adObserver) {
            adObserver.onTrackingInfoResponse(true);
            return Unit.INSTANCE;
        }
    }

    private final <T> Triple<T, Double, Double> reevaluateAnchorAd(String adType, ArrayList<T> adsList, double pos, boolean useProgramDateTime, Function2<? super Double, ? super T, Double> startComparator, Function2<? super Double, ? super T, Double> startDateComparator, Function1<? super T, Double> startTimeGetter) {
        Double dValueOf;
        Double dInvoke;
        T t;
        Double dValueOf2 = Double.valueOf(pos);
        if (useProgramDateTime) {
            startComparator = startDateComparator;
        }
        int iBinarySearchExactOrRightBelow = BinarySearchKt.binarySearchExactOrRightBelow(dValueOf2, adsList, startComparator);
        if (iBinarySearchExactOrRightBelow >= 0) {
            t = adsList.get(iBinarySearchExactOrRightBelow);
            dValueOf = startTimeGetter.invoke(t);
            int i = iBinarySearchExactOrRightBelow + 1;
            dInvoke = i < adsList.size() ? startTimeGetter.invoke(adsList.get(i)) : Double.valueOf(Double.MAX_VALUE);
        } else {
            dValueOf = Double.valueOf(Double.MIN_VALUE);
            dInvoke = !adsList.isEmpty() ? startTimeGetter.invoke(adsList.get(0)) : Double.valueOf(Double.MAX_VALUE);
            t = null;
        }
        Logger_androidKt.getLogger().d(this.tag + "Update time range (" + dValueOf + " - " + dInvoke + "), " + adType + " ad index " + iBinarySearchExactOrRightBelow + "\n=> " + t);
        return new Triple<>(t, dValueOf, dInvoke);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x025a  */
    /* JADX WARN: Code duplicated, block: B:106:0x026a  */
    /* JADX WARN: Code duplicated, block: B:108:0x0328  */
    /* JADX WARN: Code duplicated, block: B:111:0x032d  */
    /* JADX WARN: Code duplicated, block: B:113:0x033d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0363  */
    /* JADX WARN: Code duplicated, block: B:118:0x036e  */
    /* JADX WARN: Code duplicated, block: B:121:0x037c  */
    /* JADX WARN: Code duplicated, block: B:122:0x037f  */
    /* JADX WARN: Code duplicated, block: B:125:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:127:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:128:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:131:0x03d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:135:0x03ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x0401  */
    /* JADX WARN: Code duplicated, block: B:138:0x046d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0048  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:64:0x015c  */
    /* JADX WARN: Code duplicated, block: B:65:0x0161  */
    /* JADX WARN: Code duplicated, block: B:67:0x0164  */
    /* JADX WARN: Code duplicated, block: B:68:0x0169  */
    /* JADX WARN: Code duplicated, block: B:71:0x0173  */
    /* JADX WARN: Code duplicated, block: B:73:0x0177  */
    /* JADX WARN: Code duplicated, block: B:75:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:81:0x01db  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:90:0x0205  */
    /* JADX WARN: Code duplicated, block: B:92:0x0209  */
    /* JADX WARN: Code duplicated, block: B:94:0x020f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0216  */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x026a, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:132:0x03d9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:136:0x0401, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x0177, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    private final void onPlayheadUpdateImp(final double playhead, Double programDateTime) {
        final SessionTracker sessionTracker;
        String str;
        double d;
        AdData adData;
        AdData adData2;
        String adId;
        String adId2;
        Double d2;
        Double[] quartileEventOffsets;
        double dDoubleValue;
        Double d3;
        boolean z;
        double d4;
        final NonLinearAdsData nonLinearAdsData;
        final double dDoubleValue2;
        NonLinearAdsData nonLinearAdsData2;
        double dDoubleValue3;
        NonLinearAdsData nonLinearAdsData3;
        Double d5;
        double dDoubleValue4;
        double dDoubleValue5;
        double d6;
        double d7;
        Double d8;
        double d9;
        int i;
        Double[] quartileEventOffsets2;
        double dDoubleValue6;
        Double d10 = this.lastPlayheadPos;
        if (d10 != null) {
            Intrinsics.checkNotNull(d10);
            if (playhead > d10.doubleValue()) {
                Double d11 = this.lastPlayheadPos;
                Intrinsics.checkNotNull(d11);
                if (playhead < d11.doubleValue() + 2.5d) {
                    if (this.trackingRequestInterval >= 0.0d && this.trackingRequest == null) {
                        Double d12 = this.lastTrackingRequestPos;
                        if (d12 != null) {
                            Intrinsics.checkNotNull(d12);
                            if (Math.abs(playhead - d12.doubleValue()) >= this.trackingRequestInterval) {
                                requestAdTrackingInfoImp(playhead, programDateTime);
                                this.lastTrackingRequestPos = Double.valueOf(playhead);
                            }
                        } else {
                            requestAdTrackingInfoImp(playhead, programDateTime);
                            this.lastTrackingRequestPos = Double.valueOf(playhead);
                        }
                    }
                    Double d13 = this.adHasStartDate ? programDateTime : null;
                    boolean z2 = (d13 == null || Intrinsics.areEqual(d13, 0.0d)) ? false : true;
                    double dDoubleValue7 = z2 ? d13.doubleValue() : playhead;
                    Function1 function1 = z2 ? new MutablePropertyReference1Impl() { // from class: com.amazon.mediatailorsdk.SessionTracker$onPlayheadUpdateImp$adStartGetter$1
                        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return Double.valueOf(((AdData) obj).getStartDate());
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                        public void set(Object obj, Object obj2) {
                            ((AdData) obj).setStartDate$MediaTailor_release(((Number) obj2).doubleValue());
                        }
                    } : new PropertyReference1Impl() { // from class: com.amazon.mediatailorsdk.SessionTracker$onPlayheadUpdateImp$adStartGetter$2
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return Double.valueOf(((AdData) obj).getStart());
                        }
                    };
                    Function1 function2 = z2 ? new MutablePropertyReference1Impl() { // from class: com.amazon.mediatailorsdk.SessionTracker$onPlayheadUpdateImp$nonlinearAdsStartGetter$1
                        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return Double.valueOf(((NonLinearAdsData) obj).getStartDate());
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                        public void set(Object obj, Object obj2) {
                            ((NonLinearAdsData) obj).setStartDate$MediaTailor_release(((Number) obj2).doubleValue());
                        }
                    } : new PropertyReference1Impl() { // from class: com.amazon.mediatailorsdk.SessionTracker$onPlayheadUpdateImp$nonlinearAdsStartGetter$2
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return Double.valueOf(((NonLinearAdsData) obj).getStart());
                        }
                    };
                    Logger_androidKt.getLogger().v(this.tag + "onPlayheadUpdate(" + playhead + ", " + programDateTime + "), adHasStartDate => " + this.adHasStartDate + ", pdt => " + d13);
                    if (dDoubleValue7 >= this.continuousPbRangeBegin) {
                        double d14 = this.continuousPbRangeEnd;
                        if (dDoubleValue7 > d14 + 2.5d) {
                            this.continuousPbRangeBegin = dDoubleValue7;
                            this.continuousPbRangeEnd = dDoubleValue7;
                        } else if (dDoubleValue7 > d14) {
                            this.continuousPbRangeEnd = dDoubleValue7;
                        }
                    } else {
                        this.continuousPbRangeBegin = dDoubleValue7;
                        this.continuousPbRangeEnd = dDoubleValue7;
                    }
                    Double d15 = this.checkedTimeRangeBegin;
                    if (d15 != null) {
                        Intrinsics.checkNotNull(d15);
                        if (dDoubleValue7 >= d15.doubleValue()) {
                            Double d16 = this.checkedTimeRangeEnd;
                            Intrinsics.checkNotNull(d16);
                            if (dDoubleValue7 >= d16.doubleValue()) {
                                str = null;
                                sessionTracker = this;
                                Triple tripleReevaluateAnchorAd = sessionTracker.reevaluateAnchorAd("linear", this.allAds, dDoubleValue7, z2, this.adStartComparator, this.adStartDateComparator, function1);
                                sessionTracker.checkedTimeRangeAnchorAd = (AdData) tripleReevaluateAnchorAd.getFirst();
                                sessionTracker.checkedTimeRangeBegin = (Double) tripleReevaluateAnchorAd.getSecond();
                                sessionTracker.checkedTimeRangeEnd = (Double) tripleReevaluateAnchorAd.getThird();
                            } else {
                                sessionTracker = this;
                                str = null;
                            }
                        } else {
                            str = null;
                            sessionTracker = this;
                            Triple tripleReevaluateAnchorAd2 = sessionTracker.reevaluateAnchorAd("linear", this.allAds, dDoubleValue7, z2, this.adStartComparator, this.adStartDateComparator, function1);
                            sessionTracker.checkedTimeRangeAnchorAd = (AdData) tripleReevaluateAnchorAd2.getFirst();
                            sessionTracker.checkedTimeRangeBegin = (Double) tripleReevaluateAnchorAd2.getSecond();
                            sessionTracker.checkedTimeRangeEnd = (Double) tripleReevaluateAnchorAd2.getThird();
                        }
                    } else {
                        str = null;
                        sessionTracker = this;
                        Triple tripleReevaluateAnchorAd3 = sessionTracker.reevaluateAnchorAd("linear", this.allAds, dDoubleValue7, z2, this.adStartComparator, this.adStartDateComparator, function1);
                        sessionTracker.checkedTimeRangeAnchorAd = (AdData) tripleReevaluateAnchorAd3.getFirst();
                        sessionTracker.checkedTimeRangeBegin = (Double) tripleReevaluateAnchorAd3.getSecond();
                        sessionTracker.checkedTimeRangeEnd = (Double) tripleReevaluateAnchorAd3.getThird();
                    }
                    final AdData adData3 = sessionTracker.currentAd;
                    Double d17 = sessionTracker.checkedTimeRangeBegin;
                    Intrinsics.checkNotNull(d17);
                    final double dDoubleValue8 = dDoubleValue7 - d17.doubleValue();
                    if (sessionTracker.checkedTimeRangeAnchorAd != null) {
                        Double d18 = sessionTracker.checkedTimeRangeBegin;
                        Intrinsics.checkNotNull(d18);
                        double dDoubleValue9 = d18.doubleValue();
                        d = 0.0d;
                        AdData adData4 = sessionTracker.checkedTimeRangeAnchorAd;
                        Intrinsics.checkNotNull(adData4);
                        if (dDoubleValue7 < dDoubleValue9 + adData4.getDuration()) {
                            adData = sessionTracker.checkedTimeRangeAnchorAd;
                        }
                        sessionTracker.currentAd = adData;
                        adData2 = sessionTracker.currentAd;
                        if (adData2 != null) {
                            adId = adData2.getAdId();
                        } else {
                            adId = str;
                        }
                        if (adData3 != null) {
                            adId2 = adData3.getAdId();
                        } else {
                            adId2 = str;
                        }
                        if (Intrinsics.areEqual(adId, adId2)) {
                            if (sessionTracker.currentAd != null) {
                                Logger_androidKt.getLogger().d(sessionTracker.tag + "Ad progresses, time => " + dDoubleValue8);
                                sessionTracker = this;
                                sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SessionTracker.onPlayheadUpdateImp$lambda$1(this.f$0, dDoubleValue8, playhead, (AdObserver) obj);
                                    }
                                });
                                double d19 = sessionTracker.continuousPbRangeEnd;
                                Double d20 = sessionTracker.checkedTimeRangeBegin;
                                Intrinsics.checkNotNull(d20);
                                dDoubleValue5 = d19 - d20.doubleValue();
                                d6 = sessionTracker.continuousPbRangeBegin;
                                d7 = sessionTracker.currAdContPbRangeEnd;
                                d8 = sessionTracker.checkedTimeRangeBegin;
                                Intrinsics.checkNotNull(d8);
                                if (d6 <= d7 + d8.doubleValue()) {
                                    d9 = sessionTracker.currAdContPbRangeEnd;
                                    if (dDoubleValue5 > d9) {
                                        sessionTracker.currAdContPbRangeEnd = dDoubleValue5;
                                        i = 0;
                                        while (i < 3) {
                                            AdData adData5 = sessionTracker.currentAd;
                                            Intrinsics.checkNotNull(adData5);
                                            quartileEventOffsets2 = adData5.getQuartileEventOffsets();
                                            if (quartileEventOffsets2 != null) {
                                                dDoubleValue6 = quartileEventOffsets2[i].doubleValue();
                                            } else {
                                                dDoubleValue6 = d;
                                            }
                                            Double d21 = d13;
                                            if (d9 >= dDoubleValue6 && sessionTracker.currAdContPbRangeEnd >= dDoubleValue6) {
                                                notifyAdTrackingEvent$default(sessionTracker, SessionTrackerKt.adTrackingQuartileEvents[i], null, 2, null);
                                            }
                                            i++;
                                            d13 = d21;
                                            str = null;
                                        }
                                    }
                                }
                            }
                            d2 = d13;
                        } else {
                            d2 = d13;
                            if (adData3 != null) {
                                quartileEventOffsets = adData3.getQuartileEventOffsets();
                                if (quartileEventOffsets != null) {
                                    dDoubleValue = quartileEventOffsets[3].doubleValue();
                                } else {
                                    dDoubleValue = d;
                                }
                                if (dDoubleValue > d && sessionTracker.currAdContPbRangeEnd + 2.5d > dDoubleValue) {
                                    sessionTracker.notifyAdTrackingEvent(AdTrackingEvent.COMPLETE, adData3);
                                }
                                Logger_androidKt.getLogger().d(sessionTracker.tag + "Ad ends, ad-id " + adData3.getAdId());
                                sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SessionTracker.onPlayheadUpdateImp$lambda$2(adData3, (AdObserver) obj);
                                    }
                                });
                            }
                            sessionTracker.currAdContPbRangeEnd = d;
                            if (sessionTracker.currentAd != null) {
                                AdData adData6 = sessionTracker.currentAd;
                                Intrinsics.checkNotNull(adData6);
                                adData6.setPlayCount$MediaTailor_release(adData6.getPlayCount() + 1);
                                if (z2 != 0) {
                                    Logger logger = Logger_androidKt.getLogger();
                                    String str2 = sessionTracker.tag;
                                    double dDoubleValue10 = d2.doubleValue() - playhead;
                                    AdData adData7 = sessionTracker.currentAd;
                                    Intrinsics.checkNotNull(adData7);
                                    double startDate = adData7.getStartDate();
                                    AdData adData8 = sessionTracker.currentAd;
                                    Intrinsics.checkNotNull(adData8);
                                    logger.d(str2 + "PDT offset => player " + dDoubleValue10 + ", ad " + (startDate - adData8.getStart()));
                                }
                                Logger logger2 = Logger_androidKt.getLogger();
                                String str3 = sessionTracker.tag;
                                AdData adData9 = sessionTracker.currentAd;
                                Intrinsics.checkNotNull(adData9);
                                logger2.d(str3 + "Ad loads, ad-id " + adData9.getAdId());
                                sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SessionTracker.onPlayheadUpdateImp$lambda$3(this.f$0, (AdObserver) obj);
                                    }
                                });
                                notifyAdTrackingEvent$default(sessionTracker, AdTrackingEvent.LOADED, null, 2, null);
                                Logger logger3 = Logger_androidKt.getLogger();
                                String str4 = sessionTracker.tag;
                                AdData adData10 = sessionTracker.currentAd;
                                Intrinsics.checkNotNull(adData10);
                                logger3.d(str4 + "Ad starts, time => " + dDoubleValue8 + ", ad-id " + adData10.getAdId());
                                sessionTracker = this;
                                sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SessionTracker.onPlayheadUpdateImp$lambda$4(this.f$0, dDoubleValue8, playhead, (AdObserver) obj);
                                    }
                                });
                                str = null;
                                notifyAdTrackingEvent$default(sessionTracker, AdTrackingEvent.START, null, 2, null);
                                notifyAdTrackingEvent$default(sessionTracker, AdTrackingEvent.IMPRESSION, null, 2, null);
                            } else {
                                str = null;
                            }
                        }
                        if (sessionTracker.currentAd == null) {
                            Double d22 = sessionTracker.checkedTimeRangeEnd;
                            Intrinsics.checkNotNull(d22);
                            dDoubleValue4 = d22.doubleValue() - dDoubleValue7;
                            if (dDoubleValue4 <= sessionTracker.incomingAdCountdownInterval) {
                                sessionTracker.sessionUiEventManager.dispatchEvent(SessionUiEvent.AD_INCOMING, new SessionUiEventData(null, null, null, null, null, Double.valueOf(dDoubleValue4), null, 95, null));
                            }
                        }
                        d3 = sessionTracker.nlCheckedTimeRangeBegin;
                        if (d3 != null) {
                            Intrinsics.checkNotNull(d3);
                            if (dDoubleValue7 >= d3.doubleValue()) {
                                d5 = sessionTracker.nlCheckedTimeRangeEnd;
                                Intrinsics.checkNotNull(d5);
                                if (dDoubleValue7 >= d5.doubleValue()) {
                                    z = z2;
                                    d4 = dDoubleValue7;
                                    Triple tripleReevaluateAnchorAd4 = sessionTracker.reevaluateAnchorAd("nonlinear", sessionTracker.nonLinearAdsOnTimeline, d4, z, sessionTracker.nonlinearAdsStartComparator, sessionTracker.nonlinearAdsStartDateComparator, function2);
                                    sessionTracker.nlCheckedTimeRangeAnchorAd = (NonLinearAdsData) tripleReevaluateAnchorAd4.getFirst();
                                    sessionTracker.nlCheckedTimeRangeBegin = (Double) tripleReevaluateAnchorAd4.getSecond();
                                    sessionTracker.nlCheckedTimeRangeEnd = (Double) tripleReevaluateAnchorAd4.getThird();
                                } else {
                                    z = z2;
                                    d4 = dDoubleValue7;
                                }
                            } else {
                                z = z2;
                                d4 = dDoubleValue7;
                                Triple tripleReevaluateAnchorAd5 = sessionTracker.reevaluateAnchorAd("nonlinear", sessionTracker.nonLinearAdsOnTimeline, d4, z, sessionTracker.nonlinearAdsStartComparator, sessionTracker.nonlinearAdsStartDateComparator, function2);
                                sessionTracker.nlCheckedTimeRangeAnchorAd = (NonLinearAdsData) tripleReevaluateAnchorAd5.getFirst();
                                sessionTracker.nlCheckedTimeRangeBegin = (Double) tripleReevaluateAnchorAd5.getSecond();
                                sessionTracker.nlCheckedTimeRangeEnd = (Double) tripleReevaluateAnchorAd5.getThird();
                            }
                        } else {
                            z = z2;
                            d4 = dDoubleValue7;
                            Triple tripleReevaluateAnchorAd6 = sessionTracker.reevaluateAnchorAd("nonlinear", sessionTracker.nonLinearAdsOnTimeline, d4, z, sessionTracker.nonlinearAdsStartComparator, sessionTracker.nonlinearAdsStartDateComparator, function2);
                            sessionTracker.nlCheckedTimeRangeAnchorAd = (NonLinearAdsData) tripleReevaluateAnchorAd6.getFirst();
                            sessionTracker.nlCheckedTimeRangeBegin = (Double) tripleReevaluateAnchorAd6.getSecond();
                            sessionTracker.nlCheckedTimeRangeEnd = (Double) tripleReevaluateAnchorAd6.getThird();
                        }
                        nonLinearAdsData = sessionTracker.nlCurrentAd;
                        Double d23 = sessionTracker.nlCheckedTimeRangeBegin;
                        Intrinsics.checkNotNull(d23);
                        dDoubleValue2 = d4 - d23.doubleValue();
                        if (sessionTracker.nlCheckedTimeRangeAnchorAd != null) {
                            Double d24 = sessionTracker.nlCheckedTimeRangeBegin;
                            Intrinsics.checkNotNull(d24);
                            dDoubleValue3 = d24.doubleValue();
                            nonLinearAdsData3 = sessionTracker.nlCheckedTimeRangeAnchorAd;
                            Intrinsics.checkNotNull(nonLinearAdsData3);
                            if (d4 < dDoubleValue3 + nonLinearAdsData3.getDuration()) {
                                nonLinearAdsData2 = sessionTracker.nlCheckedTimeRangeAnchorAd;
                            } else {
                                nonLinearAdsData2 = str;
                            }
                        } else {
                            nonLinearAdsData2 = str;
                        }
                        sessionTracker.nlCurrentAd = nonLinearAdsData2;
                        if (nonLinearAdsData2 != nonLinearAdsData) {
                            if (nonLinearAdsData != null) {
                                Logger_androidKt.getLogger().d(sessionTracker.tag + "Nonlinear Ad ends");
                                sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SessionTracker.onPlayheadUpdateImp$lambda$6(nonLinearAdsData, (AdObserver) obj);
                                    }
                                });
                            }
                            if (sessionTracker.nlCurrentAd != null) {
                                if (z) {
                                    Logger logger4 = Logger_androidKt.getLogger();
                                    String str5 = sessionTracker.tag;
                                    double dDoubleValue11 = d2.doubleValue() - playhead;
                                    NonLinearAdsData nonLinearAdsData4 = sessionTracker.nlCurrentAd;
                                    Intrinsics.checkNotNull(nonLinearAdsData4);
                                    double startDate2 = nonLinearAdsData4.getStartDate();
                                    NonLinearAdsData nonLinearAdsData5 = sessionTracker.nlCurrentAd;
                                    Intrinsics.checkNotNull(nonLinearAdsData5);
                                    logger4.d(str5 + "PDT offset => player " + dDoubleValue11 + ", nonlinear ad " + (startDate2 - nonLinearAdsData5.getStart()));
                                }
                                Logger_androidKt.getLogger().d(sessionTracker.tag + "Nonlinear ad starts, time => " + dDoubleValue2);
                                sessionTracker = this;
                                sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SessionTracker.onPlayheadUpdateImp$lambda$7(this.f$0, dDoubleValue2, playhead, (AdObserver) obj);
                                    }
                                });
                            }
                        }
                    } else {
                        d = 0.0d;
                    }
                    adData = str;
                    sessionTracker.currentAd = adData;
                    adData2 = sessionTracker.currentAd;
                    if (adData2 != null) {
                        adId = adData2.getAdId();
                    } else {
                        adId = str;
                    }
                    if (adData3 != null) {
                        adId2 = adData3.getAdId();
                    } else {
                        adId2 = str;
                    }
                    if (Intrinsics.areEqual(adId, adId2)) {
                        if (sessionTracker.currentAd != null) {
                            Logger_androidKt.getLogger().d(sessionTracker.tag + "Ad progresses, time => " + dDoubleValue8);
                            sessionTracker = this;
                            sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SessionTracker.onPlayheadUpdateImp$lambda$1(this.f$0, dDoubleValue8, playhead, (AdObserver) obj);
                                }
                            });
                            double d110 = sessionTracker.continuousPbRangeEnd;
                            Double d25 = sessionTracker.checkedTimeRangeBegin;
                            Intrinsics.checkNotNull(d25);
                            dDoubleValue5 = d110 - d25.doubleValue();
                            d6 = sessionTracker.continuousPbRangeBegin;
                            d7 = sessionTracker.currAdContPbRangeEnd;
                            d8 = sessionTracker.checkedTimeRangeBegin;
                            Intrinsics.checkNotNull(d8);
                            if (d6 <= d7 + d8.doubleValue()) {
                                d9 = sessionTracker.currAdContPbRangeEnd;
                                if (dDoubleValue5 > d9) {
                                    sessionTracker.currAdContPbRangeEnd = dDoubleValue5;
                                    i = 0;
                                    while (i < 3) {
                                        AdData adData11 = sessionTracker.currentAd;
                                        Intrinsics.checkNotNull(adData11);
                                        quartileEventOffsets2 = adData11.getQuartileEventOffsets();
                                        if (quartileEventOffsets2 != null) {
                                            dDoubleValue6 = quartileEventOffsets2[i].doubleValue();
                                        } else {
                                            dDoubleValue6 = d;
                                        }
                                        Double d26 = d13;
                                        if (d9 >= dDoubleValue6) {
                                        }
                                        i++;
                                        d13 = d26;
                                        str = null;
                                    }
                                }
                            }
                        }
                        d2 = d13;
                    } else {
                        d2 = d13;
                        if (adData3 != null) {
                            quartileEventOffsets = adData3.getQuartileEventOffsets();
                            if (quartileEventOffsets != null) {
                                dDoubleValue = quartileEventOffsets[3].doubleValue();
                            } else {
                                dDoubleValue = d;
                            }
                            if (dDoubleValue > d) {
                                sessionTracker.notifyAdTrackingEvent(AdTrackingEvent.COMPLETE, adData3);
                            }
                            Logger_androidKt.getLogger().d(sessionTracker.tag + "Ad ends, ad-id " + adData3.getAdId());
                            sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SessionTracker.onPlayheadUpdateImp$lambda$2(adData3, (AdObserver) obj);
                                }
                            });
                        }
                        sessionTracker.currAdContPbRangeEnd = d;
                        if (sessionTracker.currentAd != null) {
                            AdData adData12 = sessionTracker.currentAd;
                            Intrinsics.checkNotNull(adData12);
                            adData12.setPlayCount$MediaTailor_release(adData12.getPlayCount() + 1);
                            if (z2 != 0) {
                                Logger logger5 = Logger_androidKt.getLogger();
                                String str6 = sessionTracker.tag;
                                double dDoubleValue12 = d2.doubleValue() - playhead;
                                AdData adData13 = sessionTracker.currentAd;
                                Intrinsics.checkNotNull(adData13);
                                double startDate3 = adData13.getStartDate();
                                AdData adData14 = sessionTracker.currentAd;
                                Intrinsics.checkNotNull(adData14);
                                logger5.d(str6 + "PDT offset => player " + dDoubleValue12 + ", ad " + (startDate3 - adData14.getStart()));
                            }
                            Logger logger6 = Logger_androidKt.getLogger();
                            String str7 = sessionTracker.tag;
                            AdData adData15 = sessionTracker.currentAd;
                            Intrinsics.checkNotNull(adData15);
                            logger6.d(str7 + "Ad loads, ad-id " + adData15.getAdId());
                            sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SessionTracker.onPlayheadUpdateImp$lambda$3(this.f$0, (AdObserver) obj);
                                }
                            });
                            notifyAdTrackingEvent$default(sessionTracker, AdTrackingEvent.LOADED, null, 2, null);
                            Logger logger7 = Logger_androidKt.getLogger();
                            String str8 = sessionTracker.tag;
                            AdData adData16 = sessionTracker.currentAd;
                            Intrinsics.checkNotNull(adData16);
                            logger7.d(str8 + "Ad starts, time => " + dDoubleValue8 + ", ad-id " + adData16.getAdId());
                            sessionTracker = this;
                            sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SessionTracker.onPlayheadUpdateImp$lambda$4(this.f$0, dDoubleValue8, playhead, (AdObserver) obj);
                                }
                            });
                            str = null;
                            notifyAdTrackingEvent$default(sessionTracker, AdTrackingEvent.START, null, 2, null);
                            notifyAdTrackingEvent$default(sessionTracker, AdTrackingEvent.IMPRESSION, null, 2, null);
                        } else {
                            str = null;
                        }
                    }
                    if (sessionTracker.currentAd == null) {
                        Double d27 = sessionTracker.checkedTimeRangeEnd;
                        Intrinsics.checkNotNull(d27);
                        dDoubleValue4 = d27.doubleValue() - dDoubleValue7;
                        if (dDoubleValue4 <= sessionTracker.incomingAdCountdownInterval) {
                            sessionTracker.sessionUiEventManager.dispatchEvent(SessionUiEvent.AD_INCOMING, new SessionUiEventData(null, null, null, null, null, Double.valueOf(dDoubleValue4), null, 95, null));
                        }
                    }
                    d3 = sessionTracker.nlCheckedTimeRangeBegin;
                    if (d3 != null) {
                        Intrinsics.checkNotNull(d3);
                        if (dDoubleValue7 >= d3.doubleValue()) {
                            d5 = sessionTracker.nlCheckedTimeRangeEnd;
                            Intrinsics.checkNotNull(d5);
                            if (dDoubleValue7 >= d5.doubleValue()) {
                                z = z2;
                                d4 = dDoubleValue7;
                                Triple tripleReevaluateAnchorAd7 = sessionTracker.reevaluateAnchorAd("nonlinear", sessionTracker.nonLinearAdsOnTimeline, d4, z, sessionTracker.nonlinearAdsStartComparator, sessionTracker.nonlinearAdsStartDateComparator, function2);
                                sessionTracker.nlCheckedTimeRangeAnchorAd = (NonLinearAdsData) tripleReevaluateAnchorAd7.getFirst();
                                sessionTracker.nlCheckedTimeRangeBegin = (Double) tripleReevaluateAnchorAd7.getSecond();
                                sessionTracker.nlCheckedTimeRangeEnd = (Double) tripleReevaluateAnchorAd7.getThird();
                            } else {
                                z = z2;
                                d4 = dDoubleValue7;
                            }
                        } else {
                            z = z2;
                            d4 = dDoubleValue7;
                            Triple tripleReevaluateAnchorAd8 = sessionTracker.reevaluateAnchorAd("nonlinear", sessionTracker.nonLinearAdsOnTimeline, d4, z, sessionTracker.nonlinearAdsStartComparator, sessionTracker.nonlinearAdsStartDateComparator, function2);
                            sessionTracker.nlCheckedTimeRangeAnchorAd = (NonLinearAdsData) tripleReevaluateAnchorAd8.getFirst();
                            sessionTracker.nlCheckedTimeRangeBegin = (Double) tripleReevaluateAnchorAd8.getSecond();
                            sessionTracker.nlCheckedTimeRangeEnd = (Double) tripleReevaluateAnchorAd8.getThird();
                        }
                    } else {
                        z = z2;
                        d4 = dDoubleValue7;
                        Triple tripleReevaluateAnchorAd9 = sessionTracker.reevaluateAnchorAd("nonlinear", sessionTracker.nonLinearAdsOnTimeline, d4, z, sessionTracker.nonlinearAdsStartComparator, sessionTracker.nonlinearAdsStartDateComparator, function2);
                        sessionTracker.nlCheckedTimeRangeAnchorAd = (NonLinearAdsData) tripleReevaluateAnchorAd9.getFirst();
                        sessionTracker.nlCheckedTimeRangeBegin = (Double) tripleReevaluateAnchorAd9.getSecond();
                        sessionTracker.nlCheckedTimeRangeEnd = (Double) tripleReevaluateAnchorAd9.getThird();
                    }
                    nonLinearAdsData = sessionTracker.nlCurrentAd;
                    Double d28 = sessionTracker.nlCheckedTimeRangeBegin;
                    Intrinsics.checkNotNull(d28);
                    dDoubleValue2 = d4 - d28.doubleValue();
                    if (sessionTracker.nlCheckedTimeRangeAnchorAd != null) {
                        Double d29 = sessionTracker.nlCheckedTimeRangeBegin;
                        Intrinsics.checkNotNull(d29);
                        dDoubleValue3 = d29.doubleValue();
                        nonLinearAdsData3 = sessionTracker.nlCheckedTimeRangeAnchorAd;
                        Intrinsics.checkNotNull(nonLinearAdsData3);
                        if (d4 < dDoubleValue3 + nonLinearAdsData3.getDuration()) {
                            nonLinearAdsData2 = sessionTracker.nlCheckedTimeRangeAnchorAd;
                        } else {
                            nonLinearAdsData2 = str;
                        }
                    } else {
                        nonLinearAdsData2 = str;
                    }
                    sessionTracker.nlCurrentAd = nonLinearAdsData2;
                    if (nonLinearAdsData2 != nonLinearAdsData) {
                        if (nonLinearAdsData != null) {
                            Logger_androidKt.getLogger().d(sessionTracker.tag + "Nonlinear Ad ends");
                            sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SessionTracker.onPlayheadUpdateImp$lambda$6(nonLinearAdsData, (AdObserver) obj);
                                }
                            });
                        }
                        if (sessionTracker.nlCurrentAd != null) {
                            if (z) {
                                Logger logger8 = Logger_androidKt.getLogger();
                                String str9 = sessionTracker.tag;
                                double dDoubleValue13 = d2.doubleValue() - playhead;
                                NonLinearAdsData nonLinearAdsData6 = sessionTracker.nlCurrentAd;
                                Intrinsics.checkNotNull(nonLinearAdsData6);
                                double startDate4 = nonLinearAdsData6.getStartDate();
                                NonLinearAdsData nonLinearAdsData7 = sessionTracker.nlCurrentAd;
                                Intrinsics.checkNotNull(nonLinearAdsData7);
                                logger8.d(str9 + "PDT offset => player " + dDoubleValue13 + ", nonlinear ad " + (startDate4 - nonLinearAdsData7.getStart()));
                            }
                            Logger_androidKt.getLogger().d(sessionTracker.tag + "Nonlinear ad starts, time => " + dDoubleValue2);
                            sessionTracker = this;
                            sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SessionTracker.onPlayheadUpdateImp$lambda$7(this.f$0, dDoubleValue2, playhead, (AdObserver) obj);
                                }
                            });
                        }
                    }
                } else {
                    sessionTracker = this;
                }
            } else {
                sessionTracker = this;
            }
        } else {
            sessionTracker = this;
        }
        sessionTracker.lastPlayheadPos = Double.valueOf(playhead);
        sessionTracker.lastProgramDateTimePos = programDateTime;
    }

    static final Unit onPlayheadUpdateImp$lambda$1(SessionTracker sessionTracker, double d, double d2, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        AdData adData = sessionTracker.currentAd;
        Intrinsics.checkNotNull(adData);
        notifyToAdObservers.onAdProgress(adData, d, d2);
        return Unit.INSTANCE;
    }

    static final Unit onPlayheadUpdateImp$lambda$2(AdData adData, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        notifyToAdObservers.onAdEnd(adData);
        return Unit.INSTANCE;
    }

    static final Unit onPlayheadUpdateImp$lambda$3(SessionTracker sessionTracker, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        AdData adData = sessionTracker.currentAd;
        Intrinsics.checkNotNull(adData);
        notifyToAdObservers.onAdLoad(adData);
        return Unit.INSTANCE;
    }

    static final Unit onPlayheadUpdateImp$lambda$4(SessionTracker sessionTracker, double d, double d2, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        AdData adData = sessionTracker.currentAd;
        Intrinsics.checkNotNull(adData);
        notifyToAdObservers.onAdStart(adData, d, d2);
        return Unit.INSTANCE;
    }

    static final Unit onPlayheadUpdateImp$lambda$6(NonLinearAdsData nonLinearAdsData, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        notifyToAdObservers.onNonLinearAdsEnd(nonLinearAdsData);
        return Unit.INSTANCE;
    }

    static final Unit onPlayheadUpdateImp$lambda$7(SessionTracker sessionTracker, double d, double d2, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        NonLinearAdsData nonLinearAdsData = sessionTracker.nlCurrentAd;
        Intrinsics.checkNotNull(nonLinearAdsData);
        notifyToAdObservers.onNonLinearAdsStart(nonLinearAdsData, d, d2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object requestAdTrackingInfo$default(SessionTracker sessionTracker, double d, Double d2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            d2 = null;
        }
        return sessionTracker.requestAdTrackingInfo(d, d2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object requestAdTrackingInfo(double d, Double d2, Continuation<? super Unit> continuation) {
        C05721 c05721;
        Mutex mutex;
        if (continuation instanceof C05721) {
            c05721 = (C05721) continuation;
            if ((c05721.label & Integer.MIN_VALUE) != 0) {
                c05721.label -= Integer.MIN_VALUE;
            } else {
                c05721 = new C05721(continuation);
            }
        } else {
            c05721 = new C05721(continuation);
        }
        Object obj = c05721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05721.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c05721.L$0 = d2;
            c05721.L$1 = mutex;
            c05721.D$0 = d;
            c05721.I$0 = 0;
            c05721.label = 1;
            if (mutex.lock(null, c05721) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05721.I$0;
            d = c05721.D$0;
            Mutex mutex2 = (Mutex) c05721.L$1;
            Double d3 = (Double) c05721.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            d2 = d3;
        }
        try {
            requestAdTrackingInfoImp(d, d2);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateAdTrackingInfo(AdTrackingResponse adTrackingResponse, Continuation<? super Unit> continuation) {
        C05761 c05761;
        Mutex mutex;
        if (continuation instanceof C05761) {
            c05761 = (C05761) continuation;
            if ((c05761.label & Integer.MIN_VALUE) != 0) {
                c05761.label -= Integer.MIN_VALUE;
            } else {
                c05761 = new C05761(continuation);
            }
        } else {
            c05761 = new C05761(continuation);
        }
        Object obj = c05761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05761.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c05761.L$0 = adTrackingResponse;
            c05761.L$1 = mutex;
            c05761.I$0 = 0;
            c05761.label = 1;
            if (mutex.lock(null, c05761) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05761.I$0;
            Mutex mutex2 = (Mutex) c05761.L$1;
            AdTrackingResponse adTrackingResponse2 = (AdTrackingResponse) c05761.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            adTrackingResponse = adTrackingResponse2;
        }
        try {
            if (adTrackingResponse == null) {
                Double d = this.lastPlayheadPos;
                requestAdTrackingInfoImp(d != null ? d.doubleValue() : 0.0d, this.lastProgramDateTimePos);
                this.lastTrackingRequestPos = this.lastPlayheadPos;
            } else {
                Job job = this.trackingRequest;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                processAdTrackingResponse(adTrackingResponse);
                notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SessionTracker.updateAdTrackingInfo$lambda$0$0((AdObserver) obj2);
                    }
                });
                this.trackingRequest = null;
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateAdTrackingInfo$lambda$0$0(AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        notifyToAdObservers.onTrackingInfoResponse(false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object startUpdatingAdTrackingInfo(Double d, Continuation<? super Unit> continuation) {
        C05741 c05741;
        Mutex mutex;
        if (continuation instanceof C05741) {
            c05741 = (C05741) continuation;
            if ((c05741.label & Integer.MIN_VALUE) != 0) {
                c05741.label -= Integer.MIN_VALUE;
            } else {
                c05741 = new C05741(continuation);
            }
        } else {
            c05741 = new C05741(continuation);
        }
        Object obj = c05741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05741.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c05741.L$0 = d;
            c05741.L$1 = mutex;
            c05741.I$0 = 0;
            c05741.label = 1;
            if (mutex.lock(null, c05741) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05741.I$0;
            Mutex mutex2 = (Mutex) c05741.L$1;
            Double d2 = (Double) c05741.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            d = d2;
        }
        try {
            String str = this.trackingUrl;
            if (str == null || StringsKt.isBlank(str)) {
                Logger_androidKt.getLogger().w(this.tag + "Missing 'trackingUrl'");
            } else {
                double dDoubleValue = d != null ? d.doubleValue() : 0.0d;
                this.trackingRequestInterval = dDoubleValue;
                if (Math.abs(dDoubleValue) > Double.MAX_VALUE || this.trackingRequestInterval == 0.0d) {
                    this.trackingRequestInterval = 10.0d;
                }
                this.lastTrackingRequestPos = null;
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object stopUpdatingAdTrackingInfo(Continuation<? super Unit> continuation) {
        C05751 c05751;
        Mutex mutex;
        if (continuation instanceof C05751) {
            c05751 = (C05751) continuation;
            if ((c05751.label & Integer.MIN_VALUE) != 0) {
                c05751.label -= Integer.MIN_VALUE;
            } else {
                c05751 = new C05751(continuation);
            }
        } else {
            c05751 = new C05751(continuation);
        }
        Object obj = c05751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05751.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c05751.L$0 = mutex2;
            c05751.I$0 = 0;
            c05751.label = 1;
            if (mutex2.lock(null, c05751) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05751.I$0;
            mutex = (Mutex) c05751.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            this.trackingRequestInterval = -1.0d;
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object onPlayheadUpdate(double d, Double d2, Continuation<? super Unit> continuation) {
        C05691 c05691;
        Mutex mutex;
        if (continuation instanceof C05691) {
            c05691 = (C05691) continuation;
            if ((c05691.label & Integer.MIN_VALUE) != 0) {
                c05691.label -= Integer.MIN_VALUE;
            } else {
                c05691 = new C05691(continuation);
            }
        } else {
            c05691 = new C05691(continuation);
        }
        Object obj = c05691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05691.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c05691.L$0 = d2;
            c05691.L$1 = mutex;
            c05691.D$0 = d;
            c05691.I$0 = 0;
            c05691.label = 1;
            if (mutex.lock(null, c05691) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05691.I$0;
            d = c05691.D$0;
            Mutex mutex2 = (Mutex) c05691.L$1;
            Double d3 = (Double) c05691.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            d2 = d3;
        }
        try {
            onPlayheadUpdateImp(d, d2);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    public final Object onPlaybackRateUpdate(double d, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object onPlaybackEvent(PlaybackEvent playbackEvent, Continuation<? super Unit> continuation) {
        C05681 c05681;
        Mutex mutex;
        PalNonceManagerWrapper palNonceManagerWrapper;
        if (continuation instanceof C05681) {
            c05681 = (C05681) continuation;
            if ((c05681.label & Integer.MIN_VALUE) != 0) {
                c05681.label -= Integer.MIN_VALUE;
            } else {
                c05681 = new C05681(continuation);
            }
        } else {
            c05681 = new C05681(continuation);
        }
        Object obj = c05681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05681.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c05681.L$0 = playbackEvent;
            c05681.L$1 = mutex;
            c05681.I$0 = 0;
            c05681.label = 1;
            if (mutex.lock(null, c05681) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05681.I$0;
            Mutex mutex2 = (Mutex) c05681.L$1;
            PlaybackEvent playbackEvent2 = (PlaybackEvent) c05681.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            playbackEvent = playbackEvent2;
        }
        try {
            int i3 = WhenMappings.$EnumSwitchMapping$0[playbackEvent.ordinal()];
            if (i3 == 1) {
                PalNonceManagerWrapper palNonceManagerWrapper2 = this.palNonceManager;
                if (palNonceManagerWrapper2 != null) {
                    palNonceManagerWrapper2.sendPlaybackStart();
                }
            } else if (i3 == 2 && (palNonceManagerWrapper = this.palNonceManager) != null) {
                palNonceManagerWrapper.sendPlaybackEnd();
            }
            if (this.currentAd != null) {
                switch (WhenMappings.$EnumSwitchMapping$0[playbackEvent.ordinal()]) {
                    case 3:
                        notifyAdTrackingEvent$default(this, AdTrackingEvent.PAUSE, null, 2, null);
                        break;
                    case 4:
                        notifyAdTrackingEvent$default(this, AdTrackingEvent.RESUME, null, 2, null);
                        break;
                    case 5:
                        notifyAdTrackingEvent$default(this, AdTrackingEvent.MUTE, null, 2, null);
                        break;
                    case 6:
                        notifyAdTrackingEvent$default(this, AdTrackingEvent.UNMUTE, null, 2, null);
                        break;
                    case 7:
                        notifyAdTrackingEvent$default(this, AdTrackingEvent.FULLSCREEN, null, 2, null);
                        break;
                    case 8:
                        notifyAdTrackingEvent$default(this, AdTrackingEvent.EXIT_FULLSCREEN, null, 2, null);
                        break;
                }
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object onVideoClick(Continuation<? super Unit> continuation) {
        C05701 c05701;
        Mutex mutex;
        if (continuation instanceof C05701) {
            c05701 = (C05701) continuation;
            if ((c05701.label & Integer.MIN_VALUE) != 0) {
                c05701.label -= Integer.MIN_VALUE;
            } else {
                c05701 = new C05701(continuation);
            }
        } else {
            c05701 = new C05701(continuation);
        }
        Object obj = c05701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05701.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c05701.L$0 = mutex2;
            c05701.I$0 = 0;
            c05701.label = 1;
            if (mutex2.lock(null, c05701) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05701.I$0;
            mutex = (Mutex) c05701.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (this.currentAd != null) {
                notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SessionTracker.onVideoClick$lambda$0$0(this.f$0, (AdObserver) obj2);
                    }
                });
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onVideoClick$lambda$0$0(SessionTracker sessionTracker, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        AdData adData = sessionTracker.currentAd;
        Intrinsics.checkNotNull(adData);
        notifyToAdObservers.onAdClick(adData);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object onAdClickthrough(Continuation<? super Unit> continuation) {
        C05661 c05661;
        Mutex mutex;
        if (continuation instanceof C05661) {
            c05661 = (C05661) continuation;
            if ((c05661.label & Integer.MIN_VALUE) != 0) {
                c05661.label -= Integer.MIN_VALUE;
            } else {
                c05661 = new C05661(continuation);
            }
        } else {
            c05661 = new C05661(continuation);
        }
        Object obj = c05661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05661.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c05661.L$0 = mutex2;
            c05661.I$0 = 0;
            c05661.label = 1;
            if (mutex2.lock(null, c05661) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05661.I$0;
            mutex = (Mutex) c05661.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (this.currentAd != null) {
                PalNonceManagerWrapper palNonceManagerWrapper = this.palNonceManager;
                if (palNonceManagerWrapper != null) {
                    palNonceManagerWrapper.sendAdClick();
                }
                notifyAdTrackingEvent$default(this, AdTrackingEvent.CLICK_THROUGH, null, 2, null);
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object onAdSkip(Continuation<? super Unit> continuation) {
        C05671 c05671;
        Mutex mutex;
        if (continuation instanceof C05671) {
            c05671 = (C05671) continuation;
            if ((c05671.label & Integer.MIN_VALUE) != 0) {
                c05671.label -= Integer.MIN_VALUE;
            } else {
                c05671 = new C05671(continuation);
            }
        } else {
            c05671 = new C05671(continuation);
        }
        Object obj = c05671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05671.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c05671.L$0 = mutex2;
            c05671.I$0 = 0;
            c05671.label = 1;
            if (mutex2.lock(null, c05671) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05671.I$0;
            mutex = (Mutex) c05671.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (this.currentAd != null) {
                notifyAdTrackingEvent$default(this, AdTrackingEvent.SKIP, null, 2, null);
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    public final void addUiEventListener(SessionUiEvent event, Function2<? super SessionUiEvent, ? super SessionUiEventData, Unit> listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sessionUiEventManager.addEventListener(event, listener);
    }

    public final void removeUiEventListener(SessionUiEvent event, Function2<? super SessionUiEvent, ? super SessionUiEventData, Unit> listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sessionUiEventManager.removeEventListener(event, listener);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$addAdObserver$1, reason: invalid class name */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker$addAdObserver$1", f = "SessionTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AdObserver $adObserver;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AdObserver adObserver, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$adObserver = adObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionTracker.this.new AnonymousClass1(this.$adObserver, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (SessionTracker.this.allAdObservers.indexOf(this.$adObserver) < 0) {
                    SessionTracker.this.allAdObservers.add(this.$adObserver);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void addAdObserver(AdObserver adObserver) {
        Intrinsics.checkNotNullParameter(adObserver, "adObserver");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), Dispatchers.getMain(), null, new AnonymousClass1(adObserver, null), 2, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionTracker$removeAdObserver$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionTracker$removeAdObserver$1", f = "SessionTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C05711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AdObserver $adObserver;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05711(AdObserver adObserver, Continuation<? super C05711> continuation) {
            super(2, continuation);
            this.$adObserver = adObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionTracker.this.new C05711(this.$adObserver, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                int iIndexOf = SessionTracker.this.allAdObservers.indexOf(this.$adObserver);
                if (iIndexOf >= 0) {
                    SessionTracker.this.allAdObservers.remove(iIndexOf);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void removeAdObserver(AdObserver adObserver) {
        Intrinsics.checkNotNullParameter(adObserver, "adObserver");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), Dispatchers.getMain(), null, new C05711(adObserver, null), 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAllAds(Continuation<? super List<AdData>> continuation) {
        C05631 c05631;
        Mutex mutex;
        if (continuation instanceof C05631) {
            c05631 = (C05631) continuation;
            if ((c05631.label & Integer.MIN_VALUE) != 0) {
                c05631.label -= Integer.MIN_VALUE;
            } else {
                c05631 = new C05631(continuation);
            }
        } else {
            c05631 = new C05631(continuation);
        }
        Object obj = c05631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05631.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c05631.L$0 = mutex2;
            c05631.I$0 = 0;
            c05631.label = 1;
            if (mutex2.lock(null, c05631) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05631.I$0;
            mutex = (Mutex) c05631.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            return new ArrayList(this.allAds);
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAllNonLinearAds(boolean z, Continuation<? super List<NonLinearAdsData>> continuation) {
        C05641 c05641;
        Mutex mutex;
        if (continuation instanceof C05641) {
            c05641 = (C05641) continuation;
            if ((c05641.label & Integer.MIN_VALUE) != 0) {
                c05641.label -= Integer.MIN_VALUE;
            } else {
                c05641 = new C05641(continuation);
            }
        } else {
            c05641 = new C05641(continuation);
        }
        Object obj = c05641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05641.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c05641.L$0 = mutex2;
            c05641.Z$0 = z;
            c05641.I$0 = 0;
            c05641.label = 1;
            if (mutex2.lock(null, c05641) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c05641.I$0;
            z = c05641.Z$0;
            mutex = (Mutex) c05641.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            return new ArrayList(z ? this.allNonLinearAds.values() : this.nonLinearAdsOnTimeline);
        } finally {
            mutex.unlock(null);
        }
    }

    static final Unit adBeaconManager$lambda$0(SessionTracker sessionTracker, final AdData adData, final AdData.TrackingEvent beaconInfo, final String beaconUrl, final int i) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        Intrinsics.checkNotNullParameter(beaconInfo, "beaconInfo");
        Intrinsics.checkNotNullParameter(beaconUrl, "beaconUrl");
        sessionTracker.notifyToAdObservers(new Function1() { // from class: com.amazon.mediatailorsdk.SessionTracker$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SessionTracker.adBeaconManager$lambda$0$0(adData, beaconInfo, beaconUrl, i, (AdObserver) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adBeaconManager$lambda$0$0(AdData adData, AdData.TrackingEvent trackingEvent, String str, int i, AdObserver notifyToAdObservers) {
        Intrinsics.checkNotNullParameter(notifyToAdObservers, "$this$notifyToAdObservers");
        notifyToAdObservers.onAdBeaconResponse(adData, trackingEvent, str, i);
        return Unit.INSTANCE;
    }
}
