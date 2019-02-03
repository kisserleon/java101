package com.jacky.java101.stream;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StreamJoin {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString(); //aaa,bbb,ccc

        sj = new StringJoiner("/", "prefix-", "-suffix");
        sj.add("2016");
        sj.add("02");
        sj.add("26");
        result = sj.toString(); //prefix-2016/02/26-suffix

        //2015-10-31
        result = String.join("-", "2015", "10", "31" );

        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
        //java, python, nodejs, ruby
        result = String.join(", ", list);


        //java | python | nodejs | ruby
        result = list.stream().map(x -> x).collect(Collectors.joining(" | "));

        //{java, python, nodejs, ruby}
        result = list.stream().collect(Collectors.joining(", ", "{", "}"));
    }



}
