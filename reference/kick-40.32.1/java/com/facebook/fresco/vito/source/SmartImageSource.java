package com.facebook.fresco.vito.source;

import android.net.Uri;
import com.facebook.drawee.drawable.SizingHint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmartImageSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006 "}, d2 = {"Lcom/facebook/fresco/vito/source/SmartImageSource;", "Lcom/facebook/fresco/vito/source/SingleImageSource;", "imageUri", "Landroid/net/Uri;", "sizingHint", "Lcom/facebook/drawee/drawable/SizingHint;", "extras", "", "", "", "smartFetchOptIn", "Lcom/facebook/fresco/vito/source/SmartFetchOptIn;", "<init>", "(Landroid/net/Uri;Lcom/facebook/drawee/drawable/SizingHint;Ljava/util/Map;Lcom/facebook/fresco/vito/source/SmartFetchOptIn;)V", "getImageUri", "()Landroid/net/Uri;", "getSizingHint", "()Lcom/facebook/drawee/drawable/SizingHint;", "getExtras", "()Ljava/util/Map;", "getSmartFetchOptIn", "()Lcom/facebook/fresco/vito/source/SmartFetchOptIn;", "uri", "getUri", "getStringExtra", "key", "equals", "", "other", "hashCode", "", "getClassNameString", "source_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmartImageSource implements SingleImageSource {
    private final Map<String, Object> extras;
    private final Uri imageUri;
    private final SizingHint sizingHint;
    private final SmartFetchOptIn smartFetchOptIn;
    private final Uri uri;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartImageSource(Uri imageUri) {
        this(imageUri, null, null, null, 14, null);
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartImageSource(Uri imageUri, SizingHint sizingHint) {
        this(imageUri, sizingHint, null, null, 12, null);
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(sizingHint, "sizingHint");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartImageSource(Uri imageUri, SizingHint sizingHint, Map<String, ? extends Object> map) {
        this(imageUri, sizingHint, map, null, 8, null);
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(sizingHint, "sizingHint");
    }

    public SmartImageSource(Uri imageUri, SizingHint sizingHint, Map<String, ? extends Object> map, SmartFetchOptIn smartFetchOptIn) {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(sizingHint, "sizingHint");
        this.imageUri = imageUri;
        this.sizingHint = sizingHint;
        this.extras = map;
        this.smartFetchOptIn = smartFetchOptIn;
        this.uri = getImageUri();
    }

    @Override // com.facebook.fresco.vito.source.UriImageSource
    public Uri getImageUri() {
        return this.imageUri;
    }

    public /* synthetic */ SmartImageSource(Uri uri, SizingHint sizingHint, Map map, SmartFetchOptIn smartFetchOptIn, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? SizingHint.DEFAULT : sizingHint, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : smartFetchOptIn);
    }

    public final SizingHint getSizingHint() {
        return this.sizingHint;
    }

    @Override // com.facebook.fresco.vito.source.UriImageSource
    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public final SmartFetchOptIn getSmartFetchOptIn() {
        return this.smartFetchOptIn;
    }

    @Override // com.facebook.fresco.vito.source.SingleImageSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.facebook.fresco.vito.source.SingleImageSource
    public String getStringExtra(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, Object> extras = getExtras();
        Object obj = extras != null ? extras.get(key) : null;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null) || !(other instanceof SmartImageSource)) {
            return false;
        }
        SmartImageSource smartImageSource = (SmartImageSource) other;
        return Intrinsics.areEqual(getImageUri(), smartImageSource.getImageUri()) && this.sizingHint == smartImageSource.sizingHint && Intrinsics.areEqual(getExtras(), smartImageSource.getExtras()) && this.smartFetchOptIn == smartImageSource.smartFetchOptIn;
    }

    public int hashCode() {
        int iHashCode = ((getImageUri().hashCode() * 31) + this.sizingHint.hashCode()) * 31;
        Map<String, Object> extras = getExtras();
        int iHashCode2 = (iHashCode + (extras != null ? extras.hashCode() : 0)) * 31;
        SmartFetchOptIn smartFetchOptIn = this.smartFetchOptIn;
        return iHashCode2 + (smartFetchOptIn != null ? smartFetchOptIn.hashCode() : 0);
    }

    @Override // com.facebook.fresco.vito.source.SingleImageSource, com.facebook.fresco.vito.source.UriImageSource, com.facebook.fresco.vito.source.ImageSource
    public String getClassNameString() {
        return "SmartImageSource";
    }
}
