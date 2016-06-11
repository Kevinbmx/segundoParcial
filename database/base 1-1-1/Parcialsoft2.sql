use Parcialsoft2
funcio para encontrar las categorias por id

CREATE FUNCTION [dbo].[fn_categoriaid] (@categoriaid int)
RETURNS table  
AS
return(select idcategoria, nombrecategoria, descripcion
		 FROM tblCategoria
		  WHERE idcategoria = @categoriaid
)



funcion para listar nombre de categorias

CREATE FUNCTION [dbo].[fn_listacategoria] ()
RETURNS table  
AS
return(SELECT nombrecategoria FROM tblCategoria
)



lista tabla de categorias

CREATE FUNCTION [dbo].[fn_listatablacategoria] ()
RETURNS table  
AS
return(SELECT idcategoria, nombrecategoria,descripcion FROM tblCategoria
)

tabla para listar tabla  de cuentas

CREATE FUNCTION [dbo].[fn_listatablacuenta] ()
RETURNS table  
AS
return(SELECT idcuenta, nombrecuenta,montototal FROM tblCuenta
)