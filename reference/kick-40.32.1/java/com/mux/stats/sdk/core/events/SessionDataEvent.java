package com.mux.stats.sdk.core.events;

import com.mux.stats.sdk.core.model.BaseQueryData;
import com.mux.stats.sdk.core.model.CustomData;
import com.mux.stats.sdk.core.model.CustomerPlayerData;
import com.mux.stats.sdk.core.model.CustomerVideoData;
import com.mux.stats.sdk.core.model.CustomerViewData;
import com.mux.stats.sdk.core.model.CustomerViewerData;
import com.mux.stats.sdk.core.model.SessionTag;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.util.MuxLogger;
import com.mux.stats.sdk.core.util.SessionDataKeys;
import com.mux.stats.sdk.core.util.Util;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class SessionDataEvent extends BaseEvent {
    public static final String TYPE = "SessionDataEvent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewData f238a;
    private VideoData b;
    private CustomerVideoData c;
    private CustomerPlayerData d;
    private CustomerViewData e;
    private CustomerViewerData f;
    private CustomData g;

    public SessionDataEvent() {
    }

    public SessionDataEvent(SessionDataEvent sessionDataEvent) {
        this();
        this.f238a = sessionDataEvent.f238a;
        this.b = sessionDataEvent.b;
        this.c = sessionDataEvent.c;
        this.d = sessionDataEvent.d;
        this.e = sessionDataEvent.e;
        this.g = sessionDataEvent.g;
    }

    public SessionDataEvent(List<SessionTag> list) throws JSONException {
        this();
        setSessionData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CustomData a() throws Exception {
        return new CustomData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CustomerViewerData b() throws Exception {
        return new CustomerViewerData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CustomerViewData c() throws Exception {
        return new CustomerViewData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CustomerPlayerData d() throws Exception {
        return new CustomerPlayerData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CustomerVideoData e() throws Exception {
        return new CustomerVideoData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ VideoData f() throws Exception {
        return new VideoData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ViewData g() throws Exception {
        return new ViewData();
    }

    public CustomData getCustomData() {
        return this.g;
    }

    public CustomerPlayerData getCustomerPlayerData() {
        return this.d;
    }

    public CustomerVideoData getCustomerVideoData() {
        return this.c;
    }

    public CustomerViewData getCustomerViewData() {
        return this.e;
    }

    public CustomerViewerData getCustomerViewerData() {
        return this.f;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getDebugString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getDebugString());
        sb.append("\nviewData: ");
        ViewData viewData = this.f238a;
        sb.append(viewData != null ? viewData.getDebugString() : null);
        sb.append("\nvideoData: ");
        VideoData videoData = this.b;
        sb.append(videoData != null ? videoData.getDebugString() : null);
        sb.append("\ncustomerVideoData: ");
        sb.append(this.c != null ? this.e.getDebugString() : null);
        sb.append("\ncustomerPlayerData: ");
        CustomerPlayerData customerPlayerData = this.d;
        sb.append(customerPlayerData != null ? customerPlayerData.getDebugString() : null);
        sb.append("\ncustomerViewData: ");
        CustomerViewData customerViewData = this.e;
        sb.append(customerViewData != null ? customerViewData.getDebugString() : null);
        sb.append("\ncustomData: ");
        CustomData customData = this.g;
        sb.append(customData != null ? customData.getDebugString() : null);
        return sb.toString();
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }

    public VideoData getVideoData() {
        return this.b;
    }

    public ViewData getViewData() {
        return this.f238a;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public boolean isData() {
        return true;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public boolean isSessionData() {
        return true;
    }

    public void setCustomData(CustomData customData) {
        this.g = customData;
    }

    public void setCustomerPlayerData(CustomerPlayerData customerPlayerData) {
        this.d = customerPlayerData;
    }

    public void setCustomerVideoData(CustomerVideoData customerVideoData) {
        this.c = customerVideoData;
    }

    public void setCustomerViewData(CustomerViewData customerViewData) {
        this.e = customerViewData;
    }

    public void setCustomerViewerData(CustomerViewerData customerViewerData) {
        this.f = customerViewerData;
    }

    public void setSessionData(List<SessionTag> list) throws JSONException {
        this.f238a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.c = null;
        this.g = null;
        if (list != null) {
            updateSessionData(list);
        }
    }

    public void setVideoData(VideoData videoData) {
        this.b = videoData;
    }

    public void setViewData(ViewData viewData) {
        this.f238a = viewData;
    }

    public void updateSessionData(List<SessionTag> list) throws JSONException {
        BaseQueryData baseQueryData;
        if (list != null) {
            for (SessionTag sessionTag : list) {
                Class<? extends BaseQueryData> clsType = SessionDataKeys.type(sessionTag.key);
                MuxLogger.w(TYPE, "Data key is " + sessionTag.key + " Data is " + sessionTag);
                if (clsType == null) {
                    MuxLogger.w(TYPE, "Unknown experiment value ignored: " + sessionTag.key);
                } else {
                    MuxLogger.d(TYPE, "Obtained class " + clsType.getSimpleName());
                    if (clsType.equals(ViewData.class)) {
                        ViewData viewData = (ViewData) Util.lazyGet(this.f238a, new Callable() { // from class: com.mux.stats.sdk.core.events.SessionDataEvent$$ExternalSyntheticLambda0
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return SessionDataEvent.g();
                            }
                        });
                        this.f238a = viewData;
                        baseQueryData = viewData;
                    } else if (clsType.equals(VideoData.class)) {
                        VideoData videoData = (VideoData) Util.lazyGet(this.b, new Callable() { // from class: com.mux.stats.sdk.core.events.SessionDataEvent$$ExternalSyntheticLambda1
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return SessionDataEvent.f();
                            }
                        });
                        this.b = videoData;
                        baseQueryData = videoData;
                    } else if (clsType.equals(CustomerVideoData.class)) {
                        CustomerVideoData customerVideoData = (CustomerVideoData) Util.lazyGet(this.c, new Callable() { // from class: com.mux.stats.sdk.core.events.SessionDataEvent$$ExternalSyntheticLambda2
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return SessionDataEvent.e();
                            }
                        });
                        this.c = customerVideoData;
                        baseQueryData = customerVideoData;
                    } else if (clsType.equals(CustomerPlayerData.class)) {
                        CustomerPlayerData customerPlayerData = (CustomerPlayerData) Util.lazyGet(this.d, new Callable() { // from class: com.mux.stats.sdk.core.events.SessionDataEvent$$ExternalSyntheticLambda3
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return SessionDataEvent.d();
                            }
                        });
                        this.d = customerPlayerData;
                        baseQueryData = customerPlayerData;
                    } else if (clsType.equals(CustomerViewData.class)) {
                        CustomerViewData customerViewData = (CustomerViewData) Util.lazyGet(this.e, new Callable() { // from class: com.mux.stats.sdk.core.events.SessionDataEvent$$ExternalSyntheticLambda4
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return SessionDataEvent.c();
                            }
                        });
                        this.e = customerViewData;
                        baseQueryData = customerViewData;
                    } else if (clsType.equals(CustomerViewerData.class)) {
                        CustomerViewerData customerViewerData = (CustomerViewerData) Util.lazyGet(this.f, new Callable() { // from class: com.mux.stats.sdk.core.events.SessionDataEvent$$ExternalSyntheticLambda5
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return SessionDataEvent.b();
                            }
                        });
                        this.f = customerViewerData;
                        baseQueryData = customerViewerData;
                    } else if (clsType.equals(CustomData.class)) {
                        CustomData customData = (CustomData) Util.lazyGet(this.g, new Callable() { // from class: com.mux.stats.sdk.core.events.SessionDataEvent$$ExternalSyntheticLambda6
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return SessionDataEvent.a();
                            }
                        });
                        this.g = customData;
                        baseQueryData = customData;
                    } else {
                        MuxLogger.d(TYPE, "Unknown session data with key [" + sessionTag.key + "] was ignored");
                    }
                    baseQueryData.put(SessionDataKeys.shortCode(sessionTag.key), sessionTag.value);
                }
            }
        }
    }
}
