/* [주석 1 : 과제 설명]

  객체지향프로그래밍 평가과제 (배점 25점)
  학과 : 컴퓨터전자시스템공학부
  학번 : 201802624
  이름 : 이승민
  
  과제 주제 : 제가 이번에 만들게 된 프로그램은 현재 우리 나라의 코로나 확진자 수를 먼저 입력을 시켜놓았고,
  그 데이터를 이용하여 제가 원하는 지역을 골라 그 지역의 코로나 확진자 수를 조회하거나 확진자 수가 매일 최신화가 되므로
  업데이트를 원할 경우에는 직접 업데이트를 선택하여 확진자 수와 갱신 날짜를 최신화 시킬 수 있는 프로그램을 만들어 보았습니다.
  한국 전체의 총 확진자 수부터 서울, 부산, 대구, 인천 등 특별시, 광역시 뿐만 아니라 경기도, 강원도, 경상도, 전라도, 충청도, 제주도와 같은
  자치도와 마지막으로 검역의 확진자 수 까지 정리를 해보았습니다.
  
*/

import java.util.Scanner;
import java.util.InputMismatchException; // [주석 10 : 예외 처리] 예외처리

interface CovidConfiredCase { // [주석 11 : 인터페이스] 인터페이스
    void show();

    // default 메소드
    default void printLogo() {
        System.out.println("**** 코로나 지역별 확진자 수 현황 조회 ****");
    }
}

abstract class ConfiredCase implements CovidConfiredCase { // [주석 7 : 추상 클래스] 추상 클래스
    public abstract void update(int c, String d);
}

class Korea extends ConfiredCase { // [주석 2 : 클래스 상속] 클래스 상속
    int confirmedCase;
    String date;

    public Korea() { // [주석 3 : 생성자] 매개 변수 없는 생성자
        confirmedCase = 0;
    }

    public Korea(int c, String d) { // [주석 3 : 생성자] 매개 변수를 가진 생성자
        confirmedCase = c;
        date = d;
    }

    @Override // [주석 6 : 오버라이딩] 오버라이딩
    public void show() {
        System.out.println(date + " 기준");
        System.out.println("한국 확진자 수 : " + confirmedCase + "명");
    }

    @Override // [주석 6 : 오버라이딩] 오버라이딩
    public void update(int c, String d) {
        confirmedCase = c;
        date = d;
    }
}

class City extends Korea { // [주석 2, 8 : 클래스 상속, 다형성] 클래스 상속 및 다형성
    String name;
    int confirmedCase;

    public City(String n, int c, String d) { // [주석 3 : 생성자] 매개 변수를 가진 생성자
        name = n;
        confirmedCase = c;
        date = d;
    }

    @Override // [주석 6 : 오버라이딩] 오버라이딩
    public void show() {
        System.out.println(date + " 기준");
        System.out.println(name + " 확진자 수 : " + confirmedCase + "명");
    }

    @Override // [주석 6 : 오버라이딩] 오버라이딩
    public void update(int c, String d) {
        confirmedCase = c;
        date = d;
    }
}

// 경기도, 경상도와 같은 자치도
class Province extends Korea { // [주석 2, 8 : 클래스 상속, 다형성] 클래스 상속 및 다형성
    String name;
    int confirmedCase;

    public Province(String n, int c, String d) { // [주석 3 : 생성자] 매개 변수를 가진 생성자
        name = n;
        confirmedCase = c;
        date = d;
    }

    @Override // [주석 6 : 오버라이딩] 오버라이딩
    public void show() {
        System.out.println(date + " 기준");
        System.out.println(name + " 확진자 수 : " + confirmedCase + "명");
    }

    @Override // [주석 6 : 오버라이딩] 오버라이딩
    public void update(int c, String d) {
        confirmedCase = c;
        date = d;
    }
}

// 검역
class Quarantine extends Korea { // [주석 2, 8 : 클래스 상속, 다형성] 클래스 상속 및 다형성
    String name;
    int confirmedCase;

    public Quarantine(String n, int c, String d) { // [주석 3 : 생성자] 매개 변수를 가진 생성자
        name = n;
        confirmedCase = c;
        date = d;
    }

    @Override // [주석 6 : 오버라이딩] 오버라이딩
    public void show() {
        System.out.println(date + " 기준");
        System.out.println(name + " 확진자 수 : " + confirmedCase + "명");
    }

    @Override // [주석 6 : 오버라이딩] 오버라이딩
    public void update(int c, String d) {
        confirmedCase = c;
        date = d;
    }
}

