USE [master]
GO
/****** Object:  Database [Magza_DB]    Script Date: 11.05.2022 16:24:38 ******/
CREATE DATABASE [Magza_DB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Magza_DB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Magza_DB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Magza_DB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Magza_DB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Magza_DB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Magza_DB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Magza_DB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Magza_DB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Magza_DB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Magza_DB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Magza_DB] SET ARITHABORT OFF 
GO
ALTER DATABASE [Magza_DB] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Magza_DB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Magza_DB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Magza_DB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Magza_DB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Magza_DB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Magza_DB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Magza_DB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Magza_DB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Magza_DB] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Magza_DB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Magza_DB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Magza_DB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Magza_DB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Magza_DB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Magza_DB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Magza_DB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Magza_DB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Magza_DB] SET  MULTI_USER 
GO
ALTER DATABASE [Magza_DB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Magza_DB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Magza_DB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Magza_DB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Magza_DB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Magza_DB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Magza_DB] SET QUERY_STORE = OFF
GO
USE [Magza_DB]
GO
/****** Object:  User [magza]    Script Date: 11.05.2022 16:24:38 ******/
CREATE USER [magza] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
USE [Magza_DB]
GO
/****** Object:  Sequence [dbo].[hibernate_sequence]    Script Date: 11.05.2022 16:24:38 ******/
CREATE SEQUENCE [dbo].[hibernate_sequence] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [dbo].[Bize_Ulasin_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bize_Ulasin_Table](
	[BUT_Id] [int] IDENTITY(1,1) NOT NULL,
	[BUT_Isim] [varchar](40) NOT NULL,
	[BUT_SoyIsım] [varchar](40) NOT NULL,
	[BUT_Mail] [varchar](40) NOT NULL,
	[BUT_Konu] [varchar](50) NOT NULL,
	[BUT_Icerik] [varchar](400) NOT NULL,
	[BUT_Tarih] [date] NOT NULL,
	[BUT_Durum] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[BUT_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Iade_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Iade_Table](
	[Iade_Urun_Barkod] [varchar](50) NOT NULL,
	[Iade_Tarih] [date] NOT NULL,
	[Iade_Fis_No] [varchar](255) NOT NULL,
	[Iade_Musteri_Id] [int] NOT NULL,
	[Iade_Id] [int] IDENTITY(1,1) NOT NULL,
	[Iade_Kasa_Id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Iade_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Iletisim_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Iletisim_Table](
	[Iletisim_Id] [int] IDENTITY(1,1) NOT NULL,
	[Iletisim_Persone_Id] [int] NOT NULL,
	[Iletisim_Onem] [int] NOT NULL,
	[Iletisim_Gorsel] [image] NULL,
	[Iletisim_Durum] [varchar](100) NOT NULL,
	[Iletisim_Tur] [varchar](50) NOT NULL,
	[Iletisim_Icerik] [varchar](500) NOT NULL,
	[Iletisim_Konu] [varchar](50) NOT NULL,
	[Iletisim_Tarih] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Iletisim_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Kampanya_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kampanya_Table](
	[Kampanya_Urun_Barkod] [varchar](50) NOT NULL,
	[Kampanya_Eski_Fiyat] [decimal](15, 2) NOT NULL,
	[Kampanya_Yeni_Fiyat] [decimal](15, 2) NOT NULL,
	[Kampanya_Baslangıc_Tarih] [date] NOT NULL,
	[Kampanya_Bitis_Tarih] [date] NOT NULL,
	[Kampanya_Id] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Kampanya_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Kart_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kart_Table](
	[Kart_Id] [varchar](50) NOT NULL,
	[Kart_CVV] [varchar](3) NOT NULL,
	[Kart_SKT] [date] NOT NULL,
	[Kart_Sifre] [varchar](6) NOT NULL,
	[Kart_Bakiye] [decimal](15, 2) NOT NULL,
	[Kart_Kayit_Tarih] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Kart_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Kasa_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kasa_Table](
	[Kasa_Id] [int] IDENTITY(1,1) NOT NULL,
	[Kasa_Durum] [varchar](50) NOT NULL,
	[Kasa_Personel_Id] [int] NOT NULL,
	[Kasa_Tip] [varchar](50) NOT NULL,
	[Kasa_Acilis_Tarih] [datetime] NULL,
	[Kasa_Kapanis_Tarih] [datetime] NULL,
	[Kasa_Port_Barkod] [varchar](5) NULL,
	[Kasa_Port_KartOkuyucu] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[Kasa_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Musteri_Kart_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Musteri_Kart_Table](
	[MKT_Id] [int] IDENTITY(1,1) NOT NULL,
	[MKT_Musteri_Id] [int] NOT NULL,
	[MKT_Kart_Id] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MKT_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Musteri_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Musteri_Table](
	[Musteri_Id] [int] IDENTITY(1,1) NOT NULL,
	[Musteri_Isim] [varchar](50) NOT NULL,
	[Musteri_SoyIsim] [varchar](50) NOT NULL,
	[Musteri_Cinsiyet] [varchar](1) NOT NULL,
	[Musteri_Telefon] [varchar](13) NOT NULL,
	[Musteri_Adres] [varchar](100) NOT NULL,
	[Musteri_Dogum_Tarih] [date] NOT NULL,
	[Musteri_Kayıt_Tarih] [date] NOT NULL,
	[Musteri_Sifre] [varchar](20) NOT NULL,
	[Musteri_SMS_Onay] [varchar](10) NULL,
	[Musteri_Mail] [varchar](100) NOT NULL,
	[Musteri_Sifre_Degis_Parola] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[Musteri_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Musteri_Mail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Personel_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Personel_Table](
	[Personel_Id] [int] IDENTITY(1,1) NOT NULL,
	[Personel__Isim] [varchar](50) NOT NULL,
	[Personel_SoyIsim] [varchar](50) NOT NULL,
	[Personel_Cinsiyet] [varchar](1) NOT NULL,
	[Personel_Telefon] [varchar](13) NOT NULL,
	[Personel_Adres] [varchar](100) NOT NULL,
	[Personel_Egitim_Duzey] [varchar](50) NOT NULL,
	[Personel_Baslama_Tarih] [date] NOT NULL,
	[Personel_Izın_Hakkı] [int] NOT NULL,
	[Personel_Sifre] [varchar](13) NOT NULL,
	[Personel_Maas] [varchar](13) NOT NULL,
	[Personel_Dogum_Tarih] [date] NOT NULL,
	[Personel_Yetki] [int] NOT NULL,
	[Personel_Mail] [varchar](50) NOT NULL,
	[Personel_Sifre_Degis_Parola] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Personel_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Personel_Mail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Satis_Fis_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Satis_Fis_Table](
	[Satis_Fis_Id] [int] IDENTITY(1,1) NOT NULL,
	[Satis_Musteri_Id] [int] NOT NULL,
	[Satis_Kart_Id] [varchar](50) NOT NULL,
	[Satis_Toplam_Tutar] [varchar](50) NOT NULL,
	[Satis_Tarih] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Satis_Fis_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Satis_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Satis_Table](
	[Satis_Id] [int] IDENTITY(1,1) NOT NULL,
	[Satis_Urun_Barkod] [varchar](50) NOT NULL,
	[Satis_Musteri_Id] [int] NOT NULL,
	[Satis_Durum] [varchar](1) NOT NULL,
	[Satis_Tarih] [date] NOT NULL,
	[Satis_Kasa_Id] [int] NOT NULL,
	[Satis_Fis_Id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Satis_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Siparis_Hazirlat_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Siparis_Hazirlat_Table](
	[SHT_Id] [int] IDENTITY(1,1) NOT NULL,
	[SHT_MusteriId] [int] NOT NULL,
	[SHT_AlimTime] [datetime] NOT NULL,
	[SHT_Durum] [varchar](50) NOT NULL,
	[SHT_Siparis_Tarih] [datetime] NOT NULL,
	[SFT_FisId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SHT_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Urun_Alim_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Urun_Alim_Table](
	[UA_Id] [int] IDENTITY(1,1) NOT NULL,
	[UA_Urun_Barkod] [varchar](50) NOT NULL,
	[UA_Tarih] [date] NOT NULL,
	[UA_Miktar] [varchar](50) NOT NULL,
	[UA_Odeme] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UA_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Urun_Table]    Script Date: 11.05.2022 16:24:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Urun_Table](
	[Urun_Barkod] [varchar](50) NOT NULL,
	[Urun_Marka] [varchar](50) NOT NULL,
	[Urun_Isim] [varchar](50) NOT NULL,
	[Urun_Fiyat] [decimal](15, 2) NOT NULL,
	[Urun_Stok] [varchar](50) NOT NULL,
	[Urun_Durum] [varchar](50) NOT NULL,
	[Urun_Gorsel] [image] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Urun_Barkod] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Iade_Table]  WITH CHECK ADD  CONSTRAINT [FK_Iade_Table_Kasa_Table] FOREIGN KEY([Iade_Kasa_Id])
REFERENCES [dbo].[Kasa_Table] ([Kasa_Id])
GO
ALTER TABLE [dbo].[Iade_Table] CHECK CONSTRAINT [FK_Iade_Table_Kasa_Table]
GO
ALTER TABLE [dbo].[Iade_Table]  WITH CHECK ADD  CONSTRAINT [FK_Iade_Table_Musteri_Table] FOREIGN KEY([Iade_Musteri_Id])
REFERENCES [dbo].[Musteri_Table] ([Musteri_Id])
GO
ALTER TABLE [dbo].[Iade_Table] CHECK CONSTRAINT [FK_Iade_Table_Musteri_Table]
GO
ALTER TABLE [dbo].[Iade_Table]  WITH CHECK ADD  CONSTRAINT [FK_Iade_Table_Urun_Table] FOREIGN KEY([Iade_Urun_Barkod])
REFERENCES [dbo].[Urun_Table] ([Urun_Barkod])
GO
ALTER TABLE [dbo].[Iade_Table] CHECK CONSTRAINT [FK_Iade_Table_Urun_Table]
GO
ALTER TABLE [dbo].[Iletisim_Table]  WITH CHECK ADD  CONSTRAINT [FK_Iletisim_Table_Personel_Table] FOREIGN KEY([Iletisim_Persone_Id])
REFERENCES [dbo].[Personel_Table] ([Personel_Id])
GO
ALTER TABLE [dbo].[Iletisim_Table] CHECK CONSTRAINT [FK_Iletisim_Table_Personel_Table]
GO
ALTER TABLE [dbo].[Kampanya_Table]  WITH CHECK ADD  CONSTRAINT [FK_Kampanya_Table_Urun_Table] FOREIGN KEY([Kampanya_Urun_Barkod])
REFERENCES [dbo].[Urun_Table] ([Urun_Barkod])
GO
ALTER TABLE [dbo].[Kampanya_Table] CHECK CONSTRAINT [FK_Kampanya_Table_Urun_Table]
GO
ALTER TABLE [dbo].[Kasa_Table]  WITH CHECK ADD  CONSTRAINT [FK_Kasa_Table_Personel_Table] FOREIGN KEY([Kasa_Personel_Id])
REFERENCES [dbo].[Personel_Table] ([Personel_Id])
GO
ALTER TABLE [dbo].[Kasa_Table] CHECK CONSTRAINT [FK_Kasa_Table_Personel_Table]
GO
ALTER TABLE [dbo].[Musteri_Kart_Table]  WITH CHECK ADD  CONSTRAINT [FK_Musteri_Kart_Table_Kart_Table] FOREIGN KEY([MKT_Kart_Id])
REFERENCES [dbo].[Kart_Table] ([Kart_Id])
GO
ALTER TABLE [dbo].[Musteri_Kart_Table] CHECK CONSTRAINT [FK_Musteri_Kart_Table_Kart_Table]
GO
ALTER TABLE [dbo].[Musteri_Kart_Table]  WITH CHECK ADD  CONSTRAINT [FK_Musteri_Kart_Table_Musteri_Table] FOREIGN KEY([MKT_Musteri_Id])
REFERENCES [dbo].[Musteri_Table] ([Musteri_Id])
GO
ALTER TABLE [dbo].[Musteri_Kart_Table] CHECK CONSTRAINT [FK_Musteri_Kart_Table_Musteri_Table]
GO
ALTER TABLE [dbo].[Satis_Fis_Table]  WITH CHECK ADD  CONSTRAINT [FK_Satis_Fis_Table_Kart_Table] FOREIGN KEY([Satis_Kart_Id])
REFERENCES [dbo].[Kart_Table] ([Kart_Id])
GO
ALTER TABLE [dbo].[Satis_Fis_Table] CHECK CONSTRAINT [FK_Satis_Fis_Table_Kart_Table]
GO
ALTER TABLE [dbo].[Satis_Fis_Table]  WITH CHECK ADD  CONSTRAINT [FK_Satis_Fis_Table_Musteri_Table] FOREIGN KEY([Satis_Musteri_Id])
REFERENCES [dbo].[Musteri_Table] ([Musteri_Id])
GO
ALTER TABLE [dbo].[Satis_Fis_Table] CHECK CONSTRAINT [FK_Satis_Fis_Table_Musteri_Table]
GO
ALTER TABLE [dbo].[Satis_Table]  WITH CHECK ADD  CONSTRAINT [FK_Satis_Table_Kasa_Table] FOREIGN KEY([Satis_Kasa_Id])
REFERENCES [dbo].[Kasa_Table] ([Kasa_Id])
GO
ALTER TABLE [dbo].[Satis_Table] CHECK CONSTRAINT [FK_Satis_Table_Kasa_Table]
GO
ALTER TABLE [dbo].[Satis_Table]  WITH CHECK ADD  CONSTRAINT [FK_Satis_Table_Musteri_Table] FOREIGN KEY([Satis_Musteri_Id])
REFERENCES [dbo].[Musteri_Table] ([Musteri_Id])
GO
ALTER TABLE [dbo].[Satis_Table] CHECK CONSTRAINT [FK_Satis_Table_Musteri_Table]
GO
ALTER TABLE [dbo].[Satis_Table]  WITH CHECK ADD  CONSTRAINT [FK_Satis_Table_Satis_Fis_Table] FOREIGN KEY([Satis_Fis_Id])
REFERENCES [dbo].[Satis_Fis_Table] ([Satis_Fis_Id])
GO
ALTER TABLE [dbo].[Satis_Table] CHECK CONSTRAINT [FK_Satis_Table_Satis_Fis_Table]
GO
ALTER TABLE [dbo].[Satis_Table]  WITH CHECK ADD  CONSTRAINT [FK_Satis_Table_Urun_Table] FOREIGN KEY([Satis_Urun_Barkod])
REFERENCES [dbo].[Urun_Table] ([Urun_Barkod])
GO
ALTER TABLE [dbo].[Satis_Table] CHECK CONSTRAINT [FK_Satis_Table_Urun_Table]
GO
ALTER TABLE [dbo].[Siparis_Hazirlat_Table]  WITH CHECK ADD  CONSTRAINT [FK_Siparis_Hazirlat_Table_Musteri_Table] FOREIGN KEY([SHT_MusteriId])
REFERENCES [dbo].[Musteri_Table] ([Musteri_Id])
GO
ALTER TABLE [dbo].[Siparis_Hazirlat_Table] CHECK CONSTRAINT [FK_Siparis_Hazirlat_Table_Musteri_Table]
GO
ALTER TABLE [dbo].[Siparis_Hazirlat_Table]  WITH CHECK ADD  CONSTRAINT [FK_Siparis_Hazirlat_Table_Satis_Fis_Table] FOREIGN KEY([SFT_FisId])
REFERENCES [dbo].[Satis_Fis_Table] ([Satis_Fis_Id])
GO
ALTER TABLE [dbo].[Siparis_Hazirlat_Table] CHECK CONSTRAINT [FK_Siparis_Hazirlat_Table_Satis_Fis_Table]
GO
ALTER TABLE [dbo].[Urun_Alim_Table]  WITH CHECK ADD  CONSTRAINT [FK_Urun_Alim_Table_Urun_Table] FOREIGN KEY([UA_Urun_Barkod])
REFERENCES [dbo].[Urun_Table] ([Urun_Barkod])
GO
ALTER TABLE [dbo].[Urun_Alim_Table] CHECK CONSTRAINT [FK_Urun_Alim_Table_Urun_Table]
GO
USE [master]
GO
ALTER DATABASE [Magza_DB] SET  READ_WRITE 
GO
