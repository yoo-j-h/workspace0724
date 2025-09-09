--1_1)
SELECT department_name AS "학과 명", category AS "계열"  
FROM tb_department;

--1_2)
SELECT department_name||'의 정원은 '||capacity||' 명 입니다.' AS "학과별 정원"
FROM tb_department;

--1_3)
SELECT STUDENT_NAME FROM tb_student
JOIN tb_department USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과' 
AND ABSENCE_YN = 'Y' 
AND SUBSTR(STUDENT_SSN,8,1) IN ('2','4');

--1_4)
SELECT student_name FROM tb_student
WHERE student_no IN ('A513079','A513090','A513091','A513110','A513119');

--1_5)
SELECT department_name, category FROM tb_department
WHERE capacity BETWEEN 20 AND 30;

--1_6)
SELECT professor_name FROM tb_professor
WHERE department_no IS NULL;

--1_7)
SELECT * FROM tb_student
WHERE department_no IS NULL;

--8)
SELECT class_no FROM tb_class
WHERE preattending_class_no IS NOT NULL;

--1_9)
SELECT DISTINCT category FROM tb_department;

--1_10)----------------------------------------------------------------
SELECT student_no, student_name, student_ssn, entrance_date, student_address
FROM tb_student
WHERE EXTRACT(YEAR FROM entrance_date) = '2002'
AND student_address LIKE '전주시%';

--------------------------------SQL02--------------------------------------------

--2_1)
SELECT student_no AS 학번, student_name AS 이름, 
        TO_CHAR(entrance_date,'RRRR"-"MM"-"DD') AS 입학년도 
FROM tb_student
WHERE department_no = '002'
ORDER BY entrance_date ASC;

--2_2)-----------------------------------------------------------------------
SELECT professor_name, professor_ssn 
FROM tb_professor
WHERE LENGTH(professor_name)!= 3;

--2_3)--------------------------------------------------------------------------
SELECT professor_name AS 교수이름,
        FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE('19'||SUBSTR(PROFESSOR_SSN,1,2)||SUBSTR(PROFESSOR_SSN,3,4)))/12) AS 나이
FROM tb_professor
WHERE SUBSTR(PROFESSOR_SSN,8,1) IN( '1');

--2_4)
SELECT SUBSTR((professor_name),2) FROM tb_professor;

--2_5)------------------------------------------------------------------------------
SELECT * FROM tb_student
WHERE EXTRACT(YEAR FROM entrance_date)- EXTRACT(YEAR FROM TO_DATE(SUBSTR(STUDENT_SSN,1,6),'RRMMDD')) > 19;

--2_6)
SELECT TO_CHAR(TO_DATE('2020/12/25'),'DAY') FROM DUAL;

--2_7)
SELECT EXTRACT(YEAR FROM TO_DATE('99/10/11','YY/MM/DD')) AS "99, YY",
        EXTRACT(YEAR FROM TO_DATE('49/10/11','YY/MM/DD'))AS "49, YY",
        EXTRACT(YEAR FROM TO_DATE('99/10/11','RR/MM/DD'))AS "99, RR",
        EXTRACT(YEAR FROM TO_DATE('49/10/11','RR/MM/DD'))AS "49, RR"
FROM DUAL;

--2_8)
SELECT student_no, student_name FROM tb_student
WHERE NOT student_no LIKE 'A%';

--2_9)
SELECT ROUND(AVG(POINT),1) AS 평점  FROM tb_grade
GROUP BY student_no
HAVING student_no = 'A517178';

--2_10)
SELECT department_no, COUNT(*) FROM tb_student
GROUP BY department_no
ORDER BY department_no;

--2_11)
SELECT COUNT(*) FROM tb_student
GROUP BY coach_professor_no
HAVING coach_professor_no IS NULL;

--2_12)-----------------------------------------------------------
SELECT SUBSTR(term_no,1,4) AS 년도, ROUND(AVG(POINT),1) AS "년도 별 평점"
FROM tb_grade
WHERE student_no = 'A112113'
GROUP BY SUBSTR(term_no,1,4);

--2_13)----------------------------------------------------------------------
SELECT department_no AS "학과 코드명", COUNT(CASE WHEN ABSENCE_YN = 'Y' THEN 1 END)AS "휴학생 수"
FROM tb_student
GROUP BY department_no
ORDER BY department_no;

--2_14)
SELECT student_name AS "동일이름",COUNT(*) FROM tb_student
GROUP BY student_name
HAVING COUNT(*)>1
ORDER BY student_name;

--2_15)-------------------------------------------------------------------------
SELECT SUBSTR(TERM_NO,1,4) AS 년도,SUBSTR(TERM_NO,5,2) AS 학기, ROUND(AVG(POINT),1) AS 평점 
FROM tb_grade
WHERE student_no = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4), ROLLUP(SUBSTR(TERM_NO,5,2))
ORDER BY SUBSTR(TERM_NO,1,4);

------------------------------------SQL3----------------------------------------

--3_1)
SELECT student_name AS "학생 이름", student_address AS "주소지"  FROM tb_student
ORDER BY student_name ASC;

--3_2)
SELECT student_name, student_ssn FROM tb_student
WHERE absence_yn = 'Y'
ORDER BY student_ssn DESC;

