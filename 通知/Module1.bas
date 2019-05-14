Attribute VB_Name = "Module1"
Option Explicit

Public Function PolaSendOrder(strOrderType, strOrderData)
    Application.EnableEvents = False
    PolaSendOrder = Sheet1.SendOrderText(strOrderType, strOrderData)
    Application.EnableEvents = True
End Function

Public Function PolaSetAPI(intSetType As Integer)
    Sheet1.SetAPIStatus intSetType
    PolaSetAPI = "Setting API..."
    'PolaGetLastReport
End Function

Public Function PolaGetLastReportMsg() As String
    Application.Volatile
    PolaGetLastReportMsg = Sheet1.strMsg
End Function

Public Function PolaGetLastReportArray(strMsg As String) As Variant
    Dim strTmp As String
    Application.Volatile
    If strMsg = "" Then strTmp = Sheet1.strIndex + ",#" + Sheet1.strMsg Else strTmp = strMsg
    PolaGetLastReportArray = Split(strTmp, ",#")
End Function


Public Function PolaGetOrderString()
    Application.Volatile
    PolaGetOrderString = Sheet1.GetOrderText
End Function

Public Function PolaGetOrderCount() As Long
    Application.Volatile
    PolaGetOrderCount = Sheet1.intOrderCnt

End Function
Public Function PolaGetWatchList(strStkCode) As String
    'Application.EnableEvents = False
    If Trim(strStkCode) = "" Then
        Sheet1.GetStkWatchList ("")
        PolaGetWatchList = "exit..."
    Else
        Sheet1.GetStkWatchList (strStkCode)
        PolaGetWatchList = strStkCode
    End If
    'Application.EnableEvents = True
End Function
