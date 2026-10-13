package expo.modules.router;

import android.content.Context;
import android.graphics.Color;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.material.color.MaterialColors;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: ExpoRouterModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lexpo/modules/router/ExpoRouterModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "materialColor", "", "name", "scheme", "dynamicColor", "getColorFromTheme", "themeResId", "", "getSystemScheme", "Companion", "expo-router_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoRouterModule extends Module {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Integer> attrMap = MapsKt.mapOf(TuplesKt.to("primary", Integer.valueOf(androidx.appcompat.R.attr.colorPrimary)), TuplesKt.to("onprimary", Integer.valueOf(com.google.android.material.R.attr.colorOnPrimary)), TuplesKt.to("primarycontainer", Integer.valueOf(com.google.android.material.R.attr.colorPrimaryContainer)), TuplesKt.to("onprimarycontainer", Integer.valueOf(com.google.android.material.R.attr.colorOnPrimaryContainer)), TuplesKt.to("primaryinverse", Integer.valueOf(com.google.android.material.R.attr.colorPrimaryInverse)), TuplesKt.to("primaryfixed", Integer.valueOf(com.google.android.material.R.attr.colorPrimaryFixed)), TuplesKt.to("primaryfixeddim", Integer.valueOf(com.google.android.material.R.attr.colorPrimaryFixedDim)), TuplesKt.to("onprimaryfixed", Integer.valueOf(com.google.android.material.R.attr.colorOnPrimaryFixed)), TuplesKt.to("onprimaryfixedvariant", Integer.valueOf(com.google.android.material.R.attr.colorOnPrimaryFixedVariant)), TuplesKt.to("secondary", Integer.valueOf(com.google.android.material.R.attr.colorSecondary)), TuplesKt.to("onsecondary", Integer.valueOf(com.google.android.material.R.attr.colorOnSecondary)), TuplesKt.to("secondarycontainer", Integer.valueOf(com.google.android.material.R.attr.colorSecondaryContainer)), TuplesKt.to("onsecondarycontainer", Integer.valueOf(com.google.android.material.R.attr.colorOnSecondaryContainer)), TuplesKt.to("secondaryfixed", Integer.valueOf(com.google.android.material.R.attr.colorSecondaryFixed)), TuplesKt.to("secondaryfixeddim", Integer.valueOf(com.google.android.material.R.attr.colorSecondaryFixedDim)), TuplesKt.to("onsecondaryfixed", Integer.valueOf(com.google.android.material.R.attr.colorOnSecondaryFixed)), TuplesKt.to("onsecondaryfixedvariant", Integer.valueOf(com.google.android.material.R.attr.colorOnSecondaryFixedVariant)), TuplesKt.to("tertiary", Integer.valueOf(com.google.android.material.R.attr.colorTertiary)), TuplesKt.to("ontertiary", Integer.valueOf(com.google.android.material.R.attr.colorOnTertiary)), TuplesKt.to("tertiarycontainer", Integer.valueOf(com.google.android.material.R.attr.colorTertiaryContainer)), TuplesKt.to("ontertiarycontainer", Integer.valueOf(com.google.android.material.R.attr.colorOnTertiaryContainer)), TuplesKt.to("tertiaryfixed", Integer.valueOf(com.google.android.material.R.attr.colorTertiaryFixed)), TuplesKt.to("tertiaryfixeddim", Integer.valueOf(com.google.android.material.R.attr.colorTertiaryFixedDim)), TuplesKt.to("ontertiaryfixed", Integer.valueOf(com.google.android.material.R.attr.colorOnTertiaryFixed)), TuplesKt.to("ontertiaryfixedvariant", Integer.valueOf(com.google.android.material.R.attr.colorOnTertiaryFixedVariant)), TuplesKt.to("error", Integer.valueOf(androidx.appcompat.R.attr.colorError)), TuplesKt.to("onerror", Integer.valueOf(com.google.android.material.R.attr.colorOnError)), TuplesKt.to("errorcontainer", Integer.valueOf(com.google.android.material.R.attr.colorErrorContainer)), TuplesKt.to("onerrorcontainer", Integer.valueOf(com.google.android.material.R.attr.colorOnErrorContainer)), TuplesKt.to("outline", Integer.valueOf(com.google.android.material.R.attr.colorOutline)), TuplesKt.to("outlinevariant", Integer.valueOf(com.google.android.material.R.attr.colorOutlineVariant)), TuplesKt.to("background", Integer.valueOf(android.R.attr.colorBackground)), TuplesKt.to("onbackground", Integer.valueOf(com.google.android.material.R.attr.colorOnBackground)), TuplesKt.to("surface", Integer.valueOf(com.google.android.material.R.attr.colorSurface)), TuplesKt.to("onsurface", Integer.valueOf(com.google.android.material.R.attr.colorOnSurface)), TuplesKt.to("surfacevariant", Integer.valueOf(com.google.android.material.R.attr.colorSurfaceVariant)), TuplesKt.to("onsurfacevariant", Integer.valueOf(com.google.android.material.R.attr.colorOnSurfaceVariant)), TuplesKt.to("surfaceinverse", Integer.valueOf(com.google.android.material.R.attr.colorSurfaceInverse)), TuplesKt.to("onsurfaceinverse", Integer.valueOf(com.google.android.material.R.attr.colorOnSurfaceInverse)), TuplesKt.to("surfacebright", Integer.valueOf(com.google.android.material.R.attr.colorSurfaceBright)), TuplesKt.to("surfacedim", Integer.valueOf(com.google.android.material.R.attr.colorSurfaceDim)), TuplesKt.to("surfacecontainer", Integer.valueOf(com.google.android.material.R.attr.colorSurfaceContainer)), TuplesKt.to("surfacecontainerlow", Integer.valueOf(com.google.android.material.R.attr.colorSurfaceContainerLow)), TuplesKt.to("surfacecontainerlowest", Integer.valueOf(com.google.android.material.R.attr.colorSurfaceContainerLowest)), TuplesKt.to("surfacecontainerhigh", Integer.valueOf(com.google.android.material.R.attr.colorSurfaceContainerHigh)), TuplesKt.to("surfacecontainerhighest", Integer.valueOf(com.google.android.material.R.attr.colorSurfaceContainerHighest)));

    private final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        ExpoRouterModule expoRouterModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (expoRouterModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(expoRouterModule);
            moduleDefinitionBuilder.Name("ExpoRouter");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.router.ExpoRouterModule$definition$lambda$2$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.router.ExpoRouterModule$definition$lambda$2$$inlined$Function$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(String.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(String.class, returnType2);
                returnType = returnType2;
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("Material3Color", new SyncFunctionComponent("Material3Color", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.router.ExpoRouterModule$definition$lambda$2$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    return this.this$0.materialColor((String) obj, str);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.router.ExpoRouterModule$definition$lambda$2$$inlined$Function$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType3 = new AnyType(typeDescriptor3, converters2);
            }
            anyTypeArr2[0] = anyType3;
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.router.ExpoRouterModule$definition$lambda$2$$inlined$Function$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType4 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr2[1] = anyType4;
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(String.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(String.class, returnType4);
                returnType3 = returnType4;
            }
            moduleDefinitionBuilder3.getSyncFunctions().put("Material3DynamicColor", new SyncFunctionComponent("Material3DynamicColor", anyTypeArr2, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.router.ExpoRouterModule$definition$lambda$2$$inlined$Function$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    return this.this$0.dynamicColor((String) obj, str);
                }
            }));
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th5) {
            Trace.endSection();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String materialColor(String name, String scheme) {
        int i;
        if (!Intrinsics.areEqual(scheme, "dark") && !Intrinsics.areEqual(scheme, "light")) {
            scheme = getSystemScheme();
        }
        if (Intrinsics.areEqual(scheme, "dark")) {
            i = com.google.android.material.R.style.Theme_Material3_Dark;
        } else {
            i = com.google.android.material.R.style.Theme_Material3_Light;
        }
        return getColorFromTheme(name, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String dynamicColor(String name, String scheme) {
        int i;
        if (!Intrinsics.areEqual(scheme, "dark") && !Intrinsics.areEqual(scheme, "light")) {
            scheme = getSystemScheme();
        }
        if (Intrinsics.areEqual(scheme, "dark")) {
            i = com.google.android.material.R.style.Theme_Material3_DynamicColors_Dark;
        } else {
            i = com.google.android.material.R.style.Theme_Material3_DynamicColors_Light;
        }
        return getColorFromTheme(name, i);
    }

    private final String getColorFromTheme(String name, int themeResId) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), themeResId);
        Map<String, Integer> map = attrMap;
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Integer num = map.get(lowerCase);
        if (num != null) {
            Integer colorOrNull = MaterialColors.getColorOrNull(contextThemeWrapper, num.intValue());
            if (colorOrNull != null) {
                return INSTANCE.colorToHex(colorOrNull.intValue());
            }
        }
        return null;
    }

    private final String getSystemScheme() {
        int i = getContext().getResources().getConfiguration().uiMode & 48;
        if (i == 16 || i != 32) {
            return "light";
        }
        return "dark";
    }

    /* JADX INFO: compiled from: ExpoRouterModule.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/router/ExpoRouterModule$Companion;", "", "<init>", "()V", "colorToHex", "", "color", "", "attrMap", "", "getAttrMap", "()Ljava/util/Map;", "expo-router_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String colorToHex(int color) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("#%02x%02x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(Color.red(color)), Integer.valueOf(Color.green(color)), Integer.valueOf(Color.blue(color))}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final Map<String, Integer> getAttrMap() {
            return ExpoRouterModule.attrMap;
        }
    }
}
