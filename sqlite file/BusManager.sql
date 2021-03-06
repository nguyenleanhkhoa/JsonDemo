USE [master]
GO
/****** Object:  Database [BusManager]    Script Date: 10/21/2017 6:58:17 PM ******/
CREATE DATABASE [BusManager]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BusManager', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\BusManager.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BusManager_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\BusManager_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [BusManager] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BusManager].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BusManager] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BusManager] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BusManager] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BusManager] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BusManager] SET ARITHABORT OFF 
GO
ALTER DATABASE [BusManager] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BusManager] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [BusManager] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BusManager] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BusManager] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BusManager] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BusManager] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BusManager] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BusManager] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BusManager] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BusManager] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BusManager] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BusManager] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BusManager] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BusManager] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BusManager] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BusManager] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BusManager] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BusManager] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BusManager] SET  MULTI_USER 
GO
ALTER DATABASE [BusManager] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BusManager] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BusManager] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BusManager] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [BusManager]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Admin](
	[admin_Id] [int] IDENTITY(1,1) NOT NULL,
	[admin_Password] [varchar](50) NOT NULL,
	[admin_Name] [nvarchar](30) NOT NULL,
	[admin_Address] [nvarchar](50) NOT NULL,
	[admin_Phone] [bigint] NOT NULL,
	[admin_Email] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[admin_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Announcement]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Announcement](
	[announcement_Id] [int] IDENTITY(1,1) NOT NULL,
	[mContent] [text] NOT NULL,
	[date] [date] NOT NULL,
	[admin_Id] [int] NOT NULL,
 CONSTRAINT [PK_Announcement] PRIMARY KEY CLUSTERED 
(
	[announcement_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Bus]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Bus](
	[bus_Id] [int] IDENTITY(1,1) NOT NULL,
	[bus_Number] [int] NOT NULL,
	[bus_SignNumber] [char](11) NOT NULL,
 CONSTRAINT [PK_Bus] PRIMARY KEY CLUSTERED 
(
	[bus_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BusSchedule]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BusSchedule](
	[bus_Id] [int] NOT NULL,
	[route_Id] [int] NOT NULL,
	[time] [time](7) NOT NULL,
 CONSTRAINT [PK_BusSchedule] PRIMARY KEY CLUSTERED 
(
	[bus_Id] ASC,
	[route_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Department]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[department_Id] [int] IDENTITY(1,1) NOT NULL,
	[department] [nvarchar](50) NOT NULL,
	[basic_salary] [money] NOT NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[department_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Employees]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employees](
	[employee_Id] [int] IDENTITY(1,1) NOT NULL,
	[employer_Password] [varchar](20) NOT NULL,
	[employee_Name] [nvarchar](30) NOT NULL,
	[employee_Birthday] [date] NOT NULL,
	[employee_Phone] [bigint] NOT NULL,
	[employee_Email] [varchar](50) NOT NULL,
	[employee_Address] [nvarchar](100) NOT NULL,
	[department_Id] [int] NOT NULL,
	[admin_Id] [int] NOT NULL,
 CONSTRAINT [PK_Employees] PRIMARY KEY CLUSTERED 
(
	[employee_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EmployeeSchedule]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeSchedule](
	[employee_Id] [int] NOT NULL,
	[bus_Id] [int] NOT NULL,
	[date] [date] NOT NULL,
 CONSTRAINT [PK_EmployeeSchedule] PRIMARY KEY CLUSTERED 
(
	[employee_Id] ASC,
	[bus_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Route]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Route](
	[route_Id] [int] IDENTITY(1,1) NOT NULL,
	[route] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_Route] PRIMARY KEY CLUSTERED 
(
	[route_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Subsidy]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subsidy](
	[subsidy_Id] [int] IDENTITY(1,1) NOT NULL,
	[description] [nvarchar](50) NOT NULL,
	[subsidy] [money] NOT NULL,
	[department_Id] [int] NOT NULL,
 CONSTRAINT [PK_Subsidy] PRIMARY KEY CLUSTERED 
(
	[subsidy_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Ticket]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ticket](
	[ticket_Id] [int] NOT NULL,
	[ticket_KindOf] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_Ticket] PRIMARY KEY CLUSTERED 
(
	[ticket_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TicketInserted]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TicketInserted](
	[date] [date] NOT NULL,
	[ticket_Id] [int] NOT NULL,
	[ticket] [bigint] NOT NULL,
	[admin_Id] [int] NOT NULL,
	[bus_Id] [int] NOT NULL,
 CONSTRAINT [PK_TicketInserted] PRIMARY KEY CLUSTERED 
(
	[date] ASC,
	[ticket_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  View [dbo].[EmployerSchedule_View]    Script Date: 10/21/2017 6:58:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[EmployerSchedule_View]
AS
SELECT dbo.Employees.employee_Id, dbo.Employees.employee_Name, dbo.Bus.bus_Number, dbo.EmployeeSchedule.date
FROM     dbo.Employees INNER JOIN
                  dbo.EmployeeSchedule ON dbo.Employees.employee_Id = dbo.EmployeeSchedule.employee_Id INNER JOIN
                  dbo.Bus ON dbo.EmployeeSchedule.bus_Id = dbo.Bus.bus_Id

GO
SET IDENTITY_INSERT [dbo].[Admin] ON 

INSERT [dbo].[Admin] ([admin_Id], [admin_Password], [admin_Name], [admin_Address], [admin_Phone], [admin_Email]) VALUES (1, N'123456', N'Lân', N'address', 113, N'bruce@gmai.com')
INSERT [dbo].[Admin] ([admin_Id], [admin_Password], [admin_Name], [admin_Address], [admin_Phone], [admin_Email]) VALUES (2, N'23123', N'dsa', N'q', 123, N'sa')
INSERT [dbo].[Admin] ([admin_Id], [admin_Password], [admin_Name], [admin_Address], [admin_Phone], [admin_Email]) VALUES (3, N'111111', N'AAA', N'DDD', 12314, N'sa')
SET IDENTITY_INSERT [dbo].[Admin] OFF
SET IDENTITY_INSERT [dbo].[Bus] ON 

INSERT [dbo].[Bus] ([bus_Id], [bus_Number], [bus_SignNumber]) VALUES (1, 14, N'123456     ')
INSERT [dbo].[Bus] ([bus_Id], [bus_Number], [bus_SignNumber]) VALUES (2, 13, N'123457     ')
INSERT [dbo].[Bus] ([bus_Id], [bus_Number], [bus_SignNumber]) VALUES (3, 54, N'234567     ')
SET IDENTITY_INSERT [dbo].[Bus] OFF
INSERT [dbo].[BusSchedule] ([bus_Id], [route_Id], [time]) VALUES (1, 2, CAST(0x07007870335C0000 AS Time))
INSERT [dbo].[BusSchedule] ([bus_Id], [route_Id], [time]) VALUES (2, 1, CAST(0x070010ACD1530000 AS Time))
INSERT [dbo].[BusSchedule] ([bus_Id], [route_Id], [time]) VALUES (2, 3, CAST(0x070058A5C8C00000 AS Time))
SET IDENTITY_INSERT [dbo].[Department] ON 

INSERT [dbo].[Department] ([department_Id], [department], [basic_salary]) VALUES (1, N'Lái xe', 300000.0000)
INSERT [dbo].[Department] ([department_Id], [department], [basic_salary]) VALUES (2, N'Thu vé', 100000.0000)
SET IDENTITY_INSERT [dbo].[Department] OFF
SET IDENTITY_INSERT [dbo].[Employees] ON 

INSERT [dbo].[Employees] ([employee_Id], [employer_Password], [employee_Name], [employee_Birthday], [employee_Phone], [employee_Email], [employee_Address], [department_Id], [admin_Id]) VALUES (1, N'123456', N'Alistar', CAST(0x833D0B00 AS Date), 113, N'a@gmail.com', N'DDD', 1, 1)
INSERT [dbo].[Employees] ([employee_Id], [employer_Password], [employee_Name], [employee_Birthday], [employee_Phone], [employee_Email], [employee_Address], [department_Id], [admin_Id]) VALUES (2, N'123456', N'Jhin', CAST(0x493C0B00 AS Date), 114, N'j@gmailc.om', N'DDD', 2, 3)
SET IDENTITY_INSERT [dbo].[Employees] OFF
INSERT [dbo].[EmployeeSchedule] ([employee_Id], [bus_Id], [date]) VALUES (1, 2, CAST(0xA23D0B00 AS Date))
INSERT [dbo].[EmployeeSchedule] ([employee_Id], [bus_Id], [date]) VALUES (2, 1, CAST(0x493C0B00 AS Date))
SET IDENTITY_INSERT [dbo].[Route] ON 

INSERT [dbo].[Route] ([route_Id], [route]) VALUES (1, N'A-B-C-D')
INSERT [dbo].[Route] ([route_Id], [route]) VALUES (2, N'C-D-V-E')
INSERT [dbo].[Route] ([route_Id], [route]) VALUES (3, N'A-G-R-E')
SET IDENTITY_INSERT [dbo].[Route] OFF
SET IDENTITY_INSERT [dbo].[Subsidy] ON 

INSERT [dbo].[Subsidy] ([subsidy_Id], [description], [subsidy], [department_Id]) VALUES (2, N'Tiền cơm tháng', 500000.0000, 1)
INSERT [dbo].[Subsidy] ([subsidy_Id], [description], [subsidy], [department_Id]) VALUES (3, N'Tiền cơm tháng', 500000.0000, 2)
INSERT [dbo].[Subsidy] ([subsidy_Id], [description], [subsidy], [department_Id]) VALUES (4, N'Trợ cấp riêng', 200000.0000, 1)
INSERT [dbo].[Subsidy] ([subsidy_Id], [description], [subsidy], [department_Id]) VALUES (5, N'Trợ cấp riêng', 100000.0000, 2)
SET IDENTITY_INSERT [dbo].[Subsidy] OFF
INSERT [dbo].[Ticket] ([ticket_Id], [ticket_KindOf]) VALUES (1, N'Sinh Viên')
INSERT [dbo].[Ticket] ([ticket_Id], [ticket_KindOf]) VALUES (2, N'Thường')
INSERT [dbo].[TicketInserted] ([date], [ticket_Id], [ticket], [admin_Id], [bus_Id]) VALUES (CAST(0x833D0B00 AS Date), 1, 300, 1, 3)
INSERT [dbo].[TicketInserted] ([date], [ticket_Id], [ticket], [admin_Id], [bus_Id]) VALUES (CAST(0x833D0B00 AS Date), 2, 200, 1, 3)
ALTER TABLE [dbo].[Announcement]  WITH CHECK ADD  CONSTRAINT [FK_Announcement_Admin] FOREIGN KEY([admin_Id])
REFERENCES [dbo].[Admin] ([admin_Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Announcement] CHECK CONSTRAINT [FK_Announcement_Admin]
GO
ALTER TABLE [dbo].[BusSchedule]  WITH CHECK ADD  CONSTRAINT [FK_BusSchedule_Bus] FOREIGN KEY([bus_Id])
REFERENCES [dbo].[Bus] ([bus_Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BusSchedule] CHECK CONSTRAINT [FK_BusSchedule_Bus]
GO
ALTER TABLE [dbo].[BusSchedule]  WITH CHECK ADD  CONSTRAINT [FK_BusSchedule_Route] FOREIGN KEY([route_Id])
REFERENCES [dbo].[Route] ([route_Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BusSchedule] CHECK CONSTRAINT [FK_BusSchedule_Route]
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD  CONSTRAINT [FK_Employees_Admin] FOREIGN KEY([admin_Id])
REFERENCES [dbo].[Admin] ([admin_Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Employees] CHECK CONSTRAINT [FK_Employees_Admin]
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD  CONSTRAINT [FK_Employees_Department] FOREIGN KEY([department_Id])
REFERENCES [dbo].[Department] ([department_Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Employees] CHECK CONSTRAINT [FK_Employees_Department]
GO
ALTER TABLE [dbo].[EmployeeSchedule]  WITH CHECK ADD  CONSTRAINT [FK_EmployeeSchedule_Bus] FOREIGN KEY([bus_Id])
REFERENCES [dbo].[Bus] ([bus_Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[EmployeeSchedule] CHECK CONSTRAINT [FK_EmployeeSchedule_Bus]
GO
ALTER TABLE [dbo].[EmployeeSchedule]  WITH CHECK ADD  CONSTRAINT [FK_EmployeeSchedule_Employees] FOREIGN KEY([employee_Id])
REFERENCES [dbo].[Employees] ([employee_Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[EmployeeSchedule] CHECK CONSTRAINT [FK_EmployeeSchedule_Employees]
GO
ALTER TABLE [dbo].[Subsidy]  WITH CHECK ADD  CONSTRAINT [FK_Subsidy_Department] FOREIGN KEY([department_Id])
REFERENCES [dbo].[Department] ([department_Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Subsidy] CHECK CONSTRAINT [FK_Subsidy_Department]
GO
ALTER TABLE [dbo].[TicketInserted]  WITH CHECK ADD  CONSTRAINT [FK_TicketInserted_Admin] FOREIGN KEY([admin_Id])
REFERENCES [dbo].[Admin] ([admin_Id])
GO
ALTER TABLE [dbo].[TicketInserted] CHECK CONSTRAINT [FK_TicketInserted_Admin]
GO
ALTER TABLE [dbo].[TicketInserted]  WITH CHECK ADD  CONSTRAINT [FK_TicketInserted_Bus] FOREIGN KEY([bus_Id])
REFERENCES [dbo].[Bus] ([bus_Id])
GO
ALTER TABLE [dbo].[TicketInserted] CHECK CONSTRAINT [FK_TicketInserted_Bus]
GO
ALTER TABLE [dbo].[TicketInserted]  WITH CHECK ADD  CONSTRAINT [FK_TicketInserted_Ticket] FOREIGN KEY([ticket_Id])
REFERENCES [dbo].[Ticket] ([ticket_Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TicketInserted] CHECK CONSTRAINT [FK_TicketInserted_Ticket]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Employees"
            Begin Extent = 
               Top = 7
               Left = 48
               Bottom = 170
               Right = 274
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "EmployeeSchedule"
            Begin Extent = 
               Top = 7
               Left = 322
               Bottom = 148
               Right = 516
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Bus"
            Begin Extent = 
               Top = 7
               Left = 564
               Bottom = 170
               Right = 771
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1176
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1356
         SortOrder = 1416
         GroupBy = 1350
         Filter = 1356
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'EmployerSchedule_View'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'EmployerSchedule_View'
GO
USE [master]
GO
ALTER DATABASE [BusManager] SET  READ_WRITE 
GO
