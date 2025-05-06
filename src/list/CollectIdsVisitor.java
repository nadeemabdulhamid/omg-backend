package list;

import media.*;

public class CollectIdsVisitor implements IListVisitor<IMedia, ILo<Integer>> {

    @Override
    public ILo<Integer> visitEmpty(MTLo<IMedia> lo) {
        return new MTLo<Integer>();
    }

    @Override
    public ILo<Integer> visitCons(ConsLo<IMedia> lo, IMedia first, ILo<IMedia> rest) {
        return new ConsLo<Integer>(first.getId(), rest.accept(this));
    }
    
}
