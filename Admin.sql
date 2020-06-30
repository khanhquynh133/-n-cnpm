--<ScriptOptions statementTerminator="GO"/>

ALTER TABLE "dbo"."Admin" DROP CONSTRAINT "PK_Admin"
GO

DROP TABLE "dbo"."Admin"
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE "dbo"."Admin" (
	"idAdmin" INT NOT NULL,
	"Fullname" null,
	"Gender" null,
	"iAddress" null,
	"Username" null,
	"iPassword" null,
	"Dob" null,
	CONSTRAINT "PK_Admin" PRIMARY KEY ("idAdmin") WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)

)
GO

SET ANSI_PADDING OFF
GO

