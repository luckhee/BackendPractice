package kr.co.hanbit.product.management.application;


import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidationService {
    public <T> void checkValid(@Valid T validationTarget) {
        //아무것도 안해버리기
        //@Valid 때문에 아무것도 안하고 인자로만 받아도 유효성 검사가 됨.

    }
}
