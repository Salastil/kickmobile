package expo.modules.medialibrary.next.objects.album;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.medialibrary.next.exceptions.AlbumPropertyNotFoundException;
import expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException;
import expo.modules.medialibrary.next.extensions.WeakReferenceExtensionsKt;
import expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt;
import expo.modules.medialibrary.next.objects.asset.Asset;
import expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter;
import expo.modules.medialibrary.next.objects.asset.factories.AssetFactory;
import expo.modules.medialibrary.next.objects.asset.movers.AssetMover;
import expo.modules.medialibrary.next.objects.wrappers.RelativePath;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: Album.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001d\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0004\b!\u0010\u001eJ\u0017\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010%J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0086@¢\u0006\u0002\u0010\u001eJ\u000e\u0010)\u001a\u00020*H\u0086@¢\u0006\u0002\u0010\u001eJ\u000e\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010\u001eJ\u001c\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020(0'H\u0086@¢\u0006\u0002\u0010/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u000b0\u000b0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00060"}, d2 = {"Lexpo/modules/medialibrary/next/objects/album/Album;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "id", "", "assetDeleter", "Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "assetFactory", "Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "assetMover", "Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Ljava/lang/String;Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;Landroid/content/Context;)V", "getId", "()Ljava/lang/String;", "getAssetDeleter", "()Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "getAssetFactory", "()Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "getAssetMover", "()Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "getTitle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRelativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "getRelativePath-MwbCjzw", "createRelativePathFrom", "filePath", "createRelativePathFrom-MwbCjzw", "(Ljava/lang/String;)Ljava/lang/String;", "getAssets", "", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "getAssetCount", "", "delete", "", "add", "assets", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Album extends SharedObject {
    private final AssetDeleter assetDeleter;
    private final AssetFactory assetFactory;
    private final AssetMover assetMover;
    private final WeakReference<Context> contextRef;
    private final String id;

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.album.Album$add$1, reason: invalid class name */
    /* JADX INFO: compiled from: Album.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.Album", f = "Album.kt", i = {0, 1}, l = {75, 75}, m = "add", n = {"assets", "assets"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Album.this.add(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.album.Album$delete$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Album.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.Album", f = "Album.kt", i = {}, l = {EACTags.MESSAGE_REFERENCE, 70}, m = "delete", n = {}, s = {})
    static final class C08901 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08901(Continuation<? super C08901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Album.this.delete(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.album.Album$getAssets$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Album.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.Album", f = "Album.kt", i = {}, l = {63}, m = "getAssets", n = {}, s = {})
    static final class C08911 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08911(Continuation<? super C08911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Album.this.getAssets(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.album.Album$getTitle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Album.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.Album", f = "Album.kt", i = {}, l = {38}, m = "getTitle", n = {}, s = {})
    static final class C08921 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08921(Continuation<? super C08921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Album.this.getTitle(this);
        }
    }

    public final String getId() {
        return this.id;
    }

    public final AssetDeleter getAssetDeleter() {
        return this.assetDeleter;
    }

    public final AssetFactory getAssetFactory() {
        return this.assetFactory;
    }

    public final AssetMover getAssetMover() {
        return this.assetMover;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Album(String id, AssetDeleter assetDeleter, AssetFactory assetFactory, AssetMover assetMover, Context context) {
        super(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(assetDeleter, "assetDeleter");
        Intrinsics.checkNotNullParameter(assetFactory, "assetFactory");
        Intrinsics.checkNotNullParameter(assetMover, "assetMover");
        Intrinsics.checkNotNullParameter(context, "context");
        this.id = id;
        this.assetDeleter = assetDeleter;
        this.assetFactory = assetFactory;
        this.assetMover = assetMover;
        this.contextRef = new WeakReference<>(context);
    }

    private final ContentResolver getContentResolver() throws ContentResolverNotObtainedException {
        ContentResolver contentResolver = WeakReferenceExtensionsKt.getOrThrow(this.contextRef).getContentResolver();
        if (contentResolver != null) {
            return contentResolver;
        }
        throw new ContentResolverNotObtainedException(null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getTitle(Continuation<? super String> continuation) throws AlbumPropertyNotFoundException, ContentResolverNotObtainedException {
        C08921 c08921;
        if (continuation instanceof C08921) {
            c08921 = (C08921) continuation;
            if ((c08921.label & Integer.MIN_VALUE) != 0) {
                c08921.label -= Integer.MIN_VALUE;
            } else {
                c08921 = new C08921(continuation);
            }
        } else {
            c08921 = new C08921(continuation);
        }
        Object objQueryAlbumTitle = c08921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08921.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAlbumTitle);
            ContentResolver contentResolver = getContentResolver();
            String str = this.id;
            c08921.label = 1;
            objQueryAlbumTitle = AlbumExtensionsKt.queryAlbumTitle(contentResolver, str, c08921);
            if (objQueryAlbumTitle == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryAlbumTitle);
        }
        String str2 = (String) objQueryAlbumTitle;
        if (str2 != null) {
            return str2;
        }
        throw new AlbumPropertyNotFoundException("Album with ID=" + this.id + " does not exist in MediaStore", null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        if (r9 == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0088, code lost:
    
        if (r9 == r1) goto L31;
     */
    /* JADX INFO: renamed from: getRelativePath-MwbCjzw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m12005getRelativePathMwbCjzw(kotlin.coroutines.Continuation<? super expo.modules.medialibrary.next.objects.wrappers.RelativePath> r9) throws expo.modules.medialibrary.next.exceptions.AlbumPropertyNotFoundException, expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException {
        /*
            r8 = this;
            boolean r0 = r9 instanceof expo.modules.medialibrary.next.objects.album.Album$getRelativePath$1
            if (r0 == 0) goto L14
            r0 = r9
            expo.modules.medialibrary.next.objects.album.Album$getRelativePath$1 r0 = (expo.modules.medialibrary.next.objects.album.Album$getRelativePath$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.album.Album$getRelativePath$1 r0 = new expo.modules.medialibrary.next.objects.album.Album$getRelativePath$1
            r0.<init>(r8, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = " does not exist in MediaStore"
            java.lang.String r4 = "Album with ID="
            r5 = 1
            r6 = 2
            r7 = 0
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3a
            if (r2 != r6) goto L32
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8b
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            expo.modules.medialibrary.next.objects.wrappers.RelativePath r9 = (expo.modules.medialibrary.next.objects.wrappers.RelativePath) r9
            if (r9 == 0) goto L46
            java.lang.String r9 = r9.m12049unboximpl()
            goto L60
        L46:
            r9 = r7
            goto L60
        L48:
            kotlin.ResultKt.throwOnFailure(r9)
            int r9 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r9 < r2) goto L7c
            android.content.ContentResolver r9 = r8.getContentResolver()
            java.lang.String r2 = r8.id
            r0.label = r5
            java.lang.Object r9 = expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt.queryAlbumRelativePath(r9, r2, r0)
            if (r9 != r1) goto L60
            goto L8a
        L60:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L65
            return r9
        L65:
            expo.modules.medialibrary.next.exceptions.AlbumPropertyNotFoundException r9 = new expo.modules.medialibrary.next.exceptions.AlbumPropertyNotFoundException
            java.lang.String r8 = r8.id
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            r0.append(r8)
            r0.append(r3)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8, r7, r6, r7)
            throw r9
        L7c:
            android.content.ContentResolver r9 = r8.getContentResolver()
            java.lang.String r2 = r8.id
            r0.label = r6
            java.lang.Object r9 = expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt.queryAlbumFilepath(r9, r2, r0)
            if (r9 != r1) goto L8b
        L8a:
            return r1
        L8b:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L94
            java.lang.String r8 = r8.m12004createRelativePathFromMwbCjzw(r9)
            return r8
        L94:
            expo.modules.medialibrary.next.exceptions.AlbumPropertyNotFoundException r9 = new expo.modules.medialibrary.next.exceptions.AlbumPropertyNotFoundException
            java.lang.String r8 = r8.id
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            r0.append(r8)
            r0.append(r3)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8, r7, r6, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.album.Album.m12005getRelativePathMwbCjzw(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: createRelativePathFrom-MwbCjzw, reason: not valid java name */
    private final String m12004createRelativePathFromMwbCjzw(String filePath) throws AlbumPropertyNotFoundException {
        String parent = new File(filePath).getParent();
        if (parent == null) {
            throw new AlbumPropertyNotFoundException("Could not get a relative path for the album", null, 2, null);
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intrinsics.checkNotNull(absolutePath);
        return RelativePath.m12043constructorimpl(StringsKt.trimStart(StringsKt.removePrefix(parent, (CharSequence) absolutePath), '/') + DomExceptionUtils.SEPARATOR);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAssets(Continuation<? super List<Asset>> continuation) throws ContentResolverNotObtainedException {
        C08911 c08911;
        if (continuation instanceof C08911) {
            c08911 = (C08911) continuation;
            if ((c08911.label & Integer.MIN_VALUE) != 0) {
                c08911.label -= Integer.MIN_VALUE;
            } else {
                c08911 = new C08911(continuation);
            }
        } else {
            c08911 = new C08911(continuation);
        }
        Object objQueryAlbumAssetsContentUris = c08911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08911.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAlbumAssetsContentUris);
            ContentResolver contentResolver = getContentResolver();
            String str = this.id;
            c08911.label = 1;
            objQueryAlbumAssetsContentUris = AlbumExtensionsKt.queryAlbumAssetsContentUris(contentResolver, str, c08911);
            if (objQueryAlbumAssetsContentUris == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryAlbumAssetsContentUris);
        }
        Iterable iterable = (Iterable) objQueryAlbumAssetsContentUris;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(this.assetFactory.create((Uri) it.next()));
        }
        return arrayList;
    }

    public final Object getAssetCount(Continuation<? super Integer> continuation) {
        return AlbumExtensionsKt.queryAlbumAssetsCount(getContentResolver(), this.id, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0082, code lost:
    
        if (r6.delete(r2, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object delete(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException {
        /*
            r6 = this;
            boolean r0 = r7 instanceof expo.modules.medialibrary.next.objects.album.Album.C08901
            if (r0 == 0) goto L14
            r0 = r7
            expo.modules.medialibrary.next.objects.album.Album$delete$1 r0 = (expo.modules.medialibrary.next.objects.album.Album.C08901) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.album.Album$delete$1 r0 = new expo.modules.medialibrary.next.objects.album.Album$delete$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L85
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$0
            expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter r6 = (expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L50
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter r7 = r6.assetDeleter
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r6 = r6.getAssets(r0)
            if (r6 != r1) goto L4d
            goto L84
        L4d:
            r5 = r7
            r7 = r6
            r6 = r5
        L50:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r4)
            r2.<init>(r4)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r7 = r7.iterator()
        L63:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L77
            java.lang.Object r4 = r7.next()
            expo.modules.medialibrary.next.objects.asset.Asset r4 = (expo.modules.medialibrary.next.objects.asset.Asset) r4
            android.net.Uri r4 = r4.getContentUri()
            r2.add(r4)
            goto L63
        L77:
            java.util.List r2 = (java.util.List) r2
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.delete(r2, r0)
            if (r6 != r1) goto L85
        L84:
            return r1
        L85:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.album.Album.delete(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
    
        if (r5.mo12024moveAssetsqTZuolk(r6, (java.lang.String) r7, r0) == r1) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object add(java.util.List<expo.modules.medialibrary.next.objects.asset.Asset> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws expo.modules.medialibrary.next.exceptions.AlbumPropertyNotFoundException, expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof expo.modules.medialibrary.next.objects.album.Album.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            expo.modules.medialibrary.next.objects.album.Album$add$1 r0 = (expo.modules.medialibrary.next.objects.album.Album.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.album.Album$add$1 r0 = new expo.modules.medialibrary.next.objects.album.Album$add$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L82
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            java.lang.Object r5 = r0.L$2
            r6 = r5
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r5 = r0.L$1
            expo.modules.medialibrary.next.objects.asset.movers.AssetMover r5 = (expo.modules.medialibrary.next.objects.asset.movers.AssetMover) r5
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r7)
            expo.modules.medialibrary.next.objects.wrappers.RelativePath r7 = (expo.modules.medialibrary.next.objects.wrappers.RelativePath) r7
            java.lang.String r7 = r7.m12049unboximpl()
            goto L6c
        L50:
            kotlin.ResultKt.throwOnFailure(r7)
            expo.modules.medialibrary.next.objects.asset.movers.AssetMover r7 = r5.assetMover
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            r0.L$1 = r7
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r5 = r5.m12005getRelativePathMwbCjzw(r0)
            if (r5 != r1) goto L68
            goto L81
        L68:
            r2 = r7
            r7 = r5
            r5 = r2
            r2 = r6
        L6c:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$0 = r2
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r5 = r5.mo12024moveAssetsqTZuolk(r6, r7, r0)
            if (r5 != r1) goto L82
        L81:
            return r1
        L82:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.album.Album.add(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
