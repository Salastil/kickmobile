package expo.modules.kotlin.types.descriptors;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: TypeDescriptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class TypeDescriptor$params$1$1 implements Function0<KType> {
    final /* synthetic */ int $index;
    final /* synthetic */ TypeDescriptor this$0;

    public TypeDescriptor$params$1$1(TypeDescriptor typeDescriptor, int i) {
        this.this$0 = typeDescriptor;
        this.$index = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final KType invoke() {
        KType type = this.this$0.getKType().getArguments().get(this.$index).getType();
        if (type != null) {
            return type;
        }
        throw new IllegalStateException("Type argument is missing".toString());
    }
}
