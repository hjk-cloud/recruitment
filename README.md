# recruitment

## 功能介绍
### 管理员 admin

1. 审核公司信息(招聘者注册)
4. 删除无效岗位
5. 查看操作日志

### 招聘者 recruiter

1. CRUD招聘信息（1:N）
2. 接收求职者简历(招聘者1: 岗位N: 求职者N)
3. 筛选查看求职者

### 求职者 candidate

1. 上传简历附件/填写在线简历
2. 投递简历(求职者N:岗位N)
3. 浏览筛选职位列表
4. 分享职位(选做)
5. 投递记录，进度(已投递、初筛、一面、二面、hr面、)
6. 查看浏览记录(选做)

### 聊天功能

   1.求职者与HR交流

### 登录注册功能   

​	springsecurity + jwt

## 数据库设计

### 管理员 admin
用户id、用户名、密码

### 求职者 candidate
用户id、用户名、密码、手机号、性别、出生年月、所在城市、求职状态(在校、随时到岗)、学历、毕业院校、期望薪资、简历附件

### 招聘者 recruiter
用户id、真实姓名、性别、担任职务、企业名称、企业所在地、企业类型

### 职位信息 position
id、职位名称、职位描述、职位亮点（可选）、职位类别、学历/经验要求、职位关键词、工作地址、薪资范围

### 求职者-职位表
userId  jobId  status


