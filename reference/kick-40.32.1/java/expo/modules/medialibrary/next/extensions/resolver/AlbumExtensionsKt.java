package expo.modules.medialibrary.next.extensions.resolver;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import expo.modules.medialibrary.next.objects.wrappers.RelativePath;
import expo.modules.medialibrary.next.records.AlbumMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AlbumExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\b\u001a\u001c\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\b\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\b\u001a\u001e\u0010\f\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u000e\u0010\b\u001a\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\b\u001a\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011*\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0012\u001a\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011*\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0012\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\b\u001a \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\b\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0018"}, d2 = {"EXTERNAL_CONTENT_URI", "Landroid/net/Uri;", "getEXTERNAL_CONTENT_URI", "()Landroid/net/Uri;", "queryAlbumTitle", "", "Landroid/content/ContentResolver;", "bucketId", "(Landroid/content/ContentResolver;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAlbumRelativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "queryAlbumFilepath", "queryAlbumId", "relativePath", "queryAlbumId-qTZuolk", "name", "queryAllAlbumIds", "", "(Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAlbumsMetadata", "Lexpo/modules/medialibrary/next/records/AlbumMetadata;", "queryAlbumAssetsCount", "", "queryAlbumAssetsContentUris", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AlbumExtensionsKt {
    private static final Uri EXTERNAL_CONTENT_URI;

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumRelativePath$1, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt", f = "AlbumExtensions.kt", i = {0, 0}, l = {28}, m = "queryAlbumRelativePath", n = {"$this$queryAlbumRelativePath", "bucketId"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objQueryAlbumRelativePath = AlbumExtensionsKt.queryAlbumRelativePath(null, null, this);
            if (objQueryAlbumRelativePath == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return objQueryAlbumRelativePath;
            }
            String str = (String) objQueryAlbumRelativePath;
            if (str != null) {
                return RelativePath.m12042boximpl(str);
            }
            return null;
        }
    }

    static {
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Intrinsics.checkNotNullExpressionValue(contentUri, "getContentUri(...)");
        EXTERNAL_CONTENT_URI = contentUri;
    }

    public static final Uri getEXTERNAL_CONTENT_URI() {
        return EXTERNAL_CONTENT_URI;
    }

    public static final Object queryAlbumTitle(ContentResolver contentResolver, String str, Continuation<? super String> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, EXTERNAL_CONTENT_URI, "bucket_display_name", C08792.INSTANCE, "bucket_id = ?", new String[]{str}, null, continuation, 32, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumTitle$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08792 extends FunctionReferenceImpl implements Function2<Cursor, Integer, String> {
        public static final C08792 INSTANCE = new C08792();

        C08792() {
            super(2, expo.modules.medialibrary.next.extensions.CursorExtensionsKt.class, "getNullableString", "getNullableString(Landroid/database/Cursor;I)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ String invoke(Cursor cursor, Integer num) {
            return invoke(cursor, num.intValue());
        }

        public final String invoke(Cursor p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableString(p0, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object queryAlbumRelativePath(ContentResolver contentResolver, String str, Continuation<? super RelativePath> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objQueryOne$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryOne$default);
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(contentResolver);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass2.label = 1;
            objQueryOne$default = QueryOneKt.queryOne$default(contentResolver, EXTERNAL_CONTENT_URI, "relative_path", new Function2<Cursor, Integer, RelativePath>() { // from class: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt.queryAlbumRelativePath.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ RelativePath invoke(Cursor cursor, Integer num) {
                    String strM12000invokevDAV04g = m12000invokevDAV04g(cursor, num.intValue());
                    if (strM12000invokevDAV04g != null) {
                        return RelativePath.m12042boximpl(strM12000invokevDAV04g);
                    }
                    return null;
                }

                /* JADX INFO: renamed from: invoke-vDAV04g, reason: not valid java name */
                public final String m12000invokevDAV04g(Cursor queryOne, int i2) {
                    Intrinsics.checkNotNullParameter(queryOne, "$this$queryOne");
                    String nullableString = expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableString(queryOne, i2);
                    if (nullableString != null) {
                        return RelativePath.m12043constructorimpl(nullableString);
                    }
                    return null;
                }
            }, "bucket_id = ?", new String[]{str}, null, anonymousClass2, 32, null);
            if (objQueryOne$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryOne$default);
        }
        RelativePath relativePath = (RelativePath) objQueryOne$default;
        if (relativePath != null) {
            return relativePath.m12049unboximpl();
        }
        return null;
    }

    public static final Object queryAlbumFilepath(ContentResolver contentResolver, String str, Continuation<? super String> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, EXTERNAL_CONTENT_URI, "_data", C08762.INSTANCE, "bucket_id = ?", new String[]{str}, null, continuation, 32, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumFilepath$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08762 extends FunctionReferenceImpl implements Function2<Cursor, Integer, String> {
        public static final C08762 INSTANCE = new C08762();

        C08762() {
            super(2, expo.modules.medialibrary.next.extensions.CursorExtensionsKt.class, "getNullableString", "getNullableString(Landroid/database/Cursor;I)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ String invoke(Cursor cursor, Integer num) {
            return invoke(cursor, num.intValue());
        }

        public final String invoke(Cursor p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableString(p0, i);
        }
    }

    /* JADX INFO: renamed from: queryAlbumId-qTZuolk, reason: not valid java name */
    public static final Object m11999queryAlbumIdqTZuolk(ContentResolver contentResolver, String str, Continuation<? super String> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, EXTERNAL_CONTENT_URI, "bucket_id", C08772.INSTANCE, "relative_path = ?", new String[]{str}, null, continuation, 32, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08772 extends FunctionReferenceImpl implements Function2<Cursor, Integer, String> {
        public static final C08772 INSTANCE = new C08772();

        C08772() {
            super(2, expo.modules.medialibrary.next.extensions.CursorExtensionsKt.class, "getNullableString", "getNullableString(Landroid/database/Cursor;I)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ String invoke(Cursor cursor, Integer num) {
            return invoke(cursor, num.intValue());
        }

        public final String invoke(Cursor p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableString(p0, i);
        }
    }

    public static final Object queryAlbumId(ContentResolver contentResolver, String str, Continuation<? super String> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, EXTERNAL_CONTENT_URI, "bucket_id", AnonymousClass4.INSTANCE, "bucket_display_name = ?", new String[]{str}, null, continuation, 32, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumId$4, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function2<Cursor, Integer, String> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(2, expo.modules.medialibrary.next.extensions.CursorExtensionsKt.class, "getNullableString", "getNullableString(Landroid/database/Cursor;I)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ String invoke(Cursor cursor, Integer num) {
            return invoke(cursor, num.intValue());
        }

        public final String invoke(Cursor p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableString(p0, i);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAllAlbumIds$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumExtensions.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAllAlbumIds$2", f = "AlbumExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08812 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
        final /* synthetic */ ContentResolver $this_queryAllAlbumIds;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08812(ContentResolver contentResolver, Continuation<? super C08812> continuation) {
            super(2, continuation);
            this.$this_queryAllAlbumIds = contentResolver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08812 c08812 = new C08812(this.$this_queryAllAlbumIds, continuation);
            c08812.L$0 = obj;
            return c08812;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
            return ((C08812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Cursor cursorQuery = this.$this_queryAllAlbumIds.query(AlbumExtensionsKt.getEXTERNAL_CONTENT_URI(), new String[]{"bucket_id"}, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("bucket_id");
                    Iterable<Cursor> iterableAsIterable = expo.modules.medialibrary.next.extensions.CursorExtensionsKt.asIterable(cursor2);
                    ArrayList arrayList = new ArrayList();
                    Iterator<Cursor> it = iterableAsIterable.iterator();
                    while (it.hasNext()) {
                        String nullableString = expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableString(it.next(), columnIndexOrThrow);
                        if (nullableString != null) {
                            arrayList.add(nullableString);
                        }
                    }
                    List list = CollectionsKt.toList(CollectionsKt.toSet(arrayList));
                    CloseableKt.closeFinally(cursor, null);
                    if (list != null) {
                        return list;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursor, th);
                        throw th2;
                    }
                }
            }
            return CollectionsKt.emptyList();
        }
    }

    public static final Object queryAllAlbumIds(ContentResolver contentResolver, Continuation<? super List<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C08812(contentResolver, null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumsMetadata$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumExtensions.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lexpo/modules/medialibrary/next/records/AlbumMetadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumsMetadata$2", f = "AlbumExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08802 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AlbumMetadata>>, Object> {
        final /* synthetic */ ContentResolver $this_queryAlbumsMetadata;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08802(ContentResolver contentResolver, Continuation<? super C08802> continuation) {
            super(2, continuation);
            this.$this_queryAlbumsMetadata = contentResolver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08802 c08802 = new C08802(this.$this_queryAlbumsMetadata, continuation);
            c08802.L$0 = obj;
            return c08802;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends AlbumMetadata>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<AlbumMetadata>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<AlbumMetadata>> continuation) {
            return ((C08802) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Cursor cursorSafeQuery$default = SafeQueryKt.safeQuery$default(this.$this_queryAlbumsMetadata, AlbumExtensionsKt.getEXTERNAL_CONTENT_URI(), new String[]{"bucket_id", "bucket_display_name"}, null, null, null, 28, null);
            if (cursorSafeQuery$default != null) {
                Cursor cursor = cursorSafeQuery$default;
                try {
                    Cursor cursor2 = cursor;
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    final int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("bucket_id");
                    final int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("bucket_display_name");
                    List list = SequencesKt.toList(SequencesKt.mapNotNull(expo.modules.medialibrary.next.extensions.CursorExtensionsKt.asSequence(cursor2), new Function1() { // from class: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumsMetadata$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return AlbumExtensionsKt.C08802.invokeSuspend$lambda$1$lambda$0(columnIndexOrThrow, columnIndexOrThrow2, (Cursor) obj2);
                        }
                    }));
                    CloseableKt.closeFinally(cursor, null);
                    if (list != null) {
                        return list;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursor, th);
                        throw th2;
                    }
                }
            }
            return CollectionsKt.emptyList();
        }

        static final AlbumMetadata invokeSuspend$lambda$1$lambda$0(int i, int i2, Cursor cursor) {
            String nullableString = expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableString(cursor, i);
            if (nullableString == null) {
                return null;
            }
            String nullableString2 = expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableString(cursor, i2);
            if (nullableString2 == null) {
                nullableString2 = "";
            }
            return new AlbumMetadata(nullableString, nullableString2, null, 4, null);
        }
    }

    public static final Object queryAlbumsMetadata(ContentResolver contentResolver, Continuation<? super List<AlbumMetadata>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C08802(contentResolver, null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumAssetsCount$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumExtensions.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumAssetsCount$2", f = "AlbumExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08752 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ String $bucketId;
        final /* synthetic */ ContentResolver $this_queryAlbumAssetsCount;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08752(ContentResolver contentResolver, String str, Continuation<? super C08752> continuation) {
            super(2, continuation);
            this.$this_queryAlbumAssetsCount = contentResolver;
            this.$bucketId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08752 c08752 = new C08752(this.$this_queryAlbumAssetsCount, this.$bucketId, continuation);
            c08752.L$0 = obj;
            return c08752;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C08752) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int count;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Cursor cursorSafeQuery$default = SafeQueryKt.safeQuery$default(this.$this_queryAlbumAssetsCount, AlbumExtensionsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_id"}, "bucket_id = ?", new String[]{this.$bucketId}, null, 16, null);
            if (cursorSafeQuery$default != null) {
                Cursor cursor = cursorSafeQuery$default;
                try {
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    count = cursor.getCount();
                    CloseableKt.closeFinally(cursor, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursor, th);
                        throw th2;
                    }
                }
            } else {
                count = 0;
            }
            return Boxing.boxInt(count);
        }
    }

    public static final Object queryAlbumAssetsCount(ContentResolver contentResolver, String str, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C08752(contentResolver, str, null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumAssetsContentUris$2, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumExtensions.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt$queryAlbumAssetsContentUris$2", f = "AlbumExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Uri>>, Object> {
        final /* synthetic */ String $bucketId;
        final /* synthetic */ ContentResolver $this_queryAlbumAssetsContentUris;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ContentResolver contentResolver, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_queryAlbumAssetsContentUris = contentResolver;
            this.$bucketId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_queryAlbumAssetsContentUris, this.$bucketId, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Uri>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Cursor cursorQuery = this.$this_queryAlbumAssetsContentUris.query(AlbumExtensionsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_id", "media_type"}, "bucket_id = ?", new String[]{this.$bucketId}, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("media_type");
                    Iterable<Cursor> iterableAsIterable = expo.modules.medialibrary.next.extensions.CursorExtensionsKt.asIterable(cursor2);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
                    Iterator<Cursor> it = iterableAsIterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(CursorExtensionsKt.extractAssetContentUri(it.next(), columnIndexOrThrow, columnIndexOrThrow2));
                    }
                    List list = CollectionsKt.toList(arrayList);
                    CloseableKt.closeFinally(cursor, null);
                    if (list != null) {
                        return list;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursor, th);
                        throw th2;
                    }
                }
            }
            return CollectionsKt.emptyList();
        }
    }

    public static final Object queryAlbumAssetsContentUris(ContentResolver contentResolver, String str, Continuation<? super List<? extends Uri>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(contentResolver, str, null), continuation);
    }
}
