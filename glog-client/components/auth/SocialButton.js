import { FaGoogle, FaGithub } from 'react-icons/fa';
import styled from 'styled-components';
import axios from 'axios';
import Router from 'next/router';

function SocialButton({ btnType }) {
  const goGithub = () => {};
//   const goGoogle = () => {
//     const gooleURL = 'https://accounts.google.com/o/oauth2/v2/auth?'
//     + `client_id=${process.env.NEXT_PUBLIC_CLIENT_ID}`
//     + `&redirect_uri=${process.env.NEXT_PUBLIC_REDIRECT_URI}`
//     + `&response_type=code&scope=profile`;
//     window.location.assign('https://www.naver.com');
//   };
const goGoogle =()=>{
    Router.push("https://accounts.google.com/o/oauth2/v2/auth/identifier?client_id=831514969986-67u6g2eqe7a61o4b41br1n0clkh89ktg.apps.googleusercontent.com&redirect_uri=https%3A%2F%2Flocalhost%3A3000%2F&response_type=code&scope=profile&flowName=GeneralOAuthFlow")
}


  return (
    <StyledSocial onClick={btnType === 'Google' ? goGoogle : goGithub}>
      {btnType === 'Google' ? <FaGoogle /> : <FaGithub />}
      <span>
        {btnType}
        계정으로 계속하기
      </span>
    </StyledSocial>
  );
}
const StyledSocial = styled.button`
  width: 100%;
  height: 40px;
  margin-top: 10px;
  line-height: 18px;
  font-size: 16px;
  border: 2px solid #ddd;
  border-radius: 1.5rem;
  cursor: pointer;
  background: #fff;
  color: #797979;
  span {
    display: inline-block;
    margin-left: 10px;
  }
  &:hover {
    border: 1px solid #a680d2;
    background-color: #a680d267;
    color: #fff;
  }
`;
export default SocialButton;
