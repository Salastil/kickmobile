package com.kick.mobile.capacitorauthmigrator;

import android.content.Context;
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
import kotlin.text.Charsets;

/* JADX INFO: compiled from: CapacitorAuthMigratorModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/kick/mobile/capacitorauthmigrator/CapacitorAuthMigratorModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "capacitor-auth-migrator_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CapacitorAuthMigratorModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        CapacitorAuthMigratorModule capacitorAuthMigratorModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (capacitorAuthMigratorModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(capacitorAuthMigratorModule);
            moduleDefinitionBuilder.Name("CapacitorAuthMigrator");
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
            moduleDefinitionBuilder2.getSyncFunctions().put("getCapAuthToken", new SyncFunctionComponent("getCapAuthToken", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: com.kick.mobile.capacitorauthmigrator.CapacitorAuthMigratorModule$definition$lambda$0$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context applicationContext;
                    byte[] token;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext == null || (applicationContext = reactContext.getApplicationContext()) == null || (token = PasswordStorageHelper.INSTANCE.getToken(applicationContext)) == null) {
                        return null;
                    }
                    return new String(token, Charsets.UTF_8);
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
