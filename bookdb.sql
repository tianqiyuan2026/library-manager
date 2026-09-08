-- 图书管理系统 · 建库建表脚本
-- 用法：mysql -u root -p < bookdb.sql
CREATE DATABASE IF NOT EXISTS bookdb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE bookdb;

CREATE TABLE IF NOT EXISTS books (
    uid  INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
