CREATE DATABASE IF NOT EXISTS `springdatajpa` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
CREATE TABLE `tb_article` (
  `id` int(24) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `supplier` varchar(128) DEFAULT NULL COMMENT '供应商',
  `price` decimal(20,4) DEFAULT NULL COMMENT '单价',
  `locality` varchar(128) DEFAULT NULL COMMENT '出版社',
  `image` varchar(128) DEFAULT NULL COMMENT '商品图片',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `storage` int NOT NULL COMMENT '库存数量',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文章';

INSERT INTO `tb_article` (
    title,
    supplier,
    price,
    locality,
    STORAGE,
    image,
    description,
    create_time
    )
VALUES
       (
           '疯狂Java讲义(附光盘)。',
           '李刚 著',
           108.8,
           '电子工业出版社',
           100,
           'java.jpg',
           '疯狂源自梦想,技术成就辉煌 本书来自作者3年的Java培训经历,凝结了作者近3000个小时的授课经验,总结了几百个Java学员学习过程中的典型错误。',
           '2008-10-01 10:00:00'
           ),
       (
           '轻量级Java EE企业应用实战。',
           '李刚 著',
           79.8,
           '电子工业出版社',
           100,
           'ee.jpg',
           '本书主要介绍以Spring+Hibernate为基础的Java EE应用。',
           '2008-11-01'
           ),
       (
           '疯狂Ajax讲义(含CD光盘1张)。',
           '李刚 著',
           66.6,
           '电子工业出版社',
           100,
           'ajax.jpg',
           '异步访问技术,现在所有网站都在用。',
           '2011-07-01'
           ),
       (
           '疯狂iOS讲义（基础篇）（含光盘1张）',
           '李刚 著',
           85.6,
           '电子工业出版社',
           100,
           'ios.jpg',
           '基于iOS全新版本彻底升级，Swift和Objective-C双语讲解。',
           '2016-05-01'
           ),
       (
           '魔戒：插图珍藏版（200套限量编号版随机发送！）。奴役全世界的力量。',
           '(英国) J.R.R.托尔金 著',
           132.3,
           '译林出版社',
           100,
           '22566493-1_b.jpg',
           '天真无邪的哈比男孩佛罗多继承了一枚戒,这是一次异常艰险的远征……',
           '2012-06-18'
           ),
       (
           '肖申克的救赎。',
           '（美）金 著,施寄青,赵永芬,齐若兰',
           19.9,
           '人民文学出版社',
           100,
           '9198692-1_l.jpg',
           '本书是斯蒂芬•金最为人精精乐道的杰出代表作。',
           '2012-06-11'
           ),
       (
           '权威定本四大名著： 红楼梦 三国演义  水浒传  西游记 全国独家',
           '[明] 吴承恩，[明] 施耐庵，[明] 罗贯中，[清] 曹雪芹 著；黄肃秋 注',
           145.8,
           '清华大学出版社',
           100,
           '20605371-1_a.jpg',
           '权威定本四大名著： 红楼梦 三国演义  水浒传  西游记。',
           '2012-06-11'
           ) ,
       (
           '万物生光辉',
           '[英] 吉米·哈利 著；余国芳，谢瑶玲 译',
           23.6,
           '湖北教育出版社',
           100,
           '22639083-1_a.jpg',
           '邂逅最可爱的动物，感受最纯真的幽默。',
           '2012-06-11'
           ),
       (
           '爱你是最好的时光',
           '匪我思存 著 ',
           17.6,
           '译林出版社',
           120,
           '22630101-1_a.jpg',
           '终极大结局完结篇。',
           '2012-06-11'
           ),
       (
           '白鹿原',
           '陈忠实 著',
           360,
           '春风文艺出版社',
           100,
           '22541642-1_a.jpg',
           '中国首部当代名家名篇宣纸线装书，陈忠实先生亲笔签名签章限量珍藏版。',
           '2012-06-11'
           ),
       (
           'Spring+MyBatis企业应用实战。',
           '肖文吉 著',
           58,
           '电子工业出版社',
           100,
           'Spring+MyBatis.jpg',
           '媲美于SSH组合的轻量级Java EE开发方式。',
           '2017-01-01'
           ),
       (
           '疯狂XML讲义(含光盘1张),包括DTD、Schema等技术的深入讲解。',
           '李刚 著',
           48.8,
           '电子工业出版社',
           100,
           'xml.jpg',
           '本书主要以XML为核心,深入地介绍了XML的各种相关知识。',
           '2012-06-11'
           ),
       (
           '疯狂Java：突破程序员基本功的16课(修订版)',
           '李刚 著',
           44.2,
           '电子工业出版社',
           100,
           'basic.jpg',
           '《疯狂Java：突破程序员基本功的16课(修订版)》',
           '2012-06-11'
           ),
       (
           '疯狂Android讲义(含CD光盘1张)',
           '李刚 著',
           60.6,
           '电子工业出版社',
           100,
           'android.jpg',
           '本书全面地介绍了Android应用开发的相关知识。',
           '2012-06-11'
           );
