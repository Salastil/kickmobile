package org.h.s;

import android.content.SharedPreferences;
import com.facebook.hermes.intl.Constants;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: loaded from: classes11.dex */
public final class l1 {
    public u0 c;
    public z0 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Mutex f534a = MutexKt.Mutex$default(false, 1, null);
    public PersistentList b = ExtensionsKt.persistentListOf();
    public final d e = l4.a();
    public String f = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0tk6dHeTH1Em5C52QwPhn2xoCWheHa3NSSWOlO2xTLdCIFVAJDNtwcCEkBHMqq8JTH+Z071PySq7Q59skq31u202capq97wQBoJXK786bDo3CM4jRRk/8EWw33uv3lMBVaCtzN/FmuOHdcWH/P+Rn2GT74L2070MxTEZ52ikmYwIDAQAB";
    public String g = "";

    public l1() {
        Dispatchers.getDefault();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(c cVar, b bVar, Continuation continuation) {
        k1 k1Var;
        Mutex mutex;
        z0 z0Var;
        String str;
        List listEmptyList;
        if (continuation instanceof k1) {
            k1Var = (k1) continuation;
            int i = k1Var.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                k1Var.f = i - Integer.MIN_VALUE;
            } else {
                k1Var = new k1(this, continuation);
            }
        } else {
            k1Var = new k1(this, continuation);
        }
        Object obj = k1Var.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = k1Var.f;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.c = bVar;
                    this.d = cVar;
                    if (cVar != null) {
                        mutex = this.f534a;
                        k1Var.f530a = this;
                        k1Var.b = cVar;
                        k1Var.c = mutex;
                        k1Var.f = 1;
                        if (mutex.lock(null, k1Var) == coroutine_suspended) {
                            z0Var = cVar;
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Mutex mutex2 = k1Var.c;
                z0 z0Var2 = k1Var.b;
                l1 l1Var = k1Var.f530a;
                ResultKt.throwOnFailure(obj);
                mutex = mutex2;
                this = l1Var;
                z0Var = z0Var2;
                Json.Companion companion = Json.INSTANCE;
                companion.getSerializersModule();
                listEmptyList = (List) companion.decodeFromString(new ArrayListSerializer(j3.Companion.serializer()), str);
            } catch (Exception unused) {
                listEmptyList = CollectionsKt.emptyList();
            }
            z0Var = cVar;
            w3 w3Var = z0Var.f593a;
            w3Var.getClass();
            Intrinsics.checkNotNullParameter("LS-MS-K", "key");
            SharedPreferences sharedPreferences = w3Var.f586a;
            Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
            Intrinsics.checkNotNullParameter("LS-MS-K", "sharedPrefKey");
            Intrinsics.checkNotNullParameter("", Constants.COLLATION_DEFAULT);
            String string = sharedPreferences.getString("LS-MS-K", "");
            str = string != null ? string : "";
            this.b = ExtensionsKt.toPersistentList(CollectionsKt.plus((Collection) listEmptyList, (Iterable) this.b));
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Continuation continuation) {
        h1 h1Var;
        Mutex mutex;
        if (continuation instanceof h1) {
            h1Var = (h1) continuation;
            int i = h1Var.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                h1Var.e = i - Integer.MIN_VALUE;
            } else {
                h1Var = new h1(this, continuation);
            }
        } else {
            h1Var = new h1(this, continuation);
        }
        Object obj = h1Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = h1Var.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.f534a;
            h1Var.f516a = this;
            h1Var.b = mutex;
            h1Var.e = 1;
            if (mutex.lock(null, h1Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = h1Var.b;
            l1 l1Var = h1Var.f516a;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            this = l1Var;
        }
        try {
            this.b = this.b.clear();
            z0 z0Var = this.d;
            if (z0Var != null) {
                w3 w3Var = z0Var.f593a;
                w3Var.getClass();
                Intrinsics.checkNotNullParameter("LS-MS-K", "key");
                Intrinsics.checkNotNullParameter("", "value");
                v3.a(w3Var.f586a, "", "LS-MS-K");
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(j3 j3Var, Continuation continuation) {
        g1 g1Var;
        Mutex mutex;
        if (continuation instanceof g1) {
            g1Var = (g1) continuation;
            int i = g1Var.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                g1Var.f = i - Integer.MIN_VALUE;
            } else {
                g1Var = new g1(this, continuation);
            }
        } else {
            g1Var = new g1(this, continuation);
        }
        Object obj = g1Var.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = g1Var.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.f534a;
            g1Var.f511a = this;
            g1Var.b = j3Var;
            g1Var.c = mutex;
            g1Var.f = 1;
            if (mutex.lock(null, g1Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = g1Var.c;
            j3Var = g1Var.b;
            l1 l1Var = g1Var.f511a;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            this = l1Var;
        }
        try {
            this.b = this.b.add(j3Var);
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            this.e.f494a.set(true);
            return unit;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    public final String a(Object aesKey) {
        byte[] bArr;
        byte[] bArr2;
        Intrinsics.checkNotNullParameter(aesKey, "aesKey");
        String strA = null;
        Json jsonJson$default = JsonKt.Json$default(null, i1.f521a, 1, null);
        if (this.b.isEmpty()) {
            return null;
        }
        try {
            Pair pairA = x.a(jsonJson$default.encodeToString(new q2(j3.Companion.serializer()), this.b), aesKey);
            String strA2 = (pairA == null || (bArr2 = (byte[]) pairA.getSecond()) == null) ? null : w.a(bArr2);
            if (pairA != null && (bArr = (byte[]) pairA.getFirst()) != null) {
                strA = w.a(bArr);
            }
            String str = strA + ServerSentEventKt.SPACE + x.a(aesKey);
            if (this.g.length() == 0) {
                a();
            }
            String strA3 = x.a(str, this.g);
            if (strA3 == null) {
                strA3 = "Error in preparing data to be sent";
            }
            if (strA2 == null) {
                strA2 = "Error in preparing data to be sent";
            }
            c1 c1Var = new c1(strA3, strA2);
            jsonJson$default.getSerializersModule();
            return jsonJson$default.encodeToString(c1.Companion.serializer(), c1Var);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            c1 c1Var2 = new c1("Exception caught while preparing data", message);
            jsonJson$default.getSerializersModule();
            return jsonJson$default.encodeToString(c1.Companion.serializer(), c1Var2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
    public final void a() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.f;
        u0 u0Var = this.c;
        if (u0Var != null) {
            j1 methodToUpdatePublicKey = new j1(this, objectRef);
            Intrinsics.checkNotNullParameter(methodToUpdatePublicKey, "methodToUpdatePublicKey");
            w3 w3Var = u0Var.f577a;
            w3Var.getClass();
            Intrinsics.checkNotNullParameter("EPK", "key");
            SharedPreferences sharedPreferences = w3Var.f586a;
            Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
            Intrinsics.checkNotNullParameter("EPK", "sharedPrefKey");
            Intrinsics.checkNotNullParameter("", Constants.COLLATION_DEFAULT);
            String string = sharedPreferences.getString("EPK", "");
            methodToUpdatePublicKey.invoke(string != null ? string : "");
        }
        a((String) objectRef.element, false);
    }

    public final void a(String input, boolean z) {
        String string;
        u0 u0Var;
        Intrinsics.checkNotNullParameter(input, "encryptedHeader");
        this.f = input;
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() <= 50) {
            string = new String();
        } else {
            char[] charArray = StringsKt.substring(input, new IntRange(40, 50)).toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            ArrayList arrayList = new ArrayList(charArray.length);
            for (char c : charArray) {
                int i = c ^ 3;
                if (i >= 0 && i <= 65535) {
                    arrayList.add(Character.valueOf((char) i));
                } else {
                    throw new IllegalArgumentException("Invalid Char code: " + i);
                }
            }
            string = StringsKt.replaceRange((CharSequence) input, new IntRange(40, 50), (CharSequence) StringsKt.concatToString(CollectionsKt.toCharArray(arrayList))).toString();
        }
        this.g = string;
        if (!z || (u0Var = this.c) == null) {
            return;
        }
        String value = this.f;
        Intrinsics.checkNotNullParameter(value, "encPublicKey");
        w3 w3Var = u0Var.f577a;
        w3Var.getClass();
        Intrinsics.checkNotNullParameter("EPK", "key");
        Intrinsics.checkNotNullParameter(value, "value");
        v3.a(w3Var.f586a, value, "EPK");
    }
}
