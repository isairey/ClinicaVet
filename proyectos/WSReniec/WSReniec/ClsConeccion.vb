Imports System.Data.SqlClient


Public Class ClsConeccion

    Public Function Coneccion() As SqlConnection
        Dim cn As New SqlConnection
        cn.ConnectionString = ConfigurationManager.ConnectionStrings("ConexionReniec").ConnectionString
        Return cn
    End Function

End Class
