package com.datadog.android.internal.data;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpPreferencesStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u001e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/internal/data/NoOpPreferencesStorage;", "Lcom/datadog/android/internal/data/PreferencesStorage;", "()V", "clear", "", "getBoolean", "", "key", "", "defaultValue", "getFloat", "", "getInt", "", "getString", "getStringSet", "", "putBoolean", "value", "putFloat", "putInt", "putString", "putStringSet", "remove", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpPreferencesStorage implements PreferencesStorage {
    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void clear() {
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public boolean getBoolean(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return false;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public float getFloat(String key, float defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return 0.0f;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public int getInt(String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return 0;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public String getString(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putFloat(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putStringSet(String key, Set<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public Set<String> getStringSet(String key, Set<String> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return SetsKt.emptySet();
    }
}
