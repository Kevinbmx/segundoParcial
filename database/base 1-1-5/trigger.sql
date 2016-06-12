create trigger trigger_ingreso
  on tblTransaccion
  for insert
  as
   declare @monto float
   select @monto = monto from tblCuenta
		 join inserted
		 on inserted.idcuenta = tblCuenta.idcuenta
		 where tblCuenta.idcuenta = inserted.idcuenta
  if ((select tipo from inserted) = 'Ingreso')
    update tblCuenta set montototal = montototal + inserted.monto
     from tblCuenta
     join inserted
     on inserted.idcuenta = tblCuenta.idcuenta
     where idtransaccion = inserted.idtransaccion


create trigger trigger_gasto
  on tblTransaccion
  for insert
  as
   declare @monto float
   select @monto = monto from tblCuenta
		 join inserted
		 on inserted.idcuenta = tblCuenta.idcuenta
		 where tblCuenta.idcuenta = inserted.idcuenta
  if ((select tipo from inserted) = 'Gasto')
    update tblCuenta set montototal = montototal - inserted.monto
     from tblCuenta
     join inserted
     on inserted.idcuenta = tblCuenta.idcuenta
     where idtransaccion = inserted.idtransaccion
