package kr.co.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Data
@Component
public class Restaurant {
	
//	@Setter에서 사용된 onMethod 속성은 생성되는 setChef()에 @Autowired 어노테이션을 추가하도록 하자.
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
	
	
}
