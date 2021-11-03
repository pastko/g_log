/* eslint-disable @next/next/link-passhref */
import Link from 'next/link';
import Image from 'next/image';
import styled from 'styled-components';
import logo from '../../public/logo.png';
import AuthButton from '../auth/AuthButton';
import { useState } from 'react';
import SignIn from '../modal/SignIn';
import Register from '../modal/Register';

const Header = () => {
    const [isSignInOpen, setIsSignInOpen] = useState(false);
    const [isRegisterOpen, setIsRegisterOpen] = useState(false);

    return (
        <>
            <StyledHeader>
                <div className="logo">
                    <Image src={logo} alt="logo" width={48} height={48} />
                </div>
                <div className="right">
                    <AuthButton isLink onClick={() => setIsSignInOpen(true)}>로그인</AuthButton>
                    <AuthButton isLink defaultType onClick={() => setIsRegisterOpen(true)}>회원가입</AuthButton>
                </div>
            </StyledHeader>
            {isSignInOpen && <SignIn setIsOpen={setIsSignInOpen} />}
            {isRegisterOpen && <Register setIsOpen={setIsRegisterOpen} />}
        </>
    );
};

const StyledHeader = styled.header`
    width: 1280px;
    height: 64px;
    margin: 20px auto;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 16px;
    .logo {
        font-size: 24px;
        font-weight: bold;
    }
    .right a {
        margin-left: 5px;
    }
`;

export default Header;
