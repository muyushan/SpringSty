package com.sane.pkg.utils;

import com.sane.pkg.exceptions.BizException;

import java.util.Arrays;
import java.util.List;

public class CommonUtil {
    private static String[]EnglishLetterArray={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    private static int LETTER_MAX=25;
    private static List<String> englishLetterList;
    static {
        englishLetterList= Arrays.asList(EnglishLetterArray);
    }

    /**
     * 根据给定的参数  f1和f2 计算出 f1+1和f2+1在 26个英文字母表中位置的字符的组合值
     * 如 f1:A f2:C 则结果是 AD 如 f1:A f2:Z 则运算结果是 BA 如果 f1是空字符串 则产生的第一个字母为A
     * 如果 f1:Z f2:Z 则报出 超出最大取值范围的异常
     * @param f1
     * @param f2
     * @return
     * @throws BizException
     */
    public static String generageNextCode(String f1,String f2) throws BizException{
        int first=englishLetterList.indexOf(f1.toUpperCase());
        int second=englishLetterList.indexOf(f2.toUpperCase());
        if(first==LETTER_MAX&&second==LETTER_MAX){
            throw  new BizException("超出最大取值范围了");
        }else if(second==25){
            first=first+1;
            second=0;
        }else if(first==-1){
            first=0;
            second=second+1;
        }else{
            second=second+1;
        }
        String nextCode=String.format("%s%s",englishLetterList.get(first),englishLetterList.get(second));
        return  nextCode;
    }
}
