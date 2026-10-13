package com.mux.stats.sdk.muxstats;

import com.facebook.hermes.intl.Constants;
import com.mux.stats.sdk.core.Core;
import com.mux.stats.sdk.core.CorePlayer;
import com.mux.stats.sdk.core.CustomOptions;
import com.mux.stats.sdk.core.MuxSDKViewOrientation;
import com.mux.stats.sdk.core.events.BaseEvent;
import com.mux.stats.sdk.core.events.BaseEventListener;
import com.mux.stats.sdk.core.events.IEvent;
import com.mux.stats.sdk.core.events.InternalErrorEvent;
import com.mux.stats.sdk.core.events.SessionDataEvent;
import com.mux.stats.sdk.core.events.data.DataEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakEndEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakStartEvent;
import com.mux.stats.sdk.core.events.playback.AdEndedEvent;
import com.mux.stats.sdk.core.events.playback.AdErrorEvent;
import com.mux.stats.sdk.core.events.playback.AdEvent;
import com.mux.stats.sdk.core.events.playback.AdFirstQuartileEvent;
import com.mux.stats.sdk.core.events.playback.AdMidpointEvent;
import com.mux.stats.sdk.core.events.playback.AdPauseEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayingEvent;
import com.mux.stats.sdk.core.events.playback.AdRequestEvent;
import com.mux.stats.sdk.core.events.playback.AdResponseEvent;
import com.mux.stats.sdk.core.events.playback.AdThirdQuartileEvent;
import com.mux.stats.sdk.core.events.playback.CdnChangeEvent;
import com.mux.stats.sdk.core.events.playback.EndedEvent;
import com.mux.stats.sdk.core.events.playback.ErrorEvent;
import com.mux.stats.sdk.core.events.playback.NetworkChangeEvent;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import com.mux.stats.sdk.core.events.playback.PlayEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackModeChangeEvent;
import com.mux.stats.sdk.core.events.playback.PlayerReadyEvent;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import com.mux.stats.sdk.core.events.playback.RebufferEndEvent;
import com.mux.stats.sdk.core.events.playback.RebufferStartEvent;
import com.mux.stats.sdk.core.events.playback.RenditionChangeEvent;
import com.mux.stats.sdk.core.events.playback.RequestCanceled;
import com.mux.stats.sdk.core.events.playback.RequestCompleted;
import com.mux.stats.sdk.core.events.playback.RequestFailed;
import com.mux.stats.sdk.core.events.playback.Sampling;
import com.mux.stats.sdk.core.events.playback.SeekedEvent;
import com.mux.stats.sdk.core.events.playback.SeekingEvent;
import com.mux.stats.sdk.core.events.playback.TimeUpdateEvent;
import com.mux.stats.sdk.core.events.playback.ViewEndEvent;
import com.mux.stats.sdk.core.events.playback.ViewInitEvent;
import com.mux.stats.sdk.core.model.BandwidthMetricData;
import com.mux.stats.sdk.core.model.BaseQueryData;
import com.mux.stats.sdk.core.model.CustomerData;
import com.mux.stats.sdk.core.model.CustomerPlayerData;
import com.mux.stats.sdk.core.model.CustomerVideoData;
import com.mux.stats.sdk.core.model.CustomerViewData;
import com.mux.stats.sdk.core.model.EnvironmentData;
import com.mux.stats.sdk.core.model.PlaybackMode;
import com.mux.stats.sdk.core.model.PlayerData;
import com.mux.stats.sdk.core.model.SessionTag;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.core.model.ViewData;
import com.mux.stats.sdk.core.model.ViewerData;
import com.mux.stats.sdk.core.util.MuxLogger;
import com.mux.stats.sdk.core.util.Util;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class MuxStats extends BaseEventListener {
    private static IDevice A = null;
    private static INetworkRequest B = null;
    protected static final int MAX_PIXEL_SIZE = 1048576;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Timer f278a;
    private String b;
    private CustomerData c;
    private Integer d;
    private Integer e;
    private Integer f;
    private Integer g;
    private boolean h;
    private VideoData i;
    private ViewerData j;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private boolean o;
    private MuxSDKViewPresentation p;
    private ErrorEventTranslating q;
    private String r;
    private String s;
    private String t;
    private boolean u;
    private CustomOptions v;
    private CorePlayer w;
    private IPlayerListener x;

    @Nullable
    private String y;

    @Nullable
    private Boolean z;

    public interface ErrorEventTranslating {
        void translateErrorEvent(ErrorEvent errorEvent);
    }

    private static class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<MuxStats> f279a;
        private final WeakReference<Timer> b;

        public a(MuxStats muxStats, Timer timer) {
            this.f279a = new WeakReference<>(muxStats);
            this.b = new WeakReference<>(timer);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            MuxStats muxStats = this.f279a.get();
            if (muxStats == null) {
                Timer timer = this.b.get();
                if (timer != null) {
                    timer.cancel();
                    timer.purge();
                    return;
                }
                return;
            }
            try {
                if (muxStats.x.getPaused()) {
                    return;
                }
                MuxStats.b(muxStats);
            } catch (Throwable th) {
                MuxLogger.exception(th, "MuxStats", "Exception terminated timer task", muxStats.c);
                muxStats.release();
            }
        }
    }

    public MuxStats(IPlayerListener iPlayerListener, String str, CustomerData customerData) {
        this(iPlayerListener, str, customerData, new CustomOptions());
    }

    public MuxStats(IPlayerListener iPlayerListener, String str, CustomerData customerData, CustomOptions customOptions) {
        this.i = new VideoData();
        this.c = customerData;
        this.b = str;
        this.u = true;
        this.o = false;
        this.v = customOptions;
        this.h = true;
        if (customOptions == null) {
            throw new IllegalArgumentException("customOptions cannot be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("playerName cannot be null");
        }
        if (customerData == null || customerData.getCustomerPlayerData() == null) {
            throw new IllegalArgumentException("customerPlayerData cannot be null");
        }
        this.w = Core.createPlayer(this.b, this.v);
        this.m = 0L;
        this.x = iPlayerListener;
        b();
        PlayerData playerData = getPlayerData();
        a(new ViewInitEvent(playerData));
        Timer timer = new Timer();
        this.f278a = timer;
        timer.scheduleAtFixedRate(new a(this, this.f278a), 0L, 100L);
        this.i = new VideoData();
        DataEvent dataEvent = new DataEvent();
        CustomerData customerData2 = this.c;
        if (customerData2 != null && customerData2.getCustomerPlayerData() != null) {
            dataEvent.setCustomerPlayerData(this.c.getCustomerPlayerData());
        }
        CustomerData customerData3 = this.c;
        if (customerData3 != null && customerData3.getCustomerVideoData() != null) {
            dataEvent.setCustomerVideoData(this.c.getCustomerVideoData());
        }
        CustomerData customerData4 = this.c;
        if (customerData4 != null && customerData4.getCustomerViewData() != null) {
            dataEvent.setCustomerViewData(this.c.getCustomerViewData());
        }
        CustomerData customerData5 = this.c;
        if (customerData5 != null && customerData5.getCustomData() != null) {
            dataEvent.setCustomData(this.c.getCustomData());
        }
        CustomerData customerData6 = this.c;
        if (customerData6 != null && customerData6.getCustomerViewerData() != null) {
            dataEvent.setCustomerViewerData(this.c.getCustomerViewerData());
        }
        CustomerData customerData7 = this.c;
        if (customerData7 != null && (customerData7.getCustomerPlayerData() != null || this.c.getCustomerVideoData() != null || this.c.getCustomerViewData() != null || this.c.getCustomData() != null || this.c.getCustomerViewerData() != null)) {
            a(dataEvent);
        }
        a(new PlayerReadyEvent(playerData));
        a();
    }

    @Deprecated
    public MuxStats(IPlayerListener iPlayerListener, String str, CustomerData customerData, boolean z) {
        this(iPlayerListener, str, customerData, new CustomOptions());
    }

    @Deprecated
    public MuxStats(IPlayerListener iPlayerListener, String str, CustomerPlayerData customerPlayerData, CustomerVideoData customerVideoData) {
        this(iPlayerListener, str, customerPlayerData, customerVideoData, null, true);
    }

    @Deprecated
    public MuxStats(IPlayerListener iPlayerListener, String str, CustomerPlayerData customerPlayerData, CustomerVideoData customerVideoData, CustomerViewData customerViewData) {
        this(iPlayerListener, str, customerPlayerData, customerVideoData, customerViewData, true);
    }

    @Deprecated
    public MuxStats(IPlayerListener iPlayerListener, String str, CustomerPlayerData customerPlayerData, CustomerVideoData customerVideoData, CustomerViewData customerViewData, boolean z) {
        this(iPlayerListener, str, new CustomerData(customerPlayerData, customerVideoData, customerViewData));
    }

    private static int a(int i, int i2, int i3) {
        if (i > 1048576) {
            return 1048576;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    private static PlaybackEvent a(PlaybackEvent playbackEvent) throws JSONException {
        if (playbackEvent.getViewData() != null) {
            playbackEvent.getViewData().setViewProgramChanged(Boolean.TRUE);
            return playbackEvent;
        }
        ViewData viewData = new ViewData();
        viewData.setViewProgramChanged(Boolean.TRUE);
        playbackEvent.setViewData(viewData);
        return playbackEvent;
    }

    private void a() {
        a(PlaybackMode.STANDARD.getModeValue(), null);
        IDevice iDevice = A;
        if (iDevice != null) {
            handle(new NetworkChangeEvent(getPlayerData(), (String) Util.lazyGet(iDevice.getNetworkConnectionType(), new Callable() { // from class: com.mux.stats.sdk.muxstats.MuxStats$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return MuxStats.e();
                }
            }), A.getIsNetworkInLowDataMode()));
        }
    }

    private void a(BaseEvent baseEvent) {
        ErrorEventTranslating errorEventTranslating;
        if (this.h) {
            try {
                if (baseEvent.getType().equalsIgnoreCase("error") && (errorEventTranslating = this.q) != null) {
                    errorEventTranslating.translateErrorEvent((ErrorEvent) baseEvent);
                }
                if (baseEvent.isPlayback()) {
                    ViewData viewData = ((PlaybackEvent) baseEvent).getViewData();
                    if (viewData == null) {
                        viewData = new ViewData();
                    }
                    viewData.setViewDroppedFrames(Long.valueOf(this.m));
                    ((PlaybackEvent) baseEvent).setViewData(viewData);
                }
                Core.dispatchEventForPlayer(this.b, baseEvent);
            } catch (Throwable th) {
                MuxLogger.exception(th, "MuxStats", "Failed to dispatch event: " + baseEvent + ", for player name: " + this.b);
                CustomerData customerData = this.c;
                if (customerData == null || customerData.getCustomerPlayerData() == null) {
                    return;
                }
                MuxLogger.exception(th, "MuxStats", "Failed to dispatch player event: " + baseEvent);
            }
        }
    }

    private void a(CustomerData customerData) {
        this.z = null;
        this.y = null;
        a(new ViewInitEvent(getPlayerData()));
        this.c = customerData;
        DataEvent dataEvent = new DataEvent();
        if (this.c.getCustomerVideoData() != null) {
            dataEvent.setCustomerVideoData(this.c.getCustomerVideoData());
        }
        if (this.c.getCustomData() != null) {
            dataEvent.setCustomData(this.c.getCustomData());
        }
        if (this.c.getCustomerViewData() != null) {
            dataEvent.setCustomerViewData(this.c.getCustomerViewData());
        }
        VideoData videoData = new VideoData();
        this.i = videoData;
        dataEvent.setVideoData(videoData);
        a(dataEvent);
        a();
    }

    private void a(String str, @Nullable JSONObject jSONObject) {
        PlayerData playerData = getPlayerData();
        playerData.setPlayerPlaybackMode(str);
        if (jSONObject != null) {
            playerData.setPlayerPlaybackModeData(jSONObject.toString());
        }
        handle(new PlaybackModeChangeEvent(playerData));
    }

    private boolean a(@Nullable String str) {
        String str2 = this.y;
        if (str != null) {
            return !str.equals(str2);
        }
        return str2 != null;
    }

    private void b() {
        try {
            EnvironmentData environmentData = new EnvironmentData();
            IDevice iDevice = A;
            if (iDevice != null) {
                this.r = iDevice.getDeviceId();
                this.s = A.getAppName();
                this.t = A.getAppVersion();
            }
            String str = this.r;
            if (str != null) {
                environmentData.setMuxViewerId(str);
            }
            ViewerData viewerData = new ViewerData();
            IDevice iDevice2 = A;
            if (iDevice2 != null) {
                viewerData.setViewerOsFamily(iDevice2.getOSFamily());
                viewerData.setViewerOsArchitecture(A.getHardwareArchitecture());
                viewerData.setViewerOsVersion(A.getOSVersion());
                viewerData.setViewerDeviceManufacturer(A.getManufacturer());
                viewerData.setViewerDeviceModel(A.getModelName());
                viewerData.setViewerDeviceName(A.getDeviceName());
                viewerData.setViewerDeviceCategory(A.getDeviceCategory());
                viewerData.setViewerConnectionType((String) Util.lazyGet(A.getNetworkConnectionType(), new Callable() { // from class: com.mux.stats.sdk.muxstats.MuxStats$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return MuxStats.d();
                    }
                }));
            }
            String str2 = this.s;
            if (str2 != null) {
                viewerData.setViewerApplicationName(str2);
            }
            String str3 = this.t;
            if (str3 != null) {
                viewerData.setViewerApplicationVersion(str3);
            }
            DataEvent dataEvent = new DataEvent();
            dataEvent.setEnvironmentData(environmentData);
            dataEvent.setViewerData(viewerData);
            Core.dispatchDataEvent(dataEvent);
            this.j = viewerData;
        } catch (Throwable th) {
            MuxLogger.exception(th, "MuxStats", "Exception caught preparing environment", this.c);
        }
    }

    static /* synthetic */ void b(MuxStats muxStats) {
        muxStats.handle(new TimeUpdateEvent(null));
    }

    private void c() throws JSONException {
        boolean z;
        IPlayerListener iPlayerListener = this.x;
        if (iPlayerListener == null) {
            return;
        }
        if (iPlayerListener.getVideoHoldback() != null && this.x.getVideoHoldback().longValue() != -1) {
            this.i.setVideoHoldback(this.x.getVideoHoldback());
        }
        if (this.x.getVideoPartHoldback() != null && this.x.getVideoPartHoldback().longValue() != -1) {
            this.i.setVideoPartHoldback(this.x.getVideoPartHoldback());
        }
        if (this.x.getVideoPartTargetDuration() != null && this.x.getVideoPartTargetDuration().longValue() != -1) {
            this.i.setVideoPartTargetDuration(this.x.getVideoPartTargetDuration());
        }
        if (this.x.getVideoTargetDuration() != null && this.x.getVideoTargetDuration().longValue() != -1) {
            this.i.setVideoTargetDuration(this.x.getVideoTargetDuration());
        }
        boolean z2 = true;
        if (this.x.getSourceWidth() == null || this.x.getSourceWidth().equals(this.i.getVideoSourceWidth())) {
            z = false;
        } else {
            this.i.setVideoSourceWidth(this.x.getSourceWidth());
            z = true;
        }
        if (this.x.getSourceHeight() != null && !this.x.getSourceHeight().equals(this.i.getVideoSourceHeight())) {
            this.i.setVideoSourceHeight(this.x.getSourceHeight());
            z = true;
        }
        if (this.x.getMimeType() != null && this.i.getVideoSourceMimeType() != this.x.getMimeType()) {
            this.i.setVideoSourceMimeType(this.x.getMimeType());
            z = true;
        }
        if (this.x.getSourceDurationMs() != null && this.i.getVideoSourceDuration() != this.x.getSourceDurationMs()) {
            this.i.setVideoSourceDuration(this.x.getSourceDurationMs());
            z = true;
        }
        if (this.x.getSourceAdvertisedBitrate() != null && this.i.getVideoSourceAdvertisedBitrate() != this.x.getSourceAdvertisedBitrate()) {
            this.i.setVideoSourceAdvertisedBitrate(this.x.getSourceAdvertisedBitrate());
            z = true;
        }
        if (this.x.getSourceAdvertisedFramerate() != null && this.i.getVideoSourceAdvertisedFramerate() != this.x.getSourceAdvertisedFramerate()) {
            this.i.setVideoSourceAdvertisedFramerate(this.x.getSourceAdvertisedFramerate());
            z = true;
        }
        if (this.x.getSourceCodec() == null || this.i.getVideoSourceCodec() == this.x.getSourceCodec()) {
            z2 = z;
        } else {
            this.i.setVideoSourceCodec(this.x.getSourceCodec());
        }
        if (z2) {
            DataEvent dataEvent = new DataEvent();
            dataEvent.setVideoData(this.i);
            a(dataEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String d() throws Exception {
        return "no_connection";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e() throws Exception {
        return "no_connection";
    }

    public static IDevice getHostDevice() {
        return A;
    }

    public static INetworkRequest getHostNetworkApi() {
        return B;
    }

    public static void setHostDevice(IDevice iDevice) {
        A = iDevice;
    }

    public static void setHostNetworkApi(INetworkRequest iNetworkRequest) {
        B = iNetworkRequest;
    }

    public void allowLogcatOutput(boolean z, boolean z2) {
        Core.allowLogcatOutputForPlayer(this.b, z, z2);
    }

    public void disable() {
        a((BaseEvent) new ViewEndEvent(getPlayerData()));
        this.h = false;
    }

    public void enable(CustomerData customerData) {
        this.h = true;
        a(customerData);
    }

    public void error(MuxErrorException muxErrorException) throws JSONException {
        MuxLogger.d("MuxStats", "external error (" + muxErrorException.getErrorCode() + "): " + muxErrorException.getMessage());
        c();
        PlayerData playerData = getPlayerData();
        playerData.setPlayerErrorMessage(muxErrorException.getMessage());
        playerData.setPlayerErrorCode(muxErrorException.getErrorCode());
        playerData.setPlayerErrorContext(muxErrorException.getContext());
        a((BaseEvent) new ErrorEvent(playerData));
    }

    public void error(String str, String str2, String str3) {
        PlayerData playerData = getPlayerData();
        playerData.setPlayerErrorCode(str);
        playerData.setPlayerErrorMessage(str2);
        a((BaseEvent) new ErrorEvent(playerData, str3));
    }

    public void error(String str, String str2, String str3, ErrorEvent.ErrorSeverity errorSeverity, boolean z) {
        PlayerData playerData = getPlayerData();
        playerData.setPlayerErrorCode(str);
        playerData.setPlayerErrorMessage(str2);
        a((BaseEvent) new ErrorEvent(playerData, str3, errorSeverity, z));
    }

    public String getBeaconDomain() {
        return this.v.getBeaconDomain();
    }

    protected CorePlayer getCorePlayer() {
        return this.w;
    }

    public CustomerData getCustomerData() {
        return this.c;
    }

    @Deprecated
    public CustomerPlayerData getCustomerPlayerData() {
        CustomerData customerData = this.c;
        if (customerData != null) {
            return customerData.getCustomerPlayerData();
        }
        return null;
    }

    @Deprecated
    public CustomerVideoData getCustomerVideoData() {
        CustomerData customerData = this.c;
        if (customerData != null) {
            return customerData.getCustomerVideoData();
        }
        return null;
    }

    @Deprecated
    public CustomerViewData getCustomerViewData() {
        CustomerData customerData = this.c;
        if (customerData != null) {
            return customerData.getCustomerViewData();
        }
        return null;
    }

    protected long getDroppedFrames() {
        return this.m;
    }

    public ErrorEventTranslating getErrorEventTranslating() {
        return this.q;
    }

    protected PlayerData getPlayerData() {
        PlayerData playerData = new PlayerData();
        IDevice hostDevice = getHostDevice();
        if (hostDevice != null) {
            playerData.setPlayerMuxPluginName(hostDevice.getPluginName());
            playerData.setPlayerMuxPluginVersion(hostDevice.getPluginVersion());
            playerData.setPlayerSoftwareName(hostDevice.getPlayerSoftware());
        }
        IDevice iDevice = A;
        if (iDevice != null) {
            playerData.setPlayerSoftwareVersion(iDevice.getPlayerVersion());
        }
        IPlayerListener iPlayerListener = this.x;
        if (iPlayerListener != null) {
            playerData.setPlayerIsPaused(Boolean.valueOf(iPlayerListener.getPaused()));
            playerData.setPlayerPlayheadTime(Long.valueOf(this.x.getCurrentPositionMs()));
            if (this.x.getPlayerProgramTime() != null && this.x.getPlayerProgramTime().longValue() != -1) {
                playerData.setPlayerProgramTime(this.x.getPlayerProgramTime());
            }
            if (this.x.getPlayerManifestNewestTime() != null && this.x.getPlayerManifestNewestTime().longValue() != -1) {
                playerData.setPlayerManifestNewestProgramTime(this.x.getPlayerManifestNewestTime());
            }
            if (!this.o) {
                this.d = Integer.valueOf(a(this.x.getPlayerViewWidth(), 0, 1048576));
                this.e = Integer.valueOf(a(this.x.getPlayerViewHeight(), 0, 1048576));
            }
            MuxSDKViewPresentation muxSDKViewPresentation = this.p;
            if (muxSDKViewPresentation == null) {
                Integer num = this.e;
                if (num != null && this.d != null) {
                    playerData.setPlayerHeight(num);
                    playerData.setPlayerWidth(this.d);
                    Integer num2 = this.g;
                    if (num2 != null && this.f != null) {
                        if ((num2.intValue() > this.e.intValue() || this.f.intValue() > this.d.intValue()) && (this.f.intValue() > this.e.intValue() || this.g.intValue() > this.d.intValue())) {
                            playerData.setPlayerIsFullscreen(Constants.CASEFIRST_FALSE);
                            return playerData;
                        }
                        playerData.setPlayerIsFullscreen("true");
                        return playerData;
                    }
                }
            } else {
                playerData.setPlayerIsFullscreen(String.valueOf(muxSDKViewPresentation == MuxSDKViewPresentation.FULLSCREEN));
                Integer num3 = this.e;
                if (num3 != null && this.d != null) {
                    playerData.setPlayerHeight(num3);
                    playerData.setPlayerWidth(this.d);
                }
            }
        }
        return playerData;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x02d0 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:118:0x02d2 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x02da A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x02e5 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x02ed A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x02f8 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0300 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x030b A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0313 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x031e A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0326 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0331 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0339 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0343 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x034b A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0355 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x035d A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0367 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x036f A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0379 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0381 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x038b A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0393 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x039d A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x03a5 A[Catch: all -> 0x03f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:10:0x0016, B:12:0x001f, B:14:0x0023, B:17:0x002c, B:18:0x0034, B:158:0x03df, B:160:0x03e3, B:20:0x0039, B:115:0x02c5, B:116:0x02cd, B:118:0x02d2, B:120:0x02da, B:154:0x03ae, B:34:0x008b, B:121:0x02e5, B:123:0x02ed, B:124:0x02f8, B:126:0x0300, B:127:0x030b, B:129:0x0313, B:130:0x031e, B:132:0x0326, B:133:0x0331, B:135:0x0339, B:136:0x0343, B:138:0x034b, B:139:0x0355, B:141:0x035d, B:142:0x0367, B:144:0x036f, B:145:0x0379, B:147:0x0381, B:148:0x038b, B:150:0x0393, B:151:0x039d, B:153:0x03a5, B:23:0x0043, B:25:0x004b, B:26:0x0054, B:27:0x0059, B:29:0x0061, B:30:0x006e, B:32:0x0076, B:33:0x0088, B:35:0x0090, B:37:0x0098, B:39:0x00a7, B:40:0x00aa, B:41:0x00b0, B:43:0x00b8, B:44:0x00f8, B:46:0x0100, B:47:0x010e, B:50:0x0118, B:53:0x0122, B:56:0x012c, B:58:0x0134, B:59:0x0153, B:62:0x015d, B:64:0x0165, B:65:0x0173, B:67:0x017b, B:68:0x019a, B:70:0x01a2, B:71:0x01b0, B:73:0x01b8, B:74:0x01c6, B:77:0x01d0, B:79:0x01d8, B:80:0x01e9, B:83:0x01f3, B:85:0x01fb, B:86:0x020f, B:88:0x0217, B:89:0x0225, B:91:0x022d, B:92:0x0257, B:94:0x025f, B:95:0x026d, B:98:0x0276, B:101:0x027f, B:104:0x0288, B:106:0x0290, B:107:0x029e, B:110:0x02a7, B:112:0x02af, B:113:0x02bd, B:155:0x03c3, B:157:0x03cb), top: B:166:0x0001 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.mux.stats.sdk.core.events.BaseEventListener, com.mux.stats.sdk.core.events.IEventListener
    public synchronized void handle(IEvent iEvent) {
        PlaybackEvent requestCanceled;
        BandwidthMetricData bandwidthMetricData;
        BaseEvent renditionChangeEvent;
        String type;
        if (!iEvent.isPlayback() && !iEvent.isError()) {
            MuxLogger.d("MuxStats", "unexpected internal event");
            return;
        }
        Core.restoreProtectedValues();
        if (iEvent.isError() && !this.u) {
            MuxLogger.d("MuxStats", "error detected, but automatic error reporting is disabled");
            return;
        }
        String type2 = iEvent.getType();
        switch (type2.hashCode()) {
            case -1893763032:
                if (type2.equals(RequestCanceled.TYPE)) {
                    c();
                    requestCanceled = new RequestCanceled(getPlayerData());
                    bandwidthMetricData = ((PlaybackEvent) iEvent).getBandwidthMetricData();
                    requestCanceled.setBandwidthMetricData(bandwidthMetricData);
                    a((BaseEvent) requestCanceled);
                }
                break;
            case -1535613269:
                if (type2.equals(AdPlayingEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case -1519101404:
                if (type2.equals(RenditionChangeEvent.TYPE)) {
                    c();
                    renditionChangeEvent = new RenditionChangeEvent(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case -1422144041:
                if (type2.equals(AdPlayEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case -1300510776:
                if (type2.equals(RebufferEndEvent.TYPE)) {
                    c();
                    renditionChangeEvent = new RebufferEndEvent(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case -1146889097:
                if (type2.equals(AdEndedEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case -1146756155:
                if (type2.equals(AdErrorEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case -1137100877:
                if (type2.equals(AdPauseEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case -906224361:
                if (type2.equals(SeekedEvent.TYPE)) {
                    c();
                    renditionChangeEvent = new SeekedEvent(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case -500460706:
                if (type2.equals(NetworkChangeEvent.TYPE)) {
                    c();
                    requestCanceled = new NetworkChangeEvent(getPlayerData());
                    ViewerData viewerData = new ViewerData();
                    viewerData.update(((PlaybackEvent) iEvent).getViewerData());
                    requestCanceled.setViewerData(viewerData);
                    DataEvent dataEvent = new DataEvent();
                    dataEvent.setViewerData(viewerData);
                    Core.dispatchDataEvent(dataEvent);
                    a((BaseEvent) requestCanceled);
                }
                break;
            case -493563858:
                if (type2.equals(PlayingEvent.TYPE)) {
                    c();
                    requestCanceled = new PlayingEvent(getPlayerData());
                    a((BaseEvent) requestCanceled);
                }
                break;
            case -456624996:
                if (type2.equals(RequestCompleted.TYPE)) {
                    c();
                    requestCanceled = new RequestCompleted(getPlayerData());
                    bandwidthMetricData = ((PlaybackEvent) iEvent).getBandwidthMetricData();
                    requestCanceled.setBandwidthMetricData(bandwidthMetricData);
                    a((BaseEvent) requestCanceled);
                }
                break;
            case -215092057:
                if (type2.equals(AdThirdQuartileEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case 3443508:
                if (type2.equals(PlayEvent.TYPE)) {
                    c();
                    this.n = true;
                    renditionChangeEvent = new PlayEvent(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case 53643532:
                if (type2.equals(AdRequestEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case 57736207:
                if (type2.equals(RebufferStartEvent.TYPE)) {
                    c();
                    renditionChangeEvent = new RebufferStartEvent(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case 96651962:
                if (type2.equals(EndedEvent.TYPE)) {
                    c();
                    renditionChangeEvent = new EndedEvent(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case 96784904:
                if (type2.equals("error")) {
                    c();
                    PlayerData playerData = new PlayerData();
                    playerData.update(getPlayerData());
                    playerData.update(((PlaybackEvent) iEvent).getPlayerData());
                    renditionChangeEvent = new ErrorEvent(playerData);
                    a(renditionChangeEvent);
                }
                break;
            case 106440182:
                if (type2.equals(PauseEvent.TYPE)) {
                    c();
                    renditionChangeEvent = new PauseEvent(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case 417371499:
                if (type2.equals(AdMidpointEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case 1412496925:
                if (type2.equals(CdnChangeEvent.TYPE)) {
                    c();
                    requestCanceled = new CdnChangeEvent(getPlayerData());
                    VideoData videoData = new VideoData();
                    videoData.update(((PlaybackEvent) iEvent).getVideoData());
                    requestCanceled.setVideoData(videoData);
                    a((BaseEvent) requestCanceled);
                }
                break;
            case 1651552038:
                if (type2.equals(AdBreakStartEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case 1682958576:
                if (type2.equals(AdFirstQuartileEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case 1715883364:
                if (type2.equals(AdResponseEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
            case 1762557398:
                if (type2.equals(TimeUpdateEvent.TYPE)) {
                    c();
                    renditionChangeEvent = new TimeUpdateEvent(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case 1832171883:
                if (type2.equals(InternalErrorEvent.TYPE)) {
                    InternalErrorEvent internalErrorEvent = (InternalErrorEvent) iEvent;
                    PlayerData playerData2 = getPlayerData();
                    playerData2.setPlayerErrorMessage(internalErrorEvent.getErrorMessage());
                    playerData2.setPlayerErrorCode(String.valueOf(internalErrorEvent.getErrorCode()));
                    playerData2.setPlayerErrorContext(internalErrorEvent.getErrorContext());
                    MuxLogger.d("MuxStats", "internal error: " + internalErrorEvent.getErrorMessage());
                    c();
                    renditionChangeEvent = new ErrorEvent(playerData2);
                    a(renditionChangeEvent);
                }
                break;
            case 1927313262:
                if (type2.equals(PlaybackModeChangeEvent.TYPE)) {
                    c();
                    PlayerData playerData3 = getPlayerData();
                    BaseQueryData playerData4 = ((PlaybackEvent) iEvent).getPlayerData();
                    if (playerData4 != null) {
                        playerData3.update(playerData4);
                    }
                    renditionChangeEvent = new PlaybackModeChangeEvent(playerData3);
                    a(renditionChangeEvent);
                }
                break;
            case 1929584524:
                if (type2.equals(RequestFailed.TYPE)) {
                    c();
                    requestCanceled = new RequestFailed(getPlayerData());
                    bandwidthMetricData = ((PlaybackEvent) iEvent).getBandwidthMetricData();
                    requestCanceled.setBandwidthMetricData(bandwidthMetricData);
                    a((BaseEvent) requestCanceled);
                }
                break;
            case 1971820138:
                if (type2.equals(SeekingEvent.TYPE)) {
                    c();
                    renditionChangeEvent = new SeekingEvent(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case 1975570407:
                if (type2.equals(Sampling.TYPE)) {
                    renditionChangeEvent = new Sampling(getPlayerData());
                    a(renditionChangeEvent);
                }
                break;
            case 2133546143:
                if (type2.equals(AdBreakEndEvent.TYPE)) {
                    type = iEvent.getType();
                    switch (type.hashCode()) {
                        case -1535613269:
                            if (type.equals(AdPlayingEvent.TYPE)) {
                                requestCanceled = new AdPlayingEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1422144041:
                            if (type.equals(AdPlayEvent.TYPE)) {
                                requestCanceled = new AdPlayEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146889097:
                            if (type.equals(AdEndedEvent.TYPE)) {
                                requestCanceled = new AdEndedEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1146756155:
                            if (type.equals(AdErrorEvent.TYPE)) {
                                requestCanceled = new AdErrorEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -1137100877:
                            if (type.equals(AdPauseEvent.TYPE)) {
                                requestCanceled = new AdPauseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case -215092057:
                            if (type.equals(AdThirdQuartileEvent.TYPE)) {
                                requestCanceled = new AdThirdQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 53643532:
                            if (type.equals(AdRequestEvent.TYPE)) {
                                requestCanceled = new AdRequestEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 417371499:
                            if (type.equals(AdMidpointEvent.TYPE)) {
                                requestCanceled = new AdMidpointEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1651552038:
                            if (type.equals(AdBreakStartEvent.TYPE)) {
                                requestCanceled = new AdBreakStartEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1682958576:
                            if (type.equals(AdFirstQuartileEvent.TYPE)) {
                                requestCanceled = new AdFirstQuartileEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 1715883364:
                            if (type.equals(AdResponseEvent.TYPE)) {
                                requestCanceled = new AdResponseEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                        case 2133546143:
                            if (type.equals(AdBreakEndEvent.TYPE)) {
                                requestCanceled = new AdBreakEndEvent(getPlayerData());
                                requestCanceled.setViewData(((PlaybackEvent) iEvent).getViewData());
                                requestCanceled.setAdData(((AdEvent) iEvent).getAdData());
                                a((BaseEvent) requestCanceled);
                            }
                            break;
                    }
                }
                break;
        }
        if (this.x != null) {
            this.l = new Date().getTime();
            this.k = this.x.getCurrentPositionMs();
        }
    }

    public void networkChange(@Nonnull String str) {
        if (a(str)) {
            this.y = str;
            MuxLogger.d("MuxStats", "networkChange: " + str);
            handle(new NetworkChangeEvent(getPlayerData(), str));
        }
    }

    public void networkChange(@Nonnull String str, @Nullable Boolean bool) {
        if (!a(str)) {
            Boolean bool2 = this.z;
            if (bool != null) {
                if (bool.equals(bool2)) {
                    return;
                }
            } else if (bool2 == null) {
                return;
            }
        }
        MuxLogger.d("MuxStats", "networkChange: " + str + "low data: " + bool);
        this.y = str;
        this.z = bool;
        handle(new NetworkChangeEvent(getPlayerData(), str, bool));
    }

    public void orientationChange(MuxSDKViewOrientation muxSDKViewOrientation) {
        Core.orientationChangeForPlayer(this.b, muxSDKViewOrientation);
    }

    public void playbackModeChange(PlaybackMode playbackMode, @Nullable String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                MuxLogger.exception(e, "MuxStats", "Invalid Playback Mode JSON String. Not reporting mode change");
                return;
            }
        } else {
            jSONObject = null;
        }
        a(playbackMode.getModeValue(), jSONObject);
    }

    public void playbackModeChange(PlaybackMode playbackMode, @Nullable JSONObject jSONObject) {
        a(playbackMode.getModeValue(), jSONObject);
    }

    public void playbackModeChange(String str, @Nullable String str2) {
        JSONObject jSONObject;
        if (str2 != null) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e) {
                MuxLogger.exception(e, "MuxStats", "Invalid Playback Mode JSON String. Not reporting mode change");
                return;
            }
        } else {
            jSONObject = null;
        }
        a(str, jSONObject);
    }

    public void playbackModeChange(String str, @Nullable JSONObject jSONObject) {
        a(str, jSONObject);
    }

    public void presentationChange(@Nullable MuxSDKViewPresentation muxSDKViewPresentation) {
        this.p = muxSDKViewPresentation;
    }

    public void programChange(CustomerVideoData customerVideoData) {
        videoChange(customerVideoData);
        a((BaseEvent) a((PlaybackEvent) new PlayEvent(getPlayerData())));
        a((BaseEvent) a((PlaybackEvent) new PlayingEvent(getPlayerData())));
    }

    public void release() {
        Timer timer = this.f278a;
        if (timer != null) {
            timer.cancel();
            this.f278a.purge();
            this.f278a = null;
        }
        if (this.b != null) {
            a((BaseEvent) new ViewEndEvent(getPlayerData()));
            Core.destroyPlayer(this.b);
        }
        this.x = null;
        this.w = null;
    }

    public void setAutomaticErrorTracking(boolean z) {
        this.u = z;
    }

    public void setCustomerData(CustomerData customerData) {
        if (customerData == null || customerData.getCustomerPlayerData() == null) {
            throw new IllegalArgumentException("customerPlayerData cannot be null");
        }
        DataEvent dataEvent = new DataEvent();
        if (customerData.getCustomerViewData() != null) {
            dataEvent.setCustomerViewData(customerData.getCustomerViewData());
        }
        if (customerData.getCustomerPlayerData() != null) {
            dataEvent.setCustomerPlayerData(customerData.getCustomerPlayerData());
        }
        if (customerData.getCustomerVideoData() != null) {
            dataEvent.setCustomerVideoData(customerData.getCustomerVideoData());
        }
        if (customerData.getCustomData() != null) {
            dataEvent.setCustomData(customerData.getCustomData());
        }
        if (customerData.getCustomerViewerData() != null) {
            dataEvent.setCustomerViewerData(customerData.getCustomerViewerData());
        }
        this.c = customerData;
        a(dataEvent);
    }

    public void setDroppedFramesCount(Long l) {
        this.m = l.longValue();
    }

    public void setErrorEventTranslating(ErrorEventTranslating errorEventTranslating) {
        this.q = errorEventTranslating;
    }

    public void setPlayerSize(int i, int i2) {
        if (i == -1 || i2 == -1) {
            return;
        }
        int iA = a(i, 0, 1048576);
        int iA2 = a(i2, 0, 1048576);
        this.o = true;
        this.d = Integer.valueOf(iA);
        this.e = Integer.valueOf(iA2);
    }

    public void setScreenSize(int i, int i2) {
        if (i == -1 || i2 == -1) {
            return;
        }
        this.f = Integer.valueOf(i);
        this.g = Integer.valueOf(i2);
    }

    public void setSessionData(@Nullable List<SessionTag> list) {
        if (this.h) {
            Core.dispatchEventForPlayer(this.b, new SessionDataEvent(list));
        }
    }

    @Deprecated
    public void updateCustomerData(CustomerPlayerData customerPlayerData, CustomerVideoData customerVideoData) {
        updateCustomerData(customerPlayerData, customerVideoData, null);
    }

    @Deprecated
    public void updateCustomerData(CustomerPlayerData customerPlayerData, CustomerVideoData customerVideoData, CustomerViewData customerViewData) {
        if (customerVideoData == null && customerPlayerData == null && customerViewData == null) {
            return;
        }
        DataEvent dataEvent = new DataEvent();
        if (customerVideoData != null) {
            this.c.setCustomerVideoData(customerVideoData);
            dataEvent.setCustomerVideoData(customerVideoData);
        }
        if (customerPlayerData != null) {
            this.c.setCustomerPlayerData(customerPlayerData);
            dataEvent.setCustomerPlayerData(customerPlayerData);
        }
        if (customerViewData != null) {
            this.c.setCustomerViewData(customerViewData);
            dataEvent.setCustomerViewData(customerViewData);
        }
        a(dataEvent);
    }

    @Deprecated
    public void updateHostDeviceData() {
    }

    public void videoChange(CustomerData customerData) {
        a((BaseEvent) new ViewEndEvent(getPlayerData()));
        a(customerData);
    }

    public void videoChange(CustomerVideoData customerVideoData) {
        this.c.setCustomerVideoData(customerVideoData);
        videoChange(this.c);
        this.m = 0L;
    }

    public void videoDataChange(@Nullable VideoData videoData) {
        if (this.h) {
            DataEvent dataEvent = new DataEvent();
            dataEvent.setVideoData(videoData);
            Core.dispatchEventForPlayer(this.b, dataEvent);
        }
    }
}
