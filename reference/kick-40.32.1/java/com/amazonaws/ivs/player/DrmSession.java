package com.amazonaws.ivs.player;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaFormat;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import androidx.media3.common.C;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
class DrmSession implements Releasable, MediaDrm.OnEventListener {
    private static final Map<UUID, DrmSession> sessions = new ConcurrentHashMap();
    private final MediaDrm drm;
    private final Listener listener;
    private byte[] session;
    private boolean sessionSharing;
    private final UUID systemUUID;
    private final String SECURITY_LEVEL = "securityLevel";
    private final String SESSION_SHARING = "sessionSharing";
    private final Map<DrmPssh, MediaCrypto> mediaCrypto = new HashMap();

    public interface Listener {
        void onError(String str);

        void onKeyExpired();

        void onKeyRequested();

        void onProvisionRequested();
    }

    static class OpaqueRequest {
        byte[] data;
        String url;

        OpaqueRequest() {
        }
    }

    public static DrmSession create(UUID uuid, Listener listener) {
        if (MediaDrm.isCryptoSchemeSupported(uuid)) {
            return new DrmSession(uuid, listener);
        }
        return null;
    }

    public static DrmSession create(ByteBuffer byteBuffer, long j) {
        return create(DrmPssh.getUUID(byteBuffer), new DrmListener(j));
    }

    public static DrmSession get(MediaFormat mediaFormat) {
        int i = 0;
        while (true) {
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("drm-" + i);
            if (byteBuffer == null) {
                return null;
            }
            UUID systemId = new DrmPssh(byteBuffer).getSystemId();
            if (systemId != null) {
                Map<UUID, DrmSession> map = sessions;
                if (map.containsKey(systemId)) {
                    return map.get(systemId);
                }
            }
            i++;
        }
    }

    private DrmSession(UUID uuid, Listener listener) {
        this.systemUUID = uuid;
        this.listener = listener;
        try {
            MediaDrm mediaDrm = new MediaDrm(uuid);
            this.drm = mediaDrm;
            mediaDrm.setOnEventListener(this);
            if (uuid.equals(ProtectionSystem.WIDEVINE.getUUID())) {
                if (this.sessionSharing) {
                    try {
                        mediaDrm.setPropertyString("sessionSharing", "enable");
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    if ("L1".equals(this.drm.getPropertyString("securityLevel"))) {
                        setWidevineSecurityLevel("L3");
                    }
                } catch (Exception e2) {
                    Logging.w("Failed to set security level", e2);
                }
            }
            sessions.put(uuid, this);
        } catch (UnsupportedSchemeException e3) {
            e3.printStackTrace();
            throw new RuntimeException(e3);
        }
    }

    private void createSession(boolean z) {
        byte[] bArr = this.session;
        if (bArr != null) {
            this.drm.closeSession(bArr);
            this.session = null;
        }
        try {
            this.session = this.drm.openSession();
        } catch (NotProvisionedException e) {
            e.printStackTrace();
            Listener listener = this.listener;
            if (!z) {
                listener.onProvisionRequested();
            } else {
                listener.onError(e.getMessage());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.listener.onError(e2.getMessage());
        }
    }

    public void initialize() {
        createSession(false);
    }

    @Override // com.amazonaws.ivs.player.Releasable
    public void release() {
        MediaDrm mediaDrm = this.drm;
        if (mediaDrm != null) {
            try {
                byte[] bArr = this.session;
                if (bArr != null) {
                    mediaDrm.closeSession(bArr);
                }
                synchronized (this.mediaCrypto) {
                    this.mediaCrypto.clear();
                }
                this.drm.release();
                sessions.remove(this.systemUUID);
            } catch (Throwable th) {
                this.drm.release();
                sessions.remove(this.systemUUID);
                throw th;
            }
        }
    }

    MediaCrypto getMediaCrypto(MediaFormat mediaFormat) {
        int i = 0;
        DrmPssh drmPssh = null;
        while (true) {
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("drm-" + i);
            if (byteBuffer == null) {
                break;
            }
            drmPssh = new DrmPssh(byteBuffer);
            if (this.systemUUID.equals(drmPssh.getSystemId())) {
                break;
            }
            i++;
        }
        if (drmPssh != null) {
            synchronized (this.mediaCrypto) {
                if (this.mediaCrypto.containsKey(drmPssh)) {
                    return this.mediaCrypto.get(drmPssh);
                }
                try {
                    MediaCrypto mediaCrypto = new MediaCrypto(this.systemUUID, this.session);
                    this.mediaCrypto.put(drmPssh, mediaCrypto);
                    return mediaCrypto;
                } catch (MediaCryptoException e) {
                    e.printStackTrace();
                    this.listener.onError(e.getMessage());
                }
            }
        }
        return null;
    }

    public byte[] getSessionId() {
        return this.session;
    }

    @Override // android.media.MediaDrm.OnEventListener
    public void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        Logging.w("MediaDrm event " + i + " extra " + i2);
        if (i == 2) {
            this.listener.onKeyRequested();
        } else {
            if (i != 3) {
                return;
            }
            this.listener.onKeyExpired();
        }
    }

    public OpaqueRequest generateKeyRequest(byte[] bArr) {
        try {
            MediaDrm.KeyRequest keyRequest = this.drm.getKeyRequest(this.session, bArr, C.CENC_TYPE_cenc, 1, null);
            OpaqueRequest opaqueRequest = new OpaqueRequest();
            opaqueRequest.url = keyRequest.getDefaultUrl();
            opaqueRequest.data = keyRequest.getData();
            return opaqueRequest;
        } catch (NotProvisionedException e) {
            this.listener.onProvisionRequested();
            e.printStackTrace();
            return null;
        }
    }

    public OpaqueRequest generateProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.drm.getProvisionRequest();
        OpaqueRequest opaqueRequest = new OpaqueRequest();
        opaqueRequest.url = provisionRequest.getDefaultUrl();
        opaqueRequest.data = provisionRequest.getData();
        return opaqueRequest;
    }

    public void updateKeyResponse(byte[] bArr) {
        try {
            this.drm.provideKeyResponse(this.session, bArr);
        } catch (DeniedByServerException e) {
            e.printStackTrace();
            this.listener.onError(e.getMessage());
        } catch (NotProvisionedException e2) {
            e2.printStackTrace();
            this.listener.onProvisionRequested();
        }
    }

    public void updateProvisionResponse(byte[] bArr) {
        try {
            this.drm.provideProvisionResponse(bArr);
            if (this.session == null) {
                createSession(true);
            }
        } catch (DeniedByServerException e) {
            e.printStackTrace();
            this.listener.onError(e.getMessage());
        }
    }

    private void unprovision() {
        try {
            this.drm.provideProvisionResponse("unprovision".getBytes());
        } catch (Exception e) {
            Logging.w("Un-provision failed", e);
        }
    }

    private void setWidevineSecurityLevel(String str) {
        if (!this.systemUUID.equals(ProtectionSystem.WIDEVINE.getUUID()) || this.drm.getPropertyString("securityLevel").equals(str)) {
            return;
        }
        this.drm.setPropertyString("securityLevel", str);
    }
}
