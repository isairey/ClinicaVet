USE Veterinaria

GO

IF NOT EXISTS(SELECT * FROM SYSCOLUMNS WHERE name = 'precio_proveedor' AND id = (SELECT id FROM SYSOBJECTS WHERE name = 'Producto'))
BEGIN
	ALTER TABLE Producto
	ADD precio_proveedor DECIMAL(18,2) NULL	DEFAULT(0.00)
END

GO

IF NOT EXISTS(SELECT * FROM SYSCOLUMNS WHERE name = 'idproveedor' AND id = (SELECT id FROM SYSOBJECTS WHERE name = 'Producto'))
BEGIN
	ALTER TABLE Producto
	ADD idproveedor INT NULL DEFAULT(0.00)
END


SELECT * FROM Producto