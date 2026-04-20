Imports System.Data.SqlClient
Imports System.Data
Imports WSReniec

Public Class ClsData

    Dim cn As SqlConnection = New ClsConeccion().Coneccion()

    Public Function GetPersona(ByVal StrDNI As String) As String
        Try
            Dim cmd As New SqlCommand("RENIEC_GETPERSONA", cn)
            cmd.CommandType = CommandType.StoredProcedure
            cmd.Parameters.Add("@DNI", SqlDbType.VarChar, 50).Value = StrDNI.Trim
            cn.Open()
            Dim strresul As String = cmd.ExecuteScalar.ToString
            cn.Close()
            Return strresul
        Catch ex As Exception
            Return "0"
        End Try

    End Function
End Class
