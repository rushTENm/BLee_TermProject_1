package TermProject1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private int age;
    private String phoneNum;

    Scanner scanner = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName() {
        Pattern patternKorean = Pattern.compile("^[가-힣]{2,5}$");
        Pattern patternRoman = Pattern.compile("^[A-Z][a-z A-Z,.'-]+$");

        while (true) {
            String input = scanner.nextLine();
            Matcher matcherKorean = patternKorean.matcher(input);
            Matcher matcherRoman = patternRoman.matcher(input);

            if (matcherKorean.find() || matcherRoman.find()) {
                this.name = input;
                break;
            } else
                System.out.println("올바른 이름을 입력하세요");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        Pattern patternNum = Pattern.compile("^[0-9]*$");

        while (true) {
            String stringInput = scanner.nextLine();
            Matcher matcherNum = patternNum.matcher(stringInput);

            if (matcherNum.find() && Integer.parseInt(stringInput) > 0) {
                this.age = Integer.parseInt(stringInput);
                break;
            } else
                System.out.println("올바른 나이를 입력하세요");
        }
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum() {
        Pattern p1 = Pattern.compile("^01(?:0|1|[6-9])-(?:[0-9]{3}|[0-9]{4})-[0-9]{4}");
        Pattern p2 = Pattern.compile("^010[0-9]{8}");
        Pattern p3 = Pattern.compile("^01(?:1|[6-9])[0-9]{7}");

        while (true) {
            StringBuffer bufferInput = new StringBuffer(scanner.nextLine());
            Matcher m1 = p1.matcher(bufferInput);
            Matcher m2 = p2.matcher(bufferInput);
            Matcher m3 = p3.matcher(bufferInput);

            if (m1.find()) {
                this.phoneNum = bufferInput.toString();
                break;
            } else if (m2.find()) {
                bufferInput.insert(3, "-");
                bufferInput.insert(8, "-");
                this.phoneNum = bufferInput.toString();
                break;
            } else if (m3.find()) {
                bufferInput.insert(3, "-");
                bufferInput.insert(7, "-");
                this.phoneNum = bufferInput.toString();
                break;
            } else {
                System.out.println("올바른 번호를 입력하세요");
            }
        }
    }
}
