USE [Parcialsoft2]

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
ALTER procedure [dbo].[buscarTransaccionFecha] @fecha date,@idcuenta int
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