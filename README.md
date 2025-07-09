# ? Hodl_Server - �๰ ���� �� �ǰ� ��� �鿣�� ����

## ? ������Ʈ ����

**Hodl_Server**�� ������� �๰ ���� ������ �ǰ� ����� ���� ����� ���� �鿣�� �����Դϴ�. ����ڰ� �๰�� ����ϰ� ���� ������ �����ϸ�, ����, �, �޺� ����, ���� ���� �ǰ� �����͸� ����� �� �ִ� RESTful API�� �����մϴ�.

### ? �ֿ� ���
- **�๰ ����**: �๰ ���, ���� ���� ����, ���� ���
- **�ǰ� ���**: ����, �, �޺� ����, ���� ���
- **�˸� �ý���**: Firebase Cloud Messaging�� ���� Ǫ�� �˸�
- **����� ����**: ȸ������, �α���, ������ ����
- **ä�� ��� UX**: �ܰ躰 ä�� �������̽��� ���� �������� �๰ ���

## ?? �ý��� ��Ű��ó

### ��ü �ý��� ����

```mermaid
graph TB
    subgraph "Client Layer"
        A[Mobile App]
    end
    
    subgraph "Web Server Layer"
        B[Nginx - Reverse Proxy]
    end
    
    subgraph "Application Layer"
        C[Spring Boot Application]
        D[JWT Authentication]
        E[Firebase Cloud Messaging]
    end
    
    subgraph "Data Layer"
        F[MySQL Database]
        G[AWS RDS]
    end
    
    subgraph "Infrastructure"
        H[AWS EC2 - Linux]
        I[AWS RDS - MySQL]
    end
    
    A -->|HTTPS| B
    B -->|HTTP| C
    C --> D
    C --> E
    C -->|JDBC| F
    F --> G
    C --> H
    G --> I
    
    style A fill:#e1f5fe
    style B fill:#fff3e0
    style C fill:#f3e5f5
    style D fill:#e8f5e8
    style E fill:#fff8e1
    style F fill:#fce4ec
    style G fill:#f1f8e9
    style H fill:#e0f2f1
    style I fill:#fafafa
```

### ? ��û ó�� �帧

```mermaid
sequenceDiagram
    participant Client as Mobile App
    participant Nginx as Nginx Server
    participant Spring as Spring Boot
    participant DB as MySQL Database
    participant FCM as Firebase Cloud Messaging
    
    Client->>Nginx: HTTPS Request
    Nginx->>Spring: HTTP Request (Reverse Proxy)
    Spring->>Spring: JWT Authentication
    Spring->>DB: Database Query
    DB->>Spring: Query Result
    Spring->>FCM: Push Notification (if needed)
    FCM->>Client: Push Notification
    Spring->>Nginx: HTTP Response
    Nginx->>Client: HTTPS Response
```

### ? �ý��� ��Ű��ó �� ����

| ���̾� | ���� ��� | ���� | ��� ���� |
|--------|-----------|------|-----------|
| **Client Layer** | Mobile App | ����� �������̽� | React Native / Flutter |
| **Web Server Layer** | Nginx | ������ ���Ͻ�, �ε� �뷱�� | Nginx |
| **Application Layer** | Spring Boot | ����Ͻ� ���� ó�� | Spring Boot 2.4.2 |
| **Application Layer** | JWT Authentication | ���� �� ���� ���� | JWT |
| **Application Layer** | Firebase Cloud Messaging | Ǫ�� �˸� ���� | Firebase FCM |
| **Data Layer** | MySQL Database | ������ ���� �� ���� | MySQL 8.0 |
| **Infrastructure** | AWS EC2 | ���ø����̼� ���� | Amazon EC2 (Linux) |
| **Infrastructure** | AWS RDS | �����ͺ��̽� ���� | Amazon RDS (MySQL) |

## ?? ��� ����

### Backend
- **Framework**: Spring Boot 2.4.2
- **Language**: Java 8
- **Build Tool**: Gradle
- **Database**: MySQL 8.0
- **ORM**: Spring JDBC Template
- **Authentication**: JWT (JSON Web Token)
- **Push Notification**: Firebase Cloud Messaging
- **Email Service**: JavaMail API
- **Security**: Spring Security (�⺻ ����)

### Infrastructure
- **Cloud Platform**: AWS
- **Server**: EC2 (Linux)
- **Web Server**: Nginx
- **Database**: RDS (MySQL)
- **Load Balancer**: Nginx (Reverse Proxy)

