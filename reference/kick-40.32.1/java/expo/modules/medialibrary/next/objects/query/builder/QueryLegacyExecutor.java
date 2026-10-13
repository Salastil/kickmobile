package expo.modules.medialibrary.next.objects.query.builder;

import android.content.ContentResolver;
import android.database.Cursor;
import expo.modules.medialibrary.next.exceptions.PermissionException;
import expo.modules.medialibrary.next.exceptions.QueryCouldNotBeExecuted;
import expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt;
import expo.modules.medialibrary.next.extensions.resolver.SafeQueryKt;
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

/* JADX INFO: compiled from: QueryLegacyExecutor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u001d"}, d2 = {"Lexpo/modules/medialibrary/next/objects/query/builder/QueryLegacyExecutor;", "Lexpo/modules/medialibrary/next/objects/query/builder/QueryExecutor;", "clauses", "", "", "args", "sortDescriptors", "Lexpo/modules/medialibrary/next/records/SortDescriptor;", "limit", "", "offset", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "exe", "Landroid/database/Cursor;", "projection", "", "contentResolver", "Landroid/content/ContentResolver;", "([Ljava/lang/String;Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildSortOrder", "buildSelection", "buildOrderBy", "addLimit", "sortOrder", "requireNotEmptySortOrder", "addOffset", "orderBy", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class QueryLegacyExecutor implements QueryExecutor {
    private final List<String> args;
    private final List<String> clauses;
    private final Integer limit;
    private final Integer offset;
    private final List<SortDescriptor> sortDescriptors;

    public QueryLegacyExecutor(List<String> clauses, List<String> args, List<SortDescriptor> sortDescriptors, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(clauses, "clauses");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(sortDescriptors, "sortDescriptors");
        this.clauses = clauses;
        this.args = args;
        this.sortDescriptors = sortDescriptors;
        this.limit = num;
        this.offset = num2;
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.query.builder.QueryLegacyExecutor$exe$2, reason: invalid class name */
    /* JADX INFO: compiled from: QueryLegacyExecutor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.query.builder.QueryLegacyExecutor$exe$2", f = "QueryLegacyExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            return QueryLegacyExecutor.this.new AnonymousClass2(this.$contentResolver, this.$projection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Cursor> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws PermissionException, QueryCouldNotBeExecuted {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String strBuildSelection = QueryLegacyExecutor.this.buildSelection();
                String strBuildSortOrder = QueryLegacyExecutor.this.buildSortOrder();
                Cursor cursorSafeQuery = SafeQueryKt.safeQuery(this.$contentResolver, AlbumExtensionsKt.getEXTERNAL_CONTENT_URI(), this.$projection, strBuildSelection, (String[]) QueryLegacyExecutor.this.args.toArray(new String[0]), strBuildSortOrder);
                if (cursorSafeQuery != null) {
                    return cursorSafeQuery;
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
    public final String buildSortOrder() {
        return addOffset(addLimit(buildOrderBy()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildSelection() {
        return CollectionsKt.joinToString$default(this.clauses, " AND ", null, null, 0, null, null, 62, null);
    }

    private final String buildOrderBy() {
        if (this.sortDescriptors.isEmpty()) {
            return null;
        }
        return CollectionsKt.joinToString$default(this.sortDescriptors, ", ", null, null, 0, null, new Function1() { // from class: expo.modules.medialibrary.next.objects.query.builder.QueryLegacyExecutor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QueryLegacyExecutor.buildOrderBy$lambda$0((SortDescriptor) obj);
            }
        }, 30, null);
    }

    static final CharSequence buildOrderBy$lambda$0(SortDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toMediaStoreQueryString();
    }

    private final String addLimit(String sortOrder) {
        if (this.limit != null) {
            return requireNotEmptySortOrder(sortOrder) + " LIMIT " + this.limit;
        }
        if (this.offset == null) {
            return sortOrder == null ? "" : sortOrder;
        }
        return requireNotEmptySortOrder(sortOrder) + " LIMIT -1";
    }

    private final String requireNotEmptySortOrder(String sortOrder) {
        return sortOrder == null ? "_id" : sortOrder;
    }

    private final String addOffset(String orderBy) {
        Integer num = this.offset;
        if (num == null) {
            return orderBy;
        }
        return orderBy + " OFFSET " + num;
    }
}
