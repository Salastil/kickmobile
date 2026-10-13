package com.useinsider.insider;

import android.content.Context;
import android.content.SharedPreferences;
import com.mux.stats.sdk.core.model.EnvironmentData;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import expo.modules.notifications.serverregistration.InstallationId;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderUser {
    private Context context;
    private Map<String, Object> customAttributes;
    private Map<String, Object> deviceAttributes;
    private String insiderID;
    private boolean isUserValid;
    private ArrayList<String> unsetCustomAttributes;
    private Map<String, Object> userAttributes;
    private Map<String, String> userIdentifiersForStopPayload;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    public interface InsiderIDResult {
        void insiderIDResult(String str);
    }

    InsiderUser() {
        this.isUserValid = false;
    }

    private Boolean areIdentifiersAlreadyCached(InsiderIdentifiers insiderIdentifiers) {
        try {
            return !this.isUserValid ? Boolean.FALSE : Boolean.valueOf(w4.a(new JSONObject(getInsiderSharedPreferences().getString(f.p, "{}"))).equals(insiderIdentifiers.getIdentifiers()));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return Boolean.FALSE;
        }
    }

    private SharedPreferences getInsiderSharedPreferences() {
        return h4.a().e(this.context, "Insider");
    }

    private boolean isItemInTheArray(String str, ArrayList<String> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() != 0) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        String str2 = arrayList.get(i);
                        i++;
                        if (str2.equals(str)) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
        return false;
    }

    private void setAppVersion(String str) {
        if (this.isUserValid) {
            this.deviceAttributes.put("app_version", str);
        }
    }

    private void setCarrier(String str) {
        if (this.isUserValid) {
            if (!e.m) {
                str = "N/A";
            }
            this.deviceAttributes.put("carrier", str);
        }
    }

    private void setCustomAttribute(String str, Object obj, String str2) {
        try {
            if (this.isUserValid) {
                this.customAttributes.put(str, obj);
                this.unsetCustomAttributes.remove(str);
                if (obj.getClass().getSimpleName().equals("String[]")) {
                    obj = w4.a((String[]) obj);
                }
                HashMap map = new HashMap();
                map.put("name", str);
                map.put("value", obj);
                map.put("type", str2);
                Debugger.a(DebuggingTag.setCustomAttribute, 4, map);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void setDeviceLanguage(String str) {
        if (this.isUserValid) {
            this.deviceAttributes.put("device_language", str);
        }
    }

    private void setMobileInstallDate() {
        try {
            long jG = w4.g(this.context);
            if (jG == 0) {
                w4.x(this.context);
                jG = w4.g(this.context);
            }
            if (jG > 0) {
                setUserAttribute("mid", Long.valueOf(jG), z3.c);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void setModel(String str) {
        if (this.isUserValid) {
            this.deviceAttributes.put("model", str);
        }
    }

    private void setOSVersion(String str) {
        if (this.isUserValid) {
            this.deviceAttributes.put("os_version", str);
        }
    }

    private void setPackageName(String str) {
        if (this.isUserValid) {
            this.deviceAttributes.put("package_name", str);
        }
    }

    private void setPlatform(String str) {
        if (this.isUserValid) {
            this.deviceAttributes.put("platform", str);
        }
    }

    private void setProvider(n4 n4Var) {
        if (this.isUserValid) {
            this.deviceAttributes.put("provider", n4Var.b());
        }
    }

    private void setSDKVersion(String str) {
        if (this.isUserValid) {
            this.deviceAttributes.put("sdk_version", str);
        }
    }

    private void setTimezone(String str) {
        if (this.isUserValid) {
            this.deviceAttributes.put("timezone", str);
        }
    }

    private void setUDID(String str) {
        if (this.isUserValid) {
            this.deviceAttributes.put("udid", str);
        }
    }

    void fillDeviceAttributes(d5 d5Var) {
        try {
            if (this.isUserValid) {
                setUDID(w4.k(this.context));
                setModel(w4.c());
                setCarrier(d5Var.b());
                setAppVersion(d5Var.a());
                setPlatform(GetDeviceInfoUseCaseKt.PLATFORM);
                setOSVersion(w4.g());
                String id = "";
                setDeviceLanguage((Locale.getDefault() == null || Locale.getDefault().getLanguage() == null) ? "" : Locale.getDefault().getLanguage());
                if (TimeZone.getDefault() != null && TimeZone.getDefault().getID() != null) {
                    id = TimeZone.getDefault().getID();
                }
                setTimezone(id);
                setSDKVersion(w4.i());
                setPackageName(d5Var.c());
                setProvider(w4.e(this.context));
                this.deviceAttributes.put("push_enabled", Boolean.valueOf(w4.p(this.context)));
                this.deviceAttributes.put("location_enabled", Boolean.valueOf(w4.n(this.context)));
                this.deviceAttributes.put("is_location_disabled", Boolean.valueOf(!e.l));
                this.deviceAttributes.put("is_ip_disabled", Boolean.valueOf(!e.k));
                if (w4.j() != null) {
                    this.deviceAttributes.put("device_token", w4.j());
                }
                setMobileInstallDate();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    Map<String, Object> getCustomAttributes() {
        return !this.isUserValid ? Collections.EMPTY_MAP : this.customAttributes;
    }

    Map<String, Object> getDeviceAttributes() {
        return !this.isUserValid ? Collections.EMPTY_MAP : this.deviceAttributes;
    }

    String getInsiderID() {
        try {
            if (!this.isUserValid) {
                return "";
            }
            String str = this.insiderID;
            if (str == null || str.isEmpty()) {
                this.insiderID = getInsiderSharedPreferences().contains(f.s) ? getInsiderSharedPreferences().getString(f.s, w4.k(this.context)) : w4.k(this.context);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
        return this.insiderID;
    }

    String getUDID() {
        return !this.isUserValid ? "" : w4.k(this.context);
    }

    ArrayList<String> getUnsetCustomAttributes() {
        return !this.isUserValid ? new ArrayList<>() : this.unsetCustomAttributes;
    }

    Map<String, Object> getUserAttributes() {
        return !this.isUserValid ? Collections.EMPTY_MAP : this.userAttributes;
    }

    Map<String, String> getUserIdentifiersForStopPayload() {
        return !this.isUserValid ? Collections.EMPTY_MAP : this.userIdentifiersForStopPayload;
    }

    Map<String, Object> inflateDeviceAttributes() {
        d5 d5Var = new d5(this.context);
        HashMap map = new HashMap();
        map.put("udid", w4.k(this.context));
        map.put("model", w4.c());
        map.put("carrier", !e.m ? "N/A" : d5Var.b());
        map.put("app_version", d5Var.a());
        map.put("platform", GetDeviceInfoUseCaseKt.PLATFORM);
        map.put("os_version", w4.g());
        map.put("device_language", Locale.getDefault().getLanguage());
        TimeZone timeZone = TimeZone.getDefault();
        if (timeZone == null || timeZone.getID() == null) {
            map.put("timezone", "");
        } else {
            map.put("timezone", timeZone.getID());
        }
        map.put("sdk_version", w4.i());
        map.put("package_name", d5Var.c());
        map.put("provider", w4.e(this.context));
        map.put("push_enabled", Boolean.valueOf(w4.p(this.context)));
        map.put("location_enabled", Boolean.valueOf(w4.n(this.context)));
        map.put("is_location_disabled", Boolean.valueOf(!e.l));
        map.put("is_ip_disabled", Boolean.valueOf(!e.k));
        return Collections.unmodifiableMap(map);
    }

    public void login(InsiderIdentifiers insiderIdentifiers) {
        try {
            if (this.isUserValid && insiderIdentifiers != null && !insiderIdentifiers.getIdentifiers().isEmpty() && !areIdentifiersAlreadyCached(insiderIdentifiers).booleanValue()) {
                Insider.Instance.startUnificationProcessWithSessionProcess(insiderIdentifiers, null);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    public void logout() {
        try {
            if (this.isUserValid) {
                this.userIdentifiersForStopPayload.clear();
                getInsiderSharedPreferences().edit().remove(f.p).remove(f.o).apply();
                setUserAttribute("mls", Boolean.FALSE, z3.b);
                Debugger.a(DebuggingTag.logout, 4);
                f3.b("auth", "User logged out.", "{}", "InsiderUser-logout");
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    public void logoutResettingInsiderID(InsiderIdentifiers[] insiderIdentifiersArr) {
        logoutResettingInsiderID(insiderIdentifiersArr, null);
    }

    public InsiderUser setAge(int i) {
        if (i < 0) {
            return this;
        }
        setUserAttribute("ag", Integer.valueOf(i), z3.c);
        return this;
    }

    public InsiderUser setBirthday(Date date) {
        String strA = w4.a(date);
        if (strA == null) {
            return this;
        }
        setUserAttribute("bi", strA, z3.e);
        return this;
    }

    public InsiderUser setCustomAttributeWithArray(String str, String[] strArr) {
        try {
            String[] strArrB = w4.b((Object[]) strArr);
            if (this.isUserValid && strArrB != null && w4.d(str)) {
                setCustomAttribute(str, strArrB, z3.d);
            }
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderUser setCustomAttributeWithBoolean(String str, boolean z) {
        try {
            if (this.isUserValid && w4.d(str)) {
                setCustomAttribute(str, Boolean.valueOf(z), z3.b);
            }
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderUser setCustomAttributeWithDate(String str, Date date) {
        try {
            String strA = w4.a(date);
            if (this.isUserValid && strA != null && w4.d(str)) {
                setCustomAttribute(str, strA, z3.e);
            }
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderUser setCustomAttributeWithDouble(String str, double d) {
        try {
            if (this.isUserValid && w4.d(str)) {
                setCustomAttribute(str, Double.valueOf(d), z3.c);
            }
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderUser setCustomAttributeWithInt(String str, int i) {
        try {
            if (this.isUserValid && w4.d(str)) {
                setCustomAttribute(str, Integer.valueOf(i), z3.c);
            }
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderUser setCustomAttributeWithString(String str, String str2) {
        try {
            if (this.isUserValid && str2 != null && str2.length() != 0 && w4.d(str)) {
                setCustomAttribute(str, str2, z3.f454a);
            }
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderUser setEmail(String str) {
        if (str != null && str.length() != 0 && w4.c(str)) {
            setUserAttribute(EnvironmentData.MUX_EMBED, str, z3.f454a);
            return this;
        }
        Debugger.putLog(DebuggingTag.invalidUserEmail, 4, str);
        f3.b("common", "User email is invalid.", "{ 'email_status': 'invalid', 'email': '" + str + "' }", "InsiderUser-setEmail");
        return this;
    }

    public InsiderUser setEmailOptin(boolean z) {
        setUserAttribute("eo", Boolean.valueOf(z), z3.b);
        return this;
    }

    public InsiderUser setFacebookID(String str) {
        if (str != null && str.length() != 0) {
            setUserAttribute("fid", str, z3.f454a);
        }
        return this;
    }

    public InsiderUser setGender(InsiderGender insiderGender) {
        if (insiderGender == null) {
            return this;
        }
        setUserAttribute("ge", insiderGender.name().toLowerCase(), z3.f454a);
        return this;
    }

    void setIdentifiersAsAttributes(Map<String, String> map) {
        try {
            if (this.isUserValid) {
                for (String str : map.keySet()) {
                    int iHashCode = str.hashCode();
                    if (iHashCode != 3240) {
                        if (iHashCode != 3582) {
                            if (iHashCode == 3601339 && str.equals(InstallationId.LEGACY_PREFERENCES_UUID_KEY)) {
                                setUserAttribute(InstallationId.LEGACY_PREFERENCES_UUID_KEY, map.get(str), z3.f454a);
                            } else {
                                setCustomAttributeWithString(str.replaceFirst("c_", ""), map.get(str));
                            }
                        } else if (str.equals("pn")) {
                            setUserAttribute("pn", map.get(str), z3.f454a);
                        } else {
                            setCustomAttributeWithString(str.replaceFirst("c_", ""), map.get(str));
                        }
                    } else if (str.equals("em")) {
                        setUserAttribute("em", map.get(str), z3.f454a);
                    } else {
                        setCustomAttributeWithString(str.replaceFirst("c_", ""), map.get(str));
                    }
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void setIdentifiersForStopPayload(InsiderIdentifiers insiderIdentifiers) {
        try {
            if (this.isUserValid) {
                this.userIdentifiersForStopPayload = insiderIdentifiers.getIdentifiers();
                Debugger.a(DebuggingTag.setUserIdentifier, 4, insiderIdentifiers.getIdentifiers());
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void setInsiderID(String str) {
        try {
            if (this.isUserValid) {
                this.insiderID = str;
                getInsiderSharedPreferences().edit().putString(f.s, str).apply();
                e3.a(str);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    public InsiderUser setLanguage(String str) {
        if (str != null && str.length() != 0) {
            setUserAttribute("la", str, z3.f454a);
        }
        return this;
    }

    public InsiderUser setLocale(String str) {
        if (str != null && str.length() != 0) {
            setUserAttribute("lo", str, z3.f454a);
        }
        return this;
    }

    public InsiderUser setLocationOptin(boolean z) {
        if (this.isUserValid) {
            Insider.Instance.setLocationOptin(z);
            Debugger.a(DebuggingTag.setLocationOptIn, 4, Boolean.valueOf(z));
            if (w4.o(this.context)) {
                this.deviceAttributes.put("location_enabled", Boolean.valueOf(z));
                e.i = z;
                return this;
            }
            if (z) {
                Debugger.putLog(DebuggingTag.nativeLocationWarning, 4, "");
                f3.c("common", InsiderHybridMethods.SET_LOCATION_OPTIN, "{ 'status': 'failed', 'reason': 'fine_location_or_always_allow_missing' }", "InsiderUser-setLocationOptin");
            }
        }
        return this;
    }

    public InsiderUser setName(String str) {
        if (str != null && str.length() != 0) {
            setUserAttribute("na", str, z3.f454a);
        }
        return this;
    }

    public InsiderUser setPhoneNumber(String str) {
        if (str != null && str.length() != 0 && w4.f(str)) {
            setUserAttribute("mpn", str, z3.f454a);
            return this;
        }
        Debugger.putLog(DebuggingTag.invalidUserPhoneNumber, 4, str);
        f3.b("common", "User phone number is invalid.", "{ 'phone_status': 'invalid', 'phone': '" + str + "' }", "InsiderUser-setPhoneNumber");
        return this;
    }

    public InsiderUser setPushOptin(boolean z) {
        if (this.isUserValid) {
            Insider.Instance.setPushOptin(z);
            Debugger.a(DebuggingTag.setPushOptIn, 4, Boolean.valueOf(z));
            if (w4.r(this.context)) {
                this.deviceAttributes.put("push_enabled", Boolean.valueOf(z));
                return this;
            }
            if (z) {
                Debugger.putLog(DebuggingTag.pushOptinWarning, 4, "");
                f3.c("push", InsiderHybridMethods.SET_PUSH_OPTIN, "{ 'status': 'failed', 'reason': 'native_push_permission_missing' }", "InsiderUser-setPushOptin");
            }
        }
        return this;
    }

    InsiderUser setPushToken(String str) {
        try {
            if (!this.isUserValid) {
                return this;
            }
            this.deviceAttributes.put("device_token", str);
            w4.n(str);
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderUser setSMSOptin(boolean z) {
        setUserAttribute("so", Boolean.valueOf(z), z3.b);
        return this;
    }

    void setSavedIdentifiersForStopPayload(Map<String, String> map) {
        if (this.isUserValid) {
            this.userIdentifiersForStopPayload = map;
        }
    }

    public InsiderUser setSurname(String str) {
        if (str != null && str.length() != 0) {
            setUserAttribute("su", str, z3.f454a);
        }
        return this;
    }

    public InsiderUser setTwitterID(String str) {
        if (str != null && str.length() != 0) {
            setUserAttribute("tid", str, z3.f454a);
        }
        return this;
    }

    void setUserAttribute(String str, Object obj, String str2) {
        try {
            if (this.isUserValid) {
                this.userAttributes.put(str, obj);
                HashMap map = new HashMap();
                map.put("name", str);
                map.put("value", obj);
                map.put("type", str2);
                Debugger.a(DebuggingTag.setUserAttribute, 4, map);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    public InsiderUser setWhatsappOptin(boolean z) {
        setUserAttribute("wbo", Boolean.valueOf(z), z3.b);
        return this;
    }

    public InsiderUser unsetCustomAttribute(String str) {
        try {
            if (this.isUserValid && str != null && w4.d(str)) {
                if (!isItemInTheArray(str, this.unsetCustomAttributes)) {
                    this.unsetCustomAttributes.add(str);
                }
                this.customAttributes.remove(str);
                Debugger.putLog(DebuggingTag.unsetCustomAttribute, 4, str);
            }
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public void logoutResettingInsiderID(InsiderIdentifiers[] insiderIdentifiersArr, InsiderIDResult insiderIDResult) {
        try {
            if (this.isUserValid) {
                Insider.Instance.startSeparationProcess(insiderIdentifiersArr, insiderIDResult);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    InsiderUser(Context context) {
        this.isUserValid = true;
        this.context = context;
        this.deviceAttributes = new ConcurrentHashMap();
        this.customAttributes = new ConcurrentHashMap();
        this.userAttributes = new ConcurrentHashMap();
        this.userIdentifiersForStopPayload = new ConcurrentHashMap();
        this.unsetCustomAttributes = new ArrayList<>();
    }

    public void login(InsiderIdentifiers insiderIdentifiers, InsiderIDResult insiderIDResult) {
        try {
            if (this.isUserValid && insiderIdentifiers != null && insiderIDResult != null && !insiderIdentifiers.getIdentifiers().isEmpty()) {
                if (!areIdentifiersAlreadyCached(insiderIdentifiers).booleanValue()) {
                    Insider.Instance.startUnificationProcessWithSessionProcess(insiderIdentifiers, insiderIDResult);
                } else {
                    if (Insider.Instance.shouldRetryIdentification()) {
                        return;
                    }
                    insiderIDResult.insiderIDResult(getInsiderID());
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
