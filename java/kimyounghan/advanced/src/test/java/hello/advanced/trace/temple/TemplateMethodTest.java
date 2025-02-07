package hello.advanced.trace.temple;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.temple.code.AbstractTemplate;
import hello.advanced.trace.temple.code.SubClassLogic1;
import hello.advanced.trace.temple.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class TemplateMethodTest {

	@Test
	void templateMethodV0() {
		logic1();
		logic2();
	}

	@Test
	void templateMethodV1() {
		AbstractTemplate abstractTemplate1 = new SubClassLogic1();
		abstractTemplate1.execute();

		AbstractTemplate abstractTemplate2 = new SubClassLogic2();
		abstractTemplate2.execute();
	}

	@Test
	void templateMethodV2() {
		AbstractTemplate template1 = new AbstractTemplate() {
			@Override
			protected void call() {
				log.info("비즈니스 로직1 실행");
			}
		};

		log.info("클래스 이름1={}", template1.getClass());
		template1.execute();

		AbstractTemplate template2 = new AbstractTemplate() {
			@Override
			protected void call() {
				log.info("비즈니스 로직2 실행");
			}
		};

		log.info("클래스 이름2={}", template2.getClass());
		template2.execute();
	}

	private void logic1() {
		long startTime = System.currentTimeMillis();
		//비즈니스 로직 실행
		log.info("비즈니스 로직1 실행");
		//비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}

	private void logic2() {
		long startTime = System.currentTimeMillis();
		//비즈니스 로직 실행
		log.info("비즈니스 로직2 실행");
		//비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}

}
