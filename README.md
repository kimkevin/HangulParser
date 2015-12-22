# HangulParser
[자바 & 안드로이드] HangulToJasoParser는 한 글자를 자소(자음과 모음)로 분리하고 자음과 모음을 하나의 글자로 만들 수 있는 인스턴스입니다.

[Java & Android] HangulToJasoParser is to seperate Hangul to basic consonant and vowel by using Unicode and also to convert basic consonant and vowel to hangul.

# Usage

**1. 자소 분리(Disassemble)**

```java
  String hangul = "한글";
  for (int i = 0, li = hangul.length(); i < li; i++) {
    try {
      jasoList.addAll(HangulToJasoParser.getInstance().disassemble(hangul.charAt(i)));
    } catch (HangulParserException e) {
      e.printStackTrace();
    }
  }
  
  > [ㅎ, ㅏ, ㄴ, ㄱ, ㅡ, ㄹ]
```

**2. 자소 결합(assemble)**
```java
  jasoList.add("ㅎ");
  jasoList.add("ㅏ");
  jasoList.add("ㄴ");
  try {
    String hangul = HangulToJasoParser.getInstance().assemble(jasoList);
  } catch (HangulParserException e) {
    e.printStackTrace();
  }
  
  > 한
```

# Developed By
* Kevin Yongjun Kim - imkimkevin@gmail.com

# Contributing
All contributions are welcome. Open a [Pull Requests](https://github.com/kimkevin/HangulToJasoParser/pulls) or refer to
the [Issues](https://github.com/kimkevin/HangulToJasoParser/issues) section.

# License
Copyright (c) 2013 "KimKevin"

Licensed under the MIT license.
