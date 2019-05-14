VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "Sheet1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = True
Option Explicit
Dim bolOpen As Boolean
Dim intEventIndex As Long
Dim EWW As New EWinner_Interface
Dim WithEvents EWinner As EWinner_Interface
Attribute EWinner.VB_VarHelpID = -1

Public intOrderCnt As Long
Public strIndex, strMsg, strOrderText As String



Private Sub CommandButton1_Click()
  
  Dim OrderType As String
  Dim OrderData As String
  
  OrderType = Sheet1.Cells(1, 2)
  OrderData = GetOrderText
  
  Sheet1.Cells(19, 1) = OrderData
  
End Sub

Private Sub CommandButton2_Click()
  
  Dim OrderType As String
  Dim OrderData As String
  
  
  OrderType = Sheet1.Cells(1, 2)
  OrderDatum = GetOrderText
  
  
  'Sheet1.Cells(20, 1) = OrderData
  
  'EWW.SendOrder (OrderType), (OrderData)
  SendOrderText OrderType, OrderData
  'SendOrderText OrderType, OrderData
  
End Sub

Private Sub CommandButton3_Click()
  Dim strTmp As String
  intEventIndex = 33
  SetAPIStatus (1)
  'MsgBox strTmp
  'StrResult = EWW.SetOpen(1)
  'Sheet1.Cells(1, 2) = StrResult

End Sub

Private Sub CommandButton4_Click()
  'EWW.SetOpen (0)
  SetAPIStatus 0
  If intEventIndex < 33 Then
    intEventIndex = 33
  End If
  Range("A33:B" & CStr(intEventIndex)).Select
  Selection.ClearContents
  
  'StrResult = EWW.SetOpen(0)
  'Sheet1.Cells(1, 3) = StrResult
  'Set EWinner = Nothing
  'Set EWW = Nothing
  intEventIndex = 33
End Sub

Private Sub CommandButton5_Click()
  Dim OrderType As String
  Dim OrderData As String
  
  
  OrderType = Sheet1.Cells(1, 2) & "T"
  OrderData = GetOrderText
  
  EWW.SendOrder OrderType, OrderData
  'SendOrderText OrderType, OrderData
End Sub

Private Sub CommandButton6_Click()
On Error Resume Next
    Dim intRowIndex As Integer
    Dim intColIndex As Integer
    Dim i As Integer
    Dim j As Integer
    Dim strStkCodeList As String
    intRowIndex = 103
    intColIndex = 38
    Sheet1.GetStkWatchList ("")
    Sheet4.Range("B3:AL" & CStr(intRowIndex)).Cells.Clear
    For i = 3 To intRowIndex
        If Trim(Sheet4.Cells(i, 1)) <> "" Then
            For j = 2 To intColIndex
                'Sheet4.Cells(i, j) = CStr("=EWinner|RQ!" & CStr(Sheet4.Cells(i, 1)) & "." & CStr(Sheet4.Cells(1, j)))
                strStkCodeList = CStr("=EWinner|RQ!'" & CStr(Sheet4.Cells(i, 1)) & "." & CStr(Sheet4.Cells(1, j))) & "'"
                Sheet4.Cells(i, j).Value = ""
            Next j
        Else
            Exit For
        End If
    Next i
End Sub

Private Sub EWinner_OnDataResponse(ByVal Index As Long, ByVal Value As Variant)
'On Error Resume Next
  'Application.EnableEvents = False
  If intEventIndex < 33 Then
    intEventIndex = 33
  End If
  strIndex = CStr(Index)
  strMsg = CStr(Value)
  If Index = 201 Then
    GetWatchListSheet (strMsg)
  Else
    
    intEventIndex = intEventIndex + 1
    Sheet1.Cells(intEventIndex, 1) = strIndex
    Sheet1.Cells(intEventIndex, 2) = strMsg
    'Application.EnableEvents = True
      
  End If