public class project {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Korea Korea = new Korea(510583, "2021.12.11");
        City Seoul = new City("서울", 180031, "2021.12.11");
        City Busan = new City("부산", 18584, "2021.12.11");
        City Daegu = new City("대구", 20260, "2021.12.11");
        City Incheon = new City("인천", 28639, "2021.12.11");
        City Gwangju = new City("광주", 6720, "2021.12.11");
        City Daejeon = new City("대전", 10026, "2021.12.11");
        City Ulsan = new City("울산", 5899, "2021.12.11");
        City Sejong = new City("세종", 1692, "2021.12.11");
        Province Gyeonggi = new Province("경기", 152303, "2021.12.11");
        Province Gangwon = new Province("강원", 10041, "2021.12.11");
        Province Chungbuk = new Province("충북", 9644, "2021.12.11");
        Province Chungnam = new Province("충남", 14662, "2021.12.11");
        Province Jeonbuk = new Province("전북", 7218, "2021.12.11");
        Province Jeonnam = new Province("전남", 4994, "2021.12.11");
        Province Gyeongbuk = new Province("경북", 12647, "2021.12.11");
        Province Gyeongnam = new Province("경남", 16584, "2021.12.11");
        Province Jeju = new Province("제주", 4112, "2021.12.11");
        Quarantine Quarantine = new Quarantine("검역", 6527, "2021.12.11");

        Korea.printLogo();

