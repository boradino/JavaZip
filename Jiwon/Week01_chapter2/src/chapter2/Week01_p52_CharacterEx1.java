package chapter2;

public class CharacterEx1 {
    public static void main(String[] args){
        char ch1 = 'A';
        System.out.println(ch1);        //문자 출력
        System.out.println((int)ch1);   //문자에 해당하는 아스키코드값 출력

        char ch2 = 66;
        System.out.println(ch2);        //정수값에 해당하는 문자 출력

        int ch3 = 67;
        System.out.println(ch3);        //ch3 변수에 들어가있는 정수 출력
        System.out.println((char)ch3);   //정수값에 해당하는 문자 출력
    }
}
