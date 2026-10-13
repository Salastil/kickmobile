package expo.modules.structuredheaders;

import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes9.dex */
public interface Type<T> extends Supplier<T> {
    String serialize();

    StringBuilder serializeTo(StringBuilder sb);
}
