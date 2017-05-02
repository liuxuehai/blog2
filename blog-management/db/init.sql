CREATE DATABASE `blog` /*!40100 DEFAULT CHARACTER SET utf8 */;


CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) DEFAULT NULL,
  `comment_author` tinytext,
  `comment_author_email` varchar(100) DEFAULT NULL,
  `comment_author_url` varchar(200) DEFAULT NULL,
  `comment_author_ip` varchar(100) DEFAULT NULL,
  `comment_date` datetime DEFAULT NULL,
  `comment_context` text,
  `comment_approved` varchar(20) DEFAULT NULL,
  `comment_agent` varchar(255) DEFAULT NULL,
  `comment_type` varchar(20) DEFAULT NULL,
  `comment_parent` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` bigint(20) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `post_context` longtext,
  `post_conext_eng` longtext,
  `post_title` text,
  `post_status` int(2) DEFAULT NULL,
  `comment_status` int(2) DEFAULT NULL,
  `ping_status` int(2) DEFAULT NULL,
  `post_modified` datetime DEFAULT NULL,
  `post_parent` bigint(20) DEFAULT NULL,
  `guid` varchar(255) DEFAULT NULL,
  `menu_order` int(11) DEFAULT NULL,
  `post_type` varchar(20) DEFAULT NULL,
  `post_mime_type` varchar(100) DEFAULT NULL,
  `comment_count` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_login` varchar(60) DEFAULT NULL,
  `user_pass` varchar(64) DEFAULT NULL,
  `user_nicename` varchar(100) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_url` varchar(100) DEFAULT NULL,
  `user_registered` datetime DEFAULT NULL,
  `user_status` int(2) DEFAULT NULL,
  `display_name` varchar(250) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


