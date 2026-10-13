package expo.modules.ui;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarResult;
import com.facebook.react.modules.dialog.DialogModule;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SnackbarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "options", "Lexpo/modules/ui/SnackbarShowOptions;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.SnackbarViewKt$SnackbarHostContent$1$1", f = "SnackbarView.kt", i = {0, 0}, l = {93}, m = "invokeSuspend", n = {"options", "duration"}, s = {"L$0", "L$1"})
final class SnackbarViewKt$SnackbarHostContent$1$1 extends SuspendLambda implements Function2<SnackbarShowOptions, Continuation<? super Object>, Object> {
    final /* synthetic */ SnackbarHostState $hostState;
    final /* synthetic */ CoroutineScope $scope;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: compiled from: SnackbarView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarResult.values().length];
            try {
                iArr[SnackbarResult.ActionPerformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SnackbarResult.Dismissed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarViewKt$SnackbarHostContent$1$1(CoroutineScope coroutineScope, SnackbarHostState snackbarHostState, Continuation<? super SnackbarViewKt$SnackbarHostContent$1$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$hostState = snackbarHostState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnackbarViewKt$SnackbarHostContent$1$1 snackbarViewKt$SnackbarHostContent$1$1 = new SnackbarViewKt$SnackbarHostContent$1$1(this.$scope, this.$hostState, continuation);
        snackbarViewKt$SnackbarHostContent$1$1.L$0 = obj;
        return snackbarViewKt$SnackbarHostContent$1$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SnackbarShowOptions snackbarShowOptions, Continuation<Object> continuation) {
        return ((SnackbarViewKt$SnackbarHostContent$1$1) create(snackbarShowOptions, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SnackbarShowOptions snackbarShowOptions, Continuation<? super Object> continuation) {
        return invoke2(snackbarShowOptions, (Continuation<Object>) continuation);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0061  */
    /* JADX WARN: Code duplicated, block: B:33:0x0067  */
    /* JADX WARN: Code duplicated, block: B:34:0x006a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SnackbarResult snackbarResult;
        SnackbarDuration snackbarDuration;
        SnackbarShowOptions snackbarShowOptions = (SnackbarShowOptions) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String duration = snackbarShowOptions.getDuration();
                if (duration != null) {
                    int iHashCode = duration.hashCode();
                    if (iHashCode != 3327612) {
                        if (iHashCode != 109413500) {
                            if (iHashCode == 240880789 && duration.equals("indefinite")) {
                                snackbarDuration = SnackbarDuration.Indefinite;
                            } else if (snackbarShowOptions.getActionLabel() == null) {
                                snackbarDuration = SnackbarDuration.Short;
                            } else {
                                snackbarDuration = SnackbarDuration.Indefinite;
                            }
                        } else if (duration.equals("short")) {
                            snackbarDuration = SnackbarDuration.Short;
                        } else if (snackbarShowOptions.getActionLabel() == null) {
                            snackbarDuration = SnackbarDuration.Short;
                        } else {
                            snackbarDuration = SnackbarDuration.Indefinite;
                        }
                    } else if (duration.equals("long")) {
                        snackbarDuration = SnackbarDuration.Long;
                    } else if (snackbarShowOptions.getActionLabel() == null) {
                        snackbarDuration = SnackbarDuration.Short;
                    } else {
                        snackbarDuration = SnackbarDuration.Indefinite;
                    }
                } else if (snackbarShowOptions.getActionLabel() == null) {
                    snackbarDuration = SnackbarDuration.Short;
                } else {
                    snackbarDuration = SnackbarDuration.Indefinite;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(snackbarShowOptions);
                this.L$1 = SpillingKt.nullOutSpilledVariable(snackbarDuration);
                this.label = 1;
                obj = BuildersKt.withContext(this.$scope.getCoroutineContext(), new SnackbarViewKt$SnackbarHostContent$1$1$result$1(this.$hostState, snackbarShowOptions, snackbarDuration, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            snackbarResult = (SnackbarResult) obj;
        } catch (CancellationException unused) {
            snackbarResult = SnackbarResult.Dismissed;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[snackbarResult.ordinal()];
        if (i2 == 1) {
            return "actionPerformed";
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return DialogModule.ACTION_DISMISSED;
    }
}
