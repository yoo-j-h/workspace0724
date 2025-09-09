/*
    <GOUP BY>
    그룹기준을 제시할 수 있는 구문(해단 기룹기준별로 여러 그룹으로 무묶을 수 있음)
    여러개의 값들을 하나의 그룹으로 묶어서 처리하는 목적으로 사용
*/

SELECT SUM(salary) 
FROM employee;

--그룹 : 부서별
--각 부서별 급여 총합

SELECT dept_code, SUM(salary)
FROM employee
GROUP BY dept_code;

--각 부서별 사원수
SELECT dept_code, COUNT(*), SUM(salary) --3
FROM employee           --1
GROUP BY dept_code      --2
ORDER BY dept_code;     --4


--GROUP BY절에 ㅡ함수식 사용가능(그룹을 나눌 수 있는 기준만 넣어주면)
--남자사원과 여자사원들 수를 조회
SELECT DECODE(SUBSTR(EMP_NO,8,1),'1','남자','2','여자'),COUNT(*) 
FROM employee
GROUP BY SUBSTR(EMP_NO,8,1);

--GROUP BY절에 여러컬럼을 기술할 수 있음
--여러개의 컬럼을 기술하면 해당 여러컬럼들 모두를 하나의 기준으로 사용함.
SELECT dept_code, job_code,COUNT(*)
FROM employee
GROUP BY dept_code, job_code;

/*
    <HAVING>
    그룹에 대한 조건을 제시할 때 사용되는 구문(주로 그룹함수식을 가지고 조건을 만든다)
*/
--각 부서별 평균 급여(부서코드, 평균 급여)
SELECT dept_code, ROUND(AVG(salary))
FROM employee
GROUP BY dept_code;

--각 부서별 평균급여가 300만원 이상인 부서들만 부서코드, 평균급여 조회
--WHERE절이  GROUP BY이전에 실행되므로 해당코드는 300만원 이상의 급여를 받는 사람을 먼저 필터링한 후
--부서코드와 평균을 구한다.
SELECT dept_code, AVG(salary) FROM employee 
WHERE salary >= 3000000
GROUP BY dept_code;

SELECT dept_code,ROUND(AVG(salary)) FROM employee 
GROUP BY dept_code
HAVING AVG(salary) >= 3000000;

--직급별 직급코드, 총 급여합(단, 직급별 총급여합이 1000만원 이상인 직급만 조회)
SELECT job_code, SUM(salary) 
FROM employee 
GROUP BY job_code HAVING SUM(salary)>= 10000000 ;

--부서별 보너스를 받는 사원이 없는 부서의 부서코드
SELECT DEPT_CODE, COUNT(BONUS) 
FROM employee 
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

SELECT EXTRACT(YEAR FROM hire_date) ,COUNT(*) FROM employee
GROUP BY EXTRACT(YEAR FROM hire_date);

------------------------------------------
/*
    SELECT *                          --5
    FROM 테이블                        --1
    WHERE 조건식                       --2
    GROUP BY 그룹기준 컬럼 | 함수식      --3
    HAVING 조건식                      --4
    ORDER BY 정렬기준                  --6
    (오라클에는 존재X)LIMIT                
*/









