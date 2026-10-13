package com.fingerprintjs.android.fpjs_pro_internal;

import android.util.Log;
import java.util.Iterator;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class setKeepScreenOnI3248 implements setAutofillHintsI14457 {
    @Override // com.fingerprintjs.android.fpjs_pro_internal.setAutofillHintsI14457
    public final void setPivotYN16904(JSONObject jSONObject) throws JSONException {
        jSONObject.toString(2);
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.setAutofillHintsI14457
    public final void component9(Object obj, String str) {
        Iterator it = StringsKt.split$default((CharSequence) (obj.getClass().getCanonicalName() + ": " + str), new char[]{'\n'}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            Log.e("FingerprintJS", (String) it.next());
        }
    }
}
