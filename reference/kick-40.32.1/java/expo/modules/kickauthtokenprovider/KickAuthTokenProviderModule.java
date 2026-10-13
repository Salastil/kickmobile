package expo.modules.kickauthtokenprovider;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
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
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import java.io.IOException;
import java.security.GeneralSecurityException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: KickAuthTokenProviderModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/kickauthtokenprovider/KickAuthTokenProviderModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Companion", "kick-auth-token-provider_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickAuthTokenProviderModule extends Module {
    private static final String LOG_TAG = "KickAuthTokenProviderModule";

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        KickAuthTokenProviderModule kickAuthTokenProviderModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (kickAuthTokenProviderModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(kickAuthTokenProviderModule);
            moduleDefinitionBuilder.Name("KickAuthTokenProvider");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setToken", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kickauthtokenprovider.KickAuthTokenProviderModule$definition$lambda$0$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        Log.d("KickAuthTokenProviderModule", "setToken --> " + str);
                        try {
                            Context reactContext = this.this$0.getAppContext().getReactContext();
                            if (reactContext != null) {
                                MasterKey masterKeyBuild = new MasterKey.Builder(reactContext).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
                                Intrinsics.checkNotNullExpressionValue(masterKeyBuild, "build(...)");
                                SharedPreferences sharedPreferencesCreate = EncryptedSharedPreferences.create(reactContext, "secure_auth_store", masterKeyBuild, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
                                Intrinsics.checkNotNullExpressionValue(sharedPreferencesCreate, "create(...)");
                                SharedPreferences.Editor editorEdit = sharedPreferencesCreate.edit();
                                editorEdit.putString("access_token", str);
                                editorEdit.apply();
                            }
                            Log.d("KickAuthTokenProviderModule", "Token stored successfully.");
                        } catch (Exception e) {
                            Log.e("KickAuthTokenProviderModule", "Failed to store token: " + e.getMessage());
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError), new Function0<KType>() { // from class: expo.modules.kickauthtokenprovider.KickAuthTokenProviderModule$definition$lambda$0$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.nullableTypeOf(String.class);
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
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                    }
                    anyType = new AnyType(typeDescriptor, converters);
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Integer> function1 = new Function1<Object[], Integer>() { // from class: expo.modules.kickauthtokenprovider.KickAuthTokenProviderModule$definition$lambda$0$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(Object[] objArr) {
                        int iE;
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        String str = (String) objArr[0];
                        Log.d("KickAuthTokenProviderModule", "setToken --> " + str);
                        try {
                            Context reactContext = this.this$0.getAppContext().getReactContext();
                            if (reactContext != null) {
                                MasterKey masterKeyBuild = new MasterKey.Builder(reactContext).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
                                Intrinsics.checkNotNullExpressionValue(masterKeyBuild, "build(...)");
                                SharedPreferences sharedPreferencesCreate = EncryptedSharedPreferences.create(reactContext, "secure_auth_store", masterKeyBuild, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
                                Intrinsics.checkNotNullExpressionValue(sharedPreferencesCreate, "create(...)");
                                SharedPreferences.Editor editorEdit = sharedPreferencesCreate.edit();
                                editorEdit.putString("access_token", str);
                                editorEdit.apply();
                            }
                            iE = Log.d("KickAuthTokenProviderModule", "Token stored successfully.");
                        } catch (Exception e) {
                            iE = Log.e("KickAuthTokenProviderModule", "Failed to store token: " + e.getMessage());
                        }
                        return Integer.valueOf(iE);
                    }
                };
                if (!Intrinsics.areEqual(Integer.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Integer.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Integer.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Integer.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Integer.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("setToken", anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("setToken", anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("setToken", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("setToken", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("setToken", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("setToken", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            AsyncFunctionComponent asyncFunctionComponent = asyncFunctionWithPromiseComponent;
            moduleDefinitionBuilder2.getAsyncFunctions().put("setToken", asyncFunctionWithPromiseComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionWithPromiseComponent;
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Object.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Object.class, returnType2);
                returnType = returnType2;
            }
            moduleDefinitionBuilder3.getSyncFunctions().put("getToken", new SyncFunctionComponent("getToken", anyTypeArr2, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kickauthtokenprovider.KickAuthTokenProviderModule$definition$lambda$0$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) throws GeneralSecurityException, IOException {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Log.d("KickAuthTokenProviderModule", "getToken: " + this.this$0.getAppContext().getReactContext());
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext == null) {
                        return null;
                    }
                    MasterKey masterKeyBuild = new MasterKey.Builder(reactContext).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
                    Intrinsics.checkNotNullExpressionValue(masterKeyBuild, "build(...)");
                    SharedPreferences sharedPreferencesCreate = EncryptedSharedPreferences.create(reactContext, "secure_auth_store", masterKeyBuild, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
                    Intrinsics.checkNotNullExpressionValue(sharedPreferencesCreate, "create(...)");
                    String string = sharedPreferencesCreate.getString("access_token", null);
                    Log.d("KickAuthTokenProviderModule", "getToken => " + string);
                    return string;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(Object.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(Object.class, returnType4);
                returnType3 = returnType4;
            }
            moduleDefinitionBuilder4.getSyncFunctions().put("getTokenFromBroadcastApp", new SyncFunctionComponent("getTokenFromBroadcastApp", anyTypeArr3, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.kickauthtokenprovider.KickAuthTokenProviderModule$definition$lambda$0$$inlined$FunctionWithoutArgs$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Log.d("KickAuthTokenProviderModule", "getTokenFromBroadcastApp: -> " + this.this$0.getAppContext().getReactContext());
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext == null) {
                        return null;
                    }
                    Uri uri = Uri.parse("content://com.kick.streaming.tokenprovider/token");
                    Cursor cursorQuery = reactContext.getContentResolver().query(uri, null, null, null, null);
                    Log.d("KickAuthTokenProviderModule", "getTokenFromBroadcastApp: -> " + uri + ", " + cursorQuery);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    try {
                        Bundle bundleCall = reactContext.getContentResolver().call(Uri.parse("content://com.kick.streaming.tokenprovider/token"), "getToken", (String) null, (Bundle) null);
                        Log.i("KickAuthTokenProviderModule", "getTokenFromBroadcastApp: result: " + bundleCall);
                        String string = bundleCall != null ? bundleCall.getString("token") : null;
                        Log.i("KickAuthTokenProviderModule", "getTokenFromBroadcastApp: token: " + string);
                        return string;
                    } catch (Exception e) {
                        Log.e("KickAuthTokenProviderModule", "getTokenFromBroadcastApp: " + e.getMessage());
                        return null;
                    }
                }
            }));
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }
}