End Sub
Private Sub GettWatchListSheet(strWatchListInfo As String)
    On Error Resume Next
    Dim intIndex As Integer
    Dim i As Integer
    Dim j As Integer
    intIndex = 100
    'intIndex = Sheet1.Rows.Count
    Dim aryWatchListInfo As Variant
    aryWatchListInfo = Split(strWatchListInfo, ",|")
    For i = 0 To UBound(aryWatchListInfo) - 1
        Dim bolStkCheck As Boolean
        bolStkCheck = False
         Dim aryStkInfo As Variant
        aryStkInfo = Split(aryyatchListInfo(i), ",#")
        For i = 3 To intIndex
            If Trim(CStr(Sheet4.Cells(j, 1))) <> "" Then
                If CStr(Sheet4.Cells(j, 1)) = CStr(aryStkInfo(0)) Then
                    Select Case CStr(aryStkInfo(1))
                        Case "0" 
                            Sheet4.Cells(j, 5) = ""
                            Sheet4.Cells(j, 5) = CStr(aryStkInfo(2))
                        Case "1" 
                            Sheet4.Cells(j, 6) = ""
                            Sheet4.Cells(j, 6) = CStr(aryStkInfo(2))
                        Case "2" 
                            Sheet4.Cells(j, 7) = ""
                            Sheet4.Cells(j, 7) = CStr(aryStkInfo(2))
                        Case "3" 
                            Sheet4.Cells(j, 3) = ""
                            Sheet4.Cells(j, 3) = CStr(aryStkInfo(2))
                        Case "4" 
                            Sheet4.Cells(j, 15) = ""
                            Sheet4.Cells(j, 15) = CStr(aryStkInfo(2))
                        Case "5" 
                            Sheet4.Cells(j, 4) = ""
                            Sheet4.Cells(j, 4) = CStr(aryStkInfo(2))
                        Case "6" 
                            Sheet4.Cells(j, 17) = ""
                            Sheet4.Cells(j, 17) = CStr(aryStkInfo(2))
                        Case "7" 
                            Sheet4.Cells(j, 8) = ""
                            Sheet4.Cells(j, 8) = CStr(aryStkInfo(2))
                        Case "8" 
                            Sheet4.Cells(j, 15) = ""
                            Sheet4.Cells(j, 15) = CStr(aryStkInfo(2))
                        Case "9" 
                            Sheet4.Cells(j, 13) = ""
                            Sheet4.Cells(j, 13) = CStr(aryStkInfo(2))
                        Case "10" 
                            Sheet4.Cells(j, 9) = ""
                            Sheet4.Cells(j, 9) = CStr(aryStkInfo(2))
                        Case "11" 
                            Sheet4.Cells(j, 39) = ""
                            Sheet4.Cells(j, 39) = CStr(aryStkInfo(2))
                        Case "12" 
                            Sheet4.Cells(j, 25) = ""
                            Sheet4.Cells(j, 25) = CStr(aryStkInfo(2))
                        Case "13" 
                            Sheet4.Cells(j, 31) = ""
                            Sheet4.Cells(j, 31) = CStr(aryStkInfo(2))
                        Case "14" 
                            Sheet4.Cells(j, 32) = ""
                            Sheet4.Cells(j, 32) = CStr(aryStkInfo(2))
                        Case "15" 
                            Sheet4.Cells(j, 33) = ""
                            Sheet4.Cells(j, 33) = CStr(aryStkInfo(2))
                        Case "16" 
                            Sheet4.Cells(j, 27) = ""
                            Sheet4.Cells(j, 27) = CStr(aryStkInfo(2))
                        Case "17" 
                            Sheet4.Cells(j, 30) = ""
                            Sheet4.Cells(j, 30) = CStr(aryStkInfo(2))
                        Case "18" 
                            Sheet4.Cells(j, 29) = ""
                            Sheet4.Cells(j, 29) = CStr(aryStkInfo(2))
                        Case "19" 
                            Sheet4.Cells(j, 28) = ""
                            Sheet4.Cells(j, 28) = CStr(aryStkInfo(2))
                        Case "20" 
                            Sheet4.Cells(j, 34) = ""
                            Sheet4.Cells(j, 34) = CStr(aryStkInfo(2))
                        Case "21" 
                            Sheet4.Cells(j, 35) = ""
                            Sheet4.Cells(j, 35) = CStr(aryStkInfo(2))
                        Case "42"
                            Sheet4.Cells(j, 37) = ""
                            Sheet4.Cells(j, 37) = CStr(aryStkInfo(2))
                        Case "43" 
                            Sheet4.Cells(j, 38) = ""
                            Sheet4.Cells(j, 38) = CStr(aryStkInfo(2))
                        Case "255" 
                            Sheet4.Cells(j, 10) = ""
                            Sheet4.Cells(j, 10) = CStr(aryStkInfo(2))
                    End Select
                    bolStkCheck = True
                    Exit For
                End If
            Else
                Exit For
            End If
        Next j
        
    Next i
    
End Sub
Public Function SendOrderText(strOrderType, strOrderData)
    Application.EnableEvents = False
    SendOrderText = "False"
    strOrderData = GetOrderText()
    If Not bolOpen Then Exit Function
    If MsgBox("是否送出此委託單", vbOKCancel + vbDefaultButton2, "資訊") = vbOK Then
        intOrderCnt = intOrderCnt + 1
        EWW.SendOrder strOrderType, strOrrderData
        SendOrderText = "True"
    End If
    Application.EnableEvents = True
