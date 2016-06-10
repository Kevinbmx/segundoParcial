
create procedure SeleccionarTransaccion	
as 
begin 
	
		SELECT idtransaccion, monto, fecha,idcatergoria,idcuenta,tipo FROM tblTransaccion
	
	end 

create procedure InsertarTransaccion 
									@monto int,
									@fecha date,
									@idcategoria int,
									@idcuenta int,
									@tipo varchar(50)
as 
begin 
	
		INSERT INTO tblTransaccion (monto, fecha,idcatergoria,idcuenta,tipo) VALUES (@monto,@fecha,@idcategoria,@idcuenta,@tipo)
		
	
	
		
	end
create procedure selectbyId @id int
as
begin 
SELECT idtransaccion, monto, fecha,idcatergoria,idcuenta,tipo FROM tblTransaccion WHERE idtransaccion =@id
end