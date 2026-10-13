package com.kick.mobile.misclib;

import android.content.Context;
import android.provider.Settings;
import androidx.tracing.Trace;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KickMiscLibModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/kick/mobile/misclib/KickMiscLibModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "kick-misc-lib_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickMiscLibModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        KickMiscLibModule kickMiscLibModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (kickMiscLibModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(kickMiscLibModule);
            moduleDefinitionBuilder.Name("KickMiscLib");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
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
            moduleDefinitionBuilder2.getSyncFunctions().put("getSystemOrientationLockState", new SyncFunctionComponent("getSystemOrientationLockState", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: com.kick.mobile.misclib.KickMiscLibModule$definition$lambda$0$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (Settings.System.getInt(reactContext != null ? reactContext.getContentResolver() : null, "accelerometer_rotation", 0) == 1) {
                        return "UNLOCKED";
                    }
                    return "LOCKED";
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