### Development Tools
- **IDE**: IntelliJ IDEA
- **Version Control**: Git
- **API Testing**: Postman
- **Database Management**: MySQL Workbench

## ? ������Ʈ ����

```
Hodl_Server/
������ src/
��   ������ main/
��   ��   ������ java/shop/hodl/kkonggi/
��   ��   ��   ������ config/                 # ���� Ŭ����
��   ��   ��   ��   ������ BaseException.java
��   ��   ��   ��   ������ BaseResponse.java
��   ��   ��   ��   ������ BaseResponseStatus.java
��   ��   ��   ��   ������ Constant.java
��   ��   ��   ������ src/
��   ��   ��   ��   ������ user/               # ����� ����
��   ��   ��   ��   ��   ������ UserController.java
��   ��   ��   ��   ��   ������ UserService.java
��   ��   ��   ��   ��   ������ UserProvider.java
��   ��   ��   ��   ��   ������ UserDao.java
��   ��   ��   ��   ��   ������ model/
��   ��   ��   ��   ������ medicine/           # �๰ ����
��   ��   ��   ��   ��   ������ MedicineController.java
��   ��   ��   ��   ��   ������ MedicineService.java
��   ��   ��   ��   ��   ������ MedicineProvider.java
��   ��   ��   ��   ��   ������ MedicineDao.java
��   ��   ��   ��   ��   ������ model/
��   ��   ��   ��   ������ record/             # �ǰ� ���
��   ��   ��   ��   ��   ������ medicine/       # �๰ ���� ���
��   ��   ��   ��   ��   ������ sleep/          # ���� ���
��   ��   ��   ��   ��   ������ exercise/       # � ���
��   ��   ��   ��   ��   ������ sun/            # �޺� ���
��   ��   ��   ��   ��   ������ symptom/        # ���� ���
��   ��   ��   ��   ������ notification/       # �˸� ����
��   ��   ��   ��   ������ push/               # Ǫ�� �˸�
��   ��   ��   ��   ������ email/              # �̸��� ����
��   ��   ��   ��   ������ firebase/           # Firebase ����
��   ��   ��   ��   ������ data/               # ��������, ���� ����
��   ��   ��   ��   ������ store/              # ����� ����
��   ��   ��   ������ utils/                  # ��ƿ��Ƽ Ŭ����
��   ��   ��   ��   ������ JwtService.java
��   ��   ��   ��   ������ AES128.java
��   ��   ��   ��   ������ ValidationRegex.java
��   ��   ��   ������ WebSecurityConfig.java  # ���� ����
��   ��   ������ resources/
��   ��       ������ templates/
��   ��       ��   ������ mail.html           # �̸��� ���ø�
��   ��       ������ logback-spring.xml      # �α� ����
��   ������ test/                           # �׽�Ʈ �ڵ�
������ build.gradle                        # Gradle ����
������ gradlew
������ README.md
```

## ? �ֿ� ��� �� ����

### 1. ����� ���� (User Management)

#### ȸ������ �� �α���
- **�̸��� ����**: ȸ������ �� �̸��� ���� �ڵ� �߼�
- **JWT ��ū**: �α��� ���� �� 1�� ��ȿ�� JWT ��ū �߱�
- **��й�ȣ ��ȣȭ**: AES128 �˰������� ��й�ȣ ��ȣȭ

#### ������ ����
- �г���, �������, ���� ���� ����
- ä�� ��� �г��� ���� ���μ���

**API ��������Ʈ:**
```
POST /app/v1/users          # ȸ������
POST /app/v1/users/logIn    # �α���
GET  /app/v1/users/{userIdx} # ������ ��ȸ
PATCH /app/v1/users/{userIdx} # ������ ����
```

### 2. �๰ ���� (Medicine Management)

#### �๰ ��� ���μ���
ä�� ����� �ܰ躰 �๰ ��� �ý���:
1. **�๰�� �Է�** �� 2. **���� �ֱ� ����** �� 3. **������ ����** �� 4. **������ ����** �� 5. **���� �ð� ����**

#### ���� ���� ����
- ���Ϻ� ���� ���� (��~��)
- �ð��뺰 ���� ���� (����, ��ħ, ����, ����, �ڱ���)
- ���뷮 �� �޸� ����

**API ��������Ʈ:**
```
GET  /app/v1/users/medicine/input    # �๰ ��� ����
GET  /app/v1/users/medicine/name     # �๰�� �Է�
GET  /app/v1/users/medicine/cycle    # ���� �ֱ� ����
GET  /app/v1/users/medicine/start    # ������ ����
GET  /app/v1/users/medicine/end      # ������ ����
GET  /app/v1/users/medicine/time     # ���� �ð� ����
POST /app/v1/users/medicine          # �๰ ���
GET  /app/v1/users/medicine          # �๰ ��� ��ȸ
PUT  /app/v1/users/medicine/{medicineIdx} # �๰ ����
DELETE /app/v1/users/medicine/{medicineIdx} # �๰ ����
```

