--<ScriptOptions statementTerminator="GO"/>

ALTER TABLE "dbo"."Schedule" DROP CONSTRAINT "PK__Schedule__5717CA9438996AB5"
GO

DROP TABLE "dbo"."Schedule"
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE "dbo"."Schedule" (
	"idSchedule" INT NOT NULL,
	"idVaccine" null,
	"Vaccine_name" null,
	"idVatNuoi" null,
	"Vatnuoi_name" null,
	"Number_vaccine" INT,
	"Time_register" DATETIME,
	CONSTRAINT "PK__Schedule__5717CA9438996AB5" PRIMARY KEY ("idSchedule") WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)

)
GO

SET ANSI_PADDING OFF
GO

