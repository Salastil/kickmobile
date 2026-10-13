package com.fingerprintjs.android.fpjs_pro_internal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJG\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0017¢\u0006\u0004\b\u0011\u0010\u0012Jg\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00142\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00152\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010 R\u0016\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010!"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/bq;", "Lcom/fingerprintjs/android/fpjs_pro_internal/bn;", "Lcom/fingerprintjs/android/fpjs_pro_internal/setAutofillHintsI14457;", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/ca;", "p1", "Ljavax/net/ssl/SSLSocketFactory;", "p2", "<init>", "(Lcom/fingerprintjs/android/fpjs_pro_internal/setAutofillHintsI14457;Lcom/fingerprintjs/android/fpjs_pro_internal/ca;Ljavax/net/ssl/SSLSocketFactory;)V", "Lcom/fingerprintjs/android/fpjs_pro_internal/bp;", "", "Lkotlin/Function0;", "", "p3", "p4", "Lcom/fingerprintjs/android/fpjs_pro_internal/bo;", "component5", "(Lcom/fingerprintjs/android/fpjs_pro_internal/bp;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/fingerprintjs/android/fpjs_pro_internal/bo;", "", "Lcom/fingerprintjs/android/fpjs_pro_internal/bm;", "", "Lkotlin/Function1;", "Lcom/fingerprintjs/android/fpjs_pro_internal/bj;", "", "p5", "Lkotlin/Pair;", "", "component9", "(Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro_internal/bm;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Ljava/lang/Integer;)Lkotlin/Pair;", "vD14832N6715", "Lcom/fingerprintjs/android/fpjs_pro_internal/setAutofillHintsI14457;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ca;", "Ljavax/net/ssl/SSLSocketFactory;", "D8871"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class bq implements bn {

    /* JADX INFO: renamed from: D8871, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ca component5;

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    private final SSLSocketFactory D8871;
    private final setAutofillHintsI14457 vD14832N6715;

    private bq(setAutofillHintsI14457 setautofillhintsi14457, ca caVar, SSLSocketFactory sSLSocketFactory) {
        this.vD14832N6715 = setautofillhintsi14457;
        this.component5 = caVar;
        this.D8871 = sSLSocketFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fingerprintjs.android.fpjs_pro_internal.bn
    public final bo component5(final bp p0, Integer p1, Integer p2, Function0<Unit> p3, Function0<Unit> p4) {
        bq bqVar;
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        bo boVar;
        p3.invoke();
        try {
            Result.Companion companion = Result.INSTANCE;
            bqVar = this;
            try {
                objM12684constructorimpl = Result.m12684constructorimpl(bqVar.component9(p0.component5(), p0.setPivotYN16904(), p0.vD14832N6715(), new Function1<bj, byte[]>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.bq.3
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: component5, reason: merged with bridge method [inline-methods] */
                    public final byte[] invoke(bj bjVar) {
                        byte[] bArrComponent5;
                        JSONObject jSONObject = new JSONObject(p0.vD14832N6715(bjVar));
                        this.vD14832N6715.setPivotYN16904(jSONObject);
                        byte[] bytes = jSONObject.toString().getBytes(Charsets.UTF_8);
                        ca caVar = this.component5;
                        return (caVar == null || (bArrComponent5 = caVar.component5(bytes)) == null) ? bytes : bArrComponent5;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }
                }, p1, p2));
            } catch (Throwable th) {
                th = th;
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            th = th2;
            bqVar = this;
        }
        D8871 pivotYN16904 = bb.setPivotYN16904(objM12684constructorimpl);
        p4.invoke();
        if (pivotYN16904 instanceof vD14832N6715) {
            Pair pair = (Pair) ((vD14832N6715) pivotYN16904).setPivotYN16904;
            byte[] bArr = (byte[]) pair.component1();
            try {
                Result.Companion companion3 = Result.INSTANCE;
                ca caVar = bqVar.component5;
                if (caVar != null) {
                    byte[] bArrComponent9 = caVar.component9(bArr);
                    if (bArrComponent9.length == 0) {
                        boVar = new bo(bArr);
                    } else {
                        boVar = new bo(bArrComponent9);
                    }
                } else {
                    boVar = new bo(bArr);
                }
                objM12684constructorimpl2 = Result.m12684constructorimpl(boVar);
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            pivotYN16904 = bb.setPivotYN16904(objM12684constructorimpl2);
        } else if (!(pivotYN16904 instanceof setPivotYN16904)) {
            throw new NoWhenBranchMatchedException();
        }
        return (bo) component9.component9(pivotYN16904, new bo(null));
    }

    private final Pair<byte[], Boolean> component9(String p0, bm p1, Map<String, String> p2, Function1<? super bj, byte[]> p3, Integer p4, Integer p5) throws Exception {
        Object objM12684constructorimpl;
        DataInputStream dataInputStream;
        List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{p4, p5});
        if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
            for (Integer num : listListOf) {
                if (num != null && num.intValue() <= 0) {
                    throw new Exception();
                }
            }
        }
        URLConnection uRLConnectionOpenConnection = new URL(p0).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        if (p4 != null) {
            httpsURLConnection.setConnectTimeout(p4.intValue());
        }
        if (p5 != null) {
            httpsURLConnection.setReadTimeout(p5.intValue());
        }
        SSLSocketFactory sSLSocketFactory = this.D8871;
        if (sSLSocketFactory != null) {
            httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
        }
        for (String str : p2.keySet()) {
            p2.get(str);
            httpsURLConnection.setRequestProperty(str, p2.get(str));
        }
        boolean z = true;
        if (Intrinsics.areEqual(p1, bm.vD14832N6715.INSTANCE)) {
            httpsURLConnection.setRequestMethod(I30900.ac.INSTANCE.component5());
        } else if (Intrinsics.areEqual(p1, bm.component5.INSTANCE)) {
            httpsURLConnection.setRequestMethod(I30900.bo.INSTANCE.component5());
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.connect();
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(httpsURLConnection.getServerCertificates());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            byte[] bArrInvoke = p3.invoke(new bj((Certificate[]) component9.component9(bb.setPivotYN16904(objM12684constructorimpl), null)));
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            dataOutputStream.write(bArrInvoke);
            dataOutputStream.flush();
        }
        httpsURLConnection.getResponseCode();
        if (httpsURLConnection.getResponseCode() != 200) {
            dataInputStream = httpsURLConnection.getErrorStream();
            if (dataInputStream == null) {
                dataInputStream = httpsURLConnection.getInputStream();
                Intrinsics.checkNotNull(dataInputStream);
            }
        } else {
            dataInputStream = new DataInputStream(httpsURLConnection.getInputStream());
            z = false;
        }
        InputStream inputStream = dataInputStream;
        try {
            byte[] bytes = ByteStreamsKt.readBytes(inputStream);
            new String(bytes, Charsets.UTF_8);
            Pair<byte[], Boolean> pair = new Pair<>(bytes, Boolean.valueOf(z));
            CloseableKt.closeFinally(inputStream, null);
            return pair;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(inputStream, th2);
                throw th3;
            }
        }
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.bq$D8871, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/bq$D8871;", "", "<init>", "()V", "Lcom/fingerprintjs/android/fpjs_pro_internal/setAutofillHintsI14457;", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/ca;", "p1", "Lcom/fingerprintjs/android/fpjs_pro_internal/bq;", "setPivotYN16904", "(Lcom/fingerprintjs/android/fpjs_pro_internal/setAutofillHintsI14457;Lcom/fingerprintjs/android/fpjs_pro_internal/ca;)Lcom/fingerprintjs/android/fpjs_pro_internal/bq;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static bq setPivotYN16904(setAutofillHintsI14457 p0, ca p1) {
            return new bq(p0, p1, null, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ bq(setAutofillHintsI14457 setautofillhintsi14457, ca caVar, SSLSocketFactory sSLSocketFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(setautofillhintsi14457, caVar, sSLSocketFactory);
    }
}
