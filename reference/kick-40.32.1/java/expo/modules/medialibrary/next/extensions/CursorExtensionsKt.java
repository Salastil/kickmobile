package expo.modules.medialibrary.next.extensions;

import android.database.Cursor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: CursorExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u0002\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0019\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"asIterable", "", "Landroid/database/Cursor;", "asSequence", "Lkotlin/sequences/Sequence;", "getNullableString", "", "columnIndex", "", "getNullableInt", "(Landroid/database/Cursor;I)Ljava/lang/Integer;", "getNullableLong", "", "(Landroid/database/Cursor;I)Ljava/lang/Long;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CursorExtensionsKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.CursorExtensionsKt$asIterable$1, reason: invalid class name */
    /* JADX INFO: compiled from: CursorExtensions.kt */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0096\u0002¨\u0006\u0005"}, d2 = {"expo/modules/medialibrary/next/extensions/CursorExtensionsKt$asIterable$1", "", "Landroid/database/Cursor;", "iterator", "", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterable<Cursor>, KMappedMarker {
        final /* synthetic */ Cursor $this_asIterable;

        AnonymousClass1(Cursor cursor) {
            this.$this_asIterable = cursor;
        }

        @Override // java.lang.Iterable
        public Iterator<Cursor> iterator() {
            return new CursorExtensionsKt$asIterable$1$iterator$1(this.$this_asIterable);
        }
    }

    public static final Iterable<Cursor> asIterable(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        return new AnonymousClass1(cursor);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.CursorExtensionsKt$asSequence$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CursorExtensions.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/database/Cursor;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.extensions.CursorExtensionsKt$asSequence$1", f = "CursorExtensions.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
    static final class C08741 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Cursor>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Cursor $this_asSequence;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08741(Cursor cursor, Continuation<? super C08741> continuation) {
            super(2, continuation);
            this.$this_asSequence = cursor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08741 c08741 = new C08741(this.$this_asSequence, continuation);
            c08741.L$0 = obj;
            return c08741;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Cursor> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C08741) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            while (this.$this_asSequence.moveToNext()) {
                this.L$0 = sequenceScope;
                this.label = 1;
                if (sequenceScope.yield(this.$this_asSequence, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final Sequence<Cursor> asSequence(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        return SequencesKt.sequence(new C08741(cursor, null));
    }

    public static final String getNullableString(Cursor cursor, int i) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        return cursor.getString(i);
    }

    public static final Integer getNullableInt(Cursor cursor, int i) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        if (cursor.isNull(i)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i));
    }

    public static final Long getNullableLong(Cursor cursor, int i) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        if (cursor.isNull(i)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i));
    }
}
