Option Strict Off
Option Explicit On
'UPGRADE_NOTE: Main was upgraded to Main_Renamed. Click for more: 'ms-help://MS.VSCC.v80/dv_commoner/local/redirect.htm?keyword="A9E4979A-37FA-4718-9994-97DD76ED70A7"'
Friend Class Main_Renamed
	Inherits System.Windows.Forms.Form
	
	Private Sub Command1_Click(ByVal eventSender As System.Object, ByVal eventArgs As System.EventArgs) Handles Command1.Click
        Shell("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\selectsort.bat")
		
	End Sub
	
	Private Sub Command2_Click(ByVal eventSender As System.Object, ByVal eventArgs As System.EventArgs) Handles Command2.Click
        Shell("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\insertsort.bat")
	End Sub
	
	Private Sub Command3_Click(ByVal eventSender As System.Object, ByVal eventArgs As System.EventArgs) Handles Command3.Click
        Shell("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\bst.bat")
	End Sub
	
	
	Private Sub Command4_Click(ByVal eventSender As System.Object, ByVal eventArgs As System.EventArgs) Handles Command4.Click
        Shell("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\merge.bat")
	End Sub
	
	Private Sub Command5_Click(ByVal eventSender As System.Object, ByVal eventArgs As System.EventArgs) Handles Command5.Click
        Shell("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\bubble.bat")
	End Sub
	
	Private Sub Command6_Click(ByVal eventSender As System.Object, ByVal eventArgs As System.EventArgs) Handles Command6.Click
        Shell("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\quick.bat")
	End Sub
	
	Private Sub Command7_Click(ByVal eventSender As System.Object, ByVal eventArgs As System.EventArgs) Handles Command7.Click
		Me.Close()
	End Sub
End Class