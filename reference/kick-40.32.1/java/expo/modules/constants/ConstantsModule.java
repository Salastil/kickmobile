package expo.modules.constants;

import androidx.tracing.Trace;
import com.datadog.android.core.internal.data.upload.DataOkHttpUploader;
import expo.modules.interfaces.constants.ConstantsInterface;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ConstantComponentBuilder;
import expo.modules.kotlin.services.Service;
import expo.modules.kotlin.types.AnyType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstantsModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/constants/ConstantsModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-constants_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConstantsModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Map<String, Object> constants;
        ConstantsModule constantsModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (constantsModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(constantsModule);
            moduleDefinitionBuilder.Name("ExponentConstants");
            Service service = getAppContext().getServices().getRegistry().get(ConstantsInterface.class);
            if (!(service instanceof ConstantsInterface)) {
                service = null;
            }
            ConstantsInterface constantsInterface = (ConstantsInterface) service;
            if (constantsInterface != null && (constants = constantsInterface.getConstants()) != null) {
                for (final Map.Entry<String, Object> entry : constants.entrySet()) {
                    String key = entry.getKey();
                    ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder(key);
                    constantComponentBuilder.setGetter(new Function0<Object>() { // from class: expo.modules.constants.ConstantsModule$definition$lambda$0$0$$inlined$Constant$1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return entry.getValue();
                        }
                    });
                    moduleDefinitionBuilder.getConstants().put(key, constantComponentBuilder);
                }
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("getWebViewUserAgentAsync", new UntypedAsyncFunctionComponent("getWebViewUserAgentAsync", new AnyType[0], new Function1<Object[], String>() { // from class: expo.modules.constants.ConstantsModule$definition$lambda$0$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return System.getProperty(DataOkHttpUploader.SYSTEM_UA);
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
