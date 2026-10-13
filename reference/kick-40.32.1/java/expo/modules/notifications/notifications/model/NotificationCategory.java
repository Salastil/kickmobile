package expo.modules.notifications.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class NotificationCategory implements Parcelable, Serializable {
    public static final Parcelable.Creator<NotificationCategory> CREATOR = new Parcelable.Creator<NotificationCategory>() { // from class: expo.modules.notifications.notifications.model.NotificationCategory.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationCategory createFromParcel(Parcel parcel) {
            return new NotificationCategory(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationCategory[] newArray(int i) {
            return new NotificationCategory[i];
        }
    };
    private static final long serialVersionUID = -7231554903600752807L;
    private final List<NotificationAction> mActions;
    private final String mIdentifier;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NotificationCategory(String str, List<NotificationAction> list) {
        this.mIdentifier = str;
        this.mActions = list;
    }

    private NotificationCategory(Parcel parcel) {
        this.mIdentifier = parcel.readString();
        this.mActions = parcel.readArrayList(NotificationAction.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mIdentifier);
        parcel.writeList(this.mActions);
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public List<NotificationAction> getActions() {
        List<NotificationAction> list = this.mActions;
        return list == null ? Collections.EMPTY_LIST : list;
    }
}
