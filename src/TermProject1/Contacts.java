package TermProject1;

import java.util.Scanner;
import java.util.Vector;

public class Contacts {
    Scanner sScanner = new Scanner(System.in);
    Vector PersonVector = new Vector();

    void Start() {
        System.out.println("#### 친구 연락처 관리 ####");
        do {
            // po.Menu(sScanner);
            switch (this.Menu()) {
                case 1: // 출력
                    this.Check();
                    break;
                case 2: // 등록
                    this.Register();
                    break;
                case 3: // 삭제
                    this.Cancel();
                    break;
                case 4: // 종료
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("<올바른 입력이 아닙니다.>");
            }
        } while (true);
    }

    // 메뉴 출력
    int Menu() {
        int iSwitch_Menu = 0;
        System.out.println("1.  연락처 출력");
        System.out.println("2.  연락처 등록");
        System.out.println("3.  연락처 삭제");
        System.out.println("4.  끝내기");
        System.out.print("선택: ");
        iSwitch_Menu = sScanner.nextInt();
        return iSwitch_Menu;
    }

    // 연락처 출력
    void Check() { // 조회
        Person tmp;
        if (PersonVector.size() == 0) {
            System.out.println("등록된 연락처가 없습니다.");
        }
        for (int Num = 1; Num - 1 < PersonVector.size(); Num++) {
            tmp = (Person) PersonVector.get(Num - 1);
            System.out.println("    " + Num + ". " + tmp.getName() + "\t" + tmp.getAge() + "\t" + tmp.getNumber());
        }
        System.out.println();
    }

    // 연락처 등록
    void Register() {
        Person tmpPerson;
        System.out.print("  이름 : ");
        String Name = sScanner.next();
        System.out.print("  나이 : ");
        int Age = sScanner.nextInt();
        System.out.print("  전화번호 : ");
        String Number = sScanner.next();
        System.out.println();

        tmpPerson = new Person(Name, Age, Number);
        PersonVector.add(tmpPerson);
    }

    // 연락처 삭제
    void Cancel() {
        // TODO Auto-generated method stub
        System.out.print("  삭제할 행번호 : ");
        int Num = sScanner.nextInt() - 1;
        if (Num < PersonVector.size() || 0 < Num) {
            PersonVector.remove(Num);
        } else {
            System.out.println("올바른 행 번호가 아닙니다.");
        }
        System.out.println();
    }
}
