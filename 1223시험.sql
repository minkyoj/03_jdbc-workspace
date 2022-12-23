CREATE USER EMP IDENTIFIED BY EMP0123;

GRANT CONNECT, RESOURCE TO EMP;


SELECT EMPNAME, JOBCODE, COUNT(*) AS 사원수

FROM EMP

WHERE BONUS != 'NULL'

GROUP BY JOBCODE

ORDER BY JOBCODE;

SELECT EMP_NAME, JOB_CODE, COUNT(*) AS 사원수

FROM EMPLOYEE

WHERE BONUS IS NOT NULL

GROUP BY EMP_NAME, JOB_CODE

ORDER BY JOB_CODE;

ALTER TABLE EMPLOYEE_COPY3 ADD PRIMARY KEY (EMP_ID);

ALTER TABLE EMPLOYEE_COPY2 ADD FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE_COPY3;

ALTER TABLE EMPLOYEE_COPY3 ADD UNIQUE (EMP_NAME);

ALTER TABLE EMPLOYEE_COPY3 ADD CHECK ('연봉'IN('고소득','저소득'));

ALTER TABLE EMPLOYEE_COPY3 MODIFY SALARY NOT NULL;

-- 다음은 직원 테이블에서 사원명, 직급코드, 보너스를 받는 사원 수를 조회하여
-- 직급코드 순으로 오름차순 정렬하는 구문이다.
/*
테이블명 : memberTb

id          pass          name          age

(varchar2(10)) (varchar2(20)) (varchar2(10)) (number)

0100      1234      이지은      25

0101       kimleechoi      강한나      30

0102       snsd       서주현        28
*/

CREATE TABLE memberTb(
id varchar2(10),
pass varchar2(20),
name varchar2(10),
age number);

INSERT INTO MEMBERTB VALUES (0100, 1234, '이지은', 25);
INSERT INTO MEMBERTB VALUES (0101, 'kimleechoi', '강한나', 30);
INSERT INTO MEMBERTB VALUES (0102, 'snsd', '서주현', 28);

--INSERT INTO MEMBERTB (0100, 1234, '이지은', 25);







