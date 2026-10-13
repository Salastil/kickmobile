package expo.modules.medialibrary.next.objects.query.builder;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import expo.modules.medialibrary.next.exceptions.QueryCouldNotBeExecuted;
import expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt;
import expo.modules.medialibrary.next.records.SortDescriptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: QueryModernExecutor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0019"}, d2 = {"Lexpo/modules/medialibrary/next/objects/query/builder/QueryModernExecutor;", "Lexpo/modules/medialibrary/next/objects/query/builder/QueryExecutor;", "clauses", "", "", "args", "sortDescriptors", "Lexpo/modules/medialibrary/next/records/SortDescriptor;", "limit", "", "offset", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "exe", "Landroid/database/Cursor;", "projection", "", "contentResolver", "Landroid/content/ContentResolver;", "([Ljava/lang/String;Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "build", "Landroid/os/Bundle;", "buildSelection", "buildSortOrder", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class QueryModernExecutor implements QueryExecutor {
    private List<String> args;
    private List<String> clauses;
    private final Integer limit;
    private final Integer offset;
    private final List<SortDescriptor> sortDescriptors;

    public QueryModernExecutor(List<String> clauses, List<String> args, List<SortDescriptor> sortDescriptors, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(clauses, "clauses");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(sortDescriptors, "sortDescriptors");
        this.clauses = clauses;
        this.args = args;
        this.sortDescriptors = sortDescriptors;
        this.limit = num;
        this.offset = num2;
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.query.builder.QueryModernExecutor$exe$2, reason: invalid class name */
    /* JADX INFO: compiled from: QueryModernExecutor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.query.builder.QueryModernExecutor$exe$2", f = "QueryModernExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Cursor>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        final /* synthetic */ String[] $projection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ContentResolver contentResolver, String[] strArr, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$contentResolver = contentResolver;
            this.$projection = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QueryModernExecutor.this.new AnonymousClass2(this.$contentResolver, this.$projection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Cursor> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws QueryCouldNotBeExecuted {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Cursor cursorQuery = this.$contentResolver.query(AlbumExtensionsKt.getEXTERNAL_CONTENT_URI(), this.$projection, QueryModernExecutor.this.build(), null);
                if (cursorQuery != null) {
                    return cursorQuery;
                }
                throw new QueryCouldNotBeExecuted("Cursor is null", null, 2, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // expo.modules.medialibrary.next.objects.query.builder.QueryExecutor
    public Object exe(String[] strArr, ContentResolver contentResolver, Continuation<? super Cursor> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(contentResolver, strArr, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle build() {
        String strBuildSelection = buildSelection();
        String[] strArr = (String[]) this.args.toArray(new String[0]);
        String strBuildSortOrder = buildSortOrder();
        Bundle bundle = new Bundle();
        Integer num = this.limit;
        if (num != null) {
            bundle.putInt("android:query-arg-limit", num.intValue());
        }
        Integer num2 = this.offset;
        if (num2 != null) {
            int iIntValue = num2.intValue();
            if (this.limit == null) {
                bundle.putInt("android:query-arg-limit", -1);
            }
            bundle.putInt("android:query-arg-offset", iIntValue);
        }
        if (strBuildSelection != null) {
            bundle.putString("android:query-arg-sql-selection", strBuildSelection);
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
        }
        if (strBuildSortOrder != null) {
            bundle.putString("android:query-arg-sql-sort-order", strBuildSortOrder);
        }
        return bundle;
    }

    private final String buildSelection() {
        if (this.clauses.isEmpty()) {
            return null;
        }
        return CollectionsKt.joinToString$default(this.clauses, " AND ", null, null, 0, null, null, 62, null);
    }

    private final String buildSortOrder() {
        if (this.sortDescriptors.isEmpty()) {
            return null;
        }
        return CollectionsKt.joinToString$default(this.sortDescriptors, ", ", null, null, 0, null, new Function1() { // from class: expo.modules.medialibrary.next.objects.query.builder.QueryModernExecutor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QueryModernExecutor.buildSortOrder$lambda$5((SortDescriptor) obj);
            }
        }, 30, null);
    }

    static final CharSequence buildSortOrder$lambda$5(SortDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toMediaStoreQueryString();
    }
}
