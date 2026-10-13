package expo.modules.kotlin.modules;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [Type] */
/* JADX INFO: compiled from: TypeConverterCollection.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class ModuleConvertersBuilder$TypeConverter$lambda$0$$inlined$from$2<Type> implements Function1<Object, Type> {
    final /* synthetic */ Function1 $body$inlined;

    public ModuleConvertersBuilder$TypeConverter$lambda$0$$inlined$from$2(Function1 function1) {
        this.$body$inlined = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Type invoke(Object obj) {
        return (Type) this.$body$inlined.invoke(obj);
    }
}
