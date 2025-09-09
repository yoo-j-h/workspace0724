/*
    <함수 FUNCTION>
    전달된 컬럼값을 읽어들여서 함수(기능)를 실행한 결과를 반환
    
    -단일행 함수 : n개의 값을 읽어들여서 n개의 결과값을 리턴(매행마다 함수실행결과를 반환) 
    -그룹 함수 : n개의 값을 읽어들여서 1개의 결과값을 리턴 (그룹을 지어 그룹별로 함수 실행 결과를 반환)
    
    >>SELECT 절에 단일행 함수와 그룹합수를 함께 사용하지 못한다.
    왜? 결과행의 갯수가 서로 다르기 때문에
    
    >>함수를 사용할 수 있는 위치 : SELECT절, WHERE절, ORDER BY절 GROUP BY절 HAVING절
*/

---------------------------------------단일행 함수---------------------------------------
/*
    <문자처리함수>
    *LENGTH(컬럼 | '문자열') : 해당 문자열의 글자수를 반환
    *LENGTHB(컬럼 | '문자열') :  해당문자열의 바이트수를 반환
    
    '최' '나' 'ㄱ' 한글은 글자당 3바이트
    영문자, 숫자, 특수문자 글자당 1바이트
*/

SELECT LENGTH('오라클'), LENGTHB('오라클') FROM DUAL;

SELECT LENGTH('oracle'), LENGTHB('oracle') FROM DUAL;

SELECT emp_name, LENGTH(emp_name), LENGTHB(emp_name)FROM employee;

-----------------------------------------------------------------
/*
    *INSTR
    문자열로부터 특정 문자의 시작위치를 찾아서 반환
    
    INSTR(컬럼 | '문자열', '찾고자하는 문자', ['찾을 위치의 시작값', 순번])-> 결과는  NUMBER
*/
SELECT instr('AABAACAABBAA', 'B') FROM dual;
--찾을 위치의 시작 값 : 1, 순번 : 1 -> 기본값

SELECT instr('AABAACAABBAA', 'B', 1) FROM dual;
SELECT instr('AABAACAABBAA', 'B', -1) FROM dual;
SELECT instr('AABAACAABBAA', 'B', 1, 2) FROM dual;

SELECT email, instr(email, '@')as"@위치" FROM employee;

-----------------------------------------------------------------------------------
/*
    *SUBSTR
    문자열에서 특정 문자열을 추출해서 반환
    
    [표현법]
    SUBSTR(컬럼 | '문자열', 추출 시작위치, [추출문자 갯수])
*/

SELECT substr('SHOWMETHEMONEY', 7) FROM dual; -- 7번위치 부터 끝까지
SELECT substr('SHOWMETHEMONEY', 5, 2) FROM dual;
SELECT substr('SHOWMETHEMONEY', 1, 6) FROM dual;
SELECT substr('SHOWMETHEMONEY', -8, 3) FROM dual;

SELECT emp_no, emp_name, substr(emp_no,8,1)as 성별 FROM employee;

--사원들 중 여자사원들만 이름과 주민번호를 조회
SELECT emp_name, emp_no 
FROM employee 
WHERE substr(emp_no,8,1) IN ('1','3');

--함수는 중첩사용 가능
SELECT emp_name, email, substr(email,1,instr(email, '@')-1) as 아이디 
FROM employee;

--------------------------------------------------------------------------------
/*
    *LPAD / RPAD
    문자열을 조회할 때 통일감 있게 조회하고자 정렬을 하는 함수
    
    [표현법]
    LPAD/RPAD(문자열, 최종적으로 반환활 문자열의 길이, [덧붙이고자하는 문자])
*/
--30만큼의 길이 중 email컬럼 값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다.
SELECT emp_name, LPAD(email, 30) 
FROM employee;

SELECT emp_name, LPAD(email, 30, '#') 
FROM employee;

SELECT emp_name, RPAD(email, 30, '#') 
FROM employee;

--사원들의 사원명, 주민번호("123456-1XXXXX")
--SELECT emp_name, RPAD(substr(emp_no, 1, 8), 14, 'X') 
SELECT emp_name,substr(emp_no, 1, 8) || 'XXXXXX'
FROM employee;

