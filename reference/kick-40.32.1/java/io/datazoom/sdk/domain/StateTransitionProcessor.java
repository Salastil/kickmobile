package io.datazoom.sdk.domain;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.data.memory.ConfigStore;
import io.datazoom.sdk.data.memory.FluxDataStore;
import io.datazoom.sdk.data.memory.FluxDataStoreExtensionsKt;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.data.memory.MetaDataStoreExtensionsKt;
import io.datazoom.sdk.data.memory.PreferenceStore;
import io.datazoom.sdk.data.memory.PreferenceStoreExtKt;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.model.AppConfig;
import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import io.datazoom.sdk.model.FluxData;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.stateMachine.Transition;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import io.datazoom.sdk.time.Time;
import io.datazoom.sdk.utils.DzPlaybackEvent;
import io.ktor.sse.ServerSentEventKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateTransitionProcessor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B×\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016\u0012\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011¢\u0006\u0004\b\u001e\u0010\u001fJP\u00102\u001a\u00020\u00132%\u0010\u000e\u001a!\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\t0603j\u0002`72!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011JP\u0010=\u001a\u00020\u00132%\u0010\u000e\u001a!\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\t0603j\u0002`72!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J)\u0010>\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J)\u0010?\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J\u0006\u0010@\u001a\u00020\u0013J)\u0010A\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J3\u0010B\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010C\u001a\u00020\u001dH\u0002J1\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020F2!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J)\u0010G\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J1\u0010H\u001a\u00020\u00132\u0006\u0010E\u001a\u00020F2!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011JP\u0010I\u001a\u00020\u00132%\u0010J\u001a!\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\t0603j\u0002`72!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011JP\u0010K\u001a\u00020\u00132%\u0010J\u001a!\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\t0603j\u0002`72!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J)\u0010L\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J)\u0010M\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J1\u0010N\u001a\u00020\u00132\u0006\u0010E\u001a\u00020F2!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J)\u0010O\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J)\u0010P\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J\u0010\u0010Q\u001a\u00020\u00132\b\b\u0002\u0010C\u001a\u00020\u001dJ(\u0010R\u001a\u00020\u00132\n\u0010S\u001a\u00060Tj\u0002`U2\u0006\u0010V\u001a\u00020\u001d2\n\u0010W\u001a\u00060Tj\u0002`UH\u0002J+\u0010X\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011H\u0002J)\u0010Y\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J\u0006\u0010Z\u001a\u00020\u0013J)\u0010[\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J)\u0010\\\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J)\u0010]\u001a\u00020\u00132!\u00108\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00130\u0011J\u001a\u0010^\u001a\u00020\u00132\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00130\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#¨\u0006_"}, d2 = {"Lio/datazoom/sdk/domain/StateTransitionProcessor;", "", "contentSessionManager", "Lio/datazoom/sdk/domain/SessionManager;", "adSessionManager", "adBreakSessionManager", "prefStore", "Lio/datazoom/sdk/data/memory/PreferenceStore;", "globalPrefStore", "configStore", "Lio/datazoom/sdk/data/memory/ConfigStore;", "fluxData", "Lio/datazoom/sdk/data/memory/FluxDataStore;", "globalFlux", "metadata", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "onNewContentSessionRequested", "Lkotlin/Function1;", "", "", "onNewAdSessionRequested", "onAdComplete", "Lkotlin/Function0;", "onAdBreakEnded", "playbackEvents", "Lio/datazoom/sdk/utils/DzPlaybackEvent;", "onAdSkip", "getEventTimeSince", "Lio/datazoom/sdk/model/Event$Type;", "", "<init>", "(Lio/datazoom/sdk/domain/SessionManager;Lio/datazoom/sdk/domain/SessionManager;Lio/datazoom/sdk/domain/SessionManager;Lio/datazoom/sdk/data/memory/PreferenceStore;Lio/datazoom/sdk/data/memory/PreferenceStore;Lio/datazoom/sdk/data/memory/ConfigStore;Lio/datazoom/sdk/data/memory/FluxDataStore;Lio/datazoom/sdk/data/memory/FluxDataStore;Lio/datazoom/sdk/data/memory/MetaDataStore;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getOnNewContentSessionRequested", "()Lkotlin/jvm/functions/Function1;", "setOnNewContentSessionRequested", "(Lkotlin/jvm/functions/Function1;)V", "getOnNewAdSessionRequested", "setOnNewAdSessionRequested", "getOnAdComplete", "()Lkotlin/jvm/functions/Function0;", "setOnAdComplete", "(Lkotlin/jvm/functions/Function0;)V", "getOnAdBreakEnded", "setOnAdBreakEnded", "getPlaybackEvents", "setPlaybackEvents", "getOnAdSkip", "setOnAdSkip", "getGetEventTimeSince", "setGetEventTimeSince", "seekingContentStateOnEntry", "Ljava/util/HashMap;", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "sendEvent", "Lio/datazoom/sdk/model/Event;", "Lkotlin/ParameterName;", "name", "event", "seekingAdStateOnEntry", "pausedStateOnEntry", "playingStateOnEntry", "playingStateOnExit", "adPlayingStateOnEntry", "adPlaybackStarted", "timestamp", "adBufferingStateOnEntry", "transition", "Lio/datazoom/sdk/stateMachine/Transition;", "adBufferingStateOnExit", "adRequestedStateOnEntry", "handleErrorStateOnEntry", "payload", "handleAdErrorStateOnEntry", "stoppedStateOnEntry", "contentCompletedStateOnEntry", "handleBufferingStateOnEntry", "handleBufferingStateOnExit", "handleRequestedStateOnEntry", "updateDurations", "updateDurationsInStore", "contentSpecificDuration", "Lio/datazoom/sdk/model/FluxData$Type;", "Lio/datazoom/sdk/model/FD;", "elapsed", "overallDuration", "endContentSession", "adPausedStateOnEntry", "reset", "adBreakEndedStateOnEntry", "adBreakStartedStateOnEntry", "adCompletedStateOnEntry", "adSkippedStateOnEntry", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StateTransitionProcessor {
    private final SessionManager adBreakSessionManager;
    private final SessionManager adSessionManager;
    private final ConfigStore configStore;
    private final SessionManager contentSessionManager;
    private final FluxDataStore fluxData;
    private Function1<? super Event.Type, Long> getEventTimeSince;
    private final FluxDataStore globalFlux;
    private final PreferenceStore globalPrefStore;
    private final MetaDataStore metadata;
    private Function0<Unit> onAdBreakEnded;
    private Function0<Unit> onAdComplete;
    private Function0<Unit> onAdSkip;
    private Function1<? super String, Unit> onNewAdSessionRequested;
    private Function1<? super String, Unit> onNewContentSessionRequested;
    private Function1<? super DzPlaybackEvent, Unit> playbackEvents;
    private final PreferenceStore prefStore;

    public final void adRequestedStateOnEntry(Transition transition, Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
    }

    public StateTransitionProcessor(SessionManager contentSessionManager, SessionManager adSessionManager, SessionManager adBreakSessionManager, PreferenceStore prefStore, PreferenceStore globalPrefStore, ConfigStore configStore, FluxDataStore fluxData, FluxDataStore globalFlux, MetaDataStore metadata, Function1<? super String, Unit> function1, Function1<? super String, Unit> function2, Function0<Unit> function0, Function0<Unit> function3, Function1<? super DzPlaybackEvent, Unit> function4, Function0<Unit> function5, Function1<? super Event.Type, Long> function6) {
        Intrinsics.checkNotNullParameter(contentSessionManager, "contentSessionManager");
        Intrinsics.checkNotNullParameter(adSessionManager, "adSessionManager");
        Intrinsics.checkNotNullParameter(adBreakSessionManager, "adBreakSessionManager");
        Intrinsics.checkNotNullParameter(prefStore, "prefStore");
        Intrinsics.checkNotNullParameter(globalPrefStore, "globalPrefStore");
        Intrinsics.checkNotNullParameter(configStore, "configStore");
        Intrinsics.checkNotNullParameter(fluxData, "fluxData");
        Intrinsics.checkNotNullParameter(globalFlux, "globalFlux");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.contentSessionManager = contentSessionManager;
        this.adSessionManager = adSessionManager;
        this.adBreakSessionManager = adBreakSessionManager;
        this.prefStore = prefStore;
        this.globalPrefStore = globalPrefStore;
        this.configStore = configStore;
        this.fluxData = fluxData;
        this.globalFlux = globalFlux;
        this.metadata = metadata;
        this.onNewContentSessionRequested = function1;
        this.onNewAdSessionRequested = function2;
        this.onAdComplete = function0;
        this.onAdBreakEnded = function3;
        this.playbackEvents = function4;
        this.onAdSkip = function5;
        this.getEventTimeSince = function6;
    }

    public final Function1<String, Unit> getOnNewContentSessionRequested() {
        return this.onNewContentSessionRequested;
    }

    public final void setOnNewContentSessionRequested(Function1<? super String, Unit> function1) {
        this.onNewContentSessionRequested = function1;
    }

    public final Function1<String, Unit> getOnNewAdSessionRequested() {
        return this.onNewAdSessionRequested;
    }

    public final void setOnNewAdSessionRequested(Function1<? super String, Unit> function1) {
        this.onNewAdSessionRequested = function1;
    }

    public final Function0<Unit> getOnAdComplete() {
        return this.onAdComplete;
    }

    public final void setOnAdComplete(Function0<Unit> function0) {
        this.onAdComplete = function0;
    }

    public final Function0<Unit> getOnAdBreakEnded() {
        return this.onAdBreakEnded;
    }

    public final void setOnAdBreakEnded(Function0<Unit> function0) {
        this.onAdBreakEnded = function0;
    }

    public final Function1<DzPlaybackEvent, Unit> getPlaybackEvents() {
        return this.playbackEvents;
    }

    public final void setPlaybackEvents(Function1<? super DzPlaybackEvent, Unit> function1) {
        this.playbackEvents = function1;
    }

    public final Function0<Unit> getOnAdSkip() {
        return this.onAdSkip;
    }

    public final void setOnAdSkip(Function0<Unit> function0) {
        this.onAdSkip = function0;
    }

    public final Function1<Event.Type, Long> getGetEventTimeSince() {
        return this.getEventTimeSince;
    }

    public final void setGetEventTimeSince(Function1<? super Event.Type, Long> function1) {
        this.getEventTimeSince = function1;
    }

    public final void seekingContentStateOnEntry(HashMap<String, Object> metadata, Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.SeekEnd, Time.INSTANCE.now(), metadata, null, null, 12, null));
    }

    public final void seekingAdStateOnEntry(HashMap<String, Object> metadata, Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.SeekEnd, Time.INSTANCE.now(), metadata, null, null, 12, null));
    }

    public final void pausedStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        PreferenceStore preferenceStore = this.prefStore;
        if (PreferenceStoreExtKt.isContentPaused(preferenceStore)) {
            return;
        }
        PreferenceStoreExtKt.setContentPaused(preferenceStore, true);
        sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.Pause, Time.INSTANCE.now(), null, null, null, 14, null));
    }

    public final void playingStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        PreferenceStore preferenceStore = this.prefStore;
        Long l = 0L;
        if (!PreferenceStoreExtKt.isContentStarted(preferenceStore)) {
            PreferenceStoreExtKt.setContentStarted(preferenceStore, true);
            Long ctPlayingPos = PreferenceStoreExtKt.getCtPlayingPos(preferenceStore);
            if (ctPlayingPos != null && ctPlayingPos.longValue() == 0) {
                PreferenceStoreExtKt.setCtPosUpdateTime(this.prefStore, Time.INSTANCE.now());
            }
            PreferenceStore preferenceStore2 = this.globalPrefStore;
            PreferenceStoreExtKt.setCtPlayedCount(preferenceStore2, PreferenceStoreExtKt.getCtPlayedCount(preferenceStore2) + 1);
            this.fluxData.put(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAY_HEAD_POSITION, l));
            Function1<? super Event.Type, Long> function1 = this.getEventTimeSince;
            long jLongValue = function1 != null ? function1.invoke(Event.Type.MediaRequest).longValue() : 0L;
            sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.PlaybackStart, 0L, null, MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.STARTUP_DURATION_CONTENT_MS.getValue(), Long.valueOf(jLongValue - PreferenceStoreExtKt.getTotalAdBreakTime(this.prefStore))), TuplesKt.to(MetaData.Type.STARTUP_DURATION_TOTAL_MS.getValue(), Long.valueOf(jLongValue - PreferenceStoreExtKt.getTotalAdPlaybackTime(this.prefStore)))), MapsKt.hashMapOf(TuplesKt.to(FluxData.Type.NUMBER_OF_VIDEOS_PLAYED.getValue(), Integer.valueOf(PreferenceStoreExtKt.getCtPlayedCount(this.globalPrefStore)))), 3, null));
        }
        Long l2 = (Long) this.fluxData.get(FluxData.Type.PLAY_HEAD_POSITION);
        PreferenceStoreExtKt.setCtPlayingPos(preferenceStore, l2 != null ? l2 : 0L);
        sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.Playing, 0L, null, null, null, 15, null));
        if (PreferenceStoreExtKt.isContentPaused(preferenceStore)) {
            PreferenceStoreExtKt.setContentPaused(preferenceStore, false);
            sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.Resume, 0L, null, null, null, 15, null));
        }
        AppConfig appConfig = ConfigStore.get$default(this.configStore, null, 1, null);
        if (appConfig != null) {
            long heartbeatIntervalMs = appConfig.getHeartbeatIntervalMs();
            if (PreferenceStoreExtKt.getNextHeartbeatTime(preferenceStore) <= 0) {
                PreferenceStoreExtKt.setNextHeartbeatTime(preferenceStore, Time.INSTANCE.now() + heartbeatIntervalMs);
                PreferenceStoreExtKt.setActiveSinceLastHeartbeat(preferenceStore, false);
            }
        }
    }

    public final void playingStateOnExit() {
        PreferenceStoreExtKt.setCtPlayingPos(this.prefStore, null);
    }

    public final void adPlayingStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        long jNow = Time.INSTANCE.now();
        PreferenceStoreExtKt.setAdPosUpdateTime(this.prefStore, jNow);
        if (!PreferenceStoreExtKt.isAdStarted(this.prefStore)) {
            adPlaybackStarted(sendEvent, jNow);
        }
        if (PreferenceStoreExtKt.isAdPaused(this.prefStore)) {
            PreferenceStoreExtKt.setAdPaused(this.prefStore, false);
            sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.Resume, jNow, null, null, null, 14, null));
            Function1<? super DzPlaybackEvent, Unit> function1 = this.playbackEvents;
            if (function1 != null) {
                function1.invoke(DzPlaybackEvent.RESUME);
            }
        }
    }

    private final void adPlaybackStarted(Function1<? super Event, Unit> sendEvent, long timestamp) {
        PreferenceStoreExtKt.setAdStarted(this.prefStore, true);
        PreferenceStoreExtKt.setPlayingAd(this.prefStore, true);
        this.globalFlux.incrementCounter(FluxData.Type.NUMBER_OF_ADS_PLAYED);
        this.fluxData.incrementCounter(FluxData.Type.NUMBER_OF_ADS_BREAK_PLAYED);
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.PlaybackStartAd, timestamp, null, null, null, 14, null));
    }

    public final void adBufferingStateOnEntry(Transition transition, Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        PreferenceStoreExtKt.setStalling(this.prefStore, Intrinsics.areEqual(transition.getOldState(), State.Ad.PLAYING.INSTANCE));
        if (PreferenceStoreExtKt.isStalling(this.prefStore)) {
            this.fluxData.incrementCounter(FluxData.Type.STALL_COUNT_ADS);
            sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.StallStarted, 0L, null, null, null, 15, null));
        }
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.BufferStart, 0L, null, null, null, 15, null));
    }

    public final void adBufferingStateOnExit(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        long jNow = Time.INSTANCE.now();
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.BufferEnd, jNow, null, null, null, 14, null));
        if (PreferenceStoreExtKt.isStalling(this.prefStore)) {
            sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.StallEnded, jNow, null, null, null, 14, null));
        }
        PreferenceStoreExtKt.setStalling(this.prefStore, false);
    }

    public final void handleErrorStateOnEntry(HashMap<String, Object> payload, Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.globalFlux.incrementCounter(FluxData.Type.NUMBER_OF_ERRORS_CONTENT);
        this.globalFlux.computeSum(FluxData.Type.NUMBER_OF_ERRORS, CollectionsKt.listOf((Object[]) new FluxData.Type[]{FluxData.Type.NUMBER_OF_ERRORS_AD, FluxData.Type.NUMBER_OF_ERRORS_CONTENT}));
        sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.Error, 0L, null, payload, null, 11, null));
        this.contentSessionManager.endSession();
    }

    public final void handleAdErrorStateOnEntry(HashMap<String, Object> payload, Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.adSessionManager.endSession();
        this.globalFlux.incrementCounter(FluxData.Type.NUMBER_OF_ERRORS_AD);
        this.globalFlux.computeSum(FluxData.Type.NUMBER_OF_ERRORS, CollectionsKt.listOf((Object[]) new FluxData.Type[]{FluxData.Type.NUMBER_OF_ERRORS_AD, FluxData.Type.NUMBER_OF_ERRORS_CONTENT}));
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.Error, 0L, null, payload, null, 11, null));
    }

    public final void stoppedStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.contentSessionManager.endSession();
        sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.Stop, 0L, null, null, null, 15, null));
    }

    public final void contentCompletedStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.PlaybackCompleted, 0L, null, null, null, 15, null));
        Function1<? super DzPlaybackEvent, Unit> function1 = this.playbackEvents;
        if (function1 != null) {
            function1.invoke(DzPlaybackEvent.END);
        }
    }

    public final void handleBufferingStateOnEntry(Transition transition, Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        PreferenceStoreExtKt.setStalling(this.prefStore, Intrinsics.areEqual(transition.getOldState(), State.Content.PLAYING.INSTANCE));
        if (PreferenceStoreExtKt.isStalling(this.prefStore)) {
            this.fluxData.incrementCounter(FluxData.Type.STALL_COUNT_CONTENT);
            sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.StallStarted, 0L, null, null, null, 15, null));
        }
        sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.BufferStart, 0L, null, null, null, 15, null));
    }

    public final void handleBufferingStateOnExit(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        long jNow = Time.INSTANCE.now();
        sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.BufferEnd, jNow, null, null, null, 14, null));
        if (PreferenceStoreExtKt.isStalling(this.prefStore)) {
            sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.StallEnded, jNow, null, null, null, 14, null));
        }
        PreferenceStoreExtKt.setStalling(this.prefStore, false);
        if (!PreferenceStoreExtKt.isContentStarted(this.prefStore)) {
            sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.MediaLoaded, jNow, null, null, null, 14, null));
        }
        updateDurations$default(this, 0L, 1, null);
    }

    public final void handleRequestedStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        endContentSession(sendEvent);
        Function1<? super String, Unit> function1 = this.onNewContentSessionRequested;
        if (function1 != null) {
            function1.invoke(this.contentSessionManager.currentSession().getId());
        }
        SessionManager.Session sessionCurrentSession = this.contentSessionManager.currentSession();
        this.metadata.put(MetaDataStoreExtensionsKt.to(MetaData.Type.CONTENT_SESSION_ID, sessionCurrentSession.getId()));
        this.fluxData.put(FluxDataStoreExtensionsKt.to(FluxData.Type.CONTENT_SESSION_START_TS_MS, Long.valueOf(sessionCurrentSession.getTime())));
        PreferenceStore preferenceStore = this.globalPrefStore;
        PreferenceStoreExtKt.setCtRequestedCount(preferenceStore, PreferenceStoreExtKt.getCtRequestedCount(preferenceStore) + 1);
        sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.MediaRequest, 0L, null, null, MapsKt.hashMapOf(TuplesKt.to(FluxData.Type.NUM_REQUESTS_CONTENT.getValue(), Integer.valueOf(PreferenceStoreExtKt.getCtRequestedCount(this.globalPrefStore)))), 7, null));
        Logger_androidKt.getLogger().d("Media Requested " + this.contentSessionManager.currentSession().getId() + ServerSentEventKt.SPACE);
    }

    public static /* synthetic */ void updateDurations$default(StateTransitionProcessor stateTransitionProcessor, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Time.INSTANCE.now();
        }
        stateTransitionProcessor.updateDurations(j);
    }

    public final void updateDurations(long timestamp) {
        long lastDurUpdateTime = timestamp - PreferenceStoreExtKt.getLastDurUpdateTime(this.prefStore);
        if (lastDurUpdateTime < 0 || lastDurUpdateTime > 2000) {
            StateTransitionProcessorKt.durationAbnormalityLogger(lastDurUpdateTime);
        } else if (lastDurUpdateTime > 0) {
            if (Intrinsics.areEqual(PreferenceStoreExtKt.getCurrState(this.prefStore), State.Content.PAUSED.INSTANCE)) {
                updateDurationsInStore(FluxData.Type.PAUSE_DURATION_CONTENT_MS, lastDurUpdateTime, FluxData.Type.PAUSE_DURATION_MS);
            } else if (Intrinsics.areEqual(PreferenceStoreExtKt.getCurrState(this.prefStore), State.Ad.PAUSED.INSTANCE)) {
                updateDurationsInStore(FluxData.Type.PAUSE_DURATION_ADS_MS, lastDurUpdateTime, FluxData.Type.PAUSE_DURATION_MS);
            } else {
                boolean zAreEqual = Intrinsics.areEqual(PreferenceStoreExtKt.getCurrState(this.prefStore), State.Content.BUFFERING.INSTANCE);
                PreferenceStore preferenceStore = this.prefStore;
                if (zAreEqual) {
                    if (PreferenceStoreExtKt.isStalling(preferenceStore)) {
                        updateDurationsInStore(FluxData.Type.STALL_DURATION_CONTENT_MS, lastDurUpdateTime, FluxData.Type.STALL_DURATION_MS);
                    }
                    updateDurationsInStore(FluxData.Type.BUFFER_DURATION_CONTENT_MS, lastDurUpdateTime, FluxData.Type.BUFFER_DURATION_MS);
                } else if (Intrinsics.areEqual(PreferenceStoreExtKt.getCurrState(preferenceStore), State.Content.BUFFERING.INSTANCE)) {
                    if (PreferenceStoreExtKt.isStalling(this.prefStore)) {
                        updateDurationsInStore(FluxData.Type.STALL_DURATION_ADS_MS, lastDurUpdateTime, FluxData.Type.STALL_DURATION_MS);
                    }
                    updateDurationsInStore(FluxData.Type.BUFFER_DURATION_ADS_MS, lastDurUpdateTime, FluxData.Type.BUFFER_DURATION_MS);
                }
            }
        }
        PreferenceStoreExtKt.setLastDurUpdateTime(this.prefStore, timestamp);
    }

    private final void updateDurationsInStore(FluxData.Type contentSpecificDuration, long elapsed, FluxData.Type overallDuration) {
        this.fluxData.addDuration(contentSpecificDuration, elapsed);
        this.fluxData.addDuration(overallDuration, elapsed);
    }

    private final void endContentSession(Function1<? super Event, Unit> sendEvent) {
        boolean zIsAlive = this.contentSessionManager.isAlive();
        this.contentSessionManager.endSession();
        if (zIsAlive) {
            sendEvent.invoke(EventKt.toContentEvent$default(Event.Type.Stop, 0L, null, null, null, 15, null));
        }
        PreferenceStoreExtKt.setContentStarted(this.prefStore, false);
    }

    public final void adPausedStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        if (PreferenceStoreExtKt.isAdPaused(this.prefStore)) {
            return;
        }
        PreferenceStoreExtKt.setAdPaused(this.prefStore, true);
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.Pause, 0L, null, null, null, 15, null));
        Function1<? super DzPlaybackEvent, Unit> function1 = this.playbackEvents;
        if (function1 != null) {
            function1.invoke(DzPlaybackEvent.PAUSE);
        }
    }

    public final void reset() {
        this.onNewContentSessionRequested = null;
        this.onNewAdSessionRequested = null;
        this.onAdComplete = null;
        this.onAdBreakEnded = null;
        this.playbackEvents = null;
        this.onAdSkip = null;
        this.getEventTimeSince = null;
        Logger_androidKt.getLogger().d("StateTransitionProcessor disposed, all callbacks cleared.");
    }

    public final void adBreakEndedStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.adBreakSessionManager.endSession();
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.AdBreakEnd, 0L, null, null, null, 15, null));
        Function0<Unit> function0 = this.onAdBreakEnded;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void adBreakStartedStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.AdBreakStart, 0L, null, null, null, 15, null));
        this.adBreakSessionManager.currentSession();
        Function1<? super String, Unit> function1 = this.onNewAdSessionRequested;
        if (function1 != null) {
            function1.invoke(this.adSessionManager.currentSession().getId());
        }
    }

    public final void adCompletedStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.PlaybackCompletedAd, 0L, null, null, null, 15, null));
        this.adSessionManager.endSession();
        Function0<Unit> function0 = this.onAdComplete;
        if (function0 != null) {
            function0.invoke();
        }
        PreferenceStoreExtKt.setAdStarted(this.prefStore, false);
        PreferenceStoreExtKt.setPlayingAd(this.prefStore, false);
        PreferenceStoreExtKt.setAdLoaded(this.prefStore, false);
    }

    public final void adSkippedStateOnEntry(Function1<? super Event, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.AdSkip, 0L, null, null, null, 15, null));
        Function0<Unit> function0 = this.onAdSkip;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
