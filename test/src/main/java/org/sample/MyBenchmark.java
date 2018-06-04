/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

import by.kir.Jop;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Optional;

@State(Scope.Benchmark)
public class MyBenchmark {

    private Pojo pojo = new JopTest().getPojoWithOutNulls();

    @Benchmark
    public void java7style(Blackhole blackhole) {
        if (pojo != null &&
            pojo.getSubPojo() != null &&
            pojo.getSubPojo().getSubSubPojo() != null &&
            pojo.getSubPojo().getSubSubPojo().getTitle() != null
            ) {
            String title = pojo.getSubPojo().getSubSubPojo().getTitle();
            blackhole.consume(title);
        }else {
            throw new NullPointerException();
        }
    }

    @Benchmark
    public void java8style(Blackhole blackhole) {
        String title = Optional
            .of(pojo)
            .map(Pojo::getSubPojo)
            .map(SubPojo::getSubSubPojo)
            .map(SubSubPojo::getTitle).get();
        blackhole.consume(title);
    }

    @Benchmark
    public void joptional(Blackhole blackhole) {
        String title = Jop.of(pojo).getSubPojo().getSubSubPojo().getTitle();
        blackhole.consume(title);
    }
}
