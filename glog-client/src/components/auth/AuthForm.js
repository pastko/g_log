import { useState } from 'react';
import { Link } from 'react-router-dom';
import Input from './AuthInput';
import styled from 'styled-components';
import AuthButton from './AuthButton';
import SocialButton from './SocialButton';

function AuthForm({ isRegister }) {
    const [isValidate, setIsValidate] = useState({
        mail: '',
        pwd: '',
        confirmPwd: ''
    });
    const [isForm, setIsForm] = useState({
        mail: '',
        pwd: '',
        confirmPwd: '',
        nikNm: ''
    });
    const [isDisabled, setDisabled] = useState(true);
    const onChangeHandler = (e) => {
        const { name, value } = e.target;
        setIsForm({
            ...isForm,
            [name]: value,
        });

        validation(name, value);
    };

    const validation = (name, value) => {
        const mailRegex = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        const pwdRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/;

        if (name === 'mail') {
            if (!mailRegex.test(isForm.mail)) {
                setIsValidate({
                    ...isValidate,
                    mail: '이메일 형식이 아닙니다.'
                });
                setDisabled(true);
                return;
            } else {
                isValidate.mail = '';
            }
        }
        if (name === 'pwd') {
            if (!pwdRegex.test(isForm.pwd)) {
                setIsValidate({
                    ...isValidate,
                    pwd: '비밀번호는 최소8자 및 최대 12자, 영문/숫자/특수문자 조합이어야 합니다.'
                });
                setDisabled(true);
                return;
            } else {
                isValidate.pwd = '';
            }
        }
        if (name === 'confirmPwd') {
            if (isForm.pwd !== value) {
                setIsValidate({
                    ...isValidate,
                    confirmPwd: '비밀번호가 일치해야합니다.'
                })
                setDisabled(true);
                return;
            } else {
                isValidate.confirmPwd = '';
            }
        }
        setDisabled(false);
    }
    const goMain = () => {
        window.location.href = "/";
    };

    return (
        <FormStyled>
            <Input message="이메일" type="text" name="mail" onChange={onChangeHandler} />
            <StyeldError>{isValidate.mail}</StyeldError>

            {isRegister ?
                <>
                    <Input message="비밀번호" type="password" name="pwd" onChange={onChangeHandler} />
                    <StyeldError>{isValidate.pwd}</StyeldError>
                </>
                :
                <Input message="비밀번호" type="password" name="pwd" />
            }
            {isRegister && (
                <>
                    <Input
                        type="password"
                        message="비밀번호 확인"
                        name="confirmPwd"
                        onChange={onChangeHandler}
                    />
                    <StyeldError>{isValidate.confirmPwd}</StyeldError>
                </>
            )}
            {isRegister && (
                <Input message="닉네임" name="nikNm" onChange={onChangeHandler} />
            )}

            <StyledButton fullWidth _disabled={isDisabled} _onClick={goMain}>
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
const StyeldError = styled.div`
    text-align: right;
    font-size: 0.8rem;
    padding-bottom: 0.6rem;
    color: #d81d1d;

`;
export default AuthForm;
