package com.amazon.mediatailorsdk;

import android.content.Context;
import com.amazon.mediatailorsdk.logs.Logger_androidKt;
import com.amazon.mediatailorsdk.utils.RandomUUID_androidKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.ads.interactivemedia.pal.ConsentSettings;
import com.google.ads.interactivemedia.pal.NonceLoader;
import com.google.ads.interactivemedia.pal.NonceManager;
import com.google.ads.interactivemedia.pal.NonceRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PAL.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001ac\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2Q\u0010\u000b\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\fH\u0000\"\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"currentNonceLoader", "Lcom/google/ads/interactivemedia/pal/NonceLoader;", "palInit", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "consentSettings", "Lcom/amazon/mediatailorsdk/PalConsentSettings;", "palRequestNonceManager", "requestParams", "Lcom/amazon/mediatailorsdk/PalNonceRequestParams;", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "nonce", "Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;", "nonceManager", "error", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PAL_androidKt {
    private static NonceLoader currentNonceLoader;

    public static final void palInit(Context context, PalConsentSettings consentSettings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consentSettings, "consentSettings");
        NonceLoader nonceLoader = new NonceLoader(context, ConsentSettings.builder().directedForChildOrUnknownAge(Boolean.valueOf(consentSettings.getDirectedForChildOrUnknownAge())).build());
        if (currentNonceLoader != null) {
            Logger_androidKt.getLogger().w("initPal: Resetting NonceLoader");
        }
        currentNonceLoader = nonceLoader;
    }

    public static final void palRequestNonceManager(PalNonceRequestParams requestParams, final Function3<? super String, ? super PalNonceManagerWrapper, ? super String, Unit> callback) {
        Task<NonceManager> taskLoadNonceManager;
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (currentNonceLoader != null) {
            NonceRequest.Builder builder = NonceRequest.builder();
            Intrinsics.checkNotNullExpressionValue(builder, "builder(...)");
            Boolean adWillAutoPlay = requestParams.getAdWillAutoPlay();
            if (adWillAutoPlay != null) {
                adWillAutoPlay.booleanValue();
                builder.willAdAutoPlay(adWillAutoPlay);
            }
            Boolean adWillPlayMuted = requestParams.getAdWillPlayMuted();
            if (adWillPlayMuted != null) {
                adWillPlayMuted.booleanValue();
                builder.willAdPlayMuted(adWillPlayMuted);
            }
            Boolean continuousPlayback = requestParams.getContinuousPlayback();
            if (continuousPlayback != null) {
                continuousPlayback.booleanValue();
                builder.continuousPlayback(continuousPlayback);
            }
            String descriptionUrl = requestParams.getDescriptionUrl();
            if (descriptionUrl != null) {
                builder.descriptionURL(descriptionUrl);
            }
            Boolean iconsSupported = requestParams.getIconsSupported();
            if (iconsSupported != null) {
                iconsSupported.booleanValue();
                builder.iconsSupported(iconsSupported);
            }
            Integer nonceLengthLimit = requestParams.getNonceLengthLimit();
            if (nonceLengthLimit != null) {
                builder.nonceLengthLimit(Integer.valueOf(nonceLengthLimit.intValue()));
            }
            String playerType = requestParams.getPlayerType();
            if (playerType != null) {
                builder.playerType(playerType);
            }
            String playerVersion = requestParams.getPlayerVersion();
            if (playerVersion != null) {
                builder.playerVersion(playerVersion);
            }
            String ppid = requestParams.getPpid();
            if (ppid != null) {
                builder.ppid(ppid);
            }
            Integer videoHeight = requestParams.getVideoHeight();
            if (videoHeight != null) {
                builder.videoPlayerHeight(Integer.valueOf(videoHeight.intValue()));
            }
            Integer videoWidth = requestParams.getVideoWidth();
            if (videoWidth != null) {
                builder.videoPlayerWidth(Integer.valueOf(videoWidth.intValue()));
            }
            String sessionId = requestParams.getSessionId();
            if (sessionId == null) {
                sessionId = RandomUUID_androidKt.randomUUID();
            }
            builder.sessionId(sessionId);
            String omidPartnerName = requestParams.getOmidPartnerName();
            if (omidPartnerName == null) {
                omidPartnerName = ConstantsKt.DEFAULT_OMID_PARTNER_NAME;
            }
            builder.omidPartnerName(omidPartnerName);
            String omidPartnerVersion = requestParams.getOmidPartnerVersion();
            if (omidPartnerVersion == null) {
                omidPartnerVersion = ConstantsKt.DEFAULT_OMID_PARTNER_VERSION;
            }
            builder.omidPartnerVersion(omidPartnerVersion);
            Set<Integer> supportedApiFrameworks = requestParams.getSupportedApiFrameworks();
            if (supportedApiFrameworks == null) {
                supportedApiFrameworks = ConstantsKt.getDEFAULT_SUPPORTED_API_FRAMEWORKS();
            }
            builder.supportedApiFrameworks(supportedApiFrameworks);
            NonceLoader nonceLoader = currentNonceLoader;
            if (nonceLoader == null || (taskLoadNonceManager = nonceLoader.loadNonceManager(builder.build())) == null) {
                return;
            }
            final Function1 function1 = new Function1() { // from class: com.amazon.mediatailorsdk.PAL_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PAL_androidKt.palRequestNonceManager$lambda$11(callback, (NonceManager) obj);
                }
            };
            Task<NonceManager> taskAddOnSuccessListener = taskLoadNonceManager.addOnSuccessListener(new OnSuccessListener() { // from class: com.amazon.mediatailorsdk.PAL_androidKt$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            });
            if (taskAddOnSuccessListener != null) {
                taskAddOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.amazon.mediatailorsdk.PAL_androidKt$$ExternalSyntheticLambda2
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        PAL_androidKt.palRequestNonceManager$lambda$13(callback, exc);
                    }
                });
                return;
            }
            return;
        }
        callback.invoke(null, null, "PAL isn't initialized");
    }

    static final Unit palRequestNonceManager$lambda$11(Function3 function3, NonceManager nonceManager) {
        String nonce = nonceManager.getNonce();
        Intrinsics.checkNotNull(nonceManager);
        function3.invoke(nonce, new AndroidPalNonceManagerWrapper(nonceManager), null);
        return Unit.INSTANCE;
    }

    static final void palRequestNonceManager$lambda$13(Function3 function3, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        function3.invoke(null, null, error.toString());
    }
}
