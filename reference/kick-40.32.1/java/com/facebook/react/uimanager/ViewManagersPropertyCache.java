package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DimensionPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaValue;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÀ\u0002\u0018\u00002\u00020\u0001:\u000f#$%&'()*+,-./01B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0007JE\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0016\u0010\u000e\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u00062\u0012\u0010\u0010\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\u0006H\u0001¢\u0006\u0002\b\u0012J1\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0016\u0010\u0014\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u0006H\u0001¢\u0006\u0002\b\u0015J-\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\u0014\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\u0006H\u0001¢\u0006\u0002\b\u0017J$\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J8\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J4\u0010!\u001a\u00020\f2\u0016\u0010\u0014\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J0\u0010\"\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002R*\u0010\u0004\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache;", "", "<init>", "()V", "CLASS_PROPS_CACHE", "", "Ljava/lang/Class;", "", "", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "EMPTY_PROPS_MAP", "clear", "", "getNativePropsForView", "viewManagerTopClass", "Lcom/facebook/react/uimanager/ViewManager;", "shadowNodeTopClass", "Lcom/facebook/react/uimanager/ReactShadowNode;", "getNativePropsForView$ReactAndroid", "getNativePropSettersForViewManagerClass", "cls", "getNativePropSettersForViewManagerClass$ReactAndroid", "getNativePropSettersForShadowNodeClass", "getNativePropSettersForShadowNodeClass$ReactAndroid", "createPropSetter", "annotation", "Lcom/facebook/react/uimanager/annotations/ReactProp;", FirebaseAnalytics.Param.METHOD, "Ljava/lang/reflect/Method;", "propTypeClass", "createPropSetters", "Lcom/facebook/react/uimanager/annotations/ReactPropGroup;", "props", "extractPropSettersFromViewManagerClassDefinition", "extractPropSettersFromShadowNodeClassDefinition", "PropSetter", "DynamicPropSetter", "IntPropSetter", "DoublePropSetter", "ColorPropSetter", "DimensionPropSetter", "BooleanPropSetter", "FloatPropSetter", "ArrayPropSetter", "MapPropSetter", "StringPropSetter", "BoxedBooleanPropSetter", "BoxedFloatPropSetter", "BoxedIntPropSetter", "BoxedColorPropSetter", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ViewManagersPropertyCache {
    public static final ViewManagersPropertyCache INSTANCE = new ViewManagersPropertyCache();
    private static final Map<Class<?>, Map<String, PropSetter>> CLASS_PROPS_CACHE = new HashMap();
    private static final Map<String, PropSetter> EMPTY_PROPS_MAP = new HashMap();

    private ViewManagersPropertyCache() {
    }

    @JvmStatic
    public static final void clear() {
        CLASS_PROPS_CACHE.clear();
        EMPTY_PROPS_MAP.clear();
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B!\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB)\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\b\u0010\rJ(\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\u001f\u001a\u00020\u00192\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020$H$R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "defaultType", "", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/String;Ljava/lang/reflect/Method;)V", "Lcom/facebook/react/uimanager/annotations/ReactPropGroup;", FirebaseAnalytics.Param.INDEX, "", "(Lcom/facebook/react/uimanager/annotations/ReactPropGroup;Ljava/lang/String;Ljava/lang/reflect/Method;I)V", "propName", "getPropName", "()Ljava/lang/String;", "propType", "getPropType", "getSetter", "()Ljava/lang/reflect/Method;", "getIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "updateViewProp", "", "viewManager", "Lcom/facebook/react/uimanager/ViewManager;", "viewToUpdate", "Landroid/view/View;", "value", "updateShadowNodeProp", "nodeToUpdate", "Lcom/facebook/react/uimanager/ReactShadowNode;", "getValueOrDefault", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class PropSetter {
        private final Integer index;
        private final String propName;
        private final String propType;
        private final Method setter;

        protected abstract Object getValueOrDefault(Object value, Context context);

        public final String getPropName() {
            return this.propName;
        }

        public final String getPropType() {
            return this.propType;
        }

        protected final Method getSetter() {
            return this.setter;
        }

        protected final Integer getIndex() {
            return this.index;
        }

        protected PropSetter(ReactProp prop, String defaultType, Method setter) {
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(defaultType, "defaultType");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.propName = prop.name();
            this.propType = Intrinsics.areEqual("__default_type__", prop.customType()) ? defaultType : prop.customType();
            this.setter = setter;
            this.index = null;
        }

        protected PropSetter(ReactPropGroup prop, String defaultType, Method setter, int i) {
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(defaultType, "defaultType");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.propName = prop.names()[i];
            this.propType = Intrinsics.areEqual("__default_type__", prop.customType()) ? defaultType : prop.customType();
            this.setter = setter;
            this.index = Integer.valueOf(i);
        }

        public final void updateViewProp(ViewManager<?, ?> viewManager, View viewToUpdate, Object value) {
            Intrinsics.checkNotNullParameter(viewManager, "viewManager");
            Intrinsics.checkNotNullParameter(viewToUpdate, "viewToUpdate");
            try {
                Context context = viewToUpdate.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                Object valueOrDefault = getValueOrDefault(value, context);
                Integer num = this.index;
                Method method = this.setter;
                if (num == null) {
                    method.invoke(viewManager, viewToUpdate, valueOrDefault);
                } else {
                    method.invoke(viewManager, viewToUpdate, num, valueOrDefault);
                }
            } catch (Throwable th) {
                FLog.e((Class<?>) ViewManager.class, "Error while updating prop " + this.propName, th);
                throw new JSApplicationIllegalArgumentException("Error while updating property '" + this.propName + "' of a view managed by: " + viewManager.getName(), th);
            }
        }

        public final void updateShadowNodeProp(ReactShadowNode<?> nodeToUpdate, Object value) {
            Intrinsics.checkNotNullParameter(nodeToUpdate, "nodeToUpdate");
            try {
                Object valueOrDefault = getValueOrDefault(value, nodeToUpdate.getThemedContext());
                Integer num = this.index;
                Method method = this.setter;
                if (num == null) {
                    method.invoke(nodeToUpdate, valueOrDefault);
                } else {
                    method.invoke(nodeToUpdate, num, valueOrDefault);
                }
            } catch (Throwable th) {
                FLog.e((Class<?>) ViewManager.class, "Error while updating prop " + this.propName, th);
                throw new JSApplicationIllegalArgumentException("Error while updating property '" + this.propName + "' in shadow node of type: " + nodeToUpdate.getViewClass(), th);
            }
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$DynamicPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "Lcom/facebook/react/uimanager/annotations/ReactPropGroup;", FirebaseAnalytics.Param.INDEX, "", "(Lcom/facebook/react/uimanager/annotations/ReactPropGroup;Ljava/lang/reflect/Method;I)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class DynamicPropSetter extends PropSetter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DynamicPropSetter(ReactProp prop, Method setter) {
            super(prop, "mixed", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DynamicPropSetter(ReactPropGroup prop, Method setter, int i) {
            super(prop, "mixed", setter, i);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return value instanceof Dynamic ? (Dynamic) value : new DynamicFromObject(value);
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\fJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$IntPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "defaultValue", "", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;I)V", "Lcom/facebook/react/uimanager/annotations/ReactPropGroup;", FirebaseAnalytics.Param.INDEX, "(Lcom/facebook/react/uimanager/annotations/ReactPropGroup;Ljava/lang/reflect/Method;II)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class IntPropSetter extends PropSetter {
        private final int defaultValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntPropSetter(ReactProp prop, Method setter, int i) {
            super(prop, "number", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.defaultValue = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntPropSetter(ReactPropGroup prop, Method setter, int i, int i2) {
            super(prop, "number", setter, i);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.defaultValue = i2;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Integer.valueOf(value == null ? this.defaultValue : (int) ((Double) value).doubleValue());
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$DoublePropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "defaultValue", "", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;D)V", "Lcom/facebook/react/uimanager/annotations/ReactPropGroup;", FirebaseAnalytics.Param.INDEX, "", "(Lcom/facebook/react/uimanager/annotations/ReactPropGroup;Ljava/lang/reflect/Method;ID)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class DoublePropSetter extends PropSetter {
        private final double defaultValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoublePropSetter(ReactProp prop, Method setter, double d) {
            super(prop, "number", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.defaultValue = d;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoublePropSetter(ReactPropGroup prop, Method setter, int i, double d) {
            super(prop, "number", setter, i);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.defaultValue = d;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Double.valueOf(value == null ? this.defaultValue : ((Double) value).doubleValue());
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\rJ\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$ColorPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "defaultValue", "", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;I)V", "Lcom/facebook/react/uimanager/annotations/ReactPropGroup;", FirebaseAnalytics.Param.INDEX, "(Lcom/facebook/react/uimanager/annotations/ReactPropGroup;Ljava/lang/reflect/Method;II)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class ColorPropSetter extends PropSetter {
        private final int defaultValue;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ColorPropSetter(ReactProp prop, Method setter) {
            this(prop, setter, 0);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ColorPropSetter(ReactProp prop, Method setter, int i) {
            super(prop, "mixed", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.defaultValue = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ColorPropSetter(ReactPropGroup prop, Method setter, int i, int i2) {
            super(prop, "mixed", setter, i);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.defaultValue = i2;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (value == null) {
                return Integer.valueOf(this.defaultValue);
            }
            return ColorPropConverter.getColor(value, context);
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$DimensionPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class DimensionPropSetter extends PropSetter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DimensionPropSetter(ReactProp prop, Method setter) {
            super(prop, "mixed", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return DimensionPropConverter.INSTANCE.getDimension(value);
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$BooleanPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "defaultValue", "", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;Z)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BooleanPropSetter extends PropSetter {
        private final boolean defaultValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BooleanPropSetter(ReactProp prop, Method setter, boolean z) {
            super(prop, TypedValues.Custom.S_BOOLEAN, setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.defaultValue = z;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Boolean.valueOf(value == null ? this.defaultValue : ((Boolean) value).booleanValue());
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$FloatPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "defaultValue", "", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;F)V", "Lcom/facebook/react/uimanager/annotations/ReactPropGroup;", FirebaseAnalytics.Param.INDEX, "", "(Lcom/facebook/react/uimanager/annotations/ReactPropGroup;Ljava/lang/reflect/Method;IF)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class FloatPropSetter extends PropSetter {
        private final float defaultValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FloatPropSetter(ReactProp prop, Method setter, float f) {
            super(prop, "number", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.defaultValue = f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FloatPropSetter(ReactPropGroup prop, Method setter, int i, float f) {
            super(prop, "number", setter, i);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
            this.defaultValue = f;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Float.valueOf(value == null ? this.defaultValue : (float) ((Double) value).doubleValue());
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$ArrayPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class ArrayPropSetter extends PropSetter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayPropSetter(ReactProp prop, Method setter) {
            super(prop, "Array", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (ReadableArray) value;
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$MapPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class MapPropSetter extends PropSetter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MapPropSetter(ReactProp prop, Method setter) {
            super(prop, "Map", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (ReadableMap) value;
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$StringPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class StringPropSetter extends PropSetter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringPropSetter(ReactProp prop, Method setter) {
            super(prop, "String", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (String) value;
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$BoxedBooleanPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BoxedBooleanPropSetter extends PropSetter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxedBooleanPropSetter(ReactProp prop, Method setter) {
            super(prop, TypedValues.Custom.S_BOOLEAN, setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (value != null) {
                return Boolean.valueOf(((Boolean) value).booleanValue());
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$BoxedFloatPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BoxedFloatPropSetter extends PropSetter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxedFloatPropSetter(ReactProp prop, Method setter) {
            super(prop, "number", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (value != null) {
                return Float.valueOf(value instanceof Double ? (float) ((Number) value).doubleValue() : ((Float) value).floatValue());
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$BoxedIntPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "Lcom/facebook/react/uimanager/annotations/ReactPropGroup;", FirebaseAnalytics.Param.INDEX, "", "(Lcom/facebook/react/uimanager/annotations/ReactPropGroup;Ljava/lang/reflect/Method;I)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BoxedIntPropSetter extends PropSetter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxedIntPropSetter(ReactProp prop, Method setter) {
            super(prop, "number", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxedIntPropSetter(ReactPropGroup prop, Method setter, int i) {
            super(prop, "number", setter, i);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (value != null) {
                return Integer.valueOf(value instanceof Double ? (int) ((Number) value).doubleValue() : ((Integer) value).intValue());
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ViewManagersPropertyCache.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagersPropertyCache$BoxedColorPropSetter;", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "prop", "Lcom/facebook/react/uimanager/annotations/ReactProp;", "setter", "Ljava/lang/reflect/Method;", "<init>", "(Lcom/facebook/react/uimanager/annotations/ReactProp;Ljava/lang/reflect/Method;)V", "Lcom/facebook/react/uimanager/annotations/ReactPropGroup;", FirebaseAnalytics.Param.INDEX, "", "(Lcom/facebook/react/uimanager/annotations/ReactPropGroup;Ljava/lang/reflect/Method;I)V", "getValueOrDefault", "", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BoxedColorPropSetter extends PropSetter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxedColorPropSetter(ReactProp prop, Method setter) {
            super(prop, "mixed", setter);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxedColorPropSetter(ReactPropGroup prop, Method setter, int i) {
            super(prop, "mixed", setter, i);
            Intrinsics.checkNotNullParameter(prop, "prop");
            Intrinsics.checkNotNullParameter(setter, "setter");
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        protected Object getValueOrDefault(Object value, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (value != null) {
                return ColorPropConverter.getColor(value, context);
            }
            return null;
        }
    }

    @JvmStatic
    public static final Map<String, String> getNativePropsForView$ReactAndroid(Class<? extends ViewManager<?, ?>> viewManagerTopClass, Class<? extends ReactShadowNode<?>> shadowNodeTopClass) {
        Intrinsics.checkNotNullParameter(viewManagerTopClass, "viewManagerTopClass");
        Intrinsics.checkNotNullParameter(shadowNodeTopClass, "shadowNodeTopClass");
        HashMap map = new HashMap();
        for (PropSetter propSetter : getNativePropSettersForViewManagerClass$ReactAndroid(viewManagerTopClass).values()) {
            map.put(propSetter.getPropName(), propSetter.getPropType());
        }
        for (PropSetter propSetter2 : getNativePropSettersForShadowNodeClass$ReactAndroid(shadowNodeTopClass).values()) {
            map.put(propSetter2.getPropName(), propSetter2.getPropType());
        }
        return map;
    }

    @JvmStatic
    public static final Map<String, PropSetter> getNativePropSettersForViewManagerClass$ReactAndroid(Class<? extends ViewManager<?, ?>> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        if (Intrinsics.areEqual(cls, ViewManager.class)) {
            return EMPTY_PROPS_MAP;
        }
        Map<Class<?>, Map<String, PropSetter>> map = CLASS_PROPS_CACHE;
        Map<String, PropSetter> map2 = map.get(cls);
        if (map2 != null) {
            return map2;
        }
        ViewManagersPropertyCache viewManagersPropertyCache = INSTANCE;
        Class<? super Object> superclass = cls.getSuperclass();
        Intrinsics.checkNotNull(superclass, "null cannot be cast to non-null type java.lang.Class<out com.facebook.react.uimanager.ViewManager<*, *>>");
        HashMap map3 = new HashMap(getNativePropSettersForViewManagerClass$ReactAndroid(superclass));
        viewManagersPropertyCache.extractPropSettersFromViewManagerClassDefinition(cls, map3);
        map.put(cls, map3);
        return map3;
    }

    @JvmStatic
    public static final Map<String, PropSetter> getNativePropSettersForShadowNodeClass$ReactAndroid(Class<? extends ReactShadowNode<?>> cls) {
        Map<String, PropSetter> nativePropSettersForShadowNodeClass$ReactAndroid;
        Intrinsics.checkNotNullParameter(cls, "cls");
        Iterator it = ArrayIteratorKt.iterator(cls.getInterfaces());
        while (it.hasNext()) {
            if (Intrinsics.areEqual((Class) it.next(), ReactShadowNode.class)) {
                return EMPTY_PROPS_MAP;
            }
        }
        Map<Class<?>, Map<String, PropSetter>> map = CLASS_PROPS_CACHE;
        Map<String, PropSetter> map2 = map.get(cls);
        if (map2 != null) {
            return map2;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (!(superclass instanceof Class)) {
            superclass = null;
        }
        if (superclass != null) {
            nativePropSettersForShadowNodeClass$ReactAndroid = getNativePropSettersForShadowNodeClass$ReactAndroid(superclass);
        } else {
            nativePropSettersForShadowNodeClass$ReactAndroid = EMPTY_PROPS_MAP;
        }
        HashMap map3 = new HashMap(nativePropSettersForShadowNodeClass$ReactAndroid);
        INSTANCE.extractPropSettersFromShadowNodeClassDefinition(cls, map3);
        map.put(cls, map3);
        return map3;
    }

    private final PropSetter createPropSetter(ReactProp annotation, Method method, Class<?> propTypeClass) {
        if (Intrinsics.areEqual(propTypeClass, Dynamic.class)) {
            return new DynamicPropSetter(annotation, method);
        }
        if (Intrinsics.areEqual(propTypeClass, Boolean.TYPE)) {
            return new BooleanPropSetter(annotation, method, annotation.defaultBoolean());
        }
        if (Intrinsics.areEqual(propTypeClass, Integer.TYPE)) {
            if (Intrinsics.areEqual("Color", annotation.customType())) {
                return new ColorPropSetter(annotation, method, annotation.defaultInt());
            }
            return new IntPropSetter(annotation, method, annotation.defaultInt());
        }
        if (Intrinsics.areEqual(propTypeClass, Float.TYPE)) {
            return new FloatPropSetter(annotation, method, annotation.defaultFloat());
        }
        if (Intrinsics.areEqual(propTypeClass, Double.TYPE)) {
            return new DoublePropSetter(annotation, method, annotation.defaultDouble());
        }
        if (Intrinsics.areEqual(propTypeClass, String.class)) {
            return new StringPropSetter(annotation, method);
        }
        if (Intrinsics.areEqual(propTypeClass, Boolean.class)) {
            return new BoxedBooleanPropSetter(annotation, method);
        }
        if (Intrinsics.areEqual(propTypeClass, Float.class)) {
            return new BoxedFloatPropSetter(annotation, method);
        }
        if (Intrinsics.areEqual(propTypeClass, Integer.class)) {
            if (Intrinsics.areEqual("Color", annotation.customType())) {
                return new BoxedColorPropSetter(annotation, method);
            }
            return new BoxedIntPropSetter(annotation, method);
        }
        if (Intrinsics.areEqual(propTypeClass, ReadableArray.class)) {
            return new ArrayPropSetter(annotation, method);
        }
        if (Intrinsics.areEqual(propTypeClass, ReadableMap.class)) {
            return new MapPropSetter(annotation, method);
        }
        if (Intrinsics.areEqual(propTypeClass, YogaValue.class)) {
            return new DimensionPropSetter(annotation, method);
        }
        throw new RuntimeException("Unrecognized type: " + propTypeClass + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
    }

    private final void createPropSetters(ReactPropGroup annotation, Method method, Class<?> propTypeClass, Map<String, PropSetter> props) {
        PropSetter boxedIntPropSetter;
        PropSetter intPropSetter;
        String[] strArrNames = annotation.names();
        int i = 0;
        if (Intrinsics.areEqual(propTypeClass, Dynamic.class)) {
            int length = strArrNames.length;
            while (i < length) {
                props.put(strArrNames[i], new DynamicPropSetter(annotation, method, i));
                i++;
            }
            return;
        }
        if (Intrinsics.areEqual(propTypeClass, Integer.TYPE)) {
            int length2 = strArrNames.length;
            while (i < length2) {
                String str = strArrNames[i];
                if (Intrinsics.areEqual("Color", annotation.customType())) {
                    intPropSetter = new ColorPropSetter(annotation, method, i, annotation.defaultInt());
                } else {
                    intPropSetter = new IntPropSetter(annotation, method, i, annotation.defaultInt());
                }
                props.put(str, intPropSetter);
                i++;
            }
            return;
        }
        if (Intrinsics.areEqual(propTypeClass, Float.TYPE)) {
            int length3 = strArrNames.length;
            while (i < length3) {
                props.put(strArrNames[i], new FloatPropSetter(annotation, method, i, annotation.defaultFloat()));
                i++;
            }
            return;
        }
        if (Intrinsics.areEqual(propTypeClass, Double.TYPE)) {
            int length4 = strArrNames.length;
            for (int i2 = 0; i2 < length4; i2++) {
                props.put(strArrNames[i2], new DoublePropSetter(annotation, method, i2, annotation.defaultDouble()));
            }
            return;
        }
        if (Intrinsics.areEqual(propTypeClass, Integer.class)) {
            int length5 = strArrNames.length;
            while (i < length5) {
                String str2 = strArrNames[i];
                if (Intrinsics.areEqual("Color", annotation.customType())) {
                    boxedIntPropSetter = new BoxedColorPropSetter(annotation, method, i);
                } else {
                    boxedIntPropSetter = new BoxedIntPropSetter(annotation, method, i);
                }
                props.put(str2, boxedIntPropSetter);
                i++;
            }
            return;
        }
        throw new RuntimeException("Unrecognized type: " + propTypeClass + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
    }

    private final void extractPropSettersFromViewManagerClassDefinition(Class<? extends ViewManager<?, ?>> cls, Map<String, PropSetter> props) {
        Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredMethods());
        while (it.hasNext()) {
            Method method = (Method) it.next();
            ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
            if (reactProp != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 2) {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                }
                if (!View.class.isAssignableFrom(parameterTypes[0])) {
                    throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                }
                String strName = reactProp.name();
                Intrinsics.checkNotNull(method);
                Class<?> cls2 = parameterTypes[1];
                Intrinsics.checkNotNullExpressionValue(cls2, "get(...)");
                props.put(strName, createPropSetter(reactProp, method, cls2));
            }
            ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
            if (reactPropGroup != null) {
                Class<?>[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 3) {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                }
                if (!View.class.isAssignableFrom(parameterTypes2[0])) {
                    throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                }
                if (!Intrinsics.areEqual(parameterTypes2[1], Integer.TYPE)) {
                    throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                }
                Intrinsics.checkNotNull(method);
                Class<?> cls3 = parameterTypes2[2];
                Intrinsics.checkNotNullExpressionValue(cls3, "get(...)");
                createPropSetters(reactPropGroup, method, cls3, props);
            }
        }
    }

    private final void extractPropSettersFromShadowNodeClassDefinition(Class<? extends ReactShadowNode<?>> cls, Map<String, PropSetter> props) {
        Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredMethods());
        while (it.hasNext()) {
            Method method = (Method) it.next();
            ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
            if (reactProp != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                }
                String strName = reactProp.name();
                Intrinsics.checkNotNull(method);
                Class<?> cls2 = parameterTypes[0];
                Intrinsics.checkNotNullExpressionValue(cls2, "get(...)");
                props.put(strName, createPropSetter(reactProp, method, cls2));
            }
            ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
            if (reactPropGroup != null) {
                Class<?>[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 2) {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                }
                if (!Intrinsics.areEqual(parameterTypes2[0], Integer.TYPE)) {
                    throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                }
                Intrinsics.checkNotNull(method);
                Class<?> cls3 = parameterTypes2[1];
                Intrinsics.checkNotNullExpressionValue(cls3, "get(...)");
                createPropSetters(reactPropGroup, method, cls3, props);
            }
        }
    }
}