### 3. �ǰ� ��� (Health Records)

#### �๰ ���� ���
- �Ϻ�, �ð��뺰 ���� ���� ���
- ���뷮, ���� �ð�, �޸� ����
- ��ü �๰ �ϰ� ���� ��� ���

#### ���� ���
- ���� �ð�, ��� �ð� ���
- ���� ǰ�� �� ���� ���� �޸�
- ���� ���� �м�

#### � ���
- � ���� �ð�, �� � �ð�
- � ���� �� � ����
- � ���� �޸�

#### �޺� ���� ���
- �߿� Ȱ�� ���� �ð�, �� Ȱ�� �ð�
- �޺� ���� ���� �޸�

#### ���� ���
- ü������ ���� üũ����Ʈ
- ���ۿ� �� ���� ���
- ���� �׷캰 �з�

**API ��������Ʈ:**
```
# �๰ ���� ���
GET  /app/v1/users/record/medicine
POST /app/v1/users/record/medicine/all
PATCH /app/v1/users/record/medicine/all

# ���� ���
GET  /app/v1/users/record/sleep
POST /app/v1/users/record/sleep
PATCH /app/v1/users/record/sleep

# � ���
GET  /app/v1/users/record/exercise
POST /app/v1/users/record/exercise
PATCH /app/v1/users/record/exercise

# �޺� ���
GET  /app/v1/users/record/sun
POST /app/v1/users/record/sun
PATCH /app/v1/users/record/sun

# ���� ���
GET  /app/v1/users/record/symptom
POST /app/v1/users/record/symptom
PATCH /app/v1/users/record/symptom
```

### 4. �˸� �ý��� (Notification System)

#### Ǫ�� �˸�
- **Firebase Cloud Messaging** ����
- �๰ ���� �ð� �˸�
- �����ٸ� ��� �ڵ� �˸� ����
- ����ں� �˸� ���� ����

#### �˸� ����
- ���� �˸�, �๰ �˸�, �̺�Ʈ �˸�, ������ �˸� �и�
- �ð��뺰 �๰ �˸� ����
- ����̽� ��ū ����

**API ��������Ʈ:**
```
GET  /app/v1/users/notification          # �˸� ���� ��ȸ
PATCH /app/v1/users/notification         # �˸� ���� ����
GET  /app/v1/users/notification/medicine # �๰ �˸� ���� ��ȸ
PATCH /app/v1/users/notification/medicine # �๰ �˸� ���� ����
PATCH /app/v1/users/notification/token   # ����̽� ��ū ������Ʈ
```

### 5. ������ ���� (Data Management)

#### ��������
- �� �� �������� ����
- �������� ��� �� �� ���� ��ȸ

#### ���� ����
- �� ���� ���� ����
- �ֽ� ���� ���� ��ȸ

**API ��������Ʈ:**
```
GET /app/v1/data/noticeboard           # �������� ���
GET /app/v1/data/noticeboard/{idx}     # �������� ��
GET /app/v1/data/version               # �� ���� ����
```

## ? ���� �� ����

### JWT ��� ����
- **��ū ����**: �α��� �� userIdx�� ������ JWT ��ū ����
- **��ū ����**: �� API ��û �� X-ACCESS-TOKEN ������� JWT ���� �� ����
- **��ū ����**: 1�� ��ȿ�� ��ū (���� �ʿ�: 30��-1�ð� ����)

### Spring Security
- �⺻���� Spring Security ����
- CSRF ��ȣ ��Ȱ��ȭ
- ���� JWT ���� ����

### ��й�ȣ ��ȣȭ
- AES128 �˰����� ����� ��й�ȣ ��ȣȭ
- �̸��� ���� �ڵ� ��ȣȭ

## ? �����ͺ��̽� ����

### �ֿ� ���̺� ����
- **Users**: ����� �⺻ ����
- **Authentication**: �̸��� ���� ����
- **Medicine**: �๰ ����
- **MedicineTime**: �๰ ���� �ð� ����
- **MedicineRecord**: �๰ ���� ���
- **SleepRecord**: ���� ���
- **ExerciseRecord**: � ���
- **SunRecord**: �޺� ���� ���
- **SymptomRecord**: ���� ���
- **Notification**: �˸� ����
- **DeviceToken**: ����̽� ��ū

