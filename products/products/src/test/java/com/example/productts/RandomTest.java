package com.example.productts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomTest {
    @Test
    public void onePlusOneIsTwo(){
        //arrange
        int a=1;
        int b=1;

        //act
        int x=a+b;

        //assert
        Assertions.assertEquals(4,x);
    }
}
