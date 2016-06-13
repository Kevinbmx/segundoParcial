use Parcialsoft2
create procedure buscarTransaccionFecha @fecha date,@idcuenta int
as 
begin 
		SELECT idtransaccion, monto, fecha,idcuenta,idcatergoria,tipo FROM tblTransaccion  where fecha=@fecha and idcuenta=@idcuenta
end 
go


create procedure SeleccionarTransaccion	
as 
begin 
		SELECT idtransaccion, monto, fecha,idcatergoria,idcuenta,tipo FROM tblTransaccion
	end 
go

create procedure InsertarTransaccion 
									@monto int,
									@fecha date,
									@idcategoria int,
									@idcuenta int,
									@tipo varchar(50)
as 
begin 
		INSERT INTO tblTransaccion (monto, fecha,idcatergoria,idcuenta,tipo)
		VALUES (@monto,@fecha,@idcategoria,@idcuenta,@tipo)
	end
go

create procedure selectbyId @id int
as
begin 
	SELECT idtransaccion, monto, fecha,idcatergoria,idcuenta,tipo 
	FROM tblTransaccion 
	WHERE idtransaccion =@id
end
go