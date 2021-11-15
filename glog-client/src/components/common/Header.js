import { useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import AuthButton from '../auth/AuthButton';
import SignIn from '../modal/SignIn';
import Register from '../modal/Register';
import Images from '../layout/Images';
import ProfileMenu from '../../components/common/ProfileMenu';
import { Avatar, IconButton, Tooltip } from '@mui/material';
import { useSelector, useDispatch } from "react-redux";


const Header = () => {
    const dispatch = useDispatch();
    const isLogin = useSelector((state) => state.user.is_login);
    const users = useSelector((state) => state.user);
    console.log(isLogin);
    console.log(users);

    const [isSignInOpen, setIsSignInOpen] = useState(false);
    const [isRegisterOpen, setIsRegisterOpen] = useState(false);
    const [anchorEl, setAnchorEl] = useState(null);

    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const open = Boolean(anchorEl);
    const handleClose = () => {
        setAnchorEl(null);
    };


    if (isLogin) {
        if (isSignInOpen) setIsSignInOpen(false);
        if (isRegisterOpen) setIsRegisterOpen(false);
    }
    return (
        <>
            <StyledHeader>
                <Link to="/">
                    <Images
                        src="/common/logo/logo.png"
                        width={48}
                        height={48}
                    />
                </Link>
                <div className="right">
                    {isLogin ? (
                        <>
                            <Link to="/post/write">
                                <AuthButton isLink defaultType>
                                    글쓰기
                                </AuthButton>
                            </Link>
                            <Tooltip
                                sx={{
                                    display: 'flex',
                                    alignItems: 'center',
                                    textAlign: 'center',
                                }}
                            >
                                <IconButton
                                    onClick={handleClick}
                                    size="medium"
                                    sx={{ ml: 0.5 }}
                                >
                                    <Avatar sx={{ width: 35, height: 35 }}>
                                        P
                                    </Avatar>
                                </IconButton>
                            </Tooltip>
                            <ProfileMenu
                                anchorEl={anchorEl}
                                open={open}
                                handleClose={handleClose}
                            />
                        </>
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
    max-width: 1280px;
    @media (max-width: 1440px) {
        width : 1280px;
    }
    @media (max-width: 1280px) {
        width: 768px;
    }
    @media (max-width: 768px) {
        width: 100vw;
    }
    height: 64px;
    margin: 20px auto;
    display: flex;
    align-items: center;
    justify-content: space-between;
    .logo {
        font-size: 24px;
        font-weight: bold;
    }
    .right a {
        margin-left: 5px;
    }
    @media (max-width: 380px) {
        width: 100vw;
        display: block;
        .right a {
            display: flex;
            align-items: center;
            justify-content: center;
            line-height: 1.3rem;
            font-size: 1.1rem;
            height: 2.8rem;
            margin-top: 0.5rem;
        }
    }
`;

export default Header;