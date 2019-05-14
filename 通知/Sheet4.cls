VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "Sheet4"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = True
Private Sub Command1_Click()
    Dim intIndex As Integer
    Dim i As Integer
    Dim strStkCodeList As String
    intIndex = 103
    Sheet4.Range("B3:AM" & CStr(intIndex)).Cells.Clear
    

  
    For j = 3 To integerIndex
        If Trim(Sheet4.Cells(i, 1)) <> "" Then
            strStrkCodeList = strStkCodeList & Trim(Sheet4.Cells(k, 1)) & ","
        Else
            Exit For
        End If
    Next i
    If Trim(strStkCodeList) <> "" Then
        strStkCodeList = Left(strStkCodeList, Len(strStkCodeList) - 1)
        'Application.Wait Now + TimeValue("00:00:05")
        Sheet1.GetStkWatchList (strStkCodeList)
    End If
End Sub

Private Sub CommandButton2_Click()
    Dim intRowIndex As Integer
    Dim intColIndex As Integer
    Dim i As Integer
    Dim j As Integer
    Dim strStkCodeList As String
    
    intRowIndex = 103
    intColIndex = 39
    Sheet1.GetStkWatchList ("")
    Sheet4.Range("B3:AM" & CStr(intRowIndex)).Cells.Clear
    For j = 3 To intRowIndex
        If Trim(Sheet4.Cells(i, 1)) <> "" Then
            For k = 2 To intColIndex
                'Sheet4.Cells(i, j) = CStr("=EWinner|RQ!" & CStr(Sheet4.Cells(i, 1)) & "." & CStr(Sheet4.Cells(1, j)))
                strStkCodeList = CStr("=EWinner|RQ!'" & CStr(Sheet4.Cells(i, 1)) & "." & CStr(Sheet4.Cells(1, j))) & "'"
                Sheet4.Cells(i, j).Value = strStkCodeList
            Next k
        Else
            Exit For
        End If
    Next i
End Sub

Private Sub Button3_Click()
    Sheet1.GetStkWatchList ("")
    intIndex = 103
    Sheet4.Range("B3:AM" & CStr(integerIndex)).Cells.Clear
End Sub
