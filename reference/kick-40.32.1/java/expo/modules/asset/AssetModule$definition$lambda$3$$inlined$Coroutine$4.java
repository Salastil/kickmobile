package expo.modules.asset;

import android.net.Uri;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$7"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.asset.AssetModule$definition$lambda$3$$inlined$Coroutine$4", f = "AssetModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {281, 288}, m = "invokeSuspend", n = {"<destruct>", "p0", "p1", "p2", "$completion", "type", "md5Hash", "uri", "cacheFileId", "cacheDirectory", "localUrl", "$i$a$-Coroutine-AssetModule$definition$1$1", "<destruct>", "p0", "p1", "p2", "$completion", "type", "md5Hash", "uri", "cacheFileId", "cacheDirectory", "localUrl", "$i$a$-Coroutine-AssetModule$definition$1$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"})
public final class AssetModule$definition$lambda$3$$inlined$Coroutine$4 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ AssetModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetModule$definition$lambda$3$$inlined$Coroutine$4(Continuation continuation, AssetModule assetModule) {
        super(3, continuation);
        this.this$0 = assetModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        AssetModule$definition$lambda$3$$inlined$Coroutine$4 assetModule$definition$lambda$3$$inlined$Coroutine$4 = new AssetModule$definition$lambda$3$$inlined$Coroutine$4(continuation, this.this$0);
        assetModule$definition$lambda$3$$inlined$Coroutine$4.L$0 = objArr;
        return assetModule$definition$lambda$3$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws UnableToDownloadAssetException, Exceptions.AppContextLost {
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
        AssetModule$definition$lambda$3$$inlined$Coroutine$4 assetModule$definition$lambda$3$$inlined$Coroutine$4 = this;
        String str = (String) obj4;
        String str2 = (String) obj3;
        URI uri = (URI) obj2;
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (!StringsKt.startsWith$default(string, ResourceAssetKt.ANDROID_EMBEDDED_URL_BASE_RESOURCE, false, 2, (Object) null)) {
                return uri;
            }
        }
        String mD5HashOfFilePath = str2 == null ? this.this$0.getMD5HashOfFilePath(uri) : str2;
        File cacheDirectory = this.this$0.getAppContext().getCacheDirectory();
        File file = new File(cacheDirectory + "/ExponentAsset-" + mD5HashOfFilePath + "." + str);
        if (!file.exists()) {
            AssetModule assetModule = this.this$0;
            AppContext appContext = assetModule.getAppContext();
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
            this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
            this.L$4 = SpillingKt.nullOutSpilledVariable(assetModule$definition$lambda$3$$inlined$Coroutine$4);
            this.L$5 = SpillingKt.nullOutSpilledVariable(str);
            this.L$6 = SpillingKt.nullOutSpilledVariable(str2);
            this.L$7 = SpillingKt.nullOutSpilledVariable(uri);
            this.L$8 = SpillingKt.nullOutSpilledVariable(mD5HashOfFilePath);
            this.L$9 = SpillingKt.nullOutSpilledVariable(cacheDirectory);
            this.L$10 = SpillingKt.nullOutSpilledVariable(file);
            this.I$0 = 0;
            this.label = 1;
            Object objDownloadAsset = assetModule.downloadAsset(appContext, uri, file, this);
            if (objDownloadAsset != coroutine_suspended) {
                return objDownloadAsset;
            }
        } else {
            if (str2 == null || Intrinsics.areEqual(str2, FileUtilsKt.getMD5HashOfFileContent(file))) {
                return Uri.fromFile(file);
            }
            AssetModule assetModule2 = this.this$0;
            AppContext appContext2 = assetModule2.getAppContext();
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
            this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
            this.L$4 = SpillingKt.nullOutSpilledVariable(assetModule$definition$lambda$3$$inlined$Coroutine$4);
            this.L$5 = SpillingKt.nullOutSpilledVariable(str);
            this.L$6 = SpillingKt.nullOutSpilledVariable(str2);
            this.L$7 = SpillingKt.nullOutSpilledVariable(uri);
            this.L$8 = SpillingKt.nullOutSpilledVariable(mD5HashOfFilePath);
            this.L$9 = SpillingKt.nullOutSpilledVariable(cacheDirectory);
            this.L$10 = SpillingKt.nullOutSpilledVariable(file);
            this.I$0 = 0;
            this.label = 2;
            Object objDownloadAsset2 = assetModule2.downloadAsset(appContext2, uri, file, this);
            if (objDownloadAsset2 != coroutine_suspended) {
                return objDownloadAsset2;
            }
        }
        return coroutine_suspended;
    }
}
