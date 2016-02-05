## HangulParser
[자바 & 안드로이드] `HangulToJasoParser`는 한 글자를 자소(자음과 모음)로 분리하고 자음과 모음을 하나의 글자로 만들 수 있는 그래들 라이브러리입니다.

[Java & Android] `HangulToJasoParser` is to seperate hangul to basic consonant and vowel by using unicode and also to convert basic consonant and vowel to hangul.

## Usage

**1. 자소 분리(Disassemble)**

```java
  try {
    jasoList = HangulToJasoParser.getInstance().disassemble('한');
  } catch (HangulParserException e) {
    e.printStackTrace();
  }
  
  > [ㅎ, ㅏ, ㄴ]
```

```java
  try {
    jasoList = HangulToJasoParser.getInstance().disassemble("한글");
  } catch (HangulParserException e) {
    e.printStackTrace();
  }

  > [ㅎ, ㅏ, ㄴ, ㄱ, ㅡ, ㄹ]
```

**2. 자소 결합(assemble)**
```java
  jasoList.add("ㅎ");
  jasoList.add("ㅏ");
  jasoList.add("ㄴ");
  jasoList.add("ㄱ");
  jasoList.add("ㅡ");
  jasoList.add("ㄹ");
  try {
    String hangul = HangulToJasoParser.getInstance().assemble(jasoList);
  } catch (HangulParserException e) {
    e.printStackTrace();
  }
  
  > 한글
```

## Settings

#### Android Studio

프로젝트안의 라이브러리에 라이브러리 추가(클론)하기

build.gradle
```groovy
  compile project(':your_library_folder:HangulParser')
```

settings.gradle
```groovy
  ':your_library_folder:HangulParser'
```
 
#### Eclipse

그래들 프로젝트로 ```HangulParser```를 추가하고 소스 폴더의 패스를  ```src/main/java``` 아래처럼 수정하기 (the Properties of library > Java Build Path > Source)

<img src="./screenshot/settings_01.png" width=557 height=280 />


## Contributing
All contributions are welcome. Open a [Pull Requests](https://github.com/kimkevin/HangulToJasoParser/pulls) or refer to
the [Issues](https://github.com/kimkevin/HangulToJasoParser/issues) section.

## License
Copyright (c) 2013 "KimKevin" Yongjun Kim

Licensed under the MIT license.
