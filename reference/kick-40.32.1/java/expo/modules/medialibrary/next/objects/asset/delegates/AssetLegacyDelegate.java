package expo.modules.medialibrary.next.objects.asset.delegates;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.GapComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException;
import expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException;
import expo.modules.medialibrary.next.exceptions.PermissionException;
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
import expo.modules.medialibrary.next.permissions.SystemPermissionsDelegate;
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

/* JADX INFO: compiled from: AssetLegacyDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010*\u001a\u0004\u0018\u00010+H\u0096@¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u0004\u0018\u00010+H\u0096@¢\u0006\u0002\u0010,J\u000e\u0010.\u001a\u00020/H\u0096@¢\u0006\u0002\u0010,J\u000e\u00100\u001a\u000201H\u0096@¢\u0006\u0002\u0010,J\u000e\u00102\u001a\u000201H\u0096@¢\u0006\u0002\u0010,J\u0010\u00103\u001a\u0004\u0018\u000104H\u0096@¢\u0006\u0002\u0010,J\u000e\u00105\u001a\u000206H\u0096@¢\u0006\u0002\u0010,J\u0010\u00107\u001a\u0004\u0018\u00010+H\u0096@¢\u0006\u0002\u0010,J\u000e\u00108\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010,J\u000e\u00109\u001a\u00020:H\u0096@¢\u0006\u0002\u0010,J\u000e\u0010;\u001a\u00020<H\u0096@¢\u0006\u0002\u0010,J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020<H\u0096@¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020BH\u0096@¢\u0006\u0004\bC\u0010,J\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EH\u0096@¢\u0006\u0002\u0010,J\u0010\u0010G\u001a\u0004\u0018\u00010HH\u0096@¢\u0006\u0002\u0010,J\u000e\u0010I\u001a\u00020JH\u0096@¢\u0006\u0002\u0010,J\u000e\u0010K\u001a\u00020>H\u0096@¢\u0006\u0002\u0010,J\u0018\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020NH\u0096@¢\u0006\u0004\bO\u0010PJ\u0018\u0010Q\u001a\u00020R2\u0006\u0010M\u001a\u00020NH\u0096@¢\u0006\u0004\bS\u0010PR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00110\u00110!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006T"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/delegates/AssetLegacyDelegate;", "Lexpo/modules/medialibrary/next/objects/asset/delegates/AssetDelegate;", "contentUri", "Landroid/net/Uri;", "assetDeleter", "Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "assetMapper", "Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "assetDimensionsResolver", "Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "systemPermissionsDelegate", "Lexpo/modules/medialibrary/next/permissions/SystemPermissionsDelegate;", "assetFactory", "Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "assetMover", "Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/net/Uri;Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;Lexpo/modules/medialibrary/next/permissions/SystemPermissionsDelegate;Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;Landroid/content/Context;)V", "getAssetDeleter", "()Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "getAssetMapper", "()Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "getAssetDimensionsResolver", "()Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "getSystemPermissionsDelegate", "()Lexpo/modules/medialibrary/next/permissions/SystemPermissionsDelegate;", "getAssetFactory", "()Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "getAssetMover", "()Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "value", "getContentUri", "()Landroid/net/Uri;", "getCreationTime", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDuration", "getFilename", "", "getHeight", "", "getWidth", "getShape", "Lexpo/modules/medialibrary/next/records/Shape;", "getMediaType", "Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;", "getModificationTime", "getUri", "getInfo", "Lexpo/modules/medialibrary/next/records/AssetInfo;", "getFavorite", "", "setFavorite", "", "isFavorite", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "Lexpo/modules/medialibrary/next/objects/wrappers/MimeType;", "getMimeType-dctPOJs", "getAlbums", "", "Lexpo/modules/medialibrary/next/objects/album/Album;", "getLocation", "Lexpo/modules/medialibrary/next/records/Location;", "getExif", "Landroid/os/Bundle;", "delete", "move", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "move-dXLngQ8", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copy", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "copy-dXLngQ8", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetLegacyDelegate implements AssetDelegate {
    private final AssetDeleter assetDeleter;
    private final AssetDimensionsResolver assetDimensionsResolver;
    private final AssetFactory assetFactory;
    private final AssetMapper assetMapper;
    private final AssetMover assetMover;
    private Uri contentUri;
    private final WeakReference<Context> contextRef;
    private final SystemPermissionsDelegate systemPermissionsDelegate;

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getAlbums$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {1}, l = {148, 149}, m = "getAlbums", n = {"albumId"}, s = {"L$0"})
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
            return AssetLegacyDelegate.this.getAlbums(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getCreationTime$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {}, l = {76}, m = "getCreationTime", n = {}, s = {})
    static final class C08961 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08961(Continuation<? super C08961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetLegacyDelegate.this.getCreationTime(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getDuration$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {}, l = {EACTags.ANSWER_TO_RESET, 84}, m = "getDuration", n = {}, s = {})
    static final class C08971 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08971(Continuation<? super C08971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetLegacyDelegate.this.getDuration(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {}, l = {89}, m = "getFilename", n = {}, s = {})
    static final class C08991 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08991(Continuation<? super C08991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetLegacyDelegate.this.getFilename(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {1}, l = {93, 95}, m = "getHeight", n = {"mediaStoreItem"}, s = {"L$0"})
    static final class C09001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09001(Continuation<? super C09001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetLegacyDelegate.this.getHeight(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {1}, l = {132, WebmConstants.MkvEbmlElement.CODEC_ID}, m = "getInfo", n = {"mediaStoreItem"}, s = {"L$0"})
    static final class C09011 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09011(Continuation<? super C09011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetLegacyDelegate.this.getInfo(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getModificationTime$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {}, l = {119}, m = "getModificationTime", n = {}, s = {})
    static final class C09021 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09021(Continuation<? super C09021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetLegacyDelegate.this.getModificationTime(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getShape$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {1}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 111}, m = "getShape", n = {"mediaStoreItem"}, s = {"L$0"})
    static final class C09031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09031(Continuation<? super C09031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetLegacyDelegate.this.getShape(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getUri$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {}, l = {GapComposerKt.nodeKey}, m = "getUri", n = {}, s = {})
    static final class C09041 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09041(Continuation<? super C09041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetLegacyDelegate.this.getUri(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {1}, l = {101, 103}, m = "getWidth", n = {"mediaStoreItem"}, s = {"L$0"})
    static final class C09051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09051(Continuation<? super C09051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetLegacyDelegate.this.getWidth(this);
        }
    }

    public AssetLegacyDelegate(Uri contentUri, AssetDeleter assetDeleter, AssetMapper assetMapper, AssetDimensionsResolver assetDimensionsResolver, SystemPermissionsDelegate systemPermissionsDelegate, AssetFactory assetFactory, AssetMover assetMover, Context context) {
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        Intrinsics.checkNotNullParameter(assetDeleter, "assetDeleter");
        Intrinsics.checkNotNullParameter(assetMapper, "assetMapper");
        Intrinsics.checkNotNullParameter(assetDimensionsResolver, "assetDimensionsResolver");
        Intrinsics.checkNotNullParameter(systemPermissionsDelegate, "systemPermissionsDelegate");
        Intrinsics.checkNotNullParameter(assetFactory, "assetFactory");
        Intrinsics.checkNotNullParameter(assetMover, "assetMover");
        Intrinsics.checkNotNullParameter(context, "context");
        this.assetDeleter = assetDeleter;
        this.assetMapper = assetMapper;
        this.assetDimensionsResolver = assetDimensionsResolver;
        this.systemPermissionsDelegate = systemPermissionsDelegate;
        this.assetFactory = assetFactory;
        this.assetMover = assetMover;
        this.contextRef = new WeakReference<>(context);
        this.contentUri = contentUri;
    }

    public final AssetDeleter getAssetDeleter() {
        return this.assetDeleter;
    }

    public final AssetMapper getAssetMapper() {
        return this.assetMapper;
    }

    public final AssetDimensionsResolver getAssetDimensionsResolver() {
        return this.assetDimensionsResolver;
    }

    public final SystemPermissionsDelegate getSystemPermissionsDelegate() {
        return this.systemPermissionsDelegate;
    }

    public final AssetFactory getAssetFactory() {
        return this.assetFactory;
    }

    public final AssetMover getAssetMover() {
        return this.assetMover;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentResolver getContentResolver() throws ContentResolverNotObtainedException {
        ContentResolver contentResolver = WeakReferenceExtensionsKt.getOrThrow(this.contextRef).getContentResolver();
        if (contentResolver != null) {
            return contentResolver;
        }
        throw new ContentResolverNotObtainedException(null, 1, null);
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Uri getContentUri() {
        return this.contentUri;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getCreationTime(Continuation<? super Long> continuation) throws ContentResolverNotObtainedException {
        C08961 c08961;
        if (continuation instanceof C08961) {
            c08961 = (C08961) continuation;
            if ((c08961.label & Integer.MIN_VALUE) != 0) {
                c08961.label -= Integer.MIN_VALUE;
            } else {
                c08961 = new C08961(continuation);
            }
        } else {
            c08961 = new C08961(continuation);
        }
        Object objQueryAssetDateTaken = c08961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08961.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetDateTaken);
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            c08961.label = 1;
            objQueryAssetDateTaken = AssetExtensionsKt.queryAssetDateTaken(contentResolver, contentUri, c08961);
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
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C08971
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getDuration$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C08971) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getDuration$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getDuration$1
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
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.getDuration(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getFilename(Continuation<? super String> continuation) throws AssetPropertyNotFoundException, ContentResolverNotObtainedException {
        C08991 c08991;
        if (continuation instanceof C08991) {
            c08991 = (C08991) continuation;
            if ((c08991.label & Integer.MIN_VALUE) != 0) {
                c08991.label -= Integer.MIN_VALUE;
            } else {
                c08991 = new C08991(continuation);
            }
        } else {
            c08991 = new C08991(continuation);
        }
        Object objQueryAssetDisplayName = c08991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08991.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetDisplayName);
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            c08991.label = 1;
            objQueryAssetDisplayName = AssetExtensionsKt.queryAssetDisplayName(contentResolver, contentUri, c08991);
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
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C09001
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getHeight$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C09001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getHeight$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getHeight$1
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
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.getHeight(kotlin.coroutines.Continuation):java.lang.Object");
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
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C09051
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getWidth$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C09051) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getWidth$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getWidth$1
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
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.getWidth(kotlin.coroutines.Continuation):java.lang.Object");
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
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C09031
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getShape$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C09031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getShape$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getShape$1
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
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.getShape(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getMediaType(Continuation<? super MediaType> continuation) {
        return MediaType.INSTANCE.fromContentUri(getContentUri());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getModificationTime(Continuation<? super Long> continuation) throws ContentResolverNotObtainedException {
        C09021 c09021;
        if (continuation instanceof C09021) {
            c09021 = (C09021) continuation;
            if ((c09021.label & Integer.MIN_VALUE) != 0) {
                c09021.label -= Integer.MIN_VALUE;
            } else {
                c09021 = new C09021(continuation);
            }
        } else {
            c09021 = new C09021(continuation);
        }
        Object objQueryAssetDateModified = c09021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09021.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetDateModified);
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            c09021.label = 1;
            objQueryAssetDateModified = AssetExtensionsKt.queryAssetDateModified(contentResolver, contentUri, c09021);
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
        C09041 c09041;
        if (continuation instanceof C09041) {
            c09041 = (C09041) continuation;
            if ((c09041.label & Integer.MIN_VALUE) != 0) {
                c09041.label -= Integer.MIN_VALUE;
            } else {
                c09041 = new C09041(continuation);
            }
        } else {
            c09041 = new C09041(continuation);
        }
        Object objQueryAssetData = c09041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09041.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetData);
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = getContentUri();
            c09041.label = 1;
            objQueryAssetData = AssetExtensionsKt.queryAssetData(contentResolver, contentUri, c09041);
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
            boolean r0 = r6 instanceof expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C09011
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getInfo$1 r0 = (expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.C09011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getInfo$1 r0 = new expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getInfo$1
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
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.getInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object getFavorite(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(false);
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    public Object setFavorite(boolean z, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /* JADX INFO: renamed from: getMimeType-dctPOJs */
    public Object mo12015getMimeTypedctPOJs(Continuation<? super MimeType> continuation) {
        AssetLegacyDelegate$getMimeType$1 assetLegacyDelegate$getMimeType$1;
        MimeType.Companion companion;
        if (continuation instanceof AssetLegacyDelegate$getMimeType$1) {
            assetLegacyDelegate$getMimeType$1 = (AssetLegacyDelegate$getMimeType$1) continuation;
            if ((assetLegacyDelegate$getMimeType$1.label & Integer.MIN_VALUE) != 0) {
                assetLegacyDelegate$getMimeType$1.label -= Integer.MIN_VALUE;
            } else {
                assetLegacyDelegate$getMimeType$1 = new AssetLegacyDelegate$getMimeType$1(this, continuation);
            }
        } else {
            assetLegacyDelegate$getMimeType$1 = new AssetLegacyDelegate$getMimeType$1(this, continuation);
        }
        Object obj = assetLegacyDelegate$getMimeType$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = assetLegacyDelegate$getMimeType$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String type = getContentResolver().getType(getContentUri());
            if (type != null) {
                return MimeType.m12028constructorimpl(type);
            }
            MimeType.Companion companion2 = MimeType.INSTANCE;
            assetLegacyDelegate$getMimeType$1.L$0 = companion2;
            assetLegacyDelegate$getMimeType$1.label = 1;
            Object uri = getUri(assetLegacyDelegate$getMimeType$1);
            if (uri == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = uri;
            companion = companion2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            companion = (MimeType.Companion) assetLegacyDelegate$getMimeType$1.L$0;
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
    public Object getLocation(Continuation<? super Location> continuation) throws PermissionException, FileNotFoundException {
        Location location;
        this.systemPermissionsDelegate.requireReadPermissions();
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

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getExif$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$getExif$2", f = "AssetLegacyDelegate.kt", i = {0}, l = {WebmConstants.MkvEbmlElement.BLOCK_MORE}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    static final class C08982 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C08982(Continuation<? super C08982> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08982 c08982 = AssetLegacyDelegate.this.new C08982(continuation);
            c08982.L$0 = obj;
            return c08982;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bundle> continuation) {
            return ((C08982) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws PermissionException, FileNotFoundException {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AssetLegacyDelegate.this.getSystemPermissionsDelegate().requireReadPermissions();
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = AssetLegacyDelegate.this.getMediaType(this);
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
            InputStream inputStreamOpenInputStream = AssetLegacyDelegate.this.getContentResolver().openInputStream(AssetLegacyDelegate.this.getContentUri());
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
        return BuildersKt.withContext(Dispatchers.getIO(), new C08982(null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$delete$2, reason: invalid class name */
    /* JADX INFO: compiled from: AssetLegacyDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$delete$2", f = "AssetLegacyDelegate.kt", i = {}, l = {WebmConstants.MkvEbmlElement.CUE_POINT}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AssetLegacyDelegate.this.new AnonymousClass2(continuation);
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
                if (AssetLegacyDelegate.this.getAssetDeleter().delete(AssetLegacyDelegate.this.getContentUri(), this) == coroutine_suspended) {
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

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /* JADX INFO: renamed from: move-dXLngQ8 */
    public Object mo12016movedXLngQ8(String str, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AssetLegacyDelegate$move$2(this, str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate
    /* JADX INFO: renamed from: copy-dXLngQ8 */
    public Object mo12014copydXLngQ8(String str, Continuation<? super Asset> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AssetLegacyDelegate$copy$2(this, str, null), continuation);
    }
}