        while (true) {
            System.out.print("----------------------------\n");
            System.out.print("1. 한국 확진자 수 조회 | 2. 한국 확진자 수 업데이트 | 3. 지역별 확진자 수 조회 | 0. 종료 \n");
            System.out.print("번호를 선택해주세요. ");
            int input1 = 0;
            try { // [주석 10 : 예외 처리] 정수를 입력 받아야하는데 문자를 입력 하였을 때 예외처리
                input1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 값입니다. 정수만 입력해주세요.");
            }
            switch (input1) {
                case 1:
                    Korea.show();
                    break;
                case 2:
                    System.out.print("날짜 입력 : ");
                    String koreaD = scanner.next();
                    System.out.print("확진자 수 : ");
                    int koreaC = scanner.nextInt();
                    Korea.update(koreaC, koreaD);
                    break;
                case 3:
                    System.out.print("----------------------------\n");
                    System.out
                            .print("1. 경기도 | 2. 강원도 | 3. 충청도 | 4. 경상도 | 5. 전라도 | 6. 제주도 | 7. 검역 | 8. 처음으로 | 0. 종료 \n");
                    System.out.print("위치를 선택해주세요. ");
                    int input2 = scanner.nextInt();
                    switch (input2) {
                        case 1:
                            System.out.print("----------------------------\n");
                            System.out.print("경기도를 선택하셨습니다.\n");
                            System.out.print("1. 서울 | 2. 인천 | 3. 경기 | 4. 처음으로 | 0. 종료 \n");
                            System.out.print("상세 위치를 선택해주세요. ");
                            int gyeongido = scanner.nextInt();
                            switch (gyeongido) {
                                case 1:
                                    System.out.print("----------------------------\n");
                                    System.out.print("서울을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int seoul = scanner.nextInt();
                                    switch (seoul) {
                                        case 1:
                                            Seoul.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String seoulD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int seoulC = scanner.nextInt();
                                            Seoul.update(seoulC, seoulD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 2:
                                    System.out.print("----------------------------\n");
                                    System.out.print("인천을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int incheon = scanner.nextInt();
                                    switch (incheon) {
                                        case 1:
                                            Incheon.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String incheonD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int incheonC = scanner.nextInt();
                                            Incheon.update(incheonC, incheonD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 3:
                                    System.out.print("----------------------------\n");
                                    System.out.print("경기를 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int gyeonggi = scanner.nextInt();
                                    switch (gyeonggi) {
                                        case 1:
                                            Gyeonggi.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String gyeonggiD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int gyeonggiC = scanner.nextInt();
                                            Gyeonggi.update(gyeonggiC, gyeonggiD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 4:
                                    break;
                                case 0:
                                    System.out.print("프로그램을 종료하겠습니다.");
                                    scanner.close();
                                    System.exit(0);
                            }
                            break;
                        case 2:
                            System.out.print("----------------------------\n");
                            System.out.print("강원도를 선택하셨습니다.\n");
                            System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                            System.out.print("번호를 선택해주세요. ");
                            int gangwondo = scanner.nextInt();
                            switch (gangwondo) {
                                case 1:
                                    Gangwon.show();
                                    break;
                                case 2:
                                    System.out.print("날짜 입력 : ");
                                    String gangwonD = scanner.next();
                                    System.out.print("확진자 수 : ");
                                    int gangwonC = scanner.nextInt();
                                    Gangwon.update(gangwonC, gangwonD);
                                    break;
                                case 3:
                                    break;
                                case 0:
                                    System.out.print("프로그램을 종료하겠습니다.");
                                    scanner.close();
                                    System.exit(0);
                            }
                            break;
                        case 3:
                            System.out.print("----------------------------\n");
                            System.out.print("충청도를 선택하셨습니다.\n");
                            System.out.print("1. 대전 | 2. 세종 | 3. 충북 | 4. 충남 | 5. 처음으로 | 0. 종료 \n");
                            System.out.print("상세 위치를 선택해주세요. ");
                            int chungcheongdo = scanner.nextInt();
                            switch (chungcheongdo) {
                                case 1:
                                    System.out.print("----------------------------\n");
                                    System.out.print("대전을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int daejeon = scanner.nextInt();
                                    switch (daejeon) {
                                        case 1:
                                            Daejeon.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String daejeonD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int daejeonC = scanner.nextInt();
                                            Daejeon.update(daejeonC, daejeonD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 2:
                                    System.out.print("----------------------------\n");
                                    System.out.print("세종을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int sejong = scanner.nextInt();
                                    switch (sejong) {
                                        case 1:
                                            Sejong.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String sejongD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int sejongC = scanner.nextInt();
                                            Sejong.update(sejongC, sejongD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 3:
                                    System.out.print("----------------------------\n");
                                    System.out.print("충북을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int chungbuk = scanner.nextInt();
                                    switch (chungbuk) {
                                        case 1:
                                            Chungbuk.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String chungbukD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int chungbukC = scanner.nextInt();
                                            Chungbuk.update(chungbukC, chungbukD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 4:
                                    System.out.print("----------------------------\n");
                                    System.out.print("충남을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int chungnam = scanner.nextInt();
                                    switch (chungnam) {
                                        case 1:
                                            Chungnam.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String chungnamD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int chungnamC = scanner.nextInt();
                                            Chungnam.update(chungnamC, chungnamD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 5:
                                    break;
                                case 0:
                                    System.out.print("프로그램을 종료하겠습니다.");
                                    scanner.close();
                                    System.exit(0);
                            }
                            break;
                        case 4:
                            System.out.print("----------------------------\n");
                            System.out.print("경상도를 선택하셨습니다.\n");
                            System.out.print("1. 대구 | 2. 울산 | 3. 부산 | 4. 경북 | 5. 경남 | 6. 처음으로 | 0. 종료 \n");
                            System.out.print("상세 위치를 선택해주세요. ");
                            int gyeongsangdo = scanner.nextInt();
                            switch (gyeongsangdo) {
                                case 1:
                                    System.out.print("----------------------------\n");
                                    System.out.print("대구를 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int daegu = scanner.nextInt();
                                    switch (daegu) {
                                        case 1:
                                            Daegu.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String daeguD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int daeguC = scanner.nextInt();
                                            Daegu.update(daeguC, daeguD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 2:
                                    System.out.print("----------------------------\n");
                                    System.out.print("울산을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int ulsan = scanner.nextInt();
                                    switch (ulsan) {
                                        case 1:
                                            Ulsan.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String ulsanD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int ulsanC = scanner.nextInt();
                                            Ulsan.update(ulsanC, ulsanD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 3:
                                    System.out.print("----------------------------\n");
                                    System.out.print("부산을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int busan = scanner.nextInt();
                                    switch (busan) {
                                        case 1:
                                            Busan.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String busanD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int busanC = scanner.nextInt();
                                            Busan.update(busanC, busanD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 4:
                                    System.out.print("----------------------------\n");
                                    System.out.print("경북을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int gyeongbuk = scanner.nextInt();
                                    switch (gyeongbuk) {
                                        case 1:
                                            Gyeongbuk.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String gyeongbukD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int gyeongbukC = scanner.nextInt();
                                            Gyeongbuk.update(gyeongbukC, gyeongbukD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 5:
                                    System.out.print("----------------------------\n");
                                    System.out.print("경남을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int gyeongnam = scanner.nextInt();
                                    switch (gyeongnam) {
                                        case 1:
                                            Gyeongnam.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String gyeongnamD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int gyeongnamC = scanner.nextInt();
                                            Gyeongnam.update(gyeongnamC, gyeongnamD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 6:
                                    break;
                                case 0:
                                    System.out.print("프로그램을 종료하겠습니다.");
                                    scanner.close();
                                    System.exit(0);
                            }
                            break;
                        case 5:
                            System.out.print("----------------------------\n");
                            System.out.print("전라도를 선택하셨습니다.\n");
                            System.out.print("1. 광주 | 2. 전북 | 3. 전남 | 4. 처음으로 | 0. 종료 \n");
                            System.out.print("상세 위치를 선택해주세요. ");
                            int jeollado = scanner.nextInt();
                            switch (jeollado) {
                                case 1:
                                    System.out.print("----------------------------\n");
                                    System.out.print("광주을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int gwangju = scanner.nextInt();
                                    switch (gwangju) {
                                        case 1:
                                            Gwangju.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String gwangjuD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int gwangjuC = scanner.nextInt();
                                            Gwangju.update(gwangjuC, gwangjuD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 2:
                                    System.out.print("----------------------------\n");
                                    System.out.print("전북을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int jeonbuk = scanner.nextInt();
                                    switch (jeonbuk) {
                                        case 1:
                                            Jeonbuk.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String jeonbukD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int jeonbukC = scanner.nextInt();
                                            Jeonbuk.update(jeonbukC, jeonbukD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 3:
                                    System.out.print("----------------------------\n");
                                    System.out.print("전남을 선택하셨습니다.\n");
                                    System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                                    System.out.print("번호를 선택해주세요. ");
                                    int jeonnam = scanner.nextInt();
                                    switch (jeonnam) {
                                        case 1:
                                            Jeonnam.show();
                                            break;
                                        case 2:
                                            System.out.print("날짜 입력 : ");
                                            String jeonnamD = scanner.next();
                                            System.out.print("확진자 수 : ");
                                            int jeonnamC = scanner.nextInt();
                                            Jeonnam.update(jeonnamC, jeonnamD);
                                            break;
                                        case 3:
                                            break;
                                        case 0:
                                            System.out.print("프로그램을 종료하겠습니다.");
                                            scanner.close();
                                            System.exit(0);
                                    }
                                    break;
                                case 4:
                                    break;
                                case 0:
                                    System.out.print("프로그램을 종료하겠습니다.");
                                    scanner.close();
                                    System.exit(0);
                            }
                            break;
                        case 6:
                            System.out.print("----------------------------\n");
                            System.out.print("제주도를 선택하셨습니다.\n");
                            System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                            System.out.print("번호를 선택해주세요. ");
                            int jejudo = scanner.nextInt();
                            switch (jejudo) {
                                case 1:
                                    Jeju.show();
                                    break;
                                case 2:
                                    System.out.print("날짜 입력 : ");
                                    String jejuD = scanner.next();
                                    System.out.print("확진자 수 : ");
                                    int jejuC = scanner.nextInt();
                                    Jeju.update(jejuC, jejuD);
                                    break;
                                case 3:
                                    break;
                                case 0:
                                    System.out.print("프로그램을 종료하겠습니다.");
                                    scanner.close();
                                    System.exit(0);
                            }
                            break;
                        case 7:
                            System.out.print("----------------------------\n");
                            System.out.print("검역을 선택하셨습니다.\n");
                            System.out.print("1. 확진자 수 조회 | 2. 확진자 수 업데이트 | 3. 처음으로 | 0. 종료 \n");
                            System.out.print("번호를 선택해주세요. ");
                            int quarantine = scanner.nextInt();
                            switch (quarantine) {
                                case 1:
                                    Quarantine.show();
                                    break;
                                case 2:
                                    System.out.print("날짜 입력 : ");
                                    String quarantineD = scanner.next();
                                    System.out.print("확진자 수 : ");
                                    int quarantineC = scanner.nextInt();
                                    Quarantine.update(quarantineC, quarantineD);
                                    break;
                                case 3:
                                    break;
                                case 0:
                                    System.out.print("프로그램을 종료하겠습니다.");
                                    scanner.close();
                                    System.exit(0);
                            }
                            break;
                        case 8:
                            break;
                        case 0:
                            System.out.print("프로그램을 종료하겠습니다.");
                            scanner.close();
                            System.exit(0);
                    }
                    break;
                case 0:
                    System.out.print("프로그램을 종료하겠습니다.");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}