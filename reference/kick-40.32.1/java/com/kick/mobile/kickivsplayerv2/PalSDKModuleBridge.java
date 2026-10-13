package com.kick.mobile.kickivsplayerv2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import java.net.URI;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PALSDKModuleBridge.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0016\u0010\u001a\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/PalSDKModuleBridge;", "", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "generateNonce", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "config", "Lcom/kick/mobile/kickivsplayerv2/PalNonceRequestConfig;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "setSessionActive", "active", "", "sendPlaybackEvent", "eventName", "", "resetSession", "destroyBridge", "makeRequestData", "Lcom/kick/mobile/kickivsplayerv2/PalNonceRequestData;", "makeSignal", "Lcom/kick/mobile/kickivsplayerv2/PalSignal;", "runOnMain", "action", "Lkotlin/Function0;", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PalSDKModuleBridge {
    public static final PalSDKModuleBridge INSTANCE = new PalSDKModuleBridge();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private PalSDKModuleBridge() {
    }

    public final void generateNonce(Context context, PalNonceRequestConfig config, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (context == null) {
            promise.reject("INVALID_PAL_NONCE_REQUEST", "React context is unavailable", new Error("React context is unavailable"));
            return;
        }
        PalNonceRequestData palNonceRequestDataMakeRequestData = makeRequestData(config);
        if (palNonceRequestDataMakeRequestData == null) {
            promise.reject("INVALID_PAL_NONCE_REQUEST", "Invalid PAL nonce request config", new Error("Invalid PAL nonce request config"));
        } else {
            PalSDKManager.INSTANCE.generateNonce(context, palNonceRequestDataMakeRequestData, new Function1() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKModuleBridge$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PalSDKModuleBridge.generateNonce$lambda$0(promise, (Result) obj);
                }
            });
        }
    }

    static final Unit generateNonce$lambda$0(Promise promise, Result result) {
        Object value = result.getValue();
        if (Result.m12691isSuccessimpl(value)) {
            promise.resolve(MapsKt.mapOf(TuplesKt.to("sdkAvailable", true), TuplesKt.to("nonce", (String) value)));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(value);
        if (thM12687exceptionOrNullimpl != null) {
            promise.reject("PAL_NONCE_GENERATION_FAILED", thM12687exceptionOrNullimpl.getMessage(), thM12687exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }

    public final void setSessionActive(final boolean active, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKModuleBridge$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKModuleBridge.setSessionActive$lambda$0(active, promise);
            }
        });
    }

    static final Unit setSessionActive$lambda$0(boolean z, Promise promise) {
        PalSDKManager.INSTANCE.setSessionActive(z);
        promise.resolve();
        return Unit.INSTANCE;
    }

    public final void sendPlaybackEvent(final String eventName, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKModuleBridge$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKModuleBridge.sendPlaybackEvent$lambda$0(eventName, promise);
            }
        });
    }

    static final Unit sendPlaybackEvent$lambda$0(String str, Promise promise) {
        PalSignal palSignalMakeSignal = INSTANCE.makeSignal(str);
        if (palSignalMakeSignal != null) {
            PalSDKManager.INSTANCE.sendSignal(palSignalMakeSignal);
        }
        promise.resolve();
        return Unit.INSTANCE;
    }

    public final void resetSession(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKModuleBridge$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKModuleBridge.resetSession$lambda$0(promise);
            }
        });
    }

    static final Unit resetSession$lambda$0(Promise promise) {
        PalSDKManager.INSTANCE.resetSession();
        promise.resolve();
        return Unit.INSTANCE;
    }

    public final void destroyBridge(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        runOnMain(new Function0() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKModuleBridge$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PalSDKModuleBridge.destroyBridge$lambda$0(promise);
            }
        });
    }

    static final Unit destroyBridge$lambda$0(Promise promise) {
        PalSDKManager.INSTANCE.destroyBridge();
        promise.resolve();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    private final PalNonceRequestData makeRequestData(PalNonceRequestConfig config) {
        String streamKey;
        String descriptionUrl;
        String playerType;
        String playerVersion;
        String string;
        if (config != null && (streamKey = config.getStreamKey()) != null) {
            String str = !StringsKt.isBlank(streamKey) ? streamKey : null;
            if (str != null && (descriptionUrl = config.getDescriptionUrl()) != null) {
                String str2 = !StringsKt.isBlank(descriptionUrl) ? descriptionUrl : null;
                if (str2 != null && (playerType = config.getPlayerType()) != null) {
                    String str3 = !StringsKt.isBlank(playerType) ? playerType : null;
                    if (str3 != null && (playerVersion = config.getPlayerVersion()) != null) {
                        String str4 = !StringsKt.isBlank(playerVersion) ? playerVersion : null;
                        if (str4 != null) {
                            try {
                                new URI(str2);
                                String ppid = config.getPpid();
                                String sessionId = config.getSessionId();
                                if (sessionId == null) {
                                    string = UUID.randomUUID().toString();
                                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                } else {
                                    string = StringsKt.isBlank(sessionId) ? null : sessionId;
                                    if (string == null) {
                                        string = UUID.randomUUID().toString();
                                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                    }
                                }
                                String str5 = string;
                                Integer videoPlayerHeight = config.getVideoPlayerHeight();
                                int iIntValue = videoPlayerHeight != null ? videoPlayerHeight.intValue() : 0;
                                Integer videoPlayerWidth = config.getVideoPlayerWidth();
                                int iIntValue2 = videoPlayerWidth != null ? videoPlayerWidth.intValue() : 0;
                                Boolean willAdPlayMuted = config.getWillAdPlayMuted();
                                return new PalNonceRequestData(str, str2, str3, str4, ppid, str5, iIntValue, iIntValue2, willAdPlayMuted != null ? willAdPlayMuted.booleanValue() : false);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private final PalSignal makeSignal(String eventName) {
        if (eventName == null) {
            return null;
        }
        int iHashCode = eventName.hashCode();
        if (iHashCode == -1178343643) {
            if (eventName.equals("adClick")) {
                return PalSignal.AdClicked;
            }
            return null;
        }
        if (iHashCode == -930179321) {
            if (eventName.equals("playbackStart")) {
                return PalSignal.PlaybackStarted;
            }
            return null;
        }
        if (iHashCode == 1706279104 && eventName.equals("playbackEnd")) {
            return PalSignal.PlaybackEnded;
        }
        return null;
    }

    private final void runOnMain(final Function0<Unit> action) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            action.invoke();
        } else {
            mainHandler.post(new Runnable() { // from class: com.kick.mobile.kickivsplayerv2.PalSDKModuleBridge$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    action.invoke();
                }
            });
        }
    }
}
