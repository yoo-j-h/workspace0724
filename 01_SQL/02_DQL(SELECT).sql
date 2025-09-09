/*
    테이블
    - 데이터 베이스에서 데이터를 저장하는 기본 개념
    - 행과 열로 구성된 데이터 집함
    
    컬럼
    - 테이블 내의 각 데이터 속성을 정의하는 필드
    - 컬럼은 테이블에서  저장할때 속성 = 값으로 저장
    
    => 테이블은 여러 컬럼으로 구성되고, 각 컬럼을 테이브이 표현하는 데이터의 세부적인 속성을 나타냄.
    <select>
    select 컬럼명1, 컬럼명2, ... 
    from table;
    [where = 조건]
    [oder by = 정렬기준(asc | desc)]
*/
--1.job 테이블의 모든 정보 조회
SELECT * FROM JOB;

--2. job 테이블의 직급 이름만 조회
SELECT JOB_NAME FROM JOB;

--3. department 테이블 모든정보 조회
SELECT * FROM department;

--4. employee 테이블의 직원명, 이메일, 전화번호, 고용일 조회
SELECT emp_name, email,phone, hire_date FROM employee;

--5. employee 테이블에서 이름, 연봉, 총수령액(보너스 포함), 실수령액(총수령액 - (연봉 * 세금(3%))) 조회
SELECT emp_name, salary*12 연봉, (salary + (salary * NVL(bonus,0)))*12 총수령액,
((salary + (salary * NVL(bonus,0)))*12) - (salary * 12 * 0.03) as "실수령액"
FROM employee;

--데이터 베이스에서 null은 빈값을 의미한다.
--모든 연산에서 null이 포함된 경우, 결과는 null이 된다.

--사원명, 입사일, 근무일수를 employee테이블에서 조회
--데이터 베이스에서 날짜를 계산할때 덧셈 뺄셈이 가능하다.
--현재시간 - 입사일 = 근무시간
--DATE -DATE => 결과를 무조건 일로 표시한다.
--코드 실행시 현재날짜를 표시하는 상수 : sysdate[년/월/일/시/분/초]
SELECT emp_name,sysdate - hire_date FROM employee;

--dual테이블은 오라클에서 제공하는 가상 테이블이다.
SELECT sysdate FROM dual;


/*
    <컬럼 별칭>
    컬럼명에 별칭을 부여하면 깔끔하게 표현할 수 있음.
    [표현식]
    컬럼명 별칭 / 컬럼명 as 별칭/ 컬람명 "별칭"/ 컬럼명 as "별칭"
*/

SELECT emp_name 사원명, salary as 급여, bonus "보너스", salary * 12 as "연봉" 
FROM employee;

/*
    <리터럴>
    직접 값을 나타내는 단위, 임의로 지정한 값
*/

SELECT emp_id, emp_name, salary, '원' FROM employee;

/*
    <연결 연산자 : ||>
    여러 컬럼값들을 마치 하나의 컬럼처럼 연결할 수 있음.
*/

SELECT emp_name || '님 급여는 ' || salary || '원'
FROM employee;

/*
    <DISTINCT>
    중복제거 - 컬럼에 표시된 값들을 한번씩만 조회하고자 할때 사용
*/

--실제로 사용되고 있는 직급목록
SELECT DISTINCT job_code FROM employee;

--실제로 사용되고 있는 부서목록
SELECT DISTINCT dept_code FROM employee;

--SELECT DISTINCT emp_name,DISTINCT job_code,DISTINCT dept_code FROM employee;
--위처럼 사용시 에러가 발생, DISTINCT는 한 명령어 에서 한번만 사용가능

--DISTINCT는 항상 ROW데이터 전체에 대해서 중복을 제거한다.
SELECT DISTINCT job_code, dept_code FROM employee;
--위처럼 사용시 (job_code, dept_code)를 쌍으로 묶어서 중복을 제거한 값을 보여준다.

--==================================================================================
/*
    <where 절>
    조회하고자하는 테이블로부터 특정 조건에 만족하는 데이터만 조회하고자 할 때 사용함.
    조건식에서도 다양한 연산자를 사용할 수 있음.
    
    [표현법]
    SELESCT 컬럼, 컬럼, ...
    FROM 테이블명
    WHERE 조건;
    
    >>비교연산자<<
    >, <, <=, >= : 대소비교
    = : 양쪽이 동일하다.
    != , ^=, <> : 양쪽이 다르다.
*/

--employee테이블에서 부서코드가 d9인 사원들만 조회(모든 컬럼)

SELECT * FROM employee WHERE dept_code = 'D9';

--employee에서 부서코드가 'd1'인 사원들의 사원명, 급여, 부서코드 조회

