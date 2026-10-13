package com.datadog.android.core.internal.persistence.file;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.security.Encryption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileReaderWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "Lcom/datadog/android/core/internal/persistence/file/FileWriter;", "", "Lcom/datadog/android/core/internal/persistence/file/FileReader;", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FileReaderWriter extends FileWriter<byte[]>, FileReader<byte[]> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: FileReaderWriter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter$Companion;", "", "()V", "create", "Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "encryption", "Lcom/datadog/android/security/Encryption;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final FileReaderWriter create(InternalLogger internalLogger, Encryption encryption) {
            Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
            PlainFileReaderWriter plainFileReaderWriter = new PlainFileReaderWriter(internalLogger);
            if (encryption == null) {
                return plainFileReaderWriter;
            }
            return new EncryptedFileReaderWriter(encryption, plainFileReaderWriter, internalLogger);
        }
    }
}
