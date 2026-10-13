package com.facebook.yoga;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: YogaProps.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0005H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&J\b\u0010*\u001a\u00020\u0003H&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H&J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-H&J\u0018\u00101\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u00102\u001a\u00020\u0005H&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u00104\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u00105\u001a\u00020\u0005H&J\u0018\u00106\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u00107\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u00108\u001a\u00020\u0005H&J\b\u00109\u001a\u00020\u0003H&J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u0005H&J\b\u0010=\u001a\u00020\u0003H&J\b\u0010>\u001a\u00020\u0003H&J\b\u0010?\u001a\u00020\u0003H&J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BH&J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020EH&J\u0012\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010HH&J\u0012\u0010I\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010HH&J\u0010\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u0005H&J\u0010\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0005H&J\b\u0010N\u001a\u00020\u0005H&J\b\u0010O\u001a\u00020\u0005H&J\u0012\u0010P\u001a\u00020\u00032\b\u0010Q\u001a\u0004\u0018\u00010RH&J\u0012\u0010\u0097\u0001\u001a\u00030\u008e\u00012\u0006\u0010,\u001a\u00020-H&J\u0012\u0010\u0098\u0001\u001a\u00030\u008e\u00012\u0006\u0010,\u001a\u00020-H&J\u0012\u0010\u0099\u0001\u001a\u00030\u008e\u00012\u0006\u0010,\u001a\u00020-H&J\u0011\u0010\u009a\u0001\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-H&R\u0018\u0010S\u001a\u00020TX¦\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0018\u0010Y\u001a\u00020ZX¦\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0018\u0010_\u001a\u00020`X¦\u000e¢\u0006\f\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0018\u0010e\u001a\u00020`X¦\u000e¢\u0006\f\u001a\u0004\bf\u0010b\"\u0004\bg\u0010dR\u0018\u0010h\u001a\u00020`X¦\u000e¢\u0006\f\u001a\u0004\bi\u0010b\"\u0004\bj\u0010dR\u0018\u0010k\u001a\u00020lX¦\u000e¢\u0006\f\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0018\u0010q\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0018\u0010v\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\bw\u0010s\"\u0004\bx\u0010uR\u0018\u0010y\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\bz\u0010s\"\u0004\b{\u0010uR\u0018\u0010|\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b}\u0010s\"\u0004\b~\u0010uR\u001d\u0010\u007f\u001a\u00030\u0080\u0001X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001e\u0010\u0085\u0001\u001a\u00030\u0086\u0001X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0015\u0010\u008b\u0001\u001a\u00020BX¦\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0015\u0010\u0004\u001a\u00030\u008e\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0015\u0010\r\u001a\u00030\u008e\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0090\u0001R\u0015\u0010\u0013\u001a\u00030\u008e\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0090\u0001R\u0015\u0010\u0019\u001a\u00030\u008e\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0090\u0001R\u0015\u0010 \u001a\u00030\u008e\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0090\u0001R\u0015\u0010&\u001a\u00030\u008e\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0090\u0001R\u0015\u0010<\u001a\u00030\u008e\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0090\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u009b\u0001À\u0006\u0001"}, d2 = {"Lcom/facebook/yoga/YogaProps;", "", "setWidth", "", ViewProps.WIDTH, "", "setWidthPercent", "percent", "setWidthAuto", "setWidthMaxContent", "setWidthFitContent", "setWidthStretch", "setMinWidth", ViewProps.MIN_WIDTH, "setMinWidthPercent", "setMinWidthMaxContent", "setMinWidthFitContent", "setMinWidthStretch", "setMaxWidth", ViewProps.MAX_WIDTH, "setMaxWidthPercent", "setMaxWidthMaxContent", "setMaxWidthFitContent", "setMaxWidthStretch", "setHeight", ViewProps.HEIGHT, "setHeightPercent", "setHeightAuto", "setHeightMaxContent", "setHeightFitContent", "setHeightStretch", "setMinHeight", ViewProps.MIN_HEIGHT, "setMinHeightPercent", "setMinHeightMaxContent", "setMinHeightFitContent", "setMinHeightStretch", "setMaxHeight", ViewProps.MAX_HEIGHT, "setMaxHeightPercent", "setMaxHeightMaxContent", "setMaxHeightFitContent", "setMaxHeightStretch", "setMargin", "edge", "Lcom/facebook/yoga/YogaEdge;", ViewProps.MARGIN, "setMarginPercent", "setMarginAuto", "setPadding", ViewProps.PADDING, "setPaddingPercent", "setPosition", ViewProps.POSITION, "setPositionPercent", "setBorder", "value", "setFlexBasisAuto", "setFlexBasisPercent", "setFlexBasis", ViewProps.FLEX_BASIS, "setFlexBasisMaxContent", "setFlexBasisFitContent", "setFlexBasisStretch", "setDirection", "direction", "Lcom/facebook/yoga/YogaDirection;", "setIsReferenceBaseline", "isReferenceBaseline", "", "setMeasureFunction", "measureFunction", "Lcom/facebook/yoga/YogaMeasureFunction;", "setMinContentMeasureFunction", "setMinContentWidth", "minContentWidth", "setMinContentHeight", "minContentHeight", "getMinContentWidth", "getMinContentHeight", "setBaselineFunction", "yogaBaselineFunction", "Lcom/facebook/yoga/YogaBaselineFunction;", ViewProps.FLEX_DIRECTION, "Lcom/facebook/yoga/YogaFlexDirection;", "getFlexDirection", "()Lcom/facebook/yoga/YogaFlexDirection;", "setFlexDirection", "(Lcom/facebook/yoga/YogaFlexDirection;)V", ViewProps.JUSTIFY_CONTENT, "Lcom/facebook/yoga/YogaJustify;", "getJustifyContent", "()Lcom/facebook/yoga/YogaJustify;", "setJustifyContent", "(Lcom/facebook/yoga/YogaJustify;)V", ViewProps.ALIGN_ITEMS, "Lcom/facebook/yoga/YogaAlign;", "getAlignItems", "()Lcom/facebook/yoga/YogaAlign;", "setAlignItems", "(Lcom/facebook/yoga/YogaAlign;)V", ViewProps.ALIGN_SELF, "getAlignSelf", "setAlignSelf", ViewProps.ALIGN_CONTENT, "getAlignContent", "setAlignContent", "positionType", "Lcom/facebook/yoga/YogaPositionType;", "getPositionType", "()Lcom/facebook/yoga/YogaPositionType;", "setPositionType", "(Lcom/facebook/yoga/YogaPositionType;)V", ViewProps.FLEX_GROW, "getFlexGrow", "()F", "setFlexGrow", "(F)V", ViewProps.FLEX_SHRINK, "getFlexShrink", "setFlexShrink", ViewProps.FLEX, "getFlex", "setFlex", ViewProps.ASPECT_RATIO, "getAspectRatio", "setAspectRatio", "wrap", "Lcom/facebook/yoga/YogaWrap;", "getWrap", "()Lcom/facebook/yoga/YogaWrap;", "setWrap", "(Lcom/facebook/yoga/YogaWrap;)V", "boxSizing", "Lcom/facebook/yoga/YogaBoxSizing;", "getBoxSizing", "()Lcom/facebook/yoga/YogaBoxSizing;", "setBoxSizing", "(Lcom/facebook/yoga/YogaBoxSizing;)V", "styleDirection", "getStyleDirection", "()Lcom/facebook/yoga/YogaDirection;", "Lcom/facebook/yoga/YogaValue;", "getWidth", "()Lcom/facebook/yoga/YogaValue;", "getMinWidth", "getMaxWidth", "getHeight", "getMinHeight", "getMaxHeight", "getFlexBasis", "getMargin", "getPadding", "getPosition", "getBorder", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface YogaProps {
    YogaAlign getAlignContent();

    YogaAlign getAlignItems();

    YogaAlign getAlignSelf();

    float getAspectRatio();

    float getBorder(YogaEdge edge);

    YogaBoxSizing getBoxSizing();

    float getFlex();

    YogaValue getFlexBasis();

    YogaFlexDirection getFlexDirection();

    float getFlexGrow();

    float getFlexShrink();

    YogaValue getHeight();

    YogaJustify getJustifyContent();

    YogaValue getMargin(YogaEdge edge);

    YogaValue getMaxHeight();

    YogaValue getMaxWidth();

    float getMinContentHeight();

    float getMinContentWidth();

    YogaValue getMinHeight();

    YogaValue getMinWidth();

    YogaValue getPadding(YogaEdge edge);

    YogaValue getPosition(YogaEdge edge);

    YogaPositionType getPositionType();

    YogaDirection getStyleDirection();

    YogaValue getWidth();

    YogaWrap getWrap();

    void setAlignContent(YogaAlign yogaAlign);

    void setAlignItems(YogaAlign yogaAlign);

    void setAlignSelf(YogaAlign yogaAlign);

    void setAspectRatio(float f);

    void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction);

    void setBorder(YogaEdge edge, float value);

    void setBoxSizing(YogaBoxSizing yogaBoxSizing);

    void setDirection(YogaDirection direction);

    void setFlex(float f);

    void setFlexBasis(float flexBasis);

    void setFlexBasisAuto();

    void setFlexBasisFitContent();

    void setFlexBasisMaxContent();

    void setFlexBasisPercent(float percent);

    void setFlexBasisStretch();

    void setFlexDirection(YogaFlexDirection yogaFlexDirection);

    void setFlexGrow(float f);

    void setFlexShrink(float f);

    void setHeight(float height);

    void setHeightAuto();

    void setHeightFitContent();

    void setHeightMaxContent();

    void setHeightPercent(float percent);

    void setHeightStretch();

    void setIsReferenceBaseline(boolean isReferenceBaseline);

    void setJustifyContent(YogaJustify yogaJustify);

    void setMargin(YogaEdge edge, float margin);

    void setMarginAuto(YogaEdge edge);

    void setMarginPercent(YogaEdge edge, float percent);

    void setMaxHeight(float maxHeight);

    void setMaxHeightFitContent();

    void setMaxHeightMaxContent();

    void setMaxHeightPercent(float percent);

    void setMaxHeightStretch();

    void setMaxWidth(float maxWidth);

    void setMaxWidthFitContent();

    void setMaxWidthMaxContent();

    void setMaxWidthPercent(float percent);

    void setMaxWidthStretch();

    void setMeasureFunction(YogaMeasureFunction measureFunction);

    void setMinContentHeight(float minContentHeight);

    void setMinContentMeasureFunction(YogaMeasureFunction measureFunction);

    void setMinContentWidth(float minContentWidth);

    void setMinHeight(float minHeight);

    void setMinHeightFitContent();

    void setMinHeightMaxContent();

    void setMinHeightPercent(float percent);

    void setMinHeightStretch();

    void setMinWidth(float minWidth);

    void setMinWidthFitContent();

    void setMinWidthMaxContent();

    void setMinWidthPercent(float percent);

    void setMinWidthStretch();

    void setPadding(YogaEdge edge, float padding);

    void setPaddingPercent(YogaEdge edge, float percent);

    void setPosition(YogaEdge edge, float position);

    void setPositionPercent(YogaEdge edge, float percent);

    void setPositionType(YogaPositionType yogaPositionType);

    void setWidth(float width);

    void setWidthAuto();

    void setWidthFitContent();

    void setWidthMaxContent();

    void setWidthPercent(float percent);

    void setWidthStretch();

    void setWrap(YogaWrap yogaWrap);
}
