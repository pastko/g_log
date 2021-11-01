/* eslint-disable @next/next/link-passhref */
import Link from 'next/link';
import Image from 'next/image';
import logo from '../../public/logo.png';
import styled from 'styled-components';

function AuthTemplate({children }) {
    return (
        <AuthStyled>
            <div className="auth-wrapper">
                <div className="intro">
                    <Link href="/">
                        <Image src={logo} alt="logo" width={40} height={40} />
                    </Link>
                    <h3 className="intro">Glog에 오신 것을 환영합니다.</h3>
                </div>
                <div> {children} </div>
            </div>
        </AuthStyled>
    );
}

const AuthStyled = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    background: #8383835a;
    width: 100%;
    height: 100%;
    .auth-wrapper {
        width: 380px;
        min-width: 240px;
        height: 620px;
        min-height: 400px;
        margin-top: 4.5rem;
        padding: 20px 10px 24px;
        border-radius: 32px;
        background: #fff;
        color: #3a3a3a;
        box-shadow: 0 0 10px #5d5d5d76;
        .intro {
            margin: 10px 0 20px; 
            font-size: 1.4rem;
            font-weight: 600;
        }
    }
`;

export default AuthTemplate;
