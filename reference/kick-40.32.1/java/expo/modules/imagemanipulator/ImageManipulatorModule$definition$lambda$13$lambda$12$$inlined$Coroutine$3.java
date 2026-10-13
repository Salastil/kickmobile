package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.react.uimanager.ViewProps;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$5"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3", f = "ImageManipulatorModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {278}, m = "invokeSuspend", n = {"<destruct>", "p0", "p1", "$completion", "options", "image", "options", "path", "resultBitmap", "base64String", "$i$a$-Coroutine-ImageManipulatorModule$definition$1$3$3", "compression"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1"})
public final class ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    int I$1;
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
    final /* synthetic */ ImageManipulatorModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3(Continuation continuation, ImageManipulatorModule imageManipulatorModule) {
        super(3, continuation);
        this.this$0 = imageManipulatorModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3 imageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3 = new ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3(continuation, this.this$0);
        imageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3.L$0 = objArr;
        return imageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws ImageWriteFailedException, IOException {
        Ref.ObjectRef objectRef;
        String str;
        Bitmap bitmap;
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3 imageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3 = this;
            ManipulateOptions manipulateOptions = (ManipulateOptions) obj3;
            ImageRef imageRef = (ImageRef) obj2;
            ManipulateOptions manipulateOptions2 = manipulateOptions == null ? new ManipulateOptions() : manipulateOptions;
            String strGenerateRandomOutputPath = FileUtils.INSTANCE.generateRandomOutputPath(this.this$0.getAppContext().getCacheDirectory(), manipulateOptions2.getFormat());
            int compress = (int) (manipulateOptions2.getCompress() * 100.0d);
            Bitmap ref = imageRef.getRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.this$0.getAppContext().getBackgroundCoroutineScope(), null, null, new ImageManipulatorModule$definition$1$3$3$1(strGenerateRandomOutputPath, manipulateOptions2, ref, compress, objectRef2, null), 3, null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
            this.L$3 = SpillingKt.nullOutSpilledVariable(imageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3);
            this.L$4 = SpillingKt.nullOutSpilledVariable(manipulateOptions);
            this.L$5 = SpillingKt.nullOutSpilledVariable(imageRef);
            this.L$6 = SpillingKt.nullOutSpilledVariable(manipulateOptions2);
            this.L$7 = strGenerateRandomOutputPath;
            this.L$8 = ref;
            this.L$9 = objectRef2;
            this.I$0 = 0;
            this.I$1 = compress;
            this.label = 1;
            if (deferredAsync$default.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            str = strGenerateRandomOutputPath;
            bitmap = ref;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$9;
            bitmap = (Bitmap) this.L$8;
            str = (String) this.L$7;
            ResultKt.throwOnFailure(obj);
        }
        return MapsKt.mapOf(TuplesKt.to("uri", Uri.fromFile(new File(str)).toString()), TuplesKt.to(ViewProps.WIDTH, Boxing.boxInt(bitmap.getWidth())), TuplesKt.to(ViewProps.HEIGHT, Boxing.boxInt(bitmap.getHeight())), TuplesKt.to("base64", objectRef.element));
    }
}
