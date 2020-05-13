package com.tt.concurrent.callable;

import java.util.concurrent.Callable;

public class ComplexMathCallable implements Callable<Double> {
    private ComplexMath cm;
    private final int numberOfThreads;
    private int offset;

    public ComplexMathCallable(ComplexMath _cm, int _offset, int _numberOfThreads) {
        cm = _cm;
        offset = _offset;
        numberOfThreads = _numberOfThreads;
    }

    @Override
    public Double call() throws Exception {
        double result = 0.0;
        int length = cm.getNoColumns()/numberOfThreads;
        for(int i=offset*length; i<(offset+1)*length; i++) {
            result += cm.doComplexMathForColumn(i);
        }
        return result;
    }
}
