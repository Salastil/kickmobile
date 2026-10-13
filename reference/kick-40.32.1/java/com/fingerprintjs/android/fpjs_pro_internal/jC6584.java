package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class jC6584 {
    private final Lazy vD14832N6715 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.3
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: D8871, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.bu.INSTANCE.component5();
        }
    });
    private final Lazy component5 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.2
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: D8871, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.component8T18414.INSTANCE.component5();
        }
    });
    private final Lazy D8871 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.10
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: component9, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.cr.INSTANCE.component5();
        }
    });
    private final Lazy setPivotYN16904 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.6
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: setPivotYN16904, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.ck.INSTANCE.component5();
        }
    });
    private final Lazy component9 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.7
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: component9, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.bx.INSTANCE.component5();
        }
    });
    private final Lazy sG29839 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.9
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: component9, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.bz.INSTANCE.component5();
        }
    });
    private final Lazy component8 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: component5, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.bc.INSTANCE.component5();
        }
    });
    private final Lazy N14263A23323 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.4
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: vD14832N6715, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.bd.INSTANCE.component5();
        }
    });
    private final Lazy setTopP6481 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.5
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: D8871, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.br.INSTANCE.component5();
        }
    });
    private final Lazy component13 = LazyKt.lazy(new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.jC6584.8
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: D8871, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return I30900.x.INSTANCE.component5();
        }
    });

    public final D8871<byte[], Throwable> vD14832N6715(List<K5264> list) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            List<K5264> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (K5264 k5264 : list2) {
                arrayList.add(MapsKt.mapOf(TuplesKt.to((String) this.vD14832N6715.getValue(), k5264.vD14832N6715), TuplesKt.to((String) this.component5.getValue(), k5264.component9), TuplesKt.to((String) this.D8871.getValue(), k5264.component8), TuplesKt.to((String) this.setPivotYN16904.getValue(), k5264.setTopP6481), TuplesKt.to((String) this.component9.getValue(), k5264.component13), TuplesKt.to((String) this.sG29839.getValue(), k5264.sG29839), TuplesKt.to((String) this.component8.getValue(), k5264.component5), TuplesKt.to((String) this.N14263A23323.getValue(), k5264.setPivotYN16904), TuplesKt.to((String) this.setTopP6481.getValue(), Integer.valueOf(k5264.D8871)), TuplesKt.to((String) this.component13.getValue(), k5264.N14263A23323)));
            }
            objM12684constructorimpl = Result.m12684constructorimpl(new JSONArray((Collection) arrayList).toString().getBytes(Charsets.UTF_8));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        return bb.setPivotYN16904(objM12684constructorimpl);
    }

    public final D8871<List<K5264>, Throwable> vD14832N6715(byte[] bArr) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONArray jSONArray = new JSONArray(new String(bArr, Charsets.UTF_8));
            IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                if (jSONObject != null) {
                    arrayList.add(jSONObject);
                }
            }
            ArrayList<JSONObject> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (JSONObject jSONObject2 : arrayList2) {
                K5264 k5264 = new K5264(ap.vD14832N6715(jSONObject2, (String) this.vD14832N6715.getValue()), ap.vD14832N6715(jSONObject2, (String) this.component5.getValue()), ap.component9(jSONObject2, (String) this.D8871.getValue()), 0, ap.D8871(jSONObject2, (String) this.setPivotYN16904.getValue()), ap.D8871(jSONObject2, (String) this.component9.getValue()), ap.D8871(jSONObject2, (String) this.sG29839.getValue()), ap.D8871(jSONObject2, (String) this.component8.getValue()), ap.D8871(jSONObject2, (String) this.N14263A23323.getValue()), ap.D8871(jSONObject2, (String) this.component13.getValue()), 8, null);
                Integer numComponent9 = ap.component9(jSONObject2, (String) this.setTopP6481.getValue());
                if (numComponent9 != null) {
                    k5264.D8871 = numComponent9.intValue();
                }
                arrayList3.add(k5264);
            }
            objM12684constructorimpl = Result.m12684constructorimpl(arrayList3);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        return bb.setPivotYN16904(objM12684constructorimpl);
    }
}
