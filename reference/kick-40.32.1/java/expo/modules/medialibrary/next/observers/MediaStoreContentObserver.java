package expo.modules.medialibrary.next.observers;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import expo.modules.medialibrary.next.extensions.resolver.AlbumExtensionsKt;
import expo.modules.medialibrary.next.extensions.resolver.SafeQueryKt;
import expo.modules.medialibrary.next.objects.wrappers.MediaType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MediaStoreContentObserver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/medialibrary/next/observers/MediaStoreContentObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "mediaType", "Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;", "onChange", "Lexpo/modules/medialibrary/next/observers/OnMediaLibraryChange;", "observerScope", "Lkotlinx/coroutines/CoroutineScope;", "contentResolver", "Landroid/content/ContentResolver;", "<init>", "(Landroid/os/Handler;Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;Lexpo/modules/medialibrary/next/observers/OnMediaLibraryChange;Lkotlinx/coroutines/CoroutineScope;Landroid/content/ContentResolver;)V", "assetsIdSum", "", "", "selfChange", "", "uri", "Landroid/net/Uri;", "getAssetsIdSum", "(Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaStoreContentObserver extends ContentObserver {
    private long assetsIdSum;
    private final ContentResolver contentResolver;
    private final MediaType mediaType;
    private final CoroutineScope observerScope;
    private final OnMediaLibraryChange onChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaStoreContentObserver(Handler handler, MediaType mediaType, OnMediaLibraryChange onChange, CoroutineScope observerScope, ContentResolver contentResolver) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        Intrinsics.checkNotNullParameter(observerScope, "observerScope");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.mediaType = mediaType;
        this.onChange = onChange;
        this.observerScope = observerScope;
        this.contentResolver = contentResolver;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        onChange(selfChange, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.observers.MediaStoreContentObserver$onChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaStoreContentObserver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.observers.MediaStoreContentObserver$onChange$1", f = "MediaStoreContentObserver.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaStoreContentObserver.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MediaStoreContentObserver mediaStoreContentObserver = MediaStoreContentObserver.this;
                this.label = 1;
                obj = mediaStoreContentObserver.getAssetsIdSum(mediaStoreContentObserver.mediaType, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            long jLongValue = ((Number) obj).longValue();
            if (jLongValue != MediaStoreContentObserver.this.assetsIdSum) {
                MediaStoreContentObserver.this.assetsIdSum = jLongValue;
                MediaStoreContentObserver.this.onChange.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        BuildersKt__Builders_commonKt.launch$default(this.observerScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.observers.MediaStoreContentObserver$getAssetsIdSum$2, reason: invalid class name */
    /* JADX INFO: compiled from: MediaStoreContentObserver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.observers.MediaStoreContentObserver$getAssetsIdSum$2", f = "MediaStoreContentObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ MediaType $mediaType;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MediaType mediaType, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$mediaType = mediaType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = MediaStoreContentObserver.this.new AnonymousClass2(this.$mediaType, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
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
            Cursor cursorSafeQuery$default = SafeQueryKt.safeQuery$default(MediaStoreContentObserver.this.contentResolver, AlbumExtensionsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_id"}, "media_type == " + this.$mediaType.toMediaStoreValue(), null, null, 24, null);
            try {
                Cursor cursor = cursorSafeQuery$default;
                CoroutineScopeKt.ensureActive(coroutineScope);
                long j = 0;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        j += cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                    }
                }
                Long lBoxLong = Boxing.boxLong(j);
                CloseableKt.closeFinally(cursorSafeQuery$default, null);
                return lBoxLong;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorSafeQuery$default, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAssetsIdSum(MediaType mediaType, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(mediaType, null), continuation);
    }
}
