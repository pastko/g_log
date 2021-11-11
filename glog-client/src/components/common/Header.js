import { useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import AuthButton from '../auth/AuthButton';
import SignIn from '../modal/SignIn';
import Register from '../modal/Register';
import Images from '../layout/Images';
import ProfileMenu from '../../components/common/ProfileMenu';
import { Avatar, IconButton, Tooltip } from '@mui/material';

const Header = () => {
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

    return (
        <>
            <StyledHeader>
                <Link to="/">
                    <a>
                        <Images
                            src="/common/logo/logo.png"
                            width={48}
                            height={48}
                        />
                    </a>
                </Link>
                <div className="right">
                    {false ? (

                        <>
                            <Link to="/boardWrite">
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
