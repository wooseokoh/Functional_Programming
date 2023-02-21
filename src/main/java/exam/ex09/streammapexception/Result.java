package exam.ex09.streammapexception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.function.Supplier;

@Getter
@RequiredArgsConstructor
public class Result<V, E extends Throwable> {

    private final V value;
    private final E error;

    public static <V, E extends Throwable> Result<V, E> failure(E error){
        return new Result<>(null, Objects.requireNonNull(error));
    }

    public static <V, E extends Throwable> Result<V, E> success(V value){
        return new Result<>(Objects.requireNonNull(value), null);
    }

    public boolean isError(){
        return this.error != null;
    }

    public boolean isSuccess(){
        return this.error == null;
    }

    public static <V, E extends Throwable> Result<V, E> attempt(Supplier<V> supplier){
        try {
            return Result.success(supplier.get());
        }catch (Throwable e){
            E err = (E)e;
            return Result.failure(err);
        }
    }
}