---------------------------------------------------------------------------------
/*
    LTRIM/RTRIM
    문자열에서 특정 문자를 제거한 나머지를 반환
    
    [표현법]
    LTRIM/RTRIM(컬럼 | '문자열', [제거하고 싶은 문자들])
    
    문자열의 왼쪽 또는 오른쪽에서 제거하고자 하는 문자들을 찾아서 제거한 나머지 문자열 반환
*/
SELECT LTRIM('   K   H   ') FROM dual; --앞에서 부터 다른 문자가 나올 때 까지 공백을 제거
SELECT RTRIM('132123KH123', '123') FROM dual;
SELECT LTRIM('ABCABABCCBCKBA', 'ABC') FROM dual; --제거하고자하는 문자는 문자열이 아닌 문자들

/*
    TRIM
    문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
    TRIM([LEADING | TRAILING | BOTH])제거하고자하는 문자열 from 문자열
*/

SELECT TRIM('   K  H      ')FROM dual; --기본값 양쪽
SELECT TRIM(BOTH 'z' FROM 'zzzzK  Hzzzzzz')FROM dual;
SELECT TRIM(TRAILING 'z' FROM 'zzzzK  Hzzzzzz')FROM dual;
SELECT TRIM(LEADING 'z' FROM 'zzzzK  Hzzzzzz')FROM dual;
-------------------------------------------------------------
/*
    LOWER / UPPER / INITCAP
    LOWER : 모든 문자열을 소문자로 변경해서 반환
    UPPER : 모든 문자열을 대문자로 변경해서 반환
    INITCAP : 띄어쓰기 기준 첫글자마다 대문자로 변경한 문자열 반환
*/

SELECT LOWER('Welcome TO My KH') FROM dual;
SELECT UPPER('Welcome TO My KH') FROM dual;
SELECT INITCAP('Welcome TO My KH') FROM dual;

-------------------------------------------------------------------
/*
    *CONCAT
    문자열 두개 전달 받아서 하나로 합친 후 반환
    CONCAT(STR1, STR2)
*/

SELECT CONCAT('가나다', 'ABC') FROM dual;
SELECT '가나다' || 'ABC' FROM dual;

-----------------------------------------------------------------------
/*
    *REPLACE
    특정 문자열에서 특정부분을 다른 부분으로 교체
    REPLACE (문저욜, 찾을 문자열, 치환할 문자열)
*/

SELECT email, REPLACE(email, 'C##SERVER', 'kh') FROM employee;


-------------------------<숫자 처리 함수>--------------------------------
/*
    
    *ABS
    숫자의 절대값을 구하는 함수
*/

SELECT ABS(-10), ABS(-5.4) FROM dual;

-----------------------------------------------------------------------
/*
    *MOD
    두수를 나눈 나머지 값을 반환
    MOD(값, 나누는 값)
*/

SELECT MOD(10,3) FROM dual;
SELECT MOD(10.9,3) FROM dual;

------------------------------------------------------------------------
/*
    *ROUND
    반올림한 결과를 반환
    ROUND(값, [위치])
*/

SELECT ROUND(123.456) FROM dual; --기본차수는 소수점 첫번째 자리에서 반올림
SELECT ROUND(123.456, 2) FROM dual; --위치값이 양수로 증가할 수록 소수점이 뒤로 한칸씩 이동함
SELECT ROUND(123.456, -1) FROM dual; --위치값이 음수로 감소할수록 소수점이 앞으로 한칸씩 이동함

/*
    *CEIL
    올림처리를 위한 함수
    CEIL(값)
*/

SELECT CEIL(123.456) FROM dual;

/*
    TRUNC, FLOOR
    버림처리 함수
   
    TRUNC(값, 위치)
    FLOOR(값)
    
*/

SELECT TRUNC(123.456) FROM dual;
SELECT TRUNC(123.456, 1) FROM dual;
SELECT TRUNC(123.456, -1) FROM dual;

-------------------------------------------------------------
/*
    <날짜처리함수>
*/


--SYSDATE : 시스템의 현재 날짜및 시간을 반환

SELECT sysdate FROM dual;

--MONTHS_BETWEEN : 두 날짜 사이의 개월 수를 반환
--사원들의 사원명, 입사일, 근무일수, 근무 개월수
SELECT emp_name, hire_date, FLOOR(sysdate - hire_date) as 근무일, CEIL(months_between(sysdate, hire_date)) 
FROM employee;

--ADD MONTHS : 특정 날짜에 개월수를 더한 값을 반환
SELECT ADD_MONTHS(SYSDATE, 7) FROM dual;

--사원 테이블에서 사원명, 입사일, 수습기간 종료일(입사일로 부터 3개월 뒤)을 조회
SELECT emp_name, hire_date, add_months(hire_date,3) FROM employee;

