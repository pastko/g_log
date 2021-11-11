import styled from 'styled-components';
import Img from 'next/image';
import googleIcon from '../../public/google.svg';
import githubIcon from '../../public/github.svg';
import {
  useGoogleLogin
} from 'react-google-login';

function SocialButton({
  btnType
}) {
  const githubURI =
    'https://github.com/login/oauth/authorize?' +
    `client_id=${process.env.githubClientId}` +
    `&redirect_uri=${process.env.redirectURI}`;

  const googleURI =
    'https://accounts.google.com/o/oauth2/v2/auth?' +
    `client_id=${process.env.googleClientId}` +
    `&redirect_uri=${process.env.githubRedirectURI}` +
    '&response_type=code' +
    '&scope=profile';

  // const onSuccess = (res) => {
  //   console.log('google login success ::: ', res);
  // }

  // const onFailure = (error) => {
  //   console.log('google login failed ::: ', error);
  // }

  // const googleLogin = useGoogleLogin({
  //   onSuccess,
  //   onFailure,
  //   uxMode: 'redirect',
  //   clientId: `${process.env.googleClientId}.apps.googleusercontent.com`,
  //   redirectUri: `${process.env.githubRedirectURI}`,
  //   isSignedIn: true,
  //   accessType: 'offline',
  // })

  return ( <
    StyledSocialButton href = {
      btnType === 'Google' ? googleURI : githubURI
    }
    target = "_blank" >
    <
    Img src = {
      btnType === 'Google' ? googleIcon : githubIcon
    }
    width = {
      22
    }
    height = {
      22
    }
    alt = {
      btnType
    }
    /> <
    span > {
      btnType
    }
    계정으로 계속하기 <
    /span> <
    /StyledSocialButton>
  );
}

const StyledSocialButton = styled.a `
  width: 100%;
  height: 48px;
  margin-top: 10px;
  background: #fff;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  color: rgba(0, 0, 0, 0.54);
  border: 2px solid #ddd;
  border-radius: 1.5rem;
  font-family: Roboto, sans-serif;
  font-weight: 500;
  font-size: 14px;
  cursor: pointer;
  &:hover {
    opacity: 0.6;
  }
  span {
    margin-left: 10px;
  }
`;

export default SocialButton;