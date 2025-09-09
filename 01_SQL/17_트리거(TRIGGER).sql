/*
    <트리거>
    특정 테이블에 대해  INSERT, UPDATE, DELETE와 같은 DML이벤트가 발생했을 때
    자동으로 실행되는 PL/SQL코드 블록
    
    EX) 
    -회원 탈퇴시 기존의 회원테이블에 데이터를 DELETE하디 전에 항상 탈퇴한 회뭔들을 저장하는 테이블
    
    -신고횟수가 일정 수를 넘었을 떼 묵시적으로 해당 회원을 블랙리스트에 추가
    
    트리거 특징
    -사용자가 명시적으로 실행하지 않아도 자동 실행됨
    -데이터 무결성, 로깅, 자동처리등에 유용.
    - 테이블 단위로 작성되며, 트리거 대상은 테이블
    
    트리거 분류
    *시점(어제 실행?)
    -BERORE TRIGGER : 내가 지정한 테이블에 DML이벤트가 실행되기전에
    
    
    *적용대상(어디에 적용?)
    -문장 트리거 : 이벤트가 발생한 SQL문에 대해 딱 한번만 트리거 실행(FOR EACH ㄱOW없음)
    -행 트리거 : 이벤트가 적용된 각 행마다 실행(FOR EACH ROW 필요)
    
    
    [표현식]
    CREATE [OR REPLACE] TRIGGER 트리거명
    BEFORE | AFTER INSERT | UDADTE| DLETE
    ON 테이블명
    
    BEGIN
        실행할 내용
    [EXCEPTION ...] --예외처리 가능
    END;
    /
    
*/

SET SERVEROUTPUT ON;
--EMPLOYEE 테이블에 새로운 행이 추가될 때 마다 자동으로 '안녕하세요' 출력

CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT
ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('안녕하세요');
END;
/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE)
VALUES(303,'김지원', '111111-1111111','J7');

-------------------------------------------------------------
--입출고에 대한 데이터 기록(INSERT) 될때마다 해당 상품에 대한 재고수량을 매번 수정(UPDATE)
--상품 테이블(재고), 입출고기록 테이블

--1. 상품에 대한 데이터를 보관할 상품 테이블(TB_PRODUCT)
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY, 
    PNAME VARCHAR(20) NOT NULL,
    BRAND VARCHAR2(30) NOT NULL,
    PRICE NUMBER,
    STOCK NUMBER DEFAULT 0
);

CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5;

INSERT INTO TB_PRODUCT VALUES (SEQ_PCODE.NEXTVAL, '갤럭시S25', '삼성',1500000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES (SEQ_PCODE.NEXTVAL, '아이폰', '애플',1300000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES (SEQ_PCODE.NEXTVAL, '중폰', '샤오미',900000, DEFAULT);


DROP TABLE TB_PRODETAIL;

CREATE TABLE TB_PRODETAIL(
    DCODE NUMBER PRIMARY KEY,
    PCODE NUMBER REFERENCES TB_PRODUCT,
    PDATE DATE NOT NULL,
    AMOUNT NUMBER NOT NULL,
    STATUS CHAR(3) CHECK(STATUS IN('IN', 'OUT'))
);

DROP SEQUENCE SEQ_DECODE;
CREATE SEQUENCE SEQ_DECODE
START WITH 200
INCREMENT BY 5;

--200번 상품이 오늘 10개 입고
INSERT INTO TB_PRODETAIL
VALUES(seq_decode.nextval,20, SYSDATE, 10, 'IN');
 

UPDATE TB_PRODUCT
SET STOCK = STOCK + 10
WHERE PCODE =205;

COMMIT;
SELECT * FROM TB_PRODETAIL;

CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT
ON TB_PRODETAIL
FOR EACH ROW
BEGIN
    IF(:NEW.STATUS='IN')
        THEN UPDATE tb_product
            SET STOCK = STOCK - (:NEW.AMOUNT)
            WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/
--210번 상품이 오늘 날짜로 입고
INSERT INTO tb_prodetail VALUES(SEQ_DECODE.NEXTVAL, 210, YSYDATE,7,'IN');







