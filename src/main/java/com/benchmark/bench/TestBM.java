package com.benchmark.bench;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestBM {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 2, jvmArgs = {"-Xms8G", "-Xmx8G"})
    @Warmup(iterations = 5)
    @Measurement(iterations = 4)
    public void init() {

        final ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10_000_000; i++) {
            arrayList.add(i);
        }
    }
}
