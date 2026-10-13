package com.amazonaws.ivs.player;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaFormat;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.amazonaws.ivs.net.HttpClient;
import com.amazonaws.ivs.net.HttpClientFactory;
import com.amazonaws.ivs.net.NetworkLinkInfo;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes5.dex */
public class Platform {
    public static final String LIBRARY_NAME = "playercore";
    private static ByteBuffer[] cachedProtectionSystemData;
    private static ErrorListener errorListener;
    private AudioTrackRenderer audioRenderer;
    private int audioSessionId;
    private BatteryManager batteryManager;
    private Intent batteryStatus;
    private final Context context;
    private Map<String, String> fixedDeviceProperties;
    private long handle;
    private Size maxDisplayModeSize;
    private ConcurrentLinkedQueue<Throwable> pendingExceptions;
    private PowerManager powerManager;
    private SurfaceRenderer surfaceRenderer;
    private String videoMediaType;
    private WeakReference<VideoRenderer.VideoSizeListener> videoSizeListener;

    public interface ErrorListener {
        void onError(Throwable th);
    }

    private native DeviceConfigPropertyHolder createDeviceConfigPropertyHolderImpl(long j);

    private native void sendDeviceConfigPropertyHolderAnalyticsImpl(long j, long j2);

    private native void setSeparateVttTrackSinkEnabled(long j, boolean z);

    private native void setSinkModes(long j, boolean z, boolean z2);

    Platform(Context context) {
        this(context.getApplicationContext(), null);
    }

