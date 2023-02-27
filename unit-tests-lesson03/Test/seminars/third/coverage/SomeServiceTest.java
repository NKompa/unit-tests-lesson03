package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
        private SomeService someService;

        @BeforeEach
        void setUp() {
            someService = new SomeService();
        }

        @Test
        void testReturnFizz() {
            assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz");
        }
        @Test
        void testReturnBuzz() {
            assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz");
        }
        @Test
        void testReturnFizzBuzz() {
            assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz");
        }

        @Test
        void testReturnElse() {
            assertThat(someService.fizzBuzz(14)).isEqualTo("" + 14);
        }

        @Test
        void testFirstSix() {
            assertTrue(someService.firstLast6(new int[] {6,1,2,3}));
        }

        @Test
        void testLastSix() {
            assertTrue(someService.firstLast6(new int[] {1,2,3,6}));
        }

        @Test
        void testFirstLastSix() {
            assertFalse(someService.firstLast6(new int[] {0,1,2,3}));
        }

        // ДЗ - пункт 1:
        @ParameterizedTest
        @CsvSource({
                "5.75, 0, 5.75",
                "350.0, 15, 297.5",
                "2354.0, 100, 0.0"
        })
        void testCorrectPurchaseDiscountAmounts(
                double purchaseAmount, int discountAmount, double expectedResult) {
                    double totalCalculated = someService.calculatingDiscount(purchaseAmount, discountAmount);
                    assertEquals(expectedResult, totalCalculated);
        }
        @Test
        void testPurchaseAmountBelowZero() {
            assertThatThrownBy(() ->
                    someService.calculatingDiscount(-200.0, 10))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessage("Сумма покупки не может быть отрицательной");
        }
        @ParameterizedTest
        @ValueSource(ints = {-1,101})
        void testDiscountAmountOutofRange(int i) {
            assertThatThrownBy(() ->
                    someService.calculatingDiscount(200.0, i))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
        }

        // ДЗ - пункт 2 (0 - по умолчанию чётное число):
        @ParameterizedTest
        @ValueSource(ints = {0, 16, -100})
        void testOddNumberTrue(int i) {
            assertTrue(someService.evenOddNumber(i));
        }

        @ParameterizedTest
        @ValueSource(ints = {3, 1235, -101})
        void testOddNumberFalse(int i) {
            assertFalse(someService.evenOddNumber(i));
        }

        @Test
        void testNoNumberEquals13() {
            assertThat(someService.luckySum(12,14,6)).isEqualTo(32);
        }

        @Test
        void testAEquals13() {
            assertThat(someService.luckySum(13,21,9)).isEqualTo(30);
        }
        @Test
        void testBEquals13() {
            assertThat(someService.luckySum(-17,13,17)).isEqualTo(0);
        }
        @Test
        void testCEquals13() {
            assertThat(someService.luckySum(-33,-21,13)).isEqualTo(-54);
        }



}