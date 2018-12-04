CREATE TABLE "public"."user" (
  "id" int8 NOT NULL,
  "username" varchar(20) COLLATE "default",
  "password" varchar(20) COLLATE "default",
  "email" varchar(30) COLLATE "default",
  "expired" int4,
  "disable" int4,
  PRIMARY KEY ("id")
)
  WITH (OIDS=FALSE)
;

ALTER TABLE "public"."user" OWNER TO "postgres";