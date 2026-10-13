package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p000authapi.zbbj;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.5.0 */
/* JADX INFO: loaded from: classes7.dex */
public class RevokeAccessRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<RevokeAccessRequest> CREATOR = new zbp();
    private final zbbj zba;
    private final Account zbb;
    private final String zbc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.5.0 */
    public static final class Builder {
        private zbbj zba;
        private Account zbb;
        private String zbc;

        private Builder() {
            throw null;
        }

        /* synthetic */ Builder(RevokeAccessRequest revokeAccessRequest, byte[] bArr) {
            this.zba = revokeAccessRequest.zbb();
            this.zbb = revokeAccessRequest.zbc();
            this.zbc = revokeAccessRequest.zbd();
        }

        /* synthetic */ Builder(byte[] bArr) {
        }

        public RevokeAccessRequest build() {
            return new RevokeAccessRequest(this.zba, this.zbb, this.zbc);
        }

        public Builder setAccount(Account account) {
            this.zbb = account;
            return this;
        }

        public Builder setScopes(List<Scope> list) {
            this.zba = zbbj.zbi(list);
            return this;
        }

        public final Builder zba(String str) {
            this.zbc = str;
            return this;
        }
    }

    RevokeAccessRequest(List list, Account account, String str) {
        this.zba = zbbj.zbi(list);
        this.zbb = account;
        this.zbc = str;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RevokeAccessRequest) {
            RevokeAccessRequest revokeAccessRequest = (RevokeAccessRequest) obj;
            zbbj zbbjVar = this.zba;
            int size = zbbjVar.size();
            zbbj zbbjVar2 = revokeAccessRequest.zba;
            if (size == zbbjVar2.size() && zbbjVar.containsAll(zbbjVar2) && Objects.equal(this.zbb, revokeAccessRequest.zbb) && Objects.equal(this.zbc, revokeAccessRequest.zbc)) {
                return true;
            }
        }
        return false;
    }

    public Account getAccount() {
        return this.zbb;
    }

    public List<Scope> getScopes() {
        return this.zba;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbc);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAccount(), i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final Builder zba() {
        return new Builder(this, null);
    }

    final /* synthetic */ zbbj zbb() {
        return this.zba;
    }

    final /* synthetic */ Account zbc() {
        return this.zbb;
    }

    final /* synthetic */ String zbd() {
        return this.zbc;
    }
}
