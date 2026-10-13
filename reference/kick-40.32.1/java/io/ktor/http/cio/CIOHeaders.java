package io.ktor.http.cio;

import io.ktor.http.Headers;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: CIOHeaders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\u00130\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u0014\u0010\u001a\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006\u001c"}, d2 = {"Lio/ktor/http/cio/CIOHeaders;", "Lio/ktor/http/Headers;", "Lio/ktor/http/cio/HttpHeadersMap;", "headers", "<init>", "(Lio/ktor/http/cio/HttpHeadersMap;)V", "", "", "names", "()Ljava/util/Set;", "name", "get", "(Ljava/lang/String;)Ljava/lang/String;", "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "isEmpty", "()Z", "", "entries", "Lio/ktor/http/cio/HttpHeadersMap;", "names$delegate", "Lkotlin/Lazy;", "getNames", "getCaseInsensitiveName", "caseInsensitiveName", "Entry", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CIOHeaders implements Headers {
    private final HttpHeadersMap headers;

    /* JADX INFO: renamed from: names$delegate, reason: from kotlin metadata */
    private final Lazy names;

    @Override // io.ktor.util.StringValues
    public boolean getCaseInsensitiveName() {
        return true;
    }

    public CIOHeaders(HttpHeadersMap headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
        this.names = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: io.ktor.http.cio.CIOHeaders$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CIOHeaders.names_delegate$lambda$0(this.f$0);
            }
        });
    }

    @Override // io.ktor.util.StringValues
    public /* bridge */ boolean contains(String str) {
        return super.contains(str);
    }

    @Override // io.ktor.util.StringValues
    public /* bridge */ boolean contains(String str, String str2) {
        return super.contains(str, str2);
    }

    @Override // io.ktor.util.StringValues
    public /* bridge */ void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
        super.forEach(function2);
    }

    private final Set<String> getNames() {
        return (Set) this.names.getValue();
    }

    static final LinkedHashSet names_delegate$lambda$0(CIOHeaders cIOHeaders) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(cIOHeaders.headers.getSize());
        Iterator<Integer> it = cIOHeaders.headers.offsets().iterator();
        while (it.hasNext()) {
            linkedHashSet.add(cIOHeaders.headers.nameAtOffset(it.next().intValue()).toString());
        }
        return linkedHashSet;
    }

    @Override // io.ktor.util.StringValues
    public Set<String> names() {
        return getNames();
    }

    @Override // io.ktor.util.StringValues
    public String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        CharSequence charSequence = this.headers.get(name);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    static final String getAll$lambda$0(CharSequence it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }

    @Override // io.ktor.util.StringValues
    public List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<String> list = SequencesKt.toList(SequencesKt.map(this.headers.getAll(name), new Function1() { // from class: io.ktor.http.cio.CIOHeaders$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CIOHeaders.getAll$lambda$0((CharSequence) obj);
            }
        }));
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return this.headers.getSize() == 0;
    }

    static final Entry entries$lambda$0(CIOHeaders cIOHeaders, int i) {
        return cIOHeaders.new Entry(i);
    }

    @Override // io.ktor.util.StringValues
    public Set<Map.Entry<String, List<String>>> entries() {
        return SequencesKt.toSet(SequencesKt.map(this.headers.offsets(), new Function1() { // from class: io.ktor.http.cio.CIOHeaders$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CIOHeaders.entries$lambda$0(this.f$0, ((Integer) obj).intValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CIOHeaders.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0015\u0010\u000b\u001a\u00020\u00028VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lio/ktor/http/cio/CIOHeaders$Entry;", "", "", "", "", "offset", "<init>", "(Lio/ktor/http/cio/CIOHeaders;I)V", "I", "getKey", "()Ljava/lang/String;", "key", "getValue", "()Ljava/util/List;", "value", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    final class Entry implements Map.Entry<String, List<? extends String>>, KMappedMarker {
        private final int offset;

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ List<? extends String> setValue(List<? extends String> list) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: setValue, reason: avoid collision after fix types in other method */
        public List<String> setValue2(List<String> list) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Entry(int i) {
            this.offset = i;
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return CIOHeaders.this.headers.nameAtOffset(this.offset).toString();
        }

        @Override // java.util.Map.Entry
        public List<? extends String> getValue() {
            return CollectionsKt.listOf(CIOHeaders.this.headers.valueAtOffset(this.offset).toString());
        }
    }
}
