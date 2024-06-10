package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {

	private DataService dataService; // DataService 의존성 주입을 위한 멤버 변수

	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService; // 생성자를 통한 DataService 의존성 주입
	}

	public int findMax() {
		// 데이터 서비스에서 데이터를 배열로 가져와 Stream으로 변환한 후 최대값을 찾음
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
		// 최대값이 없는 경우 0을 반환하도록 orElse(0)를 사용
	}
}
