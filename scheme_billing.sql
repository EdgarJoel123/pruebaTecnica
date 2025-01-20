/*
 Navicat Premium Dump SQL

 Source Server         : billing_connection
 Source Server Type    : PostgreSQL
 Source Server Version : 150007 (150007)
 Source Host           : localhost:5432
 Source Catalog        : billing_test
 Source Schema         : scheme_billing

 Target Server Type    : PostgreSQL
 Target Server Version : 150007 (150007)
 File Encoding         : 65001

 Date: 20/01/2025 12:17:44
*/


-- ----------------------------
-- Sequence structure for scbi_customers_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "scheme_billing"."scbi_customers_seq";
CREATE SEQUENCE "scheme_billing"."scbi_customers_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for scbi_invoice_details_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "scheme_billing"."scbi_invoice_details_seq";
CREATE SEQUENCE "scheme_billing"."scbi_invoice_details_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for scbi_invoices_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "scheme_billing"."scbi_invoices_seq";
CREATE SEQUENCE "scheme_billing"."scbi_invoices_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for scheme_billing_scbi_customers
-- ----------------------------
DROP TABLE IF EXISTS "scheme_billing"."scheme_billing_scbi_customers";
CREATE TABLE "scheme_billing"."scheme_billing_scbi_customers" (
  "customers_id" int8 NOT NULL DEFAULT nextval('"scheme_billing".scbi_customers_seq'::regclass),
  "email" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "phone" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of scheme_billing_scbi_customers
-- ----------------------------
INSERT INTO "scheme_billing"."scheme_billing_scbi_customers" VALUES (1, 'estaprue@gmail', 'edgar', '0989353272');

-- ----------------------------
-- Table structure for scheme_billing_scbi_invoice_details
-- ----------------------------
DROP TABLE IF EXISTS "scheme_billing"."scheme_billing_scbi_invoice_details";
CREATE TABLE "scheme_billing"."scheme_billing_scbi_invoice_details" (
  "invoice_details_id" int8 NOT NULL DEFAULT nextval('"scheme_billing".scbi_invoice_details_seq'::regclass),
  "invoice_id" int8,
  "product_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "quantity" int4 NOT NULL,
  "total" float8,
  "unit_price" float8 NOT NULL
)
;

-- ----------------------------
-- Records of scheme_billing_scbi_invoice_details
-- ----------------------------
INSERT INTO "scheme_billing"."scheme_billing_scbi_invoice_details" VALUES (1, 1, 'ewqw', 4654, 253940856, 54564);
INSERT INTO "scheme_billing"."scheme_billing_scbi_invoice_details" VALUES (2, 2, 'ewqw', 213, 262203, 1231);
INSERT INTO "scheme_billing"."scheme_billing_scbi_invoice_details" VALUES (3, 3, 'PRUEBA', 20, 400, 20);

-- ----------------------------
-- Table structure for scheme_billing_scbi_invoices
-- ----------------------------
DROP TABLE IF EXISTS "scheme_billing"."scheme_billing_scbi_invoices";
CREATE TABLE "scheme_billing"."scheme_billing_scbi_invoices" (
  "invoices_id" int8 NOT NULL DEFAULT nextval('"scheme_billing".scbi_invoices_seq'::regclass),
  "customer_id" int8,
  "invoice_date" timestamp(6) NOT NULL,
  "total" float8 NOT NULL
)
;

-- ----------------------------
-- Records of scheme_billing_scbi_invoices
-- ----------------------------
INSERT INTO "scheme_billing"."scheme_billing_scbi_invoices" VALUES (1, 1, '2025-01-20 12:04:27.271358', 253940856);
INSERT INTO "scheme_billing"."scheme_billing_scbi_invoices" VALUES (2, 1, '2025-01-20 12:08:08.126377', 262203);
INSERT INTO "scheme_billing"."scheme_billing_scbi_invoices" VALUES (3, 1, '2025-01-20 12:09:58.040615', 400);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"scheme_billing"."scbi_customers_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"scheme_billing"."scbi_invoice_details_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"scheme_billing"."scbi_invoices_seq"', 3, true);

-- ----------------------------
-- Uniques structure for table scheme_billing_scbi_customers
-- ----------------------------
ALTER TABLE "scheme_billing"."scheme_billing_scbi_customers" ADD CONSTRAINT "uk_t880pwkskisvpxtp01p6rdbmn" UNIQUE ("email");

-- ----------------------------
-- Primary Key structure for table scheme_billing_scbi_customers
-- ----------------------------
ALTER TABLE "scheme_billing"."scheme_billing_scbi_customers" ADD CONSTRAINT "scheme_billing_scbi_customers_pkey" PRIMARY KEY ("customers_id");

-- ----------------------------
-- Primary Key structure for table scheme_billing_scbi_invoice_details
-- ----------------------------
ALTER TABLE "scheme_billing"."scheme_billing_scbi_invoice_details" ADD CONSTRAINT "scheme_billing_scbi_invoice_details_pkey" PRIMARY KEY ("invoice_details_id");

-- ----------------------------
-- Primary Key structure for table scheme_billing_scbi_invoices
-- ----------------------------
ALTER TABLE "scheme_billing"."scheme_billing_scbi_invoices" ADD CONSTRAINT "scheme_billing_scbi_invoices_pkey" PRIMARY KEY ("invoices_id");

-- ----------------------------
-- Foreign Keys structure for table scheme_billing_scbi_invoice_details
-- ----------------------------
ALTER TABLE "scheme_billing"."scheme_billing_scbi_invoice_details" ADD CONSTRAINT "fk39xnuqc1c88w65ygm8vdkps5d" FOREIGN KEY ("invoice_id") REFERENCES "scheme_billing"."scheme_billing_scbi_invoices" ("invoices_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table scheme_billing_scbi_invoices
-- ----------------------------
ALTER TABLE "scheme_billing"."scheme_billing_scbi_invoices" ADD CONSTRAINT "fkoyveb076b9fijt0dag74cm78f" FOREIGN KEY ("customer_id") REFERENCES "scheme_billing"."scheme_billing_scbi_customers" ("customers_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
