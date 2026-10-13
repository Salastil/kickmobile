package expo.modules.imagepicker;

import android.net.Uri;
import expo.modules.imagepicker.contracts.CameraContractOptions;
import java.io.File;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2", f = "ImagePickerModule.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {272, 280}, m = "invokeSuspend", n = {"<destruct>", "p0", "$completion", "options", "$i$a$-Coroutine-ImagePickerModule$definition$1$5", "<destruct>", "p0", "$completion", "options", "tempFile", "uri", "contractOptions", "$i$a$-Coroutine-ImagePickerModule$definition$1$5"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
public final class ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2(Continuation continuation, ImagePickerModule imagePickerModule) {
        super(3, continuation);
        this.this$0 = imagePickerModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2 imagePickerModule$definition$lambda$7$$inlined$Coroutine$2 = new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2(continuation, this.this$0);
        imagePickerModule$definition$lambda$7$$inlined$Coroutine$2.L$0 = objArr;
        return imagePickerModule$definition$lambda$7$$inlined$Coroutine$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i;
        Object obj2;
        ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2 imagePickerModule$definition$lambda$7$$inlined$Coroutine$2;
        ImagePickerOptions imagePickerOptions;
        File fileCreateOutputFile;
        File file;
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                i = 0;
                obj2 = objArr[0];
                imagePickerModule$definition$lambda$7$$inlined$Coroutine$2 = this;
                ImagePickerOptions imagePickerOptions2 = (ImagePickerOptions) obj2;
                this.this$0.ensureTargetActivityIsAvailable(imagePickerOptions2);
                ImagePickerModule imagePickerModule = this.this$0;
                this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(imagePickerModule$definition$lambda$7$$inlined$Coroutine$2);
                this.L$3 = imagePickerOptions2;
                this.I$0 = 0;
                this.label = 1;
                if (imagePickerModule.ensureCameraPermissionsAreGranted(this) != coroutine_suspended) {
                    imagePickerOptions = imagePickerOptions2;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                file = (File) this.L$4;
                try {
                    ResultKt.throwOnFailure(obj);
                    file.delete();
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    file.delete();
                    throw th;
                }
            }
            i = this.I$0;
            imagePickerOptions = (ImagePickerOptions) this.L$3;
            imagePickerModule$definition$lambda$7$$inlined$Coroutine$2 = (Continuation) this.L$2;
            obj2 = this.L$1;
            ResultKt.throwOnFailure(obj);
            Uri contentUri = ImagePickerUtilsKt.toContentUri(fileCreateOutputFile, this.this$0.getContext());
            String string = contentUri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            CameraContractOptions cameraContractOptions = imagePickerOptions.toCameraContractOptions(string);
            ImagePickerModule imagePickerModule2 = this.this$0;
            ImagePickerModule$definition$1$5$1 imagePickerModule$definition$1$5$1 = new ImagePickerModule$definition$1$5$1(this.this$0, cameraContractOptions, null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(imagePickerModule$definition$lambda$7$$inlined$Coroutine$2);
            this.L$3 = SpillingKt.nullOutSpilledVariable(imagePickerOptions);
            this.L$4 = fileCreateOutputFile;
            this.L$5 = SpillingKt.nullOutSpilledVariable(contentUri);
            this.L$6 = SpillingKt.nullOutSpilledVariable(cameraContractOptions);
            this.I$0 = i;
            this.label = 2;
            Object objLaunchContract = imagePickerModule2.launchContract(imagePickerModule$definition$1$5$1, imagePickerOptions, this);
            if (objLaunchContract != coroutine_suspended) {
                file = fileCreateOutputFile;
                obj = objLaunchContract;
                file.delete();
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            file = fileCreateOutputFile;
            file.delete();
            throw th;
        }
        fileCreateOutputFile = ImagePickerUtilsKt.createOutputFile(this.this$0.getCacheDirectory(), imagePickerOptions.getNativeMediaTypes().toFileExtension());
    }
}
