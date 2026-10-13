package expo.modules.ui;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyItemsView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001BT\u0012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\fJ4\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001eJ\u0016\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0001J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0004J\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\nJ\u001e\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001eH\u0002J\b\u0010'\u001a\u00020\nH\u0002RS\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lexpo/modules/ui/LazyItemsWindow;", "", "send", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "first", "last", "revision", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "handler", "Landroid/os/Handler;", "appeared", "", "", "tokens", "sizes", "crossAxisSize", "pending", "", "lastSent", "Lkotlin/Triple;", "appear", "key", FirebaseAnalytics.Param.INDEX, "token", UserMetadata.KEYDATA_FILENAME, "", "disappear", ContentDisposition.Parameters.Size, "fallback", "measure", "updateCrossAxisSize", "cancel", "reset", "newRevision", "schedule", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LazyItemsWindow {
    public static final int $stable = 8;
    private final Map<String, Integer> appeared;
    private int crossAxisSize;
    private final Handler handler;
    private Triple<Integer, Integer, Integer> lastSent;
    private boolean pending;
    private int revision;
    private final Function3<Integer, Integer, Integer, Unit> send;
    private final Map<String, Integer> sizes;
    private final Map<String, Object> tokens;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyItemsWindow(Function3<? super Integer, ? super Integer, ? super Integer, Unit> send) {
        Intrinsics.checkNotNullParameter(send, "send");
        this.send = send;
        this.handler = new Handler(Looper.getMainLooper());
        this.appeared = new LinkedHashMap();
        this.tokens = new LinkedHashMap();
        this.sizes = new LinkedHashMap();
        this.revision = -1;
    }

    public final void appear(String key, int index, Object token, int revision, List<String> keys) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(keys, "keys");
        reset(revision, keys);
        if (index < 0 || index >= keys.size() || !Intrinsics.areEqual(keys.get(index), key)) {
            return;
        }
        this.appeared.put(key, Integer.valueOf(index));
        this.tokens.put(key, token);
        schedule();
    }

    public final void disappear(String key, Object token) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(token, "token");
        if (this.tokens.get(key) != token) {
            return;
        }
        this.appeared.remove(key);
        this.tokens.remove(key);
        if (this.appeared.isEmpty()) {
            this.lastSent = null;
        }
        schedule();
    }

    public final int size(String key, int fallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Integer num = this.sizes.get(key);
        return num != null ? num.intValue() : fallback;
    }

    public final void measure(String key, int size, int revision) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (revision != this.revision || size <= 0) {
            return;
        }
        this.sizes.put(key, Integer.valueOf(size));
    }

    public final void updateCrossAxisSize(int size) {
        int i = this.crossAxisSize;
        if (size == i) {
            return;
        }
        if (i > 0) {
            this.sizes.clear();
        }
        this.crossAxisSize = size;
    }

    public final void cancel() {
        this.handler.removeCallbacksAndMessages(null);
        this.pending = false;
    }

    private final void reset(int newRevision, List<String> keys) {
        if (this.revision == newRevision) {
            return;
        }
        this.revision = newRevision;
        this.sizes.clear();
        final HashMap map = new HashMap(keys.size());
        int i = 0;
        for (Object obj : keys) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            map.put((String) obj, Integer.valueOf(i));
            i = i2;
        }
        Set<String> setKeySet = this.appeared.keySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setKeySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.appeared.clear();
                MapsKt.putAll(this.appeared, arrayList);
                CollectionsKt.retainAll(this.tokens.keySet(), new Function1() { // from class: expo.modules.ui.LazyItemsWindow$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(LazyItemsWindow.reset$lambda$3(map, (String) obj2));
                    }
                });
                this.lastSent = null;
                schedule();
                return;
            }
            String str = (String) it.next();
            Integer num = (Integer) map.get(str);
            Pair pair = num != null ? TuplesKt.to(str, Integer.valueOf(num.intValue())) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
    }

    static final boolean reset$lambda$3(HashMap map, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return map.containsKey(it);
    }

    private final void schedule() {
        if (this.pending) {
            return;
        }
        this.pending = true;
        this.handler.post(new Runnable() { // from class: expo.modules.ui.LazyItemsWindow$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LazyItemsWindow.schedule$lambda$4(this.f$0);
            }
        });
    }

    static final void schedule$lambda$4(LazyItemsWindow lazyItemsWindow) {
        lazyItemsWindow.pending = false;
        Integer num = (Integer) CollectionsKt.minOrNull((Iterable) lazyItemsWindow.appeared.values());
        if (num != null) {
            num.intValue();
            Integer num2 = (Integer) CollectionsKt.maxOrNull((Iterable) lazyItemsWindow.appeared.values());
            if (num2 != null) {
                num2.intValue();
                Triple<Integer, Integer, Integer> triple = new Triple<>(num, num2, Integer.valueOf(lazyItemsWindow.revision));
                if (Intrinsics.areEqual(triple, lazyItemsWindow.lastSent)) {
                    return;
                }
                lazyItemsWindow.lastSent = triple;
                lazyItemsWindow.send.invoke(num, num2, Integer.valueOf(lazyItemsWindow.revision));
            }
        }
    }
}
