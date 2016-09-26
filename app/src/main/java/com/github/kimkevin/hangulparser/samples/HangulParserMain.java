package com.github.kimkevin.hangulparser.samples;

import com.github.kimkevin.hangulparser.HangulParser;
import com.github.kimkevin.hangulparser.HangulParserException;

import java.util.List;

public class HangulParserMain {
  public static void main (String[] args) {
    try {
      List<String> jasoList = HangulParser.disassemble('한');
      System.out.println(jasoList.toString());

      jasoList = HangulParser.disassemble("한글");
      System.out.println(jasoList.toString());

      jasoList.clear();
      jasoList.add("ㅎ");
      jasoList.add("ㅏ");
      jasoList.add("ㄴ");
      jasoList.add("ㄱ");
      jasoList.add("ㅡ");
      jasoList.add("ㄹ");

      String hangul = HangulParser.assemble(jasoList);
      System.out.println(hangul);
    } catch (HangulParserException e) {
      e.printStackTrace();
    }
  }
}
