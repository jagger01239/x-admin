/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.5.62 : Database - xdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xdb`;

/*Table structure for table `x_article` */

DROP TABLE IF EXISTS `x_article`;

CREATE TABLE `x_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `content` text,
  `user` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `x_article` */

insert  into `x_article`(`id`,`name`,`content`,`user`,`time`,`is_delete`) values 
(1,'十点十分','## 发射点发生和','admin','2023-10-13 19:01:52',1),
(2,'美文1','细数门前落叶,倾听窗外雨声,涉水而过的声音此次响起,你被雨淋湿的心,是否依旧','admin','2023-10-14 08:53:10',1),
(3,'美文2','站在寒冬的冷风中,漫天的雪花正纷纷扬扬地包裹着这座寒冷的城市。想着逝去了的那份真挚的无价情义,我忍不住怆然泪下。','admin','2023-10-14 08:53:35',1),
(4,'美文3','**思念**,是一种幸福的忧伤,是一种甜蜜的惆怅,是一种温馨的痛苦。思念是对昨日悠长的沉淀和对未来美==好的向往。也正是因为有了思念,才有了久别重逢的欢畅,才有了意外邂逅的惊喜,才有了亲友相聚时的举杯庆祝。==','admin','2023-10-14 08:54:13',1),
(5,'美文作文300字 篇3','天下没有不散的宴席，我们也终将要毕业。以前认为毕业还是与我们遥遥无期，昨天的我们还抱着一块发牢骚，我们什么时候可以毕业，可是一块有说有笑，可转眼却要各奔东西。毕业以后我们见面的机会还有多少？能相聚的时间又有多长？\n\n　　说起毕业总是伤感的，毕业了意味着要离开一起生活多年的同窗们，还有许多在学校未完成的事……肯定会有许多的不舍，即使有再多的不舍我们也终将要毕业，今天的离别是为了明天更好的相聚。待我们相聚时，面带笑容，哭着笑着我么终于再一次相聚了。双双梦想把家还，这个场景肯定很美好。\n\n　　但是现实总是残忍的，有多少人真的能在毕业以后能把梦想实现？再见时每一个都已经经过了社会与年龄的洗礼，没有可以前的纯真快乐，不会像以前那样没心没肺什么都敢做……\n\n　　即使有再多的不舍，我们也终将要毕业。愿我们再聚时仍然没心没肺。','admin','2023-10-14 09:15:17',0),
(6,'美文作文300字 篇4','　我爱秋天，它吸引我的不是丰收的喜悦，而是那漫山遍野的树叶 。 走在乡间的小路上，无意间看见了一颗粗壮的银杏树，随着一阵秋风出来，银杏叶慢悠悠的向下飘来，我伸出双手去接住它 ，银杏叶就像一位懂事的孩子，乖乖的落在我的手里。我仔细的观察着这片银杏叶，颜色已经绿中透黄，黄中透绿了。但叶脉仍然十分清晰，一条细长的叶柄支撑着整片树叶，叶片摸起来软软的。我不禁将它凑近我的鼻子，竟有一些清香的味道。我超它轻轻一吹，它便顺着我的手滑落下去，回到了大地母亲的怀抱。我继续向前走，脚底踩着叶片，随即发出了“咔嚓”的声音。\n\n　　穿过一片田野，竟发现远处有一大片枫林，宛如一大团熊熊燃烧的火焰，染红了天际。走近看，片片枫叶精巧细腻，好像害羞的少女，红着脸儿，看上去，煞是美丽。一阵风吹过，枫叶如仙女散花般飘落。我拾起一片枫叶，它长着五个尖角，每个角上长着许多小刺，摸上去略略扎手，一只小小的叶柄上长着许多绒毛它的叶脉从五个角伸向叶柄。整个结构分配的如此恰当、合适。看到此景，我不禁想起唐代诗人杜牧的诗句“停车坐爱枫林晚，霜叶红于二月花。” 我爱着斑斓的秋天，更爱这些美丽的树叶。','admin','2023-10-14 09:15:40',0),
(7,'美文作文300字 篇5','今天，在小荷作 文，我看到了一篇美文《霜的工作》，这篇文章是我国著名的作家叶圣陶写的，写得太棒了。\n\n　　我觉得他写的最好的地方就是运用了特别多的拟人。比如霜都会张口说话，把霜都写的像人一样，把一个沉默的霜写得生龙活虎。\n\n　　我读到了霜的功劳。霜像一个辛勤的劳动者，它就好比是毛主席在为人们服务。霜还告诉了大家，是我工作的时候了。我感觉霜是一个经过深思熟虑的人。\n\n　　霜是一个善良的人。它把栗子敲开让小孩和松鼠有东西吃。霜还画人家的玻璃窗，其实是霜冻住了窗户，但叶圣陶先生这样描写很生动。\n\n　　叶圣陶写的太完美了，让霜变成了一个人类，并且还会说话。霜先说了一声，让人有所准备，如果霜不说，人们会怪霜。叶圣陶先生写的人们都能听见霜说的话。文中还有许多拟人句、比喻句……\n\n　　我以后把叶圣陶老先生的方法用上，有可能我会变成第二个叶圣陶呢！哈哈！','admin','2023-10-14 09:16:05',0),
(8,'美文作文300字 篇7','今晨，我们牵着阳光的手，以苍桑的理性作笔，载着梦想启程。\n\n　　曾经失意的盘旋，曾经跌宕的创伤，告别了曲折的命运乐章，休止符背后必将是歇落疲惫的凝望。\n\n　　一次次生命的跃动，一幕幕岁月的漂流……让希望在想象中高度充值，赋予生活崭新的诠释和生动的假设。\n\n　　凝望生活，不再怕凋零的枝干濒临衰老的终结，不再怕青春的脚步出时间的长廊。只要你能付出，就不要轻言放弃!\n\n　　凝望生活，灰暗的天空装进了明亮的胸膛，陈旧的\'故事重新就像潺水的歌唱，最微妙的忧伤也淡成白帆，消失在离去苍茫的远方。\n\n　　凝望生活，久别重逢时的千言万语，冰释前嫌时的深情一瞥，所有春的希望与秋的收获，都将再次热烈地怒放，无法阻挡。\n\n　　凝望生活，纵然穿过日落一抹暗淡的灰黄，一缕失意的青涩，我们仍以清澈的心去细聆昨天，品味今天，追逐明天……\n\n　　风雨无悔，我们的生活在凝望中飞扬，展翅!','admin','2023-10-14 09:16:51',0),
(9,'第三方','啊实打实','admin','2023-10-14 09:41:11',1),
(10,'美文作文300字 篇9','星期五的下午，我们学校举行了美文朗诵比赛。\n\n　　第二节课铃声一响，我们就听着晨曲有序的搬着椅子进入了操场。场上气氛十分热闹。比赛开始了，主持人宣布从一年级到六年级的顺序进行比赛。比赛在同学们的掌声中有序地进行着。终于轮到我了，我走上了台，拿着话筒，面带微笑大声地朗诵。那时候我好紧张，可是很快就朗诵完了，在大家热烈的掌声中走下了台。这时我想起了古人说的话：“台上一分钟，台下十年功。”是呀！为了今天的比赛，我在这每个星期练习，为了朗诵的更好，我的嗓子都练哑了。但我仍然坚持着，我觉得我的嗓子越来越好了。\n\n　　所有的节目中我最喜欢六（3）班朗诵的《中华少年》，这个题目很适合她，通过她动情的朗诵，表达了对祖国的赞美。\n\n　　比赛结束了，每个班级都把自己班上参加美文朗诵比赛的同学展示给全校同学听，我希望我能取得好成绩。','admin','2023-10-14 10:05:40',0),
(11,'美文作文300字 篇10','往常静寂的校园里传来了朗朗书声，这是怎么回事呢？原来体育馆里正在举行美文诵读比赛呢！\n![xiaoxin.jpg](http://localhost:9999/file/6260ef84ed2e4087a11281a3a17999b3.jpg)\n　　只见体育馆里灯火通明，台上五颜六色的荧光灯照亮了舞台，台下人山人海，观众们都在议论今天的节目，舞台旁的休息室里充满了紧张的气氛，参赛者都在积极准备……不会儿，轮到我们班朗诵气势豪迈的“黄河之声”了，此时我的心里仿佛有七八只小兔子在乱窜。我们又马上来到了台上，昂着头，挺着胸，一丝不苟地朗诵。只见毛正阳正诵读第一段，他时而慷慨激昂，时而低吟浅唱。还有低沉婉转的“四季歌”，在我们眼前浮现出生机盎然的春，热情四射的夏，美丽华贵的秋，富有诗意的冬，带给我们美的享受。\n\n　　啊，美文诵读比赛，你像一阵春风，将书香飘进了校园，让教室充满了书香，使我们的学习生活更加丰富多彩。![face1.jpg](http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg)','admin','2023-10-14 10:06:55',0);

