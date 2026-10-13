package expo.modules.ui;

import android.graphics.Color;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.CutCornerShape;
import androidx.compose.foundation.shape.CutCornerShapeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ExposedDropdownMenuAnchorType;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.material3.MaterialShapesKt;
import androidx.compose.material3.carousel.CarouselItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.OnVisibilityChangedModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.graphics.shapes.RoundedPolygon;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.records.RecordTypeConverter;
import expo.modules.kotlin.records.RecordTypeConverterKt;
import expo.modules.kotlin.types.ConverterContext;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProviderImpl;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.ui.convertibles.AlignmentType;
import expo.modules.ui.convertibles.AnimatableFloatKt;
import expo.modules.ui.convertibles.CompositingStrategyType;
import expo.modules.ui.convertibles.GraphicsLayerParams;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003¢\u0006\u0002\u0010\u0017Jx\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00062c\u0010\u001a\u001a_\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0012(\u0012&\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\u0007j\u0002`\u0012¢\u0006\u0002\b\u0011¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0006Ji\u0010\u001d\u001a\u00020\u00102\u001e\u0010\u001e\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u0002`\n\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2*\u0010#\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000fH\u0007¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u0006J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fJ\b\u0010(\u001a\u00020\u000eH\u0002Rw\u0010\u0004\u001ak\u0012\u0004\u0012\u00020\u0006\u0012a\u0012_\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0012(\u0012&\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\u0007j\u0002`\u0012¢\u0006\u0002\b\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)²\u0006\n\u0010*\u001a\u00020+X\u008a\u0084\u0002"}, d2 = {"Lexpo/modules/ui/ModifierRegistry;", "", "<init>", "()V", "modifierFactories", "", "", "Lkotlin/Function4;", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/kotlin/views/ComposableScope;", "Lexpo/modules/kotlin/types/ConverterContext;", "Lkotlin/Function2;", "", "Lexpo/modules/ui/ModifierEventDispatcher;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "Lexpo/modules/ui/ModifierFactory;", "resolveShape", "Landroidx/compose/ui/graphics/Shape;", "shape", "Lexpo/modules/ui/BuiltinShapeRecord;", "(Lexpo/modules/ui/BuiltinShapeRecord;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "register", "type", "factory", "(Ljava/lang/String;Lkotlin/jvm/functions/Function6;)V", "unregister", "applyModifiers", "modifiers", "", "appContext", "Lexpo/modules/kotlin/AppContext;", PermissionsResponse.SCOPE_KEY, "eventDispatcher", "(Ljava/util/List;Lexpo/modules/kotlin/AppContext;Lexpo/modules/kotlin/views/ComposableScope;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "hasModifier", "", "registeredTypes", "registerBuiltInModifiers", "expo-ui_release", "animated", "Landroidx/compose/ui/graphics/Color;"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ModifierRegistry {
    public static final int $stable;
    public static final ModifierRegistry INSTANCE;
    private static final Map<String, Function6<Map<String, ? extends Dynamic>, ComposableScope, ConverterContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit>, Composer, Integer, Modifier>> modifierFactories;

    /* JADX INFO: compiled from: ModifierRegistry.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[BuiltinShapeType.values().length];
            try {
                iArr[BuiltinShapeType.RECTANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BuiltinShapeType.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BuiltinShapeType.ROUNDED_CORNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BuiltinShapeType.CUT_CORNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BuiltinShapeType.MATERIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CompositingStrategyType.values().length];
            try {
                iArr2[CompositingStrategyType.OFFSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CompositingStrategyType.MODULATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SemanticRoleType.values().length];
            try {
                iArr3[SemanticRoleType.CHECKBOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[SemanticRoleType.RADIO_BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[SemanticRoleType.SWITCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[SemanticRoleType.TAB.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[MenuAnchorType.values().length];
            try {
                iArr4[MenuAnchorType.PRIMARY_NOT_EDITABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    private ModifierRegistry() {
    }

    static {
        ModifierRegistry modifierRegistry = new ModifierRegistry();
        INSTANCE = modifierRegistry;
        modifierFactories = new LinkedHashMap();
        modifierRegistry.registerBuiltInModifiers();
        $stable = 8;
    }

    private final Shape resolveShape(BuiltinShapeRecord builtinShapeRecord, Composer composer, int i) {
        RoundedCornerShape rectangleShape;
        RoundedCornerShape roundedCornerShapeM2681RoundedCornerShapea9UjIt4;
        CutCornerShape cutCornerShapeM2674CutCornerShapea9UjIt4;
        ComposerKt.sourceInformationMarkerStart(composer, 664829230, "C(resolveShape)N(shape):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(664829230, i, -1, "expo.modules.ui.ModifierRegistry.resolveShape (ModifierRegistry.kt:357)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[builtinShapeRecord.getType().ordinal()];
        if (i2 == 1) {
            composer.startReplaceGroup(-1049232484);
            composer.endReplaceGroup();
            rectangleShape = RectangleShapeKt.getRectangleShape();
        } else if (i2 != 2) {
            if (i2 == 3) {
                composer.startReplaceGroup(1833646717);
                composer.endReplaceGroup();
                if (builtinShapeRecord.getTopStart() != null || builtinShapeRecord.getTopEnd() != null || builtinShapeRecord.getBottomStart() != null || builtinShapeRecord.getBottomEnd() != null) {
                    Float topStart = builtinShapeRecord.getTopStart();
                    float fM10168constructorimpl = Dp.m10168constructorimpl(topStart != null ? topStart.floatValue() : 0.0f);
                    Float topEnd = builtinShapeRecord.getTopEnd();
                    float fM10168constructorimpl2 = Dp.m10168constructorimpl(topEnd != null ? topEnd.floatValue() : 0.0f);
                    Float bottomStart = builtinShapeRecord.getBottomStart();
                    float fM10168constructorimpl3 = Dp.m10168constructorimpl(bottomStart != null ? bottomStart.floatValue() : 0.0f);
                    Float bottomEnd = builtinShapeRecord.getBottomEnd();
                    roundedCornerShapeM2681RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m2681RoundedCornerShapea9UjIt4(fM10168constructorimpl, fM10168constructorimpl2, Dp.m10168constructorimpl(bottomEnd != null ? bottomEnd.floatValue() : 0.0f), fM10168constructorimpl3);
                } else {
                    Float radius = builtinShapeRecord.getRadius();
                    roundedCornerShapeM2681RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m2680RoundedCornerShape0680j_4(Dp.m10168constructorimpl(radius != null ? radius.floatValue() : 0.0f));
                }
                rectangleShape = roundedCornerShapeM2681RoundedCornerShapea9UjIt4;
            } else if (i2 == 4) {
                composer.startReplaceGroup(1834184133);
                composer.endReplaceGroup();
                if (builtinShapeRecord.getTopStart() != null || builtinShapeRecord.getTopEnd() != null || builtinShapeRecord.getBottomStart() != null || builtinShapeRecord.getBottomEnd() != null) {
                    Float topStart2 = builtinShapeRecord.getTopStart();
                    float fM10168constructorimpl4 = Dp.m10168constructorimpl(topStart2 != null ? topStart2.floatValue() : 0.0f);
                    Float topEnd2 = builtinShapeRecord.getTopEnd();
                    float fM10168constructorimpl5 = Dp.m10168constructorimpl(topEnd2 != null ? topEnd2.floatValue() : 0.0f);
                    Float bottomStart2 = builtinShapeRecord.getBottomStart();
                    float fM10168constructorimpl6 = Dp.m10168constructorimpl(bottomStart2 != null ? bottomStart2.floatValue() : 0.0f);
                    Float bottomEnd2 = builtinShapeRecord.getBottomEnd();
                    cutCornerShapeM2674CutCornerShapea9UjIt4 = CutCornerShapeKt.m2674CutCornerShapea9UjIt4(fM10168constructorimpl4, fM10168constructorimpl5, Dp.m10168constructorimpl(bottomEnd2 != null ? bottomEnd2.floatValue() : 0.0f), fM10168constructorimpl6);
                } else {
                    Float radius2 = builtinShapeRecord.getRadius();
                    cutCornerShapeM2674CutCornerShapea9UjIt4 = CutCornerShapeKt.m2673CutCornerShape0680j_4(Dp.m10168constructorimpl(radius2 != null ? radius2.floatValue() : 0.0f));
                }
                rectangleShape = cutCornerShapeM2674CutCornerShapea9UjIt4;
            } else {
                if (i2 != 5) {
                    composer.startReplaceGroup(-1049232994);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(1834698361);
                ComposerKt.sourceInformation(composer, "");
                MaterialShapeType name = builtinShapeRecord.getName();
                rectangleShape = null;
                RoundedPolygon roundedPolygon = name != null ? name.toRoundedPolygon() : null;
                if (roundedPolygon == null) {
                    composer.startReplaceGroup(1834738474);
                } else {
                    composer.startReplaceGroup(-1049193545);
                    ComposerKt.sourceInformation(composer, "392@12080L9");
                    rectangleShape = MaterialShapesKt.toShape(roundedPolygon, 0, composer, 0, 1);
                }
                composer.endReplaceGroup();
                composer.endReplaceGroup();
            }
        } else {
            composer.startReplaceGroup(-1049230951);
            composer.endReplaceGroup();
            rectangleShape = RoundedCornerShapeKt.getCircleShape();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rectangleShape;
    }

    public final void register(String type, Function6<? super Map<String, ? extends Dynamic>, ? super ComposableScope, ? super ConverterContext, ? super Function2<? super String, ? super Map<String, ? extends Object>, Unit>, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(factory, "factory");
        modifierFactories.put(type, factory);
    }

    public final void unregister(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        modifierFactories.remove(type);
    }

    public final Modifier applyModifiers(List<? extends Map<String, ? extends Dynamic>> list, AppContext appContext, ComposableScope scope, Function2<? super String, ? super Map<String, ? extends Object>, Unit> eventDispatcher, Composer composer, int i) {
        AppContext appContext2;
        ComposableScope composableScope;
        Function2<? super String, ? super Map<String, ? extends Object>, Unit> function2;
        Composer composer2;
        String strAsString;
        Modifier modifierInvoke;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        composer.startReplaceGroup(-1182308343);
        ComposerKt.sourceInformation(composer, "C(applyModifiers)N(modifiers,appContext,scope,eventDispatcher):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1182308343, i, -1, "expo.modules.ui.ModifierRegistry.applyModifiers (ModifierRegistry.kt:429)");
        }
        List<? extends Map<String, ? extends Dynamic>> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            Modifier.Companion companion = Modifier.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return companion;
        }
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Intrinsics.checkNotNull(companion2, "null cannot be cast to non-null type androidx.compose.ui.Modifier");
        Modifier.Companion companionThen = companion2;
        for (Map<String, ? extends Dynamic> map : list) {
            Dynamic dynamic = (Dynamic) map.get("$type");
            if (dynamic == null || (strAsString = dynamic.asString()) == null) {
                appContext2 = appContext;
                composableScope = scope;
                function2 = eventDispatcher;
                composer2 = composer;
            } else {
                Function6<Map<String, ? extends Dynamic>, ComposableScope, ConverterContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit>, Composer, Integer, Modifier> function6 = modifierFactories.get(strAsString);
                if (function6 == null) {
                    composer.startReplaceGroup(1964731243);
                    composer.endReplaceGroup();
                    modifierInvoke = null;
                    appContext2 = appContext;
                    composableScope = scope;
                    function2 = eventDispatcher;
                    composer2 = composer;
                } else {
                    composer.startReplaceGroup(-1183547562);
                    ComposerKt.sourceInformation(composer, "435@13177L50");
                    appContext2 = appContext;
                    composableScope = scope;
                    function2 = eventDispatcher;
                    composer2 = composer;
                    modifierInvoke = function6.invoke(map, composableScope, appContext2, function2, composer2, Integer.valueOf(((i >> 3) & 112) | (AppContext.$stable << 6) | ((i << 3) & 896) | (i & 7168)));
                    composer2.endReplaceGroup();
                }
                if (modifierInvoke == null) {
                    modifierInvoke = Modifier.INSTANCE;
                }
                companionThen = companionThen.then(modifierInvoke);
            }
            scope = composableScope;
            appContext = appContext2;
            eventDispatcher = function2;
            composer = composer2;
        }
        Composer composer3 = composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer3.endReplaceGroup();
        return companionThen;
    }

    public final boolean hasModifier(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return modifierFactories.get(type) != null;
    }

    public final List<String> registeredTypes() {
        return CollectionsKt.toList(modifierFactories.keySet());
    }

    private final void registerBuiltInModifiers() {
        register("paddingAll", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$1((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register(ViewProps.PADDING, new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$2((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register(ContentDisposition.Parameters.Size, new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$3((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("fillMaxSize", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$4((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("fillMaxWidth", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$5((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("fillMaxHeight", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$6((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register(ViewProps.WIDTH, new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$7((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register(ViewProps.HEIGHT, new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$8((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("defaultMinSize", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$9((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("wrapContentWidth", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$11((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("wrapContentHeight", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$13((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("imePadding", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$14((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("offset", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$15((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("background", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$17((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("border", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda52
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$19((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("shadow", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda53
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$20((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("dropShadow", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$22((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("innerShadow", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$24((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("alpha", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$25((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("blur", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$26((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("cornerRadius", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$27((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("rotate", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$28((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("graphicsLayer", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$34((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register(ViewProps.Z_INDEX, new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$35((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("animateContentSize", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$36((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("weight", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$39((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("align", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$46((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("matchParentSize", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$48((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register(ViewProps.TEST_ID, new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$50((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("semantics", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$55((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("clip", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$58((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("onVisibilityChanged", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$61((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("onSizeChanged", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$65((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("onGloballyPositioned", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$69((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("clickable", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$74((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("combinedClickable", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$79((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("selectable", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$82((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("selectableGroup", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$83((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("toggleable", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$86((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("menuAnchor", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$88((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("maskClip", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$91((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("verticalScroll", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$92((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
        register("horizontalScroll", new Function6() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return ModifierRegistry.registerBuiltInModifiers$lambda$93((Map) obj, (ComposableScope) obj2, (ConverterContext) obj3, (Function2) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            }
        });
    }

    static final Modifier registerBuiltInModifiers$lambda$14(Map unused$var$, ComposableScope composableScope, ConverterContext unused$var$2, Function2 unused$var$3, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$2, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$3, "$unused$var$");
        composer.startReplaceGroup(-813524089);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-813524089, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:531)");
        }
        Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(Modifier.INSTANCE);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierImePadding;
    }

    static final Modifier registerBuiltInModifiers$lambda$27(Map unused$var$, ComposableScope composableScope, ConverterContext unused$var$2, Function2 unused$var$3, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$2, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$3, "$unused$var$");
        composer.startReplaceGroup(-1448950359);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1448950359, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:608)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companion;
    }

    static final Modifier registerBuiltInModifiers$lambda$34(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        int iM7429getOffscreenNrFUSI;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-59656345);
        ComposerKt.sourceInformation(composer, "CN(map,appContext)618@19358L51,619@19432L51,620@19506L51,621@19577L48,622@19645L48,623@19715L47,624@19788L54,625@19868L54,626@19951L57,637@20516L7,639@20562L795:ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-59656345, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:618)");
        }
        int i2 = (i & 14) | 432 | ((i << 3) & 7168);
        final float fResolveAnimatable = AnimatableFloatKt.resolveAnimatable(map, "rotationX", 0.0f, appContext, composer, i2);
        final float fResolveAnimatable2 = AnimatableFloatKt.resolveAnimatable(map, "rotationY", 0.0f, appContext, composer, i2);
        final float fResolveAnimatable3 = AnimatableFloatKt.resolveAnimatable(map, "rotationZ", 0.0f, appContext, composer, i2);
        final float fResolveAnimatable4 = AnimatableFloatKt.resolveAnimatable(map, "scaleX", 1.0f, appContext, composer, i2);
        final float fResolveAnimatable5 = AnimatableFloatKt.resolveAnimatable(map, "scaleY", 1.0f, appContext, composer, i2);
        final float fResolveAnimatable6 = AnimatableFloatKt.resolveAnimatable(map, "alpha", 1.0f, appContext, composer, i2);
        final float fResolveAnimatable7 = AnimatableFloatKt.resolveAnimatable(map, "translationX", 0.0f, appContext, composer, i2);
        final float fResolveAnimatable8 = AnimatableFloatKt.resolveAnimatable(map, "translationY", 0.0f, appContext, composer, i2);
        final float fResolveAnimatable9 = AnimatableFloatKt.resolveAnimatable(map, "shadowElevation", 0.0f, appContext, composer, i2);
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(GraphicsLayerParams.class, false, GraphicsLayerParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$34$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(GraphicsLayerParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Shape shapeResolveShape = null;
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(GraphicsLayerParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        final GraphicsLayerParams graphicsLayerParams = (GraphicsLayerParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        BuiltinShapeRecord shape = graphicsLayerParams.getShape();
        if (shape == null) {
            composer.startReplaceGroup(895140514);
        } else {
            composer.startReplaceGroup(895140515);
            ComposerKt.sourceInformation(composer, "*630@20175L16");
            shapeResolveShape = INSTANCE.resolveShape(shape, composer, 0);
        }
        composer.endReplaceGroup();
        if (shapeResolveShape == null) {
            shapeResolveShape = RectangleShapeKt.getRectangleShape();
        }
        CompositingStrategyType compositingStrategy = graphicsLayerParams.getCompositingStrategy();
        int i3 = compositingStrategy == null ? -1 : WhenMappings.$EnumSwitchMapping$1[compositingStrategy.ordinal()];
        if (i3 == 1) {
            iM7429getOffscreenNrFUSI = CompositingStrategy.INSTANCE.m7429getOffscreenNrFUSI();
        } else if (i3 == 2) {
            iM7429getOffscreenNrFUSI = CompositingStrategy.INSTANCE.m7428getModulateAlphaNrFUSI();
        } else {
            iM7429getOffscreenNrFUSI = CompositingStrategy.INSTANCE.m7427getAutoNrFUSI();
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final float density = ((Density) objConsume).getDensity();
        Modifier.Companion companion3 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1495131806, "CC(remember):ModifierRegistry.kt#9igjgp");
        boolean zChanged = composer.changed(fResolveAnimatable) | composer.changed(fResolveAnimatable2) | composer.changed(fResolveAnimatable3) | composer.changed(fResolveAnimatable4) | composer.changed(fResolveAnimatable5) | composer.changed(fResolveAnimatable6) | composer.changed(fResolveAnimatable7) | composer.changed(density) | composer.changed(fResolveAnimatable8) | composer.changedInstance(graphicsLayerParams) | composer.changed(fResolveAnimatable9) | composer.changed(shapeResolveShape) | composer.changed(iM7429getOffscreenNrFUSI);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final int i4 = iM7429getOffscreenNrFUSI;
            final Shape shape2 = shapeResolveShape;
            Object obj = new Function1() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ModifierRegistry.registerBuiltInModifiers$lambda$34$lambda$33$lambda$32(fResolveAnimatable, fResolveAnimatable2, fResolveAnimatable3, fResolveAnimatable4, fResolveAnimatable5, fResolveAnimatable6, fResolveAnimatable7, density, fResolveAnimatable8, graphicsLayerParams, fResolveAnimatable9, shape2, i4, (GraphicsLayerScope) obj2);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue = obj;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierGraphicsLayer;
    }

    static final Unit registerBuiltInModifiers$lambda$34$lambda$33$lambda$32(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, GraphicsLayerParams graphicsLayerParams, float f10, Shape shape, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setRotationX(f);
        graphicsLayer.setRotationY(f2);
        graphicsLayer.setRotationZ(f3);
        graphicsLayer.setScaleX(f4);
        graphicsLayer.setScaleY(f5);
        graphicsLayer.setAlpha(f6);
        graphicsLayer.setTranslationX(f7 * f8);
        graphicsLayer.setTranslationY(f9 * f8);
        graphicsLayer.setCameraDistance(graphicsLayerParams.getCameraDistance() * f8);
        graphicsLayer.setShadowElevation(f10 * f8);
        graphicsLayer.mo7539setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(graphicsLayerParams.getTransformOriginX(), graphicsLayerParams.getTransformOriginY()));
        graphicsLayer.setClip(graphicsLayerParams.getClip());
        graphicsLayer.setShape(shape);
        graphicsLayer.mo7537setCompositingStrategyaDBOjCE(i);
        Color ambientShadowColor = graphicsLayerParams.getAmbientShadowColor();
        if (ambientShadowColor != null) {
            graphicsLayer.mo7535setAmbientShadowColor8_81llA(UtilsKt.getCompose(ambientShadowColor));
        }
        Color spotShadowColor = graphicsLayerParams.getSpotShadowColor();
        if (spotShadowColor != null) {
            graphicsLayer.mo7538setSpotShadowColor8_81llA(UtilsKt.getCompose(spotShadowColor));
        }
        return Unit.INSTANCE;
    }

    static final Modifier registerBuiltInModifiers$lambda$48(Map unused$var$, ComposableScope composableScope, ConverterContext unused$var$2, Function2 unused$var$3, Composer composer, int i) {
        Modifier.Companion companionMatchParentSize;
        BoxScope boxScope;
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$2, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$3, "$unused$var$");
        composer.startReplaceGroup(-881388606);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-881388606, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:694)");
        }
        if (composableScope == null || (boxScope = UIComposableScopeKt.getBoxScope(composableScope)) == null || (companionMatchParentSize = boxScope.matchParentSize(Modifier.INSTANCE)) == null) {
            companionMatchParentSize = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companionMatchParentSize;
    }

    static final Unit registerBuiltInModifiers$lambda$55$lambda$54$lambda$53(ContentType contentType, String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        if (contentType != null) {
            SemanticsPropertiesKt.setContentType(semantics, contentType);
        }
        if (str != null) {
            SemanticsPropertiesKt.setContentDescription(semantics, str);
        }
        return Unit.INSTANCE;
    }

    static final Unit registerBuiltInModifiers$lambda$61$lambda$60$lambda$59(Function2 function2, boolean z) {
        function2.invoke("onVisibilityChanged", MapsKt.mapOf(TuplesKt.to("isVisible", Boolean.valueOf(z))));
        return Unit.INSTANCE;
    }

    static final Modifier registerBuiltInModifiers$lambda$65(Map unused$var$, ComposableScope composableScope, ConverterContext unused$var$2, final Function2 eventDispatcher, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$2, "$unused$var$");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        composer.startReplaceGroup(-435608);
        ComposerKt.sourceInformation(composer, "CN(eventDispatcher)739@24231L7,740@24268L253:ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-435608, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:739)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -418615835, "CC(remember):ModifierRegistry.kt#9igjgp");
        boolean zChanged = composer.changed(density) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModifierRegistry.registerBuiltInModifiers$lambda$65$lambda$64$lambda$63(density, eventDispatcher, (IntSize) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(companion, (Function1) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierOnSizeChanged;
    }

    static final Unit registerBuiltInModifiers$lambda$65$lambda$64$lambda$63(Density density, Function2 function2, IntSize intSize) {
        function2.invoke("onSizeChanged", MapsKt.mapOf(TuplesKt.to(ViewProps.WIDTH, Float.valueOf(density.mo1731toDpu2uoSUM((int) (intSize.m10343unboximpl() >> 32)))), TuplesKt.to(ViewProps.HEIGHT, Float.valueOf(density.mo1731toDpu2uoSUM((int) (intSize.m10343unboximpl() & 4294967295L))))));
        return Unit.INSTANCE;
    }

    static final Modifier registerBuiltInModifiers$lambda$69(Map unused$var$, ComposableScope composableScope, ConverterContext unused$var$2, final Function2 eventDispatcher, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$2, "$unused$var$");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        composer.startReplaceGroup(694211399);
        ComposerKt.sourceInformation(composer, "CN(eventDispatcher)754@24629L7,755@24673L437:ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(694211399, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:754)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1417227420, "CC(remember):ModifierRegistry.kt#9igjgp");
        boolean zChanged = composer.changed(density) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModifierRegistry.registerBuiltInModifiers$lambda$69$lambda$68$lambda$67(density, eventDispatcher, (LayoutCoordinates) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierOnGloballyPositioned;
    }

    static final Unit registerBuiltInModifiers$lambda$69$lambda$68$lambda$67(Density density, Function2 function2, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        long jPositionInWindow = LayoutCoordinatesKt.positionInWindow(coordinates);
        function2.invoke("onGloballyPositioned", MapsKt.mapOf(TuplesKt.to(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, Float.valueOf(density.mo1730toDpu2uoSUM(Float.intBitsToFloat((int) (jPositionInWindow >> 32))))), TuplesKt.to(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, Float.valueOf(density.mo1730toDpu2uoSUM(Float.intBitsToFloat((int) (jPositionInWindow & 4294967295L))))), TuplesKt.to(ViewProps.WIDTH, Float.valueOf(density.mo1731toDpu2uoSUM((int) (coordinates.mo8816getSizeYbymL2g() >> 32)))), TuplesKt.to(ViewProps.HEIGHT, Float.valueOf(density.mo1731toDpu2uoSUM((int) (coordinates.mo8816getSizeYbymL2g() & 4294967295L))))));
        return Unit.INSTANCE;
    }

    static final Unit registerBuiltInModifiers$lambda$74$lambda$71$lambda$70(Function2 function2) {
        function2.invoke("clickable", MapsKt.emptyMap());
        return Unit.INSTANCE;
    }

    static final Unit registerBuiltInModifiers$lambda$74$lambda$73$lambda$72(Function2 function2) {
        function2.invoke("clickable", MapsKt.emptyMap());
        return Unit.INSTANCE;
    }

    static final Unit registerBuiltInModifiers$lambda$79$lambda$76$lambda$75(Function2 function2) {
        function2.invoke("combinedClickable", MapsKt.mapOf(TuplesKt.to("event", "click")));
        return Unit.INSTANCE;
    }

    static final Unit registerBuiltInModifiers$lambda$79$lambda$78$lambda$77(Function2 function2) {
        function2.invoke("combinedClickable", MapsKt.mapOf(TuplesKt.to("event", "longClick")));
        return Unit.INSTANCE;
    }

    static final Unit registerBuiltInModifiers$lambda$82$lambda$81$lambda$80(Function2 function2) {
        function2.invoke("selectable", MapsKt.emptyMap());
        return Unit.INSTANCE;
    }

    static final Modifier registerBuiltInModifiers$lambda$83(Map unused$var$, ComposableScope composableScope, ConverterContext unused$var$2, Function2 unused$var$3, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$2, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$3, "$unused$var$");
        composer.startReplaceGroup(-822167869);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-822167869, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:819)");
        }
        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(Modifier.INSTANCE);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierSelectableGroup;
    }

    static final Unit registerBuiltInModifiers$lambda$86$lambda$85$lambda$84(Function2 function2, boolean z) {
        function2.invoke("toggleable", MapsKt.emptyMap());
        return Unit.INSTANCE;
    }

    static final Modifier registerBuiltInModifiers$lambda$88(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope;
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(567126145);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(567126145, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:840)");
        }
        if (composableScope == null || (exposedDropdownMenuBoxScope = ExposedDropdownMenuBoxComposableScopeKt.getExposedDropdownMenuBoxScope(composableScope)) == null) {
            throw new IllegalStateException("menuAnchor modifier can only be used inside ExposedDropdownMenuBox".toString());
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(MenuAnchorParams.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$88$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(MenuAnchorParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(MenuAnchorParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        MenuAnchorParams menuAnchorParams = (MenuAnchorParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        if (WhenMappings.$EnumSwitchMapping$3[menuAnchorParams.getType().ordinal()] == 1) {
            Modifier modifierMo3936menuAnchor2Hz36ac = exposedDropdownMenuBoxScope.mo3936menuAnchor2Hz36ac(companion3, ExposedDropdownMenuAnchorType.INSTANCE.m3930getPrimaryNotEditableoYjWRB4(), menuAnchorParams.getEnabled());
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifierMo3936menuAnchor2Hz36ac;
        }
        throw new NoWhenBranchMatchedException();
    }

    static final Modifier registerBuiltInModifiers$lambda$91(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        CarouselItemScope carouselItemScope;
        Object objM12684constructorimpl;
        Modifier.Companion companionMaskClip;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-1330508885);
        ComposerKt.sourceInformation(composer, "CN(map,scope,appContext):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1330508885, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:855)");
        }
        if (composableScope == null || (carouselItemScope = CarouselItemComposableScopeKt.getCarouselItemScope(composableScope)) == null) {
            throw new IllegalStateException("maskClip modifier can only be used inside a Carousel item".toString());
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ClipParams.class, false, ClipParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$91$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ClipParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Shape shapeResolveShape = null;
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ClipParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        BuiltinShapeRecord shape = ((ClipParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getShape();
        if (shape == null) {
            composer.startReplaceGroup(1063230494);
        } else {
            composer.startReplaceGroup(1063230495);
            ComposerKt.sourceInformation(composer, "*858@28399L16");
            shapeResolveShape = INSTANCE.resolveShape(shape, composer, 0);
        }
        composer.endReplaceGroup();
        if (shapeResolveShape != null) {
            composer.startReplaceGroup(1063281831);
            ComposerKt.sourceInformation(composer, "*861@28490L15");
            companionMaskClip = carouselItemScope.maskClip(Modifier.INSTANCE, shapeResolveShape, composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1063365469);
            composer.endReplaceGroup();
            companionMaskClip = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companionMaskClip;
    }

    static final Modifier registerBuiltInModifiers$lambda$92(Map unused$var$, ComposableScope composableScope, ConverterContext unused$var$2, Function2 unused$var$3, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$2, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$3, "$unused$var$");
        composer.startReplaceGroup(-635861878);
        ComposerKt.sourceInformation(composer, "C869@28640L21:ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-635861878, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:869)");
        }
        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierVerticalScroll$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$93(Map unused$var$, ComposableScope composableScope, ConverterContext unused$var$2, Function2 unused$var$3, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$2, "$unused$var$");
        Intrinsics.checkNotNullParameter(unused$var$3, "$unused$var$");
        composer.startReplaceGroup(58785129);
        ComposerKt.sourceInformation(composer, "C873@28751L21:ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(58785129, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:873)");
        }
        Modifier modifierHorizontalScroll$default = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierHorizontalScroll$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$1(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(1341174591);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1341174591, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:458)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(PaddingAllParams.class, false, PaddingAllParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$1$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(PaddingAllParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(PaddingAllParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierM2350padding3ABfNKs = PaddingKt.m2350padding3ABfNKs(Modifier.INSTANCE, Dp.m10168constructorimpl(((PaddingAllParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getAll()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2350padding3ABfNKs;
    }

    static final Modifier registerBuiltInModifiers$lambda$2(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-1080657816);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1080657816, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:463)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(PaddingParams.class, false, PaddingParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$2$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(PaddingParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(PaddingParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        PaddingParams paddingParams = (PaddingParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        Modifier modifierM2353paddingqDBjuR0 = PaddingKt.m2353paddingqDBjuR0(Modifier.INSTANCE, Dp.m10168constructorimpl(paddingParams.getStart()), Dp.m10168constructorimpl(paddingParams.getTop()), Dp.m10168constructorimpl(paddingParams.getEnd()), Dp.m10168constructorimpl(paddingParams.getBottom()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2353paddingqDBjuR0;
    }

    static final Modifier registerBuiltInModifiers$lambda$3(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-386010809);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-386010809, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:474)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SizeParams.class, false, SizeParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$3$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SizeParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SizeParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        SizeParams sizeParams = (SizeParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        Modifier modifierM2419sizeVpY3zN4 = SizeKt.m2419sizeVpY3zN4(Modifier.INSTANCE, Dp.m10168constructorimpl(sizeParams.getWidth()), Dp.m10168constructorimpl(sizeParams.getHeight()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2419sizeVpY3zN4;
    }

    static final Modifier registerBuiltInModifiers$lambda$4(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(308636198);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(308636198, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:479)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FillMaxSizeParams.class, false, FillMaxSizeParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$4$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(FillMaxSizeParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FillMaxSizeParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierFillMaxSize = SizeKt.fillMaxSize(Modifier.INSTANCE, ((FillMaxSizeParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getFraction());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierFillMaxSize;
    }

    static final Modifier registerBuiltInModifiers$lambda$5(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(1003283205);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1003283205, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:484)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FillMaxWidthParams.class, false, FillMaxWidthParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$5$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(FillMaxWidthParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FillMaxWidthParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.INSTANCE, ((FillMaxWidthParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getFraction());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierFillMaxWidth;
    }

    static final Modifier registerBuiltInModifiers$lambda$6(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(1697930212);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1697930212, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:489)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FillMaxHeightParams.class, false, FillMaxHeightParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$6$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(FillMaxHeightParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FillMaxHeightParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierFillMaxHeight = SizeKt.fillMaxHeight(Modifier.INSTANCE, ((FillMaxHeightParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getFraction());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierFillMaxHeight;
    }

    static final Modifier registerBuiltInModifiers$lambda$7(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Modifier modifierM2422width3ABfNKs;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-1902390077);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1902390077, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:494)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeWidthParams.class, false, ComposeWidthParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$7$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ComposeWidthParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeWidthParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Either<Integer, IntrinsicSizeType> width = ((ComposeWidthParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getWidth();
        if (width != null && width.isSecondType(Reflection.getOrCreateKotlinClass(IntrinsicSizeType.class))) {
            modifierM2422width3ABfNKs = IntrinsicKt.width(Modifier.INSTANCE, width.second().toComposeIntrinsicSize());
        } else {
            modifierM2422width3ABfNKs = SizeKt.m2422width3ABfNKs(Modifier.INSTANCE, Dp.m10168constructorimpl(width != null ? width.first().intValue() : 0));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2422width3ABfNKs;
    }

    static final Modifier registerBuiltInModifiers$lambda$8(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-1207743070);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1207743070, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:503)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(HeightParams.class, false, HeightParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$8$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(HeightParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(HeightParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierM2403height3ABfNKs = SizeKt.m2403height3ABfNKs(Modifier.INSTANCE, Dp.m10168constructorimpl(((HeightParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getHeight()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2403height3ABfNKs;
    }

    static final Modifier registerBuiltInModifiers$lambda$9(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        float fM10188getUnspecifiedD9Ej5fM;
        float fM10188getUnspecifiedD9Ej5fM2;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-513096063);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513096063, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:508)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DefaultMinSizeParams.class, false, DefaultMinSizeParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$9$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DefaultMinSizeParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(DefaultMinSizeParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        DefaultMinSizeParams defaultMinSizeParams = (DefaultMinSizeParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        Float minWidth = defaultMinSizeParams.getMinWidth();
        if (minWidth == null) {
            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
        } else {
            fM10188getUnspecifiedD9Ej5fM = Dp.m10168constructorimpl(minWidth.floatValue());
        }
        Float minHeight = defaultMinSizeParams.getMinHeight();
        if (minHeight == null) {
            fM10188getUnspecifiedD9Ej5fM2 = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
        } else {
            fM10188getUnspecifiedD9Ej5fM2 = Dp.m10168constructorimpl(minHeight.floatValue());
        }
        Modifier modifierM2401defaultMinSizeVpY3zN4 = SizeKt.m2401defaultMinSizeVpY3zN4(companion3, fM10188getUnspecifiedD9Ej5fM, fM10188getUnspecifiedD9Ej5fM2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2401defaultMinSizeVpY3zN4;
    }

    static final Modifier registerBuiltInModifiers$lambda$11(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Modifier modifierWrapContentWidth$default;
        Alignment.Horizontal horizontalAlignment;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(181550944);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(181550944, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:516)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WrapContentWidthParams.class, false, WrapContentWidthParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$11$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(WrapContentWidthParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(WrapContentWidthParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        AlignmentType alignment = ((WrapContentWidthParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getAlignment();
        if (alignment == null || (horizontalAlignment = alignment.toHorizontalAlignment()) == null || (modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(Modifier.INSTANCE, horizontalAlignment, false, 2, null)) == null) {
            modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(Modifier.INSTANCE, null, false, 3, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierWrapContentWidth$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$13(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Modifier modifierWrapContentHeight$default;
        Alignment.Vertical verticalAlignment;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-1508171096);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1508171096, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:523)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WrapContentHeightParams.class, false, WrapContentHeightParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$13$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(WrapContentHeightParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(WrapContentHeightParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        AlignmentType alignment = ((WrapContentHeightParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getAlignment();
        if (alignment == null || (verticalAlignment = alignment.toVerticalAlignment()) == null || (modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(Modifier.INSTANCE, verticalAlignment, false, 2, null)) == null) {
            modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(Modifier.INSTANCE, null, false, 3, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierWrapContentHeight$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$15(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-118877082);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-118877082, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:536)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(OffsetParams.class, false, OffsetParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$15$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(OffsetParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(OffsetParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        OffsetParams offsetParams = (OffsetParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        Modifier modifierM2309offsetVpY3zN4 = OffsetKt.m2309offsetVpY3zN4(Modifier.INSTANCE, Dp.m10168constructorimpl(offsetParams.getX()), Dp.m10168constructorimpl(offsetParams.getY()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2309offsetVpY3zN4;
    }

    private static final long registerBuiltInModifiers$lambda$17$lambda$16(State<androidx.compose.ui.graphics.Color> state) {
        return state.getValue().m7348unboximpl();
    }

    static final Modifier registerBuiltInModifiers$lambda$17(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Composer composer2;
        Modifier modifierM1558backgroundbw27NRU$default;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(575769925);
        ComposerKt.sourceInformation(composer, "CN(map,appContext):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(575769925, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:542)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BackgroundParams.class, false, BackgroundParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$17$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(BackgroundParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(BackgroundParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Color color = ((BackgroundParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getColor();
        if (color != null) {
            long compose = UtilsKt.getCompose(color);
            AnimationSpec colorAnimationSpec = ModifierRegistryKt.parseColorAnimationSpec(map.get("animationSpec"));
            if (colorAnimationSpec != null) {
                composer.startReplaceGroup(-1337292455);
                ComposerKt.sourceInformation(composer, "546@16885L60");
                composer2 = composer;
                modifierM1558backgroundbw27NRU$default = BackgroundKt.m1558backgroundbw27NRU$default(Modifier.INSTANCE, registerBuiltInModifiers$lambda$17$lambda$16(SingleValueAnimationKt.m1428animateColorAsStateeuL9pac(compose, colorAnimationSpec, "background-color", null, composer, 384, 8)), null, 2, null);
                composer2.endReplaceGroup();
            } else {
                composer2 = composer;
                composer2.startReplaceGroup(-1337158287);
                composer2.endReplaceGroup();
                modifierM1558backgroundbw27NRU$default = BackgroundKt.m1558backgroundbw27NRU$default(Modifier.INSTANCE, compose, null, 2, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2.endReplaceGroup();
            return modifierM1558backgroundbw27NRU$default;
        }
        Modifier.Companion companion3 = Modifier.INSTANCE;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companion3;
    }

    static final Modifier registerBuiltInModifiers$lambda$19(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Modifier.Companion companionBorder$default;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(1270416932);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1270416932, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:554)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BorderParams.class, false, BorderParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$19$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(BorderParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(BorderParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        BorderParams borderParams = (BorderParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        Color borderColor = borderParams.getBorderColor();
        if (borderColor == null || (companionBorder$default = BorderKt.border$default(Modifier.INSTANCE, BorderStrokeKt.m1584BorderStrokecXLIe8U(Dp.m10168constructorimpl(borderParams.getBorderWidth()), UtilsKt.getCompose(borderColor)), null, 2, null)) == null) {
            companionBorder$default = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companionBorder$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$20(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(1965063939);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1965063939, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:561)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ShadowParams.class, false, ShadowParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$20$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ShadowParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ShadowParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierM6916shadows4CzXII$default = ShadowKt.m6916shadows4CzXII$default(Modifier.INSTANCE, Dp.m10168constructorimpl(((ShadowParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getElevation()), null, false, 0L, 0L, 30, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM6916shadows4CzXII$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$22(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-1635256350);
        ComposerKt.sourceInformation(composer, "CN(map,appContext):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1635256350, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:566)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ShadowGeometryParams.class, false, ShadowGeometryParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$22$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ShadowGeometryParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Shape shapeResolveShape = null;
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ShadowGeometryParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        ShadowGeometryParams shadowGeometryParams = (ShadowGeometryParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        BuiltinShapeRecord shape = shadowGeometryParams.getShape();
        if (shape == null) {
            composer.startReplaceGroup(1892246375);
        } else {
            composer.startReplaceGroup(1892246376);
            ComposerKt.sourceInformation(composer, "*567@17647L16");
            shapeResolveShape = INSTANCE.resolveShape(shape, composer, 0);
        }
        composer.endReplaceGroup();
        if (shapeResolveShape == null) {
            shapeResolveShape = RectangleShapeKt.getRectangleShape();
        }
        Modifier.Companion companion3 = Modifier.INSTANCE;
        float fM10168constructorimpl = Dp.m10168constructorimpl(shadowGeometryParams.getRadius());
        float fM10168constructorimpl2 = Dp.m10168constructorimpl(shadowGeometryParams.getSpread());
        androidx.compose.ui.graphics.Color composeOrNull = UtilsKt.getComposeOrNull(shadowGeometryParams.getColor());
        Modifier modifierDropShadow = ShadowKt.dropShadow(companion3, shapeResolveShape, new Shadow(fM10168constructorimpl, composeOrNull != null ? composeOrNull.m7348unboximpl() : androidx.compose.ui.graphics.Color.INSTANCE.m7364getBlack0d7_KjU(), fM10168constructorimpl2, DpOffset.m10224constructorimpl((((long) Float.floatToRawIntBits(Dp.m10168constructorimpl(shadowGeometryParams.getOffsetX()))) << 32) | (((long) Float.floatToRawIntBits(Dp.m10168constructorimpl(shadowGeometryParams.getOffsetY()))) & 4294967295L)), shadowGeometryParams.getAlpha(), 0, 32, (DefaultConstructorMarker) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierDropShadow;
    }

    static final Modifier registerBuiltInModifiers$lambda$24(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-940609343);
        ComposerKt.sourceInformation(composer, "CN(map,appContext):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-940609343, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:581)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ShadowGeometryParams.class, false, ShadowGeometryParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$24$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ShadowGeometryParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Shape shapeResolveShape = null;
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ShadowGeometryParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        ShadowGeometryParams shadowGeometryParams = (ShadowGeometryParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        BuiltinShapeRecord shape = shadowGeometryParams.getShape();
        if (shape == null) {
            composer.startReplaceGroup(-1326167512);
        } else {
            composer.startReplaceGroup(-1326167511);
            ComposerKt.sourceInformation(composer, "*582@18194L16");
            shapeResolveShape = INSTANCE.resolveShape(shape, composer, 0);
        }
        composer.endReplaceGroup();
        if (shapeResolveShape == null) {
            shapeResolveShape = RectangleShapeKt.getRectangleShape();
        }
        Modifier.Companion companion3 = Modifier.INSTANCE;
        float fM10168constructorimpl = Dp.m10168constructorimpl(shadowGeometryParams.getRadius());
        float fM10168constructorimpl2 = Dp.m10168constructorimpl(shadowGeometryParams.getSpread());
        androidx.compose.ui.graphics.Color composeOrNull = UtilsKt.getComposeOrNull(shadowGeometryParams.getColor());
        Modifier modifierInnerShadow = ShadowKt.innerShadow(companion3, shapeResolveShape, new Shadow(fM10168constructorimpl, composeOrNull != null ? composeOrNull.m7348unboximpl() : androidx.compose.ui.graphics.Color.INSTANCE.m7364getBlack0d7_KjU(), fM10168constructorimpl2, DpOffset.m10224constructorimpl((((long) Float.floatToRawIntBits(Dp.m10168constructorimpl(shadowGeometryParams.getOffsetX()))) << 32) | (((long) Float.floatToRawIntBits(Dp.m10168constructorimpl(shadowGeometryParams.getOffsetY()))) & 4294967295L)), shadowGeometryParams.getAlpha(), 0, 32, (DefaultConstructorMarker) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierInnerShadow;
    }

    static final Modifier registerBuiltInModifiers$lambda$25(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-245962336);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-245962336, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:596)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AlphaParams.class, false, AlphaParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$25$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(AlphaParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AlphaParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierAlpha = AlphaKt.alpha(Modifier.INSTANCE, ((AlphaParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getAlpha());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierAlpha;
    }

    static final Modifier registerBuiltInModifiers$lambda$26(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(448684671);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(448684671, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:601)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BlurParams.class, false, BlurParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$26$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(BlurParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(BlurParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierM6841blurF8QBwvs$default = BlurKt.m6841blurF8QBwvs$default(Modifier.INSTANCE, Dp.m10168constructorimpl(((BlurParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getRadius()), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM6841blurF8QBwvs$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$28(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-754303352);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-754303352, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:613)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RotateParams.class, false, RotateParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$28$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(RotateParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(RotateParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierRotate = RotateKt.rotate(Modifier.INSTANCE, ((RotateParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getDegrees());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierRotate;
    }

    static final Modifier registerBuiltInModifiers$lambda$35(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(634990662);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(634990662, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:660)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ZIndexParams.class, false, ZIndexParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$35$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ZIndexParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ZIndexParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        Modifier modifierZIndex = ZIndexModifierKt.zIndex(Modifier.INSTANCE, ((ZIndexParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getIndex());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierZIndex;
    }

    static final Modifier registerBuiltInModifiers$lambda$36(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(1329637669);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1329637669, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:666)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AnimateContentSizeParams.class, false, AnimateContentSizeParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$36$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(AnimateContentSizeParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AnimateContentSizeParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        AnimateContentSizeParams animateContentSizeParams = (AnimateContentSizeParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        Modifier modifierAnimateContentSize$default = AnimationModifierKt.animateContentSize$default(Modifier.INSTANCE, AnimationSpecKt.spring$default(animateContentSizeParams.getDampingRatio(), animateContentSizeParams.getStiffness(), null, 4, null), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierAnimateContentSize$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$39(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Modifier.Companion companionWeight$default;
        ColumnScope columnScope;
        RowScope rowScope;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(2024284676);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2024284676, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:674)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WeightParams.class, false, WeightParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$39$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(WeightParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(WeightParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        WeightParams weightParams = (WeightParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        if (composableScope == null || (rowScope = UIComposableScopeKt.getRowScope(composableScope)) == null || (companionWeight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, weightParams.getWeight(), false, 2, null)) == null) {
            if (composableScope != null && (columnScope = UIComposableScopeKt.getColumnScope(composableScope)) != null) {
                companionWeight$default = ColumnScope.weight$default(columnScope, Modifier.INSTANCE, weightParams.getWeight(), false, 2, null);
            } else {
                companionWeight$default = Modifier.INSTANCE;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companionWeight$default;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0093  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d8  */
    static final Modifier registerBuiltInModifiers$lambda$46(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Modifier.Companion companionAlign;
        ColumnScope columnScope;
        AlignmentType alignment;
        Alignment.Horizontal horizontalAlignment;
        RowScope rowScope;
        AlignmentType alignment2;
        Alignment.Vertical verticalAlignment;
        BoxScope boxScope;
        Alignment alignment3;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-1576035613);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1576035613, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:683)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AlignParams.class, false, AlignParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$46$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(AlignParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Modifier modifierAlign = null;
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AlignParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        AlignParams alignParams = (AlignParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        if (composableScope == null || (boxScope = UIComposableScopeKt.getBoxScope(composableScope)) == null) {
            if (composableScope != null || (rowScope = UIComposableScopeKt.getRowScope(composableScope)) == null || (alignment2 = alignParams.getAlignment()) == null || (verticalAlignment = alignment2.toVerticalAlignment()) == null) {
                companionAlign = null;
            } else {
                companionAlign = rowScope.align(Modifier.INSTANCE, verticalAlignment);
            }
            if (companionAlign == null) {
                if (composableScope != null && (columnScope = UIComposableScopeKt.getColumnScope(composableScope)) != null && (alignment = alignParams.getAlignment()) != null && (horizontalAlignment = alignment.toHorizontalAlignment()) != null) {
                    modifierAlign = columnScope.align(Modifier.INSTANCE, horizontalAlignment);
                }
                if (modifierAlign == null) {
                    companionAlign = Modifier.INSTANCE;
                } else {
                    companionAlign = modifierAlign;
                }
            }
        } else {
            AlignmentType alignment4 = alignParams.getAlignment();
            companionAlign = (alignment4 == null || (alignment3 = alignment4.toAlignment()) == null) ? null : boxScope.align(Modifier.INSTANCE, alignment3);
            if (companionAlign == null) {
                if (composableScope != null) {
                    companionAlign = null;
                } else {
                    companionAlign = null;
                }
                if (companionAlign == null) {
                    if (composableScope != null) {
                        modifierAlign = columnScope.align(Modifier.INSTANCE, horizontalAlignment);
                    }
                    if (modifierAlign == null) {
                        companionAlign = Modifier.INSTANCE;
                    } else {
                        companionAlign = modifierAlign;
                    }
                }
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companionAlign;
    }

    static final Modifier registerBuiltInModifiers$lambda$50(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Modifier.Companion companionApplyTestTag;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-186741599);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-186741599, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:701)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(TestIDParams.class, false, TestIDParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$50$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(TestIDParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(TestIDParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        String testID = ((TestIDParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getTestID();
        if (testID == null || (companionApplyTestTag = ModifiersKt.applyTestTag(Modifier.INSTANCE, testID)) == null) {
            companionApplyTestTag = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companionApplyTestTag;
    }

    static final Modifier registerBuiltInModifiers$lambda$55(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Modifier.Companion companionSemantics$default;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(507905408);
        ComposerKt.sourceInformation(composer, "CN(map,appContext):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(507905408, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:708)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SemanticsParams.class, false, SemanticsParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$55$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SemanticsParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SemanticsParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        SemanticsParams semanticsParams = (SemanticsParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        final ContentType contentType = SemanticsModifierKt.toContentType(semanticsParams.getContentType());
        final String contentDescription = semanticsParams.getContentDescription();
        if (contentType == null && contentDescription == null) {
            composer.startReplaceGroup(-159532216);
            composer.endReplaceGroup();
            companionSemantics$default = Modifier.INSTANCE;
        } else {
            composer.startReplaceGroup(-159496814);
            ComposerKt.sourceInformation(composer, "714@23379L107");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1529164821, "CC(remember):ModifierRegistry.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(contentType) | composer.changed(contentDescription);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ModifierRegistry.registerBuiltInModifiers$lambda$55$lambda$54$lambda$53(contentType, contentDescription, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            companionSemantics$default = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue, 1, null);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companionSemantics$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$58(Map map, ComposableScope composableScope, ConverterContext appContext, Function2 unused$var$, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        composer.startReplaceGroup(-1389729622);
        ComposerKt.sourceInformation(composer, "CN(map,appContext):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1389729622, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:722)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ClipParams.class, false, ClipParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$58$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ClipParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Modifier.Companion companionClip = null;
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ClipParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        BuiltinShapeRecord shape = ((ClipParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getShape();
        if (shape == null) {
            composer.startReplaceGroup(2049674954);
        } else {
            composer.startReplaceGroup(2049674955);
            ComposerKt.sourceInformation(composer, "*724@23655L19");
            Shape shapeResolveShape = INSTANCE.resolveShape(shape, composer, 0);
            if (shapeResolveShape != null) {
                companionClip = ClipKt.clip(Modifier.INSTANCE, shapeResolveShape);
            }
        }
        composer.endReplaceGroup();
        if (companionClip == null) {
            companionClip = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companionClip;
    }

    static final Modifier registerBuiltInModifiers$lambda$61(Map map, ComposableScope composableScope, ConverterContext appContext, final Function2 eventDispatcher, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        composer.startReplaceGroup(-695082615);
        ComposerKt.sourceInformation(composer, "CN(map,appContext,eventDispatcher)733@24028L102:ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-695082615, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:729)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(OnVisibilityChangedParams.class, false, OnVisibilityChangedParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$61$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(OnVisibilityChangedParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(OnVisibilityChangedParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        OnVisibilityChangedParams onVisibilityChangedParams = (OnVisibilityChangedParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        long minDurationMs = onVisibilityChangedParams.getMinDurationMs();
        float minFractionVisible = onVisibilityChangedParams.getMinFractionVisible();
        ComposerKt.sourceInformationMarkerStart(composer, 2040513679, "CC(remember):ModifierRegistry.kt#9igjgp");
        boolean z = (((i & 7168) ^ 3072) > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModifierRegistry.registerBuiltInModifiers$lambda$61$lambda$60$lambda$59(eventDispatcher, ((Boolean) obj).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnVisibilityChanged$default = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion3, minDurationMs, minFractionVisible, null, (Function1) objRememberedValue, 4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierOnVisibilityChanged$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$74(Map map, ComposableScope composableScope, ConverterContext appContext, final Function2 eventDispatcher, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        boolean z;
        Modifier modifierM1589clickableO2vRcR0$default;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        composer.startReplaceGroup(1388858406);
        ComposerKt.sourceInformation(composer, "CN(map,appContext,eventDispatcher):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1388858406, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:772)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ClickableParams.class, false, ClickableParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$74$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ClickableParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ClickableParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        if (((ClickableParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext)).getIndication()) {
            composer.startReplaceGroup(2060949753);
            ComposerKt.sourceInformation(composer, "774@25310L62");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1041895516, "CC(remember):ModifierRegistry.kt#9igjgp");
            z = (((i & 7168) ^ 3072) > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048;
            Object objRememberedValue = composer.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModifierRegistry.registerBuiltInModifiers$lambda$74$lambda$71$lambda$70(eventDispatcher);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            modifierM1589clickableO2vRcR0$default = ClickableKt.m1593clickableoSLSa3U$default(companion3, false, null, null, null, (Function0) objRememberedValue, 15, null);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(2061056238);
            ComposerKt.sourceInformation(composer, "781@25490L62");
            Modifier.Companion companion4 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1041889756, "CC(remember):ModifierRegistry.kt#9igjgp");
            z = (((i & 7168) ^ 3072) > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048;
            Object objRememberedValue2 = composer.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda41
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModifierRegistry.registerBuiltInModifiers$lambda$74$lambda$73$lambda$72(eventDispatcher);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            modifierM1589clickableO2vRcR0$default = ClickableKt.m1589clickableO2vRcR0$default(companion4, null, null, false, null, null, (Function0) objRememberedValue2, 28, null);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM1589clickableO2vRcR0$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$79(Map map, ComposableScope composableScope, ConverterContext appContext, final Function2 eventDispatcher, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Modifier modifierM1597combinedClickableauXiCPI$default;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        composer.startReplaceGroup(2083505413);
        ComposerKt.sourceInformation(composer, "CN(map,appContext,eventDispatcher)789@25730L67,790@25822L71:ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2083505413, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:788)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ClickableParams.class, false, ClickableParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$79$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ClickableParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ClickableParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        ClickableParams clickableParams = (ClickableParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        ComposerKt.sourceInformationMarkerStart(composer, 793946120, "CC(remember):ModifierRegistry.kt#9igjgp");
        int i2 = (i & 7168) ^ 3072;
        boolean z = (i2 > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ModifierRegistry.registerBuiltInModifiers$lambda$79$lambda$76$lambda$75(eventDispatcher);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 793949068, "CC(remember):ModifierRegistry.kt#9igjgp");
        boolean z2 = (i2 > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ModifierRegistry.registerBuiltInModifiers$lambda$79$lambda$78$lambda$77(eventDispatcher);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function1 = (Function0) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (clickableParams.getIndication()) {
            modifierM1597combinedClickableauXiCPI$default = ClickableKt.m1603combinedClickablehoGz1lA$default(Modifier.INSTANCE, false, null, null, null, function1, null, false, null, function0, 239, null);
        } else {
            modifierM1597combinedClickableauXiCPI$default = ClickableKt.m1597combinedClickableauXiCPI$default(Modifier.INSTANCE, null, null, false, null, null, null, function1, null, false, function0, 444, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM1597combinedClickableauXiCPI$default;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static final Modifier registerBuiltInModifiers$lambda$82(Map map, ComposableScope composableScope, ConverterContext appContext, final Function2 eventDispatcher, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        composer.startReplaceGroup(-1516814876);
        ComposerKt.sourceInformation(composer, "CN(map,appContext,eventDispatcher)814@26763L45:ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1516814876, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:804)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SelectableParams.class, false, SelectableParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$82$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SelectableParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Role roleM9361boximpl = null;
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SelectableParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        SelectableParams selectableParams = (SelectableParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        boolean selected = selectableParams.getSelected();
        String role = selectableParams.getRole();
        if (role != null) {
            switch (role.hashCode()) {
                case -891486451:
                    if (role.equals("radioButton")) {
                        roleM9361boximpl = Role.m9361boximpl(Role.INSTANCE.m9373getRadioButtono7Vup1c());
                    }
                    break;
                case -889473228:
                    if (role.equals("switch")) {
                        roleM9361boximpl = Role.m9361boximpl(Role.INSTANCE.m9374getSwitcho7Vup1c());
                    }
                    break;
                case 114581:
                    if (role.equals("tab")) {
                        roleM9361boximpl = Role.m9361boximpl(Role.INSTANCE.m9375getTabo7Vup1c());
                    }
                    break;
                case 1536891843:
                    if (role.equals("checkbox")) {
                        roleM9361boximpl = Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c());
                    }
                    break;
            }
        }
        Role role2 = roleM9361boximpl;
        ComposerKt.sourceInformationMarkerStart(composer, -1665165679, "CC(remember):ModifierRegistry.kt#9igjgp");
        boolean z = (((i & 7168) ^ 3072) > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ModifierRegistry.registerBuiltInModifiers$lambda$82$lambda$81$lambda$80(eventDispatcher);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM2647selectableoSLSa3U$default = SelectableKt.m2647selectableoSLSa3U$default(companion3, selected, false, role2, null, (Function0) objRememberedValue, 10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2647selectableoSLSa3U$default;
    }

    static final Modifier registerBuiltInModifiers$lambda$86(Map map, ComposableScope composableScope, ConverterContext appContext, final Function2 eventDispatcher, Composer composer, int i) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        composer.startReplaceGroup(-127520862);
        ComposerKt.sourceInformation(composer, "CN(map,appContext,eventDispatcher)834@27414L45:ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-127520862, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:823)");
        }
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ToggleableParams.class, false, ToggleableParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$lambda$86$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ToggleableParams.class);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Role roleM9361boximpl = null;
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ToggleableParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        ToggleableParams toggleableParams = (ToggleableParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, appContext);
        SemanticRoleType role = toggleableParams.getRole();
        int i2 = role == null ? -1 : WhenMappings.$EnumSwitchMapping$2[role.ordinal()];
        if (i2 != -1) {
            if (i2 == 1) {
                roleM9361boximpl = Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c());
            } else if (i2 == 2) {
                roleM9361boximpl = Role.m9361boximpl(Role.INSTANCE.m9373getRadioButtono7Vup1c());
            } else if (i2 == 3) {
                roleM9361boximpl = Role.m9361boximpl(Role.INSTANCE.m9374getSwitcho7Vup1c());
            } else {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                roleM9361boximpl = Role.m9361boximpl(Role.INSTANCE.m9375getTabo7Vup1c());
            }
        }
        Role role2 = roleM9361boximpl;
        Modifier.Companion companion3 = Modifier.INSTANCE;
        boolean value = toggleableParams.getValue();
        ComposerKt.sourceInformationMarkerStart(composer, 2006518447, "CC(remember):ModifierRegistry.kt#9igjgp");
        boolean z = (((i & 7168) ^ 3072) > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: expo.modules.ui.ModifierRegistry$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModifierRegistry.registerBuiltInModifiers$lambda$86$lambda$85$lambda$84(eventDispatcher, ((Boolean) obj).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM2654toggleableoSLSa3U$default = ToggleableKt.m2654toggleableoSLSa3U$default(companion3, value, false, role2, null, (Function1) objRememberedValue, 10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2654toggleableoSLSa3U$default;
    }
}
