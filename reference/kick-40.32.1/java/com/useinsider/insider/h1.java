package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f336a;
    private Object b;
    private t2 c = t2.UNDEFINED;
    private u2 d = u2.UNDEFINED;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f337a;

        static {
            int[] iArr = new int[t2.values().length];
            f337a = iArr;
            try {
                iArr[t2.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f337a[t2.NOT_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f337a[t2.GREATER_THAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f337a[t2.GREATER_THAN_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f337a[t2.GREATER_THAN_OR_EQUAL_VERBOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f337a[t2.LESS_THAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f337a[t2.LESS_THAN_OR_EQUAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f337a[t2.LESS_THAN_OR_EQUAL_VERBOSE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f337a[t2.CONTAINS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f337a[t2.DOES_NOT_CONTAIN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f337a[t2.EMPTY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f337a[t2.NOT_EMPTY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f337a[t2.IN_THE_LAST.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f337a[t2.IN_THE_NEXT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f337a[t2.ON_DATE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f337a[t2.BETWEEN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    h1() {
    }

    private g1 b() {
        int i = a.f337a[this.c.ordinal()];
        if (i == 1) {
            return new s1(this.f336a, this.b);
        }
        if (i != 2) {
            return null;
        }
        return new q1(new s1(this.f336a, this.b));
    }

    private g1 c() {
        switch (a.f337a[this.c.ordinal()]) {
            case 1:
                return new w0(this.f336a, this.b);
            case 2:
                return new q1(new w0(this.f336a, this.b));
            case 3:
                return new x0(this.f336a, this.b);
            case 4:
            case 5:
                return new q1(new a1(this.f336a, this.b));
            case 6:
                return new a1(this.f336a, this.b);
            case 7:
            case 8:
                return new q1(new x0(this.f336a, this.b));
            case 9:
            case 10:
            case 11:
            case 12:
            default:
                return null;
            case 13:
                return new y0(this.f336a, this.b);
            case 14:
                return new z0(this.f336a, this.b);
            case 15:
            case 16:
                return new u0(this.f336a, this.b);
        }
    }

    private g1 d() {
        switch (a.f337a[this.c.ordinal()]) {
            case 1:
                return new c1(this.f336a, this.b);
            case 2:
                return new q1(new c1(this.f336a, this.b));
            case 3:
                return new d1(this.f336a, this.b);
            case 4:
            case 5:
                return new q1(new e1(this.f336a, this.b));
            case 6:
                return new e1(this.f336a, this.b);
            case 7:
            case 8:
                return new q1(new d1(this.f336a, this.b));
            default:
                return null;
        }
    }

    private g1 e() {
        int i = a.f337a[this.c.ordinal()];
        if (i == 1) {
            return new l1(this.f336a, this.b);
        }
        if (i != 2) {
            return null;
        }
        return new q1(new l1(this.f336a, this.b));
    }

    private g1 f() {
        int i = a.f337a[this.c.ordinal()];
        if (i == 1) {
            return new j1(this.f336a, this.b);
        }
        if (i == 2) {
            return new q1(new j1(this.f336a, this.b));
        }
        if (i == 9) {
            return new i1(this.f336a, this.b);
        }
        if (i != 10) {
            return null;
        }
        return new q1(new i1(this.f336a, this.b));
    }

    private g1 g() {
        int i = a.f337a[this.c.ordinal()];
        if (i == 1) {
            return new p1(this.f336a, this.b);
        }
        if (i == 2) {
            return new q1(new p1(this.f336a, this.b));
        }
        switch (i) {
            case 9:
                return new n1(this.f336a, this.b);
            case 10:
                return new q1(new n1(this.f336a, this.b));
            case 11:
                return new o1(this.f336a);
            case 12:
                return new q1(new o1(this.f336a));
            default:
                return null;
        }
    }

    h1 a(String str) {
        this.f336a = str;
        return this;
    }

    h1 a(t2 t2Var) {
        this.c = t2Var;
        return this;
    }

    h1 a(Object obj) {
        this.b = obj;
        return this;
    }

    h1 a(u2 u2Var) {
        this.d = u2Var;
        return this;
    }

    g1 a() {
        u2 u2Var = this.d;
        if (u2Var == u2.NUMBER) {
            return d();
        }
        if (u2Var == u2.BOOLEAN) {
            return b();
        }
        if (u2Var == u2.STRING) {
            return f();
        }
        if (u2Var == u2.DATE) {
            return c();
        }
        if (u2Var == u2.STRINGS) {
            return g();
        }
        if (u2Var == u2.NUMBERS) {
            return e();
        }
        return null;
    }
}
