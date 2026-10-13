package java8.util.concurrent;

/* JADX INFO: loaded from: classes9.dex */
final class Util {
    private Util() {
    }

    static <T> T requireNonNull(T t) {
        t.getClass();
        return t;
    }
}
