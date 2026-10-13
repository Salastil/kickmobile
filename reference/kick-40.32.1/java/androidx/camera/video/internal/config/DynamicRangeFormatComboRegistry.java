package androidx.camera.video.internal.config;

import android.os.Build;
import androidx.camera.core.DynamicRange;
import androidx.media3.common.MimeTypes;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DynamicRangeFormatComboRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\rJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u0005J\b\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\u0016\u0010%\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0019\u0010\u0016¨\u0006("}, d2 = {"Landroidx/camera/video/internal/config/DynamicRangeFormatComboRegistry;", "", "<init>", "()V", "MIMETYPE_VIDEO_HEVC_GATED", "", "MIMETYPE_VIDEO_VP9_GATED", "MIMETYPE_AUDIO_OPUS_GATED", "MIMETYPE_VIDEO_DOLBY_VISION_GATED", "MIMETYPE_VIDEO_AV1_GATED", "MIMETYPE_VIDEO_APV_GATED", "registries", "", "Landroidx/camera/core/DynamicRange;", "Landroidx/camera/video/internal/config/FormatComboRegistry;", "getRegistries", "()Ljava/util/Map;", "registries$delegate", "Lkotlin/Lazy;", "standardMp4Audios", "", "getStandardMp4Audios", "()Ljava/util/List;", "standardMp4Audios$delegate", "standardWebmAudios", "getStandardWebmAudios", "standardWebmAudios$delegate", "getRegistry", "dynamicRange", "getDynamicRangesForVideoMime", "", "videoMime", "buildSdrRegistry", "buildHlgRegistry", "buildHdr10Registry", "buildHdr10PlusRegistry", "buildDolbyVisionRegistry", "takeIf", "minSdk", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicRangeFormatComboRegistry {
    public static final DynamicRangeFormatComboRegistry INSTANCE;
    private static final String MIMETYPE_AUDIO_OPUS_GATED;
    private static final String MIMETYPE_VIDEO_APV_GATED;
    private static final String MIMETYPE_VIDEO_AV1_GATED;
    private static final String MIMETYPE_VIDEO_DOLBY_VISION_GATED;
    private static final String MIMETYPE_VIDEO_HEVC_GATED;
    private static final String MIMETYPE_VIDEO_VP9_GATED;

    /* JADX INFO: renamed from: registries$delegate, reason: from kotlin metadata */
    private static final Lazy registries;

    /* JADX INFO: renamed from: standardMp4Audios$delegate, reason: from kotlin metadata */
    private static final Lazy standardMp4Audios;

    /* JADX INFO: renamed from: standardWebmAudios$delegate, reason: from kotlin metadata */
    private static final Lazy standardWebmAudios;

    private DynamicRangeFormatComboRegistry() {
    }

    static {
        DynamicRangeFormatComboRegistry dynamicRangeFormatComboRegistry = new DynamicRangeFormatComboRegistry();
        INSTANCE = dynamicRangeFormatComboRegistry;
        MIMETYPE_VIDEO_HEVC_GATED = dynamicRangeFormatComboRegistry.takeIf("video/hevc", 24);
        MIMETYPE_VIDEO_VP9_GATED = dynamicRangeFormatComboRegistry.takeIf("video/x-vnd.on2.vp9", 24);
        MIMETYPE_AUDIO_OPUS_GATED = dynamicRangeFormatComboRegistry.takeIf(MimeTypes.AUDIO_OPUS, 29);
        MIMETYPE_VIDEO_DOLBY_VISION_GATED = dynamicRangeFormatComboRegistry.takeIf(MimeTypes.VIDEO_DOLBY_VISION, 33);
        MIMETYPE_VIDEO_AV1_GATED = dynamicRangeFormatComboRegistry.takeIf("video/av01", 34);
        MIMETYPE_VIDEO_APV_GATED = dynamicRangeFormatComboRegistry.takeIf(MimeTypes.VIDEO_APV, 36);
        registries = LazyKt.lazy(new Function0() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DynamicRangeFormatComboRegistry.registries_delegate$lambda$0();
            }
        });
        standardMp4Audios = LazyKt.lazy(new Function0() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionsKt.listOfNotNull((Object[]) new String[]{"audio/mp4a-latm", MimeTypes.AUDIO_AMR_NB, MimeTypes.AUDIO_AMR_WB});
            }
        });
        standardWebmAudios = LazyKt.lazy(new Function0() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionsKt.listOfNotNull((Object[]) new String[]{MimeTypes.AUDIO_VORBIS, DynamicRangeFormatComboRegistry.MIMETYPE_AUDIO_OPUS_GATED});
            }
        });
    }

    private final Map<DynamicRange, FormatComboRegistry> getRegistries() {
        return (Map) registries.getValue();
    }

    static final Map registries_delegate$lambda$0() {
        DynamicRange dynamicRange = DynamicRange.SDR;
        DynamicRangeFormatComboRegistry dynamicRangeFormatComboRegistry = INSTANCE;
        return MapsKt.mutableMapOf(TuplesKt.to(dynamicRange, dynamicRangeFormatComboRegistry.buildSdrRegistry()), TuplesKt.to(DynamicRange.HLG_10_BIT, dynamicRangeFormatComboRegistry.buildHlgRegistry()), TuplesKt.to(DynamicRange.HDR10_10_BIT, dynamicRangeFormatComboRegistry.buildHdr10Registry()), TuplesKt.to(DynamicRange.HDR10_PLUS_10_BIT, dynamicRangeFormatComboRegistry.buildHdr10PlusRegistry()), TuplesKt.to(DynamicRange.DOLBY_VISION_8_BIT, dynamicRangeFormatComboRegistry.buildDolbyVisionRegistry()), TuplesKt.to(DynamicRange.DOLBY_VISION_10_BIT, dynamicRangeFormatComboRegistry.buildDolbyVisionRegistry()));
    }

    private final List<String> getStandardMp4Audios() {
        return (List) standardMp4Audios.getValue();
    }

    private final List<String> getStandardWebmAudios() {
        return (List) standardWebmAudios.getValue();
    }

    public final FormatComboRegistry getRegistry(DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        return getRegistries().get(dynamicRange);
    }

    public final Set<DynamicRange> getDynamicRangesForVideoMime(String videoMime) {
        Intrinsics.checkNotNullParameter(videoMime, "videoMime");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<DynamicRange, FormatComboRegistry> entry : getRegistries().entrySet()) {
            DynamicRange key = entry.getKey();
            if (!entry.getValue().getCombosForVideo(videoMime).isEmpty()) {
                linkedHashSet.add(key);
            }
        }
        return linkedHashSet;
    }

    private final FormatComboRegistry buildSdrRegistry() {
        FormatComboRegistry.Builder builder = new FormatComboRegistry.Builder();
        builder.container(0, new Function1() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DynamicRangeFormatComboRegistry.buildSdrRegistry$lambda$0$0((FormatComboRegistry.Builder.ContainerScope) obj);
            }
        });
        builder.container(1, new Function1() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DynamicRangeFormatComboRegistry.buildSdrRegistry$lambda$0$1((FormatComboRegistry.Builder.ContainerScope) obj);
            }
        });
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildSdrRegistry$lambda$0$0(FormatComboRegistry.Builder.ContainerScope container) {
        Intrinsics.checkNotNullParameter(container, "$this$container");
        container.support(CollectionsKt.listOfNotNull((Object[]) new String[]{"video/avc", MimeTypes.VIDEO_MP4V, MimeTypes.VIDEO_H263, MIMETYPE_VIDEO_HEVC_GATED, MIMETYPE_VIDEO_DOLBY_VISION_GATED, MIMETYPE_VIDEO_AV1_GATED, MIMETYPE_VIDEO_APV_GATED}), INSTANCE.getStandardMp4Audios());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildSdrRegistry$lambda$0$1(FormatComboRegistry.Builder.ContainerScope container) {
        Intrinsics.checkNotNullParameter(container, "$this$container");
        container.support(CollectionsKt.listOfNotNull((Object[]) new String[]{MimeTypes.VIDEO_VP8, MIMETYPE_VIDEO_VP9_GATED}), INSTANCE.getStandardWebmAudios());
        return Unit.INSTANCE;
    }

    private final FormatComboRegistry buildHlgRegistry() {
        FormatComboRegistry.Builder builder = new FormatComboRegistry.Builder();
        builder.container(0, new Function1() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DynamicRangeFormatComboRegistry.buildHlgRegistry$lambda$0$0((FormatComboRegistry.Builder.ContainerScope) obj);
            }
        });
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildHlgRegistry$lambda$0$0(FormatComboRegistry.Builder.ContainerScope container) {
        Intrinsics.checkNotNullParameter(container, "$this$container");
        container.support(CollectionsKt.listOfNotNull((Object[]) new String[]{MIMETYPE_VIDEO_HEVC_GATED, MIMETYPE_VIDEO_AV1_GATED, MIMETYPE_VIDEO_APV_GATED}), INSTANCE.getStandardMp4Audios());
        return Unit.INSTANCE;
    }

    private final FormatComboRegistry buildHdr10Registry() {
        FormatComboRegistry.Builder builder = new FormatComboRegistry.Builder();
        builder.container(0, new Function1() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DynamicRangeFormatComboRegistry.buildHdr10Registry$lambda$0$0((FormatComboRegistry.Builder.ContainerScope) obj);
            }
        });
        builder.container(1, new Function1() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DynamicRangeFormatComboRegistry.buildHdr10Registry$lambda$0$1((FormatComboRegistry.Builder.ContainerScope) obj);
            }
        });
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildHdr10Registry$lambda$0$0(FormatComboRegistry.Builder.ContainerScope container) {
        Intrinsics.checkNotNullParameter(container, "$this$container");
        container.support(CollectionsKt.listOfNotNull((Object[]) new String[]{MIMETYPE_VIDEO_HEVC_GATED, MIMETYPE_VIDEO_AV1_GATED, MIMETYPE_VIDEO_APV_GATED}), INSTANCE.getStandardMp4Audios());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildHdr10Registry$lambda$0$1(FormatComboRegistry.Builder.ContainerScope container) {
        Intrinsics.checkNotNullParameter(container, "$this$container");
        container.support(CollectionsKt.listOfNotNull(MIMETYPE_VIDEO_VP9_GATED), INSTANCE.getStandardWebmAudios());
        return Unit.INSTANCE;
    }

    private final FormatComboRegistry buildHdr10PlusRegistry() {
        FormatComboRegistry.Builder builder = new FormatComboRegistry.Builder();
        builder.container(0, new Function1() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DynamicRangeFormatComboRegistry.buildHdr10PlusRegistry$lambda$0$0((FormatComboRegistry.Builder.ContainerScope) obj);
            }
        });
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildHdr10PlusRegistry$lambda$0$0(FormatComboRegistry.Builder.ContainerScope container) {
        Intrinsics.checkNotNullParameter(container, "$this$container");
        container.support(CollectionsKt.listOfNotNull((Object[]) new String[]{MIMETYPE_VIDEO_HEVC_GATED, MIMETYPE_VIDEO_AV1_GATED}), INSTANCE.getStandardMp4Audios());
        return Unit.INSTANCE;
    }

    private final FormatComboRegistry buildDolbyVisionRegistry() {
        FormatComboRegistry.Builder builder = new FormatComboRegistry.Builder();
        builder.container(0, new Function1() { // from class: androidx.camera.video.internal.config.DynamicRangeFormatComboRegistry$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DynamicRangeFormatComboRegistry.buildDolbyVisionRegistry$lambda$0$0((FormatComboRegistry.Builder.ContainerScope) obj);
            }
        });
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildDolbyVisionRegistry$lambda$0$0(FormatComboRegistry.Builder.ContainerScope container) {
        Intrinsics.checkNotNullParameter(container, "$this$container");
        container.support(CollectionsKt.listOfNotNull(MIMETYPE_VIDEO_DOLBY_VISION_GATED), INSTANCE.getStandardMp4Audios());
        return Unit.INSTANCE;
    }

    private final String takeIf(String str, int i) {
        if (Build.VERSION.SDK_INT >= i) {
            return str;
        }
        return null;
    }
}