--NEXT_DAY(DATE, 요일(문자|숫자)) : 특정 날짜 이후 가장 가까운 요일의 날짜를 반환
SELECT NEXT_DAY(SYSDATE, '토요일') FROM dual;
-- 1 : 일 ~ 7 : 토

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;


--LAST_DAY(DATE) : 해당월의 마지막 날짜를 구해서 반환
SELECT LAST_DAY(SYSDATE) FROM dual;

/*
    EXTRACT : 특정 날짜로부터 년|월|일 값만 추출해서 반환
    
    [표현법]
    EXTRACT (YEAR FORM DATE) : 연도만 추출
    EXTRACT (MONTH FORM DATE) : 월만 추출
    EXTRACT (DAY FORM DATE) : 일만 추출
    
*/

--사원의 사원명, 입사년도, 입사월, 입사일 조회

SELECT emp_name, 
    EXTRACT(YEAR FROM hire_date) as 입사년도,
    EXTRACT(MONTH FROM hire_date)as 입사월, 
    EXTRACT(DAY FROM hire_date)as 입사일
FROM employee;

-----------------------------------------------------------------

/*
    <형변환 함수>
    *TO_CHAR : 숫자타입 또는 날짜타입의 값을 문자타입으로 변환시켜주는 함수
    
    [표현법]
    TO_CAHR(숫자 | 문자,[포멧])
*/

--숫자 -> 문자
SELECT TO_CHAR(1234) FROM dual;

SELECT TO_CHAR(12, '99999') FROM dual; -- 9의 자리수 만큼 공간 확보
SELECT TO_CHAR(12, '00000') FROM dual; -- 0의 자리수 만큼 공간 확보, 빈칸을 0으로 채움

SELECT to_char(2000000, 'L9999999') FROM dual; --현재 설정된 나라의 로컬 화폐단위를 나타냄
SELECT to_char(2000000, '9,999,999') FROM dual;

--날짜타입 -> 문자타입
SELECT sysdate FROM dual;
SELECT to_char(sysdate) FROM dual;
SELECT to_char(sysdate, 'HH"시" MI"분" SS"초"') FROM dual;
SELECT to_char(sysdate, 'YYYY-MM-DD DY HH:MI:SS') FROM dual;

--~년~월~일~시~분~초
SELECT to_char(sysdate, 'YYYY"년" MM"월" DD"일" HH"시" MI"분" SS"초"') FROM dual;

--년도와 관련도니 포맷
SELECT to_char(sysdate, 'YYYY'),
        to_char(sysdate, 'RRRR'),
        to_char(sysdate, 'YY'),
        to_char(sysdate, 'YEAR')
FROM dual;

SELECT to_date('2025', 'YYYY'), 
        to_date('2025', 'RRRR'),
        to_date('25', 'YY'),
        to_date('25', 'RR'),
        to_date('60', 'YY'),--YY항상 입력 그대로 해석 -> 현재년도를 반영
        to_date('60', 'RR') -- 2자리 입력시 현재 세기를 기준으로 자동보정
from dual;

--월과 관련된 포맷
SELECT to_char(sysdate,'MM'),to_char(sysdate,'MON'),to_char(sysdate,'MONTH')
FROM dual;

--일과 관련된 포맷
SELECT to_char(sysdate,'DDD'),to_char(sysdate,'DD'),to_char(sysdate,'D')
FROM dual;

--요일을 나타내는 포맷
SELECT to_char(sysdate,'D'),to_char(sysdate,'DAY'),to_char(sysdate,'DY')
FROM dual;

-------------------------------------------------------------------------------
/*
    TO_DATE : 숫자타입 또는  문자타입을 날짜타입르로 번경하는 함수
    
    TO_DATE(숫자 | 문자, [포맷])-> DATE;
    
*/
SELECT TO_DATE(20100101) from dual;

SELECT TO_DATE(311201) from dual; --기본적으로 연도를 2자리만 입력시 RR률이 적용된다.

SELECT TO_DATE(051001) from dual; --0으로 시작하는 숫자는 없다.
SELECT TO_DATE('051001') from dual;

SELECT to_date('20020505 180500', 'YYYYMMDD HH24MISS') FROM dual;
/*
    TO_NUMBER : 문자타입의 데이터를 숫자타입으로 변환해서 반환.
    
    [표현법]
    TO_NUMBER(문자/[포맷])
*/

SELECT TO_NUMBER('065432165841564') FROM dual;
SELECT '1000' + '50000' FROM dual;
SELECT TO_NUMBER('100,100', '999,999') FROM dual;

