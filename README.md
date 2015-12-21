# HangulParser
[Java & Android] HangulToJasoParser is to seperate Hangul to basic consonant and vowel by using Unicode and also to convert  basic consonant and vowel to hangul.

# Usage

**1. Disassemble**

```java
  String hangul = "케빈";
  for (int i = 0, li = hangul.length(); i < li; i++) {
    try {
      jasoList.addAll(HangulToJasoParser.getInstance().disassemble(hangul.charAt(i)));
    } catch (HangulParserException e) {
      e.printStackTrace();
    }
  }
  
  > [ㅋ, ㅔ, ㅂ, ㅣ, ㄴ]
```

**2. assemble**
```java
  jasoList.add("ㅂ");
  jasoList.add("ㅣ");
  jasoList.add("ㄴ");
    try{
  String hangul = HangulToJasoParser.getInstance().assemble(jasoList);
  } catch (HangulParserException e) {
    e.printStackTrace();
  }
  
  > 빈
```

# Developed By
* Kevin Yongjun Kim - imkimkevin@gmail.com

# Contributing
All contributions are welcome. Open a [Pull Requests](https://github.com/kimkevin/HangulToJasoParser/pulls) or refer to
the [Issues](https://github.com/kimkevin/HangulToJasoParser/issues) section.

# License
MIT