--3_3)
SELECT student_name AS 학생이름, student_no AS 학번, student_address AS "거주지 주소" 
FROM tb_student
WHERE REGEXP_LIKE(STUDENT_ADDRESS ,'경기도|강원도') AND STUDENT_NO LIKE '9%'
ORDER BY student_name;

--3_4)
SELECT DISTINCT PROFESSOR_NAME, PROFESSOR_SSN FROM TB_PROFESSOR P
LEFT JOIN tb_class_professor CP ON(p.professor_no = CP.professor_no)
LEFT JOIN TB_CLASS C ON(cp.class_no = c.class_no)
JOIN TB_DEPARTMENT D ON(D.DEPARTMENT_NO = c.department_no)
WHERE DEPARTMENT_NAME = '법학과'
ORDER BY PROFESSOR_SSN;

--3_5)
SELECT student_no, POINT FROM tb_grade
WHERE class_no = 'C3118100'
ORDER BY POINT DESC, student_no ASC ;

--3_6)
SELECT student_no, student_name, DEPARTMENT_NAME FROM tb_student
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
ORDER BY student_name;

--3_6)
SELECT student_no, student_name, DEPARTMENT_NAME 
FROM tb_student
JOIN tb_department USING(DEPARTMENT_NO)
ORDER BY student_name;

--3_7)
SELECT class_name, DEPARTMENT_NAME FROM tb_class
JOIN tb_department USING(DEPARTMENT_NO)
ORDER BY class_name;

--3_8)
SELECT CLASS_NAME, PROFESSOR_NAME FROM tb_class
JOIN tb_class_professor USING(CLASS_NO)
JOIN tb_professor USING(PROFESSOR_NO)
ORDER BY CLASS_NAME;

--3_9)
SELECT CLASS_NAME, PROFESSOR_NAME FROM TB_PROFESSOR P
LEFT JOIN tb_class_professor CP ON(p.professor_no = CP.professor_no)
LEFT JOIN TB_CLASS C ON(cp.class_no = c.class_no)
JOIN TB_DEPARTMENT D ON(D.DEPARTMENT_NO = c.department_no)
WHERE CATEGORY = '인문사회'
ORDER BY CLASS_NAME;

--3_10)
SELECT STUDENT_NO, STUDENT_NAME, ROUND(AVG(POINT),1) FROM TB_GRADE
JOIN TB_STUDENT USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '음악학과'
GROUP BY STUDENT_NO, STUDENT_NAME
ORDER BY STUDENT_NO;

--3_11)
SELECT DEPARTMENT_NAME AS 학과이름, STUDENT_NAME AS 학생이름, PROFESSOR_NAME AS 지도교수이름
FROM tb_student S
JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON (D.DEPARTMENT_NO = s.department_no)
WHERE STUDENT_NO = 'A313047';

--3_12)
SELECT STUDENT_NAME, TERM_NO FROM tb_grade
JOIN tb_student USING(STUDENT_NO)
JOIN TB_CLASS USING(CLASS_NO)
WHERE TERM_NO LIKE '2007%'
AND CLASS_NAME = '인간관계론';

--3_13)
SELECT CLASS_NAME, DEPARTMENT_NAME FROM TB_CLASS
JOIN tb_department USING(DEPARTMENT_NO)
LEFT JOIN tb_class_professor USING(CLASS_NO)
WHERE CATEGORY = '예체능'
AND PROFESSOR_NO IS NULL;

--3_14)
SELECT STUDENT_NAME AS 학생이름, NVL(PROFESSOR_NAME,'지도교수 미지정') AS 지도교수
FROM tb_student S
LEFT JOIN tb_professor ON (COACH_PROFESSOR_NO = PROFESSOR_NO )
JOIN tb_department D ON (D.DEPARTMENT_NO = s.department_no)
WHERE DEPARTMENT_NAME = '서반아어학과' ;

--3_15
SELECT STUDENT_NO AS 학번, STUDENT_NAME AS 이름, DEPARTMENT_NAME AS "학과 이름", AVG(POINT) AS 평점
FROM tb_student
JOIN tb_grade USING(STUDENT_NO)
JOIN tb_department USING(DEPARTMENT_NO)
WHERE ABSENCE_YN = 'N'
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING AVG(POINT)>= 4.0;

--3_16)
SELECT CLASS_NO, CLASS_NAME, AVG(POINT)  
FROM tb_class
JOIN tb_department USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(CLASS_NO)
WHERE DEPARTMENT_NAME = '환경조경학과' AND CLASS_TYPE LIKE '%전공%'
GROUP BY CLASS_NO, CLASS_NAME;

--3_17)
SELECT STUDENT_NAME, STUDENT_ADDRESS FROM tb_student
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO FROM tb_student
                        WHERE STUDENT_NAME = '최경희');
                        
--3_18)
SELECT STUDENT_NO, STUDENT_NAME FROM tb_student
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN tb_grade USING(STUDENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
GROUP BY STUDENT_NO, STUDENT_NAME 
HAVING AVG(POINT) = (SELECT MAX(AVG(POINT)) FROM tb_grade
JOIN TB_STUDENT USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과' GROUP BY STUDENT_NO)
;
