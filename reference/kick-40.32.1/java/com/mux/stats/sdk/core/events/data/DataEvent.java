package com.mux.stats.sdk.core.events.data;

import com.mux.stats.sdk.core.events.BaseEvent;
import com.mux.stats.sdk.core.model.CustomData;
import com.mux.stats.sdk.core.model.CustomerPlayerData;
import com.mux.stats.sdk.core.model.CustomerVideoData;
import com.mux.stats.sdk.core.model.CustomerViewData;
import com.mux.stats.sdk.core.model.CustomerViewerData;
import com.mux.stats.sdk.core.model.EnvironmentData;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.model.ViewerData;

/* JADX INFO: loaded from: classes8.dex */
public class DataEvent extends BaseEvent {
    public static final String TYPE = "dataevent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewerData f242a;
    private EnvironmentData b;
    private VideoData c;
    private CustomerVideoData d;
    private CustomerViewData e;
    private CustomerPlayerData f;
    private CustomerViewerData g;
    private CustomData h;

    public CustomData getCustomData() {
        return this.h;
    }

    public CustomerPlayerData getCustomerPlayerData() {
        return this.f;
    }

    public CustomerVideoData getCustomerVideoData() {
        return this.d;
    }

    public CustomerViewData getCustomerViewData() {
        return this.e;
    }

    public CustomerViewerData getCustomerViewerData() {
        return this.g;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getDebugString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        StringBuilder sb = new StringBuilder("DataEvent: ");
        String str7 = "";
        if (this.f242a != null) {
            str = "\n  " + this.f242a.getDebugString();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.b != null) {
            str2 = "\n  " + this.b.getDebugString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.c != null) {
            str3 = "\n  " + this.c.getDebugString();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (this.d != null) {
            str4 = "\n  " + this.d.getDebugString();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (this.e != null) {
            str5 = "\n  " + this.e.getDebugString();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (this.f != null) {
            str6 = "\n  " + this.f.getDebugString();
        } else {
            str6 = "";
        }
        sb.append(str6);
        if (this.g != null) {
            str7 = "\n  " + this.g.getDebugString();
        }
        sb.append(str7);
        return sb.toString();
    }

    public EnvironmentData getEnvironmentData() {
        return this.b;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }

    public VideoData getVideoData() {
        return this.c;
    }

    public ViewerData getViewerData() {
        return this.f242a;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public boolean isData() {
        return true;
    }

    public void setCustomData(CustomData customData) {
        this.h = customData;
    }

    public void setCustomerPlayerData(CustomerPlayerData customerPlayerData) {
        this.f = customerPlayerData;
    }

    public void setCustomerVideoData(CustomerVideoData customerVideoData) {
        this.d = customerVideoData;
    }

    public void setCustomerViewData(CustomerViewData customerViewData) {
        this.e = customerViewData;
    }

    public void setCustomerViewerData(CustomerViewerData customerViewerData) {
        this.g = customerViewerData;
    }

    public void setEnvironmentData(EnvironmentData environmentData) {
        this.b = environmentData;
    }

    public void setVideoData(VideoData videoData) {
        this.c = videoData;
    }

    public void setViewerData(ViewerData viewerData) {
        this.f242a = viewerData;
    }
}
