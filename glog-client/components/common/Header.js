/* eslint-disable @next/next/link-passhref */
import Link from 'next/link';
import Image from 'next/image';
import styled from 'styled-components';
import logo from '../../public/logo.png';
import AuthButton from '../auth/AuthButton';

const Header = () => {
    return (
        <StyledHeader>
            <div className="logo">
                <Image src={logo} alt="logo" width={48} height={48} />
            </div>
            <div className="right">
                <Link href="/auth/SignIn">
                    <AuthButton isLink>로그인</AuthButton>
                </Link>
            </div>
        </StyledHeader>
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
`;

export default Header;
