CREATE USER EMP IDENTIFIED BY EMP0123;

GRANT CONNECT, RESOURCE TO EMP;


SELECT EMPNAME, JOBCODE, COUNT(*) AS �����

FROM EMP

WHERE BONUS != 'NULL'

GROUP BY JOBCODE

ORDER BY JOBCODE;

SELECT EMP_NAME, JOB_CODE, COUNT(*) AS �����

FROM EMPLOYEE

WHERE BONUS IS NOT NULL

GROUP BY EMP_NAME, JOB_CODE

ORDER BY JOB_CODE;

ALTER TABLE EMPLOYEE_COPY3 ADD PRIMARY KEY (EMP_ID);

ALTER TABLE EMPLOYEE_COPY2 ADD FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE_COPY3;

ALTER TABLE EMPLOYEE_COPY3 ADD UNIQUE (EMP_NAME);

ALTER TABLE EMPLOYEE_COPY3 ADD CHECK ('����'IN('��ҵ�','���ҵ�'));

ALTER TABLE EMPLOYEE_COPY3 MODIFY SALARY NOT NULL;

-- ������ ���� ���̺��� �����, �����ڵ�, ���ʽ��� �޴� ��� ���� ��ȸ�Ͽ�
-- �����ڵ� ������ �������� �����ϴ� �����̴�.
/*
���̺�� : memberTb

id          pass          name          age

(varchar2(10)) (varchar2(20)) (varchar2(10)) (number)

0100      1234      ������      25

0101       kimleechoi      ���ѳ�      30

0102       snsd       ������        28
*/

CREATE TABLE memberTb(
id varchar2(10),
pass varchar2(20),
name varchar2(10),
age number);

INSERT INTO MEMBERTB VALUES (0100, 1234, '������', 25);
INSERT INTO MEMBERTB VALUES (0101, 'kimleechoi', '���ѳ�', 30);
INSERT INTO MEMBERTB VALUES (0102, 'snsd', '������', 28);

--INSERT INTO MEMBERTB (0100, 1234, '������', 25);







