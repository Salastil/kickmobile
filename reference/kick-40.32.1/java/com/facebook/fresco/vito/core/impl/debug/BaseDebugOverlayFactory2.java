package com.facebook.fresco.vito.core.impl.debug;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.facebook.common.internal.Supplier;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.impl.FrescoDrawable2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseDebugOverlayFactory2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fH$R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/BaseDebugOverlayFactory2;", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayFactory2;", "debugOverlayEnabled", "Lcom/facebook/common/internal/Supplier;", "", "<init>", "(Lcom/facebook/common/internal/Supplier;)V", "update", "", "drawable", "Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2;", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "setData", "overlay", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayDrawable;", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "DebugOverlayDrawableWrapper", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseDebugOverlayFactory2 implements DebugOverlayFactory2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Supplier<Boolean> debugOverlayEnabled;

    protected abstract void setData(DebugOverlayDrawable overlay, FrescoDrawableInterface drawable, ControllerListener2.Extras extras);

    public BaseDebugOverlayFactory2(Supplier<Boolean> debugOverlayEnabled) {
        Intrinsics.checkNotNullParameter(debugOverlayEnabled, "debugOverlayEnabled");
        this.debugOverlayEnabled = debugOverlayEnabled;
    }

    @Override // com.facebook.fresco.vito.core.impl.debug.DebugOverlayFactory2
    public void update(final FrescoDrawable2 drawable, final ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this.debugOverlayEnabled.get().booleanValue()) {
            DebugOverlayDrawable debugOverlayDrawableExtractOrCreate = INSTANCE.extractOrCreate(drawable);
            debugOverlayDrawableExtractOrCreate.reset();
            debugOverlayDrawableExtractOrCreate.setOnBoundsChangedCallback(new Function1() { // from class: com.facebook.fresco.vito.core.impl.debug.BaseDebugOverlayFactory2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseDebugOverlayFactory2.update$lambda$0(this.f$0, drawable, extras, (Rect) obj);
                }
            });
            setData(debugOverlayDrawableExtractOrCreate, drawable, extras);
            debugOverlayDrawableExtractOrCreate.invalidateSelf();
        }
    }

    static final Unit update$lambda$0(BaseDebugOverlayFactory2 baseDebugOverlayFactory2, FrescoDrawable2 frescoDrawable2, ControllerListener2.Extras extras, Rect rect) {
        baseDebugOverlayFactory2.update(frescoDrawable2, extras);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: BaseDebugOverlayFactory2.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/BaseDebugOverlayFactory2$DebugOverlayDrawableWrapper;", "Landroid/graphics/drawable/LayerDrawable;", "existingOverlayDrawable", "Landroid/graphics/drawable/Drawable;", "debugOverlayDrawable", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayDrawable;", "<init>", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayDrawable;)V", "getDebugOverlayDrawable", "()Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayDrawable;", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class DebugOverlayDrawableWrapper extends LayerDrawable {
        private final DebugOverlayDrawable debugOverlayDrawable;

        public final DebugOverlayDrawable getDebugOverlayDrawable() {
            return this.debugOverlayDrawable;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DebugOverlayDrawableWrapper(Drawable existingOverlayDrawable, DebugOverlayDrawable debugOverlayDrawable) {
            super(new Drawable[]{existingOverlayDrawable, debugOverlayDrawable});
            Intrinsics.checkNotNullParameter(existingOverlayDrawable, "existingOverlayDrawable");
            Intrinsics.checkNotNullParameter(debugOverlayDrawable, "debugOverlayDrawable");
            this.debugOverlayDrawable = debugOverlayDrawable;
        }
    }

    /* JADX INFO: compiled from: BaseDebugOverlayFactory2.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/BaseDebugOverlayFactory2$Companion;", "", "<init>", "()V", "extractOrCreate", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayDrawable;", "drawable", "Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2;", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DebugOverlayDrawable extractOrCreate(FrescoDrawable2 drawable) {
            Drawable overlayDrawable = drawable.getOverlayDrawable();
            if (overlayDrawable instanceof DebugOverlayDrawable) {
                return (DebugOverlayDrawable) overlayDrawable;
            }
            if (overlayDrawable instanceof DebugOverlayDrawableWrapper) {
                return ((DebugOverlayDrawableWrapper) overlayDrawable).getDebugOverlayDrawable();
            }
            DebugOverlayDrawable debugOverlayDrawable = new DebugOverlayDrawable("v2", 0, 2, null);
            if (overlayDrawable != null) {
                drawable.setOverlayDrawable(new DebugOverlayDrawableWrapper(overlayDrawable, debugOverlayDrawable));
                return debugOverlayDrawable;
            }
            drawable.setOverlayDrawable(debugOverlayDrawable);
            return debugOverlayDrawable;
        }
    }
}
