package androidx.camera.camera2.interop;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.Camera2ImplConfigKt;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureRequestOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ#\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0016¢\u0006\u0002\u0010\rJ/\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\b\u0010\u000e\u001a\u0004\u0018\u0001H\nH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0003H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/interop/CaptureRequestOptions;", "Landroidx/camera/core/impl/ReadableConfig;", "config", "Landroidx/camera/core/impl/Config;", "unused", "", "<init>", "(Landroidx/camera/core/impl/Config;Z)V", "(Landroidx/camera/core/impl/Config;)V", "getCaptureRequestOption", "ValueT", "key", "Landroid/hardware/camera2/CaptureRequest$Key;", "(Landroid/hardware/camera2/CaptureRequest$Key;)Ljava/lang/Object;", "valueIfMissing", "getCaptureRequestOption$camera_camera2", "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)Ljava/lang/Object;", "getConfig", "Builder", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CaptureRequestOptions implements ReadableConfig {
    private final Config config;

    private CaptureRequestOptions(Config config, boolean z) {
        this.config = config;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CaptureRequestOptions(Config config) {
        this(config, false);
        Intrinsics.checkNotNullParameter(config, "config");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <ValueT> ValueT getCaptureRequestOption(CaptureRequest.Key<ValueT> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Config.Option<Object> optionCreateCaptureRequestOption = Camera2ImplConfigKt.createCaptureRequestOption(key);
        Intrinsics.checkNotNull(optionCreateCaptureRequestOption, "null cannot be cast to non-null type androidx.camera.core.impl.Config.Option<ValueT of androidx.camera.camera2.interop.CaptureRequestOptions.getCaptureRequestOption>");
        return (ValueT) this.config.retrieveOption(optionCreateCaptureRequestOption, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <ValueT> ValueT getCaptureRequestOption$camera_camera2(CaptureRequest.Key<ValueT> key, ValueT valueIfMissing) {
        Intrinsics.checkNotNullParameter(key, "key");
        Config.Option<Object> optionCreateCaptureRequestOption = Camera2ImplConfigKt.createCaptureRequestOption(key);
        Intrinsics.checkNotNull(optionCreateCaptureRequestOption, "null cannot be cast to non-null type androidx.camera.core.impl.Config.Option<ValueT of androidx.camera.camera2.interop.CaptureRequestOptions.getCaptureRequestOption>");
        return (ValueT) this.config.retrieveOption(optionCreateCaptureRequestOption, valueIfMissing);
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.config;
    }

    /* JADX INFO: compiled from: CaptureRequestOptions.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0017J'\u0010\n\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0006\u0010\u000e\u001a\u0002H\u000b¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rJ\b\u0010\u0011\u001a\u00020\u0002H\u0016R\u0013\u0010\u0005\u001a\u00070\u0006¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/interop/CaptureRequestOptions$Builder;", "Landroidx/camera/core/ExtendableBuilder;", "Landroidx/camera/camera2/interop/CaptureRequestOptions;", "<init>", "()V", "mutableOptionsBundle", "Landroidx/camera/core/impl/MutableOptionsBundle;", "Lorg/jspecify/annotations/NonNull;", "getMutableConfig", "Landroidx/camera/core/impl/MutableConfig;", "setCaptureRequestOption", "ValueT", "key", "Landroid/hardware/camera2/CaptureRequest$Key;", "value", "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)Landroidx/camera/camera2/interop/CaptureRequestOptions$Builder;", "clearCaptureRequestOption", "build", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder implements ExtendableBuilder<CaptureRequestOptions> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final MutableOptionsBundle mutableOptionsBundle;

        @JvmStatic
        public static final Builder from(Config config) {
            return INSTANCE.from(config);
        }

        public Builder() {
            MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
            Intrinsics.checkNotNullExpressionValue(mutableOptionsBundleCreate, "create(...)");
            this.mutableOptionsBundle = mutableOptionsBundleCreate;
        }

        /* JADX INFO: compiled from: CaptureRequestOptions.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/interop/CaptureRequestOptions$Builder$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Landroidx/camera/camera2/interop/CaptureRequestOptions$Builder;", "config", "Landroidx/camera/core/impl/Config;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Builder from(final Config config) {
                Intrinsics.checkNotNullParameter(config, "config");
                final Builder builder = new Builder();
                config.findOptions(Camera2ImplConfig.CAPTURE_REQUEST_ID_STEM, new Config.OptionMatcher() { // from class: androidx.camera.camera2.interop.CaptureRequestOptions$Builder$Companion$$ExternalSyntheticLambda0
                    @Override // androidx.camera.core.impl.Config.OptionMatcher
                    public final boolean onOptionMatched(Config.Option option) {
                        return CaptureRequestOptions.Builder.Companion.from$lambda$0(builder, config, option);
                    }
                });
                return builder;
            }

            static final boolean from$lambda$0(Builder builder, Config config, Config.Option it) {
                Intrinsics.checkNotNullParameter(it, "it");
                builder.getMutableConfig().insertOption(it, config.getOptionPriority(it), config.retrieveOption(it));
                return true;
            }
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
        public final <ValueT> Builder clearCaptureRequestOption(CaptureRequest.Key<ValueT> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mutableOptionsBundle.removeOption(Camera2ImplConfigKt.createCaptureRequestOption(key));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.ExtendableBuilder
        public CaptureRequestOptions build() {
            OptionsBundle optionsBundleFrom = OptionsBundle.from(this.mutableOptionsBundle);
            Intrinsics.checkNotNullExpressionValue(optionsBundleFrom, "from(...)");
            return new CaptureRequestOptions(optionsBundleFrom);
        }
    }
}
