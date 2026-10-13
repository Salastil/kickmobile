package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2ImplConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0011J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0013J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0015J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0017J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0019R\u0011\u0010\u0006\u001a\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Landroidx/camera/camera2/impl/Camera2ImplConfig;", "Landroidx/camera/camera2/interop/CaptureRequestOptions;", "config", "Landroidx/camera/core/impl/Config;", "<init>", "(Landroidx/camera/core/impl/Config;)V", "captureRequestOptions", "getCaptureRequestOptions", "()Landroidx/camera/camera2/interop/CaptureRequestOptions;", "getCaptureRequestTemplate", "", "valueIfMissing", "getStreamUseCase", "", "(Ljava/lang/Long;)Ljava/lang/Long;", "getStreamUseHint", "getDeviceStateCallback", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "getSessionStateCallback", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "getSessionCaptureCallback", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "getCaptureRequestTag", "", "getPhysicalCameraId", "", "Builder", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2ImplConfig extends CaptureRequestOptions {
    public static final String CAPTURE_REQUEST_ID_STEM = "camera2.captureRequest.option.";
    public static final Config.Option<Object> CAPTURE_REQUEST_TAG_OPTION;
    public static final Config.Option<CameraDevice.StateCallback> DEVICE_STATE_CALLBACK_OPTION;
    public static final Config.Option<CameraCaptureSession.CaptureCallback> SESSION_CAPTURE_CALLBACK_OPTION;
    public static final Config.Option<String> SESSION_PHYSICAL_CAMERA_ID_OPTION;
    public static final Config.Option<CameraCaptureSession.StateCallback> SESSION_STATE_CALLBACK_OPTION;
    public static final Config.Option<Long> STREAM_USE_CASE_OPTION;
    public static final Config.Option<Long> STREAM_USE_HINT_OPTION;
    public static final Config.Option<Integer> TEMPLATE_TYPE_OPTION;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2ImplConfig(Config config) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
    }

    public final CaptureRequestOptions getCaptureRequestOptions() {
        return CaptureRequestOptions.Builder.INSTANCE.from(getConfig()).build();
    }

    public final int getCaptureRequestTemplate(int valueIfMissing) {
        Object objRetrieveOption = getConfig().retrieveOption(TEMPLATE_TYPE_OPTION, Integer.valueOf(valueIfMissing));
        Intrinsics.checkNotNull(objRetrieveOption);
        return ((Number) objRetrieveOption).intValue();
    }

    public static /* synthetic */ Long getStreamUseCase$default(Camera2ImplConfig camera2ImplConfig, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return camera2ImplConfig.getStreamUseCase(l);
    }

    public final Long getStreamUseCase(Long valueIfMissing) {
        return (Long) getConfig().retrieveOption(STREAM_USE_CASE_OPTION, valueIfMissing);
    }

    public static /* synthetic */ Long getStreamUseHint$default(Camera2ImplConfig camera2ImplConfig, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return camera2ImplConfig.getStreamUseHint(l);
    }

    public final Long getStreamUseHint(Long valueIfMissing) {
        return (Long) getConfig().retrieveOption(STREAM_USE_HINT_OPTION, valueIfMissing);
    }

    public static /* synthetic */ CameraDevice.StateCallback getDeviceStateCallback$default(Camera2ImplConfig camera2ImplConfig, CameraDevice.StateCallback stateCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            stateCallback = null;
        }
        return camera2ImplConfig.getDeviceStateCallback(stateCallback);
    }

    public final CameraDevice.StateCallback getDeviceStateCallback(CameraDevice.StateCallback valueIfMissing) {
        return (CameraDevice.StateCallback) getConfig().retrieveOption(DEVICE_STATE_CALLBACK_OPTION, valueIfMissing);
    }

    public static /* synthetic */ CameraCaptureSession.StateCallback getSessionStateCallback$default(Camera2ImplConfig camera2ImplConfig, CameraCaptureSession.StateCallback stateCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            stateCallback = null;
        }
        return camera2ImplConfig.getSessionStateCallback(stateCallback);
    }

    public final CameraCaptureSession.StateCallback getSessionStateCallback(CameraCaptureSession.StateCallback valueIfMissing) {
        return (CameraCaptureSession.StateCallback) getConfig().retrieveOption(SESSION_STATE_CALLBACK_OPTION, valueIfMissing);
    }

    public static /* synthetic */ CameraCaptureSession.CaptureCallback getSessionCaptureCallback$default(Camera2ImplConfig camera2ImplConfig, CameraCaptureSession.CaptureCallback captureCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            captureCallback = null;
        }
        return camera2ImplConfig.getSessionCaptureCallback(captureCallback);
    }

    public final CameraCaptureSession.CaptureCallback getSessionCaptureCallback(CameraCaptureSession.CaptureCallback valueIfMissing) {
        return (CameraCaptureSession.CaptureCallback) getConfig().retrieveOption(SESSION_CAPTURE_CALLBACK_OPTION, valueIfMissing);
    }

    public static /* synthetic */ Object getCaptureRequestTag$default(Camera2ImplConfig camera2ImplConfig, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return camera2ImplConfig.getCaptureRequestTag(obj);
    }

    public final Object getCaptureRequestTag(Object valueIfMissing) {
        return getConfig().retrieveOption(CAPTURE_REQUEST_TAG_OPTION, valueIfMissing);
    }

    public static /* synthetic */ String getPhysicalCameraId$default(Camera2ImplConfig camera2ImplConfig, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return camera2ImplConfig.getPhysicalCameraId(str);
    }

    public final String getPhysicalCameraId(String valueIfMissing) {
        return (String) getConfig().retrieveOption(SESSION_PHYSICAL_CAMERA_ID_OPTION, valueIfMissing);
    }

    /* JADX INFO: compiled from: Camera2ImplConfig.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J'\u0010\n\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0006\u0010\u000e\u001a\u0002H\u000b¢\u0006\u0002\u0010\u000fJ/\u0010\u0010\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u00020\u00002\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0018\u001a\u00020\u00002\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0002H\u0016R\u0013\u0010\u0005\u001a\u00070\u0006¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/camera/camera2/impl/Camera2ImplConfig$Builder;", "Landroidx/camera/core/ExtendableBuilder;", "Landroidx/camera/camera2/impl/Camera2ImplConfig;", "<init>", "()V", "mutableOptionsBundle", "Landroidx/camera/core/impl/MutableOptionsBundle;", "Lorg/jspecify/annotations/NonNull;", "getMutableConfig", "Landroidx/camera/core/impl/MutableConfig;", "setCaptureRequestOption", "ValueT", "key", "Landroid/hardware/camera2/CaptureRequest$Key;", "value", "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)Landroidx/camera/camera2/impl/Camera2ImplConfig$Builder;", "setCaptureRequestOptionWithPriority", "priority", "Landroidx/camera/core/impl/Config$OptionPriority;", "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;Landroidx/camera/core/impl/Config$OptionPriority;)Landroidx/camera/camera2/impl/Camera2ImplConfig$Builder;", "addAllCaptureRequestOptionsWithPriority", "values", "", "", "removeCaptureRequestOptions", UserMetadata.KEYDATA_FILENAME, "", "insertAllOptions", "config", "Landroidx/camera/core/impl/Config;", "build", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder implements ExtendableBuilder<Camera2ImplConfig> {
        private final MutableOptionsBundle mutableOptionsBundle;

        public Builder() {
            MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
            Intrinsics.checkNotNullExpressionValue(mutableOptionsBundleCreate, "create(...)");
            this.mutableOptionsBundle = mutableOptionsBundleCreate;
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mutableOptionsBundle;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <ValueT> Builder setCaptureRequestOption(CaptureRequest.Key<ValueT> key, ValueT value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mutableOptionsBundle.insertOption(Camera2ImplConfigKt.createCaptureRequestOption(key), value);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <ValueT> Builder setCaptureRequestOptionWithPriority(CaptureRequest.Key<ValueT> key, ValueT value, Config.OptionPriority priority) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(priority, "priority");
            this.mutableOptionsBundle.insertOption(Camera2ImplConfigKt.createCaptureRequestOption(key), priority, value);
            return this;
        }

        public final Builder removeCaptureRequestOptions(List<? extends CaptureRequest.Key<?>> keys) {
            Intrinsics.checkNotNullParameter(keys, "keys");
            Iterator<T> it = keys.iterator();
            while (it.hasNext()) {
                this.mutableOptionsBundle.removeOption(Camera2ImplConfigKt.createCaptureRequestOption((CaptureRequest.Key) it.next()));
            }
            return this;
        }

        public final Builder insertAllOptions(Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            for (Config.Option<?> option : config.listOptions()) {
                Intrinsics.checkNotNull(option, "null cannot be cast to non-null type androidx.camera.core.impl.Config.Option<kotlin.Any>");
                this.mutableOptionsBundle.insertOption(option, config.getOptionPriority(option), config.retrieveOption(option));
            }
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.ExtendableBuilder
        public Camera2ImplConfig build() {
            OptionsBundle optionsBundleFrom = OptionsBundle.from(this.mutableOptionsBundle);
            Intrinsics.checkNotNullExpressionValue(optionsBundleFrom, "from(...)");
            return new Camera2ImplConfig(optionsBundleFrom);
        }

        public final Builder addAllCaptureRequestOptionsWithPriority(Map<CaptureRequest.Key<?>, ? extends Object> values, Config.OptionPriority priority) {
            Intrinsics.checkNotNullParameter(values, "values");
            Intrinsics.checkNotNullParameter(priority, "priority");
            for (Map.Entry<CaptureRequest.Key<?>, ? extends Object> entry : values.entrySet()) {
                CaptureRequest.Key<?> key = entry.getKey();
                Object value = entry.getValue();
                this.mutableOptionsBundle.insertOption(Camera2ImplConfigKt.createCaptureRequestOption(key), priority, value);
            }
            return this;
        }
    }

    static {
        Class cls = Integer.TYPE;
        Intrinsics.checkNotNull(cls);
        Config.Option<Integer> optionCreate = Config.Option.create("camera2.captureRequest.templateType", cls);
        Intrinsics.checkNotNullExpressionValue(optionCreate, "create(...)");
        TEMPLATE_TYPE_OPTION = optionCreate;
        Config.Option<CameraDevice.StateCallback> optionCreate2 = Config.Option.create("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);
        Intrinsics.checkNotNullExpressionValue(optionCreate2, "create(...)");
        DEVICE_STATE_CALLBACK_OPTION = optionCreate2;
        Config.Option<CameraCaptureSession.StateCallback> optionCreate3 = Config.Option.create("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);
        Intrinsics.checkNotNullExpressionValue(optionCreate3, "create(...)");
        SESSION_STATE_CALLBACK_OPTION = optionCreate3;
        Config.Option<CameraCaptureSession.CaptureCallback> optionCreate4 = Config.Option.create("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);
        Intrinsics.checkNotNullExpressionValue(optionCreate4, "create(...)");
        SESSION_CAPTURE_CALLBACK_OPTION = optionCreate4;
        Class cls2 = Long.TYPE;
        Intrinsics.checkNotNull(cls2);
        Config.Option<Long> optionCreate5 = Config.Option.create("camera2.cameraCaptureSession.streamUseCase", cls2);
        Intrinsics.checkNotNullExpressionValue(optionCreate5, "create(...)");
        STREAM_USE_CASE_OPTION = optionCreate5;
        Class cls3 = Long.TYPE;
        Intrinsics.checkNotNull(cls3);
        Config.Option<Long> optionCreate6 = Config.Option.create("camera2.cameraCaptureSession.streamUseHint", cls3);
        Intrinsics.checkNotNullExpressionValue(optionCreate6, "create(...)");
        STREAM_USE_HINT_OPTION = optionCreate6;
        Config.Option<Object> optionCreate7 = Config.Option.create("camera2.captureRequest.tag", Object.class);
        Intrinsics.checkNotNullExpressionValue(optionCreate7, "create(...)");
        CAPTURE_REQUEST_TAG_OPTION = optionCreate7;
        Config.Option<String> optionCreate8 = Config.Option.create("camera2.cameraCaptureSession.physicalCameraId", String.class);
        Intrinsics.checkNotNullExpressionValue(optionCreate8, "create(...)");
        SESSION_PHYSICAL_CAMERA_ID_OPTION = optionCreate8;
    }
}
