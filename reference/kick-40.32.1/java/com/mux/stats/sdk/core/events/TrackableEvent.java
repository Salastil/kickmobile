package com.mux.stats.sdk.core.events;

import com.mux.stats.sdk.core.model.AdData;
import com.mux.stats.sdk.core.model.BandwidthMetricData;
import com.mux.stats.sdk.core.model.BaseQueryData;
import com.mux.stats.sdk.core.model.CustomData;
import com.mux.stats.sdk.core.model.CustomerPlayerData;
import com.mux.stats.sdk.core.model.CustomerVideoData;
import com.mux.stats.sdk.core.model.CustomerViewData;
import com.mux.stats.sdk.core.model.CustomerViewerData;
import com.mux.stats.sdk.core.model.EnvironmentData;
import com.mux.stats.sdk.core.model.PlayerData;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.model.ViewerData;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nonnull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class TrackableEvent extends BaseEvent {
    public static final String TYPE = "TrackableEvent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f239a;
    private final AnonymousClass1 b;
    private ViewData c;
    private VideoData d;
    private CustomerVideoData e;
    private PlayerData f;
    private CustomerPlayerData g;
    private EnvironmentData h;
    private ViewerData i;
    private BandwidthMetricData j;
    private CustomerViewData k;
    private CustomerViewerData l;
    private AdData m;
    private CustomData n;
    private final Set<String> o;

    public TrackableEvent(String str) {
        this(str, Collections.EMPTY_SET);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.mux.stats.sdk.core.events.TrackableEvent$1] */
    public TrackableEvent(String str, Set<String> set) {
        this.o = Collections.unmodifiableSet(set);
        this.f239a = str;
        this.b = new BaseQueryData() { // from class: com.mux.stats.sdk.core.events.TrackableEvent.1
            @Override // com.mux.stats.sdk.core.model.BaseQueryData
            public final void sync() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                JSONObject jSONObject6 = new JSONObject();
                JSONObject jSONObject7 = new JSONObject();
                JSONObject jSONObject8 = new JSONObject();
                JSONObject jSONObject9 = new JSONObject();
                JSONObject jSONObject10 = new JSONObject();
                JSONObject jSONObject11 = new JSONObject();
                JSONObject jSONObject12 = new JSONObject();
                JSONArray jSONArrayKeys = keys();
                int i = 0;
                while (i < jSONArrayKeys.length()) {
                    String string = jSONArrayKeys.getString(i);
                    JSONArray jSONArray = jSONArrayKeys;
                    if (ViewData.keys.contains(string)) {
                        jSONObject.put(string, this.query.get(string));
                    }
                    if (VideoData.keys.contains(string)) {
                        jSONObject2.put(string, this.query.get(string));
                    }
                    if (CustomerVideoData.keys.contains(string)) {
                        jSONObject3.put(string, this.query.get(string));
                    }
                    if (PlayerData.keys.contains(string)) {
                        jSONObject4.put(string, this.query.get(string));
                    }
                    if (CustomerPlayerData.keys.contains(string)) {
                        jSONObject5.put(string, this.query.get(string));
                    }
                    if (EnvironmentData.keys.contains(string)) {
                        jSONObject6.put(string, this.query.get(string));
                    }
                    if (ViewerData.keys.contains(string)) {
                        jSONObject7.put(string, this.query.get(string));
                    }
                    if (BandwidthMetricData.keys.contains(string)) {
                        jSONObject8.put(string, this.query.get(string));
                    }
                    if (CustomerViewData.keys.contains(string)) {
                        jSONObject9.put(string, this.query.get(string));
                    }
                    if (CustomData.keys.contains(string)) {
                        jSONObject11.put(string, this.query.get(string));
                    }
                    if (CustomerViewerData.keys.contains(string)) {
                        jSONObject10.put(string, this.query.get(string));
                    }
                    if (AdData.keys.contains(string)) {
                        jSONObject12.put(string, this.query.get(string));
                    }
                    i++;
                    jSONArrayKeys = jSONArray;
                }
                if (TrackableEvent.this.c != null) {
                    TrackableEvent.this.c.replace(jSONObject);
                }
                if (TrackableEvent.this.d != null) {
                    TrackableEvent.this.d.replace(jSONObject2);
                }
                if (TrackableEvent.this.e != null) {
                    TrackableEvent.this.e.replace(jSONObject3);
                }
                if (TrackableEvent.this.f != null) {
                    TrackableEvent.this.f.replace(jSONObject4);
                }
                if (TrackableEvent.this.g != null) {
                    TrackableEvent.this.g.replace(jSONObject5);
                }
                if (TrackableEvent.this.h != null) {
                    TrackableEvent.this.h.replace(jSONObject6);
                }
                if (TrackableEvent.this.i != null) {
                    TrackableEvent.this.i.replace(jSONObject7);
                }
                if (TrackableEvent.this.j != null) {
                    TrackableEvent.this.j.replace(jSONObject8);
                }
                if (TrackableEvent.this.k != null) {
                    TrackableEvent.this.k.replace(jSONObject9);
                }
                if (TrackableEvent.this.l != null) {
                    TrackableEvent.this.l.replace(jSONObject9);
                }
                if (TrackableEvent.this.m != null) {
                    TrackableEvent.this.m.replace(jSONObject12);
                }
                if (TrackableEvent.this.n != null) {
                    TrackableEvent.this.n.replace(jSONObject11);
                }
            }
        };
    }

    private void a(BaseQueryData baseQueryData) {
        update(baseQueryData);
    }

    public AdData getAdData() {
        AdData adData = new AdData();
        adData.update(this.m);
        return adData;
    }

    public BandwidthMetricData getBandwidthMetricData() {
        BandwidthMetricData bandwidthMetricData = new BandwidthMetricData();
        bandwidthMetricData.update(this.j);
        return bandwidthMetricData;
    }

    public CustomData getCustomData() {
        CustomData customData = new CustomData();
        customData.update(this.n);
        return customData;
    }

    public CustomerPlayerData getCustomerPlayerData() {
        CustomerPlayerData customerPlayerData = new CustomerPlayerData();
        customerPlayerData.update(this.g);
        return customerPlayerData;
    }

    public CustomerVideoData getCustomerVideoData() {
        CustomerVideoData customerVideoData = new CustomerVideoData();
        customerVideoData.update(this.e);
        return customerVideoData;
    }

    public CustomerViewData getCustomerViewData() {
        CustomerViewData customerViewData = new CustomerViewData();
        customerViewData.update(this.k);
        return customerViewData;
    }

    public CustomerViewerData getCustomerViewerData() {
        CustomerViewerData customerViewerData = new CustomerViewerData();
        customerViewerData.update(this.l);
        return customerViewerData;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getDebugString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        StringBuilder sb = new StringBuilder("TrackableEvent: ");
        String str12 = "";
        if (this.b != null) {
            str = "\n  " + getDebugString();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.c != null) {
            str2 = "\n  " + this.c.getDebugString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.d != null) {
            str3 = "\n  " + this.d.getDebugString();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (this.e != null) {
            str4 = "\n  " + this.e.getDebugString();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (this.f != null) {
            str5 = "\n  " + this.f.getDebugString();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (this.g != null) {
            str6 = "\n  " + this.g.getDebugString();
        } else {
            str6 = "";
        }
        sb.append(str6);
        if (this.k != null) {
            str7 = "\n  " + this.k.getDebugString();
        } else {
            str7 = "";
        }
        sb.append(str7);
        if (this.l != null) {
            str8 = "\n  " + this.l.getDebugString();
        } else {
            str8 = "";
        }
        sb.append(str8);
        if (this.h != null) {
            str9 = "\n  " + this.h.getDebugString();
        } else {
            str9 = "";
        }
        sb.append(str9);
        if (this.j != null) {
            str10 = "\n  " + this.j.getDebugString();
        } else {
            str10 = "";
        }
        sb.append(str10);
        if (this.m != null) {
            str11 = "\n  " + this.m.getDebugString();
        } else {
            str11 = "";
        }
        sb.append(str11);
        if (this.n != null) {
            str12 = "\n  " + this.n.getDebugString();
        }
        sb.append(str12);
        return sb.toString();
    }

    public EnvironmentData getEnvironmentData() {
        EnvironmentData environmentData = new EnvironmentData();
        environmentData.update(this.h);
        return environmentData;
    }

    public String getEventType() {
        return this.f239a;
    }

    public PlayerData getPlayerData() {
        PlayerData playerData = new PlayerData();
        playerData.update(this.f);
        return playerData;
    }

    public BaseQueryData getQuery() {
        return this.b;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    @Nonnull
    public Set<String> getRequiredProperties() {
        return this.o;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }

    public VideoData getVideoData() {
        VideoData videoData = new VideoData();
        videoData.update(this.d);
        return videoData;
    }

    public ViewData getViewData() {
        ViewData viewData = new ViewData();
        viewData.update(this.c);
        return viewData;
    }

    public Integer getViewSequenceNumber() throws JSONException {
        String str = get(ViewData.VIEW_SEQUENCE_NUMBER);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public ViewerData getViewerData() {
        ViewerData viewerData = new ViewerData();
        viewerData.update(this.i);
        return viewerData;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public boolean isTrackable() {
        return true;
    }

    public void setAdData(AdData adData) {
        AdData adData2 = new AdData();
        adData2.update(adData);
        a(adData2);
        this.m = adData2;
    }

    public void setBandwidthMetricData(BandwidthMetricData bandwidthMetricData) {
        BandwidthMetricData bandwidthMetricData2 = new BandwidthMetricData();
        bandwidthMetricData2.update(bandwidthMetricData);
        a(bandwidthMetricData2);
        this.j = bandwidthMetricData2;
    }

    public void setCustomData(CustomData customData) {
        CustomData customData2 = new CustomData();
        customData2.update(customData);
        a(customData2);
        this.n = customData2;
    }

    public void setCustomerPlayerData(CustomerPlayerData customerPlayerData) {
        CustomerPlayerData customerPlayerData2 = new CustomerPlayerData();
        customerPlayerData2.update(customerPlayerData);
        a(customerPlayerData2);
        this.g = customerPlayerData2;
    }

    public void setCustomerVideoData(CustomerVideoData customerVideoData) {
        CustomerVideoData customerVideoData2 = new CustomerVideoData();
        customerVideoData2.update(customerVideoData);
        a(customerVideoData2);
        this.e = customerVideoData2;
    }

    public void setCustomerViewData(CustomerViewData customerViewData) {
        CustomerViewData customerViewData2 = new CustomerViewData();
        customerViewData2.update(customerViewData);
        a(customerViewData2);
        this.k = customerViewData2;
    }

    public void setCustomerViewerData(CustomerViewerData customerViewerData) {
        CustomerViewerData customerViewerData2 = new CustomerViewerData();
        customerViewerData2.update(customerViewerData);
        a(customerViewerData2);
        this.l = customerViewerData2;
    }

    public void setEnvironmentData(EnvironmentData environmentData) {
        EnvironmentData environmentData2 = new EnvironmentData();
        environmentData2.update(environmentData);
        a(environmentData);
        this.h = environmentData2;
    }

    public void setPlayerData(PlayerData playerData) {
        PlayerData playerData2 = new PlayerData();
        playerData2.update(playerData);
        a(playerData2);
        this.f = playerData2;
    }

    public void setVideoData(VideoData videoData) {
        VideoData videoData2 = new VideoData();
        videoData2.update(videoData);
        a(videoData2);
        this.d = videoData2;
    }

    public void setViewData(ViewData viewData) {
        ViewData viewData2 = new ViewData();
        viewData2.update(viewData);
        a(viewData2);
        this.c = viewData2;
    }

    public void setViewerData(ViewerData viewerData) {
        ViewerData viewerData2 = new ViewerData();
        viewerData2.update(viewerData);
        a(viewerData2);
        this.i = viewerData2;
    }

    public String toString() {
        return "TrackableEvent<" + this.f239a + ", " + toString() + ">";
    }
}
