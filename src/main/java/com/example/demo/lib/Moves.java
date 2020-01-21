package com.example.demo.lib;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class Moves extends Structure {
    public int num = 10;
//    public int [] arr = {136, 120, 168, 105, 169, 121, 119, 135, 90, 153};
//
//    public int num = 8;
//    public int [] arr = {344, 306, 286, 267, 287, 288, 305, 269};
//  public int [] arr = {90, 118, 137, 168, 149, 121, 119, 135, 99, 153};
//    public int [] arr = {52,53,68,69,84,100,85,102,86,87};
//    public int [] arr = {83,125,127,148,147,167,105,188};
//    public int [] arr = {67,101,103,120,119,135,85,152};
//    public int [] arr = {344,306,286,267,287,288,305,269,309,268};
//    public int [] arr = {64,107,104,125,126,84,87,87};
//    public int [] arr = {52,86,87,104,103,119,70,136};
//    public int [] arr = { 344,306,286,267,287,288,305,269};
    public int [] arr = {344,306,286,267,287,288,305,269,309,268};
    @Override
    protected List getFieldOrder() {
        return Arrays.asList("num", "arr");
    }
}
