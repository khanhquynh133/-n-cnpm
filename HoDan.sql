--<ScriptOptions statementTerminator="GO"/>

ALTER TABLE "dbo"."HoDan" DROP CONSTRAINT "PK__HD__4C467244239E4DCF"
GO

DROP TABLE "dbo"."HoDan"
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE "dbo"."HoDan" (
	"idHoDan" INT NOT NULL,
	"Username" null,
	"iPassword" null,
	"Fullname" null,
	"Gender" null,
	"PhoneNumber" null,
	"iAddress" null,
	"Dob" null,
	CONSTRAINT "PK__HD__4C467244239E4DCF" PRIMARY KEY ("idHoDan") WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)

)
GO

SET ANSI_PADDING OFF
GO

