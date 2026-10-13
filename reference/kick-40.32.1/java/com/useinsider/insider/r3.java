package com.useinsider.insider;

import android.content.SharedPreferences;
import android.util.Base64;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class r3 implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f418a;
    private final String c;
    private final int d = 16;
    private final int e = 12;
    private final i b = new i(a());

    public r3(String str, SharedPreferences sharedPreferences) {
        this.c = str;
        this.f418a = sharedPreferences;
    }

    private Set a(Set set, Set set2) {
        if (set != null) {
            try {
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    Object objC = c((String) it.next());
                    if (objC != null && (objC instanceof String)) {
                        hashSet.add((String) objC);
                    }
                }
                return hashSet;
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
        return set2;
    }

    private Object c(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            byte[] bArr = new byte[1];
            byte[] bArr2 = new byte[bArrDecode.length - 1];
            System.arraycopy(bArrDecode, 0, bArr, 0, 1);
            System.arraycopy(bArrDecode, 1, bArr2, 0, bArrDecode.length - 1);
            l lVarA = l.a(bArr);
            if (lVarA != null) {
                return a(this.b.a(bArr2), lVarA);
            }
            return null;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private Object d(String str) {
        return c(this.f418a.getString(a(str), null));
    }

    private byte[] e(String str) {
        try {
            return str.getBytes();
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return new byte[0];
        }
    }

    boolean b() {
        try {
            return this.f418a.getAll().size() <= 1;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return false;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        String strA = a(str);
        if (strA != null) {
            return this.f418a.contains(strA);
        }
        return false;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new s3(this.c, this.f418a.edit(), this.b);
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        String strB;
        Object value;
        HashMap map = new HashMap();
        try {
            for (Map.Entry<String, ?> entry : this.f418a.getAll().entrySet()) {
                if (!w4.g(entry.getKey()) && (strB = b(entry.getKey())) != null && (value = entry.getValue()) != null) {
                    if (value instanceof String) {
                        map.put(strB, c((String) value));
                    } else if (value instanceof Set) {
                        map.put(strB, a((Set) value, new HashSet()));
                    }
                }
            }
            return map;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return map;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object objD = d(str);
        return (objD == null || !(objD instanceof Boolean)) ? z : ((Boolean) objD).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object objD = d(str);
        return (objD == null || !(objD instanceof Float)) ? f : ((Float) objD).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object objD = d(str);
        return (objD == null || !(objD instanceof Integer)) ? i : ((Integer) objD).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object objD = d(str);
        return (objD == null || !(objD instanceof Long)) ? j : ((Long) objD).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object objD = d(str);
        return (objD == null || !(objD instanceof String)) ? str2 : (String) objD;
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        try {
            String strA = a(str);
            return strA != null ? a(this.f418a.getStringSet(strA, null), set) : set;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return set;
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f418a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f418a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    private String b(String str) {
        try {
            return this.b.a(Base64.decode(str, 2), e(this.c));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private String a(String str) {
        try {
            return this.b.b(e(str), e(this.c));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private Object a(String str, l lVar) {
        try {
            if (lVar == l.INT) {
                return Integer.valueOf(Integer.parseInt(str));
            }
            if (lVar == l.STRING) {
                return str;
            }
            if (lVar == l.FLOAT) {
                return Float.valueOf(Float.parseFloat(str));
            }
            if (lVar == l.LONG) {
                return Long.valueOf(Long.parseLong(str));
            }
            if (lVar == l.BOOLEAN) {
                return Boolean.valueOf(Boolean.parseBoolean(str));
            }
            return null;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private byte[] a() {
        byte[] bArr = new byte[16];
        try {
            String strEncodeToString = Base64.encodeToString("__insider_security_pref_key_set__".getBytes(), 2);
            String string = this.f418a.getString(strEncodeToString, null);
            if (string != null) {
                byte[] bArrDecode = Base64.decode(string, 2);
                byte[] bArr2 = new byte[16];
                System.arraycopy(bArrDecode, 12, bArr2, 0, bArrDecode.length - 12);
                return bArr2;
            }
            SecureRandom secureRandom = new SecureRandom();
            byte[] bArr3 = new byte[12];
            byte[] bArr4 = new byte[28];
            secureRandom.nextBytes(bArr);
            secureRandom.nextBytes(bArr3);
            System.arraycopy(bArr3, 0, bArr4, 0, 12);
            System.arraycopy(bArr, 0, bArr4, 12, 16);
            this.f418a.edit().clear().putString(strEncodeToString, Base64.encodeToString(bArr4, 2)).apply();
            return bArr;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return bArr;
        }
    }
}
