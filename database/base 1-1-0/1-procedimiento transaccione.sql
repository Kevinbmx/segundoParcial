
create procedure buscarTransaccionFecha @fecha date,@idcuenta int
as 
begin 
	
		SELECT idtransaccion, monto, fecha,idcuenta,idcatergoria,tipo FROM tblTransaccion  where fecha=@fecha and idcuenta=@idcuenta
		
end 


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

create procedure eliminarTransaccion @id int
as
begin 
delete from tblTransaccion 
where idtransaccion=@id
end