SELECT emp_name, salary, dept_code FROM employee WHERE dept_code = 'D1';

--employee에서 부서코드가 'd1'가 아닌 사원들의 사원명, 급여, 부서코드 조회

SELECT emp_name, salary, dept_code FROM employee WHERE dept_code != 'D1';

--월급이 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary FROM employee WHERE salary >= 4000000;

/*
    <AND, OR 연산자>
    조건을 여러개 연결할 때 사용
    [표현법]
    조건A AND 조건B -> 조건A와 조건B가 모두 만족하는 값만 참으로 한다.
    조건A OR 조건B -> 조건A와 조건B중 하나만 만족해도 참으로 한다.
    
    <BETWEEN AND>
    조건식에 사용되는 구문
    몇이상 몇이하인 범위에 대한 조건을 제시할 때 주로 사용하는 연산자(이산, 이하만 가능)
    [표현법]
    비교대상 컬럼 BETWEEN 하안값 AND 상한값;
*/

--급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
SELECT emp_name, emp_id, salary  
FROM employee 
--WHERE salary >= 3500000 AND salary <= 6000000;
WHERE salary BETWEEN 3500000 AND 6000000;

--NOT : 논리부정 연산자
--컬럼명 앞에 또는 BETWEEN앞에 선언 가능

SELECT emp_name, emp_id, salary  
FROM employee 
--WHERE salary >= 3500000 AND salary <= 6000000;
WHERE NOT salary BETWEEN 3500000 AND 6000000;

--입사일이 '90/01/01'이상 '01/01/01' 이하인 사원들을 전체 조회
SELECT * FROM employee 
--WHERE hire_date >= '90/01/01' AND hire_date <= '01/01/01';
WHERE hire_date BETWEEN '90/01/01' AND '01/01/01';

--NULL을 비교연산할 때 =을 사용할 수 없다.
--NULL값을 비교할때는 IS NULL, IS NOT NULL을 사용한다.
SELECT * FROM employee 
--WHERE bonus is null;
WHERE bonus is not null;


--------------------------------------------------------------------------

/*
    <LIKE>
    비교하고자하는 컬럼값이 내가 제시한 특정 패턴에 만족할 경우 조회
    
    [표현법]
    비교한 대상 컬럼 LIKE '특정패턴'; ->일치하는 것만 조회
    
    특정패턴을 제시할 때 와일드카드라는 개념이 정의되어있다.
    1. '%' : 포함문자 검색(0글자 이상 전부 조회)
    EX) 비교할 대상 컬럼 LIKE '문자%' : 비교할 대상컬럼 값 중에서 해당문자로 시작하는 값을 전부 조회
        비교할 대상 컬럼 LIKE '%문자' : 비교할 대상컬럼 값 중에서 해당문자로 끝나는 값을 전부 조회
        비교할 대상 컬럼 LIKE '%문자%' : 비교할 대상컬럼 값 중에서 해당문자가 포함된 값을 전부 조회
        
        2. '_': 1글자를 대체검색할 때 사용
        EX) 비교할 대상 컬럼 LIKE '_문자' : 비교할 대상컬럼 값 문자앞에 아무글자나 딱 한글자가 있는 값을 조회
        EX) 비교할 대상 컬럼 LIKE '문자_' : 비교할 대상컬럼 값 문자뒤에 아무글자나 딱 한글자가 있는 값을 조회
        EX) 비교할 대상 컬럼 LIKE '_문자_' : 비교할 대상컬럼 값 문자앞뒤에 아무글자나 딱 한글자가 있는 값을 조회

        EX) 비교할 대상 컬럼 LIKE '_문자__' : 내가 원하는 형태로 _를 통해서 문자수를 조절할 수 있다.

*/
SELECT emp_name, salary 
FROM employee 
WHERE emp_name LIKE '전%';

SELECT emp_name, salary 
FROM employee 
WHERE emp_name LIKE '%연';

SELECT emp_name, salary 
FROM employee 
WHERE emp_name LIKE '%하%';

SELECT emp_name, salary 
FROM employee 
WHERE emp_name LIKE '전__';

SELECT emp_name, salary 
FROM employee 
WHERE emp_name LIKE '_하_';

--사원들 중에서 전화번호 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호 조회

SELECT emp_id, emp_name, phone 
FROM employee WHERE phone LIKE '__1%';

--이메일 중 _앞의 글자가 3글자인 사원들의 사번, 이름, 이메일 조회
SELECT emp_id, emp_name, email FROM employee 
--WHERE email LIKE '____%';
-- WHERE email LIKE '____%'; -> 와일드카드로 인식되기 때문에 정상적으로 출력할 수 없다.
--와일드카드를 직접 문자로 사용할 때는 일반문자로 구분을 해줘야함
-- ESCAPE OPYION을 등록해서 나만의 탈출문자를 사용할 수 있음
WHERE email LIKE '___/_%' ESCAPE '/';

