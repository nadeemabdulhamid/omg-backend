package list;

public interface IListVisitor<T, R> {
    R visitEmpty(MTLo<T> lo);
    R visitCons(ConsLo<T> lo, T first, ILo<T> rest);
}
