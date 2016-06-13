use Parcialsoft2

/*-------------------------------------------TRANSFERENCIAS---------------------------------------------*/
/*--Consultar tabla Transferencia--*/
CREATE FUNCTION selectTransferencia()
RETURNS
TABLE
AS
RETURN 
(
	SELECT * FROM tblTransferencia
)
go

/*SELECT * FROM selectTransferencia()*/

/*--Insertar Transferencia--*/
create procedure insertTransferencia	@idcuentaorigen int,
										@idcuentadestino int,
										@descripcion varchar(50), 
										@fecha date, 
										@monto float
as 
begin try 
	begin tran
		insert into tblTransferencia(idcuentaorigen, idcuentadestino, descripcion, fecha, monto)
		values (@idcuentaorigen, @idcuentadestino, @descripcion, @fecha, @monto)
		commit
	end try
	begin catch
		rollback
		print error_message() 
	end catch
go
/*exec insertTransferencia 3, 2, 'Transferencia  de Billetera-3 a 2, de $ 1600', '20160611', 1600*/

/*--Eliminar Transferencias--*/
CREATE PROCEDURE dbo.deleteTransferencia
       @idtransferencia    INT        
AS 
BEGIN 
     DELETE FROM   tblTransferencia
     WHERE  
     idtransferencia = @idtransferencia
END
go

/*exec dbo.deleteTransferencia 3*/

/*--Modificar transferencia--*/
CREATE PROCEDURE dbo.updateTransferencia		@idtransferencia int,
												@idcuentaorigen int,
												@idcuentadestino int,
												@descripcion varchar(50), 
												@fecha date, 
												@monto float
AS
BEGIN 
      SET NOCOUNT ON
      UPDATE tblTransferencia
      SET  idcuentaorigen = @idcuentaorigen, 
	  idcuentadestino = @idcuentadestino, 
	  descripcion = @descripcion, 
	  monto = @monto 
      WHERE  
      idtransferencia = @idtransferencia
END
go

/*EXEC dbo.updateTransferencia  1, 2, 2, 'Descripcion', '20160605', 300*/


/*----------------------------------------------->IMPORTANTE<----------------------------------------------- 
Es importante que la creacion de los triggers se ejecute uno por uno, de arriba hacia abajo. De otro modo, 
si se cambia el orden de creacion, cambia el orden de ejecucion de los mismo, esto impediria el correcto 
funcionamiento del las "Tranferencias"*/


/*Tranferencia - Primer trigger a ejecutar para insertar*/
create trigger al_insertartransferencia_inc_cuentadestino
  on tblTransferencia
  for insert
  as
   declare @montototal float
   select @montototal = montototal from tblCuenta
		 join inserted
		 on inserted.idcuentaorigen = tblCuenta.idcuenta
		 where tblCuenta.idcuenta = inserted.idcuentaorigen
  if (@montototal > (select monto from inserted)-1)
    update tblCuenta set montototal = montototal+inserted.monto
     from tblCuenta
     join inserted
     on inserted.idcuentadestino = tblCuenta.idcuenta
     where idtransferencia = inserted.idtransferencia
  else
  begin
    raiserror ('Hay menos saldo en la cuenta de origen, de los solicitados para la tranferencia', 16, 1)
    rollback transaction
  end
  go

/*Tranferencia - Segundo trigger a ejecutar para insertar*/
create trigger al_insertartransferencia_decr_cuentaorigen
  on tblTransferencia
  for insert
  as
   declare @montototal float
   select @montototal = montototal from tblCuenta
		 join inserted
		 on inserted.idcuentaorigen = tblCuenta.idcuenta
		 where tblCuenta.idcuenta = inserted.idcuentaorigen
  if (@montototal > (select monto from inserted)-1)
    update tblCuenta set montototal = montototal-inserted.monto
     from tblCuenta
     join inserted
     on inserted.idcuentaorigen = tblCuenta.idcuenta
     where idtransferencia = inserted.idtransferencia
  else
  begin
    raiserror ('Hay menos saldo en la cuenta de origen, de los solicitados para la tranferencia', 16, 1)
    rollback transaction
  end
go
/*--------------------------------------------------------------------------------------------------------------*/

/*Tranferencia - Primer trigger a ejecutar para eliminar*/
create trigger al_eliminartransferencia_mod_cuentaorigen
  on tblTransferencia
  for delete
  as
   declare @montototal float 
   select @montototal = montototal from tblCuenta
		 join deleted
		 on deleted.idcuentadestino = tblCuenta.idcuenta
		 where tblCuenta.idcuenta = deleted.idcuentadestino
  if (@montototal > (select monto from deleted)-1)
    update tblCuenta set montototal = montototal+deleted.monto
     from tblCuenta
     join deleted
     on deleted.idcuentaorigen = tblCuenta.idcuenta
     where idtransferencia = deleted.idtransferencia
  else
  begin
    raiserror ('Hay menos saldo en la cuenta de destinoque lo tranferido, no se puede revertir la transferencia', 16, 1)
    rollback transaction
  end
go

/*Tranferencia - Segundo trigger a ejecutar para eliminar*/
create trigger al_eliminartransferencia_mod_cuentadestino
  on tblTransferencia
  for delete
  as
   declare @montototal float 
   select @montototal = montototal from tblCuenta
		 join deleted
		 on deleted.idcuentadestino = tblCuenta.idcuenta
		 where tblCuenta.idcuenta = deleted.idcuentadestino
  if (@montototal > (select monto from deleted)-1)
    update tblCuenta set montototal = montototal-deleted.monto
     from tblCuenta
     join deleted
     on deleted.idcuentadestino = tblCuenta.idcuenta
     where idtransferencia = deleted.idtransferencia
  else
  begin
    raiserror ('Hay menos saldo en la cuenta de destino que lo tranferido, no se puede revertir la transferencia', 16, 1)
    rollback transaction
  end
go

