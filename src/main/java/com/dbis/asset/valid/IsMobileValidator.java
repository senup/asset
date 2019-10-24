//package com.dbis.asset.valid;
//
//import com.alibaba.druid.util.StringUtils;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
///**
// * @ClassName IsMobileValidator
// * @Description TODO
// * @Author tom
// * @Date 2019/10/24 8:22
// * @Version 1.0
// **/
//public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {
//    private boolean required = false;
//    //初始化指定注解接口
//    @Override
//    public void initialize(IsMobile isMobile) {
//        required = isMobile.required();
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
//        if (required) {
//            return ValidatorUtil.isMobile(value);
//        } else {
//            if (StringUtils.isEmpty(value)) {
//                return true;
//            } else {
//                return ValidatorUtil.isMobile(value);
//            }
//        }
//    }
//}
//
