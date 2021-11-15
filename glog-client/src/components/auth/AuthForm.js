import { useState } from 'react';
import { Link } from 'react-router-dom';
import Input from './AuthInput';
import styled from 'styled-components';
import AuthButton from './AuthButton';
import SocialButton from './SocialButton';
import ErrorMessage from '../layout/ErrorMessage';




function AuthForm({ isRegister, setIsOpen }) {
    
    const [isForm, setForm] = useState({
        mail: "",
        pwd: "",
        confirmPwd: "",
        nikNm : "",
    });

    const onChangeHandler = (e) => {
        const { name, value } = e.target;
        setForm({
            ...isForm,
            [name]: value,
        });
    };
    console.log(isForm.mail);
    console.log(isForm.pwd);

    return (
        <FormStyled>
            <Input message="이메일" name="mail" onChange={onChangeHandler} />
            {/* <ErrorMessage isForm={isForm} type="mail" />  */}
            <Input message="비밀번호" name="pwd" onChange={onChangeHandler} />
            {/* {isRegister && <ErrorMessage isForm={isForm} type="pwd" />} */}
            {isRegister && (
                <>
                    <Input
                        message="비밀번호 확인"
                        name="confirmPwd"
                        onChange={onChangeHandler}
                    />
                    {/* <ErrorMessage isForm={isForm} type="pwdConfirm" /> */}
                </>
            )}
            {isRegister && (
                <Input message="닉네임" name="nikNm" onChange={onChangeHandler} />
            )}
            {/* <StyledButton fullWidth isForm={isForm} func={func}> */}
            <StyledButton  fullWidth isForm={isForm}  >
                {isRegister ? '가입하기' : '로그인'}
            </StyledButton>
            {!isRegister && (
                <div className="findRegister">
                    <Link to=""> 비밀번호 찾기 </Link>
                </div>
            )}
            <span className="or"> or </span>
            <StyledSocialBtn>
                <SocialButton btnType="Google" />
                {/* <SocialButton btnType="Github" /> */}
            </StyledSocialBtn>
        </FormStyled>
    );
}
const FormStyled = styled.form`
    width: 280px;
    margin: 0 auto;
    .findRegister {
        margin: 4px 0 0 15px;
        color: #797979;
        text-align: left;
        font-size: 13px;
        &:hover {
            color: #424242;
        }
    }
    .or {
        font-size: 18px;
        display: block;
        margin: 5px 0;
    }
`;
const StyledButton = styled(AuthButton)`
    margin-top: 5px;
`;
const StyledSocialBtn = styled.div`
    margin-top: 5px;
`;
export default AuthForm;
