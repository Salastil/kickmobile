package org.koin.core.extension;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;

/* JADX INFO: compiled from: ExtensionManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0011\u001a\u0002H\u0012\"\n\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\nH\u0086\b¢\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\u0004\u0018\u0001H\u0012\"\n\b\u0000\u0010\u0012\u0018\u0001*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\nH\u0086\b¢\u0006\u0002\u0010\u0014J%\u0010\u0016\u001a\u00020\u0017\"\b\b\u0000\u0010\u0012*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0018\u001a\u0002H\u0012¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R8\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lorg/koin/core/extension/ExtensionManager;", "", "_koin", "Lorg/koin/core/Koin;", "<init>", "(Lorg/koin/core/Koin;)V", "get_koin$koin_core", "()Lorg/koin/core/Koin;", "extensions", "Ljava/util/HashMap;", "", "Lorg/koin/core/extension/KoinExtension;", "Lkotlin/collections/HashMap;", "getExtensions$annotations", "()V", "getExtensions", "()Ljava/util/HashMap;", "getExtension", ExifInterface.GPS_DIRECTION_TRUE, "id", "(Ljava/lang/String;)Lorg/koin/core/extension/KoinExtension;", "getExtensionOrNull", "registerExtension", "", "extension", "(Ljava/lang/String;Lorg/koin/core/extension/KoinExtension;)V", "close", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionManager {
    private final Koin _koin;
    private final HashMap<String, KoinExtension> extensions;

    public static /* synthetic */ void getExtensions$annotations() {
    }

    public ExtensionManager(Koin _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this._koin = _koin;
        this.extensions = new HashMap<>();
    }

    /* JADX INFO: renamed from: get_koin$koin_core, reason: from getter */
    public final Koin get_koin() {
        return this._koin;
    }

    public final HashMap<String, KoinExtension> getExtensions() {
        return this.extensions;
    }

    public final /* synthetic */ <T extends KoinExtension> T getExtension(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        KoinExtension koinExtension = getExtensions().get(id);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) koinExtension;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(("Koin extension '" + id + "' not found.").toString());
    }

    public final /* synthetic */ <T extends KoinExtension> T getExtensionOrNull(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        KoinExtension koinExtension = getExtensions().get(id);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) koinExtension;
    }

    public final <T extends KoinExtension> void registerExtension(String id, T extension) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extension, "extension");
        this.extensions.put(id, extension);
        extension.onRegister(this._koin);
    }

    public final void close() {
        Collection<KoinExtension> collectionValues = this.extensions.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((KoinExtension) it.next()).onClose();
        }
    }
}
