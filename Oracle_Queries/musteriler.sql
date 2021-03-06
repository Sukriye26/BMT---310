--------------------------------------------------------
--  File created - Cumartesi-May�s-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MUSTERILER
--------------------------------------------------------

  CREATE TABLE "SUKRIYE"."MUSTERILER" 
   (	"ID" NUMBER, 
	"KAD" VARCHAR2(20 BYTE), 
	"SIFRE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into SUKRIYE.MUSTERILER
SET DEFINE OFF;
Insert into SUKRIYE.MUSTERILER (ID,KAD,SIFRE) values ('7','ali','veli');
Insert into SUKRIYE.MUSTERILER (ID,KAD,SIFRE) values ('1','�eyma','123');
Insert into SUKRIYE.MUSTERILER (ID,KAD,SIFRE) values ('2','daniel','123456');
Insert into SUKRIYE.MUSTERILER (ID,KAD,SIFRE) values ('3','aa','aa');
Insert into SUKRIYE.MUSTERILER (ID,KAD,SIFRE) values ('4','aaa','aa');
Insert into SUKRIYE.MUSTERILER (ID,KAD,SIFRE) values ('5','��kriye','1965');
Insert into SUKRIYE.MUSTERILER (ID,KAD,SIFRE) values ('6','alican','123');
--------------------------------------------------------
--  DDL for Index MUSTER�LER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SUKRIYE"."MUSTER�LER_PK" ON "SUKRIYE"."MUSTERILER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table MUSTERILER
--------------------------------------------------------

  ALTER TABLE "SUKRIYE"."MUSTERILER" ADD CONSTRAINT "MUSTER�LER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "SUKRIYE"."MUSTERILER" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  DDL for Trigger MUSTERI_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SUKRIYE"."MUSTERI_TRG" 
BEFORE INSERT ON MUSTERILER 
FOR EACH ROW 
BEGIN
  select musteri_sequence.NEXTVAL INTO:NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "SUKRIYE"."MUSTERI_TRG" ENABLE;
