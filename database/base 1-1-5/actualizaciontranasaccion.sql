GO
ALTER TABLE dbo.tblTransaccion ADD
	hora varchar(50) NULL
GO
ALTER TABLE dbo.tblTransaccion SET (LOCK_ESCALATION = TABLE)
GO
