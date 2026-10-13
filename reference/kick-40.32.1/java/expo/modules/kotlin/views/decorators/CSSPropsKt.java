package expo.modules.kotlin.views.decorators;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.BoxShadow;
import com.facebook.react.uimanager.style.LogicalEdge;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CSSProps.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001as\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042O\b\u0004\u0010\u0005\u001aI\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001as\u0010\u000e\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042O\b\u0004\u0010\u0005\u001aI\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001as\u0010\u0011\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042O\b\u0004\u0010\u0005\u001aI\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a\u001c\u0010\u0011\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001a^\u0010\u0016\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042:\b\u0004\u0010\u0005\u001a4\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0017H\u0086\bø\u0001\u0000\u001a\u001c\u0010\u0016\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001a^\u0010\u001a\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042:\b\u0004\u0010\u0005\u001a4\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0017H\u0086\bø\u0001\u0000\u001a\u001c\u0010\u001a\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001ab\u0010\u001b\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042>\b\u0004\u0010\u0005\u001a8\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00010\u0017H\u0086\bø\u0001\u0000\u001a\u001c\u0010\u001b\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001a\u001c\u0010\u001f\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"UseBorderColorProps", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "view", "Lcom/facebook/react/uimanager/style/LogicalEdge;", "edge", "", "color", "UseBorderWidthProps", "", ViewProps.WIDTH, "UseBorderRadiusProps", "Lcom/facebook/react/uimanager/style/BorderRadiusProp;", "border", "Lcom/facebook/react/uimanager/LengthPercentage;", "radius", "UseBorderStyleProp", "Lkotlin/Function2;", "Lcom/facebook/react/uimanager/style/BorderStyle;", "style", "UseBackgroundProp", "UseBoxShadowProp", "", "Lcom/facebook/react/uimanager/style/BoxShadow;", "shadow", "UseCSSProps", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CSSPropsKt {
    public static final /* synthetic */ <T extends View> void UseBorderColorProps(ViewDefinitionBuilder<T> viewDefinitionBuilder, final Function3<? super T, ? super LogicalEdge, ? super Integer, Unit> body) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(viewDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        Pair[] pairArr = {TuplesKt.to(ViewProps.BORDER_COLOR, 8), TuplesKt.to(ViewProps.BORDER_LEFT_COLOR, 0), TuplesKt.to(ViewProps.BORDER_RIGHT_COLOR, 2), TuplesKt.to(ViewProps.BORDER_TOP_COLOR, 1), TuplesKt.to(ViewProps.BORDER_BOTTOM_COLOR, 3), TuplesKt.to(ViewProps.BORDER_START_COLOR, 4), TuplesKt.to(ViewProps.BORDER_END_COLOR, 5), TuplesKt.to(ViewProps.BORDER_BLOCK_COLOR, 9), TuplesKt.to(ViewProps.BORDER_BLOCK_END_COLOR, 10), TuplesKt.to(ViewProps.BORDER_BLOCK_START_COLOR, 11)};
        Intrinsics.needClassReification();
        final Function3 function3 = new Function3<T, Integer, Integer, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt.UseBorderColorProps.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Integer num, Integer num2) {
                invoke((View) obj, num.intValue(), num2);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect types in method signature: (TT;ILjava/lang/Integer;)V */
            public final void invoke(View view, int i, Integer num) {
                Intrinsics.checkNotNullParameter(view, "view");
                body.invoke(view, LogicalEdge.INSTANCE.fromSpacingType(i), num);
            }
        };
        for (int i = 0; i < 10; i++) {
            Pair pair = pairArr[i];
            String str = (String) pair.component1();
            final Object objComponent2 = pair.component2();
            Intrinsics.needClassReification();
            Function2 function2 = new Function2<T, Integer, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderColorProps$$inlined$PropGroup$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object obj, Integer num) {
                    invoke((View) obj, (Object) num);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Incorrect types in method signature: (TT;Ljava/lang/Integer;)V */
                public final void invoke(View view, Object obj) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    function3.invoke(view, objComponent2, obj);
                }
            };
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT_NULLABLE), CSSPropsKt$UseBorderColorProps$$inlined$PropGroup$2.INSTANCE));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
                }
                anyType = new AnyType(typeDescriptor, null);
            }
            viewDefinitionBuilder.getProps().put(str, new ConcreteViewProp(str, anyType, function2));
        }
    }

    public static final /* synthetic */ <T extends View> void UseBorderWidthProps(ViewDefinitionBuilder<T> viewDefinitionBuilder, final Function3<? super T, ? super LogicalEdge, ? super Float, Unit> body) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(viewDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        String[] strArr = {ViewProps.BORDER_WIDTH, ViewProps.BORDER_LEFT_WIDTH, ViewProps.BORDER_RIGHT_WIDTH, ViewProps.BORDER_TOP_WIDTH, ViewProps.BORDER_BOTTOM_WIDTH, ViewProps.BORDER_START_WIDTH, ViewProps.BORDER_END_WIDTH};
        Intrinsics.needClassReification();
        final Function3 function3 = new Function3<T, Integer, Float, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt.UseBorderWidthProps.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Integer num, Float f) {
                invoke((View) obj, num.intValue(), f);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect types in method signature: (TT;ILjava/lang/Float;)V */
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final void invoke(View view, int i, Float f) {
                Intrinsics.checkNotNullParameter(view, "view");
                body.invoke((T) view, LogicalEdge.getEntries().get(i), f);
            }
        };
        final int i = 0;
        int i2 = 0;
        while (i2 < 7) {
            String str = strArr[i2];
            int i3 = i + 1;
            Intrinsics.needClassReification();
            Function2 function2 = new Function2<T, Float, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderWidthProps$$inlined$PropGroup$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object obj, Float f) {
                    invoke((View) obj, (Object) f);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Incorrect types in method signature: (TT;Ljava/lang/Float;)V */
                public final void invoke(View view, Object obj) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    function3.invoke(view, Integer.valueOf(i), obj);
                }
            };
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), true));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT_NULLABLE), CSSPropsKt$UseBorderWidthProps$$inlined$PropGroup$2.INSTANCE));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Float.class));
                }
                anyType = new AnyType(typeDescriptor, null);
            }
            viewDefinitionBuilder.getProps().put(str, new ConcreteViewProp(str, anyType, function2));
            i2++;
            i = i3;
        }
    }

    public static final /* synthetic */ <T extends View> void UseBorderRadiusProps(ViewDefinitionBuilder<T> viewDefinitionBuilder, final Function3<? super T, ? super BorderRadiusProp, ? super LengthPercentage, Unit> body) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(viewDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        String[] strArr = {ViewProps.BORDER_RADIUS, ViewProps.BORDER_TOP_LEFT_RADIUS, ViewProps.BORDER_TOP_RIGHT_RADIUS, ViewProps.BORDER_BOTTOM_RIGHT_RADIUS, ViewProps.BORDER_BOTTOM_LEFT_RADIUS, ViewProps.BORDER_TOP_START_RADIUS, ViewProps.BORDER_TOP_END_RADIUS, ViewProps.BORDER_BOTTOM_START_RADIUS, ViewProps.BORDER_BOTTOM_END_RADIUS, ViewProps.BORDER_END_END_RADIUS, ViewProps.BORDER_END_START_RADIUS, ViewProps.BORDER_START_END_RADIUS, ViewProps.BORDER_START_START_RADIUS};
        Intrinsics.needClassReification();
        final Function3 function3 = new Function3<T, Integer, Float, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt.UseBorderRadiusProps.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Integer num, Float f) {
                invoke((View) obj, num.intValue(), f);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect types in method signature: (TT;ILjava/lang/Float;)V */
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final void invoke(View view, int i, Float f) {
                Intrinsics.checkNotNullParameter(view, "view");
                body.invoke((T) view, BorderRadiusProp.getEntries().get(i), f != null ? new LengthPercentage(f.floatValue(), LengthPercentageType.POINT) : null);
            }
        };
        final int i = 0;
        int i2 = 0;
        while (i2 < 13) {
            String str = strArr[i2];
            int i3 = i + 1;
            Intrinsics.needClassReification();
            Function2 function2 = new Function2<T, Float, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderRadiusProps$$inlined$PropGroup$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object obj, Float f) {
                    invoke((View) obj, (Object) f);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Incorrect types in method signature: (TT;Ljava/lang/Float;)V */
                public final void invoke(View view, Object obj) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    function3.invoke(view, Integer.valueOf(i), obj);
                }
            };
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), true));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT_NULLABLE), CSSPropsKt$UseBorderRadiusProps$$inlined$PropGroup$2.INSTANCE));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Float.class));
                }
                anyType = new AnyType(typeDescriptor, null);
            }
            viewDefinitionBuilder.getProps().put(str, new ConcreteViewProp(str, anyType, function2));
            i2++;
            i = i3;
        }
    }

    public static final /* synthetic */ <T extends View> void UseBorderStyleProp(ViewDefinitionBuilder<T> viewDefinitionBuilder, final Function2<? super T, ? super BorderStyle, Unit> body) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(viewDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        Function2 function2 = new Function2<T, String, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt.UseBorderStyleProp.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, String str) {
                invoke((View) obj, str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect types in method signature: (TT;Ljava/lang/String;)V */
            public final void invoke(View view, String str) {
                Intrinsics.checkNotNullParameter(view, "view");
                body.invoke(view, str != null ? BorderStyle.INSTANCE.fromString(str) : null);
            }
        };
        AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), CSSPropsKt$UseBorderStyleProp$$inlined$Prop$1.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
            }
            anyType = new AnyType(typeDescriptor, null);
        }
        viewDefinitionBuilder.getProps().put("borderStyle", new ConcreteViewProp("borderStyle", anyType, function2));
    }

    public static final /* synthetic */ <T extends View> void UseBackgroundProp(ViewDefinitionBuilder<T> viewDefinitionBuilder, final Function2<? super T, ? super Integer, Unit> body) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(viewDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        Function2 function2 = new Function2<T, Integer, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt.UseBackgroundProp.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Integer num) {
                invoke((View) obj, num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect types in method signature: (TT;Ljava/lang/Integer;)V */
            public final void invoke(View view, Integer num) {
                Intrinsics.checkNotNullParameter(view, "view");
                body.invoke(view, num);
            }
        };
        AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT_NULLABLE), CSSPropsKt$UseBackgroundProp$$inlined$Prop$1.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
            }
            anyType = new AnyType(typeDescriptor, null);
        }
        viewDefinitionBuilder.getProps().put(ViewProps.BACKGROUND_COLOR, new ConcreteViewProp(ViewProps.BACKGROUND_COLOR, anyType, function2));
    }

    public static final /* synthetic */ <T extends View> void UseBoxShadowProp(ViewDefinitionBuilder<T> viewDefinitionBuilder, final Function2<? super T, ? super List<BoxShadow>, Unit> body) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(viewDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        Function2 function2 = new Function2<T, ReadableArray, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt.UseBoxShadowProp.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, ReadableArray readableArray) {
                invoke((View) obj, readableArray);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect types in method signature: (TT;Lcom/facebook/react/bridge/ReadableArray;)V */
            public final void invoke(View view, ReadableArray readableArray) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (readableArray == null) {
                    body.invoke(view, CollectionsKt.emptyList());
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int size = readableArray.size();
                for (int i = 0; i < size; i++) {
                    BoxShadow.Companion companion = BoxShadow.INSTANCE;
                    ReadableMap map = readableArray.getMap(i);
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    BoxShadow boxShadow = companion.parse(map, context);
                    if (boxShadow != null) {
                        arrayList.add(boxShadow);
                    }
                }
                body.invoke(view, arrayList);
            }
        };
        AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ReadableArray.class), true));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReadableArray.class, true, null)), CSSPropsKt$UseBoxShadowProp$$inlined$Prop$1.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(ReadableArray.class));
            }
            anyType = new AnyType(typeDescriptor, null);
        }
        viewDefinitionBuilder.getProps().put(ViewProps.BOX_SHADOW, new ConcreteViewProp(ViewProps.BOX_SHADOW, anyType, function2));
    }

    public static final <T extends View> void UseCSSProps(ViewDefinitionBuilder<T> viewDefinitionBuilder) {
        Intrinsics.checkNotNullParameter(viewDefinitionBuilder, "<this>");
        UseBorderColorProps(viewDefinitionBuilder);
        UseBorderWidthProps(viewDefinitionBuilder);
        UseBorderRadiusProps(viewDefinitionBuilder);
        UseBorderStyleProp(viewDefinitionBuilder);
        UseBackgroundProp(viewDefinitionBuilder);
        UseBoxShadowProp(viewDefinitionBuilder);
    }

    private static final <T extends View> void UseBorderColorProps(ViewDefinitionBuilder<T> viewDefinitionBuilder) {
        Object objM12684constructorimpl;
        Pair[] pairArr = {TuplesKt.to(ViewProps.BORDER_COLOR, 8), TuplesKt.to(ViewProps.BORDER_LEFT_COLOR, 0), TuplesKt.to(ViewProps.BORDER_RIGHT_COLOR, 2), TuplesKt.to(ViewProps.BORDER_TOP_COLOR, 1), TuplesKt.to(ViewProps.BORDER_BOTTOM_COLOR, 3), TuplesKt.to(ViewProps.BORDER_START_COLOR, 4), TuplesKt.to(ViewProps.BORDER_END_COLOR, 5), TuplesKt.to(ViewProps.BORDER_BLOCK_COLOR, 9), TuplesKt.to(ViewProps.BORDER_BLOCK_END_COLOR, 10), TuplesKt.to(ViewProps.BORDER_BLOCK_START_COLOR, 11)};
        final Function3<View, Integer, Integer, Unit> function3 = new Function3<View, Integer, Integer, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderColorProps$$inlined$UseBorderColorProps$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Integer num2) {
                invoke(view, num.intValue(), num2);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, Integer num) {
                Intrinsics.checkNotNullParameter(view, "view");
                BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.INSTANCE.fromSpacingType(i), num);
            }
        };
        for (int i = 0; i < 10; i++) {
            Pair pair = pairArr[i];
            String str = (String) pair.component1();
            final Object objComponent2 = pair.component2();
            Function2<View, Integer, Unit> function2 = new Function2<View, Integer, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderColorProps$$inlined$UseBorderColorProps$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                    invoke(view, num);
                    return Unit.INSTANCE;
                }

                public final void invoke(View view, Integer num) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    function3.invoke(view, objComponent2, num);
                }
            };
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT_NULLABLE), CSSPropsKt$UseBorderColorProps$$inlined$PropGroup$2.INSTANCE));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
                }
                anyType = new AnyType(typeDescriptor, null);
            }
            viewDefinitionBuilder.getProps().put(str, new ConcreteViewProp(str, anyType, function2));
        }
    }

    private static final <T extends View> void UseBorderWidthProps(ViewDefinitionBuilder<T> viewDefinitionBuilder) {
        Object objM12684constructorimpl;
        String[] strArr = {ViewProps.BORDER_WIDTH, ViewProps.BORDER_LEFT_WIDTH, ViewProps.BORDER_RIGHT_WIDTH, ViewProps.BORDER_TOP_WIDTH, ViewProps.BORDER_BOTTOM_WIDTH, ViewProps.BORDER_START_WIDTH, ViewProps.BORDER_END_WIDTH};
        final Function3<View, Integer, Float, Unit> function3 = new Function3<View, Integer, Float, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderWidthProps$$inlined$UseBorderWidthProps$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Float f) {
                invoke(view, num.intValue(), f);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, Float f) {
                Intrinsics.checkNotNullParameter(view, "view");
                BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.getEntries().get(i), f);
            }
        };
        final int i = 0;
        int i2 = 0;
        while (i2 < 7) {
            String str = strArr[i2];
            int i3 = i + 1;
            Function2<View, Float, Unit> function2 = new Function2<View, Float, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderWidthProps$$inlined$UseBorderWidthProps$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, Float f) {
                    invoke(view, f);
                    return Unit.INSTANCE;
                }

                public final void invoke(View view, Float f) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    function3.invoke(view, Integer.valueOf(i), f);
                }
            };
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), true));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT_NULLABLE), CSSPropsKt$UseBorderWidthProps$$inlined$PropGroup$2.INSTANCE));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Float.class));
                }
                anyType = new AnyType(typeDescriptor, null);
            }
            viewDefinitionBuilder.getProps().put(str, new ConcreteViewProp(str, anyType, function2));
            i2++;
            i = i3;
        }
    }

    private static final <T extends View> void UseBorderRadiusProps(ViewDefinitionBuilder<T> viewDefinitionBuilder) {
        Object objM12684constructorimpl;
        String[] strArr = {ViewProps.BORDER_RADIUS, ViewProps.BORDER_TOP_LEFT_RADIUS, ViewProps.BORDER_TOP_RIGHT_RADIUS, ViewProps.BORDER_BOTTOM_RIGHT_RADIUS, ViewProps.BORDER_BOTTOM_LEFT_RADIUS, ViewProps.BORDER_TOP_START_RADIUS, ViewProps.BORDER_TOP_END_RADIUS, ViewProps.BORDER_BOTTOM_START_RADIUS, ViewProps.BORDER_BOTTOM_END_RADIUS, ViewProps.BORDER_END_END_RADIUS, ViewProps.BORDER_END_START_RADIUS, ViewProps.BORDER_START_END_RADIUS, ViewProps.BORDER_START_START_RADIUS};
        final Function3<View, Integer, Float, Unit> function3 = new Function3<View, Integer, Float, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderRadiusProps$$inlined$UseBorderRadiusProps$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Float f) {
                invoke(view, num.intValue(), f);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, Float f) {
                Intrinsics.checkNotNullParameter(view, "view");
                BackgroundStyleApplicator.setBorderRadius(view, BorderRadiusProp.getEntries().get(i), f != null ? new LengthPercentage(f.floatValue(), LengthPercentageType.POINT) : null);
            }
        };
        final int i = 0;
        int i2 = 0;
        while (i2 < 13) {
            String str = strArr[i2];
            int i3 = i + 1;
            Function2<View, Float, Unit> function2 = new Function2<View, Float, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderRadiusProps$$inlined$UseBorderRadiusProps$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, Float f) {
                    invoke(view, f);
                    return Unit.INSTANCE;
                }

                public final void invoke(View view, Float f) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    function3.invoke(view, Integer.valueOf(i), f);
                }
            };
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), true));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT_NULLABLE), CSSPropsKt$UseBorderRadiusProps$$inlined$PropGroup$2.INSTANCE));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Float.class));
                }
                anyType = new AnyType(typeDescriptor, null);
            }
            viewDefinitionBuilder.getProps().put(str, new ConcreteViewProp(str, anyType, function2));
            i2++;
            i = i3;
        }
    }

    private static final <T extends View> void UseBorderStyleProp(ViewDefinitionBuilder<T> viewDefinitionBuilder) {
        Object objM12684constructorimpl;
        Function2<View, String, Unit> function2 = new Function2<View, String, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBorderStyleProp$$inlined$UseBorderStyleProp$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, String str) {
                invoke2(view, str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, String str) {
                Intrinsics.checkNotNullParameter(view, "view");
                BackgroundStyleApplicator.setBorderStyle(view, str != null ? BorderStyle.INSTANCE.fromString(str) : null);
            }
        };
        AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), CSSPropsKt$UseBorderStyleProp$$inlined$Prop$1.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
            }
            anyType = new AnyType(typeDescriptor, null);
        }
        viewDefinitionBuilder.getProps().put("borderStyle", new ConcreteViewProp("borderStyle", anyType, function2));
    }

    private static final <T extends View> void UseBackgroundProp(ViewDefinitionBuilder<T> viewDefinitionBuilder) {
        Object objM12684constructorimpl;
        Function2<View, Integer, Unit> function2 = new Function2<View, Integer, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBackgroundProp$$inlined$UseBackgroundProp$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                invoke2(view, num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, Integer num) {
                Intrinsics.checkNotNullParameter(view, "view");
                BackgroundStyleApplicator.setBackgroundColor(view, num);
            }
        };
        AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT_NULLABLE), CSSPropsKt$UseBackgroundProp$$inlined$Prop$1.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
            }
            anyType = new AnyType(typeDescriptor, null);
        }
        viewDefinitionBuilder.getProps().put(ViewProps.BACKGROUND_COLOR, new ConcreteViewProp(ViewProps.BACKGROUND_COLOR, anyType, function2));
    }

    private static final <T extends View> void UseBoxShadowProp(ViewDefinitionBuilder<T> viewDefinitionBuilder) {
        Object objM12684constructorimpl;
        Function2<View, ReadableArray, Unit> function2 = new Function2<View, ReadableArray, Unit>() { // from class: expo.modules.kotlin.views.decorators.CSSPropsKt$UseBoxShadowProp$$inlined$UseBoxShadowProp$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, ReadableArray readableArray) {
                invoke2(view, readableArray);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, ReadableArray readableArray) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (readableArray != null) {
                    ArrayList arrayList = new ArrayList();
                    int size = readableArray.size();
                    for (int i = 0; i < size; i++) {
                        BoxShadow.Companion companion = BoxShadow.INSTANCE;
                        ReadableMap map = readableArray.getMap(i);
                        Context context = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        BoxShadow boxShadow = companion.parse(map, context);
                        if (boxShadow != null) {
                            arrayList.add(boxShadow);
                        }
                    }
                    BackgroundStyleApplicator.setBoxShadow(view, arrayList);
                    return;
                }
                BackgroundStyleApplicator.setBoxShadow(view, (List<BoxShadow>) CollectionsKt.emptyList());
            }
        };
        AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ReadableArray.class), true));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReadableArray.class, true, null)), CSSPropsKt$UseBoxShadowProp$$inlined$Prop$1.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(ReadableArray.class));
            }
            anyType = new AnyType(typeDescriptor, null);
        }
        viewDefinitionBuilder.getProps().put(ViewProps.BOX_SHADOW, new ConcreteViewProp(ViewProps.BOX_SHADOW, anyType, function2));
    }
}
