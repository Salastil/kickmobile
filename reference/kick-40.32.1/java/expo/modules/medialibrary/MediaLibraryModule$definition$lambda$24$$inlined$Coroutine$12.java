package expo.modules.medialibrary;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$5"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12", f = "MediaLibraryModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {272, 273}, m = "invokeSuspend", n = {"<destruct>", "p0", "p1", "$completion", "albumId", "assetsId", "$i$a$-Coroutine-MediaLibraryModule$definition$1$9", "<destruct>", "p0", "p1", "$completion", "albumId", "assetsId", "$i$a$-Coroutine-MediaLibraryModule$definition$1$9"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
public final class MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12(Continuation continuation, MediaLibraryModule mediaLibraryModule) {
        super(3, continuation);
        this.this$0 = mediaLibraryModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12 mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12 = new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12(continuation, this.this$0);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12.L$0 = objArr;
        return mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00bf, code lost:
    
        if (expo.modules.medialibrary.albums.RemoveAssetsFromAlbumKt.removeAssetsFromAlbum(r10, r1, r2, r14) == r7) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws expo.modules.medialibrary.PermissionsException, expo.modules.kotlin.exception.Exceptions.ReactContextLost {
        /*
            r14 = this;
            java.lang.Object r0 = r14.L$0
            r6 = r0
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r14.label
            r8 = 2
            r1 = 1
            if (r0 == 0) goto L42
            if (r0 == r1) goto L2c
            if (r0 != r8) goto L24
            java.lang.Object r0 = r14.L$5
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.Object r0 = r14.L$4
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r14.L$3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto Lc2
        L24:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2c:
            int r0 = r14.I$0
            java.lang.Object r1 = r14.L$5
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.lang.Object r2 = r14.L$4
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r14.L$3
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r5 = r14.L$2
            java.lang.Object r9 = r14.L$1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L8d
        L42:
            kotlin.ResultKt.throwOnFailure(r15)
            r9 = 0
            r10 = r6[r9]
            r11 = r6[r1]
            r12 = r14
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r13 = r11
            java.lang.String r13 = (java.lang.String) r13
            r0 = r10
            java.lang.String[] r0 = (java.lang.String[]) r0
            expo.modules.medialibrary.MediaLibraryModule r2 = r14.this$0
            r4 = 0
            expo.modules.medialibrary.MediaLibraryModule.requireSystemPermissions$default(r2, r9, r1, r4)
            expo.modules.medialibrary.MediaLibraryModule r2 = r14.this$0
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r14.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r14.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r14.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r14.L$3 = r4
            r14.L$4 = r13
            r14.L$5 = r0
            r14.I$0 = r9
            r14.label = r1
            r1 = r0
            r0 = r2
            r2 = 0
            r4 = 2
            r5 = 0
            r3 = r14
            java.lang.Object r0 = expo.modules.medialibrary.MediaLibraryModule.requestMediaLibraryActionPermission$default(r0, r1, r2, r3, r4, r5)
            if (r0 != r7) goto L88
            goto Lc1
        L88:
            r0 = r9
            r9 = r10
            r5 = r11
            r4 = r12
            r2 = r13
        L8d:
            expo.modules.medialibrary.MediaLibraryModule r10 = r14.this$0
            android.content.Context r10 = expo.modules.medialibrary.MediaLibraryModule.access$getContext(r10)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r14.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r14.L$1 = r6
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r14.L$2 = r5
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r14.L$3 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r14.L$4 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r14.L$5 = r4
            r14.I$0 = r0
            r14.label = r8
            java.lang.Object r0 = expo.modules.medialibrary.albums.RemoveAssetsFromAlbumKt.removeAssetsFromAlbum(r10, r1, r2, r14)
            if (r0 != r7) goto Lc2
        Lc1:
            return r7
        Lc2:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
