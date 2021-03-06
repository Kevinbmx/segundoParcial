create database Parcialsoft2
USE [Parcialsoft2]
GO
/****** Object:  StoredProcedure [dbo].[actualizarcategoria]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[actualizarcategoria](
									@categoriaId int,
									@nombre varchar(50),
									@descripcion varchar(50)
)
AS
BEGIN TRY
	BEGIN TRAN 
		UPDATE tblCategoria     set nombrecategoria = @nombre,
								    descripcion=@descripcion
		where idcategoria= @categoriaId
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH

GO
/****** Object:  StoredProcedure [dbo].[actualizarcuenta]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[actualizarcuenta](
									@cuentaid int,
									@montototal float,
									@nombre varchar(50),
									@idusuario int
)
AS
BEGIN TRY
	BEGIN TRAN 
		UPDATE tblCuenta     set 
									montototal= @montototal,
									nombrecuenta= @nombre,
									idusuario= @idusuario
								 
		where idcuenta= @cuentaid
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH

GO
/****** Object:  StoredProcedure [dbo].[actualizarusuario]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[actualizarusuario](
									@usuarioId int,
									@nombre varchar(50),
									@telefono varchar(50)
)
AS
BEGIN TRY
	BEGIN TRAN 
		UPDATE tblUsuarios  set nombreusuario = @nombre,
								telefono = @telefono
								
		where idusuario= @usuarioId
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH

GO
/****** Object:  StoredProcedure [dbo].[eliminarcategoria]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[eliminarcategoria](  @categoriaId    INT        )
AS 
BEGIN 
     DELETE FROM tblCategoria
     WHERE  
     idcategoria = @categoriaId
END

GO
/****** Object:  StoredProcedure [dbo].[eliminarcuenta]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[eliminarcuenta](@cuentaId  int )
AS 
BEGIN 
     DELETE FROM tblCuenta
     WHERE  
	 idcuenta = @cuentaId
END

GO
/****** Object:  StoredProcedure [dbo].[eliminarUsuario]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[eliminarUsuario]  @usuarioId    INT        
AS 
BEGIN 
     DELETE FROM tblUsuarios
     WHERE  
     idusuario = @usuarioId
END

GO
/****** Object:  StoredProcedure [dbo].[insertarcategoria]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[insertarcategoria]	@nombre varchar(50),
											@descripcion varchar(50)
as 
begin try 
	begin tran
		insert into tblCategoria(nombrecategoria,descripcion)
		values (@nombre,@descripcion )
		commit
	end try
	begin catch
		rollback
		print error_message() 
	end catch

GO
/****** Object:  StoredProcedure [dbo].[insertarcuentas]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[insertarcuentas]	@monto float,
											@nombrecuenta varchar(50),
											@idUsuario int
as 
begin try 
	begin tran
		insert into tblCuenta(montototal,nombrecuenta,idusuario)
		values (@monto,@nombrecuenta,@idUsuario)
		commit
	end try
	begin catch
		rollback
		print error_message() 
	end catch

GO
/****** Object:  StoredProcedure [dbo].[insertarUsuario]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[insertarUsuario]	@nombre varchar(50),
											@telefono varchar(50)
as 
begin try 
	begin tran
		insert into tblusuarios(nombreusuario,telefono)
		values (@nombre,@telefono)
		commit
	end try
	begin catch
		rollback
		print error_message() 
	end catch

GO
/****** Object:  Table [dbo].[tblCategoria]    Script Date: 10/06/2016 0:30:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblCategoria](
	[idcategoria] [int] IDENTITY(1,1) NOT NULL,
	[nombrecategoria] [varchar](50) NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tblCategoria] PRIMARY KEY CLUSTERED 
(
	[idcategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblCuenta]    Script Date: 10/06/2016 0:30:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblCuenta](
	[idcuenta] [int] IDENTITY(1,1) NOT NULL,
	[montototal] [float] NOT NULL,
	[nombrecuenta] [varchar](50) NULL,
	[idusuario] [int] NOT NULL,
 CONSTRAINT [PK_tblCuenta] PRIMARY KEY CLUSTERED 
(
	[idcuenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblTransaccion]    Script Date: 10/06/2016 0:30:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblTransaccion](
	[idtransaccion] [int] IDENTITY(1,1) NOT NULL,
	[monto] [float] NOT NULL,
	[tipo] [varchar](50) NULL,
	[fecha] [date] NOT NULL,
	[idcatergoria] [int] NOT NULL,
	[idcuenta] [int] NOT NULL,
 CONSTRAINT [PK_tblTransaccion] PRIMARY KEY CLUSTERED 
(
	[idtransaccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblTransferencia]    Script Date: 10/06/2016 0:30:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblTransferencia](
	[idtransferencia] [int] IDENTITY(1,1) NOT NULL,
	[idcuentaorigen] [int] NOT NULL,
	[idcuentadestino] [int] NOT NULL,
	[descripcion] [varchar](50) NULL,
	[fecha] [date] NOT NULL,
	[monto] [float] NOT NULL,
 CONSTRAINT [PK_tblTransferencia] PRIMARY KEY CLUSTERED 
(
	[idtransferencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblUsuarios]    Script Date: 10/06/2016 0:30:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblUsuarios](
	[idusuario] [int] IDENTITY(1,1) NOT NULL,
	[nombreusuario] [varchar](50) NOT NULL,
	[telefono] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tblUsuarios] PRIMARY KEY CLUSTERED 
(
	[idusuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[tblCuenta]  WITH CHECK ADD  CONSTRAINT [FK_tblCuenta_tblUsuarios] FOREIGN KEY([idusuario])
REFERENCES [dbo].[tblUsuarios] ([idusuario])
GO
ALTER TABLE [dbo].[tblCuenta] CHECK CONSTRAINT [FK_tblCuenta_tblUsuarios]
GO
ALTER TABLE [dbo].[tblTransaccion]  WITH CHECK ADD  CONSTRAINT [FK_tblTransaccion_tblCategoria1] FOREIGN KEY([idcatergoria])
REFERENCES [dbo].[tblCategoria] ([idcategoria])
GO
ALTER TABLE [dbo].[tblTransaccion] CHECK CONSTRAINT [FK_tblTransaccion_tblCategoria1]
GO
ALTER TABLE [dbo].[tblTransaccion]  WITH CHECK ADD  CONSTRAINT [FK_tblTransaccion_tblCuenta] FOREIGN KEY([idcuenta])
REFERENCES [dbo].[tblCuenta] ([idcuenta])
GO
ALTER TABLE [dbo].[tblTransaccion] CHECK CONSTRAINT [FK_tblTransaccion_tblCuenta]
GO
ALTER TABLE [dbo].[tblTransferencia]  WITH CHECK ADD  CONSTRAINT [FK_tblTransferencia_tblCuenta] FOREIGN KEY([idcuentaorigen])
REFERENCES [dbo].[tblCuenta] ([idcuenta])
GO
ALTER TABLE [dbo].[tblTransferencia] CHECK CONSTRAINT [FK_tblTransferencia_tblCuenta]
GO
ALTER TABLE [dbo].[tblTransferencia]  WITH CHECK ADD  CONSTRAINT [FK_tblTransferencia_tblCuenta2] FOREIGN KEY([idcuentadestino])
REFERENCES [dbo].[tblCuenta] ([idcuenta])
GO
ALTER TABLE [dbo].[tblTransferencia] CHECK CONSTRAINT [FK_tblTransferencia_tblCuenta2]
GO


/*creacion del Usuario*/


insert into tblusuarios(nombreusuario,telefono) values ('administrador','70054865')



/*insertar categorias*/

insert into tblCategoria(nombrecategoria,descripcion) values ('transporte','para el transporte dentro de la ciudad')
insert into tblCategoria(nombrecategoria,descripcion) values ('comida','para el consumo diario')
insert into tblCategoria(nombrecategoria,descripcion) values ('taxi','para llegar rapido a algun lugar')
insert into tblCategoria(nombrecategoria,descripcion) values ('provisiones','para darse algun gusto en alguna cosa o actividad')
insert into tblCategoria(nombrecategoria,descripcion) values ('ropa','para estrenar alguna prenda de vestir')
insert into tblCategoria(nombrecategoria,descripcion) values ('medicamentos','para algun mal estar que uno tiene')
insert into tblCategoria(nombrecategoria,descripcion) values ('educacion','para algunas fotocopias u otras cosas')
insert into tblCategoria(nombrecategoria,descripcion) values ('viajes','para que puedas viajar nacional o internacional')


