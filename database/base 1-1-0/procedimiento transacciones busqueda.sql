
create procedure buscarTransaccionFecha @fecha date,@idcuenta int
as 
begin 
	
		SELECT idtransaccion, monto, fecha,idcuenta,idcatergoria,tipo FROM tblTransaccion  where fecha=@fecha and idcuenta=@idcuenta
		
end 