package expo.modules.medialibrary.next;

import android.net.Uri;
import expo.modules.kotlin.types.Either;
import expo.modules.medialibrary.next.objects.album.factories.AlbumFactory;
import expo.modules.medialibrary.next.objects.asset.Asset;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$7"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22", f = "MediaLibraryNextModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {275, 279}, m = "invokeSuspend", n = {"<destruct>", "p0", "p1", "p2", "$completion", "moveAssets", "assetRefs", "name", "assetList", "assetListKClass", "$i$a$-Coroutine-MediaLibraryNextModule$definition$1$4$12", "<destruct>", "p0", "p1", "p2", "$completion", "moveAssets", "assetRefs", "name", "assetPaths", "assetListKClass", "$i$a$-Coroutine-MediaLibraryNextModule$definition$1$4$12"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"})
public final class MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ MediaLibraryNextModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22(Continuation continuation, MediaLibraryNextModule mediaLibraryNextModule) {
        super(3, continuation);
        this.this$0 = mediaLibraryNextModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22 mediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22 = new MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22(continuation, this.this$0);
        mediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22.L$0 = objArr;
        return mediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        Object obj2 = objArr[0];
        Object obj3 = objArr[1];
        Object obj4 = objArr[2];
        MediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22 mediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22 = this;
        Boolean bool = (Boolean) obj4;
        Either either = (Either) obj3;
        String str = (String) obj2;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        if (either.isFirstType(orCreateKotlinClass)) {
            List<Asset> list = (List) either.getFirstType(orCreateKotlinClass);
            AlbumFactory albumFactory = this.this$0.getAlbumFactory();
            Boolean boolBoxBoolean = Boxing.boxBoolean(bool != null ? bool.booleanValue() : true);
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
            this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
            this.L$4 = SpillingKt.nullOutSpilledVariable(mediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22);
            this.L$5 = SpillingKt.nullOutSpilledVariable(bool);
            this.L$6 = SpillingKt.nullOutSpilledVariable(either);
            this.L$7 = SpillingKt.nullOutSpilledVariable(str);
            this.L$8 = SpillingKt.nullOutSpilledVariable(list);
            this.L$9 = SpillingKt.nullOutSpilledVariable(orCreateKotlinClass);
            this.I$0 = 0;
            this.label = 1;
            Object objCreateFromAssets = albumFactory.createFromAssets(str, list, boolBoxBoolean, this);
            if (objCreateFromAssets != coroutine_suspended) {
                return objCreateFromAssets;
            }
        } else {
            List<? extends Uri> list2 = (List) either.getSecondType(Reflection.getOrCreateKotlinClass(List.class));
            AlbumFactory albumFactory2 = this.this$0.getAlbumFactory();
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
            this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
            this.L$4 = SpillingKt.nullOutSpilledVariable(mediaLibraryNextModule$definition$lambda$66$lambda$47$$inlined$Coroutine$22);
            this.L$5 = SpillingKt.nullOutSpilledVariable(bool);
            this.L$6 = SpillingKt.nullOutSpilledVariable(either);
            this.L$7 = SpillingKt.nullOutSpilledVariable(str);
            this.L$8 = SpillingKt.nullOutSpilledVariable(list2);
            this.L$9 = SpillingKt.nullOutSpilledVariable(orCreateKotlinClass);
            this.I$0 = 0;
            this.label = 2;
            Object objCreateFromFilePaths = albumFactory2.createFromFilePaths(str, list2, this);
            if (objCreateFromFilePaths != coroutine_suspended) {
                return objCreateFromFilePaths;
            }
        }
        return coroutine_suspended;
    }
}
