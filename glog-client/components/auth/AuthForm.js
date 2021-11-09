/* eslint-disable @next/next/link-passhref */
import { useState } from 'react';
import Input from './Input';
import styled from 'styled-components';
import AuthButton from './AuthButton';
import SocialButton from './SocialButton';
import Link from 'next/link';

function AuthForm({ isRegister, func }) {
    const [form, setForm] = useState({
        mail: '',
        pwd: '',
        confirmPwd: '',
        nikNm: '',
    });

    const onChange = (e) => {
        const { name, value } = e.target;
        setForm({
            ...form,
            [name]: value,
        });
    };

    const isValidate = () => {
        const emailRegex = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        const pwdRegex =
            /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/;

        if (!form.mail || !form.pwd || !form.confirmPwd || !form.nikNm) {
            //TODO: 가입하기, 로그인 버튼 클릭 노노
            const btn = document.querySelector('.localAuthBtn');
            btn.disabled = false;
        }
        if (emailRegex.test(form.mail)) {
            //TODO: 이메일 형식 아니라고 error message띄우기
        }
        if (pwdRegex.test(form.pwd)) {
            //TODO : 패스워드 형식 error message띄우기
        }
        //TODO: 패스워드, 패스워드 확인 둘다 일치하는지 확인
        if (form.pwd !== form.confirmPwd) {
        }
        //TODO: nickname 비어있는지 확인
        if (form.nikNm === '') {
            let niks = form.nikNm.split('@');
            let id = niks[0];
            form.nikNm = id;
        }
        if (func) {
            func(form);
        }
    };

    return (
        <FormStyled>
            <Input message="이메일" name="mail" onChange={onChange} />
            <Input message="비밀번호" name="pwd" onChange={onChange} />
            {isRegister && (
                <Input
                    message="비밀번호 확인"
                    name="confirmPwd"
                    onChange={onChange}
                />
            )}
            {isRegister && (
                <Input message="닉네임" name="nikNm" onChange={onChange} />
            )}
            <StyledButton className="localAuthBtn" fullWidth onClick={isValidate}>
                {isRegister ? '가입하기' : '로그인'}
            </StyledButton>
            {!isRegister && (
                <div className="findRegister">
                    <Link href=""> 비밀번호 찾기 </Link>
                </div>
            )}
            <span className="or"> or </span> {/* <SocialButton/> */}
            <StyledSocialBtn>
                <SocialButton btnType="Google" />
                <SocialButton btnType="Github" />
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
