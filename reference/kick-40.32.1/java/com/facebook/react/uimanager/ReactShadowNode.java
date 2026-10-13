package com.facebook.react.uimanager;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.YogaWrap;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: ReactShadowNode.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "This class is part of Legacy Architecture and will be removed in a future release")
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\u0004H&J\u001d\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0014H&J\u0015\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\fH&J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\fH&J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H&J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H&J(\u0010+\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010,\u001a\u00020\u0014H&J\u0010\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0014H&J\b\u0010/\u001a\u00020\u0014H&J\u0010\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0014H&J\u0010\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\tH&J\u000f\u00104\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u00105J\u000f\u00106\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u00105J\u0017\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020;H&J\u0010\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020;H&J\b\u0010>\u001a\u00020\u0004H&J\b\u0010?\u001a\u00020\fH&J\u0018\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020)H&J\b\u0010B\u001a\u00020\u0004H&J\b\u0010C\u001a\u00020\fH&J\u001d\u0010D\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010E\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0015J\u0015\u0010F\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0017J\b\u0010G\u001a\u00020\fH&J\b\u0010H\u001a\u00020\u0014H&J\u0015\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001bJ\u000f\u0010K\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u00105J\u0010\u0010L\u001a\u00020\f2\u0006\u0010M\u001a\u00020\u0004H&J\b\u0010M\u001a\u00020\u0004H&J\b\u0010N\u001a\u00020\u0014H&J\u0015\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00028\u0000H&¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020\tH&J\u0010\u0010S\u001a\u00020\f2\u0006\u0010T\u001a\u00020\u0002H&J\u0015\u0010U\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001bJ\b\u0010V\u001a\u00020)H&J\b\u0010W\u001a\u00020)H&J\b\u0010X\u001a\u00020)H&J\b\u0010Y\u001a\u00020)H&J\b\u0010Z\u001a\u00020\u0014H&J\b\u0010[\u001a\u00020\u0014H&J\b\u0010\\\u001a\u00020\u0014H&J\b\u0010]\u001a\u00020\u0014H&J\b\u0010^\u001a\u00020_H&J\u0010\u0010`\u001a\u00020\f2\u0006\u0010a\u001a\u00020_H&J\b\u0010b\u001a\u00020cH&J\u0010\u0010d\u001a\u00020\f2\u0006\u0010e\u001a\u00020)H&J\u0010\u0010f\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\b\u0010h\u001a\u00020\fH&J\u0010\u0010i\u001a\u00020\f2\u0006\u0010e\u001a\u00020)H&J\u0010\u0010j\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\u0010\u0010k\u001a\u00020\f2\u0006\u0010e\u001a\u00020)H&J\u0010\u0010l\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\b\u0010m\u001a\u00020cH&J\b\u0010n\u001a\u00020)H&J\u0010\u0010o\u001a\u00020\f2\u0006\u0010p\u001a\u00020)H&J\u0010\u0010q\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\b\u0010r\u001a\u00020\fH&J\u0010\u0010s\u001a\u00020\f2\u0006\u0010e\u001a\u00020)H&J\u0010\u0010t\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\u0010\u0010u\u001a\u00020\f2\u0006\u0010e\u001a\u00020)H&J\u0010\u0010v\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\u0010\u0010w\u001a\u00020\f2\u0006\u0010x\u001a\u00020)H&J\u0010\u0010y\u001a\u00020\f2\u0006\u0010z\u001a\u00020)H&J\u0010\u0010{\u001a\u00020\f2\u0006\u0010|\u001a\u00020)H&J\u0010\u0010}\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\u0010\u0010~\u001a\u00020\f2\u0006\u0010\u007f\u001a\u00020)H&J\u0011\u0010\u0080\u0001\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\u0012\u0010\u0081\u0001\u001a\u00020\f2\u0007\u0010\u0082\u0001\u001a\u00020)H&J\u0011\u0010\u0083\u0001\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\u0012\u0010\u0084\u0001\u001a\u00020\f2\u0007\u0010\u0085\u0001\u001a\u00020)H&J\u0012\u0010\u0086\u0001\u001a\u00020\f2\u0007\u0010\u0087\u0001\u001a\u00020)H&J\t\u0010\u0088\u0001\u001a\u00020\fH&J\u0011\u0010\u0089\u0001\u001a\u00020\f2\u0006\u0010g\u001a\u00020)H&J\u0012\u0010\u008a\u0001\u001a\u00020\f2\u0007\u0010\u008b\u0001\u001a\u00020)H&J\u0013\u0010\u008c\u0001\u001a\u00020\f2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H&J\u0013\u0010\u008f\u0001\u001a\u00020\f2\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H&J\u0013\u0010\u0092\u0001\u001a\u00020\f2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H&J\u0013\u0010\u0095\u0001\u001a\u00020\f2\b\u0010\u0096\u0001\u001a\u00030\u0094\u0001H&J\u0013\u0010\u0097\u0001\u001a\u00020\f2\b\u0010\u0098\u0001\u001a\u00030\u0094\u0001H&J\u0013\u0010\u0099\u0001\u001a\u00020\f2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H&J\u0013\u0010\u009c\u0001\u001a\u00020\f2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H&J\u0013\u0010\u009f\u0001\u001a\u00020\f2\b\u0010 \u0001\u001a\u00030¡\u0001H&J\u001b\u0010¢\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u00142\u0007\u0010¤\u0001\u001a\u00020)H&J\u001a\u0010¥\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u00142\u0006\u0010g\u001a\u00020)H&J\u0012\u0010¦\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u0014H&J\u0012\u0010§\u0001\u001a\u00020)2\u0007\u0010£\u0001\u001a\u00020\u0014H&J\u0012\u0010¨\u0001\u001a\u00020c2\u0007\u0010£\u0001\u001a\u00020\u0014H&J\u001b\u0010©\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u00142\u0007\u0010ª\u0001\u001a\u00020)H&J\u001b\u0010«\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u00142\u0007\u0010ª\u0001\u001a\u00020)H&J\u001a\u0010¬\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u00142\u0006\u0010g\u001a\u00020)H&J\u001b\u0010\u00ad\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u00142\u0007\u0010®\u0001\u001a\u00020)H&J\u001b\u0010¯\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u00142\u0007\u0010°\u0001\u001a\u00020)H&J\u001a\u0010±\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\u00142\u0006\u0010g\u001a\u00020)H&J\u0013\u0010²\u0001\u001a\u00020\f2\b\u0010³\u0001\u001a\u00030´\u0001H&J\u0011\u0010µ\u0001\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u0004H&J\u0013\u0010¶\u0001\u001a\u00020\f2\b\u0010·\u0001\u001a\u00030¸\u0001H&J\u0013\u0010¹\u0001\u001a\u00020\f2\b\u0010º\u0001\u001a\u00030»\u0001H&J\t\u0010¼\u0001\u001a\u00020\u0004H&J\t\u0010½\u0001\u001a\u00020\fH&J\u001b\u0010¾\u0001\u001a\u00020\f2\u0007\u0010¿\u0001\u001a\u00020\u00142\u0007\u0010À\u0001\u001a\u00020\u0014H&J\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0003\u0010Â\u0001J\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0003\u0010Â\u0001J\u001c\u0010Ä\u0001\u001a\u0015\u0012\u000e\u0012\f\u0012\u0002\b\u00030\u0000¢\u0006\u0003\bÆ\u0001\u0018\u00010Å\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006Ç\u0001À\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/ReactShadowNode;", ExifInterface.GPS_DIRECTION_TRUE, "", "isVirtual", "", "isVirtualAnchor", "isYogaLeafNode", "hoistNativeChildren", "getViewClass", "", "hasUpdates", "markUpdateSeen", "", "markUpdated", "hasUnseenUpdates", "dirty", "isDirty", "addChildAt", "child", ContextChain.TAG_INFRA, "", "(Lcom/facebook/react/uimanager/ReactShadowNode;I)V", "removeChildAt", "(I)Lcom/facebook/react/uimanager/ReactShadowNode;", "getChildCount", "getChildAt", "indexOf", "(Lcom/facebook/react/uimanager/ReactShadowNode;)I", "removeAndDisposeAllChildren", "onBeforeLayout", "nativeViewHierarchyOptimizer", "Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;", "updateProperties", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "onAfterUpdateTransaction", "onCollectExtraUpdates", "uiViewOperationQueue", "Lcom/facebook/react/uimanager/UIViewOperationQueue;", "dispatchUpdatesWillChangeLayout", "absoluteX", "", "absoluteY", "dispatchUpdates", "getReactTag", "setReactTag", "reactTag", "getRootTag", "setRootTag", "rootTag", "setViewClassName", "viewClassName", "getParent", "()Lcom/facebook/react/uimanager/ReactShadowNode;", "getLayoutParent", "setLayoutParent", "layoutParent", "(Lcom/facebook/react/uimanager/ReactShadowNode;)V", "getThemedContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setThemedContext", "themedContext", "shouldNotifyOnLayout", "calculateLayout", ViewProps.WIDTH, ViewProps.HEIGHT, "hasNewLayout", "markLayoutSeen", "addNativeChildAt", "nativeIndex", "removeNativeChildAt", "removeAllNativeChildren", "getNativeChildCount", "indexOfNativeChild", "nativeChild", "getNativeParent", "setIsLayoutOnly", "isLayoutOnly", "getTotalNativeChildren", "isDescendantOf", "ancestorNode", "(Lcom/facebook/react/uimanager/ReactShadowNode;)Z", "getHierarchyInfo", "setLocalData", "data", "getNativeOffsetForChild", "getLayoutX", "getLayoutY", "getLayoutWidth", "getLayoutHeight", "getScreenX", "getScreenY", "getScreenWidth", "getScreenHeight", "getLayoutDirection", "Lcom/facebook/yoga/YogaDirection;", "setLayoutDirection", "direction", "getStyleWidth", "Lcom/facebook/yoga/YogaValue;", "setStyleWidth", "widthPx", "setStyleWidthPercent", "percent", "setStyleWidthAuto", "setStyleMinWidth", "setStyleMinWidthPercent", "setStyleMaxWidth", "setStyleMaxWidthPercent", "getStyleHeight", "getFlex", "setStyleHeight", "heightPx", "setStyleHeightPercent", "setStyleHeightAuto", "setStyleMinHeight", "setStyleMinHeightPercent", "setStyleMaxHeight", "setStyleMaxHeightPercent", "setFlex", ViewProps.FLEX, "setFlexGrow", ViewProps.FLEX_GROW, "setRowGap", ViewProps.ROW_GAP, "setRowGapPercent", "setColumnGap", ViewProps.COLUMN_GAP, "setColumnGapPercent", "setGap", ViewProps.GAP, "setGapPercent", "setFlexShrink", ViewProps.FLEX_SHRINK, "setFlexBasis", ViewProps.FLEX_BASIS, "setFlexBasisAuto", "setFlexBasisPercent", "setStyleAspectRatio", ViewProps.ASPECT_RATIO, "setFlexDirection", ViewProps.FLEX_DIRECTION, "Lcom/facebook/yoga/YogaFlexDirection;", "setFlexWrap", "wrap", "Lcom/facebook/yoga/YogaWrap;", "setAlignSelf", ViewProps.ALIGN_SELF, "Lcom/facebook/yoga/YogaAlign;", "setAlignItems", ViewProps.ALIGN_ITEMS, "setAlignContent", ViewProps.ALIGN_CONTENT, "setJustifyContent", ViewProps.JUSTIFY_CONTENT, "Lcom/facebook/yoga/YogaJustify;", "setOverflow", ViewProps.OVERFLOW, "Lcom/facebook/yoga/YogaOverflow;", "setDisplay", "display", "Lcom/facebook/yoga/YogaDisplay;", "setMargin", "spacingType", ViewProps.MARGIN, "setMarginPercent", "setMarginAuto", "getPadding", "getStylePadding", "setDefaultPadding", ViewProps.PADDING, "setPadding", "setPaddingPercent", "setBorder", ViewProps.BORDER_WIDTH, "setPosition", ViewProps.POSITION, "setPositionPercent", "setPositionType", "positionType", "Lcom/facebook/yoga/YogaPositionType;", "setShouldNotifyOnLayout", "setBaselineFunction", "baselineFunction", "Lcom/facebook/yoga/YogaBaselineFunction;", "setMeasureFunction", "measureFunction", "Lcom/facebook/yoga/YogaMeasureFunction;", "isMeasureDefined", "dispose", "setMeasureSpecs", "widthMeasureSpec", "heightMeasureSpec", "getWidthMeasureSpec", "()Ljava/lang/Integer;", "getHeightMeasureSpec", "calculateLayoutOnChildren", "", "Lkotlin/jvm/JvmWildcard;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ReactShadowNode<T extends ReactShadowNode<T>> {
    void addChildAt(T child, int i);

    void addNativeChildAt(T child, int nativeIndex);

    void calculateLayout();

    void calculateLayout(float width, float height);

    Iterable<? extends ReactShadowNode<?>> calculateLayoutOnChildren();

    void dirty();

    void dispatchUpdates(float absoluteX, float absoluteY, UIViewOperationQueue uiViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer);

    boolean dispatchUpdatesWillChangeLayout(float absoluteX, float absoluteY);

    void dispose();

    T getChildAt(int i);

    int getChildCount();

    float getFlex();

    Integer getHeightMeasureSpec();

    String getHierarchyInfo();

    YogaDirection getLayoutDirection();

    float getLayoutHeight();

    T getLayoutParent();

    float getLayoutWidth();

    float getLayoutX();

    float getLayoutY();

    int getNativeChildCount();

    int getNativeOffsetForChild(T child);

    T getNativeParent();

    float getPadding(int spacingType);

    T getParent();

    int getReactTag();

    int getRootTag();

    int getScreenHeight();

    int getScreenWidth();

    int getScreenX();

    int getScreenY();

    YogaValue getStyleHeight();

    YogaValue getStylePadding(int spacingType);

    YogaValue getStyleWidth();

    ThemedReactContext getThemedContext();

    int getTotalNativeChildren();

    String getViewClass();

    Integer getWidthMeasureSpec();

    boolean hasNewLayout();

    boolean hasUnseenUpdates();

    boolean hasUpdates();

    boolean hoistNativeChildren();

    int indexOf(T child);

    int indexOfNativeChild(T nativeChild);

    boolean isDescendantOf(T ancestorNode);

    boolean isDirty();

    boolean isLayoutOnly();

    boolean isMeasureDefined();

    boolean isVirtual();

    boolean isVirtualAnchor();

    boolean isYogaLeafNode();

    void markLayoutSeen();

    void markUpdateSeen();

    void markUpdated();

    void onAfterUpdateTransaction();

    void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer);

    void onCollectExtraUpdates(UIViewOperationQueue uiViewOperationQueue);

    void removeAllNativeChildren();

    void removeAndDisposeAllChildren();

    T removeChildAt(int i);

    T removeNativeChildAt(int i);

    void setAlignContent(YogaAlign alignContent);

    void setAlignItems(YogaAlign alignItems);

    void setAlignSelf(YogaAlign alignSelf);

    void setBaselineFunction(YogaBaselineFunction baselineFunction);

    void setBorder(int spacingType, float borderWidth);

    void setColumnGap(float columnGap);

    void setColumnGapPercent(float percent);

    void setDefaultPadding(int spacingType, float padding);

    void setDisplay(YogaDisplay display);

    void setFlex(float flex);

    void setFlexBasis(float flexBasis);

    void setFlexBasisAuto();

    void setFlexBasisPercent(float percent);

    void setFlexDirection(YogaFlexDirection flexDirection);

    void setFlexGrow(float flexGrow);

    void setFlexShrink(float flexShrink);

    void setFlexWrap(YogaWrap wrap);

    void setGap(float gap);

    void setGapPercent(float percent);

    void setIsLayoutOnly(boolean isLayoutOnly);

    void setJustifyContent(YogaJustify justifyContent);

    void setLayoutDirection(YogaDirection direction);

    void setLayoutParent(T layoutParent);

    void setLocalData(Object data);

    void setMargin(int spacingType, float margin);

    void setMarginAuto(int spacingType);

    void setMarginPercent(int spacingType, float percent);

    void setMeasureFunction(YogaMeasureFunction measureFunction);

    void setMeasureSpecs(int widthMeasureSpec, int heightMeasureSpec);

    void setOverflow(YogaOverflow overflow);

    void setPadding(int spacingType, float padding);

    void setPaddingPercent(int spacingType, float percent);

    void setPosition(int spacingType, float position);

    void setPositionPercent(int spacingType, float percent);

    void setPositionType(YogaPositionType positionType);

    void setReactTag(int reactTag);

    void setRootTag(int rootTag);

    void setRowGap(float rowGap);

    void setRowGapPercent(float percent);

    void setShouldNotifyOnLayout(boolean shouldNotifyOnLayout);

    void setStyleAspectRatio(float aspectRatio);

    void setStyleHeight(float heightPx);

    void setStyleHeightAuto();

    void setStyleHeightPercent(float percent);

    void setStyleMaxHeight(float widthPx);

    void setStyleMaxHeightPercent(float percent);

    void setStyleMaxWidth(float widthPx);

    void setStyleMaxWidthPercent(float percent);

    void setStyleMinHeight(float widthPx);

    void setStyleMinHeightPercent(float percent);

    void setStyleMinWidth(float widthPx);

    void setStyleMinWidthPercent(float percent);

    void setStyleWidth(float widthPx);

    void setStyleWidthAuto();

    void setStyleWidthPercent(float percent);

    void setThemedContext(ThemedReactContext themedContext);

    void setViewClassName(String viewClassName);

    boolean shouldNotifyOnLayout();

    void updateProperties(ReactStylesDiffMap props);
}
