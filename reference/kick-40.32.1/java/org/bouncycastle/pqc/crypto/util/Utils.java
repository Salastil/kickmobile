package org.bouncycastle.pqc.crypto.util;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.internal.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.bike.BIKEParameters;
import org.bouncycastle.pqc.crypto.cmce.CMCEParameters;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.pqc.crypto.falcon.FalconParameters;
import org.bouncycastle.pqc.crypto.frodo.FrodoParameters;
import org.bouncycastle.pqc.crypto.hqc.HQCParameters;
import org.bouncycastle.pqc.crypto.mayo.MayoParameters;
import org.bouncycastle.pqc.crypto.mldsa.MLDSAParameters;
import org.bouncycastle.pqc.crypto.mlkem.MLKEMParameters;
import org.bouncycastle.pqc.crypto.ntru.NTRUParameters;
import org.bouncycastle.pqc.crypto.ntruprime.NTRULPRimeParameters;
import org.bouncycastle.pqc.crypto.ntruprime.SNTRUPrimeParameters;
import org.bouncycastle.pqc.crypto.picnic.PicnicParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowParameters;
import org.bouncycastle.pqc.crypto.saber.SABERParameters;
import org.bouncycastle.pqc.crypto.slhdsa.SLHDSAParameters;
import org.bouncycastle.pqc.crypto.snova.SnovaParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes11.dex */
class Utils {
    static final AlgorithmIdentifier AlgID_qTESLA_p_I = new AlgorithmIdentifier(PQCObjectIdentifiers.qTESLA_p_I);
    static final AlgorithmIdentifier AlgID_qTESLA_p_III = new AlgorithmIdentifier(PQCObjectIdentifiers.qTESLA_p_III);
    static final AlgorithmIdentifier SPHINCS_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha3_256);
    static final AlgorithmIdentifier SPHINCS_SHA512_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256);
    static final AlgorithmIdentifier XMSS_SHA256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
    static final AlgorithmIdentifier XMSS_SHA512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
    static final AlgorithmIdentifier XMSS_SHAKE128 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake128);
    static final AlgorithmIdentifier XMSS_SHAKE256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256);
    static final Map bikeOids;
    static final Map bikeParams;
    static final Map categories;
    static final Map dilithiumOids;
    static final Map dilithiumParams;
    static final Map falconOids;
    static final Map falconParams;
    static final Map frodoOids;
    static final Map frodoParams;
    static final Map hqcOids;
    static final Map hqcParams;
    static final Map mayoOids;
    static final Map mayoParams;
    static final Map mcElieceOids;
    static final Map mcElieceParams;
    static final Map mldsaOids;
    static final Map mldsaParams;
    static final Map mlkemOids;
    static final Map mlkemParams;
    static final Map ntruOids;
    static final Map ntruParams;
    static final Map ntruprimeOids;
    static final Map ntruprimeParams;
    static final Map picnicOids;
    static final Map picnicParams;
    static final Map rainbowOids;
    static final Map rainbowParams;
    static final Map saberOids;
    static final Map saberParams;
    static final Map sikeOids;
    static final Map sikeParams;
    static final Map slhdsaOids;
    static final Map slhdsaParams;
    static final Map snovaOids;
    static final Map snovaParams;
    static final Map sntruprimeOids;
    static final Map sntruprimeParams;
    static final Map sphincsPlusOids;
    static final Map sphincsPlusParams;

    static {
        HashMap map = new HashMap();
        categories = map;
        HashMap map2 = new HashMap();
        picnicOids = map2;
        HashMap map3 = new HashMap();
        picnicParams = map3;
        HashMap map4 = new HashMap();
        frodoOids = map4;
        HashMap map5 = new HashMap();
        frodoParams = map5;
        HashMap map6 = new HashMap();
        saberOids = map6;
        HashMap map7 = new HashMap();
        saberParams = map7;
        HashMap map8 = new HashMap();
        mcElieceOids = map8;
        HashMap map9 = new HashMap();
        mcElieceParams = map9;
        HashMap map10 = new HashMap();
        sphincsPlusOids = map10;
        HashMap map11 = new HashMap();
        sphincsPlusParams = map11;
        sikeOids = new HashMap();
        sikeParams = new HashMap();
        HashMap map12 = new HashMap();
        ntruOids = map12;
        HashMap map13 = new HashMap();
        ntruParams = map13;
        HashMap map14 = new HashMap();
        falconOids = map14;
        HashMap map15 = new HashMap();
        falconParams = map15;
        HashMap map16 = new HashMap();
        ntruprimeOids = map16;
        HashMap map17 = new HashMap();
        ntruprimeParams = map17;
        HashMap map18 = new HashMap();
        sntruprimeOids = map18;
        HashMap map19 = new HashMap();
        sntruprimeParams = map19;
        HashMap map20 = new HashMap();
        dilithiumOids = map20;
        HashMap map21 = new HashMap();
        dilithiumParams = map21;
        HashMap map22 = new HashMap();
        bikeOids = map22;
        HashMap map23 = new HashMap();
        bikeParams = map23;
        HashMap map24 = new HashMap();
        hqcOids = map24;
        HashMap map25 = new HashMap();
        hqcParams = map25;
        HashMap map26 = new HashMap();
        rainbowOids = map26;
        HashMap map27 = new HashMap();
        rainbowParams = map27;
        HashMap map28 = new HashMap();
        mlkemOids = map28;
        HashMap map29 = new HashMap();
        mlkemParams = map29;
        HashMap map30 = new HashMap();
        mldsaOids = map30;
        HashMap map31 = new HashMap();
        mldsaParams = map31;
        HashMap map32 = new HashMap();
        slhdsaOids = map32;
        HashMap map33 = new HashMap();
        slhdsaParams = map33;
        HashMap map34 = new HashMap();
        mayoOids = map34;
        HashMap map35 = new HashMap();
        mayoParams = map35;
        HashMap map36 = new HashMap();
        snovaOids = map36;
        HashMap map37 = new HashMap();
        snovaParams = map37;
        map.put(PQCObjectIdentifiers.qTESLA_p_I, Integers.valueOf(5));
        map.put(PQCObjectIdentifiers.qTESLA_p_III, Integers.valueOf(6));
        map8.put(CMCEParameters.mceliece348864r3, BCObjectIdentifiers.mceliece348864_r3);
        map8.put(CMCEParameters.mceliece348864fr3, BCObjectIdentifiers.mceliece348864f_r3);
        map8.put(CMCEParameters.mceliece460896r3, BCObjectIdentifiers.mceliece460896_r3);
        map8.put(CMCEParameters.mceliece460896fr3, BCObjectIdentifiers.mceliece460896f_r3);
        map8.put(CMCEParameters.mceliece6688128r3, BCObjectIdentifiers.mceliece6688128_r3);
        map8.put(CMCEParameters.mceliece6688128fr3, BCObjectIdentifiers.mceliece6688128f_r3);
        map8.put(CMCEParameters.mceliece6960119r3, BCObjectIdentifiers.mceliece6960119_r3);
        map8.put(CMCEParameters.mceliece6960119fr3, BCObjectIdentifiers.mceliece6960119f_r3);
        map8.put(CMCEParameters.mceliece8192128r3, BCObjectIdentifiers.mceliece8192128_r3);
        map8.put(CMCEParameters.mceliece8192128fr3, BCObjectIdentifiers.mceliece8192128f_r3);
        map9.put(BCObjectIdentifiers.mceliece348864_r3, CMCEParameters.mceliece348864r3);
        map9.put(BCObjectIdentifiers.mceliece348864f_r3, CMCEParameters.mceliece348864fr3);
        map9.put(BCObjectIdentifiers.mceliece460896_r3, CMCEParameters.mceliece460896r3);
        map9.put(BCObjectIdentifiers.mceliece460896f_r3, CMCEParameters.mceliece460896fr3);
        map9.put(BCObjectIdentifiers.mceliece6688128_r3, CMCEParameters.mceliece6688128r3);
        map9.put(BCObjectIdentifiers.mceliece6688128f_r3, CMCEParameters.mceliece6688128fr3);
        map9.put(BCObjectIdentifiers.mceliece6960119_r3, CMCEParameters.mceliece6960119r3);
        map9.put(BCObjectIdentifiers.mceliece6960119f_r3, CMCEParameters.mceliece6960119fr3);
        map9.put(BCObjectIdentifiers.mceliece8192128_r3, CMCEParameters.mceliece8192128r3);
        map9.put(BCObjectIdentifiers.mceliece8192128f_r3, CMCEParameters.mceliece8192128fr3);
        map4.put(FrodoParameters.frodokem640aes, BCObjectIdentifiers.frodokem640aes);
        map4.put(FrodoParameters.frodokem640shake, BCObjectIdentifiers.frodokem640shake);
        map4.put(FrodoParameters.frodokem976aes, BCObjectIdentifiers.frodokem976aes);
        map4.put(FrodoParameters.frodokem976shake, BCObjectIdentifiers.frodokem976shake);
        map4.put(FrodoParameters.frodokem1344aes, BCObjectIdentifiers.frodokem1344aes);
        map4.put(FrodoParameters.frodokem1344shake, BCObjectIdentifiers.frodokem1344shake);
        map5.put(BCObjectIdentifiers.frodokem640aes, FrodoParameters.frodokem640aes);
        map5.put(BCObjectIdentifiers.frodokem640shake, FrodoParameters.frodokem640shake);
        map5.put(BCObjectIdentifiers.frodokem976aes, FrodoParameters.frodokem976aes);
        map5.put(BCObjectIdentifiers.frodokem976shake, FrodoParameters.frodokem976shake);
        map5.put(BCObjectIdentifiers.frodokem1344aes, FrodoParameters.frodokem1344aes);
        map5.put(BCObjectIdentifiers.frodokem1344shake, FrodoParameters.frodokem1344shake);
        map6.put(SABERParameters.lightsaberkem128r3, BCObjectIdentifiers.lightsaberkem128r3);
        map6.put(SABERParameters.saberkem128r3, BCObjectIdentifiers.saberkem128r3);
        map6.put(SABERParameters.firesaberkem128r3, BCObjectIdentifiers.firesaberkem128r3);
        map6.put(SABERParameters.lightsaberkem192r3, BCObjectIdentifiers.lightsaberkem192r3);
        map6.put(SABERParameters.saberkem192r3, BCObjectIdentifiers.saberkem192r3);
        map6.put(SABERParameters.firesaberkem192r3, BCObjectIdentifiers.firesaberkem192r3);
        map6.put(SABERParameters.lightsaberkem256r3, BCObjectIdentifiers.lightsaberkem256r3);
        map6.put(SABERParameters.saberkem256r3, BCObjectIdentifiers.saberkem256r3);
        map6.put(SABERParameters.firesaberkem256r3, BCObjectIdentifiers.firesaberkem256r3);
        map6.put(SABERParameters.ulightsaberkemr3, BCObjectIdentifiers.ulightsaberkemr3);
        map6.put(SABERParameters.usaberkemr3, BCObjectIdentifiers.usaberkemr3);
        map6.put(SABERParameters.ufiresaberkemr3, BCObjectIdentifiers.ufiresaberkemr3);
        map6.put(SABERParameters.lightsaberkem90sr3, BCObjectIdentifiers.lightsaberkem90sr3);
        map6.put(SABERParameters.saberkem90sr3, BCObjectIdentifiers.saberkem90sr3);
        map6.put(SABERParameters.firesaberkem90sr3, BCObjectIdentifiers.firesaberkem90sr3);
        map6.put(SABERParameters.ulightsaberkem90sr3, BCObjectIdentifiers.ulightsaberkem90sr3);
        map6.put(SABERParameters.usaberkem90sr3, BCObjectIdentifiers.usaberkem90sr3);
        map6.put(SABERParameters.ufiresaberkem90sr3, BCObjectIdentifiers.ufiresaberkem90sr3);
        map7.put(BCObjectIdentifiers.lightsaberkem128r3, SABERParameters.lightsaberkem128r3);
        map7.put(BCObjectIdentifiers.saberkem128r3, SABERParameters.saberkem128r3);
        map7.put(BCObjectIdentifiers.firesaberkem128r3, SABERParameters.firesaberkem128r3);
        map7.put(BCObjectIdentifiers.lightsaberkem192r3, SABERParameters.lightsaberkem192r3);
        map7.put(BCObjectIdentifiers.saberkem192r3, SABERParameters.saberkem192r3);
        map7.put(BCObjectIdentifiers.firesaberkem192r3, SABERParameters.firesaberkem192r3);
        map7.put(BCObjectIdentifiers.lightsaberkem256r3, SABERParameters.lightsaberkem256r3);
        map7.put(BCObjectIdentifiers.saberkem256r3, SABERParameters.saberkem256r3);
        map7.put(BCObjectIdentifiers.firesaberkem256r3, SABERParameters.firesaberkem256r3);
        map7.put(BCObjectIdentifiers.ulightsaberkemr3, SABERParameters.ulightsaberkemr3);
        map7.put(BCObjectIdentifiers.usaberkemr3, SABERParameters.usaberkemr3);
        map7.put(BCObjectIdentifiers.ufiresaberkemr3, SABERParameters.ufiresaberkemr3);
        map7.put(BCObjectIdentifiers.lightsaberkem90sr3, SABERParameters.lightsaberkem90sr3);
        map7.put(BCObjectIdentifiers.saberkem90sr3, SABERParameters.saberkem90sr3);
        map7.put(BCObjectIdentifiers.firesaberkem90sr3, SABERParameters.firesaberkem90sr3);
        map7.put(BCObjectIdentifiers.ulightsaberkem90sr3, SABERParameters.ulightsaberkem90sr3);
        map7.put(BCObjectIdentifiers.usaberkem90sr3, SABERParameters.usaberkem90sr3);
        map7.put(BCObjectIdentifiers.ufiresaberkem90sr3, SABERParameters.ufiresaberkem90sr3);
        map2.put(PicnicParameters.picnicl1fs, BCObjectIdentifiers.picnicl1fs);
        map2.put(PicnicParameters.picnicl1ur, BCObjectIdentifiers.picnicl1ur);
        map2.put(PicnicParameters.picnicl3fs, BCObjectIdentifiers.picnicl3fs);
        map2.put(PicnicParameters.picnicl3ur, BCObjectIdentifiers.picnicl3ur);
        map2.put(PicnicParameters.picnicl5fs, BCObjectIdentifiers.picnicl5fs);
        map2.put(PicnicParameters.picnicl5ur, BCObjectIdentifiers.picnicl5ur);
        map2.put(PicnicParameters.picnic3l1, BCObjectIdentifiers.picnic3l1);
        map2.put(PicnicParameters.picnic3l3, BCObjectIdentifiers.picnic3l3);
        map2.put(PicnicParameters.picnic3l5, BCObjectIdentifiers.picnic3l5);
        map2.put(PicnicParameters.picnicl1full, BCObjectIdentifiers.picnicl1full);
        map2.put(PicnicParameters.picnicl3full, BCObjectIdentifiers.picnicl3full);
        map2.put(PicnicParameters.picnicl5full, BCObjectIdentifiers.picnicl5full);
        map3.put(BCObjectIdentifiers.picnicl1fs, PicnicParameters.picnicl1fs);
        map3.put(BCObjectIdentifiers.picnicl1ur, PicnicParameters.picnicl1ur);
        map3.put(BCObjectIdentifiers.picnicl3fs, PicnicParameters.picnicl3fs);
        map3.put(BCObjectIdentifiers.picnicl3ur, PicnicParameters.picnicl3ur);
        map3.put(BCObjectIdentifiers.picnicl5fs, PicnicParameters.picnicl5fs);
        map3.put(BCObjectIdentifiers.picnicl5ur, PicnicParameters.picnicl5ur);
        map3.put(BCObjectIdentifiers.picnic3l1, PicnicParameters.picnic3l1);
        map3.put(BCObjectIdentifiers.picnic3l3, PicnicParameters.picnic3l3);
        map3.put(BCObjectIdentifiers.picnic3l5, PicnicParameters.picnic3l5);
        map3.put(BCObjectIdentifiers.picnicl1full, PicnicParameters.picnicl1full);
        map3.put(BCObjectIdentifiers.picnicl3full, PicnicParameters.picnicl3full);
        map3.put(BCObjectIdentifiers.picnicl5full, PicnicParameters.picnicl5full);
        map12.put(NTRUParameters.ntruhps2048509, BCObjectIdentifiers.ntruhps2048509);
        map12.put(NTRUParameters.ntruhps2048677, BCObjectIdentifiers.ntruhps2048677);
        map12.put(NTRUParameters.ntruhps4096821, BCObjectIdentifiers.ntruhps4096821);
        map12.put(NTRUParameters.ntruhps40961229, BCObjectIdentifiers.ntruhps40961229);
        map12.put(NTRUParameters.ntruhrss701, BCObjectIdentifiers.ntruhrss701);
        map12.put(NTRUParameters.ntruhrss1373, BCObjectIdentifiers.ntruhrss1373);
        map13.put(BCObjectIdentifiers.ntruhps2048509, NTRUParameters.ntruhps2048509);
        map13.put(BCObjectIdentifiers.ntruhps2048677, NTRUParameters.ntruhps2048677);
        map13.put(BCObjectIdentifiers.ntruhps4096821, NTRUParameters.ntruhps4096821);
        map13.put(BCObjectIdentifiers.ntruhps40961229, NTRUParameters.ntruhps40961229);
        map13.put(BCObjectIdentifiers.ntruhrss701, NTRUParameters.ntruhrss701);
        map13.put(BCObjectIdentifiers.ntruhrss1373, NTRUParameters.ntruhrss1373);
        map14.put(FalconParameters.falcon_512, BCObjectIdentifiers.falcon_512);
        map14.put(FalconParameters.falcon_1024, BCObjectIdentifiers.falcon_1024);
        map15.put(BCObjectIdentifiers.falcon_512, FalconParameters.falcon_512);
        map15.put(BCObjectIdentifiers.falcon_1024, FalconParameters.falcon_1024);
        map28.put(MLKEMParameters.ml_kem_512, NISTObjectIdentifiers.id_alg_ml_kem_512);
        map28.put(MLKEMParameters.ml_kem_768, NISTObjectIdentifiers.id_alg_ml_kem_768);
        map28.put(MLKEMParameters.ml_kem_1024, NISTObjectIdentifiers.id_alg_ml_kem_1024);
        map29.put(NISTObjectIdentifiers.id_alg_ml_kem_512, MLKEMParameters.ml_kem_512);
        map29.put(NISTObjectIdentifiers.id_alg_ml_kem_768, MLKEMParameters.ml_kem_768);
        map29.put(NISTObjectIdentifiers.id_alg_ml_kem_1024, MLKEMParameters.ml_kem_1024);
        map16.put(NTRULPRimeParameters.ntrulpr653, BCObjectIdentifiers.ntrulpr653);
        map16.put(NTRULPRimeParameters.ntrulpr761, BCObjectIdentifiers.ntrulpr761);
        map16.put(NTRULPRimeParameters.ntrulpr857, BCObjectIdentifiers.ntrulpr857);
        map16.put(NTRULPRimeParameters.ntrulpr953, BCObjectIdentifiers.ntrulpr953);
        map16.put(NTRULPRimeParameters.ntrulpr1013, BCObjectIdentifiers.ntrulpr1013);
        map16.put(NTRULPRimeParameters.ntrulpr1277, BCObjectIdentifiers.ntrulpr1277);
        map17.put(BCObjectIdentifiers.ntrulpr653, NTRULPRimeParameters.ntrulpr653);
        map17.put(BCObjectIdentifiers.ntrulpr761, NTRULPRimeParameters.ntrulpr761);
        map17.put(BCObjectIdentifiers.ntrulpr857, NTRULPRimeParameters.ntrulpr857);
        map17.put(BCObjectIdentifiers.ntrulpr953, NTRULPRimeParameters.ntrulpr953);
        map17.put(BCObjectIdentifiers.ntrulpr1013, NTRULPRimeParameters.ntrulpr1013);
        map17.put(BCObjectIdentifiers.ntrulpr1277, NTRULPRimeParameters.ntrulpr1277);
        map18.put(SNTRUPrimeParameters.sntrup653, BCObjectIdentifiers.sntrup653);
        map18.put(SNTRUPrimeParameters.sntrup761, BCObjectIdentifiers.sntrup761);
        map18.put(SNTRUPrimeParameters.sntrup857, BCObjectIdentifiers.sntrup857);
        map18.put(SNTRUPrimeParameters.sntrup953, BCObjectIdentifiers.sntrup953);
        map18.put(SNTRUPrimeParameters.sntrup1013, BCObjectIdentifiers.sntrup1013);
        map18.put(SNTRUPrimeParameters.sntrup1277, BCObjectIdentifiers.sntrup1277);
        map19.put(BCObjectIdentifiers.sntrup653, SNTRUPrimeParameters.sntrup653);
        map19.put(BCObjectIdentifiers.sntrup761, SNTRUPrimeParameters.sntrup761);
        map19.put(BCObjectIdentifiers.sntrup857, SNTRUPrimeParameters.sntrup857);
        map19.put(BCObjectIdentifiers.sntrup953, SNTRUPrimeParameters.sntrup953);
        map19.put(BCObjectIdentifiers.sntrup1013, SNTRUPrimeParameters.sntrup1013);
        map19.put(BCObjectIdentifiers.sntrup1277, SNTRUPrimeParameters.sntrup1277);
        map30.put(MLDSAParameters.ml_dsa_44, NISTObjectIdentifiers.id_ml_dsa_44);
        map30.put(MLDSAParameters.ml_dsa_65, NISTObjectIdentifiers.id_ml_dsa_65);
        map30.put(MLDSAParameters.ml_dsa_87, NISTObjectIdentifiers.id_ml_dsa_87);
        map30.put(MLDSAParameters.ml_dsa_44_with_sha512, NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512);
        map30.put(MLDSAParameters.ml_dsa_65_with_sha512, NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512);
        map30.put(MLDSAParameters.ml_dsa_87_with_sha512, NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512);
        map31.put(NISTObjectIdentifiers.id_ml_dsa_44, MLDSAParameters.ml_dsa_44);
        map31.put(NISTObjectIdentifiers.id_ml_dsa_65, MLDSAParameters.ml_dsa_65);
        map31.put(NISTObjectIdentifiers.id_ml_dsa_87, MLDSAParameters.ml_dsa_87);
        map31.put(NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512, MLDSAParameters.ml_dsa_44_with_sha512);
        map31.put(NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512, MLDSAParameters.ml_dsa_65_with_sha512);
        map31.put(NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512, MLDSAParameters.ml_dsa_87_with_sha512);
        map20.put(DilithiumParameters.dilithium2, BCObjectIdentifiers.dilithium2);
        map20.put(DilithiumParameters.dilithium3, BCObjectIdentifiers.dilithium3);
        map20.put(DilithiumParameters.dilithium5, BCObjectIdentifiers.dilithium5);
        map21.put(BCObjectIdentifiers.dilithium2, DilithiumParameters.dilithium2);
        map21.put(BCObjectIdentifiers.dilithium3, DilithiumParameters.dilithium3);
        map21.put(BCObjectIdentifiers.dilithium5, DilithiumParameters.dilithium5);
        map23.put(BCObjectIdentifiers.bike128, BIKEParameters.bike128);
        map23.put(BCObjectIdentifiers.bike192, BIKEParameters.bike192);
        map23.put(BCObjectIdentifiers.bike256, BIKEParameters.bike256);
        map22.put(BIKEParameters.bike128, BCObjectIdentifiers.bike128);
        map22.put(BIKEParameters.bike192, BCObjectIdentifiers.bike192);
        map22.put(BIKEParameters.bike256, BCObjectIdentifiers.bike256);
        map25.put(BCObjectIdentifiers.hqc128, HQCParameters.hqc128);
        map25.put(BCObjectIdentifiers.hqc192, HQCParameters.hqc192);
        map25.put(BCObjectIdentifiers.hqc256, HQCParameters.hqc256);
        map24.put(HQCParameters.hqc128, BCObjectIdentifiers.hqc128);
        map24.put(HQCParameters.hqc192, BCObjectIdentifiers.hqc192);
        map24.put(HQCParameters.hqc256, BCObjectIdentifiers.hqc256);
        map27.put(BCObjectIdentifiers.rainbow_III_classic, RainbowParameters.rainbowIIIclassic);
        map27.put(BCObjectIdentifiers.rainbow_III_circumzenithal, RainbowParameters.rainbowIIIcircumzenithal);
        map27.put(BCObjectIdentifiers.rainbow_III_compressed, RainbowParameters.rainbowIIIcompressed);
        map27.put(BCObjectIdentifiers.rainbow_V_classic, RainbowParameters.rainbowVclassic);
        map27.put(BCObjectIdentifiers.rainbow_V_circumzenithal, RainbowParameters.rainbowVcircumzenithal);
        map27.put(BCObjectIdentifiers.rainbow_V_compressed, RainbowParameters.rainbowVcompressed);
        map26.put(RainbowParameters.rainbowIIIclassic, BCObjectIdentifiers.rainbow_III_classic);
        map26.put(RainbowParameters.rainbowIIIcircumzenithal, BCObjectIdentifiers.rainbow_III_circumzenithal);
        map26.put(RainbowParameters.rainbowIIIcompressed, BCObjectIdentifiers.rainbow_III_compressed);
        map26.put(RainbowParameters.rainbowVclassic, BCObjectIdentifiers.rainbow_V_classic);
        map26.put(RainbowParameters.rainbowVcircumzenithal, BCObjectIdentifiers.rainbow_V_circumzenithal);
        map26.put(RainbowParameters.rainbowVcompressed, BCObjectIdentifiers.rainbow_V_compressed);
        map32.put(SLHDSAParameters.sha2_128s, NISTObjectIdentifiers.id_slh_dsa_sha2_128s);
        map32.put(SLHDSAParameters.sha2_128f, NISTObjectIdentifiers.id_slh_dsa_sha2_128f);
        map32.put(SLHDSAParameters.sha2_192s, NISTObjectIdentifiers.id_slh_dsa_sha2_192s);
        map32.put(SLHDSAParameters.sha2_192f, NISTObjectIdentifiers.id_slh_dsa_sha2_192f);
        map32.put(SLHDSAParameters.sha2_256s, NISTObjectIdentifiers.id_slh_dsa_sha2_256s);
        map32.put(SLHDSAParameters.sha2_256f, NISTObjectIdentifiers.id_slh_dsa_sha2_256f);
        map32.put(SLHDSAParameters.shake_128s, NISTObjectIdentifiers.id_slh_dsa_shake_128s);
        map32.put(SLHDSAParameters.shake_128f, NISTObjectIdentifiers.id_slh_dsa_shake_128f);
        map32.put(SLHDSAParameters.shake_192s, NISTObjectIdentifiers.id_slh_dsa_shake_192s);
        map32.put(SLHDSAParameters.shake_192f, NISTObjectIdentifiers.id_slh_dsa_shake_192f);
        map32.put(SLHDSAParameters.shake_256s, NISTObjectIdentifiers.id_slh_dsa_shake_256s);
        map32.put(SLHDSAParameters.shake_256f, NISTObjectIdentifiers.id_slh_dsa_shake_256f);
        map32.put(SLHDSAParameters.sha2_128s_with_sha256, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128s_with_sha256);
        map32.put(SLHDSAParameters.sha2_128f_with_sha256, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128f_with_sha256);
        map32.put(SLHDSAParameters.sha2_192s_with_sha512, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192s_with_sha512);
        map32.put(SLHDSAParameters.sha2_192f_with_sha512, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192f_with_sha512);
        map32.put(SLHDSAParameters.sha2_256s_with_sha512, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256s_with_sha512);
        map32.put(SLHDSAParameters.sha2_256f_with_sha512, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256f_with_sha512);
        map32.put(SLHDSAParameters.shake_128s_with_shake128, NISTObjectIdentifiers.id_hash_slh_dsa_shake_128s_with_shake128);
        map32.put(SLHDSAParameters.shake_128f_with_shake128, NISTObjectIdentifiers.id_hash_slh_dsa_shake_128f_with_shake128);
        map32.put(SLHDSAParameters.shake_192s_with_shake256, NISTObjectIdentifiers.id_hash_slh_dsa_shake_192s_with_shake256);
        map32.put(SLHDSAParameters.shake_192f_with_shake256, NISTObjectIdentifiers.id_hash_slh_dsa_shake_192f_with_shake256);
        map32.put(SLHDSAParameters.shake_256s_with_shake256, NISTObjectIdentifiers.id_hash_slh_dsa_shake_256s_with_shake256);
        map32.put(SLHDSAParameters.shake_256f_with_shake256, NISTObjectIdentifiers.id_hash_slh_dsa_shake_256f_with_shake256);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_sha2_128s, SLHDSAParameters.sha2_128s);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_sha2_128f, SLHDSAParameters.sha2_128f);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_sha2_192s, SLHDSAParameters.sha2_192s);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_sha2_192f, SLHDSAParameters.sha2_192f);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_sha2_256s, SLHDSAParameters.sha2_256s);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_sha2_256f, SLHDSAParameters.sha2_256f);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_shake_128s, SLHDSAParameters.shake_128s);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_shake_128f, SLHDSAParameters.shake_128f);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_shake_192s, SLHDSAParameters.shake_192s);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_shake_192f, SLHDSAParameters.shake_192f);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_shake_256s, SLHDSAParameters.shake_256s);
        map33.put(NISTObjectIdentifiers.id_slh_dsa_shake_256f, SLHDSAParameters.shake_256f);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128s_with_sha256, SLHDSAParameters.sha2_128s_with_sha256);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128f_with_sha256, SLHDSAParameters.sha2_128f_with_sha256);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192s_with_sha512, SLHDSAParameters.sha2_192s_with_sha512);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192f_with_sha512, SLHDSAParameters.sha2_192f_with_sha512);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256s_with_sha512, SLHDSAParameters.sha2_256s_with_sha512);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256f_with_sha512, SLHDSAParameters.sha2_256f_with_sha512);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_128s_with_shake128, SLHDSAParameters.shake_128s_with_shake128);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_128f_with_shake128, SLHDSAParameters.shake_128f_with_shake128);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_192s_with_shake256, SLHDSAParameters.shake_192s_with_shake256);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_192f_with_shake256, SLHDSAParameters.shake_192f_with_shake256);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_256s_with_shake256, SLHDSAParameters.shake_256s_with_shake256);
        map33.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_256f_with_shake256, SLHDSAParameters.shake_256f_with_shake256);
        map10.put(SLHDSAParameters.sha2_128s, BCObjectIdentifiers.sphincsPlus_sha2_128s);
        map10.put(SLHDSAParameters.sha2_128f, BCObjectIdentifiers.sphincsPlus_sha2_128f);
        map10.put(SLHDSAParameters.sha2_192s, BCObjectIdentifiers.sphincsPlus_sha2_192s);
        map10.put(SLHDSAParameters.sha2_192f, BCObjectIdentifiers.sphincsPlus_sha2_192f);
        map10.put(SLHDSAParameters.sha2_256s, BCObjectIdentifiers.sphincsPlus_sha2_256s);
        map10.put(SLHDSAParameters.sha2_256f, BCObjectIdentifiers.sphincsPlus_sha2_256f);
        map10.put(SLHDSAParameters.shake_128s, BCObjectIdentifiers.sphincsPlus_shake_128s);
        map10.put(SLHDSAParameters.shake_128f, BCObjectIdentifiers.sphincsPlus_shake_128f);
        map10.put(SLHDSAParameters.shake_192s, BCObjectIdentifiers.sphincsPlus_shake_192s);
        map10.put(SLHDSAParameters.shake_192f, BCObjectIdentifiers.sphincsPlus_shake_192f);
        map10.put(SLHDSAParameters.shake_256s, BCObjectIdentifiers.sphincsPlus_shake_256s);
        map10.put(SLHDSAParameters.shake_256f, BCObjectIdentifiers.sphincsPlus_shake_256f);
        map10.put(SPHINCSPlusParameters.sha2_128s_robust, BCObjectIdentifiers.sphincsPlus_sha2_128s_r3);
        map10.put(SPHINCSPlusParameters.sha2_128f_robust, BCObjectIdentifiers.sphincsPlus_sha2_128f_r3);
        map10.put(SPHINCSPlusParameters.shake_128s_robust, BCObjectIdentifiers.sphincsPlus_shake_128s_r3);
        map10.put(SPHINCSPlusParameters.shake_128f_robust, BCObjectIdentifiers.sphincsPlus_shake_128f_r3);
        map10.put(SPHINCSPlusParameters.haraka_128s, BCObjectIdentifiers.sphincsPlus_haraka_128s_r3);
        map10.put(SPHINCSPlusParameters.haraka_128f, BCObjectIdentifiers.sphincsPlus_haraka_128f_r3);
        map10.put(SPHINCSPlusParameters.sha2_192s_robust, BCObjectIdentifiers.sphincsPlus_sha2_192s_r3);
        map10.put(SPHINCSPlusParameters.sha2_192f_robust, BCObjectIdentifiers.sphincsPlus_sha2_192f_r3);
        map10.put(SPHINCSPlusParameters.shake_192s_robust, BCObjectIdentifiers.sphincsPlus_shake_192s_r3);
        map10.put(SPHINCSPlusParameters.shake_192f_robust, BCObjectIdentifiers.sphincsPlus_shake_192f_r3);
        map10.put(SPHINCSPlusParameters.haraka_192s, BCObjectIdentifiers.sphincsPlus_haraka_192s_r3);
        map10.put(SPHINCSPlusParameters.haraka_192f, BCObjectIdentifiers.sphincsPlus_haraka_192f_r3);
        map10.put(SPHINCSPlusParameters.sha2_256s_robust, BCObjectIdentifiers.sphincsPlus_sha2_256s_r3);
        map10.put(SPHINCSPlusParameters.sha2_256f_robust, BCObjectIdentifiers.sphincsPlus_sha2_256f_r3);
        map10.put(SPHINCSPlusParameters.shake_256s_robust, BCObjectIdentifiers.sphincsPlus_shake_256s_r3);
        map10.put(SPHINCSPlusParameters.shake_256f_robust, BCObjectIdentifiers.sphincsPlus_shake_256f_r3);
        map10.put(SPHINCSPlusParameters.haraka_256s, BCObjectIdentifiers.sphincsPlus_haraka_256s_r3);
        map10.put(SPHINCSPlusParameters.haraka_256f, BCObjectIdentifiers.sphincsPlus_haraka_256f_r3);
        map10.put(SPHINCSPlusParameters.haraka_128s_simple, BCObjectIdentifiers.sphincsPlus_haraka_128s_r3_simple);
        map10.put(SPHINCSPlusParameters.haraka_128f_simple, BCObjectIdentifiers.sphincsPlus_haraka_128f_r3_simple);
        map10.put(SPHINCSPlusParameters.haraka_192s_simple, BCObjectIdentifiers.sphincsPlus_haraka_192s_r3_simple);
        map10.put(SPHINCSPlusParameters.haraka_192f_simple, BCObjectIdentifiers.sphincsPlus_haraka_192f_r3_simple);
        map10.put(SPHINCSPlusParameters.haraka_256s_simple, BCObjectIdentifiers.sphincsPlus_haraka_256s_r3_simple);
        map10.put(SPHINCSPlusParameters.haraka_256f_simple, BCObjectIdentifiers.sphincsPlus_haraka_256f_r3_simple);
        map10.put(SPHINCSPlusParameters.sha2_128s, BCObjectIdentifiers.sphincsPlus_sha2_128s);
        map10.put(SPHINCSPlusParameters.sha2_128f, BCObjectIdentifiers.sphincsPlus_sha2_128f);
        map10.put(SPHINCSPlusParameters.sha2_192s, BCObjectIdentifiers.sphincsPlus_sha2_192s);
        map10.put(SPHINCSPlusParameters.sha2_192f, BCObjectIdentifiers.sphincsPlus_sha2_192f);
        map10.put(SPHINCSPlusParameters.sha2_256s, BCObjectIdentifiers.sphincsPlus_sha2_256s);
        map10.put(SPHINCSPlusParameters.sha2_256f, BCObjectIdentifiers.sphincsPlus_sha2_256f);
        map10.put(SPHINCSPlusParameters.shake_128s, BCObjectIdentifiers.sphincsPlus_shake_128s);
        map10.put(SPHINCSPlusParameters.shake_128f, BCObjectIdentifiers.sphincsPlus_shake_128f);
        map10.put(SPHINCSPlusParameters.shake_192s, BCObjectIdentifiers.sphincsPlus_shake_192s);
        map10.put(SPHINCSPlusParameters.shake_192f, BCObjectIdentifiers.sphincsPlus_shake_192f);
        map10.put(SPHINCSPlusParameters.shake_256s, BCObjectIdentifiers.sphincsPlus_shake_256s);
        map10.put(SPHINCSPlusParameters.shake_256f, BCObjectIdentifiers.sphincsPlus_shake_256f);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_128s, SPHINCSPlusParameters.sha2_128s);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_128f, SPHINCSPlusParameters.sha2_128f);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_128s, SPHINCSPlusParameters.shake_128s);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_128f, SPHINCSPlusParameters.shake_128f);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_192s, SPHINCSPlusParameters.sha2_192s);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_192f, SPHINCSPlusParameters.sha2_192f);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_192s, SPHINCSPlusParameters.shake_192s);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_192f, SPHINCSPlusParameters.shake_192f);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_256s, SPHINCSPlusParameters.sha2_256s);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_256f, SPHINCSPlusParameters.sha2_256f);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_256s, SPHINCSPlusParameters.shake_256s);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_256f, SPHINCSPlusParameters.shake_256f);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_128s_r3, SPHINCSPlusParameters.sha2_128s_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_128f_r3, SPHINCSPlusParameters.sha2_128f_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_128s_r3, SPHINCSPlusParameters.shake_128s_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_128f_r3, SPHINCSPlusParameters.shake_128f_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_128s_r3, SPHINCSPlusParameters.haraka_128s);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_128f_r3, SPHINCSPlusParameters.haraka_128f);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_192s_r3, SPHINCSPlusParameters.sha2_192s_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_192f_r3, SPHINCSPlusParameters.sha2_192f_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_192s_r3, SPHINCSPlusParameters.shake_192s_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_192f_r3, SPHINCSPlusParameters.shake_192f_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_192s_r3, SPHINCSPlusParameters.haraka_192s);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_192f_r3, SPHINCSPlusParameters.haraka_192f);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_256s_r3, SPHINCSPlusParameters.sha2_256s_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3, SPHINCSPlusParameters.sha2_256f_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_256s_r3, SPHINCSPlusParameters.shake_256s_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_256f_r3, SPHINCSPlusParameters.shake_256f_robust);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_256s_r3, SPHINCSPlusParameters.haraka_256s);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_256f_r3, SPHINCSPlusParameters.haraka_256f);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_128s_r3_simple, SPHINCSPlusParameters.sha2_128s);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_128f_r3_simple, SPHINCSPlusParameters.sha2_128f);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_128s_r3_simple, SPHINCSPlusParameters.shake_128s);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_128f_r3_simple, SPHINCSPlusParameters.shake_128f);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_128s_r3_simple, SPHINCSPlusParameters.haraka_128s_simple);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_128f_r3_simple, SPHINCSPlusParameters.haraka_128f_simple);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_192s_r3_simple, SPHINCSPlusParameters.sha2_192s);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_192f_r3_simple, SPHINCSPlusParameters.sha2_192f);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_192s_r3_simple, SPHINCSPlusParameters.shake_192s);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_192f_r3_simple, SPHINCSPlusParameters.shake_192f);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_192s_r3_simple, SPHINCSPlusParameters.haraka_192s_simple);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_192f_r3_simple, SPHINCSPlusParameters.haraka_192f_simple);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_256s_r3_simple, SPHINCSPlusParameters.sha2_256s);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3_simple, SPHINCSPlusParameters.sha2_256f);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_256s_r3_simple, SPHINCSPlusParameters.shake_256s);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_256f_r3_simple, SPHINCSPlusParameters.shake_256f);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_256s_r3_simple, SPHINCSPlusParameters.haraka_256s_simple);
        map11.put(BCObjectIdentifiers.sphincsPlus_haraka_256f_r3_simple, SPHINCSPlusParameters.haraka_256f_simple);
        map34.put(MayoParameters.mayo1, BCObjectIdentifiers.mayo1);
        map34.put(MayoParameters.mayo2, BCObjectIdentifiers.mayo2);
        map34.put(MayoParameters.mayo3, BCObjectIdentifiers.mayo3);
        map34.put(MayoParameters.mayo5, BCObjectIdentifiers.mayo5);
        map35.put(BCObjectIdentifiers.mayo1, MayoParameters.mayo1);
        map35.put(BCObjectIdentifiers.mayo2, MayoParameters.mayo2);
        map35.put(BCObjectIdentifiers.mayo3, MayoParameters.mayo3);
        map35.put(BCObjectIdentifiers.mayo5, MayoParameters.mayo5);
        map36.put(SnovaParameters.SNOVA_24_5_4_SSK, BCObjectIdentifiers.snova_24_5_4_ssk);
        map36.put(SnovaParameters.SNOVA_24_5_4_ESK, BCObjectIdentifiers.snova_24_5_4_esk);
        map36.put(SnovaParameters.SNOVA_24_5_4_SHAKE_SSK, BCObjectIdentifiers.snova_24_5_4_shake_ssk);
        map36.put(SnovaParameters.SNOVA_24_5_4_SHAKE_ESK, BCObjectIdentifiers.snova_24_5_4_shake_esk);
        map36.put(SnovaParameters.SNOVA_24_5_5_SSK, BCObjectIdentifiers.snova_24_5_5_ssk);
        map36.put(SnovaParameters.SNOVA_24_5_5_ESK, BCObjectIdentifiers.snova_24_5_5_esk);
        map36.put(SnovaParameters.SNOVA_24_5_5_SHAKE_SSK, BCObjectIdentifiers.snova_24_5_5_shake_ssk);
        map36.put(SnovaParameters.SNOVA_24_5_5_SHAKE_ESK, BCObjectIdentifiers.snova_24_5_5_shake_esk);
        map36.put(SnovaParameters.SNOVA_25_8_3_SSK, BCObjectIdentifiers.snova_25_8_3_ssk);
        map36.put(SnovaParameters.SNOVA_25_8_3_ESK, BCObjectIdentifiers.snova_25_8_3_esk);
        map36.put(SnovaParameters.SNOVA_25_8_3_SHAKE_SSK, BCObjectIdentifiers.snova_25_8_3_shake_ssk);
        map36.put(SnovaParameters.SNOVA_25_8_3_SHAKE_ESK, BCObjectIdentifiers.snova_25_8_3_shake_esk);
        map36.put(SnovaParameters.SNOVA_29_6_5_SSK, BCObjectIdentifiers.snova_29_6_5_ssk);
        map36.put(SnovaParameters.SNOVA_29_6_5_ESK, BCObjectIdentifiers.snova_29_6_5_esk);
        map36.put(SnovaParameters.SNOVA_29_6_5_SHAKE_SSK, BCObjectIdentifiers.snova_29_6_5_shake_ssk);
        map36.put(SnovaParameters.SNOVA_29_6_5_SHAKE_ESK, BCObjectIdentifiers.snova_29_6_5_shake_esk);
        map36.put(SnovaParameters.SNOVA_37_8_4_SSK, BCObjectIdentifiers.snova_37_8_4_ssk);
        map36.put(SnovaParameters.SNOVA_37_8_4_ESK, BCObjectIdentifiers.snova_37_8_4_esk);
        map36.put(SnovaParameters.SNOVA_37_8_4_SHAKE_SSK, BCObjectIdentifiers.snova_37_8_4_shake_ssk);
        map36.put(SnovaParameters.SNOVA_37_8_4_SHAKE_ESK, BCObjectIdentifiers.snova_37_8_4_shake_esk);
        map36.put(SnovaParameters.SNOVA_37_17_2_SSK, BCObjectIdentifiers.snova_37_17_2_ssk);
        map36.put(SnovaParameters.SNOVA_37_17_2_ESK, BCObjectIdentifiers.snova_37_17_2_esk);
        map36.put(SnovaParameters.SNOVA_37_17_2_SHAKE_SSK, BCObjectIdentifiers.snova_37_17_2_shake_ssk);
        map36.put(SnovaParameters.SNOVA_37_17_2_SHAKE_ESK, BCObjectIdentifiers.snova_37_17_2_shake_esk);
        map36.put(SnovaParameters.SNOVA_49_11_3_SSK, BCObjectIdentifiers.snova_49_11_3_ssk);
        map36.put(SnovaParameters.SNOVA_49_11_3_ESK, BCObjectIdentifiers.snova_49_11_3_esk);
        map36.put(SnovaParameters.SNOVA_49_11_3_SHAKE_SSK, BCObjectIdentifiers.snova_49_11_3_shake_ssk);
        map36.put(SnovaParameters.SNOVA_49_11_3_SHAKE_ESK, BCObjectIdentifiers.snova_49_11_3_shake_esk);
        map36.put(SnovaParameters.SNOVA_56_25_2_SSK, BCObjectIdentifiers.snova_56_25_2_ssk);
        map36.put(SnovaParameters.SNOVA_56_25_2_ESK, BCObjectIdentifiers.snova_56_25_2_esk);
        map36.put(SnovaParameters.SNOVA_56_25_2_SHAKE_SSK, BCObjectIdentifiers.snova_56_25_2_shake_ssk);
        map36.put(SnovaParameters.SNOVA_56_25_2_SHAKE_ESK, BCObjectIdentifiers.snova_56_25_2_shake_esk);
        map36.put(SnovaParameters.SNOVA_60_10_4_SSK, BCObjectIdentifiers.snova_60_10_4_ssk);
        map36.put(SnovaParameters.SNOVA_60_10_4_ESK, BCObjectIdentifiers.snova_60_10_4_esk);
        map36.put(SnovaParameters.SNOVA_60_10_4_SHAKE_SSK, BCObjectIdentifiers.snova_60_10_4_shake_ssk);
        map36.put(SnovaParameters.SNOVA_60_10_4_SHAKE_ESK, BCObjectIdentifiers.snova_60_10_4_shake_esk);
        map36.put(SnovaParameters.SNOVA_66_15_3_SSK, BCObjectIdentifiers.snova_66_15_3_ssk);
        map36.put(SnovaParameters.SNOVA_66_15_3_ESK, BCObjectIdentifiers.snova_66_15_3_esk);
        map36.put(SnovaParameters.SNOVA_66_15_3_SHAKE_SSK, BCObjectIdentifiers.snova_66_15_3_shake_ssk);
        map36.put(SnovaParameters.SNOVA_66_15_3_SHAKE_ESK, BCObjectIdentifiers.snova_66_15_3_shake_esk);
        map36.put(SnovaParameters.SNOVA_75_33_2_SSK, BCObjectIdentifiers.snova_75_33_2_ssk);
        map36.put(SnovaParameters.SNOVA_75_33_2_ESK, BCObjectIdentifiers.snova_75_33_2_esk);
        map36.put(SnovaParameters.SNOVA_75_33_2_SHAKE_SSK, BCObjectIdentifiers.snova_75_33_2_shake_ssk);
        map36.put(SnovaParameters.SNOVA_75_33_2_SHAKE_ESK, BCObjectIdentifiers.snova_75_33_2_shake_esk);
        map37.put(BCObjectIdentifiers.snova_24_5_4_ssk, SnovaParameters.SNOVA_24_5_4_SSK);
        map37.put(BCObjectIdentifiers.snova_24_5_4_esk, SnovaParameters.SNOVA_24_5_4_ESK);
        map37.put(BCObjectIdentifiers.snova_24_5_4_shake_ssk, SnovaParameters.SNOVA_24_5_4_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_24_5_4_shake_esk, SnovaParameters.SNOVA_24_5_4_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_24_5_5_ssk, SnovaParameters.SNOVA_24_5_5_SSK);
        map37.put(BCObjectIdentifiers.snova_24_5_5_esk, SnovaParameters.SNOVA_24_5_5_ESK);
        map37.put(BCObjectIdentifiers.snova_24_5_5_shake_ssk, SnovaParameters.SNOVA_24_5_5_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_24_5_5_shake_esk, SnovaParameters.SNOVA_24_5_5_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_25_8_3_ssk, SnovaParameters.SNOVA_25_8_3_SSK);
        map37.put(BCObjectIdentifiers.snova_25_8_3_esk, SnovaParameters.SNOVA_25_8_3_ESK);
        map37.put(BCObjectIdentifiers.snova_25_8_3_shake_ssk, SnovaParameters.SNOVA_25_8_3_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_25_8_3_shake_esk, SnovaParameters.SNOVA_25_8_3_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_29_6_5_ssk, SnovaParameters.SNOVA_29_6_5_SSK);
        map37.put(BCObjectIdentifiers.snova_29_6_5_esk, SnovaParameters.SNOVA_29_6_5_ESK);
        map37.put(BCObjectIdentifiers.snova_29_6_5_shake_ssk, SnovaParameters.SNOVA_29_6_5_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_29_6_5_shake_esk, SnovaParameters.SNOVA_29_6_5_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_37_8_4_ssk, SnovaParameters.SNOVA_37_8_4_SSK);
        map37.put(BCObjectIdentifiers.snova_37_8_4_esk, SnovaParameters.SNOVA_37_8_4_ESK);
        map37.put(BCObjectIdentifiers.snova_37_8_4_shake_ssk, SnovaParameters.SNOVA_37_8_4_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_37_8_4_shake_esk, SnovaParameters.SNOVA_37_8_4_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_37_17_2_ssk, SnovaParameters.SNOVA_37_17_2_SSK);
        map37.put(BCObjectIdentifiers.snova_37_17_2_esk, SnovaParameters.SNOVA_37_17_2_ESK);
        map37.put(BCObjectIdentifiers.snova_37_17_2_shake_ssk, SnovaParameters.SNOVA_37_17_2_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_37_17_2_shake_esk, SnovaParameters.SNOVA_37_17_2_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_49_11_3_ssk, SnovaParameters.SNOVA_49_11_3_SSK);
        map37.put(BCObjectIdentifiers.snova_49_11_3_esk, SnovaParameters.SNOVA_49_11_3_ESK);
        map37.put(BCObjectIdentifiers.snova_49_11_3_shake_ssk, SnovaParameters.SNOVA_49_11_3_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_49_11_3_shake_esk, SnovaParameters.SNOVA_49_11_3_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_56_25_2_ssk, SnovaParameters.SNOVA_56_25_2_SSK);
        map37.put(BCObjectIdentifiers.snova_56_25_2_esk, SnovaParameters.SNOVA_56_25_2_ESK);
        map37.put(BCObjectIdentifiers.snova_56_25_2_shake_ssk, SnovaParameters.SNOVA_56_25_2_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_56_25_2_shake_esk, SnovaParameters.SNOVA_56_25_2_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_60_10_4_ssk, SnovaParameters.SNOVA_60_10_4_SSK);
        map37.put(BCObjectIdentifiers.snova_60_10_4_esk, SnovaParameters.SNOVA_60_10_4_ESK);
        map37.put(BCObjectIdentifiers.snova_60_10_4_shake_ssk, SnovaParameters.SNOVA_60_10_4_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_60_10_4_shake_esk, SnovaParameters.SNOVA_60_10_4_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_66_15_3_ssk, SnovaParameters.SNOVA_66_15_3_SSK);
        map37.put(BCObjectIdentifiers.snova_66_15_3_esk, SnovaParameters.SNOVA_66_15_3_ESK);
        map37.put(BCObjectIdentifiers.snova_66_15_3_shake_ssk, SnovaParameters.SNOVA_66_15_3_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_66_15_3_shake_esk, SnovaParameters.SNOVA_66_15_3_SHAKE_ESK);
        map37.put(BCObjectIdentifiers.snova_75_33_2_ssk, SnovaParameters.SNOVA_75_33_2_SSK);
        map37.put(BCObjectIdentifiers.snova_75_33_2_esk, SnovaParameters.SNOVA_75_33_2_ESK);
        map37.put(BCObjectIdentifiers.snova_75_33_2_shake_ssk, SnovaParameters.SNOVA_75_33_2_SHAKE_SSK);
        map37.put(BCObjectIdentifiers.snova_75_33_2_shake_esk, SnovaParameters.SNOVA_75_33_2_SHAKE_ESK);
    }

    Utils() {
    }

    static ASN1ObjectIdentifier bikeOidLookup(BIKEParameters bIKEParameters) {
        return (ASN1ObjectIdentifier) bikeOids.get(bIKEParameters);
    }

    static BIKEParameters bikeParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (BIKEParameters) bikeParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier dilithiumOidLookup(DilithiumParameters dilithiumParameters) {
        return (ASN1ObjectIdentifier) dilithiumOids.get(dilithiumParameters);
    }

    static DilithiumParameters dilithiumParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (DilithiumParameters) dilithiumParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier falconOidLookup(FalconParameters falconParameters) {
        return (ASN1ObjectIdentifier) falconOids.get(falconParameters);
    }

    static FalconParameters falconParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (FalconParameters) falconParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier frodoOidLookup(FrodoParameters frodoParameters) {
        return (ASN1ObjectIdentifier) frodoOids.get(frodoParameters);
    }

    static FrodoParameters frodoParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (FrodoParameters) frodoParams.get(aSN1ObjectIdentifier);
    }

    public static AlgorithmIdentifier getAlgorithmIdentifier(String str) {
        if (str.equals("SHA-1")) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
        }
        if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA224)) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224);
        }
        if (str.equals("SHA-256")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        }
        if (str.equals("SHA-384")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384);
        }
        if (str.equals("SHA-512")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    static Digest getDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return new SHA512Digest();
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_shake128)) {
            return new SHAKEDigest(128);
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256)) {
            return new SHAKEDigest(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
    }

    public static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) OIWObjectIdentifiers.idSHA1)) {
            return "SHA-1";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha224)) {
            return McElieceCCA2KeyGenParameterSpec.SHA224;
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return "SHA-256";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha384)) {
            return "SHA-384";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier hqcOidLookup(HQCParameters hQCParameters) {
        return (ASN1ObjectIdentifier) hqcOids.get(hQCParameters);
    }

    static HQCParameters hqcParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (HQCParameters) hqcParams.get(aSN1ObjectIdentifier);
    }

    private static boolean isRaw(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byteArrayInputStream.read();
        return readLen(byteArrayInputStream) != byteArrayInputStream.available();
    }

    static ASN1ObjectIdentifier mayoOidLookup(MayoParameters mayoParameters) {
        return (ASN1ObjectIdentifier) mayoOids.get(mayoParameters);
    }

    static MayoParameters mayoParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (MayoParameters) mayoParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier mcElieceOidLookup(CMCEParameters cMCEParameters) {
        return (ASN1ObjectIdentifier) mcElieceOids.get(cMCEParameters);
    }

    static CMCEParameters mcElieceParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (CMCEParameters) mcElieceParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier mldsaOidLookup(MLDSAParameters mLDSAParameters) {
        return (ASN1ObjectIdentifier) mldsaOids.get(mLDSAParameters);
    }

    static MLDSAParameters mldsaParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (MLDSAParameters) mldsaParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier mlkemOidLookup(MLKEMParameters mLKEMParameters) {
        return (ASN1ObjectIdentifier) mlkemOids.get(mLKEMParameters);
    }

    static MLKEMParameters mlkemParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (MLKEMParameters) mlkemParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier ntruOidLookup(NTRUParameters nTRUParameters) {
        return (ASN1ObjectIdentifier) ntruOids.get(nTRUParameters);
    }

    static NTRUParameters ntruParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (NTRUParameters) ntruParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier ntrulprimeOidLookup(NTRULPRimeParameters nTRULPRimeParameters) {
        return (ASN1ObjectIdentifier) ntruprimeOids.get(nTRULPRimeParameters);
    }

    static NTRULPRimeParameters ntrulprimeParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (NTRULPRimeParameters) ntruprimeParams.get(aSN1ObjectIdentifier);
    }

    static ASN1Primitive parseData(byte[] bArr) {
        if (isRaw(bArr)) {
            return null;
        }
        byte b = bArr[0];
        if (b == 48) {
            return ASN1Sequence.getInstance(bArr);
        }
        if (b == 4) {
            return ASN1OctetString.getInstance(bArr);
        }
        if ((b & 255) == 128) {
            return ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(bArr), false);
        }
        return null;
    }

    static ASN1OctetString parseOctetData(byte[] bArr) {
        if (isRaw(bArr) || bArr[0] != 4) {
            return null;
        }
        return ASN1OctetString.getInstance(bArr);
    }

    static ASN1ObjectIdentifier picnicOidLookup(PicnicParameters picnicParameters) {
        return (ASN1ObjectIdentifier) picnicOids.get(picnicParameters);
    }

    static PicnicParameters picnicParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (PicnicParameters) picnicParams.get(aSN1ObjectIdentifier);
    }

    static AlgorithmIdentifier qTeslaLookupAlgID(int i) {
        if (i == 5) {
            return AlgID_qTESLA_p_I;
        }
        if (i == 6) {
            return AlgID_qTESLA_p_III;
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }

    static int qTeslaLookupSecurityCategory(AlgorithmIdentifier algorithmIdentifier) {
        return ((Integer) categories.get(algorithmIdentifier.getAlgorithm())).intValue();
    }

    static ASN1ObjectIdentifier rainbowOidLookup(RainbowParameters rainbowParameters) {
        return (ASN1ObjectIdentifier) rainbowOids.get(rainbowParameters);
    }

    static RainbowParameters rainbowParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (RainbowParameters) rainbowParams.get(aSN1ObjectIdentifier);
    }

    static int readLen(ByteArrayInputStream byteArrayInputStream) {
        int i = byteArrayInputStream.read();
        if (i < 0) {
            return -1;
        }
        int i2 = i & 127;
        if (i != i2) {
            i = 0;
            while (true) {
                int i3 = i2 - 1;
                if (i2 == 0) {
                    break;
                }
                i = (i << 8) + byteArrayInputStream.read();
                i2 = i3;
            }
        }
        return i;
    }

    static ASN1ObjectIdentifier saberOidLookup(SABERParameters sABERParameters) {
        return (ASN1ObjectIdentifier) saberOids.get(sABERParameters);
    }

    static SABERParameters saberParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SABERParameters) saberParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier slhdsaOidLookup(SLHDSAParameters sLHDSAParameters) {
        return (ASN1ObjectIdentifier) slhdsaOids.get(sLHDSAParameters);
    }

    static SLHDSAParameters slhdsaParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SLHDSAParameters) slhdsaParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier snovaOidLookup(SnovaParameters snovaParameters) {
        return (ASN1ObjectIdentifier) snovaOids.get(snovaParameters);
    }

    static SnovaParameters snovaParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SnovaParameters) snovaParams.get(aSN1ObjectIdentifier);
    }

    static ASN1ObjectIdentifier sntruprimeOidLookup(SNTRUPrimeParameters sNTRUPrimeParameters) {
        return (ASN1ObjectIdentifier) sntruprimeOids.get(sNTRUPrimeParameters);
    }

    static SNTRUPrimeParameters sntruprimeParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SNTRUPrimeParameters) sntruprimeParams.get(aSN1ObjectIdentifier);
    }

    static AlgorithmIdentifier sphincs256LookupTreeAlgID(String str) {
        if (str.equals("SHA3-256")) {
            return SPHINCS_SHA3_256;
        }
        if (str.equals(SPHINCSKeyParameters.SHA512_256)) {
            return SPHINCS_SHA512_256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }

    static String sphincs256LookupTreeAlgName(SPHINCS256KeyParams sPHINCS256KeyParams) {
        AlgorithmIdentifier treeDigest = sPHINCS256KeyParams.getTreeDigest();
        if (treeDigest.getAlgorithm().equals((ASN1Primitive) SPHINCS_SHA3_256.getAlgorithm())) {
            return "SHA3-256";
        }
        if (treeDigest.getAlgorithm().equals((ASN1Primitive) SPHINCS_SHA512_256.getAlgorithm())) {
            return SPHINCSKeyParameters.SHA512_256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + treeDigest.getAlgorithm());
    }

    static ASN1ObjectIdentifier sphincsPlusOidLookup(SPHINCSPlusParameters sPHINCSPlusParameters) {
        return (ASN1ObjectIdentifier) sphincsPlusOids.get(sPHINCSPlusParameters);
    }

    static SPHINCSPlusParameters sphincsPlusParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SPHINCSPlusParameters) sphincsPlusParams.get(aSN1ObjectIdentifier);
    }

    static AlgorithmIdentifier xmssLookupTreeAlgID(String str) {
        if (str.equals("SHA-256")) {
            return XMSS_SHA256;
        }
        if (str.equals("SHA-512")) {
            return XMSS_SHA512;
        }
        if (str.equals("SHAKE128")) {
            return XMSS_SHAKE128;
        }
        if (str.equals("SHAKE256")) {
            return XMSS_SHAKE256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }
}
