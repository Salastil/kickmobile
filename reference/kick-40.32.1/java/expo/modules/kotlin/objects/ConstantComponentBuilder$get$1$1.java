package expo.modules.kotlin.objects;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ConstantComponentBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class ConstantComponentBuilder$get$1$1 implements Function0<Object> {
    final /* synthetic */ Function0<R> $body;

    /* JADX WARN: Multi-variable type inference failed */
    public ConstantComponentBuilder$get$1$1(Function0<? extends R> function0) {
        this.$body = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.$body.invoke();
    }
}
