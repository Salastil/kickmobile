package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class ap {
    public static int D8871;
    public static int vD14832N6715;

    public static final String vD14832N6715(JSONObject jSONObject, String str) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Object obj = jSONObject.get(str);
            objM12684constructorimpl = Result.m12684constructorimpl(obj instanceof String ? (String) obj : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
    }

    public static final Boolean component5(JSONObject jSONObject, String str) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(jSONObject.getBoolean(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        return (Boolean) objM12684constructorimpl;
    }

    public static final Integer component9(JSONObject jSONObject, String str) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(Integer.valueOf(jSONObject.getInt(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        return (Integer) objM12684constructorimpl;
    }

    public static final Long D8871(JSONObject jSONObject, String str) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf(jSONObject.getLong(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        return (Long) objM12684constructorimpl;
    }

    public static int component9() {
        int i = D8871;
        int i2 = i % 8192432;
        D8871 = i + 1;
        if (i2 != 0) {
            return vD14832N6715;
        }
        int iMyTid = Process.myTid();
        vD14832N6715 = iMyTid;
        return iMyTid;
    }
}
