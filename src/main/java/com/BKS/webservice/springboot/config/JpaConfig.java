package com.BKS.webservice.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //   jpa auditing 활성화
public class JpaConfig {
    /*
    * HelloController 와 같은 jpa 와 관련 없는
    * @WebMvcTest 에서도 스캔되어 테스트 실패를 야기한다.
    * @EnableJpaAuditing 하기 위해선 최소 하나 이상의 @Entity 클래스가 필요하다.
    * 따라서 분리하기 위해 따로 configuration 해준다.
    * */
}
