USE [Parcialsoft2]
GO
ALTER TABLE dbo.tblTransaccion ADD
	hora varchar(50) NULL
GO

ALTER TABLE dbo.tblTransaccion SET (LOCK_ESCALATION = TABLE)



GO

ALTER procedure [dbo].[SeleccionarTransaccion]	
as 
begin 
		SELECT idtransaccion, monto, fecha,idcatergoria,idcuenta,tipo,hora FROM tblTransaccion
	end 
go

ALTER procedure [dbo].[InsertarTransaccion] 
									@monto int,
									@fecha date,
									@idcategoria int,
									@idcuenta int,
									@tipo varchar(50),
									@hora varchar(50)
as 
begin 
		INSERT INTO tblTransaccion (monto, fecha,idcatergoria,idcuenta,tipo,hora) VALUES (@monto,@fecha,@idcategoria,@idcuenta,@tipo,@hora)
	end 

GO

alter procedure [dbo].[buscarTransaccionFecha] @fecha date,@idcuenta int
as 
begin 
		SELECT idtransaccion, monto, fecha,idcuenta,idcatergoria,tipo,hora FROM tblTransaccion  where fecha=@fecha and idcuenta=@idcuenta
		
end
GO

ALTER procedure [dbo].[selectbyId] @id int
as
begin 
SELECT idtransaccion, monto, fecha,idcatergoria,idcuenta,tipo,hora FROM tblTransaccion WHERE idtransaccion =@id
end 
go


create procedure actualizarTransaccion @id int,
										@fecha date,
										@hora varchar(50),
										@tipo varchar(50),
										@monto float,
										@idcuenta int,
										@idcate int
										as
begin
update tblTransaccion set	fecha=@fecha,
							hora=@hora,
							tipo=@tipo,
							monto=@monto,
							idcuenta=@idcuenta,
							idcatergoria=@idcate
							where idtransaccion=@id
end
go


create trigger trigger_ingreso
  on tblTransaccion
  for insert
  as
   declare @monto float
   select @monto = monto from tblCuenta
		 join inserted
		 on inserted.idcuenta = tblCuenta.idcuenta
		 where tblCuenta.idcuenta = inserted.idcuenta
  if ((select tipo from inserted) = 'Ingreso')
    update tblCuenta set montototal = montototal + inserted.monto
     from tblCuenta
     join inserted
     on inserted.idcuenta = tblCuenta.idcuenta
     where idtransaccion = inserted.idtransaccion
go

create trigger trigger_gasto
  on tblTransaccion
  for insert
  as
   declare @monto float
   select @monto = monto from tblCuenta
		 join inserted
		 on inserted.idcuenta = tblCuenta.idcuenta
		 where tblCuenta.idcuenta = inserted.idcuenta
  if ((select tipo from inserted) = 'Gasto')
    update tblCuenta set montototal = montototal - inserted.monto
     from tblCuenta
     join inserted
     on inserted.idcuenta = tblCuenta.idcuenta
     where idtransaccion = inserted.idtransaccion
go




