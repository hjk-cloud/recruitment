# recruitment
接口文档  https://lnu-recruitment.apifox.cn

## 功能介绍
### 管理员 admin

1. 审核公司信息(招聘者注册)
2. 删除无效岗位
3. 查看操作日志

### 求职者 candidate

1. 上传简历附件/填写在线简历
4. 分享职位(选做)

### 注册模块

recruiter：

candidate：

### 个人信息

candidate：

查看浏览记录 Redis：List candidate_id—— position_id... ✔

查看收藏列表 Redis： List candidate_id—— positionid... ✔

修改个人信息

### 投递模块

recruiter：根据recruiter_id查看position列表，根据position_id查看求职者列表，查看附件简历，更新投递进度

candidate：根据position_id投递简历，查看投递记录，进度 ✔

### 职位管理

1、对于每个recruiter，可根据recruiter_id查询到自己发布的position列表，根据position_id可对其修改、删除 ✔

2、recruiter可增加position ✔

### 职位查询

1、根据用户信息进行职位推荐并展示在首页

2、根据条件对职位进行模糊查询 ✔

3、查看每个职位的投递数 Redis： String存 position_id —— num （incr方法自增）

### 实时聊天

1.求职者与HR交流 查看candidate个人信息

## 数据库设计

### 管理员 admin

用户id、用户名、密码

### 求职者 candidate
用户id、用户名、密码、手机号、性别、出生年月、所在城市、求职状态(在校、随时到岗)、学历、毕业院校、期望薪资、简历附件

### 招聘者 recruiter

用户id、真实姓名、性别、担任职务、企业id

### 职位信息 position

id、招聘者id、企业id、职位名称、职位描述、职位亮点（可选）、职位类别、学历/经验要求、职位关键词、工作地址、薪资范围

### 企业信息 company

id、企业名称、企业类型、人数规模、企业地址、企业网址、企业介绍、（企业全称、社会信用代码、成立日期、注册资本）

### 投递信息 delivery

id candidateId positionId status


