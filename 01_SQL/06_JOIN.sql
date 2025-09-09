/*
    <JOIN>
    두개이상의 테이블에서 데이터를 조회하고자할 때 사용되는 구문
    조회 결과는 하나의 결과(RESULT SET)을 반환
    
    관계형 데이터베이스에서는 최소한의 데이터를 각각의 테이블에 담고 있음
    (무작정 다 조회해 오는것이 아니라 각 테이블간 연결고리(외래키)를 통해 데이터를 매칭시켜 조회)
    
    JOIN은 "오라크 전용구문" "ANSI 구문"으로 나뉨
*/

--전체 사원들의 사번, 사원명, 부서코드, 부서명
SELECT emp_id, emp_name, dept_code FROM employee;

SELECT dept_id, dept_title FROM department;

/*
    1. 등가 조인 / 내부 조인(INNER JOIN) / 등가조인(EQUAL JOIN)
    연결시키는 컬럼의 값이 일치하는 행들만 조회(일치하는 값이 없는 행은 조회 제외)
*/

-->오라클 전용구문
--FROM절에 조회하고자하는 테이블을 나열(, 구분)
--WHERE절에 매칭시킬 컬럼에 대한 조건을 제시
SELECT emp_id, emp_name,dept_code, dept_title
FROM employee, department
where dept_code = dept_id;


-->ANSI구문
--FROM절에 기준이 되는 테이블 하나만 기술한다.
--JOIN절에 같이 조인하고자 하는 테이블을 기술 + 매칭시킬 컬럼에 대한 조건
-- [INNER] JOIN [USING/ON]

--1. 연결할 두 컬럼명이 다른 경우 JOIN ON을 사용해서 연결할 컬럼명을 명시적으로 연결

SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE 
FROM employee
JOIN department ON DEPT_CODE = DEPT_ID;


--2. 연결할 두 컬럼명이 동일한 경우
--전체사원들의 사번, 사원명, 직급코드, 직급명
SELECT emp_id, emp_name, job_code, job_name FROM employee 
--JOIN JOB J ON(e.job_code = J.job_code);
JOIN JOB USING(JOB_CODE);

--직급이 대리인 사원의 사번, 사원명, 직급명, 급여조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME FROM employee
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리';

--------------------------------실습------------------------------------
--1. 부서가 인사관리부인 사원들의 사번,이름, 보너스 조회
SELECT EMP_ID, EMP_NAME, BONUS FROM employee
JOIN department ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '인사관리부';

--2. 부서와 지역테이블을 참고하여 전체부서의 부서코드, 부서명, 지역코드, 지역명 조회
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID, LOCAL_NAME FROM department
JOIN location ON(location_id = LOCAL_CODE);

--3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE FROM employee
JOIN department ON(DEPT_CODE = DEPT_ID)
WHERE BONUS IS NOT NULL;

--4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY FROM employee
JOIN department ON(DEPT_CODE = DEPT_ID)
WHERE NOT DEPT_TITLE = '총무부' ;


---------------------------------------------------------------------
/*
    2.외부조인(OUTER JOIN) / 포괄조인
    두 테이블간의 JOIN시 일치하지 않는 행도 포함시켜 조회 가능
    단, 반드시 LEFT/RIGHT를 지정해야한다. (어떤 테이블을 기준으로 할것인가)
*/
--외부조인과 비교할만한 내부조인
--사원명, 부서명, 급여, 연봉
--부서배치를 받지않은 2명의 사원정보는 어떻게 되는가?
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);


--1) LEFT [OUTER] JOIN : 두테이블 중 왼편에 기술된 테이블을 기준으로 JOIN

SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

--오라클 구문
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+);

--1) RIGHT [OUTER] JOIN : 두테이블 중 오른편에 기술된 테이블을 기준으로 JOIN
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

--오라클 구문
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

--FULL [OUTER] JOIN : 두 테이블이 가진 모든행을 조회할 수 있다.
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

/*
    3. 비등가 조인
    매칭시킬 컬럼에 대한 조건 작성시 '='을 사용하지 않는 조인문
    
    범위(수치적 범위, 기간적 범위)를 기반으로 조인을 구현할 때 사용
*/

--사원명, 급여, 급여레벨
SELECT EMP_NAME, SALARY, SAL_LEVEL FROM employee
JOIN sal_grade
ON(SALARY BETWEEN MIN_SAL AND MAX_SAL);


--------------------------------------------------------------------------
/*
    4.자체조인(SELF JOIN)
    같은 테이블을 다시한번 조인하는 경우
    --하나의 테이블에서 서로 다른 두개의 행을 비교해야하는 경우 사용
    -동일한 테이블을 조인하는 것이기 때무네 별칭을 사용해서 구분해야한다.

*/

--전체사원의 사원 사번, 사원명, 사원 부서코드,  --EMPLOYEE
--사수 사번, 사수명, 사수코드                 --EMPLOYEE
SELECT e.emp_id, e.emp_name, e.dept_code,
        m.emp_id, m.emp_name, m.dept_code
FROM  EMPLOYEE E
LEFT JOIN EMPLOYEE M ON(E.manager_id = M.emp_id);

-------------------------------------------------------------------------
/*
    <다중 조인>
    2개 이상의 테이블을 가지고 JOIN할 수 있음.
*/
--사번, 사원명, 부서명, 직급명
SELECT emp_id, emp_name, dept_title, job_code FROM employee
JOIN department ON(employee.dept_code=department.dept_id)
JOIN JOB USING(job_code);

--사번, 사원명, 부서명, 지역명 조회
SELECT employee.emp_id, department.dept_title, location.local_name FROM employee
JOIN department ON(dept_code = department.dept_id)
JOIN location ON(department.location_id=location.local_code);

--사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여등급 조회
SELECT employee.emp_id, employee.emp_name,department.dept_title
        ,JOB_NAME, location.local_name, national_name,sal_grade.sal_level
FROM employee 
JOIN department ON(department.dept_id=employee.dept_code)
JOIN job USING(JOB_CODE)
JOIN location ON(department.location_id= location.local_code)
JOIN NATIONAL USING(NATIONAL_CODE)
JOIN sal_grade ON(employee.salary BETWEEN MIN_SAL AND sal_grade.max_sal);

----------------------------------------------------------------
/*
    내추럴 조인(NATURAL JOIN)
    두 테이블간에 공통된 컬럼이름을 기준으로 정해서 자동으로 조인하는 방식
    ON이나 USING조건을 지정하지 않아도 두 테이블간의 공통된 컬럼을 기반으로 조인
    
    동일한 컬럼명이 각 테이블에 존재하는 경우에만 정상적인 조인이 가능하다.
*/

--SELECT * FROM employee JOIN JOB USING(JOB_CODE);

SELECT * FROM employee NATURAL JOIN JOB;



























