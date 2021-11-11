/* eslint-disable @next/next/link-passhref */
import Input from '../layout/Input';
import styled from 'styled-components';
import AuthButton from './AuthButton';
import SocialButton from './SocialButton';
import Link from 'next/link';
import ErrorMessage from '../layout/ErrorMessage';

function AuthForm({ goRegister, goSignIn, onChangeHandler }) {
    
    const goAuth = () => {
        if (goSignIn) {
            goSignIn();
        }

        if(goRegister){
            goRegister()
        }
    };
    //TODO ::// ==>>

    return (
        <FormStyled>
            <Input message="이메일" name="mail" onChange={onChangeHandler} />
            {/* <ErrorMessage isForm={isForm} type="mail" /> */}
            <Input message="비밀번호" name="pwd" onChange={onChangeHandler} />
            {/* {isRegister && <ErrorMessage isForm={isForm} type="pwd" />} */}
            {goRegister && (
                <>
                    <Input
                        message="비밀번호 확인"
                        name="confirmPwd"
                        onChange={onChangeHandler}
                    />
                    {/* <ErrorMessage isForm={isForm} type="pwdConfirm" /> */}
                </>
            )}
            {goRegister && (
                <Input message="닉네임" name="nikNm" onChange={onChangeHandler} />
            )}
            {/* <StyledButton fullWidth isForm={isForm} func={func}> */}
            <StyledButton fullWidth goAuth>
                {goRegister ? '가입하기' : '로그인'}
            </StyledButton>
            {!goRegister && (
                <div className="findRegister">
                    <Link href=""> 비밀번호 찾기 </Link>
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
