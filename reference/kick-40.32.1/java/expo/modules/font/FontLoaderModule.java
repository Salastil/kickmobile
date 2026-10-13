package expo.modules.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.common.assets.ReactFontManager;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FontLoaderModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0003J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lexpo/modules/font/FontLoaderModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "familyTypeface", "Landroid/graphics/Typeface;", "fontFamilyName", "", "faces", "", "Lexpo/modules/font/FontFaceRecord;", "loadSingleFaceTypeface", "localUri", "buildMultiFaceTypeface", "queryCustomNativeFonts", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class FontLoaderModule extends Module {
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
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        FontLoaderModule fontLoaderModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (fontLoaderModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(fontLoaderModule);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            moduleDefinitionBuilder.Name("ExpoFontLoader");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Object.class);
            Object obj = null;
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Object.class, returnType2);
                returnType = returnType2;
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("getLoadedFonts", new SyncFunctionComponent("getLoadedFonts", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$5$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return FontLoaderModule.definition$lambda$5$getLoadedFonts(objectRef, this);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$5$$inlined$AsyncFunction$1
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
            anyTypeArr2[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$5$$inlined$AsyncFunction$2
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
            anyTypeArr2[1] = anyType2;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$5$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    String str = (String) objArr[1];
                    String str2 = (String) obj2;
                    Ref.ObjectRef objectRef2 = objectRef;
                    FontLoaderModule fontLoaderModule2 = this.this$0;
                    FontLoaderModule.definition$lambda$5$registerTypeface(objectRef2, fontLoaderModule2, str2, fontLoaderModule2.loadSingleFaceTypeface(str2, str));
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                            } else {
                                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("loadAsync", untypedAsyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder4.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$5$$inlined$AsyncFunction$4
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
            anyTypeArr3[0] = anyType3;
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(FontFaceRecord.class, false, FontFaceRecord.__Pika.__pika$IntrospectionData)), null)), new Function0<KType>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$5$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(FontFaceRecord.class)));
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (!Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    obj = objM12684constructorimpl4;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) obj;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(FontFaceRecord.class))));
                }
                anyType4 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr3[1] = anyType4;
            Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$5$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws CodedException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    List<FontFaceRecord> list = (List) objArr[1];
                    String str = (String) obj2;
                    if (list.isEmpty()) {
                        throw new CodedException("Could not load font family '" + str + "' because 'faces' is empty. Pass at least one face with a 'localUri' pointing to a font file.", null, 2, null);
                    }
                    FontFamilyFaces.INSTANCE.assertWeightsInRange(str, list);
                    Ref.ObjectRef objectRef2 = objectRef;
                    FontLoaderModule fontLoaderModule2 = this.this$0;
                    FontLoaderModule.definition$lambda$5$registerTypeface(objectRef2, fontLoaderModule2, str, fontLoaderModule2.familyTypeface(str, list));
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("loadFontFamilyAsync", anyTypeArr3, function2);
                            } else {
                                untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("loadFontFamilyAsync", anyTypeArr3, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("loadFontFamilyAsync", anyTypeArr3, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("loadFontFamilyAsync", anyTypeArr3, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("loadFontFamilyAsync", anyTypeArr3, function2);
                }
            } else {
                untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("loadFontFamilyAsync", anyTypeArr3, function2);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("loadFontFamilyAsync", untypedAsyncFunctionComponent2);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th5) {
            Trace.endSection();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.util.List, java.util.List<java.lang.String>] */
    public static final List<String> definition$lambda$5$getLoadedFonts(Ref.ObjectRef<List<String>> objectRef, FontLoaderModule fontLoaderModule) throws IOException {
        List<String> list = objectRef.element;
        if (list != null) {
            return list;
        }
        ?? QueryCustomNativeFonts = fontLoaderModule.queryCustomNativeFonts();
        objectRef.element = QueryCustomNativeFonts;
        return QueryCustomNativeFonts;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.util.List] */
    public static final void definition$lambda$5$registerTypeface(Ref.ObjectRef<List<String>> objectRef, FontLoaderModule fontLoaderModule, String str, Typeface typeface) {
        ReactFontManager.INSTANCE.getInstance().addCustomFont(str, typeface);
        Set mutableSet = CollectionsKt.toMutableSet(definition$lambda$5$getLoadedFonts(objectRef, fontLoaderModule));
        mutableSet.add(str);
        objectRef.element = CollectionsKt.toList(mutableSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Typeface familyTypeface(String fontFamilyName, List<FontFaceRecord> faces) {
        FontFaceRecord fontFaceRecord = (FontFaceRecord) CollectionsKt.first((List) faces);
        if (faces.size() == 1 && fontFaceRecord.getWeight() == null && fontFaceRecord.getStyle() == null) {
            return loadSingleFaceTypeface(fontFamilyName, fontFaceRecord.getLocalUri());
        }
        if (Build.VERSION.SDK_INT < 29) {
            return loadSingleFaceTypeface(fontFamilyName, faces.get(FontFamilyFaces.INSTANCE.defaultFaceIndex(faces)).getLocalUri());
        }
        return buildMultiFaceTypeface(fontFamilyName, faces);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Typeface loadSingleFaceTypeface(String fontFamilyName, String localUri) throws CodedException {
        FontSource fontSourceResolve = FontSource.INSTANCE.resolve(localUri, fontFamilyName, getContext());
        Typeface typefaceBuildVariableWeightTypeface = Build.VERSION.SDK_INT >= 29 ? FontLoaderModuleKt.buildVariableWeightTypeface(fontFamilyName, fontSourceResolve) : null;
        return typefaceBuildVariableWeightTypeface == null ? fontSourceResolve.load() : typefaceBuildVariableWeightTypeface;
    }

    private final Typeface buildMultiFaceTypeface(String fontFamilyName, List<FontFaceRecord> faces) {
        List<FontFaceRecord> list = faces;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(FontSource.INSTANCE.resolve(((FontFaceRecord) it.next()).getLocalUri(), fontFamilyName, getContext()));
        }
        return MultiFaceTypeface.INSTANCE.build(fontFamilyName, faces, arrayList);
    }

    private final List<String> queryCustomNativeFonts() throws IOException {
        List<String> groupValues;
        AssetManager assets = getContext().getAssets();
        Regex regex = new Regex("^(.+?)(_bold|_italic|_bold_italic)?\\.(ttf|otf)$");
        Set<String> customFontFamilies = ReactFontManager.INSTANCE.getInstance().getCustomFontFamilies();
        String[] list = assets.list("fonts/");
        ArrayList arrayListEmptyList = null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                Intrinsics.checkNotNull(str);
                MatchResult matchResultFind$default = Regex.find$default(regex, str, 0, 2, null);
                String str2 = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : groupValues.get(1);
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            arrayListEmptyList = arrayList;
        }
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        Set setUnion = CollectionsKt.union(customFontFamilies, arrayListEmptyList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : setUnion) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