/*Table structure for table `x_file` */

DROP TABLE IF EXISTS `x_file`;

CREATE TABLE `x_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件类型',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小(kb)',
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '下载链接',
  `md5` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件md5',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否禁用链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `x_file` */

insert  into `x_file`(`id`,`name`,`type`,`size`,`url`,`md5`,`is_delete`,`enable`) values 
(17,'649002da71c8473db39892b4a758f875.png','png',634,'http://localhost:9090/file/8d966b0e6cf84fe191a72a58b8293b23.png','e1a9407cd0e937c4b411a93b7aca7c87',1,0),
(18,'1641024983532cf.png','png',634,'http://localhost:9090/file/8d966b0e6cf84fe191a72a58b8293b23.png','e1a9407cd0e937c4b411a93b7aca7c87',1,0),
(19,'Java3年经验开发个人简历模板.doc','doc',47,'http://localhost:9090/file/0e020e1337474a93ba3b43a75b2890ee.doc','9ace4fac24420f85c753aa663009edb4',1,1),
(20,'1626102561055-2.jpg','jpg',24,'http://localhost:9090/file/cd379f381364482aaad0d6ffb7209d3d.jpg','adb0481b283645af3809e3d8a1bdb294',1,1),
(21,'1622011842830-5.jpg','jpg',14,'http://localhost:9090/file/7737484487db47ab89e58504ddf86ac1.jpg','2dcd5d60c696c47fdfe0b482c18de0ea',0,1),
(22,'1622536738094-7.jpg','jpg',12,'http://localhost:9090/file/ad5946fe27c14508ac796115f6465826.jpg','35977e7dc2159a734f3c81de460e4b8d',0,1),
(23,'用户信息 (1).xlsx','xlsx',3,'http://localhost:9090/file/02f70e07e69045c38b4748283ffeeabb.xlsx','687f150737c967e74cfd6fa9ec981589',0,1),
(24,'1641024983532cf.png','png',634,'http://localhost:9090/file/8d966b0e6cf84fe191a72a58b8293b23.png','e1a9407cd0e937c4b411a93b7aca7c87',0,1),
(25,'1641024983532cf.png','png',634,'http://localhost:9090/file/8d966b0e6cf84fe191a72a58b8293b23.png','e1a9407cd0e937c4b411a93b7aca7c87',0,1),
(26,'6.jpg','jpg',30,'http://localhost:9090/file/9b21a2b133b140e0bcd9bf66dc5cad1d.jpg','a2cf10bcbed5e9d98cbaf5467acae28d',0,1),
(27,'9b21a2b133b140e0bcd9bf66dc5cad1d.jpg','jpg',30,'http://localhost:9090/file/9b21a2b133b140e0bcd9bf66dc5cad1d.jpg','a2cf10bcbed5e9d98cbaf5467acae28d',0,1),
(28,'1622011842830-5.jpg','jpg',14,'http://localhost:9090/file/7737484487db47ab89e58504ddf86ac1.jpg','2dcd5d60c696c47fdfe0b482c18de0ea',1,1),
(29,'1641024983532cf (1).png','png',634,'http://localhost:9090/file/8d966b0e6cf84fe191a72a58b8293b23.png','e1a9407cd0e937c4b411a93b7aca7c87',0,1),
(30,'1622011842830-5.jpg','jpg',14,'http://localhost:9090/file/7737484487db47ab89e58504ddf86ac1.jpg','2dcd5d60c696c47fdfe0b482c18de0ea',0,1),
(31,'QQ截图20211214232106.jpg','jpg',30,'http://localhost:9090/file/7de0e50f915547539db12023cf997276.jpg','ba5dd263551a31d9bb0582b07cb480e1',0,1),
(32,'boot.jpg','jpg',11,'http://localhost:9090/file/657d7054d7864bd7a0aaba9e44f7924e.jpg','2ab82ad78ff081665ee90f8cb38b45db',0,1),
(33,'QQ图片20210828212629.gif','gif',188,'http://localhost:9090/file/e5512c68a5614135a12064afa66c67e5.gif','ce524058758a83c046b97c66ddcb8a83',0,1),
(34,'vite.jpg','jpg',27,'http://localhost:9090/file/782f20b37b8b4a158c5e13a07fe826d5.jpg','c67bab9c32968cd0cda3e1608286b0d9',0,1),
(35,'mp.jpg','jpg',32,'http://localhost:9090/file/650e8330e78b4fed8fb0c1d866684b5d.jpg','cb887a9d64563352edce80cf50296cc5',0,1),
(36,'qq音乐.png','png',445,'http://localhost:9090/file/461504596ec040729776b674ddec88d3.png','793fd534fa705475eb3358f68c87ec68',0,1),
(37,'QQ截图20211214232106.jpg','jpg',30,'http://localhost:9090/file/7de0e50f915547539db12023cf997276.jpg','ba5dd263551a31d9bb0582b07cb480e1',0,1),
(38,'boot.jpg','jpg',11,'http://localhost:9090/file/657d7054d7864bd7a0aaba9e44f7924e.jpg','2ab82ad78ff081665ee90f8cb38b45db',0,1),
(39,'QQ截图20211214232106.jpg','jpg',30,'http://localhost:9090/file/7de0e50f915547539db12023cf997276.jpg','ba5dd263551a31d9bb0582b07cb480e1',1,0),
(40,'v1.mp4','mp4',47484,'http://localhost:9090/file/a22c9d62ef0648db86b9766bb14d742a.mp4','3dda54bc1a07bd9112bfb381c20b4867',0,1),
(41,'搜狗截图20220129174103.png','png',56,'http://localhost:9090/file/8567a00d2bf740e0a63794baf600cec3.png','050df6119399582fda666834870608d7',0,1),
(42,'QQ图片20220307194920.png','png',100,'http://localhost:9090/file/5e40a867acd74d1f90b0ac9a765823e5.png','0f1337b5c0ebf68f67718fcf42d1322f',0,1),
(43,'QQ图片20220307194920.png','png',100,'http://localhost:9090/file/5e40a867acd74d1f90b0ac9a765823e5.png','0f1337b5c0ebf68f67718fcf42d1322f',0,0),
(46,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',1,1),
(47,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',1,0),
(48,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',1,0),
(49,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',1,0),
(50,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',1,1),
(51,'陈东方.docx','docx',67,'http://localhost:9999/file/83a4f1e2b922427385e68128d4b803cf.docx','f4a339ce433a7cdfa462af2548bd8d47',1,1),
(52,'用户信息导入.xlsx','xlsx',9,'http://localhost:9999/file/424b7b187292401cb198ff2002f69b5e.xlsx','2e45ae9b787b0b5d9a6d205ac33caf8b',1,1),
(53,'陈东方.docx','docx',67,'http://localhost:9999/file/83a4f1e2b922427385e68128d4b803cf.docx','f4a339ce433a7cdfa462af2548bd8d47',1,1),
(54,'用户信息导入.xlsx','xlsx',9,'http://localhost:9999/file/424b7b187292401cb198ff2002f69b5e.xlsx','2e45ae9b787b0b5d9a6d205ac33caf8b',1,1),
(55,'JianyingPro.exe','exe',1875,'http://localhost:9999/file/a0513fda7f964407b9628d43b51cd795.exe','7ba97e3fbde881cafc081881a93aff8f',1,0),
(56,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',1,1),
(57,'计算机学院2023年专业型硕士生导师招生资格审核汇总表---上报学校.xls','xls',32,'http://localhost:9999/file/6134256be06543c986b521e2caf24919.xls','c81b6e321ef3476d0298da1b62315319',1,1),
(58,'计算机学院2023年专业型硕士生导师招生资格审核汇总表---上报学校.xls','xls',32,'http://localhost:9999/file/6134256be06543c986b521e2caf24919.xls','c81b6e321ef3476d0298da1b62315319',0,0),
(59,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',0,1),
(60,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',0,1),
(61,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',0,1),
(62,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(63,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(64,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(65,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(66,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(67,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(68,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(69,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(70,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(71,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(72,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(73,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(74,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(75,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(76,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(77,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(78,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(79,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(80,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(81,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',0,1),
(82,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(83,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',0,1),
(84,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(85,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',0,1),
(86,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(87,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',0,1),
(88,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(89,'xiaoxin.jpg','jpg',136,'http://localhost:9999/file/6260ef84ed2e4087a11281a3a17999b3.jpg','b628797f3b71bfced0d903676fe0edf9',1,1),
(90,'xiaoxin.jpg','jpg',136,'http://localhost:9999/file/6260ef84ed2e4087a11281a3a17999b3.jpg','b628797f3b71bfced0d903676fe0edf9',1,1),
(91,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(92,'xiaoxin.jpg','jpg',136,'http://localhost:9999/file/6260ef84ed2e4087a11281a3a17999b3.jpg','b628797f3b71bfced0d903676fe0edf9',0,1),
(93,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(94,'证件照.JPG','JPG',2474,'http://localhost:9999/file/5c8453e516a5461d9aa62c29a1a10864.JPG','e42bfcf7a25bf4b129f129fb99d9dfb1',0,1),
(95,'xiaoxin.jpg','jpg',136,'http://localhost:9999/file/6260ef84ed2e4087a11281a3a17999b3.jpg','b628797f3b71bfced0d903676fe0edf9',0,1),
(96,'1.mp4','mp4',675,'http://localhost:9999/file/facc20dfa3f4476bb33aa4557b19821c.mp4','3c14c3beebc26f8bf456ca486f0487a6',0,1),
(97,'熊出没.mp4','mp4',10882,'http://localhost:9999/file/47b7ef5393ca457db6777de59b728a5a.mp4','abf486739aed73b45f29fec8f6c56d01',0,1),
(98,'QQ录屏20231012202935.mp4','mp4',21204,'http://localhost:9999/file/6d059db7669d4f158dcf94797b56a48f.mp4','49cc27b97aab5cca72a0fd7584faedd7',0,1),
(99,'819c41d91689d62801e4256d49f58fbd.mp4','mp4',1340,'http://localhost:9999/file/29c87144325146aa855ed4d388419e39.mp4','caede355bdff984e1cefdd77655bb894',0,1),
(100,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(101,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(102,'陈东方.docx','docx',67,'http://localhost:9999/file/83a4f1e2b922427385e68128d4b803cf.docx','f4a339ce433a7cdfa462af2548bd8d47',0,1),
(103,'电子信息通知.doc','doc',29,'http://localhost:9999/file/a64978ebab134b288b8b36b61a5322fc.doc','3b61f2d569389fa52ce2c5d8072f8196',0,1),
(104,'附件2：【电子信息】2023年硕士生招生导师情况登记表.xlsx','xlsx',20,'http://localhost:9999/file/11ca277ac1cf44f29a9eefd060381fa7.xlsx','99e5bec3e5a485a84980bff86262a729',0,1),
(105,'计算机学院2023年专业型硕士生导师招生资格审核汇总表---上报学校.xls','xls',32,'http://localhost:9999/file/b73259ae40ff472586ca80d55539ff88.xls','becf6e7de83e9ced7f88c0e682ec00f8',0,1),
(106,'xiaoxin.jpg','jpg',136,'http://localhost:9999/file/6260ef84ed2e4087a11281a3a17999b3.jpg','b628797f3b71bfced0d903676fe0edf9',0,1),
(107,'face1.jpg','jpg',13,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg','b778c8c7e58d30e12f4d620ac38b6910',0,1),
(108,'用户信息导入.xlsx','xlsx',9,'http://localhost:9999/file/c07f805283eb402e8c0445ae8773f73c.xlsx','de15cad54a8cbd7fb923d1fdc5897399',1,0),
(109,'xiaoxin.jpg','jpg',136,'http://localhost:9999/file/6260ef84ed2e4087a11281a3a17999b3.jpg','b628797f3b71bfced0d903676fe0edf9',0,1);

/*Table structure for table `x_menu` */

DROP TABLE IF EXISTS `x_menu`;

CREATE TABLE `x_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `component` varchar(100) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `redirect` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `is_leaf` varchar(1) DEFAULT NULL COMMENT '是否还有子菜单',
  `hidden` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `x_menu` */

