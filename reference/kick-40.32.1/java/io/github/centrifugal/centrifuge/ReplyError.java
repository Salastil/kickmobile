package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class ReplyError extends Throwable {
    private int code;
    private String message;
    private boolean temporary;

    public ReplyError(int i, String str, boolean z) {
        this.code = i;
        this.message = str;
        this.temporary = z;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public boolean isTemporary() {
        return this.temporary;
    }

    public void setTemporary(boolean z) {
        this.temporary = z;
    }
}