End Function

Public Sub SetAPIStatus(intSetType As Integer)
    Select Case intSetType
        Case 0
            EWW.SetOpen (intSetType)
            Set EWW = Nothing
            Set EWinner = Nothing
            bolOpen = False
            
            'Range("G4").Activate
            strIndex = ""
            strMsg = ""
        Case 1
            
            If bolOpen = False Then
                Set EWinner = EWW
                strIndex = ""
                strMsg = ""
                intOrderCnt = 0
            End If
            EWW.SetOpen (intSetType)
            bolOpen = True
            'olumns
    End Select
End Sub

Public Function GetOrderText()
  If Sheet1.Cells(1, 2) = "S" Then
     GetOrderText = "Account=" & Sheet1.Cells(3, 2) & ",ProductID=" & Sheet1.Cells(5, 2) & ",TradeType=" & Sheet1.Cells(6, 2) & ", TradeKind=" & Sheet1.Cells(7, 2) & ", OrderType=" & Sheet1.Cells(8, 2) & ", BuySell=" & Sheet1.Cells(9, 2) & ", Qty=" & Sheet1.Cells(10, 2) & ", Price=" & Sheet1.Cells(11, 2) & ", OrderNo=" & Sheet1.Cells(12, 2) & ", TradeDate=" & Sheet1.Cells(13, 2) & ", BasketNo=" & Sheet1.Cells(14, 2)
  ElseIf Sheet1.Cells(1, 2) = "F" Then
     GetOrderText = "Account=" & Sheet1.Cells(3, 5) & ",ProductID=" & Sheet1.Cells(4, 5) & ", TradeKind=" & Sheet1.Cells(5, 5) & ", BuySell=" & Sheet1.Cells(6, 5) & ", ProductID2=" & Sheet1.Cells(7, 5) & ", BuySell2=" & Sheet1.Cells(8, 5) & ", Qty=" & Sheet1.Cells(9, 5) & ", Price=" & Sheet1.Cells(10, 5) & ", PositionEffect=" & Sheet1.Cells(11, 5) & ", DayTrade=" & Sheet1.Cells(12, 5) & ", OrderCond=" & Sheet1.Cells(13, 5) & ", OrderNo=" & Sheet1.Cells(14, 5) & ", TradeDate=" & Sheet1.Cells(15, 5) & ", BasketNo=" & Sheet1.Cells(16, 5)
  ElseIf Sheet1.Cells(1, 2) = "O" Then
     GetOrderText = "Account=" & Sheet1.Cells(3, 5) & ",ProductID=" & Sheet1.Cells(4, 5) & ", TradeKind=" & Sheet1.Cells(5, 5) & ", BuySell=" & Sheet1.Cells(6, 5) & ", ProductID2=" & Sheet1.Cells(7, 5) & ", BuySell2=" & Sheet1.Cells(8, 5) & ", Qty=" & Sheet1.Cells(9, 5) & ", Price=" & Sheet1.Cells(10, 5) & ", PositionEffect=" & Sheet1.Cells(11, 5) & ", DayTrade=" & Sheet1.Cells(12, 5) & ", OrderCond=" & Sheet1.Cells(13, 5) & ", OrderNo=" & Sheet1.Cells(14, 5) & ", TradeDate=" & Sheet1.Cells(15, 5) & ", BasketNo=" & Sheet1.Cells(16, 5)
  ElseIf Sheet1.Cells(1, 2) = "A" Then
     GetOrderText = "Account=" & Sheet1.Cells(3, 8) & ",ProductID=" & Sheet1.Cells(4, 8) & ", TradeKind=" & Sheet1.Cells(5, 8) & ", PriceType=" & Sheet1.Cells(6, 8) & ", BuySell=" & Sheet1.Cells(7, 8) & ", Qty=" & Sheet1.Cells(8, 8) & ", UtPrice=" & Sheet1.Cells(9, 8) & ", UtPrice2=" & Sheet1.Cells(10, 8) & ", UtPrice4=" & Sheet1.Cells(11, 8) & ", UtPrice5=" & Sheet1.Cells(12, 8) & ", DayTrade=" & Sheet1.Cells(13, 8) & ", OrderNo=" & Sheet1.Cells(14, 8) & ", TradeDate=" & Sheet1.Cells(15, 8)
  End If
End Function
Public Sub GetStkWatchList(strStkCode As String)
    EWW.GetWatchList (strStrkCode)
End Sub
