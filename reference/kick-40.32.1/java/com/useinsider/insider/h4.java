package com.useinsider.insider;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class h4 {
    private static volatile h4 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap f340a = new ConcurrentHashMap(3);

    private h4() {
    }

    static h4 a() {
        if (b == null) {
            synchronized (h4.class) {
                if (b == null) {
                    b = new h4();
                }
            }
        }
        return b;
    }

    private boolean b() {
        return true;
    }

    private SharedPreferences c(Context context, String str) {
        try {
            return EncryptedSharedPreferences.create(context, "encrypted_" + str, new MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private SharedPreferences d(Context context, String str) {
        try {
            String str2 = "secure_" + str;
            return new r3(str2, context.getSharedPreferences(str2, 0));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return b(context, str);
        }
    }

    private Boolean f(Context context, String str) {
        boolean z = false;
        if (str != null && context != null && context.getSharedPreferences(str, 0).getAll().isEmpty()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SharedPreferences g(Context context, String str) {
        SharedPreferences sharedPreferencesD = d(context, str);
        if (sharedPreferencesD == null) {
            return null;
        }
        if (a(sharedPreferencesD)) {
            a(sharedPreferencesD, context, str);
        }
        return sharedPreferencesD;
    }

    SharedPreferences e(final Context context, String str) {
        return (SharedPreferences) this.f340a.computeIfAbsent(str, new Function() { // from class: com.useinsider.insider.h4$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.g(context, (String) obj);
            }
        });
    }

    private SharedPreferences b(Context context, String str) {
        try {
            return context.getSharedPreferences(str, 0);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private void a(SharedPreferences sharedPreferences, Context context, String str) {
        try {
            String str2 = "encrypted_" + str;
            SharedPreferences sharedPreferencesB = b(context, str);
            if (!a(sharedPreferencesB)) {
                a(sharedPreferencesB, sharedPreferences);
            } else {
                if (!b() || f(context, str2).booleanValue()) {
                    return;
                }
                a(c(context, str), sharedPreferences);
                a(context, str2);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private boolean a(SharedPreferences sharedPreferences) {
        if (sharedPreferences instanceof r3) {
            return ((r3) sharedPreferences).b();
        }
        return sharedPreferences != null && sharedPreferences.getAll().isEmpty();
    }

    private void a(Context context, String str) {
        try {
            context.getSharedPreferences(str, 0).edit().clear().apply();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void a(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        if (sharedPreferences == null || sharedPreferences2 == null) {
            return;
        }
        try {
            Map<String, ?> all = sharedPreferences.getAll();
            if (all.isEmpty()) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    editorEdit.putString(key, (String) value);
                } else if (value instanceof Integer) {
                    editorEdit.putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Boolean) {
                    editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    editorEdit.putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Long) {
                    editorEdit.putLong(key, ((Long) value).longValue());
                } else if (value instanceof Set) {
                    editorEdit.putStringSet(key, (Set) value);
                }
            }
            sharedPreferences.edit().clear().apply();
            editorEdit.apply();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
