VERSION 5.00
Begin VB.Form Main 
   Caption         =   "Simulation of DATA STRUCTURE"
   ClientHeight    =   4770
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   6045
   Icon            =   "Sort.frx":0000
   LinkTopic       =   "Form1"
   ScaleHeight     =   4770
   ScaleWidth      =   6045
   StartUpPosition =   1  'CenterOwner
   Begin VB.CommandButton Command4 
      Caption         =   "Merge Sort"
      Height          =   495
      Left            =   2400
      TabIndex        =   8
      Top             =   2880
      Width           =   1215
   End
   Begin VB.CommandButton Command3 
      Caption         =   "Binary Search Tree"
      Height          =   495
      Left            =   840
      TabIndex        =   7
      Top             =   1920
      Width           =   1215
   End
   Begin VB.CommandButton Command7 
      Caption         =   "Exit"
      Height          =   615
      Left            =   1920
      TabIndex        =   5
      Top             =   3960
      Width           =   2295
   End
   Begin VB.CommandButton Command6 
      Caption         =   "Quick Sort"
      Height          =   495
      Left            =   3960
      TabIndex        =   4
      Top             =   2880
      Width           =   1215
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Selection Sort"
      Height          =   495
      Left            =   3960
      TabIndex        =   3
      Top             =   1920
      Width           =   1215
   End
   Begin VB.CommandButton Command5 
      Caption         =   "Bubble Sort"
      Height          =   495
      Left            =   2400
      TabIndex        =   1
      Top             =   1920
      Width           =   1215
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Insertion Sort"
      Height          =   495
      Left            =   840
      TabIndex        =   0
      Top             =   2880
      Width           =   1215
   End
   Begin VB.Frame Frame1 
      Caption         =   "Operations"
      Height          =   2055
      Left            =   480
      TabIndex        =   2
      Top             =   1560
      Width           =   5175
   End
   Begin VB.Label Label1 
      Alignment       =   2  'Center
      Caption         =   "Simulation Of DATA STRUCTURE"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   20.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   1095
      Left            =   120
      TabIndex        =   6
      Top             =   240
      Width           =   5895
   End
End
Attribute VB_Name = "Main"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub Command1_Click()
Shell ("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\selectsort.bat")

End Sub

Private Sub Command2_Click()
Shell ("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\insertsort.bat")
End Sub

Private Sub Command3_Click()
Shell ("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\bst.bat")
End Sub


Private Sub Command4_Click()
Shell ("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\merge.bat")
End Sub

Private Sub Command5_Click()
Shell ("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\bubble.bat")
End Sub

Private Sub Command6_Click()
Shell ("E:\SUSHANT\Conversion JAVA TO VB.NET\raj\quick.bat")
End Sub

Private Sub Command7_Click()
Unload Me
End Sub

