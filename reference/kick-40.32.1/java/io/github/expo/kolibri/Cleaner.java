package io.github.expo.kolibri;

import io.ktor.http.LinkHeader;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeCleaner.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J#\u0010\u0013\u001a\u0002H\u0014\"\f\b\u0000\u0010\u0014*\u00060\bR\u00020\u00002\u0006\u0010\u0015\u001a\u0002H\u0014H\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/github/expo/kolibri/Cleaner;", "", "<init>", "()V", "queue", "Ljava/lang/ref/ReferenceQueue;", "lock", "head", "Lio/github/expo/kolibri/Cleaner$Node;", "register", "Lio/github/expo/kolibri/Cleanable;", "obj", "action", "Ljava/lang/Runnable;", "registerPointer", "pointer", "", "free", "Lio/github/expo/kolibri/Cleaner$PointerFree;", "link", "N", "node", "(Lio/github/expo/kolibri/Cleaner$Node;)Lio/github/expo/kolibri/Cleaner$Node;", "startDrainThread", "", "PointerFree", "Node", "ActionNode", "PointerNode", "Companion", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Cleaner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Node head;
    private final Object lock;
    private final ReferenceQueue<Object> queue;

    /* JADX INFO: compiled from: NativeCleaner.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lio/github/expo/kolibri/Cleaner$PointerFree;", "", "free", "", "pointer", "", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface PointerFree {
        void free(long pointer);
    }

    public /* synthetic */ Cleaner(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Cleaner() {
        this.queue = new ReferenceQueue<>();
        this.lock = new Object();
    }

    public final Cleanable register(Object obj, Runnable action) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(action, "action");
        return link(new ActionNode(this, obj, action));
    }

    public final Cleanable registerPointer(Object obj, long pointer, PointerFree free) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(free, "free");
        return link(new PointerNode(this, obj, pointer, free));
    }

    private final <N extends Node> N link(N node) {
        synchronized (this.lock) {
            node.next = this.head;
            Node node2 = this.head;
            if (node2 != null) {
                node2.prev = node;
            }
            this.head = node;
            node.linked = true;
            Unit unit = Unit.INSTANCE;
        }
        return node;
    }

    /* JADX INFO: compiled from: NativeCleaner.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b¢\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH$R\u0018\u0010\u0007\u001a\b\u0018\u00010\u0000R\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\b\u0018\u00010\u0000R\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/github/expo/kolibri/Cleaner$Node;", "Ljava/lang/ref/PhantomReference;", "", "Lio/github/expo/kolibri/Cleanable;", "referent", "<init>", "(Lio/github/expo/kolibri/Cleaner;Ljava/lang/Object;)V", "prev", "Lio/github/expo/kolibri/Cleaner;", LinkHeader.Rel.Next, "getNext$annotations", "()V", "linked", "", "clean", "", "perform", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private abstract class Node extends PhantomReference<Object> implements Cleanable {
        public boolean linked;
        public Node next;
        public Node prev;
        final /* synthetic */ Cleaner this$0;

        public static /* synthetic */ void getNext$annotations() {
        }

        protected abstract void perform();

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Node(Cleaner cleaner, Object referent) {
            super(referent, cleaner.queue);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.this$0 = cleaner;
        }

        @Override // io.github.expo.kolibri.Cleanable
        public final void clean() {
            Object obj = this.this$0.lock;
            Cleaner cleaner = this.this$0;
            synchronized (obj) {
                if (this.linked) {
                    this.linked = false;
                    Node node = this.prev;
                    if (node != null) {
                        node.next = this.next;
                    }
                    Node node2 = this.next;
                    if (node2 != null) {
                        node2.prev = node;
                    }
                    if (cleaner.head == this) {
                        cleaner.head = this.next;
                    }
                    this.prev = null;
                    this.next = null;
                    Unit unit = Unit.INSTANCE;
                    clear();
                    perform();
                }
            }
        }
    }

    /* JADX INFO: compiled from: NativeCleaner.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/github/expo/kolibri/Cleaner$ActionNode;", "Lio/github/expo/kolibri/Cleaner$Node;", "Lio/github/expo/kolibri/Cleaner;", "referent", "", "action", "Ljava/lang/Runnable;", "<init>", "(Lio/github/expo/kolibri/Cleaner;Ljava/lang/Object;Ljava/lang/Runnable;)V", "perform", "", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class ActionNode extends Node {
        private final Runnable action;
        final /* synthetic */ Cleaner this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionNode(Cleaner cleaner, Object referent, Runnable action) {
            super(cleaner, referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            Intrinsics.checkNotNullParameter(action, "action");
            this.this$0 = cleaner;
            this.action = action;
        }

        @Override // io.github.expo.kolibri.Cleaner.Node
        protected void perform() {
            this.action.run();
        }
    }

    /* JADX INFO: compiled from: NativeCleaner.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/github/expo/kolibri/Cleaner$PointerNode;", "Lio/github/expo/kolibri/Cleaner$Node;", "Lio/github/expo/kolibri/Cleaner;", "referent", "", "pointer", "", "free", "Lio/github/expo/kolibri/Cleaner$PointerFree;", "<init>", "(Lio/github/expo/kolibri/Cleaner;Ljava/lang/Object;JLio/github/expo/kolibri/Cleaner$PointerFree;)V", "perform", "", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class PointerNode extends Node {
        private final PointerFree free;
        private long pointer;
        final /* synthetic */ Cleaner this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PointerNode(Cleaner cleaner, Object referent, long j, PointerFree free) {
            super(cleaner, referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            Intrinsics.checkNotNullParameter(free, "free");
            this.this$0 = cleaner;
            this.pointer = j;
            this.free = free;
        }

        @Override // io.github.expo.kolibri.Cleaner.Node
        protected void perform() {
            long j = this.pointer;
            this.pointer = 0L;
            this.free.free(j);
        }
    }

    /* JADX INFO: compiled from: NativeCleaner.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lio/github/expo/kolibri/Cleaner$Companion;", "", "<init>", "()V", "create", "Lio/github/expo/kolibri/Cleaner;", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Cleaner create() {
            Cleaner cleaner = new Cleaner(null);
            cleaner.startDrainThread();
            return cleaner;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDrainThread() {
        Thread thread = new Thread(new Runnable() { // from class: io.github.expo.kolibri.Cleaner$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Cleaner.startDrainThread$lambda$1(this.f$0);
            }
        }, "kolibri-cleaner");
        thread.setDaemon(true);
        thread.start();
    }

    static final void startDrainThread$lambda$1(Cleaner cleaner) {
        while (true) {
            try {
                Object objRemove = cleaner.queue.remove();
                Intrinsics.checkNotNull(objRemove, "null cannot be cast to non-null type io.github.expo.kolibri.Cleanable");
                ((Cleanable) objRemove).clean();
            } catch (Throwable unused) {
            }
        }
    }
}