/*
    <NULL처리 함수>
*/
--NVL(컬럼, 해당컬럼이 null일 경유 보줄 값)
SELECT emp_name, bonus, nvl(bonus, 0)
FROM employee;

--전 사원의 이름, 보너스 포함 연봉조회
SELECT emp_name, (salary + (salary * nvl(bonus,0)))*12 FROM employee;

--NVL2 (컬럼, 반환값1, 반환값2)
--반환값1 : 해당컬럼이 존재하면 보여줄 값
--반환값2 : 해당컬럼이 존재하지 않으면 보여줄 값
SELECT emp_name, bonus, NVL2(bonus, 'O', 'X') FROM employee;

--NULLIF(비교대상1, 비교대상2)
--두값이 일치하면 null반환, 일치하지 않으면 비교대상1 반환

SELECT NULLIF('123','123') FROM dual;

----------------------------------------------------------------------
/*
    [선택함수]
    DECODE(비교하고자하는 대상, 비교값1, 결과값1, 비교값2, 결과값2 ...)
*/

--사번, 사원명, 주민번호, 성별
SELECT emp_id, emp_name, emp_no,
    DECODE(substr(emp_no, 8, 1),'1','남','2','여','3','남','4','여','잘못입력') as 성별
FROM employee;

-- 직원의 이름, 기존급여, 인상된 급여 조회(각 직급별로 차등인상)
--직급이 J7은 급여를 10%인상
--직급이 J6은 급여를 15%인상
--직급이 J5은 급여를 20%인상
--그외 직원들은 급여를 5%인상
SELECT emp_name, salary,
    DECODE(job_code,
        'J7', salary * 1.1,
        'J6', salary * 1.15,
        'J5', salary * 1.2,
        salary * 1.05
        ) as 인상후
FROM employee;

/*
     CASE문
     SQL에서 조건에 따라 값을 분기하고 싶을 때 사용하는 구문
     
     [표현법]
     CASE
        WHEN 조건1 THEN 결과1
        WHEN 조건2 THEN 결과2
        ...
        ELSE 기본결과
    END
*/

SELECT emp_name, salary,
    case
        when salary >= 5000000 then '시니어'
        when salary >= 3500000 then '미들'
        else '주니어'
    end
FROM employee;

---------------------------------------------------------------------
-- <그룹함수>
--1. SUM (숫자타입 컬럼) : 해당 컬럼값들의 총 합계를 구해서 반환해주는 함수

--직원들의 모든 급여의 합
SELECT SUM(salary)
FROM employee;

--남자사원들의 총 급여
SELECT sum(salary) FROM employee WHERE substr(emp_no, 8, 1) in ('1', '3');

--부서코드가 D5인 부서 사람들의 총 연봉(급여*12)
SELECT sum(salary*12) FROM employee WHERE dept_code = 'D5';

--2. AVG(NUMBER) : 해당 컬럼 값들의 평균을 구해서 반환
SELECT avg(salary) FROM employee;

--3. MIN(모든타입가능) : 해당컬럼 값중에 가장 작은 값을 반환
SELECT min(emp_name), min(salary), min(hire_date) FROM employee;

--4. max(모든타입가능) : 해당컬럼 값중에 가장 큰 값을 반환
SELECT max(emp_name), max(salary), max(hire_date) FROM employee;

--5. COUNT(*|컬럼|DISTINCT 컬럼) : 해당 조건에 맞는 행의 갯수를 세서 반환
--COUNT(*) : 조회된 결과에 모든 행의 갯수를 반환
--COUNT(컬럼) : 제시한 컬럼값이  null이 아닌것만 행의 수를 세서 반환
--COUNT(DISTINCT 컬럼) : 해당 컬럼값에서 중복을 제거한 후 행의 갯수를 세서 반환

--전체사원의 수
SELECT count(*) FROM employee;

SELECT count(*) FROM employee WHERE substr(emp_no,8,1) in ('2', '4');

--보너스를 받는 사원의 수
SELECT COUNT(bonus) FROM employee; --bonus값이 null이 아닌 데이터만 카운트함
--where bonus is not null;

--현재 사원들이 총 몇개의 부서에 분포되어 있는지 알려줘.
SELECT count(DISTINCT(dept_code)) FROM employee;


-----------------------------------------------------------------------------------
/*
실행 우선 순위
SELECT *              --3  
FROM 테이블            --1
WHERE 조건식           --2
ORDER BY 정렬기준      --4
*/