insert  into `x_menu`(`menu_id`,`component`,`path`,`redirect`,`name`,`title`,`icon`,`parent_id`,`is_leaf`,`hidden`) values 
(1,'Layout','/sys','/sys/user','sysManage','系统管理','userManage',0,'N',0),
(2,'sys/user','user',NULL,'userList','用户管理','user',1,'Y',0),
(3,'sys/role','role',NULL,'roleList','角色管理','roleManage',1,'Y',0),
(4,'Layout','/test','/test/test1','test','功能测试','el-icon-s-tools',0,'N',0),
(5,'test/test1','test1',NULL,'test1','文件上传','el-icon-upload',4,'Y',0),
(6,'test/test2','test2',NULL,'test2','整合echarts','el-icon-pie-chart',4,'Y',0),
(7,'test/test3','test3',NULL,'test3','整合高德地图','el-icon-position',4,'Y',0),
(8,'sys/Person','person',NULL,'person','个人信息','el-icon-s-custom',1,'Y',0),
(9,'Layout','/v','/v/video','gongneng',NULL,'form',0,'N',0),
(10,'video/index','video',NULL,'video','集成视频组件','el-icon-video-camera-solid',9,'Y',0),
(11,'Layout','/m','/m/markdown','mark',NULL,NULL,0,'N',0),
(12,'markdown/index','markdown',NULL,'markdown','集成markdown编辑器','el-icon-collection',11,'Y',0);

