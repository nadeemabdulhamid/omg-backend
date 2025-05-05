package list;

import media.IMedia;

public class FindItemVisitor implements IListVisitor<IMedia, IMedia> {

    private int id;

    public FindItemVisitor(int id) {
        this.id = id;
    }

    @Override
    public IMedia visitEmpty(MTLo<IMedia> lo) {
        return null;
    }

    @Override
    public IMedia visitCons(ConsLo<IMedia> lo, IMedia first, ILo<IMedia> rest) {
        if (first.getId() == this.id) {
            return first;
        } else {
            return rest.accept(this);
        }
    }
    
}
