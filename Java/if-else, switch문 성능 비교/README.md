# if-else, switch문 성능 비교
## if문과 switch문 문법 차이
### if문
```java
if (boolean 값) {
    처리문장1;
    처리문장2;
    ...
} else if (boolean 값) {
    처리문장3;
    처리문장4;
    ...
} else {
	처리문장5;
	처리문장6;
	...
}
```

### switch문
```java
switch(비교대상변수) {
    case 점검값1:
       처리문장1;
       ...
       break;
    case 점검값2:
       처리문장2;
       ...
       break;
       ...
    default:
       기본처리문장;
       ...
       break;
}
```
- 비교 대상 변수에 Java 6 까지는 long을 제외한 정수와 Enum, 
몇몇 참조 자료형에서만 switch를 사용할 수 있었지만, Java 7부터 String도 사용 가능

## 성능
- 직접 예제 코드를 실행하여 비교해보자.
```java
public class IfSwitch {

        int MAX = 100000000;

        public static void main(String[] args) {
                IfSwitch ex = new IfSwitch();
                long millis = System.currentTimeMillis();
                ex.ifEx();
                System.out.println(System.currentTimeMillis() - millis);
                millis = System.currentTimeMillis();
                ex.switchEx();
                System.out.println(System.currentTimeMillis() - millis);
        }

        public void ifEx() {
                int cnt = 0;
                int ans;
                while (cnt++ < MAX) {
                        if (cnt == 0) {
                                ans = 1;
                        } else if (cnt == 1) {
                                ans = 1;
                        } else if (cnt == 2) {
                                ans = 1;
                        } else if (cnt == 3) {
                                ans = 1;
                        } else if (cnt == 4) {
                                ans = 1;
                        } else if (cnt == 5) {
                                ans = 1;
                        } else if (cnt == 6) {
                                ans = 1;
                        } else if (cnt == 7) {
                                ans = 1;
                        } else if (cnt == 8) {
                                ans = 1;
                        } else {
                                ans = 1;
                        }
                }
        }

        public void switchEx() {
                int cnt = 0;
                int ans;

                while (cnt++ < MAX) {
                        switch (cnt) {
                                case 0:
                                        ans = 1;
                                        break;
                                case 1:
                                        ans = 1;
                                        break;
                                case 2:
                                        ans = 1;
                                        break;
                                case 3:
                                        ans = 1;
                                        break;
                                case 4:
                                        ans = 1;
                                        break;
                                case 5:
                                        ans = 1;
                                        break;
                                case 6:
                                        ans = 1;
                                        break;
                                case 7:
                                        ans = 1;
                                        break;
                                case 8:
                                        ans = 1;
                                        break;
                                default:
                                        ans = 1;
                                        break;
                        }
                }
        }
}
```
- JDK version : openjdk 11.0.11 2021-04-20 LTS
- 운영체제 : macOS Monterey 12.6
- 기종 : MacBook Air (M1, 2020), 16GB
```text
if : 155
switch : 19
```
- 동일하게 8개의 조건을 1억번의 연산을 하였을 때 다음과 같은 결과가 나온다. 조건을 줄여서 다시 실행해보자.
```java
public class IfSwitch {

        int MAX = 100000000;

        public static void main(String[] args) {
                IfSwitch ex = new IfSwitch();
                long millis = System.currentTimeMillis();
                ex.ifEx();
                System.out.println("if : " + (System.currentTimeMillis() - millis));
                millis = System.currentTimeMillis();
                ex.switchEx();
                System.out.println("switch : " + (System.currentTimeMillis() - millis));
        }

        public void ifEx() {
                int cnt = 0;
                int ans;
                while (cnt++ < MAX) {
                        if (cnt == 0) {
                                ans = 1;
                        } else {
                                ans = 1;
                        }
                }
        }

        public void switchEx() {
                int cnt = 0;
                int ans;

                while (cnt++ < MAX) {
                        switch (cnt) {
                                case 0:
                                        ans = 1;
                                        break;
                                default:
                                        ans = 1;
                                        break;
                        }
                }
        }
}
```
```text
if : 20
switch : 19
```
- 조건의 개수가 적을 때에는 크게 차이나지 않는 것을 볼 수 있다.
- 왜 이런 결과가 나올까? 구현 방식에 차이가 있다.

### if문 구현 방식
- Branch Statement 방식으로 구현
- 레지스터 2개를 비교해서 특정 메모리 번지로 이동할 것인지 결정
- 조건이 만족하면 실행 / 만족하지 않으면 무시
- 각 조건마다 그 조건을 처리할 수 있게 레지스터를 변경해주는 일들이 먼저 선행되어 오버헤드가 발생

### switch문 구현 방식
- Jump Statement 방식으로 구현
- 즉시, 특정 메모리 번지로 이동하는 방식
- 점프 테이블을 만들고, 입력된 값을 보고 특정 위치로 점프
- 점프 테이블을 만들기만 하면 조건이 몇 개든 훨씬 빠르고 쉽게 넘어감
- 점프 테이블을 만드는 오버헤드 발생

## 결론
- 따져야 할 조건 수가 적을 경우 if문이 유리
- 따져야 할 조건의 수가 많을 경우 switch문이 유리. but, 메모리가 중요한 작업이라면 생각해 볼 필요가 있음

#### 출처
- https://thinkpro.tistory.com/132