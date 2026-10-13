package expo.modules.medialibrary.next.objects.album;

import android.content.ContentResolver;
import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException;
import expo.modules.medialibrary.next.extensions.WeakReferenceExtensionsKt;
import expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt;
import expo.modules.medialibrary.next.objects.album.factories.AlbumFactory;
import expo.modules.medialibrary.next.records.AlbumMetadata;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlbumQuery.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0086@¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00050\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lexpo/modules/medialibrary/next/objects/album/AlbumQuery;", "", "albumFactory", "Lexpo/modules/medialibrary/next/objects/album/factories/AlbumFactory;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Lexpo/modules/medialibrary/next/objects/album/factories/AlbumFactory;Landroid/content/Context;)V", "getAlbumFactory", "()Lexpo/modules/medialibrary/next/objects/album/factories/AlbumFactory;", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "getAlbum", "Lexpo/modules/medialibrary/next/objects/album/Album;", "title", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAlbums", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlbumsMetadata", "Lexpo/modules/medialibrary/next/records/AlbumMetadata;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AlbumQuery {
    private final AlbumFactory albumFactory;
    private final WeakReference<Context> contextRef;

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.album.AlbumQuery$getAlbum$1, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumQuery.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.AlbumQuery", f = "AlbumQuery.kt", i = {0}, l = {22}, m = "getAlbum", n = {"title"}, s = {"L$0"})
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
            return AlbumQuery.this.getAlbum(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.album.AlbumQuery$getAllAlbums$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumQuery.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.AlbumQuery", f = "AlbumQuery.kt", i = {}, l = {28}, m = "getAllAlbums", n = {}, s = {})
    static final class C08931 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08931(Continuation<? super C08931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumQuery.this.getAllAlbums(this);
        }
    }

    public AlbumQuery(AlbumFactory albumFactory, Context context) {
        Intrinsics.checkNotNullParameter(albumFactory, "albumFactory");
        Intrinsics.checkNotNullParameter(context, "context");
        this.albumFactory = albumFactory;
        this.contextRef = new WeakReference<>(context);
    }

    public final AlbumFactory getAlbumFactory() {
        return this.albumFactory;
    }

    private final ContentResolver getContentResolver() throws ContentResolverNotObtainedException {
        ContentResolver contentResolver = WeakReferenceExtensionsKt.getOrThrow(this.contextRef).getContentResolver();
        if (contentResolver != null) {
            return contentResolver;
        }
        throw new ContentResolverNotObtainedException(null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAlbum(String str, Continuation<? super Album> continuation) throws ContentResolverNotObtainedException {
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
        Object objQueryAlbumId = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAlbumId);
            ContentResolver contentResolver = getContentResolver();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.label = 1;
            objQueryAlbumId = AlbumExtensionsKt.queryAlbumId(contentResolver, str, anonymousClass1);
            if (objQueryAlbumId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryAlbumId);
        }
        String str2 = (String) objQueryAlbumId;
        if (str2 == null) {
            return null;
        }
        return this.albumFactory.create(str2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAllAlbums(Continuation<? super List<Album>> continuation) throws ContentResolverNotObtainedException {
        C08931 c08931;
        if (continuation instanceof C08931) {
            c08931 = (C08931) continuation;
            if ((c08931.label & Integer.MIN_VALUE) != 0) {
                c08931.label -= Integer.MIN_VALUE;
            } else {
                c08931 = new C08931(continuation);
            }
        } else {
            c08931 = new C08931(continuation);
        }
        Object objQueryAllAlbumIds = c08931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08931.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAllAlbumIds);
            ContentResolver contentResolver = getContentResolver();
            c08931.label = 1;
            objQueryAllAlbumIds = AlbumExtensionsKt.queryAllAlbumIds(contentResolver, c08931);
            if (objQueryAllAlbumIds == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryAllAlbumIds);
        }
        List list = (List) objQueryAllAlbumIds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.albumFactory.create((String) it.next()));
        }
        return arrayList;
    }

    public final Object getAlbumsMetadata(Continuation<? super List<AlbumMetadata>> continuation) {
        return AlbumExtensionsKt.queryAlbumsMetadata(getContentResolver(), continuation);
    }
}
