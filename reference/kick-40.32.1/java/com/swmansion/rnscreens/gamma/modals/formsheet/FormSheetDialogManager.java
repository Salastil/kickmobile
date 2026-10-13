package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.content.Context;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.google.android.material.R;
import com.swmansion.rnscreens.gamma.modals.dimmingview.DimmingViewManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: FormSheetDialogManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0000¢\u0006\u0002\b,J\u0016\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\r\u00102\u001a\u00020*H\u0000¢\u0006\u0002\b3R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00065"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialogManager;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "contentView", "Landroid/view/View;", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "formSheetConfig", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetConfig;", "themedContext", "Landroid/view/ContextThemeWrapper;", WebViewRumEventMapper.CONTAINER_KEY_NAME, "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContainer;", "dialog", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialog;", "bottomSheetView", "Landroid/widget/FrameLayout;", "behaviorController", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetBehaviorController;", "dimmingManager", "Lcom/swmansion/rnscreens/gamma/modals/dimmingview/DimmingViewManager;", "appearanceCoordinator", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetAppearanceCoordinator;", "dimensionsCoordinator", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDimensionsCoordinator;", "presentationManager", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetPresentationManager;", "<set-?>", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialogEventEmitter;", "eventEmitter", "getEventEmitter$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialogEventEmitter;", "setEventEmitter$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialogEventEmitter;)V", "eventEmitter$delegate", "Lkotlin/properties/ReadWriteProperty;", "contentSizeChangeDelegate", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentSizeChangeDelegate;", "getContentSizeChangeDelegate$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentSizeChangeDelegate;", "applyConfig", "", "newConfig", "applyConfig$react_native_screens_release", "resolveDetents", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDetents;", "rawDetents", "", "", "destroy", "destroy$react_native_screens_release", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetDialogManager {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(FormSheetDialogManager.class, "eventEmitter", "getEventEmitter$react_native_screens_release()Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialogEventEmitter;", 0))};
    private static final double LARGE_DETENT_FRACTION = 1.0d;
    private final FormSheetAppearanceCoordinator appearanceCoordinator;
    private final FormSheetBehaviorController behaviorController;
    private final FrameLayout bottomSheetView;
    private final FormSheetContainer container;
    private final View contentView;
    private final FormSheetDialog dialog;
    private final FormSheetDimensionsCoordinator dimensionsCoordinator;
    private final DimmingViewManager dimmingManager;

    /* JADX INFO: renamed from: eventEmitter$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty eventEmitter;
    private FormSheetConfig formSheetConfig;
    private final FormSheetPresentationManager presentationManager;
    private final ContextThemeWrapper themedContext;

    public FormSheetDialogManager(Context context, View contentView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
        this.formSheetConfig = new FormSheetConfig(false, null, false, 0, 0.0f, null, 63, null);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.Theme_Material3_DayNight_NoActionBar);
        this.themedContext = contextThemeWrapper;
        FormSheetContainer formSheetContainer = new FormSheetContainer(contextThemeWrapper, contentView);
        this.container = formSheetContainer;
        FormSheetDialog formSheetDialog = new FormSheetDialog(contextThemeWrapper);
        formSheetDialog.setContentView(formSheetContainer);
        formSheetDialog.setCanceledOnTouchOutside(false);
        this.dialog = formSheetDialog;
        FrameLayout frameLayout = (FrameLayout) formSheetDialog.findViewById(R.id.design_bottom_sheet);
        this.bottomSheetView = frameLayout;
        final Object obj = null;
        FormSheetBehaviorController formSheetBehaviorController = frameLayout != null ? new FormSheetBehaviorController(frameLayout, new Function1() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetDialogManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return FormSheetDialogManager.behaviorController$lambda$0$0(this.f$0, ((Integer) obj2).intValue());
            }
        }) : null;
        this.behaviorController = formSheetBehaviorController;
        DimmingViewManager dimmingViewManager = new DimmingViewManager(context, formSheetDialog);
        this.dimmingManager = dimmingViewManager;
        FormSheetAppearanceCoordinator formSheetAppearanceCoordinator = new FormSheetAppearanceCoordinator(frameLayout);
        this.appearanceCoordinator = formSheetAppearanceCoordinator;
        FormSheetDimensionsCoordinator formSheetDimensionsCoordinator = new FormSheetDimensionsCoordinator(formSheetDialog, formSheetContainer, frameLayout, formSheetBehaviorController);
        this.dimensionsCoordinator = formSheetDimensionsCoordinator;
        FormSheetPresentationManager formSheetPresentationManager = new FormSheetPresentationManager(formSheetDialog, frameLayout, dimmingViewManager, new Function0() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetDialogManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormSheetDialogManager.presentationManager$lambda$0(this.f$0);
            }
        });
        this.presentationManager = formSheetPresentationManager;
        Delegates delegates = Delegates.INSTANCE;
        this.eventEmitter = new ObservableProperty<FormSheetDialogEventEmitter>(obj) { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetDialogManager$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, FormSheetDialogEventEmitter oldValue, FormSheetDialogEventEmitter newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                this.presentationManager.setAppearanceEventEmitter$react_native_screens_release(newValue);
            }
        };
        formSheetPresentationManager.setup$react_native_screens_release();
        formSheetAppearanceCoordinator.setup$react_native_screens_release();
        formSheetDimensionsCoordinator.setup$react_native_screens_release();
        if (formSheetBehaviorController != null) {
            formSheetBehaviorController.setup$react_native_screens_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit behaviorController$lambda$0$0(FormSheetDialogManager formSheetDialogManager, int i) {
        FormSheetDialogEventEmitter eventEmitter$react_native_screens_release = formSheetDialogManager.getEventEmitter$react_native_screens_release();
        if (eventEmitter$react_native_screens_release != null) {
            eventEmitter$react_native_screens_release.emitOnDetentChanged(i);
        }
        return Unit.INSTANCE;
    }

    static final Unit presentationManager$lambda$0(FormSheetDialogManager formSheetDialogManager) {
        FormSheetDialogEventEmitter eventEmitter$react_native_screens_release = formSheetDialogManager.getEventEmitter$react_native_screens_release();
        if (eventEmitter$react_native_screens_release != null) {
            eventEmitter$react_native_screens_release.emitOnNativeDismissEvent();
        }
        return Unit.INSTANCE;
    }

    public final FormSheetDialogEventEmitter getEventEmitter$react_native_screens_release() {
        return (FormSheetDialogEventEmitter) this.eventEmitter.getValue(this, $$delegatedProperties[0]);
    }

    public final void setEventEmitter$react_native_screens_release(FormSheetDialogEventEmitter formSheetDialogEventEmitter) {
        this.eventEmitter.setValue(this, $$delegatedProperties[0], formSheetDialogEventEmitter);
    }

    public final FormSheetContentSizeChangeDelegate getContentSizeChangeDelegate$react_native_screens_release() {
        return this.dimensionsCoordinator;
    }

    public final void applyConfig$react_native_screens_release(FormSheetConfig newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        FormSheetConfig formSheetConfig = this.formSheetConfig;
        this.formSheetConfig = newConfig;
        boolean z = !formSheetConfig.isOpen() && newConfig.isOpen();
        if (!Intrinsics.areEqual(formSheetConfig.getDetents(), newConfig.getDetents()) || z) {
            this.dimensionsCoordinator.updateFormSheetDimensions$react_native_screens_release(resolveDetents(newConfig.getDetents()), newConfig.getInitialDetentIndex(), z);
        }
        if (formSheetConfig.getPrefersGrabberVisible() != newConfig.getPrefersGrabberVisible()) {
            this.container.setGrabberVisible$react_native_screens_release(newConfig.getPrefersGrabberVisible());
        }
        if (formSheetConfig.getPreferredCornerRadius() != newConfig.getPreferredCornerRadius()) {
            this.appearanceCoordinator.updateCornerRadius$react_native_screens_release(newConfig.getPreferredCornerRadius());
        }
        if (!Intrinsics.areEqual(formSheetConfig.getNativeContainerBackgroundColor(), newConfig.getNativeContainerBackgroundColor())) {
            this.appearanceCoordinator.updateBackgroundColor$react_native_screens_release(newConfig.getNativeContainerBackgroundColor());
        }
        if (formSheetConfig.isOpen() != newConfig.isOpen()) {
            this.presentationManager.updatePresentationState$react_native_screens_release(newConfig.isOpen());
        }
    }

    private final FormSheetDetents resolveDetents(List<Double> rawDetents) {
        boolean zIsEmpty = rawDetents.isEmpty();
        Double dValueOf = Double.valueOf(1.0d);
        if (zIsEmpty) {
            return new FormSheetDetents(CollectionsKt.listOf(dValueOf));
        }
        try {
            return new FormSheetDetents(rawDetents);
        } catch (IllegalArgumentException e) {
            Log.e("[RNScreens]", "Invalid FormSheet detents: " + rawDetents + ". Falling back to large detent.", e);
            return new FormSheetDetents(CollectionsKt.listOf(dValueOf));
        }
    }

    public final void destroy$react_native_screens_release() {
        FormSheetBehaviorController formSheetBehaviorController = this.behaviorController;
        if (formSheetBehaviorController != null) {
            formSheetBehaviorController.destroy$react_native_screens_release();
        }
        this.presentationManager.destroy$react_native_screens_release();
        this.dimensionsCoordinator.destroy$react_native_screens_release();
        this.dialog.dismiss();
    }
}
