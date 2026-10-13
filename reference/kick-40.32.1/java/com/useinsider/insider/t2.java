package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
enum t2 {
    EQUAL("eq"),
    NOT_EQUAL("ne"),
    CONTAINS("cnt"),
    DOES_NOT_CONTAIN("dnc"),
    GREATER_THAN("gt"),
    GREATER_THAN_OR_EQUAL("ge"),
    GREATER_THAN_OR_EQUAL_VERBOSE("gte"),
    LESS_THAN("lt"),
    LESS_THAN_OR_EQUAL("le"),
    LESS_THAN_OR_EQUAL_VERBOSE("lte"),
    EMPTY("ie"),
    NOT_EMPTY("ine"),
    IN_THE_LAST("itl"),
    IN_THE_NEXT("itn"),
    ON_DATE("date"),
    BETWEEN("btwn"),
    UNDEFINED("undefined");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f429a;

    t2(String str) {
        this.f429a = str;
    }

    String b() {
        return this.f429a;
    }

    static t2 a(String str) {
        for (t2 t2Var : values()) {
            if (t2Var.f429a.equalsIgnoreCase(str)) {
                return t2Var;
            }
        }
        return UNDEFINED;
    }
}
