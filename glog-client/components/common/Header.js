/* eslint-disable @next/next/link-passhref */
import styled from 'styled-components';
import AuthButton from '../auth/AuthButton';
import { useState } from 'react';
import SignIn from '../modal/SignIn';
import Register from '../modal/Register';
import Images from '../layout/Images';

const Header = ({ accessToken }) => {
    const [isSignInOpen, setIsSignInOpen] = useState(false);
    const [isRegisterOpen, setIsRegisterOpen] = useState(false);

    return (
        <>
            <StyledHeader>
                <div className="logo">
                    <Images
                        src="/common/logo/logo.png"
                        width={48}
                        height={48}
                    />
                </div>
                <div className="right">
                    {accessToken !== 'none' ? (
                        '로그인 후 썸네일 처리'
                    ) : (
                        <>
                            <AuthButton
                                isLink
                                onClick={() => setIsSignInOpen(true)}
                            >
                                로그인
                            </AuthButton>
                            <AuthButton
                                isLink
                                defaultType
                                onClick={() => setIsRegisterOpen(true)}
                            >
                                회원가입
                            </AuthButton>
                        </>
                    )}
                </div>
            </StyledHeader>
            {isSignInOpen && <SignIn setIsOpen={setIsSignInOpen} />}
            {isRegisterOpen && <Register setIsOpen={setIsRegisterOpen} />}
        </>
    );
};

const StyledHeader = styled.header`
    width: 1280px;
    @media (max-width: 1280px) {
        width: 768px;
    }
    @media (max-width: 768px) {
        width: 100%;
    }
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
