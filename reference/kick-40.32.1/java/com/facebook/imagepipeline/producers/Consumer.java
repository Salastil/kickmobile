package com.facebook.imagepipeline.producers;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: compiled from: Consumer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0010\u0011J\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/producers/Consumer;", ExifInterface.GPS_DIRECTION_TRUE, "", "onNewResult", "", "newResult", "status", "", "(Ljava/lang/Object;I)V", "onFailure", "t", "", "onCancellation", "onProgressUpdate", "progress", "", "Status", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Consumer<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DO_NOT_CACHE_ENCODED = 2;
    public static final int IS_LAST = 1;
    public static final int IS_PARTIAL_RESULT = 8;
    public static final int IS_PLACEHOLDER = 4;
    public static final int IS_RESIZING_DONE = 16;
    public static final int NO_FLAGS = 0;

    /* JADX INFO: compiled from: Consumer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/facebook/imagepipeline/producers/Consumer$Status;", "", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Status {
    }

    void onCancellation();

    void onFailure(Throwable t);

    void onNewResult(T newResult, int status);

    void onProgressUpdate(float progress);

    /* JADX INFO: compiled from: Consumer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/imagepipeline/producers/Consumer$Companion;", "", "<init>", "()V", "NO_FLAGS", "", "IS_LAST", "DO_NOT_CACHE_ENCODED", "IS_PLACEHOLDER", "IS_PARTIAL_RESULT", "IS_RESIZING_DONE", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DO_NOT_CACHE_ENCODED = 2;
        public static final int IS_LAST = 1;
        public static final int IS_PARTIAL_RESULT = 8;
        public static final int IS_PLACEHOLDER = 4;
        public static final int IS_RESIZING_DONE = 16;
        public static final int NO_FLAGS = 0;

        private Companion() {
        }
    }
}