/*Table structure for table `x_role` */

DROP TABLE IF EXISTS `x_role`;

CREATE TABLE `x_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  `role_desc` varchar(100) DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `x_role` */

insert  into `x_role`(`role_id`,`role_name`,`role_desc`,`is_delete`) values 
(1,'admin','超级管理员',0),
(2,'hr','人事专员',0),
(3,'normal','普通员工',0),
(4,'ceshi1','用于测试使用的1',0),
(5,'嘻嘻嘻','哈哈哈',1),
(6,'sasd','sadasd',1),
(7,'zyzy','cdf',0),
(8,'rtyhkhj','aeghjk',0);

/*Table structure for table `x_role_menu` */

DROP TABLE IF EXISTS `x_role_menu`;

CREATE TABLE `x_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4;

/*Data for the table `x_role_menu` */

insert  into `x_role_menu`(`id`,`role_id`,`menu_id`) values 
(32,8,2),
(33,8,1),
(92,1,1),
(93,1,2),
(94,1,3),
(95,1,8),
(96,1,4),
(97,1,5),
(98,1,6),
(99,1,7),
(100,1,9),
(101,1,10),
(102,1,11),
(103,1,12),
(104,3,4),
(105,3,5),
(106,3,6),
(107,3,7),
(108,3,9),
(109,3,10),
(110,3,11),
(111,3,12);

