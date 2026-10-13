package com.facebook.fresco.vito.core.impl.debug;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.facebook.common.internal.Supplier;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.vito.core.impl.FrescoDrawable2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LightweightDebugOverlayFactory2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayFactory2;", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayFactory2;", "debugOverlayEnabled", "Lcom/facebook/common/internal/Supplier;", "", "config", "Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayConfig;", "colorProvider", "Lcom/facebook/fresco/vito/core/impl/debug/StringAndColorDebugDataProvider;", "debugDataProviders", "", "Lcom/facebook/fresco/vito/core/impl/debug/DebugDataProvider;", "<init>", "(Lcom/facebook/common/internal/Supplier;Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayConfig;Lcom/facebook/fresco/vito/core/impl/debug/StringAndColorDebugDataProvider;Ljava/util/List;)V", "update", "", "drawable", "Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2;", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "setData", "overlay", "Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayDrawable;", "extractText", "", "provider", "buildDebugTextFromProviders", "buildDebugTextFromConfig", "LightweightDebugOverlayDrawableWrapper", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LightweightDebugOverlayFactory2 implements DebugOverlayFactory2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StringAndColorDebugDataProvider colorProvider;
    private final LightweightDebugOverlayConfig config;
    private final List<DebugDataProvider> debugDataProviders;
    private final Supplier<Boolean> debugOverlayEnabled;

    /* JADX WARN: Multi-variable type inference failed */
    public LightweightDebugOverlayFactory2(Supplier<Boolean> debugOverlayEnabled, LightweightDebugOverlayConfig config, StringAndColorDebugDataProvider colorProvider, List<? extends DebugDataProvider> list) {
        Intrinsics.checkNotNullParameter(debugOverlayEnabled, "debugOverlayEnabled");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(colorProvider, "colorProvider");
        this.debugOverlayEnabled = debugOverlayEnabled;
        this.config = config;
        this.colorProvider = colorProvider;
        this.debugDataProviders = list;
    }

    public /* synthetic */ LightweightDebugOverlayFactory2(Supplier supplier, LightweightDebugOverlayConfig lightweightDebugOverlayConfig, StringAndColorDebugDataProvider stringAndColorDebugDataProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(supplier, (i & 2) != 0 ? new LightweightDebugOverlayConfig(false, false, false, false, false, false, 63, null) : lightweightDebugOverlayConfig, (i & 4) != 0 ? FrescoDrawable2DebugDataProvidersKt.getAbbreviatedOriginWithExtrasProvider() : stringAndColorDebugDataProvider, (i & 8) != 0 ? null : list);
    }

    @Override // com.facebook.fresco.vito.core.impl.debug.DebugOverlayFactory2
    public void update(final FrescoDrawable2 drawable, final ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (!this.debugOverlayEnabled.get().booleanValue()) {
            Drawable overlayDrawable = drawable.getOverlayDrawable();
            if (overlayDrawable instanceof LightweightDebugOverlayDrawable) {
                ((LightweightDebugOverlayDrawable) overlayDrawable).setOnBoundsChangedCallback(null);
                return;
            } else {
                if (overlayDrawable instanceof LightweightDebugOverlayDrawableWrapper) {
                    ((LightweightDebugOverlayDrawableWrapper) overlayDrawable).getDebugOverlayDrawable().setOnBoundsChangedCallback(null);
                    return;
                }
                return;
            }
        }
        LightweightDebugOverlayDrawable lightweightDebugOverlayDrawableExtractOrCreate = INSTANCE.extractOrCreate(drawable);
        final Rect rect = new Rect(lightweightDebugOverlayDrawableExtractOrCreate.getBounds());
        lightweightDebugOverlayDrawableExtractOrCreate.reset();
        lightweightDebugOverlayDrawableExtractOrCreate.setOnBoundsChangedCallback(new Function1() { // from class: com.facebook.fresco.vito.core.impl.debug.LightweightDebugOverlayFactory2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LightweightDebugOverlayFactory2.update$lambda$0(rect, this, drawable, extras, (Rect) obj);
            }
        });
        setData(lightweightDebugOverlayDrawableExtractOrCreate, drawable, extras);
        lightweightDebugOverlayDrawableExtractOrCreate.invalidateSelf();
    }

    static final Unit update$lambda$0(Rect rect, LightweightDebugOverlayFactory2 lightweightDebugOverlayFactory2, FrescoDrawable2 frescoDrawable2, ControllerListener2.Extras extras, Rect rect2) {
        if (rect2 != null && !Intrinsics.areEqual(rect2, rect)) {
            lightweightDebugOverlayFactory2.update(frescoDrawable2, extras);
            rect.set(rect2);
        }
        return Unit.INSTANCE;
    }

    private final void setData(LightweightDebugOverlayDrawable overlay, FrescoDrawable2 drawable, ControllerListener2.Extras extras) {
        String strBuildDebugTextFromConfig;
        overlay.setOriginColor(this.colorProvider.getExtractDataAndColor().invoke(drawable, extras).component2().intValue());
        if (this.debugDataProviders != null) {
            strBuildDebugTextFromConfig = buildDebugTextFromProviders(drawable, extras);
        } else {
            strBuildDebugTextFromConfig = buildDebugTextFromConfig(drawable, extras);
        }
        overlay.setDebugText(strBuildDebugTextFromConfig);
    }

    private final String extractText(DebugDataProvider provider, FrescoDrawable2 drawable, ControllerListener2.Extras extras) {
        if (provider instanceof StringDebugDataProvider) {
            return ((StringDebugDataProvider) provider).getExtractData().invoke(drawable, extras);
        }
        if (provider instanceof StringAndColorDebugDataProvider) {
            return ((StringAndColorDebugDataProvider) provider).getExtractDataAndColor().invoke(drawable, extras).getFirst();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String buildDebugTextFromProviders(FrescoDrawable2 drawable, ControllerListener2.Extras extras) {
        ArrayList arrayList = new ArrayList();
        List<DebugDataProvider> list = this.debugDataProviders;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String strExtractText = extractText((DebugDataProvider) it.next(), drawable, extras);
                if (strExtractText.length() > 0) {
                    arrayList.add(strExtractText);
                }
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
    }

    private final String buildDebugTextFromConfig(FrescoDrawable2 drawable, ControllerListener2.Extras extras) {
        ArrayList arrayList = new ArrayList();
        if (this.config.getShowOrigin()) {
            String strExtractText = extractText(FrescoDrawable2DebugDataProvidersKt.getAbbreviatedOriginWithExtrasProvider(), drawable, extras);
            if (strExtractText.length() > 0) {
                arrayList.add(strExtractText);
            }
        }
        if (this.config.getShowDimensions()) {
            String strExtractText2 = extractText(FrescoDrawable2DebugDataProvidersKt.getDrawableDimensionsWithExtrasProvider(), drawable, extras);
            if (strExtractText2.length() > 0) {
                arrayList.add(strExtractText2);
            }
        }
        if (this.config.getShowImageDimensions()) {
            String strExtractText3 = extractText(FrescoDrawable2DebugDataProvidersKt.getActualImageDimensionsWithPrefixProvider(), drawable, extras);
            if (strExtractText3.length() > 0) {
                arrayList.add(strExtractText3);
            }
        }
        if (this.config.getShowFormat()) {
            String strExtractText4 = extractText(FrescoDrawable2DebugDataProvidersKt.getImageFormatProvider(), drawable, extras);
            if (strExtractText4.length() > 0) {
                arrayList.add(strExtractText4);
            }
        }
        if (this.config.getShowScaleType()) {
            String strExtractText5 = extractText(FrescoDrawable2DebugDataProvidersKt.getAbbreviatedScaleTypeProvider(), drawable, extras);
            if (strExtractText5.length() > 0) {
                arrayList.add(strExtractText5);
            }
        }
        if (this.config.getShowUri()) {
            String strExtractText6 = extractText(FrescoDrawable2DebugDataProvidersKt.getImageUriProvider(), drawable, extras);
            if (strExtractText6.length() > 0) {
                arrayList.add(strExtractText6);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: compiled from: LightweightDebugOverlayFactory2.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayFactory2$LightweightDebugOverlayDrawableWrapper;", "Landroid/graphics/drawable/LayerDrawable;", "existingOverlayDrawable", "Landroid/graphics/drawable/Drawable;", "debugOverlayDrawable", "Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayDrawable;", "<init>", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayDrawable;)V", "getDebugOverlayDrawable", "()Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayDrawable;", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class LightweightDebugOverlayDrawableWrapper extends LayerDrawable {
        private final LightweightDebugOverlayDrawable debugOverlayDrawable;

        public final LightweightDebugOverlayDrawable getDebugOverlayDrawable() {
            return this.debugOverlayDrawable;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LightweightDebugOverlayDrawableWrapper(Drawable existingOverlayDrawable, LightweightDebugOverlayDrawable debugOverlayDrawable) {
            super(new Drawable[]{existingOverlayDrawable, debugOverlayDrawable});
            Intrinsics.checkNotNullParameter(existingOverlayDrawable, "existingOverlayDrawable");
            Intrinsics.checkNotNullParameter(debugOverlayDrawable, "debugOverlayDrawable");
            this.debugOverlayDrawable = debugOverlayDrawable;
        }
    }

    /* JADX INFO: compiled from: LightweightDebugOverlayFactory2.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayFactory2$Companion;", "", "<init>", "()V", "extractOrCreate", "Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayDrawable;", "drawable", "Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2;", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final LightweightDebugOverlayDrawable extractOrCreate(FrescoDrawable2 drawable) {
            Drawable overlayDrawable = drawable.getOverlayDrawable();
            if (overlayDrawable instanceof LightweightDebugOverlayDrawable) {
                return (LightweightDebugOverlayDrawable) overlayDrawable;
            }
            if (overlayDrawable instanceof LightweightDebugOverlayDrawableWrapper) {
                return ((LightweightDebugOverlayDrawableWrapper) overlayDrawable).getDebugOverlayDrawable();
            }
            LightweightDebugOverlayDrawable lightweightDebugOverlayDrawable = new LightweightDebugOverlayDrawable();
            if (overlayDrawable != null) {
                drawable.setOverlayDrawable(new LightweightDebugOverlayDrawableWrapper(overlayDrawable, lightweightDebugOverlayDrawable));
                return lightweightDebugOverlayDrawable;
            }
            drawable.setOverlayDrawable(lightweightDebugOverlayDrawable);
            return lightweightDebugOverlayDrawable;
        }
    }
}
