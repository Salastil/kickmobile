package com.amazon.mediatailorsdk;

import com.amazon.mediatailorsdk.logs.Logger_androidKt;
import com.amazon.mediatailorsdk.network.NetworkClient;
import com.amazon.mediatailorsdk.network.Resource;
import com.amazon.mediatailorsdk.network.session.SessionInitUseCase;
import com.amazon.mediatailorsdk.network.session.model.SessionInitRequest;
import com.amazon.mediatailorsdk.network.session.model.SessionInitResponse;
import com.amazon.mediatailorsdk.utils.URL_androidKt;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.google.android.gms.cast.MediaError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: Session.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u009e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000726\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t2:\u0010\u0010\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tH\u0080@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"initSession", "", "config", "Lcom/amazon/mediatailorsdk/SessionConfiguration;", "palNonce", "", "palNonceManager", "Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;", "reportSuccess", "Lkotlin/Function2;", "Lcom/amazon/mediatailorsdk/Session;", "Lkotlin/ParameterName;", "name", "session", "message", "Lkotlinx/coroutines/Job;", "reportError", "", "code", "(Lcom/amazon/mediatailorsdk/SessionConfiguration;Ljava/lang/String;Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SessionKt {

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionKt$initSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionKt", f = "Session.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {324}, m = "initSession", n = {"config", "palNonce", "palNonceManager", "reportSuccess", "reportError", "sessionInitUrl", "playbackUrl", "trackingUrl", InstrumentationTags.TIMEOUT, "maxRetry"}, nl = {MediaError.DetailedErrorCode.DASH_NO_INIT}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionKt.initSession(null, null, null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    public static final Object initSession(SessionConfiguration sessionConfiguration, String str, PalNonceManagerWrapper palNonceManagerWrapper, Function2<? super Session, ? super String, ? extends Job> function2, Function2<? super Integer, ? super String, ? extends Job> function3, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        PalNonceManagerWrapper palNonceManagerWrapper2;
        Function2<? super Session, ? super String, ? extends Job> function4;
        String str2;
        Ref.ObjectRef objectRef;
        String str3;
        String str4 = str;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objCreateSessionTracker = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreateSessionTracker);
            AnonymousClass1 anonymousClass2 = anonymousClass1;
            String sessionInitUrl = sessionConfiguration.getSessionInitUrl();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = sessionConfiguration.getTrackingUrl();
            Long sessionInitTimeout = sessionConfiguration.getSessionInitTimeout();
            long jLongValue = sessionInitTimeout != null ? sessionInitTimeout.longValue() : 30000L;
            UInt sessionInitMaxRetries = sessionConfiguration.getSessionInitMaxRetries();
            int data = sessionInitMaxRetries != null ? sessionInitMaxRetries.getData() : 7;
            String userAgent = sessionConfiguration.getUserAgent();
            if (userAgent != null) {
                NetworkClient.INSTANCE.setUserAgent(userAgent);
            }
            String str5 = sessionInitUrl;
            if (str5 != null && !StringsKt.isBlank(str5)) {
                HashMap map = new HashMap();
                Map<String, String> originParams = sessionConfiguration.getOriginParams();
                if (originParams != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(originParams.size()));
                    Iterator<T> it = originParams.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        linkedHashMap.put(entry.getKey(), JsonElementKt.JsonPrimitive((String) entry.getValue()));
                    }
                    map.putAll(linkedHashMap);
                }
                SessionFeatures sessionFeatures = sessionConfiguration.getSessionFeatures();
                if (sessionFeatures != null) {
                    String overlayAvails = sessionFeatures.getOverlayAvails();
                    if (overlayAvails != null) {
                        map.put("overlayAvails", JsonElementKt.JsonPrimitive(overlayAvails));
                    }
                    Boolean adSignaling = sessionFeatures.getAdSignaling();
                    if (adSignaling != null && adSignaling.booleanValue()) {
                        map.put("adSignaling", new JsonObject(MapsKt.mapOf(TuplesKt.to("enabled", JsonElementKt.JsonPrimitive("true")))));
                    }
                    String reportingMode = sessionFeatures.getReportingMode();
                    if (reportingMode != null) {
                        map.put("reportingMode", JsonElementKt.JsonPrimitive(reportingMode));
                    }
                    Map<String, JsonElement> extra = sessionFeatures.getExtra();
                    if (extra != null) {
                        map.putAll(extra);
                    }
                }
                HashMap map2 = new HashMap();
                String str6 = str4;
                if (str6 != null && !StringsKt.isBlank(str6)) {
                    map2.put("givn", str4);
                }
                Map<String, String> playerParams = sessionConfiguration.getPlayerParams();
                if (playerParams != null) {
                    map2.putAll(playerParams);
                }
                BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new AnonymousClass6(sessionInitUrl, map, map2, sessionConfiguration, jLongValue, data, objectRef2, objectRef3, function3, function2, str4, palNonceManagerWrapper, null), 3, null);
            } else {
                palNonceManagerWrapper2 = palNonceManagerWrapper;
                String str7 = (String) objectRef2.element;
                String str8 = (String) objectRef3.element;
                String str9 = (String) objectRef3.element;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(sessionConfiguration);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(palNonceManagerWrapper2);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(function3);
                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(sessionInitUrl);
                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(objectRef2);
                anonymousClass2.L$7 = objectRef3;
                function4 = function2;
                anonymousClass2.L$8 = function4;
                anonymousClass2.L$9 = str7;
                anonymousClass2.L$10 = str8;
                anonymousClass2.L$11 = str4;
                anonymousClass2.L$12 = palNonceManagerWrapper2;
                anonymousClass2.J$0 = jLongValue;
                anonymousClass2.I$0 = data;
                anonymousClass2.label = 1;
                objCreateSessionTracker = SessionTrackerKt.createSessionTracker(str9, palNonceManagerWrapper2, sessionConfiguration, anonymousClass2);
                if (objCreateSessionTracker == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = str7;
                objectRef = objectRef3;
                str3 = str8;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = anonymousClass1.I$0;
        long j = anonymousClass1.J$0;
        PalNonceManagerWrapper palNonceManagerWrapper3 = (PalNonceManagerWrapper) anonymousClass1.L$12;
        String str10 = (String) anonymousClass1.L$11;
        str3 = (String) anonymousClass1.L$10;
        str2 = (String) anonymousClass1.L$9;
        Function2<? super Session, ? super String, ? extends Job> function5 = (Function2) anonymousClass1.L$8;
        objectRef = (Ref.ObjectRef) anonymousClass1.L$7;
        ResultKt.throwOnFailure(objCreateSessionTracker);
        palNonceManagerWrapper2 = palNonceManagerWrapper3;
        str4 = str10;
        function4 = function5;
        Session sessionCreateSessionObject = Session_androidKt.createSessionObject(str2, str3, str4, palNonceManagerWrapper2, (SessionTracker) objCreateSessionTracker);
        CharSequence charSequence = (CharSequence) objectRef.element;
        function4.invoke(sessionCreateSessionObject, "Session initialized ".concat((charSequence == null || StringsKt.isBlank(charSequence)) ? "without 'trackingUrl'" : "elsewhere"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionKt$initSession$6, reason: invalid class name */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionKt$initSession$6", f = "Session.kt", i = {1}, l = {287, 307}, m = "invokeSuspend", n = {"result"}, nl = {295, 305}, s = {"L$0"}, v = 2)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionConfiguration $config;
        final /* synthetic */ int $maxRetry;
        final /* synthetic */ String $palNonce;
        final /* synthetic */ PalNonceManagerWrapper $palNonceManager;
        final /* synthetic */ Ref.ObjectRef<String> $playbackUrl;
        final /* synthetic */ HashMap<String, String> $playerParams;
        final /* synthetic */ Function2<Integer, String, Job> $reportError;
        final /* synthetic */ Function2<Session, String, Job> $reportSuccess;
        final /* synthetic */ HashMap<String, JsonElement> $rootParams;
        final /* synthetic */ String $sessionInitUrl;
        final /* synthetic */ long $timeout;
        final /* synthetic */ Ref.ObjectRef<String> $trackingUrl;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass6(String str, HashMap<String, JsonElement> map, HashMap<String, String> map2, SessionConfiguration sessionConfiguration, long j, int i, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Function2<? super Integer, ? super String, ? extends Job> function2, Function2<? super Session, ? super String, ? extends Job> function3, String str2, PalNonceManagerWrapper palNonceManagerWrapper, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$sessionInitUrl = str;
            this.$rootParams = map;
            this.$playerParams = map2;
            this.$config = sessionConfiguration;
            this.$timeout = j;
            this.$maxRetry = i;
            this.$playbackUrl = objectRef;
            this.$trackingUrl = objectRef2;
            this.$reportError = function2;
            this.$reportSuccess = function3;
            this.$palNonce = str2;
            this.$palNonceManager = palNonceManagerWrapper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.$sessionInitUrl, this.$rootParams, this.$playerParams, this.$config, this.$timeout, this.$maxRetry, this.$playbackUrl, this.$trackingUrl, this.$reportError, this.$reportSuccess, this.$palNonce, this.$palNonceManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v23, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Function2<Session, String, Job> function2;
            String str2;
            String str3;
            String str4;
            PalNonceManagerWrapper palNonceManagerWrapper;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Logger_androidKt.getLogger().d("createSession: Request sent to URL '" + this.$sessionInitUrl + "'");
                this.label = 1;
                obj = new SessionInitUseCase(MediaTailorKt.getNetwork()).m10987invokebPJOTnY(this.$sessionInitUrl, new SessionInitRequest(this.$rootParams, this.$playerParams), this.$config.getSessionInitHeaders(), this.$timeout, this.$maxRetry, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                palNonceManagerWrapper = (PalNonceManagerWrapper) this.L$5;
                str4 = (String) this.L$4;
                str3 = (String) this.L$3;
                str2 = (String) this.L$2;
                function2 = (Function2) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            function2.invoke(Session_androidKt.createSessionObject(str2, str3, str4, palNonceManagerWrapper, (SessionTracker) obj), "Successful session response");
            return Unit.INSTANCE;
            Resource resource = (Resource) obj;
            if (resource.isSuccess()) {
                SessionInitResponse sessionInitResponse = (SessionInitResponse) resource.getData();
                if (sessionInitResponse != null) {
                    Ref.ObjectRef<String> objectRef = this.$playbackUrl;
                    String str5 = this.$sessionInitUrl;
                    Ref.ObjectRef<String> objectRef2 = this.$trackingUrl;
                    String manifestUrl = sessionInitResponse.getManifestUrl();
                    if (manifestUrl != null) {
                        objectRef.element = URL_androidKt.absoluteUrl(manifestUrl, str5);
                    }
                    String trackingUrl = sessionInitResponse.getTrackingUrl();
                    if (trackingUrl != null) {
                        objectRef2.element = URL_androidKt.absoluteUrl(trackingUrl, str5);
                    }
                }
                String str6 = this.$playbackUrl.element;
                if (str6 == null || StringsKt.isBlank(str6) || (str = this.$trackingUrl.element) == null || StringsKt.isBlank(str)) {
                    this.$reportError.invoke(Boxing.boxInt(SessionErrorCode.INVALID_INIT_RESPONSE.getValue()), "Invalid session response");
                } else {
                    function2 = this.$reportSuccess;
                    str2 = this.$playbackUrl.element;
                    String str7 = this.$trackingUrl.element;
                    Intrinsics.checkNotNull(str7);
                    String str8 = str7;
                    String str9 = this.$palNonce;
                    PalNonceManagerWrapper palNonceManagerWrapper2 = this.$palNonceManager;
                    String str10 = this.$trackingUrl.element;
                    Intrinsics.checkNotNull(str10);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(resource);
                    this.L$1 = function2;
                    this.L$2 = str2;
                    this.L$3 = str8;
                    this.L$4 = str9;
                    this.L$5 = palNonceManagerWrapper2;
                    this.label = 2;
                    obj = SessionTrackerKt.createSessionTracker(str10, this.$palNonceManager, this.$config, this);
                    if (obj != coroutine_suspended) {
                        str3 = str8;
                        str4 = str9;
                        palNonceManagerWrapper = palNonceManagerWrapper2;
                        function2.invoke(Session_androidKt.createSessionObject(str2, str3, str4, palNonceManagerWrapper, (SessionTracker) obj), "Successful session response");
                    }
                    return coroutine_suspended;
                }
            } else {
                this.$reportError.invoke(Boxing.boxInt(SessionErrorCode.FAILED_INIT_RESPONSE.getValue()), "Session init failed");
            }
            return Unit.INSTANCE;
        }
    }
}
