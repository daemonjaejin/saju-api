CREATE DATABASE `saju` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- saju.TB_COMMON_CODE definition

CREATE TABLE `TB_COMMON_CODE` (
                                  `COMMON_CODE_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '공통코드 ID',
                                  `COMMON_CODE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '공통 코드',
                                  `GROUP_CODE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '그룹 공통 코드',
                                  `COMMON_CODE_NAME` varchar(100) NOT NULL COMMENT '공통 코드 명',
                                  `COMMON_CODE_ORDER` int DEFAULT NULL COMMENT '공통 코드 순번',
                                  `USE_YN` tinyint NOT NULL COMMENT '사용 유무',
                                  `EMPTY_VAL_1` varchar(100) DEFAULT NULL COMMENT '임시 필드1',
                                  `EMPTY_VAL_2` varchar(100) DEFAULT NULL COMMENT '임시 필드2',
                                  `EMPTY_VAL_3` varchar(100) DEFAULT NULL COMMENT '임시 필드3',
                                  `EMPTY_VAL_4` varchar(100) DEFAULT NULL COMMENT '임시 필드4',
                                  `EMPTY_VAL_5` varchar(100) DEFAULT NULL COMMENT '임시 필드5',
                                  `CREATE_USER_ID` varchar(20) NOT NULL COMMENT '생성 유저 ID',
                                  `UPDATE_USER_ID` varchar(20) DEFAULT NULL COMMENT '수정 유저 ID',
                                  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                                  `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                                  PRIMARY KEY (`COMMON_CODE_ID`),
                                  KEY `FK_COMMON_CODE_GROUP` (`GROUP_CODE`),
                                  CONSTRAINT `FK_COMMON_CODE_GROUP` FOREIGN KEY (`GROUP_CODE`) REFERENCES `TB_COMMON_GROUP` (`GROUP_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='공통 코드 테이블';

-- saju.TB_COMMON_GROUP definition

CREATE TABLE `TB_COMMON_GROUP` (
                                   `GROUP_CODE_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '그룹코드 ID',
                                   `GROUP_CODE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '그룹코드',
                                   `GROUP_CODE_NAME` varchar(100) NOT NULL COMMENT '그룹코드명',
                                   `DESCRIPTION` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '설명',
                                   `USE_YN` tinyint NOT NULL COMMENT '사용 유무',
                                   `CREATE_USER_ID` varchar(20) NOT NULL COMMENT '생성 유저 ID',
                                   `UPDATE_USER_ID` varchar(20) DEFAULT NULL COMMENT '수정 유저 ID',
                                   `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                                   `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                                   PRIMARY KEY (`GROUP_CODE_ID`),
                                   UNIQUE KEY `TB_COMMON_GROUP_UNIQUE` (`GROUP_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='공통 그룹 테이블';

-- saju.TB_MENU definition

CREATE TABLE `TB_MENU` (
                           `MENU_ID` varchar(20) NOT NULL COMMENT '메뉴 ID',
                           `MENU_PARENT_ID` varchar(20) DEFAULT NULL COMMENT '메뉴 부모 ID',
                           `MENU_NAME` varchar(100) NOT NULL COMMENT '메뉴명',
                           `MENU_URL` varchar(100) DEFAULT NULL COMMENT '메뉴 주소',
                           `USE_YN` tinyint NOT NULL,
                           `CREATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '생성 유저 ID',
                           `UPDATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '수정 유저 ID',
                           `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                           `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                           PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='메뉴 테이블';

-- saju.TB_RESULT_CONTENT_REL definition

CREATE TABLE `TB_RESULT_CONTENT_REL` (
                                         `RESULT_CONTENT_ID` varchar(20) NOT NULL COMMENT '결과 컨텐츠 ID',
                                         `SAJU_RESULT_ID` varchar(20) NOT NULL COMMENT '사주 결과 ID',
                                         `SAJU_CONTENT_ID` varchar(20) NOT NULL COMMENT '사주 컨텐츠 ID',
                                         `CREATE_USER_ID` varchar(20) NOT NULL COMMENT '생성 사용자 ID',
                                         `UPDATE_USER_ID` varchar(20) DEFAULT NULL COMMENT '수정 사용자 ID',
                                         `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                                         `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                                         PRIMARY KEY (`RESULT_CONTENT_ID`),
                                         UNIQUE KEY `TB_RESULT_CONTENT_REL_UNIQUE` (`SAJU_CONTENT_ID`,`SAJU_RESULT_ID`),
                                         KEY `TB_RESULT_CONTENT_REL_TB_SAJU_RESULT_FK` (`SAJU_RESULT_ID`),
                                         CONSTRAINT `TB_RESULT_CONTENT_REL_TB_SAJU_CONTENT_FK` FOREIGN KEY (`SAJU_CONTENT_ID`) REFERENCES `TB_SAJU_CONTENT` (`SAJU_CONTENT_ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
                                         CONSTRAINT `TB_RESULT_CONTENT_REL_TB_SAJU_RESULT_FK` FOREIGN KEY (`SAJU_RESULT_ID`) REFERENCES `TB_SAJU_RESULT` (`SAJU_RESULT_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사주 결과 컨텐츠 맴핑 테이블';

-- saju.TB_ROLE definition

CREATE TABLE `TB_ROLE` (
                           `ROLE_ID` varchar(20) NOT NULL COMMENT '권한 ID',
                           `ROLE_NAME` varchar(100) NOT NULL COMMENT '권한 이름',
                           `USE_YN` tinyint NOT NULL,
                           `CREATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '생성 유저 ID',
                           `UPDATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '수정 유저 ID',
                           `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                           `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                           PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='권한 그룹';

-- saju.TB_ROLE_MENU_REL definition

CREATE TABLE `TB_ROLE_MENU_REL` (
                                    `ROLE_MENU_ID` varchar(20) NOT NULL COMMENT '권한 메뉴 ID',
                                    `ROLE_ID` varchar(20) NOT NULL COMMENT '권한 ID',
                                    `MENU_ID` varchar(20) NOT NULL COMMENT '메뉴 ID',
                                    `CREATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '생성 유저 ID',
                                    `UPDATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '수정 유저 ID',
                                    `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                                    `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                                    PRIMARY KEY (`ROLE_MENU_ID`),
                                    UNIQUE KEY `TB_ROLE_MENU_REL_UNIQUE` (`ROLE_ID`,`MENU_ID`),
                                    KEY `TB_ROLE_MENU_TB_MENU_FK` (`MENU_ID`),
                                    CONSTRAINT `TB_ROLE_MENU_TB_MENU_FK` FOREIGN KEY (`MENU_ID`) REFERENCES `TB_MENU` (`MENU_ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
                                    CONSTRAINT `TB_ROLE_MENU_TB_ROLE_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `TB_ROLE` (`ROLE_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='권한 메뉴 관계 테이블';

-- saju.TB_SAJU_CONTENT definition

CREATE TABLE `TB_SAJU_CONTENT` (
                                   `SAJU_CONTENT_ID` varchar(20) NOT NULL COMMENT '사주 CONTENT ID',
                                   `SAJU_CONTENT_TITLE` varchar(1000) DEFAULT NULL COMMENT '사주 컨텐츠 제목',
                                   `SAJU_CONTENT_BODY` varchar(100) DEFAULT NULL COMMENT '사주 컨텐츠 내용',
                                   `USE_YN` tinyint NOT NULL,
                                   `CREATE_USER_ID` varchar(20) NOT NULL COMMENT '생성 사용자 ID',
                                   `UPDATE_USER_ID` varchar(20) DEFAULT NULL COMMENT '수정 사용자 ID',
                                   `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                                   `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                                   PRIMARY KEY (`SAJU_CONTENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사주 콘텐츠';

-- saju.TB_SAJU_PROFILE definition

CREATE TABLE `TB_SAJU_PROFILE` (
                                   `SAJU_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '사주 ID',
                                   `USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '유저 ID',
                                   `BIRTHDAY` varchar(8) DEFAULT NULL COMMENT '사주 생년월일',
                                   `BIRTHTIME` varchar(4) DEFAULT NULL COMMENT '사주 시분',
                                   `USE_YN` tinyint NOT NULL,
                                   `CREATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '생성자 ID',
                                   `UPDATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '수정자 ID',
                                   `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                                   `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                                   PRIMARY KEY (`SAJU_ID`),
                                   KEY `TB_SAJU_PROFILE_TB_USER_FK` (`USER_ID`),
                                   CONSTRAINT `TB_SAJU_PROFILE_TB_USER_FK` FOREIGN KEY (`USER_ID`) REFERENCES `TB_USER` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사용자 사주 정보';

-- saju.TB_SAJU_RESULT definition

CREATE TABLE `TB_SAJU_RESULT` (
                                  `SAJU_RESULT_ID` varchar(20) NOT NULL COMMENT '사주 결과 ID',
                                  `GENDER_CODE` varchar(20) DEFAULT NULL COMMENT '성별 코드',
                                  `CALENDAR_CODE` varchar(20) DEFAULT NULL COMMENT '양력/음료 코드',
                                  `SAJU_ID` varchar(20) DEFAULT NULL COMMENT '사주 ID',
                                  `ELEMENT_CODE` varchar(20) DEFAULT NULL COMMENT '오행 코드',
                                  `FORTUNE_CODE` varchar(20) DEFAULT NULL COMMENT '운세 코드',
                                  `GAN_CODE` varchar(20) DEFAULT NULL COMMENT '천간 코드',
                                  `JI_CODE` varchar(20) DEFAULT NULL COMMENT '자축인묘 코드',
                                  `USE_YN` tinyint NOT NULL,
                                  `CREATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '생성자 ID',
                                  `UPDATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '수정자 ID',
                                  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                                  `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                                  PRIMARY KEY (`SAJU_RESULT_ID`),
                                  KEY `TB_SAJU_RESULT_TB_SAJU_PROFILE_FK` (`SAJU_ID`),
                                  CONSTRAINT `TB_SAJU_RESULT_TB_SAJU_PROFILE_FK` FOREIGN KEY (`SAJU_ID`) REFERENCES `TB_SAJU_PROFILE` (`SAJU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사주 결과';

-- saju.TB_USER definition

CREATE TABLE `TB_USER` (
                           `USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '사용자 ID',
                           `USER_NAME` varchar(100) NOT NULL COMMENT '사용자명',
                           `ROLE_ID` varchar(20) NOT NULL COMMENT '사용자 권한',
                           `GENDER_CODE` varchar(20) DEFAULT NULL COMMENT '성별',
                           `ADDRESS` varchar(1000) DEFAULT NULL COMMENT '주소',
                           `PHONE` varchar(20) DEFAULT NULL COMMENT '연락처',
                           `BIRTHDAY` varchar(8) DEFAULT NULL COMMENT '생년월일',
                           `BIRTHTIME` varchar(4) DEFAULT NULL COMMENT '태어난날 시분\r\nEX)오후 4시 태어난 사람 \r\n1600',
                           `STAR_SIGN` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '별자리',
                           `USE_YN` tinyint DEFAULT NULL,
                           `CREATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '생성 유저 ID',
                           `UPDATE_USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '수정 유저 ID',
                           `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
                           `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
                           PRIMARY KEY (`USER_ID`),
                           KEY `TB_USER_TB_ROLE_FK` (`ROLE_ID`),
                           CONSTRAINT `TB_USER_TB_ROLE_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `TB_ROLE` (`ROLE_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사용자 테이블';




