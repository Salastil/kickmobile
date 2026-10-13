package kotlin.reflect.jvm.internal.impl.platform;

/* JADX INFO: compiled from: TargetPlatform.kt */
/* JADX INFO: loaded from: classes10.dex */
public abstract class SimplePlatform {
    private final String platformName;
    private final TargetPlatformVersion targetPlatformVersion;

    public String toString() {
        String targetName = getTargetName();
        int length = targetName.length();
        String str = this.platformName;
        if (length <= 0) {
            return str;
        }
        return str + " (" + targetName + ')';
    }

    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.targetPlatformVersion;
    }
}
