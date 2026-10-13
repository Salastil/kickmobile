package com.datadog.android.internal.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPreferencesStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J#\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001fH\u0002¢\u0006\u0002\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/datadog/android/internal/data/SharedPreferencesStorage;", "Lcom/datadog/android/internal/data/PreferencesStorage;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "clear", "", "getBoolean", "", "key", "", "defaultValue", "getFloat", "", "getInt", "", "getString", "getStringSet", "", "putBoolean", "value", "putFloat", "putInt", "putString", "putStringSet", "remove", "runSafe", ExifInterface.GPS_DIRECTION_TRUE, "runnable", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SharedPreferencesStorage implements PreferencesStorage {
    public static final String DATADOG_PREFERENCES_FILE_NAME = "dd_prefs";
    private final SharedPreferences prefs;

    public SharedPreferencesStorage(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        SharedPreferences sharedPreferences = appContext.getSharedPreferences(DATADOG_PREFERENCES_FILE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "appContext.getSharedPref…ME, Context.MODE_PRIVATE)");
        this.prefs = sharedPreferences;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putFloat(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.prefs.edit().putFloat(key, value).apply();
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public float getFloat(final String key, final float defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Float f = (Float) runSafe(new Function0<Float>() { // from class: com.datadog.android.internal.data.SharedPreferencesStorage.getFloat.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(SharedPreferencesStorage.this.prefs.getFloat(key, defaultValue));
            }
        });
        return f != null ? f.floatValue() : defaultValue;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.prefs.edit().putInt(key, value).apply();
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public int getInt(final String key, final int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Integer num = (Integer) runSafe(new Function0<Integer>() { // from class: com.datadog.android.internal.data.SharedPreferencesStorage.getInt.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(SharedPreferencesStorage.this.prefs.getInt(key, defaultValue));
            }
        });
        return num != null ? num.intValue() : defaultValue;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public String getString(final String key, final String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        String str = (String) runSafe(new Function0<String>() { // from class: com.datadog.android.internal.data.SharedPreferencesStorage.getString.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return SharedPreferencesStorage.this.prefs.getString(key, defaultValue);
            }
        });
        return str == null ? defaultValue : str;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString(key, value).apply();
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public Set<String> getStringSet(final String key, final Set<String> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Set<String> set = (Set) runSafe(new Function0<Set<String>>() { // from class: com.datadog.android.internal.data.SharedPreferencesStorage.getStringSet.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<String> invoke() {
                return SharedPreferencesStorage.this.prefs.getStringSet(key, defaultValue);
            }
        });
        return set == null ? defaultValue : set;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putStringSet(String key, Set<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putStringSet(key, value).apply();
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void putBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.prefs.edit().putBoolean(key, value).apply();
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public boolean getBoolean(final String key, final boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Boolean bool = (Boolean) runSafe(new Function0<Boolean>() { // from class: com.datadog.android.internal.data.SharedPreferencesStorage.getBoolean.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(SharedPreferencesStorage.this.prefs.getBoolean(key, defaultValue));
            }
        });
        return bool != null ? bool.booleanValue() : defaultValue;
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.prefs.edit().remove(key).apply();
    }

    @Override // com.datadog.android.internal.data.PreferencesStorage
    public void clear() {
        this.prefs.edit().clear().apply();
    }

    private final <T> T runSafe(Function0<? extends T> runnable) {
        try {
            return runnable.invoke();
        } catch (ClassCastException unused) {
            return null;
        }
    }
}
