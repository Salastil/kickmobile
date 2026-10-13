package com.facebook.yoga;

import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: YogaNode.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\b&\u0018\u00002\u00020\u0001:\u0002Þ\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0000H'J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0000H&J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001a\u001a\u00020\u0010H&J\b\u0010\u001b\u001a\u00020\u0005H&J\b\u0010\u001c\u001a\u00020\u0010H&J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0000H&J\b\u0010\u001f\u001a\u00020\u0005H&J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020!H&J\u0010\u0010k\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u0018H&J\u0010\u0010l\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u0018H&J\b\u0010n\u001a\u00020\u0005H&J\b\u0010o\u001a\u00020\u0005H&J\b\u0010p\u001a\u00020\u0005H&J\b\u0010q\u001a\u00020\u0005H&J\u0010\u0010r\u001a\u00020h2\u0006\u0010s\u001a\u00020tH&J\u0018\u0010u\u001a\u00020\u00052\u0006\u0010s\u001a\u00020t2\u0006\u0010v\u001a\u00020\u0018H&J\u0018\u0010w\u001a\u00020\u00052\u0006\u0010s\u001a\u00020t2\u0006\u0010m\u001a\u00020\u0018H&J\u0010\u0010x\u001a\u00020\u00052\u0006\u0010s\u001a\u00020tH&J\u0010\u0010y\u001a\u00020h2\u0006\u0010s\u001a\u00020tH&J\u0018\u0010z\u001a\u00020\u00052\u0006\u0010s\u001a\u00020t2\u0006\u0010{\u001a\u00020\u0018H&J\u0018\u0010|\u001a\u00020\u00052\u0006\u0010s\u001a\u00020t2\u0006\u0010m\u001a\u00020\u0018H&J\u0010\u0010}\u001a\u00020\u00182\u0006\u0010s\u001a\u00020tH&J\u0018\u0010~\u001a\u00020\u00052\u0006\u0010s\u001a\u00020t2\u0006\u0010\u007f\u001a\u00020\u0018H&J\u0011\u0010\u0080\u0001\u001a\u00020h2\u0006\u0010s\u001a\u00020tH&J\u001a\u0010\u0081\u0001\u001a\u00020\u00052\u0006\u0010s\u001a\u00020t2\u0007\u0010\u0082\u0001\u001a\u00020\u0018H&J\u0019\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010s\u001a\u00020t2\u0006\u0010m\u001a\u00020\u0018H&J\u0011\u0010\u0084\u0001\u001a\u00020\u00052\u0006\u0010s\u001a\u00020tH&J\u0011\u0010\u0086\u0001\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0011\u0010\u0087\u0001\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u0018H&J\t\u0010\u0088\u0001\u001a\u00020\u0005H&J\t\u0010\u0089\u0001\u001a\u00020\u0005H&J\t\u0010\u008a\u0001\u001a\u00020\u0005H&J\t\u0010\u008b\u0001\u001a\u00020\u0005H&J\u0011\u0010\u008d\u0001\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0011\u0010\u008e\u0001\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u0018H&J\t\u0010\u008f\u0001\u001a\u00020\u0005H&J\t\u0010\u0090\u0001\u001a\u00020\u0005H&J\t\u0010\u0091\u0001\u001a\u00020\u0005H&J\t\u0010\u0092\u0001\u001a\u00020\u0005H&J\u0012\u0010\u0095\u0001\u001a\u00020\u00052\u0007\u0010\u0093\u0001\u001a\u00020\u0018H&J\u0011\u0010\u0096\u0001\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u0018H&J\t\u0010\u0097\u0001\u001a\u00020\u0005H&J\t\u0010\u0098\u0001\u001a\u00020\u0005H&J\t\u0010\u0099\u0001\u001a\u00020\u0005H&J\u0012\u0010\u009c\u0001\u001a\u00020\u00052\u0007\u0010\u009a\u0001\u001a\u00020\u0018H&J\u0011\u0010\u009d\u0001\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u0018H&J\t\u0010\u009e\u0001\u001a\u00020\u0005H&J\t\u0010\u009f\u0001\u001a\u00020\u0005H&J\t\u0010 \u0001\u001a\u00020\u0005H&J\u0012\u0010£\u0001\u001a\u00020\u00052\u0007\u0010¡\u0001\u001a\u00020\u0018H&J\u0011\u0010¤\u0001\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u0018H&J\t\u0010¥\u0001\u001a\u00020\u0005H&J\t\u0010¦\u0001\u001a\u00020\u0005H&J\t\u0010§\u0001\u001a\u00020\u0005H&J\u0012\u0010ª\u0001\u001a\u00020\u00052\u0007\u0010¨\u0001\u001a\u00020\u0018H&J\u0011\u0010«\u0001\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u0018H&J\t\u0010¬\u0001\u001a\u00020\u0005H&J\t\u0010\u00ad\u0001\u001a\u00020\u0005H&J\t\u0010®\u0001\u001a\u00020\u0005H&J\u0013\u0010²\u0001\u001a\u00020h2\b\u0010³\u0001\u001a\u00030´\u0001H&J\u001c\u0010µ\u0001\u001a\u00020\u00052\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010¶\u0001\u001a\u00020\u0018H&J\u001c\u0010·\u0001\u001a\u00020\u00052\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010¶\u0001\u001a\u00020\u0018H&J\u0011\u0010À\u0001\u001a\u00020\u00182\u0006\u0010s\u001a\u00020tH&J\u0011\u0010Á\u0001\u001a\u00020\u00182\u0006\u0010s\u001a\u00020tH&J\u0011\u0010Â\u0001\u001a\u00020\u00182\u0006\u0010s\u001a\u00020tH&J\u0015\u0010Å\u0001\u001a\u00020\u00052\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H&J\u0015\u0010È\u0001\u001a\u00020\u00052\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H&J\u0012\u0010É\u0001\u001a\u00020\u00052\u0007\u0010Ê\u0001\u001a\u00020\u0018H&J\u0012\u0010Ë\u0001\u001a\u00020\u00052\u0007\u0010Ì\u0001\u001a\u00020\u0018H&J\t\u0010Í\u0001\u001a\u00020\u0018H&J\t\u0010Î\u0001\u001a\u00020\u0018H&J\u0015\u0010Ï\u0001\u001a\u00020\u00052\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001H&J\t\u0010Ú\u0001\u001a\u00020\u0000H&J\t\u0010Û\u0001\u001a\u00020\u0000H&J\u0012\u0010Ü\u0001\u001a\u00020\u00052\u0007\u0010Ý\u0001\u001a\u00020\u0010H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010&\u001a\u00020'X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010,\u001a\u00020-X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00102\u001a\u000203X¦\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u00108\u001a\u000203X¦\u000e¢\u0006\f\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u0018\u0010;\u001a\u000203X¦\u000e¢\u0006\f\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u0018\u0010>\u001a\u00020?X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010D\u001a\u00020EX¦\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010J\u001a\u00020KX¦\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u0004\u0018\u00010QX¦\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u0004\u0018\u00010WX¦\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0018\u0010a\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\bb\u0010^\"\u0004\bc\u0010`R\u0018\u0010d\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\be\u0010^\"\u0004\bf\u0010`R\u0012\u0010g\u001a\u00020hX¦\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0013\u0010\u0017\u001a\u00020hX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010jR\u0013\u0010\u0019\u001a\u00020hX¦\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010jR\u0014\u0010\u0093\u0001\u001a\u00020hX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010jR\u0014\u0010\u009a\u0001\u001a\u00020hX¦\u0004¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010jR\u0014\u0010¡\u0001\u001a\u00020hX¦\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010jR\u0014\u0010¨\u0001\u001a\u00020hX¦\u0004¢\u0006\u0007\u001a\u0005\b©\u0001\u0010jR\u001b\u0010¯\u0001\u001a\u00020\u0018X¦\u000e¢\u0006\u000e\u001a\u0005\b°\u0001\u0010^\"\u0005\b±\u0001\u0010`R\u0014\u0010¸\u0001\u001a\u00020\u0018X¦\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010^R\u0014\u0010º\u0001\u001a\u00020\u0018X¦\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010^R\u0014\u0010¼\u0001\u001a\u00020\u0018X¦\u0004¢\u0006\u0007\u001a\u0005\b½\u0001\u0010^R\u0014\u0010¾\u0001\u001a\u00020\u0018X¦\u0004¢\u0006\u0007\u001a\u0005\b¿\u0001\u0010^R\u0014\u0010Ã\u0001\u001a\u00020!X¦\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010#R\u0014\u0010Ò\u0001\u001a\u00020\u0010X¦\u0004¢\u0006\u0007\u001a\u0005\bÒ\u0001\u0010\u0011R\u0014\u0010Ó\u0001\u001a\u00020\u0010X¦\u0004¢\u0006\u0007\u001a\u0005\bÓ\u0001\u0010\u0011R \u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u0001X¦\u000e¢\u0006\u0010\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001¨\u0006ß\u0001"}, d2 = {"Lcom/facebook/yoga/YogaNode;", "Lcom/facebook/yoga/YogaProps;", "<init>", "()V", "reset", "", "childCount", "", "getChildCount", "()I", "getChildAt", ContextChain.TAG_INFRA, "addChildAt", "child", "setIsReferenceBaseline", "isReferenceBaseline", "", "()Z", "removeChildAt", "getOwner", "getParent", "indexOf", "calculateLayout", ViewProps.WIDTH, "", ViewProps.HEIGHT, "hasNewLayout", "dirty", "isDirty", "copyStyle", "srcNode", "markLayoutSeen", "styleDirection", "Lcom/facebook/yoga/YogaDirection;", "getStyleDirection", "()Lcom/facebook/yoga/YogaDirection;", "setDirection", "direction", ViewProps.FLEX_DIRECTION, "Lcom/facebook/yoga/YogaFlexDirection;", "getFlexDirection", "()Lcom/facebook/yoga/YogaFlexDirection;", "setFlexDirection", "(Lcom/facebook/yoga/YogaFlexDirection;)V", ViewProps.JUSTIFY_CONTENT, "Lcom/facebook/yoga/YogaJustify;", "getJustifyContent", "()Lcom/facebook/yoga/YogaJustify;", "setJustifyContent", "(Lcom/facebook/yoga/YogaJustify;)V", ViewProps.ALIGN_ITEMS, "Lcom/facebook/yoga/YogaAlign;", "getAlignItems", "()Lcom/facebook/yoga/YogaAlign;", "setAlignItems", "(Lcom/facebook/yoga/YogaAlign;)V", ViewProps.ALIGN_SELF, "getAlignSelf", "setAlignSelf", ViewProps.ALIGN_CONTENT, "getAlignContent", "setAlignContent", "positionType", "Lcom/facebook/yoga/YogaPositionType;", "getPositionType", "()Lcom/facebook/yoga/YogaPositionType;", "setPositionType", "(Lcom/facebook/yoga/YogaPositionType;)V", "boxSizing", "Lcom/facebook/yoga/YogaBoxSizing;", "getBoxSizing", "()Lcom/facebook/yoga/YogaBoxSizing;", "setBoxSizing", "(Lcom/facebook/yoga/YogaBoxSizing;)V", "wrap", "Lcom/facebook/yoga/YogaWrap;", "getWrap", "()Lcom/facebook/yoga/YogaWrap;", "setWrap", "(Lcom/facebook/yoga/YogaWrap;)V", ViewProps.OVERFLOW, "Lcom/facebook/yoga/YogaOverflow;", "getOverflow", "()Lcom/facebook/yoga/YogaOverflow;", "setOverflow", "(Lcom/facebook/yoga/YogaOverflow;)V", "display", "Lcom/facebook/yoga/YogaDisplay;", "getDisplay", "()Lcom/facebook/yoga/YogaDisplay;", "setDisplay", "(Lcom/facebook/yoga/YogaDisplay;)V", ViewProps.FLEX, "getFlex", "()F", "setFlex", "(F)V", ViewProps.FLEX_GROW, "getFlexGrow", "setFlexGrow", ViewProps.FLEX_SHRINK, "getFlexShrink", "setFlexShrink", ViewProps.FLEX_BASIS, "Lcom/facebook/yoga/YogaValue;", "getFlexBasis", "()Lcom/facebook/yoga/YogaValue;", "setFlexBasis", "setFlexBasisPercent", "percent", "setFlexBasisAuto", "setFlexBasisMaxContent", "setFlexBasisFitContent", "setFlexBasisStretch", "getMargin", "edge", "Lcom/facebook/yoga/YogaEdge;", "setMargin", ViewProps.MARGIN, "setMarginPercent", "setMarginAuto", "getPadding", "setPadding", ViewProps.PADDING, "setPaddingPercent", "getBorder", "setBorder", "value", "getPosition", "setPosition", ViewProps.POSITION, "setPositionPercent", "setPositionAuto", "getWidth", "setWidth", "setWidthPercent", "setWidthAuto", "setWidthMaxContent", "setWidthFitContent", "setWidthStretch", "getHeight", "setHeight", "setHeightPercent", "setHeightAuto", "setHeightMaxContent", "setHeightFitContent", "setHeightStretch", ViewProps.MIN_WIDTH, "getMinWidth", "setMinWidth", "setMinWidthPercent", "setMinWidthMaxContent", "setMinWidthFitContent", "setMinWidthStretch", ViewProps.MIN_HEIGHT, "getMinHeight", "setMinHeight", "setMinHeightPercent", "setMinHeightMaxContent", "setMinHeightFitContent", "setMinHeightStretch", ViewProps.MAX_WIDTH, "getMaxWidth", "setMaxWidth", "setMaxWidthPercent", "setMaxWidthMaxContent", "setMaxWidthFitContent", "setMaxWidthStretch", ViewProps.MAX_HEIGHT, "getMaxHeight", "setMaxHeight", "setMaxHeightPercent", "setMaxHeightMaxContent", "setMaxHeightFitContent", "setMaxHeightStretch", ViewProps.ASPECT_RATIO, "getAspectRatio", "setAspectRatio", "getGap", "gutter", "Lcom/facebook/yoga/YogaGutter;", "setGap", "gapLength", "setGapPercent", "layoutX", "getLayoutX", "layoutY", "getLayoutY", "layoutWidth", "getLayoutWidth", "layoutHeight", "getLayoutHeight", "getLayoutMargin", "getLayoutPadding", "getLayoutBorder", ViewProps.LAYOUT_DIRECTION, "getLayoutDirection", "setMeasureFunction", "measureFunction", "Lcom/facebook/yoga/YogaMeasureFunction;", "setMinContentMeasureFunction", "setMinContentWidth", "minContentWidth", "setMinContentHeight", "minContentHeight", "getMinContentWidth", "getMinContentHeight", "setBaselineFunction", "yogaBaselineFunction", "Lcom/facebook/yoga/YogaBaselineFunction;", "isMeasureDefined", "isBaselineDefined", "data", "", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "cloneWithoutChildren", "cloneWithChildren", "setAlwaysFormsContainingBlock", "alwaysFormsContainingBlock", "Inputs", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class YogaNode implements YogaProps {

    /* JADX INFO: compiled from: YogaNode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/facebook/yoga/YogaNode$Inputs;", "", "freeze", "", "node", "Lcom/facebook/yoga/YogaNode;", "parent", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Inputs {
        void freeze(YogaNode node, YogaNode parent);
    }

    public abstract void addChildAt(YogaNode child, int i);

    public abstract void calculateLayout(float width, float height);

    public abstract YogaNode cloneWithChildren();

    public abstract YogaNode cloneWithoutChildren();

    public abstract void copyStyle(YogaNode srcNode);

    public abstract void dirty();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaAlign getAlignContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaAlign getAlignItems();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaAlign getAlignSelf();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getAspectRatio();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getBorder(YogaEdge edge);

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaBoxSizing getBoxSizing();

    public abstract YogaNode getChildAt(int i);

    public abstract int getChildCount();

    public abstract Object getData();

    public abstract YogaDisplay getDisplay();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getFlex();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getFlexBasis();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaFlexDirection getFlexDirection();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getFlexGrow();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getFlexShrink();

    public abstract YogaValue getGap(YogaGutter gutter);

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getHeight();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaJustify getJustifyContent();

    public abstract float getLayoutBorder(YogaEdge edge);

    public abstract YogaDirection getLayoutDirection();

    public abstract float getLayoutHeight();

    public abstract float getLayoutMargin(YogaEdge edge);

    public abstract float getLayoutPadding(YogaEdge edge);

    public abstract float getLayoutWidth();

    public abstract float getLayoutX();

    public abstract float getLayoutY();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMargin(YogaEdge edge);

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMaxHeight();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMaxWidth();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getMinContentHeight();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getMinContentWidth();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMinHeight();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMinWidth();

    public abstract YogaOverflow getOverflow();

    public abstract YogaNode getOwner();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getPadding(YogaEdge edge);

    @Deprecated(message = "Use getOwner() instead. This will be removed in the next version. ", replaceWith = @ReplaceWith(expression = "getOwner()", imports = {}))
    public abstract YogaNode getParent();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getPosition(YogaEdge edge);

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaPositionType getPositionType();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaDirection getStyleDirection();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getWidth();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaWrap getWrap();

    public abstract boolean hasNewLayout();

    public abstract int indexOf(YogaNode child);

    public abstract boolean isBaselineDefined();

    public abstract boolean isDirty();

    public abstract boolean isMeasureDefined();

    public abstract boolean isReferenceBaseline();

    public abstract void markLayoutSeen();

    public abstract YogaNode removeChildAt(int i);

    public abstract void reset();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setAlignContent(YogaAlign yogaAlign);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setAlignItems(YogaAlign yogaAlign);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setAlignSelf(YogaAlign yogaAlign);

    public abstract void setAlwaysFormsContainingBlock(boolean alwaysFormsContainingBlock);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setAspectRatio(float f);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setBorder(YogaEdge edge, float value);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setBoxSizing(YogaBoxSizing yogaBoxSizing);

    public abstract void setData(Object obj);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setDirection(YogaDirection direction);

    public abstract void setDisplay(YogaDisplay yogaDisplay);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlex(float f);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexBasis(float flexBasis);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexBasisAuto();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexBasisFitContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexBasisMaxContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexBasisPercent(float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexBasisStretch();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexDirection(YogaFlexDirection yogaFlexDirection);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexGrow(float f);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexShrink(float f);

    public abstract void setGap(YogaGutter gutter, float gapLength);

    public abstract void setGapPercent(YogaGutter gutter, float gapLength);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setHeight(float height);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setHeightAuto();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setHeightFitContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setHeightMaxContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setHeightPercent(float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setHeightStretch();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setIsReferenceBaseline(boolean isReferenceBaseline);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setJustifyContent(YogaJustify yogaJustify);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMargin(YogaEdge edge, float margin);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMarginAuto(YogaEdge edge);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMarginPercent(YogaEdge edge, float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxHeight(float maxHeight);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxHeightFitContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxHeightMaxContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxHeightPercent(float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxHeightStretch();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxWidth(float maxWidth);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxWidthFitContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxWidthMaxContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxWidthPercent(float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxWidthStretch();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMeasureFunction(YogaMeasureFunction measureFunction);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinContentHeight(float minContentHeight);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinContentMeasureFunction(YogaMeasureFunction measureFunction);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinContentWidth(float minContentWidth);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinHeight(float minHeight);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinHeightFitContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinHeightMaxContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinHeightPercent(float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinHeightStretch();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinWidth(float minWidth);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinWidthFitContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinWidthMaxContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinWidthPercent(float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinWidthStretch();

    public abstract void setOverflow(YogaOverflow yogaOverflow);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPadding(YogaEdge edge, float padding);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPaddingPercent(YogaEdge edge, float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPosition(YogaEdge edge, float position);

    public abstract void setPositionAuto(YogaEdge edge);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPositionPercent(YogaEdge edge, float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPositionType(YogaPositionType yogaPositionType);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWidth(float width);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWidthAuto();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWidthFitContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWidthMaxContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWidthPercent(float percent);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWidthStretch();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWrap(YogaWrap yogaWrap);
}
