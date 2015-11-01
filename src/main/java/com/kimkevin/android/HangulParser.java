package com.kimkevin.android;

import java.util.ArrayList;
import java.util.List;

/**
 * HangulParser is to seperate Hangul to basic consonant and vowel by using Unicode
 *
 *
 * Created by KimKevin.
 * @since 0.1
 * @see HangulParserException
 *
 * ref : Hangul Syllables http://www.unicode.org/charts/PDF/UAC00.pdf
 */

public class HangulParser {
    private static final String TAG = HangulParser.class.getSimpleName();
    private static HangulParser instance;

    public static HangulParser getInstance() {
        if (instance == null) {
            synchronized (HangulParser.class) {
                instance = new HangulParser();

                JUNGSUNG_COUNT = JUNGSUNG_LIST.length;
                JONGSUNG_COUNT = JONGSUNG_LIST.length;
            }
        }

        return instance;
    }

    // First '가' : 0xAC00(44032), 끝 '힟' : 0xD79F(55199)
    private static final int FIRST_HANGUL = 44032;

    private static int JUNGSUNG_COUNT = 0;
    private static int JONGSUNG_COUNT = 0;

    // 19 initial consonants
    private static final char[] CHOSUNG_LIST = {
            'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ',
            'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };

    // 21 vowels
    private static final char[] JUNGSUNG_LIST = {
            'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ',
            'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ',
            'ㅣ'
    };

    // 28 consonants placed under a vowel(plus one empty character)
    private static final char[] JONGSUNG_LIST = {
            ' ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ',
            'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ',
            'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };

    public List<String> disassemble(char hangul) throws HangulParserException {
        List<String> jasoList = new ArrayList<>();

        String hangulStr = String.valueOf(hangul);

        if (hangulStr.matches(".*[가-힣]+.*")) {
            int baseCode = hangulStr.charAt(0) - FIRST_HANGUL;

            final int chosungIndex = baseCode / (JONGSUNG_COUNT * JUNGSUNG_COUNT);
            jasoList.add(Character.toString(CHOSUNG_LIST[chosungIndex]));

            final int jungsungIndex = (baseCode - ((JONGSUNG_COUNT * JUNGSUNG_COUNT) * chosungIndex)) / JONGSUNG_COUNT;
            jasoList.add(Character.toString(JUNGSUNG_LIST[jungsungIndex]));

            final int jongsungIndex = (baseCode - ((JONGSUNG_COUNT * JUNGSUNG_COUNT) * chosungIndex) - (JONGSUNG_COUNT * jungsungIndex));
            if (jongsungIndex > 1) {
                jasoList.add(Character.toString(JONGSUNG_LIST[jongsungIndex]));
            }
        } else if (hangulStr.matches(".*[ㄱ-ㅎ]+.*")) {
            throw new HangulParserException("It is Korean consonant");
        } else if (hangulStr.matches(".*[ㅏ-ㅣ]+.*")) {
            throw new HangulParserException("It is Korean vowel");
        } else {
            throw new HangulParserException("It is not Hangul");
        }

        return jasoList;
    }

    public String assemble(List<String> jasoList) {
        int unicode = FIRST_HANGUL;

        if (jasoList.size() > 0) {
            final int chosungIndex = new String(CHOSUNG_LIST).indexOf(jasoList.get(0));
            unicode += JONGSUNG_COUNT * JUNGSUNG_COUNT * chosungIndex;

            if (jasoList.size() > 1) {
                final int jungsungIndex = new String(JUNGSUNG_LIST).indexOf(jasoList.get(1));
                unicode += JONGSUNG_COUNT * jungsungIndex;

                if (jasoList.size() > 2) {
                    final int jongsungIndex = new String(JONGSUNG_LIST).indexOf(jasoList.get(2));
                    unicode += jongsungIndex;
                }
            }

            return Character.toString((char) unicode);
        } else {
            return null;
        }
    }
}
