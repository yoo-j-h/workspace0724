/*
    <VIEW 뷰>
    
    자주사용하는 SELECT문을 하나의 가상 테이블처럼 저장해 놓은 객체.
    실제 데이터를 저장하지 않고, 정의된 SELECT문을 실행해서 데이터를 조회.
    복잡한 조인쿼리를 매번 작성하지 않고 간단하게 재사용할 수 있음
*/

--한국에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME FROM employee 
JOIN department ON (DEPT_CODE = DEPT_ID)
JOIN location ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '한국';

--러시아에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME FROM employee 
JOIN department ON (DEPT_CODE = DEPT_ID)
JOIN location ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '러시아';

--일본에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME FROM employee 
JOIN department ON (DEPT_CODE = DEPT_ID)
JOIN location ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '일본';

/*
    1. VIEW 생성방법
    
    [표현식]
    CREATE VIEW 뷰명
    AS 서브쿼리
*/

--GRANT CREATE VIEW TO C##SERVER; 뷰 생성 권한

CREATE VIEW VW_EMPLOYEE
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME FROM employee 
    JOIN department ON (DEPT_CODE = DEPT_ID)
    JOIN location ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING(NATIONAL_CODE));

--인라인뷰로 호출
SELECT * 
FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME FROM employee 
        JOIN department ON (DEPT_CODE = DEPT_ID)
        JOIN location ON (LOCATION_ID = LOCAL_CODE)
        JOIN NATIONAL USING(NATIONAL_CODE));
        
--뷰 호출
--실제 실행되는 것은 서브쿼리(인라인뷰 형태)로 실행된다.
SELECT * 
FROM vw_employee;

--한국에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가 조회
SELECT * 
FROM vw_employee
WHERE national_name = '한국';

--러시아에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가 조회
SELECT * 
FROM vw_employee
WHERE national_name = '러시아';

--일본에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가 조회
SELECT *
FROM vw_employee
WHERE national_name = '일본';

--CREATE OR REPLACE VIEW 뷰명
--VIEW가 없을 때는 생성, 이미 존재한다면 수정
CREATE OR REPLACE VIEW VW_EMPLOYEE
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME, BONUS FROM employee 
    JOIN department ON (DEPT_CODE = DEPT_ID)
    JOIN location ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING(NATIONAL_CODE));

------------------------------------------------------------------------------
/*
    뷰컬럼에 연산식, 함수식이 있는 경우 무조건 별칭을 지정해야 함.
*/
CREATE OR REPLACE VIEW VW_EMP_JOB
AS (SELECT EMP_ID, EMP_NAME, JOB_NAME,
        DECODE(SUBSTR(EMP_NO, 8, 1), '1','남','2','여') AS GENDER,
        EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM hire_date) AS SERVICEYEAR
    FROM employee
    JOIN JOB USING(JOB_CODE));
    
SELECT * FROM vw_emp_job;

SELECT * FROM vw_emp_job
WHERE serviceyear >=20;

DROP VIEW VW_EMP_JOB;

----------------------------------------------------------------------------
--생성된 뷰를 통해서 DML(INSERT, UPDATE, DELETE)사용가능함.
--뷰를 통해서 조작하면 실제 데이터가 담겨있는 테이블에 반영됨.

CREATE OR REPLACE VIEW VW_JOB
AS(SELECT JOB_CODE, JOB_NAME
    FROM JOB);

SELECT * FROM vw_job; --가상의 논리 테이블(실제 데이터가 저장되어 있지 않음)
SELECT * FROM job;

INSERT INTO vw_job VALUES('J8', '인턴');

UPDATE vw_job
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8';

SELECT * FROM VW_JOB;
SELECT * FROM job;

/*
    DML 명령어 사용이 불가한 경우
    1) 뷰에 없는 컬럼을 조작
    2) 뷰에 정의되어있지 않은 컬럼 중에 NOT NULL제약조건이 있는 컬럼이 있는 경우
    3) 산술/함수식을 사용한 경우
    4) 그룸함수나 GROUP BY절을 포함한 경우
    5) DISTINCT 구문이 포함된 경우
    6) JOIN을 이용해서 다중테이블을 지정한 경우
    
    대부분 뷰는 조회를 목적으로 사용한다.
*/

------------------------------------------------------------------------
/*
    VIEW 생성 옵션
    
    [상세 표현식]
    CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰명
    AS 서브쿼리
    [WITH CHECK OPTION]
    [WITH READ ONLY]
    
    FORCE | NOFORCE
    >FORCE : 뷰 정의시 참조 테이블이 없어도 뷰를 생성 가능하게 함.
    >NOFORCE : 서브쿼리에 기술된 테이블이 존재할 때만 뷰 생성 가능.(기본값)
    
    >WITH CHECK OPTION : 뷰의 WHERE 조건을 강제하여, 조건에 맞는 데이터만 삽입/수정 가능하게 함.
    >WITH READ ONLY : 뷰에 대해서 조회만 가능하도록.
*/
--서브쿼리에 기술된 테이블이 존재하지 않아도 뷰는 우선 생성된다.
CREATE OR REPLACE FORCE VIEW VW_EMP
AS (SELECT TCODE, TNAME,TCONTENT 
    FROM TT);
    
SELECT * FROM VW_EMP;

CREATE TABLE TT(
    TCODE NUMBER,
    TNAME VARCHAR(20),
    TCONTENT VARCHAR(20)
);

--VIEW CHECK OPTION
CREATE OR REPLACE VIEW VE_EMP
AS ( SELECT * FROM employee
    WHERE salary >= 300000);

SELECT * FROM vw_emp;

ROLLBACK;

CREATE OR REPLACE VIEW VW_EMP
AS ( SELECT * FROM employee
    WHERE salary >= 3000000)
WITH CHECK OPTION;

--뷰의 조건 안에서 동작하도록 강제함.
UPDATE VW_EMP
SET salary = 2000000
WHERE EMP_ID = 200;

--WITH READ ONLY : 뷰는 읽기 전용으로 사용.
CREATE OR REPLACE VIEW VW_EMP
AS ( SELECT * FROM employee
    WHERE BONUS IS NOT NULL)
WITH READ ONLY;

SELECT * FROM vw_emp;

DELETE
FROM vw_emp;