-------------------------------------------------------------------------------
/*
    <IN>
    WHERE절에 비교대상 컬럼값을 가지고 내가 제시한 목록중에 일치하는 값이 있는지 검사하는 문법
    
    [표현법]
    비교대상 컬럼 IN (값,값,값,값, ...)
*/

--부서코드가 d6이거나 d8이거나 d5인 부서원들의 이름, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary FROM employee 
--WHERE dept_code ='D6' OR dept_code ='D8' OR dept_code ='D5';
WHERE dept_code IN ('D6', 'D8', 'D5');

/*
    <연산자 우선순위>
    1. 산술연산자
    2. 연결연산자
    3. 비교연산자
    4. IS NULL/ LIKE/ IN
    5. BETWEEN A AND B
    6. NOT
    7. AND
    8. OR
*/

--------------------------실습-------------------------------------------------

--1. 이름이 '연' 으로 끝나는 사원들의 사원명, 입사일 조회
SELECT emp_name, hire_date FROM employee 
WHERE emp_name LIKE '%연';

--2. 전화번호 처음 3자리가 010이 아닌 사원들의 사원명, 전화번호 조회
SELECT emp_name, phone FROM employee 
WHERE NOT phone LIKE '010%';

--3. 이름에 '하'가 포함되어 있고 급여가 240만원 이상인 사원들의 사원명, 급여 조회
SELECT emp_name, salary FROM employee 
WHERE emp_name LIKE '%하%' AND salary >= 2400000;

--4. 부서 테이블에서 해외영업부서인 부서들의 부서코드, 부서명 조회
SELECT dept_id, dept_title FROM department 
WHERE dept_title LIKE '%해외영업%';

--5. 사수가 없고 부서배치도 받지 않은 사원들의 사원명, 사번, 부서코드 조회
SELECT emp_name, emp_id, dept_code FROM employee 
WHERE manager_id IS NULL AND dept_code IS NULL;

--6. 연봉(급여 *12)이 3천만원 이상이고 보너스를 받지않는 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT emp_id, emp_name, salary, bonus FROM employee 
WHERE salary * 12 >= 30000000 AND bonus IS NULL;

--7. 입사일이 '95/01/01' 이상이고 부서배치를 받지않은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT emp_id, emp_name, hire_date, dept_code FROM employee 
WHERE hire_date >= '95/01/01' AND dept_code IS NULL;

--8. 급여가  200만원 이상이고 500만원 이하인 사원중에서 입사일이 '01/01/01' 이상이고 보너스를 받지않는
--   사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT emp_id, emp_name, salary, hire_date, bonus FROM employee 
WHERE salary BETWEEN 2000000 AND 5000000 
AND hire_date >= '01/01/01' AND bonus IS NULL;


--9. 보너스를 포함 연봉이 null이 아니고 이름에 '하'가 포함된 사원들의 사번, 사원명, 급여, 보너스 포함 연봉 조회
SELECT emp_id, emp_name, salary, hire_date, bonus FROM employee 
WHERE (salary + (salary * bonus))*12 IS NOT NULL AND emp_name LIKE '%하%';

/*
    <ORDER BY절>
    데이터를 정렬해서 조회하기 위한 구문
    SELECT문 가장 마지막 줄에 작성, 실행순서 또한 가장 마지막에 실행됨
    
    [표현법]
    SELECT 조회할 컬럼 ...
    FROM 테이블
    WHERE 조건식
    ORDER BY 정렬기준이 될 컬럼| 별칭 |컬럼 순번 [ASC|DESC] [NULLS FIRST | NULLS LAST]
    
    - ASC : 오름차순(작은값으로 시작해서 점점 커짐) -> 기본값
    - DESC : 내림차순(큰값으로 시작해서 값이 줄어듬)
    
    - null은 기본적으로 가장 큰 값으로 분류해서 정렬한다.
    
*/

SELECT * 
FROM employee
--ORDER BY bonus DESC;
--ORDER BY bonus ASC NULLS FIRST;
ORDER BY bonus DESC, salary ASC;

--정렬기준에 컬럼값이 동일할 경우 그 다음차순을 위해서 여러개의 기준 컬럼을 제시할 수 있다.

--전 사원의 사원명, 연봉 조회 (이때 연봉을 기준으로 내림차순 정렬) 
SELECT emp_name, salary *12 as "연봉"
FROM employee
--ORDER BY salary * 12 DESC;
--ORDER BY 연봉 DESC;
ORDER BY 2 DESC;


