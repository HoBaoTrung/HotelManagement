-- Tạo database
CREATE DATABASE IF NOT EXISTS HotelManagement;
USE HotelManagement;

-- Bảng khách hàng
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100),
    id_card VARCHAR(20),
    address VARCHAR(255),
    nationality VARCHAR(50),
    gender ENUM('Male', 'Female', 'Other'),
    dob DATE
);

-- Bảng loại phòng
CREATE TABLE RoomType (
    room_type_id INT PRIMARY KEY AUTO_INCREMENT,
    type_name VARCHAR(100),
    price DECIMAL(10,2),
    description TEXT,
    capacity INT
);

-- Bảng phòng
CREATE TABLE Room (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_number VARCHAR(10) UNIQUE,
    room_type_id INT,
    status ENUM('Available', 'Occupied', 'Maintenance') DEFAULT 'Available',
    FOREIGN KEY (room_type_id) REFERENCES RoomType(room_type_id)
);

-- Bảng đặt phòng
CREATE TABLE Booking (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    booking_date DATETIME,
    check_in_date DATE,
    check_out_date DATE,
    status ENUM('Booked', 'CheckedIn', 'Cancelled', 'CheckedOut') DEFAULT 'Booked',
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

-- Bảng chi tiết đặt phòng
CREATE TABLE BookingDetail (
    booking_detail_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_id INT,
    room_id INT,
    FOREIGN KEY (booking_id) REFERENCES Booking(booking_id),
    FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- Bảng dịch vụ
CREATE TABLE Service (
    service_id INT PRIMARY KEY AUTO_INCREMENT,
    service_name VARCHAR(100),
    price DECIMAL(10,2),
    unit VARCHAR(50)
);

-- Bảng sử dụng dịch vụ theo từng phòng
CREATE TABLE ServiceUsage (
    usage_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_detail_id INT,
    service_id INT,
    quantity INT,
    usage_time DATETIME,
    note VARCHAR(255),
    FOREIGN KEY (booking_detail_id) REFERENCES BookingDetail(booking_detail_id),
    FOREIGN KEY (service_id) REFERENCES Service(service_id)
);

-- Bảng hóa đơn
CREATE TABLE Invoice (
    invoice_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_id INT UNIQUE,
    invoice_date DATETIME,
    room_charge DECIMAL(10,2),
    service_charge DECIMAL(10,2),
    total_amount DECIMAL(12,2),
    payment_status ENUM('Unpaid', 'Paid') DEFAULT 'Unpaid',
    payment_method ENUM('Cash', 'MoMo', 'VNPay', 'BankTransfer'),
    FOREIGN KEY (booking_id) REFERENCES Booking(booking_id)
);

-- Bảng nhân viên
CREATE TABLE Staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100),
    username VARCHAR(50) UNIQUE,
    password_hash VARCHAR(255),
    role ENUM('Admin', 'Receptionist'),
    email VARCHAR(100)
);

-- 🌟 Đánh giá / phản hồi khách hàng
CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_detail_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    feedback_date DATETIME,
    FOREIGN KEY (booking_detail_id) REFERENCES BookingDetail(booking_detail_id)
);

-- 🌟 Ưu đãi / khuyến mãi
CREATE TABLE Promotion (
    promotion_id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE,
    description TEXT,
    discount_percent DECIMAL(5,2),
    valid_from DATE,
    valid_to DATE,
    active BOOLEAN DEFAULT TRUE
);

CREATE TABLE BookingPromotion (
    booking_id INT,
    promotion_id INT,
    PRIMARY KEY (booking_id, promotion_id),
    FOREIGN KEY (booking_id) REFERENCES Booking(booking_id),
    FOREIGN KEY (promotion_id) REFERENCES Promotion(promotion_id)
);


-- 🌟 Nhật ký hoạt động của nhân viên
CREATE TABLE ActionLog (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    staff_id INT,
    action_type VARCHAR(50),
    description TEXT,
    action_time DATETIME,
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id)
);


