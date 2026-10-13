package com.kick.mobile.kickivsplayerv2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazon.mediatailorsdk.ConstantsKt;
import com.datadog.android.ndk.internal.NdkCrashLog;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.ads.interactivemedia.pal.ConsentSettings;
import com.google.ads.interactivemedia.pal.NonceLoader;
import com.google.ads.interactivemedia.pal.NonceManager;
import com.google.ads.interactivemedia.pal.NonceRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PALSDKManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u0012J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020\u0011J\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\tH\u0002J\u001c\u0010*\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u000b2\n\u0010+\u001a\u00060,j\u0002`-H\u0002J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0014H\u0002J\u0016\u00100\u001a\u00020\u00112\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001102H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a$\u0012\u0004\u0012\u00020\u000b\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/PalSDKManager;", "", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "nonceLoader", "Lcom/google/ads/interactivemedia/pal/NonceLoader;", "nonceManager", "Lcom/google/ads/interactivemedia/pal/NonceManager;", "activeStreamKey", "", "activeRequestId", "pendingNonceCompletions", "", "Lkotlin/Function1;", "Lkotlin/Result;", "", "Lcom/kick/mobile/kickivsplayerv2/NonceCompletion;", "isSessionActive", "", "didSendPlaybackStart", "didSendPlaybackEnd", "generateNonce", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "streamData", "Lcom/kick/mobile/kickivsplayerv2/PalNonceRequestData;", "completion", "setSessionActive", "active", "resetSession", "destroyBridge", "sendSignal", NdkCrashLog.SIGNAL_KEY_NAME, "Lcom/kick/mobile/kickivsplayerv2/PalSignal;", "getOrCreateNonceLoader", "makeNonceRequest", "Lcom/google/ads/interactivemedia/pal/NonceRequest;", "handleNonceLoaded", "requestId", "loadedNonceManager", "handleNonceFailed", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "resetCurrentNonceManager", "sendPlaybackEnd", "runOnMain", "action", "Lkotlin/Function0;", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PalSDKManager {
    private static String activeRequestId;
    private static String activeStreamKey;
    private static boolean didSendPlaybackEnd;
    private static boolean didSendPlaybackStart;
    private static boolean isSessionActive;
    private static NonceLoader nonceLoader;
    private static NonceManager nonceManager;
    public static final PalSDKManager INSTANCE = new PalSDKManager();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static Map<String, Function1<Result<String>, Unit>> pendingNonceCompletions = new LinkedHashMap();

    /* JADX INFO: compiled from: PALSDKManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PalSignal.values().length];
            try {
                iArr[PalSignal.AdClicked.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PalSignal.PlaybackStarted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PalSignal.PlaybackEnded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PalSDKManager() {
    }

    public final void generateNonce(final Context context, final PalNonceRequestData streamData, final Function1<? super Result<String>, Unit> completion) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(streamData, "streamData");
        Intrinsics.checkNotNullParameter(completion, "completion");
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKManager.generateNonce$lambda$0(streamData, completion, context);
            }
        });
    }

    static final Unit generateNonce$lambda$0(PalNonceRequestData palNonceRequestData, Function1 function1, Context context) {
        NonceManager nonceManager2 = nonceManager;
        String nonce = nonceManager2 != null ? nonceManager2.getNonce() : null;
        if (Intrinsics.areEqual(activeStreamKey, palNonceRequestData.getStreamKey()) && nonce != null) {
            Result.Companion companion = Result.INSTANCE;
            function1.invoke(Result.m12683boximpl(Result.m12684constructorimpl(nonce)));
            return Unit.INSTANCE;
        }
        PalSDKManager palSDKManager = INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        NonceLoader orCreateNonceLoader = palSDKManager.getOrCreateNonceLoader(applicationContext);
        palSDKManager.resetCurrentNonceManager(didSendPlaybackStart && !didSendPlaybackEnd);
        final String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        NonceRequest nonceRequestMakeNonceRequest = palSDKManager.makeNonceRequest(palNonceRequestData);
        activeStreamKey = palNonceRequestData.getStreamKey();
        activeRequestId = string;
        pendingNonceCompletions.put(string, function1);
        Task<NonceManager> taskLoadNonceManager = orCreateNonceLoader.loadNonceManager(nonceRequestMakeNonceRequest);
        final Function1 function2 = new Function1() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PalSDKManager.generateNonce$lambda$0$0(string, (NonceManager) obj);
            }
        };
        taskLoadNonceManager.addOnSuccessListener(new OnSuccessListener() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                function2.invoke(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                PalSDKManager.generateNonce$lambda$0$2(string, exc);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateNonce$lambda$0$0(String str, NonceManager nonceManager2) {
        PalSDKManager palSDKManager = INSTANCE;
        Intrinsics.checkNotNull(nonceManager2);
        palSDKManager.handleNonceLoaded(str, nonceManager2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void generateNonce$lambda$0$2(String str, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        INSTANCE.handleNonceFailed(str, error);
    }

    public final void setSessionActive(final boolean active) {
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKManager.setSessionActive$lambda$0(active);
            }
        });
    }

    static final Unit setSessionActive$lambda$0(boolean z) {
        isSessionActive = z;
        if (!z) {
            INSTANCE.resetCurrentNonceManager(didSendPlaybackStart && !didSendPlaybackEnd);
        }
        return Unit.INSTANCE;
    }

    public final void resetSession() {
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKManager.resetSession$lambda$0();
            }
        });
    }

    static final Unit resetSession$lambda$0() {
        INSTANCE.resetCurrentNonceManager(didSendPlaybackStart && !didSendPlaybackEnd);
        return Unit.INSTANCE;
    }

    public final void destroyBridge() {
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKManager.destroyBridge$lambda$0();
            }
        });
    }

    static final Unit destroyBridge$lambda$0() {
        INSTANCE.resetCurrentNonceManager(didSendPlaybackStart && !didSendPlaybackEnd);
        NonceLoader nonceLoader2 = nonceLoader;
        if (nonceLoader2 != null) {
            nonceLoader2.release();
        }
        nonceLoader = null;
        return Unit.INSTANCE;
    }

    public final void sendSignal(final PalSignal signal) {
        Intrinsics.checkNotNullParameter(signal, "signal");
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKManager.sendSignal$lambda$0(signal);
            }
        });
    }

    static final Unit sendSignal$lambda$0(PalSignal palSignal) {
        NonceManager nonceManager2 = nonceManager;
        if (nonceManager2 != null && isSessionActive) {
            int i = WhenMappings.$EnumSwitchMapping$0[palSignal.ordinal()];
            if (i == 1) {
                nonceManager2.sendAdClick();
            } else if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!didSendPlaybackStart || didSendPlaybackEnd) {
                    return Unit.INSTANCE;
                }
                nonceManager2.sendPlaybackEnd();
                didSendPlaybackEnd = true;
                isSessionActive = false;
            } else {
                if (didSendPlaybackStart) {
                    return Unit.INSTANCE;
                }
                nonceManager2.sendPlaybackStart();
                didSendPlaybackStart = true;
                didSendPlaybackEnd = false;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final NonceLoader getOrCreateNonceLoader(Context context) {
        NonceLoader nonceLoader2 = nonceLoader;
        if (nonceLoader2 != null) {
            return nonceLoader2;
        }
        ConsentSettings consentSettingsBuild = ConsentSettings.builder().directedForChildOrUnknownAge(false).build();
        Intrinsics.checkNotNullExpressionValue(consentSettingsBuild, "build(...)");
        NonceLoader nonceLoader3 = new NonceLoader(context, consentSettingsBuild);
        nonceLoader = nonceLoader3;
        return nonceLoader3;
    }

    private final NonceRequest makeNonceRequest(PalNonceRequestData streamData) {
        NonceRequest.Builder builderOmidPartnerVersion = NonceRequest.builder().continuousPlayback(false).descriptionURL(streamData.getDescriptionUrl()).iconsSupported(true).playerType(streamData.getPlayerType()).playerVersion(streamData.getPlayerVersion()).sessionId(streamData.getSessionId()).supportedApiFrameworks(SetsKt.setOf(7)).videoPlayerHeight(Integer.valueOf(RangesKt.coerceAtLeast(streamData.getVideoPlayerHeight(), 0))).videoPlayerWidth(Integer.valueOf(RangesKt.coerceAtLeast(streamData.getVideoPlayerWidth(), 0))).willAdAutoPlay(false).willAdPlayMuted(Boolean.valueOf(streamData.getWillAdPlayMuted())).omidPartnerName("Amazon2").omidPartnerVersion(ConstantsKt.DEFAULT_OMID_PARTNER_VERSION);
        Intrinsics.checkNotNullExpressionValue(builderOmidPartnerVersion, "omidPartnerVersion(...)");
        String ppid = streamData.getPpid();
        if (ppid != null) {
            if (StringsKt.isBlank(ppid)) {
                ppid = null;
            }
            if (ppid != null) {
                builderOmidPartnerVersion.ppid(ppid);
            }
        }
        NonceRequest nonceRequestBuild = builderOmidPartnerVersion.build();
        Intrinsics.checkNotNullExpressionValue(nonceRequestBuild, "build(...)");
        return nonceRequestBuild;
    }

    private final void handleNonceLoaded(final String requestId, final NonceManager loadedNonceManager) {
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKManager.handleNonceLoaded$lambda$0(requestId, loadedNonceManager);
            }
        });
    }

    static final Unit handleNonceLoaded$lambda$0(String str, NonceManager nonceManager2) {
        Function1<Result<String>, Unit> function1Remove = pendingNonceCompletions.remove(str);
        if (function1Remove == null) {
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(str, activeRequestId)) {
            Result.Companion companion = Result.INSTANCE;
            function1Remove.invoke(Result.m12683boximpl(Result.m12684constructorimpl(ResultKt.createFailure(new PalSDKManagerException("PAL nonce request was replaced by a newer stream.")))));
            return Unit.INSTANCE;
        }
        nonceManager = nonceManager2;
        didSendPlaybackStart = false;
        didSendPlaybackEnd = false;
        Result.Companion companion2 = Result.INSTANCE;
        function1Remove.invoke(Result.m12683boximpl(Result.m12684constructorimpl(nonceManager2.getNonce())));
        return Unit.INSTANCE;
    }

    private final void handleNonceFailed(final String requestId, final Exception error) {
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKManager.handleNonceFailed$lambda$0(requestId, error);
            }
        });
    }

    static final Unit handleNonceFailed$lambda$0(String str, Exception exc) {
        Function1<Result<String>, Unit> function1Remove = pendingNonceCompletions.remove(str);
        if (function1Remove == null) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(str, activeRequestId)) {
            INSTANCE.resetCurrentNonceManager(false);
        }
        Result.Companion companion = Result.INSTANCE;
        function1Remove.invoke(Result.m12683boximpl(Result.m12684constructorimpl(ResultKt.createFailure(exc))));
        return Unit.INSTANCE;
    }

    private final void resetCurrentNonceManager(boolean sendPlaybackEnd) {
        NonceManager nonceManager2;
        if (sendPlaybackEnd && (nonceManager2 = nonceManager) != null) {
            nonceManager2.sendPlaybackEnd();
        }
        nonceManager = null;
        activeStreamKey = null;
        activeRequestId = null;
        isSessionActive = false;
        didSendPlaybackStart = false;
        didSendPlaybackEnd = false;
        for (Function1<Result<String>, Unit> function1 : pendingNonceCompletions.values()) {
            Result.Companion companion = Result.INSTANCE;
            function1.invoke(Result.m12683boximpl(Result.m12684constructorimpl(ResultKt.createFailure(new PalSDKManagerException("PAL nonce request was replaced by a newer stream.")))));
        }
        pendingNonceCompletions.clear();
    }

    private final void runOnMain(final Function0<Unit> action) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            action.invoke();
        } else {
            mainHandler.post(new Runnable() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKManager$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    action.invoke();
                }
            });
        }
    }
}