    Platform(Context context, VideoRenderer.VideoSizeListener videoSizeListener) {
        this.audioSessionId = -1;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.pendingExceptions = new ConcurrentLinkedQueue<>();
        this.fixedDeviceProperties = new HashMap();
        this.maxDisplayModeSize = new Size(0, 0);
        if (videoSizeListener != null) {
            this.videoSizeListener = new WeakReference<>(videoSizeListener);
        }
        this.fixedDeviceProperties.put("device_software", "android-" + Build.VERSION.SDK_INT);
        this.fixedDeviceProperties.put("device_os_version", Build.VERSION.RELEASE);
        this.fixedDeviceProperties.put("device_model", Build.MODEL);
        this.fixedDeviceProperties.put("device_manufacturer", Build.MANUFACTURER);
        this.fixedDeviceProperties.put("device_diagonal", getDeviceDiagonalSize());
        this.fixedDeviceProperties.put("app_id", applicationContext.getPackageName());
        this.fixedDeviceProperties.put("customer", getCustomerType(applicationContext.getPackageName()));
        if (applicationContext != null && applicationContext.getPackageManager() != null) {
            try {
                PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
                this.fixedDeviceProperties.put("app_version_name", packageInfo.versionName != null ? packageInfo.versionName : "unknown");
                this.fixedDeviceProperties.put("app_version_code", String.valueOf(packageInfo.versionCode));
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    String string = applicationInfo.metaData.getString("com.amazonaws.ivs.player.FRAMEWORK_NAME");
                    String string2 = applicationInfo.metaData.getString("com.amazonaws.ivs.player.FRAMEWORK_VERSION");
                    if (string != null && !string.isEmpty()) {
                        this.fixedDeviceProperties.put("player_framework", string);
                    }
                    if (string2 != null && !string2.isEmpty()) {
                        this.fixedDeviceProperties.put("player_framework_version", string2);
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                Logging.d("Unable to find package", e);
            }
            this.batteryStatus = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.batteryManager = (BatteryManager) this.context.getSystemService("batterymanager");
            this.powerManager = (PowerManager) this.context.getSystemService("power");
        }
        VideoCapabilities.isTypeSupported("av01");
        VideoCapabilities.isTypeSupported("hevc");
    }

    private static String getCustomerType(String str) {
        return (str == null || !str.toLowerCase().contains("twitch")) ? "ivs" : "twitch";
    }

    private String getDeviceDiagonalSize() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            return new BigDecimal(Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d))).setScale(1, 4).toString();
        }
        return "0.0";
    }

    public static void setErrorListener(ErrorListener errorListener2) {
        errorListener = errorListener2;
    }

    public void setVideoMediaType(String str) {
        this.videoMediaType = str;
    }

    MediaDecoder createDecoder(MediaFormat mediaFormat) {
        String string = mediaFormat.getString("mime");
        if (string.startsWith("video")) {
            if (this.surfaceRenderer == null) {
                WeakReference<VideoRenderer.VideoSizeListener> weakReference = this.videoSizeListener;
                this.surfaceRenderer = new SurfaceRenderer(this.context, weakReference != null ? weakReference.get() : null);
            }
            setVideoMediaType(string);
            return new MediaCodecDecoder(mediaFormat, this.surfaceRenderer);
        }
        if (!string.startsWith("audio")) {
            return null;
        }
        AudioTrackRenderer audioTrackRenderer = this.audioRenderer;
        if (audioTrackRenderer != null) {
            audioTrackRenderer.release();
        }
        this.audioRenderer = new AudioTrackRenderer();
        return new MediaCodecDecoder(mediaFormat, this.audioRenderer);
    }

    synchronized MediaRenderer createRenderer(MediaFormat mediaFormat) {
        String string = mediaFormat.getString("mime");
        if (string.startsWith("audio")) {
            return this.audioRenderer;
        }
        if (!string.startsWith("video")) {
            return null;
        }
        return this.surfaceRenderer;
    }

    VideoRenderer.VideoSizeListener getVideoSizeListener() {
        WeakReference<VideoRenderer.VideoSizeListener> weakReference = this.videoSizeListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    PlayerException createException(String str, int i, int i2, String str2) {
        ErrorType errorTypeFromInt = ErrorType.fromInt(i);
        Throwable thPoll = this.pendingExceptions.poll();
        if (thPoll != null) {
            PlayerException playerException = new PlayerException(thPoll, str, errorTypeFromInt, i2, str2);
            if (this.pendingExceptions.size() > 1) {
                Logging.e("Errored with multiple exceptions");
                Iterator<Throwable> it = this.pendingExceptions.iterator();
                while (it.hasNext()) {
                    Logging.e(str, it.next());
                }
            }
            this.pendingExceptions.clear();
            return playerException;
        }
        return new PlayerException(str, errorTypeFromInt, i2, str2);
    }

    int getAudioSessionId() {
        AudioTrackRenderer audioTrackRenderer = this.audioRenderer;
        return audioTrackRenderer == null ? this.audioSessionId : audioTrackRenderer.getAudioSessionId();
    }

    void setAudioSessionId(int i) {
        this.audioSessionId = i;
    }

    HttpClient createHttpClient() {
        return HttpClientFactory.create();
    }

    NetworkLinkInfo createNetworkLinkInfo() {
        return new NetworkLinkInfo(this.context);
    }

    static synchronized ByteBuffer[] getSupportedProtectionSystemUUIDs() {
        if (cachedProtectionSystemData == null) {
            ProtectionSystem[] protectionSystemArr = (ProtectionSystem[]) ProtectionSystem.getSupported().toArray(new ProtectionSystem[0]);
            cachedProtectionSystemData = new ByteBuffer[protectionSystemArr.length];
            for (int i = 0; i < protectionSystemArr.length; i++) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(16);
                UUID uuid = protectionSystemArr[i].getUUID();
                byteBufferAllocateDirect.putLong(uuid.getMostSignificantBits());
                byteBufferAllocateDirect.putLong(uuid.getLeastSignificantBits());
                cachedProtectionSystemData[i] = byteBufferAllocateDirect;
            }
        }
        return cachedProtectionSystemData;
    }

    VideoCapabilities getVideoDecoderCapabilities(String str) {
        return VideoCapabilities.getCapabilities(MediaType.removeParameters(str));
    }

    public void handleDecoderException(Throwable th) {
        if (th != null) {
            Logging.e("Decoder Error", th);
            this.pendingExceptions.add(th);
            ErrorListener errorListener2 = errorListener;
            if (errorListener2 != null) {
                errorListener2.onError(th);
            }
        }
    }

    public void handleRendererException(Throwable th) {
        if (th != null) {
            Logging.e("Renderer Error", th);
            this.pendingExceptions.add(th);
            ErrorListener errorListener2 = errorListener;
            if (errorListener2 != null) {
                errorListener2.onError(th);
            }
        }
    }

    public void onThreadCreated(String str) {
        try {
            Process.setThreadPriority(-2);
        } catch (Exception e) {
            Logging.e("Error while setting thread priority", e);
        }
        if (str == null || str.isEmpty()) {
            return;
        }
        Thread.currentThread().setName(str);
    }

    private void updateDeviceDisplayMode() {
        int i;
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int i2 = 0;
        if (windowManager != null) {
            Display.Mode[] supportedModes = windowManager.getDefaultDisplay().getSupportedModes();
            int length = supportedModes.length;
            int i3 = 0;
            i = 0;
            while (i2 < length) {
                Display.Mode mode = supportedModes[i2];
                int physicalWidth = mode.getPhysicalWidth();
                int physicalHeight = mode.getPhysicalHeight();
                if (physicalWidth * physicalHeight > i3 * i) {
                    i = physicalHeight;
                    i3 = physicalWidth;
                }
                i2++;
            }
            i2 = i3;
        } else {
            i = 0;
        }
        if (i2 <= 0 || i <= 0) {
            return;
        }
        Size size = new Size(i2, i);
        if (size.equals(this.maxDisplayModeSize)) {
            return;
        }
        this.maxDisplayModeSize = size;
    }

    Size getDisplaySize() {
        updateDeviceDisplayMode();
        return this.maxDisplayModeSize;
    }

    float getMaxPlaybackRateForQuality(Quality quality) {
        String str = this.videoMediaType;
        if (str == null) {
            Logging.d("getMaxPlaybackRateForQuality: decoder has not been created yet");
            return 1.0f;
        }
        return VideoCapabilities.getMaxPlaybackRateForQuality(MediaType.removeParameters(str), quality);
    }

    private enum ThermalState {
        NONE(0),
        LIGHT(1),
        MODERATE(2),
        SEVERE(3),
        CRITICAL(4),
        EMERGENCY(5),
        SHUTDOWN(6),
        UNKNOWN(-1);

        private final int id;

        ThermalState(int i) {
            this.id = i;
        }

        static ThermalState valueOf(int i) {
            for (ThermalState thermalState : values()) {
                if (thermalState.id == i) {
                    return thermalState;
                }
            }
            return UNKNOWN;
        }

        @Override // java.lang.Enum
        public String toString() {
            return name().toLowerCase();
        }
    }

    String getThermalState() {
        PowerManager powerManager;
        return ThermalState.valueOf((Build.VERSION.SDK_INT < 29 || (powerManager = this.powerManager) == null) ? -1 : powerManager.getCurrentThermalStatus()).toString();
    }

    Integer getBatteryCharge() {
        BatteryManager batteryManager = this.batteryManager;
        if (batteryManager != null) {
            return Integer.valueOf(batteryManager.getIntProperty(4));
        }
        return null;
    }

    Boolean isBatteryCharging() {
        int intExtra;
        BatteryManager batteryManager;
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 26 && (batteryManager = this.batteryManager) != null) {
            intExtra = batteryManager.getIntProperty(6);
        } else {
            intExtra = this.batteryStatus.getIntExtra("status", 1);
        }
        if (intExtra == 1) {
            return null;
        }
        if (intExtra != 2 && intExtra != 5) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    Boolean isLowPowerModeEnabled() {
        PowerManager powerManager = this.powerManager;
        if (powerManager != null) {
            return Boolean.valueOf(powerManager.isPowerSaveMode());
        }
        return null;
    }

    Map<String, String> getMutableProperties() {
        HashMap map = new HashMap();
        Boolean boolIsLowPowerModeEnabled = isLowPowerModeEnabled();
        if (boolIsLowPowerModeEnabled != null) {
            map.put("low_power_mode", String.valueOf(boolIsLowPowerModeEnabled));
        }
        Boolean boolIsBatteryCharging = isBatteryCharging();
        if (boolIsBatteryCharging != null) {
            map.put("charging", String.valueOf(boolIsBatteryCharging));
        }
        Integer batteryCharge = getBatteryCharge();
        if (batteryCharge != null) {
            map.put("battery_percent", String.valueOf(batteryCharge.intValue() / 100.0f));
        }
        map.put("thermal_state", getThermalState());
        return map;
    }

    Map<String, String> getDeviceProperties() {
        HashMap map = new HashMap(this.fixedDeviceProperties);
        map.putAll(getMutableProperties());
        return map;
    }

    String getStringOrientation() {
        int i = this.context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return "portrait";
        }
        if (i == 2) {
            return "landscape";
        }
        return "unknown";
    }

    private void setHandle(long j) {
        this.handle = j;
    }

    Resource<DeviceConfigPropertyHolder> createDeviceConfigPropertyHolder() {
        return Resource.from(createDeviceConfigPropertyHolderImpl(this.handle), new Consumer() { // from class: com.amazonaws.ivs.player.Platform$$ExternalSyntheticLambda1
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                this.f$0.m11074x29d4a5f2((DeviceConfigPropertyHolder) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$createDeviceConfigPropertyHolder$0$com-amazonaws-ivs-player-Platform, reason: not valid java name */
    /* synthetic */ void m11074x29d4a5f2(DeviceConfigPropertyHolder deviceConfigPropertyHolder) {
        sendDeviceConfigPropertyHolderAnalyticsImpl(this.handle, deviceConfigPropertyHolder.getHandle());
    }

    void updateMediaSinkConfiguration(boolean z, boolean z2) {
        setSinkModes(this.handle, z, z2);
    }

    void setSeparateVttTrackSinkEnabled(boolean z) {
        setSeparateVttTrackSinkEnabled(this.handle, z);
    }
}
