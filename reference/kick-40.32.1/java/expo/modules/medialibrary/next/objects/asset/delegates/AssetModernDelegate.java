package expo.modules.medialibrary.next.objects.asset.delegates;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException;
import expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException;
import expo.modules.medialibrary.next.extensions.WeakReferenceExtensionsKt;
import expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt;
import expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt;
import expo.modules.medialibrary.next.objects.album.Album;
import expo.modules.medialibrary.next.objects.asset.Asset;
import expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver;
import expo.modules.medialibrary.next.objects.asset.AssetMapper;
import expo.modules.medialibrary.next.objects.asset.ExifTagsKt;
import expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter;
import expo.modules.medialibrary.next.objects.asset.factories.AssetFactory;
import expo.modules.medialibrary.next.objects.asset.movers.AssetMover;
import expo.modules.medialibrary.next.objects.wrappers.MediaType;
import expo.modules.medialibrary.next.objects.wrappers.MimeType;
import expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate;
import expo.modules.medialibrary.next.records.Location;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: AssetModernDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010)\u001a\u0004\u0018\u00010*H\u0096@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u0004\u0018\u00010*H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010-\u001a\u00020.H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010/\u001a\u000200H\u0096@¢\u0006\u0002\u0010+J\u000e\u00101\u001a\u000200H\u0096@¢\u0006\u0002\u0010+J\u0010\u00102\u001a\u0004\u0018\u000103H\u0096@¢\u0006\u0002\u0010+J\u000e\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u0010+J\u0010\u00106\u001a\u0004\u0018\u00010*H\u0096@¢\u0006\u0002\u0010+J\u000e\u00107\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010+J\u000e\u00108\u001a\u000209H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010:\u001a\u00020;H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020;H\u0096@¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020AH\u0096@¢\u0006\u0004\bB\u0010+J\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0096@¢\u0006\u0002\u0010+J\u0010\u0010F\u001a\u0004\u0018\u00010GH\u0096@¢\u0006\u0002\u0010+J\u000e\u0010H\u001a\u00020IH\u0096@¢\u0006\u0002\u0010+J\u000e\u0010J\u001a\u00020=H\u0096@¢\u0006\u0002\u0010+J\u0018\u0010K\u001a\u00020=2\u0006\u0010L\u001a\u00020MH\u0096@¢\u0006\u0004\bN\u0010OJ\u0018\u0010P\u001a\u00020Q2\u0006\u0010L\u001a\u00020MH\u0096@¢\u0006\u0004\bR\u0010OJ \u0010S\u001a\u00020Q2\u0006\u0010L\u001a\u00020M2\u0006\u0010T\u001a\u00020;H\u0082@¢\u0006\u0004\bU\u0010VR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\u00110\u00110#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006W"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/delegates/AssetModernDelegate;", "Lexpo/modules/medialibrary/next/objects/asset/delegates/AssetDelegate;", "contentUri", "Landroid/net/Uri;", "assetDeleter", "Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "assetMover", "Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "assetMapper", "Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "assetDimensionsResolver", "Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "mediaStorePermissionsDelegate", "Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;", "assetFactory", "Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/net/Uri;Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;Landroid/content/Context;)V", "getContentUri", "()Landroid/net/Uri;", "getAssetDeleter", "()Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "getAssetMover", "()Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "getAssetMapper", "()Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "getAssetDimensionsResolver", "()Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "getMediaStorePermissionsDelegate", "()Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;", "getAssetFactory", "()Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "getCreationTime", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDuration", "getFilename", "", "getHeight", "", "getWidth", "getShape", "Lexpo/modules/medialibrary/next/records/Shape;", "getMediaType", "Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;", "getModificationTime", "getUri", "getInfo", "Lexpo/modules/medialibrary/next/records/AssetInfo;", "getFavorite", "", "setFavorite", "", "isFavorite", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "Lexpo/modules/medialibrary/next/objects/wrappers/MimeType;", "getMimeType-dctPOJs", "getAlbums", "", "Lexpo/modules/medialibrary/next/objects/album/Album;", "getLocation", "Lexpo/modules/medialibrary/next/records/Location;", "getExif", "Landroid/os/Bundle;", "delete", "move", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "move-dXLngQ8", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copy", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "copy-dXLngQ8", "copyInternal", "forceUniqueName", "copyInternal-v-FDBtY", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetModernDelegate implements AssetDelegate {
    private final AssetDeleter assetDeleter;
    private final AssetDimensionsResolver assetDimensionsResolver;
    private final AssetFactory assetFactory;
    private final AssetMapper assetMapper;
    private final AssetMover assetMover;
    private final Uri contentUri;
    private final WeakReference<Context> contextRef;
    private final MediaStorePermissionsDelegate mediaStorePermissionsDelegate;

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getAlbums$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {1}, l = {WebmConstants.MkvEbmlElement.CHANNELS, WebmConstants.MkvEbmlElement.BLOCK_GROUP}, m = "getAlbums", n = {"albumId"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getAlbums(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getCreationTime$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {}, l = {73}, m = "getCreationTime", n = {}, s = {})
    static final class C09061 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09061(Continuation<? super C09061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getCreationTime(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getDuration$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {}, l = {78, EACTags.ANSWER_TO_RESET}, m = "getDuration", n = {}, s = {})
    static final class C09071 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09071(Continuation<? super C09071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getDuration(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getFavorite$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {}, l = {WebmConstants.MkvEbmlElement.FLAG_DEFAULT}, m = "getFavorite", n = {}, s = {})
    static final class C09091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09091(Continuation<? super C09091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getFavorite(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {}, l = {86}, m = "getFilename", n = {}, s = {})
    static final class C09101 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09101(Continuation<? super C09101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getFilename(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {1}, l = {RotationOptions.ROTATE_90, 92}, m = "getHeight", n = {"mediaStoreItem"}, s = {"L$0"})
    static final class C09111 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09111(Continuation<? super C09111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getHeight(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {1}, l = {129, WebmConstants.MkvEbmlElement.TRACK_TYPE}, m = "getInfo", n = {"mediaStoreItem"}, s = {"L$0"})
    static final class C09121 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09121(Continuation<? super C09121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getInfo(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getModificationTime$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {}, l = {116}, m = "getModificationTime", n = {}, s = {})
    static final class C09131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09131(Continuation<? super C09131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getModificationTime(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getShape$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {1}, l = {106, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "getShape", n = {"mediaStoreItem"}, s = {"L$0"})
    static final class C09141 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09141(Continuation<? super C09141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getShape(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getUri$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {}, l = {122}, m = "getUri", n = {}, s = {})
    static final class C09151 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09151(Continuation<? super C09151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getUri(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {1}, l = {98, 100}, m = "getWidth", n = {"mediaStoreItem"}, s = {"L$0"})
    static final class C09161 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09161(Continuation<? super C09161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModernDelegate.this.getWidth(this);
        }
    }

    public AssetModernDelegate(Uri contentUri, AssetDeleter assetDeleter, AssetMover assetMover, AssetMapper assetMapper, AssetDimensionsResolver assetDimensionsResolver, MediaStorePermissionsDelegate mediaStorePermissionsDelegate, AssetFactory assetFactory, Context context) {
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        Intrinsics.checkNotNullParameter(assetDeleter, "assetDeleter");
        Intrinsics.checkNotNullParameter(assetMover, "assetMover");
        Intrinsics.checkNotNullParameter(assetMapper, "assetMapper");
        Intrinsics.checkNotNullParameter(assetDimensionsResolver, "assetDimensionsResolver");
        Intrinsics.checkNotNullParameter(mediaStorePermissionsDelegate, "mediaStorePermissionsDelegate");
        Intrinsics.checkNotNullParameter(assetFactory, "assetFactory");
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentUri = contentUri;
        this.assetDeleter = assetDeleter;
        this.assetMover = assetMover;
        this.assetMapper = assetMapper;
        this.assetDimensionsResolver = assetDimensionsResolver;
        this.mediaStorePermissionsDelegate = mediaStorePermissionsDelegate;
        this.assetFactory = assetFactory;
        this.contextRef = new WeakReference<>(context);
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Uri getContentUri() {
        return this.contentUri;
    }

    public final AssetDeleter getAssetDeleter() {
        return this.assetDeleter;
    }

    public final AssetMover getAssetMover() {
        return this.assetMover;
    }

    public final AssetMapper getAssetMapper() {
        return this.assetMapper;
    }

    public final AssetDimensionsResolver getAssetDimensionsResolver() {
        return this.assetDimensionsResolver;
    }

    public final MediaStorePermissionsDelegate getMediaStorePermissionsDelegate() {
        return this.mediaStorePermissionsDelegate;
    }

    public final AssetFactory getAssetFactory() {
        return this.assetFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentResolver getContentResolver() throws ContentResolverNotObtainedException {
        ContentResolver contentResolver = WeakReferenceExtensionsKt.getOrThrow(this.contextRef).getContentResolver();
        if (contentResolver != null) {
            return contentResolver;
        }
        throw new ContentResolverNotObtainedException(null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getCreationTime(Continuation<? super Long> continuation) throws ContentResolverNotObtainedException {
        C09061 c09061;
        if (continuation instanceof C09061) {
            c09061 = (C09061) continuation;
            if ((c09061.label & Integer.MIN_VALUE) != 0) {
                c09061.label -= Integer.MIN_VALUE;
            } else {
                c09061 = new C09061(continuation);
            }
        } else {
            c09061 = new C09061(continuation);
        }
        Object objQueryAssetDateTaken = c09061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09061.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetDateTaken);
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            c09061.label = 1;
            objQueryAssetDateTaken = AssetExtensionsKt.queryAssetDateTaken(contentResolver, contentUri, c09061);
            if (objQueryAssetDateTaken == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryAssetDateTaken);
        }
        return this.assetMapper.mapCreationTime((Long) objQueryAssetDateTaken);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        if (r6 == r1) goto L25;
     */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getDuration(kotlin.coroutines.Continuation<? super java.lang.Long> r6) throws expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09071
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getDuration$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09071) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getDuration$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getDuration$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5c
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r4
            java.lang.Object r6 = r5.getMediaType(r0)
            if (r6 != r1) goto L45
            goto L5b
        L45:
            expo.modules.medialibrary.next.objects.wrappers.MediaType r2 = expo.modules.medialibrary.next.objects.wrappers.MediaType.VIDEO
            if (r6 == r2) goto L4b
            r5 = 0
            return r5
        L4b:
            android.content.ContentResolver r6 = r5.getContentResolver()
            android.net.Uri r2 = r5.getContentUri()
            r0.label = r3
            java.lang.Object r6 = expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt.queryAssetDuration(r6, r2, r0)
            if (r6 != r1) goto L5c
        L5b:
            return r1
        L5c:
            java.lang.Long r6 = (java.lang.Long) r6
            expo.modules.medialibrary.next.objects.asset.AssetMapper r5 = r5.assetMapper
            java.lang.Long r5 = r5.mapDuration(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.getDuration(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getFilename(Continuation<? super String> continuation) throws AssetPropertyNotFoundException, ContentResolverNotObtainedException {
        C09101 c09101;
        if (continuation instanceof C09101) {
            c09101 = (C09101) continuation;
            if ((c09101.label & Integer.MIN_VALUE) != 0) {
                c09101.label -= Integer.MIN_VALUE;
            } else {
                c09101 = new C09101(continuation);
            }
        } else {
            c09101 = new C09101(continuation);
        }
        Object objQueryAssetDisplayName = c09101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09101.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetDisplayName);
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            c09101.label = 1;
            objQueryAssetDisplayName = AssetExtensionsKt.queryAssetDisplayName(contentResolver, contentUri, c09101);
            if (objQueryAssetDisplayName == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryAssetDisplayName);
        }
        String str = (String) objQueryAssetDisplayName;
        if (str != null) {
            return str;
        }
        throw new AssetPropertyNotFoundException("Filename", null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        if (r6 == r1) goto L23;
     */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getHeight(kotlin.coroutines.Continuation<? super java.lang.Integer> r6) throws expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException, expo.modules.medialibrary.next.exceptions.AssetNotFoundException, expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09111
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getHeight$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09111) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getHeight$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getHeight$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L3d
            if (r2 == r3) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r0 = r0.L$0
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r0 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L66
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L51
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            android.content.ContentResolver r6 = r5.getContentResolver()
            android.net.Uri r2 = r5.getContentUri()
            r0.label = r3
            java.lang.Object r6 = expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt.queryAssetMediaStoreItem(r6, r2, r0)
            if (r6 != r1) goto L51
            goto L65
        L51:
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r6 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r6
            if (r6 == 0) goto L82
            expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver r2 = r5.assetDimensionsResolver
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r6 = r2.resolveDimensions(r6, r0)
            if (r6 != r1) goto L66
        L65:
            return r1
        L66:
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r6 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r6
            expo.modules.medialibrary.next.objects.asset.AssetMapper r5 = r5.assetMapper
            expo.modules.medialibrary.next.records.Shape r5 = r5.mapShape(r6)
            if (r5 == 0) goto L79
            int r5 = r5.getHeight()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        L79:
            expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException r5 = new expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException
            java.lang.String r6 = "Height"
            r0 = 0
            r5.<init>(r6, r0, r4, r0)
            throw r5
        L82:
            expo.modules.medialibrary.next.exceptions.AssetNotFoundException r6 = new expo.modules.medialibrary.next.exceptions.AssetNotFoundException
            android.net.Uri r5 = r5.getContentUri()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.getHeight(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        if (r6 == r1) goto L23;
     */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getWidth(kotlin.coroutines.Continuation<? super java.lang.Integer> r6) throws expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException, expo.modules.medialibrary.next.exceptions.AssetNotFoundException, expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09161
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getWidth$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getWidth$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getWidth$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L3d
            if (r2 == r3) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r0 = r0.L$0
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r0 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L66
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L51
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            android.content.ContentResolver r6 = r5.getContentResolver()
            android.net.Uri r2 = r5.getContentUri()
            r0.label = r3
            java.lang.Object r6 = expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt.queryAssetMediaStoreItem(r6, r2, r0)
            if (r6 != r1) goto L51
            goto L65
        L51:
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r6 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r6
            if (r6 == 0) goto L82
            expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver r2 = r5.assetDimensionsResolver
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r6 = r2.resolveDimensions(r6, r0)
            if (r6 != r1) goto L66
        L65:
            return r1
        L66:
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r6 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r6
            expo.modules.medialibrary.next.objects.asset.AssetMapper r5 = r5.assetMapper
            expo.modules.medialibrary.next.records.Shape r5 = r5.mapShape(r6)
            if (r5 == 0) goto L79
            int r5 = r5.getWidth()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        L79:
            expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException r5 = new expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException
            java.lang.String r6 = "Width"
            r0 = 0
            r5.<init>(r6, r0, r4, r0)
            throw r5
        L82:
            expo.modules.medialibrary.next.exceptions.AssetNotFoundException r6 = new expo.modules.medialibrary.next.exceptions.AssetNotFoundException
            android.net.Uri r5 = r5.getContentUri()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.getWidth(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        if (r6 == r1) goto L23;
     */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getShape(kotlin.coroutines.Continuation<? super expo.modules.medialibrary.next.records.Shape> r6) throws expo.modules.medialibrary.next.exceptions.AssetNotFoundException, expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09141
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getShape$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09141) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getShape$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getShape$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r0 = r0.L$0
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r0 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L66
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L51
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            android.content.ContentResolver r6 = r5.getContentResolver()
            android.net.Uri r2 = r5.getContentUri()
            r0.label = r4
            java.lang.Object r6 = expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt.queryAssetMediaStoreItem(r6, r2, r0)
            if (r6 != r1) goto L51
            goto L65
        L51:
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r6 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r6
            if (r6 == 0) goto L6f
            expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver r2 = r5.assetDimensionsResolver
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r2.resolveDimensions(r6, r0)
            if (r6 != r1) goto L66
        L65:
            return r1
        L66:
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r6 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r6
            expo.modules.medialibrary.next.objects.asset.AssetMapper r5 = r5.assetMapper
            expo.modules.medialibrary.next.records.Shape r5 = r5.mapShape(r6)
            return r5
        L6f:
            expo.modules.medialibrary.next.exceptions.AssetNotFoundException r6 = new expo.modules.medialibrary.next.exceptions.AssetNotFoundException
            android.net.Uri r5 = r5.getContentUri()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.getShape(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getMediaType(Continuation<? super MediaType> continuation) {
        return MediaType.INSTANCE.fromContentUri(getContentUri());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getModificationTime(Continuation<? super Long> continuation) throws ContentResolverNotObtainedException {
        C09131 c09131;
        if (continuation instanceof C09131) {
            c09131 = (C09131) continuation;
            if ((c09131.label & Integer.MIN_VALUE) != 0) {
                c09131.label -= Integer.MIN_VALUE;
            } else {
                c09131 = new C09131(continuation);
            }
        } else {
            c09131 = new C09131(continuation);
        }
        Object objQueryAssetDateModified = c09131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09131.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetDateModified);
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            c09131.label = 1;
            objQueryAssetDateModified = AssetExtensionsKt.queryAssetDateModified(contentResolver, contentUri, c09131);
            if (objQueryAssetDateModified == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryAssetDateModified);
        }
        return this.assetMapper.mapModificationTime((Long) objQueryAssetDateModified);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getUri(Continuation<? super Uri> continuation) throws AssetPropertyNotFoundException, ContentResolverNotObtainedException {
        C09151 c09151;
        if (continuation instanceof C09151) {
            c09151 = (C09151) continuation;
            if ((c09151.label & Integer.MIN_VALUE) != 0) {
                c09151.label -= Integer.MIN_VALUE;
            } else {
                c09151 = new C09151(continuation);
            }
        } else {
            c09151 = new C09151(continuation);
        }
        Object objQueryAssetData = c09151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetData);
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            c09151.label = 1;
            objQueryAssetData = AssetExtensionsKt.queryAssetData(contentResolver, contentUri, c09151);
            if (objQueryAssetData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryAssetData);
        }
        Uri uriMapUri = this.assetMapper.mapUri((String) objQueryAssetData);
        if (uriMapUri != null) {
            return uriMapUri;
        }
        throw new AssetPropertyNotFoundException("Uri", null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        if (r6 == r1) goto L23;
     */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getInfo(kotlin.coroutines.Continuation<? super expo.modules.medialibrary.next.records.AssetInfo> r6) throws expo.modules.medialibrary.next.exceptions.AssetNotFoundException, expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09121
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getInfo$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.C09121) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getInfo$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getInfo$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r0 = r0.L$0
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r0 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L66
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L51
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            android.content.ContentResolver r6 = r5.getContentResolver()
            android.net.Uri r2 = r5.getContentUri()
            r0.label = r4
            java.lang.Object r6 = expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt.queryAssetMediaStoreItem(r6, r2, r0)
            if (r6 != r1) goto L51
            goto L65
        L51:
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r6 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r6
            if (r6 == 0) goto L6f
            expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver r2 = r5.assetDimensionsResolver
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r2.resolveDimensions(r6, r0)
            if (r6 != r1) goto L66
        L65:
            return r1
        L66:
            expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem r6 = (expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem) r6
            expo.modules.medialibrary.next.objects.asset.AssetMapper r5 = r5.assetMapper
            expo.modules.medialibrary.next.records.AssetInfo r5 = r5.toDto(r6)
            return r5
        L6f:
            expo.modules.medialibrary.next.exceptions.AssetNotFoundException r6 = new expo.modules.medialibrary.next.exceptions.AssetNotFoundException
            android.net.Uri r5 = r5.getContentUri()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.getInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getFavorite(Continuation<? super Boolean> continuation) throws ContentResolverNotObtainedException {
        C09091 c09091;
        AssetMapper assetMapper;
        if (continuation instanceof C09091) {
            c09091 = (C09091) continuation;
            if ((c09091.label & Integer.MIN_VALUE) != 0) {
                c09091.label -= Integer.MIN_VALUE;
            } else {
                c09091 = new C09091(continuation);
            }
        } else {
            c09091 = new C09091(continuation);
        }
        Object obj = c09091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AssetMapper assetMapper2 = this.assetMapper;
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            c09091.L$0 = assetMapper2;
            c09091.label = 1;
            Object objQueryAssetIsFavorite = AssetExtensionsKt.queryAssetIsFavorite(contentResolver, contentUri, c09091);
            if (objQueryAssetIsFavorite == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objQueryAssetIsFavorite;
            assetMapper = assetMapper2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            assetMapper = (AssetMapper) c09091.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(assetMapper.mapIsFavorite((Integer) obj));
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$setFavorite$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$setFavorite$2", f = "AssetModernDelegate.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
    static final class C09172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFavorite;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09172(boolean z, Continuation<? super C09172> continuation) {
            super(2, continuation);
            this.$isFavorite = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AssetModernDelegate.this.new C09172(this.$isFavorite, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09172) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AssetModernDelegate.this.getMediaStorePermissionsDelegate().requestMediaLibraryWritePermission(CollectionsKt.listOf(AssetModernDelegate.this.getContentUri()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_favorite", Boxing.boxInt(this.$isFavorite ? 1 : 0));
            AssetExtensionsKt.safeUpdate(AssetModernDelegate.this.getContentResolver(), AssetModernDelegate.this.getContentUri(), contentValues);
            return Unit.INSTANCE;
        }
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object setFavorite(boolean z, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C09172(z, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /* JADX INFO: renamed from: getMimeType-dctPOJs */
    public Object mo12015getMimeTypedctPOJs(Continuation<? super MimeType> continuation) {
        AssetModernDelegate$getMimeType$1 assetModernDelegate$getMimeType$1;
        MimeType.Companion companion;
        if (continuation instanceof AssetModernDelegate$getMimeType$1) {
            assetModernDelegate$getMimeType$1 = (AssetModernDelegate$getMimeType$1) continuation;
            if ((assetModernDelegate$getMimeType$1.label & Integer.MIN_VALUE) != 0) {
                assetModernDelegate$getMimeType$1.label -= Integer.MIN_VALUE;
            } else {
                assetModernDelegate$getMimeType$1 = new AssetModernDelegate$getMimeType$1(this, continuation);
            }
        } else {
            assetModernDelegate$getMimeType$1 = new AssetModernDelegate$getMimeType$1(this, continuation);
        }
        Object obj = assetModernDelegate$getMimeType$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = assetModernDelegate$getMimeType$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String type = getContentResolver().getType(getContentUri());
            if (type != null) {
                return MimeType.m12028constructorimpl(type);
            }
            MimeType.Companion companion2 = MimeType.INSTANCE;
            assetModernDelegate$getMimeType$1.L$0 = companion2;
            assetModernDelegate$getMimeType$1.label = 1;
            Object uri = getUri(assetModernDelegate$getMimeType$1);
            if (uri == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = uri;
            companion = companion2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            companion = (MimeType.Companion) assetModernDelegate$getMimeType$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return companion.m12041fromdctPOJs((Uri) obj);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0070  */
    /* JADX WARN: Code duplicated, block: B:31:0x0075  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getAlbums(Continuation<? super List<Album>> continuation) throws ContentResolverNotObtainedException {
        AnonymousClass1 anonymousClass1;
        String string;
        String str;
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
        Object objQueryAssetBucketId = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetBucketId);
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            anonymousClass1.label = 1;
            objQueryAssetBucketId = AssetExtensionsKt.queryAssetBucketId(contentResolver, contentUri, anonymousClass1);
            if (objQueryAssetBucketId != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(objQueryAssetBucketId);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str2 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objQueryAssetBucketId);
            str = str2;
        }
        if (objQueryAssetBucketId == null) {
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.listOf(new Album(str, this.assetDeleter, this.assetFactory, this.assetMover, WeakReferenceExtensionsKt.getOrThrow(this.contextRef)));
        Integer num = (Integer) objQueryAssetBucketId;
        if (num == null || (string = num.toString()) == null) {
            return CollectionsKt.emptyList();
        }
        ContentResolver contentResolver2 = getContentResolver();
        anonymousClass1.L$0 = string;
        anonymousClass1.label = 2;
        Object objQueryAlbumTitle = AlbumExtensionsKt.queryAlbumTitle(contentResolver2, string, anonymousClass1);
        if (objQueryAlbumTitle != coroutine_suspended) {
            str = string;
            objQueryAssetBucketId = objQueryAlbumTitle;
            if (objQueryAssetBucketId == null) {
                return CollectionsKt.emptyList();
            }
            return CollectionsKt.listOf(new Album(str, this.assetDeleter, this.assetFactory, this.assetMover, WeakReferenceExtensionsKt.getOrThrow(this.contextRef)));
        }
        return coroutine_suspended;
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getLocation(Continuation<? super Location> continuation) throws FileNotFoundException {
        Location location;
        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(getContentUri());
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        InputStream inputStream = inputStreamOpenInputStream;
        try {
            double[] latLong = new ExifInterface(inputStream).getLatLong();
            if (latLong != null) {
                location = new Location(Boxing.boxDouble(latLong[0]), Boxing.boxDouble(latLong[1]));
            } else {
                location = null;
            }
            CloseableKt.closeFinally(inputStream, null);
            return location;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getExif$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$getExif$2", f = "AssetModernDelegate.kt", i = {0}, l = {WebmConstants.MkvEbmlElement.TRACK_ENTRY}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    static final class C09082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C09082(Continuation<? super C09082> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09082 c09082 = AssetModernDelegate.this.new C09082(continuation);
            c09082.L$0 = obj;
            return c09082;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bundle> continuation) {
            return ((C09082) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws FileNotFoundException {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = AssetModernDelegate.this.getMediaType(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (obj != MediaType.IMAGE) {
                return new Bundle();
            }
            Bundle bundle = new Bundle();
            InputStream inputStreamOpenInputStream = AssetModernDelegate.this.getContentResolver().openInputStream(AssetModernDelegate.this.getContentUri());
            if (inputStreamOpenInputStream == null) {
                return bundle;
            }
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                CoroutineScopeKt.ensureActive(coroutineScope);
                ExifInterface exifInterface = new ExifInterface(inputStream);
                for (String[] strArr : ExifTagsKt.getEXIF_TAGS()) {
                    String str = strArr[0];
                    String str2 = strArr[1];
                    if (exifInterface.getAttribute(str2) != null) {
                        int iHashCode = str.hashCode();
                        if (iHashCode != -1325958191) {
                            if (iHashCode != -891985903) {
                                if (iHashCode == 104431 && str.equals("int")) {
                                    bundle.putInt(str2, exifInterface.getAttributeInt(str2, 0));
                                }
                            } else if (str.equals(TypedValues.Custom.S_STRING)) {
                                bundle.putString(str2, exifInterface.getAttribute(str2));
                            }
                        } else if (str.equals("double")) {
                            bundle.putDouble(str2, exifInterface.getAttributeDouble(str2, 0.0d));
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStream, null);
                return bundle;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getExif(Continuation<? super Bundle> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C09082(null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$delete$2, reason: invalid class name */
    /* JADX INFO: compiled from: AssetModernDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$delete$2", f = "AssetModernDelegate.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AssetModernDelegate.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AssetModernDelegate.this.getAssetDeleter().delete(AssetModernDelegate.this.getContentUri(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object delete(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008c, code lost:
    
        if (r8 == r1) goto L28;
     */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /* JADX INFO: renamed from: move-dXLngQ8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo12016movedXLngQ8(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException, expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$move$1
            if (r0 == 0) goto L14
            r0 = r8
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$move$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$move$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$move$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$move$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$1
            java.lang.IllegalStateException r7 = (java.lang.IllegalStateException) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8f
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5f
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate r8 = r6.mediaStorePermissionsDelegate
            android.net.Uri r2 = r6.getContentUri()
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.requestMediaLibraryWritePermission(r2, r0)
            if (r8 != r1) goto L5f
            goto L8e
        L5f:
            android.content.ContentResolver r8 = r6.getContentResolver()     // Catch: java.lang.IllegalStateException -> L6b
            android.net.Uri r2 = r6.getContentUri()     // Catch: java.lang.IllegalStateException -> L6b
            expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt.m12002updateRelativePathXUFtwTY(r8, r2, r7)     // Catch: java.lang.IllegalStateException -> L6b
            goto La0
        L6b:
            r8 = move-exception
            java.lang.String r2 = r8.getMessage()
            if (r2 == 0) goto La3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r5 = "Failed to build unique file"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.text.StringsKt.contains(r2, r5, r4)
            if (r2 != r4) goto La3
            r0.L$0 = r7
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r8 = r6.getUri(r0)
            if (r8 != r1) goto L8f
        L8e:
            return r1
        L8f:
            android.net.Uri r8 = (android.net.Uri) r8
            java.lang.String r8 = expo.modules.medialibrary.next.objects.asset.factories.BuildUniqueDisplayNameKt.buildUniqueDisplayName(r8)
            android.content.ContentResolver r0 = r6.getContentResolver()
            android.net.Uri r6 = r6.getContentUri()
            expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt.m12003updateRelativePathAndNameSGAlvP8(r0, r6, r7, r8)
        La0:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        La3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate.mo12016movedXLngQ8(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /* JADX INFO: renamed from: copy-dXLngQ8 */
    public Object mo12014copydXLngQ8(String str, Continuation<? super Asset> continuation) {
        return m12018copyInternalvFDBtY(str, false, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: copyInternal-v-FDBtY, reason: not valid java name */
    public final Object m12018copyInternalvFDBtY(String str, boolean z, Continuation<? super Asset> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AssetModernDelegate$copyInternal$2(z, this, str, null), continuation);
    }
}
