package com.benchmark.bench;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestBM {

    // -XX:+PrintCompilation                                              -   command for CLI. Passed as parameter.

    // -XX:+UnlockDiagnosticVMOptions -XX:+TraceNMethodInstalls           -   Advanced method for show ready or no this method (compile process)

    // -XX:+UnlockDiagnosticVMOptions -XX:+PrintFlagsFinal -version       -   Show all flags witch access for modification
    // -XX:MaxInlineLevel=9                                               -   Increase count nested methods

    // -XX:Tier4InvocationThreshold=5000                                  -   After this count, code will be recompile to C2
    // -XX:Tier4BackEdgeThreshold=40000                                   -   количество обратных переходов для C2 компиляции

    // java -jar benchmark.jar >out.txt                                   -   Write down results of working program

    // -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining                  -   Show Inlining





    // -Xint                                                               -   ONLY interpretator mode

    // -XX:-UseOnStackReplacement                                          -   Mode for big operations repeations of CYCLES.
    //                                                                         Must not do replacement for big iterations in real time in "center" of cycles.

    // -XX:-UseLoopCounter                                                 -   Mode witch must not using COUNT in iterations CYCLES.


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, jvmArgs = {"-Xms8G", "-Xmx8G",
            "-Xint",
            "-XX:+UnlockDiagnosticVMOptions",
            "-XX:-UseOnStackReplacement",
            "-XX:-UseLoopCounter", "-XX:Tier4InvocationThreshold=5000"})
    @Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
    public void init() {

        final int count = 10_000_000;

        final ArrayList arrayList = new ArrayList();

        for (int i = 0; i < count; i++) {
            arrayList.add(i);
        }
    }
}
