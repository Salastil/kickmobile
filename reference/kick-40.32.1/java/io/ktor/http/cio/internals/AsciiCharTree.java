package io.ktor.http.cio.internals;

import android.R;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsciiCharTree.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u0000 \u0017*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\u0018\u0017B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006JS\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/internals/AsciiCharTree;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/http/cio/internals/AsciiCharTree$Node;", CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID, "<init>", "(Lio/ktor/http/cio/internals/AsciiCharTree$Node;)V", "", "sequence", "", "fromIdx", ViewProps.END, "", "lowerCase", "Lkotlin/Function2;", "", "stopPredicate", "", "search", "(Ljava/lang/CharSequence;IIZLkotlin/jvm/functions/Function2;)Ljava/util/List;", "Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "getRoot", "()Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "Companion", "Node", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AsciiCharTree<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Node<T> root;

    /* JADX INFO: compiled from: AsciiCharTree.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u0005¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0010\u0010\u000fR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00000\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/http/cio/internals/AsciiCharTree$Node;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "ch", "", "exact", "children", "<init>", "(CLjava/util/List;Ljava/util/List;)V", "C", "getCh", "()C", "Ljava/util/List;", "getExact", "()Ljava/util/List;", "getChildren", "", "array", "[Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "getArray", "()[Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Node<T> {
        private final Node<T>[] array;
        private final char ch;
        private final List<Node<T>> children;
        private final List<T> exact;

        /* JADX WARN: Multi-variable type inference failed */
        public Node(char c, List<? extends T> exact, List<Node<T>> children) {
            Intrinsics.checkNotNullParameter(exact, "exact");
            Intrinsics.checkNotNullParameter(children, "children");
            this.ch = c;
            this.exact = exact;
            this.children = children;
            Node<T>[] nodeArr = new Node[256];
            for (int i = 0; i < 256; i++) {
                Iterator<T> it = this.children.iterator();
                Node<T> node = null;
                boolean z = false;
                Node<T> node2 = null;
                while (true) {
                    if (!it.hasNext()) {
                        if (!z) {
                            break;
                        }
                        node = node2;
                        break;
                    } else {
                        T next = it.next();
                        if (((Node) next).ch == i) {
                            if (z) {
                                break;
                            }
                            z = true;
                            node2 = next;
                        }
                    }
                }
                nodeArr[i] = node;
            }
            this.array = nodeArr;
        }

        public final char getCh() {
            return this.ch;
        }

        public final List<Node<T>> getChildren() {
            return this.children;
        }

        public final List<T> getExact() {
            return this.exact;
        }

        public final Node<T>[] getArray() {
            return this.array;
        }
    }

    public AsciiCharTree(Node<T> root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
    }

    public final Node<T> getRoot() {
        return this.root;
    }

    public static /* synthetic */ List search$default(AsciiCharTree asciiCharTree, CharSequence charSequence, int i, int i2, boolean z, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            z = false;
        }
        return asciiCharTree.search(charSequence, i, i2, z, function2);
    }

    public final List<T> search(CharSequence sequence, int fromIdx, int end, boolean lowerCase, Function2<? super Character, ? super Integer, Boolean> stopPredicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(stopPredicate, "stopPredicate");
        if (sequence.length() == 0) {
            throw new IllegalArgumentException("Couldn't search in char tree for empty string");
        }
        Node<T> node = this.root;
        while (fromIdx < end) {
            char cCharAt = sequence.charAt(fromIdx);
            if (stopPredicate.invoke(Character.valueOf(cCharAt), Integer.valueOf(cCharAt)).booleanValue()) {
                break;
            }
            Node<T> node2 = node.getArray()[cCharAt];
            if (node2 == null) {
                node = lowerCase ? node.getArray()[Character.toLowerCase(cCharAt)] : null;
                if (node == null) {
                    return CollectionsKt.emptyList();
                }
            } else {
                node = node2;
            }
            fromIdx++;
        }
        return node.getExact();
    }

    /* JADX INFO: compiled from: AsciiCharTree.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\b\b\u0001\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\t\u0010\nJY\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\b\b\u0001\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\t\u0010\u0011Jy\u0010\t\u001a\u00020\u0017\"\b\b\u0001\u0010\u0005*\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00130\u00122\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\t\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/internals/AsciiCharTree$Companion;", "", "<init>", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "", Constants.MessagePayloadKeys.FROM, "Lio/ktor/http/cio/internals/AsciiCharTree;", "build", "(Ljava/util/List;)Lio/ktor/http/cio/internals/AsciiCharTree;", "Lkotlin/Function1;", "", "length", "Lkotlin/Function2;", "", "charAt", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lio/ktor/http/cio/internals/AsciiCharTree;", "", "Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "resultList", "maxLength", "idx", "", "(Ljava/util/List;Ljava/util/List;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static final int build$lambda$0(CharSequence it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.length();
        }

        static final char build$lambda$1(CharSequence s, int i) {
            Intrinsics.checkNotNullParameter(s, "s");
            return s.charAt(i);
        }

        public final <T extends CharSequence> AsciiCharTree<T> build(List<? extends T> from) {
            Intrinsics.checkNotNullParameter(from, "from");
            return build(from, new Function1() { // from class: io.ktor.http.cio.internals.AsciiCharTree$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(AsciiCharTree.Companion.build$lambda$0((CharSequence) obj));
                }
            }, new Function2() { // from class: io.ktor.http.cio.internals.AsciiCharTree$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Character.valueOf(AsciiCharTree.Companion.build$lambda$1((CharSequence) obj, ((Integer) obj2).intValue()));
                }
            });
        }

        public final <T> AsciiCharTree<T> build(List<? extends T> from, Function1<? super T, Integer> length, Function2<? super T, ? super Integer, Character> charAt) {
            R r;
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(length, "length");
            Intrinsics.checkNotNullParameter(charAt, "charAt");
            List<? extends T> list = from;
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                T next = it.next();
                if (it.hasNext()) {
                    Integer numInvoke = length.invoke(next);
                    do {
                        T next2 = it.next();
                        Integer numInvoke2 = length.invoke(next2);
                        if (numInvoke.compareTo(numInvoke2) < 0) {
                            next = next2;
                            numInvoke = numInvoke2;
                        }
                    } while (it.hasNext());
                }
                r = next;
            } else {
                r = null;
            }
            if (r != null) {
                int iIntValue = length.invoke(r).intValue();
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (length.invoke(it2.next()).intValue() == 0) {
                            throw new IllegalArgumentException("There should be no empty entries");
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                build(arrayList2, from, iIntValue, 0, length, charAt);
                arrayList.trimToSize();
                return new AsciiCharTree<>(new Node((char) 0, CollectionsKt.emptyList(), arrayList2));
            }
            throw new NoSuchElementException("Unable to build char tree from an empty list");
        }

        private final <T> void build(List<Node<T>> resultList, List<? extends T> from, int maxLength, int idx, Function1<? super T, Integer> length, Function2<? super T, ? super Integer, Character> charAt) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T t : from) {
                Character chInvoke = charAt.invoke(t, Integer.valueOf(idx));
                chInvoke.charValue();
                Object obj = linkedHashMap.get(chInvoke);
                if (obj == null) {
                    obj = (List) new ArrayList();
                    linkedHashMap.put(chInvoke, obj);
                }
                ((List) obj).add(t);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                char cCharValue = ((Character) entry.getKey()).charValue();
                List list = (List) entry.getValue();
                int i = idx + 1;
                ArrayList arrayList = new ArrayList();
                Companion companion = AsciiCharTree.INSTANCE;
                ArrayList arrayList2 = arrayList;
                List list2 = list;
                ArrayList arrayList3 = new ArrayList();
                for (T t2 : list2) {
                    if (length.invoke(t2).intValue() > i) {
                        arrayList3.add(t2);
                    }
                }
                int i2 = maxLength;
                Function1<? super T, Integer> function1 = length;
                Function2<? super T, ? super Integer, Character> function2 = charAt;
                companion.build(arrayList2, arrayList3, i2, i, function1, function2);
                arrayList.trimToSize();
                ArrayList arrayList4 = new ArrayList();
                for (T t3 : list2) {
                    if (function1.invoke(t3).intValue() == i) {
                        arrayList4.add(t3);
                    }
                }
                resultList.add(new Node<>(cCharValue, arrayList4, arrayList2));
                maxLength = i2;
                length = function1;
                charAt = function2;
            }
        }
    }
}
