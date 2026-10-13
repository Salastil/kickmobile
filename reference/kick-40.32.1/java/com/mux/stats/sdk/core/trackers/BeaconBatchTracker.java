package com.mux.stats.sdk.core.trackers;

import androidx.work.multiprocess.RemoteWorkManager;
import com.mux.stats.sdk.core.CustomOptions;
import com.mux.stats.sdk.core.events.BaseEventListener;
import com.mux.stats.sdk.core.events.EventRateExceedTrackableEvent;
import com.mux.stats.sdk.core.events.IEvent;
import com.mux.stats.sdk.core.events.TrackableEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakEndEvent;
import com.mux.stats.sdk.core.events.playback.AdErrorEvent;
import com.mux.stats.sdk.core.events.playback.EndedEvent;
import com.mux.stats.sdk.core.events.playback.ErrorEvent;
import com.mux.stats.sdk.core.events.playback.RenditionChangeEvent;
import com.mux.stats.sdk.core.events.playback.ViewEndEvent;
import com.mux.stats.sdk.core.events.playback.ViewStartEvent;
import com.mux.stats.sdk.core.model.AdData;
import com.mux.stats.sdk.core.model.BaseQueryData;
import com.mux.stats.sdk.core.model.CustomerPlayerData;
import com.mux.stats.sdk.core.model.CustomerVideoData;
import com.mux.stats.sdk.core.model.EnvironmentData;
import com.mux.stats.sdk.core.model.PlayerData;
import com.mux.stats.sdk.core.model.SimpleBaseQueryData;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.util.MuxLogger;
import com.mux.stats.sdk.muxstats.INetworkRequest;
import com.mux.stats.sdk.muxstats.MuxStats;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class BeaconBatchTracker extends BaseEventListener implements INetworkRequest.IMuxNetworkRequestsCompletion2 {
    private a c;
    private ScheduledExecutorService e;
    private final CustomOptions h;
    protected long roundTripLastCompletedTimeElapsed;
    protected boolean roundTripLastSucceeded;
    protected long roundTripStartTime;
    protected long lastBeaconSentTime = 0;
    protected int failureCount = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f252a = true;
    private boolean b = false;
    protected ArrayList<TrackableEvent> eventQueue = new ArrayList<>();
    protected ArrayList<TrackableEvent> pendingEventsQueue = new ArrayList<>();
    protected INetworkRequest dispatcher = MuxStats.getHostNetworkApi();
    private String d = null;
    private final Set<String> f = new HashSet(Arrays.asList(ViewStartEvent.TYPE, "error", EndedEvent.TYPE, AdErrorEvent.TYPE, AdBreakEndEvent.TYPE, ViewEndEvent.TYPE));
    private boolean g = false;
    private long i = 0;
    private SimpleBaseQueryData j = null;
    private final Set<String> k = new HashSet(Arrays.asList(CustomerPlayerData.ENV_KEY, ViewData.VIEW_ID, ViewData.VIEW_SEQUENCE_NUMBER, PlayerData.PLAYER_SEQUENCE_NUMBER, PlayerData.PLAYER_PLAYHEAD_TIME, PlayerData.PLAYER_INSTANCE_ID, PlayerData.PLAYER_ERROR_CODE, PlayerData.PLAYER_ERROR_MESSAGE, PlayerData.PLAYER_ERROR_CONTEXT, PlayerData.PLAYER_ERROR_SEVERITY, PlayerData.PLAYER_ERROR_BUSINESS_EXCEPTION, "uti", ViewData.VIEW_PLAYING_TIME_MS_CUMULATIVE, AdData.AD_PLAYING_TIME_MS_CUMULATIVE, EnvironmentData.MUX_API_VERSION, CustomerVideoData.VIDEO_ID));

    public BeaconBatchTracker(CustomOptions customOptions) {
        this.h = customOptions;
        this.c = customOptions.isLongBeaconDispatch() ? a.d : a.c;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(2);
        this.e = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new Runnable() { // from class: com.mux.stats.sdk.core.trackers.BeaconBatchTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        }, 0L, 1000L, TimeUnit.MILLISECONDS);
    }

    private static String a(CustomOptions customOptions, String str) {
        String beaconDomain = customOptions.getBeaconDomain();
        String beaconCollectionDomain = customOptions.getBeaconCollectionDomain();
        if (str == null || str.isEmpty()) {
            return "inferred.litix.io";
        }
        if (beaconCollectionDomain == null || beaconCollectionDomain.isEmpty()) {
            return (beaconDomain == null || beaconDomain.isEmpty()) ? ".litix.io" : beaconDomain;
        }
        return beaconCollectionDomain;
    }

    private static Hashtable<String, String> a(String str) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        if (MuxStats.getHostDevice().getDeviceId() != null) {
            hashtable.put("x-litix-shard-id", MuxStats.getHostDevice().getDeviceId());
        }
        if (str != null) {
            hashtable.put("x-litix-env-key", str);
        }
        return hashtable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.e.execute(new Runnable() { // from class: com.mux.stats.sdk.core.trackers.BeaconBatchTracker$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    private void a(boolean z) {
        BeaconBatchTracker beaconBatchTracker;
        Throwable th;
        int size = this.eventQueue.size();
        if (!z) {
            size = Math.min(size, this.c.b);
        }
        if (size == 0) {
            return;
        }
        MuxLogger.d("MuxStatsEventQueue", "attempt to send " + size + " events, total queue size " + this.eventQueue.size());
        if ((!this.f252a && !z) || this.dispatcher == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                try {
                    if (this.eventQueue.isEmpty()) {
                        break;
                    }
                    TrackableEvent trackableEventRemove = this.eventQueue.remove(0);
                    this.pendingEventsQueue.add(trackableEventRemove);
                    String eventType = trackableEventRemove.getEventType();
                    sb.append(eventType + ", ");
                    JSONObject muxDictionary = trackableEventRemove.getQuery().getMuxDictionary();
                    muxDictionary.put("e", eventType);
                    JSONArray jSONArrayNames = muxDictionary.names();
                    MuxLogger.d("MuxStatsEventQueue", this.b ? "    sending " + eventType + "\n" + trackableEventRemove.getDebugString() : "    sending " + eventType + " with " + jSONArrayNames.length() + " dims");
                    for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                        String string = jSONArrayNames.getString(i2);
                        if (string.equals(CustomerPlayerData.ENV_KEY) && this.d == null) {
                            this.d = muxDictionary.getString(string);
                        }
                    }
                    jSONArray.put(muxDictionary);
                } catch (Throwable th2) {
                    th = th2;
                    beaconBatchTracker = this;
                    MuxLogger.exception(th, "MuxStatsEventQueue", "Error sending Beacon Queue");
                    beaconBatchTracker.f252a = true;
                }
            }
            jSONObject.put("events", jSONArray);
            JSONObject jSONObject2 = new JSONObject();
            if (this.roundTripLastSucceeded) {
                jSONObject2.put("rtt_ms", this.roundTripLastCompletedTimeElapsed);
            }
            jSONObject2.put("transmission_timestamp", System.currentTimeMillis());
            jSONObject.put("metadata", jSONObject2);
            if (z) {
                MuxLogger.d("MuxStatsEventQueue", "flush " + size + " events to batch handler");
            } else {
                MuxLogger.d("MuxStatsEventQueue", "submit " + size + " events to batch handler");
            }
            MuxLogger.d("MuxStatsEventQueue", "    [" + ((Object) sb) + "]");
            this.f252a = false;
            this.roundTripStartTime = System.currentTimeMillis();
            beaconBatchTracker = this;
            try {
                this.dispatcher.postWithCompletion(a(this.h, this.d), this.d, jSONObject.toString(), a(this.d), beaconBatchTracker);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                MuxLogger.exception(th, "MuxStatsEventQueue", "Error sending Beacon Queue");
                beaconBatchTracker.f252a = true;
            }
        } catch (Throwable th4) {
            th = th4;
            beaconBatchTracker = this;
        }
    }

    private synchronized boolean a(TrackableEvent trackableEvent) {
        if (this.eventQueue.size() < 3600) {
            if (trackableEvent != null) {
                this.eventQueue.add(trackableEvent);
            }
            if (System.currentTimeMillis() - this.lastBeaconSentTime > getNextBeaconTimeInterval()) {
                a(false);
                this.lastBeaconSentTime = System.currentTimeMillis();
            }
            return this.eventQueue.size() <= 3600;
        }
        MuxLogger.d("MuxStatsEventQueue", "Event not queued, ratelimited: " + this.g + ",queue size: " + this.eventQueue.size() + ", queue limit: 3600");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        a((TrackableEvent) null);
    }

    @Override // com.mux.stats.sdk.core.events.BaseEventListener, com.mux.stats.sdk.core.events.IEventListener
    public void flush() {
        a(true);
    }

    protected long getNextBeaconTimeInterval() {
        int i = this.failureCount;
        return i == 0 ? this.c.f270a : (long) (((Math.pow(2.0d, i - 1) * Math.random()) + 1.0d) * ((double) this.c.f270a));
    }

    @Override // com.mux.stats.sdk.core.events.BaseEventListener, com.mux.stats.sdk.core.events.IEventListener
    public void handle(IEvent iEvent) throws JSONException {
        String playerErrorSeverity;
        TrackableEvent trackableEvent = (TrackableEvent) iEvent;
        if (this.g) {
            MuxLogger.d("MuxStatsEventQueue", "Event not handled, ratelimited: " + this.g + ",queue size: " + this.eventQueue.size() + ", queue limit: 3600");
            return;
        }
        BaseQueryData query = trackableEvent.getQuery();
        String eventType = trackableEvent.getEventType();
        if (eventType.equals(ViewStartEvent.TYPE) || eventType.equals(ViewEndEvent.TYPE) || this.j == null || System.currentTimeMillis() - this.i >= RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS || eventType.equals(RenditionChangeEvent.TYPE)) {
            SimpleBaseQueryData simpleBaseQueryData = new SimpleBaseQueryData();
            this.j = simpleBaseQueryData;
            simpleBaseQueryData.update(query);
            if (eventType.equals(ViewEndEvent.TYPE)) {
                this.j = null;
            }
        } else {
            JSONObject muxDictionary = trackableEvent.getQuery().getMuxDictionary();
            SimpleBaseQueryData simpleBaseQueryData2 = new SimpleBaseQueryData();
            for (String str : muxDictionary.keySet()) {
                if (BaseQueryData.isKeyJsonObject(muxDictionary, str)) {
                    simpleBaseQueryData2.put(str, muxDictionary.getJSONObject(str));
                } else if (BaseQueryData.isKeyJsonArray(muxDictionary, str)) {
                    simpleBaseQueryData2.put(str, muxDictionary.getJSONArray(str));
                } else {
                    String string = muxDictionary.getString(str);
                    if (this.j.get(str) == null || !string.equals(this.j.get(str)) || this.k.contains(str) || trackableEvent.getRequiredProperties().contains(str) || str.equalsIgnoreCase("e") || str.startsWith("q") || str.startsWith("d")) {
                        simpleBaseQueryData2.put(str, string);
                        this.j.put(str, string);
                    }
                }
            }
            query.replace(simpleBaseQueryData2.getMuxDictionary());
        }
        this.i = System.currentTimeMillis();
        boolean zContains = true;
        this.g = !a(trackableEvent);
        if (trackableEvent.getEventType().equals("error")) {
            PlayerData playerData = trackableEvent.getPlayerData();
            if (playerData != null && (playerErrorSeverity = playerData.getPlayerErrorSeverity()) != null && playerErrorSeverity.equals(ErrorEvent.ErrorSeverity.WARNING.toString())) {
                zContains = false;
            }
        } else {
            zContains = this.f.contains(trackableEvent.getEventType());
        }
        if (zContains || this.g) {
            if (this.g) {
                this.eventQueue.add(new EventRateExceedTrackableEvent(trackableEvent));
            }
            flush();
        }
    }

    @Override // com.mux.stats.sdk.muxstats.INetworkRequest.IMuxNetworkRequestsCompletion2
    public void onComplete(boolean z, Map<String, List<String>> map) {
        List<String> list;
        MuxLogger.d("MuxStatsEventQueue", "last batch handler result " + z);
        this.f252a = true;
        if (z) {
            this.roundTripLastCompletedTimeElapsed = System.currentTimeMillis() - this.roundTripStartTime;
            this.roundTripLastSucceeded = true;
            this.failureCount = 0;
            if (map != null && (list = map.get("x-litix-io-beacon-flush-ms")) != null && !list.isEmpty()) {
                try {
                    this.c = a.a(Integer.parseInt(list.get(0)));
                } catch (NumberFormatException unused) {
                }
            }
        } else if (this.eventQueue.size() + this.pendingEventsQueue.size() < 3600) {
            this.eventQueue.addAll(0, this.pendingEventsQueue);
            this.failureCount++;
        } else {
            this.roundTripLastSucceeded = false;
            this.failureCount = 0;
            MuxLogger.d("MuxStatsEventQueue", "event queue too large, dropping events failed to send !!!");
        }
        this.pendingEventsQueue.clear();
    }

    public void release() {
        ScheduledExecutorService scheduledExecutorService = this.e;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            this.e = null;
        }
    }

    public void setVerboseMode(boolean z) {
        this.b = z;
    }
}
