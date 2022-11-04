package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int userEndingResponse = 1;
        List<Integer> computerAnswerList = new ArrayList<>();
        int userAnswer = 0;
        List<Integer> userAnswerList = new ArrayList<>();

        while (userEndingResponse == 1){

            printStartMessage();

            computerAnswerList = createComputerLength3IntegerAnswerToList();

            printGetInputMessage();
            userAnswer = getUserNumberToInteger();
            checkIllegalInputForBaseballGame(userAnswer);
            userAnswerList = convertIntegerToList(userAnswer);





        }
        // TODO: 프로그램 구현
    }

    public static List<Integer> createComputerLength3IntegerAnswerToList(){
        List<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }

        return computerAnswer;
    }

    public static void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printGetInputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public static int getUserNumberToInteger() {
        String userAnswer = Console.readLine();
        return Integer.valueOf(userAnswer);
    }
    public static List<Integer> convertIntegerToList(int num){
        List<Integer> numList = new ArrayList<>();

        String numStr = String.valueOf(num);
        for (String tmpStr : Arrays.asList(numStr.split(""))){
            numList.add(Integer.valueOf(tmpStr));
        }

        return numList;
    }
    public static void checkIllegalInputForBaseballGame(int input){

        // 1. 3자리가 아닐 경우
        String inputStr = String.valueOf(input);
        int lengthOfInput = inputStr.length();
        if (lengthOfInput != 3)
            throw new IllegalArgumentException("3자리의 숫자를 입력하십시오.");

        List<Character> appearedNumList = new ArrayList<>();
        for (int inputStringIndex = 0; inputStringIndex < lengthOfInput; inputStringIndex++){

            // 2. 값에 1-9 이외의 값이 포함되어있을 때
            char tmpInputStr = inputStr.charAt(inputStringIndex);
            int ASCII_tmpInputStr = tmpInputStr;
            if (ASCII_tmpInputStr < 49 && ASCII_tmpInputStr > 58)
                // 1: 49, 9: 57
                throw new IllegalArgumentException("1~9 사이의 숫자만 가능합니다.");

            // 3. 3자리 수 중 중복이 있을 때
            if (appearedNumList.contains(tmpInputStr))
                throw new IllegalArgumentException("3자리의 숫자 중 중복되는 값이 존재해서는 안됩니다.");
            else
                appearedNumList.add(tmpInputStr);
        }
    }
    // 에러케이스 구분할 것!

    public static List<Integer> checkWhereIsNotStrike(List<Integer> computerAnswer,
                                                   List<Integer> userAnswer){
        List<Integer> notStrikeZone = new ArrayList<>();
        for (int digit=0; digit<3; digit++){
            if (!computerAnswer.get(digit).equals(userAnswer.get(digit)))
                notStrikeZone.add(digit);
        }
        return notStrikeZone;
    }
    public static int countStrike(List<Boolean> strikeList){
        return Collections.frequency(strikeList, true);
    }
    public static void printEndingMessage(int countStrike){
        if (countStrike==3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public static void countBall(){

    }
}
