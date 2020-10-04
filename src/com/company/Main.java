package com.company;
import java.lang.management.*;
import java.lang.management.ManagementFactory;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;
import java.lang.String;

public class Main
{
    int N = 10;
    int k = 5;
    int d = 10;

    public static void main(String[] args)
    {
        char outputList[] = GenerateTestList(3, 3, 65, 90);
        for(int x = 0; x < outputList.length; x++){

            System.out.print(outputList[x]);
        }
        // System.out.println(outputList.length);
    }

    public static long getCpuTime(){
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ?
                bean.getCurrentThreadCpuTime() : 0L;
    }

    public static char[] GenerateTestList(int N, int k, int minV, int maxV){

        char testList[] = new char[N * (k+1)];

        // Outside loop controls the number of strings
        for(int i = 0; i < N; i++)
        {
            // The size of each string in the set.
            for(int j = 0; j < k; j++)
            {
                System.out.println((i * (k + 1)) + j + ": ");
                testList[(i * (k + 1)) + j] = (char)(int)(Math.random() * (maxV - minV + 1) + minV);
            }
            // Add the null character for the end of the string.
            testList[((i + 1) * k) + i] = '\0';
        }

        return testList;
    }
}
