# 메뉴 주문 시스템 (Menu Ordering System)

## 📝 프로젝트 개요
콘솔 기반으로 작동하는 간단한 음식 주문 시스템입니다. 
디자인 패턴과 클린 코드를 연습하기 위해 작성했습니다.

## 🛠 주요 기능

### 메뉴 관리
- 메뉴 등록 (관리자): 메뉴 이름, 가격, 설명 등의 정보 등록
- 메뉴 조회 (사용자): 판매 중인 메뉴 목록 확인 (메뉴 이름, 가격, 설명 포함)

### 주문 프로세스
- 메뉴 선택: 메뉴 번호 또는 이름으로 선택
- 수량 입력: 선택한 메뉴의 주문 수량 지정
- 주문 추가: 선택한 메뉴와 수량을 주문 목록에 추가
- 주문 취소: 주문 목록의 항목 취소 기능 (선택적)

### 주문 관리
- 주문 내역 확인: 현재 주문한 메뉴, 수량, 가격 정보 표시
- 총 주문 금액 계산: 현재 주문의 총 금액 표시
- 결제 처리: 주문 확인 및 결제 진행 (결제 완료 메시지 출력)

### 예외 처리
- 잘못된 입력 처리
- 재고 부족 상황 처리 (선택적)

## 💡 디자인 패턴 적용

### 사용된 디자인 패턴
- **싱글톤 패턴**: 메뉴 관리 클래스의 전역적 접근
- **팩토리 메서드 패턴**: 메뉴 객체 생성 관리
- **전략 패턴**: 다양한 할인 정책 구현

### 클린 코드 원칙
- 의미 있는 변수 및 메서드 이름 사용
- 단일 책임 원칙에 따른 메서드 분리
- 코드 중복 최소화
- 명확한 주석 작성
- 테스트 코드 작성 (JUnit)

## 🎯 사용 시나리오

```
1. 시스템 시작 → 메뉴 목록 출력
2. 메뉴 선택 (예: 김치찌개) 및 수량 입력 (2개)
3. 추가 메뉴 선택 (예: 콜라) 및 수량 입력 (1개)
4. 주문 내역 확인
5. 최종 결제 진행
6. 주문 완료
```

## 🔧 기술 스택
- Java
- JUnit (테스트)

## 📥 설치 및 실행 방법
```bash
# 프로젝트 클론
git clone [repository URL]

# 프로젝트 디렉토리로 이동
cd [project directory]

# 실행
java -jar [filename].jar
```

## 👥 기여 방법
1. 프로젝트 포크
2. 새로운 브랜치 생성
3. 변경사항 커밋
4. 풀 리퀘스트 생성
