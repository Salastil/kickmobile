package com.datadog.android.internal.data;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: PreferencesStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\fH&J\u001e\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\fH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H&J\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/internal/data/PreferencesStorage;", "", "clear", "", "getBoolean", "", "key", "", "defaultValue", "getFloat", "", "getInt", "", "getString", "getStringSet", "", "putBoolean", "value", "putFloat", "putInt", "putString", "putStringSet", "remove", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PreferencesStorage {
    void clear();

    boolean getBoolean(String key, boolean defaultValue);

    float getFloat(String key, float defaultValue);

    int getInt(String key, int defaultValue);

    String getString(String key, String defaultValue);

    Set<String> getStringSet(String key, Set<String> defaultValue);

    void putBoolean(String key, boolean value);

    void putFloat(String key, float value);

    void putInt(String key, int value);

    void putString(String key, String value);

    void putStringSet(String key, Set<String> value);

    void remove(String key);

    /* JADX INFO: compiled from: PreferencesStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ float getFloat$default(PreferencesStorage preferencesStorage, String str, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloat");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            return preferencesStorage.getFloat(str, f);
        }

        public static /* synthetic */ int getInt$default(PreferencesStorage preferencesStorage, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInt");
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return preferencesStorage.getInt(str, i);
        }

        public static /* synthetic */ String getString$default(PreferencesStorage preferencesStorage, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return preferencesStorage.getString(str, str2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Set getStringSet$default(PreferencesStorage preferencesStorage, String str, Set set, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStringSet");
            }
            if ((i & 2) != 0) {
                set = SetsKt.emptySet();
            }
            return preferencesStorage.getStringSet(str, set);
        }

        public static /* synthetic */ boolean getBoolean$default(PreferencesStorage preferencesStorage, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoolean");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return preferencesStorage.getBoolean(str, z);
        }
    }
}
