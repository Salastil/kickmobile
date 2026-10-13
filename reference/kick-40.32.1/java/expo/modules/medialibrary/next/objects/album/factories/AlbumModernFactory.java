package expo.modules.medialibrary.next.objects.album.factories;

import android.content.ContentResolver;
import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.next.exceptions.AlbumCouldNotBeCreated;
import expo.modules.medialibrary.next.extensions.WeakReferenceExtensionsKt;
import expo.modules.medialibrary.next.objects.album.Album;
import expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter;
import expo.modules.medialibrary.next.objects.asset.factories.AssetFactory;
import expo.modules.medialibrary.next.objects.asset.movers.AssetMover;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: AlbumModernFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J.\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ$\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001aH\u0096@¢\u0006\u0002\u0010\"J0\u0010#\u001a\u00020$2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010%\u001a\u00020&2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0082@¢\u0006\u0004\b'\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\t0\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lexpo/modules/medialibrary/next/objects/album/factories/AlbumModernFactory;", "Lexpo/modules/medialibrary/next/objects/album/factories/AlbumFactory;", "assetFactory", "Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "assetDeleter", "Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "assetMover", "Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;Landroid/content/Context;)V", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "create", "Lexpo/modules/medialibrary/next/objects/album/Album;", "id", "", "createFromAssets", "albumName", "assets", "", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "deleteOriginalAssets", "", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFromFilePaths", "filePaths", "Landroid/net/Uri;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processAssetsLocation", "", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "processAssetsLocation-KTsBHyQ", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AlbumModernFactory implements AlbumFactory {
    private final AssetDeleter assetDeleter;
    private final AssetFactory assetFactory;
    private final AssetMover assetMover;
    private final WeakReference<Context> contextRef;

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.album.factories.AlbumModernFactory$createFromAssets$1, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumModernFactory.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.factories.AlbumModernFactory", f = "AlbumModernFactory.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {41, 43, 44}, m = "createFromAssets", n = {"albumName", "assets", "deleteOriginalAssets", "albumName", "assets", "deleteOriginalAssets", "mimeTypeOfFirstAsset", "albumRelativePath", "albumName", "assets", "deleteOriginalAssets", "mimeTypeOfFirstAsset", "albumRelativePath"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumModernFactory.this.createFromAssets(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.album.factories.AlbumModernFactory$createFromFilePaths$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumModernFactory.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.factories.AlbumModernFactory", f = "AlbumModernFactory.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {57, EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION}, m = "createFromFilePaths", n = {"albumName", "filePaths", "mimeType", "relativePath", "$this$forEach$iv", "element$iv", "filePath", "$i$f$forEach", "$i$a$-forEach-AlbumModernFactory$createFromFilePaths$2", "albumName", "filePaths", "mimeType", "relativePath"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3"})
    static final class C08951 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C08951(Continuation<? super C08951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumModernFactory.this.createFromFilePaths(null, null, this);
        }
    }

    public AlbumModernFactory(AssetFactory assetFactory, AssetDeleter assetDeleter, AssetMover assetMover, Context context) {
        Intrinsics.checkNotNullParameter(assetFactory, "assetFactory");
        Intrinsics.checkNotNullParameter(assetDeleter, "assetDeleter");
        Intrinsics.checkNotNullParameter(assetMover, "assetMover");
        Intrinsics.checkNotNullParameter(context, "context");
        this.assetFactory = assetFactory;
        this.assetDeleter = assetDeleter;
        this.assetMover = assetMover;
        this.contextRef = new WeakReference<>(context);
    }

    private final ContentResolver getContentResolver() throws AlbumCouldNotBeCreated {
        ContentResolver contentResolver = WeakReferenceExtensionsKt.getOrThrow(this.contextRef).getContentResolver();
        if (contentResolver != null) {
            return contentResolver;
        }
        throw new AlbumCouldNotBeCreated("Failed to create album: ContentResolver is unavailable.", null, 2, null);
    }

    @Override // expo.modules.medialibrary.next.objects.album.factories.AlbumFactory
    public Album create(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new Album(id, this.assetDeleter, this.assetFactory, this.assetMover, WeakReferenceExtensionsKt.getOrThrow(this.contextRef));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f9, code lost:
    
        if (r2 == r5) goto L34;
     */
    @Override // expo.modules.medialibrary.next.objects.album.factories.AlbumFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object createFromAssets(java.lang.String r17, java.util.List<expo.modules.medialibrary.next.objects.asset.Asset> r18, java.lang.Boolean r19, kotlin.coroutines.Continuation<? super expo.modules.medialibrary.next.objects.album.Album> r20) throws expo.modules.medialibrary.next.exceptions.AlbumCouldNotBeCreated, expo.modules.medialibrary.next.exceptions.AlbumNotFoundException {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.album.factories.AlbumModernFactory.createFromAssets(java.lang.String, java.util.List, java.lang.Boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:23:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00dd, code lost:
    
        if (r8.mo12019createBuevYFM(r15, r12, r3) == r4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x010e, code lost:
    
        if (r2 == r4) goto L25;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00dd -> B:22:0x00e0). Please report as a decompilation issue!!! */
    @Override // expo.modules.medialibrary.next.objects.album.factories.AlbumFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object createFromFilePaths(java.lang.String r17, java.util.List<? extends android.net.Uri> r18, kotlin.coroutines.Continuation<? super expo.modules.medialibrary.next.objects.album.Album> r19) throws expo.modules.medialibrary.next.exceptions.AlbumCouldNotBeCreated {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.album.factories.AlbumModernFactory.createFromFilePaths(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:? A[LOOP:0: B:24:0x00a5->B:34:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0091, code lost:
    
        if (r8.mo12024moveAssetsqTZuolk(r9, r10, r0) == r1) goto L28;
     */
    /* JADX INFO: renamed from: processAssetsLocation-KTsBHyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m12010processAssetsLocationKTsBHyQ(java.util.List<expo.modules.medialibrary.next.objects.asset.Asset> r9, java.lang.String r10, java.lang.Boolean r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.album.factories.AlbumModernFactory.m12010processAssetsLocationKTsBHyQ(java.util.List, java.lang.String, java.lang.Boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
