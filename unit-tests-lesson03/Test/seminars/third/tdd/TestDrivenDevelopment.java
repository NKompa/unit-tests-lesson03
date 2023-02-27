package seminars.third.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDrivenDevelopment {

    /**
     * Нужно написать (TDD) класс MoodAnalyser, который оценивает фразы по настроению
     */
    @Test
    void testMoodAnalysisHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String str = "хорошее настроение";
        assertThat(moodAnalyser.analyse(str)).isEqualTo("Happy");

    }
    @Test
    void testMoodAnalysisSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String str = "плохое настроение";
        assertThat(moodAnalyser.analyse(str)).isEqualTo("Sad");

    }
    @Test
    void testMoodAnalysisNeutral() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String str = "как обычно";
        assertThat(moodAnalyser.analyse(str)).isEqualTo("Normal");

    }
    // ДЗ - пункт 3:
    @Test
    void testIntervalCheckTrue() {
        IntervalCheck intervalCheck = new IntervalCheck();
        Integer number = 75;
        assertTrue(intervalCheck.numberInInterval(number));

    }
    @ParameterizedTest
    @ValueSource(ints = {24,101})
    void testIntervalCheckFalse(int i) {
        IntervalCheck intervalCheck = new IntervalCheck();
        assertFalse(intervalCheck.numberInInterval(i));

    }

}