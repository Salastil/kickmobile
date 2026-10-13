package org.bouncycastle.crypto.generators;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.google.android.gms.cast.MediaError;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.constraints.ConstraintUtils;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.math.Primes;
import org.bouncycastle.util.BigIntegers;
import org.java_websocket.WebSocketImpl;

/* JADX INFO: loaded from: classes10.dex */
public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NaccacheSternKeyGenerationParameters param;
    private static int[] smallPrimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 113, 127, WebmConstants.MkvEbmlElement.TRACK_TYPE, 137, 139, 149, 151, 157, WebmConstants.MkvEbmlElement.SIMPLE_BLOCK, 167, 173, WebmConstants.MkvEbmlElement.CUE_TIME, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 191, 193, 197, 199, Primes.SMALL_FACTOR_LIMIT, 223, 227, 229, 233, 239, WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION, WebmConstants.MkvEbmlElement.REFERENCE_BLOCK, 257, GlobalMediaRouter.CallbackHandler.MSG_ROUTE_UNSELECTED, 269, 271, 277, 281, 283, 293, 307, 311, 313, TypedValues.Attributes.TYPE_EASING, MediaError.DetailedErrorCode.SMOOTH_NETWORK, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, MediaError.DetailedErrorCode.SMOOTH_MANIFEST, 433, 439, WebSocketImpl.DEFAULT_WSS_PORT, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, TypedValues.Position.TYPE_PATH_MOTION_ARC, 521, 523, 541, 547, 557};
    private static final BigInteger ONE = BigInteger.valueOf(1);

    private static Vector findFirstPrimes(int i) {
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 != i; i2++) {
            vector.addElement(BigInteger.valueOf(smallPrimes[i2]));
        }
        return vector;
    }

    private static BigInteger generatePrime(int i, int i2, SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomPrime;
        do {
            bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(i, i2, secureRandom);
        } while (bigIntegerCreateRandomPrime.bitLength() != i);
        return bigIntegerCreateRandomPrime;
    }

    private static int getInt(SecureRandom secureRandom, int i) {
        int iNextInt;
        int i2;
        if (((-i) & i) == i) {
            return (int) ((((long) i) * ((long) (secureRandom.nextInt() & Integer.MAX_VALUE))) >> 31);
        }
        do {
            iNextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i2 = iNextInt % i;
        } while ((iNextInt - i2) + (i - 1) < 0);
        return i2;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            vector3.addElement(vector.elementAt(i));
        }
        vector2.addElement(vector3.elementAt(0));
        while (true) {
            vector3.removeElementAt(0);
            if (vector3.size() == 0) {
                return vector2;
            }
            vector2.insertElementAt(vector3.elementAt(0), getInt(secureRandom, vector2.size() + 1));
        }
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger bigIntegerGeneratePrime;
        BigInteger bigIntegerAdd;
        BigInteger bigIntegerGeneratePrime2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigIntegerAdd2;
        boolean z;
        BigInteger bigIntegerMultiply;
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        long j;
        BigInteger bigIntegerMod;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        PrintStream printStream;
        StringBuilder sb;
        int i;
        BigInteger bigIntegerCreateRandomPrime;
        SecureRandom secureRandom;
        int i2;
        BigInteger bigInteger7;
        BigInteger bigInteger8;
        int i3;
        int strength = this.param.getStrength();
        SecureRandom random = this.param.getRandom();
        int certainty = this.param.getCertainty();
        boolean zIsDebug = this.param.isDebug();
        if (zIsDebug) {
            System.out.println("Fetching first " + this.param.getCntSmallPrimes() + " primes.");
        }
        Vector vectorPermuteList = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), random);
        BigInteger bigIntegerMultiply2 = ONE;
        BigInteger bigIntegerMultiply3 = bigIntegerMultiply2;
        for (int i4 = 0; i4 < vectorPermuteList.size() / 2; i4++) {
            bigIntegerMultiply3 = bigIntegerMultiply3.multiply((BigInteger) vectorPermuteList.elementAt(i4));
        }
        for (int size = vectorPermuteList.size() / 2; size < vectorPermuteList.size(); size++) {
            bigIntegerMultiply2 = bigIntegerMultiply2.multiply((BigInteger) vectorPermuteList.elementAt(size));
        }
        BigInteger bigIntegerMultiply4 = bigIntegerMultiply3.multiply(bigIntegerMultiply2);
        int iBitLength = (((strength - bigIntegerMultiply4.bitLength()) - 48) / 2) + 1;
        BigInteger bigIntegerGeneratePrime3 = generatePrime(iBitLength, certainty, random);
        BigInteger bigIntegerGeneratePrime4 = generatePrime(iBitLength, certainty, random);
        if (zIsDebug) {
            System.out.println("generating p and q");
        }
        BigInteger bigIntegerShiftLeft = bigIntegerGeneratePrime3.multiply(bigIntegerMultiply3).shiftLeft(1);
        BigInteger bigIntegerShiftLeft2 = bigIntegerGeneratePrime4.multiply(bigIntegerMultiply2).shiftLeft(1);
        long j2 = 0;
        while (true) {
            j2++;
            int i5 = 24;
            bigIntegerGeneratePrime = generatePrime(24, certainty, random);
            bigIntegerAdd = bigIntegerGeneratePrime.multiply(bigIntegerShiftLeft).add(ONE);
            if (bigIntegerAdd.isProbablePrime(certainty)) {
                while (true) {
                    bigIntegerGeneratePrime2 = generatePrime(i5, certainty, random);
                    if (!bigIntegerGeneratePrime.equals(bigIntegerGeneratePrime2)) {
                        BigInteger bigIntegerMultiply5 = bigIntegerGeneratePrime2.multiply(bigIntegerShiftLeft2);
                        bigInteger = bigIntegerShiftLeft2;
                        bigInteger2 = ONE;
                        bigIntegerAdd2 = bigIntegerMultiply5.add(bigInteger2);
                        if (bigIntegerAdd2.isProbablePrime(certainty)) {
                            break;
                        }
                        bigIntegerShiftLeft2 = bigInteger;
                        i5 = 24;
                    }
                }
                z = zIsDebug;
                if (BigIntegers.modOddIsCoprime(bigIntegerGeneratePrime.multiply(bigIntegerGeneratePrime2), bigIntegerMultiply4)) {
                    BigInteger bigInteger9 = bigIntegerShiftLeft;
                    bigIntegerMultiply = bigIntegerAdd.multiply(bigIntegerAdd2);
                    bigInteger3 = bigInteger9;
                    if (bigIntegerMultiply.bitLength() >= strength) {
                        break;
                    }
                    int i6 = strength;
                    random = random;
                    certainty = certainty;
                    bigInteger7 = bigIntegerGeneratePrime3;
                    bigInteger8 = bigIntegerGeneratePrime4;
                    if (z) {
                        PrintStream printStream2 = System.out;
                        StringBuilder sb2 = new StringBuilder("key size too small. Should be ");
                        i3 = i6;
                        sb2.append(i3);
                        sb2.append(" but is actually ");
                        sb2.append(bigIntegerAdd.multiply(bigIntegerAdd2).bitLength());
                        printStream2.println(sb2.toString());
                    } else {
                        i3 = i6;
                    }
                }
                strength = i3;
                bigIntegerGeneratePrime3 = bigInteger7;
                bigIntegerGeneratePrime4 = bigInteger8;
                bigIntegerShiftLeft2 = bigInteger;
                zIsDebug = z;
                bigIntegerShiftLeft = bigInteger3;
                random = random;
                certainty = certainty;
            } else {
                bigInteger = bigIntegerShiftLeft2;
                z = zIsDebug;
            }
            bigInteger3 = bigIntegerShiftLeft;
            bigInteger8 = bigIntegerGeneratePrime4;
            bigInteger7 = bigIntegerGeneratePrime3;
            i3 = strength;
            strength = i3;
            bigIntegerGeneratePrime3 = bigInteger7;
            bigIntegerGeneratePrime4 = bigInteger8;
            bigIntegerShiftLeft2 = bigInteger;
            zIsDebug = z;
            bigIntegerShiftLeft = bigInteger3;
            random = random;
            certainty = certainty;
        }
        BigInteger bigInteger10 = bigIntegerGeneratePrime4;
        if (z) {
            System.out.println("needed " + j2 + " tries to generate p and q.");
        }
        BigInteger bigIntegerMultiply6 = bigIntegerAdd.subtract(bigInteger2).multiply(bigIntegerAdd2.subtract(bigInteger2));
        if (z) {
            System.out.println("generating g");
        }
        long j3 = 0;
        while (true) {
            Vector vector = new Vector();
            bigInteger4 = bigIntegerAdd2;
            j = j3;
            int i7 = 0;
            while (i7 != vectorPermuteList.size()) {
                BigInteger bigIntegerDivide = bigIntegerMultiply6.divide((BigInteger) vectorPermuteList.elementAt(i7));
                while (true) {
                    j++;
                    i = i7;
                    bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(strength, certainty, random);
                    secureRandom = random;
                    i2 = certainty;
                    if (bigIntegerCreateRandomPrime.modPow(bigIntegerDivide, bigIntegerMultiply).equals(ONE)) {
                        i7 = i;
                        random = secureRandom;
                        certainty = i2;
                    }
                }
                vector.addElement(bigIntegerCreateRandomPrime);
                i7 = i + 1;
                random = secureRandom;
                certainty = i2;
            }
            SecureRandom secureRandom2 = random;
            int i8 = certainty;
            bigIntegerMod = ONE;
            for (int i9 = 0; i9 < vectorPermuteList.size(); i9++) {
                bigIntegerMod = bigIntegerMod.multiply(((BigInteger) vector.elementAt(i9)).modPow(bigIntegerMultiply4.divide((BigInteger) vectorPermuteList.elementAt(i9)), bigIntegerMultiply)).mod(bigIntegerMultiply);
            }
            int i10 = 0;
            while (true) {
                if (i10 >= vectorPermuteList.size()) {
                    BigInteger bigIntegerModPow = bigIntegerMod.modPow(bigIntegerMultiply6.divide(BigInteger.valueOf(4L)), bigIntegerMultiply);
                    BigInteger bigInteger11 = ONE;
                    if (!bigIntegerModPow.equals(bigInteger11)) {
                        if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigIntegerGeneratePrime), bigIntegerMultiply).equals(bigInteger11)) {
                            if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigIntegerGeneratePrime2), bigIntegerMultiply).equals(bigInteger11)) {
                                bigInteger5 = bigIntegerGeneratePrime3;
                                if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger5), bigIntegerMultiply).equals(bigInteger11)) {
                                    bigInteger6 = bigInteger10;
                                    if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger6), bigIntegerMultiply).equals(bigInteger11)) {
                                        break;
                                    }
                                    if (z) {
                                        System.out.println("g has order phi(n)/b\n g: " + bigIntegerMod);
                                    }
                                } else {
                                    if (z) {
                                        System.out.println("g has order phi(n)/a\n g: " + bigIntegerMod);
                                    }
                                    bigInteger6 = bigInteger10;
                                }
                            } else if (z) {
                                printStream = System.out;
                                sb = new StringBuilder("g has order phi(n)/q'\n g: ");
                                sb.append(bigIntegerMod);
                                printStream.println(sb.toString());
                            }
                        } else if (z) {
                            printStream = System.out;
                            sb = new StringBuilder("g has order phi(n)/p'\n g: ");
                            sb.append(bigIntegerMod);
                            printStream.println(sb.toString());
                        }
                    } else if (z) {
                        printStream = System.out;
                        sb = new StringBuilder("g has order phi(n)/4\n g:");
                        sb.append(bigIntegerMod);
                        printStream.println(sb.toString());
                    }
                    bigIntegerGeneratePrime3 = bigInteger5;
                    j3 = j;
                    strength = strength;
                    random = secureRandom2;
                    certainty = i8;
                    bigInteger10 = bigInteger6;
                    bigIntegerAdd2 = bigInteger4;
                } else if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide((BigInteger) vectorPermuteList.elementAt(i10)), bigIntegerMultiply).equals(ONE)) {
                    i10++;
                } else if (z) {
                    System.out.println("g has order phi(n)/" + vectorPermuteList.elementAt(i10) + "\n g: " + bigIntegerMod);
                }
                bigInteger6 = bigInteger10;
                bigInteger5 = bigIntegerGeneratePrime3;
                bigIntegerGeneratePrime3 = bigInteger5;
                j3 = j;
                strength = strength;
                random = secureRandom2;
                certainty = i8;
                bigInteger10 = bigInteger6;
                bigIntegerAdd2 = bigInteger4;
            }
        }
        if (z) {
            System.out.println("needed " + j + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            System.out.println("smallPrimes: " + vectorPermuteList);
            System.out.println("sigma:...... " + bigIntegerMultiply4 + " (" + bigIntegerMultiply4.bitLength() + " bits)");
            PrintStream printStream3 = System.out;
            StringBuilder sb3 = new StringBuilder("a:.......... ");
            sb3.append(bigInteger5);
            printStream3.println(sb3.toString());
            System.out.println("b:.......... " + bigInteger6);
            System.out.println("p':......... " + bigIntegerGeneratePrime);
            System.out.println("q':......... " + bigIntegerGeneratePrime2);
            System.out.println("p:.......... " + bigIntegerAdd);
            System.out.println("q:.......... " + bigInteger4);
            System.out.println("n:.......... " + bigIntegerMultiply);
            System.out.println("phi(n):..... " + bigIntegerMultiply6);
            System.out.println("g:.......... " + bigIntegerMod);
            System.out.println();
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NaccacheSternKeyParameters(false, bigIntegerMod, bigIntegerMultiply, bigIntegerMultiply4.bitLength()), (AsymmetricKeyParameter) new NaccacheSternPrivateKeyParameters(bigIntegerMod, bigIntegerMultiply, bigIntegerMultiply4.bitLength(), vectorPermuteList, bigIntegerMultiply6));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("NaccacheStern KeyGen", ConstraintUtils.bitsOfSecurityForFF(keyGenerationParameters.getStrength()), keyGenerationParameters, CryptoServicePurpose.KEYGEN));
    }
}
