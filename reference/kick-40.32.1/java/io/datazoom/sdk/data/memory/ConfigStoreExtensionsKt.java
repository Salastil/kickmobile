package io.datazoom.sdk.data.memory;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.AppConfig;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ConfigStoreExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0003`\u0004\"\u0004\b\u0000\u0010\u0003*\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0003`\u0004\u001aP\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0003`\u0004\"\u0004\b\u0000\u0010\u0003*\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0003`\u0004¨\u0006\b"}, d2 = {"allowedFD", "Ljava/util/HashMap;", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/HashMap;", "Lio/datazoom/sdk/model/AppConfig;", "flux", "allowedMD", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ConfigStoreExtensionsKt {
    public static final <V> HashMap<String, V> allowedFD(final AppConfig appConfig, final HashMap<String, V> flux) {
        Intrinsics.checkNotNullParameter(appConfig, "<this>");
        Intrinsics.checkNotNullParameter(flux, "flux");
        Set<String> setKeySet = flux.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        CollectionsKt.removeAll(setKeySet, new Function1() { // from class: io.datazoom.sdk.data.memory.ConfigStoreExtensionsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ConfigStoreExtensionsKt.allowedFD$lambda$0$0(appConfig, flux, (String) obj));
            }
        });
        return flux;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean allowedFD$lambda$0$0(AppConfig appConfig, HashMap map, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !appConfig.isFluxEnabled(it) || map.get(it) == null;
    }

    public static final <V> HashMap<String, V> allowedMD(final AppConfig appConfig, final HashMap<String, V> flux) {
        Intrinsics.checkNotNullParameter(appConfig, "<this>");
        Intrinsics.checkNotNullParameter(flux, "flux");
        Set<String> setKeySet = flux.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        CollectionsKt.removeAll(setKeySet, new Function1() { // from class: io.datazoom.sdk.data.memory.ConfigStoreExtensionsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ConfigStoreExtensionsKt.allowedMD$lambda$0$0(appConfig, flux, (String) obj));
            }
        });
        return flux;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean allowedMD$lambda$0$0(AppConfig appConfig, HashMap map, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(appConfig.isMetadataEnabled(it) || StringsKt.startsWith$default(it, "custom_", false, 2, (Object) null)) || map.get(it) == null;
    }
}
