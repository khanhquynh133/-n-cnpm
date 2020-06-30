--<ScriptOptions statementTerminator="GO"/>

ALTER TABLE "dbo"."Vaccine_r" DROP CONSTRAINT "FK_Vaccine_r_Animal"
GO

ALTER TABLE "dbo"."Vaccine_r" DROP CONSTRAINT "PK_Vaccine_r"
GO

DROP TABLE "dbo"."Vaccine_r"
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE "dbo"."Vaccine_r" (
	"idVaccine" null NOT NULL,
	"Vaccine_name" null,
	"Number" INT,
	"idVatNuoi" null,
	CONSTRAINT "PK_Vaccine_r" PRIMARY KEY ("idVaccine") WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)

)
GO

SET ANSI_PADDING OFF
GO

