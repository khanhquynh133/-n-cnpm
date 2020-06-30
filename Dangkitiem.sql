--<ScriptOptions statementTerminator="GO"/>

ALTER TABLE "dbo"."DKTiem" DROP CONSTRAINT "PK_hodan_vaccine"
GO

DROP TABLE "dbo"."DKTiem"
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE "dbo"."DKTiem" (
	"idHoDan" INT NOT NULL,
	"idVaccine" null NOT NULL,
	"idVatNuoi" null NOT NULL,
	"soluong" INT,
	"ngaydangki" null,
	CONSTRAINT "PK_hodan_vaccine" PRIMARY KEY ("idHoDan", "idVaccine", "idVatNuoi") WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)

)
GO

SET ANSI_PADDING OFF
GO

