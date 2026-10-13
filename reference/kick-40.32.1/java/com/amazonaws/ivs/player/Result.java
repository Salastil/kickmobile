package com.amazonaws.ivs.player;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
abstract class Result<Err, R> {
    static /* synthetic */ Object lambda$getOr$0(Object obj, Object obj2) {
        return obj;
    }

    abstract <U> Result<Err, U> flatMap(Function<R, Result<Err, U>> function);

    abstract <U> U fold(Function<Err, U> function, Function<R, U> function2);

    abstract Result<Err, R> ifError(Consumer<Err> consumer);

    abstract Result<Err, R> ifOk(Consumer<R> consumer);

    abstract boolean isError();

    abstract boolean isOk();

    abstract <U> Result<Err, U> map(Function<R, U> function);

    abstract void run(Consumer<Err> consumer, Consumer<R> consumer2);

    static final class Unit {
        Unit() {
        }
    }

    static <Err, R> Result<Err, R> error(Err err) {
        Objects.requireNonNull(err);
        return new Error(err);
    }

    static <Err, R> Result<Err, R> value(R r) {
        Objects.requireNonNull(r);
        return new Value(r);
    }

    static <Err> Result<Err, Unit> success() {
        return new Value(new Unit());
    }

    Err getError() {
        throw new NoSuchElementException();
    }

    R getValue() {
        throw new NoSuchElementException();
    }

    Result() {
    }

    R getOr(final R r) {
        return (R) fold(new Function() { // from class: com.amazonaws.ivs.player.Result$$ExternalSyntheticLambda0
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                return Result.lambda$getOr$0(r, obj);
            }
        }, new Function() { // from class: com.amazonaws.ivs.player.Result$$ExternalSyntheticLambda1
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                return this.f$0.m11087lambda$getOr$1$comamazonawsivsplayerResult(obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getOr$1$com-amazonaws-ivs-player-Result, reason: not valid java name */
    /* synthetic */ Object m11087lambda$getOr$1$comamazonawsivsplayerResult(Object obj) {
        return getValue();
    }

    static class Error<Err, R> extends Result<Err, R> {
        private final Err error;

        @Override // com.amazonaws.ivs.player.Result
        Result<Err, R> ifOk(Consumer<R> consumer) {
            return this;
        }

        @Override // com.amazonaws.ivs.player.Result
        boolean isError() {
            return true;
        }

        @Override // com.amazonaws.ivs.player.Result
        boolean isOk() {
            return false;
        }

        Error(Err err) {
            Objects.requireNonNull(err);
            this.error = err;
        }

        @Override // com.amazonaws.ivs.player.Result
        Err getError() {
            return this.error;
        }

        @Override // com.amazonaws.ivs.player.Result
        void run(Consumer<Err> consumer, Consumer<R> consumer2) {
            consumer.accept(this.error);
        }

        @Override // com.amazonaws.ivs.player.Result
        <U> Result<Err, U> flatMap(Function<R, Result<Err, U>> function) {
            return Result.error(this.error);
        }

        @Override // com.amazonaws.ivs.player.Result
        <U> U fold(Function<Err, U> function, Function<R, U> function2) {
            return function.apply(this.error);
        }

        @Override // com.amazonaws.ivs.player.Result
        Result<Err, R> ifError(Consumer<Err> consumer) {
            consumer.accept(this.error);
            return this;
        }

        @Override // com.amazonaws.ivs.player.Result
        <U> Result<Err, U> map(Function<R, U> function) {
            return Result.error(this.error);
        }
    }

    static final class Value<Err, R> extends Result<Err, R> {
        private final R value;

        @Override // com.amazonaws.ivs.player.Result
        Result<Err, R> ifError(Consumer<Err> consumer) {
            return this;
        }

        @Override // com.amazonaws.ivs.player.Result
        boolean isError() {
            return false;
        }

        @Override // com.amazonaws.ivs.player.Result
        boolean isOk() {
            return true;
        }

        Value(R r) {
            Objects.requireNonNull(r);
            this.value = r;
        }

        @Override // com.amazonaws.ivs.player.Result
        R getValue() {
            return this.value;
        }

        @Override // com.amazonaws.ivs.player.Result
        void run(Consumer<Err> consumer, Consumer<R> consumer2) {
            consumer2.accept(this.value);
        }

        @Override // com.amazonaws.ivs.player.Result
        <U> Result<Err, U> flatMap(Function<R, Result<Err, U>> function) {
            return function.apply(this.value);
        }

        @Override // com.amazonaws.ivs.player.Result
        <U> U fold(Function<Err, U> function, Function<R, U> function2) {
            return function2.apply(this.value);
        }

        @Override // com.amazonaws.ivs.player.Result
        Result<Err, R> ifOk(Consumer<R> consumer) {
            consumer.accept(this.value);
            return this;
        }

        @Override // com.amazonaws.ivs.player.Result
        <U> Result<Err, U> map(Function<R, U> function) {
            return Result.value(function.apply(this.value));
        }
    }
}
