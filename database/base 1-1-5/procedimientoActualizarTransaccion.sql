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


