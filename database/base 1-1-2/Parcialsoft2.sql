CREATE FUNCTION [dbo].[fn_cuentaid] (@cuentaid int)
RETURNS table  
AS
return(select idcuenta, nombrecuenta,idusuario
		 FROM tblCuenta
		  WHERE idcuenta = @cuentaid
)
go

CREATE FUNCTION [dbo].[fn_cuentanombreid] (@nombre varchar(50))
RETURNS table  
AS
return(select idcuenta, nombrecuenta
		 FROM tblCuenta
		  WHERE nombrecuenta = @nombre
)
go

CREATE FUNCTION [dbo].[fn_categorianombreid] (@nombre varchar(50))
RETURNS table  
AS
return(select idcategoria, nombrecategoria
		 FROM tblCategoria
		  WHERE nombrecategoria = @nombre
)
go