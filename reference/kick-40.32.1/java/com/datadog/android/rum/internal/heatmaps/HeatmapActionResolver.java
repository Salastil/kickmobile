package com.datadog.android.rum.internal.heatmaps;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.heatmaps.CrossPlatformHeatmapActionData;
import com.datadog.android.internal.heatmaps.HeatmapIdentifier;
import com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry;
import com.datadog.android.rum.model.ActionEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeatmapActionResolver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00072\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver;", "", "()V", "resolve", "Lcom/datadog/android/rum/model/ActionEvent$DdAction;", "viewUrl", "", "Companion", "CrossPlatform", "Native", "Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver$CrossPlatform;", "Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver$Native;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class HeatmapActionResolver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String HEATMAP_EMPTY_ELEMENT_PATH = "CrossPlatformHeatmapActionData.elementPath is empty — heatmap data dropped.";
    public static final String HEATMAP_IDENTIFIER_HASH_FAILURE = "Failed to compute heatmap identifier — heatmap data dropped.";
    public static final String HEATMAP_VIEW_URL_MISMATCH = "Heatmap view URL mismatch (recorded \"%s\", current \"%s\") — heatmap data dropped.";

    public /* synthetic */ HeatmapActionResolver(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract ActionEvent.DdAction resolve(String viewUrl);

    private HeatmapActionResolver() {
    }

    /* JADX INFO: compiled from: HeatmapActionResolver.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver$Native;", "Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver;", "data", "Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;", "registry", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "(Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;)V", "resolve", "Lcom/datadog/android/rum/model/ActionEvent$DdAction;", "viewUrl", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Native extends HeatmapActionResolver {
        private final NativeHeatmapActionData data;
        private final HeatmapIdentifierRegistry registry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Native(NativeHeatmapActionData data, HeatmapIdentifierRegistry heatmapIdentifierRegistry) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.registry = heatmapIdentifierRegistry;
        }

        @Override // com.datadog.android.rum.internal.heatmaps.HeatmapActionResolver
        public ActionEvent.DdAction resolve(String viewUrl) {
            HeatmapIdentifier heatmapIdentifier;
            String rawValue;
            Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
            HeatmapIdentifierRegistry heatmapIdentifierRegistry = this.registry;
            if (heatmapIdentifierRegistry == null || (heatmapIdentifier = heatmapIdentifierRegistry.getHeatmapIdentifier(this.data.getViewKey(), viewUrl)) == null || (rawValue = heatmapIdentifier.getRawValue()) == null) {
                return null;
            }
            return HeatmapActionResolver.INSTANCE.buildDdAction$dd_sdk_android_rum_release(rawValue, this.data.getPositionX(), this.data.getPositionY(), this.data.getTargetWidth(), this.data.getTargetHeight());
        }
    }

    /* JADX INFO: compiled from: HeatmapActionResolver.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver$CrossPlatform;", "Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver;", "data", "Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", "appPackageName", "", "logger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;Ljava/lang/String;Lcom/datadog/android/api/InternalLogger;)V", "resolve", "Lcom/datadog/android/rum/model/ActionEvent$DdAction;", "viewUrl", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CrossPlatform extends HeatmapActionResolver {
        private final String appPackageName;
        private final CrossPlatformHeatmapActionData data;
        private final InternalLogger logger;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CrossPlatform(CrossPlatformHeatmapActionData data, String appPackageName, InternalLogger logger) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
            Intrinsics.checkNotNullParameter(logger, "logger");
            this.data = data;
            this.appPackageName = appPackageName;
            this.logger = logger;
        }

        @Override // com.datadog.android.rum.internal.heatmaps.HeatmapActionResolver
        public ActionEvent.DdAction resolve(final String viewUrl) {
            Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
            if (!Intrinsics.areEqual(this.data.getViewUrl(), viewUrl)) {
                InternalLogger.DefaultImpls.log$default(this.logger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.heatmaps.HeatmapActionResolver$CrossPlatform$resolve$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, HeatmapActionResolver.HEATMAP_VIEW_URL_MISMATCH, Arrays.copyOf(new Object[]{this.this$0.data.getViewUrl(), viewUrl}, 2));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return null;
            }
            if (this.data.getElementPath().isEmpty()) {
                InternalLogger.DefaultImpls.log$default(this.logger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.heatmaps.HeatmapActionResolver$CrossPlatform$resolve$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return HeatmapActionResolver.HEATMAP_EMPTY_ELEMENT_PATH;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return null;
            }
            HeatmapIdentifier heatmapIdentifierCreate = HeatmapIdentifier.INSTANCE.create(this.data.getElementPath(), viewUrl, this.appPackageName, new Function1<Throwable, Unit>() { // from class: com.datadog.android.rum.internal.heatmaps.HeatmapActionResolver$CrossPlatform$resolve$identifier$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable throwable) {
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    InternalLogger.DefaultImpls.log$default(this.this$0.logger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.heatmaps.HeatmapActionResolver$CrossPlatform$resolve$identifier$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return HeatmapActionResolver.HEATMAP_IDENTIFIER_HASH_FAILURE;
                        }
                    }, throwable, false, (Map) null, 48, (Object) null);
                }
            });
            if (heatmapIdentifierCreate == null) {
                return null;
            }
            return HeatmapActionResolver.INSTANCE.buildDdAction$dd_sdk_android_rum_release(heatmapIdentifierCreate.getRawValue(), this.data.getPositionX(), this.data.getPositionY(), this.data.getTargetWidth(), this.data.getTargetHeight());
        }
    }

    /* JADX INFO: compiled from: HeatmapActionResolver.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver$Companion;", "", "()V", "HEATMAP_EMPTY_ELEMENT_PATH", "", "HEATMAP_IDENTIFIER_HASH_FAILURE", "HEATMAP_VIEW_URL_MISMATCH", "buildDdAction", "Lcom/datadog/android/rum/model/ActionEvent$DdAction;", "permanentId", "positionX", "", "positionY", "targetWidth", "targetHeight", "buildDdAction$dd_sdk_android_rum_release", "(Ljava/lang/String;JJLjava/lang/Long;Ljava/lang/Long;)Lcom/datadog/android/rum/model/ActionEvent$DdAction;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActionEvent.DdAction buildDdAction$dd_sdk_android_rum_release(String permanentId, long positionX, long positionY, Long targetWidth, Long targetHeight) {
            Intrinsics.checkNotNullParameter(permanentId, "permanentId");
            return new ActionEvent.DdAction(new ActionEvent.Position(positionX, positionY), new ActionEvent.DdActionTarget(null, null, targetWidth, targetHeight, permanentId, 3, null), null, 4, null);
        }
    }
}
