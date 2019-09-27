package unitTest;

/**
 * Created by wangxichun on 2017/10/1 0001.
 */


import java.io.*;

public class StringUtil {
    public static boolean checkSubString(String s1,String s2)
    {
        if(s1.contains(s2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}