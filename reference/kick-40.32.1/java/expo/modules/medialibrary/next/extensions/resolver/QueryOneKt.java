package expo.modules.medialibrary.next.extensions.resolver;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.medialibrary.next.exceptions.PermissionException;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: QueryOne.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0082\u0001\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062,\u0010\u0007\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u00010\b¢\u0006\u0002\b\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"queryOne", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/ContentResolver;", "contentUri", "Landroid/net/Uri;", "column", "", "extractor", "Lkotlin/Function2;", "Landroid/database/Cursor;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Lkotlin/ExtensionFunctionType;", "selection", "selectionArgs", "", "sortOrder", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class QueryOneKt {
    public static /* synthetic */ Object queryOne$default(ContentResolver contentResolver, Uri uri, String str, Function2 function2, String str2, String[] strArr, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            strArr = null;
        }
        if ((i & 32) != 0) {
            str3 = null;
        }
        return queryOne(contentResolver, uri, str, function2, str2, strArr, str3, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: expo.modules.medialibrary.next.extensions.resolver.QueryOneKt$queryOne$2, reason: invalid class name */
    /* JADX INFO: compiled from: QueryOne.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.extensions.resolver.QueryOneKt$queryOne$2", f = "QueryOne.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ String $column;
        final /* synthetic */ Uri $contentUri;
        final /* synthetic */ Function2<Cursor, Integer, T> $extractor;
        final /* synthetic */ String $selection;
        final /* synthetic */ String[] $selectionArgs;
        final /* synthetic */ String $sortOrder;
        final /* synthetic */ ContentResolver $this_queryOne;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, ContentResolver contentResolver, Uri uri, String str2, String[] strArr, String str3, Function2<? super Cursor, ? super Integer, ? extends T> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$column = str;
            this.$this_queryOne = contentResolver;
            this.$contentUri = uri;
            this.$selection = str2;
            this.$selectionArgs = strArr;
            this.$sortOrder = str3;
            this.$extractor = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$column, this.$this_queryOne, this.$contentUri, this.$selection, this.$selectionArgs, this.$sortOrder, this.$extractor, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws PermissionException {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Cursor cursorSafeQuery = SafeQueryKt.safeQuery(this.$this_queryOne, this.$contentUri, new String[]{this.$column}, this.$selection, this.$selectionArgs, this.$sortOrder);
            if (cursorSafeQuery == null) {
                return null;
            }
            Cursor cursor = cursorSafeQuery;
            String str = this.$column;
            Function2<Cursor, Integer, T> function2 = this.$extractor;
            try {
                Cursor cursor2 = cursor;
                CoroutineScopeKt.ensureActive(coroutineScope);
                T tInvoke = cursor2.moveToFirst() ? function2.invoke(cursor2, Boxing.boxInt(cursor2.getColumnIndexOrThrow(str))) : null;
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

    public static final <T> Object queryOne(ContentResolver contentResolver, Uri uri, String str, Function2<? super Cursor, ? super Integer, ? extends T> function2, String str2, String[] strArr, String str3, Continuation<? super T> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, contentResolver, uri, str2, strArr, str3, function2, null), continuation);
    }
}
