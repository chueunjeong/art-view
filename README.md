Art-View ( 전시 공간 대여 및 작가 커뮤니티 관리 시스템 ) 소개
==========================================================
![](https://blogfiles.pstatic.net/MjAxODA2MTZfMjkz/MDAxNTI5MTUwMjQ0MTM0.VJqMAXYbo-nQ03NdWkO_NsDIYVEK26CbKSXqM_vkHa4g.f638-JMmggqJbSfLal-UpDUa7CCB9sLnHkCyZXSRFJAg.PNG.iris9602/logo.PNG "Art-view" )
# 프로젝트 개요
  + 가. 프로젝트 소개
    * 개발 시스템 설계 내용 : 전시 공간 대여 및 작가 커뮤니티 관리 시스템
    * 시스템 이름 : Art-view
    * 역할 : 문화 예술 산업의 공간 정보 활용 및 인적/물적 교류 인프라 부족 해결
  + 나. 추진배경 및 필요성
    * 예술 산업 인프라 부실 : 신진작가들 간의 교류의 장이 활성화가 되지 않고, 예술 공간 인프라 부족으로 인한 어려움 호소하고 있음, 인프라 구축을 통해 청년/신진 작가들의 발굴 기회를 도모할 수 있음 
    * 종합 관리 시스템 부재 : 전시 주최자 입장에서는 전시 기획(전시인원모집)에 필요한 서비스와 공간 탐색/대여 서비스가 분리되어있어 이를 아우를 수 있는 통합 시스템의 필요성을 느꼈으며, 기존에 공간을 제공해 왔던 문화시설의 입장에서도 자체 시설 내 공간 제공을 홍보하고 해당 공간의 수요자(작가)와의 계약 진행과정을 전체적으로 검토할 수 있는 종합 관리 시스템의 필요성이 요구됨 
    * 지역 지자체 잉여 공간 활용 : 지역지자체 예술 공간 홍보로 서울지역에 비해 소외된 지역주민 복지 질 향상을 이뤄낼 수 있음

# 적용 기술
  * Augular4
  * Apache-Tomcat
  * MairaDB
  * SpringBoot + Mybatis
  * JAVA 1.8
  * Amazon S3 
  * JWT token 
  

  
# 시스템 구성도
![](https://blogfiles.pstatic.net/MjAxODA2MTZfMTEy/MDAxNTI5MTUwOTk0NDU4.8uVEenzOw0zl2Xi23T6XmuD9ji6h3isLE-GHeKT-m40g.zjuXmAi7Hpx1Wn2KJ_btZ7SL5XtTVRQK36Wlq2tHuRAg.JPEG.iris9602/%EC%8B%9C%EC%8A%A4%ED%85%9C%EA%B5%AC%EC%84%B1%EB%8F%84.jpg)

# 소프트웨어 구성도
![](https://blogfiles.pstatic.net/MjAxODA2MTZfOTUg/MDAxNTI5MTUwOTkzOTgw.bDZ4ytK81tUraxXsrEpYzC8prmT_-G1sr2KSMdSL-Rkg.Tr-FlfVSsNWX2OqpPymtBZE0kUvXC5HgO5q6eogSi2sg.PNG.iris9602/%EC%86%8C%ED%94%84%ED%8A%B8%EC%9B%A8%EC%96%B4%EA%B5%AC%EC%84%B1%EB%8F%84.png)

# 데이터베이스 설계도
![](https://blogfiles.pstatic.net/MjAxODA2MTZfMTAg/MDAxNTI5MTUyNzM0NDc5.vHmHao6qdgHPtpOp8PWLPtIPpQas0sri9ie6R1H1RKkg.vWIg4zjRDQ-XPCevE6fHsTKnFX7MwxXKDmIhJjvYpW8g.JPEG.iris9602/KakaoTalk_20180616_213818620.jpg)

 # 주요 기능과 설명
  * 공간 등록, 조회, 계약 *(Space Provider (전시 공간 제공자)와 Artist(전시기획자)와의 매칭 및 계약 서비스를 제공)*
  * 커뮤니티 게시판 *(그룹 전시 기획에 도움이 되도록 분야별 작가들을 그룹화해주는 커뮤니티 게시판을 운영 )*
  * 전시회 안내 *(주요 미술관 전시, 사이트를 통해 계약한 전시 정보를  사용자에게 제공하고 홍보 역할)*
  * 공간 계약시 디지털 아카이브 작업  
  * 작가 프로필 등록, 조회
  * 얼리버드 예매 서비스 제공 
  + 즐겨찾기/최근 본 공간 목록 조회
  + 쪽지
  
  # 주요 기능의 시스템 흐름도
   ![](https://blogfiles.pstatic.net/MjAxODA2MTZfOTcg/MDAxNTI5MTUwOTk0ODAx.pBwN9nRFONuRnOHK-tHiLgafrf_rmKLr419gn4lqZ2Ug.7zjmySdGMI-2MUeLguQaxAbY2EoW3w1g450SOXkzWbog.JPEG.iris9602/%EC%8B%9C%EC%8A%A4%ED%85%9C%ED%9D%90%EB%A6%84%EB%8F%84_%EA%B3%B5%EA%B0%84%EB%A7%A4%EC%B9%AD.jpg)
   - - -
   ![](https://blogfiles.pstatic.net/MjAxODA2MTZfMjUz/MDAxNTI5MTUwOTk1MTY0.FIwd8Bbj1rs2ZtiirB5lmwTfFE1hFv-EitRluw3hAX0g.LoJEx0F2WxaVaQLSP337OAfxXhMNVhTQS9czz49Z4tog.PNG.iris9602/%EC%8B%9C%EC%8A%A4%ED%85%9C%ED%9D%90%EB%A6%84%EB%8F%84_%EC%A0%84%EC%8B%9C%EC%A0%95%EB%B3%B4.png)
   - - -
   ![](https://blogfiles.pstatic.net/MjAxODA2MTZfMTA2/MDAxNTI5MTUwOTk1NTM5.8sdwYKis3erjPEPg3NmWQACd57YPiclpPMiEB_DskfYg.S0PYRL3ETcZxzX4yRMrBhpASDOFM20VorWK5mf5W05Ag.PNG.iris9602/%EC%8B%9C%EC%8A%A4%ED%85%9C%ED%9D%90%EB%A6%84%EB%8F%84_%EC%BB%A4%EB%AE%A4%EB%8B%88%ED%8B%B0.png)
  
  # 기대효과
   * 각 사이트마다 분산화 되어있는 전시공간 관리 기능을 종합하여 전체적인 관리가 가능한 시스템을 구축하고, 보다 예술분야에 특화된 서비스 를 제공할 
   * 예술인들에게는 공유 경제를 활용하여 기존의 제한적이였던 분위기를 타파하여  전시 기획을 장려하고, 전시 정보 제공과 커뮤니티를 통해 문화에 소외된 계층까지 아울러 전시 참여 진입 장벽을 낮추고 전시 참여 문화 활성화를 도모할 수 있는 기회를 제공함. 나아가 문화 예술 산업 전반에 예술인들의 목소리를 적극적으로 반영함으로써 긍정적인 선순환 구조 조성을 기대함.
   # 활용분야
   * 서울지역에 비해 소외된 지역지자체 예술 공간 홍보 및 활용
   * 청년/신진 작가들의 예술 공간 정보 인프라와 교류/소통 공간 제공
   
   # 프로젝트 수행방법 
   
   ### 프로젝트 추진 일정
   ![](https://blogfiles.pstatic.net/MjAxODA2MTZfMTY1/MDAxNTI5MTUyMjU0NDgz.ycyXLoP2LI3eJ81Z_AY6tFdW-20OKKzGYIy8enEvWT0g.SQosh1hTVXt0IpRJrrXE_ZJlPhYn7N91Jk_X-K8ywSUg.PNG.iris9602/%EC%9D%BC%EC%A0%95.PNG)
   ### 팀원 소개 및 업무 분배
   * (역할/ 이름/ 대학/ 학과/ 학년/ 담당)
   1. 팀장/전민선/성공회대학교/소프트웨어공학과/4학년/백엔드 프레임워크 및 자바 개발, 전체적인 프로젝트 개발상황 파악 및 회의진행
   2. 팀원/남하영/성공회대학교/소프트웨어공학과/4학년/백엔드 프레임워크 및 자바 개발, 서버 환경 구축
   3. 팀원/양다연/성공회대학교/소프트웨어공학과/4학년/프론트엔드 디자인 개발
   4. 팀원/추은정/성공회대학교/소프트웨어공학과/4학년/프론트엔드 디자인 설계, 데이터베이스 설계
   
   ### 의사소통 방법
    * 매주 화요일 4시간 이상 오프라인 모임 
    * 격주로 금요일 오프라인 모임 
    * 카카오톡 단톡방 항시 연락상태 유지
   
  
  
