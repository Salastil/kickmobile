package expo.modules.medialibrary.next;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.types.EitherOfThree;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.medialibrary.next.exceptions.PermissionException;
import expo.modules.medialibrary.next.objects.album.Album;
import expo.modules.medialibrary.next.objects.album.AlbumQuery;
import expo.modules.medialibrary.next.objects.album.factories.AlbumFactory;
import expo.modules.medialibrary.next.objects.album.factories.AlbumLegacyFactory;
import expo.modules.medialibrary.next.objects.album.factories.AlbumModernFactory;
import expo.modules.medialibrary.next.objects.asset.Asset;
import expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver;
import expo.modules.medialibrary.next.objects.asset.AssetMapper;
import expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter;
import expo.modules.medialibrary.next.objects.asset.deleters.AssetLegacyDeleter;
import expo.modules.medialibrary.next.objects.asset.deleters.AssetModernDeleter;
import expo.modules.medialibrary.next.objects.asset.factories.AssetFactory;
import expo.modules.medialibrary.next.objects.asset.factories.AssetLegacyFactory;
import expo.modules.medialibrary.next.objects.asset.factories.AssetModernFactory;
import expo.modules.medialibrary.next.objects.asset.movers.AssetLegacyMover;
import expo.modules.medialibrary.next.objects.asset.movers.AssetModernMover;
import expo.modules.medialibrary.next.objects.asset.movers.AssetMover;
import expo.modules.medialibrary.next.objects.query.MediaStoreQueryFormatter;
import expo.modules.medialibrary.next.objects.query.Query;
import expo.modules.medialibrary.next.objects.wrappers.MediaType;
import expo.modules.medialibrary.next.observers.MediaStoreObserverManager;
import expo.modules.medialibrary.next.observers.OnMediaLibraryChange;
import expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate;
import expo.modules.medialibrary.next.permissions.SystemPermissionsDelegate;
import expo.modules.medialibrary.next.permissions.enums.GranularPermission;
import expo.modules.medialibrary.next.records.AssetField;
import expo.modules.medialibrary.next.records.AssetUriOptions;
import expo.modules.medialibrary.next.records.SortDescriptor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: MediaLibraryNextModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010;\u001a\u00020<H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\r\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\r\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\r\u001a\u0004\b8\u00109¨\u0006>"}, d2 = {"Lexpo/modules/medialibrary/next/MediaLibraryNextModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "observerManager", "Lexpo/modules/medialibrary/next/observers/MediaStoreObserverManager;", "getObserverManager", "()Lexpo/modules/medialibrary/next/observers/MediaStoreObserverManager;", "observerManager$delegate", "Lkotlin/Lazy;", "systemPermissionsDelegate", "Lexpo/modules/medialibrary/next/permissions/SystemPermissionsDelegate;", "getSystemPermissionsDelegate", "()Lexpo/modules/medialibrary/next/permissions/SystemPermissionsDelegate;", "systemPermissionsDelegate$delegate", "mediaStorePermissionsDelegate", "Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;", "getMediaStorePermissionsDelegate", "()Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;", "mediaStorePermissionsDelegate$delegate", "albumQuery", "Lexpo/modules/medialibrary/next/objects/album/AlbumQuery;", "getAlbumQuery", "()Lexpo/modules/medialibrary/next/objects/album/AlbumQuery;", "albumQuery$delegate", "assetMover", "Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "getAssetMover", "()Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "assetMover$delegate", "albumFactory", "Lexpo/modules/medialibrary/next/objects/album/factories/AlbumFactory;", "getAlbumFactory", "()Lexpo/modules/medialibrary/next/objects/album/factories/AlbumFactory;", "albumFactory$delegate", "assetMapper", "Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "getAssetMapper", "()Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "assetMapper$delegate", "assetDimensionsResolver", "Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "getAssetDimensionsResolver", "()Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "assetDimensionsResolver$delegate", "assetFactory", "Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "getAssetFactory", "()Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "assetFactory$delegate", "assetDeleter", "Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "getAssetDeleter", "()Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "assetDeleter$delegate", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaLibraryNextModule extends Module {
    public static final String LIBRARY_DID_CHANGE_EVENT = "mediaLibraryDidChange";

    /* JADX INFO: renamed from: observerManager$delegate, reason: from kotlin metadata */
    private final Lazy observerManager = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.observerManager_delegate$lambda$1(this.f$0);
        }
    });

    /* JADX INFO: renamed from: systemPermissionsDelegate$delegate, reason: from kotlin metadata */
    private final Lazy systemPermissionsDelegate = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.systemPermissionsDelegate_delegate$lambda$2(this.f$0);
        }
    });

    /* JADX INFO: renamed from: mediaStorePermissionsDelegate$delegate, reason: from kotlin metadata */
    private final Lazy mediaStorePermissionsDelegate = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.mediaStorePermissionsDelegate_delegate$lambda$3(this.f$0);
        }
    });

    /* JADX INFO: renamed from: albumQuery$delegate, reason: from kotlin metadata */
    private final Lazy albumQuery = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.albumQuery_delegate$lambda$4(this.f$0);
        }
    });

    /* JADX INFO: renamed from: assetMover$delegate, reason: from kotlin metadata */
    private final Lazy assetMover = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.assetMover_delegate$lambda$5(this.f$0);
        }
    });

    /* JADX INFO: renamed from: albumFactory$delegate, reason: from kotlin metadata */
    private final Lazy albumFactory = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.albumFactory_delegate$lambda$6(this.f$0);
        }
    });

    /* JADX INFO: renamed from: assetMapper$delegate, reason: from kotlin metadata */
    private final Lazy assetMapper = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.assetMapper_delegate$lambda$7();
        }
    });

    /* JADX INFO: renamed from: assetDimensionsResolver$delegate, reason: from kotlin metadata */
    private final Lazy assetDimensionsResolver = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.assetDimensionsResolver_delegate$lambda$8();
        }
    });

    /* JADX INFO: renamed from: assetFactory$delegate, reason: from kotlin metadata */
    private final Lazy assetFactory = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.assetFactory_delegate$lambda$9(this.f$0);
        }
    });

    /* JADX INFO: renamed from: assetDeleter$delegate, reason: from kotlin metadata */
    private final Lazy assetDeleter = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryNextModule.assetDeleter_delegate$lambda$10(this.f$0);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaStoreObserverManager getObserverManager() {
        return (MediaStoreObserverManager) this.observerManager.getValue();
    }

    static final MediaStoreObserverManager observerManager_delegate$lambda$1(final MediaLibraryNextModule mediaLibraryNextModule) {
        ContentResolver contentResolver = mediaLibraryNextModule.getContext().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        return new MediaStoreObserverManager(contentResolver, mediaLibraryNextModule.getAppContext().getBackgroundCoroutineScope(), new OnMediaLibraryChange() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$$ExternalSyntheticLambda0
            @Override // expo.modules.medialibrary.next.observers.OnMediaLibraryChange
            public final void invoke() {
                this.f$0.sendEvent("mediaLibraryDidChange", BundleKt.bundleOf(TuplesKt.to("hasIncrementalChanges", false)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SystemPermissionsDelegate getSystemPermissionsDelegate() {
        return (SystemPermissionsDelegate) this.systemPermissionsDelegate.getValue();
    }

    static final SystemPermissionsDelegate systemPermissionsDelegate_delegate$lambda$2(MediaLibraryNextModule mediaLibraryNextModule) {
        return new SystemPermissionsDelegate(mediaLibraryNextModule.getAppContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaStorePermissionsDelegate getMediaStorePermissionsDelegate() {
        return (MediaStorePermissionsDelegate) this.mediaStorePermissionsDelegate.getValue();
    }

    static final MediaStorePermissionsDelegate mediaStorePermissionsDelegate_delegate$lambda$3(MediaLibraryNextModule mediaLibraryNextModule) {
        return new MediaStorePermissionsDelegate(mediaLibraryNextModule.getAppContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlbumQuery getAlbumQuery() {
        return (AlbumQuery) this.albumQuery.getValue();
    }

    static final AlbumQuery albumQuery_delegate$lambda$4(MediaLibraryNextModule mediaLibraryNextModule) {
        return new AlbumQuery(mediaLibraryNextModule.getAlbumFactory(), mediaLibraryNextModule.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AssetMover getAssetMover() {
        return (AssetMover) this.assetMover.getValue();
    }

    static final AssetMover assetMover_delegate$lambda$5(MediaLibraryNextModule mediaLibraryNextModule) {
        if (Build.VERSION.SDK_INT >= 30) {
            return new AssetModernMover(mediaLibraryNextModule.getMediaStorePermissionsDelegate());
        }
        return new AssetLegacyMover();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlbumFactory getAlbumFactory() {
        return (AlbumFactory) this.albumFactory.getValue();
    }

    static final AlbumFactory albumFactory_delegate$lambda$6(MediaLibraryNextModule mediaLibraryNextModule) {
        if (Build.VERSION.SDK_INT >= 30) {
            return new AlbumModernFactory(mediaLibraryNextModule.getAssetFactory(), mediaLibraryNextModule.getAssetDeleter(), mediaLibraryNextModule.getAssetMover(), mediaLibraryNextModule.getContext());
        }
        return new AlbumLegacyFactory(mediaLibraryNextModule.getAssetFactory(), mediaLibraryNextModule.getAssetDeleter(), mediaLibraryNextModule.getAssetMover(), mediaLibraryNextModule.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AssetMapper getAssetMapper() {
        return (AssetMapper) this.assetMapper.getValue();
    }

    static final AssetMapper assetMapper_delegate$lambda$7() {
        return new AssetMapper();
    }

    private final AssetDimensionsResolver getAssetDimensionsResolver() {
        return (AssetDimensionsResolver) this.assetDimensionsResolver.getValue();
    }

    static final AssetDimensionsResolver assetDimensionsResolver_delegate$lambda$8() {
        return new AssetDimensionsResolver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AssetFactory getAssetFactory() {
        return (AssetFactory) this.assetFactory.getValue();
    }

    static final AssetFactory assetFactory_delegate$lambda$9(MediaLibraryNextModule mediaLibraryNextModule) {
        if (Build.VERSION.SDK_INT >= 30) {
            return new AssetModernFactory(mediaLibraryNextModule.getAssetDeleter(), mediaLibraryNextModule.getAssetMover(), mediaLibraryNextModule.getAssetMapper(), mediaLibraryNextModule.getAssetDimensionsResolver(), mediaLibraryNextModule.getMediaStorePermissionsDelegate(), mediaLibraryNextModule.getContext());
        }
        return new AssetLegacyFactory(mediaLibraryNextModule.getAssetDeleter(), mediaLibraryNextModule.getAssetMover(), mediaLibraryNextModule.getAssetMapper(), mediaLibraryNextModule.getAssetDimensionsResolver(), mediaLibraryNextModule.getSystemPermissionsDelegate(), mediaLibraryNextModule.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AssetDeleter getAssetDeleter() {
        return (AssetDeleter) this.assetDeleter.getValue();
    }

    static final AssetDeleter assetDeleter_delegate$lambda$10(MediaLibraryNextModule mediaLibraryNextModule) {
        if (Build.VERSION.SDK_INT >= 30) {
            return new AssetModernDeleter(mediaLibraryNextModule.getMediaStorePermissionsDelegate());
        }
        return new AssetLegacyDeleter(mediaLibraryNextModule.getSystemPermissionsDelegate(), mediaLibraryNextModule.getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v6 */
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        AnyType anyType;
        char c;
        Object objM12684constructorimpl2;
        char c2;
        char c3;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
        Object objM12684constructorimpl10;
        Object objM12684constructorimpl11;
        Object objM12684constructorimpl12;
        Object objM12684constructorimpl13;
        Object objM12684constructorimpl14;
        Object objM12684constructorimpl15;
        Object objM12684constructorimpl16;
        Object objM12684constructorimpl17;
        Object objM12684constructorimpl18;
        Object objM12684constructorimpl19;
        Object objM12684constructorimpl20;
        Object objM12684constructorimpl21;
        Object objM12684constructorimpl22;
        ClassComponentBuilder classComponentBuilder;
        Object objM12684constructorimpl23;
        Object objM12684constructorimpl24;
        Object objM12684constructorimpl25;
        Object objM12684constructorimpl26;
        Object objM12684constructorimpl27;
        Object objM12684constructorimpl28;
        Object objM12684constructorimpl29;
        ModuleDefinitionBuilder moduleDefinitionBuilder;
        Object objM12684constructorimpl30;
        Object objM12684constructorimpl31;
        Object objM12684constructorimpl32;
        Object objM12684constructorimpl33;
        Object objM12684constructorimpl34;
        Object objM12684constructorimpl35;
        Object objM12684constructorimpl36;
        Object objM12684constructorimpl37;
        Object objM12684constructorimpl38;
        Object objM12684constructorimpl39;
        Object objM12684constructorimpl40;
        Object objM12684constructorimpl41;
        Object objM12684constructorimpl42;
        Object objM12684constructorimpl43;
        Object objM12684constructorimpl44;
        Object objM12684constructorimpl45;
        Object objM12684constructorimpl46;
        Object objM12684constructorimpl47;
        Object objM12684constructorimpl48;
        Object objM12684constructorimpl49;
        Object objM12684constructorimpl50;
        Object objM12684constructorimpl51;
        Object objM12684constructorimpl52;
        Object objM12684constructorimpl53;
        Object objM12684constructorimpl54;
        Object objM12684constructorimpl55;
        Object objM12684constructorimpl56;
        Object objM12684constructorimpl57;
        Object objM12684constructorimpl58;
        Object objM12684constructorimpl59;
        Object objM12684constructorimpl60;
        Object objM12684constructorimpl61;
        Object objM12684constructorimpl62;
        Object objM12684constructorimpl63;
        Object objM12684constructorimpl64;
        Object objM12684constructorimpl65;
        Object objM12684constructorimpl66;
        Object objM12684constructorimpl67;
        Object objM12684constructorimpl68;
        Object objM12684constructorimpl69;
        Object objM12684constructorimpl70;
        Object objM12684constructorimpl71;
        MediaLibraryNextModule mediaLibraryNextModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (mediaLibraryNextModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = new ModuleDefinitionBuilder(mediaLibraryNextModule);
            moduleDefinitionBuilder2.Name("ExpoMediaLibraryNext");
            moduleDefinitionBuilder2.Events("mediaLibraryDidChange");
            moduleDefinitionBuilder2.OnStartObserving("mediaLibraryDidChange", new Function0<Unit>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.getObserverManager().startObserving();
                }
            });
            moduleDefinitionBuilder2.OnStopObserving("mediaLibraryDidChange", new Function0<Unit>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.getObserverManager().stopObserving();
                }
            });
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder2;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Asset.class);
            Module module = moduleDefinitionBuilder3.getModule();
            if (module == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext = module.getAppContext();
            String simpleName = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType2 != null) {
                anyType = anyType2;
            } else {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$Class$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType = new AnyType(typeDescriptor, null);
            }
            ClassComponentBuilder classComponentBuilder2 = new ClassComponentBuilder(appContext, simpleName, orCreateKotlinClass, anyType, moduleDefinitionBuilder3.getConverters());
            TypeConverterProvider converters = classComponentBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[1];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), false));
            if (anyType3 != null) {
                c3 = 0;
            } else {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    c = 0;
                    try {
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Constructor$1
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Uri.class);
                            }
                        }));
                        c2 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion4 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th));
                        c2 = c;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    c = 0;
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uri.class));
                }
                anyType3 = new AnyType(typeDescriptor2, converters);
                c3 = c2;
            }
            anyTypeArr[c3] = anyType3;
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Object.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Object.class, returnType2);
                returnType = returnType2;
            }
            classComponentBuilder2.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return this.this$0.getAssetFactory().create((Uri) objArr[0]);
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), "id");
            AnyType[] anyTypeArr2 = new AnyType[1];
            ?? r17 = c3;
            anyTypeArr2[r17 == true ? 1 : 0] = new AnyType(propertyComponentBuilderWithThis.getThisType(), null, 2, null);
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(Uri.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(Uri.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(Uri.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(Uri.class, returnType4);
                returnType3 = returnType4;
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr2, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((Asset) it[0]).getContentUri();
                }
            });
            syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
            syncFunctionComponent.setCanTakeOwner(true);
            propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
            classComponentBuilder2.getProperties().put("id", propertyComponentBuilderWithThis);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = classComponentBuilder2.AsyncFunction("getCreationTime");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters2 = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), Boolean.valueOf((boolean) r17)));
            ?? r18 = r17;
            if (anyType4 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, r17, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType4 = new AnyType(typeDescriptor3, converters2);
                r18 = 0;
            }
            anyTypeArr3[r18] = anyType4;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr3, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$2(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = classComponentBuilder2.AsyncFunction("getDuration");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters3 = asyncFunctionBuilderAsyncFunction2.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType5 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType5 = new AnyType(typeDescriptor4, converters3);
            }
            anyTypeArr4[0] = anyType5;
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr4, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$4(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = classComponentBuilder2.AsyncFunction("getExif");
            String name3 = asyncFunctionBuilderAsyncFunction3.getName();
            TypeConverterProvider converters4 = asyncFunctionBuilderAsyncFunction3.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th6) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType6 = new AnyType(typeDescriptor5, converters4);
            }
            anyTypeArr5[0] = anyType6;
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(new SuspendFunctionComponent(name3, anyTypeArr5, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$6(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction4 = classComponentBuilder2.AsyncFunction("getInfo");
            String name4 = asyncFunctionBuilderAsyncFunction4.getName();
            TypeConverterProvider converters5 = asyncFunctionBuilderAsyncFunction4.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[1];
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType7 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th7) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                    objM12684constructorimpl6 = null;
                }
                TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                if (typeDescriptor6 == null) {
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType7 = new AnyType(typeDescriptor6, converters5);
            }
            anyTypeArr6[0] = anyType7;
            asyncFunctionBuilderAsyncFunction4.setAsyncFunctionComponent(new SuspendFunctionComponent(name4, anyTypeArr6, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$8(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction5 = classComponentBuilder2.AsyncFunction("getAlbums");
            String name5 = asyncFunctionBuilderAsyncFunction5.getName();
            TypeConverterProvider converters6 = asyncFunctionBuilderAsyncFunction5.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[1];
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th8) {
                    Result.Companion companion14 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                    objM12684constructorimpl7 = null;
                }
                TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
                if (typeDescriptor7 == null) {
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType8 = new AnyType(typeDescriptor7, converters6);
            }
            anyTypeArr7[0] = anyType8;
            asyncFunctionBuilderAsyncFunction5.setAsyncFunctionComponent(new SuspendFunctionComponent(name5, anyTypeArr7, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$10(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction6 = classComponentBuilder2.AsyncFunction("getLocation");
            String name6 = asyncFunctionBuilderAsyncFunction6.getName();
            TypeConverterProvider converters7 = asyncFunctionBuilderAsyncFunction6.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[1];
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType9 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th9) {
                    Result.Companion companion16 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th9));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl8)) {
                    objM12684constructorimpl8 = null;
                }
                TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl8;
                if (typeDescriptor8 == null) {
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType9 = new AnyType(typeDescriptor8, converters7);
            }
            anyTypeArr8[0] = anyType9;
            asyncFunctionBuilderAsyncFunction6.setAsyncFunctionComponent(new SuspendFunctionComponent(name6, anyTypeArr8, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$12(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction7 = classComponentBuilder2.AsyncFunction("getFilename");
            String name7 = asyncFunctionBuilderAsyncFunction7.getName();
            TypeConverterProvider converters8 = asyncFunctionBuilderAsyncFunction7.getConverters();
            AnyType[] anyTypeArr9 = new AnyType[1];
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType10 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th10) {
                    Result.Companion companion18 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(ResultKt.createFailure(th10));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl9)) {
                    objM12684constructorimpl9 = null;
                }
                TypeDescriptor typeDescriptor9 = (TypeDescriptor) objM12684constructorimpl9;
                if (typeDescriptor9 == null) {
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType10 = new AnyType(typeDescriptor9, converters8);
            }
            anyTypeArr9[0] = anyType10;
            asyncFunctionBuilderAsyncFunction7.setAsyncFunctionComponent(new SuspendFunctionComponent(name7, anyTypeArr9, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$14(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction8 = classComponentBuilder2.AsyncFunction("getHeight");
            String name8 = asyncFunctionBuilderAsyncFunction8.getName();
            TypeConverterProvider converters9 = asyncFunctionBuilderAsyncFunction8.getConverters();
            AnyType[] anyTypeArr10 = new AnyType[1];
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType11 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$15
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th11) {
                    Result.Companion companion20 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(ResultKt.createFailure(th11));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl10)) {
                    objM12684constructorimpl10 = null;
                }
                TypeDescriptor typeDescriptor10 = (TypeDescriptor) objM12684constructorimpl10;
                if (typeDescriptor10 == null) {
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType11 = new AnyType(typeDescriptor10, converters9);
            }
            anyTypeArr10[0] = anyType11;
            asyncFunctionBuilderAsyncFunction8.setAsyncFunctionComponent(new SuspendFunctionComponent(name8, anyTypeArr10, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$16(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction9 = classComponentBuilder2.AsyncFunction("getMediaType");
            String name9 = asyncFunctionBuilderAsyncFunction9.getName();
            TypeConverterProvider converters10 = asyncFunctionBuilderAsyncFunction9.getConverters();
            AnyType[] anyTypeArr11 = new AnyType[1];
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType12 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$17
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th12) {
                    Result.Companion companion22 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(ResultKt.createFailure(th12));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl11)) {
                    objM12684constructorimpl11 = null;
                }
                TypeDescriptor typeDescriptor11 = (TypeDescriptor) objM12684constructorimpl11;
                if (typeDescriptor11 == null) {
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType12 = new AnyType(typeDescriptor11, converters10);
            }
            anyTypeArr11[0] = anyType12;
            asyncFunctionBuilderAsyncFunction9.setAsyncFunctionComponent(new SuspendFunctionComponent(name9, anyTypeArr11, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$18(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction10 = classComponentBuilder2.AsyncFunction("getModificationTime");
            String name10 = asyncFunctionBuilderAsyncFunction10.getName();
            TypeConverterProvider converters11 = asyncFunctionBuilderAsyncFunction10.getConverters();
            AnyType[] anyTypeArr12 = new AnyType[1];
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType13 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$19
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th13) {
                    Result.Companion companion24 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(ResultKt.createFailure(th13));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl12)) {
                    objM12684constructorimpl12 = null;
                }
                TypeDescriptor typeDescriptor12 = (TypeDescriptor) objM12684constructorimpl12;
                if (typeDescriptor12 == null) {
                    typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType13 = new AnyType(typeDescriptor12, converters11);
            }
            anyTypeArr12[0] = anyType13;
            asyncFunctionBuilderAsyncFunction10.setAsyncFunctionComponent(new SuspendFunctionComponent(name10, anyTypeArr12, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$20(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction11 = classComponentBuilder2.AsyncFunction("getShape");
            String name11 = asyncFunctionBuilderAsyncFunction11.getName();
            TypeConverterProvider converters12 = asyncFunctionBuilderAsyncFunction11.getConverters();
            AnyType[] anyTypeArr13 = new AnyType[1];
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType14 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$21
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th14) {
                    Result.Companion companion26 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(ResultKt.createFailure(th14));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl13)) {
                    objM12684constructorimpl13 = null;
                }
                TypeDescriptor typeDescriptor13 = (TypeDescriptor) objM12684constructorimpl13;
                if (typeDescriptor13 == null) {
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType14 = new AnyType(typeDescriptor13, converters12);
            }
            anyTypeArr13[0] = anyType14;
            asyncFunctionBuilderAsyncFunction11.setAsyncFunctionComponent(new SuspendFunctionComponent(name11, anyTypeArr13, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$22(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction12 = classComponentBuilder2.AsyncFunction("getUri");
            String name12 = asyncFunctionBuilderAsyncFunction12.getName();
            TypeConverterProvider converters13 = asyncFunctionBuilderAsyncFunction12.getConverters();
            AnyType[] anyTypeArr14 = new AnyType[2];
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType15 == null) {
                try {
                    Result.Companion companion27 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$23
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th15) {
                    Result.Companion companion28 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(ResultKt.createFailure(th15));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl14)) {
                    objM12684constructorimpl14 = null;
                }
                TypeDescriptor typeDescriptor14 = (TypeDescriptor) objM12684constructorimpl14;
                if (typeDescriptor14 == null) {
                    typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType15 = new AnyType(typeDescriptor14, converters13);
            }
            anyTypeArr14[0] = anyType15;
            AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AssetUriOptions.class), true));
            if (anyType16 == null) {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AssetUriOptions.class, true, AssetUriOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$24
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(AssetUriOptions.class);
                        }
                    }));
                } catch (Throwable th16) {
                    Result.Companion companion30 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(ResultKt.createFailure(th16));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl15)) {
                    objM12684constructorimpl15 = null;
                }
                TypeDescriptor typeDescriptor15 = (TypeDescriptor) objM12684constructorimpl15;
                if (typeDescriptor15 == null) {
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(AssetUriOptions.class));
                }
                anyType16 = new AnyType(typeDescriptor15, converters13);
            }
            anyTypeArr14[1] = anyType16;
            asyncFunctionBuilderAsyncFunction12.setAsyncFunctionComponent(new SuspendFunctionComponent(name12, anyTypeArr14, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$25(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction13 = classComponentBuilder2.AsyncFunction("getWidth");
            String name13 = asyncFunctionBuilderAsyncFunction13.getName();
            TypeConverterProvider converters14 = asyncFunctionBuilderAsyncFunction13.getConverters();
            AnyType[] anyTypeArr15 = new AnyType[1];
            AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType17 == null) {
                try {
                    Result.Companion companion31 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$26
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th17) {
                    Result.Companion companion32 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(ResultKt.createFailure(th17));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl16)) {
                    objM12684constructorimpl16 = null;
                }
                TypeDescriptor typeDescriptor16 = (TypeDescriptor) objM12684constructorimpl16;
                if (typeDescriptor16 == null) {
                    typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType17 = new AnyType(typeDescriptor16, converters14);
            }
            anyTypeArr15[0] = anyType17;
            asyncFunctionBuilderAsyncFunction13.setAsyncFunctionComponent(new SuspendFunctionComponent(name13, anyTypeArr15, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$27(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction14 = classComponentBuilder2.AsyncFunction("getFavorite");
            String name14 = asyncFunctionBuilderAsyncFunction14.getName();
            TypeConverterProvider converters15 = asyncFunctionBuilderAsyncFunction14.getConverters();
            AnyType[] anyTypeArr16 = new AnyType[1];
            AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType18 == null) {
                try {
                    Result.Companion companion33 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$28
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th18) {
                    Result.Companion companion34 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(ResultKt.createFailure(th18));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl17)) {
                    objM12684constructorimpl17 = null;
                }
                TypeDescriptor typeDescriptor17 = (TypeDescriptor) objM12684constructorimpl17;
                if (typeDescriptor17 == null) {
                    typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType18 = new AnyType(typeDescriptor17, converters15);
            }
            anyTypeArr16[0] = anyType18;
            asyncFunctionBuilderAsyncFunction14.setAsyncFunctionComponent(new SuspendFunctionComponent(name14, anyTypeArr16, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$29(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction15 = classComponentBuilder2.AsyncFunction("setFavorite");
            String name15 = asyncFunctionBuilderAsyncFunction15.getName();
            TypeConverterProvider converters16 = asyncFunctionBuilderAsyncFunction15.getConverters();
            AnyType[] anyTypeArr17 = new AnyType[2];
            AnyType anyType19 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType19 == null) {
                try {
                    Result.Companion companion35 = Result.INSTANCE;
                    objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$30
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th19) {
                    Result.Companion companion36 = Result.INSTANCE;
                    objM12684constructorimpl18 = Result.m12684constructorimpl(ResultKt.createFailure(th19));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl18)) {
                    objM12684constructorimpl18 = null;
                }
                TypeDescriptor typeDescriptor18 = (TypeDescriptor) objM12684constructorimpl18;
                if (typeDescriptor18 == null) {
                    typeDescriptor18 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType19 = new AnyType(typeDescriptor18, converters16);
            }
            anyTypeArr17[0] = anyType19;
            AnyType anyType20 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType20 == null) {
                try {
                    Result.Companion companion37 = Result.INSTANCE;
                    objM12684constructorimpl19 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$31
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
                        }
                    }));
                } catch (Throwable th20) {
                    Result.Companion companion38 = Result.INSTANCE;
                    objM12684constructorimpl19 = Result.m12684constructorimpl(ResultKt.createFailure(th20));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl19)) {
                    objM12684constructorimpl19 = null;
                }
                TypeDescriptor typeDescriptor19 = (TypeDescriptor) objM12684constructorimpl19;
                if (typeDescriptor19 == null) {
                    typeDescriptor19 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType20 = new AnyType(typeDescriptor19, converters16);
            }
            anyTypeArr17[1] = anyType20;
            asyncFunctionBuilderAsyncFunction15.setAsyncFunctionComponent(new SuspendFunctionComponent(name15, anyTypeArr17, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$32(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction16 = classComponentBuilder2.AsyncFunction("delete");
            String name16 = asyncFunctionBuilderAsyncFunction16.getName();
            TypeConverterProvider converters17 = asyncFunctionBuilderAsyncFunction16.getConverters();
            AnyType[] anyTypeArr18 = new AnyType[1];
            AnyType anyType21 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Asset.class), false));
            if (anyType21 == null) {
                try {
                    Result.Companion companion39 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$33
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Asset.class);
                        }
                    }));
                } catch (Throwable th21) {
                    Result.Companion companion40 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(ResultKt.createFailure(th21));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl20)) {
                    objM12684constructorimpl20 = null;
                }
                TypeDescriptor typeDescriptor20 = (TypeDescriptor) objM12684constructorimpl20;
                if (typeDescriptor20 == null) {
                    typeDescriptor20 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Asset.class));
                }
                anyType21 = new AnyType(typeDescriptor20, converters17);
            }
            anyTypeArr18[0] = anyType21;
            asyncFunctionBuilderAsyncFunction16.setAsyncFunctionComponent(new SuspendFunctionComponent(name16, anyTypeArr18, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$34(null)));
            AsyncFunctionBuilder asyncFunctionBuilderStaticAsyncFunction = classComponentBuilder2.StaticAsyncFunction("create");
            String name17 = asyncFunctionBuilderStaticAsyncFunction.getName();
            TypeConverterProvider converters18 = asyncFunctionBuilderStaticAsyncFunction.getConverters();
            AnyType[] anyTypeArr19 = new AnyType[2];
            AnyType anyType22 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), false));
            if (anyType22 == null) {
                try {
                    Result.Companion companion41 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$35
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Uri.class);
                        }
                    }));
                } catch (Throwable th22) {
                    Result.Companion companion42 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(ResultKt.createFailure(th22));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl21)) {
                    objM12684constructorimpl21 = null;
                }
                TypeDescriptor typeDescriptor21 = (TypeDescriptor) objM12684constructorimpl21;
                if (typeDescriptor21 == null) {
                    typeDescriptor21 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uri.class));
                }
                anyType22 = new AnyType(typeDescriptor21, converters18);
            }
            anyTypeArr19[0] = anyType22;
            AnyType anyType23 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Album.class), true));
            if (anyType23 == null) {
                try {
                    Result.Companion companion43 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Album.class, true, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$36
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Album.class);
                        }
                    }));
                } catch (Throwable th23) {
                    Result.Companion companion44 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(ResultKt.createFailure(th23));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl22)) {
                    objM12684constructorimpl22 = null;
                }
                TypeDescriptor typeDescriptor22 = (TypeDescriptor) objM12684constructorimpl22;
                if (typeDescriptor22 == null) {
                    typeDescriptor22 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Album.class));
                }
                anyType23 = new AnyType(typeDescriptor22, converters18);
            }
            anyTypeArr19[1] = anyType23;
            asyncFunctionBuilderStaticAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name17, anyTypeArr19, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderStaticAsyncFunction2 = classComponentBuilder2.StaticAsyncFunction("delete");
            String name18 = asyncFunctionBuilderStaticAsyncFunction2.getName();
            TypeConverterProvider converters19 = asyncFunctionBuilderStaticAsyncFunction2.getConverters();
            AnyType[] anyTypeArr20 = new AnyType[1];
            AnyType anyType24 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType24 != null) {
                classComponentBuilder = classComponentBuilder2;
            } else {
                try {
                    Result.Companion companion45 = Result.INSTANCE;
                    PTypeDescriptor[] pTypeDescriptorArr = new PTypeDescriptor[1];
                    classComponentBuilder = classComponentBuilder2;
                    try {
                        pTypeDescriptorArr[0] = PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null);
                        objM12684constructorimpl23 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, Arrays.asList(pTypeDescriptorArr), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$38
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Asset.class)));
                            }
                        }));
                    } catch (Throwable th24) {
                        th = th24;
                        Result.Companion companion46 = Result.INSTANCE;
                        objM12684constructorimpl23 = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th25) {
                    th = th25;
                    classComponentBuilder = classComponentBuilder2;
                }
                Object obj = objM12684constructorimpl23;
                if (Result.m12690isFailureimpl(obj)) {
                    obj = null;
                }
                TypeDescriptor typeDescriptor23 = (TypeDescriptor) obj;
                if (typeDescriptor23 == null) {
                    typeDescriptor23 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Asset.class))));
                }
                anyType24 = new AnyType(typeDescriptor23, converters19);
            }
            anyTypeArr20[0] = anyType24;
            asyncFunctionBuilderStaticAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name18, anyTypeArr20, new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39(null, this)));
            moduleDefinitionBuilder3.getClassData().add(classComponentBuilder.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder2;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Album.class);
            Module module2 = moduleDefinitionBuilder4.getModule();
            if (module2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext2 = module2.getAppContext();
            String simpleName2 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass2).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            AnyType anyType25 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Album.class), false));
            if (anyType25 == null) {
                try {
                    Result.Companion companion47 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Album.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$Class$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Album.class);
                        }
                    }));
                } catch (Throwable th26) {
                    Result.Companion companion48 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(ResultKt.createFailure(th26));
                }
                Object obj2 = objM12684constructorimpl24;
                if (Result.m12690isFailureimpl(obj2)) {
                    obj2 = null;
                }
                TypeDescriptor typeDescriptor24 = (TypeDescriptor) obj2;
                if (typeDescriptor24 == null) {
                    typeDescriptor24 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Album.class));
                }
                anyType25 = new AnyType(typeDescriptor24, null);
            }
            ClassComponentBuilder classComponentBuilder3 = new ClassComponentBuilder(appContext2, simpleName2, orCreateKotlinClass2, anyType25, moduleDefinitionBuilder4.getConverters());
            TypeConverterProvider converters20 = classComponentBuilder3.getConverters();
            AnyType[] anyTypeArr21 = new AnyType[1];
            AnyType anyType26 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType26 == null) {
                try {
                    Result.Companion companion49 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Constructor$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th27) {
                    Result.Companion companion50 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(ResultKt.createFailure(th27));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl25)) {
                    objM12684constructorimpl25 = null;
                }
                TypeDescriptor typeDescriptor25 = (TypeDescriptor) objM12684constructorimpl25;
                if (typeDescriptor25 == null) {
                    typeDescriptor25 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType26 = new AnyType(typeDescriptor25, converters20);
            }
            anyTypeArr21[0] = anyType26;
            ReturnTypeProvider returnTypeProvider3 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType5 = returnTypeProvider3.getTypes().get(Object.class);
            if (returnType5 == null) {
                JSTypeConverter<?> directConverter3 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter3 == null) {
                    directConverter3 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType6 = new ReturnType(directConverter3);
                returnTypeProvider3.getTypes().put(Object.class, returnType6);
                returnType5 = returnType6;
            }
            classComponentBuilder3.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr21, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return new Album((String) objArr[0], this.this$0.getAssetDeleter(), this.this$0.getAssetFactory(), this.this$0.getAssetMover(), this.this$0.getContext());
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis2 = new PropertyComponentBuilderWithThis(classComponentBuilder3.getOwnerType().getTypeDescriptor(), "id");
            AnyType[] anyTypeArr22 = {new AnyType(propertyComponentBuilderWithThis2.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider4 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType7 = returnTypeProvider4.getTypes().get(String.class);
            if (returnType7 == null) {
                JSTypeConverter<?> directConverter4 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter4 == null) {
                    directConverter4 = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType8 = new ReturnType(directConverter4);
                returnTypeProvider4.getTypes().put(String.class, returnType8);
                returnType7 = returnType8;
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("get", anyTypeArr22, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((Album) it[0]).getId();
                }
            });
            syncFunctionComponent2.setOwnerType(propertyComponentBuilderWithThis2.getThisType());
            syncFunctionComponent2.setCanTakeOwner(true);
            propertyComponentBuilderWithThis2.setGetter(syncFunctionComponent2);
            classComponentBuilder3.getProperties().put("id", propertyComponentBuilderWithThis2);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction17 = classComponentBuilder3.AsyncFunction("getTitle");
            String name19 = asyncFunctionBuilderAsyncFunction17.getName();
            TypeConverterProvider converters21 = asyncFunctionBuilderAsyncFunction17.getConverters();
            AnyType[] anyTypeArr23 = new AnyType[1];
            AnyType anyType27 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Album.class), false));
            if (anyType27 == null) {
                try {
                    Result.Companion companion51 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Album.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Album.class);
                        }
                    }));
                } catch (Throwable th28) {
                    Result.Companion companion52 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(ResultKt.createFailure(th28));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl26)) {
                    objM12684constructorimpl26 = null;
                }
                TypeDescriptor typeDescriptor26 = (TypeDescriptor) objM12684constructorimpl26;
                if (typeDescriptor26 == null) {
                    typeDescriptor26 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Album.class));
                }
                anyType27 = new AnyType(typeDescriptor26, converters21);
            }
            anyTypeArr23[0] = anyType27;
            asyncFunctionBuilderAsyncFunction17.setAsyncFunctionComponent(new SuspendFunctionComponent(name19, anyTypeArr23, new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$2(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction18 = classComponentBuilder3.AsyncFunction("getAssets");
            String name20 = asyncFunctionBuilderAsyncFunction18.getName();
            TypeConverterProvider converters22 = asyncFunctionBuilderAsyncFunction18.getConverters();
            AnyType[] anyTypeArr24 = new AnyType[1];
            AnyType anyType28 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Album.class), false));
            if (anyType28 == null) {
                try {
                    Result.Companion companion53 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Album.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Album.class);
                        }
                    }));
                } catch (Throwable th29) {
                    Result.Companion companion54 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(ResultKt.createFailure(th29));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl27)) {
                    objM12684constructorimpl27 = null;
                }
                TypeDescriptor typeDescriptor27 = (TypeDescriptor) objM12684constructorimpl27;
                if (typeDescriptor27 == null) {
                    typeDescriptor27 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Album.class));
                }
                anyType28 = new AnyType(typeDescriptor27, converters22);
            }
            anyTypeArr24[0] = anyType28;
            asyncFunctionBuilderAsyncFunction18.setAsyncFunctionComponent(new SuspendFunctionComponent(name20, anyTypeArr24, new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$4(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction19 = classComponentBuilder3.AsyncFunction("getAssetCount");
            String name21 = asyncFunctionBuilderAsyncFunction19.getName();
            TypeConverterProvider converters23 = asyncFunctionBuilderAsyncFunction19.getConverters();
            AnyType[] anyTypeArr25 = new AnyType[1];
            AnyType anyType29 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Album.class), false));
            if (anyType29 == null) {
                try {
                    Result.Companion companion55 = Result.INSTANCE;
                    objM12684constructorimpl28 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Album.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Album.class);
                        }
                    }));
                } catch (Throwable th30) {
                    Result.Companion companion56 = Result.INSTANCE;
                    objM12684constructorimpl28 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl28)) {
                    objM12684constructorimpl28 = null;
                }
                TypeDescriptor typeDescriptor28 = (TypeDescriptor) objM12684constructorimpl28;
                if (typeDescriptor28 == null) {
                    typeDescriptor28 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Album.class));
                }
                anyType29 = new AnyType(typeDescriptor28, converters23);
            }
            anyTypeArr25[0] = anyType29;
            asyncFunctionBuilderAsyncFunction19.setAsyncFunctionComponent(new SuspendFunctionComponent(name21, anyTypeArr25, new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$6(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction20 = classComponentBuilder3.AsyncFunction("add");
            String name22 = asyncFunctionBuilderAsyncFunction20.getName();
            TypeConverterProvider converters24 = asyncFunctionBuilderAsyncFunction20.getConverters();
            AnyType[] anyTypeArr26 = new AnyType[2];
            AnyType anyType30 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Album.class), false));
            if (anyType30 == null) {
                try {
                    Result.Companion companion57 = Result.INSTANCE;
                    objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Album.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Album.class);
                        }
                    }));
                } catch (Throwable th31) {
                    Result.Companion companion58 = Result.INSTANCE;
                    objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                    objM12684constructorimpl29 = null;
                }
                TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                if (typeDescriptor29 == null) {
                    typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Album.class));
                }
                anyType30 = new AnyType(typeDescriptor29, converters24);
            }
            anyTypeArr26[0] = anyType30;
            AnyType anyType31 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType31 != null) {
                moduleDefinitionBuilder = moduleDefinitionBuilder4;
            } else {
                try {
                    Result.Companion companion59 = Result.INSTANCE;
                    PTypeDescriptor[] pTypeDescriptorArr2 = new PTypeDescriptor[1];
                    moduleDefinitionBuilder = moduleDefinitionBuilder4;
                    try {
                        pTypeDescriptorArr2[0] = PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null);
                        objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, Arrays.asList(pTypeDescriptorArr2), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$8
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Asset.class)));
                            }
                        }));
                    } catch (Throwable th32) {
                        th = th32;
                        Result.Companion companion60 = Result.INSTANCE;
                        objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th33) {
                    th = th33;
                    moduleDefinitionBuilder = moduleDefinitionBuilder4;
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                    objM12684constructorimpl30 = null;
                }
                TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                if (typeDescriptor30 == null) {
                    typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Asset.class))));
                }
                anyType31 = new AnyType(typeDescriptor30, converters24);
            }
            anyTypeArr26[1] = anyType31;
            asyncFunctionBuilderAsyncFunction20.setAsyncFunctionComponent(new SuspendFunctionComponent(name22, anyTypeArr26, new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$9(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction21 = classComponentBuilder3.AsyncFunction("delete");
            String name23 = asyncFunctionBuilderAsyncFunction21.getName();
            TypeConverterProvider converters25 = asyncFunctionBuilderAsyncFunction21.getConverters();
            AnyType[] anyTypeArr27 = new AnyType[1];
            AnyType anyType32 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Album.class), false));
            if (anyType32 == null) {
                try {
                    Result.Companion companion61 = Result.INSTANCE;
                    objM12684constructorimpl31 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Album.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Album.class);
                        }
                    }));
                } catch (Throwable th34) {
                    Result.Companion companion62 = Result.INSTANCE;
                    objM12684constructorimpl31 = Result.m12684constructorimpl(ResultKt.createFailure(th34));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl31)) {
                    objM12684constructorimpl31 = null;
                }
                TypeDescriptor typeDescriptor31 = (TypeDescriptor) objM12684constructorimpl31;
                if (typeDescriptor31 == null) {
                    typeDescriptor31 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Album.class));
                }
                anyType32 = new AnyType(typeDescriptor31, converters25);
            }
            anyTypeArr27[0] = anyType32;
            asyncFunctionBuilderAsyncFunction21.setAsyncFunctionComponent(new SuspendFunctionComponent(name23, anyTypeArr27, new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$11(null)));
            AsyncFunctionBuilder asyncFunctionBuilderStaticAsyncFunction3 = classComponentBuilder3.StaticAsyncFunction("get");
            String name24 = asyncFunctionBuilderStaticAsyncFunction3.getName();
            TypeConverterProvider converters26 = asyncFunctionBuilderStaticAsyncFunction3.getConverters();
            AnyType[] anyTypeArr28 = new AnyType[1];
            AnyType anyType33 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType33 == null) {
                try {
                    Result.Companion companion63 = Result.INSTANCE;
                    objM12684constructorimpl32 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th35) {
                    Result.Companion companion64 = Result.INSTANCE;
                    objM12684constructorimpl32 = Result.m12684constructorimpl(ResultKt.createFailure(th35));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl32)) {
                    objM12684constructorimpl32 = null;
                }
                TypeDescriptor typeDescriptor32 = (TypeDescriptor) objM12684constructorimpl32;
                if (typeDescriptor32 == null) {
                    typeDescriptor32 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType33 = new AnyType(typeDescriptor32, converters26);
            }
            anyTypeArr28[0] = anyType33;
            asyncFunctionBuilderStaticAsyncFunction3.setAsyncFunctionComponent(new SuspendFunctionComponent(name24, anyTypeArr28, new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$13(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderStaticAsyncFunction4 = classComponentBuilder3.StaticAsyncFunction("getAll");
            SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(asyncFunctionBuilderStaticAsyncFunction4.getName(), new AnyType[0], new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$14(null, this));
            asyncFunctionBuilderStaticAsyncFunction4.setAsyncFunctionComponent(suspendFunctionComponent);
            AsyncFunctionBuilder asyncFunctionBuilderStaticAsyncFunction5 = classComponentBuilder3.StaticAsyncFunction("getAlbumsMetadata");
            SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(asyncFunctionBuilderStaticAsyncFunction5.getName(), new AnyType[0], new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$15(null, this));
            asyncFunctionBuilderStaticAsyncFunction5.setAsyncFunctionComponent(suspendFunctionComponent2);
            AsyncFunctionBuilder asyncFunctionBuilderStaticAsyncFunction6 = classComponentBuilder3.StaticAsyncFunction("delete");
            String name25 = asyncFunctionBuilderStaticAsyncFunction6.getName();
            TypeConverterProvider converters27 = asyncFunctionBuilderStaticAsyncFunction6.getConverters();
            AnyType[] anyTypeArr29 = new AnyType[2];
            AnyType anyType34 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType34 == null) {
                try {
                    Result.Companion companion65 = Result.INSTANCE;
                    objM12684constructorimpl33 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(Album.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$16
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Album.class)));
                        }
                    }));
                } catch (Throwable th36) {
                    Result.Companion companion66 = Result.INSTANCE;
                    objM12684constructorimpl33 = Result.m12684constructorimpl(ResultKt.createFailure(th36));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl33)) {
                    objM12684constructorimpl33 = null;
                }
                TypeDescriptor typeDescriptor33 = (TypeDescriptor) objM12684constructorimpl33;
                if (typeDescriptor33 == null) {
                    typeDescriptor33 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Album.class))));
                }
                anyType34 = new AnyType(typeDescriptor33, converters27);
            }
            anyTypeArr29[0] = anyType34;
            AnyType anyType35 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType35 == null) {
                try {
                    Result.Companion companion67 = Result.INSTANCE;
                    objM12684constructorimpl34 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$17
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
                        }
                    }));
                } catch (Throwable th37) {
                    Result.Companion companion68 = Result.INSTANCE;
                    objM12684constructorimpl34 = Result.m12684constructorimpl(ResultKt.createFailure(th37));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl34)) {
                    objM12684constructorimpl34 = null;
                }
                TypeDescriptor typeDescriptor34 = (TypeDescriptor) objM12684constructorimpl34;
                if (typeDescriptor34 == null) {
                    typeDescriptor34 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType35 = new AnyType(typeDescriptor34, converters27);
            }
            anyTypeArr29[1] = anyType35;
            asyncFunctionBuilderStaticAsyncFunction6.setAsyncFunctionComponent(new SuspendFunctionComponent(name25, anyTypeArr29, new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$18(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderStaticAsyncFunction7 = classComponentBuilder3.StaticAsyncFunction("create");
            String name26 = asyncFunctionBuilderStaticAsyncFunction7.getName();
            TypeConverterProvider converters28 = asyncFunctionBuilderStaticAsyncFunction7.getConverters();
            AnyType[] anyTypeArr30 = new AnyType[3];
            AnyType anyType36 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType36 == null) {
                try {
                    Result.Companion companion69 = Result.INSTANCE;
                    objM12684constructorimpl35 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$19
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th38) {
                    Result.Companion companion70 = Result.INSTANCE;
                    objM12684constructorimpl35 = Result.m12684constructorimpl(ResultKt.createFailure(th38));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl35)) {
                    objM12684constructorimpl35 = null;
                }
                TypeDescriptor typeDescriptor35 = (TypeDescriptor) objM12684constructorimpl35;
                if (typeDescriptor35 == null) {
                    typeDescriptor35 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType36 = new AnyType(typeDescriptor35, converters28);
            }
            anyTypeArr30[0] = anyType36;
            AnyType anyType37 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType37 == null) {
                try {
                    Result.Companion companion71 = Result.INSTANCE;
                    objM12684constructorimpl36 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(Asset.class, false, null)), null), PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null)), null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$20
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Asset.class)))), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Uri.class)))));
                        }
                    }));
                } catch (Throwable th39) {
                    Result.Companion companion72 = Result.INSTANCE;
                    objM12684constructorimpl36 = Result.m12684constructorimpl(ResultKt.createFailure(th39));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl36)) {
                    objM12684constructorimpl36 = null;
                }
                TypeDescriptor typeDescriptor36 = (TypeDescriptor) objM12684constructorimpl36;
                if (typeDescriptor36 == null) {
                    typeDescriptor36 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Asset.class)))), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Uri.class))))));
                }
                anyType37 = new AnyType(typeDescriptor36, converters28);
            }
            anyTypeArr30[1] = anyType37;
            AnyType anyType38 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType38 == null) {
                try {
                    Result.Companion companion73 = Result.INSTANCE;
                    objM12684constructorimpl37 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$21
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
                        }
                    }));
                } catch (Throwable th40) {
                    Result.Companion companion74 = Result.INSTANCE;
                    objM12684constructorimpl37 = Result.m12684constructorimpl(ResultKt.createFailure(th40));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl37)) {
                    objM12684constructorimpl37 = null;
                }
                TypeDescriptor typeDescriptor37 = (TypeDescriptor) objM12684constructorimpl37;
                if (typeDescriptor37 == null) {
                    typeDescriptor37 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType38 = new AnyType(typeDescriptor37, converters28);
            }
            anyTypeArr30[2] = anyType38;
            asyncFunctionBuilderStaticAsyncFunction7.setAsyncFunctionComponent(new SuspendFunctionComponent(name26, anyTypeArr30, new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22(null, this)));
            moduleDefinitionBuilder.getClassData().add(classComponentBuilder3.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder2;
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Query.class);
            Module module3 = moduleDefinitionBuilder5.getModule();
            if (module3 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext3 = module3.getAppContext();
            String simpleName3 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass3).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName3, "getSimpleName(...)");
            AnyType anyType39 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType39 == null) {
                try {
                    Result.Companion companion75 = Result.INSTANCE;
                    objM12684constructorimpl38 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$Class$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th41) {
                    Result.Companion companion76 = Result.INSTANCE;
                    objM12684constructorimpl38 = Result.m12684constructorimpl(ResultKt.createFailure(th41));
                }
                Object obj3 = objM12684constructorimpl38;
                if (Result.m12690isFailureimpl(obj3)) {
                    obj3 = null;
                }
                TypeDescriptor typeDescriptor38 = (TypeDescriptor) obj3;
                if (typeDescriptor38 == null) {
                    typeDescriptor38 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType39 = new AnyType(typeDescriptor38, null);
            }
            ClassComponentBuilder classComponentBuilder4 = new ClassComponentBuilder(appContext3, simpleName3, orCreateKotlinClass3, anyType39, moduleDefinitionBuilder5.getConverters());
            AnyType[] anyTypeArr31 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider5 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType9 = returnTypeProvider5.getTypes().get(Object.class);
            if (returnType9 == null) {
                JSTypeConverter<?> directConverter5 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter5 == null) {
                    directConverter5 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType10 = new ReturnType(directConverter5);
                returnTypeProvider5.getTypes().put(Object.class, returnType10);
                returnType9 = returnType10;
            }
            classComponentBuilder4.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr31, returnType9, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Constructor$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AssetFactory assetFactory = this.this$0.getAssetFactory();
                    AssetMapper assetMapper = this.this$0.getAssetMapper();
                    ContentResolver contentResolver = this.this$0.getContext().getContentResolver();
                    Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
                    return new Query(assetFactory, assetMapper, contentResolver);
                }
            }));
            ClassComponentBuilder classComponentBuilder5 = classComponentBuilder4;
            TypeConverterProvider converters29 = classComponentBuilder5.getConverters();
            AnyType[] anyTypeArr32 = new AnyType[2];
            AnyType anyType40 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType40 == null) {
                try {
                    Result.Companion companion77 = Result.INSTANCE;
                    objM12684constructorimpl39 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th42) {
                    Result.Companion companion78 = Result.INSTANCE;
                    objM12684constructorimpl39 = Result.m12684constructorimpl(ResultKt.createFailure(th42));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl39)) {
                    objM12684constructorimpl39 = null;
                }
                TypeDescriptor typeDescriptor39 = (TypeDescriptor) objM12684constructorimpl39;
                if (typeDescriptor39 == null) {
                    typeDescriptor39 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType40 = new AnyType(typeDescriptor39, converters29);
            }
            anyTypeArr32[0] = anyType40;
            AnyType anyType41 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType41 == null) {
                try {
                    Result.Companion companion79 = Result.INSTANCE;
                    objM12684constructorimpl40 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
                        }
                    }));
                } catch (Throwable th43) {
                    Result.Companion companion80 = Result.INSTANCE;
                    objM12684constructorimpl40 = Result.m12684constructorimpl(ResultKt.createFailure(th43));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl40)) {
                    objM12684constructorimpl40 = null;
                }
                TypeDescriptor typeDescriptor40 = (TypeDescriptor) objM12684constructorimpl40;
                if (typeDescriptor40 == null) {
                    typeDescriptor40 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                }
                anyType41 = new AnyType(typeDescriptor40, converters29);
            }
            anyTypeArr32[1] = anyType41;
            ReturnTypeProvider returnTypeProvider6 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType11 = returnTypeProvider6.getTypes().get(Query.class);
            if (returnType11 == null) {
                JSTypeConverter<?> directConverter6 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter6 == null) {
                    directConverter6 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType12 = new ReturnType(directConverter6);
                returnTypeProvider6.getTypes().put(Query.class, returnType12);
                returnType11 = returnType12;
            }
            classComponentBuilder5.getSyncFunctions().put("limit", new SyncFunctionComponent("limit", anyTypeArr32, returnType11, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((Query) objArr[0]).limit(((Number) objArr[1]).intValue());
                }
            }));
            ClassComponentBuilder classComponentBuilder6 = classComponentBuilder4;
            TypeConverterProvider converters30 = classComponentBuilder6.getConverters();
            AnyType[] anyTypeArr33 = new AnyType[2];
            AnyType anyType42 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType42 == null) {
                try {
                    Result.Companion companion81 = Result.INSTANCE;
                    objM12684constructorimpl41 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th44) {
                    Result.Companion companion82 = Result.INSTANCE;
                    objM12684constructorimpl41 = Result.m12684constructorimpl(ResultKt.createFailure(th44));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl41)) {
                    objM12684constructorimpl41 = null;
                }
                TypeDescriptor typeDescriptor41 = (TypeDescriptor) objM12684constructorimpl41;
                if (typeDescriptor41 == null) {
                    typeDescriptor41 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType42 = new AnyType(typeDescriptor41, converters30);
            }
            anyTypeArr33[0] = anyType42;
            AnyType anyType43 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType43 == null) {
                try {
                    Result.Companion companion83 = Result.INSTANCE;
                    objM12684constructorimpl42 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
                        }
                    }));
                } catch (Throwable th45) {
                    Result.Companion companion84 = Result.INSTANCE;
                    objM12684constructorimpl42 = Result.m12684constructorimpl(ResultKt.createFailure(th45));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl42)) {
                    objM12684constructorimpl42 = null;
                }
                TypeDescriptor typeDescriptor42 = (TypeDescriptor) objM12684constructorimpl42;
                if (typeDescriptor42 == null) {
                    typeDescriptor42 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                }
                anyType43 = new AnyType(typeDescriptor42, converters30);
            }
            anyTypeArr33[1] = anyType43;
            ReturnTypeProvider returnTypeProvider7 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType13 = returnTypeProvider7.getTypes().get(Query.class);
            if (returnType13 == null) {
                JSTypeConverter<?> directConverter7 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter7 == null) {
                    directConverter7 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType14 = new ReturnType(directConverter7);
                returnTypeProvider7.getTypes().put(Query.class, returnType14);
                returnType13 = returnType14;
            }
            classComponentBuilder6.getSyncFunctions().put("offset", new SyncFunctionComponent("offset", anyTypeArr33, returnType13, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((Query) objArr[0]).offset(((Number) objArr[1]).intValue());
                }
            }));
            ClassComponentBuilder classComponentBuilder7 = classComponentBuilder4;
            TypeConverterProvider converters31 = classComponentBuilder7.getConverters();
            AnyType[] anyTypeArr34 = new AnyType[2];
            AnyType anyType44 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType44 == null) {
                try {
                    Result.Companion companion85 = Result.INSTANCE;
                    objM12684constructorimpl43 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th46) {
                    Result.Companion companion86 = Result.INSTANCE;
                    objM12684constructorimpl43 = Result.m12684constructorimpl(ResultKt.createFailure(th46));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl43)) {
                    objM12684constructorimpl43 = null;
                }
                TypeDescriptor typeDescriptor43 = (TypeDescriptor) objM12684constructorimpl43;
                if (typeDescriptor43 == null) {
                    typeDescriptor43 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType44 = new AnyType(typeDescriptor43, converters31);
            }
            anyTypeArr34[0] = anyType44;
            AnyType anyType45 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Album.class), false));
            if (anyType45 == null) {
                try {
                    Result.Companion companion87 = Result.INSTANCE;
                    objM12684constructorimpl44 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Album.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Album.class);
                        }
                    }));
                } catch (Throwable th47) {
                    Result.Companion companion88 = Result.INSTANCE;
                    objM12684constructorimpl44 = Result.m12684constructorimpl(ResultKt.createFailure(th47));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl44)) {
                    objM12684constructorimpl44 = null;
                }
                TypeDescriptor typeDescriptor44 = (TypeDescriptor) objM12684constructorimpl44;
                if (typeDescriptor44 == null) {
                    typeDescriptor44 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Album.class));
                }
                anyType45 = new AnyType(typeDescriptor44, converters31);
            }
            anyTypeArr34[1] = anyType45;
            ReturnTypeProvider returnTypeProvider8 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType15 = returnTypeProvider8.getTypes().get(Query.class);
            if (returnType15 == null) {
                JSTypeConverter<?> directConverter8 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter8 == null) {
                    directConverter8 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType16 = new ReturnType(directConverter8);
                returnTypeProvider8.getTypes().put(Query.class, returnType16);
                returnType15 = returnType16;
            }
            classComponentBuilder7.getSyncFunctions().put("album", new SyncFunctionComponent("album", anyTypeArr34, returnType15, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((Query) objArr[0]).album((Album) objArr[1]);
                }
            }));
            ClassComponentBuilder classComponentBuilder8 = classComponentBuilder4;
            TypeConverterProvider converters32 = classComponentBuilder8.getConverters();
            AnyType[] anyTypeArr35 = new AnyType[3];
            AnyType anyType46 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType46 == null) {
                try {
                    Result.Companion companion89 = Result.INSTANCE;
                    objM12684constructorimpl45 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th48) {
                    Result.Companion companion90 = Result.INSTANCE;
                    objM12684constructorimpl45 = Result.m12684constructorimpl(ResultKt.createFailure(th48));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl45)) {
                    objM12684constructorimpl45 = null;
                }
                TypeDescriptor typeDescriptor45 = (TypeDescriptor) objM12684constructorimpl45;
                if (typeDescriptor45 == null) {
                    typeDescriptor45 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType46 = new AnyType(typeDescriptor45, converters32);
            }
            anyTypeArr35[0] = anyType46;
            AnyType anyType47 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AssetField.class), false));
            if (anyType47 == null) {
                try {
                    Result.Companion companion91 = Result.INSTANCE;
                    objM12684constructorimpl46 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AssetField.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(AssetField.class);
                        }
                    }));
                } catch (Throwable th49) {
                    Result.Companion companion92 = Result.INSTANCE;
                    objM12684constructorimpl46 = Result.m12684constructorimpl(ResultKt.createFailure(th49));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl46)) {
                    objM12684constructorimpl46 = null;
                }
                TypeDescriptor typeDescriptor46 = (TypeDescriptor) objM12684constructorimpl46;
                if (typeDescriptor46 == null) {
                    typeDescriptor46 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AssetField.class));
                }
                anyType47 = new AnyType(typeDescriptor46, converters32);
            }
            anyTypeArr35[1] = anyType47;
            AnyType anyType48 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(EitherOfThree.class), false));
            if (anyType48 == null) {
                try {
                    Result.Companion companion93 = Result.INSTANCE;
                    objM12684constructorimpl47 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(EitherOfThree.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(MediaType.class, false, null), PTypeDescriptorRegistry.LONG, PTypeDescriptorRegistry.BOOLEAN), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(EitherOfThree.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(MediaType.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Long.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Boolean.TYPE)));
                        }
                    }));
                } catch (Throwable th50) {
                    Result.Companion companion94 = Result.INSTANCE;
                    objM12684constructorimpl47 = Result.m12684constructorimpl(ResultKt.createFailure(th50));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl47)) {
                    objM12684constructorimpl47 = null;
                }
                TypeDescriptor typeDescriptor47 = (TypeDescriptor) objM12684constructorimpl47;
                if (typeDescriptor47 == null) {
                    typeDescriptor47 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(EitherOfThree.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(MediaType.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Long.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Boolean.TYPE))));
                }
                anyType48 = new AnyType(typeDescriptor47, converters32);
            }
            anyTypeArr35[2] = anyType48;
            ReturnTypeProvider returnTypeProvider9 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType17 = returnTypeProvider9.getTypes().get(Query.class);
            if (returnType17 == null) {
                JSTypeConverter<?> directConverter9 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter9 == null) {
                    directConverter9 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType18 = new ReturnType(directConverter9);
                returnTypeProvider9.getTypes().put(Query.class, returnType18);
                returnType17 = returnType18;
            }
            classComponentBuilder8.getSyncFunctions().put("eq", new SyncFunctionComponent("eq", anyTypeArr35, returnType17, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj4 = objArr[0];
                    Object obj5 = objArr[1];
                    AssetField assetField = (AssetField) obj5;
                    return ((Query) obj4).eq(assetField, MediaStoreQueryFormatter.INSTANCE.parse(assetField, (EitherOfThree<MediaType, Long, Boolean>) objArr[2]));
                }
            }));
            ClassComponentBuilder classComponentBuilder9 = classComponentBuilder4;
            TypeConverterProvider converters33 = classComponentBuilder9.getConverters();
            AnyType[] anyTypeArr36 = new AnyType[3];
            AnyType anyType49 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType49 == null) {
                try {
                    Result.Companion companion95 = Result.INSTANCE;
                    objM12684constructorimpl48 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$14
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th51) {
                    Result.Companion companion96 = Result.INSTANCE;
                    objM12684constructorimpl48 = Result.m12684constructorimpl(ResultKt.createFailure(th51));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl48)) {
                    objM12684constructorimpl48 = null;
                }
                TypeDescriptor typeDescriptor48 = (TypeDescriptor) objM12684constructorimpl48;
                if (typeDescriptor48 == null) {
                    typeDescriptor48 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType49 = new AnyType(typeDescriptor48, converters33);
            }
            anyTypeArr36[0] = anyType49;
            AnyType anyType50 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AssetField.class), false));
            if (anyType50 == null) {
                try {
                    Result.Companion companion97 = Result.INSTANCE;
                    objM12684constructorimpl49 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AssetField.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$15
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(AssetField.class);
                        }
                    }));
                } catch (Throwable th52) {
                    Result.Companion companion98 = Result.INSTANCE;
                    objM12684constructorimpl49 = Result.m12684constructorimpl(ResultKt.createFailure(th52));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl49)) {
                    objM12684constructorimpl49 = null;
                }
                TypeDescriptor typeDescriptor49 = (TypeDescriptor) objM12684constructorimpl49;
                if (typeDescriptor49 == null) {
                    typeDescriptor49 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AssetField.class));
                }
                anyType50 = new AnyType(typeDescriptor49, converters33);
            }
            anyTypeArr36[1] = anyType50;
            AnyType anyType51 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType51 == null) {
                try {
                    Result.Companion companion99 = Result.INSTANCE;
                    objM12684constructorimpl50 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateParameterized(EitherOfThree.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(MediaType.class, false, null), PTypeDescriptorRegistry.LONG, PTypeDescriptorRegistry.BOOLEAN), null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$16
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(EitherOfThree.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(MediaType.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Long.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Boolean.TYPE)))));
                        }
                    }));
                } catch (Throwable th53) {
                    Result.Companion companion100 = Result.INSTANCE;
                    objM12684constructorimpl50 = Result.m12684constructorimpl(ResultKt.createFailure(th53));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl50)) {
                    objM12684constructorimpl50 = null;
                }
                TypeDescriptor typeDescriptor50 = (TypeDescriptor) objM12684constructorimpl50;
                if (typeDescriptor50 == null) {
                    typeDescriptor50 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(EitherOfThree.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(MediaType.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Long.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Boolean.TYPE))))));
                }
                anyType51 = new AnyType(typeDescriptor50, converters33);
            }
            anyTypeArr36[2] = anyType51;
            ReturnTypeProvider returnTypeProvider10 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType19 = returnTypeProvider10.getTypes().get(Query.class);
            if (returnType19 == null) {
                JSTypeConverter<?> directConverter10 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter10 == null) {
                    directConverter10 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType20 = new ReturnType(directConverter10);
                returnTypeProvider10.getTypes().put(Query.class, returnType20);
                returnType19 = returnType20;
            }
            classComponentBuilder9.getSyncFunctions().put("within", new SyncFunctionComponent("within", anyTypeArr36, returnType19, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj4 = objArr[0];
                    AssetField assetField = (AssetField) objArr[1];
                    Query query = (Query) obj4;
                    List list = (List) objArr[2];
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(MediaStoreQueryFormatter.INSTANCE.parse(assetField, (EitherOfThree<MediaType, Long, Boolean>) it.next()));
                    }
                    return query.within(assetField, arrayList);
                }
            }));
            ClassComponentBuilder classComponentBuilder10 = classComponentBuilder4;
            TypeConverterProvider converters34 = classComponentBuilder10.getConverters();
            AnyType[] anyTypeArr37 = new AnyType[3];
            AnyType anyType52 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType52 == null) {
                try {
                    Result.Companion companion101 = Result.INSTANCE;
                    objM12684constructorimpl51 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$18
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th54) {
                    Result.Companion companion102 = Result.INSTANCE;
                    objM12684constructorimpl51 = Result.m12684constructorimpl(ResultKt.createFailure(th54));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl51)) {
                    objM12684constructorimpl51 = null;
                }
                TypeDescriptor typeDescriptor51 = (TypeDescriptor) objM12684constructorimpl51;
                if (typeDescriptor51 == null) {
                    typeDescriptor51 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType52 = new AnyType(typeDescriptor51, converters34);
            }
            anyTypeArr37[0] = anyType52;
            AnyType anyType53 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AssetField.class), false));
            if (anyType53 == null) {
                try {
                    Result.Companion companion103 = Result.INSTANCE;
                    objM12684constructorimpl52 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AssetField.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$19
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(AssetField.class);
                        }
                    }));
                } catch (Throwable th55) {
                    Result.Companion companion104 = Result.INSTANCE;
                    objM12684constructorimpl52 = Result.m12684constructorimpl(ResultKt.createFailure(th55));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl52)) {
                    objM12684constructorimpl52 = null;
                }
                TypeDescriptor typeDescriptor52 = (TypeDescriptor) objM12684constructorimpl52;
                if (typeDescriptor52 == null) {
                    typeDescriptor52 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AssetField.class));
                }
                anyType53 = new AnyType(typeDescriptor52, converters34);
            }
            anyTypeArr37[1] = anyType53;
            AnyType anyType54 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Long.class), false));
            if (anyType54 == null) {
                try {
                    Result.Companion companion105 = Result.INSTANCE;
                    objM12684constructorimpl53 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$20
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Long.TYPE);
                        }
                    }));
                } catch (Throwable th56) {
                    Result.Companion companion106 = Result.INSTANCE;
                    objM12684constructorimpl53 = Result.m12684constructorimpl(ResultKt.createFailure(th56));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl53)) {
                    objM12684constructorimpl53 = null;
                }
                TypeDescriptor typeDescriptor53 = (TypeDescriptor) objM12684constructorimpl53;
                if (typeDescriptor53 == null) {
                    typeDescriptor53 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Long.TYPE));
                }
                anyType54 = new AnyType(typeDescriptor53, converters34);
            }
            anyTypeArr37[2] = anyType54;
            ReturnTypeProvider returnTypeProvider11 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType21 = returnTypeProvider11.getTypes().get(Query.class);
            if (returnType21 == null) {
                JSTypeConverter<?> directConverter11 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter11 == null) {
                    directConverter11 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType22 = new ReturnType(directConverter11);
                returnTypeProvider11.getTypes().put(Query.class, returnType22);
                returnType21 = returnType22;
            }
            classComponentBuilder10.getSyncFunctions().put("gt", new SyncFunctionComponent("gt", anyTypeArr37, returnType21, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj4 = objArr[0];
                    Object obj5 = objArr[1];
                    AssetField assetField = (AssetField) obj5;
                    return ((Query) obj4).gt(assetField, MediaStoreQueryFormatter.INSTANCE.parse(assetField, ((Number) objArr[2]).longValue()));
                }
            }));
            ClassComponentBuilder classComponentBuilder11 = classComponentBuilder4;
            TypeConverterProvider converters35 = classComponentBuilder11.getConverters();
            AnyType[] anyTypeArr38 = new AnyType[3];
            AnyType anyType55 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType55 == null) {
                try {
                    Result.Companion companion107 = Result.INSTANCE;
                    objM12684constructorimpl54 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$22
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th57) {
                    Result.Companion companion108 = Result.INSTANCE;
                    objM12684constructorimpl54 = Result.m12684constructorimpl(ResultKt.createFailure(th57));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl54)) {
                    objM12684constructorimpl54 = null;
                }
                TypeDescriptor typeDescriptor54 = (TypeDescriptor) objM12684constructorimpl54;
                if (typeDescriptor54 == null) {
                    typeDescriptor54 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType55 = new AnyType(typeDescriptor54, converters35);
            }
            anyTypeArr38[0] = anyType55;
            AnyType anyType56 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AssetField.class), false));
            if (anyType56 == null) {
                try {
                    Result.Companion companion109 = Result.INSTANCE;
                    objM12684constructorimpl55 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AssetField.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$23
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(AssetField.class);
                        }
                    }));
                } catch (Throwable th58) {
                    Result.Companion companion110 = Result.INSTANCE;
                    objM12684constructorimpl55 = Result.m12684constructorimpl(ResultKt.createFailure(th58));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl55)) {
                    objM12684constructorimpl55 = null;
                }
                TypeDescriptor typeDescriptor55 = (TypeDescriptor) objM12684constructorimpl55;
                if (typeDescriptor55 == null) {
                    typeDescriptor55 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AssetField.class));
                }
                anyType56 = new AnyType(typeDescriptor55, converters35);
            }
            anyTypeArr38[1] = anyType56;
            AnyType anyType57 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Long.class), false));
            if (anyType57 == null) {
                try {
                    Result.Companion companion111 = Result.INSTANCE;
                    objM12684constructorimpl56 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$24
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Long.TYPE);
                        }
                    }));
                } catch (Throwable th59) {
                    Result.Companion companion112 = Result.INSTANCE;
                    objM12684constructorimpl56 = Result.m12684constructorimpl(ResultKt.createFailure(th59));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl56)) {
                    objM12684constructorimpl56 = null;
                }
                TypeDescriptor typeDescriptor56 = (TypeDescriptor) objM12684constructorimpl56;
                if (typeDescriptor56 == null) {
                    typeDescriptor56 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Long.TYPE));
                }
                anyType57 = new AnyType(typeDescriptor56, converters35);
            }
            anyTypeArr38[2] = anyType57;
            ReturnTypeProvider returnTypeProvider12 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType23 = returnTypeProvider12.getTypes().get(Query.class);
            if (returnType23 == null) {
                JSTypeConverter<?> directConverter12 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter12 == null) {
                    directConverter12 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType24 = new ReturnType(directConverter12);
                returnTypeProvider12.getTypes().put(Query.class, returnType24);
                returnType23 = returnType24;
            }
            classComponentBuilder11.getSyncFunctions().put("gte", new SyncFunctionComponent("gte", anyTypeArr38, returnType23, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$25
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj4 = objArr[0];
                    Object obj5 = objArr[1];
                    AssetField assetField = (AssetField) obj5;
                    return ((Query) obj4).gte(assetField, MediaStoreQueryFormatter.INSTANCE.parse(assetField, ((Number) objArr[2]).longValue()));
                }
            }));
            ClassComponentBuilder classComponentBuilder12 = classComponentBuilder4;
            TypeConverterProvider converters36 = classComponentBuilder12.getConverters();
            AnyType[] anyTypeArr39 = new AnyType[3];
            AnyType anyType58 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType58 == null) {
                try {
                    Result.Companion companion113 = Result.INSTANCE;
                    objM12684constructorimpl57 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$26
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th60) {
                    Result.Companion companion114 = Result.INSTANCE;
                    objM12684constructorimpl57 = Result.m12684constructorimpl(ResultKt.createFailure(th60));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl57)) {
                    objM12684constructorimpl57 = null;
                }
                TypeDescriptor typeDescriptor57 = (TypeDescriptor) objM12684constructorimpl57;
                if (typeDescriptor57 == null) {
                    typeDescriptor57 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType58 = new AnyType(typeDescriptor57, converters36);
            }
            anyTypeArr39[0] = anyType58;
            AnyType anyType59 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AssetField.class), false));
            if (anyType59 == null) {
                try {
                    Result.Companion companion115 = Result.INSTANCE;
                    objM12684constructorimpl58 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AssetField.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$27
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(AssetField.class);
                        }
                    }));
                } catch (Throwable th61) {
                    Result.Companion companion116 = Result.INSTANCE;
                    objM12684constructorimpl58 = Result.m12684constructorimpl(ResultKt.createFailure(th61));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl58)) {
                    objM12684constructorimpl58 = null;
                }
                TypeDescriptor typeDescriptor58 = (TypeDescriptor) objM12684constructorimpl58;
                if (typeDescriptor58 == null) {
                    typeDescriptor58 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AssetField.class));
                }
                anyType59 = new AnyType(typeDescriptor58, converters36);
            }
            anyTypeArr39[1] = anyType59;
            AnyType anyType60 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Long.class), false));
            if (anyType60 == null) {
                try {
                    Result.Companion companion117 = Result.INSTANCE;
                    objM12684constructorimpl59 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$28
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Long.TYPE);
                        }
                    }));
                } catch (Throwable th62) {
                    Result.Companion companion118 = Result.INSTANCE;
                    objM12684constructorimpl59 = Result.m12684constructorimpl(ResultKt.createFailure(th62));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl59)) {
                    objM12684constructorimpl59 = null;
                }
                TypeDescriptor typeDescriptor59 = (TypeDescriptor) objM12684constructorimpl59;
                if (typeDescriptor59 == null) {
                    typeDescriptor59 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Long.TYPE));
                }
                anyType60 = new AnyType(typeDescriptor59, converters36);
            }
            anyTypeArr39[2] = anyType60;
            ReturnTypeProvider returnTypeProvider13 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType25 = returnTypeProvider13.getTypes().get(Query.class);
            if (returnType25 == null) {
                JSTypeConverter<?> directConverter13 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter13 == null) {
                    directConverter13 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType26 = new ReturnType(directConverter13);
                returnTypeProvider13.getTypes().put(Query.class, returnType26);
                returnType25 = returnType26;
            }
            classComponentBuilder12.getSyncFunctions().put("lt", new SyncFunctionComponent("lt", anyTypeArr39, returnType25, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$29
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj4 = objArr[0];
                    Object obj5 = objArr[1];
                    AssetField assetField = (AssetField) obj5;
                    return ((Query) obj4).lt(assetField, MediaStoreQueryFormatter.INSTANCE.parse(assetField, ((Number) objArr[2]).longValue()));
                }
            }));
            ClassComponentBuilder classComponentBuilder13 = classComponentBuilder4;
            TypeConverterProvider converters37 = classComponentBuilder13.getConverters();
            AnyType[] anyTypeArr40 = new AnyType[3];
            AnyType anyType61 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType61 == null) {
                try {
                    Result.Companion companion119 = Result.INSTANCE;
                    objM12684constructorimpl60 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$30
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th63) {
                    Result.Companion companion120 = Result.INSTANCE;
                    objM12684constructorimpl60 = Result.m12684constructorimpl(ResultKt.createFailure(th63));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl60)) {
                    objM12684constructorimpl60 = null;
                }
                TypeDescriptor typeDescriptor60 = (TypeDescriptor) objM12684constructorimpl60;
                if (typeDescriptor60 == null) {
                    typeDescriptor60 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType61 = new AnyType(typeDescriptor60, converters37);
            }
            anyTypeArr40[0] = anyType61;
            AnyType anyType62 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AssetField.class), false));
            if (anyType62 == null) {
                try {
                    Result.Companion companion121 = Result.INSTANCE;
                    objM12684constructorimpl61 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AssetField.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$31
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(AssetField.class);
                        }
                    }));
                } catch (Throwable th64) {
                    Result.Companion companion122 = Result.INSTANCE;
                    objM12684constructorimpl61 = Result.m12684constructorimpl(ResultKt.createFailure(th64));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl61)) {
                    objM12684constructorimpl61 = null;
                }
                TypeDescriptor typeDescriptor61 = (TypeDescriptor) objM12684constructorimpl61;
                if (typeDescriptor61 == null) {
                    typeDescriptor61 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AssetField.class));
                }
                anyType62 = new AnyType(typeDescriptor61, converters37);
            }
            anyTypeArr40[1] = anyType62;
            AnyType anyType63 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Long.class), false));
            if (anyType63 == null) {
                try {
                    Result.Companion companion123 = Result.INSTANCE;
                    objM12684constructorimpl62 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$32
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Long.TYPE);
                        }
                    }));
                } catch (Throwable th65) {
                    Result.Companion companion124 = Result.INSTANCE;
                    objM12684constructorimpl62 = Result.m12684constructorimpl(ResultKt.createFailure(th65));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl62)) {
                    objM12684constructorimpl62 = null;
                }
                TypeDescriptor typeDescriptor62 = (TypeDescriptor) objM12684constructorimpl62;
                if (typeDescriptor62 == null) {
                    typeDescriptor62 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Long.TYPE));
                }
                anyType63 = new AnyType(typeDescriptor62, converters37);
            }
            anyTypeArr40[2] = anyType63;
            ReturnTypeProvider returnTypeProvider14 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType27 = returnTypeProvider14.getTypes().get(Query.class);
            if (returnType27 == null) {
                JSTypeConverter<?> directConverter14 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter14 == null) {
                    directConverter14 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType28 = new ReturnType(directConverter14);
                returnTypeProvider14.getTypes().put(Query.class, returnType28);
                returnType27 = returnType28;
            }
            classComponentBuilder13.getSyncFunctions().put("lte", new SyncFunctionComponent("lte", anyTypeArr40, returnType27, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$33
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj4 = objArr[0];
                    Object obj5 = objArr[1];
                    AssetField assetField = (AssetField) obj5;
                    return ((Query) obj4).lte(assetField, MediaStoreQueryFormatter.INSTANCE.parse(assetField, ((Number) objArr[2]).longValue()));
                }
            }));
            ClassComponentBuilder classComponentBuilder14 = classComponentBuilder4;
            TypeConverterProvider converters38 = classComponentBuilder14.getConverters();
            AnyType[] anyTypeArr41 = new AnyType[2];
            AnyType anyType64 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType64 == null) {
                try {
                    Result.Companion companion125 = Result.INSTANCE;
                    objM12684constructorimpl63 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$34
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th66) {
                    Result.Companion companion126 = Result.INSTANCE;
                    objM12684constructorimpl63 = Result.m12684constructorimpl(ResultKt.createFailure(th66));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl63)) {
                    objM12684constructorimpl63 = null;
                }
                TypeDescriptor typeDescriptor63 = (TypeDescriptor) objM12684constructorimpl63;
                if (typeDescriptor63 == null) {
                    typeDescriptor63 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType64 = new AnyType(typeDescriptor63, converters38);
            }
            anyTypeArr41[0] = anyType64;
            AnyType anyType65 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType65 == null) {
                try {
                    Result.Companion companion127 = Result.INSTANCE;
                    objM12684constructorimpl64 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(AssetField.class, false, null), PTypeDescriptorRegistry.getOrCreateConcrete(SortDescriptor.class, false, SortDescriptor.__Pika.__pika$IntrospectionData)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$35
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(AssetField.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(SortDescriptor.class)));
                        }
                    }));
                } catch (Throwable th67) {
                    Result.Companion companion128 = Result.INSTANCE;
                    objM12684constructorimpl64 = Result.m12684constructorimpl(ResultKt.createFailure(th67));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl64)) {
                    objM12684constructorimpl64 = null;
                }
                TypeDescriptor typeDescriptor64 = (TypeDescriptor) objM12684constructorimpl64;
                if (typeDescriptor64 == null) {
                    typeDescriptor64 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(AssetField.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(SortDescriptor.class))));
                }
                anyType65 = new AnyType(typeDescriptor64, converters38);
            }
            anyTypeArr41[1] = anyType65;
            ReturnTypeProvider returnTypeProvider15 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType29 = returnTypeProvider15.getTypes().get(Query.class);
            if (returnType29 == null) {
                JSTypeConverter<?> directConverter15 = ReturnTypeKt.getDirectConverter(Query.class);
                if (directConverter15 == null) {
                    directConverter15 = ReturnTypeKt.getIndirectConverter(Query.class, null);
                }
                ReturnType returnType30 = new ReturnType(directConverter15);
                returnTypeProvider15.getTypes().put(Query.class, returnType30);
                returnType29 = returnType30;
            }
            classComponentBuilder14.getSyncFunctions().put("orderBy", new SyncFunctionComponent("orderBy", anyTypeArr41, returnType29, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Function$36
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj4 = objArr[0];
                    Either either = (Either) objArr[1];
                    Query query = (Query) obj4;
                    if (either.isFirstType(Reflection.getOrCreateKotlinClass(AssetField.class))) {
                        return query.orderBy(new SortDescriptor((AssetField) either.getFirstType(Reflection.getOrCreateKotlinClass(AssetField.class)), null, 2, null));
                    }
                    return query.orderBy((SortDescriptor) either.getSecondType(Reflection.getOrCreateKotlinClass(SortDescriptor.class)));
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction22 = classComponentBuilder4.AsyncFunction("exe");
            String name27 = asyncFunctionBuilderAsyncFunction22.getName();
            TypeConverterProvider converters39 = asyncFunctionBuilderAsyncFunction22.getConverters();
            AnyType[] anyTypeArr42 = new AnyType[1];
            AnyType anyType66 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType66 == null) {
                try {
                    Result.Companion companion129 = Result.INSTANCE;
                    objM12684constructorimpl65 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th68) {
                    Result.Companion companion130 = Result.INSTANCE;
                    objM12684constructorimpl65 = Result.m12684constructorimpl(ResultKt.createFailure(th68));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl65)) {
                    objM12684constructorimpl65 = null;
                }
                TypeDescriptor typeDescriptor65 = (TypeDescriptor) objM12684constructorimpl65;
                if (typeDescriptor65 == null) {
                    typeDescriptor65 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType66 = new AnyType(typeDescriptor65, converters39);
            }
            anyTypeArr42[0] = anyType66;
            asyncFunctionBuilderAsyncFunction22.setAsyncFunctionComponent(new SuspendFunctionComponent(name27, anyTypeArr42, new MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Coroutine$2(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction23 = classComponentBuilder4.AsyncFunction("exeForMetadata");
            String name28 = asyncFunctionBuilderAsyncFunction23.getName();
            TypeConverterProvider converters40 = asyncFunctionBuilderAsyncFunction23.getConverters();
            AnyType[] anyTypeArr43 = new AnyType[1];
            AnyType anyType67 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Query.class), false));
            if (anyType67 == null) {
                try {
                    Result.Companion companion131 = Result.INSTANCE;
                    objM12684constructorimpl66 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Query.class, false, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Query.class);
                        }
                    }));
                } catch (Throwable th69) {
                    Result.Companion companion132 = Result.INSTANCE;
                    objM12684constructorimpl66 = Result.m12684constructorimpl(ResultKt.createFailure(th69));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl66)) {
                    objM12684constructorimpl66 = null;
                }
                TypeDescriptor typeDescriptor66 = (TypeDescriptor) objM12684constructorimpl66;
                if (typeDescriptor66 == null) {
                    typeDescriptor66 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Query.class));
                }
                anyType67 = new AnyType(typeDescriptor66, converters40);
            }
            anyTypeArr43[0] = anyType67;
            asyncFunctionBuilderAsyncFunction23.setAsyncFunctionComponent(new SuspendFunctionComponent(name28, anyTypeArr43, new MediaLibraryNextModule$definition$lambda$66$lambda$62$$inlined$Coroutine$4(null)));
            moduleDefinitionBuilder5.getClassData().add(classComponentBuilder4.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder2;
            TypeConverterProvider converters41 = moduleDefinitionBuilder6.getConverters();
            AnyType[] anyTypeArr44 = new AnyType[2];
            AnyType anyType68 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType68 == null) {
                try {
                    Result.Companion companion133 = Result.INSTANCE;
                    objM12684constructorimpl67 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
                        }
                    }));
                } catch (Throwable th70) {
                    Result.Companion companion134 = Result.INSTANCE;
                    objM12684constructorimpl67 = Result.m12684constructorimpl(ResultKt.createFailure(th70));
                }
                Object obj4 = objM12684constructorimpl67;
                if (Result.m12690isFailureimpl(obj4)) {
                    obj4 = null;
                }
                TypeDescriptor typeDescriptor67 = (TypeDescriptor) obj4;
                if (typeDescriptor67 == null) {
                    typeDescriptor67 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType68 = new AnyType(typeDescriptor67, converters41);
            }
            anyTypeArr44[0] = anyType68;
            AnyType anyType69 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), true));
            if (anyType69 == null) {
                try {
                    Result.Companion companion135 = Result.INSTANCE;
                    objM12684constructorimpl68 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, true, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(GranularPermission.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$AsyncFunctionWithPromise$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class)));
                        }
                    }));
                } catch (Throwable th71) {
                    Result.Companion companion136 = Result.INSTANCE;
                    objM12684constructorimpl68 = Result.m12684constructorimpl(ResultKt.createFailure(th71));
                }
                Object obj5 = objM12684constructorimpl68;
                if (Result.m12690isFailureimpl(obj5)) {
                    obj5 = null;
                }
                TypeDescriptor typeDescriptor68 = (TypeDescriptor) obj5;
                if (typeDescriptor68 == null) {
                    typeDescriptor68 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class))));
                }
                anyType69 = new AnyType(typeDescriptor68, converters41);
            }
            anyTypeArr44[1] = anyType69;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", anyTypeArr44, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$AsyncFunctionWithPromise$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj6 = objArr[0];
                    Boolean bool = (Boolean) obj6;
                    this.this$0.getSystemPermissionsDelegate().requestPermissions(bool != null ? bool.booleanValue() : false, (List) objArr[1], promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder6.getAsyncFunctions().put("requestPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder2;
            TypeConverterProvider converters42 = moduleDefinitionBuilder7.getConverters();
            AnyType[] anyTypeArr45 = new AnyType[2];
            AnyType anyType70 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType70 == null) {
                try {
                    Result.Companion companion137 = Result.INSTANCE;
                    objM12684constructorimpl69 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$AsyncFunctionWithPromise$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
                        }
                    }));
                } catch (Throwable th72) {
                    Result.Companion companion138 = Result.INSTANCE;
                    objM12684constructorimpl69 = Result.m12684constructorimpl(ResultKt.createFailure(th72));
                }
                Object obj6 = objM12684constructorimpl69;
                if (Result.m12690isFailureimpl(obj6)) {
                    obj6 = null;
                }
                TypeDescriptor typeDescriptor69 = (TypeDescriptor) obj6;
                if (typeDescriptor69 == null) {
                    typeDescriptor69 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType70 = new AnyType(typeDescriptor69, converters42);
            }
            anyTypeArr45[0] = anyType70;
            AnyType anyType71 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), true));
            if (anyType71 == null) {
                try {
                    Result.Companion companion139 = Result.INSTANCE;
                    objM12684constructorimpl70 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, true, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(GranularPermission.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$AsyncFunctionWithPromise$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class)));
                        }
                    }));
                } catch (Throwable th73) {
                    Result.Companion companion140 = Result.INSTANCE;
                    objM12684constructorimpl70 = Result.m12684constructorimpl(ResultKt.createFailure(th73));
                }
                Object obj7 = objM12684constructorimpl70;
                if (Result.m12690isFailureimpl(obj7)) {
                    obj7 = null;
                }
                TypeDescriptor typeDescriptor70 = (TypeDescriptor) obj7;
                if (typeDescriptor70 == null) {
                    typeDescriptor70 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class))));
                }
                anyType71 = new AnyType(typeDescriptor70, converters42);
            }
            anyTypeArr45[1] = anyType71;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", anyTypeArr45, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$AsyncFunctionWithPromise$6
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj8 = objArr[0];
                    Boolean bool = (Boolean) obj8;
                    this.this$0.getSystemPermissionsDelegate().getPermissions(bool != null ? bool.booleanValue() : false, (List) objArr[1], promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder7.getAsyncFunctions().put("getPermissionsAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder2;
            TypeConverterProvider converters43 = moduleDefinitionBuilder8.getConverters();
            AnyType[] anyTypeArr46 = new AnyType[1];
            AnyType anyType72 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), true));
            if (anyType72 == null) {
                try {
                    Result.Companion companion141 = Result.INSTANCE;
                    objM12684constructorimpl71 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, true, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(GranularPermission.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$AsyncFunctionWithPromise$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class)));
                        }
                    }));
                } catch (Throwable th74) {
                    Result.Companion companion142 = Result.INSTANCE;
                    objM12684constructorimpl71 = Result.m12684constructorimpl(ResultKt.createFailure(th74));
                }
                Object obj8 = objM12684constructorimpl71;
                if (Result.m12690isFailureimpl(obj8)) {
                    obj8 = null;
                }
                TypeDescriptor typeDescriptor71 = (TypeDescriptor) obj8;
                if (typeDescriptor71 == null) {
                    typeDescriptor71 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class))));
                }
                anyType72 = new AnyType(typeDescriptor71, converters43);
            }
            anyTypeArr46[0] = anyType72;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("presentPermissionsPicker", anyTypeArr46, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$$inlined$AsyncFunctionWithPromise$8
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    this.this$0.getSystemPermissionsDelegate().presentPermissionsPicker((List) objArr[0], promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder8.getAsyncFunctions().put("presentPermissionsPicker", asyncFunctionWithPromiseComponent3);
            moduleDefinitionBuilder2.RegisterActivityContracts(new MediaLibraryNextModule$definition$1$9(this, null));
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder2.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th75) {
            Trace.endSection();
            throw th75;
        }
    }
}
