import GoogleLogin from 'react-google-login';
import styled, { css } from 'styled-components';
import { FaGithub } from 'react-icons/fa';

function SocialButton({ btnType }) {
  const googleSuccess = (response) => {
    console.log(response);
  };

  const googleFail = (error) => {
    console.log(error);
  }

  const googleClientId = `${process.env.REACT_APP_GOOGLE_CLIENT_ID}.apps.googleusercontent.com`;
  const googleRedirectURI = `${process.env.REACT_APP_GOOGLE_REDIRECT_URI}`;

  const githubURI =
    'https://github.com/login/oauth/authorize?' +
    `client_id=${process.env.REACT_APP_GITHUB_CLIENT_ID}` +
    `&redirect_uri=${process.env.REACT_APP_GITHUB_REDIRECT_URI}`;

  return (
    <StyledButton>
      <GoogleLogin
        className="google-btn"
        clientId={googleClientId}
        buttonText="Google 계정으로 계속하기"
        onSuccess={googleSuccess}
        onFailure={googleFail}
        cookiePolicy="single_host_origin"
      />
      <GithubLogin href={githubURI} target="_blank">
        <FaGithub className="github-icon" />
        <span> Github 계정으로 계속하기 </span>
      </GithubLogin>
    </StyledButton>
  );
}

const commonStyled = css`
  width: 100%;
  height: 48px;
  margin-top: 10px;
  background: #fff;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  color: rgba(0, 0, 0, 0.54);
  box-shadow: none !important;
  border: 2px solid #ddd !important;
  border-radius: 1.5rem !important;
  cursor: pointer;
  opacity: 1 !important;
  &:hover {
    border: 2px solid #a680d2 !important;
    color: #a680d2 !important;
  }
`;

const StyledButton = styled.div`
  .google-btn {
    ${commonStyled}
  }
`;

const GithubLogin = styled.a`
  ${commonStyled}
  .github-icon {
    font-size: 1.4rem;
    color: #5c6bc0;
    margin-right: 1.1rem;
  }
  span {
    font-family: Roboto, sans-serif;
    font-weight: 500;
    font-size: 14px;
  }
`;

export default SocialButton;
