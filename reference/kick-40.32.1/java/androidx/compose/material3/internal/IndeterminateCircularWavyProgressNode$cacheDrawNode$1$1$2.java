package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class IndeterminateCircularWavyProgressNode$cacheDrawNode$1$1$2 extends FunctionReferenceImpl implements Function5<Float, Float, Float, Size, Path, Path> {
    IndeterminateCircularWavyProgressNode$cacheDrawNode$1$1$2(Object obj) {
        super(5, obj, IndeterminateCircularWavyProgressNode.class, "trackPathProvider", "trackPathProvider-yzxVdVo(FFFJLandroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Path invoke(Float f, Float f2, Float f3, Size size, Path path) {
        return m5379invokeyzxVdVo(f.floatValue(), f2.floatValue(), f3.floatValue(), size.m7147unboximpl(), path);
    }

    /* JADX INFO: renamed from: invoke-yzxVdVo, reason: not valid java name */
    public final Path m5379invokeyzxVdVo(float f, float f2, float f3, long j, Path path) {
        return ((IndeterminateCircularWavyProgressNode) this.receiver).m5328trackPathProvideryzxVdVo(f, f2, f3, j, path);
    }
}
