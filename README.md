# 📚 图书管理系统（Spring Boot 版）

基于 **Spring Boot + MySQL** 的图书增删查管理系统，提供浏览器页面和 REST API 两种使用方式，数据持久化存储在 MySQL，重启不丢失。

## ✨ 功能特性

- 📖 图书列表展示（进入页面自动加载）
- 🔍 按编号 / 按书名查询
- ➕ 新增图书
- 🗑️ 按编号删除
- 🌐 前端静态页面 + REST API，前后端通过 `fetch` 通信
- 🧱 经典三层架构：Controller → Service → Repository

## 🛠️ 技术栈

| 分类 | 技术 |
|---|---|
| 后端框架 | Spring Boot 4.1.1 |
| 语言 | Java 21 |
| 数据访问 | Spring JDBC（JdbcTemplate，SQL 参数化防注入） |
| 数据库 | MySQL |
| 构建工具 | Maven（含 Maven Wrapper，无需本地安装） |
| 前端 | 原生 HTML / CSS / JavaScript（`static/index.html`） |

## 📁 项目结构

```
图书管理系统/
├── README.md                     # 项目说明
├── bookdb.sql                    # 建库建表脚本
└── book-web/                     # Spring Boot 主项目
    ├── pom.xml                   # Maven 依赖配置
    ├── mvnw / mvnw.cmd           # Maven Wrapper（免安装 Maven）
    └── src/
        ├── main/
        │   ├── java/com/book/book_web/
        │   │   ├── BookWebApplication.java      # 启动类
        │   │   ├── controller/BookController.java   # REST 接口层
        │   │   ├── service/BookService.java         # 业务逻辑层
        │   │   ├── repository/BookRepository.java   # 数据访问层（JdbcTemplate）
        │   │   └── entity/Book.java                 # 图书实体
        │   └── resources/
        │       ├── application.properties      # 数据源等配置
        │       └── static/index.html           # 前端页面
        └── test/                               # 测试目录
```

## 🚀 快速开始

### 1. 环境要求
- JDK 21+
- MySQL 已安装并启动

### 2. 初始化数据库

在项目根目录执行（Windows 用 `cmd`，macOS/Linux 用终端）：

```bash
mysql -u root -p < bookdb.sql
```

会自动创建 `bookdb` 数据库和 `books` 表。

### 3. 修改数据库连接配置

打开 `book-web/src/main/resources/application.properties`，把用户名密码改成你本机的 MySQL 账号：

```properties
spring.datasource.username=root
spring.datasource.password=你的密码
```

### 4. 启动项目

进入项目目录并启动：

```bash
# Windows
cd book-web
mvnw.cmd spring-boot:run

# macOS / Linux
cd book-web
./mvnw spring-boot:run
```

（已安装 Maven 的话，也可以直接 `mvn spring-boot:run`）

### 5. 访问

浏览器打开 **http://localhost:8080** 即可使用。

## 🔌 REST API

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/books` | 获取全部图书 |
| GET | `/books/find?uid=1` | 按编号查询 |
| GET | `/books/find?name=书名` | 按书名查询（与 uid 同时传时优先 uid） |
| POST | `/books` | 新增图书，Body 为 JSON |
| DELETE | `/books/{uid}` | 按编号删除 |

示例：

```bash
# 新增
curl -X POST http://localhost:8080/books \
  -H "Content-Type: application/json" \
  -d '{"uid": 3, "name": "三体"}'

# 查询
curl http://localhost:8080/books/find?name=三体

# 删除
curl -X DELETE http://localhost:8080/books/3
```

## 🗄️ 数据表结构

```sql
CREATE DATABASE IF NOT EXISTS bookdb DEFAULT CHARSET utf8mb4;
USE bookdb;

CREATE TABLE IF NOT EXISTS books (
    uid  INT PRIMARY KEY,          -- 图书编号
    name VARCHAR(255) NOT NULL     -- 书名
);
```

## 📸 运行效果

（待补充截图）
