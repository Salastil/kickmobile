package expo.modules.filesystem;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import expo.modules.kotlin.providers.AppContextProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilePickerContract.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lexpo/modules/filesystem/FilePickerContract;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "Lexpo/modules/filesystem/FilePickerContractOptions;", "Lexpo/modules/filesystem/FilePickerContractResult;", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "<init>", "(Lexpo/modules/kotlin/providers/AppContextProvider;)V", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "createIntent", "Landroid/content/Intent;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilePickerContract implements AppContextActivityResultContract<FilePickerContractOptions, FilePickerContractResult> {
    private final AppContextProvider appContextProvider;

    /* JADX INFO: compiled from: FilePickerContract.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PickerType.values().length];
            try {
                iArr[PickerType.DIRECTORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PickerType.FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FilePickerContract(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    private final ContentResolver getContentResolver() {
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        if (reactContext == null) {
            throw new IllegalArgumentException("React Application Context is null".toString());
        }
        ContentResolver contentResolver = reactContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        return contentResolver;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public Intent createIntent(Context context, FilePickerContractOptions input) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.getPickerType() == PickerType.FILE) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            String str = (String) CollectionsKt.firstOrNull((List) input.getMimeTypes());
            if (str == null) {
                str = "*/*";
            }
            intent.setType(str);
            if (input.getMimeTypes().size() > 1) {
                intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) input.getMimeTypes().toArray(new String[0]));
            }
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", input.getMultipleFiles());
        } else {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            intent.putExtra("android.provider.extra.INITIAL_URI", input.getInitialUri());
        }
        return intent;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public FilePickerContractResult parseResult(FilePickerContractOptions input, int resultCode, Intent intent) {
        FileSystemPath fileSystemDirectory;
        FileSystemDirectory fileSystemDirectory2;
        Intrinsics.checkNotNullParameter(input, "input");
        if (resultCode == 0 || intent == null) {
            return FilePickerContractResult.Cancelled.INSTANCE;
        }
        int flags = intent.getFlags() & 3;
        if (intent.getClipData() == null) {
            Uri data = intent.getData();
            if (data != null) {
                getContentResolver().takePersistableUriPermission(data, flags);
            } else {
                data = null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[input.getPickerType().ordinal()];
            if (i == 1) {
                if (data == null) {
                    data = Uri.EMPTY;
                }
                Intrinsics.checkNotNull(data);
                fileSystemDirectory2 = new FileSystemDirectory(data);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (data == null) {
                    data = Uri.EMPTY;
                }
                Intrinsics.checkNotNull(data);
                fileSystemDirectory2 = new FileSystemFile(data);
            }
            return new FilePickerContractResult.Success(CollectionsKt.listOf(fileSystemDirectory2));
        }
        ArrayList arrayList = new ArrayList();
        ClipData clipData = intent.getClipData();
        Intrinsics.checkNotNull(clipData);
        int itemCount = clipData.getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            ClipData clipData2 = intent.getClipData();
            Intrinsics.checkNotNull(clipData2);
            Uri uri = clipData2.getItemAt(i2).getUri();
            if (uri != null) {
                getContentResolver().takePersistableUriPermission(uri, flags);
                int i3 = WhenMappings.$EnumSwitchMapping$0[input.getPickerType().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    fileSystemDirectory = new FileSystemFile(uri);
                } else {
                    fileSystemDirectory = new FileSystemDirectory(uri);
                }
                arrayList.add(fileSystemDirectory);
            }
        }
        return new FilePickerContractResult.Success(arrayList);
    }
}
