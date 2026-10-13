package expo.modules.camera.documentscanner;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScannerContract.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/camera/documentscanner/DocumentScannerContract;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "Lexpo/modules/camera/documentscanner/DocumentScannerContractInput;", "Lexpo/modules/camera/documentscanner/DocumentScannerActivityResult;", "intentSenderProvider", "Lkotlin/Function0;", "Landroid/content/IntentSender;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "createIntent", "Landroid/content/Intent;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScannerContract implements AppContextActivityResultContract<DocumentScannerContractInput, DocumentScannerActivityResult> {
    private final Function0<IntentSender> intentSenderProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public DocumentScannerContract(Function0<? extends IntentSender> intentSenderProvider) {
        Intrinsics.checkNotNullParameter(intentSenderProvider, "intentSenderProvider");
        this.intentSenderProvider = intentSenderProvider;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public Intent createIntent(Context context, DocumentScannerContractInput input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        IntentSender intentSenderInvoke = this.intentSenderProvider.invoke();
        if (intentSenderInvoke == null) {
            throw new IllegalStateException("Document scanner IntentSender was not prepared before launch");
        }
        Intent intentPutExtra = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, new IntentSenderRequest.Builder(intentSenderInvoke).build());
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public DocumentScannerActivityResult parseResult(DocumentScannerContractInput input, int resultCode, Intent intent) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (resultCode != -1) {
            return new DocumentScannerActivityResult(true, null);
        }
        return new DocumentScannerActivityResult(false, GmsDocumentScanningResult.fromActivityResultIntent(intent));
    }
}
