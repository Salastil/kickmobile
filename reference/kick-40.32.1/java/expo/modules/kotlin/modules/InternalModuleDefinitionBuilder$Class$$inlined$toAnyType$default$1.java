package expo.modules.kotlin.modules;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: typeDescriptorOf.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class InternalModuleDefinitionBuilder$Class$$inlined$toAnyType$default$1 implements Function0<KType> {
    public static final InternalModuleDefinitionBuilder$Class$$inlined$toAnyType$default$1 INSTANCE = new InternalModuleDefinitionBuilder$Class$$inlined$toAnyType$default$1();

    @Override // kotlin.jvm.functions.Function0
    public final KType invoke() {
        return Reflection.typeOf(Unit.class);
    }
}
