package expo.modules.medialibrary.next.objects.asset.factories;

import android.content.ContentResolver;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import androidx.core.net.UriKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.medialibrary.next.exceptions.AssetCouldNotBeCreated;
import expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException;
import expo.modules.medialibrary.next.exceptions.PermissionException;
import expo.modules.medialibrary.next.extensions.FileExtensionsKt;
import expo.modules.medialibrary.next.extensions.WeakReferenceExtensionsKt;
import expo.modules.medialibrary.next.objects.asset.Asset;
import expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver;
import expo.modules.medialibrary.next.objects.asset.AssetMapper;
import expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate;
import expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate;
import expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter;
import expo.modules.medialibrary.next.objects.asset.movers.AssetMover;
import expo.modules.medialibrary.next.objects.wrappers.MimeType;
import expo.modules.medialibrary.next.objects.wrappers.RelativePath;
import expo.modules.medialibrary.next.permissions.SystemPermissionsDelegate;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AssetLegacyFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0016J\"\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096@¢\u0006\u0004\b*\u0010+J!\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b.\u0010/JB\u00100\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0006\u0012\u0004\u0018\u00010$012\u0006\u0010\f\u001a\u00020\r2\f\u00103\u001a\b\u0012\u0004\u0012\u000202042\u000e\u00105\u001a\n\u0012\u0004\u0012\u000202\u0018\u000104H\u0082@¢\u0006\u0002\u00106R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\r0\r0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u00067"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/factories/AssetLegacyFactory;", "Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "assetDeleter", "Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "assetMover", "Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "assetMapper", "Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "assetDimensionsResolver", "Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "systemPermissionsDelegate", "Lexpo/modules/medialibrary/next/permissions/SystemPermissionsDelegate;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;Lexpo/modules/medialibrary/next/permissions/SystemPermissionsDelegate;Landroid/content/Context;)V", "getAssetDeleter", "()Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "getAssetMover", "()Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "getAssetMapper", "()Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "getAssetDimensionsResolver", "()Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "getSystemPermissionsDelegate", "()Lexpo/modules/medialibrary/next/permissions/SystemPermissionsDelegate;", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "createAssetDelegate", "Lexpo/modules/medialibrary/next/objects/asset/delegates/AssetDelegate;", "contentUri", "Landroid/net/Uri;", "create", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "filePath", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "create-BuevYFM", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDestinationDirectory", "Ljava/io/File;", "createDestinationDirectory-mc4yU64", "(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/File;", "scanFile", "Lkotlin/Pair;", "", "paths", "", "mimeTypes", "(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetLegacyFactory implements AssetFactory {
    private final AssetDeleter assetDeleter;
    private final AssetDimensionsResolver assetDimensionsResolver;
    private final AssetMapper assetMapper;
    private final AssetMover assetMover;
    private final WeakReference<Context> contextRef;
    private final SystemPermissionsDelegate systemPermissionsDelegate;

    public AssetLegacyFactory(AssetDeleter assetDeleter, AssetMover assetMover, AssetMapper assetMapper, AssetDimensionsResolver assetDimensionsResolver, SystemPermissionsDelegate systemPermissionsDelegate, Context context) {
        Intrinsics.checkNotNullParameter(assetDeleter, "assetDeleter");
        Intrinsics.checkNotNullParameter(assetMover, "assetMover");
        Intrinsics.checkNotNullParameter(assetMapper, "assetMapper");
        Intrinsics.checkNotNullParameter(assetDimensionsResolver, "assetDimensionsResolver");
        Intrinsics.checkNotNullParameter(systemPermissionsDelegate, "systemPermissionsDelegate");
        Intrinsics.checkNotNullParameter(context, "context");
        this.assetDeleter = assetDeleter;
        this.assetMover = assetMover;
        this.assetMapper = assetMapper;
        this.assetDimensionsResolver = assetDimensionsResolver;
        this.systemPermissionsDelegate = systemPermissionsDelegate;
        this.contextRef = new WeakReference<>(context);
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

    public final SystemPermissionsDelegate getSystemPermissionsDelegate() {
        return this.systemPermissionsDelegate;
    }

    private final ContentResolver getContentResolver() throws ContentResolverNotObtainedException {
        ContentResolver contentResolver = WeakReferenceExtensionsKt.getOrThrow(this.contextRef).getContentResolver();
        if (contentResolver != null) {
            return contentResolver;
        }
        throw new ContentResolverNotObtainedException(null, 1, null);
    }

    private final AssetDelegate createAssetDelegate(Uri contentUri) {
        return new AssetLegacyDelegate(contentUri, this.assetDeleter, this.assetMapper, this.assetDimensionsResolver, this.systemPermissionsDelegate, this, this.assetMover, WeakReferenceExtensionsKt.getOrThrow(this.contextRef));
    }

    @Override // expo.modules.medialibrary.next.objects.asset.factories.AssetFactory
    public Asset create(Uri contentUri) {
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        return new Asset(createAssetDelegate(contentUri));
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.factories.AssetLegacyFactory$create$2, reason: invalid class name */
    /* JADX INFO: compiled from: AssetLegacyFactory.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.factories.AssetLegacyFactory$create$2", f = "AssetLegacyFactory.kt", i = {0, 0, 0}, l = {62}, m = "invokeSuspend", n = {"$this$withContext", "destinationDirectory", "destinationFile"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Asset>, Object> {
        final /* synthetic */ Uri $filePath;
        final /* synthetic */ String $relativePath;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Uri uri, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$filePath = uri;
            this.$relativePath = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = AssetLegacyFactory.this.new AnonymousClass2(this.$filePath, this.$relativePath, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Asset> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws PermissionException, IOException, AssetCouldNotBeCreated, Exceptions.ReactContextLost {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AssetLegacyFactory.this.getSystemPermissionsDelegate().requireWritePermissions();
                File fileM12021createDestinationDirectorymc4yU64 = AssetLegacyFactory.this.m12021createDestinationDirectorymc4yU64(this.$filePath, this.$relativePath);
                File fileSafeCopy = FileExtensionsKt.safeCopy(UriKt.toFile(this.$filePath), fileM12021createDestinationDirectorymc4yU64);
                AssetLegacyFactory assetLegacyFactory = AssetLegacyFactory.this;
                Context orThrow = WeakReferenceExtensionsKt.getOrThrow(assetLegacyFactory.contextRef);
                String string = fileSafeCopy.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                this.L$0 = coroutineScope;
                this.L$1 = SpillingKt.nullOutSpilledVariable(fileM12021createDestinationDirectorymc4yU64);
                this.L$2 = SpillingKt.nullOutSpilledVariable(fileSafeCopy);
                this.label = 1;
                obj = assetLegacyFactory.scanFile(orThrow, new String[]{string}, null, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Uri uri = (Uri) ((Pair) obj).component2();
            CoroutineScopeKt.ensureActive(coroutineScope);
            if (uri == null) {
                throw new AssetCouldNotBeCreated("Failed to create asset: could not add asset to MediaStore", null, 2, null);
            }
            return AssetLegacyFactory.this.create(uri);
        }
    }

    @Override // expo.modules.medialibrary.next.objects.asset.factories.AssetFactory
    /* JADX INFO: renamed from: create-BuevYFM */
    public Object mo12019createBuevYFM(Uri uri, String str, Continuation<? super Asset> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(uri, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createDestinationDirectory-mc4yU64, reason: not valid java name */
    public final File m12021createDestinationDirectorymc4yU64(Uri filePath, String relativePath) {
        File fileM12031externalStorageAssetDirectoryimpl;
        if (relativePath != null) {
            fileM12031externalStorageAssetDirectoryimpl = new File(RelativePath.m12047toFilePathimpl(relativePath));
        } else {
            String type = getContentResolver().getType(filePath);
            fileM12031externalStorageAssetDirectoryimpl = MimeType.m12031externalStorageAssetDirectoryimpl(type != null ? MimeType.m12028constructorimpl(type) : MimeType.INSTANCE.m12041fromdctPOJs(filePath));
        }
        fileM12031externalStorageAssetDirectoryimpl.mkdirs();
        return fileM12031externalStorageAssetDirectoryimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object scanFile(Context context, String[] strArr, String[] strArr2, Continuation<? super Pair<String, ? extends Uri>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        MediaScannerConnection.scanFile(context, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() { // from class: expo.modules.medialibrary.next.objects.asset.factories.AssetLegacyFactory$scanFile$2$1
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public final void onScanCompleted(String path, Uri uri) {
                Intrinsics.checkNotNullParameter(path, "path");
                Continuation<Pair<String, ? extends Uri>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m12684constructorimpl(new Pair(path, uri)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
