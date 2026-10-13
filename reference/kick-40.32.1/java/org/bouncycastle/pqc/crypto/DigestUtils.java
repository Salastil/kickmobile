package org.bouncycastle.pqc.crypto;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes10.dex */
public class DigestUtils {
    static final Map digestOids;

    static {
        HashMap map = new HashMap();
        digestOids = map;
        map.put("SHA-1", X509ObjectIdentifiers.id_SHA1);
        map.put(McElieceCCA2KeyGenParameterSpec.SHA224, NISTObjectIdentifiers.id_sha224);
        map.put("SHA-256", NISTObjectIdentifiers.id_sha256);
        map.put("SHA-384", NISTObjectIdentifiers.id_sha384);
        map.put("SHA-512", NISTObjectIdentifiers.id_sha512);
        map.put("SHA-512/224", NISTObjectIdentifiers.id_sha512_224);
        map.put(SPHINCSKeyParameters.SHA512_256, NISTObjectIdentifiers.id_sha512_256);
        map.put("SHA3-224", NISTObjectIdentifiers.id_sha3_224);
        map.put("SHA3-256", NISTObjectIdentifiers.id_sha3_256);
        map.put("SHA3-384", NISTObjectIdentifiers.id_sha3_384);
        map.put("SHA3-512", NISTObjectIdentifiers.id_sha3_512);
        map.put("SHAKE128", NISTObjectIdentifiers.id_shake128);
        map.put("SHAKE256", NISTObjectIdentifiers.id_shake256);
    }

    public static ASN1ObjectIdentifier getDigestOid(String str) {
        Map map = digestOids;
        if (map.containsKey(str)) {
            return (ASN1ObjectIdentifier) map.get(str);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }
}
