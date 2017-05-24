package TermProject1;

import java.util.Scanner;
import java.util.Vector;
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
        Pattern patternKorean = Pattern.compile("^[가-힣]{1,17}$");
        Pattern patternRoman = Pattern.compile("^[a-z A-Z,.'-]+$");

        while (true) {
            System.out.print("  이름 : ");
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
            System.out.print("  나이 : ");
            String stringInput = scanner.nextLine();
            Matcher matcherNum = patternNum.matcher(stringInput);

            if (matcherNum.find() && Integer.parseInt(stringInput) >= 0) {
                this.age = Integer.parseInt(stringInput);
                break;
            } else
                System.out.println("올바른 나이를 입력하세요");
        }
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public boolean setPhoneNum(Vector<Person> vectorPerson) {
        Pattern p1 = Pattern.compile("^0(?:[0-9]{2}|2)-(?:[0-9]{3}|[0-9]{4})-[0-9]{4}");
        Pattern p2 = Pattern.compile("^0(?:10|2|31)[0-9]{8}");
        Pattern p3 = Pattern.compile("^0[0-9]{9}");
        Pattern p4 = Pattern.compile("[0-9*#+-]+");
        StringBuffer bufferInput;

        while (true) {
            System.out.print("  전화번호 : ");
            bufferInput = new StringBuffer(scanner.nextLine());
            Matcher m1 = p1.matcher(bufferInput);
            Matcher m2 = p2.matcher(bufferInput);
            Matcher m3 = p3.matcher(bufferInput);
            Matcher m4 = p4.matcher(bufferInput);

            if (m1.find()) {
                break;
            } else if (m2.find()) {
                bufferInput.insert(3, "-");
                bufferInput.insert(8, "-");
                break;
            } else if (m3.find()) {
                bufferInput.insert(3, "-");
                bufferInput.insert(7, "-");
                break;
            } else if (m4.find()) {
                if (bufferInput.length() == 8) {
                    bufferInput.insert(4, "-");
                } else if (bufferInput.length() == 10) {
                    bufferInput.insert(3, "-");
                    bufferInput.insert(7, "-");
                } else if (bufferInput.length() == 11) {
                    bufferInput.insert(3, "-");
                    bufferInput.insert(8, "-");
                }
                break;
            } else {
                System.out.println("올바른 번호를 입력하세요");
            }
        }

        for (Person person : vectorPerson) {
            if (person.getPhoneNum().equals(bufferInput.toString())) {
                System.out.println("이미 저장된 번호이므로 중복 저장하지 않습니다.");
                return false;
            }
        }
        this.phoneNum = bufferInput.toString();
        return true;
    }
}
