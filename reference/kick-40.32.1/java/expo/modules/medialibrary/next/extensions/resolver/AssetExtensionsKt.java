package expo.modules.medialibrary.next.extensions.resolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreAudio;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreImage;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreVideo;
import expo.modules.medialibrary.next.objects.wrappers.MediaType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AssetExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001aI\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\u0004\b\u0000\u0010\u0018*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002H\u00180\u001c¢\u0006\u0002\b\u001eH\u0082@¢\u0006\u0002\u0010\u001f\u001a,\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0086@¢\u0006\u0004\b&\u0010'\u001a\u0014\u0010(\u001a\u00020)*\u00020\u00022\u0006\u0010*\u001a\u00020\u0004H\u0007\u001a\u001a\u0010+\u001a\u00020\r*\u00020\u00022\u0006\u0010*\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-\u001a!\u0010.\u001a\u00020)*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010/\u001a\u00020%¢\u0006\u0004\b0\u00101\u001a)\u00102\u001a\u00020)*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010/\u001a\u00020%2\u0006\u0010!\u001a\u00020\u0001¢\u0006\u0004\b3\u00104\u001a\u0012\u00105\u001a\u00020)*\u00020\u00022\u0006\u00106\u001a\u00020\u0001¨\u00067"}, d2 = {"queryAssetDisplayName", "", "Landroid/content/ContentResolver;", "contentUri", "Landroid/net/Uri;", "(Landroid/content/ContentResolver;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAssetDateTaken", "", "queryAssetDateModified", "queryAssetDuration", "queryAssetData", "queryAssetOwnerPackageName", "queryAssetBucketId", "", "queryAssetIsFavorite", "queryAssetMediaStoreItem", "Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem;", "queryMediaStoreImageAsset", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImage;", "queryMediaStoreVideoAsset", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideo;", "queryMediaStoreAudioAsset", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudio;", "querySingleMediaStoreAsset", ExifInterface.GPS_DIRECTION_TRUE, "projection", "", "fromCursor", "Lkotlin/Function1;", "Landroid/database/Cursor;", "Lkotlin/ExtensionFunctionType;", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPendingAsset", "displayName", "mimeType", "Lexpo/modules/medialibrary/next/objects/wrappers/MimeType;", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "insertPendingAsset-cT81_0k", "(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "publishPendingAsset", "", "uri", "safeUpdate", "values", "Landroid/content/ContentValues;", "updateRelativePath", "newRelativePath", "updateRelativePath-XUFtwTY", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)V", "updateRelativePathAndName", "updateRelativePathAndName-SGAlvP8", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "deleteBy", "assetPath", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AssetExtensionsKt {

    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$queryAssetMediaStoreItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt", f = "AssetExtensions.kt", i = {0, 0, 1, 1, 2, 2}, l = {53, 54, 55}, m = "queryAssetMediaStoreItem", n = {"$this$queryAssetMediaStoreItem", "contentUri", "$this$queryAssetMediaStoreItem", "contentUri", "$this$queryAssetMediaStoreItem", "contentUri"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
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
            return AssetExtensionsKt.queryAssetMediaStoreItem(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$queryAssetDisplayName$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08852 extends FunctionReferenceImpl implements Function2<Cursor, Integer, String> {
        public static final C08852 INSTANCE = new C08852();

        C08852() {
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

    public static final Object queryAssetDisplayName(ContentResolver contentResolver, Uri uri, Continuation<? super String> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, uri, "_display_name", C08852.INSTANCE, null, null, null, continuation, 56, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$queryAssetDateTaken$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08842 extends FunctionReferenceImpl implements Function2<Cursor, Integer, Long> {
        public static final C08842 INSTANCE = new C08842();

        C08842() {
            super(2, expo.modules.medialibrary.next.extensions.CursorExtensionsKt.class, "getNullableLong", "getNullableLong(Landroid/database/Cursor;I)Ljava/lang/Long;", 1);
        }

        public final Long invoke(Cursor p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableLong(p0, i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Long invoke(Cursor cursor, Integer num) {
            return invoke(cursor, num.intValue());
        }
    }

    public static final Object queryAssetDateTaken(ContentResolver contentResolver, Uri uri, Continuation<? super Long> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, uri, "datetaken", C08842.INSTANCE, null, null, null, continuation, 56, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$queryAssetDateModified$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08832 extends FunctionReferenceImpl implements Function2<Cursor, Integer, Long> {
        public static final C08832 INSTANCE = new C08832();

        C08832() {
            super(2, expo.modules.medialibrary.next.extensions.CursorExtensionsKt.class, "getNullableLong", "getNullableLong(Landroid/database/Cursor;I)Ljava/lang/Long;", 1);
        }

        public final Long invoke(Cursor p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableLong(p0, i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Long invoke(Cursor cursor, Integer num) {
            return invoke(cursor, num.intValue());
        }
    }

    public static final Object queryAssetDateModified(ContentResolver contentResolver, Uri uri, Continuation<? super Long> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, uri, "date_modified", C08832.INSTANCE, null, null, null, continuation, 56, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$queryAssetDuration$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08862 extends FunctionReferenceImpl implements Function2<Cursor, Integer, Long> {
        public static final C08862 INSTANCE = new C08862();

        C08862() {
            super(2, expo.modules.medialibrary.next.extensions.CursorExtensionsKt.class, "getNullableLong", "getNullableLong(Landroid/database/Cursor;I)Ljava/lang/Long;", 1);
        }

        public final Long invoke(Cursor p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableLong(p0, i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Long invoke(Cursor cursor, Integer num) {
            return invoke(cursor, num.intValue());
        }
    }

    public static final Object queryAssetDuration(ContentResolver contentResolver, Uri uri, Continuation<? super Long> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, uri, "duration", C08862.INSTANCE, null, null, null, continuation, 56, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$queryAssetData$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08822 extends FunctionReferenceImpl implements Function2<Cursor, Integer, String> {
        public static final C08822 INSTANCE = new C08822();

        C08822() {
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

    public static final Object queryAssetData(ContentResolver contentResolver, Uri uri, Continuation<? super String> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, uri, "_data", C08822.INSTANCE, null, null, null, continuation, 56, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$queryAssetOwnerPackageName$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08882 extends FunctionReferenceImpl implements Function2<Cursor, Integer, String> {
        public static final C08882 INSTANCE = new C08882();

        C08882() {
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

    public static final Object queryAssetOwnerPackageName(ContentResolver contentResolver, Uri uri, Continuation<? super String> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, uri, "owner_package_name", C08882.INSTANCE, null, null, null, continuation, 56, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$queryAssetBucketId$2, reason: invalid class name */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<Cursor, Integer, Integer> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(2, expo.modules.medialibrary.next.extensions.CursorExtensionsKt.class, "getNullableInt", "getNullableInt(Landroid/database/Cursor;I)Ljava/lang/Integer;", 1);
        }

        public final Integer invoke(Cursor p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableInt(p0, i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Cursor cursor, Integer num) {
            return invoke(cursor, num.intValue());
        }
    }

    public static final Object queryAssetBucketId(ContentResolver contentResolver, Uri uri, Continuation<? super Integer> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, uri, "bucket_id", AnonymousClass2.INSTANCE, null, null, null, continuation, 56, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$queryAssetIsFavorite$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C08872 extends FunctionReferenceImpl implements Function2<Cursor, Integer, Integer> {
        public static final C08872 INSTANCE = new C08872();

        C08872() {
            super(2, expo.modules.medialibrary.next.extensions.CursorExtensionsKt.class, "getNullableInt", "getNullableInt(Landroid/database/Cursor;I)Ljava/lang/Integer;", 1);
        }

        public final Integer invoke(Cursor p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableInt(p0, i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Cursor cursor, Integer num) {
            return invoke(cursor, num.intValue());
        }
    }

    public static final Object queryAssetIsFavorite(ContentResolver contentResolver, Uri uri, Continuation<? super Integer> continuation) {
        return QueryOneKt.queryOne$default(contentResolver, uri, "is_favorite", C08872.INSTANCE, null, null, null, continuation, 56, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
    
        if (r9 == r1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
    
        if (r9 == r1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cf, code lost:
    
        if (r9 == r1) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object queryAssetMediaStoreItem(android.content.ContentResolver r7, android.net.Uri r8, kotlin.coroutines.Continuation<? super expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem> r9) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt.queryAssetMediaStoreItem(android.content.ContentResolver, android.net.Uri, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object queryMediaStoreImageAsset(ContentResolver contentResolver, Uri uri, Continuation<? super MediaStoreImage> continuation) {
        return querySingleMediaStoreAsset(contentResolver, uri, MediaStoreImage.INSTANCE.getProjection(), new Function1() { // from class: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetExtensionsKt.queryMediaStoreImageAsset$lambda$3((Cursor) obj);
            }
        }, continuation);
    }

    static final MediaStoreImage queryMediaStoreImageAsset$lambda$3(Cursor querySingleMediaStoreAsset) {
        Intrinsics.checkNotNullParameter(querySingleMediaStoreAsset, "$this$querySingleMediaStoreAsset");
        return MediaStoreImage.Companion.from$default(MediaStoreImage.INSTANCE, querySingleMediaStoreAsset, null, 2, null);
    }

    public static final Object queryMediaStoreVideoAsset(ContentResolver contentResolver, Uri uri, Continuation<? super MediaStoreVideo> continuation) {
        return querySingleMediaStoreAsset(contentResolver, uri, MediaStoreVideo.INSTANCE.getProjection(), new Function1() { // from class: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetExtensionsKt.queryMediaStoreVideoAsset$lambda$4((Cursor) obj);
            }
        }, continuation);
    }

    static final MediaStoreVideo queryMediaStoreVideoAsset$lambda$4(Cursor querySingleMediaStoreAsset) {
        Intrinsics.checkNotNullParameter(querySingleMediaStoreAsset, "$this$querySingleMediaStoreAsset");
        return MediaStoreVideo.Companion.from$default(MediaStoreVideo.INSTANCE, querySingleMediaStoreAsset, null, 2, null);
    }

    public static final Object queryMediaStoreAudioAsset(ContentResolver contentResolver, Uri uri, Continuation<? super MediaStoreAudio> continuation) {
        return querySingleMediaStoreAsset(contentResolver, uri, MediaStoreAudio.INSTANCE.getProjection(), new Function1() { // from class: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetExtensionsKt.queryMediaStoreAudioAsset$lambda$5((Cursor) obj);
            }
        }, continuation);
    }

    static final MediaStoreAudio queryMediaStoreAudioAsset$lambda$5(Cursor querySingleMediaStoreAsset) {
        Intrinsics.checkNotNullParameter(querySingleMediaStoreAsset, "$this$querySingleMediaStoreAsset");
        return MediaStoreAudio.Companion.from$default(MediaStoreAudio.INSTANCE, querySingleMediaStoreAsset, null, 2, null);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$querySingleMediaStoreAsset$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetExtensions.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt$querySingleMediaStoreAsset$2", f = "AssetExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08892<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Uri $contentUri;
        final /* synthetic */ Function1<Cursor, T> $fromCursor;
        final /* synthetic */ String[] $projection;
        final /* synthetic */ ContentResolver $this_querySingleMediaStoreAsset;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08892(ContentResolver contentResolver, Uri uri, String[] strArr, Function1<? super Cursor, ? extends T> function1, Continuation<? super C08892> continuation) {
            super(2, continuation);
            this.$this_querySingleMediaStoreAsset = contentResolver;
            this.$contentUri = uri;
            this.$projection = strArr;
            this.$fromCursor = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08892(this.$this_querySingleMediaStoreAsset, this.$contentUri, this.$projection, this.$fromCursor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C08892) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Cursor cursorSafeQuery$default = SafeQueryKt.safeQuery$default(this.$this_querySingleMediaStoreAsset, this.$contentUri, this.$projection, null, null, null, 16, null);
            if (cursorSafeQuery$default == null) {
                return null;
            }
            Cursor cursor = cursorSafeQuery$default;
            try {
                Cursor cursor2 = cursor;
                T tInvoke = cursor2.moveToFirst() ? this.$fromCursor.invoke(cursor2) : null;
                CloseableKt.closeFinally(cursor, null);
                return tInvoke;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object querySingleMediaStoreAsset(ContentResolver contentResolver, Uri uri, String[] strArr, Function1<? super Cursor, ? extends T> function1, Continuation<? super T> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C08892(contentResolver, uri, strArr, function1, null), continuation);
    }

    /* JADX INFO: renamed from: insertPendingAsset-cT81_0k, reason: not valid java name */
    public static final Object m12001insertPendingAssetcT81_0k(ContentResolver contentResolver, String str, String str2, String str3, Continuation<? super Uri> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AssetExtensionsKt$insertPendingAsset$2(str2, contentResolver, str, str3, null), continuation);
    }

    public static final void publishPendingAsset(ContentResolver contentResolver, Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_pending", (Integer) 0);
        safeUpdate(contentResolver, uri, contentValues);
    }

    public static final int safeUpdate(ContentResolver contentResolver, Uri uri, ContentValues values) {
        Intrinsics.checkNotNullParameter(contentResolver, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(values, "values");
        if (Build.VERSION.SDK_INT >= 30) {
            return contentResolver.update(uri, values, null);
        }
        return contentResolver.update(uri, values, null, null);
    }

    /* JADX INFO: renamed from: updateRelativePath-XUFtwTY, reason: not valid java name */
    public static final void m12002updateRelativePathXUFtwTY(ContentResolver updateRelativePath, Uri contentUri, String newRelativePath) {
        Intrinsics.checkNotNullParameter(updateRelativePath, "$this$updateRelativePath");
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        Intrinsics.checkNotNullParameter(newRelativePath, "newRelativePath");
        ContentValues contentValues = new ContentValues();
        contentValues.put("relative_path", newRelativePath);
        updateRelativePath.update(contentUri, contentValues, null, null);
    }

    /* JADX INFO: renamed from: updateRelativePathAndName-SGAlvP8, reason: not valid java name */
    public static final void m12003updateRelativePathAndNameSGAlvP8(ContentResolver updateRelativePathAndName, Uri contentUri, String newRelativePath, String displayName) {
        Intrinsics.checkNotNullParameter(updateRelativePathAndName, "$this$updateRelativePathAndName");
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        Intrinsics.checkNotNullParameter(newRelativePath, "newRelativePath");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        ContentValues contentValues = new ContentValues();
        contentValues.put("relative_path", newRelativePath);
        contentValues.put("_display_name", displayName);
        updateRelativePathAndName.update(contentUri, contentValues, null, null);
    }

    public static final void deleteBy(ContentResolver contentResolver, String assetPath) {
        Intrinsics.checkNotNullParameter(contentResolver, "<this>");
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        contentResolver.delete(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), "_data=?", new String[]{assetPath});
    }
}
