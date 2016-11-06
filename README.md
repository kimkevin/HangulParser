## HangulParser
[자바 & 안드로이드] `HangulParser`는 한 글자를 자소(자음과 모음)로 분리하고 자음과 모음을 하나의 글자로 만들 수 있는 `Gradle` 라이브러리입니다.

[Java & Android] `HangulParser` is to seperate hangul to basic consonant and vowel by using unicode and also to convert basic consonant and vowel to hangul.

## Usage

```java
dependencies {
  compile 'com.github.kimkevin:hangulparser:1.0.0'
}
```

**1. 자소 분리(Disassemble)**

> public List\<String\> disassemble(char hangul)

```java 
  try {
    jasoList = HangulParser.getInstance().disassemble('한');
  } catch (HangulParserException e) {
    e.printStackTrace();
  }
  
  > [ㅎ, ㅏ, ㄴ]
```

> public List\<String\> disassemble(String hangul)

```java
  try {
    jasoList = HangulParser.getInstance().disassemble("한글");
  } catch (HangulParserException e) {
    e.printStackTrace();
  }

  > [ㅎ, ㅏ, ㄴ, ㄱ, ㅡ, ㄹ]
```

**2. 자소 결합(Assemble)**
> public String assemble(List\<String\> jasoList)

```java
  jasoList.add("ㅎ");
  jasoList.add("ㅏ");
  jasoList.add("ㄴ");
  jasoList.add("ㄱ");
  jasoList.add("ㅡ");
  jasoList.add("ㄹ");
  try {
    String hangul = HangulParser.getInstance().assemble(jasoList);
  } catch (HangulParserException e) {
    e.printStackTrace();
  }
  
  > 한글
```

## Contributing
All contributions are welcome. Open a [Pull Requests](https://github.com/kimkevin/HangulToJasoParser/pulls) or refer to
the [Issues](https://github.com/kimkevin/HangulToJasoParser/issues) section.

## License
Copyright (c) 2013 "KimKevin" Yongjun Kim

Licensed under the MIT license.
