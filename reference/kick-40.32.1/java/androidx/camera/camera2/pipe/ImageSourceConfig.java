package androidx.camera.camera2.pipe;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Streams.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/camera/camera2/pipe/ImageSourceConfig;", "", "capacity", "", "usageFlags", "", "defaultDataSpace", "defaultHardwareBufferFormat", "<init>", "(ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCapacity", "()I", "getUsageFlags", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDefaultDataSpace", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDefaultHardwareBufferFormat", "enableConcurrentOutputs", "", "getEnableConcurrentOutputs", "()Z", "setEnableConcurrentOutputs", "(Z)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageSourceConfig {
    private final int capacity;
    private final Integer defaultDataSpace;
    private final Integer defaultHardwareBufferFormat;
    private boolean enableConcurrentOutputs;
    private final Long usageFlags;

    public ImageSourceConfig(int i, Long l, Integer num, Integer num2) {
        this.capacity = i;
        this.usageFlags = l;
        this.defaultDataSpace = num;
        this.defaultHardwareBufferFormat = num2;
    }

    public /* synthetic */ ImageSourceConfig(int i, Long l, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final Long getUsageFlags() {
        return this.usageFlags;
    }

    public final Integer getDefaultDataSpace() {
        return this.defaultDataSpace;
    }

    public final Integer getDefaultHardwareBufferFormat() {
        return this.defaultHardwareBufferFormat;
    }

    public final boolean getEnableConcurrentOutputs() {
        return this.enableConcurrentOutputs;
    }

    public final void setEnableConcurrentOutputs(boolean z) {
        this.enableConcurrentOutputs = z;
    }
}
