package J107.MicroTask1;

public class InterfaceUser {
    SomeInterface<String> inUse;
    public SomeInterface<String> getUsed() {
        return inUse;
    }
    public void useInterface (SomeInterface<String> i) { }
}
