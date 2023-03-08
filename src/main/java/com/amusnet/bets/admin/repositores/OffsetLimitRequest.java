package com.amusnet.bets.admin.repositores;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
public class OffsetLimitRequest implements Pageable {
    private int limit;
    private long offset;
    @Override
    public int getPageNumber() {
        return 1;
    }

    @Override
    public int getPageSize() {
        return this.limit;
    }

    @Override
    public long getOffset() {
        return this.offset;
    }

    @Override
    public Sort getSort() {
        return Sort.unsorted();
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }


    @Override
    public boolean hasPrevious() {
        return false;
    }
}
