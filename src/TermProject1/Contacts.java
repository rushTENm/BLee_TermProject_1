package TermProject1;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts {
    Scanner scanner = new Scanner(System.in);
    Pattern patternNum = Pattern.compile("^[0-9]*$");
    Vector<Person> vectorPerson = new Vector();

    void menu() {
        System.out.println("#### 친구 연락처 관리 ####");
        do {
            System.out.println("1.  연락처 출력");
            System.out.println("2.  연락처 등록");
            System.out.println("3.  연락처 삭제");
            System.out.println("4.  끝내기");
            System.out.print("선택: ");

            String stringInput = scanner.nextLine();
            Matcher matcherNum = patternNum.matcher(stringInput);
            int intInput = matcherNum.find() ? Integer.parseInt(stringInput) : 0;

            switch (intInput) {
                case 1: // 출력
                    this.show();
                    break;
                case 2: // 등록
                    this.register();
                    break;
                case 3: // 삭제
                    this.delete();
                    break;
                case 4: // 종료
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("<올바른 입력이 아닙니다.>\n");
                    break;
            }
        } while (true);
    }

    // 연락처 출력
    void show() { // 조회
        if (vectorPerson.size() == 0)
            System.out.println("등록된 연락처가 없습니다.");
        else {
            Person tmp;
            for (int i = 1; i <= vectorPerson.size(); i++) {
                tmp = vectorPerson.get(i - 1);
                System.out.println("    " + i + ".\t" + tmp.getName() + " " + tmp.getAge() + " " + tmp.getPhoneNum());
            }
            System.out.println("");
        }
    }

    // 연락처 등록
    void register() {
        Person tmpPerson = new Person();
        System.out.print("  이름 : ");
        tmpPerson.setName();
        System.out.print("  나이 : ");
        tmpPerson.setAge();
        System.out.print("  전화번호 : ");
        tmpPerson.setPhoneNum();

        vectorPerson.add(tmpPerson);

        System.out.println();
    }

    // 연락처 삭제
    void delete() {
        System.out.print("  삭제할 행번호 : ");

        String stringInput = scanner.nextLine();
        Matcher matcherNum = patternNum.matcher(stringInput);
        int intInput = matcherNum.find() ? Integer.parseInt(stringInput) - 1 : -1;

        if (intInput < vectorPerson.size() || 0 < intInput) {
            vectorPerson.remove(intInput);
            System.out.println("  " + stringInput + "행이 삭제되었습니다.\n");
        } else
            System.out.println("올바른 행 번호가 아닙니다.\n");
    }
}
