package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VideoType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/model/VideoType;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "CONTENT", "AD", "Lio/datazoom/sdk/model/VideoType$AD;", "Lio/datazoom/sdk/model/VideoType$CONTENT;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class VideoType {
    private final String name;

    public /* synthetic */ VideoType(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: compiled from: VideoType.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/model/VideoType$CONTENT;", "Lio/datazoom/sdk/model/VideoType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class CONTENT extends VideoType {
        public static final CONTENT INSTANCE = new CONTENT();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CONTENT)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -257027010;
        }

        public String toString() {
            return "CONTENT";
        }

        private CONTENT() {
            super("content", null);
        }
    }

    private VideoType(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: compiled from: VideoType.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/model/VideoType$AD;", "Lio/datazoom/sdk/model/VideoType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AD extends VideoType {
        public static final AD INSTANCE = new AD();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AD)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -569435874;
        }

        public String toString() {
            return "AD";
        }

        private AD() {
            super("ad", null);
        }
    }
}