## ? ���� �� �

### AWS ������ ����
1. **EC2 �ν��Ͻ�**: Spring Boot ���ø����̼� ȣ����
2. **RDS MySQL**: �����ͺ��̽� ����
3. **Nginx**: ������ ���Ͻ� �� �ε� �뷱��
4. **Security Groups**: ��Ʈ��ũ ���� ����

### ���� ���μ���
1. Spring Boot ���ø����̼� ����
2. EC2 �ν��Ͻ��� JAR ���� ���ε�
3. Nginx ���� ������Ʈ
4. ���ø����̼� �����

### ���� ������ �ٽ� ���
- **JWT ��� ���� �ý���**: ����� ���� �� ���� ����
- **Firebase Ǫ�� �˸�**: ���� �๰ ���� �˸� �ڵ� ����
- **�̸��� ���� �ý���**: ȸ������ �� �̸��� ���� �ڵ� �߼�
- **ä�� ��� UX**: �ܰ躰 �๰ ��� ���μ���
- **�����ٸ� �ý���**: �źи��� �๰ ���� �ð� üũ �� �˸�
- **RESTful API**: ü������ API ���� �� ����

## ? ���� ȯ�� ����

### �ʼ� �䱸����
- Java 8 �̻�
- Gradle 6.x �̻�
- MySQL 8.0 �̻�

### ���� ���� ȯ�� ����
```bash
# ������Ʈ Ŭ��
git clone [repository-url]
cd Hodl_Server

# ������ ��ġ
./gradlew build

# ���ø����̼� ����
./gradlew bootRun
```

### ȯ�� ���� ����
```properties
# application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/hodl_db
    username: your_username
    password: your_password
  
  mail:
    host: smtp.gmail.com
    port: 587
    username: your_email@gmail.com
    password: your_app_password

# Firebase ����
firebase:
  service-account: path/to/serviceAccountKey.json
```

## ? �׽�Ʈ

### API �׽�Ʈ
- Postman�� ����� API ��������Ʈ �׽�Ʈ
- JWT ��ū ��� ���� �׽�Ʈ
- �� ��ɺ� ���� �׽�Ʈ

### �����ͺ��̽� �׽�Ʈ
- ���� ���� �׽�Ʈ
- ������ ���Ἲ �׽�Ʈ

## ? API ����

### ���� ���� ����
```json
{
  "isSuccess": true,
  "code": 1000,
  "message": "��û�� �����Ͽ����ϴ�.",
  "result": {
    // ���� ������
  }
}
```

### ���� �ڵ� ü��
- **1000**: ����
- **2000**: ��û ���� (�Է°� ���� ����)
- **3000**: ���� ���� (������ ��ȸ ����)
- **4000**: ���� ���� (�����ͺ��̽�, ���� ���� ����)

## ? ������Ʈ ���� ���� (����)

### ���� ��ȭ (����)
- JWT ��ū ���� �ð� ���� (1�� �� 30��-1�ð�)
- �������� ��ū ����
- Spring Security JWT ���� ����
- �޼��� ���� ���� ����

### ���� ���� (����)
- ĳ�� ���� ���� (Redis)
- �����ͺ��̽� ���� ����ȭ
- API ���� �ð� ����

### ��� Ȯ�� (����)
- ���� ����̽� �α��� ����
- ��ū ������Ʈ ����
- ���� �α� ���
- Rate Limiting ����

## ??? ������ ����

**����**: �鿣�� ������ (Ǯ���� �鿣��)
**��� ����**:
- ���� ���� �� ������ ���� (AWS EC2, RDS, Nginx)
- �����ͺ��̽� ���� �� ���� (MySQL)
- Spring Boot �鿣�� API ����
- JWT ���� �ý��� ����
- Firebase Ǫ�� �˸� ����
- �̸��� ���� ����

**��� ����**:
- Java, Spring Boot, MySQL, AWS, Nginx, JWT, Firebase

---

## ? ������Ʈ ����

**������Ʈ �Ⱓ**: 2021.5 - 2021.8  
**�� ����**: Hodl (�Ҽ�: [@Central-MakeUs](https://github.com/Central-MakeUs))  
**GitHub**: [@ucans/Hodl_Server](https://github.com/ucans/Hodl_Server)

---

*�� ������Ʈ�� ���б� �к� �������� ������ �� ������Ʈ��, ���� ���� ���� ������ ���� �鿣�� ���� ������ ����Ų ������Ʈ�Դϴ�.*
