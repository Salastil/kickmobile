package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.autofill.HintConstants;
import androidx.core.view.GravityCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.R;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.internal.SystraceSection;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.IViewManagerWithChildren;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ReferenceStateWrapper;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.view.ImportantForInteractionHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactTextViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = "RCTText")
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u001c\b\u0017\u0018\u0000 ]2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001]B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010)\u001a\u00020*H\u0002J\u0016\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0018\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/H\u0016J0\u00100\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u00105\u001a\u000202H\u0016J\u001a\u00106\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u00108\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u001eH\u0007J\u0018\u0010:\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010;\u001a\u000202H\u0007J\u001a\u0010<\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010=\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010>\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u001eH\u0007J\u0018\u0010@\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010A\u001a\u00020BH\u0007J\u0018\u0010C\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010D\u001a\u00020BH\u0007J\u001a\u0010E\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010F\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010G\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u001eH\u0007J\u001f\u0010I\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010J\u001a\u0004\u0018\u000102H\u0007¢\u0006\u0002\u0010KJ\u001a\u0010L\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010M\u001a\u0004\u0018\u00010\u0011H\u0007J \u0010N\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010O\u001a\u0002022\u0006\u0010P\u001a\u00020BH\u0007J\u001a\u0010Q\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010\u0011H\u0007J \u0010S\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010O\u001a\u0002022\u0006\u0010T\u001a\u00020BH\u0007J'\u0010U\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010O\u001a\u0002022\b\u0010J\u001a\u0004\u0018\u000102H\u0007¢\u0006\u0002\u0010VJ\u0018\u0010W\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010X\u001a\u00020\u001eH\u0007J\u0018\u0010Y\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020\u001eH\u0007J\u001a\u0010[\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\\\u001a\u0004\u0018\u00010\u0011H\u0007R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006^"}, d2 = {"Lcom/facebook/react/views/text/ReactTextViewManager;", "Lcom/facebook/react/uimanager/BaseViewManager;", "Lcom/facebook/react/views/text/ReactTextView;", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "Lcom/facebook/react/uimanager/IViewManagerWithChildren;", "Lcom/facebook/react/views/text/ReactTextViewManagerCallback;", "reactTextViewManagerCallback", "<init>", "(Lcom/facebook/react/views/text/ReactTextViewManagerCallback;)V", "getReactTextViewManagerCallback", "()Lcom/facebook/react/views/text/ReactTextViewManagerCallback;", "setReactTextViewManagerCallback", "prepareToRecycleView", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "view", "getName", "", "updateViewAccessibility", "", "createViewInstance", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "updateExtraData", "extraData", "", "createShadowNodeInstance", "getShadowNodeClass", "Ljava/lang/Class;", "onAfterUpdateTransaction", "needsCustomLayoutForChildren", "", "updateState", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getReactTextUpdate", "state", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "getReactTextUpdateFromPreparedLayout", "Lcom/facebook/react/views/text/ReactTextUpdate;", "preparedLayout", "Lcom/facebook/react/views/text/PreparedLayout;", "getExportedCustomDirectEventTypeConstants", "", "onPostProcessSpannable", "text", "Landroid/text/Spannable;", "setPadding", "left", "", ViewProps.TOP, "right", ViewProps.BOTTOM, "setOverflow", ViewProps.OVERFLOW, "setAccessible", "accessible", "setNumberOfLines", ViewProps.NUMBER_OF_LINES, "setEllipsizeMode", ViewProps.ELLIPSIZE_MODE, "setAdjustFontSizeToFit", ViewProps.ADJUSTS_FONT_SIZE_TO_FIT, "setFontSize", ViewProps.FONT_SIZE, "", "setLetterSpacing", ViewProps.LETTER_SPACING, "setTextAlignVertical", ViewProps.TEXT_ALIGN_VERTICAL, "setSelectable", "isSelectable", "setSelectionColor", "color", "(Lcom/facebook/react/views/text/ReactTextView;Ljava/lang/Integer;)V", "setAndroidHyphenationFrequency", "frequency", "setBorderRadius", FirebaseAnalytics.Param.INDEX, ViewProps.BORDER_RADIUS, "setBorderStyle", "borderStyle", "setBorderWidth", ViewProps.WIDTH, "setBorderColor", "(Lcom/facebook/react/views/text/ReactTextView;ILjava/lang/Integer;)V", "setIncludeFontPadding", "includepad", "setDisabled", "disabled", "setDataDetectorType", "type", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ReactTextViewManager extends BaseViewManager<ReactTextView, LayoutShadowNode> implements IViewManagerWithChildren, ReactTextViewManagerCallback {
    public static final String REACT_CLASS = "RCTText";
    private static final short TX_STATE_KEY_ATTRIBUTED_STRING = 0;
    private static final short TX_STATE_KEY_PARAGRAPH_ATTRIBUTES = 1;
    private ReactTextViewManagerCallback reactTextViewManagerCallback;

    /* JADX INFO: compiled from: ReactTextViewManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReactTextViewManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public /* synthetic */ ReactTextViewManager(ReactTextViewManagerCallback reactTextViewManagerCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : reactTextViewManagerCallback);
    }

    protected final ReactTextViewManagerCallback getReactTextViewManagerCallback() {
        return this.reactTextViewManagerCallback;
    }

    protected final void setReactTextViewManagerCallback(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        this.reactTextViewManagerCallback = reactTextViewManagerCallback;
    }

    public ReactTextViewManager(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        this.reactTextViewManagerCallback = reactTextViewManagerCallback;
        if (ReactNativeFeatureFlags.enableViewRecyclingForText()) {
            setupViewRecycling();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public ReactTextView prepareToRecycleView(ThemedReactContext reactContext, ReactTextView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        ReactTextView reactTextView = (ReactTextView) super.prepareToRecycleView(reactContext, view);
        if (reactTextView != null) {
            reactTextView.recycleView();
            setSelectionColor(reactTextView, null);
        }
        return reactTextView;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTText";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager
    public void updateViewAccessibility(ReactTextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ReactTextViewAccessibilityDelegate.INSTANCE.setDelegate(view, view.isFocusable(), view.getImportantForAccessibility());
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactTextView createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ReactTextView(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(ReactTextView view, Object extraData) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        SystraceSection systraceSection = new SystraceSection("ReactTextViewManager.updateExtraData");
        try {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) extraData;
            Spanned text = reactTextUpdate.getText();
            view.setText(reactTextUpdate);
            ReactTextViewAccessibilityDelegate.AccessibilityLinks accessibilityLinks = new ReactTextViewAccessibilityDelegate.AccessibilityLinks(text);
            int i = R.id.accessibility_links;
            if (accessibilityLinks.size() <= 0) {
                accessibilityLinks = null;
            }
            view.setTag(i, accessibilityLinks);
            ReactTextViewAccessibilityDelegate.INSTANCE.resetDelegate(view, view.isFocusable(), view.getImportantForAccessibility());
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(systraceSection, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(systraceSection, th);
                throw th2;
            }
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new LayoutShadowNode();
    }

    public final LayoutShadowNode createShadowNodeInstance(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new LayoutShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<LayoutShadowNode> getShadowNodeClass() {
        return LayoutShadowNode.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactTextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.updateView();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ReactTextView view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        SystraceSection systraceSection = new SystraceSection("ReactTextViewManager.updateState");
        try {
            ReferenceStateWrapper referenceStateWrapper = stateWrapper instanceof ReferenceStateWrapper ? (ReferenceStateWrapper) stateWrapper : null;
            Object stateDataReference = referenceStateWrapper != null ? referenceStateWrapper.getStateDataReference() : null;
            if (stateDataReference instanceof PreparedLayout) {
                ReactTextUpdate reactTextUpdateFromPreparedLayout = getReactTextUpdateFromPreparedLayout(view, (PreparedLayout) stateDataReference);
                AutoCloseableKt.closeFinally(systraceSection, null);
                return reactTextUpdateFromPreparedLayout;
            }
            ReadableMapBuffer stateDataMapBuffer = stateWrapper.getStateDataMapBuffer();
            Object reactTextUpdate = stateDataMapBuffer != null ? getReactTextUpdate(view, props, stateDataMapBuffer) : null;
            AutoCloseableKt.closeFinally(systraceSection, null);
            return reactTextUpdate;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(systraceSection, th);
                throw th2;
            }
        }
    }

    private final Object getReactTextUpdate(ReactTextView view, ReactStylesDiffMap props, MapBuffer state) {
        MapBuffer mapBuffer = state.getMapBuffer(0);
        MapBuffer mapBuffer2 = state.getMapBuffer(1);
        TextLayoutManager textLayoutManager = TextLayoutManager.INSTANCE;
        AssetManager assets = view.getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Spannable orCreateSpannableForText$ReactAndroid = textLayoutManager.getOrCreateSpannableForText$ReactAndroid(assets, ReactTypefaceUtils.getFontWeightAdjustment(context), mapBuffer, this.reactTextViewManagerCallback, TextEffectRegistry.current);
        view.setSpanned(orCreateSpannableForText$ReactAndroid);
        view.setMinimumFontSize((float) mapBuffer2.getDouble(6));
        view.setPreparedLayout(null);
        return new ReactTextUpdate(orCreateSpannableForText$ReactAndroid, -1, TextLayoutManager.getTextGravity(mapBuffer, orCreateSpannableForText$ReactAndroid), TextAttributeProps.INSTANCE.getTextBreakStrategy(mapBuffer2.getString(2)), TextAttributeProps.INSTANCE.getJustificationMode(props, Build.VERSION.SDK_INT >= 26 ? view.getJustificationMode() : 0));
    }

    private final ReactTextUpdate getReactTextUpdateFromPreparedLayout(ReactTextView view, PreparedLayout preparedLayout) {
        Layout layout = preparedLayout.getLayout();
        CharSequence text = layout.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        SpannableString spannableString = text instanceof Spannable ? (Spannable) text : new SpannableString(text);
        view.setSpanned(spannableString);
        view.setPreparedLayout(preparedLayout);
        int i = WhenMappings.$EnumSwitchMapping$0[layout.getAlignment().ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = i != 2 ? 8388611 : GravityCompat.END;
        }
        return new ReactTextUpdate(spannableString, -1, i2, preparedLayout.getTextBreakStrategy(), preparedLayout.getJustificationMode());
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        HashMap exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapsKt.mapOf(TuplesKt.to("topTextLayout", MapsKt.mapOf(TuplesKt.to("registrationName", "onTextLayout")))));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.views.text.ReactTextViewManagerCallback
    public void onPostProcessSpannable(Spannable text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ReactTextViewManagerCallback reactTextViewManagerCallback = this.reactTextViewManagerCallback;
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(text);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void setPadding(ReactTextView view, int left, int top, int right, int bottom) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPadding(left, top, right, bottom);
    }

    @ReactProp(name = ViewProps.OVERFLOW)
    public final void setOverflow(ReactTextView view, String overflow) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOverflow(overflow);
        ReactTextView reactTextView = view;
        PointerEvents pointerEvents = PointerEvents.AUTO;
        Overflow overflow2 = view.getOverflow();
        Intrinsics.checkNotNullExpressionValue(overflow2, "getOverflow(...)");
        ImportantForInteractionHelper.setImportantForInteraction(reactTextView, pointerEvents, overflow2);
    }

    @ReactProp(name = "accessible")
    public final void setAccessible(ReactTextView view, boolean accessible) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFocusable(accessible);
    }

    @ReactProp(defaultInt = Integer.MAX_VALUE, name = ViewProps.NUMBER_OF_LINES)
    public final void setNumberOfLines(ReactTextView view, int numberOfLines) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNumberOfLines(numberOfLines);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r3.equals("tail") == false) goto L25;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @com.facebook.react.uimanager.annotations.ReactProp(name = com.facebook.react.uimanager.ViewProps.ELLIPSIZE_MODE)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setEllipsizeMode(com.facebook.react.views.text.ReactTextView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r1 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            if (r3 == 0) goto L5d
            int r1 = r3.hashCode()
            switch(r1) {
                case -1074341483: goto L35;
                case 3056464: goto L27;
                case 3198432: goto L18;
                case 3552336: goto Lf;
                default: goto Le;
            }
        Le:
            goto L44
        Lf:
            java.lang.String r1 = "tail"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L5d
            goto L44
        L18:
            java.lang.String r1 = "head"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L21
            goto L44
        L21:
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.START
            r2.setEllipsizeLocation(r1)
            return
        L27:
            java.lang.String r1 = "clip"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L30
            goto L44
        L30:
            r1 = 0
            r2.setEllipsizeLocation(r1)
            return
        L35:
            java.lang.String r1 = "middle"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L3e
            goto L44
        L3e:
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.MIDDLE
            r2.setEllipsizeLocation(r1)
            return
        L44:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid ellipsizeMode: "
            r1.<init>(r0)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "ReactNative"
            com.facebook.common.logging.FLog.w(r3, r1)
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.END
            r2.setEllipsizeLocation(r1)
            return
        L5d:
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.END
            r2.setEllipsizeLocation(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextViewManager.setEllipsizeMode(com.facebook.react.views.text.ReactTextView, java.lang.String):void");
    }

    @ReactProp(name = ViewProps.ADJUSTS_FONT_SIZE_TO_FIT)
    public final void setAdjustFontSizeToFit(ReactTextView view, boolean adjustsFontSizeToFit) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAdjustFontSizeToFit(adjustsFontSizeToFit);
    }

    @ReactProp(name = ViewProps.FONT_SIZE)
    public final void setFontSize(ReactTextView view, float fontSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFontSize(fontSize);
    }

    @ReactProp(defaultFloat = 0.0f, name = ViewProps.LETTER_SPACING)
    public final void setLetterSpacing(ReactTextView view, float letterSpacing) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLetterSpacing(letterSpacing);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r4.equals("auto") == false) goto L25;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @com.facebook.react.uimanager.annotations.ReactProp(name = com.facebook.react.uimanager.ViewProps.TEXT_ALIGN_VERTICAL)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setTextAlignVertical(com.facebook.react.views.text.ReactTextView r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r2 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 0
            if (r4 == 0) goto L5d
            int r0 = r4.hashCode()
            switch(r0) {
                case -1383228885: goto L37;
                case -1364013995: goto L28;
                case 115029: goto L19;
                case 3005871: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L46
        L10:
            java.lang.String r0 = "auto"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L5d
            goto L46
        L19:
            java.lang.String r0 = "top"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L22
            goto L46
        L22:
            r2 = 48
            r3.setGravityVertical(r2)
            return
        L28:
            java.lang.String r0 = "center"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L31
            goto L46
        L31:
            r2 = 16
            r3.setGravityVertical(r2)
            return
        L37:
            java.lang.String r0 = "bottom"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L40
            goto L46
        L40:
            r2 = 80
            r3.setGravityVertical(r2)
            return
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid textAlignVertical: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "ReactNative"
            com.facebook.common.logging.FLog.w(r0, r4)
            r3.setGravityVertical(r2)
            return
        L5d:
            r3.setGravityVertical(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextViewManager.setTextAlignVertical(com.facebook.react.views.text.ReactTextView, java.lang.String):void");
    }

    @ReactProp(name = "selectable")
    public final void setSelectable(ReactTextView view, boolean isSelectable) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTextIsSelectable(isSelectable);
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public final void setSelectionColor(ReactTextView view, Integer color) {
        int defaultTextColorHighlight;
        Intrinsics.checkNotNullParameter(view, "view");
        if (color != null) {
            defaultTextColorHighlight = color.intValue();
        } else {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            defaultTextColorHighlight = DefaultStyleValuesUtil.getDefaultTextColorHighlight(context);
        }
        view.setHighlightColor(defaultTextColorHighlight);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r4.equals("none") == false) goto L21;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "android_hyphenationFrequency")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setAndroidHyphenationFrequency(com.facebook.react.views.text.ReactTextView r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r2 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 0
            if (r4 == 0) goto L57
            int r0 = r4.hashCode()
            r1 = -1039745817(0xffffffffc206bce7, float:-33.684475)
            if (r0 == r1) goto L33
            r1 = 3154575(0x30228f, float:4.420501E-39)
            if (r0 == r1) goto L25
            r1 = 3387192(0x33af38, float:4.746467E-39)
            if (r0 == r1) goto L1c
            goto L3b
        L1c:
            java.lang.String r0 = "none"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L57
            goto L3b
        L25:
            java.lang.String r0 = "full"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L2e
            goto L3b
        L2e:
            r2 = 2
            r3.setHyphenationFrequency(r2)
            return
        L33:
            java.lang.String r0 = "normal"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L52
        L3b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid android_hyphenationFrequency: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "ReactNative"
            com.facebook.common.logging.FLog.w(r0, r4)
            r3.setHyphenationFrequency(r2)
            return
        L52:
            r2 = 1
            r3.setHyphenationFrequency(r2)
            return
        L57:
            r3.setHyphenationFrequency(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextViewManager.setAndroidHyphenationFrequency(com.facebook.react.views.text.ReactTextView, java.lang.String):void");
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {ViewProps.BORDER_RADIUS, ViewProps.BORDER_TOP_LEFT_RADIUS, ViewProps.BORDER_TOP_RIGHT_RADIUS, ViewProps.BORDER_BOTTOM_RIGHT_RADIUS, ViewProps.BORDER_BOTTOM_LEFT_RADIUS})
    public final void setBorderRadius(ReactTextView view, int index, float borderRadius) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderRadius(view, BorderRadiusProp.values()[index], Float.isNaN(borderRadius) ? null : new LengthPercentage(borderRadius, LengthPercentageType.POINT));
    }

    @ReactProp(name = "borderStyle")
    public final void setBorderStyle(ReactTextView view, String borderStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderStyle(view, borderStyle == null ? null : BorderStyle.INSTANCE.fromString(borderStyle));
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {ViewProps.BORDER_WIDTH, ViewProps.BORDER_LEFT_WIDTH, ViewProps.BORDER_RIGHT_WIDTH, ViewProps.BORDER_TOP_WIDTH, ViewProps.BORDER_BOTTOM_WIDTH, ViewProps.BORDER_START_WIDTH, ViewProps.BORDER_END_WIDTH})
    public final void setBorderWidth(ReactTextView view, int index, float width) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.values()[index], Float.valueOf(width));
    }

    @ReactPropGroup(customType = "Color", names = {ViewProps.BORDER_COLOR, ViewProps.BORDER_LEFT_COLOR, ViewProps.BORDER_RIGHT_COLOR, ViewProps.BORDER_TOP_COLOR, ViewProps.BORDER_BOTTOM_COLOR})
    public final void setBorderColor(ReactTextView view, int index, Integer color) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.values()[index], color);
    }

    @ReactProp(defaultBoolean = true, name = ViewProps.INCLUDE_FONT_PADDING)
    public final void setIncludeFontPadding(ReactTextView view, boolean includepad) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIncludeFontPadding(includepad);
    }

    @ReactProp(defaultBoolean = false, name = "disabled")
    public final void setDisabled(ReactTextView view, boolean disabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnabled(!disabled);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @ReactProp(name = "dataDetectorType")
    public final void setDataDetectorType(ReactTextView view, String type) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (type != null) {
            switch (type.hashCode()) {
                case -1192969641:
                    if (type.equals(HintConstants.AUTOFILL_HINT_PHONE_NUMBER)) {
                        view.setLinkifyMask(4);
                        return;
                    }
                    break;
                case 96673:
                    if (type.equals("all")) {
                        view.setLinkifyMask(15);
                        return;
                    }
                    break;
                case 3321850:
                    if (type.equals("link")) {
                        view.setLinkifyMask(1);
                        return;
                    }
                    break;
                case 96619420:
                    if (type.equals("email")) {
                        view.setLinkifyMask(2);
                        return;
                    }
                    break;
            }
        }
        view.setLinkifyMask(0);
    }
}
