-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 30, 2016 at 03:03 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `qlquanan`
--
CREATE DATABASE IF NOT EXISTS `qlquanan` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `qlquanan`;

-- --------------------------------------------------------

--
-- Table structure for table `base_category`
--

CREATE TABLE IF NOT EXISTS `base_category` (
  `CategoryID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Mã ngành hàng',
  `CategoryName` varchar(200) NOT NULL COMMENT 'Tên ngành hàng',
  `ParentCategoryID` bigint(20) NOT NULL DEFAULT '0' COMMENT 'Mã ngành hàng cha',
  `Level` int(11) NOT NULL DEFAULT '0' COMMENT 'Cấp của ngành hàng (Ngành hàng cao nhất có cấp 0, cấp con = cấp cha + 1)',
  `Description` varchar(2000) DEFAULT NULL COMMENT 'Mô tả',
  `IsActived` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Đã kích hoạt (Sẵn dùng)',
  `CreatedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày tạo',
  `CreatedUser` int(11) NOT NULL COMMENT 'Người tạo',
  `UpdatedDate` datetime(6) DEFAULT NULL COMMENT 'Ngày cập nhật cuối',
  `UpdatedUser` int(11) DEFAULT NULL COMMENT 'Người cập nhật cuối',
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Đã xóa',
  `DeletedDate` datetime(6) DEFAULT NULL COMMENT 'Ngày xóa',
  `DeletedUser` int(11) DEFAULT NULL COMMENT 'Người xóa',
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `base_inventory`
--

CREATE TABLE IF NOT EXISTS `base_inventory` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ProductId` bigint(20) NOT NULL,
  `QtyAvailable` decimal(20,4) NOT NULL DEFAULT '0.0000',
  `COGS` decimal(19,4) NOT NULL DEFAULT '0.0000',
  `UpdatedDate` datetime(6) DEFAULT NULL,
  `UpdatedUser` int(11) NOT NULL DEFAULT '0',
  `IsDeleted` tinyint(1) DEFAULT '0',
  `DeletedUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_BASE_Inventory_BASE_Product` (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `base_product`
--

CREATE TABLE IF NOT EXISTS `base_product` (
  `ProductId` bigint(20) NOT NULL AUTO_INCREMENT,
  `BarCode` char(32) NOT NULL,
  `ProductName` varchar(500) NOT NULL,
  `CategoryID` bigint(20) DEFAULT NULL,
  `IsActived` tinyint(1) NOT NULL DEFAULT '1',
  `RetailPrice` decimal(19,4) NOT NULL,
  `QtyAvailable` decimal(20,4) NOT NULL DEFAULT '0.0000',
  `ImageId` bigint(20) DEFAULT NULL,
  `CreatedDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `CreatedUser` int(11) DEFAULT NULL,
  `UpdatedDate` datetime(6) DEFAULT NULL,
  `UpdatedUser` int(11) DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `base_product_images`
--

CREATE TABLE IF NOT EXISTS `base_product_images` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ProductId` bigint(20) NOT NULL,
  `ImageId` bigint(20) DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT '0',
  `DeletedUser` int(11) DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `cus_customers`
--

CREATE TABLE IF NOT EXISTS `cus_customers` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Code` varchar(50) NOT NULL,
  `CustomerName` varchar(200) NOT NULL,
  `Phone` char(20) DEFAULT NULL,
  `Address` varchar(511) DEFAULT NULL,
  `Birthday` datetime(6) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CreatedUser` int(11) DEFAULT NULL,
  `UpdatedDate` datetime(6) DEFAULT NULL,
  `UpdatedUser` int(11) DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `inv_stockcard`
--

CREATE TABLE IF NOT EXISTS `inv_stockcard` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ProductItemID` bigint(20) NOT NULL,
  `Action` varchar(255) NOT NULL,
  `ReferenceCode` varchar(20) NOT NULL,
  `QtyTransacted` decimal(20,4) NOT NULL,
  `QtyAvailable` decimal(20,4) NOT NULL,
  `COGS` decimal(19,4) NOT NULL,
  `Comment` varchar(500) DEFAULT NULL,
  `CreatedUser` int(11) NOT NULL,
  `CreatedDate` datetime(6) DEFAULT NULL,
  `UpdatedDate` datetime(6) DEFAULT NULL,
  `UpdatedUser` int(11) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  `DeletedNote` varchar(200) DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  `CompanyID` int(11) NOT NULL DEFAULT '0',
  `Price` decimal(19,4) NOT NULL,
  `UnitPrice` decimal(19,4) NOT NULL DEFAULT '0.0000',
  `PriceWithFee` decimal(19,4) NOT NULL DEFAULT '0.0000',
  PRIMARY KEY (`ID`),
  KEY `FK_INV_StockCard_BASE_Product_Item` (`ProductItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `sch_user_workshift`
--

CREATE TABLE IF NOT EXISTS `sch_user_workshift` (
  `Id` bigint(20) NOT NULL,
  `UserId` bigint(20) NOT NULL,
  `WorkShiftId` bigint(20) NOT NULL,
  `WorkDate` datetime(6) NOT NULL,
  `IsPresence` smallint(6) NOT NULL,
  `PresentTime` datetime(6) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  `IsConfirm` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `FK_SCH_User_WorkShift_SCH_WorkShift` (`WorkShiftId`),
  KEY `FK_SCH_User_WorkShift_SYSTEM_User` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sch_workshift`
--

CREATE TABLE IF NOT EXISTS `sch_workshift` (
  `Id` bigint(20) NOT NULL,
  `ScheduleName` varchar(511) DEFAULT NULL,
  `StartDate` datetime(6) NOT NULL,
  `ToDate` datetime(6) NOT NULL,
  `IsActived` tinyint(1) NOT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  `CreatedDate` datetime(6) NOT NULL,
  `CreatedUser` int(11) NOT NULL,
  `UpdatedDate` datetime(6) DEFAULT NULL,
  `UpdatedUser` int(11) DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `so_receiptvoucher`
--

CREATE TABLE IF NOT EXISTS `so_receiptvoucher` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Code` varchar(20) NOT NULL,
  `TypeID` int(11) NOT NULL,
  `ReceivedDate` datetime(6) NOT NULL,
  `Status` int(11) NOT NULL,
  `Amount` decimal(19,4) NOT NULL,
  `Description` varchar(2000) DEFAULT NULL,
  `CustomerID` bigint(20) DEFAULT NULL,
  `CreatedDate` datetime(6) NOT NULL,
  `CreatedUser` int(11) NOT NULL,
  `UpdatedDate` datetime(6) DEFAULT NULL,
  `UpdatedUser` int(11) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `so_saleorder`
--

CREATE TABLE IF NOT EXISTS `so_saleorder` (
  `SaleOrderId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Mã phiếu xuất',
  `SaleOrderCode` varchar(20) NOT NULL,
  `Status` int(11) NOT NULL COMMENT 'Trạng thái',
  `CustomerId` bigint(20) NOT NULL COMMENT 'Mã khách hàng',
  `TableId` bigint(20) NOT NULL,
  `SaleUser` int(11) DEFAULT NULL,
  `SaleDate` datetime(6) DEFAULT NULL COMMENT 'Ngày xuất',
  `TotalQuantity` decimal(20,4) NOT NULL COMMENT 'Tổng số lượng',
  `SubTotal` decimal(19,4) NOT NULL COMMENT 'Tổng tiền giá',
  `Discount` decimal(19,4) NOT NULL COMMENT 'Giảm giá',
  `Tax` decimal(19,4) DEFAULT NULL COMMENT 'Thuế VAT',
  `Total` decimal(19,4) NOT NULL COMMENT 'Tổng tiền (cộng thuế và trừ giảm giá)',
  `AmountPaid` decimal(19,4) NOT NULL COMMENT 'Tiền đã trả',
  `PaymentBalance` decimal(19,4) NOT NULL COMMENT 'Tiền còn lại',
  `CreatedDate` datetime(6) NOT NULL COMMENT 'Ngày tạo',
  `CreatedUser` int(11) NOT NULL COMMENT 'Người tạo',
  `UpdatedDate` datetime(6) DEFAULT NULL COMMENT 'Ngày cập nhật cuối',
  `UpdatedUser` int(11) DEFAULT NULL COMMENT 'Người cập nhật cuối',
  `IsDeleted` tinyint(1) NOT NULL COMMENT 'Đã xóa',
  `DeletedNote` varchar(200) DEFAULT NULL COMMENT 'Ghi chú xóa',
  `DeletedDate` datetime(6) DEFAULT NULL COMMENT 'Ngày xóa',
  `DeletedUser` int(11) DEFAULT NULL COMMENT 'Người xóa',
  `Comment` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`SaleOrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `so_saleorder_detail`
--

CREATE TABLE IF NOT EXISTS `so_saleorder_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SaleOrderId` bigint(20) NOT NULL,
  `SubTotal` decimal(19,4) NOT NULL,
  `Discount` decimal(19,4) NOT NULL,
  `DiscountIsPercent` tinyint(1) NOT NULL,
  `ProductId` bigint(20) NOT NULL,
  `Quantity` decimal(20,4) NOT NULL,
  `UnitPrice` decimal(19,4) NOT NULL,
  `CreatedDate` datetime(6) NOT NULL,
  `CreatedUser` int(11) NOT NULL,
  `UpdatedDate` datetime(6) DEFAULT NULL,
  `UpdatedUser` int(11) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `DeletedNote` varchar(511) DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SO_SaleOrder_Detail_BASE_Product` (`ProductId`),
  KEY `FK_SO_SaleOrder_Detail_SO_SalesOrder` (`SaleOrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `so_saleorder_receiptvoucher`
--

CREATE TABLE IF NOT EXISTS `so_saleorder_receiptvoucher` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SaleOrderID` bigint(20) NOT NULL,
  `ReceiptVoucherID` bigint(20) NOT NULL,
  `SaleOrderCode` varchar(20) NOT NULL,
  `ReceiptVoucherCode` varchar(20) NOT NULL,
  `CreatedDate` datetime(6) NOT NULL,
  `CreatedUser` int(11) NOT NULL,
  `UpdatedDate` datetime(6) DEFAULT NULL,
  `UpdatedUser` int(11) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  `DeletedNote` varchar(200) DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  `CompanyID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SO_SaleOrder_ReceiptPayment_SO_SalesOrder` (`SaleOrderID`),
  KEY `FK_SO_SaleOrder_ReceiptVoucher_ACC_ReceiptVoucher` (`ReceiptVoucherID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `system_group`
--

CREATE TABLE IF NOT EXISTS `system_group` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `GroupName` varchar(511) NOT NULL,
  `Description` longtext,
  `IsDeleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `system_group`
--

INSERT INTO `system_group` (`Id`, `GroupName`, `Description`, `IsDeleted`) VALUES
(1, 'SystemAdmin', 'Nhóm admin', 0),
(2, 'System Manager ', 'Nhóm qu?n lý', 0);

-- --------------------------------------------------------

--
-- Table structure for table `system_group_rolelist`
--

CREATE TABLE IF NOT EXISTS `system_group_rolelist` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `GroupId` bigint(20) NOT NULL,
  `RoleListId` bigint(20) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `FK_SYSTEM_Group_RoleList_SYSTEM_Group` (`GroupId`),
  KEY `FK_SYSTEM_Group_RoleList_SYSTEM_RoleList` (`RoleListId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `system_printtemplate`
--

CREATE TABLE IF NOT EXISTS `system_printtemplate` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(20) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Type` int(11) NOT NULL,
  `Content` longtext NOT NULL,
  `IsSelected` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` datetime(6) NOT NULL,
  `CreatedUser` int(11) NOT NULL,
  `UpdatedDate` datetime(6) DEFAULT NULL,
  `UpdatedUser` int(11) DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  `CompanyId` int(11) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `system_rolelist`
--

CREATE TABLE IF NOT EXISTS `system_rolelist` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Key` varchar(511) NOT NULL,
  `Value` longtext NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `system_salary`
--

CREATE TABLE IF NOT EXISTS `system_salary` (
  `Id` bigint(20) NOT NULL,
  `WorkShiftId` bigint(20) NOT NULL,
  `BasicSalary` bigint(20) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_SYSTEM_Salary_SCH_WorkShift` (`WorkShiftId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `system_user`
--

CREATE TABLE IF NOT EXISTS `system_user` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `UserId` bigint(64) NOT NULL,
  `Fullname` varchar(200) DEFAULT NULL,
  `Birthday` datetime(6) DEFAULT NULL,
  `Address` varchar(500) DEFAULT NULL,
  `Phone` char(20) DEFAULT NULL,
  `IndentityNumber` char(20) DEFAULT NULL,
  `CreatedUser` int(11) NOT NULL,
  `CreateDate` datetime(6) NOT NULL,
  `UpdateUser` int(11) DEFAULT NULL,
  `UpdateDate` datetime(6) DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `IsDeleted` int(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `FK_SYSTEM_User_SYSTEM_User_Account` (`UserId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `system_user`
--

INSERT INTO `system_user` (`Id`, `UserId`, `Fullname`, `Birthday`, `Address`, `Phone`, `IndentityNumber`, `CreatedUser`, `CreateDate`, `UpdateUser`, `UpdateDate`, `DeletedUser`, `DeletedDate`, `IsDeleted`) VALUES
(1, 0, 'Administrator', '0000-00-00 00:00:00.000000', NULL, NULL, NULL, 0, '2016-05-22 14:48:39.000000', NULL, NULL, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `system_user_account`
--

CREATE TABLE IF NOT EXISTS `system_user_account` (
  `Id` bigint(64) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `GroupId` bigint(20) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `IsActived` tinyint(1) NOT NULL,
  `CreatedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CreatedUser` int(11) NOT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  `UpdatedUser` int(11) DEFAULT NULL,
  `DeletedDate` datetime DEFAULT NULL,
  `DeletedUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id` (`Id`),
  KEY `FK_SYSTEM_User_SYSTEM_Group` (`GroupId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `system_user_account`
--

INSERT INTO `system_user_account` (`Id`, `Username`, `Password`, `GroupId`, `IsDeleted`, `IsActived`, `CreatedDate`, `CreatedUser`, `UpdatedDate`, `UpdatedUser`, `DeletedDate`, `DeletedUser`) VALUES
(0, 'admin', '827ccb0eea8a706c4c34a16891f84e7b', 1, 0, 1, '2016-05-22 14:48:39', 0, '2016-05-22 14:49:51', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tables`
--

CREATE TABLE IF NOT EXISTS `tbl_tables` (
  `Id` bigint(20) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Description` longtext,
  `Status` smallint(6) NOT NULL,
  `MaxCustomer` smallint(6) NOT NULL DEFAULT '0',
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_tool`
--

CREATE TABLE IF NOT EXISTS `tbl_user_tool` (
  `Id` bigint(20) NOT NULL,
  `UserId` bigint(20) NOT NULL,
  `ToolName` varchar(1000) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_TBL_User_Tool_SYSTEM_User` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `base_inventory`
--
ALTER TABLE `base_inventory`
  ADD CONSTRAINT `FK_BASE_Inventory_BASE_Product` FOREIGN KEY (`ProductId`) REFERENCES `base_product` (`ProductId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `inv_stockcard`
--
ALTER TABLE `inv_stockcard`
  ADD CONSTRAINT `FK_INV_StockCard_BASE_Product_Item` FOREIGN KEY (`ProductItemID`) REFERENCES `base_product` (`ProductId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sch_user_workshift`
--
ALTER TABLE `sch_user_workshift`
  ADD CONSTRAINT `FK_SCH_User_WorkShift_SCH_WorkShift` FOREIGN KEY (`WorkShiftId`) REFERENCES `sch_workshift` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_SCH_User_WorkShift_SYSTEM_User` FOREIGN KEY (`UserId`) REFERENCES `system_user` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `so_saleorder_detail`
--
ALTER TABLE `so_saleorder_detail`
  ADD CONSTRAINT `FK_SO_SaleOrder_Detail_BASE_Product` FOREIGN KEY (`ProductId`) REFERENCES `base_product` (`ProductId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_SO_SaleOrder_Detail_SO_SalesOrder` FOREIGN KEY (`SaleOrderId`) REFERENCES `so_saleorder` (`SaleOrderId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `so_saleorder_receiptvoucher`
--
ALTER TABLE `so_saleorder_receiptvoucher`
  ADD CONSTRAINT `FK_SO_SaleOrder_ReceiptPayment_SO_SalesOrder` FOREIGN KEY (`SaleOrderID`) REFERENCES `so_saleorder` (`SaleOrderId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_SO_SaleOrder_ReceiptVoucher_ACC_ReceiptVoucher` FOREIGN KEY (`ReceiptVoucherID`) REFERENCES `so_receiptvoucher` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `system_group_rolelist`
--
ALTER TABLE `system_group_rolelist`
  ADD CONSTRAINT `FK_SYSTEM_Group_RoleList_SYSTEM_Group` FOREIGN KEY (`GroupId`) REFERENCES `system_group` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_SYSTEM_Group_RoleList_SYSTEM_RoleList` FOREIGN KEY (`RoleListId`) REFERENCES `system_rolelist` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `system_salary`
--
ALTER TABLE `system_salary`
  ADD CONSTRAINT `FK_SYSTEM_Salary_SCH_WorkShift` FOREIGN KEY (`WorkShiftId`) REFERENCES `sch_workshift` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `system_user`
--
ALTER TABLE `system_user`
  ADD CONSTRAINT `FK_SYSTEM_User_SYSTEM_User_Account` FOREIGN KEY (`UserId`) REFERENCES `system_user_account` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbl_user_tool`
--
ALTER TABLE `tbl_user_tool`
  ADD CONSTRAINT `FK_TBL_User_Tool_SYSTEM_User` FOREIGN KEY (`UserId`) REFERENCES `system_user` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
