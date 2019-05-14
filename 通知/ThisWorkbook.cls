VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "ThisWorkbook"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = True
Dim i As Single
Private Sub Workbook_open()
    Call self
End Sub
Private Sub self()
    On Error Resume Next
    i = i + 1
    If i = 1 Then
        工作表1.Cells(2, 2) = Sheet4.Cells(5, 2)
        工作表1.Cells(2, 3) = Sheet4.Cells(2, 5)
        工作表1.Cells(2, 6) = Sheet4.Cells(2, 8)
        工作表1.Cells(2, 7) = Sheet4.Cells(2, 9)
        i = i + 2
    End If

    工作表1.Cells(i, 2) = Time
    工作表1.Cells(i, 3) = Sheet4.Cells(5, 5)
    工作表1.Cells(i, 4) = Sheet4.Cells(5, 6)
    工作表1.Cells(i, 5) = Sheet4.Cells(5, 7)
    工作表1.Cells(i, 6) = Sheet4.Cells(5, 8)
    工作表1.Cells(i, 7) = Sheet4.Cells(5, 9)
    工作表1.Cells(2, 2) = Sheet4.Cells(5, 2)
    工作表1.Cells(2, 3) = Sheet4.Cells(2, 5)
    工作表1.Cells(2, 6) = Sheet4.Cells(2, 8)
    工作表1.Cells(2, 7) = Sheet4.Cells(2, 9)
	工作表1.Cells(i, 3) = Sheet4.Cells(5, 5)
    工作表1.Cells(i, 4) = Sheet4.Cells(5, 6)
    工作表1.Cells(i, 5) = Sheet4.Cells(5, 7)
    工作表1.Cells(i, 6) = Sheet4.Cells(5, 8)
    工作表1.Cells(i, 7) = Sheet4.Cells(5, 9)
    工作表1.Cells(2, 2) = Sheet4.Cells(5, 2)
    工作表1.Cells(i, 4) = Sheet4.Cells(5, 6)
    工作表1.Cells(i, 5) = Sheet4.Cells(5, 7)
    工作表1.Cells(i, 6) = Sheet4.Cells(5, 8)
    工作表1.Cells(i, 7) = Sheet4.Cells(5, 9)
    工作表1.Cells(2, 2) = Sheet4.Cells(5, 2)
    工作表1.Cells(2, 3) = Sheet4.Cells(2, 5)
    工作表1.Cells(2, 6) = Sheet4.Cells(2, 8)
    工作表1.Cells(2, 7) = Sheet4.Cells(2, 9)
     i = i + 2
    End If

    工作表1.Cells(i, 2) = Time
    工作表1.Cells(i, 3) = Sheet4.Cells(5, 5)
    工作表1.Cells(i, 4) = Sheet4.Cells(5, 6)
    工作表1.Cells(i, 5) = Sheet4.Cells(5, 7)
    工作表1.Cells(i, 6) = Sheet4.Cells(5, 8)
    工作表1.Cells(i, 7) = Sheet4.Cells(5, 9)
End If

End Sub
Private Sub Workbook_BeforeClose(cancel As Boolean)
    On Error Resume Next
    Application.OnTime Now , "ThisWorkbook", , true
End Sub