/*Table structure for table `x_user` */

DROP TABLE IF EXISTS `x_user`;

CREATE TABLE `x_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `x_user` */

insert  into `x_user`(`id`,`username`,`password`,`email`,`phone`,`status`,`avatar`,`deleted`) values 
(1,'admin','123456','super@aliyun.com','18677778888',1,'http://localhost:9999/file/b502a0b707a04b4cadd628930a7a2812.jpg',0),
(2,'zhangsan','123456','zhangsan@gmail.com','13966667777',1,'',0),
(3,'lisi','123456','lisi@gmail.com','13966667778',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0),
(4,'wangwu','123456','wangwu@gmail.com','13966667772',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0),
(5,'zhaoer','123456','zhaoer@gmail.com','13966667776',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0),
(6,'songliu','123456','songliu@gmail.com','13966667771',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0),
(35,'zhaoer','123456','zhaoer@gmail.com','13966667776',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',1),
(36,'zyzzy','123456','2511730983@qq.com','13615686716',0,NULL,0),
(37,'宅宅宅','123456','2511730983@qq.com','19159272116',1,'http://localhost:9999/file/6260ef84ed2e4087a11281a3a17999b3.jpg',0),
(38,'翟小艺','123456','2511730983@qq.com','13615686716',1,NULL,1),
(39,'喜羊羊','123456','super@aliyun.com','18677778888',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0),
(40,'懒羊羊','123456','zhangsan@gmail.com','13966667777',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0),
(41,'美羊羊','123456','lisi@gmail.com','13966667778',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0),
(42,'沸羊羊','123456','wangwu@gmail.com','13966667772',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0),
(43,'灰太狼','123456','zhaoer@gmail.com','13966667776',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0),
(44,'灰太狼','123456','songliu@gmail.com','13966667771',1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',0);

/*Table structure for table `x_user_role` */

DROP TABLE IF EXISTS `x_user_role`;

CREATE TABLE `x_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

/*Data for the table `x_user_role` */

insert  into `x_user_role`(`id`,`user_id`,`role_id`) values 
(1,1,1),
(24,36,2),
(25,36,3),
(26,43,1),
(27,43,2),
(29,37,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
