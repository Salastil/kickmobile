package expo.modules.medialibrary.next.objects.query;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.medialibrary.next.extensions.CursorExtensionsKt;
import expo.modules.medialibrary.next.objects.album.Album;
import expo.modules.medialibrary.next.objects.asset.Asset;
import expo.modules.medialibrary.next.objects.asset.AssetMapper;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreFile;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreFileColumnIndexes;
import expo.modules.medialibrary.next.objects.asset.factories.AssetFactory;
import expo.modules.medialibrary.next.objects.query.builder.QueryLegacyExecutor;
import expo.modules.medialibrary.next.objects.query.builder.QueryModernExecutor;
import expo.modules.medialibrary.next.records.AssetField;
import expo.modules.medialibrary.next.records.AssetMetadata;
import expo.modules.medialibrary.next.records.SortDescriptor;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Query.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u001c\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120 J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u0016\u0010\"\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u0016\u0010#\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u0016\u0010$\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0017J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0015J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0 H\u0086@¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0 H\u0086@¢\u0006\u0002\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006."}, d2 = {"Lexpo/modules/medialibrary/next/objects/query/Query;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "assetFactory", "Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "assetMapper", "Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "contentResolver", "Landroid/content/ContentResolver;", "<init>", "(Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;Landroid/content/ContentResolver;)V", "getAssetFactory", "()Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "getAssetMapper", "()Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "getContentResolver", "()Landroid/content/ContentResolver;", "clauses", "", "", "args", "orderBy", "Lexpo/modules/medialibrary/next/records/SortDescriptor;", "limit", "", "Ljava/lang/Integer;", "offset", "eq", "field", "Lexpo/modules/medialibrary/next/records/AssetField;", "value", "within", "values", "", "gt", "gte", "lt", "lte", "album", "Lexpo/modules/medialibrary/next/objects/album/Album;", "count", "descriptor", "exe", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exeForMetadata", "Lexpo/modules/medialibrary/next/records/AssetMetadata;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Query extends SharedObject {
    private final List<String> args;
    private final AssetFactory assetFactory;
    private final AssetMapper assetMapper;
    private final List<String> clauses;
    private final ContentResolver contentResolver;
    private Integer limit;
    private Integer offset;
    private final List<SortDescriptor> orderBy;

    public final AssetFactory getAssetFactory() {
        return this.assetFactory;
    }

    public final AssetMapper getAssetMapper() {
        return this.assetMapper;
    }

    public final ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Query(AssetFactory assetFactory, AssetMapper assetMapper, ContentResolver contentResolver) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(assetFactory, "assetFactory");
        Intrinsics.checkNotNullParameter(assetMapper, "assetMapper");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.assetFactory = assetFactory;
        this.assetMapper = assetMapper;
        this.contentResolver = contentResolver;
        this.clauses = new ArrayList();
        this.args = new ArrayList();
        this.orderBy = new ArrayList();
    }

    public final Query eq(AssetField field, String value) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        if (field == AssetField.IS_FAVORITE && Build.VERSION.SDK_INT < 29) {
            return this;
        }
        this.clauses.add(field.toMediaStoreColumn() + " = ?");
        this.args.add(value);
        return this;
    }

    public final Query within(AssetField field, List<String> values) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(values, "values");
        if (field == AssetField.IS_FAVORITE && Build.VERSION.SDK_INT < 29) {
            return this;
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(values, ", ", null, null, 0, null, new Function1() { // from class: expo.modules.medialibrary.next.objects.query.Query$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Query.within$lambda$2$lambda$1((String) obj);
            }
        }, 30, null);
        this.clauses.add(field.toMediaStoreColumn() + " IN (" + strJoinToString$default + ")");
        this.args.addAll(values);
        return this;
    }

    static final CharSequence within$lambda$2$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "?";
    }

    public final Query gt(AssetField field, String value) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        this.clauses.add(field.toMediaStoreColumn() + " > ?");
        this.args.add(value);
        return this;
    }

    public final Query gte(AssetField field, String value) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        this.clauses.add(field.toMediaStoreColumn() + " >= ?");
        this.args.add(value);
        return this;
    }

    public final Query lt(AssetField field, String value) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        this.clauses.add(field.toMediaStoreColumn() + " < ?");
        this.args.add(value);
        return this;
    }

    public final Query lte(AssetField field, String value) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        this.clauses.add(field.toMediaStoreColumn() + " <= ?");
        this.args.add(value);
        return this;
    }

    public final Query limit(int limit) {
        this.limit = Integer.valueOf(limit);
        return this;
    }

    public final Query album(Album album) {
        Intrinsics.checkNotNullParameter(album, "album");
        this.clauses.add("bucket_id = ?");
        this.args.add(album.getId());
        return this;
    }

    public final Query offset(int count) {
        this.offset = Integer.valueOf(count);
        return this;
    }

    public final Query orderBy(SortDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.orderBy.add(descriptor);
        return this;
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.query.Query$exe$2, reason: invalid class name */
    /* JADX INFO: compiled from: Query.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.query.Query$exe$2", f = "Query.kt", i = {0, 0, 0}, l = {103}, m = "invokeSuspend", n = {"$this$withContext", "queryExecutor", "projection"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Asset>>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = Query.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Asset>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Asset>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Asset>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            QueryLegacyExecutor queryLegacyExecutor;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Build.VERSION.SDK_INT >= 30) {
                    queryLegacyExecutor = new QueryModernExecutor(Query.this.clauses, Query.this.args, Query.this.orderBy, Query.this.limit, Query.this.offset);
                } else {
                    queryLegacyExecutor = new QueryLegacyExecutor(Query.this.clauses, Query.this.args, Query.this.orderBy, Query.this.limit, Query.this.offset);
                }
                String[] strArr = {"_id", "media_type"};
                this.L$0 = coroutineScope;
                this.L$1 = SpillingKt.nullOutSpilledVariable(queryLegacyExecutor);
                this.L$2 = SpillingKt.nullOutSpilledVariable(strArr);
                this.label = 1;
                obj = queryLegacyExecutor.exe(strArr, Query.this.getContentResolver(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Cursor cursor = (Cursor) obj;
            Query query = Query.this;
            try {
                Cursor cursor2 = cursor;
                CoroutineScopeKt.ensureActive(coroutineScope);
                int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("media_type");
                Iterable<Cursor> iterableAsIterable = CursorExtensionsKt.asIterable(cursor2);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
                Iterator<Cursor> it = iterableAsIterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(expo.modules.medialibrary.next.extensions.resolver.CursorExtensionsKt.extractAssetContentUri(it.next(), columnIndexOrThrow, columnIndexOrThrow2));
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(query.getAssetFactory().create((Uri) it2.next()));
                }
                List list = CollectionsKt.toList(arrayList3);
                CloseableKt.closeFinally(cursor, null);
                return list;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
    }

    public final Object exe(Continuation<? super List<Asset>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.query.Query$exeForMetadata$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Query.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lexpo/modules/medialibrary/next/records/AssetMetadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.query.Query$exeForMetadata$2", f = "Query.kt", i = {0, 0}, l = {122}, m = "invokeSuspend", n = {"$this$withContext", "queryExecutor"}, s = {"L$0", "L$1"})
    static final class C09182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AssetMetadata>>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C09182(Continuation<? super C09182> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09182 c09182 = Query.this.new C09182(continuation);
            c09182.L$0 = obj;
            return c09182;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends AssetMetadata>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<AssetMetadata>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<AssetMetadata>> continuation) {
            return ((C09182) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            QueryLegacyExecutor queryLegacyExecutor;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Build.VERSION.SDK_INT >= 30) {
                    queryLegacyExecutor = new QueryModernExecutor(Query.this.clauses, Query.this.args, Query.this.orderBy, Query.this.limit, Query.this.offset);
                } else {
                    queryLegacyExecutor = new QueryLegacyExecutor(Query.this.clauses, Query.this.args, Query.this.orderBy, Query.this.limit, Query.this.offset);
                }
                this.L$0 = coroutineScope;
                this.L$1 = SpillingKt.nullOutSpilledVariable(queryLegacyExecutor);
                this.label = 1;
                obj = queryLegacyExecutor.exe(MediaStoreFile.INSTANCE.getProjection(), Query.this.getContentResolver(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Closeable closeable = (Closeable) obj;
            final Query query = Query.this;
            try {
                Cursor cursor = (Cursor) closeable;
                CoroutineScopeKt.ensureActive(coroutineScope);
                final MediaStoreFileColumnIndexes mediaStoreFileColumnIndexesFrom = MediaStoreFileColumnIndexes.INSTANCE.from(cursor);
                List list = SequencesKt.toList(SequencesKt.map(SequencesKt.map(CursorExtensionsKt.asSequence(cursor), new Function1() { // from class: expo.modules.medialibrary.next.objects.query.Query$exeForMetadata$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return MediaStoreFile.INSTANCE.from((Cursor) obj2, mediaStoreFileColumnIndexesFrom);
                    }
                }), new Function1() { // from class: expo.modules.medialibrary.next.objects.query.Query$exeForMetadata$2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return query.getAssetMapper().toMetadata((MediaStoreFile) obj2);
                    }
                }));
                CloseableKt.closeFinally(closeable, null);
                return list;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(closeable, th);
                    throw th2;
                }
            }
        }
    }

    public final Object exeForMetadata(Continuation<? super List<AssetMetadata>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C09182(null), continuation);
    }
}
