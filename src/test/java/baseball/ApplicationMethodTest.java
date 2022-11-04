package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationMethodTest {

    @Test
    void createComputerLength3IntegerAnswerToList() {
        List<Integer> computerAnswer = Application.createComputerLength3IntegerAnswerToList();
        System.out.println(computerAnswer);

        assertThat(computerAnswer.size()).isEqualTo(3);
        assertThat(computerAnswer.get(0)).isNotSameAs(0);
        assertThat(computerAnswer.get(1)).isNotSameAs(0);
        assertThat(computerAnswer.get(2)).isNotSameAs(0);
    }

    @Test
    void printStartMessage() {
        Application.printStartMessage();
    }

    @Test
    void printGetInputMessage() {
        Application.printGetInputMessage();
    }

    @Test
    void getUserNumberToInteger() {}

    @Test
    void convertIntegerToList() {}

    @Test
    void checkIllegalInputForBaseballGame() {}


    @Test
    void checkWhereIsNotStrike() {
        List<Integer> computerAnswer = new ArrayList<>(){
            {add(3); add(4); add(5);}
        };
        List<Integer> userAnswer = new ArrayList<>(){
            {add(3); add(4); add(5);}
        };
        List<Integer> notStrikeZone = Application.checkWhereIsNotStrike(computerAnswer, userAnswer);

        List<Boolean> realAnswer = new ArrayList<>(){};
        assertThat(notStrikeZone).isEqualTo(realAnswer);
    }

    @Test
    void countStrike() {
        List<Boolean> strikeList = new ArrayList<>(){
            {add(true); add(true); add(true);}
        };
        int countTrue = Application.countStrike(strikeList);
        assertThat(countTrue).isEqualTo(3);
    }

    @Test
    void printEndingMessage() {
        int countStrike = 3;
        Application.printEndingMessage(countStrike);
    }
}