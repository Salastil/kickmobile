package expo.modules.ui;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.types.Either;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PaddingValuesExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0005"}, d2 = {"toPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Lexpo/modules/kotlin/types/Either;", "", "Lexpo/modules/ui/PaddingValuesRecord;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PaddingValuesExtensionKt {
    public static final PaddingValues toPaddingValues(Either<Float, PaddingValuesRecord> either) {
        if (either == null) {
            return PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
        }
        if (either.isFirstType(Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(either.getFirstType(Reflection.getOrCreateKotlinClass(Float.TYPE)).floatValue()));
        }
        if (either.isSecondType(Reflection.getOrCreateKotlinClass(PaddingValuesRecord.class))) {
            return either.getSecondType(Reflection.getOrCreateKotlinClass(PaddingValuesRecord.class)).toPaddingValues();
        }
        throw new IllegalStateException();
    }
}
