package com.useinsider.insider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q2 f448a = q2.UNDEFINED;
    private List b = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f449a;

        static {
            int[] iArr = new int[q2.values().length];
            f449a = iArr;
            try {
                iArr[q2.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f449a[q2.EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f449a[q2.OR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    y1() {
    }

    private x1 b() {
        if (this.b.isEmpty()) {
            return null;
        }
        return new w1((List) this.b.stream().map(new y1$$ExternalSyntheticLambda0()).collect(Collectors.toList()));
    }

    private x1 c() {
        if (this.b.isEmpty()) {
            return null;
        }
        return ((p2) this.b.get(0)).d();
    }

    private x1 d() {
        if (this.b.isEmpty()) {
            return null;
        }
        return new a2((List) this.b.stream().map(new y1$$ExternalSyntheticLambda0()).collect(Collectors.toList()));
    }

    y1 a(q2 q2Var) {
        this.f448a = q2Var;
        return this;
    }

    y1 a(List list) {
        this.b = list;
        return this;
    }

    x1 a() {
        int i = a.f449a[this.f448a.ordinal()];
        if (i == 1) {
            return b();
        }
        if (i == 2) {
            return c();
        }
        if (i != 3) {
            return null;
        }
        return d();
    }
}
