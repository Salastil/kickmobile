package com.kick.mobile.kickivsplayerv2;

import android.app.Activity;
import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.cast.MediaTrack;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KickIvsPlayerV2Manager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010+\u001a\u00020\u00142&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012\u0012\u0004\u0012\u00020\u00140\u000eJ \u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\"2\b\b\u0002\u00101\u001a\u00020\"J&\u00102\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/2\u0006\u00103\u001a\u00020\"2\u0006\u00101\u001a\u00020\"2\u0006\u00104\u001a\u00020\"J\u000e\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020\"J\u000e\u00109\u001a\u00020\u00142\u0006\u00106\u001a\u000207J\u000e\u0010:\u001a\u00020\u00142\u0006\u00106\u001a\u000207J\u0012\u0010;\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u000e\u0010<\u001a\u00020\u00142\u0006\u00106\u001a\u000207J\u0006\u0010=\u001a\u00020\u0014J\u0010\u0010>\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010@R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRZ\u0010\r\u001aB\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0011\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u0011\u0010)\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b)\u0010#R\u000e\u0010*\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/KickIvsPlayerV2Manager;", "", "<init>", "()V", "nativePipSessionState", "Lcom/kick/mobile/kickivsplayerv2/NativePipSessionState;", RumEventMeta.VIEW_ID_KEY, "", "getViewId", "()Ljava/lang/Integer;", "setViewId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sendEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "getSendEvent", "()Lkotlin/jvm/functions/Function2;", "setSendEvent", "(Lkotlin/jvm/functions/Function2;)V", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", MediaTrack.ROLE_SUBTITLE, "getSubtitle", "setSubtitle", "isPlaying", "", "()Z", "setPlaying", "(Z)V", "pipEnabled", "getPipEnabled", "setPipEnabled", "isNativePipActive", "isScreenLocked", "setEventListener", "moduleEventDispatcher", "setBackgroundPipState", "activity", "Landroid/app/Activity;", "newState", "isChangingConfigurations", "onActivityStop", "isFinishing", "isInPictureInPictureMode", "onActivityResume", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "shouldRunAudioService", "onScreenLocked", "onUserPresent", "handleNativePipDismissed", "onTaskRemoved", "destroy", "setStreamInfo", "newInfo", "Lcom/kick/mobile/kickivsplayerv2/StreamInfo;", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickIvsPlayerV2Manager {
    private static boolean isPlaying;
    private static boolean isScreenLocked;
    private static boolean pipEnabled;
    private static Function2<? super String, ? super Map<String, ? extends Object>, Unit> sendEvent;
    private static Integer viewId;
    public static final KickIvsPlayerV2Manager INSTANCE = new KickIvsPlayerV2Manager();
    private static final NativePipSessionState nativePipSessionState = new NativePipSessionState();
    private static String title = "Kick";
    private static String subtitle = "Audio playing";

    private KickIvsPlayerV2Manager() {
    }

    public final Integer getViewId() {
        return viewId;
    }

    public final void setViewId(Integer num) {
        viewId = num;
    }

    public final Function2<String, Map<String, ? extends Object>, Unit> getSendEvent() {
        return sendEvent;
    }

    public final void setSendEvent(Function2<? super String, ? super Map<String, ? extends Object>, Unit> function2) {
        sendEvent = function2;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(String str) {
        title = str;
    }

    public final String getSubtitle() {
        return subtitle;
    }

    public final void setSubtitle(String str) {
        subtitle = str;
    }

    public final boolean isPlaying() {
        return isPlaying;
    }

    public final void setPlaying(boolean z) {
        isPlaying = z;
    }

    public final boolean getPipEnabled() {
        return pipEnabled;
    }

    public final void setPipEnabled(boolean z) {
        pipEnabled = z;
    }

    public final boolean isNativePipActive() {
        return nativePipSessionState.getIsActive();
    }

    public final void setEventListener(Function2<? super String, ? super Map<String, ? extends Object>, Unit> moduleEventDispatcher) {
        Intrinsics.checkNotNullParameter(moduleEventDispatcher, "moduleEventDispatcher");
        sendEvent = moduleEventDispatcher;
    }

    public static /* synthetic */ void setBackgroundPipState$default(KickIvsPlayerV2Manager kickIvsPlayerV2Manager, Activity activity, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        kickIvsPlayerV2Manager.setBackgroundPipState(activity, z, z2);
    }

    public final void setBackgroundPipState(Activity activity, boolean newState, boolean isChangingConfigurations) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean zIsNativePipActive = isNativePipActive();
        boolean zOnPipStateChanged = nativePipSessionState.onPipStateChanged(newState, isChangingConfigurations);
        if (zIsNativePipActive != newState) {
            Integer num = viewId;
            KickIvsPlayerV2View kickIvsPlayerV2View = num != null ? (KickIvsPlayerV2View) activity.findViewById(num.intValue()) : null;
            if (kickIvsPlayerV2View != null) {
                kickIvsPlayerV2View.setNativePipPresentation(activity, newState);
            }
            if (kickIvsPlayerV2View != null) {
                kickIvsPlayerV2View.onNativePipStateChanged(newState);
            }
            Function2<? super String, ? super Map<String, ? extends Object>, Unit> function2 = sendEvent;
            if (function2 != null) {
                function2.invoke("onPipChange", MapsKt.mapOf(TuplesKt.to("active", Boolean.valueOf(newState))));
            }
            if (shouldRunAudioService()) {
                AudioService.INSTANCE.start(activity);
            } else {
                AudioService.INSTANCE.stop(activity);
            }
        }
        if (zOnPipStateChanged) {
            handleNativePipDismissed(activity);
        }
    }

    public final void onActivityStop(Activity activity, boolean isFinishing, boolean isChangingConfigurations, boolean isInPictureInPictureMode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (nativePipSessionState.onActivityStopped(isChangingConfigurations, isInPictureInPictureMode)) {
            handleNativePipDismissed(activity);
        }
    }

    public final void onActivityResume(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        nativePipSessionState.onActivityResumed();
        isScreenLocked = false;
        if (shouldRunAudioService()) {
            return;
        }
        AudioService.INSTANCE.stop(context);
    }

    public final boolean shouldRunAudioService() {
        if (isPlaying) {
            return isScreenLocked || isNativePipActive();
        }
        return false;
    }

    public final void onScreenLocked(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isScreenLocked = true;
        if (shouldRunAudioService()) {
            AudioService.INSTANCE.start(context);
        }
    }

    public final void onUserPresent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isScreenLocked = false;
        if (shouldRunAudioService()) {
            return;
        }
        AudioService.INSTANCE.stop(context);
    }

    private final void handleNativePipDismissed(Activity activity) {
        Function2<? super String, ? super Map<String, ? extends Object>, Unit> function2;
        Integer num;
        KickIvsPlayerV2View kickIvsPlayerV2View;
        if (activity != null && (num = viewId) != null && (kickIvsPlayerV2View = (KickIvsPlayerV2View) activity.findViewById(num.intValue())) != null) {
            kickIvsPlayerV2View.setNativePipPresentation(activity, false);
            kickIvsPlayerV2View.onNativePipDismissed();
        }
        if (!nativePipSessionState.markDismissed() || (function2 = sendEvent) == null) {
            return;
        }
        function2.invoke("onPipChange", MapsKt.mapOf(TuplesKt.to("active", false)));
    }

    public final void onTaskRemoved(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AudioService.INSTANCE.stop(context);
        destroy();
    }

    public final void destroy() {
        viewId = null;
        isPlaying = false;
        pipEnabled = false;
        isScreenLocked = false;
        nativePipSessionState.reset();
    }

    public final void setStreamInfo(StreamInfo newInfo) {
        title = newInfo != null ? newInfo.getTitle() : null;
        subtitle = newInfo != null ? newInfo.getChannel() : null;
    }
}
