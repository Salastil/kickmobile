package com.google.re2j;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
class Machine {
    private int[] matchcap;
    private boolean matched;
    private int ncap;
    Machine next;
    private Thread[] pool;
    private int poolSize;
    private final Prog prog;
    private final Queue q0;
    private final Queue q1;
    private RE2 re2;

    private static class Thread {
        int[] cap;
        Inst inst;

        Thread(int i) {
            this.cap = new int[i];
        }
    }

    private static class Queue {
        final int[] densePcs;
        final Thread[] denseThreads;
        int size;
        final int[] sparse;

        Queue(int i) {
            this.sparse = new int[i];
            this.densePcs = new int[i];
            this.denseThreads = new Thread[i];
        }

        boolean contains(int i) {
            int i2 = this.sparse[i];
            return i2 < this.size && this.densePcs[i2] == i;
        }

        boolean isEmpty() {
            return this.size == 0;
        }

        int add(int i) {
            int i2 = this.size;
            this.size = i2 + 1;
            this.sparse[i] = i2;
            this.denseThreads[i2] = null;
            this.densePcs[i2] = i;
            return i2;
        }

        void clear() {
            this.size = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < this.size; i++) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(this.densePcs[i]);
            }
            sb.append(AbstractJsonLexerKt.END_OBJ);
            return sb.toString();
        }
    }

    Machine(RE2 re2) {
        this.pool = new Thread[10];
        Prog prog = re2.prog;
        this.prog = prog;
        this.re2 = re2;
        this.q0 = new Queue(prog.numInst());
        this.q1 = new Queue(prog.numInst());
        this.matchcap = new int[prog.numCap >= 2 ? prog.numCap : 2];
    }

    Machine(Machine machine) {
        this.pool = new Thread[10];
        this.re2 = machine.re2;
        this.prog = machine.prog;
        this.q0 = machine.q0;
        this.q1 = machine.q1;
        this.pool = machine.pool;
        this.poolSize = machine.poolSize;
        this.matched = machine.matched;
        this.matchcap = machine.matchcap;
        this.ncap = machine.ncap;
    }

    void init(int i) {
        this.ncap = i;
        if (i > this.matchcap.length) {
            initNewCap(i);
        } else {
            resetCap(i);
        }
    }

    private void resetCap(int i) {
        for (int i2 = 0; i2 < this.poolSize; i2++) {
            Arrays.fill(this.pool[i2].cap, 0, i, 0);
        }
    }

    private void initNewCap(int i) {
        for (int i2 = 0; i2 < this.poolSize; i2++) {
            this.pool[i2].cap = new int[i];
        }
        this.matchcap = new int[i];
    }

    int[] submatches() {
        int i = this.ncap;
        if (i == 0) {
            return Utils.EMPTY_INTS;
        }
        return Arrays.copyOf(this.matchcap, i);
    }

    private Thread alloc(Inst inst) {
        Thread thread;
        int i = this.poolSize;
        if (i > 0) {
            int i2 = i - 1;
            this.poolSize = i2;
            thread = this.pool[i2];
        } else {
            thread = new Thread(this.matchcap.length);
        }
        thread.inst = inst;
        return thread;
    }

    private void free(Queue queue) {
        free(queue, 0);
    }

    private void free(Queue queue, int i) {
        int i2 = this.poolSize + (queue.size - i);
        Thread[] threadArr = this.pool;
        if (threadArr.length < i2) {
            this.pool = (Thread[]) Arrays.copyOf(threadArr, Math.max(threadArr.length * 2, i2));
        }
        while (i < queue.size) {
            Thread thread = queue.denseThreads[i];
            if (thread != null) {
                Thread[] threadArr2 = this.pool;
                int i3 = this.poolSize;
                threadArr2[i3] = thread;
                this.poolSize = i3 + 1;
            }
            i++;
        }
        queue.clear();
    }

    private void free(Thread thread) {
        Thread[] threadArr = this.pool;
        if (threadArr.length <= this.poolSize) {
            this.pool = (Thread[]) Arrays.copyOf(threadArr, threadArr.length * 2);
        }
        Thread[] threadArr2 = this.pool;
        int i = this.poolSize;
        threadArr2[i] = thread;
        this.poolSize = i + 1;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f9  */
    boolean match(MachineInput machineInput, int i, int i2) {
        int i3;
        int i4;
        int iContext;
        int i5;
        int i6;
        int i7;
        int i8;
        Queue queue;
        int i9;
        int i10;
        int iContext2;
        boolean z;
        int i11;
        Machine machine = this;
        int i12 = i2;
        int i13 = machine.re2.cond;
        if (i13 == -1) {
            return false;
        }
        if ((i12 == 1 || i12 == 2) && i != 0) {
            return false;
        }
        machine.matched = false;
        Arrays.fill(machine.matchcap, 0, machine.prog.numCap, -1);
        Queue queue2 = machine.q0;
        Queue queue3 = machine.q1;
        int iStep = machineInput.step(i);
        int i14 = iStep >> 3;
        int i15 = iStep & 7;
        if (iStep != -8) {
            int iStep2 = machineInput.step(i + i15);
            i4 = iStep2 >> 3;
            i3 = iStep2 & 7;
        } else {
            i3 = 0;
            i4 = -1;
        }
        if (i == 0) {
            iContext = Utils.emptyOpContext(-1, i14);
        } else {
            iContext = machineInput.context(i);
        }
        int i16 = iContext;
        Queue queue4 = queue3;
        Queue queue5 = queue2;
        int i17 = i;
        while (true) {
            if (queue5.isEmpty()) {
                if (((i13 & 4) != 0 && i17 != 0) || machine.matched) {
                    break;
                }
                if (!machine.re2.prefix.isEmpty() && i4 != machine.re2.prefixRune && machineInput.canCheckPrefix()) {
                    int iIndex = machineInput.index(machine.re2, i17);
                    if (iIndex < 0) {
                        break;
                    }
                    i17 += iIndex;
                    int iStep3 = machineInput.step(i17);
                    i14 = iStep3 >> 3;
                    i15 = iStep3 & 7;
                    int iStep4 = machineInput.step(i17 + i15);
                    i4 = iStep4 >> 3;
                    i3 = iStep4 & 7;
                }
                i5 = i3;
                int i18 = i14;
                i6 = i15;
                i7 = i4;
                i8 = i17;
                if (machine.matched) {
                    queue = queue5;
                    i9 = i7;
                } else {
                    queue = queue5;
                    i9 = i7;
                }
                i10 = i8 + i6;
                iContext2 = machineInput.context(i10);
                queue5 = queue4;
                if (i8 == machineInput.endPos()) {
                    z = true;
                } else {
                    z = false;
                }
                machine = this;
                machine.step(queue, queue5, i8, i10, i18, iContext2, i12, z);
                if (i6 != 0) {
                    if (i9 != -1) {
                        int iStep5 = machineInput.step(i10 + i5);
                        i11 = iStep5 >> 3;
                        i3 = iStep5 & 7;
                    } else {
                        i11 = i9;
                        i3 = i5;
                    }
                    i12 = i2;
                    queue4 = queue;
                    i17 = i10;
                    i14 = i9;
                    i16 = iContext2;
                    i4 = i11;
                    i15 = i5;
                }
            } else {
                i5 = i3;
                int i19 = i14;
                i6 = i15;
                i7 = i4;
                i8 = i17;
                if (machine.matched || !(i8 == 0 || i12 == 0)) {
                    queue = queue5;
                    i9 = i7;
                } else {
                    if (machine.ncap > 0) {
                        machine.matchcap[0] = i8;
                    }
                    queue = queue5;
                    int i20 = i16;
                    i9 = i7;
                    machine.add(queue, machine.prog.start, i8, machine.matchcap, i20, null);
                }
                i10 = i8 + i6;
                iContext2 = machineInput.context(i10);
                queue5 = queue4;
                if (i8 == machineInput.endPos()) {
                    z = true;
                } else {
                    z = false;
                }
                machine = this;
                machine.step(queue, queue5, i8, i10, i19, iContext2, i12, z);
                if (i6 != 0 && (machine.ncap != 0 || !machine.matched)) {
                    if (i9 != -1) {
                        int iStep6 = machineInput.step(i10 + i5);
                        i11 = iStep6 >> 3;
                        i3 = iStep6 & 7;
                    } else {
                        i11 = i9;
                        i3 = i5;
                    }
                    i12 = i2;
                    queue4 = queue;
                    i17 = i10;
                    i14 = i9;
                    i16 = iContext2;
                    i4 = i11;
                    i15 = i5;
                }
            }
            machine.free(queue5);
            return machine.matched;
        }
        queue5 = queue4;
        machine.free(queue5);
        return machine.matched;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e A[SYNTHETIC] */
    private void step(Queue queue, Queue queue2, int i, int i2, int i3, int i4, int i5, boolean z) {
        boolean z2 = this.re2.longest;
        for (int i6 = 0; i6 < queue.size; i6++) {
            Thread threadAdd = queue.denseThreads[i6];
            if (threadAdd != null) {
                if (z2 && this.matched && this.ncap > 0 && this.matchcap[0] < threadAdd.cap[0]) {
                    free(threadAdd);
                } else {
                    Inst inst = threadAdd.inst;
                    boolean zMatchRune = true;
                    switch (inst.op) {
                        case 6:
                            if (i5 != 2 || z) {
                                if (this.ncap > 0 && (!z2 || !this.matched || this.matchcap[1] < i)) {
                                    threadAdd.cap[1] = i;
                                    System.arraycopy(threadAdd.cap, 0, this.matchcap, 0, this.ncap);
                                }
                                if (!z2) {
                                    free(queue, i6 + 1);
                                }
                                this.matched = true;
                            }
                            zMatchRune = false;
                            if (zMatchRune) {
                                threadAdd = add(queue2, inst.out, i2, threadAdd.cap, i4, threadAdd);
                            }
                            if (threadAdd != null) {
                                free(threadAdd);
                                queue.denseThreads[i6] = null;
                            }
                            break;
                        case 7:
                        default:
                            throw new IllegalStateException("bad inst");
                        case 8:
                            zMatchRune = inst.matchRune(i3);
                            if (zMatchRune) {
                                threadAdd = add(queue2, inst.out, i2, threadAdd.cap, i4, threadAdd);
                            }
                            if (threadAdd != null) {
                                free(threadAdd);
                                queue.denseThreads[i6] = null;
                            }
                            break;
                        case 9:
                            if (i3 != inst.runes[0]) {
                                zMatchRune = false;
                            }
                            if (zMatchRune) {
                                threadAdd = add(queue2, inst.out, i2, threadAdd.cap, i4, threadAdd);
                            }
                            if (threadAdd != null) {
                                free(threadAdd);
                                queue.denseThreads[i6] = null;
                            }
                            break;
                        case 10:
                            if (zMatchRune) {
                                threadAdd = add(queue2, inst.out, i2, threadAdd.cap, i4, threadAdd);
                            }
                            if (threadAdd != null) {
                                free(threadAdd);
                                queue.denseThreads[i6] = null;
                            }
                            break;
                        case 11:
                            if (i3 == 10) {
                                zMatchRune = false;
                            }
                            if (zMatchRune) {
                                threadAdd = add(queue2, inst.out, i2, threadAdd.cap, i4, threadAdd);
                            }
                            if (threadAdd != null) {
                                free(threadAdd);
                                queue.denseThreads[i6] = null;
                            }
                            break;
                    }
                }
            }
        }
        queue.clear();
    }

    private Thread add(Queue queue, int i, int i2, int[] iArr, int i3, Thread thread) {
        Thread threadAlloc;
        if (i == 0 || queue.contains(i)) {
            return thread;
        }
        int iAdd = queue.add(i);
        Inst inst = this.prog.inst[i];
        switch (inst.op) {
            case 1:
            case 2:
                return add(queue, inst.arg, i2, iArr, i3, add(queue, inst.out, i2, iArr, i3, thread));
            case 3:
                if (inst.arg < this.ncap) {
                    int i4 = iArr[inst.arg];
                    iArr[inst.arg] = i2;
                    add(queue, inst.out, i2, iArr, i3, null);
                    iArr[inst.arg] = i4;
                    return thread;
                }
                return add(queue, inst.out, i2, iArr, i3, thread);
            case 4:
                return (inst.arg & (~i3)) == 0 ? add(queue, inst.out, i2, iArr, i3, thread) : thread;
            case 5:
                return thread;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
                if (thread == null) {
                    threadAlloc = alloc(inst);
                } else {
                    thread.inst = inst;
                    threadAlloc = thread;
                }
                if (this.ncap > 0 && threadAlloc.cap != iArr) {
                    System.arraycopy(iArr, 0, threadAlloc.cap, 0, this.ncap);
                }
                queue.denseThreads[iAdd] = threadAlloc;
                return null;
            case 7:
                return add(queue, inst.out, i2, iArr, i3, thread);
            default:
                throw new IllegalStateException("unhandled");
        }
    }
}
