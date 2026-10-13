package org.h.s;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes11.dex */
public final class i0 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f520a;
    public long b;
    public int c;

    public i0(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new i0(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new i0((Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0046  */
    /* JADX WARN: Code duplicated, block: B:16:0x0053  */
    /* JADX WARN: Code duplicated, block: B:17:0x0055  */
    /* JADX WARN: Code duplicated, block: B:21:0x005b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0075  */
    /* JADX WARN: Code duplicated, block: B:25:0x0078 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:28:0x0098  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003b -> B:12:0x003e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x0075
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.c
            r2 = 1000(0x3e8, double:4.94E-321)
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L1e
            if (r1 != r4) goto L16
            long r6 = r13.b
            org.h.s.h0 r1 = r13.f520a
            kotlin.ResultKt.throwOnFailure(r14)
            goto L3e
        L16:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L1e:
            kotlin.ResultKt.throwOnFailure(r14)
            org.h.s.h0 r14 = new org.h.s.h0
            r14.<init>()
            r1 = r14
        L27:
            org.h.s.c3 r14 = org.h.s.c3.j
            int r14 = r14.d()
            long r6 = (long) r14
            long r6 = r6 * r2
            org.h.s.g0.c = r5
            r13.f520a = r1
            r13.b = r6
            r13.c = r4
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r6, r13)
            if (r14 != r0) goto L3e
            return r0
        L3e:
            org.h.s.c3 r14 = org.h.s.c3.j
            int r8 = r14.d()
            if (r8 == 0) goto La4
            kotlinx.coroutines.CoroutineDispatcher r8 = org.h.s.k0.f529a
            int r14 = r14.d()
            long r8 = (long) r14
            long r8 = r8 * r2
            int r14 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            r8 = 0
            if (r14 > 0) goto L55
            r14 = r4
            goto L56
        L55:
            r14 = r8
        L56:
            java.lang.Long r9 = org.h.s.g0.c
            if (r9 != 0) goto L5b
            goto L75
        L5b:
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.Long r11 = org.h.s.g0.c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            long r11 = r11.longValue()
            long r9 = r9 - r11
            double r9 = (double) r9
            double r6 = (double) r6
            r11 = 4607092346807469998(0x3fefae147ae147ae, double:0.99)
            double r6 = r6 * r11
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 < 0) goto L76
        L75:
            r8 = r4
        L76:
            if (r14 == 0) goto L27
            if (r8 == 0) goto L27
            io.mobileshield.sdk.config.Config r14 = org.h.s.g0.b
            java.lang.String r6 = "endpoint"
            java.lang.String r7 = "/149e9513-01fa-4fb0-aad4-566afd725d1b/2d206a39-8ed7-437e-a3be-862e0f06eea3/mfc"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            java.lang.String r6 = "tpResponseHandler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
            org.h.s.s3 r6 = org.h.s.f1.f506a
            org.h.s.w0 r6 = org.h.s.w0.e0
            r8 = 47
            r9 = 2
            java.lang.String r8 = kotlin.text.StringsKt.substringAfterLast$default(r7, r8, r5, r9, r5)
            org.h.s.f1.a(r6, r8)
            if (r14 == 0) goto L27
            java.lang.String r14 = org.h.s.p2.a(r14, r7)
            r6 = 22
            org.h.s.p2.a(r14, r5, r5, r1, r6)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            goto L27
        La4:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.h.s.i0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
