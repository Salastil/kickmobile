package expo.modules.securestore;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecureStoreModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\b"}, d2 = {"removeItem", "", "prefs", "Landroid/content/SharedPreferences;", "legacyPrefs", "key", "", "keychainAwareKey", "expo-secure-store_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SecureStoreModuleKt {
    public static final boolean removeItem(SharedPreferences prefs, SharedPreferences legacyPrefs, String key, String keychainAwareKey) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(legacyPrefs, "legacyPrefs");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(keychainAwareKey, "keychainAwareKey");
        return prefs.edit().remove(keychainAwareKey).remove(key).commit() && legacyPrefs.edit().remove(key).commit();
    }
}
