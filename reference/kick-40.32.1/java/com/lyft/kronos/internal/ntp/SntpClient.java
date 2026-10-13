package com.lyft.kronos.internal.ntp;

import com.google.common.base.Ascii;
import com.lyft.kronos.Clock;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public class SntpClient {
    private static final long MAX_BOOT_MISMATCH_MS = 1000;
    private static final int NTP_LEAP_NOSYNC = 3;
    private static final int NTP_MODE_BROADCAST = 5;
    private static final int NTP_MODE_CLIENT = 3;
    private static final int NTP_MODE_SERVER = 4;
    private static final int NTP_PACKET_SIZE = 48;
    private static final int NTP_PORT = 123;
    private static final int NTP_STRATUM_DEATH = 0;
    private static final int NTP_STRATUM_MAX = 15;
    private static final int NTP_VERSION = 3;
    private static final long OFFSET_1900_TO_1970 = 2208988800L;
    private static final int ORIGINATE_TIME_OFFSET = 24;
    private static final int RECEIVE_TIME_OFFSET = 32;
    private static final int TRANSMIT_TIME_OFFSET = 40;
    private final DatagramFactory datagramFactory;
    private final Clock deviceClock;
    private final DnsResolver dnsResolver;

    private static class InvalidServerReplyException extends IOException {
        public InvalidServerReplyException(String str) {
            super(str);
        }
    }

    public SntpClient(Clock clock, DnsResolver dnsResolver, DatagramFactory datagramFactory) {
        this.deviceClock = clock;
        this.dnsResolver = dnsResolver;
        this.datagramFactory = datagramFactory;
    }

    public Response requestTime(String str, Long l) throws Throwable {
        DatagramSocket datagramSocketCreateSocket = null;
        try {
            InetAddress inetAddressResolve = this.dnsResolver.resolve(str);
            datagramSocketCreateSocket = this.datagramFactory.createSocket();
            try {
                datagramSocketCreateSocket.setSoTimeout(l.intValue());
                byte[] bArr = new byte[48];
                DatagramPacket datagramPacketCreatePacket = this.datagramFactory.createPacket(bArr, inetAddressResolve, NTP_PORT);
                bArr[0] = Ascii.ESC;
                long currentTimeMs = this.deviceClock.getCurrentTimeMs();
                long elapsedTimeMs = this.deviceClock.getElapsedTimeMs();
                writeTimeStamp(bArr, 40, currentTimeMs);
                datagramSocketCreateSocket.send(datagramPacketCreatePacket);
                byte[] bArrCopyOf = Arrays.copyOf(bArr, 48);
                datagramSocketCreateSocket.receive(this.datagramFactory.createPacket(bArrCopyOf));
                long elapsedTimeMs2 = this.deviceClock.getElapsedTimeMs();
                long j = currentTimeMs + (elapsedTimeMs2 - elapsedTimeMs);
                byte b = bArrCopyOf[0];
                byte b2 = (byte) ((b >> 6) & 3);
                byte b3 = (byte) (b & 7);
                int i = bArrCopyOf[1] & 255;
                long timeStamp = readTimeStamp(bArrCopyOf, 24);
                long timeStamp2 = readTimeStamp(bArrCopyOf, 32);
                try {
                    long timeStamp3 = readTimeStamp(bArrCopyOf, 40);
                    checkValidServerReply(b2, b3, i, timeStamp3);
                    Response response = new Response(j, elapsedTimeMs2, ((timeStamp2 - timeStamp) + (timeStamp3 - j)) / 2, this.deviceClock);
                    if (datagramSocketCreateSocket != null) {
                        datagramSocketCreateSocket.close();
                    }
                    return response;
                } catch (Throwable th) {
                    th = th;
                    datagramSocketCreateSocket = datagramSocketCreateSocket;
                    if (datagramSocketCreateSocket != null) {
                        datagramSocketCreateSocket.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static void checkValidServerReply(byte b, byte b2, int i, long j) throws InvalidServerReplyException {
        if (b == 3) {
            throw new InvalidServerReplyException("unsynchronized server");
        }
        if (b2 != 4 && b2 != 5) {
            throw new InvalidServerReplyException("untrusted mode: " + ((int) b2));
        }
        if (i == 0 || i > 15) {
            throw new InvalidServerReplyException("untrusted stratum: " + i);
        }
        if (j == 0) {
            throw new InvalidServerReplyException("zero transmitTime");
        }
    }

    private static long read32(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }

    static long readTimeStamp(byte[] bArr, int i) {
        return ((read32(bArr, i) - OFFSET_1900_TO_1970) * 1000) + ((read32(bArr, i + 4) * 1000) / 4294967296L);
    }

    private static void writeTimeStamp(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + OFFSET_1900_TO_1970;
        bArr[i] = (byte) (j4 >> 24);
        bArr[i + 1] = (byte) (j4 >> 16);
        bArr[i + 2] = (byte) (j4 >> 8);
        bArr[i + 3] = (byte) j4;
        long j5 = (j3 * 4294967296L) / 1000;
        bArr[i + 4] = (byte) (j5 >> 24);
        bArr[i + 5] = (byte) (j5 >> 16);
        bArr[i + 6] = (byte) (j5 >> 8);
        bArr[i + 7] = (byte) (Math.random() * 255.0d);
    }

    public static final class Response {
        private final Clock deviceClock;
        private final long deviceCurrentTimestampMs;
        private final long deviceElapsedTimestampMs;
        private final long offsetMs;

        Response(long j, long j2, long j3, Clock clock) {
            this.deviceCurrentTimestampMs = j;
            this.deviceElapsedTimestampMs = j2;
            this.offsetMs = j3;
            this.deviceClock = clock;
        }

        long getDeviceCurrentTimestampMs() {
            return this.deviceCurrentTimestampMs;
        }

        long getDeviceElapsedTimestampMs() {
            return this.deviceElapsedTimestampMs;
        }

        public long getCurrentTimeMs() {
            return this.deviceCurrentTimestampMs + this.offsetMs + getResponseAge();
        }

        public long getOffsetMs() {
            return this.offsetMs;
        }

        public long getResponseAge() {
            return this.deviceClock.getElapsedTimeMs() - this.deviceElapsedTimestampMs;
        }

        boolean isFromSameBoot() {
            return Math.abs((this.deviceCurrentTimestampMs - this.deviceElapsedTimestampMs) - (this.deviceClock.getCurrentTimeMs() - this.deviceClock.getElapsedTimeMs())) < 1000;
        }
    }
}
