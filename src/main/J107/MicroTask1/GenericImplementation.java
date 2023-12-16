package J107.MicroTask1;

public class GenericImplementation<T> implements SomeInterface<T> {
    T data;

    @Override
    public T getData() {
        return data;
    }

    @Override
    public Boolean validate(T data) {
        return null;
    }
}
