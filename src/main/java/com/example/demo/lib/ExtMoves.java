package com.example.demo.lib;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtMoves extends Structure {
    public int num = 0;
    public int [] moves = new int[256];

    @Override
    protected List getFieldOrder() {
        return Arrays.asList("num", "moves");
    }

}
