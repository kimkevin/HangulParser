package com.github.kimkevin.hangulparser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HangulParserTest {
  @Test
  public void testAssemble() throws Exception {
    try {
      List<String> jasoList = HangulParser.getInstance().disassemble('한');

      assertList(Arrays.asList("ㅎ", "ㅏ", "ㄴ"), jasoList);
    } catch (HangulParserException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testDisassemble() throws Exception {
    try {
      List<String> jasoList = new ArrayList<>();

      jasoList.add("ㅎ");
      jasoList.add("ㅏ");
      jasoList.add("ㄴ");
      jasoList.add("ㄱ");
      jasoList.add("ㅡ");
      jasoList.add("ㄹ");

      String hangul = HangulParser.getInstance().assemble(jasoList);
      assertEquals("한글", hangul);
    } catch (HangulParserException e) {
      e.printStackTrace();
    }
  }

  private void assertList(List<String> actual, List<String> expected) {
    for (String className : actual) {
      assertThat(true, is(expected.contains(className)));
    }
  }
}
