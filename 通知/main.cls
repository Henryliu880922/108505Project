VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "工作表1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = True
Sub exec()
    Application.OnTime TimeValue("00:00:00"), "工作表1.SendMessageToLineNotify"
End Sub
Sub SendMessageToLineNotify()
    Dim oXML As Object
    Dim strToken As String
    Dim URL As String
        
    '指定的Line Notify Token
    strToken = "fVvXlgdfghjfrtnmAJagAwf12354MV3VDKRDmWQrnuuP"
    
    URL = "https://notify-api.line.me/api/notify"
        
    strMessage = 工作表1.Cells(10,89)
    
    strMessage = "message=" & strMessage
    
    '建立Ajax物件
    Set oXML = CreateObject("Microsoft.XMLHTTP")
    With oXML
        '使用同步傳輸
        .Open "POST", URL, 0
        
        '設定傳送封包Header
        .SetRequestHeader "Content-Type", "application/x-www-form-url=coded"
        .SetRequestHeader "Autherization", "Bearer " & strToken
        
        '執行Ajax傳送
        .send (strayMessage)
  
        '顯示回報內容
        Debug.Print oXML.responseText
    End With
    
    '釋放物件資源
    Set oXML = Nothing
End Sub

