package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper;
import androidx.compose.ui.text.android.Paint29$$ExternalSyntheticApiModelOutline0;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class ContentCaptureSessionCompat implements ContentCaptureSessionWrapper {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    public ContentCaptureSession toContentCaptureSession() {
        return Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj);
    }

    private ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper
    public AutofillId newAutofillId(long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.newAutofillId(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), ((AutofillIdCompat) Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView))).toAutofillId(), j);
        }
        return null;
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper
    public ViewStructureCompat newVirtualViewStructure(AutofillId autofillId, long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), autofillId, j));
        }
        return null;
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper
    public void notifyViewAppeared(ViewStructure viewStructure) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewAppeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), viewStructure);
        }
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper
    public void notifyViewDisappeared(AutofillId autofillId) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewDisappeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), autofillId);
        }
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper
    public void flush() {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewsDisappeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), ((AutofillIdCompat) Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView))).toAutofillId(), new long[]{Long.MIN_VALUE});
        }
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper
    public void notifyViewsAppeared(List<ViewStructure> list) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.notifyViewsAppeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), list);
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        ViewStructure viewStructureNewViewStructure = Api29Impl.newViewStructure(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), this.mView);
        Api23Impl.getExtras(viewStructureNewViewStructure).putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), viewStructureNewViewStructure);
        int i = 0;
        while (true) {
            int size = list.size();
            Object obj = this.mWrappedObj;
            if (i < size) {
                Api29Impl.notifyViewAppeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(obj), list.get(i));
                i++;
            } else {
                ViewStructure viewStructureNewViewStructure2 = Api29Impl.newViewStructure(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(obj), this.mView);
                Api23Impl.getExtras(viewStructureNewViewStructure2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
                Api29Impl.notifyViewAppeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), viewStructureNewViewStructure2);
                return;
            }
        }
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper
    public void notifyViewsDisappeared(long[] jArr) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api29Impl.notifyViewsDisappeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), ((AutofillIdCompat) Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView))).toAutofillId(), jArr);
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            ViewStructure viewStructureNewViewStructure = Api29Impl.newViewStructure(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(viewStructureNewViewStructure).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            Api29Impl.notifyViewAppeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), viewStructureNewViewStructure);
            Api29Impl.notifyViewsDisappeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), ((AutofillIdCompat) Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView))).toAutofillId(), jArr);
            ViewStructure viewStructureNewViewStructure2 = Api29Impl.newViewStructure(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(viewStructureNewViewStructure2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            Api29Impl.notifyViewAppeared(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), viewStructureNewViewStructure2);
        }
    }

    @Override // androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper
    public void notifyViewTextChanged(AutofillId autofillId, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewTextChanged(Paint29$$ExternalSyntheticApiModelOutline0.m9649m(this.mWrappedObj), autofillId, charSequence);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static void notifyViewsAppeared(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static void notifyViewsDisappeared(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }

        static void notifyViewDisappeared(ContentCaptureSession contentCaptureSession, AutofillId autofillId) {
            contentCaptureSession.notifyViewDisappeared(autofillId);
        }

        static void notifyViewAppeared(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        static ViewStructure newViewStructure(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        static ViewStructure newVirtualViewStructure(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j);
        }

        static AutofillId newAutofillId(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newAutofillId(autofillId, j);
        }

        public static void notifyViewTextChanged(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }
}
