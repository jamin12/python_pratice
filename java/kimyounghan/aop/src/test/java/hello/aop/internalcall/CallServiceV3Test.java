package hello.aop.internalcall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import hello.aop.internalcall.aop.CallLogAspect;

@SpringBootTest
@Import(CallLogAspect.class)
class CallServiceV3Test {
	@Autowired
	CallServiceV3 service;

	@Test
	void external() {
		service.external();
	}

}