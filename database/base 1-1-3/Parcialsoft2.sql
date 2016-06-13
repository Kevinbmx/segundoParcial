ALTER FUNCTION [dbo].[fn_cuentaid] (@cuentaid int)
RETURNS table  
AS
return(select idcuenta,montototal, nombrecuenta,idusuario
		 FROM tblCuenta
		  WHERE idcuenta = @cuentaid
)
go